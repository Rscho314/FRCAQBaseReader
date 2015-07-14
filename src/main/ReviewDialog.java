package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
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
		setBounds(100, 100, 500, 650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {

	        @Override
	        public void windowClosing(WindowEvent arg0) { 
	            MainWindow.frame.setVisible(true);
	            ReviewDialog.this.dispose();
	        }
		});
		for(int i = 0; i < MainWindow.raaCopy.length; i++){
		    for(int j = 0; j < MainWindow.raaCopy[i].length; j++){
		    	if (MainWindow.raaCopy[i][j] == 0) {
		    		if(!errorIndices.contains(i)){
		    			errorIndices.add(i);
		    		}
				  }
		    }
		}
		
		for (int i=0; i<errorIndices.size(); i++){
			//System.out.println(i + MainWindow.aqaCopy[i] + Arrays.toString(MainWindow.aqaCopy) + errorIndices);
			errorpaths.add(MainWindow.aqaCopy[i]);
		}
		String[][] rq = FindReviewedQuestion();
//		System.out.println(Arrays.toString(errorIndices.toArray()));
//		System.out.println(Arrays.toString(errorpaths.toArray()));
//		System.out.println(Arrays.toString(MainWindow.aqaCopy));
//		System.out.println(Arrays.toString(MainWindow.raaCopy));
//		System.out.println(Arrays.deepToString(MainWindow.gaaCopy));
//		System.out.println(Arrays.deepToString(rq));
		
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		final JLabel lblLegend = new JLabel("<html>You answered:</html>");
		lblLegend.setBorder(new EmptyBorder(10,10,20,0));
		panel.add(lblLegend);
		
		/*final JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
		panel.add(sep);*/
		
		final JLabel lblQuestion = new JLabel("<html>"+rq[0][0]+"</html>");
		lblQuestion.setBorder(new EmptyBorder(0,10,20,0));
		panel.add(lblQuestion);
		
		final JCheckBox chckbxAns = new JCheckBox();
		chckbxAns.setBorder(new EmptyBorder(0,15,10,0));
		if(MainWindow.gaaCopy[0][0]==true){
			chckbxAns.setSelected(true);
		}else{
			chckbxAns.setSelected(false);
		}
		if(MainWindow.gaaCopy[0][0]==Boolean.valueOf(rq[1][0])){
			chckbxAns.setText("<html><font color='green'>"+rq[1][1]+"</font></html>");
		}else{
			chckbxAns.setText("<html><font color='red'>"+rq[1][1]+"</font></html>");
		}
		panel.add(chckbxAns);
		
		final JCheckBox chckbxAns_1 = new JCheckBox();
		chckbxAns_1.setBorder(new EmptyBorder(0,15,10,0));
		if(MainWindow.gaaCopy[0][1]==true){
			chckbxAns_1.setSelected(true);
		}else{
			chckbxAns_1.setSelected(false);
		}
		if(MainWindow.gaaCopy[0][1]==Boolean.valueOf(rq[2][0])){
			chckbxAns_1.setText("<html><font color='green'>"+rq[2][1]+"</font></html>");
		}else{
			chckbxAns_1.setText("<html><font color='red'>"+rq[2][1]+"</font></html>");
		}
		panel.add(chckbxAns_1);
		
		final JCheckBox chckbxAns_2 = new JCheckBox();
		chckbxAns_2.setBorder(new EmptyBorder(0,15,10,0));
		if(MainWindow.gaaCopy[0][2]==true){
			chckbxAns_2.setSelected(true);
		}else{
			chckbxAns_2.setSelected(false);
		}
		if(MainWindow.gaaCopy[0][2]==Boolean.valueOf(rq[3][0])){
			chckbxAns_2.setText("<html><font color='green'>"+rq[3][1]+"</font></html>");
		}else{
			chckbxAns_2.setText("<html><font color='red'>"+rq[3][1]+"</font></html>");
		}
		panel.add(chckbxAns_2);
		
		final JCheckBox chckbxAns_3 = new JCheckBox();
		chckbxAns_3.setBorder(new EmptyBorder(0,15,10,0));
		if(MainWindow.gaaCopy[0][3]==true){
			chckbxAns_3.setSelected(true);
		}else{
			chckbxAns_3.setSelected(false);
		}
		if(MainWindow.gaaCopy[0][3]==Boolean.valueOf(rq[4][0])){
			chckbxAns_3.setText("<html><font color='green'>"+rq[4][1]+"</font></html>");
		}else{
			chckbxAns_3.setText("<html><font color='red'>"+rq[4][1]+"</font></html>");
		}
		panel.add(chckbxAns_3);
		
		final JCheckBox chckbxAns_4 = new JCheckBox();
		chckbxAns_4.setBorder(new EmptyBorder(0,15,20,0));
		if(MainWindow.gaaCopy[0][4]==true){
			chckbxAns_4.setSelected(true);
		}else{
			chckbxAns_4.setSelected(false);
		}
		if(MainWindow.gaaCopy[0][4]==Boolean.valueOf(rq[5][0])){
			chckbxAns_4.setText("<html><font color='green'>"+rq[5][1]+"</font></html>");
		}else{
			chckbxAns_4.setText("<html><font color='red'>"+rq[5][1]+"</font></html>");
		}
		panel.add(chckbxAns_4);
		
		final JLabel lblExplanation = new JLabel("<html>"+rq[6][0]+"</html>");
		lblExplanation.setBorder(new EmptyBorder(0,10,20,0));
		panel.add(lblExplanation);
		
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
						
						if(MainWindow.gaaCopy[reviewed][0]==true){
							chckbxAns.setSelected(true);
						}else{
							chckbxAns.setSelected(false);
						}
						if(MainWindow.gaaCopy[reviewed][0]==Boolean.valueOf(rq[1][0])){
							chckbxAns.setText("<html><font color='green'>"+rq[1][1]+"</font></html>");
						}else{
							chckbxAns.setText("<html><font color='red'>"+rq[1][1]+"</font></html>");
						}
						if(MainWindow.gaaCopy[reviewed][1]==true){
							chckbxAns_1.setSelected(true);
						}else{
							chckbxAns_1.setSelected(false);
						}
						if(MainWindow.gaaCopy[reviewed][1]==Boolean.valueOf(rq[2][0])){
							chckbxAns_1.setText("<html><font color='green'>"+rq[2][1]+"</font></html>");
						}else{
							chckbxAns_1.setText("<html><font color='red'>"+rq[2][1]+"</font></html>");
						}
						if(MainWindow.gaaCopy[reviewed][2]==true){
							chckbxAns_2.setSelected(true);
						}else{
							chckbxAns_2.setSelected(false);
						}
						if(MainWindow.gaaCopy[reviewed][2]==Boolean.valueOf(rq[3][0])){
							chckbxAns_2.setText("<html><font color='green'>"+rq[3][1]+"</font></html>");
						}else{
							chckbxAns_2.setText("<html><font color='red'>"+rq[3][1]+"</font></html>");
						}
						if(MainWindow.gaaCopy[reviewed][3]==true){
							chckbxAns_3.setSelected(true);
						}else{
							chckbxAns_3.setSelected(false);
						}
						if(MainWindow.gaaCopy[reviewed][3]==Boolean.valueOf(rq[4][0])){
							chckbxAns_3.setText("<html><font color='green'>"+rq[4][1]+"</font></html>");
						}else{
							chckbxAns_3.setText("<html><font color='red'>"+rq[4][1]+"</font></html>");
						}
						if(MainWindow.gaaCopy[reviewed][4]==true){
							chckbxAns_4.setSelected(true);
						}else{
							chckbxAns_4.setSelected(false);
						}
						if(MainWindow.gaaCopy[reviewed][4]==Boolean.valueOf(rq[5][0])){
							chckbxAns_4.setText("<html><font color='green'>"+rq[5][1]+"</font></html>");
						}else{
							chckbxAns_4.setText("<html><font color='red'>"+rq[5][1]+"</font></html>");
						}
						lblExplanation.setText("<html>"+rq[6][0]+"</html>");
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
		File f = new File(ReviewDialog.class.getResource("resource"+"/"+errorpaths.get(reviewed)).toURI());
		BufferedReader br = new BufferedReader(new FileReader(f));
		StringBuilder sb = new StringBuilder();
		String[][] sa = new String[7][2];
		try {
			String line = null;
			for(int i=0; i<6; i++){
				try{
					line = br.readLine();
					if(i==0){
						sa[i][0] = line;
						sa[i][1] = null;
					}else{
						sa[i][0] = line.split(",",2)[0];
						sa[i][1] = line.split(",",2)[1];				
					}
				}catch(Exception e){ //since line cannot be read, replaces it by next line
					//System.out.println("Cannot read question!: "+line.length() + "; " + line);
					line = br.readLine();
					sa[i][0] = line.split(",",2)[0];
					sa[i][1] = line.split(",",2)[1];
					//System.out.println(line);
					continue;
				}
			}
			while(line != null){
				line = br.readLine();
				if(line == null){break;}
				sb.append(line);
	            sb.append(System.lineSeparator());
			}
			sa[6][0] = sb.toString();
		
		} finally {
        br.close();
        //System.out.println(Arrays.deepToString(sa));
        //System.out.println(sb.toString());
		}
		return sa;
	}
}
