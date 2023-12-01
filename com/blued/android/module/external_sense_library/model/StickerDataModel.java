package com.blued.android.module.external_sense_library.model;

import android.text.TextUtils;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/model/StickerDataModel.class */
public class StickerDataModel implements Serializable {
    private static final String b = "Blued_Sense_" + StickerDataModel.class.getSimpleName();
    public List<StickerBaseModel> a = new ArrayList();

    private StickerBaseModel a(String str) {
        StickerBaseModel stickerBaseModel;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<StickerBaseModel> it = this.a.iterator();
        while (true) {
            stickerBaseModel = null;
            if (!it.hasNext()) {
                break;
            }
            stickerBaseModel = it.next();
            if (stickerBaseModel != null && str.equals(stickerBaseModel.name)) {
                break;
            }
        }
        return stickerBaseModel;
    }

    public void a(String str, String str2, String str3, int i) {
        boolean z;
        StickerBaseModel stickerBaseModel;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            LogUtils.b(b, "name==null || path==null", new Object[0]);
            return;
        }
        StickerBaseModel a = a(str);
        if (a == null) {
            StickerBaseModel stickerBaseModel2 = new StickerBaseModel();
            stickerBaseModel2.name = str;
            z = true;
            stickerBaseModel = stickerBaseModel2;
        } else {
            z = false;
            stickerBaseModel = a;
        }
        stickerBaseModel.path = str2;
        stickerBaseModel.localPath = str3;
        LogUtils.b(b, stickerBaseModel.name + " | 3 localPath:" + stickerBaseModel.localPath, new Object[0]);
        stickerBaseModel.stickerState = i;
        if (z) {
            this.a.add(stickerBaseModel);
        }
    }
}
