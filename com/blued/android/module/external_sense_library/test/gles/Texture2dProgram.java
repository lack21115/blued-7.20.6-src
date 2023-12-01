package com.blued.android.module.external_sense_library.test.gles;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/test/gles/Texture2dProgram.class */
public class Texture2dProgram {

    /* renamed from: com.blued.android.module.external_sense_library.test.gles.Texture2dProgram$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/test/gles/Texture2dProgram$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11300a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[ProgramType.values().length];
            f11300a = iArr;
            try {
                iArr[ProgramType.TEXTURE_2D.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11300a[ProgramType.TEXTURE_EXT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11300a[ProgramType.TEXTURE_EXT_BW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11300a[ProgramType.TEXTURE_EXT_FILT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/test/gles/Texture2dProgram$ProgramType.class */
    public enum ProgramType {
        TEXTURE_2D,
        TEXTURE_EXT,
        TEXTURE_EXT_BW,
        TEXTURE_EXT_FILT
    }
}
