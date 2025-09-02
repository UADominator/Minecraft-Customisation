// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class Pet<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "pet"), "main");
	private final ModelPart player;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart rightArm;
	private final ModelPart leftArm;
	private final ModelPart pet;
	private final ModelPart petHead;
	private final ModelPart petTail;
	private final ModelPart petWings;
	private final ModelPart petLeftWing;
	private final ModelPart petRightWing;

	public Pet(ModelPart root) {
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

		PartDefinition pet = partdefinition.addOrReplaceChild("pet", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 0.0F));

		PartDefinition petHead = pet.addOrReplaceChild("petHead", CubeListBuilder.create().texOffs(12, 10).addBox(-1.0F, -2.5F, -1.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -2.0F));

		PartDefinition petTail = pet.addOrReplaceChild("petTail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition part2_r1 = petTail.addOrReplaceChild("part2_r1", CubeListBuilder.create().texOffs(14, 2).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -0.75F, 1.0F, 0.0F, 1.1345F, 3.1416F));

		PartDefinition part1_r1 = petTail.addOrReplaceChild("part1_r1", CubeListBuilder.create().texOffs(14, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 0.0F, 2.5F, 0.0F, 0.48F, 0.0F));

		PartDefinition petWings = pet.addOrReplaceChild("petWings", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition petLeftWing = petWings.addOrReplaceChild("petLeftWing", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -0.5F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 0.0F));

		PartDefinition petRightWing = petWings.addOrReplaceChild("petRightWing", CubeListBuilder.create().texOffs(0, 5).addBox(-3.0F, -0.5F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		player.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		pet.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}