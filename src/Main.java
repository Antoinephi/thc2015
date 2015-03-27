import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	
	enum CaseType {
		H,
		T
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader("data/test_round.in"));
		
		String currentLine = reader.readLine();
		Scanner sc = new Scanner(currentLine);
		
		int nbLine = sc.nextInt();
		int nbColumn = sc.nextInt();
		
		int maxHPerPart = sc.nextInt();
		int maxCasePerPart = sc.nextInt();
		
		CaseType[][] pizza = new CaseType[nbLine][];
		
		for(int i=0; i<nbLine; i++) {
			pizza[i] = new CaseType[nbColumn];
			currentLine = reader.readLine();
			for(int j=0; j<nbColumn; j++) {
				pizza[i][j] = currentLine.charAt(j) == 'H' ? CaseType.H : CaseType.T;
				System.out.println(pizza[i][j]);
			}
		}
		
		
		
		
	}

}
