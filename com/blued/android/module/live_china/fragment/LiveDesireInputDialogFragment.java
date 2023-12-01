package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveDesireInputDialogFragment.class */
public class LiveDesireInputDialogFragment extends BaseDialogFragment {
    public Context a;
    public TextView b;
    private EditText c;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(this.c, 0);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.a = getActivity();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_desire_input, (ViewGroup) null);
        int a = DensityUtils.a(this.a, 60.0f);
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, a));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.alpha_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a;
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - a;
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_live_desire_input, viewGroup);
        EditText editText = (EditText) inflate.findViewById(R.id.et_input);
        this.c = editText;
        editText.setText(this.b.getText());
        this.c.setHint(this.b.getHint());
        this.c.setTextColor(this.b.getTextColors());
        this.c.setHintTextColor(this.b.getHintTextColors());
        this.c.setTextSize(0, this.b.getTextSize());
        this.c.setFilters(this.b.getFilters());
        this.c.setFocusable(true);
        this.c.setFocusableInTouchMode(true);
        this.c.requestFocus();
        if (!TextUtils.isEmpty(this.c.getText())) {
            EditText editText2 = this.c;
            editText2.setSelection(editText2.getText().length());
        }
        this.c.addTextChangedListener(new TextWatcher() { // from class: com.blued.android.module.live_china.fragment.LiveDesireInputDialogFragment.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                LiveDesireInputDialogFragment.this.b.setText(editable);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireInputDialogFragment$qnIUDAbyEHL6bSpud89cRLj0Nw8
            @Override // java.lang.Runnable
            public final void run() {
                LiveDesireInputDialogFragment.this.d();
            }
        }, 300L);
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
