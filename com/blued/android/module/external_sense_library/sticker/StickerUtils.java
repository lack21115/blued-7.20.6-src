package com.blued.android.module.external_sense_library.sticker;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.module.external_sense_library.model.StickerDataModel;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.blued.android.module.external_sense_library.utils.SenseLibSPMgr;
import com.google.gson.reflect.TypeToken;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/sticker/StickerUtils.class */
public class StickerUtils {
    private static final String a = "Blued_Sense_" + StickerUtils.class.getSimpleName();

    /* JADX WARN: Type inference failed for: r2v2, types: [com.blued.android.module.external_sense_library.sticker.StickerUtils$1] */
    public static StickerDataModel a() {
        String b = SenseLibSPMgr.a().b();
        if (TextUtils.isEmpty(b)) {
            return new StickerDataModel();
        }
        String str = a;
        LogUtils.b(str, "readStickerConfig:" + b, new Object[0]);
        return (StickerDataModel) AppInfo.f().fromJson(b, new TypeToken<StickerDataModel>() { // from class: com.blued.android.module.external_sense_library.sticker.StickerUtils.1
        }.getType());
    }

    public static void a(StickerDataModel stickerDataModel) {
        if (stickerDataModel == null) {
            LogUtils.b(a, "stickerDataModel ==null", new Object[0]);
            return;
        }
        String json = AppInfo.f().toJson(stickerDataModel);
        String str = a;
        LogUtils.b(str, "writeStickerConfig:" + json, new Object[0]);
        SenseLibSPMgr.a().a(json);
    }

    public static void a(String str, String str2, String str3, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            LogUtils.b(a, "writeStickerConfig name == null || path == null", new Object[0]);
            return;
        }
        StickerDataModel a2 = a();
        a2.a(str, str2, str3, i);
        a(a2);
    }
}
