package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.mapsdk.internal.h1;
import com.tencent.mapsdk.internal.hj;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/a1.class */
public interface a1 extends MapDelegate<rc, VectorMap, x1>, hj.n, me, v4, TencentMap.OnIndoorStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public static final int f37284a = 0;
    public static final int b = 1;

    rc A();

    @Deprecated
    boolean B();

    int C();

    boolean D();

    void E();

    ViewGroup F();

    boolean G();

    int H();

    String I();

    CameraPosition J();

    void K();

    boolean M();

    void N();

    boolean O();

    ze a(String str);

    void a();

    void a(int i, int i2);

    void a(Context context, TencentMapOptions tencentMapOptions);

    void a(Handler handler, Bitmap.Config config, int i);

    void a(c1 c1Var);

    void a(c5 c5Var);

    void a(de deVar);

    void a(eg egVar);

    void a(h1.g gVar);

    void a(i5 i5Var);

    void a(qh qhVar);

    void a(w4 w4Var);

    void a(yd ydVar, ib ibVar);

    void a(TencentMap.OnCameraChangeListener onCameraChangeListener);

    void a(TencentMap.OnDismissCallback onDismissCallback);

    void a(TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener);

    void a(TencentMap.OnMapPoiClickListener onMapPoiClickListener);

    void a(OverSeaTileProvider overSeaTileProvider);

    void a(TencentMapGestureListener tencentMapGestureListener);

    void a(String str, boolean z);

    void a(String str, boolean z, boolean z2);

    void a(boolean z);

    boolean a(float f, float f2);

    void b(float f);

    void b(int i, int i2);

    void b(c5 c5Var);

    void b(w4 w4Var);

    void b(TencentMapGestureListener tencentMapGestureListener);

    void b(boolean z);

    boolean b();

    boolean b(float f, float f2);

    boolean b(int i);

    boolean b(String str);

    GeoPoint c();

    String c(float f, float f2);

    void c(float f);

    void c(int i, int i2);

    void c(boolean z);

    vf d();

    void d(boolean z);

    boolean d(float f, float f2);

    void e();

    void e(boolean z);

    boolean e(float f, float f2);

    void f(boolean z);

    boolean f();

    boolean f(float f, float f2);

    void g();

    void g(boolean z);

    Context getContext();

    @Override // com.tencent.mapsdk.internal.me
    int getEGLContextHash();

    void h();

    void h(boolean z);

    b0 i();

    void i(boolean z);

    boolean isHandDrawMapEnable();

    void j(boolean z);

    eg k();

    TencentMapOptions l();

    boolean m();

    int n();

    yd o();

    void p();

    int q();

    boolean r();

    boolean s();

    void setCompassExtraPadding(int i);

    void setCompassExtraPadding(int i, int i2);

    void setFlingGestureEnabled(boolean z);

    void setMapCenterAndScale(float f, float f2, float f3);

    void setOnTapMapViewInfoWindowHidden(boolean z);

    void t();

    vh u();

    boolean v();

    qc w();

    void y();
}
