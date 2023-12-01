package androidx.tracing;

/* loaded from: source-8756600-dex2jar.jar:androidx/tracing/TraceApi29Impl.class */
final class TraceApi29Impl {
    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(String str, int i) {
        android.os.Trace.beginAsyncSection(str, i);
    }

    public static void endAsyncSection(String str, int i) {
        android.os.Trace.endAsyncSection(str, i);
    }

    public static void setCounter(String str, int i) {
        android.os.Trace.setCounter(str, i);
    }
}
