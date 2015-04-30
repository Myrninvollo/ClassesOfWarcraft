package mods.battleclasses.ability.effect;

import mods.battleclasses.ability.active.BattleClassesAbstractAbilityActive;
import mods.battleclasses.enums.EnumBattleClassesAbilityIntent;
import mods.battleclasses.enums.EnumBattleClassesAbilitySchool;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class BattleClassesAbilityEffectPotion extends BattleClassesAbstractAbilityEffect {

	BattleClassesAbilityEffectPotion() {
		super();
	}
	
	BattleClassesAbilityEffectPotion(int potionID, float effectDuration) {
		this();
		this.potionID = potionID;
		this.effectDuration = effectDuration;
	}
	
	protected int potionID;
	protected float effectDuration;
	
	@Override
	protected void performByOwnerOnTarget(EntityLivingBase owner, EntityLivingBase target) {
		target.addPotionEffect(new PotionEffect(potionID, this.durationInTicksForSeconds(), 1, false));
	}
	
	protected int durationInTicksForSeconds() {
		return (int) (this.effectDuration * 20);
	}
	
	public Potion getPotionByStoredID() {
		return Potion.potionTypes[this.potionID];
	}

	@Override
	public EnumBattleClassesAbilityIntent getIntent() {
		return (this.getPotionByStoredID().isBadEffect()) ? 
				EnumBattleClassesAbilityIntent.OFFENSIVE : 
					EnumBattleClassesAbilityIntent.SUPPORTIVE ;
	}
	
}
