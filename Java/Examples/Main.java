import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	public static int applicantId(int id) {

		String app_id = String.valueOf(id);
		int counter = 0;
		result = 0;
		for (int i = 0; i < app_id.length(); i++) {
			int digit = app_id.charAt(i) - '0';
			if (digit % 2 == 0)
				digit++;
			else
				digit--;

			result = result * Math.pow(10, counter++) + digit;

		}
		return result;
	}
	public static void main(String args[] ) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t != 0) {
			String str1 = br.readLine();
			String str2 = str1.replaceAll("[aeiouAEIOU]", "");
			str2 = str2.toLowerCase();
			str2 = str2.replaceAll("([a-zA-Z])", "*$1");
			System.out.println(str2);
		}

		System.out.println(applicantId(245452));
	}
}