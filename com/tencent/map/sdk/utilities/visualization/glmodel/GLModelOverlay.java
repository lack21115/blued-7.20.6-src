package com.tencent.map.sdk.utilities.visualization.glmodel;

import com.tencent.map.lib.models.CommonParamsModelClass;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimatorModel;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/visualization/glmodel/GLModelOverlay.class */
public interface GLModelOverlay extends IAnimatorModel, VectorOverlay {
    List<CommonParamsModelClass.AnimationInfo> getSkeletonAnimationProperties();

    void playSkeletonAnimation(int i, float f, boolean z);

    void stopSkeletonAnimation();
}
