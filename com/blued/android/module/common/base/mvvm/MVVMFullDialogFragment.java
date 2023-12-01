package com.blued.android.module.common.base.mvvm;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import com.blued.android.chat.grpc.backup.MsgBackupManager;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.module.common.R;
import com.blued.android.module.common.ext.AnyExtKt;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvvm/MVVMFullDialogFragment.class */
public abstract class MVVMFullDialogFragment<VB extends ViewBinding, VM extends ViewModel> extends BaseDialogFragment {
    public VM a;
    public VB b;
    private final String c = "navigationBarBackground";

    private final void a(Dialog dialog) {
        if (Build.VERSION.SDK_INT < 19 || !h() || a(getActivity())) {
            return;
        }
        Intrinsics.a(dialog);
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.getDecorView().setSystemUiVisibility(5894);
    }

    public final void a(VM vm) {
        Intrinsics.e(vm, "<set-?>");
        this.a = vm;
    }

    public final void a(VB vb) {
        Intrinsics.e(vb, "<set-?>");
        this.b = vb;
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
            if (viewGroup2.getChildAt(i2).getId() != -1 && Intrinsics.a((Object) this.c, (Object) activity.getResources().getResourceEntryName(viewGroup2.getChildAt(i2).getId()))) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public final VB d() {
        VB vb = this.b;
        if (vb != null) {
            return vb;
        }
        Intrinsics.c("vb");
        return null;
    }

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public final boolean h() {
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

    /* JADX WARN: Multi-variable type inference failed */
    public Dialog onCreateDialog(Bundle bundle) {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.a(genericSuperclass);
        if (genericSuperclass != null) {
            Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            Intrinsics.c(type, "type!!.saveAs<Parameteri…().actualTypeArguments[0]");
            Object invoke = ((Class) type).getDeclaredMethod("inflate", LayoutInflater.class).invoke(this, getLayoutInflater());
            Intrinsics.a(invoke);
            a((MVVMFullDialogFragment<VB, VM>) ((ViewBinding) AnyExtKt.a(invoke)));
            Type genericSuperclass2 = getClass().getGenericSuperclass();
            if (genericSuperclass2 != null) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass2).getActualTypeArguments();
                ViewModelProvider viewModelProvider = new ViewModelProvider((ViewModelStoreOwner) this);
                Type type2 = actualTypeArguments[1];
                if (type2 != null) {
                    a((MVVMFullDialogFragment<VB, VM>) viewModelProvider.get((Class) type2));
                    Dialog dialog = new Dialog(requireActivity(), R.style.dialog_full_screen);
                    dialog.requestWindowFeature(1);
                    dialog.setContentView(d().getRoot(), new ViewGroup.LayoutParams(-1, -1));
                    Window window = dialog.getWindow();
                    Intrinsics.a(window);
                    window.setBackgroundDrawable(new ColorDrawable(0));
                    a(dialog);
                    return dialog;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<VM of com.blued.android.module.common.base.mvvm.MVVMFullDialogFragment>");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
    }

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        e();
        f();
        g();
    }
}
