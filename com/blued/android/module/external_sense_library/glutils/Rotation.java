package com.blued.android.module.external_sense_library.glutils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/glutils/Rotation.class */
public enum Rotation {
    NORMAL,
    ROTATION_90,
    ROTATION_180,
    ROTATION_270;

    /* renamed from: com.blued.android.module.external_sense_library.glutils.Rotation$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/glutils/Rotation$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11257a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[Rotation.values().length];
            f11257a = iArr;
            try {
                iArr[Rotation.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11257a[Rotation.ROTATION_90.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11257a[Rotation.ROTATION_180.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11257a[Rotation.ROTATION_270.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }
}
