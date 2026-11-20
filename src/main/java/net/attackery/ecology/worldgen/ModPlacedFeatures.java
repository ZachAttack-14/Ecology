package net.attackery.ecology.worldgen;

import net.attackery.ecology.Ecology;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> SNOWY_PLAINS_ORE_PLACED_KEY = registerKey("snowy_plains_ore_placed");

    public static final ResourceKey<PlacedFeature> DWARFED_TREE_PLACED_KEY = registerKey("dwarfed_tree_placed_key");

    public static final ResourceKey<PlacedFeature> LICHEN_PLACED_KEY = registerKey("lichen_placed_key");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var Features = context.lookup(Registries.FEATURE);

        register(context, SNOWY_PLAINS_ORE_PLACED_KEY, Features.getOrThrow(ModFeatures.SNOWY_PLAINS_ORE_KEY),
                OrePlacements.commonOrePlacement(12,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(100))));

        register(context, DWARFED_TREE_PLACED_KEY, Features.getOrThrow(ModFeatures.SNOWY_PLAINS_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        Blocks.SPRUCE_SAPLING));

        register(context, LICHEN_PLACED_KEY, Features.getOrThrow(ModFeatures.LICHEN_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(Ecology.MOD_ID, name));

    }


    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<Feature> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}