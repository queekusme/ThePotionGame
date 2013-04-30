package me.queekus.programs.ThePotionGame;

import java.io.*;
import me.queekus.programs.ThePotionGame.Objects.*;

public class GameLogic {

	public GameLogic(){
		
	}
	
	public void Load(){
		
	}
	public void Update(){
		
	try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    String s = bufferRead.readLine();
		    
		    String[] args = s.split(" ");
		    
		    switch(args[0]){
		    	case "add":
		    		switch(args[1]){
			    	case "wings":
			    		if (ThePotionGame.Cauldron.addToCauldron(GameObject.flyWings)){
			    		}
			    		break;
		    		}
		    		break;
		    	case "bottle":
			    	Potion result = ThePotionGame.Cauldron.bottlePotion();
				    System.out.println(result.statValue);
		    		break;
		    }
		    
		    
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Draw();
	}
	public void Draw(){
		//Do Draw Methods Here
		Update();
	}
	
}
