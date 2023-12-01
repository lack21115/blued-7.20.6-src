package com.blued.android.framework.utils.upload.qiniu;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/IUploadTask.class */
public interface IUploadTask {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/IUploadTask$IUploadStateListener.class */
    public interface IUploadStateListener {
        void a();
    }

    String a();

    void a(IUploadStateListener iUploadStateListener);

    void a(boolean z);

    void b();
}
