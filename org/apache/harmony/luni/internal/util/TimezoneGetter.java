package org.apache.harmony.luni.internal.util;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/luni/internal/util/TimezoneGetter.class */
public abstract class TimezoneGetter {
    private static TimezoneGetter instance;

    public static TimezoneGetter getInstance() {
        return instance;
    }

    public static void setInstance(TimezoneGetter timezoneGetter) {
        if (instance != null) {
            throw new UnsupportedOperationException("TimezoneGetter instance already set");
        }
        instance = timezoneGetter;
    }

    public abstract String getId();
}
