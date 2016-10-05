package spring.service.dice.test;

import java.util.Calendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.dice.Dice;
import spring.service.dice.play.MultiPlayer;

/*
 * FileName : DiceMultiPlayerTestApp01.java
 */
public class DiceMultiPlayerTestApp01 {

	///Main Method
	public static void main(String[] args){
	
		//1. ApplicatiContext 이용 Wiring(객체간 연관관계 형성하는 DI  및 instance 생성 작업)
		//===============================================================//
		// 출력결과를 확인하여 ApplicationContext는 인스턴스 생성시 SingleTon으로 생성 확인 //
		//===============================================================//
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("/config/dicemultiplayerservice01.xml");

		//2. Container 로 부터 multiPlayer01  id 를 갖는 instance Dependency Look Up 
		MultiPlayer multiPlayer01 = (MultiPlayer)factory.getBean("multiPlayer01");
		List<Dice> diceList = multiPlayer01.getDiceList();
		System.out.println("\n===== multiPlayer01 ======");
		System.out.println(":: 저장된 인스턴스 갯수 : "+diceList.size()+"EA");
		System.out.println(":: "+diceList);

		
		//3. Container 로 부터 multiPlayer02  id 를 갖는 instance Dependency Look Up 
		MultiPlayer multiPlayer02 = (MultiPlayer)factory.getBean("multiPlayer02");
		Dice[] diceArray = multiPlayer02.getDiceArray();
		System.out.println("\n===== multiPlayer02 ======");
		System.out.println("::저장된 인스턴스 갯수 :  "+diceArray.length+"EA");
		for (Dice dice : diceArray) {
			System.out.println(":: "+dice);
		}
		
		//4. Container 로 부터 multiPlayer03   id 를 갖는 instance Dependency Look Up 
		MultiPlayer multiPlayer03 = (MultiPlayer)factory.getBean("multiPlayer03");
		Calendar currentDate = multiPlayer03.getCurrentDate();
		System.out.println("\n===== multiPlayer03 ======");
		//==> 출력 null 확인 :: 명시적 null injection 
		System.out.println(currentDate);
		System.out.println(multiPlayer03.getDice());
	}
}//end of class