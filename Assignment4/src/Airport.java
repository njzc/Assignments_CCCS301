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

public class Airport {
	
	Queue<Airplane> airplanes;
	
	JFrame frame;
	JPanel panelItinerary = new JPanel(new GridLayout(1, 4));
	
	JTextField jtfPassengerName = new JTextField();
	JTextField jtfItineraryItem = new JTextField();
	
	
	JButton jbtEnterPassengerName = new JButton("Ok");
	JButton jbtEnterItineraryItem = new JButton("Ok");
	JButton jbtCancelEnterItineraryItem = new JButton("Cancel");
	
	public Airport(int numOfPlanes)
	{
		airplanes = new Queue<Airplane>(numOfPlanes);
	}
	
	public void menu()
	{
		frame = new JFrame("Airport");
		//frame.pack();
		frame.setSize(600, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		
		JButton jbtRegister = new JButton("Register a passenger");
		jbtRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registerPassenger();
			}
		});
		
		JButton jbtItinerary = new JButton("Manage Passenger Itinerary");
		JButton jbtDispatch = new JButton("Dispatch airplane");
		
		frame.add(jbtRegister);
		frame.add(jbtItinerary);
		frame.add(jbtDispatch);
		
	}
	
	private void registerPassenger()
	{
		final JPanel panel = new JPanel(new GridLayout(1, 4));
		panel.add(new JLabel("Passenger Name: "));
		panel.add(jtfPassengerName);
		panel.setBorder(new TitledBorder("Enter passenger information"));
		
		jbtEnterPassengerName.addActionListener(new ButtonListener());
		panel.add(jbtEnterPassengerName);
		
		JButton jbtCancelEnterPassengerName = new JButton("Cancel");
		jbtCancelEnterPassengerName.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);				
			}
			
		});
		
		panel.add(jbtCancelEnterPassengerName);
		
		panel.setVisible(true);
		frame.add(panel, BorderLayout.CENTER);
		
		panelItinerary.add(new JLabel("Itinerary item:"));
		panelItinerary.add(jtfItineraryItem);
		panelItinerary.add(jbtEnterItineraryItem);
		panelItinerary.add(jbtCancelEnterItineraryItem);
		
		panelItinerary.setBorder(new TitledBorder(
				"Enter itinerary information"));
		panelItinerary.setVisible(false);
		frame.add(panelItinerary, BorderLayout.SOUTH);
	}
	
	private void dispatchAirplane()
	{
		Airplane airplane = airplanes.dequeue();
		if ( airplane != null )
		{
			
		}
		else
		{
			
		}
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Get values from text fields
			String name = jtfPassengerName.getText().trim();
			if ( !name.isEmpty() )
			{
				Passenger passenger = new Passenger(name);
				Itinerary itinerary = passenger.getItinerary();
				panelItinerary.setVisible(true);
			}
			else
			{
				
			}

		}
	}
	    
	
}
