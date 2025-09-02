package net.harmoniya.customisation.render.model.models;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.harmoniya.customisation.Customisation;
import net.harmoniya.customisation.render.model.AbstractBaseLayerModel;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class PetLayerModel extends AbstractBaseLayerModel<LivingEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Customisation.MODID, "pet"), "main");
	private final ModelPart pet;
	private final ModelPart petHead;
	private final ModelPart petTail;
	private final ModelPart petWings;
	private final ModelPart petLeftWing;
	private final ModelPart petRightWing;

	public PetLayerModel(ModelPart root) {
		super();
		this.player = root.getChild("player");
		this.body = this.player.getChild("body");
		this.head = this.player.getChild("head");
		this.rightArm = this.player.getChild("rightArm");
		this.leftArm = this.player.getChild("leftArm");
		this.pet = this.player.getChild("pet");
		this.petHead = this.pet.getChild("petHead");
		this.petTail = this.pet.getChild("petTail");
		this.petWings = this.pet.getChild("petWings");
		this.petLeftWing = this.petWings.getChild("petLeftWing");
		this.petRightWing = this.petWings.getChild("petRightWing");

		partsByName.put("pet", pet);
		partsByName.put("petHead", petHead);
		partsByName.put("petTail", petTail);
		partsByName.put("petWings", petWings);
		partsByName.put("petLeftWing", petLeftWing);
		partsByName.put("petRightWing", petRightWing);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition player = partdefinition.addOrReplaceChild("player", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.0F, -8.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition body = player.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = player.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightArm = player.addOrReplaceChild("rightArm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftArm = player.addOrReplaceChild("leftArm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition pet = player.addOrReplaceChild("pet", CubeListBuilder.create().texOffs(0, 8).addBox(-2.0F, -4.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition petHead = pet.addOrReplaceChild("petHead", CubeListBuilder.create().texOffs(0, 12).addBox(-2.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -4.0F, 0.0F));

		PartDefinition petTail = pet.addOrReplaceChild("petTail", CubeListBuilder.create().texOffs(8, 12).addBox(0.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -4.0F, 0.0F));

		PartDefinition part2_r1 = petTail.addOrReplaceChild("part2_r1", CubeListBuilder.create().texOffs(12, 8).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 1.5708F, 3.1416F));

		PartDefinition petWings = pet.addOrReplaceChild("petWings", CubeListBuilder.create(), PartPose.offset(-2.0F, -3.0F, 0.0F));

		PartDefinition petLeftWing = petWings.addOrReplaceChild("petLeftWing", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -1.0F, -1.0F));

		PartDefinition PetRightWing = petWings.addOrReplaceChild("petRightWing", CubeListBuilder.create().texOffs(0, 4).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -1.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}


	public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(0.625f).looping()
														   .addAnimation("petTail",
																   new AnimationChannel(AnimationChannel.Targets.ROTATION,
																		   new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
																				   AnimationChannel.Interpolations.LINEAR),
																		   new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(360f, 0f, 0f),
																				   AnimationChannel.Interpolations.LINEAR)))
														   .addAnimation("petLeftWing",
																   new AnimationChannel(AnimationChannel.Targets.ROTATION,
																		   new Keyframe(0f, KeyframeAnimations.degreeVec(-30f, 0f, 0f),
																				   AnimationChannel.Interpolations.LINEAR),
																		   new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(30f, 0f, 0f),
																				   AnimationChannel.Interpolations.LINEAR),
																		   new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(-30f, 0f, 0f),
																				   AnimationChannel.Interpolations.LINEAR)))
														   .addAnimation("petRightWing",
																   new AnimationChannel(AnimationChannel.Targets.ROTATION,
																		   new Keyframe(0f, KeyframeAnimations.degreeVec(30f, 0f, 0f),
																				   AnimationChannel.Interpolations.LINEAR),
																		   new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(-30f, 0f, 0f),
																				   AnimationChannel.Interpolations.LINEAR),
																		   new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(30f, 0f, 0f),
																				   AnimationChannel.Interpolations.LINEAR)))
														   .addAnimation("petHead",
																   new AnimationChannel(AnimationChannel.Targets.ROTATION,
																		   new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -20f),
																				   AnimationChannel.Interpolations.LINEAR),
																		   new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(0f, 0f, 15f),
																				   AnimationChannel.Interpolations.LINEAR),
																		   new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(0f, 0f, -20f),
																				   AnimationChannel.Interpolations.LINEAR)))
														   .addAnimation("pet",
																   new AnimationChannel(AnimationChannel.Targets.POSITION,
																		   new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
																				   AnimationChannel.Interpolations.LINEAR),
																		   new Keyframe(0.2916767f, KeyframeAnimations.posVec(0f, 1.3f, 0f),
																				   AnimationChannel.Interpolations.LINEAR),
																		   new Keyframe(0.5834334f, KeyframeAnimations.posVec(0f, 0f, 0f),
																				   AnimationChannel.Interpolations.LINEAR)))
														   .addAnimation("pet",
																   new AnimationChannel(AnimationChannel.Targets.ROTATION,
																		   new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
																				   AnimationChannel.Interpolations.LINEAR),
																		   new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
																				   AnimationChannel.Interpolations.LINEAR),
																		   new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
																				   AnimationChannel.Interpolations.LINEAR))).build();

	@Override
	public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		applyAnimation(this, IDLE, ageInTicks);
//		float animationLength = 10;
//		float progress = (ageInTicks % animationLength) / animationLength;
//
//		petTail.xRot = (float) Math.toRadians(progress * 360f);
//
//		petLeftWing.xRot = (float) Math.toRadians(Math.sin(progress * Math.PI * 2) * 30f);
//		petRightWing.xRot = (float) Math.toRadians(Math.sin(progress * Math.PI * 2 + Math.PI) * 30f);
//		petHead.zRot = (float) Math.toRadians(Math.sin(progress * Math.PI * 2) * 20f - 20f);
	}
}