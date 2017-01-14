package MainAndJUnit;

import TheNumbersGame.TheNumbersGameA;

import TheNumbersGame.TheNumbersGameB;

public class MainTest {

	public static void main(String[] args) {
		int[] arr = {5,6};
		TheNumbersGameA tng1 = new TheNumbersGameA();
		tng1.theGamePart01();
		TheNumbersGameB tng2 = new TheNumbersGameB(arr);
		tng2.buildTree();
		int start = tng2.fillTreeAndGetWinDiff();
		System.out.println(tng2.toString());
		System.out.println("start = " + start);
	}
}
