package com.sobot.network.http.download;

import com.sobot.network.http.upload.ProgressListener;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/download/SobotDownloadListener.class */
public abstract class SobotDownloadListener implements ProgressListener<File> {
    public final Object tag;

    public SobotDownloadListener(Object obj) {
        this.tag = obj;
    }
}
