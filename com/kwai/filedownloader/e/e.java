package com.kwai.filedownloader.e;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/e/e.class */
public class e {
    public final int aJr;
    public final long aJs;
    public final boolean aJt;
    public final boolean aJu;
    public final int aJv;
    public final boolean aJw;
    public final boolean aJx;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/e/e$a.class */
    public static final class a {
        private static final e aJy = new e((byte) 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0222  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private e() {
        /*
            Method dump skipped, instructions count: 754
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.e.e.<init>():void");
    }

    /* synthetic */ e(byte b) {
        this();
    }

    public static e Jb() {
        return a.aJy;
    }

    public static int dj(int i) {
        if (i > 12) {
            d.h(e.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i), 12, 12);
            return 12;
        } else if (i <= 0) {
            d.h(e.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i), 1, 1);
            return 1;
        } else {
            return i;
        }
    }
}
