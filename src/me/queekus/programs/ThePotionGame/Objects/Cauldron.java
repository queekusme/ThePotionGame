package me.queekus.programs.ThePotionGame.Objects;
import me.queekus.TissueParticle.*;
import me.queekus.programs.ThePotionGame.api.*;

public class Cauldron extends StatableItem{

	public CauldronRecipe[] recipeList = new CauldronRecipe[999];
	
	public Cauldron(){}
	
	private int getNextFreeRecipeID(){
	    for (int i = 0; i < 999; i++){
	        if (recipeList[i] == null){
	            return i;
	        }
	    }return -1;
	}
	
	public void addRecipe(CauldronRecipe recipe){
		recipeList[getNextFreeRecipeID()] = recipe;
	}
}
