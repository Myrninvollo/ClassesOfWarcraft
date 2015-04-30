package mods.battleclasses.ability.effect;

import java.util.List;

public interface ICWEffectModifierOwner {
	public List<ICWEffectModifier> getEffectModifiers();
	public void setEffectModifiers(List<ICWEffectModifier> effectModifiers);
}
