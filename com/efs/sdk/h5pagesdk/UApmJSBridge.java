package com.efs.sdk.h5pagesdk;

import android.util.Log;
import android.webkit.JavascriptInterface;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/h5pagesdk/UApmJSBridge.class */
public class UApmJSBridge {
    @JavascriptInterface
    public String getLaunchOptionsSync() {
        try {
            if (H5Manager.getH5ConfigMananger() == null) {
                if (H5Manager.isDebug) {
                    Log.d("getLaunchOptionsSync", "H5Manager.getH5ConfigMananger() is null.");
                    return "";
                }
                return "";
            }
            String generateLaunchOptions = H5Manager.getH5ConfigMananger().generateLaunchOptions();
            if (H5Manager.isDebug) {
                Log.d("getLaunchOptionsSync", generateLaunchOptions);
                return generateLaunchOptions;
            }
            return generateLaunchOptions;
        } catch (Throwable th) {
            return "";
        }
    }

    @JavascriptInterface
    public void sendData(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    if (H5Manager.isDebug) {
                        Log.d("sendData", str);
                    }
                    if (H5Manager.getH5ConfigMananger() != null) {
                        H5Manager.getH5ConfigMananger().sendData(str);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }
}
