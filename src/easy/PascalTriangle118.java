package easy;

import java.util.*;

public class PascalTriangle118 {
    public List<List<Integer>> generate(int numRows) {

        if(numRows<1 || numRows>30)
            return new ArrayList<>();

        if(numRows==1) {
            List<List<Integer>> listOne = new ArrayList<>();
            listOne.add(new ArrayList<>());
            listOne.get(0).add(1);
            return listOne;
        }

        List<List<Integer>> rl = new ArrayList<>();
        rl.add(new ArrayList<>());
        rl.get(0).add(1);

        for(int row = 1; row<numRows; row++){
            List<Integer> lr = new ArrayList<>();
            lr.add(1);
            for(int column = 1; column<=row; column++){
                int value;
                if(column <= rl.get(row-1).size()-1){
                    value = rl.get(row-1).get(column-1) +
                            rl.get(row-1).get(column);
                }
                else{
                    value = 1;
                }
                lr.add(value);
            }
            rl.add(lr);
        }
        return rl;

    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangle118().generate(5));
    }
}
