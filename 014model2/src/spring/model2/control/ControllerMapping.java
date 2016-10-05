package spring.model2.control;

import spring.model2.service.user.view.HomeController;
import spring.model2.service.user.view.LogonActionController;
import spring.model2.service.user.view.LogonController;

public class ControllerMapping {
	
	private static ControllerMapping controllerMapping;
	
	private ControllerMapping(){
		
	}
	
	public static ControllerMapping getInstance(){
		if(controllerMapping == null){
			controllerMapping = new ControllerMapping();
		}
		return controllerMapping;
	}
	
	public Controller getController(String actionPage){
		System.out.println("[ ControllerMapping.getController() Start....]");
		
		Controller controller = null;
		
		if(actionPage.equals("logon")){
			controller = new LogonController();
		}else if(actionPage.equals("logonAction")){
			controller = new LogonActionController();
		}else if(actionPage.equals("home")){
			controller = new HomeController();
		}
		
		System.out.println("[ ControllerMapping.getController() End....]");
		return controller;
	}
}
