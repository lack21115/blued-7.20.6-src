package com.sobot.network.http.download;

import android.text.TextUtils;
import android.util.Log;
import com.sobot.network.http.SobotOkHttpUtils;
import com.sobot.network.http.db.SobotDownloadManager;
import com.sobot.network.http.exception.StException;
import com.sobot.network.http.exception.StHttpException;
import com.sobot.network.http.exception.StStorageException;
import com.sobot.network.http.model.SobotProgress;
import com.sobot.network.http.request.RequestCall;
import com.sobot.network.http.task.PriorityRunnable;
import com.sobot.network.http.utils.IOUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/download/SobotDownloadTask.class */
public class SobotDownloadTask implements Runnable {
    private static final int BUFFER_SIZE = 8192;
    private ThreadPoolExecutor executor;
    public Map<Object, SobotDownloadListener> listeners;
    private PriorityRunnable priorityRunnable;
    public SobotProgress progress;

    public SobotDownloadTask(SobotProgress sobotProgress) {
        this.progress = sobotProgress;
        this.executor = SobotDownload.getInstance().getThreadPool().getExecutor();
        this.listeners = new HashMap();
    }

    public SobotDownloadTask(String str, RequestCall requestCall) {
        SobotProgress sobotProgress = new SobotProgress();
        this.progress = sobotProgress;
        sobotProgress.tag = str;
        this.progress.isUpload = false;
        this.progress.folder = SobotDownload.getInstance().getFolder();
        this.progress.url = requestCall.getOkHttpRequest().getBaseUrl();
        this.progress.status = 0;
        this.progress.totalSize = -1L;
        this.progress.request = requestCall;
        this.executor = SobotDownload.getInstance().getThreadPool().getExecutor();
        this.listeners = new HashMap();
    }

