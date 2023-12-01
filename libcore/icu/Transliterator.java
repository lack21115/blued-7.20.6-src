package libcore.icu;

/* loaded from: source-2895416-dex2jar.jar:libcore/icu/Transliterator.class */
public final class Transliterator {
    private long peer;

    public Transliterator(String str) {
        this.peer = create(str);
    }

    private static native long create(String str);

    private static native void destroy(long j);

    public static native String[] getAvailableIDs();

    private static native String transliterate(long j, String str);

    protected void finalize() throws Throwable {
        synchronized (this) {
            destroy(this.peer);
            this.peer = 0L;
            super.finalize();
        }
    }

    public String transliterate(String str) {
        return transliterate(this.peer, str);
    }
}
