package mods.battleclasses.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import mods.battleclasses.client.BattleClassesClientEvents;
import mods.battleclasses.client.BattleClassesClientProxy;
import mods.battleclasses.gui.tab.BattleClassesContainerEmpty;
import mods.battleclasses.gui.tab.BattleClassesTabClassSelector;
import mods.battleclasses.gui.tab.BattleClassesTabConfig;
import mods.battleclasses.gui.tab.BattleClassesTabEquipment;
import mods.battleclasses.gui.tab.BattleClassesTabHelp;
import mods.battleclasses.gui.tab.BattleClassesTabTalents;
import mods.battlegear2.Battlegear;
import mods.battlegear2.client.gui.BattleEquipGUI;
import mods.battlegear2.client.gui.BattlegearSigilGUI;
import mods.battlegear2.client.gui.GuiFlagDesigner;
import mods.battlegear2.gui.BattlegearGUIHandeler;
import mods.battlegear2.gui.ContainerBattle;
import mods.battlegear2.gui.ContainerHeraldry;

public class BattleClassesGuiHandler implements IGuiHandler {

	public static final int vanillaInventoryID = 0;
    public static final int equipID = 1;
    public static final int talentsID = 2;
    public static final int classSelectorID = 3;
    public static final int helpID = 4;
    public static final int configID = 5;
    
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
                                      int x, int y, int z) {
        switch (ID) {
        	case vanillaInventoryID:
        		//BattleClassesClientEvents.returnToInventory(player);
            case equipID:
                return new ContainerBattle(player.inventory, !world.isRemote, player);
            case talentsID:
                return new BattleClassesContainerEmpty(player.inventory, !world.isRemote, player);
            case classSelectorID:
                return new BattleClassesContainerEmpty(player.inventory, !world.isRemote, player);
            case helpID:
                return new BattleClassesContainerEmpty(player.inventory, !world.isRemote, player);
            case configID:
                return new BattleClassesContainerEmpty(player.inventory, !world.isRemote, player);
            default:
                return null;
        }

    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
                                      int x, int y, int z) {
        switch (ID) {
        	case vanillaInventoryID:
        		//
            case equipID:
                return new BattleClassesTabEquipment(player, world.isRemote);
            case talentsID:
                return new BattleClassesTabTalents(player, world.isRemote);
            case classSelectorID:
                return new BattleClassesTabClassSelector(player, world.isRemote);
            case helpID:
                return new BattleClassesTabHelp(player, world.isRemote);
            case configID:
                return new BattleClassesTabConfig(player, world.isRemote);
            default:
                return null;
        }
    }
    
    public static void setInventoryContainer(EntityPlayer player) {
    	//player.closeScreen();
    	player.openContainer = player.inventoryContainer;
    }


}

