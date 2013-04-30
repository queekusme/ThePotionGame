package me.queekus.programs.ThePotionGame.Objects;
import me.queekus.TissueParticle.*;

public class GameObject {
	public static GameObject flyWings = new GameObject(StatType.Health, 10);
	public static GameObject timeWait10 = new GameObject(StatType.Wait, 10);
	public static GameObject temperature100 = new GameObject(StatType.Heat, 100);
	public static GameObject healthPotion = new Potion(StatType.Health, 20);
	
	public StatType statType;
	public int statValue = 0;
	
	protected GameObject(StatType _statType, int _statValue){
		statType = _statType;
		statValue = _statValue;
	}
}
