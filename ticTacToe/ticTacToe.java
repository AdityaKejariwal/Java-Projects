package ticTacToe;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class ticTacToe implements ActionListener{

	Random random;
	JFrame frame;
	JPanel title_panel, button_panel;
	JLabel textField;
	JButton[] buttons;
	boolean player1Turn;
	public ticTacToe() {
		random = new Random();
		frame = new JFrame();
		title_panel = new JPanel();
		button_panel = new JPanel();
		textField = new JLabel();
		buttons = new JButton[9];
		
		start();
	}
	
	private void start() {
		// TODO Auto-generated method stub
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(25, 255, 0));
		textField.setFont(new Font("Ink Free", Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic-Tac-Toe");
		textField.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,600,100);
		
		button_panel.setLayout(new GridLayout(3, 3));
		button_panel.setBackground(new Color(150,150,150));
		
		setButtons();
		
		title_panel.add(textField);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
	}

	private void setButtons() {
		// TODO Auto-generated method stub
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("Times New Roman", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < buttons.length; i++) {
			if(e.getSource() == buttons[i]) {
				if(player1Turn) {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(255, 0, 0));
						buttons[i].setText("X");
						player1Turn = false;
						textField.setText("O Turn");
						checkWinner();
					}
				}
				else {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0, 0, 255));
						buttons[i].setText("O");
						player1Turn = true;
						textField.setText("X Turn");
						checkWinner();
					}
				}
			}
		}
		
	}
	
	public void firstTurn() {
		
		try {
			Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		 if(random.nextInt(2) == 0) {
			 player1Turn = true;
			 textField.setText("X Turn");
		 }
		 else {
			 player1Turn = false;
			 textField.setText("O Turn");
		 }
	}
	
	public void checkWinner() {
		//Checking the 2 diagonals
		String rd = "", ld = "";
		for (int i = 0, j = 2; i < buttons.length/3; i++, j--) {
			rd += buttons[i * 3 + j].getText();
			ld += buttons[i * 3 + i].getText();
		}
		if(rd.equals("XXX"))
			winner(2,4,6,'X');
		else if(ld.equals("XXX"))
			winner(0,4,8,'X');
		else if(rd.equals("OOO"))
			winner(2,4,6,'O');
		else if(rd.equals("OOO"))
			winner(0,4,8,'O');

		//Checking rows
		int i = 0;
		String row = "";
		while(i < 3) {
			row = "";
			for(int j = 0;j < 3;j++) {
				row +=buttons[i * 3 + j].getText();
			}
			if(row.equals("XXX"))
				winner(i*3,i*3+1,i*3+2,'X');
			else if(row.equals("OOO"))
				winner(i*3,i*3+1,i*3+2,'O');
			i++;
		}
		
		//Checking columns
		int j = 0;
		String col = "";
		while(j < 3) {
			col = "";
			for(i = 0;i < 3;i++) {
				col +=buttons[i * 3 + j].getText();
			}
			if(col.equals("XXX"))
				winner(0 * 3 + j,1 * 3 + j,2 * 3 + j,'X');
			else if(col.equals("OOO"))
				winner(0 * 3 + j,1 * 3 + j,2 * 3 + j,'O');
			j++;
		}
	}
	
	public void winner(int a, int b, int c, char p) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for (int i = 0; i < buttons.length; i++) 
			buttons[i].setEnabled(false);
		textField.setText(p + " WINS!!!");
		//System.exit(0);
	}
}
