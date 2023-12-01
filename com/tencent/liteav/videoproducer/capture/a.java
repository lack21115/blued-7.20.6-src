package com.tencent.liteav.videoproducer.capture;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/a.class */
public final class a {
    public static int a() {
        CameraManager cameraManager = (CameraManager) ContextUtils.getApplicationContext().getSystemService("camera");
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            if (cameraIdList.length > 0) {
                int i = -1;
                for (String str : cameraIdList) {
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                    Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                    if (num == null || num.intValue() == 0 || num.intValue() == 1) {
                        Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                        if (num2 == null) {
                            return -1;
                        }
                        i = num2.intValue();
                    }
                }
                return i;
            }
            return -1;
        } catch (Exception e) {
            LiteavLog.e("CameraAbilityProvider", "getCamera2SupportLevel exception:".concat(String.valueOf(e)));
            return -1;
        }
    }
}
