package me.queekus.programs.ThePotionGame.Objects;

public class Potion extends GameObject{

	public String name;

	public Potion(StatType _statType, int _statValue, String _name){
		super(_statType, _statValue);
		if (_name == null){
			name = "" + _statType;			
		}else{
			name = _name;
		}
	}
}
