class Solution {
    public double angleClock(int hour, int minutes) {
        double hour_angle = (hour%12)*30 + minutes/2.0;
        double min_angle = 6*minutes;

        System.out.println(hour_angle+" "+ min_angle);
        return Math.min(Math.abs(hour_angle-min_angle),360-Math.abs(hour_angle-min_angle));
    }
}