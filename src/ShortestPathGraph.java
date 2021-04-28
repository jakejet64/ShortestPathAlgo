public class ShortestPathGraph extends Graph{

    public ShortestPathGraph() {
        super();
    }
    public ShortestPathGraph(int nodes) {
        super(nodes);
    }

    public String FindShortestPaths(int fromVertex, boolean printIterations){
        boolean[] visited = new boolean[this.Adjacancies.length];
        int[] dist = new int[this.Adjacancies.length];
        for(int i = 0; i < this.Adjacancies.length; i++){
            if(i == fromVertex){
                dist[i] = 0;
            }else{
                dist[i] = Integer.MAX_VALUE;
            }
            visited[i] = false;
        }

        for(int iteration = 0; iteration < this.Adjacancies.length; iteration++){
            int vertexToAnalyze = getMinDistUnvisited(visited, dist);
            visited[vertexToAnalyze] = true;
            for(int neighbor = 0; neighbor < this.Adjacancies.length; neighbor++){
                if(this.Adjacancies[vertexToAnalyze][neighbor] != -1
                        && (dist[vertexToAnalyze] +
                        this.Adjacancies[vertexToAnalyze][neighbor])
                        < dist[neighbor]
                ){
                    dist[neighbor] = dist[vertexToAnalyze] +
                            this.Adjacancies[vertexToAnalyze][neighbor];
                }
            }
            if(printIterations){
                System.out.println(distFormat(fromVertex, dist));
            }
        }
        return distFormat(fromVertex, dist);
    }

    private int getMinDistUnvisited(boolean[] visited, int[] dist){
        int minDistanceSoFar = Integer.MAX_VALUE;
        int retVert = -1;
        for(int i = 0; i < this.Adjacancies.length; i++){
            if(!visited[i] && dist[i] < minDistanceSoFar){
                minDistanceSoFar = dist[i];
                retVert = i;
            }
        }
        return retVert;
    }

    private String distFormat(int fromVertex, int[] dist){
        String ret = "";
        ret += ("Distances from vertex " + fromVertex + ":\n");
        for(int i = 0; i < dist.length; i++){
            ret += ("To " + i + " = " + dist[i] + "\n");
        }
        return ret;
    }
}
