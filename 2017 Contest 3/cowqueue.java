import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class cowqueue{
	public static void main(String[] args) throws FileNotFoundException {
		Scanner reader = new Scanner(new File("cowqueue.in"));
		PrintWriter writer = new PrintWriter (new File("cowqueue.out"));
		int total = reader.nextInt(); reader.nextLine();
		int[] times = new int[total];
		int[] lengths = new int[total];
		int[] tracker = new int[total];
		int index = 0;
		while (reader.hasNext()){
			String line = reader.nextLine();
			times[index] = Integer.parseInt(line.substring(0, line.indexOf(" ")));
			lengths[index] = Integer.parseInt(line.substring(line.indexOf(" ")+1));
			index++;
		}
		bubbleSort(times, lengths);

		int time = times[0] + lengths[0];
		for (int i = 1; i < total; i++){
			if (times[i] > time)
				time = times[i];
			time += lengths[i];
		}

		writer.println(time);
		reader.close();
		writer.close();
	}

	public static void bubbleSort(int[] array, int[] array2) {
		boolean swapped = true;
		int j = 0;
		int tmp, tmp2;
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < array.length - j; i++) {
				if (array[i] > array[i + 1]) {
					tmp = array[i];
					tmp2 = array2[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
					array2[i] = array2[i + 1];
					array2[i + 1] = tmp2;
					swapped = true;
				}
			}
		}
	}
}
