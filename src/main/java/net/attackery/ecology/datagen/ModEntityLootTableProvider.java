package net.attackery.ecology.datagen;

import net.attackery.ecology.entity.ModEntities;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricEntityLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.UniformContainerBase;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.concurrent.CompletableFuture;

public class ModEntityLootTableProvider extends FabricEntityLootSubProvider {
    public ModEntityLootTableProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate() {
        this.add(ModEntities.MUSKOX,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add((LootPoolEntryContainer.Builder)((UniformContainerBase.Builder)
                                LootItem.lootTableItem(Items.LEATHER)
                                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(0, 2))))
                                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.enchantments,
                                        ContextFloatProviders.between(0.0F, 1.0F)))))
                                .withPool(LootPool.lootPool().setRolls(ContextIntProviders.exactly(1))
                                        .add((LootPoolEntryContainer.Builder)((UniformContainerBase.Builder)
                                LootItem.lootTableItem(Items.STRING)
                                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(0, 1))))
                                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.enchantments,
                                        ContextFloatProviders.between(0.0F, 1.0F)))))
                                .withPool(LootPool.lootPool().setRolls(ContextIntProviders.exactly(1))
                        .add((LootPoolEntryContainer.Builder)((UniformContainerBase.Builder)((UniformContainerBase.Builder)
                                LootItem.lootTableItem(Items.BEEF)
                                                .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3))))
                                                .apply((LootItemFunction.Builder) SmeltItemFunction.smelted()
                                         .when(this.shouldSmeltLoot()))).apply(EnchantedCountIncreaseFunction
                                        .lootingMultiplier(this.enchantments, ContextFloatProviders.between(0.0F, 1.0F)))
                                        ).when(LootItemKilledByPlayerCondition.killedByPlayer())));


    }
}
