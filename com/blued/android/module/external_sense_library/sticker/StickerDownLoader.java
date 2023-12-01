package com.blued.android.module.external_sense_library.sticker;

import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.module.external_sense_library.contract.IGetStickerListener;
import com.blued.android.module.external_sense_library.model.ErrorCode;
import com.blued.android.module.external_sense_library.utils.FileUtils;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.blued.android.module.external_sense_library.utils.StickerConfig;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/sticker/StickerDownLoader.class */
public class StickerDownLoader {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11266a = "Blued_Sense_" + StickerDownLoader.class.getSimpleName();
    private static volatile Map<String, String> b = new HashMap();

    public static void a(final String str, final String str2, final IGetStickerListener iGetStickerListener, IRequestHost iRequestHost) {
        File file = new File(StickerConfig.b());
        if (!file.exists()) {
            file.mkdirs();
        }
        String str3 = f11266a;
        LogUtils.a(str3, "start downloadAsyn:" + str, new Object[0]);
        FileDownloader.a(str2, StickerConfig.b(str), new FileHttpResponseHandler() { // from class: com.blued.android.module.external_sense_library.sticker.StickerDownLoader.1
            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onSuccess(File file2) {
                String str4 = StickerDownLoader.f11266a;
                LogUtils.a(str4, "downloadAsyn onSuccess:" + String.this, new Object[0]);
                String a2 = FileUtils.a(file2, new File(StickerConfig.a()));
                file2.delete();
                StickerDownLoader.b.remove(String.this);
                IGetStickerListener iGetStickerListener2 = iGetStickerListener;
                if (iGetStickerListener2 != null) {
                    iGetStickerListener2.onSuccess(String.this, a2);
                } else {
                    StickerUtils.a(String.this, str2, a2, 2);
                }
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onFailure(Throwable th, int i, File file2) {
                super.onFailure(th, i, file2);
                String str4 = StickerDownLoader.f11266a;
                LogUtils.a(str4, "error:" + th, new Object[0]);
                StickerDownLoader.b.remove(String.this);
                IGetStickerListener iGetStickerListener2 = iGetStickerListener;
                if (iGetStickerListener2 != null) {
                    iGetStickerListener2.onFailed(ErrorCode.PlayStickerCode.DOWNLOAD_FAIL, "file downloader failed");
                }
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onCancel() {
                LogUtils.a(StickerDownLoader.f11266a, "onCancel", new Object[0]);
                StickerDownLoader.b.remove(String.this);
                IGetStickerListener iGetStickerListener2 = iGetStickerListener;
                if (iGetStickerListener2 != null) {
                    iGetStickerListener2.onFailed(ErrorCode.PlayStickerCode.DOWNLOAD_FAIL, "file downloader onCancel");
                }
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFinish() {
                LogUtils.a(StickerDownLoader.f11266a, "onFinish", new Object[0]);
                StickerDownLoader.b.remove(String.this);
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onStart() {
                LogUtils.a(StickerDownLoader.f11266a, "onCancel", new Object[0]);
                StickerDownLoader.b.put(String.this, str2);
                IGetStickerListener iGetStickerListener2 = iGetStickerListener;
                if (iGetStickerListener2 != null) {
                    iGetStickerListener2.onSyncStart();
                }
            }
        }, iRequestHost);
    }

    public static boolean a(String str) {
        return b.containsKey(str);
    }
}
