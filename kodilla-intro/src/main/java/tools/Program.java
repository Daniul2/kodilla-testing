package tools;

import java.util.LinkedList;
import java.util.List;

class Clock{
    private int hour;
    private int minute;

    public Clock(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
    public void advanceOneMinute(){
        this.minute ++;
        if (this.minute >= 60){
            this.minute = 0;
            this.hour++;
        }
        if (this.hour >= 24){
            this.hour = 0;
        }
    }
    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }
}
public class Program {
    public static void main(String[] args) {
        List<Clock>clocks = new LinkedList<>();
        clocks.add(new Clock(10, 30));
        clocks.add(new Clock(12, 59));
        clocks.add(new Clock(23, 59));
        clocks.add(new Clock(8, 15));

        System.out.println("Before: " + clocks);

        for (Clock clock : clocks){
            clock.advanceOneMinute();
        }
        System.out.println("After:  " + clocks);

        printDivisibleByFour();

    }
    public static void printDivisibleByFour(){
        for (int i = 0; i <= 100; i+=4) {
            System.out.print(i + " ");
        }
    }
}
