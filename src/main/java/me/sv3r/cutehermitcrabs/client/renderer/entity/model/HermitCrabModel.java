package me.sv3r.cutehermitcrabs.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import me.sv3r.cutehermitcrabs.common.entity.HermitCrabEntity;
import me.sv3r.cutehermitcrabs.core.CuteHermitCrabs;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HermitCrabModel<T extends HermitCrabEntity> extends AgeableListModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(CuteHermitCrabs.MOD_ID, "hermit_crab"), "main");

    private final ModelPart shell;
    private final ModelPart left_back_leg;
    private final ModelPart left_middle_leg;
    private final ModelPart left_front_leg;
    private final ModelPart right_back_leg;
    private final ModelPart right_middle_leg;
    private final ModelPart right_front_leg;
    private final ModelPart left_claw;
    private final ModelPart right_claw;
    private final ModelPart body;
    private final ModelPart left_eye;
    private final ModelPart right_eye;

    private final boolean scaleHead;
    private final float babyYHeadOffset;
    private final float babyZHeadOffset;
    private final float babyHeadScale;
    private final float babyBodyScale;
    private final float bodyYOffset;

    public HermitCrabModel(ModelPart root, boolean pScaleHead, float pBabyYHeadOffset, float pBabyZHeadOffset, float pBabyHeadScale, float pBabyBodyScale, float pBodyYOffset) {
        this.shell = root.getChild("shell");
        this.left_back_leg = root.getChild("left_back_leg");
        this.left_middle_leg = root.getChild("left_middle_leg");
        this.left_front_leg = root.getChild("left_front_leg");
        this.right_back_leg = root.getChild("right_back_leg");
        this.right_middle_leg = root.getChild("right_middle_leg");
        this.right_front_leg = root.getChild("right_front_leg");
        this.left_claw = root.getChild("left_claw");
        this.right_claw = root.getChild("right_claw");
        this.body = root.getChild("body");
        this.left_eye = root.getChild("left_eye");
        this.right_eye = root.getChild("right_eye");

        this.scaleHead = pScaleHead;
        this.babyYHeadOffset = pBabyYHeadOffset;
        this.babyZHeadOffset = pBabyZHeadOffset;
        this.babyHeadScale = pBabyHeadScale;
        this.babyBodyScale = pBabyBodyScale;
        this.bodyYOffset = pBodyYOffset;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition shell = partdefinition.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -5.0F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.5F, 2.0F));
        PartDefinition left_back_leg = partdefinition.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 22.5F, 2.5F, 0.0F, 0.0F, 0.0F));
        PartDefinition left_middle_leg = partdefinition.addOrReplaceChild("left_middle_leg", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 22.5F, 0.5F));
        PartDefinition left_front_leg = partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(18, 14).mirror().addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 22.5F, -1.5F));
        PartDefinition right_back_leg = partdefinition.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(18, 14).addBox(-4.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 22.5F, 2.5F));
        PartDefinition right_middle_leg = partdefinition.addOrReplaceChild("right_middle_leg", CubeListBuilder.create().texOffs(18, 14).addBox(-4.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 22.5F, 0.5F));
        PartDefinition right_front_leg = partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(18, 14).addBox(-4.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 22.5F, -1.5F));
        PartDefinition left_claw = partdefinition.addOrReplaceChild("left_claw", CubeListBuilder.create(), PartPose.offset(2.0F, 22.0F, -4.0F));
        PartDefinition left_claw_r1 = left_claw.addOrReplaceChild("left_claw_r1", CubeListBuilder.create().texOffs(21, 0).mirror().addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F));
        PartDefinition right_claw = partdefinition.addOrReplaceChild("right_claw", CubeListBuilder.create().texOffs(21, 0).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 22.0F, -4.0F));
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 14).addBox(-2.5F, -1.5F, -4.0F, 5.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));
        PartDefinition left_eye = partdefinition.addOrReplaceChild("left_eye", CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 20.5F, -3.0F));
        PartDefinition right_eye = partdefinition.addOrReplaceChild("right_eye", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-0.5F, -4.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 20.5F, -3.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.shell.xRot = -0.10f;
        this.right_eye.zRot = -0.15f;
        this.left_eye.zRot = 0.15f;
        this.left_claw.xRot = -0.10f;
        this.left_claw.yRot = -0.15f;
        this.right_claw.xRot = -0.10f;
        this.right_claw.yRot = 0.15f;
        this.left_front_leg.yRot = 0.45f;
        this.left_front_leg.zRot = 0.30f;
        this.left_middle_leg.yRot = 0f;
        this.left_middle_leg.zRot = 0.30f;
        this.left_back_leg.yRot = -0.45f;
        this.left_back_leg.zRot = 0.30f;
        this.right_front_leg.yRot = -0.45f;
        this.right_front_leg.zRot = -0.30f;
        this.right_middle_leg.yRot = 0f;
        this.right_middle_leg.zRot = -0.30f;
        this.right_back_leg.yRot = 0.45f;
        this.right_back_leg.zRot = -0.30f;
        this.right_front_leg.z = -0.5f;
        this.right_back_leg.z = 1.5f;
        this.left_front_leg.z = -0.5f;
        this.left_back_leg.z = 1.5f;

        float lookMultiplier = 0.5f;

        this.right_eye.xRot = lookMultiplier * 0.5F * headPitch * ((float) Math.PI / 180F);
        this.left_eye.xRot = lookMultiplier * 0.5F * headPitch * ((float) Math.PI / 180F);
        this.right_eye.yRot = lookMultiplier * netHeadYaw * ((float) Math.PI / 180F);
        this.left_eye.yRot = lookMultiplier * netHeadYaw * ((float) Math.PI / 180F);

        float height = 0.5f;
        float speed = 5.0f;
        float f1 = Mth.cos(speed * limbSwing) * (limbSwingAmount * height);
        float f2 = Mth.cos((speed * limbSwing) + 1f) * (limbSwingAmount * height);
        float f3 = Mth.cos((speed * limbSwing) + 2f) * (limbSwingAmount * height);
        this.left_front_leg.zRot += f1;
        this.left_middle_leg.zRot += f2;
        this.left_back_leg.zRot += f3;
        this.right_front_leg.zRot += f1;
        this.right_middle_leg.zRot += f2;
        this.right_back_leg.zRot += f3;

        float f4 = Mth.sin(speed * limbSwing) * (limbSwingAmount * height);
        float f5 = Mth.sin((speed * limbSwing) + 1f) * (limbSwingAmount * height);
        float f6 = Mth.sin((speed * limbSwing) + 2f) * (limbSwingAmount * height);
        this.left_front_leg.yRot += f4;
        this.left_middle_leg.yRot += f5;
        this.left_back_leg.yRot += f6;
        this.right_front_leg.yRot += f4;
        this.right_middle_leg.yRot += f5;
        this.right_back_leg.yRot += f6;
    }

    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        if (this.young)
        {
            this.shell.visible = false;
            pPoseStack.pushPose();
            if (this.scaleHead) {
                float f = 1.5F / this.babyHeadScale;
                pPoseStack.scale(f, f, f);
            }

            pPoseStack.translate(0.0D, (double)(this.babyYHeadOffset / 16.0F), (double)(this.babyZHeadOffset / 16.0F));
            this.headParts().forEach((modelPart) -> {
                modelPart.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
            });
            pPoseStack.popPose();
            pPoseStack.pushPose();
            float f1 = 1.0F / this.babyBodyScale;
            pPoseStack.scale(f1, f1, f1);
            pPoseStack.translate(0.0D, (double)(this.bodyYOffset / 16.0F), 0.0D);
            this.bodyParts().forEach((modelPart) -> {
                modelPart.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
            });
            pPoseStack.popPose();
        }
        else
        {
            this.shell.visible = true;
            this.headParts().forEach((p_102061_) -> {
                p_102061_.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
            });
            this.bodyParts().forEach((p_102051_) -> {
                p_102051_.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
            });
        }
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.left_eye, this.right_eye);
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(
                this.body,
                this.shell,
                this.right_claw,
                this.left_claw,
                this.right_front_leg,
                this.right_middle_leg,
                this.right_back_leg,
                this.left_front_leg,
                this.left_middle_leg,
                this.left_back_leg
        );
    }
}