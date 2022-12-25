package easy;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        if(nums == null || nums.length == 0 || nums.length > 10000)
            return -1;

        int resultIndex = -1;

        if(nums.length==1) {
            if(target<=nums[0]) return 0;
            else return 1;
        }
        else {
            int middleIndex = (nums.length / 2) - 1;
            if(target <= nums[middleIndex]){
                resultIndex = binarySearch(nums, target, 0, middleIndex);
            }
            else {
                resultIndex = binarySearch(nums, target, middleIndex+1, nums.length-1);
            }
        }
        return resultIndex;
    }

    public int binarySearch(int[] array, int target, int startIndex, int endIndex){

        if(startIndex == endIndex){
            if(target<=array[startIndex]) return startIndex;
            else return startIndex+1;
        }

        int middleIndex = startIndex + (endIndex-startIndex) / 2;

        if(target <= array[middleIndex])
            return binarySearch(array, target, 0, middleIndex);
        else
            return binarySearch(array, target, middleIndex+1, endIndex);
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1,1,2,3,5,6}, 7));
    }
}
