import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum CaseType {
	H,
	T
}

class Coord {
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int x;
	public int y;
}

class Part {
	public int x1;
	public int x2;
	public int y1;
	public int y2;
}

public class Main {
	

	
	static int nbLine;
	static int nbColumn;
	static int minHPerPart;
	static int maxCasePerPart;
	static CaseType[][] pizza;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader("data/test_round.in"));
		
		String currentLine = reader.readLine();
		Scanner sc = new Scanner(currentLine);
		
		nbLine = sc.nextInt();
		nbColumn = sc.nextInt();
		
		minHPerPart = sc.nextInt();
		maxCasePerPart = sc.nextInt();
		
		pizza = new CaseType[nbLine][];
		
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
		
		Coord c1 = getBestPart(0, 0, 2);
		if(c1 != null)
			System.out.println("x="+c1.x+",y="+c1.y);
		else
			System.out.println("fuck");
		
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

	private static Coord getBestPart(int begX, int begY, int maxDimX, int maxDimY) {
		
		while(true) {
			for(int i=0; i<maxDimX; i++) {
				for(int j=0; j<maxDimY; j++) {
					if(partAccepted(begX, begY, i, j)) {
						return new Coord(begX+i, begY+j);
					}
				}
			}
			
			Coord1 = getBestPart(int begX, int begY, int maxDimX, int maxDimY);
			
		}
	}

	private static boolean partAccepted(int x1, int y1, int x2, int y2) {
		int nbH = 0;
		for(int i=x1; i<x2; i++) {
			for(int j=y1; j<y2; j++) {
				if(pizza[i][j] == CaseType.H) {
					nbH++;
				}
			}
		}
		
		/*
		 * TODO collision
		 */
		
		return nbH >= minHPerPart && Math.abs(x2-x1)*Math.abs(y2-y1) <= maxCasePerPart;
	}

}
