package mods.battleclasses.ability.passive;

import java.util.ArrayList;
import java.util.List;

import mods.battleclasses.ability.effect.modifier.ICWEffectModifier;
import mods.battleclasses.ability.effect.modifier.ICWEffectModifierOwner;

public class BattleClassesPassiveAbilityEffectModifier extends BattleClassesAbstractAbilityPassive implements ICWEffectModifierOwner  {

	/*
	public BattleClassesPassiveAbilityEffectModifier(int parAbilityID) {
		super(parAbilityID);
	}
	*/
	
	public BattleClassesPassiveAbilityEffectModifier(List<ICWEffectModifier> effectModifiers) {
		super();
		this.setEffectModifiers(effectModifiers);
	}
	
	public BattleClassesPassiveAbilityEffectModifier(ICWEffectModifier effectModifier) {
		super();
		this.setSingleEffectModifier(effectModifier);
	}
	
	List<ICWEffectModifier> effectModifiers;

	@Override
	public List<ICWEffectModifier> getEffectModifiers() {
		return effectModifiers;
	}

	@Override
	public void setEffectModifiers(List<ICWEffectModifier> effectModifiers) {
		this.effectModifiers = effectModifiers;
	}
	
	public void setSingleEffectModifier(ICWEffectModifier effectModifier) {
		this.effectModifiers = new ArrayList<ICWEffectModifier>();
		this.effectModifiers.add(effectModifier);
	}

}
