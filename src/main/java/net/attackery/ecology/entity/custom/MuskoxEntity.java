package net.attackery.ecology.entity.custom;

import net.attackery.ecology.entity.ModEntities;
import net.attackery.ecology.entity.goals.HerdingGoal;
import net.attackery.ecology.sound.ModSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class MuskoxEntity extends Animal {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public MuskoxEntity(EntityType<? extends Animal> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25, stack -> stack.is(Items.GLOW_LICHEN), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25));
        this.goalSelector.addGoal(4, new HerdingGoal(this, 0.5));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }


    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10d)
                .add(Attributes.MOVEMENT_SPEED, 0.2);
    }

    /* SOUNDS */
    @Override
    protected @Nullable SoundEvent getHurtSound(@NonNull DamageSource source) {
        return ModSounds.MUSKOX_ATTACK;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ModSounds.MUSKOX_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSounds.MUSKOX_DEATH;
    }

    /* Breedable */

    @Override
    public @Nullable AgeableMob getBreedOffspring(@NonNull ServerLevel level, @NonNull AgeableMob partner) {
        return ModEntities.MUSKOX.create(level, EntitySpawnReason.BREEDING);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(Items.GLOW_LICHEN);
    }
}
