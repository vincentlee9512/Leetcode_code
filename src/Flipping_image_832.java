public class Flipping_image_832 {

    /**
     * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
     *
     * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
     *
     * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
     * @param image as 2-D array
     * @return flipped image as 2-D array
     */

    public int[][] flipAndInvertImage(int[][] A) {

        //create a new array based on the input 2-D array.
        int num_row = A.length;
        int num_column = A[0].length;
        int[][] newArr = new int[num_row][num_column];

        //reverse index
        int k;

        for(int i=0; i<num_row; i++){
            k = num_column - 1;
            for(int j=0; j<num_column; j++){
                newArr[i][k] = (A[i][j] == 0) ? 1 : 0;
                k--;
            }
        }

        return newArr;
    }

    public static void main(String[] args){

    }

}
