class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ls = new ArrayList<>();
        for(int hour = 0; hour<12; hour++){
            for(int mins = 0; mins<60; mins++){
                if(Integer.bitCount(hour)+Integer.bitCount(mins)==turnedOn){
                    ls.add(String.format("%d:%02d",hour,mins));
                }
            }
        }
        return ls;
    }
}