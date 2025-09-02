package net.harmoniya.customisation.render.model.models;

import net.harmoniya.customisation.Customisation;
import net.harmoniya.customisation.render.model.AbstractBaseLayerModel;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class PetLayerModel extends AbstractBaseLayerModel<LivingEntity> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Customisation.MODID, "pet"), "main");
	private final ModelPart pet;
	private final ModelPart petHead;
	private final ModelPart petTail;
	private final ModelPart petWings;
	private final ModelPart petLeftWing;
	private final ModelPart petRightWing;

	public PetLayerModel(ModelPart root) {
		super(root);
		this.player = root.getChild("player");
		this.body = this.player.getChild("body");
		this.head = this.player.getChild("head");
		this.rightArm = this.player.getChild("rightArm");
		this.leftArm = this.player.getChild("leftArm");

		this.pet = root.getChild("pet");
		this.petHead = this.pet.getChild("petHead");
		this.petTail = this.pet.getChild("petTail");
		this.petWings = this.pet.getChild("petWings");
		this.petLeftWing = this.petWings.getChild("petLeftWing");
		this.petRightWing = this.petWings.getChild("petRightWing");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition player = partdefinition.addOrReplaceChild("player", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition body = player.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = player.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightArm = player.addOrReplaceChild("rightArm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftArm = player.addOrReplaceChild("leftArm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition pet = partdefinition.addOrReplaceChild("pet", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -8.0F, 0.0F));

		PartDefinition petHead = pet.addOrReplaceChild("petHead", CubeListBuilder.create().texOffs(12, 10).addBox(-1.0F, -2.5F, -1.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -2.0F));

		PartDefinition petTail = pet.addOrReplaceChild("petTail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition part2_r1 = petTail.addOrReplaceChild("part2_r1", CubeListBuilder.create().texOffs(14, 2).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -0.75F, 1.0F, 0.0F, 1.1345F, 3.1416F));

		PartDefinition part1_r1 = petTail.addOrReplaceChild("part1_r1", CubeListBuilder.create().texOffs(14, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 0.0F, 2.5F, 0.0F, 0.48F, 0.0F));

		PartDefinition petWings = pet.addOrReplaceChild("petWings", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition petLeftWing = petWings.addOrReplaceChild("petLeftWing", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -0.5F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 0.0F));

		PartDefinition petRightWing = petWings.addOrReplaceChild("petRightWing", CubeListBuilder.create().texOffs(0, 5).addBox(-3.0F, -0.5F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}


	public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(0.5F).looping()
														   .addAnimation("pet", new AnimationChannel(AnimationChannel.Targets.ROTATION,
																   new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
																   new Keyframe(0.25F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
																   new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
														   ))
														   .addAnimation("pet", new AnimationChannel(AnimationChannel.Targets.POSITION,
																   new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
																   new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
																   new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
														   ))
														   .addAnimation("petHead", new AnimationChannel(AnimationChannel.Targets.ROTATION,
																   new Keyframe(0.0F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
																   new Keyframe(0.25F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
																   new Keyframe(0.5F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
														   ))
														   .addAnimation("petTail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
																   new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
																   new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 720.0F), AnimationChannel.Interpolations.LINEAR)
														   ))
														   .addAnimation("petLeftWing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
																   new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -32.5F), AnimationChannel.Interpolations.LINEAR),
																   new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 25.0F), AnimationChannel.Interpolations.LINEAR),
																   new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -32.5F), AnimationChannel.Interpolations.LINEAR)
														   ))
														   .addAnimation("petRightWing", new AnimationChannel(AnimationChannel.Targets.ROTATION,
																   new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 32.5F), AnimationChannel.Interpolations.LINEAR),
																   new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -25.0F), AnimationChannel.Interpolations.LINEAR),
																   new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 32.5F), AnimationChannel.Interpolations.LINEAR)
														   ))
														   .build();


	@Override
	public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		idleAnimationState.startIfStopped((int) (ageInTicks));
		animate(idleAnimationState, IDLE, ageInTicks);
	}

	@Override
	public void copyFromPlayerModel(HumanoidModel<?> playerModel) {
		super.copyFromPlayerModel(playerModel);
		this.pet.copyFrom(this.player);
	}
}