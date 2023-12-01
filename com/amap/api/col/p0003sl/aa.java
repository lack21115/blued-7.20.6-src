package com.amap.api.col.p0003sl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

/* renamed from: com.amap.api.col.3sl.aa  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/aa.class */
public final class aa implements IMapFragmentDelegate {
    public static volatile Context a;
    private static String f;
    public int b = 0;
    boolean c = true;
    private IAMap d;
    private int e;
    private AMapOptions g;

    public aa(int i) {
        this.e = 0;
        this.e = i % 3;
        b();
    }

    private static void a() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int i = 0;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            while (i < stackTrace.length) {
                boolean z4 = z2;
                if (stackTrace[i].getClassName() != null) {
                    z4 = z2;
                    if (stackTrace[i].getClassName().endsWith("TextureMapView")) {
                        z4 = true;
                    }
                }
                boolean z5 = z;
                if (stackTrace[i].getClassName() != null) {
                    z5 = z;
                    if (stackTrace[i].getClassName().endsWith("Fragment")) {
                        z5 = true;
                    }
                }
                if ("OnDestroyView".equalsIgnoreCase(stackTrace[i].getMethodName())) {
                    z3 = true;
                }
                i++;
                z = z5;
                z2 = z4;
            }
            if (z && z2 && !z3) {
                c();
            }
        } catch (Throwable th) {
        }
    }

    private static void a(Context context) {
        if (context != null) {
            a = context.getApplicationContext();
        }
    }

    private void a(AMapOptions aMapOptions) throws RemoteException {
        if (aMapOptions == null || this.d == null) {
            return;
        }
        CameraPosition camera = aMapOptions.getCamera();
        if (camera != null) {
            this.d.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
        }
        UiSettings aMapUiSettings = this.d.getAMapUiSettings();
        aMapUiSettings.setRotateGesturesEnabled(aMapOptions.getRotateGesturesEnabled());
        aMapUiSettings.setScrollGesturesEnabled(aMapOptions.getScrollGesturesEnabled());
        aMapUiSettings.setTiltGesturesEnabled(aMapOptions.getTiltGesturesEnabled());
        aMapUiSettings.setZoomControlsEnabled(aMapOptions.getZoomControlsEnabled());
        aMapUiSettings.setZoomGesturesEnabled(aMapOptions.getZoomGesturesEnabled());
        aMapUiSettings.setCompassEnabled(aMapOptions.getCompassEnabled());
        aMapUiSettings.setScaleControlsEnabled(aMapOptions.getScaleControlsEnabled());
        aMapUiSettings.setLogoPosition(aMapOptions.getLogoPosition());
        this.d.setMapType(aMapOptions.getMapType());
        this.d.setZOrderOnTop(aMapOptions.getZOrderOnTop());
    }

    private static void b() {
        try {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 80) {
                    f = sb.toString();
                    return;
                } else {
                    sb.append("=");
                    i = i2 + 1;
                }
            }
        } catch (Throwable th) {
        }
    }

    private static void c() {
        Log.i("errorLog", f);
        Log.i("errorLog", "OnDestroy 方法需要在OnDestroyView中调用");
        Log.i("errorLog", f);
    }

    public final IAMap getMap() throws RemoteException {
        if (this.d == null) {
            if (a == null) {
                Log.w("MapFragmentDelegateImp", "Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
                return null;
            }
            int i = a.getResources().getDisplayMetrics().densityDpi;
            if (i <= 120) {
                w.a = 0.5f;
            } else if (i <= 160) {
                w.a = 0.8f;
            } else if (i <= 240) {
                w.a = 0.87f;
            } else if (i <= 320) {
                w.a = 1.0f;
            } else if (i <= 480) {
                w.a = 1.5f;
            } else if (i <= 640) {
                w.a = 1.8f;
            } else {
                w.a = 0.9f;
            }
            int i2 = this.e;
            if (i2 == 0) {
                this.d = new n(a, this.c).a();
            } else if (i2 == 1) {
                this.d = new o(a, this.c).a();
            } else {
                this.d = new m(a).a();
            }
        }
        return this.d;
    }

    public final boolean isReady() throws RemoteException {
        return false;
    }

    public final void loadWorldVectorMap(boolean z) {
        this.c = z;
        IAMap iAMap = this.d;
        if (iAMap != null) {
            iAMap.loadWorldVectorMap(z);
        }
    }

    public final void onCreate(Bundle bundle) throws RemoteException {
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException {
        byte[] byteArray;
        if (a == null && layoutInflater != null) {
            setContext(layoutInflater.getContext().getApplicationContext());
        }
        try {
            IAMap map = getMap();
            this.d = map;
            map.setVisibilityEx(this.b);
            if (this.g == null && bundle != null && (byteArray = bundle.getByteArray("MAP_OPTIONS")) != null) {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.g = AMapOptions.CREATOR.createFromParcel(obtain);
            }
            a(this.g);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.d.getView();
    }

    public final void onDestroy() throws RemoteException {
        a();
        IAMap iAMap = this.d;
        if (iAMap != null) {
            iAMap.clear();
            this.d.destroy();
            this.d = null;
        }
    }

    public final void onDestroyView() throws RemoteException {
    }

    public final void onInflate(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException {
        setContext(activity.getApplicationContext());
        this.g = aMapOptions;
    }

    public final void onLowMemory() throws RemoteException {
        Log.d("onLowMemory", "onLowMemory run");
    }

    public final void onPause() throws RemoteException {
        IAMap iAMap = this.d;
        if (iAMap != null) {
            iAMap.onActivityPause();
        }
    }

    public final void onResume() throws RemoteException {
        IAMap iAMap = this.d;
        if (iAMap != null) {
            iAMap.onActivityResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        if (this.d != null) {
            if (this.g == null) {
                this.g = new AMapOptions();
            }
            try {
                Parcel obtain = Parcel.obtain();
                AMapOptions camera = this.g.camera(getMap().getCameraPosition());
                this.g = camera;
                camera.writeToParcel(obtain, 0);
                bundle.putByteArray("MAP_OPTIONS", obtain.marshall());
            } catch (Throwable th) {
            }
        }
    }

    public final void setContext(Context context) {
        a(context);
    }

    public final void setOptions(AMapOptions aMapOptions) {
        this.g = aMapOptions;
    }

    public final void setVisibility(int i) {
        this.b = i;
        IAMap iAMap = this.d;
        if (iAMap != null) {
            iAMap.setVisibilityEx(i);
        }
    }
}
