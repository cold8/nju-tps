package Client.geass.gui.travellerGUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Client.geass.gui.guiController.guiUserController.ClientUserControllerInterface;
import Client.geass.gui.planGUI.CreatePlanPanel;
import Client.geass.gui.planGUI.DisplayPlanListPanel;
import Client.geass.gui.planGUI.DisplayPlanPanel;
import Client.geass.gui.planGUI.DisplaySearchedPlanListPanel;
import Client.geass.gui.planGUI.DisplaySearchedPlanPanel;
import Client.geass.gui.planGUI.ModifyDayOfPlanPanel;
import Client.geass.gui.planGUI.ModifyPlanPanel;
import Client.geass.gui.planGUI.SetPlanPanel;
import Shared.geass.dataPOJO.Journey;
import Shared.geass.dataPOJO.Plan;

/**
 *
 * @author Kite
 */
public class TravellerFrame extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form TravellerFrame
     */
    public TravellerFrame( ClientUserControllerInterface clientUserController) {
        initComponents();
        initial(clientUserController);
        
    }
    
    
    private void initial(ClientUserControllerInterface clientUserController){
        this.clientUserController = clientUserController;
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        this.setLocation((screenSize.width-this.getWidth())/2, (screenSize.height-this.getHeight())/2);
        this.welcomePanel = new WelcomePanel(this,clientUserController);
        //plan
        //journey
        this.createPlanPanel = new CreatePlanPanel(this,clientUserController.getUserName());
        this.setContentPane(welcomePanel);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
 
    public void backToMain(){
    	this.setContentPane(welcomePanel);
    	this.validate();
    }
    
    public void CreateNewPlan(){
    	this.setContentPane(createPlanPanel);
    	this.validate();
    	
    }
    


    

    private CreatePlanPanel createPlanPanel;
    private WelcomePanel welcomePanel;
    private ClientUserControllerInterface clientUserController;
    
	public void setNewPanel(TravellerFrame parent, Plan plan) {
		JScrollPane jp = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jp.setViewportView(new SetPlanPanel(parent,plan));
		this.setContentPane(jp);
		this.validate();
	}


	public void displayPlan(TravellerFrame parent, Plan plan) {
		JScrollPane jp = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		try {
			jp.setViewportView(new DisplayPlanPanel(parent,plan));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setContentPane(jp);
		this.validate();
	}


	public void displayPlanList(TravellerFrame parent) throws IOException {
		JScrollPane jp = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jp.setViewportView(new DisplayPlanListPanel(parent));
		this.setContentPane(jp);
		this.validate();
	}
	
	public void displaySearchedPlan(TravellerFrame parent, ArrayList<Plan> resultlist, Plan plan) throws IOException{
		JScrollPane jp = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jp.setViewportView(new DisplaySearchedPlanPanel(parent,resultlist,plan));
		this.setContentPane(jp);
		this.validate();
	}
	
	public void displaySearchedPlanList(TravellerFrame parent,ArrayList<Plan> resultlist) {
		JScrollPane jp = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jp.setViewportView(new DisplaySearchedPlanListPanel(parent,resultlist));
		this.setContentPane(jp);
		this.validate();
	}
	
	public void modifyPlan(TravellerFrame parent, Plan plan) throws IOException{
		JScrollPane jp = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jp.setViewportView(new ModifyPlanPanel(parent,plan));
		this.setContentPane(jp);
		this.validate();
	}
	
	public void modifyDayOfPlan(TravellerFrame parent, Plan plan,String datestr){
		JScrollPane jp = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jp.setViewportView(new ModifyDayOfPlanPanel(parent,plan,datestr));
		this.setContentPane(jp);
		this.validate();
	}


	public void modifyPlan(TravellerFrame parent, int planid) throws IOException {
		JScrollPane jp = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jp.setViewportView(new ModifyPlanPanel(parent,planid));
		this.setContentPane(jp);
		this.validate();
		
	}


	public void switchtoManageJourney(Journey journey) {
		// TODO Auto-generated method stub
		
	}
}
