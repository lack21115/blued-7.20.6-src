package io.perfmark;

/* loaded from: source-3503164-dex2jar.jar:io/perfmark/PerfMark.class */
public final class PerfMark {
    private static final Impl impl;

    /* JADX WARN: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    static {
        /*
            java.util.logging.Level r0 = java.util.logging.Level.WARNING
            r7 = r0
            r0 = 0
            r11 = r0
            java.lang.String r0 = "io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L12 java.lang.ClassNotFoundException -> L16
            r8 = r0
            r0 = 0
            r6 = r0
            goto L1d
        L12:
            r6 = move-exception
            goto L1b
        L16:
            r6 = move-exception
            java.util.logging.Level r0 = java.util.logging.Level.FINE
            r7 = r0
        L1b:
            r0 = 0
            r8 = r0
        L1d:
            r0 = r11
            r9 = r0
            r0 = r6
            r10 = r0
            r0 = r8
            if (r0 == 0) goto L55
            r0 = r8
            java.lang.Class<io.perfmark.Impl> r1 = io.perfmark.Impl.class
            java.lang.Class r0 = r0.asSubclass(r1)     // Catch: java.lang.Throwable -> L50
            r1 = 1
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L50
            r2 = r1
            r3 = 0
            java.lang.Class<io.perfmark.Tag> r4 = io.perfmark.Tag.class
            r2[r3] = r4     // Catch: java.lang.Throwable -> L50
            java.lang.reflect.Constructor r0 = r0.getConstructor(r1)     // Catch: java.lang.Throwable -> L50
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L50
            r2 = r1
            r3 = 0
            io.perfmark.Tag r4 = io.perfmark.Impl.NO_TAG     // Catch: java.lang.Throwable -> L50
            r2[r3] = r4     // Catch: java.lang.Throwable -> L50
            java.lang.Object r0 = r0.newInstance(r1)     // Catch: java.lang.Throwable -> L50
            io.perfmark.Impl r0 = (io.perfmark.Impl) r0     // Catch: java.lang.Throwable -> L50
            r9 = r0
            r0 = r6
            r10 = r0
            goto L55
        L50:
            r10 = move-exception
            r0 = r11
            r9 = r0
        L55:
            r0 = r9
            if (r0 == 0) goto L60
            r0 = r9
            io.perfmark.PerfMark.impl = r0
            goto L6d
        L60:
            io.perfmark.Impl r0 = new io.perfmark.Impl
            r1 = r0
            io.perfmark.Tag r2 = io.perfmark.Impl.NO_TAG
            r1.<init>(r2)
            io.perfmark.PerfMark.impl = r0
        L6d:
            r0 = r10
            if (r0 == 0) goto L82
            java.lang.Class<io.perfmark.PerfMark> r0 = io.perfmark.PerfMark.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            r1 = r7
            java.lang.String r2 = "Error during PerfMark.<clinit>"
            r3 = r10
            r0.log(r1, r2, r3)
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.perfmark.PerfMark.m12622clinit():void");
    }

    private PerfMark() {
    }

    public static void attachTag(Tag tag) {
        impl.attachTag(tag);
    }

    public static Tag createTag() {
        return Impl.NO_TAG;
    }

    public static Tag createTag(long j) {
        return impl.createTag("", j);
    }

    public static Tag createTag(String str) {
        return impl.createTag(str, Long.MIN_VALUE);
    }

    public static Tag createTag(String str, long j) {
        return impl.createTag(str, j);
    }

    public static void event(String str) {
        impl.event(str);
    }

    public static void event(String str, Tag tag) {
        impl.event(str, tag);
    }

    @Deprecated
    public static Link link() {
        return Impl.NO_LINK;
    }

    public static void linkIn(Link link) {
        impl.linkIn(link);
    }

    public static Link linkOut() {
        return impl.linkOut();
    }

    public static void setEnabled(boolean z) {
        impl.setEnabled(z);
    }

    public static void startTask(String str) {
        impl.startTask(str);
    }

    public static void startTask(String str, Tag tag) {
        impl.startTask(str, tag);
    }

    public static void stopTask(String str) {
        impl.stopTask(str);
    }

    public static void stopTask(String str, Tag tag) {
        impl.stopTask(str, tag);
    }
}
