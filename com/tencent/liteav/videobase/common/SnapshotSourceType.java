package com.tencent.liteav.videobase.common;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/common/SnapshotSourceType.class */
public enum SnapshotSourceType {
    STREAM(0),
    VIEW(1);
    

    /* renamed from: c  reason: collision with root package name */
    private static final SnapshotSourceType[] f22924c = values();
    private final int mValue;

    SnapshotSourceType(int i) {
        this.mValue = i;
    }

    public static SnapshotSourceType a(int i) {
        SnapshotSourceType[] snapshotSourceTypeArr = f22924c;
        int length = snapshotSourceTypeArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return VIEW;
            }
            SnapshotSourceType snapshotSourceType = snapshotSourceTypeArr[i3];
            if (i == snapshotSourceType.mValue) {
                return snapshotSourceType;
            }
            i2 = i3 + 1;
        }
    }
}
