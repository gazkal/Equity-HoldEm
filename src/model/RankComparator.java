package model;

import java.util.Comparator;
import java.util.Map;

public class RankComparator implements Comparator<String> {
	Map<String, Double> table;

    public RankComparator(Map<String, Double> table) {
        this.table = table;
    }
    public int compare(String x, String y) {
        if (table.get(x) >= table.get(y)) {
            return -1;
        } else {
            return 1;
        }
    }
}
