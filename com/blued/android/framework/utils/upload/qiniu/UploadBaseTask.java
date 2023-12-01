package com.blued.android.framework.utils.upload.qiniu;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.utils.Houyi;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.ThreadUtils;
import com.blued.android.framework.utils.upload.QiniuUpload;
import com.blued.android.framework.utils.upload.QiniuUploadExtra;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.framework.utils.upload.qiniu.IUploadTask;
import com.blued.android.framework.utils.upload.qiniu.UploadProcessManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/UploadBaseTask.class */
public abstract class UploadBaseTask implements IUploadTask, UploadProcessManager.IUpdateProcessListener {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f10136a = UploadVideoTask.class.getSimpleName();
    protected String b;
    protected List<Pair<String, String>> h;
    protected IUploadTask.IUploadStateListener i;
    protected SenderListener j;
    protected UploadProcessManager n;

    /* renamed from: c  reason: collision with root package name */
    protected List<Pair<String, String>> f10137c = new ArrayList();
    protected List<Pair<String, String>> d = new ArrayList();
    protected List<Pair<String, String>> e = new ArrayList();
    protected Map<String, Long> f = new HashMap();
    protected Map<String, Long> g = new HashMap();
    protected long k = 0;
    protected boolean l = true;
    protected boolean m = false;
    protected int o = 2;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/UploadBaseTask$Consumer.class */
    public class Consumer extends ThreadExecutor {
        public Consumer(String str) {
            super(str);
        }

        @Override // com.blued.android.framework.pool.ThreadExecutor
        public void execute() {
            UploadBaseTask.this.d(getThreadName());
        }
    }

    public UploadBaseTask(String str, SenderListener senderListener) {
        this.b = str;
        this.j = senderListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str) {
        if (this.m) {
            b("取消任务 消费者 " + str + " 退出");
            return;
        }
        b(str + ":消费者消费任务");
        if (!c()) {
            b("没可上传文件!!!");
            return;
        }
        b("有待上传文件!!!");
        b(new IUploadTask.IUploadStateListener() { // from class: com.blued.android.framework.utils.upload.qiniu.UploadBaseTask.7
            @Override // com.blued.android.framework.utils.upload.qiniu.IUploadTask.IUploadStateListener
            public void a() {
                UploadBaseTask.this.d(str);
            }
        });
    }

    @Override // com.blued.android.framework.utils.upload.qiniu.IUploadTask
    public String a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(double d) {
        UploadProcessManager uploadProcessManager = this.n;
        if (uploadProcessManager != null) {
            uploadProcessManager.a(d);
        }
    }

