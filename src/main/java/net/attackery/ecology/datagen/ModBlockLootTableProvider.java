package net.attackery.ecology.datagen;

import net.attackery.ecology.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.DWARFED_SPRUCE_LOG);
        dropSelf(ModBlocks.DWARFED_SPRUCE_POST);
        dropSelf(ModBlocks.STRIPPED_DWARFED_SPRUCE_LOG);
        dropSelf(ModBlocks.STRIPPED_DWARFED_SPRUCE_POST);
        dropSelf(ModBlocks.YELLOW_MOSS);
        dropSelf(ModBlocks.RED_MOSS);
        dropSelf(ModBlocks.ORANGE_MOSS);
        dropSelf(ModBlocks.ORANGE_SHRUB);
        dropSelf(ModBlocks.STUNTED_RED_SHRUB);
        dropSelf(ModBlocks.YELLOW_SHRUB);
        dropSelf(ModBlocks.BLOOMING_LICHEN);

        add(ModBlocks.SMOOTH_BASALT_IRON_ORE, createMultipleOreDrops(ModBlocks.SMOOTH_BASALT_IRON_ORE, Items.RAW_IRON, 2,3));

    }

    public LootTable.Builder createMultipleOreDrops(final Block block, Item item, int minDrops, int maxDrops) {
        return this.createSilkTouchDispatchTable(
                block, this.applyExplosionDecay(
                        block, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(this.enchantments.getOrThrow(Enchantments.FORTUNE)))));
    }
}
