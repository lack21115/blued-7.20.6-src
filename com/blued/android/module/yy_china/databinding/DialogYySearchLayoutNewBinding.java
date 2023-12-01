package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYySearchLayoutNewBinding.class */
public final class DialogYySearchLayoutNewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f16456a;
    public final EditText b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16457c;
    private final RelativeLayout d;

    private DialogYySearchLayoutNewBinding(RelativeLayout relativeLayout, View view, EditText editText, ShapeTextView shapeTextView) {
        this.d = relativeLayout;
        this.f16456a = view;
        this.b = editText;
        this.f16457c = shapeTextView;
    }

    public static DialogYySearchLayoutNewBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.cover_view);
        if (findViewById != null) {
            EditText editText = (EditText) view.findViewById(R.id.et_input);
            if (editText != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_ok_btn);
                if (shapeTextView != null) {
                    return new DialogYySearchLayoutNewBinding((RelativeLayout) view, findViewById, editText, shapeTextView);
                }
                str = "tvOkBtn";
            } else {
                str = "etInput";
            }
        } else {
            str = "coverView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.d;
    }
}
