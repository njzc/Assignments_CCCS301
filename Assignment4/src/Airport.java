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
	JDialog registerDialog;
	
	JFrame frame;
	JPanel panelItinerary = new JPanel(new GridLayout(1, 4));
	
	//JTextField jtfPassengerName = new JTextField();
	JTextField jtfItineraryItem = new JTextField();
	
	final JPanel panel = new JPanel(new GridLayout(1, 4));
	

	JButton jbtEnterItineraryItem = new JButton("Ok");
	JButton jbtCancelEnterItineraryItem = new JButton("Cancel");
	
	public Airport(int numOfPlanes)
	{
		airplanes = new Queue<Airplane>(numOfPlanes);
		
		//initialize airplanes with default size 50;
		for (int i = 0; i < numOfPlanes; i++ )
		{
			airplanes.enqueue(new Airplane(i + 1, 50));
		}
	}
	
	public void menu()
	{
		frame = new JFrame("Airport");
		//frame.pack();
		frame.setSize(600, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		frame.setLocationRelativeTo(null);
		

		registerDialog = new JDialog(frame, Dialog.ModalityType.DOCUMENT_MODAL);
		 
		JButton jbtRegister = new JButton("Register a passenger");
		jbtRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registerPassenger();
			}
		});
		
		JButton jbtItinerary = new JButton("Manage Passenger Itinerary");
		JButton jbtDispatch = new JButton("Dispatch airplane");
		jbtDispatch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispatchAirplane();
				
			}
			
		});
		
		frame.add(jbtRegister);
		frame.add(jbtItinerary);
		frame.add(jbtDispatch);
		
	}
	
	private void registerPassenger()
	{
		
		registerDialog.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		registerDialog.setTitle("Register a Passenger");
		registerDialog.setSize(500, 300);
		
		registerDialog.add(new EnterPassengerPanel(), BorderLayout.CENTER);
		
		registerDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
		registerDialog.setLocationRelativeTo(null);
		registerDialog.setVisible(true); 
	}
	
	private void dispatchAirplane()
	{
		Airplane airplane = airplanes.dequeue();
		String title = "Dispatch Airplane";
		String message = "";
		if ( airplane != null )
		{
			message = "Dispatch airplane " + airplane.getID() + " successfully";
		}
		else
		{
			message = "No airplanes in the airport";
		}
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	

	private class EnterPassengerPanel extends JPanel
	{
		public EnterPassengerPanel()
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
						//disable pnName elements
						jtfPassengerName.setEnabled(false);
						jbtEnterPassengerName.setEnabled(false);						
						passenger = new Passenger(passengerName);

						registerDialog.add(new EnterItineraryPanel(), BorderLayout.SOUTH);
						registerDialog.add(new SetAirplaneSeatPanel(), BorderLayout.SOUTH);
						registerDialog.revalidate();
						registerDialog.repaint();
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
							airplane.setSeat(seatRow, seatColumn);
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
		
		public void setEnable(boolean enabled)
		{
			jbtSet.setEnabled(enabled);
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
	
	private void addItineraryActivity(String activity)
	{

	}
}
