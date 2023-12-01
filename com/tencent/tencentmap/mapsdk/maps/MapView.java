package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import com.tencent.map.tools.Callback;
import com.tencent.mapsdk.internal.mi;
import com.tencent.mapsdk.internal.t;
import com.tencent.mapsdk.internal.u;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/MapView.class */
public class MapView extends BaseMapView {
    private TencentMap mMap;
    public BaseMapView.MapViewProxy mMapDelegate;
    private TencentMapOptions mMapOptions;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/MapView$a.class */
    public class a implements Callback<BaseMapView.MapViewProxy> {
        public final /* synthetic */ Callback b;

        public a(Callback callback) {
            this.b = callback;
        }

        @Override // com.tencent.map.tools.Callback
        /* renamed from: a */
        public void callback(BaseMapView.MapViewProxy mapViewProxy) {
            MapView.this.mMapDelegate = mapViewProxy;
            if (mapViewProxy != null) {
                mapViewProxy.onResume();
                this.b.callback(mapViewProxy.getMap());
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/MapView$b.class */
    public class b implements Callback<TencentMap> {
        public final /* synthetic */ Callback b;

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/MapView$b$a.class */
        public class a implements TencentMap.OnMapLoadedCallback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TencentMap f25287a;

            public a(TencentMap tencentMap) {
                this.f25287a = tencentMap;
            }

            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback
            public void onMapLoaded() {
                Callback callback = b.this.b;
                if (callback != null) {
                    callback.callback(this.f25287a);
                }
                this.f25287a.removeOnMapLoadedCallback(this);
            }
        }

        public b(Callback callback) {
            this.b = callback;
        }

        @Override // com.tencent.map.tools.Callback
        /* renamed from: a */
        public void callback(TencentMap tencentMap) {
            tencentMap.addOnMapLoadedCallback(new a(tencentMap));
        }
    }

    static {
        System.loadLibrary(mi.f23958a);
    }

    public MapView(Context context) {
        this(context, new TencentMapOptions());
    }

    public MapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, new TencentMapOptions());
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, new TencentMapOptions());
    }

    public MapView(Context context, AttributeSet attributeSet, int i, TencentMapOptions tencentMapOptions) {
        super(context, attributeSet, i);
        this.mMap = getMap(tencentMapOptions);
    }

    public MapView(Context context, AttributeSet attributeSet, TencentMapOptions tencentMapOptions) {
        this(context, attributeSet, 0, tencentMapOptions);
    }

    public MapView(Context context, TencentMapOptions tencentMapOptions) {
        super(context);
        this.mMap = getMap(tencentMapOptions);
    }

    private <T extends TencentMap> void getMapSync(TencentMapOptions tencentMapOptions, Callback<T> callback) {
        tencentMapOptions.setGetMapAsync(new b(callback));
        initMap(tencentMapOptions);
    }

    private void initMap(TencentMapOptions tencentMapOptions) {
        BaseMapView.MapViewProxy mapViewProxy;
        TencentMapOptions tencentMapOptions2;
        if (this.mMap == null || !((tencentMapOptions2 = this.mMapOptions) == tencentMapOptions || tencentMapOptions2.equals(tencentMapOptions))) {
            TencentMapOptions tencentMapOptions3 = tencentMapOptions;
            if (tencentMapOptions == null) {
                tencentMapOptions3 = new TencentMapOptions();
            }
            if (tencentMapOptions3.getMapViewType() == null) {
                tencentMapOptions3.setMapViewType(getViewType());
            }
            if (tencentMapOptions3.getMapKernel() == null) {
                tencentMapOptions3.setMapKernel(getMapKernel());
            }
            setClickable(true);
            if (this.mMap != null && (mapViewProxy = this.mMapDelegate) != null) {
                mapViewProxy.onPause();
                this.mMapDelegate.onStop();
                this.mMapDelegate.onDestroy();
                this.mMapDelegate = null;
                this.mMap = null;
            }
            Callback<TencentMap> mapAsyncCallback = tencentMapOptions3.getMapAsyncCallback();
            if (this.mMapDelegate == null) {
                t tVar = new t(getContext().getApplicationContext());
                if (mapAsyncCallback != null) {
                    tVar.a(this, tencentMapOptions3, new a(mapAsyncCallback));
                } else {
                    this.mMapDelegate = tVar.a(this, tencentMapOptions3);
                }
            }
            this.mMapOptions = tencentMapOptions3;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        BaseMapView.MapViewProxy mapViewProxy;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (dispatchTouchEvent || (mapViewProxy = this.mMapDelegate) == null || !mapViewProxy.isTouchable()) {
            return dispatchTouchEvent;
        }
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(this.mMapOptions.isDisallowInterceptTouchEvent());
        }
        return this.mMapDelegate.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public TencentMap getMap() {
        TencentMap tencentMap = this.mMap;
        return tencentMap != null ? tencentMap : getMap(this.mMapOptions);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public TencentMap getMap(TencentMapOptions tencentMapOptions) {
        if (TencentMapInitializer.getAgreePrivacy()) {
            initMap(tencentMapOptions);
            BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
            if (mapViewProxy != null) {
                return mapViewProxy.getMap();
            }
            return null;
        }
        return null;
    }

    public int[] getMapPadding() {
        return new int[]{getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()};
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public void onDestroy() {
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            mapViewProxy.onDestroy();
            this.mMapDelegate = null;
        }
        this.mMapOptions = null;
        this.mMap = null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public void onPause() {
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            mapViewProxy.onPause();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public void onRestart() {
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            mapViewProxy.onRestart();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public void onResume() {
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            mapViewProxy.onResume();
        }
        u.d().onResumeReport();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            mapViewProxy.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public void onStart() {
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            mapViewProxy.onStart();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public void onStop() {
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            mapViewProxy.onStop();
        }
        u.d().close();
    }

    public void onSurfaceChanged(Object obj, int i, int i2) {
        BaseMapView.MapViewProxy mapViewProxy;
        if (((obj instanceof Surface) || (obj instanceof SurfaceTexture) || (obj instanceof SurfaceHolder)) && (mapViewProxy = this.mMapDelegate) != null) {
            mapViewProxy.onSurfaceChanged(obj, i, i2);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void setMapPadding(int i, int i2, int i3, int i4) {
        setPadding(i, i2, i3, i4);
    }

    public void setOnTop(boolean z) {
        BaseMapView.MapViewProxy mapViewProxy = this.mMapDelegate;
        if (mapViewProxy != null) {
            mapViewProxy.setOnTop(z);
        }
    }
}
