// This is a solution for Q.554(Brick Wall) from leetcode
// We use a hashmap to store all distinct positions of the edges of each brick (except the once on the last column) 
// And then we subtract the max value in the hashmap from the total number of rows to find the minumum number of bricks crossed 
import java.util.*;

public class BrickWall {
    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        List<Integer> row1 = Arrays.asList(1, 2, 2, 1);
        List<Integer> row2 = Arrays.asList(3, 1, 2);
        List<Integer> row3 = Arrays.asList(1, 3, 2);
        List<Integer> row4 = Arrays.asList(2, 4);
        List<Integer> row5 = Arrays.asList(3, 1, 2);
        List<Integer> row6 = Arrays.asList(1, 3, 1, 1);
        wall.add(row1);
        wall.add(row2);
        wall.add(row3);
        wall.add(row4);
        wall.add(row5);
        wall.add(row6);
        System.out.println(leastBricks(wall));
        
    }
    public static int leastBricks(List<List<Integer>> wall) {
         HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int edgeLocation = 0;
            // Exclude the last brick to avoid the last vertical edge of the wall
            for (int i = 0; i < row.size() - 1; i++) {
                edgeLocation += row.get(i);
                map.put(edgeLocation, map.getOrDefault(edgeLocation, 0) + 1);
            }
        }
        int maxEdgeCount = 0;
        for (int value : map.values()) {
            maxEdgeCount = Math.max(maxEdgeCount, value);
        }
        return wall.size() - maxEdgeCount;
        // Let n be the number of bricks
        // Time Complexity: O(n) because we are interating through each and every brick in the wall and all the operations in the loop are constant time
        // Space Complexity: O(n) - in the worst case where where we have distinct edgeLocations for each brick we have to add each of them in the hashmap 
    }
}
