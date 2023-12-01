package com.blued.android.module.external_sense_library.manager;

import android.text.TextUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.external_sense_library.contract.IGetStickerListener;
import com.blued.android.module.external_sense_library.contract.IStickerInitListener;
import com.blued.android.module.external_sense_library.model.ErrorCode;
import com.blued.android.module.external_sense_library.model.StickerBaseModel;
import com.blued.android.module.external_sense_library.sticker.StickerLoader;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.blued.android.module.external_sense_library.utils.SenseLibThreadPoolHelper;
import com.blued.android.module.external_sense_library.utils.StickerConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/manager/StickerDataManager.class */
public class StickerDataManager {
    private static final String TAG = "Blued_Sense_" + StickerDataManager.class.getSimpleName();
    private static StickerLoader stickerLoader;

    public static void clearData() {
        stickerLoader = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getStickerPath(String str, String str2) {
        getStickerPath(str, str2, null);
    }

    public static void getStickerPath(String str, String str2, IGetStickerListener iGetStickerListener) {
        if (stickerLoader == null) {
            stickerLoader = new StickerLoader.Builder().a();
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            LogUtils.d(TAG, "name or path null", new Object[0]);
            if (iGetStickerListener != null) {
                iGetStickerListener.onFailed(ErrorCode.PlayStickerCode.DATA_ERROR, "name or path null");
            }
        } else if (!stickerLoader.a(str)) {
            stickerLoader.a(str, str2, iGetStickerListener, (IRequestHost) null);
        } else if (iGetStickerListener != null) {
            iGetStickerListener.onSuccess(str, StickerConfig.a(str));
        }
    }

    public static Map<String, Integer> getStickerStateMap() {
        StickerLoader stickerLoader2 = stickerLoader;
        if (stickerLoader2 != null) {
            return stickerLoader2.a();
        }
        LogUtils.d(TAG, "StickerDataManager init no finish", new Object[0]);
        return new HashMap();
    }

    public static void init(List<StickerBaseModel> list, IStickerInitListener iStickerInitListener) {
        init(list, true, iStickerInitListener);
    }

    public static void init(final List<StickerBaseModel> list, boolean z, final IStickerInitListener iStickerInitListener) {
        if (stickerLoader == null) {
            stickerLoader = new StickerLoader.Builder().a();
        }
        stickerLoader.a(list);
        if (z) {
            SenseLibThreadPoolHelper.a().a(new SenseLibThreadPoolHelper.SenseLibThread(new Runnable() { // from class: com.blued.android.module.external_sense_library.manager.StickerDataManager.1
                @Override // java.lang.Runnable
                public void run() {
                    List list2 = List.this;
                    if (list2 == null || list2.isEmpty()) {
                        LogUtils.d(StickerDataManager.TAG, "filterList is null", new Object[0]);
                        return;
                    }
                    for (StickerBaseModel stickerBaseModel : List.this) {
                        if (stickerBaseModel != null && StickerDataManager.stickerLoader != null && !StickerDataManager.stickerLoader.a(stickerBaseModel.name)) {
                            StickerDataManager.getStickerPath(stickerBaseModel.name, stickerBaseModel.path);
                        }
                    }
                    LogUtils.c(StickerDataManager.TAG, "StickerDataManager init finish", new Object[0]);
                    IStickerInitListener iStickerInitListener2 = iStickerInitListener;
                    if (iStickerInitListener2 != null) {
                        iStickerInitListener2.onFinish(StickerDataManager.getStickerStateMap());
                    }
                }
            }));
        }
    }

    public static boolean isDownLoad(String str) {
        if (stickerLoader == null) {
            stickerLoader = new StickerLoader.Builder().a();
        }
        return stickerLoader.a(str);
    }
}
