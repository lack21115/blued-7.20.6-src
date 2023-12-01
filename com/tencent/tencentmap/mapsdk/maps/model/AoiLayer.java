package com.tencent.tencentmap.mapsdk.maps.model;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/AoiLayer.class */
public interface AoiLayer extends IOverlay {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/AoiLayer$OnAoiLayerLoadListener.class */
    public interface OnAoiLayerLoadListener {
        void onAoiLayerLoaded(boolean z, AoiLayer aoiLayer);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    String getId();

    LatLng location();

    String name();

    boolean remove();
}
