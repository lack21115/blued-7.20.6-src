package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/BitmapDescriptorFactory.class */
public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static final List<TencentMapContext> sTencentMapContextList = new CopyOnWriteArrayList();
    private static final AtomicInteger sAttachIndex = new AtomicInteger(0);

    private BitmapDescriptorFactory() {
    }

    public static void attachMapContext(TencentMapContext tencentMapContext) {
        List<TencentMapContext> list = sTencentMapContextList;
        if (list.contains(tencentMapContext)) {
            return;
        }
        list.add(tencentMapContext);
        sAttachIndex.incrementAndGet();
    }

    private static Bitmap createBitmapFromBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return null;
                }
                return bitmap.copy(Bitmap.Config.ARGB_8888, true);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static Bitmap[] createBitmapFromBitmaps(Bitmap... bitmapArr) {
        int length = bitmapArr.length;
        Bitmap[] bitmapArr2 = new Bitmap[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            try {
                bitmapArr2[i2] = createBitmapFromBitmap(bitmapArr[i2]);
                i = i2 + 1;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return bitmapArr2;
    }

    public static BitmapDescriptor defaultMarker() {
        TencentMapContext activeMapContext = getActiveMapContext();
        if (activeMapContext != null) {
            return defaultMarker(activeMapContext);
        }
        return null;
    }

    public static BitmapDescriptor defaultMarker(float f) {
        TencentMapContext activeMapContext = getActiveMapContext();
        if (activeMapContext != null) {
            return defaultMarker(activeMapContext, f);
        }
        return null;
    }

    public static BitmapDescriptor defaultMarker(TencentMapContext tencentMapContext) {
        return tencentMapContext.createBitmapDescriptor(5);
    }

    public static BitmapDescriptor defaultMarker(TencentMapContext tencentMapContext, float f) {
        return tencentMapContext.createBitmapDescriptor(f, 6);
    }

    public static void detachMapContext(TencentMapContext tencentMapContext) {
        if (sTencentMapContextList.remove(tencentMapContext)) {
            sAttachIndex.decrementAndGet();
        }
    }

    public static BitmapDescriptor fromAsset(TencentMapContext tencentMapContext, String str) {
        return tencentMapContext.createBitmapDescriptor(str, 2);
    }

    public static BitmapDescriptor fromAsset(String str) {
        TencentMapContext activeMapContext = getActiveMapContext();
        if (activeMapContext != null) {
            return fromAsset(activeMapContext, str);
        }
        return null;
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        TencentMapContext activeMapContext = getActiveMapContext();
        if (activeMapContext != null) {
            return fromBitmap(activeMapContext, bitmap);
        }
        return null;
    }

    public static BitmapDescriptor fromBitmap(TencentMapContext tencentMapContext, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return tencentMapContext.createBitmapDescriptor(createBitmapFromBitmap(bitmap), 7);
    }

    public static BitmapDescriptor fromBitmaps(TencentMapContext tencentMapContext, Bitmap... bitmapArr) {
        if (tencentMapContext == null || bitmapArr == null) {
            return null;
        }
        return tencentMapContext.createBitmapDescriptor(createBitmapFromBitmaps(bitmapArr), 10);
    }

    public static BitmapDescriptor fromBitmaps(Bitmap... bitmapArr) {
        TencentMapContext activeMapContext = getActiveMapContext();
        if (activeMapContext != null) {
            return fromBitmaps(activeMapContext, bitmapArr);
        }
        return null;
    }

    public static BitmapDescriptor fromFile(TencentMapContext tencentMapContext, String str) {
        return tencentMapContext.createBitmapDescriptor(str, 3);
    }

    public static BitmapDescriptor fromFile(String str) {
        TencentMapContext activeMapContext = getActiveMapContext();
        if (activeMapContext != null) {
            return fromFile(activeMapContext, str);
        }
        return null;
    }

    public static BitmapDescriptor fromPath(TencentMapContext tencentMapContext, String str) {
        return tencentMapContext.createBitmapDescriptor(str, 4);
    }

    public static BitmapDescriptor fromPath(String str) {
        TencentMapContext activeMapContext = getActiveMapContext();
        if (activeMapContext != null) {
            return fromPath(activeMapContext, str);
        }
        return null;
    }

    public static BitmapDescriptor fromResource(int i) {
        TencentMapContext activeMapContext = getActiveMapContext();
        if (activeMapContext != null) {
            return fromResource(activeMapContext, i);
        }
        return null;
    }

    public static BitmapDescriptor fromResource(TencentMapContext tencentMapContext, int i) {
        return tencentMapContext.createBitmapDescriptor(i, 1);
    }

    public static BitmapDescriptor fromView(View view) {
        TencentMapContext activeMapContext = getActiveMapContext();
        if (activeMapContext != null) {
            return fromView(activeMapContext, view);
        }
        return null;
    }

    public static BitmapDescriptor fromView(TencentMapContext tencentMapContext, View view) {
        synchronized (BitmapDescriptorFactory.class) {
            if (view == null) {
                return null;
            }
            try {
                view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                view.buildDrawingCache();
                BitmapDescriptor fromBitmap = fromBitmap(tencentMapContext, view.getDrawingCache());
                view.destroyDrawingCache();
                return fromBitmap;
            } catch (Exception e) {
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static TencentMapContext getActiveMapContext() {
        int i = sAttachIndex.get();
        if (i > 0) {
            List<TencentMapContext> list = sTencentMapContextList;
            if (i <= list.size()) {
                return list.get(i - 1);
            }
            return null;
        }
        return null;
    }
}
