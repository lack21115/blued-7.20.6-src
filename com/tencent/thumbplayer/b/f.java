package com.tencent.thumbplayer.b;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/b/f.class */
class f {

    /* renamed from: a  reason: collision with root package name */
    public static String f25533a = "base_video";
    private static int b;

    /* renamed from: c  reason: collision with root package name */
    private static int f25534c;
    private static int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i) {
        if (i == 1) {
            int i2 = d;
            d = i2 + 1;
            return i2;
        } else if (i == 2) {
            int i3 = b;
            b = i3 + 1;
            return i3;
        } else if (i == 3) {
            int i4 = f25534c;
            f25534c = i4 + 1;
            return i4;
        } else {
            return -1;
        }
    }
}
