package mods.battleclasses.gui.controlls;

import mods.battleclasses.BattleClassesUtils;
import mods.battleclasses.BattleClassesUtils.LogType;
import mods.battleclasses.client.BattleClassesClientEvents;
import mods.battleclasses.gui.BattleClassesGuiHandler;
import mods.battleclasses.gui.BattleClassesGuiHUDOverlay;
import mods.battleclasses.gui.tab.BattleClassesTabInventory;
import mods.battlegear2.Battlegear;
import mods.battlegear2.client.gui.BattleEquipGUI;
import mods.battlegear2.gui.BattlegearGUIHandeler;
import mods.battlegear2.packet.BattlegearGUIPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C16PacketClientStatus;

public class GuiTabBarButtonVanillaInventory extends BattleClassesGuiTabBarButton {
	
	public GuiTabBarButtonVanillaInventory(int par1, int par2, int par3) {
		super(par1, par2, par3, "inventory");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openGui(Minecraft mc) {
		BattleClassesUtils.Log("GuiTabBarButtonVanillaInventory openGui", LogType.GUI);
		BattleClassesGuiHUDOverlay.previousGui = mc.currentScreen.getClass();
        mc.thePlayer.sendQueue.addToSendQueue(new C0DPacketCloseWindow(mc.thePlayer.openContainer.windowId));
		GuiInventory guiInventory = new GuiInventory(mc.thePlayer);
		mc.displayGuiScreen(guiInventory);
	}

	@Override
	public Class<? extends GuiScreen> getGUIClass() {
		return BattleClassesTabInventory.class;
	}
}
