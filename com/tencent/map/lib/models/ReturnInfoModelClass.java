package com.tencent.map.lib.models;

import com.baidu.mobads.sdk.internal.bw;
import com.tencent.map.lib.models.CommonParamsModelClass;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/ReturnInfoModelClass.class */
public class ReturnInfoModelClass {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/ReturnInfoModelClass$BaseBooleanReturnInfo.class */
    public static class BaseBooleanReturnInfo extends ReturnStatus {
        public boolean value;

        public BaseBooleanReturnInfo(boolean z) {
            this.status = bw.o;
            this.value = z;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/ReturnInfoModelClass$BaseFloatReturnInfo.class */
    public static class BaseFloatReturnInfo extends ReturnStatus {
        public float value;

        public BaseFloatReturnInfo(float f) {
            this.status = bw.o;
            this.value = f;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/ReturnInfoModelClass$BaseIntReturnInfo.class */
    public static class BaseIntReturnInfo extends ReturnStatus {
        public int value;

        public BaseIntReturnInfo(int i) {
            this.status = bw.o;
            this.value = i;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/ReturnInfoModelClass$BaseStringReturnInfo.class */
    public static class BaseStringReturnInfo extends ReturnStatus {
        public String value;

        public BaseStringReturnInfo(String str) {
            this.status = bw.o;
            this.value = str;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/ReturnInfoModelClass$ErrorReturnInfo.class */
    public static class ErrorReturnInfo extends ReturnStatus {
        public int errorCode;
        public String errorMsg;

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/ReturnInfoModelClass$ErrorReturnInfo$ErrorMsg.class */
        public enum ErrorMsg {
            success(0, "none"),
            jsonparse(1, "json parse error"),
            unsupported(2, "unsupported function"),
            internal(3, VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_INTERNAL_ERROR);
            
            private int errorCode;
            private String errorMsg;

            ErrorMsg(int i, String str) {
                this.errorCode = i;
                this.errorMsg = str;
            }

            public int getErrorCode() {
                return this.errorCode;
            }

            public String getErrorMsg() {
                return this.errorMsg;
            }
        }

        public ErrorReturnInfo(ErrorMsg errorMsg) {
            this.status = "failed";
            this.errorCode = errorMsg.getErrorCode();
            this.errorMsg = errorMsg.getErrorMsg();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/ReturnInfoModelClass$PositionReturnInfo.class */
    public static class PositionReturnInfo extends ReturnStatus {
        public CommonParamsModelClass.PositionParams value;

        public PositionReturnInfo(LatLng latLng) {
            CommonParamsModelClass.PositionParams positionParams = new CommonParamsModelClass.PositionParams();
            this.value = positionParams;
            positionParams.lat = latLng.latitude;
            positionParams.lng = latLng.longitude;
            positionParams.altitude = latLng.altitude;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/ReturnInfoModelClass$ReturnStatus.class */
    public static class ReturnStatus extends JsonComposer {
        public String status = bw.o;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/ReturnInfoModelClass$RotationReturnInfo.class */
    public static class RotationReturnInfo extends ReturnStatus {
        public CommonParamsModelClass.RotationParams value;

        public RotationReturnInfo(float f, float f2, float f3) {
            CommonParamsModelClass.RotationParams rotationParams = new CommonParamsModelClass.RotationParams();
            this.value = rotationParams;
            rotationParams.rotationX = f;
            rotationParams.rotationY = f2;
            rotationParams.rotationZ = f3;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/ReturnInfoModelClass$SkeletonAnimationReturnInfo.class */
    public static class SkeletonAnimationReturnInfo extends ReturnStatus {
        public List<CommonParamsModelClass.AnimationInfo> animationInfo;

        public SkeletonAnimationReturnInfo(List<CommonParamsModelClass.AnimationInfo> list) {
            this.animationInfo = new ArrayList();
            if (list != null) {
                this.animationInfo = list;
            }
        }
    }
}
