package Client.geass.clientController.planController;

import java.io.IOException;

import Client.geass.clientController.PlanClient;

public class GuiDeletePlanController {
	
	private static PlanClient client = PlanClient.getInstance();;
	
	public GuiDeletePlanController(){
		
	}

	public static boolean deletePlan(int planid) throws IOException {
		return client.deletePlan(planid);
	}
	
	

}
