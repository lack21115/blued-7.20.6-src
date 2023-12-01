package com.tencent.qcloud.core.http.interceptor;

import com.tencent.qcloud.core.http.HttpTask;
import com.tencent.qcloud.core.http.QCloudHttpClient;
import com.tencent.qcloud.core.logger.QCloudLogger;
import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/interceptor/TrafficControlInterceptor.class */
public class TrafficControlInterceptor implements Interceptor {
    private TrafficStrategy uploadTrafficStrategy = new ModerateTrafficStrategy("UploadStrategy-", 2);
    private TrafficStrategy downloadTrafficStrategy = new AggressiveTrafficStrategy("DownloadStrategy-", 3);

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/interceptor/TrafficControlInterceptor$AggressiveTrafficStrategy.class */
    static class AggressiveTrafficStrategy extends TrafficStrategy {
        AggressiveTrafficStrategy(String str, int i) {
            super(str, i, i);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/interceptor/TrafficControlInterceptor$ModerateTrafficStrategy.class */
    static class ModerateTrafficStrategy extends TrafficStrategy {
        ModerateTrafficStrategy(String str, int i) {
            super(str, 1, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/interceptor/TrafficControlInterceptor$ResizableSemaphore.class */
    public static class ResizableSemaphore extends Semaphore {
        ResizableSemaphore(int i, boolean z) {
            super(i, z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.concurrent.Semaphore
        public void reducePermits(int i) {
            super.reducePermits(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/interceptor/TrafficControlInterceptor$TrafficStrategy.class */
    public static abstract class TrafficStrategy {
        static final long BOOST_MODE_DURATION = TimeUnit.SECONDS.toNanos(3);
        static final int SINGLE_THREAD_SAFE_SPEED = 100;
        private long boostModeExhaustedTime;
        private AtomicInteger concurrent;
        private ResizableSemaphore controller;
        private final int maxConcurrent;
        private final String name;

        TrafficStrategy(String str, int i, int i2) {
            this.name = str;
            this.maxConcurrent = i2;
            this.controller = new ResizableSemaphore(i, true);
            this.concurrent = new AtomicInteger(i);
            QCloudLogger.d(QCloudHttpClient.HTTP_LOG_TAG, str + " init concurrent is " + i, new Object[0]);
        }

        private void adjustConcurrent(int i, boolean z) {
            synchronized (this) {
                int i2 = i - this.concurrent.get();
                if (i2 != 0) {
                    this.concurrent.set(i);
                    if (i2 <= 0) {
                        this.controller.reducePermits(i2 * (-1));
                        if (z) {
                            this.controller.release();
                        }
                    } else if (z) {
                        this.controller.release(i2 + 1);
                    }
                    QCloudLogger.i(QCloudHttpClient.HTTP_LOG_TAG, this.name + "set concurrent to " + i, new Object[0]);
                } else if (z) {
                    this.controller.release();
                }
            }
        }

        void reportException(Request request, IOException iOException) {
            this.controller.release();
        }

        void reportSpeed(Request request, double d) {
            int i = (d > 0.0d ? 1 : (d == 0.0d ? 0 : -1));
            if (i <= 0) {
                this.controller.release();
                return;
            }
            QCloudLogger.d(QCloudHttpClient.HTTP_LOG_TAG, this.name + " %s streaming speed is %1.3f KBps", request, Double.valueOf(d));
            int i2 = this.concurrent.get();
            if (d > 240.0d && i2 < this.maxConcurrent) {
                this.boostModeExhaustedTime = System.nanoTime() + BOOST_MODE_DURATION;
                adjustConcurrent(i2 + 1, true);
            } else if (d > 120.0d && this.boostModeExhaustedTime > 0) {
                this.boostModeExhaustedTime = System.nanoTime() + BOOST_MODE_DURATION;
                this.controller.release();
            } else if (i <= 0 || i2 <= 1 || d >= 70.0d) {
                this.controller.release();
            } else {
                adjustConcurrent(i2 - 1, true);
            }
        }

        void reportTimeOut(Request request) {
            adjustConcurrent(1, true);
        }

        void waitForPermit() {
            try {
                if (this.concurrent.get() > 1 && System.nanoTime() > this.boostModeExhaustedTime) {
                    adjustConcurrent(1, false);
                }
                this.controller.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private double getAverageStreamingSpeed(HttpTask httpTask, long j) {
        if (j == 0) {
            return 0.0d;
        }
        return (httpTask.getTransferBodySize() / 1024.0d) / (j / 1000.0d);
    }

    private TrafficStrategy getSuitableStrategy(HttpTask httpTask) {
        TrafficStrategy trafficStrategy = null;
        if (httpTask.isEnableTraffic()) {
            if (httpTask.isDownloadTask()) {
                return this.downloadTrafficStrategy;
            }
            if (httpTask.isUploadTask()) {
                trafficStrategy = this.uploadTrafficStrategy;
            }
            return trafficStrategy;
        }
        return null;
    }

    private Response processRequest(Interceptor.Chain chain, Request request) throws IOException {
        return chain.proceed(request);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00d4  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.core.http.interceptor.TrafficControlInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
