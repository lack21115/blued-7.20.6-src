package com.tencent.map.lib.models;

import android.os.BatteryManager;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngListDeserializer;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommonParamsModelClass.class */
public class CommonParamsModelClass {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommonParamsModelClass$AnimationInfo.class */
    public static class AnimationInfo extends JsonComposer {
        @Json(name = "duration")
        public float duration;
        @Json(name = "index")
        public int index;
        @Json(name = "name")
        public String name;

        public AnimationInfo(int i, String str, float f) {
            this.index = i;
            this.name = str;
            this.duration = f;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommonParamsModelClass$EnableClickParams.class */
    public static class EnableClickParams extends JsonComposer {
        @Json(name = "enabled")
        public boolean enabled;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommonParamsModelClass$ExposureParams.class */
    public static class ExposureParams extends JsonComposer {
        @Json(name = "exposure")
        public float exposure;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommonParamsModelClass$PixelBoundParams.class */
    public static class PixelBoundParams extends JsonComposer {
        @Json(name = "height")
        public int height;
        @Json(name = "width")
        public int width;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommonParamsModelClass$PlaySkeletonAnimationParams.class */
    public static class PlaySkeletonAnimationParams extends JsonComposer {
        @Json(name = "index")
        public int index;
        @Json(name = "repeat")
        public boolean repeat;
        @Json(name = "speed")
        public float speed;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommonParamsModelClass$PositionParams.class */
    public static class PositionParams extends JsonComposer {
        @Json(name = "altitude")
        public double altitude;
        @Json(name = "lat")
        public double lat;
        @Json(name = "lng")
        public double lng;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommonParamsModelClass$RotationParams.class */
    public static class RotationParams extends JsonComposer {
        @Json(name = "rotationX")
        public float rotationX;
        @Json(name = "rotationY")
        public float rotationY;
        @Json(name = "rotationZ")
        public float rotationZ;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommonParamsModelClass$ScaleParams.class */
    public static class ScaleParams extends JsonComposer {
        @Json(name = BatteryManager.EXTRA_SCALE)
        public float scale;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommonParamsModelClass$StartTranslateAnimationParams.class */
    public static class StartTranslateAnimationParams extends JsonComposer {
        @Json(name = "duration")
        public float duration;
        @Json(name = "initRotation")
        public float initRotation;
        @Json(name = "needRotate")
        public boolean needRotate;
        @Json(deserializer = LatLngListDeserializer.class, name = "positions")
        public List<LatLng> positions;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommonParamsModelClass$VisibleParams.class */
    public static class VisibleParams extends JsonComposer {
        @Json(name = "isVisible")
        public boolean isVisible;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommonParamsModelClass$ZoomLevelRangeParams.class */
    public static class ZoomLevelRangeParams extends JsonComposer {
        @Json(name = "maxLevel")
        public int maxLevel;
        @Json(name = "minLevel")
        public int minLevel;
    }
}
