package net.attackery.ecology.datagen.registries;

import net.attackery.ecology.block.ModBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModFlammableBlocks {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DWARFED_SPRUCE_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DWARFED_SPRUCE_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DWARFED_SPRUCE_POST, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DWARFED_SPRUCE_POST, 5, 5);
    }
}
