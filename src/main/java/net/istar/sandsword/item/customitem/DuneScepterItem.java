package net.istar.sandsword.item.customitem;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.istar.sandsword.entity.custom.DuneEdgeEntity;
import net.istar.sandsword.item.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Vanishable;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class DuneScepterItem extends Item implements Vanishable {
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public DuneScepterItem(Item.Settings settings) {
        super(settings.rarity(Rarity.EPIC).maxCount(1).maxDamage(256));
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        this.attributeModifiers = builder.build();
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return super.isEnchantable(stack) && stack.getItem() == this;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPYGLASS;
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            return this.attributeModifiers;
        }
        return super.getAttributeModifiers(slot);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack itemStack = playerEntity.getStackInHand(hand);

        if (!world.isClient) {
            // Check for creative mode or Infinity enchantment
            if (playerEntity.getAbilities().creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY, itemStack) > 0) {
                // Skip sand check and proceed normally (no sand consumption)

                itemStack.damage(1, playerEntity, (entity) -> entity.sendToolBreakStatus(hand));

                world.playSound(null, playerEntity.getBlockPos(), SoundEvents.BLOCK_SAND_BREAK, SoundCategory.NEUTRAL, 0.2f, 0.1f);

                DuneEdgeEntity duneEdgeEntity = new DuneEdgeEntity(world, playerEntity, itemStack);
                duneEdgeEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0f, 4f, 1.0f);
                world.spawnEntity(duneEdgeEntity);

                playerEntity.getItemCooldownManager().set(this, 10); // Apply cooldown

                return TypedActionResult.success(itemStack);
            } else {
                int sandSlot = playerEntity.getInventory().getSlotWithStack(new ItemStack(Items.SAND)); // Find the slot with sand
                if (sandSlot != -1) {
                    ItemStack sandStack = playerEntity.getInventory().getStack(sandSlot);
                    sandStack.decrement(1); // Decrement sand stack by 1
                    if (sandStack.isEmpty()) {
                        playerEntity.getInventory().removeStack(sandSlot); // Remove empty stack
                    }

                    itemStack.damage(1, playerEntity, (entity) -> entity.sendToolBreakStatus(hand));

                    world.playSound(null, playerEntity.getBlockPos(), SoundEvents.BLOCK_SAND_BREAK, SoundCategory.NEUTRAL, 0.2f, 0.1f);

                    DuneEdgeEntity duneEdgeEntity = new DuneEdgeEntity(world, playerEntity, itemStack);
                    duneEdgeEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0f, 4f, 1.0f);
                    world.spawnEntity(duneEdgeEntity);

                    playerEntity.getItemCooldownManager().set(this, 10); // Apply cooldown

                    return TypedActionResult.success(itemStack);
                } else {
                    return TypedActionResult.fail(itemStack); // Indicate failure if no sand found
                }
            }
        }

        // Play sound for client-side feedback
        world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.NEUTRAL, 0.8f, 0.8f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        return TypedActionResult.pass(itemStack);
    }
    @Override
    public int getEnchantability() {
        return 1;
    }
    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        // Check if the ingredient is a Sunshard
        return ingredient.getItem() == ModItems.SUNSHARD;
    }
}