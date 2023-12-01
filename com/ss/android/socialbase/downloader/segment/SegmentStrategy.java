package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/segment/SegmentStrategy.class */
public class SegmentStrategy {
    private static final int MAX_THREAD_COUNT = 16;
    private static final long MIN_CONNECT_TIMEOUT = 2000;
    private static final long MIN_READ_TIMEOUT = 4000;
    private static final long SEGMENT_MIN_INIT_SIZE = 5242880;
    private static final long SEGMENT_MIN_SIZE = 65536;
    public static final String TAG = "SegmentStrategy";
    private final JSONObject config;
    private int threadCount;

    private SegmentStrategy(JSONObject jSONObject) {
        this.config = jSONObject;
    }

    private int calculateThreadCount(int i) {
        int optInt = this.config.optInt(DownloadSettingKeys.SegmentConfig.THREAD_COUNT, 4);
        int i2 = optInt;
        if (optInt > 16) {
            i2 = 16;
        }
        if (i2 > 0) {
            return getUrlBalance() == 1 ? Math.min(i2, i) : i2;
        } else if (getUrlBalance() > 0) {
            return i;
        } else {
            return 1;
        }
    }

    public static SegmentStrategy from(JSONObject jSONObject) {
        return new SegmentStrategy(jSONObject);
    }

    private int getUrlBalance() {
        return this.config.optInt(DownloadSettingKeys.SegmentConfig.URL_BALANCE, 2);
    }

    public int getBufferCount() {
        return this.config.optInt(DownloadSettingKeys.SegmentConfig.BUFFER_COUNT, 512);
    }

    public int getBufferSize() {
        return this.config.optInt(DownloadSettingKeys.SegmentConfig.BUFFER_SIZE, 8192);
    }

    public long getConnectTimeout() {
        long optInt = this.config.optInt(DownloadSettingKeys.SegmentConfig.CONNECT_TIMEOUT, -1);
        if (optInt >= 2000) {
            return optInt;
        }
        return -1L;
    }

    public int getIpStrategy() {
        return this.config.optInt(DownloadSettingKeys.SegmentConfig.IP_STRATEGY, 0);
    }

    public float getMainRatio() {
        return (float) this.config.optDouble(DownloadSettingKeys.SegmentConfig.MAIN_RATIO, 0.0d);
    }

    public float getPoorSpeedRatio() {
        return Math.min(Math.max(0.0f, (float) this.config.optDouble(DownloadSettingKeys.SegmentConfig.POOR_SPEED_RATIO, 0.0d)), 1.0f);
    }

    public int getRatioSegmentStrategy() {
        return this.config.optInt(DownloadSettingKeys.SegmentConfig.RATIO_SEGMENT, 0);
    }

    public long getReadTimeout() {
        long optInt = this.config.optInt(DownloadSettingKeys.SegmentConfig.READ_TIMEOUT, -1);
        if (optInt >= MIN_READ_TIMEOUT) {
            return optInt;
        }
        return -1L;
    }

    public long getSegmentMaxSize() {
        long optInt = this.config.optInt(DownloadSettingKeys.SegmentConfig.SEGMENT_MAX_KB, 0) * 1048576;
        long j = optInt;
        if (optInt < getSegmentMinSize()) {
            j = -1;
        }
        return j;
    }

    public long getSegmentMinInitSize() {
        long optInt = this.config.optInt(DownloadSettingKeys.SegmentConfig.SEGMENT_MIN_INIT_MB, 10) * 1048576;
        long j = optInt;
        if (optInt < SEGMENT_MIN_INIT_SIZE) {
            j = 5242880;
        }
        return j;
    }

    public long getSegmentMinSize() {
        long optInt = this.config.optInt(DownloadSettingKeys.SegmentConfig.SEGMENT_MIN_KB, 512) * 1024;
        long j = optInt;
        if (optInt < 65536) {
            j = 65536;
        }
        return j;
    }

    public int getThreadCount() {
        return this.threadCount;
    }

    public boolean segmentOneByOne() {
        return this.config.optInt(DownloadSettingKeys.SegmentConfig.SEGMENT_MODE, 1) == 0;
    }

    public void updateUrlCount(int i) {
        this.threadCount = calculateThreadCount(i);
    }

    public boolean urlBalance() {
        return getUrlBalance() > 0;
    }

    public boolean urlBalanceStrictly() {
        return getUrlBalance() == 1;
    }
}
