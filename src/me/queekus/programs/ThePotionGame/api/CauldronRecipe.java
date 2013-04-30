package me.queekus.programs.ThePotionGame.api;
import me.queekus.programs.ThePotionGame.Objects.*;

public class CauldronRecipe {
	public GameObject[] recipe = new GameObject[999];
	public Potion potion;
	
	public CauldronRecipe(GameObject[] _recipe){
		recipe = _recipe;
	}
	
	public CauldronRecipe associatePotion(GameObject healthPotion){
		potion = (Potion) healthPotion;
		return this;
	}
}
