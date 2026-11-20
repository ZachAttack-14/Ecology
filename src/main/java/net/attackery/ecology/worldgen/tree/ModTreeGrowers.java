package net.attackery.ecology.worldgen.tree;

import net.attackery.ecology.Ecology;
import net.attackery.ecology.worldgen.ModFeatures;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower DWARFED_SPRUCE = new TreeGrower(Ecology.MOD_ID + ":dwarfed_spruce",
            WeightedList.of(ModFeatures.SNOWY_PLAINS_TREE_KEY), WeightedList.of(), WeightedList.of(), null);
}
