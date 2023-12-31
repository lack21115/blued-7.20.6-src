package com.sensetime.stmobile;

import com.sensetime.stmobile.model.STRect;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobileObjectTrackNative.class */
public class STMobileObjectTrackNative {
    private long objectTrackNativeHandle;

    public native int createInstance();

    public native void destroyInstance();

    public native STRect objectTrack(byte[] bArr, int i, int i2, int i3, float[] fArr);

    public native void reset();

    public native int setTarget(byte[] bArr, int i, int i2, int i3, STRect sTRect);
}
