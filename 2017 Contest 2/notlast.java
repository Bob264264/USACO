import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class notlast{
	public static void main(String[] args) throws FileNotFoundException {
		Scanner reader = new Scanner(new File("notlast.in"));
		PrintWriter writer = new PrintWriter (new File("notlast.out"));
		int total = reader.nextInt();
		reader.nextLine();
		String[] names = new String[total];
		int[] milk = new int[total];
		int count = 0;
		while (reader.hasNext()){
			String line = reader.nextLine();
			names[count] = line.substring(0, line.indexOf(" "));
			milk[count] = Integer.parseInt(line.substring(line.indexOf(" ")+1));
			count++;
		}
		String[] uniqueNames = {" ", " ", " ", " ", " ", " ", " "};
		int[] totalMilk = new int[7];
		for (int i = 0, k = 0; i < total; i++){
			boolean has = false;
			int found = 0;
			for (int j = 0; j < 7; j++)
				if (uniqueNames[j].equals(names[i])){
					has = true;
					found = j;
				}
			if (!has){
				uniqueNames[k] = names[i];
				totalMilk[k] = milk[i];
				k++;
			}
			else{
				totalMilk[found]+=milk[i];
			}
		}
		int small1 = 10000;
		int small2 = 10000;
		int index1 = 0;
		int index2 = 1;

		for (int i = 0; i < 7; i++){
			if (totalMilk[i] < small1){
				small2 = small1;
				index2 = index1;
				small1 = totalMilk[i];
				index1 = i;
			}
			else if (totalMilk[i] < small2 && totalMilk[i] != small1){
				small2 = totalMilk[i];
				index2 = i;
			}
		}
		count = 0;
		int target = totalMilk[index2];
		for (int i:totalMilk){
			if (i == target)
				count++;
		}
		if (count == 1)
			writer.println(uniqueNames[index2]);
		else
			writer.println("Tie");
		
		reader.close();
		writer.close();
	}

}