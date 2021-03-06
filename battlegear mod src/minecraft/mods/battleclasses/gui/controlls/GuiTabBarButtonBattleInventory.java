package mods.battleclasses.gui.controlls;

import mods.battleclasses.gui.BattleClassesGuiHUDOverlay;
import mods.battleclasses.gui.tab.BattleClassesTabEquipment;
import mods.battlegear2.client.gui.BattleEquipGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiTabBarButtonBattleInventory extends BattleClassesGuiTabBarButton {

	public GuiTabBarButtonBattleInventory(int par1, int par2, int par3) {
		super(par1, par2, par3, "equipment");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openGui(Minecraft mc) {
		BattleClassesTabEquipment.open(mc.thePlayer);
	}

	@Override
	public Class<? extends GuiScreen> getGUIClass() {
		return BattleClassesTabEquipment.class;
	}	
}