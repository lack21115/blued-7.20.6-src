package ar.com.hjg.pngj.pixels;

import ar.com.hjg.pngj.FilterType;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/pixels/PixelsWriter.class */
public abstract class PixelsWriter {

    /* renamed from: ar.com.hjg.pngj.pixels.PixelsWriter$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/pixels/PixelsWriter$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3679a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[FilterType.values().length];
            f3679a = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3679a[FilterType.FILTER_PAETH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3679a[FilterType.FILTER_SUB.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3679a[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f3679a[FilterType.FILTER_UP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }
}
