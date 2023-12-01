package ar.com.hjg.pngj.pixels;

import ar.com.hjg.pngj.FilterType;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/pixels/FiltersPerformance.class */
public class FiltersPerformance {

    /* renamed from: a  reason: collision with root package name */
    public static final double[] f3629a = {0.73d, 1.03d, 0.97d, 1.11d, 1.22d};
    private static final double b = (-1.0d) / Math.log(2.0d);

    /* renamed from: ar.com.hjg.pngj.pixels.FiltersPerformance$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/pixels/FiltersPerformance$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3630a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[FilterType.values().length];
            f3630a = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3630a[FilterType.FILTER_PAETH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3630a[FilterType.FILTER_SUB.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3630a[FilterType.FILTER_UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f3630a[FilterType.FILTER_AVERAGE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }
}
