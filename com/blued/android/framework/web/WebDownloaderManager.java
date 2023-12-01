package com.blued.android.framework.web;

import android.content.Context;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.framework.urlroute.BluedURIRouter;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/WebDownloaderManager.class */
public class WebDownloaderManager {
    private Set<String> a;
    private Set<DownloaderJSCallback> b;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/WebDownloaderManager$DownloadListener.class */
    public class DownloadListener extends FileHttpResponseHandler {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public long f;
        public long g;
        private int i = 0;

        public DownloadListener() {
        }

        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        /* renamed from: a */
        public void onSuccess(File file) {
            synchronized (WebDownloaderManager.this.b) {
                for (DownloaderJSCallback downloaderJSCallback : WebDownloaderManager.this.b) {
                    downloaderJSCallback.a(1, this.e, this.d, 100);
                }
            }
        }

        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        /* renamed from: a */
        public void onFailure(Throwable th, int i, File file) {
            super.onFailure(th, i, file);
            synchronized (WebDownloaderManager.this.b) {
                for (DownloaderJSCallback downloaderJSCallback : WebDownloaderManager.this.b) {
                    downloaderJSCallback.a(-1, this.e, this.d, 0);
                }
            }
        }

        @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
        public boolean onAccept(int i, long j) {
            this.g = j;
            return super.onAccept(i, j);
        }

        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFinish() {
            super.onFinish();
            synchronized (WebDownloaderManager.this.a) {
                WebDownloaderManager.this.a.remove(this.b);
            }
            if ("emotionpack".equals(this.d) && BluedURIRouter.a().b()) {
                BluedURIRouter.a().a((Context) null, BluedURIRouter.a().a("http://common.blued.com", "download_emotion", new String[]{"download_path"}, new String[]{this.c}));
            }
        }

        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onProgress(int i, int i2) {
            super.onProgress(i, i2);
            this.f = i2;
            if (this.i + 10 <= i) {
                this.i = i;
                synchronized (WebDownloaderManager.this.b) {
                    for (DownloaderJSCallback downloaderJSCallback : WebDownloaderManager.this.b) {
                        downloaderJSCallback.a(0, this.e, this.d, i);
                    }
                }
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/WebDownloaderManager$SingletonCreator.class */
    static class SingletonCreator {
        private static final WebDownloaderManager a = new WebDownloaderManager();

        private SingletonCreator() {
        }
    }

    private WebDownloaderManager() {
        this.a = new HashSet();
        this.b = new HashSet();
    }

    public static WebDownloaderManager a() {
        return SingletonCreator.a;
    }

    public void a(DownloaderJSCallback downloaderJSCallback) {
        synchronized (this.b) {
            this.b.add(downloaderJSCallback);
        }
    }

    public void a(String str, String str2, String str3) {
        synchronized (this.b) {
            for (DownloaderJSCallback downloaderJSCallback : this.b) {
                downloaderJSCallback.a(-1, str3, str2, 0);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        DownloadListener downloadListener = new DownloadListener();
        downloadListener.a = str;
        downloadListener.b = str2;
        downloadListener.c = RecyclingUtils.e(str2);
        downloadListener.d = str3;
        downloadListener.e = str4;
        synchronized (this.a) {
            if (this.a.contains(str2)) {
                return;
            }
            this.a.add(str2);
            FileDownloader.a(downloadListener.b, downloadListener.c, downloadListener, null);
        }
    }

    public void b(DownloaderJSCallback downloaderJSCallback) {
        synchronized (this.b) {
            this.b.remove(downloaderJSCallback);
        }
    }
}
