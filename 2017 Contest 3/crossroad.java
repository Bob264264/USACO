import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class crossroad{
	public static void main(String[] args) throws FileNotFoundException {
		Scanner reader = new Scanner(new File("crossroad.in"));
		PrintWriter writer = new PrintWriter (new File("crossroad.out"));
		int total = reader.nextInt(); reader.nextLine();
		int[] cows = new int[total];
		int[] roadSide = new int[total];
		int[] cowTracker = new int[total];
		System.out.println(total);
		int index = 0;
		while (reader.hasNext()){
			String line = reader.nextLine();
			cows[index] = Integer.parseInt(line.substring(0, line.indexOf(" ")));
			roadSide[index] = Integer.parseInt(line.substring(line.indexOf(" ")+1));
			index++;
		}
		for (int i = 0; i < cowTracker.length; i++)
			cowTracker[i] = -1;
		
		int count = 0;
		for (int i = 0; i < cowTracker.length; i++){
			if (cowTracker[cows[i]] == -1)
				cowTracker[cows[i]] = roadSide[i];
			else if (cowTracker[cows[i]] != roadSide[i]){
				count += 1;
				cowTracker[cows[i]] = roadSide[i];
			}
		}

		writer.println(count);
		reader.close();
		writer.close();
	}

}