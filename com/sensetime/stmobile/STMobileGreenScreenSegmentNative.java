package com.sensetime.stmobile;

import com.sensetime.stmobile.model.STImage;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobileGreenScreenSegmentNative.class */
public class STMobileGreenScreenSegmentNative {
    private long GreenScreenSegmentNativeHandle;

    static {
        System.loadLibrary("st_mobile");
        System.loadLibrary("stmobile_jni");
    }

    public native int createInstance();

    public native int destroyInstance();

    public native float getParam(int i);

    public native int process(STImage sTImage, int i);

    public native int setParam(int i, float f);
}
