package medium;

import java.awt.Point;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class Traverse2BFS {
    public static int[] findDiagonalOrder(List<List<Integer>> nums) {

        if(nums==null || nums.isEmpty())
            return new int[0];

        List<Integer> resultList = new ArrayList<>();

        //BFS
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0));

        while(!q.isEmpty()){
            Point p = q.poll();
            int row = p.x;
            int col = p.y;
            resultList.add(nums.get(row).get(col));

            // Main part - most difficult - this is solution:
            if(col == 0 && row +1 < nums.size()){
                q.offer(new Point(row+1, col));
            }
            if(col+1<nums.get(row).size()){
                q.offer(new Point(row, col+1));
            }
        }

        int[] result = new int[resultList.size()];
        int k = 0;
        for(int i:resultList)
            result[k++] = i;

        return result;
    }

    public static void main(String[] args) {
        List<Integer> row1 = List.of(1,2,3,4,5);
        List<Integer> row2 = List.of(6,7);
        List<Integer> row3 = List.of(8);
        List<Integer> row4 = List.of(9,10,11);
        List<Integer> row5 = List.of(12,13,14,15,16);
        List<List<Integer>> list = List.of(row1, row2, row3, row4, row5);
        //[1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16]
        //[1 ,6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16]
        System.out.println(Arrays.toString(findDiagonalOrder(list)));
    }
}