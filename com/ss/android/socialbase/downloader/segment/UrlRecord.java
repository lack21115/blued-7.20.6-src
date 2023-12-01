package com.ss.android.socialbase.downloader.segment;

import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/segment/UrlRecord.class */
public class UrlRecord {
    private final AtomicLong downloadBytes;
    private int failedTimes;
    private int hashCode;
    final String ip;
    final String ipFamily;
    private boolean isCurrentFailed;
    final boolean isMainUrl;
    private String key;
    private final List<SegmentReader> readers;
    final String url;

    public UrlRecord(String str, String str2) {
        this.readers = new ArrayList();
        this.downloadBytes = new AtomicLong();
        this.url = str;
        this.isMainUrl = false;
        this.ip = str2;
        this.ipFamily = getIpFamily(str2);
    }

    public UrlRecord(String str, boolean z) {
        this.readers = new ArrayList();
        this.downloadBytes = new AtomicLong();
        this.url = str;
        this.isMainUrl = z;
        this.ip = null;
        this.ipFamily = null;
    }

    private String getIpFamily(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, lastIndexOf);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String getKey() {
        if (this.key == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.url);
            sb.append(BridgeUtil.UNDERLINE_STR);
            String str = this.ip;
            String str2 = str;
            if (str == null) {
                str2 = "";
            }
            sb.append(str2);
            sb.append(BridgeUtil.UNDERLINE_STR);
            sb.append(this.isMainUrl);
            this.key = sb.toString();
        }
        return this.key;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UrlRecord) {
            return getKey().equals(((UrlRecord) obj).getKey());
        }
        return false;
    }

    public int getCurrentUsers() {
        int size;
        synchronized (this) {
            size = this.readers.size();
        }
        return size;
    }

    public long getDownloadBytes() {
        long j = this.downloadBytes.get();
        for (SegmentReader segmentReader : this.readers) {
            j += segmentReader.getReadingBytes();
        }
        return j;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = getKey().hashCode();
        }
        return this.hashCode;
    }

    public void increaseDownloadBytes(long j) {
        this.downloadBytes.addAndGet(j);
    }

    public boolean isCurrentFailed() {
        boolean z;
        synchronized (this) {
            z = this.isCurrentFailed;
        }
        return z;
    }

    public void recordFailed() {
        synchronized (this) {
            this.failedTimes++;
            this.isCurrentFailed = true;
        }
    }

    public void recordSucceed() {
        synchronized (this) {
            this.isCurrentFailed = false;
        }
    }

    public void recordUnUse(SegmentReader segmentReader) {
        synchronized (this) {
            try {
                this.readers.remove(segmentReader);
            } catch (Throwable th) {
            }
        }
    }

    public void recordUse(SegmentReader segmentReader) {
        synchronized (this) {
            this.readers.add(segmentReader);
        }
    }

    public String toString() {
        return "UrlRecord{url='" + this.url + "', ip='" + this.ip + "', ipFamily='" + this.ipFamily + "', isMainUrl=" + this.isMainUrl + ", failedTimes=" + this.failedTimes + ", isCurrentFailed=" + this.isCurrentFailed + '}';
    }
}
