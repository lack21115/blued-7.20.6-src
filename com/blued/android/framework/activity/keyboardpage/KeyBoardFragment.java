package com.blued.android.framework.activity.keyboardpage;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.blued.android.framework.activity.HomeTabFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.KeyboardUtils;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/activity/keyboardpage/KeyBoardFragment.class */
public class KeyBoardFragment extends HomeTabFragment {
    private static long b;
    public KeyboardListenLinearLayout d;
    public View e;
    public EditText f;
    public View g;
    public boolean h;
    public boolean i;

    public static boolean V_() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - b;
        if (0 >= j || j >= 600) {
            b = currentTimeMillis;
            return false;
        }
        return true;
    }

    public void O_() {
        if (V_()) {
            return;
        }
        if (this.e.getVisibility() != 0) {
            this.e.setVisibility(0);
            KeyboardUtils.a((Activity) getActivity());
            W_();
            j_(-4);
            return;
        }
        this.e.setVisibility(8);
        this.f.setFocusable(true);
        this.f.setFocusableInTouchMode(true);
        this.f.requestFocus();
        KeyboardUtils.c(getActivity());
        W_();
    }

    public void P_() {
        if (this.e.getVisibility() == 0) {
            this.f.setFocusable(true);
            this.f.setFocusableInTouchMode(true);
            this.f.requestFocus();
            KeyboardUtils.c(getActivity());
            W_();
            return;
        }
        this.e.setVisibility(0);
        this.g.setVisibility(0);
        KeyboardUtils.a((Activity) getActivity());
        W_();
        j_(-4);
    }

    protected void W_() {
        ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
        layoutParams.height = KeyboardUtils.a();
        this.e.setLayoutParams(layoutParams);
    }

    public void a(View view, KeyboardListenLinearLayout keyboardListenLinearLayout, EditText editText) {
        this.e = view;
        this.d = keyboardListenLinearLayout;
        this.f = editText;
        w_();
    }

    public void a(View view, KeyboardListenLinearLayout keyboardListenLinearLayout, EditText editText, View view2) {
        this.e = view;
        this.d = keyboardListenLinearLayout;
        this.f = editText;
        this.g = view2;
        w_();
    }

    public void a(KeyboardListenLinearLayout keyboardListenLinearLayout) {
        this.d = keyboardListenLinearLayout;
        v_();
    }

    protected void b(View view) {
        if (view.getVisibility() == 4) {
            view.setVisibility(8);
        }
    }

    protected void c(View view) {
        if (view.getVisibility() == 0) {
            view.setVisibility(4);
        }
    }

    @Override // com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment, com.blued.android.core.utils.PageTimeUtils.APMInterface
    public String getPageBizName() {
        return super.getPageBizName();
    }

    @Override // com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment
    public boolean isClosePageAPM() {
        return super.isClosePageAPM();
    }

    public void j_(int i) {
    }

    protected void v_() {
        this.d.setOnKeyboardStateChangedListener(new KeyboardListenLinearLayout.IOnKeyboardStateChangedListener() { // from class: com.blued.android.framework.activity.keyboardpage.KeyBoardFragment.1
            @Override // com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout.IOnKeyboardStateChangedListener
            public void a(int i) {
                if (i == -3) {
                    KeyBoardFragment.this.j_(-3);
                } else if (i != -2) {
                } else {
                    KeyBoardFragment.this.j_(-2);
                }
            }
        });
    }

    protected void w_() {
        this.d.setOnKeyboardStateChangedListener(new KeyboardListenLinearLayout.IOnKeyboardStateChangedListener() { // from class: com.blued.android.framework.activity.keyboardpage.KeyBoardFragment.2
            @Override // com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout.IOnKeyboardStateChangedListener
            public void a(int i) {
                if (i != -3) {
                    if (i != -2) {
                        return;
                    }
                    KeyBoardFragment keyBoardFragment = KeyBoardFragment.this;
                    keyBoardFragment.b(keyBoardFragment.e);
                    KeyBoardFragment.this.j_(-2);
                    KeyBoardFragment.this.h = false;
                    return;
                }
                KeyBoardFragment.this.getActivity().getWindow().setSoftInputMode(19);
                if (KeyBoardFragment.this.i) {
                    KeyBoardFragment keyBoardFragment2 = KeyBoardFragment.this;
                    keyBoardFragment2.c(keyBoardFragment2.e);
                } else {
                    KeyBoardFragment keyBoardFragment3 = KeyBoardFragment.this;
                    keyBoardFragment3.b(keyBoardFragment3.e);
                }
                KeyBoardFragment.this.W_();
                KeyBoardFragment.this.j_(-3);
                KeyBoardFragment.this.h = true;
            }
        });
    }

    @Override // com.blued.android.framework.activity.HomeTabFragment
    public boolean x_() {
        return true;
    }
}
