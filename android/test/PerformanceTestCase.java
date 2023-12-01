package android.test;

/* loaded from: source-9557208-dex2jar.jar:android/test/PerformanceTestCase.class */
public interface PerformanceTestCase {

    /* loaded from: source-9557208-dex2jar.jar:android/test/PerformanceTestCase$Intermediates.class */
    public interface Intermediates {
        void addIntermediate(String str);

        void addIntermediate(String str, long j);

        void finishTiming(boolean z);

        void setInternalIterations(int i);

        void startTiming(boolean z);
    }

    boolean isPerformanceOnly();

    int startPerformance(Intermediates intermediates);
}