    private void download(InputStream inputStream, RandomAccessFile randomAccessFile, SobotProgress sobotProgress) throws IOException {
        if (inputStream == null || randomAccessFile == null) {
            return;
        }
        sobotProgress.status = 2;
        byte[] bArr = new byte[8192];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
        while (true) {
            try {
                int read = bufferedInputStream.read(bArr, 0, 8192);
                if (read == -1 || sobotProgress.status != 2) {
                    break;
                }
                randomAccessFile.write(bArr, 0, read);
                try {
                    SobotProgress.changeProgress(sobotProgress, read, sobotProgress.totalSize, new SobotProgress.Action() { // from class: com.sobot.network.http.download.SobotDownloadTask.1
                        @Override // com.sobot.network.http.model.SobotProgress.Action
                        public void call(SobotProgress sobotProgress2) {
                            SobotDownloadTask.this.postLoading(sobotProgress2);
                        }
                    });
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(randomAccessFile);
                    IOUtils.closeQuietly(bufferedInputStream);
                    IOUtils.closeQuietly(inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        IOUtils.closeQuietly(randomAccessFile);
        IOUtils.closeQuietly(bufferedInputStream);
        IOUtils.closeQuietly(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postLoading(final SobotProgress sobotProgress) {
        updateDatabase(sobotProgress);
        SobotOkHttpUtils.runOnUiThread(new Runnable() { // from class: com.sobot.network.http.download.SobotDownloadTask.5
            @Override // java.lang.Runnable
            public void run() {
                for (SobotDownloadListener sobotDownloadListener : SobotDownloadTask.this.listeners.values()) {
                    sobotDownloadListener.onProgress(sobotProgress);
                }
            }
        });
    }

    private void postOnError(final SobotProgress sobotProgress, Throwable th) {
        sobotProgress.speed = 0L;
        sobotProgress.status = 4;
        sobotProgress.exception = th;
        updateDatabase(sobotProgress);
        SobotOkHttpUtils.runOnUiThread(new Runnable() { // from class: com.sobot.network.http.download.SobotDownloadTask.6
            @Override // java.lang.Runnable
            public void run() {
                for (SobotDownloadListener sobotDownloadListener : SobotDownloadTask.this.listeners.values()) {
                    sobotDownloadListener.onProgress(sobotProgress);
                    sobotDownloadListener.onError(sobotProgress);
                }
            }
        });
    }

    private void postOnFinish(final SobotProgress sobotProgress, final File file) {
        sobotProgress.speed = 0L;
        sobotProgress.fraction = 1.0f;
        sobotProgress.status = 5;
        updateDatabase(sobotProgress);
        SobotOkHttpUtils.runOnUiThread(new Runnable() { // from class: com.sobot.network.http.download.SobotDownloadTask.7
            @Override // java.lang.Runnable
            public void run() {
                for (SobotDownloadListener sobotDownloadListener : SobotDownloadTask.this.listeners.values()) {
                    sobotDownloadListener.onProgress(sobotProgress);
                    sobotDownloadListener.onFinish(file, sobotProgress);
                }
                SobotDownload.getInstance().removeTask(sobotProgress.tag);
            }
        });
    }

    private void postOnRemove(final SobotProgress sobotProgress) {
        updateDatabase(sobotProgress);
        SobotOkHttpUtils.runOnUiThread(new Runnable() { // from class: com.sobot.network.http.download.SobotDownloadTask.8
            @Override // java.lang.Runnable
            public void run() {
                for (SobotDownloadListener sobotDownloadListener : SobotDownloadTask.this.listeners.values()) {
                    sobotDownloadListener.onRemove(sobotProgress);
                }
                SobotDownloadTask.this.listeners.clear();
            }
        });
    }

    private void postOnStart(final SobotProgress sobotProgress) {
        sobotProgress.speed = 0L;
        sobotProgress.status = 0;
        updateDatabase(sobotProgress);
        SobotOkHttpUtils.runOnUiThread(new Runnable() { // from class: com.sobot.network.http.download.SobotDownloadTask.2
            @Override // java.lang.Runnable
            public void run() {
                for (SobotDownloadListener sobotDownloadListener : SobotDownloadTask.this.listeners.values()) {
                    sobotDownloadListener.onStart(sobotProgress);
                }
            }
        });
    }

    private void postPause(final SobotProgress sobotProgress) {
        sobotProgress.speed = 0L;
        sobotProgress.status = 3;
        updateDatabase(sobotProgress);
        SobotOkHttpUtils.runOnUiThread(new Runnable() { // from class: com.sobot.network.http.download.SobotDownloadTask.4
            @Override // java.lang.Runnable
            public void run() {
                for (SobotDownloadListener sobotDownloadListener : SobotDownloadTask.this.listeners.values()) {
                    sobotDownloadListener.onProgress(sobotProgress);
                }
            }
        });
    }

    private void postWaiting(final SobotProgress sobotProgress) {
        sobotProgress.speed = 0L;
        sobotProgress.status = 1;
        updateDatabase(sobotProgress);
        SobotOkHttpUtils.runOnUiThread(new Runnable() { // from class: com.sobot.network.http.download.SobotDownloadTask.3
            @Override // java.lang.Runnable
            public void run() {
                for (SobotDownloadListener sobotDownloadListener : SobotDownloadTask.this.listeners.values()) {
                    sobotDownloadListener.onProgress(sobotProgress);
                }
            }
        });
    }

    private void updateDatabase(SobotProgress sobotProgress) {
        SobotDownloadManager.getInstance().update(SobotProgress.buildUpdateContentValues(sobotProgress), sobotProgress.tag);
    }

    public SobotDownloadTask fileName(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.progress.fileName = str;
        }
        return this;
    }

    public SobotDownloadTask folder(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.progress.folder = str;
        }
        return this;
    }

    public void pause() {
        this.executor.remove(this.priorityRunnable);
        if (this.progress.status == 1) {
            postPause(this.progress);
        } else if (this.progress.status == 2) {
            this.progress.speed = 0L;
            this.progress.status = 3;
        }
    }

    public SobotDownloadTask priority(int i) {
        this.progress.priority = i;
        return this;
    }

    public SobotDownloadTask register(SobotDownloadListener sobotDownloadListener) {
        if (sobotDownloadListener != null) {
            this.listeners.put(sobotDownloadListener.tag, sobotDownloadListener);
        }
        return this;
    }

    public SobotDownloadTask remove(boolean z) {
        pause();
        if (z) {
            IOUtils.delFileOrFolder(this.progress.filePath);
        }
        SobotDownloadManager.getInstance().delete(this.progress.tag);
        SobotDownloadTask removeTask = SobotDownload.getInstance().removeTask(this.progress.tag);
        postOnRemove(this.progress);
        return removeTask;
    }

    public void remove() {
        remove(false);
    }

    public void restart() {
        pause();
        IOUtils.delFileOrFolder(this.progress.filePath);
        this.progress.status = 0;
        this.progress.currentSize = 0L;
        this.progress.fraction = 0.0f;
        this.progress.speed = 0L;
        SobotDownloadManager.getInstance().replace((SobotDownloadManager) this.progress);
        start();
    }

    @Override // java.lang.Runnable
    public void run() {
        File file;
        long j = this.progress.currentSize;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            postOnError(this.progress, StException.BREAKPOINT_EXPIRED());
            return;
        }
        long j2 = j;
        if (i > 0) {
            j2 = j;
            if (!TextUtils.isEmpty(this.progress.filePath)) {
                j2 = j;
                if (!new File(this.progress.filePath).exists()) {
                    this.progress.currentSize = 0L;
                    j2 = 0;
                }
            }
        }
        try {
            RequestCall requestCall = this.progress.request;
            requestCall.getOkHttpRequest().addHeader("Range", "bytes=" + j2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            Response execute = requestCall.execute();
            int code = execute.code();
            if (code == 404 || code >= 500) {
                postOnError(this.progress, StHttpException.NET_ERROR());
                return;
            }
            ResponseBody body = execute.body();
            if (body == null) {
                postOnError(this.progress, new StHttpException("response body is null"));
                return;
            }
            if (this.progress.totalSize == -1) {
                this.progress.totalSize = body.contentLength();
            }
            String str = this.progress.fileName;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = IOUtils.getNetFileName(execute, this.progress.url);
                this.progress.fileName = str2;
            }
            if (!IOUtils.createFolder(this.progress.folder)) {
                postOnError(this.progress, StStorageException.NOT_AVAILABLE());
                return;
            }
            if (TextUtils.isEmpty(this.progress.filePath)) {
                file = new File(this.progress.folder, str2);
                this.progress.filePath = file.getAbsolutePath();
            } else {
                file = new File(this.progress.filePath);
            }
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 > 0 && !file.exists()) {
                remove();
                postOnError(this.progress, StException.BREAKPOINT_EXPIRED());
            } else if (j2 > this.progress.totalSize) {
                remove(true);
                postOnError(this.progress, StException.BREAKPOINT_EXPIRED());
            } else {
                if (i2 == 0 && file.exists()) {
                    IOUtils.delFileOrFolder(file);
                }
                if (j2 == this.progress.totalSize && i2 > 0) {
                    if (file.exists() && j2 == file.length()) {
                        postOnFinish(this.progress, file);
                        return;
                    }
                    remove(true);
                    postOnError(this.progress, StException.BREAKPOINT_EXPIRED());
                    return;
                }
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(j2);
                    this.progress.currentSize = j2;
                    try {
                        SobotDownloadManager.getInstance().replace((SobotDownloadManager) this.progress);
                        download(body.byteStream(), randomAccessFile, this.progress);
                        if (this.progress.status == 3) {
                            postPause(this.progress);
                        } else if (this.progress.status != 2) {
                            postOnError(this.progress, StException.UNKNOWN());
                        } else if (file.length() == this.progress.totalSize) {
                            postOnFinish(this.progress, file);
                        } else {
                            postOnError(this.progress, StException.BREAKPOINT_EXPIRED());
                        }
                    } catch (Exception e) {
                        postOnError(this.progress, e);
                    }
                } catch (Exception e2) {
                    postOnError(this.progress, e2);
                }
            }
        } catch (Exception e3) {
            postOnError(this.progress, e3);
        }
    }

    public SobotDownloadTask save() {
        if (!TextUtils.isEmpty(this.progress.folder) && !TextUtils.isEmpty(this.progress.fileName)) {
            this.progress.filePath = new File(this.progress.folder, this.progress.fileName).getAbsolutePath();
        }
        SobotDownloadManager.getInstance().replace((SobotDownloadManager) this.progress);
        return this;
    }

    public void start() {
        if (SobotDownload.getInstance().getTask(this.progress.tag) == null || SobotDownloadManager.getInstance().get(this.progress.tag) == null) {
            Log.i("SobotDownloadTask", "you must call SobotDownloadTask#save() before SobotDownloadTask#start()！");
        } else if (this.progress.status == 0 || this.progress.status == 3 || this.progress.status == 4) {
            postOnStart(this.progress);
            postWaiting(this.progress);
            PriorityRunnable priorityRunnable = new PriorityRunnable(this.progress.priority, this);
            this.priorityRunnable = priorityRunnable;
            this.executor.execute(priorityRunnable);
        } else if (this.progress.status == 5) {
            if (this.progress.filePath == null) {
                SobotProgress sobotProgress = this.progress;
                postOnError(sobotProgress, new StStorageException("the file of the task with tag:" + this.progress.tag + " may be invalid or damaged, please call the method restart() to download again！"));
                return;
            }
            File file = new File(this.progress.filePath);
            if (file.exists() && file.length() == this.progress.totalSize) {
                postOnFinish(this.progress, new File(this.progress.filePath));
                return;
            }
            SobotProgress sobotProgress2 = this.progress;
            postOnError(sobotProgress2, new StStorageException("the file " + this.progress.filePath + " may be invalid or damaged, please call the method restart() to download again！"));
        }
    }

    public void unRegister(SobotDownloadListener sobotDownloadListener) {
        this.listeners.remove(sobotDownloadListener.tag);
    }

    public void unRegister(String str) {
        this.listeners.remove(str);
    }
}
