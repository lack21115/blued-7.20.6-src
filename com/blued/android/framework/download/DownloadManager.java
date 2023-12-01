package com.blued.android.framework.download;

import android.util.Log;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.download.model.DownloadBaseInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/download/DownloadManager.class */
public class DownloadManager {

    /* renamed from: a  reason: collision with root package name */
    private static DownloadManager f9791a;
    private List<DownloadTask> b;

    /* renamed from: c  reason: collision with root package name */
    private ExecutorService f9792c;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/download/DownloadManager$DownloadTask.class */
    public static class DownloadTask implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public DownloadBaseInfo f9793a;
        private String d;
        private OnFileDownloadListener e;
        private FileHttpResponseHandler f;
        private IRequestHost g;
        private boolean h;

        /* renamed from: c  reason: collision with root package name */
        private DownloadTask f9794c = this;
        public boolean b = true;

        public DownloadTask(DownloadBaseInfo downloadBaseInfo, String str, OnFileDownloadListener onFileDownloadListener, boolean z) {
            this.d = "";
            this.f9793a = downloadBaseInfo;
            this.d = str;
            this.e = onFileDownloadListener;
            this.h = z;
            a();
        }

        private void a() {
            this.f = new FileHttpResponseHandler() { // from class: com.blued.android.framework.download.DownloadManager.DownloadTask.1
                @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                /* renamed from: a */
                public void onSuccess(File file) {
                    if (file == null) {
                        DownloadManager.a().a(DownloadTask.this.f9794c);
                        return;
                    }
                    try {
                        if (DownloadTask.this.h) {
                            String a2 = Md5.a(file);
                            Log.d("yaojingwa", "mGameInfo.gameMD5 =" + DownloadTask.this.f9793a.md5 + "; md5=" + a2);
                            if (DownloadTask.this.f9793a.md5 == null || !DownloadTask.this.f9793a.md5.equals(a2)) {
                                file.delete();
                                if (DownloadTask.this.e != null) {
                                    DownloadTask.this.e.b(DownloadTask.this.f9793a);
                                }
                            } else if (DownloadTask.this.e != null) {
                                DownloadTask.this.e.a(DownloadTask.this.f9793a, DownloadTask.this.d);
                            }
                        } else if (DownloadTask.this.e != null) {
                            DownloadTask.this.e.a(DownloadTask.this.f9793a, DownloadTask.this.d);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    DownloadManager.a().a(DownloadTask.this.f9794c);
                }

                @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                /* renamed from: a */
                public void onFailure(Throwable th, int i, File file) {
                    super.onFailure(th, i, file);
                    if (DownloadTask.this.e != null) {
                        DownloadTask.this.e.b(DownloadTask.this.f9793a);
                    }
                    DownloadManager.a().a(DownloadTask.this.f9794c);
                }

                @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                public void onProgress(int i, int i2) {
                    Log.d("yaojingwa", "percent = " + i + ",byteCount = " + i2);
                    if (DownloadTask.this.e != null) {
                        DownloadTask.this.e.a(DownloadTask.this.f9793a, i, i2);
                    }
                }

                @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                public void onStart() {
                    super.onStart();
                    Log.d("yaojingwa", DownloadTask.this.f9793a.download_url);
                }
            };
            this.g = new IRequestHost() { // from class: com.blued.android.framework.download.DownloadManager.DownloadTask.2
                @Override // com.blued.android.core.net.IRequestHost
                public boolean isActive() {
                    return DownloadTask.this.b;
                }
            };
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i("DownloadManager", "Start download for: " + this.d);
            FileDownloader.b(this.f9793a.download_url, this.d, this.f, this.g);
        }
    }

    private DownloadManager() {
        this.b = null;
        this.f9792c = null;
        this.f9792c = Executors.newSingleThreadExecutor();
        this.b = Collections.synchronizedList(new ArrayList());
    }

    public static DownloadManager a() {
        if (f9791a == null) {
            f9791a = new DownloadManager();
        }
        return f9791a;
    }

    public void a(DownloadTask downloadTask) {
        this.b.remove(downloadTask);
    }

    public boolean a(DownloadBaseInfo downloadBaseInfo, String str, OnFileDownloadListener onFileDownloadListener, boolean z) throws NullPointerException {
        if (downloadBaseInfo == null || str == null) {
            throw new NullPointerException("Input parameter should not be null");
        }
        for (DownloadTask downloadTask : this.b) {
            if (downloadTask.d.equals(str)) {
                Log.i("DownloadManager", "Downloading task exists. " + str);
                return false;
            }
        }
        DownloadTask downloadTask2 = new DownloadTask(downloadBaseInfo, str, onFileDownloadListener, z);
        this.b.add(downloadTask2);
        this.f9792c.execute(downloadTask2);
        onFileDownloadListener.a(downloadBaseInfo);
        Log.i("DownloadManager", "adding Downloading-task success " + str);
        return true;
    }
}
