package _5_labs._2_stream._4_strategy;

public class DoubleAllocateStrategy implements AllocateStrategy {
    public int nextAfter(int now) {
        return now * 2;
    }
}
