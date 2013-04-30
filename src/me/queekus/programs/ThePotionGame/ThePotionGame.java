package me.queekus.programs.ThePotionGame;
import me.queekus.TissueParticle.*;
import me.queekus.programs.ThePotionGame.Objects.*;
import me.queekus.programs.ThePotionGame.api.*;

public class ThePotionGame{

	public static void main(String[] args){
		Version version = new Version(0, 0, 0, 2, DevStates.Pre_Alpha);		
		PotGameWindow gui = new PotGameWindow("Tombs " + version.toString(), 800, 600);
		
		Cauldron Cauldron = new Cauldron();		
		
		// Cauldron Recipes Added Here
		Cauldron.addRecipe(new CauldronRecipe(new GameObject[]{ GameObject.flyWings, GameObject.temperature100, GameObject.flyWings }));
		
	}
	
}
