package spring.service.dice.test;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.dice.Dice;
import spring.service.dice.play.MultiPlayer;

/*
 * FileName : DiceMultiPlayerTestApp02.java
 */
public class DiceMultiPlayerTestApp02 {
	
	///Main Method
	public static void main(String[] args){
		
		//1. ApplicatiContext 이용 Wiring(객체간 연관관계 형성하는 DI  및 instance 생성 작업) 
		ApplicationContext factory =
								new ClassPathXmlApplicationContext(
															new String[] 	{	
																			"/config/dicemultiplayerservice01.xml",
																			"/config/dicemultiplayerservice02.xml"	
																						}			
																										);

		//2. Container 로 부터 multiPlayer04  id 를 갖는 instance Dependency Look Up
		MultiPlayer multiPlayer04 = (MultiPlayer)factory.getBean("multiPlayer04");
		Set<Dice> diceSet = multiPlayer04.getDiceSet();
		System.out.println("\n===== multiPlayer04 ======");
		System.out.println(":: 저장된 인스턴스 갯수 : "+diceSet.size()+"EA");
		System.out.println(":: "+diceSet);
		
		//3. Container 로 부터 multiPlayer05  id 를 갖는 instance Dependency Look Up
		MultiPlayer multiPlayer05 = (MultiPlayer)factory.getBean("multiPlayer05");
		Map<String, Dice> diceMap = multiPlayer05.getDiceMap();
		System.out.println("\n===== multiPlayer05 ======");
		System.out.println("저장된 인스턴스 갯수 : "+diceMap.size()+"EA");
		System.out.println(":: "+diceMap);
		
		//4. Container 로 부터 multiPlayer06  id 를 갖는 instance Dependency Look Up
		MultiPlayer multiPlayer06 = (MultiPlayer)factory.getBean("multiPlayer06");
		Properties properties = multiPlayer06.getDiceProperties();
		System.out.println("\n===== multiPlayer06 ======");
		System.out.println("저장된 key=value 갯수 : "+properties.size()+"EA");
		System.out.println(":: "+properties);

	}
}//end of class