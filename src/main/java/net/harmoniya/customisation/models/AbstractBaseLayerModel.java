package net.harmoniya.customisation.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public abstract class AbstractBaseLayerModel<T extends LivingEntity> extends EntityModel<T> {
	protected ModelPart player;
	protected ModelPart head;
	protected ModelPart body;
	protected ModelPart rightArm;
	protected ModelPart leftArm;

	@Override
	public void setupAnim(T t, float v, float v1, float v2, float v3, float v4) {

	}

	@Override
	public void renderToBuffer(PoseStack pose, VertexConsumer vertex, int light, int overlay, float r, float g, float b, float a) {
		player.render(pose, vertex, light, overlay, r, g, b, a);
	}


	public void copyFromPlayerModel(HumanoidModel<?> playerModel) {
		this.head.copyFrom(playerModel.head);
		this.body.copyFrom(playerModel.body);
		this.rightArm.copyFrom(playerModel.rightArm);
		this.leftArm.copyFrom(playerModel.leftArm);
	}
}
