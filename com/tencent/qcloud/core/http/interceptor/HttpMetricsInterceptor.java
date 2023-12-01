package com.tencent.qcloud.core.http.interceptor;

import com.tencent.qcloud.core.http.HttpTask;
import com.tencent.qcloud.core.http.HttpTaskMetrics;
import com.tencent.qcloud.core.logger.QCloudLogger;
import com.tencent.qcloud.core.task.TaskManager;
import java.io.IOException;
import java.net.Socket;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.RealInterceptorChain;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/interceptor/HttpMetricsInterceptor.class */
public class HttpMetricsInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        try {
            if (chain instanceof RealInterceptorChain) {
                Connection connection = chain.connection();
                if (connection instanceof RealConnection) {
                    Socket socket = ((RealConnection) connection).socket();
                    HttpTaskMetrics metrics = ((HttpTask) TaskManager.getInstance().get((String) request.tag())).metrics();
                    if (metrics != null) {
                        metrics.recordConnectAddress(socket.getInetAddress());
                    }
                }
            }
        } catch (Exception e) {
            QCloudLogger.d("HttpMetricsInterceptor", e.getMessage(), new Object[0]);
        }
        return chain.proceed(request);
    }
}
