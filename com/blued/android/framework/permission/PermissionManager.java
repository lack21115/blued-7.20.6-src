package com.blued.android.framework.permission;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import com.blued.android.core.AppInfo;
import com.igexin.assist.util.AssistUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/permission/PermissionManager.class */
public class PermissionManager {

    /* renamed from: a  reason: collision with root package name */
    private static PermissionCallbacks f9827a;
    private static HashMap<String, Integer> b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f9828c = false;
    private static String d;
    private static String e;

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a() {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(Context context, ArrayList<String> arrayList) {
        Integer num;
        if (arrayList == null || arrayList.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(" ");
        if (b != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next) && (num = b.get(next)) != null && !arrayList2.contains(num)) {
                    arrayList2.add(num);
                }
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                sb.append(context.getString(((Integer) it2.next()).intValue()));
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void a(PermissionAuxiliaryDialogSetting permissionAuxiliaryDialogSetting) {
        if (permissionAuxiliaryDialogSetting != null) {
            d = permissionAuxiliaryDialogSetting.a();
            e = permissionAuxiliaryDialogSetting.b();
        }
    }

    public static void a(PermissionCallbacks permissionCallbacks, String... strArr) {
        String[] c2 = c(strArr);
        if (c2 == null || c2.length == 0) {
            if (permissionCallbacks != null) {
                permissionCallbacks.U_();
                return;
            }
            return;
        }
        if (permissionCallbacks != null) {
            f9827a = permissionCallbacks;
        }
        f9828c = true;
        Bundle bundle = new Bundle();
        bundle.putStringArray("com.blued.android.framework.reqeust_permission_code", c2);
        Intent intent = new Intent(AppInfo.d(), PermissionActivity.class);
        intent.addFlags(268435456);
        intent.putExtras(bundle);
        AppInfo.d().startActivity(intent);
    }

    public static void a(HashMap<String, Integer> hashMap) {
        b = hashMap;
    }

    public static boolean a(String... strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            String str = strArr[i2];
            boolean z = ContextCompat.checkSelfPermission(AppInfo.d(), str) == 0;
            boolean z2 = z;
            if (z) {
                z2 = z;
                if (d()) {
                    z2 = PermissionChecker.checkPermission(AppInfo.d(), str, Process.myPid(), Process.myUid(), AppInfo.d().getPackageName()) == 0;
                }
            }
            if (AppInfo.m()) {
                Log.i("PermissionManager", str + ": " + z2);
            }
            if (!z2) {
                return false;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String b() {
        return e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(String... strArr) {
        f9828c = false;
        if (f9827a != null) {
            if (AppInfo.m()) {
                Log.v("PermissionManager", "permission Denied or Cancel, " + Arrays.toString(strArr));
            }
            f9827a.a(c(strArr));
            f9827a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void c() {
        f9828c = false;
        if (f9827a != null) {
            if (AppInfo.m()) {
                Log.v("PermissionManager", "permission Granted.");
            }
            f9827a.U_();
            f9827a = null;
        }
    }

    private static String[] c(String... strArr) {
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            String str = strArr[i2];
            boolean z = ContextCompat.checkSelfPermission(AppInfo.d(), str) == 0;
            boolean z2 = z;
            if (z) {
                z2 = z;
                if (d()) {
                    z2 = PermissionChecker.checkPermission(AppInfo.d(), str, Process.myPid(), Process.myUid(), AppInfo.d().getPackageName()) == 0;
                }
            }
            if (!z2) {
                arrayList.add(str);
            }
            i = i2 + 1;
        }
    }

    private static boolean d() {
        return AssistUtils.BRAND_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER);
    }
}
