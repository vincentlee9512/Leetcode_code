import java.util.ArrayList;

public class SortArrayByParity_905 {
    public static int[] sortArrayByParity(int[] A) {
        int[] returnArr = new int[A.length];

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int x:A){
            if(x%2 == 0){
                list.add(0, x);
            }else{
                list.add(x);
            }
        }

        for(int i=0; i<list.size(); i++){
            returnArr[i] = list.get(i);
        }

        return returnArr;
    }

    public static void main(String[] args){
        System.out.println("here");
    }
}
