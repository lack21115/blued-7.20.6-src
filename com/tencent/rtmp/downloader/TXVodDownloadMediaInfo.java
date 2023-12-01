package com.tencent.rtmp.downloader;

import com.tencent.liteav.txcvodplayer.b.d;
import com.tencent.rtmp.downloader.a.a;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/downloader/TXVodDownloadMediaInfo.class */
public class TXVodDownloadMediaInfo {
    public static final int STATE_ERROR = 3;
    public static final int STATE_FINISH = 4;
    public static final int STATE_INIT = 0;
    public static final int STATE_START = 1;
    public static final int STATE_STOP = 2;
    protected a dataSource;
    protected int downloadSegments;
    protected int downloadSize;
    protected int duration;
    @Deprecated
    protected d netApi;
    protected String playPath;
    protected int playableDuration;
    protected float progress;
    protected int segments;
    protected int size;
    protected String url;
    protected String userName = "default";
    protected int tid = -1;
    protected int downloadState = 0;

    public TXVodDownloadDataSource getDataSource() {
        return this.dataSource;
    }

    public int getDownloadSize() {
        return (this.downloadSize != 0 || this.size <= 0 || getProgress() <= 0.0f) ? Math.min(this.downloadSize, this.size) : Math.min((int) (this.size * getProgress()), this.size);
    }

    public int getDownloadState() {
        return this.downloadState;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getPlayPath() {
        return this.playPath;
    }

    public int getPlayableDuration() {
        return this.playableDuration;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (r5 > 0) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
        if (r5 > 0) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public float getProgress() {
        /*
            r3 = this;
            r0 = r3
            int r0 = r0.playableDuration
            r4 = r0
            r0 = r4
            if (r0 <= 0) goto L18
            r0 = r3
            int r0 = r0.duration
            r5 = r0
            r0 = r5
            if (r0 <= 0) goto L18
        L12:
            r0 = r4
            float r0 = (float) r0
            r1 = r5
            float r1 = (float) r1
            float r0 = r0 / r1
            return r0
        L18:
            r0 = r3
            int r0 = r0.downloadSize
            r4 = r0
            r0 = r4
            if (r0 <= 0) goto L2d
            r0 = r3
            int r0 = r0.size
            r5 = r0
            r0 = r5
            if (r0 <= 0) goto L2d
            goto L12
        L2d:
            r0 = r3
            int r0 = r0.downloadSegments
            r4 = r0
            r0 = r4
            if (r0 <= 0) goto L42
            r0 = r3
            int r0 = r0.segments
            r5 = r0
            r0 = r5
            if (r0 <= 0) goto L42
            goto L12
        L42:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.downloader.TXVodDownloadMediaInfo.getProgress():float");
    }

    public int getSize() {
        return this.size;
    }

    public int getTaskId() {
        return this.tid;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUserName() {
        return this.userName;
    }

    public boolean isDownloadFinished() {
        return this.downloadState == 4;
    }
}
