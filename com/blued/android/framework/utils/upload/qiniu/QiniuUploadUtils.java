package com.blued.android.framework.utils.upload.qiniu;

import android.text.TextUtils;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import java.io.File;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/QiniuUploadUtils.class */
public class QiniuUploadUtils {
    public static void a(int i, String str, String str2, String str3, String str4, String str5, QiniuUploadTools.QiNiuListener qiNiuListener) {
        if (!TextUtils.isEmpty(str3)) {
            QiniuUploadTools.a(QiniuUploadTools.a(i, str, str2), new File(str3), str4, str5, qiNiuListener);
        } else if (qiNiuListener != null) {
            qiNiuListener.a(str4);
        }
    }
}
