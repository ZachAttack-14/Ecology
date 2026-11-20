package net.attackery.ecology.datagen;

import net.attackery.ecology.block.ModBlocks;
import net.attackery.ecology.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        tag(ModTags.Blocks.DWARFED_LOGS)
                .add(ModBlocks.getRK(ModBlocks.DWARFED_SPRUCE_LOG))
                .add(ModBlocks.getRK(ModBlocks.DWARFED_SPRUCE_POST))
                .add(ModBlocks.getRK(ModBlocks.STRIPPED_DWARFED_SPRUCE_POST))
                .add(ModBlocks.getRK(ModBlocks.STRIPPED_DWARFED_SPRUCE_LOG));

        tag(BlockTags.LOGS)
                .addTag(ModTags.Blocks.DWARFED_LOGS);

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.SMOOTH_BASALT_IRON_ORE));

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.getRK(ModBlocks.SMOOTH_BASALT_IRON_ORE));

    }
}

