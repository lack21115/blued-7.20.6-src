package com.blued.android.framework.utils.upload.qiniu;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.utils.upload.QiniuUploadExtra;
import com.blued.android.framework.utils.upload.qiniu.IUploadTask;
import com.blued.android.framework.utils.upload.qiniu.UploadBaseTask;
import com.blued.android.framework.utils.upload.qiniu.pool.UploadThreadManager;
import java.io.File;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/UploadImageTask.class */
public class UploadImageTask extends UploadBaseTask {
    private String p;
    private BluedToken q;
    private QiniuUploadExtra r;
    private boolean s;
    private int t;

    public UploadImageTask(String str, List<Pair<String, String>> list, String str2, boolean z, SenderListener senderListener) {
        super(str, senderListener);
        this.s = false;
        this.t = 0;
        this.c = list;
        this.d.addAll(this.c);
        this.p = str2;
        this.s = z;
        if (list != null) {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            int i = 2;
            if (availableProcessors > 0) {
                i = (int) ((availableProcessors * 2.0f) / 3.0f);
                if (i <= 0) {
                    i = 2;
                }
            }
            if (list.size() >= i) {
                this.o = i;
            } else {
                this.o = list.size();
            }
            if (list.size() == 1) {
                this.s = true;
            }
        }
        b("是否进行单文件进度回调:" + this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, final IUploadTask.IUploadStateListener iUploadStateListener) {
        synchronized (this) {
            b("获取Task token！");
            QiniuTokenUtils.a(str, i, new BluedUIHttpResponse<BluedEntity<BluedToken, QiniuUploadExtra>>() { // from class: com.blued.android.framework.utils.upload.qiniu.UploadImageTask.2
                boolean a;

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i2, String str2) {
                    this.a = true;
                    UploadImageTask uploadImageTask = UploadImageTask.this;
                    uploadImageTask.c("getTaskToken Error ! errorCode:" + i2 + " | errorMessage:" + str2);
                    if (AppInfo.p()) {
                        return true;
                    }
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
                        UploadImageTask.this.c("getTaskToken Error !  No Data");
                        return;
                    }
                    this.a = false;
                    UploadImageTask uploadImageTask = UploadImageTask.this;
                    uploadImageTask.b("获取Task token成功！！！ " + bluedEntity.toString());
                    UploadImageTask.this.q = bluedEntity.data.get(0);
                    UploadImageTask.this.r = bluedEntity.extra;
                }
            }, null);
        }
    }

    static /* synthetic */ int f(UploadImageTask uploadImageTask) {
        int i = uploadImageTask.t;
        uploadImageTask.t = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.o) {
                return;
            }
            UploadThreadManager.a().a(new UploadBaseTask.Consumer("upload_consumer" + i2));
            i = i2 + 1;
        }
    }

    private String h() {
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
        a(this.p, this.c.size(), new IUploadTask.IUploadStateListener() { // from class: com.blued.android.framework.utils.upload.qiniu.UploadImageTask.1
            @Override // com.blued.android.framework.utils.upload.qiniu.IUploadTask.IUploadStateListener
            public void a() {
                UploadImageTask uploadImageTask = UploadImageTask.this;
                if (uploadImageTask.a(uploadImageTask.q, UploadImageTask.this.r)) {
                    if (UploadImageTask.this.s) {
                        UploadThreadManager.a().a(new ThreadExecutor("readFileSize_thread") { // from class: com.blued.android.framework.utils.upload.qiniu.UploadImageTask.1.1
                            @Override // com.blued.android.framework.pool.ThreadExecutor
                            public void execute() {
                                for (Pair<String, String> pair : UploadImageTask.this.c) {
                                    if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first)) {
                                        File file = new File((String) pair.first);
                                        if (file.exists()) {
                                            long length = file.length();
                                            UploadImageTask uploadImageTask2 = UploadImageTask.this;
                                            uploadImageTask2.b(((String) pair.first) + "大小:" + length);
                                            UploadImageTask uploadImageTask3 = UploadImageTask.this;
                                            uploadImageTask3.k = uploadImageTask3.k + length;
                                            UploadImageTask.this.f.put((String) pair.first, Long.valueOf(length));
                                        }
                                    }
                                }
                                UploadImageTask uploadImageTask4 = UploadImageTask.this;
                                uploadImageTask4.b("上传文件总大小:" + UploadImageTask.this.k);
                                UploadImageTask.this.g();
                            }
                        });
                    } else {
                        UploadImageTask.this.g();
                    }
                } else if (UploadImageTask.this.t <= 0) {
                    UploadImageTask.f(UploadImageTask.this);
                    UploadImageTask uploadImageTask2 = UploadImageTask.this;
                    uploadImageTask2.a(uploadImageTask2.p, UploadImageTask.this.c.size(), this);
                } else {
                    UploadImageTask.this.e();
                    if (UploadImageTask.this.j != null) {
                        UploadImageTask.this.j.a(UploadImageTask.this.a(), false, UploadImageTask.this.c);
                    }
                    if (UploadImageTask.this.i != null) {
                        UploadImageTask.this.i.a();
                    }
                }
            }
        });
    }

    @Override // com.blued.android.framework.utils.upload.qiniu.UploadBaseTask
    public void a(String str, String str2, double d) {
        synchronized (this) {
            if (this.s) {
                String str3 = str + str2;
                Long l = this.f.get(str);
                long longValue = l == null ? 0L : l.longValue();
                if (longValue > 0) {
                    long j = (long) (longValue * d);
                    b("updateUploadProcess | finishFileSize：" + j + " | uploadFileSize：" + longValue + " | originalPath：" + str);
                    Long l2 = this.g.get(str3);
                    if (j > (l2 == null ? 0L : l2.longValue())) {
                        this.g.put(str3, Long.valueOf(j));
                        long j2 = 0;
                        for (Long l3 : this.g.values()) {
                            j2 += l3.longValue();
                        }
                        b("updateUploadProcess | uploadFinishSize：" + j2 + " | totalSize：" + this.k);
                        a((double) ((((float) j2) * 100.0f) / ((float) this.k)));
                    }
                }
            } else {
                a(((this.e.size() * 1.0f) * 100.0f) / this.c.size());
            }
        }
    }

    @Override // com.blued.android.framework.utils.upload.qiniu.UploadBaseTask
    public boolean a(String str) {
        return this.s;
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
        b("上传图片");
        String h = h();
        String str = this.q.token;
        if (TextUtils.isEmpty(h) || TextUtils.isEmpty(str)) {
            a(0, "", "", d);
            if (iUploadStateListener != null) {
                iUploadStateListener.a();
            }
        } else if (this.l) {
            a(h, str, this.r, d, iUploadStateListener, 0, 0);
        } else {
            a(h, str, this.r, 0, d, (String) d.first, iUploadStateListener, 0);
        }
    }
}
