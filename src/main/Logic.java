package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Logic {
	static String[] Fl;
	List<Integer> chosenList = new ArrayList<Integer>();

	/**Generates a list of all question files.
	 * @throws URISyntaxException
	 */
	public Logic() throws URISyntaxException{
		//String path = Logic.class.getResource("\\resource\\").getPath();
		Fl = new File(Logic.class.getResource("\\resource\\").toURI()).list();
	}
	
	public File ChooseQuestion() throws URISyntaxException{
		Random random = new Random();
		int index = random.nextInt(Fl.length);
		if(!chosenList.contains(index)){
			chosenList.add(index);
		}else{
			ChooseQuestion();
		}
		MainWindow.aqa[MainWindow.questionsDone] = Fl[index];
		return new File(Logic.class.getResource("\\resource\\"+"/"+Fl[index]).toURI());
	}
	
	public static String[][] ReadQuestion(File f) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(f));
		String[][] sa = new String[6][2];
		String line = null;
			for(int i=0; i<6; i++){
				try{
					line = br.readLine();
					if(line==null){						
						throw new Exception();//handles empty lines before or inside question
					}else if(i==0){
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
		br.close();
		return sa;
	}
}
