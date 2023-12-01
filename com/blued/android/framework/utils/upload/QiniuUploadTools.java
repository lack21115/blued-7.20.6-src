package com.blued.android.framework.utils.upload;

import android.text.TextUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.ThreadUtils;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.biz.Event;
import com.qiniu.android.common.FixedZone;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UpCancellationSignal;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UpProgressHandler;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.storage.UploadOptions;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/QiniuUploadTools.class */
public class QiniuUploadTools {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/QiniuUploadTools$QiNiuListener.class */
    public interface QiNiuListener {
        void a(String str);

        void a(String str, double d);

        void a(String str, String str2);

        boolean a();
    }

    public static Configuration a(int i, String str, String str2) {
        Configuration.Builder builder = new Configuration.Builder();
        builder.useHttps(true);
        if (1 != i) {
            builder.chunkSize(1048576);
        }
        if (!TextUtils.isEmpty(str)) {
            builder.zone(new FixedZone(new String[]{str, str2}));
        }
        return builder.build();
    }

    public static Configuration a(String str, String str2) {
        Configuration.Builder builder = new Configuration.Builder();
        builder.useHttps(true);
        builder.chunkSize(1048576);
        if (!TextUtils.isEmpty(str)) {
            builder.zone(new FixedZone(new String[]{str, str2}));
        }
        return builder.build();
    }

    public static void a(Configuration configuration, File file, String str, String str2, final QiNiuListener qiNiuListener) {
        final long currentTimeMillis = System.currentTimeMillis();
        (configuration == null ? new UploadManager() : new UploadManager(configuration, 3)).put(file, str, str2, new UpCompletionHandler() { // from class: com.blued.android.framework.utils.upload.QiniuUploadTools.4
            public void complete(String str3, ResponseInfo responseInfo, JSONObject jSONObject) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String jSONObject2 = jSONObject == null ? "null" : jSONObject.toString();
                if (responseInfo != null && responseInfo.isOK()) {
                    Event c = BluedStatistics.c();
                    c.a("QN_UPLOAD", 0L, 0, "time=" + (currentTimeMillis2 - currentTimeMillis) + ",reqId=" + responseInfo.reqId);
                    Logger.a("QiniuUploadUtils", "response = ", jSONObject2);
                    try {
                        String string = jSONObject.getString("name");
                        Logger.a("QiniuUploadUtils", "name = ", string);
                        if (qiNiuListener != null) {
                            qiNiuListener.a(string, str3);
                            return;
                        }
                        return;
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                if (responseInfo != null) {
                    Event c2 = BluedStatistics.c();
                    c2.a("QN_UPLOAD", 0L, 1, "time=" + (currentTimeMillis2 - currentTimeMillis) + ",code=" + responseInfo.statusCode + ",reqId=" + responseInfo.reqId);
                } else {
                    Event c3 = BluedStatistics.c();
                    c3.a("QN_UPLOAD", 0L, 1, "time=" + (currentTimeMillis2 - currentTimeMillis));
                }
                String responseInfo2 = responseInfo == null ? "null" : responseInfo.toString();
                Logger.a("QiniuUploadUtils", " Fail info = " + responseInfo2 + " | response = " + jSONObject2);
                QiNiuListener qiNiuListener2 = qiNiuListener;
                if (qiNiuListener2 != null) {
                    qiNiuListener2.a(str3);
                }
            }
        }, new UploadOptions(new HashMap(), (String) null, false, new UpProgressHandler() { // from class: com.blued.android.framework.utils.upload.QiniuUploadTools.5
            public void progress(String str3, double d) {
                QiNiuListener qiNiuListener2 = QiNiuListener.this;
                if (qiNiuListener2 != null) {
                    qiNiuListener2.a(str3, d);
                }
            }
        }, new UpCancellationSignal() { // from class: com.blued.android.framework.utils.upload.QiniuUploadTools.6
            public boolean isCancelled() {
                return QiNiuListener.this.a();
            }
        }));
    }

    public static void a(Configuration configuration, byte[] bArr, String str, String str2, final QiNiuListener qiNiuListener) {
        final long currentTimeMillis = System.currentTimeMillis();
        (configuration == null ? new UploadManager() : new UploadManager(configuration, 3)).put(bArr, str, str2, new UpCompletionHandler() { // from class: com.blued.android.framework.utils.upload.QiniuUploadTools.1
            public void complete(final String str3, ResponseInfo responseInfo, JSONObject jSONObject) {
                String jSONObject2 = jSONObject == null ? "null" : jSONObject.toString();
                long currentTimeMillis2 = System.currentTimeMillis();
                if (responseInfo != null && responseInfo.isOK()) {
                    Logger.a("QiniuUploadUtils", "response = ", jSONObject2);
                    Event c = BluedStatistics.c();
                    c.a("QN_UPLOAD", 0L, 0, "time=" + (currentTimeMillis2 - currentTimeMillis) + ",reqId=" + responseInfo.reqId);
                    try {
                        final String string = jSONObject.getString("name");
                        Logger.a("QiniuUploadUtils", "name = ", string);
                        ThreadUtils.a(new Runnable() { // from class: com.blued.android.framework.utils.upload.QiniuUploadTools.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (qiNiuListener != null) {
                                    qiNiuListener.a(string, str3);
                                }
                            }
                        });
                        return;
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                if (responseInfo != null) {
                    Event c2 = BluedStatistics.c();
                    c2.a("QN_UPLOAD", 0L, 1, "time=" + (currentTimeMillis2 - currentTimeMillis) + ",code=" + responseInfo.statusCode + ",reqId=" + responseInfo.reqId);
                } else {
                    Event c3 = BluedStatistics.c();
                    c3.a("QN_UPLOAD", 0L, 1, "time=" + (currentTimeMillis2 - currentTimeMillis));
                }
                String responseInfo2 = responseInfo == null ? "null" : responseInfo.toString();
                Logger.a("QiniuUploadUtils", " Fail info = " + responseInfo2 + " | response = " + jSONObject2);
                ThreadUtils.a(new Runnable() { // from class: com.blued.android.framework.utils.upload.QiniuUploadTools.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (qiNiuListener != null) {
                            qiNiuListener.a(str3);
                        }
                    }
                });
            }
        }, new UploadOptions(new HashMap(), (String) null, false, new UpProgressHandler() { // from class: com.blued.android.framework.utils.upload.QiniuUploadTools.2
            public void progress(final String str3, final double d) {
                ThreadUtils.a(new Runnable() { // from class: com.blued.android.framework.utils.upload.QiniuUploadTools.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QiNiuListener.this != null) {
                            QiNiuListener.this.a(str3, d);
                        }
                    }
                });
            }
        }, new UpCancellationSignal() { // from class: com.blued.android.framework.utils.upload.QiniuUploadTools.3
            public boolean isCancelled() {
                return QiNiuListener.this.a();
            }
        }));
    }
}
