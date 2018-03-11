package adhoc;
import java.util.Scanner;

public class LongestPrefixSuffix {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
		int T = sc.nextInt();
		while (T-- > 0) {
			String input = sc.next();
			int[] array = new int[input.length()];
			int j = 0;
			char ch_i, ch_j;
			for (int i = 1; i < input.length(); i++) {
				ch_i = input.charAt(i);
				ch_j = input.charAt(j);
				while (ch_j != ch_i) {
					if (j == 0)
						break;
					j = array[j - 1];
					ch_j = input.charAt(j);
				}
				if (ch_i != ch_j)
					array[i] = 0;
				else {
					array[i] = j + 1;
					j++;
				}
			}
			System.out.println(array[input.length() - 1]);
		}
		
	}
}
