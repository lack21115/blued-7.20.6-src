package com.tencent.cos.xml.transfer;

import java.net.InetAddress;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/TransferTaskMetrics.class */
public class TransferTaskMetrics {
    InetAddress connectAddress;
    String domain;
    private long firstProgressTookTime;
    long size;
    private long tookTime;
    private long waitTookTime;
    private long startTime = 0;
    private long progressTime = 0;
    private long firstProgressCallbackTime = 0;
    private long completeTime = 0;

    public TransferTaskMetrics() {
    }

    public TransferTaskMetrics(String str, InetAddress inetAddress, long j, long j2, long j3) {
        this.domain = str;
        this.connectAddress = inetAddress;
        this.size = j;
        this.tookTime = j2;
        this.firstProgressTookTime = j3;
    }

    private long tookTime(long j) {
        return Math.max(-1L, j - this.startTime) / 1000000;
    }

    public InetAddress getConnectAddress() {
        return this.connectAddress;
    }

    public String getDomain() {
        return this.domain;
    }

    public long getFirstProgressTookTime() {
        return this.firstProgressTookTime;
    }

    public long getSize() {
        return this.size;
    }

    public long getTookTime() {
        return this.tookTime;
    }

    public long getWaitTookTime() {
        return this.waitTookTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onComplete() {
        long nanoTime = System.nanoTime();
        this.completeTime = nanoTime;
        this.tookTime = tookTime(nanoTime);
        this.waitTookTime = tookTime(this.progressTime);
        this.firstProgressTookTime = tookTime(this.firstProgressCallbackTime);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onFirstProgressCallback() {
        if (this.firstProgressCallbackTime <= this.progressTime) {
            this.firstProgressCallbackTime = System.nanoTime();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInProgress() {
        long nanoTime = System.nanoTime();
        this.progressTime = nanoTime;
        this.firstProgressCallbackTime = nanoTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onStart() {
        this.startTime = System.nanoTime();
    }

    public String toString() {
        return "TransferTaskMetrics{domain='" + this.domain + "', connectAddress=" + this.connectAddress + ", size=" + this.size + ", tookTime=" + this.tookTime + ", waitTookTime=" + this.waitTookTime + ", firstProgressTookTime=" + this.firstProgressTookTime + '}';
    }
}
