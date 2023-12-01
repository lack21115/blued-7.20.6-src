package com.soft.blued.ui.find.fragment;

import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.provider.BrowserContract;
import android.text.TextUtils;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.LocaleUtils;
import com.soft.blued.R;
import com.soft.blued.ui.find.presenter.SearchMapPresenter;
import com.soft.blued.utils.Logger;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import java.util.Locale;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/BaseSearchMapFragment.class */
public abstract class BaseSearchMapFragment extends MvpFragment<SearchMapPresenter> implements TencentLocationListener, LocationSource {

    /* renamed from: a  reason: collision with root package name */
    public TencentMap f30188a;
    public TextureMapView b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f30189c;
    public TencentLocationManager d;
    public LocationSource.OnLocationChangedListener e;

    private void d() {
        this.f30188a = this.b.getMap();
        TencentLocationManager tencentLocationManager = TencentLocationManager.getInstance(getActivity());
        this.d = tencentLocationManager;
        tencentLocationManager.setCoordinateType(1);
        this.f30188a.setLocationSource(this);
        this.f30188a.setMyLocationEnabled(true);
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.icon(BitmapDescriptorFactory.fromResource(R.drawable.my_position));
        myLocationStyle.strokeColor(Color.argb(0, 0, 0, 0));
        myLocationStyle.fillColor(Color.argb(0, 0, 0, 0));
        myLocationStyle.strokeWidth(0);
        this.f30188a.setMyLocationStyle(myLocationStyle);
        this.f30188a.getUiSettings().setMyLocationButtonEnabled(false);
        this.f30188a.getUiSettings().setZoomControlsEnabled(false);
        this.f30188a.getUiSettings().setGestureScaleByMapCenter(true);
        this.f30188a.getUiSettings().setRotateGesturesEnabled(false);
        this.f30188a.moveCamera(CameraUpdateFactory.zoomTo(16.0f));
    }

    private void e() {
        Locale c2 = LocaleUtils.c();
        if (TextUtils.equals(c2 != null ? c2.getLanguage() : "", a.V)) {
            this.f30188a.setForeignLanguage(Language.zh);
        } else {
            this.f30188a.setForeignLanguage(Language.en);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        TencentMapInitializer.setAgreePrivacy(true);
        TencentLocationManager.setUserAgreePrivacy(true);
        b(bundle);
        d();
        e();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.LocationSource
    public void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        this.e = onLocationChangedListener;
        try {
            int requestSingleFreshLocation = this.d.requestSingleFreshLocation(null, this, Looper.myLooper());
            if (requestSingleFreshLocation < 1 || requestSingleFreshLocation > 3) {
                return;
            }
            AppMethods.a((CharSequence) (getActivity().getResources().getString(R.string.location_fail_try_again) + "(" + requestSingleFreshLocation + ")"));
        } catch (Exception e) {
        }
    }

    public abstract int b();

    public void b(Bundle bundle) {
        this.b = c();
    }

    public abstract TextureMapView c();

    @Override // com.tencent.tencentmap.mapsdk.maps.LocationSource
    public void deactivate() {
        this.d = null;
        this.e = null;
        this.f30188a = null;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return b();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.b.onDestroy();
    }

    @Override // com.tencent.map.geolocation.TencentLocationListener
    public void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
        Logger.a(BrowserContract.Bookmarks.POSITION, "定位完成：" + i + "," + str);
        if (i != 0 || this.e == null) {
            return;
        }
        Location location = new Location(tencentLocation.getProvider());
        location.setLatitude(tencentLocation.getLatitude());
        location.setLongitude(tencentLocation.getLongitude());
        location.setAccuracy(tencentLocation.getAccuracy());
        this.e.onLocationChanged(location);
        this.f30189c = new LatLng(tencentLocation.getLatitude(), tencentLocation.getLongitude());
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.b.onPause();
        deactivate();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.b.onResume();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.tencent.map.geolocation.TencentLocationListener
    public void onStatusUpdate(String str, int i, String str2) {
    }
}