    @Override // com.blued.android.framework.utils.upload.qiniu.UploadProcessManager.IUpdateProcessListener
    public void a(final int i) {
        a(new Runnable() { // from class: com.blued.android.framework.utils.upload.qiniu.UploadBaseTask.6
            @Override // java.lang.Runnable
            public void run() {
                UploadBaseTask uploadBaseTask = UploadBaseTask.this;
                uploadBaseTask.b("更新进度runInUIThread:" + i + "%");
                if (UploadBaseTask.this.j != null) {
                    UploadBaseTask.this.j.a(UploadBaseTask.this.a(), i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, String str, String str2, Pair<String, String> pair) {
        synchronized (this) {
            this.e.add(pair);
            if (!TextUtils.isEmpty(pair.first) && !TextUtils.isEmpty(pair.second)) {
                a(pair.first, str2, 1.0d);
                UploadModel uploadModel = new UploadModel();
                uploadModel.url = pair.second;
                uploadModel.compressPath = str;
                uploadModel.type = i;
                final Pair pair2 = new Pair(pair.first, uploadModel);
                b("更新记录并回调:" + pair2.toString());
                a(new Runnable() { // from class: com.blued.android.framework.utils.upload.qiniu.UploadBaseTask.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UploadBaseTask.this.j != null) {
                            UploadBaseTask.this.j.a(UploadBaseTask.this.a(), pair2);
                        }
                    }
                });
                f();
            }
            if (this.h == null) {
                this.h = new ArrayList();
            }
            this.h.add(pair);
            UploadModel uploadModel2 = new UploadModel();
            uploadModel2.url = pair.second;
            uploadModel2.compressPath = str;
            uploadModel2.type = i;
            final Pair pair22 = new Pair(pair.first, uploadModel2);
            b("更新记录并回调:" + pair22.toString());
            a(new Runnable() { // from class: com.blued.android.framework.utils.upload.qiniu.UploadBaseTask.4
                @Override // java.lang.Runnable
                public void run() {
                    if (UploadBaseTask.this.j != null) {
                        UploadBaseTask.this.j.a(UploadBaseTask.this.a(), pair22);
                    }
                }
            });
            f();
        }
    }

    @Override // com.blued.android.framework.utils.upload.qiniu.IUploadTask
    public void a(IUploadTask.IUploadStateListener iUploadStateListener) {
        this.i = iUploadStateListener;
        this.n = new UploadProcessManager(this);
    }

    protected void a(Runnable runnable) {
        ThreadUtils.a(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, int i, Pair<String, String> pair, String str2, IUploadTask.IUploadStateListener iUploadStateListener) {
        synchronized (this) {
            a(str, i, false, pair, str2, iUploadStateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, int i, boolean z, Pair<String, String> pair, IUploadTask.IUploadStateListener iUploadStateListener) {
        synchronized (this) {
            a(str, i, z, pair, pair.first, iUploadStateListener);
        }
    }

    protected void a(String str, final int i, final boolean z, final Pair<String, String> pair, final String str2, final IUploadTask.IUploadStateListener iUploadStateListener) {
        synchronized (this) {
            b("获取token！");
            QiniuTokenUtils.a(str, 1, new BluedUIHttpResponse<BluedEntity<BluedToken, QiniuUploadExtra>>() { // from class: com.blued.android.framework.utils.upload.qiniu.UploadBaseTask.3

                /* renamed from: a  reason: collision with root package name */
                boolean f10144a;
                String b;

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i2, String str3) {
                    this.f10144a = true;
                    UploadBaseTask uploadBaseTask = UploadBaseTask.this;
                    uploadBaseTask.c("getToken Error ! errorCode:" + i2 + " | errorMessage:" + str3);
                    return super.onUIFailure(i2, str3);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                    if (this.f10144a) {
                        UploadBaseTask.this.a(0, str2, this.b, pair);
                        IUploadTask.IUploadStateListener iUploadStateListener2 = iUploadStateListener;
                        if (iUploadStateListener2 != null) {
                            iUploadStateListener2.a();
                        }
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIStart() {
                    this.f10144a = false;
                    super.onUIStart();
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<BluedToken, QiniuUploadExtra> bluedEntity) {
                    if (!bluedEntity.hasData()) {
                        this.f10144a = true;
                        UploadBaseTask.this.c("getToken Error !  No Data");
                        return;
                    }
                    this.f10144a = false;
                    UploadBaseTask uploadBaseTask = UploadBaseTask.this;
                    uploadBaseTask.b("获取token成功！！！ " + bluedEntity.toString());
                    BluedToken bluedToken = bluedEntity.data.get(0);
                    QiniuUploadExtra qiniuUploadExtra = bluedEntity.extra;
                    if (UploadBaseTask.this.a(bluedToken, qiniuUploadExtra)) {
                        String str3 = bluedToken.key;
                        this.b = str3;
                        if (z) {
                            UploadBaseTask.this.a(str3, bluedToken.token, qiniuUploadExtra, pair, iUploadStateListener, 0, 0);
                        } else {
                            UploadBaseTask.this.a(str3, bluedToken.token, qiniuUploadExtra, i, pair, str2, iUploadStateListener, 0);
                        }
                    }
                }
            }, null);
        }
    }

    abstract void a(String str, String str2, double d);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final String str, final String str2, final QiniuUploadExtra qiniuUploadExtra, final int i, final Pair<String, String> pair, final String str3, final IUploadTask.IUploadStateListener iUploadStateListener, final int i2) {
        b("开始走上传流程:" + pair.first);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            a(i, str3, str, new Pair<>(pair.first, ""));
            if (iUploadStateListener != null) {
                iUploadStateListener.a();
            }
        } else if (pair == null || TextUtils.isEmpty(pair.first)) {
            if (iUploadStateListener != null) {
                iUploadStateListener.a();
            }
        } else {
            QiniuUpload qiniuUpload = new QiniuUpload();
            QiniuUpload qiniuUpload2 = qiniuUpload;
            if (qiniuUploadExtra != null) {
                qiniuUpload2 = qiniuUpload;
                if (qiniuUploadExtra.upload != null) {
                    qiniuUpload2 = qiniuUploadExtra.upload;
                }
            }
            final boolean a2 = a(pair.first);
            QiniuUploadUtils.a(i, qiniuUpload2.host, qiniuUpload2.backup, str3, str, str2, new QiniuUploadTools.QiNiuListener() { // from class: com.blued.android.framework.utils.upload.qiniu.UploadBaseTask.1
                @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
                public void a(String str4) {
                    if (i2 <= 0) {
                        UploadBaseTask uploadBaseTask = UploadBaseTask.this;
                        uploadBaseTask.c("上传第一次失败: " + ((String) pair.first));
                        UploadBaseTask.this.a(str, str2, qiniuUploadExtra, i, pair, str3, iUploadStateListener, i2 + 1);
                        return;
                    }
                    Pair<String, String> pair2 = new Pair<>((String) pair.first, "");
                    UploadBaseTask uploadBaseTask2 = UploadBaseTask.this;
                    uploadBaseTask2.c("上传第二次失败:" + pair2.toString());
                    UploadBaseTask.this.a(i, str3, str, pair2);
                    IUploadTask.IUploadStateListener iUploadStateListener2 = iUploadStateListener;
                    if (iUploadStateListener2 != null) {
                        iUploadStateListener2.a();
                    }
                }

                @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
                public void a(String str4, double d) {
                    if (a2) {
                        UploadBaseTask uploadBaseTask = UploadBaseTask.this;
                        uploadBaseTask.b("onProgress:" + d + " | " + ((String) pair.first));
                        UploadBaseTask.this.a((String) pair.first, str, d);
                    }
                }

                @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
                public void a(String str4, String str5) {
                    UploadBaseTask uploadBaseTask = UploadBaseTask.this;
                    uploadBaseTask.b("上传完成 url:" + str4 + " | originalPath:" + ((String) pair.first));
                    UploadBaseTask.this.a(i, str3, str, new Pair<>((String) pair.first, str4));
                    UploadBaseTask.this.a(new Runnable() { // from class: com.blued.android.framework.utils.upload.qiniu.UploadBaseTask.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (iUploadStateListener != null) {
                                iUploadStateListener.a();
                            }
                        }
                    });
                }

                @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
                public boolean a() {
                    return UploadBaseTask.this.m;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final String str, final String str2, final QiniuUploadExtra qiniuUploadExtra, final Pair<String, String> pair, final IUploadTask.IUploadStateListener iUploadStateListener, final int i, final int i2) {
        if (TextUtils.isEmpty(pair.second)) {
            final String e = RecyclingUtils.e(pair.first);
            b("压缩图:" + pair.first + " | 压缩后地址：" + e);
            Houyi.a().a(pair.first, e).a(new Houyi.OnCompressListener() { // from class: com.blued.android.framework.utils.upload.qiniu.UploadBaseTask.2
                @Override // com.blued.android.framework.utils.Houyi.OnCompressListener
                public void a() {
                }

                @Override // com.blued.android.framework.utils.Houyi.OnCompressListener
                public void a(String str3) {
                    UploadBaseTask uploadBaseTask = UploadBaseTask.this;
                    uploadBaseTask.b("压缩完成:" + str3);
                    UploadBaseTask.this.a(str, str2, qiniuUploadExtra, 0, pair, e, iUploadStateListener, 0);
                }

                @Override // com.blued.android.framework.utils.Houyi.OnCompressListener
                public void a(Throwable th) {
                    if (i <= 1) {
                        UploadBaseTask uploadBaseTask = UploadBaseTask.this;
                        uploadBaseTask.c("第一次压缩失败:" + ((String) pair.first) + " | " + th.toString());
                        UploadBaseTask.this.a(str, str2, qiniuUploadExtra, pair, iUploadStateListener, i + 1, i2);
                        return;
                    }
                    UploadBaseTask uploadBaseTask2 = UploadBaseTask.this;
                    uploadBaseTask2.c("第二次压缩失败:" + ((String) pair.first) + " | " + th.toString());
                    UploadBaseTask.this.a(0, (String) pair.first, str, new Pair<>((String) pair.first, ""));
                    UploadBaseTask uploadBaseTask3 = UploadBaseTask.this;
                    uploadBaseTask3.b("回调上传失败:" + ((String) pair.first));
                    UploadBaseTask.this.a(new Runnable() { // from class: com.blued.android.framework.utils.upload.qiniu.UploadBaseTask.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (iUploadStateListener != null) {
                                iUploadStateListener.a();
                            }
                        }
                    });
                }
            }).a();
            return;
        }
        b("检测当前图已上传完成 更新记录:" + pair.first);
        a(0, pair.first, str, new Pair<>(pair.first, pair.second));
        if (iUploadStateListener != null) {
            iUploadStateListener.a();
        }
    }

    @Override // com.blued.android.framework.utils.upload.qiniu.IUploadTask
    public void a(boolean z) {
        this.l = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(BluedToken bluedToken, QiniuUploadExtra qiniuUploadExtra) {
        QiniuUpload qiniuUpload;
        if (bluedToken == null || TextUtils.isEmpty(bluedToken.token)) {
            return false;
        }
        if (AppInfo.p()) {
            return true;
        }
        return (qiniuUploadExtra == null || qiniuUploadExtra.upload == null || (qiniuUpload = qiniuUploadExtra.upload) == null || TextUtils.isEmpty(qiniuUpload.host)) ? false : true;
    }

    abstract boolean a(String str);

    @Override // com.blued.android.framework.utils.upload.qiniu.IUploadTask
    public void b() {
        synchronized (this) {
            this.m = true;
            if (this.n != null) {
                this.n.c();
            }
            if (this.d != null) {
                this.d.clear();
            }
        }
    }

    abstract void b(IUploadTask.IUploadStateListener iUploadStateListener);

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        if (AppInfo.m()) {
            Logger.c(MediaSender.f10132a, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str) {
        if (AppInfo.m()) {
            Logger.e(MediaSender.f10132a, str);
        }
    }

    protected boolean c() {
        synchronized (this) {
            b("判断是否有下一个上传文件 mUploadRecordList.size():" + this.d.size());
            return this.d.size() > 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Pair<String, String> d() {
        synchronized (this) {
            if (this.d.size() > 0) {
                b("获取下一个文件 mUploadRecordList.size():" + this.d.size());
                return this.d.remove(0);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        UploadProcessManager uploadProcessManager = this.n;
        if (uploadProcessManager != null) {
            uploadProcessManager.a();
        }
    }

    protected void f() {
        Pair pair;
        synchronized (this) {
            if (this.e.size() >= this.f10137c.size()) {
                boolean z = true;
                if (this.h != null) {
                    z = true;
                    if (this.h.size() > 0) {
                        z = false;
                    }
                }
                final ArrayList arrayList = new ArrayList();
                String str = "";
                for (Pair<String, String> pair2 : this.f10137c) {
                    Iterator<Pair<String, String>> it = this.e.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Pair<String, String> next = it.next();
                        if (next != null && pair2.first.equals(next.first)) {
                            arrayList.add(new Pair(pair2.first, next.second));
                            str = str + pair.toString();
                            break;
                        }
                    }
                }
                e();
                b("任务完成 taskId: " + a() + " | isSuccess:" + z + " | uploadLocalPathToUrlList:" + str);
                final boolean z2 = z;
                a(new Runnable() { // from class: com.blued.android.framework.utils.upload.qiniu.UploadBaseTask.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UploadBaseTask.this.j != null) {
                            if (z2) {
                                UploadBaseTask.this.j.a(UploadBaseTask.this.a(), 100);
                            }
                            UploadBaseTask.this.j.a(UploadBaseTask.this.a(), z2, arrayList);
                        }
                        if (UploadBaseTask.this.i != null) {
                            UploadBaseTask.this.i.a();
                        }
                    }
                });
            }
        }
    }
}
