package medium;

import java.util.*;

public class Diagonals2 {

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {

        if(nums == null || nums.size() == 0)
            return new int[0];

        Map<Integer, List<Integer>> m = new HashMap<>();
        int count = 0;

        for(int row = nums.size()-1; row>-1; row--){
            for(int col = 0; col <= nums.get(row).size()-1; col++){

                int sum = row + col;

                if(!m.containsKey(sum))
                    m.put(sum, new ArrayList<>());

                m.get(sum).add(nums.get(row).get(col));

                count++;
            }
        }

        int[] result = new int[count];
        int k = 0;

        for(int i = 0; i<m.size(); i++)
            for(Integer e: m.get(i))
                result[k++]=e;

        return result;
    }


    public static void main(String[] args) {
        List<Integer> row1 = List.of(1,2,3,4,5);
        List<Integer> row2 = List.of(6,7);
        List<Integer> row3 = List.of(8);
        List<Integer> row4 = List.of(9,10,11);
        List<Integer> row5 = List.of(12,13,14,15,16);
        List<List<Integer>> list = List.of(row1, row2, row3, row4, row5);
        // Expected output:
        // [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
        System.out.println(Arrays.toString(findDiagonalOrder(list)));
    }
}

