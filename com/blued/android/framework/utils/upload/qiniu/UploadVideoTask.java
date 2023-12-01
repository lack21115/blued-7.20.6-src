package com.blued.android.framework.utils.upload.qiniu;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.utils.upload.qiniu.IUploadTask;
import com.blued.android.framework.utils.upload.qiniu.UploadBaseTask;
import com.blued.android.framework.utils.upload.qiniu.pool.UploadThreadManager;
import com.blued.android.module.base.shortvideo.ITranscodingVideoListener;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/UploadVideoTask.class */
public class UploadVideoTask extends UploadBaseTask {
    private Pair<String, String> p;
    private Pair<String, String> q;
    private String r;
    private final int s;
    private double t;
    private boolean u;
    private String v;
    private String w;

    public UploadVideoTask(String str, String str2, String str3, Pair<String, String> pair, Pair<String, String> pair2, SenderListener senderListener) {
        super(str, senderListener);
        this.s = 50;
        this.t = 0.0d;
        this.u = true;
        this.p = pair;
        this.q = pair2;
        this.w = str2;
        this.v = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g() {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.utils.upload.qiniu.UploadVideoTask.g():void");
    }

    @Override // com.blued.android.framework.utils.upload.qiniu.UploadBaseTask, com.blued.android.framework.utils.upload.qiniu.IUploadTask
    public void a(IUploadTask.IUploadStateListener iUploadStateListener) {
        super.a(iUploadStateListener);
        this.u = true;
        UploadThreadManager.a().a(new ThreadExecutor("transcodingVideo_thread") { // from class: com.blued.android.framework.utils.upload.qiniu.UploadVideoTask.1
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                UploadVideoTask.this.b("走转码流程!!!");
                ShortVideoProxy.e().a((String) UploadVideoTask.this.q.first, new ITranscodingVideoListener() { // from class: com.blued.android.framework.utils.upload.qiniu.UploadVideoTask.1.1
                    @Override // com.blued.android.module.base.shortvideo.ITranscodingVideoListener
                    public void a(String str, double d) {
                        if (UploadVideoTask.this.m) {
                            return;
                        }
                        double d2 = (d * 50.0d) / 100.0d;
                        if (d2 > UploadVideoTask.this.t) {
                            UploadVideoTask.this.t = d2;
                            UploadVideoTask.this.a(d2);
                        }
                    }

                    @Override // com.blued.android.module.base.shortvideo.ITranscodingVideoListener
                    public void a(String str, boolean z) {
                        if (z) {
                            UploadVideoTask.this.b("需要转码,转码中...");
                            return;
                        }
                        UploadVideoTask.this.b("不需要转码,开启任务消费");
                        UploadVideoTask.this.u = z;
                        UploadVideoTask.this.g();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= UploadVideoTask.this.o) {
                                return;
                            }
                            UploadVideoTask uploadVideoTask = UploadVideoTask.this;
                            UploadThreadManager.a().a(new UploadBaseTask.Consumer("upload_consumer" + i2));
                            i = i2 + 1;
                        }
                    }

                    @Override // com.blued.android.module.base.shortvideo.ITranscodingVideoListener
                    public void a(boolean z, String str, String str2) {
                        if (UploadVideoTask.this.m) {
                            return;
                        }
                        if (!z) {
                            UploadVideoTask.this.c("需要转码,转码失败！！！");
                            UploadVideoTask.this.e();
                            if (UploadVideoTask.this.j != null) {
                                UploadVideoTask.this.j.a(UploadVideoTask.this.a(), false, UploadVideoTask.this.c);
                            }
                            if (UploadVideoTask.this.i != null) {
                                UploadVideoTask.this.i.a();
                                return;
                            }
                            return;
                        }
                        UploadVideoTask.this.b("需要转码,并转码成功！！！");
                        UploadVideoTask.this.a(50.0d);
                        UploadVideoTask.this.r = str2;
                        UploadVideoTask.this.g();
                        for (int i = 0; i < UploadVideoTask.this.o; i++) {
                            UploadThreadManager.a().a(new UploadBaseTask.Consumer("upload_consumer" + i));
                        }
                    }
                });
            }
        });
    }

    @Override // com.blued.android.framework.utils.upload.qiniu.UploadBaseTask
    public void a(String str, String str2, double d) {
        synchronized (this) {
            Long l = this.f.get(str);
            long longValue = l == null ? 0L : l.longValue();
            if (longValue > 0) {
                String str3 = str + str2;
                long j = (long) (longValue * d);
                Long l2 = this.g.get(str3);
                if ((l2 == null ? 0L : l2.longValue()) < j) {
                    this.g.put(str3, Long.valueOf(j));
                    long j2 = 0;
                    for (Long l3 : this.g.values()) {
                        j2 += l3.longValue();
                    }
                    double d2 = ((((float) j2) * 1.0f) / ((float) this.k)) * (this.u ? 50 : 100);
                    double d3 = d2;
                    if (this.u) {
                        d3 = d2 + 50.0d;
                    }
                    a(d3);
                }
            }
        }
    }

    @Override // com.blued.android.framework.utils.upload.qiniu.UploadBaseTask
    public boolean a(String str) {
        long j;
        if (this.f.containsKey(str)) {
            j = this.f.get(str).longValue();
            b("上传文件大小:" + j);
        } else {
            j = 0;
        }
        return j >= 3145728;
    }

    @Override // com.blued.android.framework.utils.upload.qiniu.UploadBaseTask, com.blued.android.framework.utils.upload.qiniu.IUploadTask
    public void b() {
        super.b();
        ShortVideoProxy.e().d();
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
        b("上传视频任务!!!");
        if (TextUtils.isEmpty((CharSequence) d.first)) {
            if (iUploadStateListener != null) {
                iUploadStateListener.a();
            }
        } else if (!((String) d.second).equals(String.valueOf(1))) {
            b("上传视频封面");
            a(this.w, 0, true, this.p, iUploadStateListener);
        } else {
            Pair<String, String> pair = this.q;
            if (pair == null || TextUtils.isEmpty((CharSequence) pair.first)) {
                b("视频文件路径有错");
                a(1, "", "", this.q);
                if (iUploadStateListener != null) {
                    iUploadStateListener.a();
                    return;
                }
                return;
            }
            b("上传视频");
            if (!TextUtils.isEmpty(this.r)) {
                a(this.v, 1, this.q, this.r, iUploadStateListener);
                return;
            }
            String str = this.v;
            Pair<String, String> pair2 = this.q;
            a(str, 1, pair2, (String) pair2.first, iUploadStateListener);
        }
    }
}
