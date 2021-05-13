import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakesnLadders {

	
	public static void main(String args[]){
		int[][] board = {
						 {-1,-1,-1,-1,-1,-1},
						 {-1,4,-1,-1,-1,-1},
		                 {-1,-1,-1,-1,-1,-1},
		                 {-1,-1,-1,-1,-1,-1},
		                 {-1,32,-1,-1,13,-1},
		                 {-1,-1,-1,-1,-1,-1},
		                 {-1,15,-1,-1,34,-1}};
		
		
//		int[][] board = {
//				 {-1,-1,-1,-1,-1,-1},
//                {-1,-1,-1,-1,-1,-1},
//                {-1,-1,-1,-1,-1,-1},
//                {-1,35,-1,-1,13,-1},
//                {-1,-1,-1,-1,-1,-1},
//                {-1,15,-1,-1,-1,-1}};
		System.out.println(snakesAndLadders(board));;
	}
	
	public static int snakesAndLadders(int[][] board) {
        Map<Integer,Integer> distMap = new HashMap<>();
        Queue<Integer> bRowCol = new LinkedList<>();
        bRowCol.add(1);
        distMap.put(1,0);
        int rowLength = board.length;
        int colLength = board[0].length;
        while(!bRowCol.isEmpty()){
            int val = bRowCol.remove();
            if(val == rowLength * colLength){
                return distMap.get(val);
            }
            for(int i = val+1;i<val+6 && i<= (rowLength * colLength);i++){
                int row = rowLength - ((i-1)/colLength) -1;
                int colVal = (i-1) % colLength;
                int col = (rowLength - (row + 1)) % 2 == 1 ? colLength - colVal - 1 : colVal;
                int nextVal = board[row][col] != -1 ? board[row][col] : i;
                if(!distMap.containsKey(nextVal)){
                    distMap.put(nextVal, distMap.get(val)+1);
                    bRowCol.add(nextVal);
                }
            }
            
        }
        return -1;
        
    }
}
