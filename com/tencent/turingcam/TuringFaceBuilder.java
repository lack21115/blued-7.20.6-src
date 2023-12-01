package com.tencent.turingcam;

import android.content.Context;
import com.tencent.turingface.sdk.mfa.ITuringNetwork;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/TuringFaceBuilder.class */
public class TuringFaceBuilder {
    private int channel;
    private String hostUrl;
    private Context mContext;
    private boolean mIsHardwareAcceleration = true;
    private ITuringNetwork turingNetwork;

    private TuringFaceBuilder() {
    }

    public static TuringFaceBuilder build() {
        return new TuringFaceBuilder();
    }

    public int getChannel() {
        return this.channel;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getHostUrl() {
        return this.hostUrl;
    }

    public ITuringNetwork getTuringNetwork() {
        return this.turingNetwork;
    }

    public boolean isHardwareAcceleration() {
        return this.mIsHardwareAcceleration;
    }

    public TuringFaceBuilder setChannel(int i) {
        this.channel = i;
        return this;
    }

    public TuringFaceBuilder setContext(Context context) {
        this.mContext = context.getApplicationContext();
        return this;
    }

    public TuringFaceBuilder setHostUrl(String str) {
        this.hostUrl = str;
        return this;
    }

    public TuringFaceBuilder setIsHardwareAcceleration(boolean z) {
        this.mIsHardwareAcceleration = z;
        return this;
    }

    public TuringFaceBuilder setTuringNetwork(ITuringNetwork iTuringNetwork) {
        this.turingNetwork = iTuringNetwork;
        return this;
    }
}
