package com.blued.android.module.shortvideo.permission;

import com.anythink.china.common.d;
import com.blued.android.framework.R;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.permission.PermissionManager;
import java.util.HashMap;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/permission/PermissionHelper.class */
public final class PermissionHelper {
    private static void a() {
        HashMap hashMap = new HashMap();
        hashMap.put("android.permission.CAMERA", Integer.valueOf(R.string.permission_camera));
        hashMap.put("android.permission.RECORD_AUDIO", Integer.valueOf(R.string.permission_mic));
        hashMap.put(d.a, Integer.valueOf(R.string.permission_phone));
        hashMap.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(R.string.permission_storage));
        hashMap.put(d.b, Integer.valueOf(R.string.permission_storage));
        PermissionManager.a(hashMap);
    }

    public static void a(PermissionCallbacks permissionCallbacks) {
        a();
        PermissionManager.a(permissionCallbacks, "android.permission.CAMERA");
    }

    public static void b(PermissionCallbacks permissionCallbacks) {
        a();
        PermissionManager.a(permissionCallbacks, "android.permission.RECORD_AUDIO");
    }

    public static void c(PermissionCallbacks permissionCallbacks) {
        a();
        PermissionManager.a(permissionCallbacks, "android.permission.CAMERA", "android.permission.RECORD_AUDIO");
    }
}
