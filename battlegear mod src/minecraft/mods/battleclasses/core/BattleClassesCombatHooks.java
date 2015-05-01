package mods.battleclasses.core;

import java.util.List;

import mods.battleclasses.BattleClassesUtils;
import mods.battleclasses.items.IControlledSpeedWeapon;
import mods.battlegear2.api.IHandListener;
import mods.battlegear2.api.PlayerEventChild.OffhandAttackEvent;
import mods.battlegear2.api.core.BattlegearUtils;
import mods.battlegear2.api.core.IBattlePlayer;
import mods.battlegear2.api.core.InventoryPlayerBattle;
import mods.battlegear2.api.heraldry.IFlagHolder;
import mods.battlegear2.api.heraldry.IHeraldryItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BattleClassesCombatHooks {
	
	@SubscribeEvent
	public void onMainhandAttack(AttackEntityEvent event) {
		//Settings Mainhand weapon CD
		BattleClassesWeaponHitHandler weaponHitHandler = BattleClassesUtils.getPlayerWeaponHandler(event.entityPlayer);
		weaponHitHandler.setMainhandToCooldown(event.entityPlayer);
		
		//Reseting hurtResistanceTime for ControlledSpeedWeapons
		ItemStack mainHandItemStack = BattleClassesUtils.getMainhandItemStack(event.entityPlayer);
		if(BattleClassesUtils.isPlayerInBattlemode(event.entityPlayer) && mainHandItemStack != null && mainHandItemStack.getItem() instanceof IControlledSpeedWeapon) {
			event.target.hurtResistantTime = 0;
		}
	}

	@SubscribeEvent
	public void onOffhandAttack(OffhandAttackEvent event) {
		System.out.println("Settings offhandCD");
		BattleClassesUtils.getPlayerWeaponHandler(event.entityPlayer).setOffhandToCooldown(event.entityPlayer);
	}
			
	/**
	 * Helper method to certain events, should be called on attack, on hit recieved.
	 * @param player
	 */
	public static void onPlayerCombatEntered(EntityPlayer player) {
		
	}
		
	/**
	 * Checks the player for temporal effects which prevent him/her from using any kind of <<attack AND ability>>
	 * @param player
	 * @return
	 */
	public static boolean isPlayerCombatDisabled(EntityPlayer player) {
		return false;
	}
	
	/**
	 * Checks the player for temporal effects which prevent him/her from using <<abilitis>> which don't ignore silence
	 * @param player
	 * @return
	 */
	public static boolean isPlayerSilenced(EntityPlayer player) {
		return false;
	}
}