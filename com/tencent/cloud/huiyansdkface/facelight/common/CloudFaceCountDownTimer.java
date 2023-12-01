package com.tencent.cloud.huiyansdkface.facelight.common;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/common/CloudFaceCountDownTimer.class */
public abstract class CloudFaceCountDownTimer {

    /* renamed from: a  reason: collision with root package name */
    private final long f35583a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private long f35584c;
    private boolean d = false;
    private Handler e = new Handler() { // from class: com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (CloudFaceCountDownTimer.this) {
                if (CloudFaceCountDownTimer.this.d) {
                    return;
                }
                long elapsedRealtime = CloudFaceCountDownTimer.this.f35584c - SystemClock.elapsedRealtime();
                if (elapsedRealtime <= 0) {
                    CloudFaceCountDownTimer.this.onFinish();
                } else if (elapsedRealtime < CloudFaceCountDownTimer.this.b) {
                    sendMessageDelayed(obtainMessage(1), elapsedRealtime);
                } else {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    CloudFaceCountDownTimer.this.onTick(elapsedRealtime);
                    long elapsedRealtime3 = (elapsedRealtime2 + CloudFaceCountDownTimer.this.b) - SystemClock.elapsedRealtime();
                    while (elapsedRealtime3 < 0) {
                        elapsedRealtime3 += CloudFaceCountDownTimer.this.b;
                    }
                    sendMessageDelayed(obtainMessage(1), elapsedRealtime3);
                }
            }
        }
    };

    public CloudFaceCountDownTimer(long j, long j2) {
        this.f35583a = j;
        this.b = j2;
    }

    public final void cancel() {
        synchronized (this) {
            this.d = true;
            this.e.removeMessages(1);
        }
    }

    public abstract void onFinish();

    public abstract void onTick(long j);

    public final CloudFaceCountDownTimer start() {
        synchronized (this) {
            this.d = false;
            if (this.f35583a <= 0) {
                onFinish();
                return this;
            }
            this.f35584c = SystemClock.elapsedRealtime() + this.f35583a;
            this.e.sendMessage(this.e.obtainMessage(1));
            return this;
        }
    }
}
