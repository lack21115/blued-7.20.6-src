package com.tencent.ugc.common;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.g;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/common/MediaExtractorBuilder.class */
public class MediaExtractorBuilder {
    private static final String CONTENT_URL_SCHEME = "content://";
    private static final String TAG = "MediaExtractorBuilder";
    private String mFilePath = "";
    private String mMimeType = "";

    public static boolean isContentUri(String str) {
        return str != null && str.startsWith(CONTENT_URL_SCHEME);
    }

    private void selectMimeType(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= trackCount) {
                return;
            }
            if (mediaExtractor.getTrackFormat(i2).getString(MediaFormat.KEY_MIME).startsWith(this.mMimeType)) {
                mediaExtractor.selectTrack(i2);
                return;
            }
            i = i2 + 1;
        }
    }

    public MediaExtractor build() {
        MediaExtractor mediaExtractor;
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        try {
            if (isContentUri(this.mFilePath)) {
                mediaExtractor2.setDataSource(ContextUtils.getApplicationContext().getContentResolver().openFileDescriptor(Uri.parse(this.mFilePath), "r").getFileDescriptor());
            } else if (!g.a(this.mFilePath)) {
                mediaExtractor2.release();
                return null;
            } else {
                mediaExtractor2.setDataSource(this.mFilePath);
            }
            mediaExtractor = mediaExtractor2;
            if (!TextUtils.isEmpty(this.mMimeType)) {
                selectMimeType(mediaExtractor2);
                return mediaExtractor2;
            }
        } catch (Exception e) {
            LiteavLog.e(TAG, "setDataSource: ".concat(String.valueOf(e)));
            mediaExtractor2.release();
            mediaExtractor = null;
        }
        return mediaExtractor;
    }

    public MediaExtractorBuilder setMimeType(String str) {
        this.mMimeType = str;
        return this;
    }

    public MediaExtractorBuilder setPath(String str) {
        this.mFilePath = str;
        return this;
    }
}
