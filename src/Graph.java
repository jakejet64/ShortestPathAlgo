public class Graph {
    public int[][] Adjacancies;
    private final int DefaultNodes = 8;

    public Graph(){
        Adjacancies = new int[DefaultNodes][DefaultNodes];
        initializeGraph();
    }

    public Graph(int nodes){
        Adjacancies = new int[nodes][nodes];
        initializeGraph();
    }

    public void makeConnection(int from, int to, int cost){
        Adjacancies[from][to] = cost;
    }

    private void initializeGraph(){
        for(int row = 0; row < this.Adjacancies.length; row++){
            for(int col = 0; col < this.Adjacancies.length; col++){
                Adjacancies[row][col] = -1;
                // -1 is used to represent no connection
                // this would need to be changed to account
                // for negative distances
            }
        }
    }
}
