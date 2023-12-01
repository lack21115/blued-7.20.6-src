package com.sobot.network.http.upload;

import android.text.TextUtils;
import android.util.Log;
import com.sobot.network.http.SobotOkHttpUtils;
import com.sobot.network.http.db.SobotDownloadManager;
import com.sobot.network.http.log.SobotNetLogUtils;
import com.sobot.network.http.model.SobotProgress;
import com.sobot.network.http.model.UploadFileResult;
import com.sobot.network.http.request.ProgressRequestBody;
import com.sobot.network.http.request.RequestCall;
import com.sobot.network.http.task.PriorityRunnable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.Call;
import okhttp3.Response;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/upload/SobotUploadTask.class */
public class SobotUploadTask<T> implements Runnable {
    private static final String TAG = "SobotUploadTask";
    private ThreadPoolExecutor executor;
    public Map<Object, SobotUploadListener> listeners;
    private PriorityRunnable priorityRunnable;
    public SobotProgress progress;

    public SobotUploadTask(SobotProgress sobotProgress) {
        this.progress = sobotProgress;
        this.executor = SobotUpload.getInstance().getThreadPool().getExecutor();
        this.listeners = new HashMap();
    }

    public SobotUploadTask(String str, RequestCall requestCall) {
        SobotProgress sobotProgress = new SobotProgress();
        this.progress = sobotProgress;
        sobotProgress.tag = str;
        this.progress.isUpload = true;
        this.progress.status = 0;
        this.progress.totalSize = -1L;
        this.progress.request = requestCall;
        this.executor = SobotUpload.getInstance().getThreadPool().getExecutor();
        this.listeners = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postLoading(final SobotProgress sobotProgress) {
        updateDatabase(sobotProgress);
        SobotOkHttpUtils.runOnUiThread(new Runnable() { // from class: com.sobot.network.http.upload.SobotUploadTask.5
            @Override // java.lang.Runnable
            public void run() {
                for (SobotUploadListener sobotUploadListener : SobotUploadTask.this.listeners.values()) {
                    sobotUploadListener.onProgress(sobotProgress);
                }
            }
        });
    }

    private void postOnError(final SobotProgress sobotProgress, Throwable th) {
        sobotProgress.speed = 0L;
        sobotProgress.status = 4;
        sobotProgress.exception = th;
        updateDatabase(sobotProgress);
        SobotOkHttpUtils.runOnUiThread(new Runnable() { // from class: com.sobot.network.http.upload.SobotUploadTask.6
            @Override // java.lang.Runnable
            public void run() {
                for (SobotUploadListener sobotUploadListener : SobotUploadTask.this.listeners.values()) {
                    sobotUploadListener.onProgress(sobotProgress);
                    sobotUploadListener.onError(sobotProgress);
                }
            }
        });
    }

    private void postOnFinish(final SobotProgress sobotProgress, final SobotUploadModelBase sobotUploadModelBase) {
        sobotProgress.speed = 0L;
        sobotProgress.fraction = 1.0f;
        sobotProgress.status = 5;
        updateDatabase(sobotProgress);
        SobotDownloadManager.getInstance().replace((SobotDownloadManager) sobotProgress);
        SobotOkHttpUtils.runOnUiThread(new Runnable() { // from class: com.sobot.network.http.upload.SobotUploadTask.7
            @Override // java.lang.Runnable
            public void run() {
                for (SobotUploadListener sobotUploadListener : SobotUploadTask.this.listeners.values()) {
                    sobotUploadListener.onProgress(sobotProgress);
                    sobotUploadListener.onFinish(sobotUploadModelBase, sobotProgress);
                }
                if (TextUtils.isEmpty(sobotProgress.tmpTag)) {
                    SobotUpload.getInstance().removeTask(sobotProgress.tag);
                } else {
                    SobotUpload.getInstance().removeTask(sobotProgress.tmpTag);
                }
            }
        });
    }

    private void postOnRemove(final SobotProgress sobotProgress) {
        updateDatabase(sobotProgress);
        SobotOkHttpUtils.runOnUiThread(new Runnable() { // from class: com.sobot.network.http.upload.SobotUploadTask.8
            @Override // java.lang.Runnable
            public void run() {
                for (SobotUploadListener sobotUploadListener : SobotUploadTask.this.listeners.values()) {
                    sobotUploadListener.onRemove(sobotProgress);
                }
                SobotUploadTask.this.listeners.clear();
            }
        });
    }

    private void postOnStart(final SobotProgress sobotProgress) {
        sobotProgress.speed = 0L;
        sobotProgress.status = 0;
        updateDatabase(sobotProgress);
        SobotOkHttpUtils.runOnUiThread(new Runnable() { // from class: com.sobot.network.http.upload.SobotUploadTask.2
            @Override // java.lang.Runnable
            public void run() {
                for (SobotUploadListener sobotUploadListener : SobotUploadTask.this.listeners.values()) {
                    sobotUploadListener.onStart(sobotProgress);
                }
            }
        });
    }

    private void postPause(final SobotProgress sobotProgress) {
        sobotProgress.speed = 0L;
        sobotProgress.status = 3;
        updateDatabase(sobotProgress);
        SobotOkHttpUtils.runOnUiThread(new Runnable() { // from class: com.sobot.network.http.upload.SobotUploadTask.4
            @Override // java.lang.Runnable
            public void run() {
                for (SobotUploadListener sobotUploadListener : SobotUploadTask.this.listeners.values()) {
                    sobotUploadListener.onProgress(sobotProgress);
                }
            }
        });
    }

    private void postWaiting(final SobotProgress sobotProgress) {
        sobotProgress.speed = 0L;
        sobotProgress.status = 1;
        updateDatabase(sobotProgress);
        SobotOkHttpUtils.runOnUiThread(new Runnable() { // from class: com.sobot.network.http.upload.SobotUploadTask.3
            @Override // java.lang.Runnable
            public void run() {
                for (SobotUploadListener sobotUploadListener : SobotUploadTask.this.listeners.values()) {
                    sobotUploadListener.onProgress(sobotProgress);
                }
            }
        });
    }

    private void updateDatabase(SobotProgress sobotProgress) {
    }

    public SobotUploadTask<T> filePath(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.progress.filePath = str;
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
        } else {
            Log.w(TAG, "only the task with status WAITING(1) or LOADING(2) can pause, current status is " + this.progress.status);
        }
    }

