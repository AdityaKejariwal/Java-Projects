package stopWatch;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class createWatch extends JFrame{

	JFrame f;
	JButton startB, stopB, exit;
	JLabel startL, stopL, elapsedL;
	JTextField startTF, stopTF, elapsedTF;
	long start = 0, end = 0;
	public createWatch() {
		f = new JFrame();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startB = new JButton();
		stopB = new JButton();
		exit = new JButton();
		startL = new JLabel();
		stopL = new JLabel();
		elapsedL = new JLabel();
		startTF = new JTextField(); 
		stopTF = new JTextField(); 
		elapsedTF = new JTextField();
	}
	protected void display() {
		// TODO Auto-generated method stub
		f.getContentPane().setLayout(new GridBagLayout());
		f.setTitle("Time Kharab tha, toh socha rok dun.");
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		
		startB.setText("Start Timing");
		gbc.gridx = 0;
		gbc.gridy = 0;
		f.getContentPane().add(startB, gbc);
		startB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				startTF.setText(Long.toString(getTime()));
				elapsedTF.setText("");
				stopTF.setText("");
			}
		});
		
		stopB.setText("Stop Timing");l
		gbc.gridx = 0;
		gbc.gridy = 1;
		f.getContentPane().add(stopB, gbc);
		stopB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stopTF.setText(Long.toString(setTime()));
				elapsedTF.setText(Double.toString((end - start)/1000.0));
			}
		});
		
		exit.setText("Exit");
		gbc.gridx = 0;
		gbc.gridy = 2;
		f.getContentPane().add(exit, gbc);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					System.exit(0);
			}
		});
		
		startL.setText("Start Time");
		gbc.gridx = 1;
		gbc.gridy = 0;
		f.getContentPane().add(startL, gbc);
		
		stopL.setText("Stop Time");
		gbc.gridx = 1;
		gbc.gridy = 1;
		f.getContentPane().add(stopL, gbc);
		
		elapsedL.setText("Elapsed Time in sec");
		gbc.gridx = 1;
		gbc.gridy = 2;
		f.getContentPane().add(elapsedL, gbc);

		startTF.setText("");
		startTF.setColumns(15);
		gbc.gridx = 2;
		gbc.gridy = 0;
		f.getContentPane().add(startTF, gbc);

		stopTF.setText("");
		stopTF.setColumns(15);
		gbc.gridx = 2;
		gbc.gridy = 1;
		f.getContentPane().add(stopTF, gbc);
		
		elapsedTF.setText("");
		elapsedTF.setColumns(15);
		gbc.gridx = 2;
		gbc.gridy = 2;
		f.getContentPane().add(elapsedTF, gbc);
		
		f.pack();
	}
	private long setTime() {
		// TODO Auto-generated method stub
		end = System.currentTimeMillis();
		return end;
	}
	private long getTime() {
		// TODO Auto-generated method stub
		start = System.currentTimeMillis();
		return start;
	}

}
