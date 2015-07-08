package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
		Logic L = new Logic();
		File f = L.ChooseQuestion();
		String[][] qa = L.ReadQuestion(f);
		//System.out.println(Arrays.deepToString(qa));
		
		//GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblQuestion = new JLabel("<html>"+qa[0][0]+"</html>");
		lblQuestion.setBorder(new EmptyBorder(10,10,20,0));
		contentPane.add(lblQuestion, BorderLayout.NORTH);
		
		JButton btnValidate = new JButton("validate");
		contentPane.add(btnValidate, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JCheckBox chckbxAns = new JCheckBox(qa[1][1]);
		chckbxAns.setBorder(new EmptyBorder(0,15,10,0));
		panel.add(chckbxAns);
		
		JCheckBox chckbxAns_1 = new JCheckBox(qa[2][1]);
		chckbxAns_1.setBorder(new EmptyBorder(0,15,10,0));
		panel.add(chckbxAns_1);
		
		JCheckBox chckbxAns_2 = new JCheckBox(qa[3][1]);
		chckbxAns_2.setBorder(new EmptyBorder(0,15,10,0));
		panel.add(chckbxAns_2);
		
		JCheckBox chckbxAns_3 = new JCheckBox(qa[4][1]);
		chckbxAns_3.setBorder(new EmptyBorder(0,15,10,0));
		panel.add(chckbxAns_3);
		
		JCheckBox chckbxAns_4 = new JCheckBox(qa[5][1]);
		chckbxAns_4.setBorder(new EmptyBorder(0,15,10,0));
		panel.add(chckbxAns_4);

		this.setTitle("FRCA QBase Reader");
		
	}
}
