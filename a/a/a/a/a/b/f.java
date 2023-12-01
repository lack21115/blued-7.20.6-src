package a.a.a.a.a.b;

import android.hardware.Camera;
import android.os.Build;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final List<a.a.a.a.a.e.f> f1259a;

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/f$a.class */
    public static final class a implements Comparator<Camera.Size> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Camera.Size size, Camera.Size size2) {
            return (size.width * size.height) - (size2.width * size2.height);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/f$b.class */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1260a;
        public static final /* synthetic */ int[] b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004a -> B:24:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004e -> B:6:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0052 -> B:30:0x0033). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0056 -> B:26:0x003e). Please submit an issue!!! */
        static {
            int[] iArr = new int[CameraStreamingSetting.PREVIEW_SIZE_RATIO.values().length];
            b = iArr;
            try {
                iArr[CameraStreamingSetting.PREVIEW_SIZE_RATIO.RATIO_4_3.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[CameraStreamingSetting.PREVIEW_SIZE_RATIO.RATIO_16_9.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[CameraStreamingSetting.PREVIEW_SIZE_LEVEL.values().length];
            f1260a = iArr2;
            try {
                iArr2[CameraStreamingSetting.PREVIEW_SIZE_LEVEL.SMALL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1260a[CameraStreamingSetting.PREVIEW_SIZE_LEVEL.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1260a[CameraStreamingSetting.PREVIEW_SIZE_LEVEL.LARGE.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f1259a = arrayList;
        arrayList.add(new a.a.a.a.a.e.f(1184, 666));
        f1259a.add(new a.a.a.a.a.e.f(854, 480));
    }

    public static double a(CameraStreamingSetting.PREVIEW_SIZE_RATIO preview_size_ratio) {
        int i = b.b[preview_size_ratio.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1.7777777777777777d;
            }
            throw new IllegalArgumentException("cannot support ratio:" + preview_size_ratio);
        }
        return 1.3333333333333333d;
    }

    public static int a(Camera.Parameters parameters, int i) {
        ArrayList arrayList;
        int i2;
        a.a.a.a.a.e.e.g.c("CameraUtils", "desired preview fps: " + i);
        try {
            List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
            arrayList = new ArrayList();
            i2 = Integer.MAX_VALUE;
            for (int[] iArr : supportedPreviewFpsRange) {
                a.a.a.a.a.e.e.g.c("CameraUtils", "checking entry: " + iArr[0] + " - " + iArr[1]);
                if (iArr[0] != iArr[1]) {
                    if (iArr[0] > i || i > iArr[1]) {
                        a.a.a.a.a.e.e.g.c("CameraUtils", "range not cover desired fps, pass.");
                    } else {
                        arrayList.add(iArr);
                        a.a.a.a.a.e.e.g.c("CameraUtils", "added range entry: " + iArr[0] + " - " + iArr[1]);
                    }
                } else if (iArr[0] >= i && iArr[0] - i < i2 - i) {
                    i2 = iArr[0];
                    a.a.a.a.a.e.e.g.c("CameraUtils", "rewrited fixed value:" + i2);
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
            a.a.a.a.a.e.e.g.e("CameraUtils", "getSupportedPreviewFpsRange() gave StringIndexOutOfBoundsException");
        }
        if (!arrayList.isEmpty()) {
            int[] iArr2 = (int[]) arrayList.get(0);
            int i3 = 0;
            while (i3 < arrayList.size()) {
                int[] iArr3 = (int[]) arrayList.get(i3);
                int[] iArr4 = iArr2;
                if (iArr3[1] - iArr3[0] < iArr2[1] - iArr2[0]) {
                    iArr4 = iArr3;
                }
                i3++;
                iArr2 = iArr4;
            }
            parameters.setPreviewFpsRange(iArr2[0], iArr2[1]);
            a.a.a.a.a.e.e.g.c("CameraUtils", "chose range fps: " + iArr2[0] + " - " + iArr2[1]);
            return iArr2[1];
        }
        a.a.a.a.a.e.e.g.c("CameraUtils", "cannot find appropriate range fps, try fixed.");
        if (i2 != Integer.MAX_VALUE) {
            parameters.setPreviewFpsRange(i2, i2);
            a.a.a.a.a.e.e.g.c("CameraUtils", "chose fixed fps: " + i2);
            return i2;
        }
        a.a.a.a.a.e.e.g.c("CameraUtils", "no appropriate fixed fps.");
        int[] iArr5 = new int[2];
        parameters.getPreviewFpsRange(iArr5);
        a.a.a.a.a.e.e.g.d("CameraUtils", "use default preview fps range " + iArr5[0] + " - " + iArr5[1]);
        return iArr5[1];
    }

    public static Camera.Size a(Camera.Parameters parameters, CameraStreamingSetting.PREVIEW_SIZE_RATIO preview_size_ratio, CameraStreamingSetting.PREVIEW_SIZE_LEVEL preview_size_level) {
        Camera.Size size;
        List<Camera.Size> a2 = a(a(parameters.getSupportedPreviewSizes(), preview_size_ratio));
        for (Camera.Size size2 : a2) {
            a.a.a.a.a.e.e.g.c("CameraUtils", "after filter size.w:" + size2.width + ", size.h:" + size2.height);
        }
        if (a2.isEmpty()) {
            return null;
        }
        int i = b.f1260a[preview_size_level.ordinal()];
        if (i == 1) {
            size = a2.get(0);
        } else if (i == 2) {
            size = a2.get(a2.size() - 1 >= 0 ? (a2.size() - 1) / 2 : 0);
        } else if (i != 3) {
            throw new IllegalArgumentException("cannot support level:" + preview_size_level);
        } else {
            size = a2.get(a2.size() - 1);
        }
        a.a.a.a.a.e.e.g.c("CameraUtils", "preview size width:" + size.width + ",height:" + size.height);
        parameters.setPreviewSize(size.width, size.height);
        return size;
    }

    public static Camera.Size a(List<Camera.Size> list, CameraStreamingSetting.PREVIEW_SIZE_RATIO preview_size_ratio, int i) {
        if (list == null) {
            return null;
        }
        double a2 = a(preview_size_ratio);
        double d = Double.MAX_VALUE;
        Iterator<Camera.Size> it = list.iterator();
        Camera.Size size = null;
        while (it.hasNext()) {
            Camera.Size next = it.next();
            if (next.height == i && a(next)) {
                double abs = Math.abs(a2 - ((next.width * 1.0d) / next.height));
                if (abs < d) {
                    size = next;
                    d = abs;
                }
            } else {
                it.remove();
            }
        }
        return size;
    }

    public static CameraStreamingSetting.PREVIEW_SIZE_RATIO a(int i, int i2) {
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
        eVar.c("CameraUtils", "getRatioBySize width:" + i + ",height:" + i2);
        double d = ((double) i) / ((double) i2);
        double abs = Math.abs(d - 1.3333333333333333d);
        double abs2 = Math.abs(d - 1.7777777777777777d);
        if (abs <= 0.05d) {
            return CameraStreamingSetting.PREVIEW_SIZE_RATIO.RATIO_4_3;
        }
        if (abs2 <= 0.05d) {
            return CameraStreamingSetting.PREVIEW_SIZE_RATIO.RATIO_16_9;
        }
        a.a.a.a.a.e.e.g.d("CameraUtils", "ratio of this size beyond tolerance of 4:3 and 16:9, pick the closet one");
        return abs < abs2 ? CameraStreamingSetting.PREVIEW_SIZE_RATIO.RATIO_4_3 : CameraStreamingSetting.PREVIEW_SIZE_RATIO.RATIO_16_9;
    }

    public static List<Camera.Size> a(List<Camera.Size> list) {
        Collections.sort(list, new a());
        return list;
    }

    public static List<Camera.Size> a(List<Camera.Size> list, int i) {
        if (list == null) {
            return null;
        }
        Iterator<Camera.Size> it = list.iterator();
        while (it.hasNext()) {
            Camera.Size next = it.next();
            if (next.height <= i || !a(next)) {
                it.remove();
            }
        }
        return list;
    }

    public static List<Camera.Size> a(List<Camera.Size> list, CameraStreamingSetting.PREVIEW_SIZE_RATIO preview_size_ratio) {
        if (list == null) {
            return null;
        }
        double a2 = a(preview_size_ratio);
        Iterator<Camera.Size> it = list.iterator();
        while (it.hasNext()) {
            Camera.Size next = it.next();
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
            eVar.c("CameraUtils", "size.width:" + next.width + ",size.height:" + next.height);
            if (Math.abs((next.width / next.height) - a2) > 0.05d || b(next)) {
                it.remove();
            }
        }
        return list;
    }

    public static boolean a(Camera.Size size) {
        if (size == null) {
            return false;
        }
        boolean z = false;
        if (size.width % 16 == 0) {
            z = false;
            if (size.height % 16 == 0) {
                z = true;
            }
        }
        return z;
    }

    public static Camera.Size b(List<Camera.Size> list, CameraStreamingSetting.PREVIEW_SIZE_RATIO preview_size_ratio, int i) {
        if (list == null) {
            return null;
        }
        double a2 = a(preview_size_ratio);
        Iterator<Camera.Size> it = list.iterator();
        Camera.Size size = null;
        while (it.hasNext()) {
            Camera.Size next = it.next();
            if (next.height != i || !a(next)) {
                it.remove();
            } else if (Math.abs((next.width / next.height) - a2) > 0.05d || b(next)) {
                it.remove();
            } else {
                size = next;
            }
        }
        return size;
    }

    public static List<Camera.Size> b(List<Camera.Size> list, int i) {
        if (list == null) {
            return null;
        }
        Iterator<Camera.Size> it = list.iterator();
        while (it.hasNext()) {
            Camera.Size next = it.next();
            if (next.height >= i || !a(next)) {
                it.remove();
            }
        }
        return list;
    }

    public static boolean b(Camera.Size size) {
        for (a.a.a.a.a.e.f fVar : f1259a) {
            if (size.width == fVar.a() && size.height == fVar.b()) {
                a.a.a.a.a.e.e.g.c("CameraUtils", "Incompatible size just remove it.");
                return true;
            } else if (Build.MODEL.equals("MI 5s") || Build.MODEL.equals("MI 5")) {
                if (size.width == 864 && size.height == 480) {
                    return true;
                }
            }
        }
        return false;
    }
}
