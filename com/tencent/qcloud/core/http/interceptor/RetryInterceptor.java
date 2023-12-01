package com.tencent.qcloud.core.http.interceptor;

import com.anythink.expressad.video.module.a.a.m;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.http.HttpConfiguration;
import com.tencent.qcloud.core.http.HttpTask;
import com.tencent.qcloud.core.http.QCloudHttpClient;
import com.tencent.qcloud.core.logger.QCloudLogger;
import com.tencent.qcloud.core.task.RetryStrategy;
import com.tencent.qcloud.core.task.TaskManager;
import com.tencent.qcloud.core.util.QCloudUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/interceptor/RetryInterceptor.class */
public class RetryInterceptor implements Interceptor {
    private static final int MIN_CLOCK_SKEWED_OFFSET = 600;
    private static final int NETWORK_DETECT_RETRY_DELAY = 3000;
    private static volatile Map<String, HostReliable> hostReliables = new HashMap();
    private RetryStrategy.WeightAndReliableAddition additionComputer = new RetryStrategy.WeightAndReliableAddition();
    private RetryStrategy retryStrategy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/interceptor/RetryInterceptor$HostReliable.class */
    public static class HostReliable {
        private static final int defaultReliable = 2;
        private final String host;
        private final int maxReliable;
        private final int minReliable;
        private int reliable;
        private final long resetPeriod;

