/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 4 
	5.Where you developed your program: Eclipse
*/

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JOptionPane;

public class Airport {
	
	Queue<Airplane> airplanes;
	Passenger passenger;
	JDialog jdlRegister;
	JDialog jdlSearchPassenger;
	
	AddItineraryDialog dlgAddItinerary;
	DeleteItineraryDialog dlgDelItinerary;
	MoveItineraryDialog dlgMoveItinerary;
	
	JFrame frmMain;
	ManageItineraryPanel pnManageItinerary;
	ListItineraryPanel pnListItinerary;
	
	public Airport(int numOfPlanes)
	{
		airplanes = new Queue<Airplane>(numOfPlanes);
		
		//initialize airplanes with size 50;
		for (int i = 0; i < numOfPlanes; i++ )
		{
			airplanes.enqueue(new Airplane(i + 1, 50));
		}
		
//		//TODO: to be deleted
//		passenger = new Passenger("aa");
//		passenger.setPlaneID(1);
//		passenger.setSeatRow(1);
//		passenger.setSeatColumn(1);
//		airplanes.clone().delete(0).setSeat(passenger, 1, 1);
		
	}
	
	public void menu()
	{
		frmMain = new JFrame("Airport");

		frmMain.setSize(560, 500);
		frmMain.setVisible(true);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		frmMain.setLocationRelativeTo(null);
		

		jdlRegister = new JDialog(frmMain, Dialog.ModalityType.DOCUMENT_MODAL);
		jdlRegister.setResizable(false);
		jdlSearchPassenger = new JDialog(frmMain, Dialog.ModalityType.DOCUMENT_MODAL);
		jdlSearchPassenger.setResizable(false);
		
		JButton jbtRegister = new JButton("Register a passenger");
		jbtRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registerPassenger();
			}
		});
		
		JButton jbtItinerary = new JButton("Manage Passenger Itinerary");
		jbtItinerary.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manageItinerary();
			}

		});
		
		JButton jbtDispatch = new JButton("Dispatch airplane");
		jbtDispatch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispatchAirplane();
				
			}
			
		});
		
		frmMain.add(jbtRegister);
		frmMain.add(jbtItinerary);
		frmMain.add(jbtDispatch);
		frmMain.revalidate();
		frmMain.repaint();
	}
	
	private void registerPassenger()
	{
		
		jdlRegister.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		jdlRegister.setTitle("Register a Passenger");
		jdlRegister.setSize(500, 300);
		
		//remove panel before adding
		Component components[] = jdlRegister.getContentPane().getComponents();
		for (int i = 0; i < components.length; i++)
		{
			if (components[i].getClass() == NewPassengerPanel.class 
					|| components[i].getClass() == EnterItineraryPanel.class 
					|| components[i].getClass() == SetAirplaneSeatPanel.class 
					)
			{
				jdlRegister.remove(components[i]);				
			}
		}
		jdlRegister.add(new NewPassengerPanel(), BorderLayout.CENTER);
		
		jdlRegister.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
		jdlRegister.setLocationRelativeTo(null);
		jdlRegister.setVisible(true); 
	}
	

	private void manageItinerary() {
		
		jdlSearchPassenger.setTitle("Manage Passenger Itinerary");
		jdlSearchPassenger.setSize(500,120);
		
		//remove panel before adding
		Component components[] = jdlSearchPassenger.getContentPane().getComponents();
		for (int i = 0; i < components.length; i++)
		{
			if (components[i].getClass() == SearchPassengerPanel.class)
			{
				jdlSearchPassenger.remove(components[i]);				
			}
		}
		
		jdlSearchPassenger.add(new SearchPassengerPanel(), BorderLayout.CENTER);
		jdlSearchPassenger.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
		jdlSearchPassenger.setLocationRelativeTo(null);
		jdlSearchPassenger.setVisible(true);
	}
	
	private void dispatchAirplane()
	{
		Airplane airplane = airplanes.dequeue();
		String message = "";
		if ( airplane != null )
		{
			message = "Dispatch airplane " + airplane.getID() + " successfully";
		}
		else
		{
			message = "No airplanes in the airport";
		}
		showAlert(message);
	}
	

	private class NewPassengerPanel extends JPanel
	{
		public NewPassengerPanel()
		{
			this.add(new JLabel("Enter Passenger Name: "));
			final JTextField jtfPassengerName = new JTextField(16);
			this.add(jtfPassengerName);
			
			final JButton jbtEnterPassengerName = new JButton("Ok");
			jbtEnterPassengerName.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					String passengerName = jtfPassengerName.getText();
					if ( !passengerName.isEmpty() )
					{				
						jtfPassengerName.setEnabled(false);
						jbtEnterPassengerName.setEnabled(false);						
						passenger = new Passenger(passengerName);

						jdlRegister.add(new EnterItineraryPanel(), BorderLayout.SOUTH);
						jdlRegister.add(new SetAirplaneSeatPanel(), BorderLayout.SOUTH);
						jdlRegister.revalidate();
						jdlRegister.repaint();
					}
					else
					{
						showAlert("Passenger name cannot be empty, please re-enter");
					}
				}
			});
			this.add(jbtEnterPassengerName);

			this.setBorder(BorderFactory.createTitledBorder("Passenger Infomation"));
			this.setVisible(true);
		}
	}
	
	private class EnterItineraryPanel extends JPanel
	{
		public EnterItineraryPanel()
		{
			this.add(new JLabel("Enter Itinerary Activity:"));
			final JTextField jtfItineraryItem = new JTextField(15);
			this.add(jtfItineraryItem);
			final JButton jbtEnterItinerary = new JButton("Ok");
			final JLabel jlbItinerary = new JLabel();
			jbtEnterItinerary.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String itineraryActivity = jtfItineraryItem.getText();
					if ( !itineraryActivity.isEmpty())
					{
						if ( passenger != null )
						{
							passenger.getItinerary().add(itineraryActivity);
							showAlert("Add itinerary activity successfully");
							jtfItineraryItem.setText("");
						}
					}
					else
					{
						showAlert("Itinerary activity cannot be empty, please re-enter");
					}
				}
			});
			this.add(jbtEnterItinerary);
			this.setBorder(BorderFactory.createTitledBorder("Set Passenger's Itinerary"));
			this.setVisible(true);
		}
	}
	
	private class SetAirplaneSeatPanel extends JPanel
	{
		final JButton jbtSet = new JButton("OK");
		
		public SetAirplaneSeatPanel()
		{
			this.add(new JLabel("Airplane ID: "));
			final JTextField jtfAirplaneID = new JTextField(4);
			this.add(jtfAirplaneID);

			this.add(new JLabel("Seat Row: "));
			final JTextField jtfSeatRow = new JTextField(4);
			this.add(jtfSeatRow);
			
			this.add(new JLabel("Seat Column: "));
			final JTextField jtfSeatColumn = new JTextField(4);
			this.add(jtfSeatColumn);
						
			jbtSet.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int airplaneID = 0;
					int seatRow = 0;
					int seatColumn = 0;
					try
					{
						airplaneID = Integer.valueOf(jtfAirplaneID.getText());
						seatRow = Integer.valueOf(jtfSeatRow.getText());
						seatColumn = Integer.valueOf(jtfSeatColumn.getText());
						Airplane airplane = getValidAirplane(airplaneID);
						if ( airplane != null)
						{
							airplane.setSeat(passenger, seatRow, seatColumn);
							//check if this seat is valid
							if ( airplane.getSeat(seatRow, seatColumn))
							{
								passenger.setPlaneID(airplaneID);
								passenger.setSeatRow(seatRow);
								passenger.setSeatColumn(seatColumn);
								showAlert("Set airplane and seat successfully");
								jbtSet.setEnabled(false);
							}
							else
							{
								showAlert("Seat is not available, please re-enter");
							}
						}
						else
						{
							showAlert("Airplane is not valid, please re-enter Airplane ID");
						}
					}
					catch (NumberFormatException ex)
					{
						showAlert("Please input integer number");
					}
					
				}
			});
			this.add(jbtSet);
						
			this.setBorder(BorderFactory.createTitledBorder("Set Airplane & Seat"));
			this.setVisible(true);
		}
		
	}
	    

	private class SearchPassengerPanel extends JPanel
	{
		public SearchPassengerPanel()
		{
			
			this.add(new JLabel("Enter Passenger Name: "));
			final JTextField jtfPassengerName = new JTextField(16);
			this.add(jtfPassengerName);
			
			this.add(new JLabel("Airplane ID: "));
			final JTextField jtfAirplaneID = new JTextField(4);
			this.add(jtfAirplaneID);
			
			final JButton jbtSearchPassenger = new JButton("Search");
			jbtSearchPassenger.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					try
					{
						int airplaneID = Integer.valueOf(jtfAirplaneID.getText());
						String passengerName = jtfPassengerName.getText();
						
						if ( !passengerName.isEmpty() )
						{				
							Airplane airplane = getValidAirplane(airplaneID);
							if ( airplane != null )
							{
								passenger = airplane.getPassenger(passengerName);

								if ( passenger != null ) 
								{
									jdlSearchPassenger.setVisible(false);
									pnManageItinerary = new ManageItineraryPanel();
									//jpnManageItinerary.setLayout(new BorderLayout());
									frmMain.add(pnManageItinerary, BorderLayout.SOUTH);
									frmMain.setSize(720,500);
									
									frmMain.revalidate();
									frmMain.repaint();
								}
								else
								{
									showAlert("There is no passenger whose name is " + passengerName + " in airplane " + airplaneID + ", please re-enter");
								}
							}
							else
							{
								showAlert("Airplane doesn't exist, please re-enter");
							}
						}
						else
						{
							showAlert("Passenger name cannot be empty, please re-enter");
						}
					}
					catch (NumberFormatException ex)
					{
						showAlert("Please input integer number for Airplane ID");
					}
					
				}
			});
			this.add(jbtSearchPassenger);

			this.setBorder(BorderFactory.createTitledBorder("Passenger Infomation"));
			this.setVisible(true);
		}
	}
	
	private class ManageItineraryPanel extends JPanel
	{
		public ManageItineraryPanel()
		{
			this.setSize(700,300);
			JButton jbtDisplayItinerary = new JButton("Display itinerary");
			jbtDisplayItinerary.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					pnListItinerary = new ListItineraryPanel(passenger.getItinerary());
					
					//remove panel before adding
					Component components[] = frmMain.getContentPane().getComponents();
					for (int i = 0; i < components.length; i++)
					{
						if (components[i].getClass() == ListItineraryPanel.class )
						{
							frmMain.remove(components[i]);				
						}
					}
					
					frmMain.add(pnListItinerary, BorderLayout.SOUTH);
					frmMain.revalidate();
					frmMain.repaint();
				}
			});
			this.add(jbtDisplayItinerary);
			
			JButton jbtAddItem = new JButton("Add itinerary item");
			jbtAddItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dlgAddItinerary = new AddItineraryDialog(frmMain, Dialog.ModalityType.DOCUMENT_MODAL);
					dlgAddItinerary.setVisible(true);
					
				}
			});
			this.add(jbtAddItem);
						
			JButton jbtDeleteItem = new JButton("Delete an itinerary item");
			jbtDeleteItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dlgDelItinerary = new DeleteItineraryDialog(frmMain, Dialog.ModalityType.DOCUMENT_MODAL);
					dlgDelItinerary.setVisible(true);					
				}
			});
			this.add(jbtDeleteItem);
						
			JButton jbtMoveItem = new JButton("Move an itinerary item");
			jbtMoveItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dlgMoveItinerary = new MoveItineraryDialog(frmMain, Dialog.ModalityType.DOCUMENT_MODAL);
					dlgMoveItinerary.setVisible(true);	
					
				}
			});
			this.add(jbtMoveItem);	
			
			JButton jbtQuit = new JButton("Quit");
			jbtQuit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					pnManageItinerary.setVisible(false);		
				}
			});
			this.add(jbtQuit);
		}
	}
	
	private class AddItineraryDialog extends JDialog
	{
		public AddItineraryDialog(Window window, ModalityType type)
		{
			super(window, type);
			this.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
			this.setTitle("Add Itinerary Item");
			this.setSize(500, 100);
			this.setResizable(false);
			this.setLocationRelativeTo(null);

			this.add(new JLabel("Enter itinerary item: "));
			final JTextField jtfItineraryItem = new JTextField(25);
			this.add(jtfItineraryItem);
			
			JButton jbtAddItem = new JButton("Add");
			jbtAddItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String item = jtfItineraryItem.getText();
					if ( !item.isEmpty() )
					{
						passenger.getItinerary().add(item);
						showAlert("Add itinerary successfully");
						jtfItineraryItem.setText("");
					}
					else
					{
						showAlert("Itinerary item cannot be empty");
					}
				}
			});
			this.add(jbtAddItem);
		}
	}
	
	private class DeleteItineraryDialog extends JDialog
	{
		public DeleteItineraryDialog(Window window, ModalityType type)
		{
			super(window, type);
			this.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
			this.setTitle("Delete Itinerary Item");
			this.setSize(300, 100);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			
			this.add(new JLabel("Enter itinerary index: "));
			final JTextField jtfItineraryIndex = new JTextField(4);
			this.add(jtfItineraryIndex);
			
			JButton jbtDelItem = new JButton("Delete");
			jbtDelItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String index = jtfItineraryIndex.getText();
					if ( isInteger(index) )
					{
						if ( passenger.getItinerary().delete(Integer.valueOf(index) - 1))
						{
							showAlert("Delete itinerary successfully");
							jtfItineraryIndex.setText("");
						}
						else
						{
							showAlert("Index " + index + " doesn't exist, please re-enter");
						}
					}
					else
					{
						showAlert("Itinerary index must be an integer");
					}
				}
			});
			this.add(jbtDelItem);
		}
	}
	
	private class MoveItineraryDialog extends JDialog
	{
		public MoveItineraryDialog(Window window, ModalityType type)
		{
			super(window, type);
			this.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
			this.setTitle("Delete Itinerary Item");
			this.setSize(500, 100);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			
			this.add(new JLabel("Move itinerary from index: "));
			final JTextField jtfItineraryFromIndex = new JTextField(4);
			this.add(jtfItineraryFromIndex);
			
			this.add(new JLabel("to index: "));
			final JTextField jtfItineraryToIndex = new JTextField(4);
			this.add(jtfItineraryToIndex);
			
			JButton jbtDelItem = new JButton("Move");
			jbtDelItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String fromIndex = jtfItineraryFromIndex.getText();
					String toIndex = jtfItineraryToIndex.getText();
					if ( isInteger(fromIndex) && isInteger(toIndex) )
					{
						if ( passenger.getItinerary().move(Integer.valueOf(fromIndex) - 1, Integer.valueOf(toIndex) - 1))
						{
							showAlert("Move itinerary successfully");
							jtfItineraryFromIndex.setText("");
							jtfItineraryToIndex.setText("");
						}
						else
						{
							showAlert("Index " + fromIndex + " doesn't exist, please re-enter");
						}
					}
					else
					{
						showAlert("Itinerary index must be an integer");
					}
				}
			});
			this.add(jbtDelItem);
		}
	}
	
	private class ListItineraryPanel extends JPanel
	{
		public ListItineraryPanel(Itinerary itinerary)
		{
			this.add(new JLabel(itinerary.toString()));
		}
	}
	
	private Airplane getValidAirplane(int airplaneID)
	{
		Queue<Airplane> tempQueue = airplanes.clone();
		
		Airplane airplane = tempQueue.dequeue();
		while ( airplane != null )
		{
			if ( airplane.getID() == airplaneID)
			{
				return airplane;
			}
			airplane = tempQueue.dequeue();
		}
		return null;
	}
	
	private void showAlert(String message)
	{
		JOptionPane.showMessageDialog(null, message, null, JOptionPane.INFORMATION_MESSAGE);
	}
	
	private boolean isInteger(String input)
	{
		try
		{
			Integer.valueOf(input);
			return true;
		}
		catch (NumberFormatException ex)
		{
			return false;
		}
		
	}
}
