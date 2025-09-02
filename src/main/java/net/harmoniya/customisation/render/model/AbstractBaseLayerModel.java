package net.harmoniya.customisation.render.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;

public abstract class AbstractBaseLayerModel<T extends LivingEntity> extends HierarchicalModel<T> {
	protected final AnimationState idleAnimationState = new AnimationState();

	private final ModelPart root;

	protected ModelPart player;
	protected ModelPart head;
	protected ModelPart body;
	protected ModelPart rightArm;
	protected ModelPart leftArm;

	public AbstractBaseLayerModel(ModelPart root) {
		this.root = root;
	}

	@Override
	public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root().getAllParts().forEach(ModelPart::resetPose);
	}

	@Override
	public void renderToBuffer(PoseStack pose, VertexConsumer vertex, int light, int overlay, float r, float g, float b, float a) {
		root.render(pose, vertex, light, overlay, r, g, b, a);
	}

	@Override
	public ModelPart root() {
		return root;
	}

	public void copyFromPlayerModel(HumanoidModel<?> playerModel) {
		this.head.copyFrom(playerModel.head);
		this.body.copyFrom(playerModel.body);
		this.rightArm.copyFrom(playerModel.rightArm);
		this.leftArm.copyFrom(playerModel.leftArm);
	}
}
