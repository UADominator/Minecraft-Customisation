package net.harmoniya.customisation.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.harmoniya.customisation.Customisation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public class BaseArmorLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
	private final NakidkaLayerModel nakidkaModel;

	public BaseArmorLayer(RenderLayerParent<T, M> renderer, EntityModelSet modelSet) {
		super(renderer);
		this.nakidkaModel = new NakidkaLayerModel(modelSet.bakeLayer(NakidkaLayerModel.LAYER_LOCATION));
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

		ItemStack chest = entity.getItemBySlot(EquipmentSlot.CHEST);
		if (!(chest.getItem() instanceof ArmorItem)) {
			return;
		}

		AbstractBaseLayerModel<?> model;
		ResourceLocation texture;

		CompoundTag tag = chest.getTag();
		String variant = tag != null && tag.contains("Variant") ? tag.getString("Variant") : "none";

		switch (variant) {
			case "nakidka":
				model = this.nakidkaModel;
				texture = new ResourceLocation(Customisation.MODID, "textures/entity/nakidka.png");
				break;
			// EXAMPLE
//			case "dildo":
//				model = this.dildoModel;
//				texture = new ResourceLocation(Customisation.MODID, "textures/entity/dildo.png");
//				break;
			default:
				return;
		}

		if (this.getParentModel() instanceof HumanoidModel<?> parentHumanoid) {
			model.copyFromPlayerModel(parentHumanoid);
		}

		VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(texture));

		model.renderToBuffer(
				poseStack,
				vertexConsumer,
				packedLight,
				OverlayTexture.NO_OVERLAY,
				1.0F, 1.0F, 1.0F, 1.0F
		);
	}
}