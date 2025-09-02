package net.harmoniya.customisation.render.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.harmoniya.customisation.Customisation;
import net.harmoniya.customisation.mixin.AnimationDefinitionAccessor;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;
import org.joml.Vector3f;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractBaseLayerModel<T extends LivingEntity> extends HierarchicalModel<T> {
	public final Map<String, ModelPart> partsByName = new HashMap<>();
	protected ModelPart player;
	protected ModelPart head;
	protected ModelPart body;
	protected ModelPart rightArm;
	protected ModelPart leftArm;

	public AbstractBaseLayerModel() {
		partsByName.put("player", player);
		partsByName.put("body", body);
		partsByName.put("head", head);
		partsByName.put("rightArm", rightArm);
		partsByName.put("leftArm", leftArm);
	}

	@Override
	public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack pose, VertexConsumer vertex, int light, int overlay, float r, float g, float b, float a) {
		player.render(pose, vertex, light, overlay, r, g, b, a);
	}

	@Override
	public ModelPart root() {
		return player;
	}

	public void copyFromPlayerModel(HumanoidModel<?> playerModel) {
		this.head.copyFrom(playerModel.head);
		this.body.copyFrom(playerModel.body);
		this.rightArm.copyFrom(playerModel.rightArm);
		this.leftArm.copyFrom(playerModel.leftArm);
	}


	;


	private static float lerp(float start, float end, float progress) {
		return start + (end - start) * progress;
	}

	private static Vector3f lerpVec(Vector3f start, Vector3f end, float progress) {
		return new Vector3f(
				lerp(start.x(), end.x(), progress),
				lerp(start.y(), end.y(), progress),
				lerp(start.z(), end.z(), progress)
		);
	}

	public static void applyAnimation(AbstractBaseLayerModel<?> model, AnimationDefinition animDef, float ageInTicks) {
		try {
			Map<String, List<AnimationChannel>> animationByBone = ((AnimationDefinitionAccessor) (Object) animDef).getAnimationByBone();
			float length = ((AnimationDefinitionAccessor) (Object) animDef).getLength();
			boolean looping = ((AnimationDefinitionAccessor) (Object) animDef).isLooping();

			float progressSeconds = ageInTicks / 20f;
			float normalized;
			if (looping) {
				normalized = (progressSeconds % length) / length;
			} else {
				normalized = Math.min(progressSeconds / length, 1f);
			}

			// Проходимо по всіх кістках
			for (Map.Entry<String, List<AnimationChannel>> entry : animationByBone.entrySet()) {
				String boneName = entry.getKey();
				ModelPart part = model.partsByName.get(boneName); // дістаємо частину напряму з Map
				if (part == null) continue;

				for (AnimationChannel channel : entry.getValue()) {
					Keyframe[] keyframesArray = channel.keyframes();
					if (keyframesArray.length == 0) continue;

					List<Keyframe> keyframes = Arrays.asList(keyframesArray);

					Keyframe prev = keyframes.get(0);
					Keyframe next = keyframes.get(keyframes.size() - 1);
					for (int i = 0; i < keyframes.size() - 1; i++) {
						if (normalized > keyframes.get(i).timestamp() && normalized <= keyframes.get(i + 1).timestamp()) {
							prev = keyframes.get(i);
							next = keyframes.get(i + 1);
							break;
						}
					}
					Customisation.LOGGER.info("Normalized: {}, pren: {}, next {}", normalized, prev.timestamp(), next.timestamp());

					float frameProgress = (normalized - prev.timestamp()) / (next.timestamp() - prev.timestamp());

					Vector3f lerped = lerpVec(prev.target(), next.target(), frameProgress);

					// Лінійна інтерполяція
					if (channel.target().equals(AnimationChannel.Targets.ROTATION)) {
						part.xRot = lerped.x();
						part.yRot = lerped.y();
						part.zRot = lerped.z();
					} else if (channel.target().equals(AnimationChannel.Targets.POSITION)) {
						part.x = lerped.x();
						part.y = lerped.y();
						part.z = lerped.z();
					} else if (channel.target().equals(AnimationChannel.Targets.SCALE)) {
						part.xScale = lerped.x();
						part.yScale = lerped.y();
						part.zScale = lerped.z();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
