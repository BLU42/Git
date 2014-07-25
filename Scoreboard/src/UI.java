import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.*;

/**
 * UI.java
 * 
 * contains UI and main components for simple scoreboard program
 */

/**
 * @author John Mullen III
 *
 */
public class UI {
	
	private JFrame window;
	
	private JPanel red; //left panel (red scoring)
	private JPanel blue; // right panel (blue scoring)
	private JPanel redButtons;
	private JPanel blueButtons;
	
	private JLabel rScoreText;
	private JLabel bScoreText;
	private JLabel rScoreRead; // left (red) score display
	private JLabel bScoreRead; // right (blue) score display
	private JButton rPlus; // red score increase
	private JButton rMinus; // red score descrease
	private JButton bPlus; // blue score increase
	private JButton bMinus; // blue score decrease
	
	private int rScore = 0;
	private int bScore = 0;
	
	public UI(){
		start();
	}
	
	
	// SETUP FUNCTION
	private void start(){
		
		//WINDOW SETUP
		window = new JFrame("Simple Scoreboard v 1.1");
		rScoreText = new JLabel("Red Score", SwingConstants.CENTER);
		bScoreText = new JLabel("Blue Score", SwingConstants.CENTER);
		rScoreRead = new JLabel(Integer.toString(rScore), SwingConstants.CENTER);
		bScoreRead = new JLabel(Integer.toString(bScore), SwingConstants.CENTER);
		
		Font numberFont = new Font(rScoreRead.getFont().getName(), rScoreRead.getFont().getStyle(), 22);
		rScoreRead.setFont(numberFont);
		bScoreRead.setFont(numberFont);
		
		
		//BUTTON SETUP
		rPlus = new JButton("+1");
		bPlus = new JButton("+1");
		rMinus = new JButton("-1");
		bMinus = new JButton("-1");
		
		ActionListener rPluser = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				rScore += 1;
				rScoreRead.setText(Integer.toString(rScore));
				try {
					write(0);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		rPlus.addActionListener(rPluser);
		
		ActionListener bPluser = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				bScore += 1;
				bScoreRead.setText(Integer.toString(bScore));
				try {
					write(1);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		bPlus.addActionListener(bPluser);
		
		ActionListener rMinuser = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				rScore -= 1;
				rScoreRead.setText(Integer.toString(rScore));
				try {
					write(0);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		rMinus.addActionListener(rMinuser);
		
		ActionListener bMinuser = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				bScore -= 1;
				bScoreRead.setText(Integer.toString(bScore));
				try {
					write(1);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		bMinus.addActionListener(bMinuser);
		
		
		window.setLayout(new BorderLayout());
		
		red = new JPanel();
		red.setLayout(new BorderLayout());
		red.add(rScoreText, BorderLayout.NORTH);
		red.add(rScoreRead, BorderLayout.CENTER);
		redButtons = new JPanel();
		redButtons.setLayout(new FlowLayout());
		redButtons.add(rMinus);
		redButtons.add(rPlus);
		red.add(redButtons, BorderLayout.SOUTH);
		window.add(red, BorderLayout.WEST);
		
		blue = new JPanel();
		blue.setLayout(new BorderLayout());
		blue.add(bScoreText, BorderLayout.NORTH);
		blue.add(bScoreRead, BorderLayout.CENTER);
		blueButtons = new JPanel();
		blueButtons.setLayout(new FlowLayout());
		blueButtons.add(bMinus);
		blueButtons.add(bPlus);
		blue.add(blueButtons, BorderLayout.SOUTH);
		window.add(blue, BorderLayout.EAST);
		
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
	
	private void write(int side) throws FileNotFoundException{
		if(side == 0){
			PrintWriter outRed = new PrintWriter("RedScore.txt");
			outRed.printf("%d", rScore);
			outRed.close();
		}
		else if(side == 1){
			PrintWriter outBlue = new PrintWriter("BlueScore.txt");
			outBlue.printf("%d", bScore);
			outBlue.close();
		}
	}
	
	
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new UI();

	}

}
