import java.util.*;

class prims{
    int minkey(int key[],int[] mst){
        int min = Integer.MAX_VALUE;
        int min_index = 0; 
        for(int i =0;i<key.length;i++){
            if(mst[i]==0 && key[i]<min){
                min = key[i];
                min_index =i;
            }
        }
        return min_index;
    }


    void prim(int graph[][],int size){
        int parent[] = new int[size];
        int key[] = new int[size];
        int mst[] = new int[size];

        for (int i = 0; i< size ;i++){
            key[i]=Integer.MAX_VALUE;
            mst[i]= 0;
        }
        key[0]=0;
        parent[0]=-1;

        for(int i =0;i<size-1;i++){
            int u = minkey(key,mst);
            mst[u]=1;
            for(int j =0;j<size;j++){
                if(graph[u][j] != 0 && mst[j]==0 && graph[u][j]<key[j]){
                    parent [j] = u;
                    key[j]= graph[u][j];
                }
            }
        }
        
        int totalspaning = 0;
        for(int i =0 ; i<size;i++){
            totalspaning += key[i];
        } 
        System.out.println(totalspaning);
    }
    public static void main(String[] args) {
        System.out.println("How many node are present in graph");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int graph[][] = new int[size][size];
        System.out.println("Enter the Adjacent matrix");
        for(int i =0;i<size;i++){
            for(int j =0;j<size;j++){
                graph[i][j]= sc.nextInt();
            }
        }
        System.out.println("Adjacent matrix: ");
        for(int i =0;i<size;i++){
            for(int j =0;j<size;j++){
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
        prims p = new prims();
        p.prim(graph, size);
        
    }
}