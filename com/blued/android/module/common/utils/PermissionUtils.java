package com.blued.android.module.common.utils;

import android.Manifest;
import android.os.Build;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.permission.PermissionAuxiliaryDialogSetting;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.permission.PermissionManager;
import com.blued.android.module.common.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/PermissionUtils.class */
public final class PermissionUtils {

    /* renamed from: a  reason: collision with root package name */
    private static ArrayList<String> f10895a;

    /* renamed from: com.blued.android.module.common.utils.PermissionUtils$2  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/PermissionUtils$2.class */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PermissionCallbacks f10897a;

        @Override // java.lang.Runnable
        public void run() {
            PermissionUtils.f(new PermissionCallbacks() { // from class: com.blued.android.module.common.utils.PermissionUtils.2.1
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    PermissionUtils.l(AnonymousClass2.this.f10897a);
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] strArr) {
                    PermissionUtils.f10895a.addAll(PermissionUtils.c(strArr));
                    PermissionUtils.l(AnonymousClass2.this.f10897a);
                }
            });
        }
    }

    /* renamed from: com.blued.android.module.common.utils.PermissionUtils$5  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/PermissionUtils$5.class */
    class AnonymousClass5 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PermissionCallbacks f10903a;

        @Override // java.lang.Runnable
        public void run() {
            PermissionUtils.b(new PermissionCallbacks() { // from class: com.blued.android.module.common.utils.PermissionUtils.5.1
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    PermissionUtils.m(AnonymousClass5.this.f10903a);
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] strArr) {
                    PermissionUtils.f10895a.addAll(PermissionUtils.c(strArr));
                    PermissionUtils.m(AnonymousClass5.this.f10903a);
                }
            });
        }
    }

    /* renamed from: com.blued.android.module.common.utils.PermissionUtils$7  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/PermissionUtils$7.class */
    class AnonymousClass7 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PermissionCallbacks f10906a;

        @Override // java.lang.Runnable
        public void run() {
            PermissionUtils.e(new PermissionCallbacks() { // from class: com.blued.android.module.common.utils.PermissionUtils.7.1
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    PermissionUtils.n(AnonymousClass7.this.f10906a);
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] strArr) {
                    PermissionUtils.f10895a.addAll(PermissionUtils.c(strArr));
                    PermissionUtils.n(AnonymousClass7.this.f10906a);
                }
            });
        }
    }

    public static String a(int i) {
        return AppInfo.d().getString(i);
    }

    public static void a(PermissionCallbacks permissionCallbacks) {
        c();
        if (Build.VERSION.SDK_INT >= 26) {
            if (a(Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR)) {
                permissionCallbacks.U_();
                return;
            }
            c(R.string.permission_calendar_content);
            PermissionManager.a(permissionCallbacks, Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR);
        } else if (a(Manifest.permission.READ_CALENDAR)) {
            permissionCallbacks.U_();
        } else {
            c(R.string.permission_calendar_content);
            PermissionManager.a(permissionCallbacks, Manifest.permission.READ_CALENDAR);
        }
    }

    public static boolean a() {
        return a((!AppInfo.o() || Build.VERSION.SDK_INT < 26) ? new String[]{"android.permission.ACCESS_FINE_LOCATION"} : new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"});
    }

    public static boolean a(String... strArr) {
        return PermissionManager.a(strArr);
    }

    public static void b(PermissionCallbacks permissionCallbacks) {
        c();
        if (!a(Manifest.permission.CAMERA)) {
            c(R.string.permission_camera_content);
            PermissionManager.a(permissionCallbacks, Manifest.permission.CAMERA);
        } else if (permissionCallbacks != null) {
            permissionCallbacks.U_();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> c(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                f10895a.add(strArr[i2]);
                i = i2 + 1;
            }
        }
        return f10895a;
    }

    private static void c() {
        HashMap hashMap = new HashMap();
        hashMap.put(Manifest.permission.READ_CALENDAR, Integer.valueOf(com.blued.android.framework.R.string.permission_calendar));
        hashMap.put(Manifest.permission.WRITE_CALENDAR, Integer.valueOf(com.blued.android.framework.R.string.permission_calendar));
        hashMap.put(Manifest.permission.CAMERA, Integer.valueOf(com.blued.android.framework.R.string.permission_camera));
        hashMap.put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(com.blued.android.framework.R.string.permission_location));
        hashMap.put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(com.blued.android.framework.R.string.permission_location));
        hashMap.put(Manifest.permission.RECORD_AUDIO, Integer.valueOf(com.blued.android.framework.R.string.permission_mic));
        hashMap.put("android.permission.READ_PHONE_STATE", Integer.valueOf(com.blued.android.framework.R.string.permission_phone));
        hashMap.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(com.blued.android.framework.R.string.permission_storage));
        hashMap.put("android.permission.WRITE_EXTERNAL_STORAGE", Integer.valueOf(com.blued.android.framework.R.string.permission_storage));
        PermissionManager.a(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final int i) {
        PermissionManager.a(new PermissionAuxiliaryDialogSetting() { // from class: com.blued.android.module.common.utils.PermissionUtils.9
            @Override // com.blued.android.framework.permission.PermissionAuxiliaryDialogSetting
            public String a() {
                return PermissionUtils.a(R.string.permission_title);
            }

            @Override // com.blued.android.framework.permission.PermissionAuxiliaryDialogSetting
            public String b() {
                return PermissionUtils.a(i);
            }
        });
    }

    public static void c(PermissionCallbacks permissionCallbacks) {
        if (a()) {
            if (permissionCallbacks != null) {
                permissionCallbacks.U_();
                return;
            }
            return;
        }
        c();
        c(R.string.permission_location_content);
        if (Build.VERSION.SDK_INT >= 26) {
            PermissionManager.a(permissionCallbacks, "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION");
        } else {
            PermissionManager.a(permissionCallbacks, "android.permission.ACCESS_FINE_LOCATION");
        }
    }

    public static void d(PermissionCallbacks permissionCallbacks) {
        h(permissionCallbacks);
    }

    public static void e(PermissionCallbacks permissionCallbacks) {
        c();
        if (a("android.permission.READ_PHONE_STATE")) {
            permissionCallbacks.U_();
            return;
        }
        c(R.string.permission_phone_content);
        PermissionManager.a(permissionCallbacks, "android.permission.READ_PHONE_STATE");
    }

    public static void f(PermissionCallbacks permissionCallbacks) {
        c();
        if (Build.VERSION.SDK_INT >= 26) {
            if (a("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE")) {
                permissionCallbacks.U_();
                return;
            }
            c(R.string.permission_storage_content);
            PermissionManager.a(permissionCallbacks, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
        } else if (a("android.permission.WRITE_EXTERNAL_STORAGE")) {
            permissionCallbacks.U_();
        } else {
            c(R.string.permission_storage_content);
            PermissionManager.a(permissionCallbacks, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
    }

    public static void g(final PermissionCallbacks permissionCallbacks) {
        f10895a = new ArrayList<>();
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.common.utils.PermissionUtils.1
            @Override // java.lang.Runnable
            public void run() {
                PermissionUtils.l(PermissionCallbacks.this);
            }
        });
    }

    public static void h(final PermissionCallbacks permissionCallbacks) {
        c();
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.common.utils.PermissionUtils.6
            @Override // java.lang.Runnable
            public void run() {
                PermissionUtils.c(R.string.permission_radio_content);
                PermissionManager.a(PermissionCallbacks.this, Manifest.permission.RECORD_AUDIO);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(final PermissionCallbacks permissionCallbacks) {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.common.utils.PermissionUtils.3
            @Override // java.lang.Runnable
            public void run() {
                PermissionUtils.b(new PermissionCallbacks() { // from class: com.blued.android.module.common.utils.PermissionUtils.3.1
                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void U_() {
                        PermissionUtils.m(PermissionCallbacks.this);
                    }

                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void a(String[] strArr) {
                        PermissionUtils.f10895a.addAll(PermissionUtils.c(strArr));
                        PermissionUtils.m(PermissionCallbacks.this);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(final PermissionCallbacks permissionCallbacks) {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.common.utils.PermissionUtils.4
            @Override // java.lang.Runnable
            public void run() {
                PermissionUtils.h(new PermissionCallbacks() { // from class: com.blued.android.module.common.utils.PermissionUtils.4.1
                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void U_() {
                        PermissionCallbacks.this.U_();
                    }

                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void a(String[] strArr) {
                        PermissionUtils.f10895a.addAll(PermissionUtils.c(strArr));
                        PermissionCallbacks.this.a((String[]) PermissionUtils.f10895a.toArray(new String[PermissionUtils.f10895a.size()]));
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(final PermissionCallbacks permissionCallbacks) {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.common.utils.PermissionUtils.8
            @Override // java.lang.Runnable
            public void run() {
                PermissionUtils.f(new PermissionCallbacks() { // from class: com.blued.android.module.common.utils.PermissionUtils.8.1
                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void U_() {
                        PermissionCallbacks.this.U_();
                    }

                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void a(String[] strArr) {
                        PermissionUtils.f10895a.addAll(PermissionUtils.c(strArr));
                        PermissionCallbacks.this.a((String[]) PermissionUtils.f10895a.toArray(new String[PermissionUtils.f10895a.size()]));
                    }
                });
            }
        });
    }
}
