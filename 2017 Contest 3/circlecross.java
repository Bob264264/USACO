import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class circlecross{
	public static void main(String[] args) throws FileNotFoundException {
		Scanner reader = new Scanner(new File("circlecross.in"));
		PrintWriter writer = new PrintWriter (new File("circlecross.out"));
		String text = reader.nextLine();
		text = text.substring(0, text.length());
		int[] seen = new int[26];
		int count = 0;
		for (int i = 0; i < text.length(); i++){
			char c1 = text.charAt(i);
			int c2 = text.substring(i+1).indexOf(c1) + 1;
			System.out.println("i: " + i + " c1: " + c1 + " c2: " + c2);
			count += checkBetween(text, i, i + c2, seen);
			if (c2 > 0)
				i += c2;
		}
		System.out.println(count);
		writer.println(count);

		reader.close();
		writer.close();
	}

	public static int checkBetween(String s, int start, int end, int[] seen){
		int count = 0;
		for (int i = start + 1; i < end; i++){
			if (seen[s.charAt(i) - 'A'] == 0){
				System.out.print(s.charAt(i) + " ");
				seen[s.charAt(i) - 'A'] = 1;
				int x = s.substring(i + 1, end).indexOf(s.charAt(i));
				System.out.print(x + " ");
				if (x == -1){
					System.out.print("count: " + count);
					count++;
					System.out.println(" count: " + count);
				}
				else{
					System.out.println(s.charAt(i + x));
					count+=checkBetween(s, i, x, seen);
				}
			}
		}
		return count;
	}
}
