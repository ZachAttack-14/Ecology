package net.attackery.ecology.sound;

import net.attackery.ecology.Ecology;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {
    public static final SoundEvent MUSKOX_AMBIENT = registerSoundEvent("muskox_ambient");
    public static final SoundEvent MUSKOX_ATTACK = registerSoundEvent("muskox_attack");
    public static final SoundEvent MUSKOX_DEATH = registerSoundEvent("muskox_death");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(Ecology.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }


    public static void registerSounds() {
        Ecology.LOGGER.info("Registering sounds for " + Ecology.MOD_ID);
    }
}
