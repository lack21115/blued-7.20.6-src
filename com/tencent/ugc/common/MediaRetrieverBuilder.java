package com.tencent.ugc.common;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.g;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/common/MediaRetrieverBuilder.class */
public class MediaRetrieverBuilder {
    private final String TAG = "MediaRetrieverBuilder";
    private String mFilePath = "";

    public MediaMetadataRetriever build() {
        Context applicationContext = ContextUtils.getApplicationContext();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (MediaExtractorBuilder.isContentUri(this.mFilePath)) {
                mediaMetadataRetriever.setDataSource(applicationContext, Uri.parse(this.mFilePath));
                return mediaMetadataRetriever;
            } else if (g.a(this.mFilePath)) {
                mediaMetadataRetriever.setDataSource(this.mFilePath);
                return mediaMetadataRetriever;
            } else {
                mediaMetadataRetriever.release();
                return null;
            }
        } catch (Exception e) {
            LiteavLog.e("MediaRetrieverBuilder", String.valueOf(e));
            mediaMetadataRetriever.release();
            return null;
        }
    }

    public MediaRetrieverBuilder setPath(String str) {
        this.mFilePath = str;
        return this;
    }
}
