package mods.battleclasses.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.battleclasses.BattleClassesMod;
import mods.battleclasses.BattleClassesUtils;
import mods.battleclasses.ability.BattleClassesAbstractAbility;
import mods.battleclasses.ability.active.BattleClassesAbstractAbilityActive;
import mods.battleclasses.enums.EnumBattleClassesPlayerClass;
import mods.battlegear2.api.core.IBattlePlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

public class BattleClassesGuiHelper extends Gui {
	
	public static BattleClassesGuiHelper INSTANCE = new BattleClassesGuiHelper(); 
	public static final RenderItem itemRenderer = new RenderItem();
	public static final int COOLDOWN_FRAMES = 16;
	public static final int COOLDOWN_ICON_SIZE = 32;
	public static IIcon cooldownIcons[];
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public BattleClassesGuiHelper() {
		super();
		this.zLevel = 0;
	}
	
    public static final ResourceLocation resourceLocationHUD = new ResourceLocation("battleclasses", "textures/gui/InterfaceHUD.png");
    
	public static ResourceLocation getAbilityIconResourceLocation(String abilityName) {
		return getResourceLocationOfTexture("textures/spells/icons/", BattleClassesAbstractAbility.UNLOCALIZED_PREFIX_ABILITY + abilityName + ".icon" + ".png");
	}
	
	public static ResourceLocation getResourceLocationOfTexture(String path, String fileName) {
		return new ResourceLocation(BattleClassesMod.MODID, path + fileName );
	}
	
	public static ResourceLocation getCooldownIconResourceLocation(int cooldownFrameIndex) {
		return new ResourceLocation("battleclasses", "textures/sharedicons/cooldown/cooldown_" + cooldownFrameIndex + ".png");
	}
	
	/*
	public static void drawCooldown(int posX, int posY, float f) {
    	if(f > 0) {
    		int frameIndex = BattleClassesGuiHelper.cooldownIcons.length-1;
    		if(f < 1) {
    			frameIndex = (int) (((float) BattleClassesGuiHelper.cooldownIcons.length)*f);
    		}
    	    
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
		    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		    //GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		    GL11.glDisable(GL11.GL_LIGHTING);
		    GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
		    
		    mc.getTextureManager().bindTexture(getCooldownIconResourceLocation(frameIndex));
		    drawTexturedRectFromCustomSource(posX, posY, COOLDOWN_ICON_SIZE, COOLDOWN_ICON_SIZE, 0);
    		
    		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);    		    
	        //GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	        GL11.glDisable(GL11.GL_BLEND);
	        GL11.glPopMatrix();
      	}
	}
	*/
	
