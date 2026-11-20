package net.attackery.ecology.worldgen.gen;

import net.attackery.ecology.worldgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModWorldGeneration {
    public static void  generateModWorldGen() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.SNOWY_PLAINS), GenerationStep.Decoration.UNDERGROUND_ORES,
                ModPlacedFeatures.SNOWY_PLAINS_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.SNOWY_PLAINS),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DWARFED_TREE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.SNOWY_PLAINS),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DWARFED_TREE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.SNOWY_PLAINS),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LICHEN_PLACED_KEY);

    }
}
