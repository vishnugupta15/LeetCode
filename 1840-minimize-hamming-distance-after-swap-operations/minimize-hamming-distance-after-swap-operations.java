class Solution {
    int [] parent;
    int [] rank;

    public int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);

        if(rootx == rooty) return;

        if(rank[rootx]< rank[rooty]){
            int temp = rootx;
            rootx = rooty;
            rooty = temp;
        }
        parent[rooty] = rootx;

        if(rank[rootx]==rank[rooty]){
            rank[rootx]++;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps){
        int n = source.length;

        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i<n; i++){
            parent[i] = i;
        }

        for(int[] edge: allowedSwaps){
            union(edge[0],edge[1]);
        }

        Map<Integer,Map<Integer,Integer>> groupFreq = new HashMap<>();

        for(int i = 0; i<n; i++){
            int root = find(i);

            groupFreq.putIfAbsent(root,new HashMap<>());
            Map<Integer,Integer> freqMap = groupFreq.get(root);

            freqMap.put(source[i],freqMap.getOrDefault(source[i],0)+1);
        }

        int dist = 0;

        for(int i = 0; i<n; i++){
            int root = find(i);
            Map<Integer,Integer> freqMap = groupFreq.get(root);

            if(freqMap.getOrDefault(target[i],0)>0){
                freqMap.put(target[i],freqMap.get(target[i])-1);
            }
            else dist++;
        }
        return dist;
    }

}