package com.google.android.cameraview;

import android.content.Context;
import android.hardware.camera2.params.StreamConfigurationMap;
import com.google.android.cameraview.CameraViewImpl;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/cameraview/Camera2Api23.class */
class Camera2Api23 extends Camera2 {
    Camera2Api23(CameraViewImpl.Callback callback, PreviewImpl previewImpl, Context context) {
        super(callback, previewImpl, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.cameraview.Camera2
    public void collectPictureSizes(SizeMap sizeMap, StreamConfigurationMap streamConfigurationMap) {
        if (streamConfigurationMap.getHighResolutionOutputSizes(256) != null) {
            android.util.Size[] highResolutionOutputSizes = streamConfigurationMap.getHighResolutionOutputSizes(256);
            int length = highResolutionOutputSizes.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                android.util.Size size = highResolutionOutputSizes[i2];
                sizeMap.add(new Size(size.getWidth(), size.getHeight()));
                i = i2 + 1;
            }
        }
        if (sizeMap.isEmpty()) {
            super.collectPictureSizes(sizeMap, streamConfigurationMap);
        }
    }
}
