package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/MapRenderLayer.class */
public class MapRenderLayer extends MapView {
    public MapRenderLayer(Context context, TencentMapOptions tencentMapOptions) {
        super(context, tencentMapOptions);
        onResume();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public final MapViewType getViewType() {
        return MapViewType.RenderLayer;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.MapView
    public final void onSurfaceChanged(Object obj, int i, int i2) {
        if ((obj instanceof Surface) || (obj instanceof SurfaceTexture) || (obj instanceof SurfaceHolder)) {
            super.onSurfaceChanged(obj, i, i2);
        }
    }
}
