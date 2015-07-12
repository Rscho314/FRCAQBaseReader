package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MarkDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean review = false;
	
	public MarkDialog(){
		setBounds(100, 100, 500, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {

	        @Override
	        public void windowClosing(WindowEvent arg0) {
	            if(review == false){ 
	            	MainWindow.frame.setVisible(true);
	            	MarkDialog.this.dispose();
	            }else{
	            	MarkDialog.this.dispose();
	            	ReviewDialog rd;
					try {
						rd = new ReviewDialog();
						rd.setVisible(true);
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	            }
	        }



	    });
		
		final JPanel panel = new JPanel();
		setContentPane(panel);
		//panel.setLayout(new BorderLayout(panel, BorderLayout.CENTER));
		
		JPanel txtPanel = new JPanel();
		txtPanel.setBorder(new EmptyBorder(5, 5, 50, 5));
		txtPanel.setLayout(new BoxLayout(txtPanel, BoxLayout.Y_AXIS));
		panel.add(txtPanel);
		
		JLabel lblAppreciation = new JLabel("", SwingConstants.CENTER);
		if(MainWindow.mark >= 80){
			lblAppreciation.setText("<html>You scored <font color='green' size='6'>"+ MainWindow.mark + "%</font>!</html>");
		}else{
			lblAppreciation.setText("<html>You scored <font color='red' size='6'>"+ MainWindow.mark + "%</font>!</html>");
		}
		txtPanel.add(lblAppreciation);
		
		JLabel lblRename = new JLabel("", SwingConstants.CENTER);
		if(MainWindow.mark >= 80){
			lblRename.setText("<html>You will likely pass a lot of gas until retirement. Isn't that nice?</html>");
		}else{
			lblRename.setText("<html>Flipping burgers is also a very honourable profession, you know?</html>");
		}
		txtPanel.add(lblRename);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 20;
        gbc.ipady = 20;

		panel.add(btnPanel);
		
		JButton btnReview = new JButton("Review wrong answers");
		btnPanel.add(btnReview, gbc);
		gbc.gridy++;
		btnReview.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				review = true;
				MarkDialog.this.dispatchEvent(new WindowEvent(MarkDialog.this, WindowEvent.WINDOW_CLOSING));
			}
			
		});
		
		JButton btnRestart = new JButton("Start a new session");
		btnPanel.add(btnRestart, gbc);
		gbc.gridy++;
		btnRestart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MarkDialog.this.dispatchEvent(new WindowEvent(MarkDialog.this, WindowEvent.WINDOW_CLOSING));
				/*MainWindow.gaa = new String[MainWindow.examSize][5];
				MainWindow.raa = new int[MainWindow.examSize];
				MainWindow.questionsDone = 0;*/
			}
			
		});
		
		JButton btnQuit = new JButton("Quit");
		btnPanel.add(btnQuit, gbc);
		gbc.gridy++;
		btnQuit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
			
		});
	}

}
