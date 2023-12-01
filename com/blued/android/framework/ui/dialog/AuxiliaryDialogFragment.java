package com.blued.android.framework.ui.dialog;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.R;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/dialog/AuxiliaryDialogFragment.class */
public class AuxiliaryDialogFragment extends BaseDialogFragment {
    private LinearLayout a;
    private LinearLayout b;
    private TextView c;
    private TextView d;
    private String e;
    private String f;

    public static AuxiliaryDialogFragment a(FragmentManager fragmentManager, String str, String str2) {
        AuxiliaryDialogFragment auxiliaryDialogFragment = new AuxiliaryDialogFragment();
        auxiliaryDialogFragment.show(fragmentManager, AuxiliaryDialogFragment.class.getSimpleName());
        auxiliaryDialogFragment.a(str, str2);
        auxiliaryDialogFragment.setCancelable(false);
        return auxiliaryDialogFragment;
    }

    private void a(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_setting_alert_dialog);
        this.a = linearLayout;
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_auxiliary_dialog);
        this.b = linearLayout2;
        linearLayout2.setVisibility(0);
        this.c = (TextView) view.findViewById(R.id.tv_auxiliary_dialog_title);
        this.d = (TextView) view.findViewById(R.id.tv_auxiliary_dialog_content);
        this.c.setText(this.e);
        this.d.setText(this.f);
    }

    private void a(String str, String str2) {
        this.e = str;
        this.f = str2;
    }

    public int d() {
        return AppInfo.l;
    }

    public int e() {
        return AppInfo.m;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(getActivity());
        if (Build.VERSION.SDK_INT >= 21) {
            dialog.getWindow().getDecorView().setSystemUiVisibility(GL10.GL_INVALID_ENUM);
            dialog.getWindow().addFlags(Integer.MIN_VALUE);
            dialog.getWindow().setStatusBarColor(0);
        }
        dialog.getWindow().setBackgroundDrawableResource(com.android.internal.R.color.transparent);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setStyle(0, com.android.internal.R.style.Theme_Black_NoTitleBar_Fullscreen);
        Window window = getDialog().getWindow();
        window.setGravity(48);
        window.setAttributes(window.getAttributes());
        window.setLayout(d(), e());
        View inflate = layoutInflater.inflate(R.layout.dialog_permission, (ViewGroup) window.findViewById(16908290), false);
        a(inflate);
        return inflate;
    }
}
