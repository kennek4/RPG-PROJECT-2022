package rpg;

public class Weapon {
	double dmg, acc, critChance;
	String weaponName;
	Weapon(String weaponName, int dmg, double acc, double critChance)
	{
		this.weaponName = weaponName;
		this.dmg = dmg;
		this.acc = acc;	
		this.critChance = critChance;
	}
	public double getAcc()
	{
		return acc;
	}
	public double getDmg()
	{
		return dmg;
	}
	public double getCritChance()
	{
		return critChance;
	}
	public String getWeaponName()
	{
		return weaponName;
	}

	

}
