package com.blued.android.framework.utils.upload.qiniu;

import androidx.core.util.Pair;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/SenderListener.class */
public interface SenderListener {
    void a(String str, int i);

    void a(String str, Pair<String, UploadModel> pair);

    void a(String str, boolean z, List<Pair<String, String>> list);
}
