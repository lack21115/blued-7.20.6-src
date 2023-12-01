package ar.com.hjg.pngj;

import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/FilterType.class */
public enum FilterType {
    FILTER_NONE(0),
    FILTER_SUB(1),
    FILTER_UP(2),
    FILTER_AVERAGE(3),
    FILTER_PAETH(4),
    FILTER_DEFAULT(-1),
    FILTER_AGGRESSIVE(-2),
    FILTER_VERYAGGRESSIVE(-4),
    FILTER_ADAPTIVE_FULL(-4),
    FILTER_ADAPTIVE_MEDIUM(-3),
    FILTER_ADAPTIVE_FAST(-2),
    FILTER_SUPER_ADAPTIVE(-10),
    FILTER_PRESERVE(-40),
    FILTER_CYCLIC(-50),
    FILTER_UNKNOWN(-100);
    
    private static HashMap<Integer, FilterType> q = new HashMap<>();
    public final int p;

    static {
        FilterType[] values;
        for (FilterType filterType : values()) {
            q.put(Integer.valueOf(filterType.p), filterType);
        }
    }

    FilterType(int i) {
        this.p = i;
    }

    public static FilterType a(int i) {
        return q.get(Integer.valueOf(i));
    }

    public static boolean b(int i) {
        return i >= 0 && i <= 4;
    }
}
