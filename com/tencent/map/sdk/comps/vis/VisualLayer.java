package com.tencent.map.sdk.comps.vis;

import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Alphable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Removable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Visible;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/comps/vis/VisualLayer.class */
public interface VisualLayer extends Alphable, Levelable, Removable, Visible, VectorOverlay {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/comps/vis/VisualLayer$OnLayerStatusChangedListener.class */
    public interface OnLayerStatusChangedListener {

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/comps/vis/VisualLayer$OnLayerStatusChangedListener$EventType.class */
        public @interface EventType {
            public static final String ON_CLICK = "onClickEvent";
            public static final String ON_LAYER_LOAD_FINISH = "onLayerLoadFinishEvent";
            public static final String ON_TRANSLATEANIMATION_COMPLETE = "onTranslateAnimationCompleteEvent";
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/comps/vis/VisualLayer$OnLayerStatusChangedListener$LayerStatus.class */
        public @interface LayerStatus {
            public static final int ERR_AUTH = 2;
            public static final int ERR_DATA_AVAILABLE = 4;
            public static final int ERR_DATA_DECODE = 3;
            public static final int ERR_INTERNAL_ERROR = 20;
            public static final int ERR_NETWORK = 1;
            public static final int OK = 0;
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/comps/vis/VisualLayer$OnLayerStatusChangedListener$LayerStatusMsg.class */
        public @interface LayerStatusMsg {
            public static final String MSG_ERR_AUTH = "authentication error";
            public static final String MSG_ERR_DATA_AVAILABLE = "data check available error";
            public static final String MSG_ERR_DATA_DECODE = "data protocol decode error";
            public static final String MSG_ERR_INTERNAL_ERROR = "internal error";
            public static final String MSG_ERR_NETWORK = "network error";
            public static final String MSG_OK = "";
        }

        boolean onEvent(VisualLayer visualLayer, String str, String str2);

        void onLayerLoadFinish(int i);
    }

    void addLayerStatusChangedListener(OnLayerStatusChangedListener onLayerStatusChangedListener);

    void clearCache();

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    void enableClick(boolean z);

    String executeCommand(TencentMap tencentMap, String str);

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    boolean isClickEnabled();

    void removeLayerStatusChangedListener(OnLayerStatusChangedListener onLayerStatusChangedListener);

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    void setLevel(int i);

    void setTimeInterval(int i);
}
