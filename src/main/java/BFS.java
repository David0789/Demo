package main.java;

import javax.xml.soap.Node;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 广度优先搜索
 */
public class BFS {

    /**
     * Return the length of the shortest path between root and target node.
     */
    int BFS(Node root, Node target) {
        Queue<Node> queue = new LinkedBlockingQueue<>();  // store all nodes which are waiting to be processed
        Set<Node> set = new HashSet<>();
        int step = 0;       // number of steps neeeded from root to current node
        // initialize
        queue.add(root);
        set.add(root);
        // BFS
        while (!queue.isEmpty()) {
            step = step + 1;
            // iterate the nodes which are already in the loopQueue
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node cur = queue.peek();
                if (Objects.equals(target, cur)) {
                    return step;
                }
//                for (Node next : the neighbors of cur) {
//                    add next to queue;
//                }
                queue.poll();
            }
        }
        return -1;          // there is no path from root to target
    }
}
