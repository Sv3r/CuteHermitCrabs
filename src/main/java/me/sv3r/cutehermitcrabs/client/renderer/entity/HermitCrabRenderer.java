package me.sv3r.cutehermitcrabs.client.renderer.entity;

import me.sv3r.cutehermitcrabs.client.renderer.entity.model.HermitCrabModel;
import me.sv3r.cutehermitcrabs.common.CuteHermitCrabs;
import me.sv3r.cutehermitcrabs.common.entity.HermitCrabEntity;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.ParametersAreNonnullByDefault;

@OnlyIn(Dist.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class HermitCrabRenderer extends MobRenderer<HermitCrabEntity, HermitCrabModel<HermitCrabEntity>>
{

    private static final ResourceLocation TEXTURE = new ResourceLocation(CuteHermitCrabs.MOD_ID, "textures/entity/hermit_crab.png");

    public HermitCrabRenderer(EntityRendererProvider.Context context)
    {
        super(context, new HermitCrabModel<>(context.bakeLayer(HermitCrabModel.LAYER_LOCATION), true, 9.5F, 1F, 2F, 2F, 24), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(HermitCrabEntity hermitCrabEntity)
    {
        return TEXTURE;
    }
}
