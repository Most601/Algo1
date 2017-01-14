package TheNumbersGame;

public class Node{
	protected int leftIndex;
	protected int rightIndex;
	protected int leftDiff;
	protected int rightDiff;
	protected boolean goLeft;
	protected boolean goRight;
	
	public Node(int leftIndex, int rightIndex){
		this.leftIndex = leftIndex;
		this.rightIndex = rightIndex;
		this.leftDiff = 0;
		this.rightDiff = 0;
		goLeft = false;
		goRight = false;
	}
	
	public String toString(){
		return "index of Node is [" + leftIndex + "," + rightIndex + "]," +
		" leftDiff = " + leftDiff + ", rightDiff = " + rightDiff +
		" goLeft? = " + goLeft + " goRight? = " + goRight;
	}
}