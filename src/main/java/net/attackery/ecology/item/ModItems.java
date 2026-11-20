package net.attackery.ecology.item;

import net.attackery.ecology.Ecology;
import net.attackery.ecology.entity.ModEntities;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

import java.util.function.Function;

public class ModItems {
    public static final Item MUSKOX_SPAWN_EGG = registerItem(
            properties -> new SpawnEggItem(properties.spawnEgg(ModEntities.MUSKOX)));



    private static Item registerItem(Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "muskox_spawn_egg"),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "muskox_spawn_egg")))));
    }

    public static void registerModItems() {
        Ecology.LOGGER.info("Registering Mod Items for " + Ecology.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.SPAWN_EGGS).register(output -> {
            output.accept(MUSKOX_SPAWN_EGG);
        });
    }
}