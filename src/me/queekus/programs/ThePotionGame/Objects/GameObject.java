package me.queekus.programs.ThePotionGame.Objects;
import me.queekus.TissueParticle.*;

public class GameObject {
	public static GameObject flyWings = new GameObject(StatType.Health, 10);
	public static GameObject flowers = new GameObject(StatType.Luck, 10);
	public static GameObject heart = new GameObject(StatType.Love, 50);
	public static GameObject money = new GameObject(StatType.Fortune, 10);
	public static GameObject timeWait10 = new GameObject(StatType.Wait, 10);
	public static GameObject temperature100 = new GameObject(StatType.Heat, 100);
	public static GameObject healthPotion = new Potion(StatType.Health, 20, "Health Potion");
	
	public StatType statType;
	public int statValue = 0;
	public GameObject[] stats;
	
	protected GameObject(StatType _statType, int _statValue){
		statType = _statType;
		statValue = _statValue;
	}
	
	protected void setStats(GameObject[] _stats){
		stats = _stats;
	}
}
