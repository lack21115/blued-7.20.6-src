package com.blued.android.module.live_china.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.chat.grpc.backup.MsgBackupManager;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live.base.constants.LiveEventBusConstant;
import com.blued.android.module.live_china.R;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/BaseFullScreenDialog.class */
public abstract class BaseFullScreenDialog extends BaseDialogFragment {
    private final String a = "navigationBarBackground";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BaseFullScreenDialog this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void f() {
        if (Build.VERSION.SDK_INT < 19 || !e() || a((Activity) getActivity())) {
            return;
        }
        Dialog dialog = getDialog();
        Intrinsics.a(dialog);
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.getDecorView().setSystemUiVisibility(5894);
    }

    public final boolean a(Activity activity) {
        Window window;
        ViewGroup viewGroup = null;
        if (activity != null && (window = activity.getWindow()) != null) {
            viewGroup = window.getDecorView();
        }
        if (viewGroup == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ViewGroup viewGroup2 = viewGroup;
        int childCount = viewGroup2.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return false;
            }
            viewGroup2.getChildAt(i2).getContext().getPackageName();
            if (viewGroup2.getChildAt(i2).getId() != -1 && Intrinsics.a((Object) this.a, (Object) activity.getResources().getResourceEntryName(viewGroup2.getChildAt(i2).getId()))) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public boolean d() {
        return false;
    }

    public final boolean e() {
        Object invoke;
        Resources resources = getResources();
        Intrinsics.c(resources, "resources");
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", MsgBackupManager.PLATFORM_ANDROID);
        boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method method = cls.getMethod("get", String.class);
            Intrinsics.c(method, "systemPropertiesClass.ge…get\", String::class.java)");
            invoke = method.invoke(cls, "qemu.hw.mainkeys");
        } catch (Exception e) {
        }
        if (invoke != null) {
            String str = (String) invoke;
            if (Intrinsics.a((Object) "1", (Object) str)) {
                return false;
            }
            if (Intrinsics.a((Object) "0", (Object) str)) {
                return true;
            }
            return z;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        f();
        Dialog dialog = getDialog();
        Intrinsics.a(dialog);
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        if (d()) {
            Dialog dialog2 = getDialog();
            Intrinsics.a(dialog2);
            Window window2 = dialog2.getWindow();
            Intrinsics.a(window2);
            window2.setSoftInputMode(16);
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.dialog_full_screen);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        LiveEventBus.get(LiveEventBusConstant.d, String.class).observe((LifecycleOwner) this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$BaseFullScreenDialog$it40W9dEbtx9wxs_za6rB-wyySM
            public final void onChanged(Object obj) {
                BaseFullScreenDialog.a(BaseFullScreenDialog.this, (String) obj);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.e(manager, "manager");
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = manager.beginTransaction();
            Intrinsics.c(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(manager, str);
        }
    }
}
