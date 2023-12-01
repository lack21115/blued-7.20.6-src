package com.huawei.openalliance.ad.download;

import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/DownloadTask.class */
public class DownloadTask {
    private boolean allowedMobileNetowrk;
    private long downloadedSize;
    private long fileTotalSize;
    private int pauseReason;
    private int priority;
    private int progress;
    private String sha256;
    private String url;
    @com.huawei.openalliance.ad.annotations.d
    private final byte[] lock = new byte[0];
    @com.huawei.openalliance.ad.annotations.d
    private int status = 0;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/DownloadTask$a.class */
    public interface a {
        public static final int Code = 0;
        public static final int I = 2;
        public static final int V = 1;
    }

    public int B() {
        int i;
        synchronized (this.lock) {
            i = this.status;
        }
        return i;
    }

    public int C() {
        return this.priority;
    }

    public String Code() {
        return this.url;
    }

    public void Code(int i) {
        synchronized (this.lock) {
            this.status = i;
        }
    }

    public void Code(long j) {
        this.fileTotalSize = j;
    }

    public void Code(String str) {
        this.url = str;
    }

    public void Code(boolean z) {
        this.allowedMobileNetowrk = z;
    }

    public int D() {
        return this.pauseReason;
    }

    public String F() {
        return Code();
    }

    public long I() {
        return this.fileTotalSize;
    }

    public void I(int i) {
        this.progress = i;
    }

    public int S() {
        return this.progress;
    }

    public String V() {
        return this.sha256;
    }

    public void V(int i) {
        this.priority = i;
    }

    public void V(long j) {
        this.downloadedSize = j;
    }

    public void V(String str) {
        this.sha256 = str;
    }

    public long Z() {
        return this.downloadedSize;
    }

    public void Z(int i) {
        this.pauseReason = i;
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DownloadTask) && TextUtils.equals(F(), ((DownloadTask) obj).F());
        }
        return false;
    }

    public int hashCode() {
        return F() != null ? F().hashCode() : super.hashCode();
    }
}
