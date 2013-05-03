package me.queekus.programs.ThePotionGame.api;
import me.queekus.programs.ThePotionGame.Objects.*;

public class CauldronRecipe {
	public static CauldronRecipe healthPotRecipe = new CauldronRecipe(new GameObject[]{ GameObject.flyWings, GameObject.flyWings }).associatePotion(GameObject.healthPotion);
			
	public GameObject[] recipe = new GameObject[999];
	public Potion potion;
	
	protected CauldronRecipe(GameObject[] _recipe){
		recipe = _recipe;
	}
	
	protected CauldronRecipe associatePotion(GameObject healthPotion){
		potion = (Potion) healthPotion;
		return this;
	}
}
