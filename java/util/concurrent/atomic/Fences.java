package java.util.concurrent.atomic;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/Fences.class */
public class Fences {
    private static volatile int theVolatile;

    private Fences() {
    }

    public static <T> T orderAccesses(T t) {
        theVolatile = 0;
        return t;
    }

    public static <T> T orderReads(T t) {
        int i = theVolatile;
        return t;
    }

    public static <T> T orderWrites(T t) {
        theVolatile = 0;
        return t;
    }

    public static void reachabilityFence(Object obj) {
        if (obj != null) {
            synchronized (obj) {
            }
        }
    }
}
