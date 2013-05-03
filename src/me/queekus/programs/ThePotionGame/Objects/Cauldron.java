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
		
		// REWRITE WHOLE OF THIS, IT HAS BECOME SPAGHETTIFIED!!!!!
		int correct;
		int maxnums;
		boolean match = false;
		//check if is a set recipe, match means that it is a set recipe
		for(CauldronRecipe recipes : recipeList){// Foreach recipe
			correct = 0;
			int numofadded = 0;
			if (recipes != null){
				maxnums = recipes.recipe.length;
				for(GameObject added : addedItems){
					if (added.statType != null){
						numofadded++;
					}
				}
				if (numofadded == recipes.recipe.length) { //nullpointer on this line
					for (int r = 0; r < recipes.recipe.length; r++) {// Foreach item in recipe
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
		return null;
		
		// if not then
		// check for certain ingrediant combinations to apply different effect
		//return effects list
		
		
		//Check Items In Potion And Give Result Acording To a) Recipe or b) randomness
		//GameObject[] recipeStats = new GameObject[999];
		//for(int rz = 0; rz < recipeStats.length; rz++){
		//	recipeStats[rz] = new GameObject(null, -1);
		//}
		//int numofrecipes = 0;

		//int numofstats = 0;
		//int numofcorrect = 0;
		//int numofadded = 0;
		//for (CauldronRecipe recipe : recipeList){
		//	if (recipe != null) {
		//		numofrecipes++;
		//	}
		//}
		//for(int r = 0; r < numofrecipes; r++){
		//	GameObject[] rep = recipeList[r].recipe;
		//	for(int x = 0; x < rep.length; x++){
		//		recipeStats[x] = recipeList[r].recipe[x];
		//	}
		//	for(int added = 0; added < addedItems.length; added++){
		//		if (addedItems[added].statType != null){
		//			numofadded++;
		//		}
		//	}
		//	
		//	for (int z = 0; z < recipeStats.length; z++){
		//		numofstats++;
		//		// add something here to check lengths of recipe and added items and if they equal then check items else just skip to working out effects
		//		if (recipeStats[z].statType != null){
		//			if (recipeStats[z].statType == addedItems[z].statType){
		//				if (recipeStats[z].statValue == addedItems[z].statValue){
		//					numofcorrect++;
		//				}				
		//			}
		//		}else{
		//			numofstats--;
		//			break;
		//		}
		//	}
		//	if (numofstats != numofcorrect && (numofstats != 0 || numofcorrect != 0)){
		//		//Do checking here for certain items having certain effects
		//		//e.g. wings and flowers = (both items removed and ) poison-effect (added)
		//		for (GameObject addedItem: addedItems){
	    //			if (addedItem.statType != null){
	    //				System.out.print("Effect:" + addedItem.statValue + " " + addedItem.statType + "\n");
		//			}
	    //			//
	    //		}
		//		recipeList[r].potion.setStats(addedItems);
		//		recipeList[r].potion.name = "Unspecified Potion";
		//	}
		//	//for(int aI = 0; aI < addedItems.length; aI++){
		//	//	addedItems[aI] = new GameObject(null, -1);
		//	//}
		//	return recipeList[r].potion;
		//}
		//for(int aI = 0; aI < addedItems.length; aI++){
		//	addedItems[aI] = new GameObject(null, -1);
		//}
		//return new Potion(null, -1, "Flat Potion");
	}
}
