import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Nrepeated_Element_961 {

    /**
     * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
     *
     * Return the element repeated N times.
     *
     * requirement:
     *  1. 4 <= A.length <= 10000
     *  2. 0 <= A[i] < 10000
     *  3. A.length is even
     * @param A
     * @return
     */

    public static int repeatedNTimes(int[] A){

        //invalid input
        if(A.length < 4 || A.length > 10000){
            return -1;
        }
        if(A.length % 2 != 0){
            return -1;
        }

        int n = A.length/2;
        ArrayList<Integer> uniqueElementArr = new ArrayList<>();
        ArrayList<Integer> elementCounts = new ArrayList<>();

        for(int i=0; i<A.length; i++){

            //invalid input
            if(A[i] < 0 || A[i] > 10000){
                return -1;
            }

            int elementIndex = uniqueElementArr.indexOf(A[i]);

            if(elementIndex == -1){
                //this element is not in the array, add it to the array
                uniqueElementArr.add(A[i]);
                elementIndex = uniqueElementArr.indexOf(A[i]);
                elementCounts.add(1);
            }else{
                //this element is already in the array
                elementCounts.set(elementIndex, elementCounts.get(elementIndex)+1);
            }

        }

        return uniqueElementArr.get(elementCounts.indexOf(n));
    }

    public static int repeatedNTimes2(int[] A){
        Map<Integer, Integer> count = new HashMap<>();
        for(int x:A){
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        for(int k: count.keySet()){
            System.out.println("k = " + k + " k.value = " + count.get(k));
            if(count.get(k) > 1){
                return k;
            }
        }

        throw null;
    }

    public static void main(String[] args){
        System.out.println("hello, world");

        int[] array1 = {1,2,3,3};
        int[] array2 = {2,1,2,5,3,2};
        int[] array3 = {5,1,5,2,5,3,5,4};

        System.out.println(repeatedNTimes2(array1));
        System.out.println(repeatedNTimes2(array2));
        System.out.println(repeatedNTimes2(array3));

    }
}
