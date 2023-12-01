package com.blued.community.ui.common;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.community.R;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/common/CommFullScreenDialog.class */
public abstract class CommFullScreenDialog extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private View f19492a;
    private final String b = "navigationBarBackground";

    private final void j() {
        if (Build.VERSION.SDK_INT < 19 || !h() || a(getActivity())) {
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
            if (viewGroup2.getChildAt(i2).getId() != -1 && Intrinsics.a((Object) this.b, (Object) activity.getResources().getResourceEntryName(viewGroup2.getChildAt(i2).getId()))) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public final View d() {
        return this.f19492a;
    }

    public abstract int e();

    public void f() {
    }

    public boolean g() {
        return false;
    }

    public final boolean h() {
        Object invoke;
        Resources resources = getResources();
        Intrinsics.c(resources, "resources");
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method method = cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class);
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

    public void i() {
        dismissAllowingStateLoss();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.dialog_community_full_screen);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        f();
        View inflate = inflater.inflate(e(), viewGroup, true);
        this.f19492a = inflate;
        Intrinsics.a(inflate);
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        j();
        Dialog dialog = getDialog();
        Intrinsics.a(dialog);
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        if (g()) {
            Dialog dialog2 = getDialog();
            Intrinsics.a(dialog2);
            Window window2 = dialog2.getWindow();
            Intrinsics.a(window2);
            window2.setSoftInputMode(16);
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.e(manager, "manager");
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = manager.beginTransaction();
            Intrinsics.c(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(manager, str);
        }
    }
}
