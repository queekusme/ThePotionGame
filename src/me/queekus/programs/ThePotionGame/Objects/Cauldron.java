package me.queekus.programs.ThePotionGame.Objects;
import me.queekus.programs.ThePotionGame.*;
import me.queekus.programs.ThePotionGame.api.*;

public class Cauldron {

	public CauldronRecipe[] recipeList = new CauldronRecipe[999];
	public GameObject[] addedItems = new GameObject[999];
	public Cauldron(){
		for(int aI = 0; aI < addedItems.length; aI++){
			addedItems[aI] = new GameObject(null, -1);
		}
	}
	
	private int getNextFreeRecipeID(){
	    for (int i = 0; i < 999; i++){
	        if (recipeList[i] == null){
	            return i;
	        }
	    }return -1;
	}
	private int getNextFreeCreationID(){
	    for (int i = 0; i < 999; i++){
	        if (addedItems[i].statType == null){
	            return i;
	        }
	    }return -1;
	}
	
	public void addRecipe(CauldronRecipe recipe){
		recipeList[getNextFreeRecipeID()] = recipe;
	}
	
	public boolean addToCauldron(GameObject item){
		addedItems[getNextFreeCreationID()] = item;
		return true;
	}
	public Potion bottlePotion(){
		int correct;
		int maxnums;
		boolean match = false;
		//check if is a set recipe, match means that it is a set recipe
		for(CauldronRecipe recipes : recipeList){
			correct = 0;
			int numofadded = 0;
			if (recipes != null){
				maxnums = recipes.recipe.length;
				for(GameObject added : addedItems){
					if (added.statType != null){
						numofadded++;
					}
				}
				if (numofadded == recipes.recipe.length) { 
					for (int r = 0; r < recipes.recipe.length; r++) {
						GameObject Ingredient = recipes.recipe[r];
						if (Ingredient.statType == addedItems[r].statType
								&& Ingredient.statValue == addedItems[r].statValue) {
							correct++;
						}
						if (correct == maxnums) {
							match = true;
						}
					}
					if (match == true) {
						return recipes.potion;
					}
				}
			}
		}
		
		// if not then
		// check for certain ingrediant combinations to apply different effect
		checkForSpecialCombinations(this.contains(GameObject.flyWings), this.contains(GameObject.flowers), GameObject.money);
		checkForSpecialCombinations(this.contains(GameObject.money), this.contains(GameObject.flowers), GameObject.heart);
		
		//Combine all like effects
		int Health = 0;
		int Luck = 0;
		int Fortune = 0;
		int Love = 0;
		int Heat = 0;
		int Wait = 0;
		for (GameObject effect : addedItems){
			if (effect != null){
				if (effect.statType != null){
					switch(effect.statType){
						case Health:
							Health += effect.statValue;
							break;
						case Luck:
							Luck += effect.statValue;
							break;
						case Fortune:
							Fortune += effect.statValue;
							break;
						case Love:
							Love += effect.statValue;
							break;
						case Heat:
							Heat += effect.statValue;
							break;
						case Wait:
							Wait += effect.statValue;
							break;	
					}
				}
			}
		}
		GameObject[] outputItems = new GameObject[6];
		if (Health > 0){
			outputItems[0] = new GameObject(StatType.Health, Health);
		}
		if (Luck > 0){
			outputItems[1] = new GameObject(StatType.Luck, Luck);	
		}
		if (Fortune > 0){
			outputItems[2] = new GameObject(StatType.Fortune, Fortune);
		}
		if (Love > 0){
			outputItems[3] = new GameObject(StatType.Love, Love);
		}
		if (Heat > 0){
			outputItems[4] = new GameObject(StatType.Heat, Heat);
		}
		if (Wait > 0){
			outputItems[5] = new GameObject(StatType.Wait, Wait);	
		}
		
		// return effects list
		Potion newPotion = new Potion(null, 0, "Custom Potion");
		newPotion.setStats(outputItems);
		return newPotion;
	}

	private void checkForSpecialCombinations(int refOne, int refTwo, GameObject replacing) {

		if ( refOne != -1 && refTwo != -1 ){
			addedItems[refOne] = replacing;
			addedItems[refTwo] = null;
		}
	}
	public int contains(Object obj){
		for (int y = 0; y < addedItems.length; y++){
			if (addedItems[y] != null){
				if (addedItems[y].equals(obj)){
					return y;
				}
			}
		}
		return -1;
	}
}
