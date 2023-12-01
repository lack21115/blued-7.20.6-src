package com.blued.community.ui.send.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.community.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/AnonymousHelpDialogFragment.class */
public class AnonymousHelpDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private Context f19914a;
    private View b;

    public static void a(FragmentManager fragmentManager) {
        new AnonymousHelpDialogFragment().show(fragmentManager, AnonymousHelpDialogFragment.class.getSimpleName());
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        super.setupDialog(dialog, i);
        this.f19914a = getContext();
        View inflate = View.inflate(getContext(), R.layout.dialog_anonymous_help, null);
        this.b = inflate;
        dialog.setContentView(inflate);
    }
}
