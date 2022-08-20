package me.sv3r.cutehermitcrabs.common.entity;

import me.sv3r.cutehermitcrabs.common.CuteHermitCrabs;
import me.sv3r.cutehermitcrabs.common.registry.CHCEntityRegistry;
import me.sv3r.cutehermitcrabs.common.registry.CHCItemRegistry;
import me.sv3r.cutehermitcrabs.common.registry.CHCSoundRegistry;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class HermitCrabEntity extends Animal implements Bucketable
{
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.SEAGRASS, Items.KELP);
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(HermitCrabEntity.class, EntityDataSerializers.BOOLEAN);

    public HermitCrabEntity(EntityType<? extends Animal> entityType, Level level)
    {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag)
    {
        compoundTag.putBoolean("FromBucket", this.fromBucket());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag)
    {
        this.setFromBucket(compoundTag.getBoolean("FromBucket"));
    }

    @Override
    protected void defineSynchedData()
    {
        super.defineSynchedData();
        this.entityData.define(FROM_BUCKET, false);
    }

    @Override
    protected void registerGoals()
    {
        super.registerGoals();
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.00D));
        this.goalSelector.addGoal(1, new BreedGoal(this, 0.75D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 0.85D, FOOD_ITEMS, false));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 0.85D));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }

    @Override
    public boolean isFood(ItemStack itemStack)
    {
        return FOOD_ITEMS.test(itemStack);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob)
    {
        return CHCEntityRegistry.HERMIT_CRAB.get().create(serverLevel);
    }

    @Override
    protected ResourceLocation getDefaultLootTable()
    {
        return new ResourceLocation(CuteHermitCrabs.MOD_ID, "entities/hermit_crab");
    }

    public static boolean checkHermitCrabSpawnRules(EntityType<HermitCrabEntity> entityType, ServerLevelAccessor serverLevelAccessor,
                                                    MobSpawnType spawnType, BlockPos blockPos, Random random)
    {
        return serverLevelAccessor.getBlockState(blockPos.below()).is(CuteHermitCrabs.Tags.HERMIT_CRAB_SPAWNABLE_BLOCKS) && isBrightEnoughToSpawn(serverLevelAccessor, blockPos);
    }

    @Override
    public boolean canBreatheUnderwater()
    {
        return true;
    }

    @Override
    public boolean isPushedByFluid()
    {
        return false;
    }

    @Override
    public ItemStack getBucketItemStack()
    {
        return new ItemStack(CHCItemRegistry.BUCKET_OF_HERMIT_CRAB.get());
    }

    @Override
    public boolean fromBucket()
    {
        return this.entityData.get(FROM_BUCKET);
    }

    @Override
    public void setFromBucket(boolean fromBucket)
    {
        this.entityData.set(FROM_BUCKET, fromBucket);
    }

    @Override
    public void saveToBucketTag(ItemStack itemStack)
    {
        Bucketable.saveDefaultDataToBucketTag(this, itemStack);
        CompoundTag compoundtag = itemStack.getOrCreateTag();
        compoundtag.putInt("Age", this.getAge());
        compoundtag.putFloat("Health", this.getHealth());
        if (this.hasCustomName())
        {
            itemStack.setHoverName(this.getCustomName());
        }
    }

    @Override
    public void loadFromBucketTag(CompoundTag compoundTag)
    {
        Bucketable.loadDefaultDataFromBucketTag(this, compoundTag);
        if (compoundTag.contains("Age"))
        {
            this.setAge(compoundTag.getInt("Age"));
        }
        if (compoundTag.contains("Health"))
        {
            this.setHealth(compoundTag.getFloat("Health"));
        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand interactionHand)
    {
        return Bucketable.bucketMobPickup(player, interactionHand, this).orElse(super.mobInteract(player, interactionHand));
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource)
    {
        return CHCSoundRegistry.HERMIT_CRAB_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound()
    {
        return CHCSoundRegistry.HERMIT_CRAB_HURT.get();
    }

    @Override
    public SoundEvent getPickupSound()
    {
        return SoundEvents.BUCKET_FILL_FISH;
    }
}