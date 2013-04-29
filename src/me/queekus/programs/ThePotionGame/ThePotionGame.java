package me.queekus.programs.ThePotionGame;
import me.queekus.TissueParticle.*;
import me.queekus.programs.ThePotionGame.Objects.*;
import me.queekus.programs.ThePotionGame.api.*;

public class ThePotionGame{

	public static void main(String[] args){
		Version version = new Version(0, 0, 0, 1, DevStates.Pre_Alpha);		
		PotGameWindow gui = new PotGameWindow("Tombs " + version.toString(), 800, 600);
		
		Cauldron Cauldron = new Cauldron();
		
		// Potion Item Declaration Here
		GameObject flyWings = new GameObject();
			flyWings.setStatValue("Health", 10);
		GameObject timeWait10 = new GameObject();
			timeWait10.setStatValue("Wait", 10);
		
		// Cauldron Recipes Added Here
		Cauldron.addRecipe(new CauldronRecipe(new GameObject[]{ flyWings, timeWait10, flyWings }));
		
	}
	
}
