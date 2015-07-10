package mods.battleclasses.enums;

import mods.battleclasses.client.particle.EntityFXCasting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public enum EnumBattleClassesAbilitySchool {
	PHYSICAL_MELEE_RAGE {
		public float getCriticalStrikeChanceBase() {
			return 0.10F;
		}
		
		public float getCriticalStrikeBonus() {
			return 1.5F;
		}
				
		@SideOnly(Side.CLIENT)
		public int getCastBarColoringV() {
			return 64;
		}
	},
	PHYSICAL_MELEE_ENERGY {
		public float getCriticalStrikeChanceBase() {
			return 0.10F;
		}
		
		public float getCriticalStrikeBonus() {
			return 1.5F;
		}
				
		@SideOnly(Side.CLIENT)
		public int getCastBarColoringV() {
			return 80;
		}
	},
	PHYSICAL_RANGED {
		public float getCriticalStrikeChanceBase() {
			return 0.10F;
		}
		
		public float getCriticalStrikeBonus() {
			return 2F;
		}
		
		public boolean hasCastingSound() {
			return true;
		}
		
		@SideOnly(Side.CLIENT)
		public int getCastBarColoringV() {
			return 96;
		}
	},
	
	SPELL_ARCANE {
		public float getCriticalStrikeChanceBase() {
			return 0.10F;
		}
		
		public float getCriticalStrikeBonus() {
			return 1.5F;
		}
		
		public boolean isMagical() {
			return true;
		}
		
		public boolean hasCastingSound() {
			return true;
		}
		
		public boolean hasParticleFX() {
			return true;
		}
		
		public void spawnParticleFXCasting(EntityPlayer entityPlayer) {
			EntityFXCasting.spawnParticleFXCastingArcane(entityPlayer);
		}
		
		public void spawnParticleFXRelease(EntityPlayer entityPlayer) {
			EntityFXCasting.spawnParticleFXReleaseArcane(entityPlayer);
		}
		
		@SideOnly(Side.CLIENT)
		public int getCastBarColoringV() {
			return 144;
		}
	},
	SPELL_FIRE {
		public float getCriticalStrikeChanceBase() {
			return 0.10F;
		}
		
		public float getCriticalStrikeBonus() {
			return 2F;
		}
		
		public boolean isMagical() {
			return true;
		}
		
		public boolean hasCastingSound() {
			return true;
		}
		
		public boolean hasParticleFX() {
			return true;
		}
		
		public void spawnParticleFXCasting(EntityPlayer entityPlayer) {
			EntityFXCasting.spawnParticleFXCastingFire(entityPlayer);
		}
		
		public void spawnParticleFXRelease(EntityPlayer entityPlayer) {
			EntityFXCasting.spawnParticleFXReleaseFire(entityPlayer);
		}
		
		@SideOnly(Side.CLIENT)
		public int getCastBarColoringV() {
			return 112;
		}
	},
	SPELL_FROST {
		public float getCriticalStrikeChanceBase() {
			return 0.10F;
		}
		
		public float getCriticalStrikeBonus() {
			return 25F;
		}
		
		public boolean isMagical() {
			return true;
		}
		
		public boolean hasCastingSound() {
			return true;
		}
		
		public boolean hasParticleFX() {
			return true;
		}
		
		public void spawnParticleFXCasting(EntityPlayer entityPlayer) {
			EntityFXCasting.spawnParticleFXCastingFrost(entityPlayer);
		}
		
		public void spawnParticleFXRelease(EntityPlayer entityPlayer) {
			EntityFXCasting.spawnParticleFXReleaseFrost(entityPlayer);
		}
		
		@SideOnly(Side.CLIENT)
		public int getCastBarColoringV() {
			return 128;
		}
	},
	SPELL_HOLY {
		public float getCriticalStrikeChanceBase() {
			return 0.10F;
		}
		
		public float getCriticalStrikeBonus() {
			return 1.5F;
		}
		
		public boolean isMagical() {
			return true;
		}
		
		public boolean hasCastingSound() {
			return true;
		}
		
		public boolean hasParticleFX() {
			return true;
		}
		
		public void spawnParticleFXCasting(EntityPlayer entityPlayer) {
			EntityFXCasting.spawnParticleFXCastingHoly(entityPlayer);
		}
		
		public void spawnParticleFXRelease(EntityPlayer entityPlayer) {
			EntityFXCasting.spawnParticleFXReleaseHoly(entityPlayer);
		}
		
		@SideOnly(Side.CLIENT)
		public int getCastBarColoringV() {
			return 160;
		}
	},
	SPELL_SHADOW {
		public float getCriticalStrikeChanceBase() {
			return 0.10F;
		}
		
		public float getCriticalStrikeBonus() {
			return 1.5F;
		}
		
		public boolean isMagical() {
			return true;
		}
		
		public boolean hasCastingSound() {
			return true;
		}
		
		public boolean hasParticleFX() {
			return true;
		}
		
		public void spawnParticleFXCasting(EntityPlayer entityPlayer) {
			EntityFXCasting.spawnParticleFXCastingShadow(entityPlayer);
		}
		
		public void spawnParticleFXRelease(EntityPlayer entityPlayer) {
			EntityFXCasting.spawnParticleFXReleaseShadow(entityPlayer);
		}
		
		@SideOnly(Side.CLIENT)
		public int getCastBarColoringV() {
			return 176;
		}
	},
	UNKNOWN;
	
	public float getCriticalStrikeChanceBase() {
		return 0.10F;
	}
	
	public float getCriticalStrikeBonus() {
		return 1.5F;
	}
	
	public boolean isMagical() {
    	return false;
    }
	
	public boolean hasCastingSound() {
		return false;
	}
	
	public boolean hasParticleFX() {
		return false;
	}
	
	public void spawnParticleFXCasting(EntityPlayer entityPlayer) {
		//Stub
	}
	
	public void spawnParticleFXRelease(EntityPlayer entityPlayer) {
		//Stub
	}
	
    @SideOnly(Side.CLIENT)
	public int getCastBarColoringV() {
    	return 48;
    }
        
    public String getTranslatedDisplayedName() {
    	String unlocaizedName = new String("abilityschool." + this.toString().toLowerCase() + ".name");
    	String displayedName = StatCollector.translateToLocal(unlocaizedName);
    	return displayedName;
    }

}



