class Tcs {
	static int minimumJumps(int arr[], int h, int l) {
		int net_height = h - l;
		System.out.println(net_height);
		int result = 0;
		for (int i : arr) {
			int net_distance = i - h;
			System.out.println(net_distance);
			if (net_distance <= 0)
				result += 1;
			else {
				int dis = (int)Math.ceil((double)net_distance / net_height);
				System.out.println(dis + "dis");
				result += dis + 1;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int arr[] = {20, 15};
		System.out.println(minimumJumps(arr, 10, 2));
	}
}