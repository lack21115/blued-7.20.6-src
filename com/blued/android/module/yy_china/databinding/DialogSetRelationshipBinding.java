package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogSetRelationshipBinding.class */
public final class DialogSetRelationshipBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f16411a;
    public final RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16412c;
    private final LinearLayout d;

    private DialogSetRelationshipBinding(LinearLayout linearLayout, RecyclerView recyclerView, RecyclerView recyclerView2, ShapeTextView shapeTextView) {
        this.d = linearLayout;
        this.f16411a = recyclerView;
        this.b = recyclerView2;
        this.f16412c = shapeTextView;
    }

    public static DialogSetRelationshipBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_set_relationship, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogSetRelationshipBinding a(View view) {
        String str;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv_relation_type);
        if (recyclerView != null) {
            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rcv_time);
            if (recyclerView2 != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_ok);
                if (shapeTextView != null) {
                    return new DialogSetRelationshipBinding((LinearLayout) view, recyclerView, recyclerView2, shapeTextView);
                }
                str = "tvOk";
            } else {
                str = "rcvTime";
            }
        } else {
            str = "rcvRelationType";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.d;
    }
}
