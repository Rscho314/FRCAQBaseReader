package main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JDialog;

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
		for (int i = 0; i < MainWindow.raa.length; i++) {
			  if (MainWindow.raa[i] == 0) {
			    errorIndices.add(i);
			  }
		}
		
		for (int i=0; i<errorIndices.size(); i++){
			errorpaths.add(MainWindow.aqa[i]);
		}
		String[][] rq = FindReviewedQuestion();
		System.out.println(Arrays.toString(errorIndices.toArray()));
		System.out.println(Arrays.toString(errorpaths.toArray()));
		System.out.println(Arrays.toString(MainWindow.aqa));
		System.out.println(Arrays.toString(MainWindow.raa));
		System.out.println(Arrays.deepToString(MainWindow.gaa));
		System.out.println(Arrays.deepToString(rq));
	}
	
	private String[][] FindReviewedQuestion() throws URISyntaxException, IOException{
		System.out.println(ReviewDialog.class.getResource("\\resource\\"+"/"+errorpaths.get(reviewed)).toURI());
		File f = new File(ReviewDialog.class.getResource("\\resource\\"+"/"+errorpaths.get(reviewed)).toURI());
		reviewed = ++reviewed;
		return Logic.ReadQuestion(f);
	}
}
