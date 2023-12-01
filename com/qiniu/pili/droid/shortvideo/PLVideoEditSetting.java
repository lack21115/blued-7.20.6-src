package com.qiniu.pili.droid.shortvideo;

import com.qiniu.pili.droid.shortvideo.f.e;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLVideoEditSetting.class */
public class PLVideoEditSetting {
    private static final String TAG = "PLVideoEditSetting";
    private String mDestFilepath;
    private String mSourceFilepath;
    private boolean mIsKeepOriginFile = true;
    private boolean mIsGifPreviewEnabled = true;

    public String getDestFilepath() {
        return this.mDestFilepath;
    }

    public String getSourceFilepath() {
        return this.mSourceFilepath;
    }

    public boolean isGifPreviewEnabled() {
        return this.mIsGifPreviewEnabled;
    }

    public boolean isKeepOriginFile() {
        return this.mIsKeepOriginFile;
    }

    public PLVideoEditSetting setDestFilepath(String str) {
        this.mDestFilepath = str;
        e eVar = e.e;
        eVar.c(TAG, "setDestFilepath: " + str);
        return this;
    }

    public PLVideoEditSetting setGifPreviewEnabled(boolean z) {
        this.mIsGifPreviewEnabled = z;
        return this;
    }

    public PLVideoEditSetting setKeepOriginFile(boolean z) {
        this.mIsKeepOriginFile = z;
        e eVar = e.e;
        eVar.c(TAG, "setKeepOriginFile: " + z);
        return this;
    }

    public PLVideoEditSetting setSourceFilepath(String str) {
        this.mSourceFilepath = str;
        e eVar = e.e;
        eVar.c(TAG, "setSourceFilepath: " + str);
        return this;
    }
}
