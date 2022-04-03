package algo;

import java.util.*;

/* BFS would be the algorithm of choice */
public class IsThereAPathBetweenNodes {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph =  new HashMap<>() {
            {
                put(0, Arrays.asList(1));
                put(1, Arrays.asList(0, 2, 3));
                put(2, Arrays.asList(1, 3));
                put(3, Arrays.asList(1, 2));
                put(4, Arrays.asList(5, 6));
            }
        };
        int source = 0;
        int destination = 3;
        System.out.println(String.format("%s and %s are %s", source,destination,
                isConnected(source,destination,graph)?"connected": "not connected"));
    }

    static boolean isConnected(Integer source, Integer destination, Map<Integer,List<Integer>> graph){
        return dfs(source,destination,graph, new HashSet<>());
    }

    private static boolean dfs(
            Integer currentNode, Integer destination,
            final Map<Integer, List<Integer>> graph,Set<Integer> visitedNodes) {
        /* continue traversal */
        if(!visitedNodes.contains(currentNode)) {
            System.out.println("current element : "+currentNode);
            if(destination.equals(currentNode)) return true;
            /* mark the current node as visited */
            visitedNodes.add(currentNode);
            List<Integer> connectedNodes = graph.get(currentNode);
            boolean isFound = false;
            if(connectedNodes!=null) {
                for (Integer node : connectedNodes) {
                    isFound=dfs(node, destination, graph, visitedNodes);
                    if(isFound) break;
                }
            }
            return isFound;
        }
        return false;
    }
}
