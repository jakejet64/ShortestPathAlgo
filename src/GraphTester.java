public class GraphTester {
    public static void main(String[] args){
        ShortestPathGraph testGraph = new ShortestPathGraph(6);
        testGraph.makeConnection(0,1,6);
        testGraph.makeConnection(0,2,1);
        testGraph.makeConnection(0,3,10);
        testGraph.makeConnection(1,4,3);
        testGraph.makeConnection(2,1,4);
        testGraph.makeConnection(2,5,2);
        testGraph.makeConnection(4,3,3);
        testGraph.makeConnection(5,1,1);

        System.out.println(testGraph.FindShortestPaths(0, true));
    }
}
