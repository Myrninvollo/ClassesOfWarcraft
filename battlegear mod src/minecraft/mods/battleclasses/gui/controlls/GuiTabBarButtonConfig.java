package mods.battleclasses.gui.controlls;

import mods.battleclasses.gui.tab.BattleClassesTabConfig;
import mods.battlegear2.client.gui.BattleEquipGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class GuiTabBarButtonConfig extends BattleClassesGuiTabBarButton {

	public GuiTabBarButtonConfig(int par1, int par2, int par3) {
		super(par1, par2, par3, "config");
		// TODO Auto-generated constructor stub
	}

	public GuiTabBarButtonConfig(int par1, int par2, int par3, boolean parHorizontal) {
		super(par1, par2, par3, "config", parHorizontal);
	}

	@Override
	public void openGui(Minecraft mc) {
		BattleClassesTabConfig.open(mc.thePlayer);
	}

	@Override
	public Class<? extends GuiScreen> getGUIClass() {
		return BattleClassesTabConfig.class;
	}
}
