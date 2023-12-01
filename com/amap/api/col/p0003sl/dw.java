package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amap.api.col.p0003sl.ia;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.FileUtil;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.dw  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/dw.class */
public final class dw {

    /* renamed from: a  reason: collision with root package name */
    private static FPoint[] f4869a = {FPoint.obtain(), FPoint.obtain(), FPoint.obtain(), FPoint.obtain()};
    private static List<Float> b = new ArrayList(4);

    /* renamed from: c  reason: collision with root package name */
    private static List<Float> f4870c = new ArrayList(4);
    private static int d = 0;

    private static double a(double d2, double d3, double d4, double d5, double d6, double d7) {
        return ((d4 - d2) * (d7 - d3)) - ((d6 - d2) * (d5 - d3));
    }

    private static double a(float f, double d2, double d3) {
        return 20.0d - (Math.log(d3 / (d2 * f)) / Math.log(2.0d));
    }

    private static float a(float f, float f2, double d2) {
        return (float) (d2 / (Math.pow(2.0d, 20.0f - f2) * f));
    }

    private static float a(float f, float f2, float f3) {
        return (float) (f3 * Math.pow(2.0d, 20.0f - f2) * f);
    }

    public static float a(IGLMapState iGLMapState, int i, int i2, double d2, double d3, int i3) {
        IPoint obtain = IPoint.obtain();
        VirtualEarthProjection.latLongToPixels(d2, d3, 20, obtain);
        float a2 = a(iGLMapState, i, i2, obtain.x, obtain.y, i3);
        obtain.recycle();
        return a2;
    }

    private static float a(IGLMapState iGLMapState, int i, int i2, int i3, int i4, int i5) {
        if (iGLMapState != null) {
            return iGLMapState.calculateMapZoomer(i, i2, i3, i4, i5);
        }
        return 3.0f;
    }

    public static float a(DPoint dPoint, DPoint dPoint2) {
        if (dPoint == null || dPoint2 == null) {
            return 0.0f;
        }
        double d2 = dPoint.x;
        double d3 = dPoint2.x;
        return (float) ((Math.atan2(dPoint2.y - dPoint.y, d3 - d2) / 3.141592653589793d) * 180.0d);
    }

    public static float a(IMapConfig iMapConfig, float f) {
        float f2;
        if (iMapConfig != null) {
            if (f > iMapConfig.getMaxZoomLevel()) {
                return iMapConfig.getMaxZoomLevel();
            }
            f2 = f;
            if (f < iMapConfig.getMinZoomLevel()) {
                return iMapConfig.getMinZoomLevel();
            }
        } else if (f > 20.0f) {
            return 20.0f;
        } else {
            f2 = f;
            if (f < 3.0f) {
                f2 = 3.0f;
            }
        }
        return f2;
    }

    public static float a(IMapConfig iMapConfig, float f, float f2) {
        int i;
        boolean z = false;
        boolean z2 = false;
        if (iMapConfig != null) {
            z = iMapConfig.isAbroadEnable();
            if (iMapConfig.getAbroadState() != 1) {
                z2 = true;
            }
        } else {
            z2 = false;
        }
        float f3 = 0.0f;
        if (f >= 0.0f) {
            f3 = f;
        }
        if (z && z2) {
            if (f3 > 40.0f) {
                return 40.0f;
            }
            return f3;
        } else if (iMapConfig != null && iMapConfig.isTerrainEnable()) {
            if (f3 > 80.0f) {
                return 80.0f;
            }
            return f3;
        } else {
            float f4 = f3;
            if (f > 40.0f) {
                if (f2 <= 15.0f) {
                    i = 40;
                } else if (f2 <= 16.0f) {
                    i = 56;
                } else if (f2 <= 17.0f) {
                    i = 66;
                } else {
                    int i2 = (f2 > 18.0f ? 1 : (f2 == 18.0f ? 0 : -1));
                    i = i2 <= 0 ? 74 : i2 <= 0 ? 78 : 80;
                }
                float f5 = i;
                f4 = f3;
                if (f3 > f5) {
                    f4 = f5;
                }
            }
            return f4;
        }
    }

