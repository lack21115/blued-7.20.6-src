package com.blued.android.framework.ui.custom;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.KeyboardUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/custom/MvpKeyBoardFragment.class */
public abstract class MvpKeyBoardFragment<T extends MvpPresenter> extends MvpFragment<T> {
    public KeyboardListenLinearLayout a;
    public View b;
    public EditText c;
    public View d;
    public View e;
    public boolean f;
    public boolean g;

    public void a(int i) {
    }

    protected void a(View view) {
        if (view.getVisibility() == 4) {
            view.setVisibility(8);
        }
    }

    public void a(View view, KeyboardListenLinearLayout keyboardListenLinearLayout, EditText editText, View view2) {
        this.b = view;
        this.a = keyboardListenLinearLayout;
        this.c = editText;
        this.d = view2;
        c();
    }

    public void a(KeyboardListenLinearLayout keyboardListenLinearLayout) {
        this.a = keyboardListenLinearLayout;
        b();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
        KeyboardListenLinearLayout keyboardListenLinearLayout = this.a;
        if (keyboardListenLinearLayout != null) {
            keyboardListenLinearLayout.setOnKeyboardStateChangedListener(null);
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = false;
    }

    protected void b() {
        this.a.setOnKeyboardStateChangedListener(new KeyboardListenLinearLayout.IOnKeyboardStateChangedListener() { // from class: com.blued.android.framework.ui.custom.MvpKeyBoardFragment.1
            @Override // com.blued.android.framework.ui.custom.KeyboardListenLinearLayout.IOnKeyboardStateChangedListener
            public void a(int i) {
                if (i == -3) {
                    MvpKeyBoardFragment.this.a(-3);
                } else if (i != -2) {
                } else {
                    MvpKeyBoardFragment.this.a(-2);
                }
            }
        });
    }

    protected void b(View view) {
        if (view.getVisibility() == 0) {
            view.setVisibility(4);
        }
    }

    protected void c() {
        this.a.setOnKeyboardStateChangedListener(new KeyboardListenLinearLayout.IOnKeyboardStateChangedListener() { // from class: com.blued.android.framework.ui.custom.MvpKeyBoardFragment.2
            @Override // com.blued.android.framework.ui.custom.KeyboardListenLinearLayout.IOnKeyboardStateChangedListener
            public void a(int i) {
                if (i != -3) {
                    if (i != -2) {
                        return;
                    }
                    MvpKeyBoardFragment mvpKeyBoardFragment = MvpKeyBoardFragment.this;
                    mvpKeyBoardFragment.a(mvpKeyBoardFragment.b);
                    MvpKeyBoardFragment.this.a(-2);
                    MvpKeyBoardFragment.this.f = false;
                    return;
                }
                MvpKeyBoardFragment.this.getActivity().getWindow().setSoftInputMode(19);
                if (MvpKeyBoardFragment.this.g) {
                    MvpKeyBoardFragment mvpKeyBoardFragment2 = MvpKeyBoardFragment.this;
                    mvpKeyBoardFragment2.b(mvpKeyBoardFragment2.b);
                } else {
                    MvpKeyBoardFragment mvpKeyBoardFragment3 = MvpKeyBoardFragment.this;
                    mvpKeyBoardFragment3.a(mvpKeyBoardFragment3.b);
                }
                MvpKeyBoardFragment.this.d();
                MvpKeyBoardFragment.this.a(-3);
                MvpKeyBoardFragment.this.f = true;
            }
        });
    }

    protected void d() {
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        layoutParams.height = KeyboardUtils.a();
        this.b.setLayoutParams(layoutParams);
    }

    public void e() {
        if (this.b.getVisibility() == 0) {
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.requestFocus();
            KeyboardUtils.c(getActivity());
            d();
            return;
        }
        this.b.setVisibility(0);
        this.d.setVisibility(0);
        KeyboardUtils.a((Activity) getActivity());
        d();
        a(-4);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.utils.PageTimeUtils.APMInterface
    public String getPageBizName() {
        return super.getPageBizName();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public boolean isClosePageAPM() {
        return super.isClosePageAPM();
    }
}
