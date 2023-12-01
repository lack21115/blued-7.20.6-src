package com.blued.android.module.shortvideo.permission;

import android.Manifest;
import com.blued.android.framework.R;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.permission.PermissionManager;
import java.util.HashMap;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/permission/PermissionHelper.class */
public final class PermissionHelper {
    private static void a() {
        HashMap hashMap = new HashMap();
        hashMap.put(Manifest.permission.CAMERA, Integer.valueOf(R.string.permission_camera));
        hashMap.put(Manifest.permission.RECORD_AUDIO, Integer.valueOf(R.string.permission_mic));
        hashMap.put("android.permission.READ_PHONE_STATE", Integer.valueOf(R.string.permission_phone));
        hashMap.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(R.string.permission_storage));
        hashMap.put("android.permission.WRITE_EXTERNAL_STORAGE", Integer.valueOf(R.string.permission_storage));
        PermissionManager.a(hashMap);
    }

    public static void a(PermissionCallbacks permissionCallbacks) {
        a();
        PermissionManager.a(permissionCallbacks, Manifest.permission.CAMERA);
    }

    public static void b(PermissionCallbacks permissionCallbacks) {
        a();
        PermissionManager.a(permissionCallbacks, Manifest.permission.RECORD_AUDIO);
    }

    public static void c(PermissionCallbacks permissionCallbacks) {
        a();
        PermissionManager.a(permissionCallbacks, Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO);
    }
}
