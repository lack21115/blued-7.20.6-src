package com.blued.android.module.common.utils.third;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.qiniu.android.storage.Configuration;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/third/QiniuUploadUtils.class */
public class QiniuUploadUtils {
    public static List<Pair<String, String>> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(str, str2));
        return arrayList;
    }

    public static void a(String str, BluedAlbum bluedAlbum, QiniuUploadTools.QiNiuListener qiNiuListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QiniuUploadTools.a((Configuration) null, new File(str), bluedAlbum.key, bluedAlbum.token, qiNiuListener);
    }

    public static void a(byte[] bArr, BluedAlbum bluedAlbum, QiniuUploadTools.QiNiuListener qiNiuListener) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        QiniuUploadTools.a((Configuration) null, bArr, bluedAlbum.key, bluedAlbum.token, qiNiuListener);
    }
}
