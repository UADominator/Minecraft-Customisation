package net.harmoniya.customisation.render.model.models;

import net.harmoniya.customisation.Customisation;
import net.harmoniya.customisation.render.model.AbstractBaseLayerModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class NakidkaLayerModel extends AbstractBaseLayerModel<LivingEntity> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Customisation.MODID, "nakidka"), "main");

	public NakidkaLayerModel(ModelPart root) {
		super();
		Customisation.LOGGER.info("Location - " + LAYER_LOCATION);
		this.player = root.getChild("Player");
		this.head = this.player.getChild("Head");
		this.body = this.player.getChild("Body");
		this.rightArm = this.player.getChild("RightArm");
		this.leftArm = this.player.getChild("LeftArm");
	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Player = partdefinition.addOrReplaceChild("Player", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F/*24.0F*/, 0.0F));

		PartDefinition Head = Player.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.6F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition Body = Player.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 12).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 10.0F, 4.0F, new CubeDeformation(0.4F))
																	   .texOffs(41, 9).addBox(-1.0F, 1.5F, -2.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(41, 9).addBox(-1.0F, 0.1F, -2.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition RightArm = Player.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 27).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.4F)), PartPose.offset(-5.0F, -22.0F, 0.0F));

		PartDefinition LeftArm = Player.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(25, 12).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.4F)), PartPose.offset(5.0F, -22.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public ModelPart root() {
		return null;
	}
}