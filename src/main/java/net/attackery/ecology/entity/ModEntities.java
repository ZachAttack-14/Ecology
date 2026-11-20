package net.attackery.ecology.entity;

import net.attackery.ecology.Ecology;
import net.attackery.ecology.entity.custom.MuskoxEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {
    public static final ResourceKey<EntityType<?>> MUSKOX_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "muskox"));

    public static final EntityType<MuskoxEntity> MUSKOX = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "muskox"),
            EntityType.Builder.of(MuskoxEntity::new, MobCategory.CREATURE).sized(0.75f, 1.5f).build(MUSKOX_KEY));


    public static void registerModEntities() {
        Ecology.LOGGER.info("Registering Mod Entities for " + Ecology.MOD_ID);
    }
}
