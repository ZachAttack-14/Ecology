package net.attackery.ecology.worldgen;

import net.attackery.ecology.Ecology;
import net.attackery.ecology.block.ModBlocks;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.OffsetPlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModFeatures {
    public static final ResourceKey<Feature> SNOWY_PLAINS_ORE_KEY = registerKey("snowy_plains_ore_key");
    public static final ResourceKey<Feature> SNOWY_PLAINS_TREE_KEY = registerKey("snowy_plains_tree_key");
    public static final ResourceKey<Feature> LICHEN_KEY = registerKey("lichen_key");

    public static void bootstrap(BootstrapContext<Feature> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        context.register(SNOWY_PLAINS_ORE_KEY, new OreFeature(
                List.of(BlockReplacement.replace(stoneReplaceables, ModBlocks.SMOOTH_BASALT_IRON_ORE.defaultBlockState()),
                        BlockReplacement.replace(stoneReplaceables, Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState()),
                        BlockReplacement.replace(stoneReplaceables, Blocks.RAW_GOLD_BLOCK.defaultBlockState()),
                        BlockReplacement.replace(stoneReplaceables, Blocks.RAW_IRON_BLOCK.defaultBlockState())),
                9));
        context.register(SNOWY_PLAINS_TREE_KEY, new TreeFeature.Builder(
                BlockStateProvider.of(ModBlocks.DWARFED_SPRUCE_LOG),
                new StraightTrunkPlacer(4, 2, 1),

                BlockStateProvider.of(Blocks.SPRUCE_LEAVES),
                new SpruceFoliagePlacer(UniformInt.of(1, 2), UniformInt.of(1, 3), UniformInt.of(1, 3)),

                new TwoLayersFeatureSize(2, 0, 2),
                BlockStateProvider.holderOf(Blocks.GRASS_BLOCK)).build());

        context.register(LICHEN_KEY, new SimpleRandomSelectorFeature(
                HolderSet.direct(PlacementUtils.inlinePlaced(new SimpleBlockFeature(
                                BlockStateProvider.of(ModBlocks.BLOOMING_LICHEN
                                        .defaultBlockState())),
                        CountPlacement.of(32),
                        OffsetPlacement.ofTriangle(6, 3),
                        BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)))));
    }

    public static ResourceKey<Feature> registerKey(String name) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(Ecology.MOD_ID, name));
    }
}