package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveCurBaseDialogFragment.class */
public abstract class LiveCurBaseDialogFragment extends BaseDialogFragment {
    public abstract View d();

    public abstract float e();

    public abstract void f();

    public abstract int g();

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        int a2 = DensityUtils.a(getContext(), e());
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(d(), new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.style.main_menu_animstyle);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = a2;
            attributes.gravity = 80;
            dialog.onWindowAttributesChanged(attributes);
            window.setFlags(67108864, 67108864);
        }
        d().setBackgroundResource(g());
        f();
        return dialog;
    }
}
