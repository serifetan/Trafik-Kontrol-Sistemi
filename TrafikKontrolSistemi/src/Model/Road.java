package Model;

import java.util.LinkedList;
import java.util.Queue;

public class Road {

	public Queue<Car> cars;
	public int[] XFirst;
	public int[] YFirst;
	public int[] XSecond;
	public int[] YSecond;
	public int[] distance = { 0, 0 };
	public int[] distance1 = { 0, 0 };
	public Road() {
		cars = new LinkedList<Car>();
			XFirst = new int[] { -200, 313, 1107 };
			YFirst = new int[] { 223, 223, 223 };

			XSecond = new int[] { -200, 313, 464, 464 };
			YSecond = new int[] { 292, 292, 292, 706 };
	}
}
