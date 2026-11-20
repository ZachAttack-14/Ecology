package net.attackery.ecology.datagen;

import net.attackery.ecology.Ecology;
import net.attackery.ecology.sound.ModSounds;
import net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricSoundsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModSoundsProvider extends FabricSoundsProvider {
    public ModSoundsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registryLookup, SoundExporter exporter) {
        exporter.add(ModSounds.MUSKOX_AMBIENT, SoundTypeBuilder.of(ModSounds.MUSKOX_AMBIENT).subtitle("sounds.ecology.muskox_ambient")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "muskox_ambient_1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "muskox_ambient_2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "muskox_ambient_3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "muskox_ambient_4")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "muskox_ambient_5"))));

        exporter.add(ModSounds.MUSKOX_ATTACK, SoundTypeBuilder.of(ModSounds.MUSKOX_ATTACK).subtitle("sounds.ecology.muskox_attack")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "muskox_attack_1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "muskox_attack_2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "muskox_attack_3"))));

        exporter.add(ModSounds.MUSKOX_DEATH, SoundTypeBuilder.of(ModSounds.MUSKOX_DEATH).subtitle("sounds.ecology.muskox_death")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "muskox_death_1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(Ecology.MOD_ID, "muskox_death_2"))));
    }

    @Override
    public String getName() {
        return "Ecology Sounds";
    }
}
