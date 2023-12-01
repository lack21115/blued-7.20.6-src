package com.blued.android.module.live.base.utils;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.net.HttpManager;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.live.base.model.LiveQiniuTokenModel;
import com.blued.android.module.live.base.model.LiveSettingConfigModel;
import com.qiniu.android.storage.Configuration;
import java.io.File;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/utils/LiveSettingConfig.class */
public class LiveSettingConfig {
    private LiveSettingConfigModel a;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/utils/LiveSettingConfig$SettingConfig.class */
    public static class SettingConfig {
        public static LiveSettingConfig a = new LiveSettingConfig();
    }

    public static LiveSettingConfig a() {
        return SettingConfig.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return;
        }
        QiniuUploadTools.a((Configuration) null, new File(str2), str3, str4, new QiniuUploadTools.QiNiuListener() { // from class: com.blued.android.module.live.base.utils.LiveSettingConfig.3
            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str5) {
                Log.i("==xpmm", "uploadQiniu onFailure: " + str5);
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str5, double d) {
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str5, String str6) {
                Log.i("==xpmm", "onSuccess:" + str2 + "  url:" + str5);
                LiveSettingConfig.this.b(str, str5, str2);
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public boolean a() {
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, final String str3) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("zip", str2);
        HttpManager.b(str, new BluedUIHttpResponse<BluedEntityA<Object>>(null) { // from class: com.blued.android.module.live.base.utils.LiveSettingConfig.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                File file = new File(str3);
                if (file.exists()) {
                    file.delete();
                }
            }
        }).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).h();
    }

    public void a(String str) {
        HttpManager.a(str, new BluedUIHttpResponse<BluedEntityA<LiveSettingConfigModel>>(null) { // from class: com.blued.android.module.live.base.utils.LiveSettingConfig.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveSettingConfigModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.getSingleData() == null) {
                    return;
                }
                LiveSettingConfig.this.a = bluedEntityA.getSingleData();
                if (LiveSettingConfig.this.a != null) {
                    Log.i("==xpmm", "updateSettingConfig :" + LiveSettingConfig.this.a.log);
                }
            }
        }).b(BluedHttpTools.a(true)).h();
    }

    public void a(String str, final String str2, final String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !new File(str3).exists()) {
            return;
        }
        HttpManager.a(str, new BluedUIHttpResponse<BluedEntityA<LiveQiniuTokenModel>>(null) { // from class: com.blued.android.module.live.base.utils.LiveSettingConfig.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveQiniuTokenModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.getSingleData() == null) {
                    return;
                }
                LiveSettingConfig.this.a(str2, str3, bluedEntityA.getSingleData().key, bluedEntityA.getSingleData().token);
            }
        }).b(BluedHttpTools.a(true)).h();
    }

    public boolean b() {
        LiveSettingConfigModel liveSettingConfigModel = this.a;
        boolean z = false;
        if (liveSettingConfigModel == null) {
            return false;
        }
        if (liveSettingConfigModel.log == 1) {
            z = true;
        }
        return z;
    }

    public boolean c() {
        LiveSettingConfigModel liveSettingConfigModel = this.a;
        boolean z = false;
        if (liveSettingConfigModel == null) {
            return false;
        }
        if (liveSettingConfigModel.audio_log == 1) {
            z = true;
        }
        return z;
    }
}
