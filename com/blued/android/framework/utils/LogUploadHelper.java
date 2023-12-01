package com.blued.android.framework.utils;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.Zip;
import com.blued.android.core.net.HttpManager;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.upload.BluedQiniuToken;
import com.blued.android.framework.utils.upload.QiniuUpload;
import com.blued.android.framework.utils.upload.QiniuUploadExtra;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.qiniu.android.storage.Configuration;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/LogUploadHelper.class */
public class LogUploadHelper {
    private Future<?> b;
    private Application d;
    private File e;
    private String f;
    private OnUploadListener g;
    private String h;

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f10094a = Executors.newSingleThreadExecutor();

    /* renamed from: c  reason: collision with root package name */
    private boolean f10095c = false;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/LogUploadHelper$OnUploadListener.class */
    public interface OnUploadListener {
        void a();

        void a(String str);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/LogUploadHelper$UploadZipResult.class */
    public static class UploadZipResult {
        String zip;
    }

    public LogUploadHelper(Application application) {
        this.d = application;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        b();
        File c2 = c();
        this.e = c2;
        if (c2 == null || !c2.exists()) {
            e();
            return;
        }
        Logger.a("LogUploadHelper", "uploadFile.size=", Long.valueOf(this.e.length()), "\n  path=", this.e.getPath());
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Configuration configuration, String str, String str2) {
        QiniuUploadTools.a(configuration, this.e, str, str2, new QiniuUploadTools.QiNiuListener() { // from class: com.blued.android.framework.utils.LogUploadHelper.3
            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str3) {
                Logger.b("LogUploadHelper", "uploadQiNiu = onFailure", str3);
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.framework.utils.LogUploadHelper.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LogUploadHelper.this.e();
                    }
                });
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str3, double d) {
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(final String str3, String str4) {
                Logger.b("LogUploadHelper", "uploadQiNiu = onSuccess", str3);
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.framework.utils.LogUploadHelper.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (TextUtils.isEmpty(str3)) {
                            LogUploadHelper.this.e();
                        } else {
                            LogUploadHelper.this.a(str3);
                        }
                    }
                });
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public boolean a() {
                Logger.b("LogUploadHelper", "uploadQiNiu = isCanceled", Boolean.valueOf(!LogUploadHelper.this.f10095c));
                return !LogUploadHelper.this.f10095c;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("zip", str);
        HttpManager.b(this.f + "/blued/zip", new BluedUIHttpResponse<BluedEntityA<UploadZipResult>>(null) { // from class: com.blued.android.framework.utils.LogUploadHelper.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UploadZipResult> bluedEntityA) {
                if (bluedEntityA.hasData()) {
                    UploadZipResult uploadZipResult = bluedEntityA.data.get(0);
                    if (uploadZipResult == null || TextUtils.isEmpty(uploadZipResult.zip)) {
                        Logger.d("LogUploadHelper", "upload result zip is empty!!");
                        LogUploadHelper.this.e();
                    } else if (LogUploadHelper.this.g != null) {
                        LogUploadHelper.this.g.a(uploadZipResult.zip);
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                LogUploadHelper.this.e();
                return super.onUIFailure(i, str2);
            }
        }).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x01be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b() {
        /*
            Method dump skipped, instructions count: 457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.utils.LogUploadHelper.b():boolean");
    }

    private File c() {
        File a2 = AppInfo.a((Context) this.d);
        File file = new File(this.d.getFilesDir(), "blued_log.zip");
        if (file.exists()) {
            file.delete();
        }
        try {
            Zip.b(a2.getPath(), file.getPath());
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return file;
        }
    }

    private void d() {
        Map<String, String> a2 = BluedHttpTools.a();
        HttpManager.a(this.f + "/blued/qiniu?filter=token&action=zip", new BluedUIHttpResponse<BluedEntity<BluedQiniuToken, QiniuUploadExtra>>(null) { // from class: com.blued.android.framework.utils.LogUploadHelper.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LogUploadHelper.this.e();
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedQiniuToken, QiniuUploadExtra> bluedEntity) {
                if (bluedEntity.hasData()) {
                    BluedQiniuToken bluedQiniuToken = bluedEntity.data.get(0);
                    if (bluedQiniuToken == null || TextUtils.isEmpty(bluedQiniuToken.key) || TextUtils.isEmpty(bluedQiniuToken.token)) {
                        Logger.d("LogUploadHelper", "token is empty!!");
                        LogUploadHelper.this.e();
                        return;
                    }
                    QiniuUploadExtra qiniuUploadExtra = bluedEntity.extra;
                    Configuration configuration = null;
                    if (qiniuUploadExtra != null) {
                        QiniuUpload qiniuUpload = qiniuUploadExtra.upload;
                        configuration = null;
                        if (qiniuUpload != null) {
                            configuration = QiniuUploadTools.a(qiniuUpload.host, qiniuUpload.backup);
                        }
                    }
                    LogUploadHelper.this.a(configuration, bluedQiniuToken.key, bluedQiniuToken.token);
                }
            }
        }).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        OnUploadListener onUploadListener = this.g;
        if (onUploadListener != null) {
            onUploadListener.a();
        }
    }

    public void a(String str, String str2, OnUploadListener onUploadListener) {
        this.f = str;
        this.h = str2;
        this.g = onUploadListener;
        if (this.b == null) {
            this.b = this.f10094a.submit(new Runnable() { // from class: com.blued.android.framework.utils.LogUploadHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    LogUploadHelper.this.f10095c = true;
                    LogUploadHelper.this.a();
                }
            });
        }
    }
}
