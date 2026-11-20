package net.attackery.ecology.creativemodetab;

import net.attackery.ecology.Ecology;
import net.attackery.ecology.block.ModBlocks;
import net.attackery.ecology.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTab {
    public static final CreativeModeTab ECOLOGY_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "ecology_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(Items.GLOW_INK_SAC))
                    .title(Component.translatable("creativemodetab.ecology.ecology_items"))
                    .displayItems((parameters, output) -> {
                    output.accept(Items.GLOW_INK_SAC);

                    }).build());

    public static final CreativeModeTab ECOLOGY_BLOCK_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "ecology_blocks"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RED_MOSS))
                    .title(Component.translatable("creativemodetab.ecology.ecology_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.ORANGE_MOSS);
                        output.accept(ModBlocks.RED_MOSS);
                        output.accept(ModBlocks.YELLOW_MOSS);
                        output.accept(ModBlocks.BLOOMING_LICHEN);
                        output.accept(ModBlocks.SMOOTH_BASALT_IRON_ORE);
                        output.accept(ModBlocks.WHITE_ICE);
                        output.accept(ModBlocks.DWARFED_SPRUCE_LOG);
                        output.accept(ModBlocks.STRIPPED_DWARFED_SPRUCE_LOG);
                        output.accept(ModBlocks.STRIPPED_DWARFED_SPRUCE_POST);
                        output.accept(ModBlocks.DWARFED_SPRUCE_POST);
                        output.accept(ModBlocks.ORANGE_SHRUB);
                        output.accept(ModBlocks.STUNTED_RED_SHRUB);
                        output.accept(ModBlocks.YELLOW_SHRUB);


                    }).build());

    public static void registerCreativeModeTabs() {
        Ecology.LOGGER.info("Registering Creative Mode Tabs for " + Ecology.MOD_ID);
    }
}
