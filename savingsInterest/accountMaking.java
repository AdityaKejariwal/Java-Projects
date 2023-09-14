package savingsInterest;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class accountMaking extends JFrame{
	
	JFrame f;
	JButton calc, exit;
	JLabel  mdL, yiL, nomL, fbL;
	JTextField mdTF, yiTF, nomTF, fbTF;
	public accountMaking() {
		f = new JFrame();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calc = new JButton();
		exit = new JButton();
		mdL = new JLabel();
		yiL = new JLabel();
		nomL = new JLabel();
		fbL = new JLabel();
		mdTF = new JTextField(); 
		yiTF = new JTextField(); 
		nomTF = new JTextField();
		fbTF = new JTextField();
	}

	public void display() {
		// TODO Auto-generated method stub
		f.getContentPane().setLayout(new GridBagLayout());
		f.setTitle("Time Kharab tha, toh socha rok dun.");
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		mdL.setText("Monthly Deposit");
		gbc.gridx = 0;
		gbc.gridy = 0;
		f.getContentPane().add(mdL, gbc);

		yiL.setText("Yearly Interest rate");
		gbc.gridx = 0;
		gbc.gridy = 1;
		f.getContentPane().add(yiL, gbc);
		
		nomL.setText("No. of Months");
		gbc.gridx = 0;
		gbc.gridy = 2;
		f.getContentPane().add(nomL, gbc);

		fbL.setText("Final Balance");
		gbc.gridx = 0;
		gbc.gridy = 3;
		f.getContentPane().add(fbL, gbc);
		
		mdTF.setText("");
		mdTF.setColumns(15);
		gbc.gridx = 2;
		gbc.gridy = 0;
		f.getContentPane().add(mdTF, gbc);

		yiTF.setText("");
		yiTF.setColumns(15);
		gbc.gridx = 2;
		gbc.gridy = 1;
		f.getContentPane().add(yiTF, gbc);
		
		nomTF.setText("");
		nomTF.setColumns(15);
		gbc.gridx = 2;
		gbc.gridy = 2;
		f.getContentPane().add(nomTF, gbc);
		
		fbTF.setText("");
		fbTF.setEditable(false);
		fbTF.setColumns(15);
		gbc.gridx = 2;
		gbc.gridy = 3;
		f.getContentPane().add(fbTF, gbc);
		
		calc.setText("Calculate");
		gbc.gridx = 1;
		gbc.gridy = 4;
		f.getContentPane().add(calc, gbc);
		calc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double md = Double.valueOf(mdTF.getText());
				double nom = Double.valueOf(nomTF.getText());
				double mi = Double.valueOf(yiTF.getText())/1200;
				double fb = md*(Math.pow((1 + mi), nom) - 1)/mi;
				fbTF.setText(new DecimalFormat("0.00").format(fb));
				
			}
		});
		
		exit.setText("Exit");
		gbc.gridx = 1;
		gbc.gridy = 5;
		f.getContentPane().add(exit, gbc);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		f.pack();
	}

}
