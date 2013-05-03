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
		CauldronRecipe matchedrecipe = null;
		
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
						System.out.print("MATCH");
						return recipes.potion;
					}
				}
			}
		}
		
		// if not then
		// check for certain ingrediant combinations to apply different effect
		checkForSpecialCombinations(this.contains(GameObject.flyWings), this.contains(GameObject.flowers), StatType.Fortune, 10);
		
		// return effects list
		Potion newPotion = new Potion(null, 0, "Custom Potion");
		newPotion.setStats(addedItems);
		return newPotion;
	}

	private void checkForSpecialCombinations(int refOne, int refTwo, StatType replacingType, int ReplacingValue) {

		if ( refOne != -1 && refTwo != -1 ){
			addedItems[refOne] = new GameObject( replacingType, ReplacingValue );
			addedItems[refTwo] = null;
		}
	}
	public int contains(Object obj){
		for (int y = 0; y < addedItems.length; y++){
			if (addedItems[y].equals(obj)){
				return y;
			}
		}
		return -1;
	}
}
