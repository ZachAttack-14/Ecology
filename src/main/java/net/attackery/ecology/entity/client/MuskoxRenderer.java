package net.attackery.ecology.entity.client;

import net.attackery.ecology.Ecology;
import net.attackery.ecology.entity.custom.MuskoxEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class MuskoxRenderer extends MobRenderer<MuskoxEntity, MuskoxRenderState, MuskoxModel> {
    public MuskoxRenderer(EntityRendererProvider.Context context) {
        super(context, new MuskoxModel(context.bakeLayer(ModModelLayerLocations.MUSKOX)), 0.45f);
    }

    @Override
    public Identifier getTextureLocation(MuskoxRenderState state) {
        return Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "textures/entity/muskox/muskox.png");
    }

    @Override
    public MuskoxRenderState createRenderState() {
        return new MuskoxRenderState();
    }

    @Override
    public void extractRenderState(MuskoxEntity entity, MuskoxRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);

        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }
}