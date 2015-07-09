package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ReviewDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Integer> errorIndices = new ArrayList<Integer>();
	List<String> errorpaths = new ArrayList<String>();
	int reviewed = 0;
	
	public ReviewDialog() throws URISyntaxException, IOException{
		setBounds(100, 100, 500, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {

	        @Override
	        public void windowClosing(WindowEvent arg0) { 
	            MainWindow.frame.setVisible(true);
	            ReviewDialog.this.dispose();
	        }
		});
		for (int i = 0; i < MainWindow.raaCopy.length; i++) {
			  if (MainWindow.raaCopy[i] == 0) {
			    errorIndices.add(i);
			  }
		}
		
		for (int i=0; i<errorIndices.size(); i++){
			errorpaths.add(MainWindow.aqaCopy[i]);
		}
		String[][] rq = FindReviewedQuestion();
		/*System.out.println(Arrays.toString(errorIndices.toArray()));
		System.out.println(Arrays.toString(errorpaths.toArray()));
		System.out.println(Arrays.toString(MainWindow.aqa));
		System.out.println(Arrays.toString(MainWindow.raaCopy));
		System.out.println(Arrays.deepToString(MainWindow.gaaCopy));
		System.out.println(Arrays.deepToString(rq));*/
		
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		final JLabel lblQuestion = new JLabel("<html>"+rq[0][0]+"</html>");
		lblQuestion.setBorder(new EmptyBorder(10,10,20,0));
		panel.add(lblQuestion);
		
		final JCheckBox chckbxAns = new JCheckBox("<html>"+rq[1][1]+"</html>");
		chckbxAns.setBorder(new EmptyBorder(0,15,10,0));
		panel.add(chckbxAns);
		
		final JCheckBox chckbxAns_1 = new JCheckBox("<html>"+rq[2][1]+"</html>");
		chckbxAns_1.setBorder(new EmptyBorder(0,15,10,0));
		panel.add(chckbxAns_1);
		
		final JCheckBox chckbxAns_2 = new JCheckBox("<html>"+rq[3][1]+"</html>");
		chckbxAns_2.setBorder(new EmptyBorder(0,15,10,0));
		panel.add(chckbxAns_2);
		
		final JCheckBox chckbxAns_3 = new JCheckBox("<html>"+rq[4][1]+"</html>");
		chckbxAns_3.setBorder(new EmptyBorder(0,15,10,0));
		panel.add(chckbxAns_3);
		
		final JCheckBox chckbxAns_4 = new JCheckBox("<html>"+rq[5][1]+"</html>");
		chckbxAns_4.setBorder(new EmptyBorder(0,15,10,0));
		panel.add(chckbxAns_4);
		
		final JButton btnValidate = new JButton("next");
		btnValidate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					reviewed = ++reviewed;
					if(reviewed < errorpaths.size()){
						if(reviewed == errorpaths.size()-1){
							btnValidate.setText("start new session");
						}
						String[][] rq = FindReviewedQuestion();
						lblQuestion.setText("<html>"+rq[0][0]+"</html>");
						chckbxAns.setText("<html>"+rq[1][1]+"</html>");
						chckbxAns_1.setText("<html>"+rq[2][1]+"</html>");
						chckbxAns_2.setText("<html>"+rq[3][1]+"</html>");
						chckbxAns_3.setText("<html>"+rq[4][1]+"</html>");
						chckbxAns_4.setText("<html>"+rq[5][1]+"</html>");
					}else{
						ReviewDialog.this.dispatchEvent(new WindowEvent(ReviewDialog.this, WindowEvent.WINDOW_CLOSING));
						/*MainWindow.gaa = new String[MainWindow.examSize][5];
						MainWindow.raa = new int[MainWindow.examSize];
						MainWindow.questionsDone = 0;*/
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnValidate, BorderLayout.SOUTH);
	}
	
	private String[][] FindReviewedQuestion() throws URISyntaxException, IOException{
//		System.out.println(ReviewDialog.class.getResource("\\resource\\"+"/"+errorpaths.get(reviewed)).toURI());
		File f = new File(ReviewDialog.class.getResource("\\resource\\"+"/"+errorpaths.get(reviewed)).toURI());
		return Logic.ReadQuestion(f);
	}
}
