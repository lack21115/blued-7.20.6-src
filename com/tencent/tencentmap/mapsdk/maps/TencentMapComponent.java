package com.tencent.tencentmap.mapsdk.maps;

import com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.IAlphaAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimationSet;
import com.tencent.tencentmap.mapsdk.maps.model.IEmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IRotateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IScaleAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.ITranslateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/TencentMapComponent.class */
public interface TencentMapComponent {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/TencentMapComponent$Component.class */
    public interface Component {
    }

    IAlphaAnimation createAlphaAnimation(float f, float f2);

    IAnimationSet createAnimationSet(boolean z);

    IEmergeAnimation createEmergeAnimation(LatLng latLng);

    HeatMapTileProvider createHeatMapTileProvider(HeatMapTileProvider.Builder builder);

    IRotateAnimation createRotateAnimation(float f, float f2, float f3, float f4, float f5);

    IScaleAnimation createScaleAnimation(float f, float f2, float f3, float f4);

    ITranslateAnimation createTranslateAnimation(LatLng latLng);

    <T extends Component> T getMapComponent(Class<T> cls);

    TencentMapServiceProtocol getMapServiceProtocol();
}
