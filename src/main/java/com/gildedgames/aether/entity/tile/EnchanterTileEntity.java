package com.gildedgames.aether.entity.tile;

import com.gildedgames.aether.Aether;
import com.gildedgames.aether.crafting.AetherRecipeTypes;
import com.gildedgames.aether.api.AetherAPI;
import com.gildedgames.aether.inventory.container.EnchanterContainer;

import com.gildedgames.aether.registry.AetherTileEntityTypes;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class EnchanterTileEntity extends AbstractFurnaceTileEntity
{
	protected EnchanterTileEntity(TileEntityType<?> tileTypeIn, IRecipeType<? extends AbstractCookingRecipe> recipeTypeIn) {
		super(tileTypeIn, recipeTypeIn);
	}
	
	public EnchanterTileEntity() {
		super(AetherTileEntityTypes.ENCHANTER.get(), AetherRecipeTypes.ENCHANTING);
	}

	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container." + Aether.MODID + ".enchanter");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new EnchanterContainer(id, player, this, this.furnaceData);
	}
	
	@Override
	protected int getBurnTime(ItemStack stack) {
		return !stack.isEmpty()? AetherAPI.getEnchantmentFuelTime(stack.getItem()) : 0;
	}

}