package com.blued.android.framework.web.permission;

import com.blued.android.framework.R;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.permission.PermissionManager;
import java.util.HashMap;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/permission/PermissionHelper.class */
public final class PermissionHelper {
    private static void a() {
        HashMap hashMap = new HashMap();
        hashMap.put("android.permission.CAMERA", Integer.valueOf(R.string.permission_camera));
        PermissionManager.a(hashMap);
    }

    public static void a(PermissionCallbacks permissionCallbacks) {
        a();
        PermissionManager.a(permissionCallbacks, "android.permission.CAMERA");
    }
}
