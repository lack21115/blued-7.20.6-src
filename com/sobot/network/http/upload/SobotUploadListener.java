package com.sobot.network.http.upload;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/upload/SobotUploadListener.class */
public abstract class SobotUploadListener implements ProgressListener<SobotUploadModelBase> {
    public final Object tag;

    public SobotUploadListener(Object obj) {
        this.tag = obj;
    }
}
