package mods.battleclasses.ability;

import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import mods.battleclasses.BattleClassesUtils;
import mods.battleclasses.BattleClassesUtils.LogType;
import mods.battleclasses.ability.active.BattleClassesAbstractAbilityCooldownHolder;
import mods.battleclasses.core.BattleClassesPlayerHooks;
import mods.battleclasses.core.CooldownClock;
import mods.battleclasses.packet.BattleClassesPacketCooldownSet;
import mods.battlegear2.Battlegear;


public class BattleClassesWeaponSkill extends BattleClassesAbstractAbilityCooldownHolder {

	public BattleClassesWeaponSkill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BattleClassesWeaponSkill(BattleClassesPlayerHooks parPlayerHooks, boolean isMainHand) {
		super();
		this.setPlayerHooks(parPlayerHooks);
		this.mainHand = isMainHand;
	}
	
	public boolean mainHand;


}
