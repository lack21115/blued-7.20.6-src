package com.sobot.chat.camera.util;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.WindowManager;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/util/CameraParamUtil.class */
public class CameraParamUtil {
    private static final String TAG = "JCameraView";
    private static CameraParamUtil cameraParamUtil;
    private CameraSizeComparator sizeComparator = new CameraSizeComparator();

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/util/CameraParamUtil$CameraSizeComparator.class */
    class CameraSizeComparator implements Comparator<Camera.Size> {
        private CameraSizeComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Camera.Size size, Camera.Size size2) {
            if (size.width != size2.width) {
                return size.width > size2.width ? 1 : -1;
            } else if (size.height == size2.height) {
                return 0;
            } else {
                return size.height > size2.height ? 1 : -1;
            }
        }
    }

    private CameraParamUtil() {
    }

    private boolean equalRate(Camera.Size size, float f) {
        return ((double) Math.abs((((float) size.width) / ((float) size.height)) - f)) <= 0.2d;
    }

    private Camera.Size getBestSize(List<Camera.Size> list, float f) {
        int i = 0;
        int i2 = 0;
        float f2 = 100.0f;
        while (true) {
            float f3 = f2;
            if (i >= list.size()) {
                return list.get(i2);
            }
            Camera.Size size = list.get(i);
            float f4 = f - (size.width / size.height);
            float f5 = f3;
            if (Math.abs(f4) < f3) {
                f5 = Math.abs(f4);
                i2 = i;
            }
            i++;
            f2 = f5;
        }
    }

    public static CameraParamUtil getInstance() {
        CameraParamUtil cameraParamUtil2 = cameraParamUtil;
        CameraParamUtil cameraParamUtil3 = cameraParamUtil2;
        if (cameraParamUtil2 == null) {
            cameraParamUtil3 = new CameraParamUtil();
            cameraParamUtil = cameraParamUtil3;
        }
        return cameraParamUtil3;
    }

    public int getCameraDisplayOrientation(Context context, int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        try {
            Camera.getCameraInfo(i, cameraInfo);
        } catch (Exception e) {
        }
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int rotation = windowManager != null ? windowManager.getDefaultDisplay().getRotation() : 0;
        int i2 = 0;
        if (rotation != 0) {
            i2 = rotation != 1 ? rotation != 2 ? rotation != 3 ? 0 : 270 : 180 : 90;
        }
        return cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i2) % 360)) % 360 : ((cameraInfo.orientation - i2) + 360) % 360;
    }

    public Camera.Size getPictureSize(List<Camera.Size> list, int i, float f) {
        int i2;
        Collections.sort(list, this.sizeComparator);
        Iterator<Camera.Size> it = list.iterator();
        int i3 = 0;
        while (true) {
            i2 = i3;
            if (!it.hasNext()) {
                break;
            }
            Camera.Size next = it.next();
            if (next.width > i && equalRate(next, f)) {
                Log.i(TAG, "MakeSure Picture :w = " + next.width + " h = " + next.height);
                break;
            }
            i3 = i2 + 1;
        }
        return i2 == list.size() ? getBestSize(list, f) : list.get(i2);
    }

    public Camera.Size getPreviewSize(List<Camera.Size> list, int i, float f) {
        int i2;
        Collections.sort(list, this.sizeComparator);
        Iterator<Camera.Size> it = list.iterator();
        int i3 = 0;
        while (true) {
            i2 = i3;
            if (!it.hasNext()) {
                break;
            }
            Camera.Size next = it.next();
            if (next.width > i && equalRate(next, f)) {
                Log.i(TAG, "MakeSure Preview :w = " + next.width + " h = " + next.height);
                break;
            }
            i3 = i2 + 1;
        }
        return i2 == list.size() ? getBestSize(list, f) : list.get(i2);
    }

    public Camera.Size getSmallPictureSize(Camera camera) {
        if (camera != null) {
            List<Camera.Size> supportedPictureSizes = camera.getParameters().getSupportedPictureSizes();
            Camera.Size size = supportedPictureSizes.get(0);
            int i = 1;
            while (i < supportedPictureSizes.size()) {
                float f = supportedPictureSizes.get(i).height / supportedPictureSizes.get(i).width;
                Camera.Size size2 = size;
                if (size.width > supportedPictureSizes.get(i).width) {
                    size2 = size;
                    if (f < 0.6f) {
                        size2 = size;
                        if (f > 0.5f) {
                            size2 = supportedPictureSizes.get(i);
                        }
                    }
                }
                i++;
                size = size2;
            }
            Log.i(TAG, "MakeSure Picture :w = " + size.width + " h = " + size.height);
            return size;
        }
        return null;
    }

    public boolean isSupportedFocusMode(List<String> list, String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                Log.i(TAG, "FocusMode not supported " + str);
                return false;
            } else if (str.equals(list.get(i2))) {
                Log.i(TAG, "FocusMode supported " + str);
                return true;
            } else {
                i = i2 + 1;
            }
        }
    }

    public boolean isSupportedPictureFormats(List<Integer> list, int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                Log.i(TAG, "Formats not supported " + i);
                return false;
            } else if (i == list.get(i3).intValue()) {
                Log.i(TAG, "Formats supported " + i);
                return true;
            } else {
                i2 = i3 + 1;
            }
        }
    }
}
