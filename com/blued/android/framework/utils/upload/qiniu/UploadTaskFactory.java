package com.blued.android.framework.utils.upload.qiniu;

import androidx.core.util.Pair;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/UploadTaskFactory.class */
public class UploadTaskFactory {
    public static IUploadTask a(String str, String str2, String str3, Pair<String, String> pair, Pair<String, String> pair2, SenderListener senderListener) {
        return new UploadVideoTask(str, str2, str3, pair, pair2, senderListener);
    }

    public static IUploadTask a(String str, List<Pair<String, String>> list, String str2, SenderListener senderListener) {
        return new UploadAudioTask(str, list, str2, senderListener);
    }

    public static IUploadTask a(String str, List<Pair<String, String>> list, String str2, boolean z, SenderListener senderListener) {
        return new UploadImageTask(str, list, str2, z, senderListener);
    }
}
