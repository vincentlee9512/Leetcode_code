import java.util.HashMap;
import java.util.Map;

public class Robot_return_657 {

    /**
     * There is a robot starting at position (0, 0), the origin, on a 2D plane.
     * Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
     *
     * The move sequence is represented by a string, and the character moves[i] represents its ith move.
     * Valid moves are R (right), L (left), U (up), and D (down).
     * If the robot returns to the origin after it finishes all of its moves, return true.
     * Otherwise, return false.
     *
     * Note: The way that the robot is "facing" is irrelevant.
     * "R" will always make the robot move to the right once, "L" will always make it move left, etc.
     * Also, assume that the magnitude of the robot's movement is the same for each move.
     */


    public static boolean judgeCircle(String moves) {
        char[] charArr = moves.toCharArray();

        Map<Character, Integer> count = new HashMap<>();

        count.put('R', 0);
        count.put('L', 0);
        count.put('U', 0);
        count.put('D', 0);


        for(char x: charArr){
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        if(count.get('U').intValue() != count.get('D').intValue()){
            return false;
        }

        if(count.get('L').intValue() != count.get('R').intValue()){
            return false;
        }

        for(char c:count.keySet()){
            System.out.println( "key: " + c + " value: " + count.get(c));
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println("here");

        judgeCircle("UDUD");
    }
}
