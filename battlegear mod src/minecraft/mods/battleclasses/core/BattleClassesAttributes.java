package mods.battleclasses.core;

import mods.battleclasses.enumhelper.EnumBattleClassesAttributeType;

public class BattleClassesAttributes {

	//Primary attributes (in points)
	public float stamina = 0;
	public float strength = 0;
	public float agility = 0;
	public float spellpower_arcane = 0;
	public float spellpower_fire = 0;
	public float spellpower_frost = 0;
	public float spellpower_holy = 0;
	public float spellpower_shadow = 0;
	
	//Secondary attributes (in percentage)
	public float haste = 0;
	public float crit = 0;
	public float armor_pen = 0;
	public float weapon_damage = 0;
		
	public BattleClassesAttributes() {
		
	}
	
	public BattleClassesAttributes(int value) {
		//Primary attributes (in points)
		this.stamina = value;
		this.strength = value;
		this.agility = value;
		this.spellpower_arcane = value;
		this.spellpower_fire = value;
		this.spellpower_frost = value;
		this.spellpower_holy = value;
		this.spellpower_shadow = value;
		//Secondary attributes (in percentage)
		this.haste = value;
		this.crit = value;
		this.armor_pen = value;
		this.weapon_damage = value;
	}
	
	public BattleClassesAttributes add(BattleClassesAttributes attributes) {
		//Primary attributes (in points)
		this.stamina += attributes.stamina;
		this.strength += attributes.strength;
		this.agility += attributes.agility;
		this.spellpower_arcane += attributes.spellpower_arcane;
		this.spellpower_fire += attributes.spellpower_fire;
		this.spellpower_frost += attributes.spellpower_frost;
		this.spellpower_holy += attributes.spellpower_holy;
		this.spellpower_shadow += attributes.spellpower_shadow;
		//Secondary attributes (in percentage)
		this.haste += attributes.haste;
		this.crit += attributes.crit;
		this.armor_pen += attributes.armor_pen;
		this.weapon_damage += attributes.weapon_damage;
		return this;
	}
	
	public BattleClassesAttributes multiply(BattleClassesAttributes attributes) {
		//Primary attributes (in points)
		this.stamina *= attributes.stamina;
		this.strength *= attributes.strength;
		this.agility *= attributes.agility;
		this.spellpower_arcane *= attributes.spellpower_arcane;
		this.spellpower_fire *= attributes.spellpower_fire;
		this.spellpower_frost *= attributes.spellpower_frost;
		this.spellpower_holy *= attributes.spellpower_holy;
		this.spellpower_shadow *= attributes.spellpower_shadow;
		//Secondary attributes (in percentage)
		this.haste *= attributes.haste;
		this.crit *= attributes.crit;
		this.armor_pen *= attributes.armor_pen;
		this.weapon_damage *= attributes.weapon_damage;
		return this;
	}
	
	public float getByType(EnumBattleClassesAttributeType attributeType) {
		switch (attributeType) {
		case AGILITY:{
			return this.agility;
		}
		case ARMOR_PENETRATION:{
			return this.armor_pen;
		}
		case CRITICAL_RATING:{
			return this.crit;
		}
		case HASTE_RATING:{
			return this.haste;
		}
		case SPELLPOWER_ARCANE:{
			return this.spellpower_arcane;
		}
		case SPELLPOWER_FIRE:{
			return this.spellpower_fire;
		}
		case SPELLPOWER_FROST:{
			return this.spellpower_frost;
		}
		case SPELLPOWER_HOLY:{
			return this.spellpower_holy;
		}
		case SPELLPOWER_SHADOW:{
			return this.spellpower_shadow;
		}
		case STAMINA: {
			return this.stamina;
		}
		case STRENGTH: {
			return this.strength;
		}
		case WEAPON_DAMAGE: {
			return this.weapon_damage;
		}
		default:
			break;		
		}
		return 0;
	}
	
	public void setByType(EnumBattleClassesAttributeType attributeType, float value) {
		switch(attributeType) {
		case AGILITY: {
			this.agility = value;
		}
			break;
		case ARMOR_PENETRATION: {
			this.armor_pen = value;
		}
			break;
		case CRITICAL_RATING: {
			this.crit = value;
		}
			break;
		case HASTE_RATING: {
			this.haste = value;
		}
			break;
		case SPELLPOWER_ARCANE: {
			this.spellpower_arcane = value;
		}
			break;
		case SPELLPOWER_FIRE: {
			this.spellpower_fire = value;
		}
			break;
		case SPELLPOWER_FROST: {
			this.spellpower_frost = value;
		}
			break;
		case SPELLPOWER_HOLY: {
			this.spellpower_holy = value;
		}
			break;
		case SPELLPOWER_SHADOW: {
			this.spellpower_shadow = value;
		}
			break;
		case STAMINA: {
			this.stamina = value;
		}
			break;
		case STRENGTH: {
			this.strength = value;
		}
			break;
		case WEAPON_DAMAGE: {
			this.weapon_damage = value;
		}
			break;
		default:
			break;
		
		}
	}
}
