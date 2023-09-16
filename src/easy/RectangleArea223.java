package easy;

public class RectangleArea223 {

        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

            if(rec1 == null || rec2 == null)
                return false;

            if(rec1.length != 4 || rec2.length != 4)
                return false;

            if(rec1[0] > rec1[2] || rec1[1] > rec1[3] || rec2[0] > rec2[2] || rec2[1] > rec2[3])
                return false;

            if(rec2[0]<rec1[2] && rec2[2]>rec1[0])
                return rec2[1] < rec1[3] && rec2[3] > rec1[1];

            return false;
        }

    public static void main(String[] args) {

/*      Example 1:
        Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
        Output: true*/
        System.out.println(new RectangleArea223().isRectangleOverlap(new int[]{0,0,2,2},new int[]{1,1,3,3}));

/*      Example 2:
        Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
        Output: false*/
        System.out.println(new RectangleArea223().isRectangleOverlap(new int[]{0,0,1,1},new int[]{1,0,2,1}));

/*      Example 3:
        Input: rec1 = [0,0,1,1], rec2 = [2,2,3,3]
        Output: false*/
        System.out.println(new RectangleArea223().isRectangleOverlap(new int[]{0,0,1,1},new int[]{2,2,3,3}));
    }
}
