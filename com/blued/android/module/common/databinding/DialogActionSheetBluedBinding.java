package com.blued.android.module.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/databinding/DialogActionSheetBluedBinding.class */
public final class DialogActionSheetBluedBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f10712a;
    public final RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f10713c;
    private final ConstraintLayout d;

    private DialogActionSheetBluedBinding(ConstraintLayout constraintLayout, View view, RecyclerView recyclerView, ShapeTextView shapeTextView) {
        this.d = constraintLayout;
        this.f10712a = view;
        this.b = recyclerView;
        this.f10713c = shapeTextView;
    }

    public static DialogActionSheetBluedBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_action_sheet_blued, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogActionSheetBluedBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.line);
        if (findViewById != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv_sheet);
            if (recyclerView != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_cancel);
                if (shapeTextView != null) {
                    return new DialogActionSheetBluedBinding((ConstraintLayout) view, findViewById, recyclerView, shapeTextView);
                }
                str = "tvCancel";
            } else {
                str = "rcvSheet";
            }
        } else {
            str = "line";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
