// This is Q.933(Number of Recent Calls) from leetcode
// This solution uses a queue to utilize FIFO

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> requests;
    
    public RecentCounter() {
        requests = new LinkedList<>();
    }
    
    public int ping(int t) {
        requests.add(t);
        while (requests.peek() < t - 3000) {
            requests.remove();
        }
        return requests.size();
    }
    // Let n be the number of pings
    // Time Complexity: O(n)
    // Space Complexity: O(1) - the maximum size of our queue is 3000 because it is guaranteed that every call to ping uses a strictly larger value of t than before. So it will just be O(3000) = O(1)
    
    
    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
    }



}