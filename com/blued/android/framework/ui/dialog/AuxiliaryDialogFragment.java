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

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/dialog/AuxiliaryDialogFragment.class */
public class AuxiliaryDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f9886a;
    private LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f9887c;
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
        this.f9886a = linearLayout;
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_auxiliary_dialog);
        this.b = linearLayout2;
        linearLayout2.setVisibility(0);
        this.f9887c = (TextView) view.findViewById(R.id.tv_auxiliary_dialog_title);
        this.d = (TextView) view.findViewById(R.id.tv_auxiliary_dialog_content);
        this.f9887c.setText(this.e);
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

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(getActivity());
        if (Build.VERSION.SDK_INT >= 21) {
            dialog.getWindow().getDecorView().setSystemUiVisibility(1280);
            dialog.getWindow().addFlags(Integer.MIN_VALUE);
            dialog.getWindow().setStatusBarColor(0);
        }
        dialog.getWindow().setBackgroundDrawableResource(17170445);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setStyle(0, 16973834);
        Window window = getDialog().getWindow();
        window.setGravity(48);
        window.setAttributes(window.getAttributes());
        window.setLayout(d(), e());
        View inflate = layoutInflater.inflate(R.layout.dialog_permission, (ViewGroup) window.findViewById(16908290), false);
        a(inflate);
        return inflate;
    }
}
