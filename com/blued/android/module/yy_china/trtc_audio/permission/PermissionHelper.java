package com.blued.android.module.yy_china.trtc_audio.permission;

import android.Manifest;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.R;
import com.blued.android.framework.permission.PermissionAuxiliaryDialogSetting;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.permission.PermissionManager;
import java.util.HashMap;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/trtc_audio/permission/PermissionHelper.class */
public final class PermissionHelper {
    public static String a(int i) {
        return AppInfo.d().getString(i);
    }

    private static void a() {
        HashMap hashMap = new HashMap();
        hashMap.put(Manifest.permission.CAMERA, Integer.valueOf(R.string.permission_camera));
        hashMap.put(Manifest.permission.RECORD_AUDIO, Integer.valueOf(R.string.permission_mic));
        hashMap.put("android.permission.READ_PHONE_STATE", Integer.valueOf(R.string.permission_phone));
        hashMap.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(R.string.permission_storage));
        hashMap.put("android.permission.WRITE_EXTERNAL_STORAGE", Integer.valueOf(R.string.permission_storage));
        PermissionManager.a(hashMap);
    }

    public static void a(final PermissionCallbacks permissionCallbacks) {
        a();
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.yy_china.trtc_audio.permission.PermissionHelper.1
            @Override // java.lang.Runnable
            public void run() {
                PermissionHelper.c(com.blued.android.module.yy_china.R.string.permission_radio_content);
                PermissionManager.a(PermissionCallbacks.this, Manifest.permission.RECORD_AUDIO);
            }
        });
    }

    public static boolean a(String... strArr) {
        return PermissionManager.a(strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final int i) {
        PermissionManager.a(new PermissionAuxiliaryDialogSetting() { // from class: com.blued.android.module.yy_china.trtc_audio.permission.PermissionHelper.2
            @Override // com.blued.android.framework.permission.PermissionAuxiliaryDialogSetting
            public String a() {
                return PermissionHelper.a(com.blued.android.module.yy_china.R.string.permission_title);
            }

            @Override // com.blued.android.framework.permission.PermissionAuxiliaryDialogSetting
            public String b() {
                return PermissionHelper.a(i);
            }
        });
    }
}
