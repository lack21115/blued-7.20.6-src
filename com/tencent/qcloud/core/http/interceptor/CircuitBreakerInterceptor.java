package com.tencent.qcloud.core.http.interceptor;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.qcloud.core.http.HttpRequest;
import com.tencent.qcloud.core.http.HttpTask;
import com.tencent.qcloud.core.http.QCloudHttpClient;
import com.tencent.qcloud.core.logger.QCloudLogger;
import com.tencent.qcloud.core.task.TaskManager;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/interceptor/CircuitBreakerInterceptor.class */
public class CircuitBreakerInterceptor implements Interceptor {
    private static final int THRESHOLD_STATE_SWITCH_FOR_CONTINUOUS_FAIL = 5;
    private static final int THRESHOLD_STATE_SWITCH_FOR_CONTINUOUS_SUCCESS = 2;
    private static final long TIMEOUT_FOR_OPEN_STATE = 10000;
    private static final long TIMEOUT_FOR_RESET_ALL = 60000;
    private long entryOpenStateTimestamp;
    private long recentErrorTimestamp;
    private AtomicInteger failedCount = new AtomicInteger(0);
    private AtomicInteger successCount = new AtomicInteger(0);
    private State state = State.CLOSED;
    private FootprintWriter footprintWriter = new FootprintWriter();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/interceptor/CircuitBreakerInterceptor$FootprintWriter.class */
    static class FootprintWriter {
        private Set<String> tasks;

        private FootprintWriter() {
            this.tasks = new HashSet();
        }

        String getResourceId(HttpTask httpTask) {
            HttpRequest request = httpTask.request();
            return request.method() + request.url().getHost() + BridgeUtil.SPLIT_MARK + request.url().getPath();
        }

        boolean noRecords(HttpTask httpTask) {
            return !this.tasks.contains(getResourceId(httpTask));
        }

        void remember(HttpTask httpTask) {
            this.tasks.add(getResourceId(httpTask));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/interceptor/CircuitBreakerInterceptor$State.class */
    enum State {
        OPEN,
        CLOSED,
        HALF_OPENED
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean noRecords;
        Request request = chain.request();
        HttpTask httpTask = (HttpTask) TaskManager.getInstance().get((String) request.tag());
        synchronized (CircuitBreakerInterceptor.class) {
            try {
                if (this.state == State.OPEN && TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.entryOpenStateTimestamp) > 10000) {
                    this.state = State.HALF_OPENED;
                }
                if (this.recentErrorTimestamp > 0 && TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.recentErrorTimestamp) > 60000) {
                    this.state = State.CLOSED;
                    this.successCount.set(0);
                    this.failedCount.set(0);
                    this.recentErrorTimestamp = 0L;
                }
                noRecords = this.footprintWriter.noRecords(httpTask);
                if (noRecords) {
                    this.footprintWriter.remember(httpTask);
                }
            } finally {
            }
        }
        if (this.state == State.OPEN && ((httpTask.isDownloadTask() || httpTask.isUploadTask()) && !noRecords)) {
            QCloudLogger.i(QCloudHttpClient.HTTP_LOG_TAG, "CircuitBreaker deny %s", request);
            throw new CircuitBreakerDeniedException("too many continuous errors.");
        }
        try {
            Response proceed = chain.proceed(request);
            synchronized (CircuitBreakerInterceptor.class) {
                if (this.state == State.HALF_OPENED && this.successCount.incrementAndGet() >= 2) {
                    QCloudLogger.i(QCloudHttpClient.HTTP_LOG_TAG, "CircuitBreaker is CLOSED.", new Object[0]);
                    this.state = State.CLOSED;
                    this.failedCount.set(0);
                } else if (this.state == State.OPEN) {
                    QCloudLogger.i(QCloudHttpClient.HTTP_LOG_TAG, "CircuitBreaker is HALF_OPENED.", new Object[0]);
                    this.state = State.HALF_OPENED;
                    this.successCount.set(1);
                } else if (this.state == State.CLOSED) {
                    int i = this.failedCount.get();
                    if (i > 0) {
                        this.failedCount.set(Math.max(i - 2, 0));
                    }
                    QCloudLogger.i(QCloudHttpClient.HTTP_LOG_TAG, "CircuitBreaker get success", new Object[0]);
                }
            }
            return proceed;
        } catch (IOException e) {
            synchronized (CircuitBreakerInterceptor.class) {
                try {
                    this.recentErrorTimestamp = System.nanoTime();
                    if (this.state == State.CLOSED && this.failedCount.incrementAndGet() >= 5) {
                        QCloudLogger.i(QCloudHttpClient.HTTP_LOG_TAG, "CircuitBreaker is OPEN.", new Object[0]);
                        this.state = State.OPEN;
                        this.entryOpenStateTimestamp = System.nanoTime();
                        throw e;
                    }
                    if (this.state == State.HALF_OPENED) {
                        QCloudLogger.i(QCloudHttpClient.HTTP_LOG_TAG, "CircuitBreaker is OPEN.", new Object[0]);
                        this.state = State.OPEN;
                        this.entryOpenStateTimestamp = System.nanoTime();
                    } else {
                        QCloudLogger.i(QCloudHttpClient.HTTP_LOG_TAG, "CircuitBreaker get fail: %d", Integer.valueOf(this.failedCount.get()));
                    }
                    throw e;
                } finally {
                }
            }
        }
    }
}
