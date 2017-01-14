package TheNumbersGame;

public class TheNumbersGameB {
	
	private int[] arr;
	private static final int finalSize = 10;
	private static final int minNumber = 10;
	private static final int maxNumber = 99;
	
	private Node[] nodes;
	// מערך בתוספת איבר 0
	private int[] prices;
	
	public TheNumbersGameB() {
		arr = new int[finalSize];
		for (int i=0; i<finalSize; i++) {
			arr[i] = (int) (Math.random() * (maxNumber - minNumber)) + minNumber;
		}
		initPrices();
	}
	
	public TheNumbersGameB(int[] arr) {
		this.arr = new int[arr.length];
		for (int i = 0; i < this.arr.length; i++) {
			this.arr[i] = arr[i];
		}
		initPrices();
	}
	
	private int parent(int i){
		return i/2;
	}
	
	private int leftChild(int i) {
		return 2*i;
	}
	private int rightChild(int i) {
		return 2*i+1;
	}
	
	public String toString() {
		String str = "";
		if (nodes != null) {
			for (int i=1; i<nodes.length; i++) {
				str += nodes[i] + "\n";
			}
		}
		return str;
	}
	
	private void initPrices() {
		// לא קיים שימוש באיבר הראשון במערך החדש
		prices = new int[arr.length+1];
		for (int i=1; i<prices.length; i++) {
			prices[i] = arr[i-1];
		}
	}	
	
	public void buildTree() {
		int n = arr.length;
		int len = (int)Math.pow(2,n); // כולל האיבר הראשון שאינ ובשימוש
		nodes = new Node[len];
		nodes[1] = new Node(1,n); // האיבר הראשון - אפשר לבחור את 2 הקצוות של המערך
		for (int i=1; i<nodes.length/2; i++){
			// אם בחרנו במספר השמאלי - הבנים יהיו - ימין ושמאל בתוספת 1, וכן להפך
			nodes[leftChild(i)] = new Node(nodes[i].leftIndex+1,nodes[i].rightIndex);
			nodes[rightChild(i)] = new Node(nodes[i].leftIndex,nodes[i].rightIndex-1);
		}
		
		// הכנסת ערכים שליליים לעלים
		for (int i=nodes.length/2; i<nodes.length; i++){
			nodes[i].leftDiff = -prices[nodes[i].leftIndex];
			nodes[i].rightDiff = -prices[nodes[i].rightIndex];
		}
	}
	
	public int fillTreeAndGetWinDiff() {
		int level = (nodes.length / 2) / 2;
		int factor = 1;
		int winDiff = 0;
		int tempLeftDiff = 0;
		int tempRightDiff = 0;
		int maxLeft = 0;
		int maxRight = 0;
		
		for (int i = nodes.length-1; i > 1; i = i-2){
			
			// i מציאת ההורה של 
			int par = parent(i);
			
			// מציאת ה'דיף' - עבור הרגל השמאלית
			tempLeftDiff = nodes[i].leftDiff + factor * prices[nodes[par].rightIndex];
			tempRightDiff = nodes[i].rightDiff + factor * prices[nodes[par].rightIndex];
			maxLeft = Math.max(tempLeftDiff, tempRightDiff);
			if (factor > 0) maxLeft = Math.min(tempLeftDiff, tempRightDiff);
			nodes[par].leftDiff = maxLeft;
			
			// כנ"ל עבור הרגל הימנית
			tempLeftDiff = nodes[i-1].leftDiff + factor * prices[nodes[par].leftIndex];
			tempRightDiff = nodes[i-1].rightDiff + factor * prices[nodes[par].leftIndex];
			maxRight = Math.max(tempLeftDiff, tempRightDiff);
			if (factor > 0) maxRight = Math.min(tempLeftDiff, tempRightDiff);
			nodes[par].rightDiff = maxRight;
			
			// מציאת הרגל העדיפה
			if (factor < 0){
				if (maxLeft >= maxRight) nodes[par].goLeft = true;
				else nodes[par].goRight = true;
			}
			else{
				if (maxLeft >= maxRight) nodes[par].goRight = true;
				else nodes[par].goLeft = true;
			}
			// אם האינדקס של האב שווה ל"שלב" - אנחנו הגענו לשלב חדש בעץ
			if (par == level){
				level = level/2;
				factor = -factor;
			}
		}
		// האיבר הגדול מייצג את גודל ההפרש בנצחון שבין הרגליים של האיבר הראשון
		winDiff = Math.max(maxLeft, maxRight); 
		return winDiff;
	}
}
