package me.queekus.programs.ThePotionGame.Objects;
import me.queekus.TissueParticle.*;

public class GameObject {
	public static GameObject flyWings = (new GameObject()).setStatValue("Health", 10);
	public static GameObject timeWait10 = (new GameObject()).setStatValue("Wait", 10);
	public static GameObject temperature100 = (new GameObject()).setStatValue("Temperature", 100);
	
	protected GameObject(){}
	private static String[] _stats = new String[999];
	private static int[] _Istats = new int[999];

	private int getStatID(String identifyer){
	    int i = 0;
	    while (i < 999){
	        if (_stats[i] == identifyer){
	            return i;
	        }
	        i++;
	    }
	    return -1;
	}
	
	private int getNextFreeID(){
	    int i = 0;
	    while (i < 999){
	        if (_stats[i] == null)
	        {
	            return i;
	        }
	        i++;
	    }
	    return -1;
	}
	
	public GameObject setStatValue(String identifyer, int value){
	    int iValue = getStatID(identifyer);
	    
	    if (iValue == -1){
	        iValue = getNextFreeID();
	    }
	    _stats[iValue] = identifyer;
	    _Istats[iValue] = value;
		return this;
	}
	
	public int getStatValue(String identifyer){
	    int iValue = getStatID(identifyer);
	
	    if (iValue == -1){
	        return -1;
	    }
	    return _Istats[iValue];
	}
}
