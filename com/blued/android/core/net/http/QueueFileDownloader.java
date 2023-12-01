package com.blued.android.core.net.http;

import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.pool.DefaultThreadFactory;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/QueueFileDownloader.class */
public class QueueFileDownloader {
    static ExecutorService a = Executors.newSingleThreadExecutor(new DefaultThreadFactory("queuefiledownload"));

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/QueueFileDownloader$QueueFileListener.class */
    public interface QueueFileListener {
        void a(int i, int i2, String str, String str2);
    }

    public static void a(final String[] strArr, final String[] strArr2, final QueueFileListener queueFileListener, final IRequestHost iRequestHost, final boolean z) {
        if (strArr != null && strArr2 != null && strArr.length == strArr2.length) {
            a.submit(new Runnable() { // from class: com.blued.android.core.net.http.QueueFileDownloader.1
                @Override // java.lang.Runnable
                public void run() {
                    int i = 0;
                    while (true) {
                        final int i2 = i;
                        if (i2 >= strArr.length) {
                            return;
                        }
                        IRequestHost iRequestHost2 = iRequestHost;
                        if (iRequestHost2 != null && !iRequestHost2.isActive()) {
                            return;
                        }
                        final String str = strArr[i2];
                        final String str2 = strArr2[i2];
                        if (z && new File(str2).exists()) {
                            QueueFileListener queueFileListener2 = queueFileListener;
                            if (queueFileListener2 != null) {
                                queueFileListener2.a(0, i2, str, str2);
                                return;
                            }
                            return;
                        }
                        final String e = RecyclingUtils.e(str);
                        FileDownloader.b(str, e, new FileHttpResponseHandler() { // from class: com.blued.android.core.net.http.QueueFileDownloader.1.1
                            private long f = 0;

                            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                            /* renamed from: a */
                            public void onSuccess(File file) {
                                int i3 = -1;
                                if (file == null || file.length() != this.f) {
                                    if (queueFileListener != null) {
                                        queueFileListener.a(-1, i2, str, str2);
                                        return;
                                    }
                                    return;
                                }
                                boolean a2 = AppMethods.a(e, str2);
                                if (queueFileListener != null) {
                                    QueueFileListener queueFileListener3 = queueFileListener;
                                    if (a2) {
                                        i3 = 0;
                                    }
                                    queueFileListener3.a(i3, i2, str, str2);
                                }
                            }

                            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                            /* renamed from: a */
                            public void onFailure(Throwable th, int i3, File file) {
                                super.onFailure(th, i3, file);
                                if (queueFileListener != null) {
                                    queueFileListener.a(-1, i2, str, str2);
                                }
                            }

                            @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
                            public boolean onAccept(int i3, long j) {
                                this.f = j;
                                return super.onAccept(i3, j);
                            }

                            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                            public void onFinish() {
                                super.onFinish();
                                File file = new File(e);
                                if (file.exists()) {
                                    file.delete();
                                }
                            }
                        }, iRequestHost);
                        i = i2 + 1;
                    }
                }
            });
        } else if (queueFileListener != null) {
            queueFileListener.a(-1, -1, null, null);
        }
    }
}
