package mods.battleclasses.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mods.battleclasses.BattleClassesUtils;
import mods.battleclasses.BattleClassesUtils.LogType;
import mods.battleclasses.ability.active.BattleClassesAbilityTestCasted;
import mods.battleclasses.ability.active.BattleClassesAbstractAbilityActive;
import mods.battleclasses.ability.talent.BattleClassesAbstractTalent;
import mods.battleclasses.enums.EnumBattleClassesCooldownType;
import mods.battleclasses.enums.EnumBattleClassesPlayerClass;
import mods.battleclasses.gui.controlls.BattleClassesGuiButtonTalentNode;

public class BattleClassesTalentMatrix {
	
	protected BattleClassesPlayerHooks playerHooks;
	
	public BattleClassesTalentMatrix(BattleClassesPlayerHooks parPlayerHooks) {
		playerHooks = parPlayerHooks;
	}
	
	public List<BattleClassesTalentTree> talentTrees = new ArrayList<BattleClassesTalentTree>();
	public HashMap<String, BattleClassesAbstractTalent> talentHashMap = new HashMap<String, BattleClassesAbstractTalent>();

	public static final int TALENT_POINTS_TO_SPEND = 3;
	protected int talentPoints = TALENT_POINTS_TO_SPEND;
	
	public void initWithTalentTrees(List<BattleClassesTalentTree> parTalentTrees) {
		//Setting reverse references on trees and talentAbilities
		talentTrees = parTalentTrees;
		for(BattleClassesTalentTree talentTree : talentTrees) {
			talentTree.setOwnerTalentMatrix(this);
		}
		
		//Filling up talentHashMap
		talentHashMap.clear();
		for(BattleClassesTalentTree talentTree : this.talentTrees) {
        	for(BattleClassesAbstractTalent talentAbility : talentTree.talentList ) {
        		this.talentHashMap.put(talentAbility.getAbilityID(), talentAbility);
        	}
        }
	}
	
	public static final float TALENT_CHANGE_COOLDOWN_DURATION = 3.0F;
	
	public void onTalentsChanged() {
		this.playerHooks.playerClass.getCooldownClock().startCooldown(TALENT_CHANGE_COOLDOWN_DURATION, false, EnumBattleClassesCooldownType.CooldownType_TALENT_CHANGE);
		this.playerHooks.onAttributeSourcesChanged();
	}
	
	public BattleClassesPlayerHooks getPlayerHooks() {
		return this.playerHooks;
	}
	
	public void setTalentPoints(int n) {
		if(n <= TALENT_POINTS_TO_SPEND) {
			talentPoints = n;
		}
	}
	
	public int getTalentPoints() {
		return talentPoints;
	}
	
	public boolean hasPointsToSpend() {
		return talentPoints > 0;
	}
	
	public boolean hasPointsSpentAlready() {
		return talentPoints < TALENT_POINTS_TO_SPEND;
	}
	
	public void applyPointsOnTrees(int tree0, int tree1, int tree2) {
		this.talentTrees.get(0).spendTalentPoints(tree0);
		this.talentTrees.get(1).spendTalentPoints(tree1);
		this.talentTrees.get(2).spendTalentPoints(tree2);
	}
	
	public void applyPointsOnTrees(int[] pointsOnTrees) {
		for(int i = 0; i < pointsOnTrees.length; ++i) {
			this.talentTrees.get(i).spendTalentPoints(pointsOnTrees[i]);
        }
	}
	
	public int[] getPointsOnTrees() {
		int[] points = new int[this.talentTrees.size()];
		int i = 0;
		for(BattleClassesTalentTree talentTree : this.talentTrees) {
			points[i] = talentTree.getPointsOnTree();
        	++i;
        }
		return points;
	}
	
	public void learnFullTreeAtIndex(int index) {
		BattleClassesUtils.Log("Trying to learn full talent tree at index: " + index, LogType.CORE);
		this.resetTalentPoints();
		BattleClassesTalentTree talentTree = this.talentTrees.get(index);
		for(BattleClassesAbstractTalent talentAbility : talentTree.talentList ) {
    		while(!talentAbility.isAlreadyLearned() && talentPoints != 0) {
    			this.learnTalent(talentAbility);
    		}
    	}
	}
	
	public void resetTalentPoints() {
		for(BattleClassesTalentTree talentTree : this.talentTrees) {
        	for(BattleClassesAbstractTalent talentAbility : talentTree.talentList ) {
        		talentAbility.resetState();
        	}
        }
		talentPoints = TALENT_POINTS_TO_SPEND;
	}
	
	public void learnTalent(BattleClassesAbstractTalent talentAbility) {
		if(talentAbility.isAvailableToLearn()) {
    		talentAbility.incrementState();
    		--talentPoints;
    	}
	}
	
	//Helper
	public BattleClassesTalentTree getTreeAtIndex(int index) {
		if(this.talentTrees.size() > 0 && index < this.talentTrees.size()) {
			return this.talentTrees.get(index);
		}
		return null;
	}
}
