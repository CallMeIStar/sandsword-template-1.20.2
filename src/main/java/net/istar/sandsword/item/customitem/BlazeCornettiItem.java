package net.istar.sandsword.item.customitem;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class BlazeCornettiItem extends Item {
    public BlazeCornettiItem(Item.Settings settings) {
        super(settings);
    }
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);
        if (!world.isClient) {
            // ... (Existing teleportation code) ...

            // Set the user on fire after teleportation
            user.setOnFireFor(5);  // Adjust the duration as needed
            // Visual and sound effects for fire (optional)
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.PLAYERS, 1.0F, 1.0F);

        }
        return itemStack;
    }

}
