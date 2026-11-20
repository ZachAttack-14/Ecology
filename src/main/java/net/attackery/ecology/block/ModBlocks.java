package net.attackery.ecology.block;

import net.attackery.ecology.block.custom.BloomingLichenBlock;
import net.attackery.ecology.block.custom.DwarfedLogBlock;
import net.attackery.ecology.block.custom.DwarfedPostBlock;
import net.attackery.ecology.Ecology;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

import java.util.function.Function;

public class ModBlocks {
    public static final Block BLOOMING_LICHEN = registerBlock("blooming_lichen",
            properties -> new BloomingLichenBlock(properties.noCollision().sound(SoundType.GLOW_LICHEN).lightLevel(BlockBehaviour.BlockStateBase::getLightEmission)));
    public  static final Block ORANGE_MOSS = registerBlock("orange_moss",
            properties -> new Block(properties.strength(0.1f)
                    .sound(SoundType.MOSS)));
    public  static final Block RED_MOSS = registerBlock("red_moss",
            properties -> new Block(properties.strength(0.1f)
                    .sound(SoundType.MOSS)));
    public  static final Block YELLOW_MOSS = registerBlock("yellow_moss",
            properties -> new Block(properties.strength(0.1f)
                    .sound(SoundType.MOSS)));
    public  static final Block SMOOTH_BASALT_IRON_ORE = registerBlock("smooth_basalt_iron_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 5), properties.strength(7.5f)
                .requiresCorrectToolForDrops().sound(SoundType.BASALT)));
    public  static final Block STUNTED_RED_SHRUB = registerBlock("stunted_red_shrub",
            properties -> new Block(properties.strength(0.1f)
                    .sound(SoundType.RED_SHRUB)));
    public  static final Block ORANGE_SHRUB = registerBlock("orange_shrub",
            properties -> new Block(properties.strength(0.1f)
                    .sound(SoundType.RED_SHRUB)));
    public  static final Block YELLOW_SHRUB = registerBlock("yellow_shrub",
            properties -> new Block(properties.strength(0.1f)
                    .sound(SoundType.RED_SHRUB)));
    public  static final Block WHITE_ICE = registerBlock("white_ice",
            properties -> new Block(properties.strength(0.5f)
                .requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final Block DWARFED_SPRUCE_LOG = registerBlock("dwarfed_spruce_log",
            properties -> new DwarfedLogBlock(properties.strength(2.0f, 3.0f).instrument(NoteBlockInstrument.BASS).ignitedByLava().sound(SoundType.WOOD)));
    public static final Block DWARFED_SPRUCE_POST = registerBlock("dwarfed_spruce_post",
            properties -> new DwarfedPostBlock(properties.strength(2.0f, 3.0f).instrument(NoteBlockInstrument.BASS).ignitedByLava().sound(SoundType.WOOD)));
    public static final Block STRIPPED_DWARFED_SPRUCE_LOG = registerBlock("stripped_dwarfed_spruce_log",
            properties -> new DwarfedLogBlock(properties.strength(2.0f, 3.0f).instrument(NoteBlockInstrument.BASS).ignitedByLava().sound(SoundType.WOOD)));
    public static final Block STRIPPED_DWARFED_SPRUCE_POST = registerBlock("stripped_dwarfed_spruce_post",
            properties -> new DwarfedPostBlock(properties.strength(2.0f, 3.0f).instrument(NoteBlockInstrument.BASS).ignitedByLava().sound(SoundType.WOOD)));



    public static ResourceKey<Block> getRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Ecology.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Ecology.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Ecology.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Ecology.MOD_ID, name)))));
}

    public static void registerModBlocks() {
        Ecology.LOGGER.info("Registering Mod Blocks for " + Ecology.MOD_ID);
    }
}