        private HostReliable(String str) {
            this.maxReliable = 4;
            this.minReliable = 0;
            this.resetPeriod = 300000L;
            this.host = str;
            this.reliable = 2;
            TimerTask timerTask = new TimerTask() { // from class: com.tencent.qcloud.core.http.interceptor.RetryInterceptor.HostReliable.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                }
            };
            new Timer(str + "reliable").schedule(timerTask, 300000L, 300000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decreaseReliable() {
            synchronized (this) {
                if (this.reliable > 0) {
                    this.reliable--;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getReliable() {
            int i;
            synchronized (this) {
                i = this.reliable;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void increaseReliable() {
            synchronized (this) {
                if (this.reliable < 4) {
                    this.reliable++;
                }
            }
        }

        private void resetReliable() {
            synchronized (this) {
                this.reliable = 2;
            }
        }

        private void zeroReliable() {
            synchronized (this) {
                this.reliable = 0;
            }
        }
    }

    public RetryInterceptor(RetryStrategy retryStrategy) {
        this.retryStrategy = retryStrategy;
    }

    private void decreaseHostAccess(String str) {
        HostReliable hostReliable = hostReliables.get(str);
        if (hostReliable != null) {
            hostReliable.decreaseReliable();
        } else {
            hostReliables.put(str, new HostReliable(str));
        }
    }

    private Response executeTaskOnce(Interceptor.Chain chain, Request request, HttpTask httpTask) throws IOException {
        try {
            if (httpTask.isCanceled()) {
                throw new IOException("CANCELED");
            }
            return processSingleRequest(chain, request);
        } catch (ProtocolException e) {
            if (e.getMessage() == null || !e.getMessage().contains("HTTP 204 had non-zero Content-Length: ")) {
                e.printStackTrace();
                throw e;
            }
            return new Response.Builder().request(request).message(e.toString()).code(204).protocol(Protocol.HTTP_1_1).build();
        } catch (IOException e2) {
            e2.printStackTrace();
            throw e2;
        }
    }

    private int getHostReliable(String str) {
        HostReliable hostReliable = hostReliables.get(str);
        if (hostReliable != null) {
            return hostReliable.getReliable();
        }
        return 2;
    }

    private void increaseHostReliable(String str) {
        HostReliable hostReliable = hostReliables.get(str);
        if (hostReliable != null) {
            hostReliable.increaseReliable();
        } else {
            hostReliables.put(str, new HostReliable(str));
        }
    }

    private boolean isRecoverable(IOException iOException) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? iOException instanceof SocketTimeoutException : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private boolean isUserCancelled(IOException iOException) {
        return (iOException == null || iOException.getMessage() == null || !iOException.getMessage().toLowerCase(Locale.ROOT).equals("canceled")) ? false : true;
    }

    private boolean shouldRetry(Request request, Response response, int i, int i2, long j, IOException iOException, int i3) {
        boolean z = false;
        if (isUserCancelled(iOException)) {
            return false;
        }
        int hostReliable = getHostReliable(request.url().host());
        int retryAddition = this.additionComputer.getRetryAddition(i2, hostReliable);
        QCloudLogger.i(QCloudHttpClient.HTTP_LOG_TAG, String.format(Locale.ENGLISH, "attempts = %d, weight = %d, reliable = %d, addition = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(hostReliable), Integer.valueOf(retryAddition)), new Object[0]);
        if (this.retryStrategy.shouldRetry(i, System.nanoTime() - j, retryAddition) && this.retryStrategy.getQCloudHttpRetryHandler().shouldRetry(request, response, iOException)) {
            if (iOException == null || !isRecoverable(iOException)) {
                if (i3 == 500 || i3 == 502 || i3 == 503 || i3 == 504) {
                    z = true;
                }
                return z;
            }
            return true;
        }
        return false;
    }

    String getClockSkewError(Response response, int i) {
        if (response == null || i != 403) {
            return null;
        }
        if (response.request().method().toUpperCase(Locale.ROOT).equals("HEAD")) {
            return QCloudServiceException.ERR0R_REQUEST_IS_EXPIRED;
        }
        ResponseBody body = response.body();
        if (body != null) {
            try {
                BufferedSource source = body.source();
                source.request(Long.MAX_VALUE);
                String readString = source.buffer().clone().readString(Charset.forName("UTF-8"));
                Pattern compile = Pattern.compile("<Code>(RequestTimeTooSkewed|AccessDenied)</Code>");
                Pattern compile2 = Pattern.compile("<Message>Request has expired</Message>");
                Matcher matcher = compile.matcher(readString);
                Matcher matcher2 = compile2.matcher(readString);
                if (matcher.find()) {
                    String group = matcher.group(1);
                    if (QCloudServiceException.ERR0R_REQUEST_TIME_TOO_SKEWED.equals(group)) {
                        return QCloudServiceException.ERR0R_REQUEST_TIME_TOO_SKEWED;
                    }
                    if ("AccessDenied".equals(group)) {
                        if (matcher2.find()) {
                            return QCloudServiceException.ERR0R_REQUEST_IS_EXPIRED;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            } catch (IOException e) {
                return null;
            }
        }
        return null;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        return processRequest(chain, request, (HttpTask) TaskManager.getInstance().get((String) request.tag()));
    }

    Response processRequest(Interceptor.Chain chain, Request request, HttpTask httpTask) throws IOException {
        IOException e;
        int i;
        if (httpTask == null || httpTask.isCanceled()) {
            throw new IOException("CANCELED");
        }
        long nanoTime = System.nanoTime();
        Response response = null;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            long nextDelay = this.retryStrategy.getNextDelay(i3);
            if (nextDelay > 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(nextDelay);
                } catch (InterruptedException e2) {
                }
            }
            if (!QCloudUtils.isNetworkConnected()) {
                try {
                    TimeUnit.MILLISECONDS.sleep(m.ag);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
                if (!QCloudUtils.isNetworkConnected()) {
                    e = new IOException(new QCloudClientException("NetworkNotConnected"));
                    break;
                }
            }
            QCloudLogger.i(QCloudHttpClient.HTTP_LOG_TAG, "%s start to execute, attempts is %d", request, Integer.valueOf(i3));
            int i4 = i3 + 1;
            try {
                Response executeTaskOnce = executeTaskOnce(chain, request, httpTask);
                i = executeTaskOnce.code();
                response = executeTaskOnce;
                e = null;
            } catch (IOException e4) {
                e = e4;
                i = -1;
            }
            String header = response != null ? response.header("Date") : null;
            if (e == null && response.isSuccessful()) {
                if (header != null) {
                    HttpConfiguration.calculateGlobalTimeOffset(header, new Date(), 600);
                }
                increaseHostReliable(request.url().host());
                this.retryStrategy.onTaskEnd(true, null);
            } else {
                String clockSkewError = getClockSkewError(response, i);
                if (clockSkewError != null) {
                    QCloudLogger.i(QCloudHttpClient.HTTP_LOG_TAG, "%s failed for %s", request, clockSkewError);
                    if (header != null && HttpConfiguration.calculateGlobalTimeOffset(header, new Date()) > 2) {
                        e = new IOException(new QCloudServiceException("client clock skewed").setErrorCode(clockSkewError));
                    }
                } else if (!shouldRetry(request, response, i4, httpTask.getWeight(), nanoTime, e, i) || httpTask.isCanceled()) {
                    break;
                } else {
                    QCloudLogger.i(QCloudHttpClient.HTTP_LOG_TAG, "%s failed for %s, code is %d", request, e, Integer.valueOf(i));
                    this.retryStrategy.onTaskEnd(false, e);
                    i2 = i4;
                }
            }
        }
        QCloudLogger.i(QCloudHttpClient.HTTP_LOG_TAG, "%s ends for %s, code is %d", request, e, Integer.valueOf(i));
        if (e == null) {
            return response;
        }
        decreaseHostAccess(request.url().host());
        this.retryStrategy.onTaskEnd(false, e);
        throw e;
    }

    Response processSingleRequest(Interceptor.Chain chain, Request request) throws IOException {
        return chain.proceed(request);
    }
}
