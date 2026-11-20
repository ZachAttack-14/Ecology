package net.attackery.ecology.datagen.registries;

import net.attackery.ecology.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.BlockTransformerHelper;

public class ModStrippableBlocks {
    public static void registerStrippableBlocks() {
        BlockTransformerHelper.registerStripping(ModBlocks.DWARFED_SPRUCE_LOG, ModBlocks.STRIPPED_DWARFED_SPRUCE_LOG);
        BlockTransformerHelper.registerStripping(ModBlocks.DWARFED_SPRUCE_POST, ModBlocks.STRIPPED_DWARFED_SPRUCE_POST);

    }
}