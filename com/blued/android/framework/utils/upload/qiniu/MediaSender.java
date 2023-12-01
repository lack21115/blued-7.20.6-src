package com.blued.android.framework.utils.upload.qiniu;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.NetworkUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/MediaSender.class */
public class MediaSender {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10132a = MediaSender.class.getSimpleName();

    private static String a() {
        long currentTimeMillis;
        synchronized (MediaSender.class) {
            try {
                currentTimeMillis = System.currentTimeMillis();
            } catch (Throwable th) {
                throw th;
            }
        }
        return String.valueOf(currentTimeMillis);
    }

    public static String a(String str, Pair<String, String> pair, SenderListener senderListener) {
        return a((String) null, str, (Pair<String, String>) null, pair, senderListener);
    }

    public static String a(String str, String str2, Pair<String, String> pair, Pair<String, String> pair2, SenderListener senderListener) {
        String a2 = a();
        ArrayList arrayList = new ArrayList();
        if (!NetworkUtils.b() || TextUtils.isEmpty(str2) || pair2 == null || (AppInfo.p() && pair != null && !TextUtils.isEmpty(pair.first) && TextUtils.isEmpty(str))) {
            if (senderListener != null) {
                if (pair != null) {
                    arrayList.add(pair);
                }
                arrayList.add(pair2);
                senderListener.a(a2, false, arrayList);
            }
            return a2;
        }
        if (AppInfo.m()) {
            String str3 = f10132a;
            Logger.c(str3, "上传视频, taskId:" + a2);
        }
        IUploadTask a3 = UploadTaskFactory.a(a2, str, str2, pair, pair2, senderListener);
        a3.a(false);
        UploadTaskHandle.a().a(a3);
        return a2;
    }

    public static String a(String str, List<Pair<String, String>> list, SenderListener senderListener) {
        String a2 = a();
        if (!NetworkUtils.b()) {
            if (senderListener != null) {
                senderListener.a(a2, false, list);
            }
            return a2;
        } else if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            if (senderListener != null) {
                senderListener.a(a2, false, list);
            }
            return a2;
        } else {
            if (AppInfo.m()) {
                String str2 = f10132a;
                Logger.c(str2, "上传语音, taskId:" + a2);
            }
            IUploadTask a3 = UploadTaskFactory.a(a2, list, str, senderListener);
            a3.a(false);
            UploadTaskHandle.a().a(a3);
            return a2;
        }
    }

    public static String a(String str, List<Pair<String, String>> list, boolean z, SenderListener senderListener) {
        return a(str, list, z, false, senderListener);
    }

    public static String a(String str, List<Pair<String, String>> list, boolean z, boolean z2, SenderListener senderListener) {
        String a2 = a();
        if (!NetworkUtils.b()) {
            if (senderListener != null) {
                senderListener.a(a2, false, list);
            }
            return a2;
        } else if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            if (senderListener != null) {
                senderListener.a(a2, false, list);
            }
            return a2;
        } else {
            if (AppInfo.m()) {
                String str2 = f10132a;
                Logger.c(str2, "上传图片, taskId:" + a2);
            }
            IUploadTask a3 = UploadTaskFactory.a(a2, list, str, z2, senderListener);
            a3.a(z);
            UploadTaskHandle.a().a(a3);
            return a2;
        }
    }

    public static void a(String str) {
        UploadTaskHandle.a().a(str);
    }
}
