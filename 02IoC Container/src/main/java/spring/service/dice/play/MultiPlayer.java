package spring.service.dice.play;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import spring.service.dice.Dice;

/*
 *	FileName : Player01.java
 *	�� DiceA �� ������(?, has a :: Association Relationship)�ִ� Player Object 
 *  �� DiceA �� ���, ���� �����ϴ� Method Definition 
 */
public class MultiPlayer {
		
	private Dice dice;
	private List<Dice> diceList;
	private Dice[] diceArray;
	private Set<Dice> diceSet;
	private Map<String,Dice> diceMap;
	private Properties diceProperties;
	private Calendar currentDate = Calendar.getInstance();
	
	
	
	public MultiPlayer() {
		System.out.println("\n::"+getClass().getName()+" ����Ʈ ������...");
	}

	public MultiPlayer(Dice dice) {
		System.out.println("\n::"+getClass().getName()+" Dice�� ���ڷ� �޴� ������...");
		this.dice = dice;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		System.out.println("::"+getClass().getName()+".setDice()...");
		this.dice = dice;
	}

	public List<Dice> getDiceList() {
		return diceList;
	}

	public void setDiceList(List<Dice> diceList) {
		System.out.println("::"+getClass().getName()+".setDiceList()...");
		this.diceList = diceList;
	}

	public Dice[] getDiceArray() {
		return diceArray;
	}

	public void setDiceArray(Dice[] diceArray) {
		System.out.println("::"+getClass().getName()+".setDiceArray()...");
		this.diceArray = diceArray;
	}

	public Set<Dice> getDiceSet() {
		return diceSet;
	}

	public void setDiceSet(Set<Dice> diceSet) {
		System.out.println("::"+getClass().getName()+".setDiceSet()...");
		this.diceSet = diceSet;
	}

	public Map<String, Dice> getDiceMap() {
		return diceMap;
	}

	public void setDiceMap(Map<String, Dice> diceMap) {
		System.out.println("::"+getClass().getName()+".setDiceMap()...");
		this.diceMap = diceMap;
	}

	public Properties getDiceProperties() {
		return diceProperties;
	}

	public void setDiceProperties(Properties diceProperties) {
		System.out.println("::"+getClass().getName()+".setDiceProperties()...");
		this.diceProperties = diceProperties;
	}

	public Calendar getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Calendar currentDate) {
		System.out.println("::"+getClass().getName()+".setCurrentDate()...");
		this.currentDate = currentDate;
	}
	
	
	
	
}