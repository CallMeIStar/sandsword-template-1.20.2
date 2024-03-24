package net.istar.sandsword.mixin;

import net.istar.sandsword.item.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(InfinityEnchantment.class)
abstract class MInfinityEnchantment extends Enchantment {
	protected MInfinityEnchantment(Rarity weight, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
		super(weight, target, slotTypes);
	}
	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return super.isAcceptableItem(stack)
				|| stack.isOf(ModItems.DUNESCEPTER);
	}
}