package com.qiniu.pili.droid.shortvideo;

import android.hardware.Camera;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLCameraParamSelectListener.class */
public interface PLCameraParamSelectListener {
    String onFocusModeSelected(List<String> list);

    int[] onPreviewFpsSelected(List<int[]> list);

    Camera.Size onPreviewSizeSelected(List<Camera.Size> list);
}