    public SobotUploadTask<T> priority(int i) {
        this.progress.priority = i;
        return this;
    }

    public SobotUploadTask<T> register(SobotUploadListener sobotUploadListener) {
        if (sobotUploadListener != null) {
            this.listeners.put(sobotUploadListener.tag, sobotUploadListener);
        }
        return this;
    }

    public SobotUploadTask<T> remove() {
        pause();
        SobotUploadTask<T> sobotUploadTask = (SobotUploadTask<T>) SobotUpload.getInstance().removeTask(this.progress.tag);
        postOnRemove(this.progress);
        return sobotUploadTask;
    }

    public void restart() {
        pause();
        this.progress.status = 0;
        this.progress.currentSize = 0L;
        this.progress.fraction = 0.0f;
        this.progress.speed = 0L;
        start();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.progress.status = 2;
        postLoading(this.progress);
        try {
            final RequestCall requestCall = this.progress.request;
            requestCall.getOkHttpRequest().uploadInterceptor(new ProgressRequestBody.UploadInterceptor() { // from class: com.sobot.network.http.upload.SobotUploadTask.1
                @Override // com.sobot.network.http.request.ProgressRequestBody.UploadInterceptor
                public void uploadProgress(SobotProgress sobotProgress) {
                    Call call = requestCall.getCall();
                    if (call.isCanceled()) {
                        return;
                    }
                    if (SobotUploadTask.this.progress.status != 2) {
                        call.cancel();
                        return;
                    }
                    SobotUploadTask.this.progress.from(sobotProgress);
                    SobotUploadTask sobotUploadTask = SobotUploadTask.this;
                    sobotUploadTask.postLoading(sobotUploadTask.progress);
                }
            });
            Response execute = requestCall.buildCall(null).execute();
            if (!execute.isSuccessful()) {
                postOnError(this.progress, new RuntimeException(execute.message()));
                return;
            }
            try {
                String string = execute.body().string();
                SobotNetLogUtils.i("uploadFile----->:" + string);
                SobotUploadModel jsonToCommonModel = SobotCommonGsonUtil.jsonToCommonModel(string);
                if (jsonToCommonModel == null || !"1".equals(jsonToCommonModel.getCode()) || jsonToCommonModel.getData() == null) {
                    postOnError(this.progress, new RuntimeException("服务器异常"));
                    return;
                }
                SobotUploadModelBase data = jsonToCommonModel.getData();
                UploadFileResult obtainUploadFileResult = SobotCommonGsonUtil.obtainUploadFileResult(data.getMsg());
                if (obtainUploadFileResult == null || TextUtils.isEmpty(obtainUploadFileResult.getMsgId())) {
                    postOnError(this.progress, new RuntimeException("服务器异常"));
                    return;
                }
                this.progress.tag = obtainUploadFileResult.getMsgId();
                this.progress.url = obtainUploadFileResult.getUrl();
                postOnFinish(this.progress, data);
            } catch (Exception e) {
                e.printStackTrace();
                postOnError(this.progress, new RuntimeException("服务器异常"));
            }
        } catch (Exception e2) {
            postOnError(this.progress, e2);
        }
    }

    public SobotUploadTask<T> start() {
        if (SobotUpload.getInstance().getTask(this.progress.tag) == null) {
            Log.i(TAG, "you must call SobotUploadTask#save() before SobotUploadTask#start()！");
        }
        if (this.progress.status != 1 && this.progress.status != 2) {
            postOnStart(this.progress);
            postWaiting(this.progress);
            PriorityRunnable priorityRunnable = new PriorityRunnable(this.progress.priority, this);
            this.priorityRunnable = priorityRunnable;
            this.executor.execute(priorityRunnable);
            return this;
        }
        Log.w(TAG, "the task with tag " + this.progress.tag + " is already in the upload queue, current task status is " + this.progress.status);
        return this;
    }

    public SobotUploadTask<T> tmpTag(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.progress.tmpTag = str;
        }
        return this;
    }

    public void unRegister(SobotUploadListener sobotUploadListener) {
        this.listeners.remove(sobotUploadListener.tag);
    }

    public void unRegister(String str) {
        this.listeners.remove(str);
    }
}
