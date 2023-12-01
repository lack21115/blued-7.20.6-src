package com.zx.sdk.api;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.zx.a.I8b7.i1;
import com.zx.a.I8b7.m;
import com.zx.a.I8b7.m2;
import com.zx.a.I8b7.n2;
import com.zx.a.I8b7.p1;

/* loaded from: source-8829756-dex2jar.jar:com/zx/sdk/api/ZXManager.class */
public class ZXManager {
    public static final String TAG = "ZXManager";
    public static ZXApi api;

    static {
        try {
            System.loadLibrary("zxprotect");
        } catch (Throwable th) {
            StringBuilder a2 = m2.a("ZXLoadLibraryError:");
            a2.append(th.getMessage());
            Log.e(TAG, a2.toString());
        }
    }

    public static void addZXIDChangedListener(ZXIDChangedListener zXIDChangedListener) {
        try {
            if (checkAPI()) {
                api.addZXIDChangedListener(zXIDChangedListener);
            }
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager.registerListener(listener) failed: "));
        }
    }

    public static void allowPermissionDialog(boolean z) {
        try {
            if (checkAPI()) {
                api.allowPermissionDialog(z);
            }
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager.allowPermissionDialog failed: "));
        }
    }

    private static boolean checkAPI() {
        if (api == null) {
            m.b("ZXManager not init, should init firstly");
            return false;
        }
        return true;
    }

    public static void checkPermission(Activity activity, PermissionCallback permissionCallback) {
        if (permissionCallback == null) {
            return;
        }
        try {
            if (checkAPI()) {
                api.checkPermission(activity, permissionCallback);
            }
        } catch (Throwable th) {
            m.b(th.getMessage());
        }
    }

    public static void getAuthToken(Callback callback) {
        try {
            if (checkAPI() && callback != null) {
                api.getAuthToken(callback);
            }
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager getTag onFailed:"));
        }
    }

    public static void getSAID(String str, String str2, String str3, String str4, String str5, SAIDCallback sAIDCallback) {
        try {
            if (checkAPI() && sAIDCallback != null) {
                api.getSAID(str, str2, str3, str4, str5, sAIDCallback);
            }
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager getSAID onFailed:"));
        }
    }

    public static void getTag(Callback callback) {
        try {
            if (checkAPI() && callback != null) {
                api.getTag(callback);
            }
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager getTag onFailed:"));
        }
    }

    public static String getVersion() {
        try {
            if (checkAPI()) {
                api.getVersion();
                return "3.2.0.16894";
            }
            return "3.2.0.16894";
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager.getVersion failed: "));
            return "3.2.0.16894";
        }
    }

    public static void getZXID(ZXIDListener zXIDListener) {
        try {
            if (checkAPI() && zXIDListener != null) {
                api.getZXID(zXIDListener);
            }
        } catch (Throwable th) {
            if (zXIDListener != null) {
                zXIDListener.onFailed(10000, th.getMessage());
            }
            n2.a(th, m2.a("ZXManager.getZXID(zxidListener) failed: "));
        }
    }

    public static void init(Context context) {
        try {
            if (api == null) {
                api = new p1(i1.a(context));
            }
            api.init(context);
        } catch (Throwable th) {
            Log.e(TAG, "ZXManager.init failed: " + th);
        }
    }

    public static String invoke(String str, String str2) {
        try {
            return !checkAPI() ? "ZXManager is not init" : api.invoke(str, str2);
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager.invoke failed: "));
            return null;
        }
    }

    public static boolean isAllowPermissionDialog() {
        try {
            if (checkAPI()) {
                return api.isAllowPermissionDialog();
            }
            return false;
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager.isAllowPermissionDialog failed: "));
            return false;
        }
    }

    public static boolean isEnable() {
        try {
            if (checkAPI()) {
                return api.isEnable();
            }
            return false;
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager.isEnable failed: "));
            return false;
        }
    }

    public static ZXApi newSDK(String str) {
        try {
            return new p1(str);
        } catch (Throwable th) {
            m.b("ZXManager.newProxy failed:" + th);
            return null;
        }
    }

    public static void setDebug(boolean z) {
        try {
            m.f42147a = z;
            ZXApi zXApi = api;
            if (zXApi != null) {
                zXApi.setDebug(z);
            }
        } catch (Throwable th) {
            m.b(th.getMessage());
        }
    }

    public static void setEnable(boolean z) {
        try {
            if (checkAPI()) {
                api.setEnable(z);
            }
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager.setEnable failed: "));
        }
    }
}
