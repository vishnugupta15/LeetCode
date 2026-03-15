class Fancy {
    long mod = 1_000_000_007;
    List<Long> seq = new ArrayList<>();
    long mul = 1;
    long add = 0;

    long power(long a, long b){
        if(b==0)return 1;

        long half = power(a,b/2);
        long result = (half*half)%mod;

        if(b%2==1){
            result = (result*a)%mod;
        }
        return result;

    }
    public Fancy() {
        
    }
    
    public void append(int val) {
        long x = ((val-add)%mod + mod) * power(mul,mod-2)%mod; // fermat's Little theorem
        seq.add(x);
    }
    
    public void addAll(int inc) {
        add = (add+inc)%mod;   
    }
    
    public void multAll(int m) {
        mul = (mul*m)%mod;
        add = (add*m)%mod;   
    }
    
    public int getIndex(int idx) {
        if(idx>=seq.size()) return -1;
        return (int) ((seq.get(idx)*mul + add)%mod );
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */