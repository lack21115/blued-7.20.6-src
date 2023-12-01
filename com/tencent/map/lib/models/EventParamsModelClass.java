package com.tencent.map.lib.models;

import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/EventParamsModelClass.class */
public class EventParamsModelClass {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/EventParamsModelClass$ClickEventParams.class */
    public static class ClickEventParams extends EventParams {
        @Json(name = "clickedPosition")
        public float[] clickedPosition;
        @Json(name = "identifier")
        public String identifier;
        @Json(name = "name")
        public String name;

        public ClickEventParams(String str, LatLng latLng, String str2, String str3) {
            this.eventType = VisualLayer.OnLayerStatusChangedListener.EventType.ON_CLICK;
            this.layerId = str;
            this.clickedPosition = r0;
            float[] fArr = {(float) latLng.getLatitude()};
            this.clickedPosition[1] = (float) latLng.getLongitude();
            this.identifier = str2;
            this.name = str3;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/EventParamsModelClass$EventParams.class */
    public static class EventParams extends JsonComposer {
        @Json(name = "eventType")
        public String eventType;
        @Json(name = "layerId")
        public String layerId;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/EventParamsModelClass$LoadFinishEventParams.class */
    public static class LoadFinishEventParams extends EventParams {
        public int errorCode;
        public String errorMsg;

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/EventParamsModelClass$LoadFinishEventParams$LoadFinishInfo.class */
        public enum LoadFinishInfo {
            ok(0, ""),
            errNetwork(1, VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_NETWORK),
            errAuth(2, VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_AUTH),
            errDataDecode(3, VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_DATA_DECODE),
            errDataAvailable(4, VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_DATA_AVAILABLE),
            errInternal(20, VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_INTERNAL_ERROR);
            
            private int errorCode;
            private String errorMsg;

            LoadFinishInfo(int i, String str) {
                this.errorCode = i;
                this.errorMsg = str;
            }

            public static LoadFinishInfo getById(int i) {
                LoadFinishInfo[] values = values();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= 6) {
                        return ok;
                    }
                    LoadFinishInfo loadFinishInfo = values[i3];
                    if (loadFinishInfo.checkStatus(i)) {
                        return loadFinishInfo;
                    }
                    i2 = i3 + 1;
                }
            }

            public boolean checkStatus(int i) {
                return this.errorCode == i;
            }

            public int getErrorCode() {
                return this.errorCode;
            }

            public String getErrorMsg() {
                return this.errorMsg;
            }
        }

        public LoadFinishEventParams(String str, LoadFinishInfo loadFinishInfo) {
            this.eventType = VisualLayer.OnLayerStatusChangedListener.EventType.ON_LAYER_LOAD_FINISH;
            this.layerId = str;
            this.errorCode = loadFinishInfo.errorCode;
            this.errorMsg = loadFinishInfo.errorMsg;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/EventParamsModelClass$TranslateAnimationCompleteEventParams.class */
    public static class TranslateAnimationCompleteEventParams extends EventParams {
        public TranslateAnimationCompleteEventParams(String str) {
            this.eventType = VisualLayer.OnLayerStatusChangedListener.EventType.ON_TRANSLATEANIMATION_COMPLETE;
            this.layerId = str;
        }
    }
}
