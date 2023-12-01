package com.tencent.map.lib.models;

import com.tencent.map.lib.models.CommonParamsModelClass;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass.class */
public class CommandFunctionModelClass {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$BaseCommandFunction.class */
    public static class BaseCommandFunction extends JsonComposer {
        @Json(name = "function")
        public String commandFunction;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$EnableClickCommand.class */
    public static class EnableClickCommand extends BaseCommandFunction {
        @Json(name = "params")
        public CommonParamsModelClass.EnableClickParams params;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$ErrorCommandFunction.class */
    public static class ErrorCommandFunction extends BaseCommandFunction {
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$GetClickEnabledCommand.class */
    public static class GetClickEnabledCommand extends BaseCommandFunction {
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$GetExposureCommand.class */
    public static class GetExposureCommand extends BaseCommandFunction {
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$GetPositionCommand.class */
    public static class GetPositionCommand extends BaseCommandFunction {
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$GetRotationCommand.class */
    public static class GetRotationCommand extends BaseCommandFunction {
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$GetScaleCommand.class */
    public static class GetScaleCommand extends BaseCommandFunction {
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$GetSkeletonAnimationInfoCommand.class */
    public static class GetSkeletonAnimationInfoCommand extends BaseCommandFunction {
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$GetTypeCommand.class */
    public static class GetTypeCommand extends BaseCommandFunction {
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$GetVisibleCommand.class */
    public static class GetVisibleCommand extends BaseCommandFunction {
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$PlaySkeletonAnimationCommand.class */
    public static class PlaySkeletonAnimationCommand extends BaseCommandFunction {
        @Json(name = "params")
        public CommonParamsModelClass.PlaySkeletonAnimationParams params;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$SetExposureCommand.class */
    public static class SetExposureCommand extends BaseCommandFunction {
        @Json(name = "params")
        public CommonParamsModelClass.ExposureParams params;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$SetPixelBoundCommand.class */
    public static class SetPixelBoundCommand extends BaseCommandFunction {
        @Json(name = "params")
        public CommonParamsModelClass.PixelBoundParams params;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$SetPositionCommand.class */
    public static class SetPositionCommand extends BaseCommandFunction {
        @Json(name = "params")
        public CommonParamsModelClass.PositionParams params;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$SetRotationCommand.class */
    public static class SetRotationCommand extends BaseCommandFunction {
        @Json(name = "params")
        public CommonParamsModelClass.RotationParams params;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$SetScaleCommand.class */
    public static class SetScaleCommand extends BaseCommandFunction {
        @Json(name = "params")
        public CommonParamsModelClass.ScaleParams params;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$SetVisibleCommand.class */
    public static class SetVisibleCommand extends BaseCommandFunction {
        @Json(name = "params")
        public CommonParamsModelClass.VisibleParams params;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$SetZoomLevelRangeCommand.class */
    public static class SetZoomLevelRangeCommand extends BaseCommandFunction {
        @Json(name = "params")
        public CommonParamsModelClass.ZoomLevelRangeParams params;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$StartTranslateAnimationCommand.class */
    public static class StartTranslateAnimationCommand extends BaseCommandFunction {
        @Json(name = "params")
        public CommonParamsModelClass.StartTranslateAnimationParams params;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/CommandFunctionModelClass$StopSkeletonAnimationCommand.class */
    public static class StopSkeletonAnimationCommand extends BaseCommandFunction {
    }
}