    public static float a(IMapConfig iMapConfig, int i, int i2, int i3, int i4, int i5, int i6) {
        float sz = iMapConfig.getSZ();
        float f = sz;
        if (i != i3) {
            f = sz;
            if (i2 != i4) {
                f = Math.max((float) a(iMapConfig.getMapZoomScale(), i5, Math.abs(i3 - i)), (float) a(iMapConfig.getMapZoomScale(), i6, Math.abs(i4 - i2)));
            }
        }
        return f;
    }

    public static int a(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Bitmap a(Context context, String str) {
        try {
            InputStream open = dq.a(context).open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            return decodeStream;
        } catch (Throwable th) {
            iw.c(th, "Util", "fromAsset");
            a(th);
            return null;
        }
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * f), (int) (bitmap.getHeight() * f), true);
    }

    public static Bitmap a(View view) {
        try {
            c(view);
            view.destroyDrawingCache();
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                return drawingCache.copy(Bitmap.Config.ARGB_8888, false);
            }
            return null;
        } catch (Throwable th) {
            iw.c(th, "Utils", "getBitmapFromView");
            th.printStackTrace();
            return null;
        }
    }

    public static Bitmap a(int[] iArr, int i, int i2) {
        return a(iArr, i, i2, false);
    }

    public static Bitmap a(int[] iArr, int i, int i2, boolean z) {
        try {
            int[] iArr2 = new int[iArr.length];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= i2) {
                    Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    createBitmap.setPixels(iArr2, 0, i, 0, 0, i, i2);
                    return createBitmap;
                }
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 < i) {
                        int i7 = (i4 * i) + i6;
                        int i8 = iArr[i7];
                        int i9 = (i8 & Color.GREEN) | ((i8 << 16) & Spanned.SPAN_PRIORITY) | ((i8 >> 16) & 255);
                        if (z) {
                            iArr2[(((i2 - i4) - 1) * i) + i6] = i9;
                        } else {
                            iArr2[i7] = i9;
                        }
                        i5 = i6 + 1;
                    }
                }
                i3 = i4 + 1;
            }
        } catch (Throwable th) {
            iw.c(th, "Util", "rgbaToArgb");
            th.printStackTrace();
            return null;
        }
    }

    public static Pair<Float, IPoint> a(AbstractCameraUpdateMessage abstractCameraUpdateMessage, IMapConfig iMapConfig) {
        return a(iMapConfig, Math.max(abstractCameraUpdateMessage.paddingLeft, 1), Math.max(abstractCameraUpdateMessage.paddingRight, 1), Math.max(abstractCameraUpdateMessage.paddingTop, 1), Math.max(abstractCameraUpdateMessage.paddingBottom, 1), abstractCameraUpdateMessage.bounds, abstractCameraUpdateMessage.width, abstractCameraUpdateMessage.height);
    }

    public static Pair<Float, IPoint> a(IMapConfig iMapConfig, int i, int i2, int i3, int i4, LatLngBounds latLngBounds, int i5, int i6) {
        int i7;
        float f;
        float f2;
        int i8;
        if (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null || iMapConfig == null) {
            return null;
        }
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLngBounds.northeast.latitude, latLngBounds.northeast.longitude, 20);
        Point latLongToPixels2 = VirtualEarthProjection.latLongToPixels(latLngBounds.southwest.latitude, latLngBounds.southwest.longitude, 20);
        int i9 = latLongToPixels.x - latLongToPixels2.x;
        int i10 = latLongToPixels2.y - latLongToPixels.y;
        int i11 = i5 - (i + i2);
        int i12 = i6 - (i3 + i4);
        if (i9 >= 0 || i10 >= 0) {
            if (i9 <= 0) {
                i9 = 1;
            }
            if (i10 <= 0) {
                i10 = 1;
            }
            if (i11 <= 0) {
                i11 = 1;
            }
            if (i12 <= 0) {
                i12 = 1;
            }
            Pair<Float, Boolean> b2 = b(iMapConfig, latLongToPixels.x, latLongToPixels.y, latLongToPixels2.x, latLongToPixels2.y, i11, i12);
            float floatValue = b2.first.floatValue();
            boolean booleanValue = b2.second.booleanValue();
            float a2 = a(iMapConfig.getMapZoomScale(), floatValue, i9);
            float a3 = a(iMapConfig.getMapZoomScale(), floatValue, i10);
            if (floatValue >= iMapConfig.getMaxZoomLevel()) {
                i7 = (int) (latLongToPixels2.x + ((((i2 - i) + a2) * i9) / (a2 * 2.0f)));
                i8 = latLongToPixels.y;
            } else if (!booleanValue) {
                i7 = (int) (latLongToPixels2.x + ((((i2 - i) + a2) * i9) / (a2 * 2.0f)));
                f = latLongToPixels.y;
                f2 = (((i6 / 2) - i3) / a3) * i10;
                int i13 = (int) (f + f2);
                return new Pair<>(Float.valueOf(floatValue), IPoint.obtain((int) (i7 + a(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1))), (int) (i13 + a(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1)))));
            } else {
                i7 = (int) (latLongToPixels2.x + ((((i5 / 2) - i) / a2) * i9));
                i8 = latLongToPixels.y;
            }
            f = i8;
            f2 = (((i4 - i3) + a3) * i10) / (a3 * 2.0f);
            int i132 = (int) (f + f2);
            return new Pair<>(Float.valueOf(floatValue), IPoint.obtain((int) (i7 + a(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1))), (int) (i132 + a(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1)))));
        }
        return null;
    }

    public static ia a() {
        try {
            if (w.e == null) {
                w.e = new ia.a("3dmap", "9.3.1", w.f5440c).a(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.autonavi.amap", "com.autonavi.ae", "com.autonavi.base", "com.autonavi.patch", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"}).a("9.3.1").a();
            }
            return w.e;
        } catch (Throwable th) {
            return null;
        }
    }

    public static DPoint a(LatLng latLng) {
        double d2 = latLng.longitude / 360.0d;
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return DPoint.obtain((d2 + 0.5d) * 1.0d, (((Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / (-6.283185307179586d)) + 0.5d) * 1.0d);
    }

    public static String a(int i) {
        if (i < 1000) {
            return i + "m";
        }
        return (i / 1000) + "km";
    }

    public static String a(Context context) {
        File file = new File(FileUtil.getMapBaseStorage(context), AeUtil.ROOT_DATA_PATH_NAME);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file.toString() + File.separator);
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file.toString() + File.separator;
    }

    public static String a(File file) {
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader2;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        FileInputStream fileInputStream4;
        StringBuffer stringBuffer = new StringBuffer();
        FileInputStream fileInputStream5 = null;
        try {
            try {
                try {
                    fileInputStream4 = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    e = e;
                    fileInputStream2 = null;
                    fileInputStream3 = null;
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = null;
                    bufferedReader2 = null;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = null;
                }
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(fileInputStream4, "utf-8"));
                    while (true) {
                        try {
                            String readLine = bufferedReader3.readLine();
                            try {
                                if (readLine != null) {
                                    stringBuffer.append(readLine);
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                        bufferedReader3.close();
                                    }
                                }
                            } catch (Throwable th2) {
                                try {
                                    bufferedReader3.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                                throw th2;
                            }
                        } catch (FileNotFoundException e5) {
                            e = e5;
                            fileInputStream2 = fileInputStream4;
                            fileInputStream3 = bufferedReader3;
                            iw.c(e, "Util", "readFile fileNotFound");
                            FileInputStream fileInputStream6 = fileInputStream3;
                            e.printStackTrace();
                            if (r0 != null) {
                                try {
                                    try {
                                        fileInputStream3.close();
                                    } finally {
                                        if (fileInputStream3 != null) {
                                            try {
                                                fileInputStream3.close();
                                            } catch (IOException e6) {
                                                e6.printStackTrace();
                                            }
                                        }
                                    }
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                    if (fileInputStream3 != null) {
                                        fileInputStream3.close();
                                    }
                                }
                            }
                            if (fileInputStream3 != null) {
                                fileInputStream3.close();
                            }
                            return stringBuffer.toString();
                        } catch (IOException e8) {
                            e = e8;
                            fileInputStream = fileInputStream4;
                            bufferedReader2 = bufferedReader3;
                            iw.c(e, "Util", "readFile io");
                            FileInputStream fileInputStream7 = fileInputStream;
                            e.printStackTrace();
                            try {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e9) {
                                        e9.printStackTrace();
                                        if (bufferedReader2 != null) {
                                            bufferedReader2.close();
                                        }
                                    }
                                }
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                                return stringBuffer.toString();
                            } catch (Throwable th3) {
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
                                    }
                                }
                                throw th3;
                            }
                        }
                    }
                    fileInputStream4.close();
                    bufferedReader3.close();
                } catch (FileNotFoundException e11) {
                    e = e11;
                    fileInputStream2 = fileInputStream4;
                    fileInputStream3 = null;
                } catch (IOException e12) {
                    e = e12;
                    fileInputStream = fileInputStream4;
                    bufferedReader2 = null;
                } catch (Throwable th4) {
                    bufferedReader = null;
                    fileInputStream5 = fileInputStream4;
                    th = th4;
                    try {
                        try {
                            if (fileInputStream5 != null) {
                                try {
                                    fileInputStream5.close();
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    throw th;
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } catch (IOException e14) {
                            e14.printStackTrace();
                        }
                        throw th;
                    } catch (Throwable th5) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e15) {
                                e15.printStackTrace();
                            }
                        }
                        throw th5;
                    }
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            return stringBuffer.toString();
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static String a(InputStream inputStream) {
        try {
            return new String(b(inputStream), "utf-8");
        } catch (Throwable th) {
            iw.c(th, "Util", "decodeAssetResData");
            th.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse.getAuthority() == null || !parse.getAuthority().startsWith("dualstack-")) {
                if (parse.getAuthority() == null || !parse.getAuthority().startsWith("restsdk.amap.com")) {
                    Uri.Builder buildUpon = parse.buildUpon();
                    return buildUpon.authority("dualstack-" + parse.getAuthority()).build().toString();
                }
                return parse.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
            }
            return str;
        } catch (Throwable th) {
            return str;
        }
    }

    public static String a(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }

    public static String a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : strArr) {
            sb.append(str);
            if (i != strArr.length - 1) {
                sb.append(",");
            }
            i++;
        }
        return sb.toString();
    }

    public static void a(Bitmap bitmap) {
        if (bitmap == null || Build.VERSION.SDK_INT > 10 || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public static void a(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static void a(Throwable th) {
        try {
            if (MapsInitializer.getExceptionLogger() != null) {
                MapsInitializer.getExceptionLogger().onException(th);
            }
        } catch (Throwable th2) {
        }
    }

    private static boolean a(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d4 - d2;
        double d10 = d8 - d7;
        double d11 = d5 - d3;
        double d12 = 180.0d - d6;
        double d13 = (d9 * d10) - (d11 * d12);
        if (d13 != 0.0d) {
            double d14 = d3 - d7;
            double d15 = d2 - d6;
            double d16 = ((d12 * d14) - (d10 * d15)) / d13;
            double d17 = ((d14 * d9) - (d15 * d11)) / d13;
            return d16 >= 0.0d && d16 <= 1.0d && d17 >= 0.0d && d17 <= 1.0d;
        }
        return false;
    }

    public static boolean a(double d2, LatLng latLng, CircleHoleOptions circleHoleOptions) {
        try {
            return ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), latLng)) <= d2 - circleHoleOptions.getRadius();
        } catch (Throwable th) {
            iw.c(th, "CircleDelegateImp", "isCircleInCircle");
            th.printStackTrace();
            return true;
        }
    }

    private static boolean a(double d2, LatLng latLng, List<BaseHoleOptions> list, LatLng latLng2) throws RemoteException {
        if (list != null && list.size() > 0) {
            for (BaseHoleOptions baseHoleOptions : list) {
                if (a(baseHoleOptions, latLng2)) {
                    return false;
                }
            }
        }
        return d2 >= ((double) AMapUtils.calculateLineDistance(latLng, latLng2));
    }

    public static boolean a(double d2, LatLng latLng, List<BaseHoleOptions> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z;
        boolean z2 = true;
        boolean z3 = true;
        try {
            List<LatLng> points = polygonHoleOptions.getPoints();
            int i = 0;
            while (true) {
                int i2 = i;
                z2 = z3;
                z = z3;
                if (i2 >= points.size()) {
                    break;
                }
                boolean z4 = z3;
                z3 = a(d2, latLng, list, points.get(i2));
                z = z3;
                if (!z3) {
                    break;
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            iw.c(th, "CircleDelegateImp", "isPolygonInCircle");
            th.printStackTrace();
            z = z2;
        }
        return z;
    }

    public static boolean a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            Log.w("3dmap", "the map must have a size");
            return false;
        }
        return true;
    }

    public static boolean a(Rect rect, int i, int i2) {
        return rect.contains(i, i2);
    }

    public static boolean a(BaseHoleOptions baseHoleOptions, LatLng latLng) {
        if (baseHoleOptions instanceof CircleHoleOptions) {
            CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
            LatLng center = circleHoleOptions.getCenter();
            return center != null && ((double) AMapUtils.calculateLineDistance(center, latLng)) <= circleHoleOptions.getRadius();
        }
        List<LatLng> points = ((PolygonHoleOptions) baseHoleOptions).getPoints();
        if (points == null || points.size() == 0) {
            return false;
        }
        return a(latLng, points);
    }

    private static boolean a(CircleHoleOptions circleHoleOptions, CircleHoleOptions circleHoleOptions2) {
        try {
            return ((double) AMapUtils.calculateLineDistance(circleHoleOptions2.getCenter(), circleHoleOptions.getCenter())) < circleHoleOptions.getRadius() + circleHoleOptions2.getRadius();
        } catch (Throwable th) {
            iw.c(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
            return false;
        }
    }

    public static boolean a(LatLng latLng, List<LatLng> list) {
        boolean z;
        boolean z2 = false;
        if (latLng == null || list == null) {
            return false;
        }
        double d2 = latLng.longitude;
        double d3 = latLng.latitude;
        double d4 = latLng.latitude;
        if (list.size() < 3) {
            return false;
        }
        if (list.get(0).equals(list.get(list.size() - 1))) {
            z = false;
        } else {
            list.add(list.get(0));
            z = true;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            try {
                if (i >= list.size() - 1) {
                    if (i3 % 2 != 0) {
                        z2 = true;
                    }
                    if (z) {
                        list.remove(list.size() - 1);
                    }
                    return z2;
                }
                double d5 = list.get(i).longitude;
                double d6 = list.get(i).latitude;
                i++;
                double d7 = list.get(i).longitude;
                try {
                    double d8 = list.get(i).latitude;
                    if (b(d2, d3, d5, d6, d7, d8)) {
                        if (z) {
                            list.remove(list.size() - 1);
                            return true;
                        }
                        return true;
                    }
                    int i4 = i3;
                    if (Math.abs(d8 - d6) >= 1.0E-9d) {
                        if (b(d5, d6, d2, d3, 180.0d, d4)) {
                            i4 = i3;
                            if (d6 <= d8) {
                            }
                            i4 = i3 + 1;
                        } else if (b(d7, d8, d2, d3, 180.0d, d4)) {
                            i4 = i3;
                            if (d8 <= d6) {
                            }
                            i4 = i3 + 1;
                        } else {
                            i4 = i3;
                            if (a(d5, d6, d7, d8, d2, d3, d4)) {
                                i4 = i3 + 1;
                            }
                        }
                    }
                    i2 = i4;
                } catch (Throwable th) {
                    th = th;
                    if (z) {
                        list.remove(list.size() - 1);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static boolean a(List<BaseHoleOptions> list, CircleHoleOptions circleHoleOptions) {
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            BaseHoleOptions baseHoleOptions = list.get(i);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                boolean b2 = b(((PolygonHoleOptions) baseHoleOptions).getPoints(), circleHoleOptions);
                z = b2;
                if (b2) {
                    return true;
                }
            } else if (baseHoleOptions instanceof CircleHoleOptions) {
                boolean a2 = a(circleHoleOptions, (CircleHoleOptions) baseHoleOptions);
                z = a2;
                if (a2) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return z;
    }

    public static boolean a(List<BaseHoleOptions> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            BaseHoleOptions baseHoleOptions = list.get(i);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                boolean a2 = a(((PolygonHoleOptions) baseHoleOptions).getPoints(), polygonHoleOptions.getPoints());
                z = a2;
                if (a2) {
                    return true;
                }
            } else if (baseHoleOptions instanceof CircleHoleOptions) {
                boolean b2 = b(polygonHoleOptions.getPoints(), (CircleHoleOptions) baseHoleOptions);
                z = b2;
                if (b2) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r6 >= r4.size()) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
        if (a(r4.get(r6), r5) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
        return b(r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
        r0 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
        r6 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.util.List<com.amap.api.maps.model.LatLng> r4, java.util.List<com.amap.api.maps.model.LatLng> r5) {
        /*
            r0 = 0
            r6 = r0
        L2:
            r0 = r6
            r1 = r5
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L44
            if (r0 >= r1) goto L5b
            r0 = r5
            r1 = r6
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L44
            com.amap.api.maps.model.LatLng r0 = (com.amap.api.maps.model.LatLng) r0     // Catch: java.lang.Throwable -> L44
            r1 = r4
            boolean r0 = a(r0, r1)     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto L54
            r0 = 1
            return r0
        L1f:
            r0 = r6
            r1 = r4
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L44
            if (r0 >= r1) goto L3c
            r0 = r4
            r1 = r6
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L44
            com.amap.api.maps.model.LatLng r0 = (com.amap.api.maps.model.LatLng) r0     // Catch: java.lang.Throwable -> L44
            r1 = r5
            boolean r0 = a(r0, r1)     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto L60
            r0 = 1
            return r0
        L3c:
            r0 = r4
            r1 = r5
            boolean r0 = b(r0, r1)     // Catch: java.lang.Throwable -> L44
            r7 = r0
            r0 = r7
            return r0
        L44:
            r4 = move-exception
            r0 = r4
            java.lang.String r1 = "Util"
            java.lang.String r2 = "isPolygon2PolygonIntersect"
            com.amap.api.col.p0003sl.iw.c(r0, r1, r2)
            r0 = r4
            r0.printStackTrace()
            r0 = 0
            return r0
        L54:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L2
        L5b:
            r0 = 0
            r6 = r0
            goto L1f
        L60:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.dw.a(java.util.List, java.util.List):boolean");
    }

    public static boolean a(List<LatLng> list, List<BaseHoleOptions> list2, CircleHoleOptions circleHoleOptions) {
        try {
            if (b(list, circleHoleOptions)) {
                return false;
            }
            return a(list, list2, circleHoleOptions.getCenter());
        } catch (Throwable th) {
            iw.c(th, "PolygonDelegateImp", "isCircleInPolygon");
            th.printStackTrace();
            return false;
        }
    }

    private static boolean a(List<LatLng> list, List<BaseHoleOptions> list2, LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return false;
        }
        if (list2 != null) {
            try {
                if (list2.size() > 0) {
                    Iterator<BaseHoleOptions> it = list2.iterator();
                    do {
                        if (it.hasNext()) {
                        }
                    } while (!a(it.next(), latLng));
                    return false;
                }
            } catch (Throwable th) {
                iw.c(th, "PolygonDelegateImp", "contains");
                th.printStackTrace();
                return false;
            }
        }
        return a(latLng, list);
    }

    public static byte[] a(byte[] bArr, int i) {
        return a(bArr, i, i, true);
    }

    public static byte[] a(byte[] bArr, int i, int i2, boolean z) {
        try {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            Bitmap copy = decodeByteArray.copy(decodeByteArray.getConfig(), true);
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= width) {
                    break;
                }
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 < height) {
                        if (i4 != 0 && i6 != 0) {
                            copy.setPixel(i4, i6, i);
                        } else if (!z) {
                            copy.setPixel(i4, i6, i2);
                        }
                        i5 = i6 + 1;
                    }
                }
                i3 = i4 + 1;
            }
            byte[] b2 = b(copy);
            byte[] bArr2 = b2;
            if (b2 == null) {
                bArr2 = bArr;
            }
            a(copy);
            a(decodeByteArray);
            return bArr2;
        } catch (Throwable th) {
            th.printStackTrace();
            return bArr;
        }
    }

    public static int[] a(int i, int i2, int i3, int i4, IMapConfig iMapConfig, IGLMapState iGLMapState, int i5, int i6) {
        int max;
        int max2;
        synchronized (dw.class) {
            try {
                int mapWidth = iMapConfig.getMapWidth();
                int mapHeight = iMapConfig.getMapHeight();
                int anchorX = iMapConfig.getAnchorX();
                int anchorY = iMapConfig.getAnchorY();
                float a2 = a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), anchorX);
                float a3 = a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), mapWidth - anchorX);
                float a4 = a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), anchorY);
                float a5 = a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), mapHeight - anchorY);
                float f = i2;
                float f2 = i4;
                max = (int) Math.max(i3 + a2, Math.min(i5, i - a3));
                max2 = (int) Math.max(f + a4, Math.min(i6, f2 - a5));
            } catch (Throwable th) {
                throw th;
            }
        }
        return new int[]{max, max2};
    }

    public static int b() {
        int i;
        synchronized (dw.class) {
            try {
                int i2 = d + 1;
                d = i2;
                if (i2 == Integer.MAX_VALUE) {
                    d = 0;
                }
                i = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    private static Pair<Float, Boolean> b(IMapConfig iMapConfig, int i, int i2, int i3, int i4, int i5, int i6) {
        float min;
        iMapConfig.getSZ();
        boolean z = true;
        if (i == i3 && i2 == i4) {
            min = iMapConfig.getMaxZoomLevel();
            z = true;
        } else {
            float a2 = (float) a(iMapConfig.getMapZoomScale(), i6, Math.abs(i4 - i2));
            float a3 = (float) a(iMapConfig.getMapZoomScale(), i5, Math.abs(i3 - i));
            float min2 = Math.min(a3, a2);
            if (min2 != a3) {
                z = false;
            }
            min = Math.min(iMapConfig.getMaxZoomLevel(), Math.max(iMapConfig.getMinZoomLevel(), min2));
        }
        return new Pair<>(Float.valueOf(min), Boolean.valueOf(z));
    }

    public static String b(Context context) {
        return FileUtil.getMapBaseStorage(context) + File.separator + "data" + File.separator;
    }

    public static String b(View view) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = sb;
        if (view != null) {
            StringBuilder sb3 = sb;
            StringBuilder sb4 = sb;
            try {
                if (view instanceof TextView) {
                    sb3 = new StringBuilder(((TextView) view).getText().toString());
                }
                StringBuilder sb5 = sb3;
                sb2 = sb3;
                if (view instanceof ViewGroup) {
                    StringBuilder sb6 = sb3;
                    int childCount = ((ViewGroup) view).getChildCount();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        sb2 = sb3;
                        if (i2 >= childCount) {
                            break;
                        }
                        sb4 = sb3;
                        String b2 = b(((ViewGroup) view).getChildAt(i2));
                        StringBuilder sb7 = sb3;
                        if (!TextUtils.isEmpty(b2)) {
                            StringBuilder sb8 = sb3;
                            sb3.append("--");
                            StringBuilder sb9 = sb3;
                            sb3.append(b2);
                        }
                        i = i2 + 1;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                sb2 = sb4;
            }
        }
        return sb2.toString();
    }

    private static boolean b(double d2, double d3, double d4, double d5, double d6, double d7) {
        return Math.abs(a(d2, d3, d4, d5, d6, d7)) < 1.0E-9d && (d2 - d4) * (d2 - d6) <= 0.0d && (d3 - d5) * (d3 - d7) <= 0.0d;
    }

    private static boolean b(List<LatLng> list, CircleHoleOptions circleHoleOptions) {
        try {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                arrayList.add(list.get(i2));
                i = i2 + 1;
            }
            arrayList.add(list.get(0));
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= arrayList.size()) {
                    return false;
                }
                int i5 = i4 + 1;
                if (i5 >= arrayList.size()) {
                    return false;
                }
                if (circleHoleOptions.getRadius() >= AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i4)) || circleHoleOptions.getRadius() >= AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i5))) {
                    return true;
                }
                arrayList2.clear();
                arrayList2.add(arrayList.get(i4));
                arrayList2.add(arrayList.get(i5));
                if (circleHoleOptions.getRadius() >= ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), SpatialRelationUtil.calShortestDistancePoint(arrayList2, circleHoleOptions.getCenter()).second))) {
                    return true;
                }
                i3 = i5;
            }
        } catch (Throwable th) {
            iw.c(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
            return false;
        }
    }

    public static boolean b(List<LatLng> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z;
        boolean z2 = false;
        int i = 0;
        if (list == null || polygonHoleOptions == null) {
            return false;
        }
        try {
            List<LatLng> points = polygonHoleOptions.getPoints();
            boolean z3 = false;
            while (true) {
                z2 = z3;
                z = z2;
                try {
                    if (i >= points.size()) {
                        break;
                    }
                    boolean a2 = a(points.get(i), list);
                    z = a2;
                    if (!a2) {
                        break;
                    }
                    i++;
                    z3 = a2;
                } catch (Throwable th) {
                    th = th;
                    iw.c(th, "PolygonDelegateImp", "isPolygonInPolygon");
                    th.printStackTrace();
                    z = z2;
                    return z;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0075, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean b(java.util.List<com.amap.api.maps.model.LatLng> r6, java.util.List<com.amap.api.maps.model.LatLng> r7) {
        /*
            r0 = 0
            r8 = r0
        L2:
            r0 = r8
            r1 = r6
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L7b
            if (r0 >= r1) goto L89
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r10 = r0
            r0 = r10
            r1 = r6
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L7b
            if (r0 >= r1) goto L89
            r0 = 0
            r9 = r0
        L1e:
            r0 = r9
            r1 = r7
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L7b
            if (r0 >= r1) goto L75
            r0 = r9
            r1 = 1
            int r0 = r0 + r1
            r11 = r0
            r0 = r11
            r1 = r7
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L7b
            if (r0 >= r1) goto L75
            r0 = r6
            r1 = r8
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L7b
            com.amap.api.maps.model.LatLng r0 = (com.amap.api.maps.model.LatLng) r0     // Catch: java.lang.Throwable -> L7b
            r1 = r6
            r2 = r10
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L7b
            com.amap.api.maps.model.LatLng r1 = (com.amap.api.maps.model.LatLng) r1     // Catch: java.lang.Throwable -> L7b
            r2 = r7
            r3 = r9
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L7b
            com.amap.api.maps.model.LatLng r2 = (com.amap.api.maps.model.LatLng) r2     // Catch: java.lang.Throwable -> L7b
            r3 = r7
            r4 = r11
            java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L7b
            com.amap.api.maps.model.LatLng r3 = (com.amap.api.maps.model.LatLng) r3     // Catch: java.lang.Throwable -> L7b
            boolean r0 = com.amap.api.col.p0003sl.dr.a(r0, r1, r2, r3)     // Catch: java.lang.Throwable -> L7b
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L6f
            r0 = r12
            return r0
        L6f:
            r0 = r11
            r9 = r0
            goto L1e
        L75:
            r0 = r10
            r8 = r0
            goto L2
        L7b:
            r6 = move-exception
            r0 = r6
            java.lang.String r1 = "Util"
            java.lang.String r2 = "isSegmentsIntersect"
            com.amap.api.col.p0003sl.iw.c(r0, r1, r2)
            r0 = r6
            r0.printStackTrace()
        L89:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.dw.b(java.util.List, java.util.List):boolean");
    }

    private static byte[] b(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                try {
                    byteArrayOutputStream2.close();
                    return byteArray;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return byteArray;
                }
            } catch (Throwable th2) {
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                        return null;
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        } catch (Throwable th4) {
            byteArrayOutputStream = null;
        }
    }

    private static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static String c(Context context) {
        String a2 = a(context);
        if (a2 == null) {
            return null;
        }
        File file = new File(a2, "VMAP2");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + File.separator;
    }

    private static void c(View view) {
        int i = 0;
        if (!(view instanceof ViewGroup)) {
            if (view instanceof TextView) {
                ((TextView) view).setHorizontallyScrolling(false);
                return;
            }
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            c(viewGroup.getChildAt(i));
            i++;
        }
    }

    public static boolean d(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || (state = activeNetworkInfo.getState()) == null || state == NetworkInfo.State.DISCONNECTED || state == NetworkInfo.State.DISCONNECTING) ? false : true;
    }

    public static boolean e(Context context) {
        File file = new File(b(context));
        if (file.exists()) {
            return FileUtil.deleteFile(file);
        }
        return true;
    }
}
