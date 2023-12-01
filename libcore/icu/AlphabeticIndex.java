package libcore.icu;

import java.util.Locale;

/* loaded from: source-2895416-dex2jar.jar:libcore/icu/AlphabeticIndex.class */
public final class AlphabeticIndex {
    private long peer;

    /* loaded from: source-2895416-dex2jar.jar:libcore/icu/AlphabeticIndex$ImmutableIndex.class */
    public static final class ImmutableIndex {
        private long peer;

        private ImmutableIndex(long j) {
            this.peer = j;
        }

        private static native int getBucketCount(long j);

        private static native int getBucketIndex(long j, String str);

        private static native String getBucketLabel(long j, int i);

        protected void finalize() throws Throwable {
            synchronized (this) {
                AlphabeticIndex.destroy(this.peer);
                this.peer = 0L;
                super.finalize();
            }
        }

        public int getBucketCount() {
            return getBucketCount(this.peer);
        }

        public int getBucketIndex(String str) {
            return getBucketIndex(this.peer, str);
        }

        public String getBucketLabel(int i) {
            return getBucketLabel(this.peer, i);
        }
    }

    public AlphabeticIndex(Locale locale) {
        this.peer = create(locale.toString());
    }

    private static native void addLabelRange(long j, int i, int i2);

    private static native void addLabels(long j, String str);

    private static native long buildImmutableIndex(long j);

    private static native long create(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void destroy(long j);

    private static native int getBucketCount(long j);

    private static native int getBucketIndex(long j, String str);

    private static native String getBucketLabel(long j, int i);

    private static native int getMaxLabelCount(long j);

    private static native void setMaxLabelCount(long j, int i);

    public AlphabeticIndex addLabelRange(int i, int i2) {
        synchronized (this) {
            addLabelRange(this.peer, i, i2);
        }
        return this;
    }

    public AlphabeticIndex addLabels(Locale locale) {
        synchronized (this) {
            addLabels(this.peer, locale.toString());
        }
        return this;
    }

    protected void finalize() throws Throwable {
        synchronized (this) {
            destroy(this.peer);
            this.peer = 0L;
            super.finalize();
        }
    }

    public int getBucketCount() {
        int bucketCount;
        synchronized (this) {
            bucketCount = getBucketCount(this.peer);
        }
        return bucketCount;
    }

    public int getBucketIndex(String str) {
        int bucketIndex;
        synchronized (this) {
            bucketIndex = getBucketIndex(this.peer, str);
        }
        return bucketIndex;
    }

    public String getBucketLabel(int i) {
        String bucketLabel;
        synchronized (this) {
            bucketLabel = getBucketLabel(this.peer, i);
        }
        return bucketLabel;
    }

    public ImmutableIndex getImmutableIndex() {
        ImmutableIndex immutableIndex;
        synchronized (this) {
            immutableIndex = new ImmutableIndex(buildImmutableIndex(this.peer));
        }
        return immutableIndex;
    }

    public int getMaxLabelCount() {
        int maxLabelCount;
        synchronized (this) {
            maxLabelCount = getMaxLabelCount(this.peer);
        }
        return maxLabelCount;
    }

    public AlphabeticIndex setMaxLabelCount(int i) {
        synchronized (this) {
            setMaxLabelCount(this.peer, i);
        }
        return this;
    }
}
