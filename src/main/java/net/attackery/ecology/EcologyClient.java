package net.attackery.ecology;

import net.attackery.ecology.entity.ModEntities;
import net.attackery.ecology.entity.client.ModModelLayerLocations;
import net.attackery.ecology.entity.client.MuskoxModel;
import net.attackery.ecology.entity.client.MuskoxRenderer;
import net.attackery.ecology.entity.goals.HerdingGoal;
import net.attackery.ecology.keymapping.ModKeyMappings;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class EcologyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModKeyMappings.register();

    ModelLayerRegistry.registerModelLayer(ModModelLayerLocations.MUSKOX, MuskoxModel::createBodyLayer);
        EntityRenderers.register(ModEntities.MUSKOX, MuskoxRenderer::new);

    }
}


