class Solution {
    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        int bestIdx = -1;
    }

    private TrieNode root = new TrieNode();

    private void insert(String word, int idx, String[] wordsContainer){
        TrieNode node = root;
        node.bestIdx = betterIdx(node.bestIdx, idx, wordsContainer);

        for(int i = word.length()-1; i>=0; i--){
            int c = word.charAt(i) - 'a';
            if(node.children[c]==null){
                node.children[c] = new TrieNode();
            }

            node = node.children[c];
            node.bestIdx = betterIdx(node.bestIdx, idx, wordsContainer);
        }
    }

    private int betterIdx(int a, int b, String[] words){
        if(a==-1) return b;
        if(words[b].length()< words[a].length()) return b;
        return a;
    }

    private int query(String word){
        TrieNode node = root;
        for(int i = word.length()-1; i>=0; i--){
            int c = word.charAt(i)-'a';
            if(node.children[c]==null) break;
            node = node.children[c];
        }

        return node.bestIdx;
    }
    
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        for(int i = 0; i<wordsContainer.length; i++){
            insert(wordsContainer[i],i, wordsContainer);
        }

        int[] ans = new int[wordsQuery.length];
        for(int i = 0; i<wordsQuery.length; i++){
            ans[i] = query(wordsQuery[i]);
        }
        return ans;
    }
}