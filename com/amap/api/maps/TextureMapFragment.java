package com.amap.api.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcel;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.col.p0003sl.aa;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/TextureMapFragment.class */
public class TextureMapFragment extends Fragment implements BaseMapView {
    private AMap aMap;
    private IMapFragmentDelegate mapFragmentDelegate;

    public static TextureMapFragment newInstance() {
        return newInstance(new AMapOptions());
    }

    public static TextureMapFragment newInstance(AMapOptions aMapOptions) {
        TextureMapFragment textureMapFragment = new TextureMapFragment();
        Bundle bundle = new Bundle();
        try {
            Parcel obtain = Parcel.obtain();
            aMapOptions.writeToParcel(obtain, 0);
            bundle.putByteArray("MAP_OPTIONS", obtain.marshall());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        textureMapFragment.setArguments(bundle);
        return textureMapFragment;
    }

    public AMap getMap() {
        IMapFragmentDelegate mapFragmentDelegate = getMapFragmentDelegate();
        if (mapFragmentDelegate == null) {
            return null;
        }
        try {
            IAMap map = mapFragmentDelegate.getMap();
            if (map == null) {
                return null;
            }
            if (this.aMap == null) {
                this.aMap = new AMap(map);
            }
            return this.aMap;
        } catch (Throwable th) {
            return null;
        }
    }

    protected IMapFragmentDelegate getMapFragmentDelegate() {
        IMapFragmentDelegate iMapFragmentDelegate = this.mapFragmentDelegate;
        if (iMapFragmentDelegate == null && iMapFragmentDelegate == null) {
            aa aaVar = new aa(1);
            this.mapFragmentDelegate = aaVar;
            aaVar.setContext(getActivity());
        }
        return this.mapFragmentDelegate;
    }

    @Override // com.amap.api.maps.BaseMapView
    public void loadWorldVectorMap(boolean z) {
        try {
            getMapFragmentDelegate().loadWorldVectorMap(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            getMapFragmentDelegate().onCreate(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2 = bundle;
        if (bundle == null) {
            try {
                bundle2 = getArguments();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return getMapFragmentDelegate().onCreateView(layoutInflater, viewGroup, bundle2);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        try {
            getMapFragmentDelegate().onDestroy();
            this.aMap = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        try {
            getMapFragmentDelegate().onDestroyView();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        Tracker.onHiddenChanged(this, z);
        super.onHiddenChanged(z);
    }

    @Override // android.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        try {
            getMapFragmentDelegate().onInflate(activity, new AMapOptions(), bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        Tracker.onPause(this);
        super.onPause();
        try {
            getMapFragmentDelegate().onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        Tracker.onResume(this);
        super.onResume();
        try {
            getMapFragmentDelegate().onResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate().onSaveInstanceState(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Fragment
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Tracker.setUserVisibleHint(this, z);
        if (z) {
            getMapFragmentDelegate().setVisibility(0);
        } else {
            getMapFragmentDelegate().setVisibility(8);
        }
    }
}
