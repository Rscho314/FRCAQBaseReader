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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		this.setTitle("FRCA QBase Reader");
		String path = MainWindow.class.getResource("\\resource\\").getPath();
		System.out.println(path);
		String[] Fl = new File(MainWindow.class.getResource("\\resource\\").toURI()).list();
		System.out.println(Arrays.toString(Fl));
		//System.out.println(MainWindow.class.getResource("\\resource\\"+"/"+Fl[1]).getPath());
		Random random = new Random();
		int index = random.nextInt(Fl.length);
		File f = new File(MainWindow.class.getResource("\\resource\\"+"/"+Fl[index]).toURI());
		//System.out.println(f.exists());
	    /*
		BufferedReader br = new BufferedReader(new FileReader(f));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        String everything = sb.toString();
	        System.out.println(everything);
	    } finally {
	        br.close();
	    }
	    */
		BufferedReader br = new BufferedReader(new FileReader(f));
		String[][] sa = new String[6][2];
		try {
			String line;
			for(int i=0; i<6; i++){
				line = br.readLine();
				if(line==null){
					
				}else if(i==0){
					sa[i][0] = line;
					sa[i][1] = null;
				}else{
					sa[i][0] = line.split(",")[0];
					sa[i][1] = line.split(",")[1];				
				} 
			}
		
		} finally {
        br.close();
        System.out.println(Arrays.deepToString(sa));
		}
		
	}
}
