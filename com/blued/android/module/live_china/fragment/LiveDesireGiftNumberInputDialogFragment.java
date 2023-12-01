package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
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
import java.util.regex.Pattern;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveDesireGiftNumberInputDialogFragment.class */
public class LiveDesireGiftNumberInputDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public Context f12829a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f12830c;
    private EditText d;
    private View e;
    private InputCallBack f;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveDesireGiftNumberInputDialogFragment$InputCallBack.class */
    public interface InputCallBack {
        void a(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z) {
        if (z && a(view)) {
            return;
        }
        if (z || a(view)) {
            view.setTag(Boolean.valueOf(z));
            if (z) {
                view.setPivotX(view.getWidth() / 2);
                view.setPivotY(view.getHeight() / 2);
                view.setScaleX(0.9f);
                view.setScaleY(0.9f);
            }
            ViewPropertyAnimator scaleX = view.animate().alpha(z ? 1.0f : 0.0f).scaleX(z ? 1.0f : 0.9f);
            float f = 0.9f;
            if (z) {
                f = 1.0f;
            }
            scaleX.scaleY(f).setDuration(70L);
        }
    }

    private boolean a(View view) {
        if (view.getTag() != null && (view.getTag() instanceof Boolean)) {
            return ((Boolean) view.getTag()).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(TextView textView, int i, KeyEvent keyEvent) {
        dismiss();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (this.e.getAlpha() > 0.95f) {
            dismiss();
        }
    }

    private void d() {
        this.d.addTextChangedListener(new TextWatcher() { // from class: com.blued.android.module.live_china.fragment.LiveDesireGiftNumberInputDialogFragment.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i;
                boolean z;
                if (editable == null || editable.length() == 0 || !LiveDesireGiftNumberInputDialogFragment.this.a(editable.toString())) {
                    i = 0;
                    z = false;
                } else {
                    i = editable.length() > 4 ? 9999 : Integer.parseInt(editable.toString());
                    z = true;
                }
                LiveDesireGiftNumberInputDialogFragment.this.f12830c = i;
                if (z) {
                    LiveDesireGiftNumberInputDialogFragment liveDesireGiftNumberInputDialogFragment = LiveDesireGiftNumberInputDialogFragment.this;
                    liveDesireGiftNumberInputDialogFragment.a(liveDesireGiftNumberInputDialogFragment.e, true);
                    return;
                }
                LiveDesireGiftNumberInputDialogFragment.this.e.setClickable(false);
                LiveDesireGiftNumberInputDialogFragment liveDesireGiftNumberInputDialogFragment2 = LiveDesireGiftNumberInputDialogFragment.this;
                liveDesireGiftNumberInputDialogFragment2.a(liveDesireGiftNumberInputDialogFragment2.e, false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.d.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireGiftNumberInputDialogFragment$HQpRVB7BKULNw80Zn7W-ckAcnk4
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean a2;
                a2 = LiveDesireGiftNumberInputDialogFragment.this.a(textView, i, keyEvent);
                return a2;
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireGiftNumberInputDialogFragment$a2YTrNg4x-r_l2TyNuoiCEPe26o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveDesireGiftNumberInputDialogFragment.this.b(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(this.d, 0);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.f12829a = getActivity();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_desire_adddesire_gift_number_input, (ViewGroup) null);
        int a2 = DensityUtils.a(this.f12829a, 60.0f);
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.alpha_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a2;
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - a2;
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_live_desire_adddesire_gift_number_input, viewGroup);
        this.d = (EditText) inflate.findViewById(R.id.et_number);
        this.e = inflate.findViewById(R.id.iv_check);
        d();
        int i = this.b;
        String valueOf = i == 0 ? "" : String.valueOf(i);
        if (this.b > 0) {
            this.d.setText(valueOf);
        }
        this.d.setFocusable(true);
        this.d.setFocusableInTouchMode(true);
        this.d.requestFocus();
        if (this.b > 0) {
            this.d.setSelection(valueOf.length());
        }
        a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireGiftNumberInputDialogFragment$pO-QAxmwiUvsoyrrN6AHEx9PeB0
            @Override // java.lang.Runnable
            public final void run() {
                LiveDesireGiftNumberInputDialogFragment.this.e();
            }
        }, 300L);
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f.a(this.f12830c);
        super.onDismiss(dialogInterface);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment
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
