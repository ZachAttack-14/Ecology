package net.attackery.ecology.datagen;

import net.attackery.ecology.block.ModBlocks;
import net.attackery.ecology.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.ORANGE_MOSS);
        blockModelGenerators.createTrivialCube(ModBlocks.RED_MOSS);
        blockModelGenerators.createTrivialCube(ModBlocks.YELLOW_MOSS);
        blockModelGenerators.createTrivialCube(ModBlocks.SMOOTH_BASALT_IRON_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.WHITE_ICE);

        blockModelGenerators.createNonTemplateModelBlock(ModBlocks.DWARFED_SPRUCE_LOG);
        blockModelGenerators.createNonTemplateModelBlock(ModBlocks.DWARFED_SPRUCE_POST);
        blockModelGenerators.createNonTemplateModelBlock(ModBlocks.STRIPPED_DWARFED_SPRUCE_LOG);
        blockModelGenerators.createNonTemplateModelBlock(ModBlocks.STRIPPED_DWARFED_SPRUCE_POST);
        blockModelGenerators.createCrossBlock(ModBlocks.BLOOMING_LICHEN, BlockModelGenerators.PlantType.NOT_TINTED);
        blockModelGenerators.createCrossBlock(ModBlocks.ORANGE_SHRUB, BlockModelGenerators.PlantType.NOT_TINTED);
        blockModelGenerators.createCrossBlock(ModBlocks.STUNTED_RED_SHRUB, BlockModelGenerators.PlantType.NOT_TINTED);
        blockModelGenerators.createCrossBlock(ModBlocks.YELLOW_SHRUB, BlockModelGenerators.PlantType.NOT_TINTED);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.MUSKOX_SPAWN_EGG, ModelTemplates.FLAT_ITEM);

    }
}
