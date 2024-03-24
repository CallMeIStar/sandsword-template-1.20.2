package net.istar.sandsword.item.customitem;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
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
        super(settings.rarity(Rarity.EPIC).maxCount(1).maxDamage(512));
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        this.attributeModifiers = builder.build();
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return super.isEnchantable(stack) && stack.getItem() == this; // Only allow enchanting this item
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
            if (playerEntity.getInventory().contains(new ItemStack(Items.SAND, 1))) {

                itemStack.damage(1, playerEntity, (entity) -> entity.sendToolBreakStatus(hand));

                world.playSound(null, playerEntity.getBlockPos(), SoundEvents.BLOCK_SAND_BREAK, SoundCategory.NEUTRAL, 0.2f, 0.1f);
                playerEntity.getItemCooldownManager().set(this, 60);

                return TypedActionResult.success(itemStack);
            } else {
                return TypedActionResult.fail(itemStack);
            }
        }
        return TypedActionResult.pass(itemStack);
    }
    @Override
    public int getEnchantability() {
        return 1;
    }
}