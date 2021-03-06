package mods.battleclasses.client;

import mods.battleclasses.BattleClassesUtils;
import mods.battleclasses.ability.active.BattleClassesAbstractAbilityActive;
import mods.battleclasses.gui.BattleClassesGuiHUDOverlay;
import mods.battlegear2.Battlegear;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;

public class BattleClassesClientTargeting {
	public static EntityLivingBase lastTarget;
	
	public static EntityLivingBase getClientMouseOverTarget(float distance) {
		MovingObjectPosition mop =  Battlegear.proxy.getMouseOver(1, distance);
		if(mop != null && mop.entityHit != null) {
			if(mop.entityHit instanceof EntityLivingBase) {
				return (EntityLivingBase) mop.entityHit;
			}
		}

		return null;
	}
	
	public static EntityLivingBase getFinalTargetOfAbility(BattleClassesAbstractAbilityActive ability) {
		EntityLivingBase target = BattleClassesClientTargeting.getClientMouseOverTarget(ability.range);
		EntityLivingBase finalTarget = ability.getFinalTargetFromRaytracedEntity(target);
		return finalTarget;
	}
	
	public static void generateTargetingInfo() {
		Minecraft mc = Minecraft.getMinecraft();
		
		BattleClassesAbstractAbilityActive chosenAbility = BattleClassesUtils.getPlayerSpellBook(mc.thePlayer).getChosenAbility();
		if(!BattleClassesUtils.getPlayerSpellBook(mc.thePlayer).isCastingInProgress()) {
			BattleClassesClientTargeting.lastTarget = null;
			return;
		}
		
		
		if(chosenAbility != null) {
			//TODO : Range
			float range = 40.0F;
			//chosenAbility.getRange() ...
			String targetInfo = null;
			
			if(chosenAbility.requiresRayTracingForTarget()) {
				EntityLivingBase finalTarget = getFinalTargetOfAbility(chosenAbility);
				if(finalTarget != null) {
					if(BattleClassesUtils.isTargetFriendly(mc.thePlayer, finalTarget)) {
						targetInfo = StatCollector.translateToLocal("bchud.target.healing") + " " + getEntityName( finalTarget );
					}
					else {
						targetInfo = StatCollector.translateToLocal("bchud.target.targeting") + " " +  getEntityName( finalTarget );
					}
				}
				else if (BattleClassesClientTargeting.lastTarget != null) {
					targetInfo = StatCollector.translateToLocal("bchud.target.target_lost");
				}
				
				//Saving latest target
				BattleClassesClientTargeting.lastTarget = finalTarget;
			}
			
			
			if(targetInfo != null) {
				BattleClassesGuiHUDOverlay.displayTargetInfo(targetInfo);			
			}
		}
	}
	
	public static String getEntityName(EntityLivingBase entity) {
		Minecraft mc = Minecraft.getMinecraft();
		if(entity == mc.thePlayer) {
			return StatCollector.translateToLocal("bchud.target.self");
		}
		return entity.getCommandSenderName();
	}
}
