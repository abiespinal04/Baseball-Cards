import java.util.ArrayList;

public class SortingByNum {

	private int num;
	private BaseballPlayers player;
	
	public SortingByNum() {
		this.num = 0;
		this.player =null;
	}
	public SortingByNum(int num, BaseballPlayers player) {
		
		this.num = num;
		this.player = player;
		
	}
	
	
	public int[] sortTheArray(BaseballPlayers players) {
		
		ArrayList<Integer> sortedArray = players.cloneArray();
		int[] tempSorted = new int[players.arraySize()];
		
		for(int i=0; i < sortedArray.size()-1; i++) {
			int temp = tempSorted[i+1];
			
			if(sortedArray.get(i) > sortedArray.get(i+1)) {
				
				sortedArray.add(i, sortedArray.get(i+1));
				sortedArray.add(i+1, temp);
				
				
			}
			
			
		}
		
		return tempSorted;
		
	}
	
}
