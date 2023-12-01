package com.tencent.liteav.videobase.utils;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/Rotation.class */
public enum Rotation {
    NORMAL(0),
    ROTATION_90(90),
    ROTATION_180(180),
    ROTATION_270(270);
    
    private static final Rotation[] e = values();
    public final int mValue;

    Rotation(int i) {
        this.mValue = i;
    }

    public static Rotation a(int i) {
        Rotation[] rotationArr = e;
        int length = rotationArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return NORMAL;
            }
            Rotation rotation = rotationArr[i3];
            if (rotation.mValue == i) {
                return rotation;
            }
            i2 = i3 + 1;
        }
    }

    public static boolean b(int i) {
        return i == 0 || i == 90 || i == 180 || i == 270;
    }
}
