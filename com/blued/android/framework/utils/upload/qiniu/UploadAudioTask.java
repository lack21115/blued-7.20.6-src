package com.blued.android.framework.utils.upload.qiniu;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.upload.QiniuUploadExtra;
import com.blued.android.framework.utils.upload.qiniu.IUploadTask;
import com.blued.android.framework.utils.upload.qiniu.UploadBaseTask;
import com.blued.android.framework.utils.upload.qiniu.pool.UploadThreadManager;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/UploadAudioTask.class */
public class UploadAudioTask extends UploadBaseTask {
    private String p;
    private BluedToken q;
    private QiniuUploadExtra r;
    private int s;

    public UploadAudioTask(String str, List<Pair<String, String>> list, String str2, SenderListener senderListener) {
        super(str, senderListener);
        this.s = 0;
        this.c = list;
        this.d.addAll(this.c);
        this.p = str2;
        a(false);
        this.o = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, final IUploadTask.IUploadStateListener iUploadStateListener) {
        synchronized (this) {
            b("获取Task token！");
            QiniuTokenUtils.a(str, i, new BluedUIHttpResponse<BluedEntity<BluedToken, QiniuUploadExtra>>() { // from class: com.blued.android.framework.utils.upload.qiniu.UploadAudioTask.2
                boolean a;

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i2, String str2) {
                    this.a = true;
                    UploadAudioTask uploadAudioTask = UploadAudioTask.this;
                    uploadAudioTask.c("getTaskToken Error ! errorCode:" + i2 + " | errorMessage:" + str2);
                    return super.onUIFailure(i2, str2);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                    IUploadTask.IUploadStateListener iUploadStateListener2 = iUploadStateListener;
                    if (iUploadStateListener2 != null) {
                        iUploadStateListener2.a();
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIStart() {
                    this.a = false;
                    super.onUIStart();
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<BluedToken, QiniuUploadExtra> bluedEntity) {
                    if (!bluedEntity.hasData()) {
                        UploadAudioTask.this.c("getTaskToken Error !  No Data");
                        return;
                    }
                    this.a = false;
                    UploadAudioTask uploadAudioTask = UploadAudioTask.this;
                    uploadAudioTask.b("获取Task token成功！！！ " + bluedEntity.toString());
                    UploadAudioTask.this.q = bluedEntity.data.get(0);
                    UploadAudioTask.this.r = bluedEntity.extra;
                }
            }, null);
        }
    }

    static /* synthetic */ int d(UploadAudioTask uploadAudioTask) {
        int i = uploadAudioTask.s;
        uploadAudioTask.s = i + 1;
        return i;
    }

    private String g() {
        synchronized (this) {
            if (this.q.uploading_keys == null || this.q.uploading_keys.size() <= 0) {
                b("获取key:" + this.q.key);
                return this.q.key;
            }
            b("获取 列表中的key:" + this.q.uploading_keys.get(0));
            return this.q.uploading_keys.remove(0);
        }
    }

    @Override // com.blued.android.framework.utils.upload.qiniu.UploadBaseTask, com.blued.android.framework.utils.upload.qiniu.IUploadTask
    public void a(IUploadTask.IUploadStateListener iUploadStateListener) {
        super.a(iUploadStateListener);
        a(this.p, this.c.size(), new IUploadTask.IUploadStateListener() { // from class: com.blued.android.framework.utils.upload.qiniu.UploadAudioTask.1
            @Override // com.blued.android.framework.utils.upload.qiniu.IUploadTask.IUploadStateListener
            public void a() {
                UploadAudioTask uploadAudioTask = UploadAudioTask.this;
                if (uploadAudioTask.a(uploadAudioTask.q, UploadAudioTask.this.r)) {
                    for (int i = 0; i < UploadAudioTask.this.o; i++) {
                        UploadThreadManager.a().a(new UploadBaseTask.Consumer("upload_consumer" + i));
                    }
                } else if (UploadAudioTask.this.s <= 0) {
                    UploadAudioTask.d(UploadAudioTask.this);
                    UploadAudioTask uploadAudioTask2 = UploadAudioTask.this;
                    uploadAudioTask2.a(uploadAudioTask2.p, UploadAudioTask.this.c.size(), this);
                } else {
                    UploadAudioTask.this.e();
                    if (UploadAudioTask.this.j != null) {
                        UploadAudioTask.this.j.a(UploadAudioTask.this.a(), false, UploadAudioTask.this.c);
                    }
                    if (UploadAudioTask.this.i != null) {
                        UploadAudioTask.this.i.a();
                    }
                }
            }
        });
    }

    @Override // com.blued.android.framework.utils.upload.qiniu.UploadBaseTask
    public void a(String str, String str2, double d) {
        synchronized (this) {
            a((int) (((this.e.size() * 1.0f) / this.c.size()) * 100.0f));
        }
    }

    @Override // com.blued.android.framework.utils.upload.qiniu.UploadBaseTask
    public boolean a(String str) {
        return false;
    }

    @Override // com.blued.android.framework.utils.upload.qiniu.UploadBaseTask
    public void b(IUploadTask.IUploadStateListener iUploadStateListener) {
        Pair<String, String> d = d();
        if (d == null) {
            if (iUploadStateListener != null) {
                iUploadStateListener.a();
                return;
            }
            return;
        }
        b("上传语音");
        String g = g();
        String str = this.q.token;
        if (!TextUtils.isEmpty(g) && !TextUtils.isEmpty(str)) {
            a(g, str, this.r, 2, d, (String) d.first, iUploadStateListener, 0);
            return;
        }
        a(2, "", "", d);
        if (iUploadStateListener != null) {
            iUploadStateListener.a();
        }
    }
}
