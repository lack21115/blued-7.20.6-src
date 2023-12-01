package com.tencent.mapsdk.core;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mapsdk.internal.e7;
import com.tencent.mapsdk.internal.s;
import com.tencent.mapsdk.internal.u;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/MapDelegateFactoryImpl.class */
public class MapDelegateFactoryImpl implements s {
    @Override // com.tencent.mapsdk.internal.s
    public MapDelegate createDelegate(Context context, TencentMapOptions tencentMapOptions, ViewGroup viewGroup) {
        TencentMapOptions.IMapKernel mapKernel = tencentMapOptions.getMapKernel();
        Class<?> a2 = e7.a("com.tencent.mapsdk.navi.MapKernelNavi", mapKernel.getClass().getClassLoader());
        Class<?> a3 = e7.a("com.tencent.mapsdk.compat.MapKernelCompat", mapKernel.getClass().getClassLoader());
        MapDelegate mapDelegate = (a3 == null || a3 != mapKernel.getClass()) ? (a2 == null || a2 != mapKernel.getClass()) ? (MapDelegate) e7.a(e7.a("com.tencent.mapsdk.vector.VectorMapDelegateProxy", MapDelegate.class, u.d().b()), context, tencentMapOptions, viewGroup) : (MapDelegate) e7.a(e7.a("com.tencent.mapsdk.navi.VectorMapNaviDelegateProxy", MapDelegate.class, u.d().b()), context, tencentMapOptions, viewGroup) : (MapDelegate) e7.a(e7.a("com.tencent.mapsdk.compat.VectorMapCompatDelegateProxy", MapDelegate.class, u.d().b()), context, tencentMapOptions, viewGroup);
        if (mapDelegate != null) {
            mapDelegate.onCreated();
        }
        return mapDelegate;
    }
}
