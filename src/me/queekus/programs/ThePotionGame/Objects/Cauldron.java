package me.queekus.programs.ThePotionGame.Objects;
import me.queekus.TissueParticle.*;
import me.queekus.programs.ThePotionGame.api.*;

public class Cauldron extends StatableItem{

	public CauldronRecipe[] recipeList = new CauldronRecipe[999];
	public GameObject[] addedItems = new GameObject[999];
	public Cauldron(){}
	
	private int getNextFreeRecipeID(){
	    for (int i = 0; i < 999; i++){
	        if (recipeList[i] == null){
	            return i;
	        }
	    }return -1;
	}
	private int getNextFreeCreationID(){
	    for (int i = 0; i < 999; i++){
	        if (addedItems[i] == null){
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
		for(int r = 0; r < recipeList.length; r++){
			GameObject[] rep = recipeList[r].recipe;
			for(int x = 0; x < rep.length; x++){
				//System.out.print(r + "-");
				//System.out.print(x + "-");
				recipeStats[x] = recipeList[r].recipe[x];
			}
			if (recipeStats == addedItems){
				
				return recipeList[r].potion;
			}
			return new Potion(null, -1);
		}
		
		return null;
		
	}
}
