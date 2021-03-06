package search;

public class BinarySearch {
	//Invariant: a != null 
	//			&& for i in range(1, a.length) a[i - 1] >= a[i]
	//			&& array == const
	//			&& x == const

	static int binarySearch(int[] a, int x) {
		int l = -1, r = a.length;

		//Cycle invariant: r - l > 1
		//				&& -1 <= l < a.length
		//				&& -1 < r <= a.length

		//Pre: l == -1 
		//	&& r == a.length
		while (r - l > 1) {

			//Pre: l == const, r == const
			int m = (l + r) / 2;
			//Post: m == (l + r) / 2
			//		&& 0 <= m <= a.length - 1

			//Pre: m == (l + r) / 2
			//		&& 0 <= m <= a.length - 1
			if (a[m] > x) {

				//Pre: a[m] > x
				l = m;
				//Post: l' == m

			}	
			//Post: l' == m == (l + r) / 2
			//		&& r' = r

			//Pre: m == (l + r) / 2
			//		&& 0 <= m <= a.length - 1
			else {

				//Pre: a[m] <= x
				r = m;
				//Post: r' == m
			}	
			//Post: r' == m == (l + r) / 2
			//		&& l' == l
		}
		//Post: r - l <= 1
		//		&& (r = min(1..a.length - 1) : a[r] <= x 
		//			|| such index does not exist)

		//Pre: r - l <= 1
		//		&& (r = min(1..a.length - 1) : a[r] <= x 
		//			|| such index does not exist)
		return r;
		//Post: -
	}

	//Recursion invariant: r - l > 1
	//					&& -1 <= l < a.length
	//					&& -1 < r <= a.length
	static int recursiveBinarySearch(int[] a, int x, int l, int r) {
		//Pre: -
		if (r - l <= 1) {
			//Pre: r - l <= 1
			//		&& (r = min(1..a.length - 1) : a[r] <= x 
			//			|| such index does not exist)
			return r;
			//Post: -
		}
		//Post: -

		//Pre: l == const, r == const
		int m = (l + r) / 2;
		//Post: m == (l + r) / 2
		//		&& 0 <= m <= a.length - 1

		//Pre: m == (l + r) / 2
		//		&& 0 <= m <= a.length - 1
		if (a[m] > x) {
			
			//Pre: a[m] > x
			return recursiveBinarySearch(a, x, m, r);
			//Post: (R = min(1..a.length - 1) : a[R] <= x 
			//			|| such index does not exist)
		
		}
		//Post: (R = min(1..a.length - 1) : a[R] <= x 
		//			|| such index does not exist)
		//Pre: m == (l + r) / 2
		//		&& 0 <= m <= a.length - 1 
		else {
			
			//Pre: a[m] <= x
			return recursiveBinarySearch(a, x, l, m);
			//Post: (R = min(1..a.length - 1) : a[R] <= x 
			//			|| such index does not exist)

		}
		//Post: (R = min(1..a.length - 1) : a[R] <= x 
		//			|| such index does not exist)
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Error: not enough arguments. Usage: java BinarySearch <x> <array[0]> <array[1]> ... <array[n]");
			return;
		}

		try {
			int x = Integer.parseInt(args[0]);
			int[] a = new int[args.length - 1];
			for (int i = 1; i < args.length; i++) {
				a[i - 1] = Integer.parseInt(args[i]);
			}
	
			System.out.println(binarySearch(a, x));
			//System.out.println(recursiveBinarySearch(a, x, -1, a.length));
		}
		catch (NumberFormatException ex) {
			System.out.println("Error: invalid input data");
		}
	}

}