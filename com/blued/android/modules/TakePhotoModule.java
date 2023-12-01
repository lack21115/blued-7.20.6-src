package com.blued.android.modules;

import android.provider.MediaStore;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.module.base.album.ITakePhoto;
import com.blued.android.module.base.album.TakePhotoProxy;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/modules/TakePhotoModule.class */
public class TakePhotoModule {

    /* renamed from: a  reason: collision with root package name */
    protected static ITakePhoto f18643a = new ITakePhoto() { // from class: com.blued.android.modules.TakePhotoModule.1
        @Override // com.blued.android.module.base.album.ITakePhoto
        public void a(String str) {
            if (new File(str).exists()) {
                try {
                    String substring = str.substring(str.lastIndexOf(BridgeUtil.SPLIT_MARK) + 1, str.length() - 1);
                    if (!TextUtils.isEmpty(substring)) {
                        MediaStore.Images.Media.insertImage(AppInfo.d().getContentResolver(), str, substring, (String) null);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                AppUtils.a(AppInfo.d(), str, false);
            }
        }
    };

    public static void a() {
        TakePhotoProxy.a().a((TakePhotoProxy) f18643a);
    }
}
