import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	
	enum CaseType {
		H,
		T
	}
	
	class Part {
		int x1;
		int x2;
		int y1;
		int y2;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader("data/test_round.in"));
		
		String currentLine = reader.readLine();
		Scanner sc = new Scanner(currentLine);
		
		int nbLine = sc.nextInt();
		int nbColumn = sc.nextInt();
		
		int minHPerPart = sc.nextInt();
		int maxCasePerPart = sc.nextInt();
		
		CaseType[][] pizza = new CaseType[nbLine][];
		
		for(int i=0; i<nbLine; i++) {
			pizza[i] = new CaseType[nbColumn];
			currentLine = reader.readLine();
			for(int j=0; j<nbColumn; j++) {
				pizza[i][j] = currentLine.charAt(j) == 'H' ? CaseType.H : CaseType.T;
			}
		}
		
		List<Part> parts = new ArrayList<Part>();
		
		/*
		 * Algorithm
		 */
		
		/*
		 * Output
		 */
		
		FileWriter write = new FileWriter("data/out");
		
		write.write(parts.size()+"\n");
		for(int i=0; i<parts.size(); i++) {
			write.write(parts.get(i).x1+" "+parts.get(i).y1+" "+parts.get(i).x2+" "+parts.get(i).y2+"\n");
		}
		
		write.close();
		
		
		
		
		
		
	}

}
