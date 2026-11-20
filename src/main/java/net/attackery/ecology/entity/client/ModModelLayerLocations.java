package net.attackery.ecology.entity.client;

import net.attackery.ecology.Ecology;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class ModModelLayerLocations {
    public static final ModelLayerLocation MUSKOX =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "muskox"), "main");
}
