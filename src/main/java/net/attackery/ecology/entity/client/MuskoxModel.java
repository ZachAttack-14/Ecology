package net.attackery.ecology.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

import javax.swing.text.html.parser.Entity;


public class MuskoxModel extends EntityModel<MuskoxRenderState> {

    private final ModelPart leg4;
    private final ModelPart leg3;
    private final ModelPart leg2;
    private final ModelPart leg1;
    private final ModelPart head;
    private final ModelPart head_rotation;
    private final ModelPart bone;
    private final ModelPart body;
    private final ModelPart rotation;

    private final KeyframeAnimation walkingAnimation;
    private final KeyframeAnimation idlingAnimation;

    public MuskoxModel(ModelPart root) {
        super(root);

        this.leg4 = root.getChild("leg4");
        this.leg3 = root.getChild("leg3");
        this.leg2 = root.getChild("leg2");
        this.leg1 = root.getChild("leg1");
        this.head = root.getChild("head");
        this.head_rotation = this.head.getChild("head_rotation");
        this.bone = this.head.getChild("bone");
        this.body = root.getChild("body");
        this.rotation = this.body.getChild("rotation");

        this.walkingAnimation = MuskoxAnim.WALK.bake(root);
        this.idlingAnimation = MuskoxAnim.IDLE.bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition leg4 = partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(54, 0).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 12.0F, -6.0F));

        PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(54, 16).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 12.0F, -6.0F));

        PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 61).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 12.0F, 6.0F));

        PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(16, 61).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 12.0F, 6.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, -7.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition head_rotation = head.addOrReplaceChild("head_rotation", CubeListBuilder.create().texOffs(44, 33).addBox(-3.0F, -5.0F, -6.0F, 6.0F, 9.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(68, 65).addBox(-2.0F, 6.0F, -6.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(32, 61).addBox(-3.0F, 4.0F, -6.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(56, 61).addBox(-6.0F, -4.0F, -4.0F, 12.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(83, 52).addBox(-4.0F, -4.0F, -7.0F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0872F, -0.9981F, -0.5236F, 0.0F, 0.0F));

        PartDefinition bone = head.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(56, 65).addBox(0.0F, 4.0F, -4.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9128F, -1.9981F, 0.0436F, 0.0F, 0.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 1.0F));

        PartDefinition rotation = body.addOrReplaceChild("rotation", CubeListBuilder.create().texOffs(0, 33).addBox(-6.0F, -9.0F, -9.0F, 12.0F, 18.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-6.5F, -9.5F, -13.0F, 13.0F, 19.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(44, 49).addBox(-6.5F, -9.5F, 1.0F, 13.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(32, 69).addBox(-2.0F, 3.0F, -11.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 1.5708F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay);
    }

    @Override
    public void setupAnim(MuskoxRenderState state) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(state.yRot, state.xRot);

        this.walkingAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 3f, 2.5f);
        this.idlingAnimation.apply(state.idleAnimationState, state.ageInTicks, 1f);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.head.yRot = headYaw * ((float)Math.PI / 180f);
        this.head.xRot = headPitch *  ((float)Math.PI / 180f);
    }
}
