package com.soft.blued.ui.setting.vm;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.soft.blued.ui.setting.model.PermissionModel;
import com.soft.blued.utils.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/SystemPermissionVM.class */
public final class SystemPermissionVM extends BaseListViewModel<PermissionModel> {

    /* renamed from: a  reason: collision with root package name */
    private final List<PermissionModel> f33693a = new ArrayList();

    private final void a(String str, String str2) {
        List<PermissionModel> list = this.f33693a;
        PermissionModel permissionModel = new PermissionModel();
        permissionModel.setTitle(str);
        permissionModel.setDesc(str2);
        list.add(permissionModel);
    }

    private final boolean a(Context context) {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT < 23) {
                Class<?> cls = Class.forName("android.content.Context");
                Field declaredField = cls.getDeclaredField("APP_OPS_SERVICE");
                Intrinsics.c(declaredField, "cls.getDeclaredField(\"APP_OPS_SERVICE\")");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(cls);
                String str = obj instanceof String ? (String) obj : null;
                if (str == null) {
                    return false;
                }
                Object invoke = cls.getMethod("getSystemService", String.class).invoke(context, str);
                Class<?> cls2 = Class.forName("android.app.AppOpsManager");
                Field declaredField2 = cls2.getDeclaredField("MODE_ALLOWED");
                Intrinsics.c(declaredField2, "cls.getDeclaredField(\"MODE_ALLOWED\")");
                declaredField2.setAccessible(true);
                Method method = cls2.getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class);
                Intrinsics.c(method, "cls.getMethod(\n         …ss.java\n                )");
                Object invoke2 = method.invoke(invoke, 24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName());
                if (invoke2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                if (((Integer) invoke2).intValue() == declaredField2.getInt(cls2)) {
                    return true;
                }
            } else if (Build.VERSION.SDK_INT >= 26) {
                Object systemService = context.getSystemService(Context.APP_OPS_SERVICE);
                if (systemService == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.app.AppOpsManager");
                }
                int checkOpNoThrow = ((AppOpsManager) systemService).checkOpNoThrow("android:system_alert_window", Process.myUid(), context.getPackageName());
                Logger.c("canDrawOverlays", Intrinsics.a("mode : ", (Object) Integer.valueOf(checkOpNoThrow)));
                if (Settings.canDrawOverlays(context) || checkOpNoThrow == 0) {
                    return true;
                }
            } else {
                z = Settings.canDrawOverlays(context);
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0135, code lost:
        if (a(r0) != false) goto L25;
     */
    @Override // com.blued.android.module.common.base.mvi.BaseListViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void requestData() {
        /*
            Method dump skipped, instructions count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.setting.vm.SystemPermissionVM.requestData():void");
    }
}
