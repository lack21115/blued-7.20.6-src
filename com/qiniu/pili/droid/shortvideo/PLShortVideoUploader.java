package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.KeyGenerator;
import com.qiniu.android.storage.Recorder;
import com.qiniu.android.storage.UpCancellationSignal;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UpProgressHandler;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.storage.UploadOptions;
import com.qiniu.android.storage.persistent.FileRecorder;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.io.File;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLShortVideoUploader.class */
public final class PLShortVideoUploader {
    private static final String TAG = "PLShortVideoUploader";
    private Recorder mRecorder;
    private UploadManager mUploadManager;
    private UploadOptions mUploadOptions;
    private PLUploadProgressListener mUploadProgressListener;
    private PLUploadResultListener mUploadResultListener;
    private volatile boolean mIsCancelled = false;
    private UpCancellationSignal mUpLoadCancellationSignal = new UpCancellationSignal() { // from class: com.qiniu.pili.droid.shortvideo.PLShortVideoUploader.2
        @Override // com.qiniu.android.http.CancellationHandler
        public boolean isCancelled() {
            return PLShortVideoUploader.this.mIsCancelled;
        }
    };
    private UpProgressHandler mUpLoadProgressHandler = new UpProgressHandler() { // from class: com.qiniu.pili.droid.shortvideo.PLShortVideoUploader.3
        @Override // com.qiniu.android.storage.UpProgressHandler
        public void progress(String str, double d) {
            if (PLShortVideoUploader.this.mUploadProgressListener != null) {
                PLShortVideoUploader.this.mUploadProgressListener.onUploadProgress(str, d);
            }
        }
    };
    private UpCompletionHandler mUpLoadCompletionHandler = new UpCompletionHandler() { // from class: com.qiniu.pili.droid.shortvideo.PLShortVideoUploader.4
        @Override // com.qiniu.android.storage.UpCompletionHandler
        public void complete(String str, ResponseInfo responseInfo, JSONObject jSONObject) {
            if (PLShortVideoUploader.this.mUploadResultListener != null) {
                if (responseInfo.isOK()) {
                    PLShortVideoUploader.this.mUploadResultListener.onUploadVideoSuccess(jSONObject);
                } else {
                    PLShortVideoUploader.this.mUploadResultListener.onUploadVideoFailed(responseInfo.statusCode, responseInfo.error);
                }
            }
        }
    };

    public PLShortVideoUploader(Context context, PLUploadSetting pLUploadSetting) {
        this.mRecorder = null;
        QosManager.a(context).a(QosManager.KeyPoint.upload_init);
        try {
            this.mRecorder = new FileRecorder(context.getCacheDir().getPath());
        } catch (Exception e) {
            e.o.e(TAG, e.getMessage());
        }
        KeyGenerator keyGenerator = new KeyGenerator() { // from class: com.qiniu.pili.droid.shortvideo.PLShortVideoUploader.1
            @Override // com.qiniu.android.storage.KeyGenerator
            public String gen(String str, File file) {
                return str + "_._" + ((Object) new StringBuffer(file.getAbsolutePath()).reverse());
            }
        };
        if (this.mUploadManager == null) {
            this.mUploadManager = new UploadManager(new Configuration.Builder().chunkSize(pLUploadSetting.getChunkSize()).putThreshhold(pLUploadSetting.getPutThreshhold()).connectTimeout(pLUploadSetting.getConnectTimeout()).responseTimeout(pLUploadSetting.getResponseTimeout()).recorder(this.mRecorder, keyGenerator).zone(pLUploadSetting.getZone()).useHttps(pLUploadSetting.isHttpsEnabled()).build());
        }
        this.mUploadOptions = new UploadOptions(pLUploadSetting.getParams(), null, false, this.mUpLoadProgressHandler, this.mUpLoadCancellationSignal);
    }

    public void cancelUpload() {
        e.o.c(TAG, "cancel upload");
        this.mIsCancelled = true;
    }

    public void setUploadProgressListener(PLUploadProgressListener pLUploadProgressListener) {
        this.mUploadProgressListener = pLUploadProgressListener;
    }

    public void setUploadResultListener(PLUploadResultListener pLUploadResultListener) {
        this.mUploadResultListener = pLUploadResultListener;
    }

    public void startUpload(String str, String str2) {
        startUpload(str, null, str2);
    }

    public void startUpload(String str, String str2, String str3) {
        QosManager.a().a(QosManager.KeyPoint.upload_video);
        e.o.c(TAG, "start upload");
        this.mIsCancelled = false;
        this.mUploadManager.put(str, str2, str3, this.mUpLoadCompletionHandler, this.mUploadOptions);
    }
}
