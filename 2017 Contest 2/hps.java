import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class hps{
	public static void main(String[] args) throws FileNotFoundException {
		Scanner reader = new Scanner(new File("hps.in"));
		PrintWriter writer = new PrintWriter (new File("hps.out"));
		int total = reader.nextInt();
		int[] row1 = new int[total];
		int[] row2 = new int[total];
		int count = 0;
		while (reader.hasNext()){	
			row1[count]=reader.nextInt();
			row2[count]=reader.nextInt();
			count++;
		}
		int game1 = 0;
		int game2 = 0;
		for (int i = 0; i < total; i++){
			if ((row1[i] + 1) % 3 == (row2[i] % 3))
				game1 += 1;
			if ((row1[i] + 2) % 3 == (row2[i] % 3))
				game2 += 1;
		}
		if (game1 > game2)
			writer.println(game1);
		else
			writer.println(game2);

		reader.close();
		writer.close();
	}

}