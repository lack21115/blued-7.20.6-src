package com.blued.android.module.common.widget.emoticon.manager;

import android.content.Context;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.web.WebDownloaderManager;
import com.blued.android.module.common.widget.emoticon.model.EmotionPackDownload;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoticon/manager/EmotionPackWebDownload.class */
public class EmotionPackWebDownload {
    public static void a(Context context, final String str, final String str2, final String str3) {
        EmotionManager.b(context, new BluedUIHttpResponse<BluedEntityA<EmotionPackDownload>>() { // from class: com.blued.android.module.common.widget.emoticon.manager.EmotionPackWebDownload.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EmotionPackDownload> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                WebDownloaderManager.a().a(String.this, bluedEntityA.data.get(0).download, str3, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str4) {
                WebDownloaderManager.a().a(String.this, str3, str);
                return super.onUIFailure(i, str4);
            }
        }, str);
    }
}
