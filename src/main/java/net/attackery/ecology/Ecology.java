package net.attackery.ecology;

import net.attackery.ecology.datagen.registries.ModFlammableBlocks;
import net.attackery.ecology.datagen.registries.ModStrippableBlocks;
import net.attackery.ecology.block.ModBlocks;
import net.attackery.ecology.creativemodetab.ModCreativeModeTab;
import net.attackery.ecology.entity.ModEntities;
import net.attackery.ecology.entity.custom.MuskoxEntity;
import net.attackery.ecology.item.ModItems;
import net.attackery.ecology.sound.ModSounds;
import net.attackery.ecology.worldgen.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ecology implements ModInitializer {
	public static final String MOD_ID = "ecology";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTab.registerCreativeModeTabs();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModFlammableBlocks.registerFlammableBlocks();
		ModStrippableBlocks.registerStrippableBlocks();

		ModWorldGeneration.generateModWorldGen();

        ModEntities.registerModEntities();

		ModSounds.registerSounds();

		FabricDefaultAttributeRegistry.register(ModEntities.MUSKOX, MuskoxEntity.createAttributes());
	}
}
