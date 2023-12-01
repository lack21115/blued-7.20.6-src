package libcore.util;

/* loaded from: source-2895416-dex2jar.jar:libcore/util/SneakyThrow.class */
public final class SneakyThrow {
    private SneakyThrow() {
    }

    public static void sneakyThrow(Throwable th) {
        sneakyThrow2(th);
    }

    private static <T extends Throwable> void sneakyThrow2(Throwable th) throws Throwable {
        throw th;
    }
}
