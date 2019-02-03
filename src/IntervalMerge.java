import java.util.*;

public class IntervalMerge {
    private final List<Interval> intervals;

    public IntervalMerge(List<Interval> intervals) {
        this.intervals = intervals;
    }

    public static void main(String[] args) {

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2, 5));
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(6, 7));

        IntervalMerge intervalMerge = new IntervalMerge(intervals);
        intervalMerge.mergeIntervals();
    }

    private void mergeIntervals() {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        List<Interval> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(new Interval(intervals.get(0).start, intervals.get(0).end));

        for (int i = 1; i < intervals.size(); i++) {
            Interval last = mergedIntervals.get(mergedIntervals.size() - 1);
            if (intervals.get(i).start <= last.end) {
                last.start = Math.min(intervals.get(i).start, last.start);
                last.end = Math.max(intervals.get(i).end, last.end);
            }
            else
                mergedIntervals.add(new Interval(intervals.get(i).start, intervals.get(i).end));
        }
        for (Interval interval: mergedIntervals) {
            System.out.print(interval.start+ " " + interval.end);
            System.out.println();
        }
    }
}

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
