package com.tencent.map.sdk.utilities.visualization.aggregation;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/aggregation/AggregationOverlay.class */
public interface AggregationOverlay extends VectorOverlay {
    VectorHeatAggregationUnit getUnit(LatLng latLng);
}
