package me.queekus.programs.ThePotionGame.Objects;
import me.queekus.TissueParticle.*;
import me.queekus.programs.ThePotionGame.api.*;

public class Cauldron extends StatableItem{

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
		//Check Items In Potion And Give Result Acording To a) Recipe or b) randomness
		GameObject[] recipeStats = new GameObject[999];
		for(int rz = 0; rz < recipeStats.length; rz++){
			recipeStats[rz] = new GameObject(null, -1);
		}
		int numofrecipes = 0;

		int numofstats = 0;
		int numofcorrect = 0;
		for (CauldronRecipe recipe : recipeList){
			if (recipe != null) {
				numofrecipes++;
			}
		}
		for(int r = 0; r < numofrecipes; r++){
			GameObject[] rep = recipeList[r].recipe;
			for(int x = 0; x < rep.length; x++){
				recipeStats[x] = recipeList[r].recipe[x];
				System.out.println("StatType: " + recipeStats[x].statType);
				System.out.println("StatValue: " + recipeStats[x].statValue);
				System.out.println("AddedItem StatType: " + addedItems[x].statType);
				System.out.println("AddedItem StatValue: " + addedItems[x].statValue);
			}
			for (int z = 0; z < recipeStats.length; z++){
				numofstats++;
				if (recipeStats[z].statType != null){
					if (recipeStats[z].statType == addedItems[z].statType){
						if (recipeStats[z].statValue == addedItems[z].statValue){
							numofcorrect++;
						}
					}else{
						for(int aI = 0; aI < addedItems.length; aI++){
							addedItems[aI] = new GameObject(null, -1);
						}
						break;						
					}
				}else{
					numofstats--;
					for(int aI = 0; aI < addedItems.length; aI++){
						addedItems[aI] = new GameObject(null, -1);
					}
					break;
				}
			}
			return new Potion(recipeList[r].potion.statType, (recipeList[r].potion.statValue * numofcorrect) / numofstats, recipeList[r].potion.name);					
		}
		return new Potion(null, -1, "Flat Potion");
	}
}
