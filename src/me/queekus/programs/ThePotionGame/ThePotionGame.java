package me.queekus.programs.ThePotionGame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import me.queekus.TissueParticle.*;
import me.queekus.programs.ThePotionGame.Objects.*;
import me.queekus.programs.ThePotionGame.api.*;

public class ThePotionGame{
	public static Version version;	
	public static Cauldron Cauldron = new Cauldron();
	public static PotGameWindow gui;
	public static void main(String[] args){
		
		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new InputStreamReader(new URL("https://raw.github.com/queekusme/ThePotionGame/master/RemoteVersion.txt").openStream()));
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    String line = "";
	    String[] splitLine;
	    try {
			line = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		splitLine = line.split("#");
		
		
		if (splitLine[0].equals("PRE-ALPHA")){
			version = new Version(Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]), DevStates.Pre_Alpha);	
		}else if (splitLine[0].equals("ALPHA")){
			version = new Version(Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]), DevStates.Alpha);
		}else if (splitLine[0].equals("BETA")){
			version = new Version(Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]), DevStates.Beta);
		}else if (splitLine[0].equals("RELEASE")){
			version = new Version(Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]), DevStates.Release);
		}else if (splitLine[0].equals("SNAPSHOT")){
			version = new Version(Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]), DevStates.Snapshot);
		}
		
		gui = new PotGameWindow("The Potion Game " + version.toString(), 500, 300);
			
		// Cauldron Recipes Added Here
		Cauldron.addRecipe(CauldronRecipe.healthPotRecipe);
		Cauldron.addRecipe(CauldronRecipe.PlagueCureRecipe);
		
	}
	
}
