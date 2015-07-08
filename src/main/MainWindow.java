package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;


public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	final static int examSize = 5;
	private int questionsDone = 1;
	static String[][] gaa = new String[examSize][5]; //given answers array
	static int[] raa = new int[examSize]; //registered answers array
	static float mark;
	static MainWindow frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 * @throws URISyntaxException 
	 */
	public MainWindow() throws URISyntaxException, Exception {
		
		//Logic
		final Logic L = new Logic();
		
		File f = L.ChooseQuestion();
		String[][] qa = L.ReadQuestion(f); //question parts array
		String[] aa = {qa[1][0], qa[2][0], qa[3][0], qa[4][0], qa[5][0]}; //answers array
		//System.out.println(Arrays.deepToString(aa));
		
		//GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		setLocationRelativeTo(null); //center window on screen
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		final JLabel lblQuestion = new JLabel("<html>"+qa[0][0]+"</html>");
		lblQuestion.setBorder(new EmptyBorder(10,10,20,0));
		panel.add(lblQuestion);
		
		final JCheckBox chckbxAns = new JCheckBox("<html>"+qa[1][1]+"</html>");
		chckbxAns.setBorder(new EmptyBorder(0,15,10,0));
		panel.add(chckbxAns);
		
		final JCheckBox chckbxAns_1 = new JCheckBox("<html>"+qa[2][1]+"</html>");
		chckbxAns_1.setBorder(new EmptyBorder(0,15,10,0));
		panel.add(chckbxAns_1);
		
		final JCheckBox chckbxAns_2 = new JCheckBox("<html>"+qa[3][1]+"</html>");
		chckbxAns_2.setBorder(new EmptyBorder(0,15,10,0));
		panel.add(chckbxAns_2);
		
		final JCheckBox chckbxAns_3 = new JCheckBox("<html>"+qa[4][1]+"</html>");
		chckbxAns_3.setBorder(new EmptyBorder(0,15,10,0));
		panel.add(chckbxAns_3);
		
		final JCheckBox chckbxAns_4 = new JCheckBox("<html>"+qa[5][1]+"</html>");
		chckbxAns_4.setBorder(new EmptyBorder(0,15,10,0));
		panel.add(chckbxAns_4);
		
		final JButton btnValidate = new JButton("validate");
		btnValidate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				File f;
				try {
					if(questionsDone < examSize){
						f = L.ChooseQuestion();
						String[][] qa = L.ReadQuestion(f);
						String[] aa = {qa[1][0], qa[2][0], qa[3][0], qa[4][0], qa[5][0]};
						lblQuestion.setText("<html>"+qa[0][0]+"</html>");
						chckbxAns.setText("<html>"+qa[1][1]+"</html>");
						chckbxAns_1.setText("<html>"+qa[2][1]+"</html>");
						chckbxAns_2.setText("<html>"+qa[3][1]+"</html>");
						chckbxAns_3.setText("<html>"+qa[4][1]+"</html>");
						chckbxAns_4.setText("<html>"+qa[5][1]+"</html>");
						
						if(chckbxAns.isSelected()){gaa[questionsDone][0] = "true";}else{gaa[questionsDone][0] = "false";}
						if(chckbxAns_1.isSelected()){gaa[questionsDone][0] = "true";}else{gaa[questionsDone][1] = "false";}
						if(chckbxAns_2.isSelected()){gaa[questionsDone][0] = "true";}else{gaa[questionsDone][2] = "false";}
						if(chckbxAns_3.isSelected()){gaa[questionsDone][0] = "true";}else{gaa[questionsDone][3] = "false";}
						if(chckbxAns_4.isSelected()){gaa[questionsDone][0] = "true";}else{gaa[questionsDone][4] = "false";}
						
						if(gaa[questionsDone] == aa){raa[questionsDone] = 1;}else{raa[questionsDone] = 0;}
						
						questionsDone = ++questionsDone;
					}else{
						//System.out.println(Arrays.toString(raa));
						for (int i : raa)
						    mark += i;
						mark = mark*100/examSize; // exam mark in percents
						MainWindow.this.setVisible(false); //hide the questions window
						ReviewDialog rd = new ReviewDialog();
						rd.setVisible(true);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
		});
		contentPane.add(btnValidate, BorderLayout.SOUTH);

		this.setTitle("FRCA QBase Reader");
		
	}
}
