package com.tencent.map.lib.models;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/DownloadPriority.class */
public enum DownloadPriority {
    NONE(-1),
    HIGH(0),
    MIDDLE(1),
    LOW(2);
    
    private final int mValue;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/DownloadPriority$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37259a;

        static {
            DownloadPriority.values();
            int[] iArr = new int[4];
            f37259a = iArr;
            try {
                DownloadPriority downloadPriority = DownloadPriority.HIGH;
                iArr[1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f37259a;
                DownloadPriority downloadPriority2 = DownloadPriority.LOW;
                iArr2[3] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = f37259a;
                DownloadPriority downloadPriority3 = DownloadPriority.MIDDLE;
                iArr3[2] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    DownloadPriority(int i) {
        this.mValue = i;
    }

    public static DownloadPriority get(int i) {
        DownloadPriority[] values = values();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 4) {
                return NONE;
            }
            DownloadPriority downloadPriority = values[i3];
            if (downloadPriority.mValue == i) {
                return downloadPriority;
            }
            i2 = i3 + 1;
        }
    }

    public static int getThreadPriority(int i) {
        int ordinal = get(i).ordinal();
        if (ordinal != 1) {
            return ordinal != 3 ? 5 : 1;
        }
        return 10;
    }

    public int getValue() {
        return this.mValue;
    }
}