    public void drawCooldown(int posX, int posY, float f) {
    	if(f > 0) {
    		int frameIndex = BattleClassesGuiHelper.cooldownIcons.length-1;
    		if(f < 1) {
    			frameIndex = (int) (((float) BattleClassesGuiHelper.cooldownIcons.length)*f);
    		}
    		IIcon cooldownIcon = BattleClassesGuiHelper.cooldownIcons[frameIndex];
    	    
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
		    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		    GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		    GL11.glDisable(GL11.GL_LIGHTING);
		    GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
		    
		    mc.getTextureManager().bindTexture(TextureMap.locationItemsTexture);
    		this.drawTexturedModelRectFromIcon(posX, posY, cooldownIcon, cooldownIcon.getIconWidth(), cooldownIcon.getIconHeight());
    		
    		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);    		    
	        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	        GL11.glDisable(GL11.GL_BLEND);
	        GL11.glPopMatrix();
      	}
	}
	
	public static final int ABILITY_ACTIONBAR_NODE_WIDTH = 20;
    public static final int ABILITY_ACTIONBAR_HEIGHT = 22;
	public void drawActionbarBackgroundCentered(int centerX, int posY, int length) {
    	if(length == 0) {
    		return;
    	}
    	int actionbarHeight = ABILITY_ACTIONBAR_HEIGHT;
    	int actionbarWidth = getActionBarWidth(length);
        
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
	    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	    GL11.glDisable(GL11.GL_LIGHTING);
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    
	    this.mc.renderEngine.bindTexture(resourceLocationHUD);
	    int actionbarPosX = centerX - actionbarWidth/2;
        int actionbarPosY = posY;
        int currentX = actionbarPosX;
	    if(length == 1) {
	    	int drawNodeWith = ABILITY_ACTIONBAR_NODE_WIDTH+2;
	    	int drawNodeHeight = ABILITY_ACTIONBAR_HEIGHT;
	    	this.drawTexturedModalRect(currentX, actionbarPosY, 0, 0, drawNodeWith/2, drawNodeHeight);
            currentX += drawNodeWith/2;
            this.drawTexturedModalRect(currentX, actionbarPosY, 40 + drawNodeWith/2, 0, drawNodeWith/2, drawNodeHeight);
	    }
	    else {
	        for(int i = 0; i < length; ++i) {
	        	int drawNodeWith = ABILITY_ACTIONBAR_NODE_WIDTH;
		    	int drawNodeHeight = ABILITY_ACTIONBAR_HEIGHT;
	        	int u = 21;
	        	int v = 0;
	        	if(i == 0) {
	        		++drawNodeWith;
	        		u = 0;
	            	v = 0;
	        	}
	        	if(i == (length - 1)) {
	        		++drawNodeWith;
	        		u += 20;
	            	v = 0;
	        	}
	            this.drawTexturedModalRect(currentX, actionbarPosY, u, v, drawNodeWith, drawNodeHeight);
	            currentX += drawNodeWith;
	        }
	    }
        
        
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
	}
	
    public void drawAbilityIcon(int x, int y, BattleClassesAbstractAbilityActive ability ) {
    	if(ability != null && ability.getIconResourceLocation() != null) {
    		if(ability.hasItemIcon()) {
    			ItemStack itemStack = ability.getIconItemStack();
    			if(itemStack != null) {
    				
    				GL11.glPushMatrix();
    				itemRenderer.renderItemAndEffectIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, itemStack, x, y);
    				GL11.glPopMatrix();
    		        GL11.glDisable(GL11.GL_ALPHA_TEST);
    		        GL11.glDisable(GL11.GL_LIGHTING);

    				//renderStackAt(x, y, itemStack, 0);
    			}
    		}
    		else {
    			GL11.glPushMatrix();
    			GL11.glEnable(GL11.GL_BLEND);
    		    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    		    GL11.glEnable(GL12.GL_RESCALE_NORMAL);
    		    //GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    		    //GL11.glDisable(GL11.GL_LIGHTING);
    		    
    		    mc.getTextureManager().bindTexture(ability.getIconResourceLocation());
    		    drawTexturedRectFromCustomSource(x, y, 16, 16, this.zLevel);
    		        		    
    	        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
    	        GL11.glDisable(GL11.GL_BLEND);
    	        GL11.glPopMatrix();
    		     
    		}
        	drawCooldown(x, y, BattleClassesUtils.getCooldownPercentage(ability));
    	}
    }
    
    public void drawAbilitySelector(int actionbarPosX, int actionbarPosY) {
    	GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
	    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	    GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	    GL11.glDisable(GL11.GL_LIGHTING);
	    
	    this.mc.renderEngine.bindTexture(resourceLocationHUD);
        boolean hasClass = BattleClassesUtils.getPlayerClassEnum(mc.thePlayer) != EnumBattleClassesPlayerClass.NONE;
        if (hasClass && ((IBattlePlayer) mc.thePlayer).isBattlemode()) {
        	int chosenIndex = BattleClassesUtils.getPlayerSpellBook(mc.thePlayer).getChosenAbilityIndex();
            this.drawTexturedModalRect(actionbarPosX-1 + chosenIndex*20, actionbarPosY-1, 232, 0, 24, 24);
        }
        
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }

	
	public static int getActionBarWidth(int length) {
		return 1 + length*ABILITY_ACTIONBAR_NODE_WIDTH + 1;
	}
	
	/**
	 * Draws textured modal rectangle without any disortion
	 * when binding custom sized image source to the texture manager.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param zLevel
	 */
	public static void drawTexturedRectFromCustomSource(int x, int y, int width, int height, float zLevel)
	{
		 Tessellator tessellator = Tessellator.instance;
		 tessellator.startDrawingQuads();    
		 tessellator.addVertexWithUV(x        , y + height, (double)zLevel, 0.0, 1.0);
		 tessellator.addVertexWithUV(x + width, y + height, (double)zLevel, 1.0, 1.0);
		 tessellator.addVertexWithUV(x + width, y         , (double)zLevel, 1.0, 0.0);
		 tessellator.addVertexWithUV(x        , y         , (double)zLevel, 0.0, 0.0);
		 tessellator.draw();
	}
	
	public static ArrayList<String> createHoveringText() {
		return new ArrayList<String>();
	}
	
	public static List<String> addTitle(List<String> hoveringText, String titleText) {
		addLine(hoveringText, "", EnumChatFormatting.GOLD, false);
		addLine(hoveringText, titleText, EnumChatFormatting.GOLD, false);
		return hoveringText;
	}
	
	public static List<String> addParagraph(List<String> hoveringText, String paragraphText) {
		//addLine(hoveringText, paragraphText, EnumChatFormatting.GRAY, true);
		addLine(hoveringText, paragraphText, EnumChatFormatting.WHITE, true);
		return hoveringText;
	}
	
	protected static List<String> addLine(List<String> hoveringText, String text, EnumChatFormatting format, boolean insertWithAppend) {
		String line = new String(format + text);
		if(insertWithAppend) {
			hoveringText.add(line);
		}
		else {
			hoveringText.add(0, line);
		}
		return hoveringText;
	}
	
	public static List<String> getLimitedWidthHoveringText(List<String> hoveringText, int numberOfMaximalCharactersInLine) {
		List<String> limitedHoveringText = createHoveringText();
		for(String textLine : hoveringText) {
			int formatStringCharacters = 2;
			String formatString = "";
			if(textLine.startsWith("\u00a7")) {
				//System.out.println("Checking formatedLine: " + textLine + " Length:" + textLine.length());
				formatString = textLine.substring(0, formatStringCharacters);
				textLine = textLine.substring(formatStringCharacters);
			}
			if(textLine.length() > numberOfMaximalCharactersInLine) {
				while(textLine.length() > numberOfMaximalCharactersInLine) {
					String[] textLineWords = textLine.split(" ");
					String limitedTextLine = "";
					String remainingTextLine = "";
					boolean breakLine = false; 
					for(int i = 0; i<textLineWords.length; ++i) {
						if(limitedTextLine.length()==0 && textLineWords[i].length() >= numberOfMaximalCharactersInLine) {
							String separator = (limitedTextLine.length() > 0) ? " " : "";
							limitedTextLine += (separator + textLineWords[i]);
						}
						else if(((limitedTextLine.length()+textLineWords[i].length()+1) <= numberOfMaximalCharactersInLine && !breakLine)) {
							String separator = (limitedTextLine.length() > 0) ? " " : "";
							limitedTextLine += (separator + textLineWords[i]);
						}
						else {
							breakLine = true;
							String separator = (remainingTextLine.length() > 0) ? " " : "";
							remainingTextLine += (separator + textLineWords[i]);
						}
					}
					if(limitedTextLine.length()>0) {
						limitedHoveringText.add(new String(formatString) + limitedTextLine);
					}
					if(remainingTextLine.length() > 0) {
						textLine = new String(formatString) + remainingTextLine;
					}
					else {
						textLine = remainingTextLine;
					}
				}
				if(textLine.length() > 0) {
					limitedHoveringText.add(new String(formatString) + textLine);
				}
			}
			else {
				limitedHoveringText.add(formatString + textLine);
			}
		}
		return limitedHoveringText;
	}
}
