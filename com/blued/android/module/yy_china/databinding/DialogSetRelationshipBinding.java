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
    public final RecyclerView a;
    public final RecyclerView b;
    public final ShapeTextView c;
    private final LinearLayout d;

    private DialogSetRelationshipBinding(LinearLayout linearLayout, RecyclerView recyclerView, RecyclerView recyclerView2, ShapeTextView shapeTextView) {
        this.d = linearLayout;
        this.a = recyclerView;
        this.b = recyclerView2;
        this.c = shapeTextView;
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
        RecyclerView findViewById = view.findViewById(R.id.rcv_relation_type);
        if (findViewById != null) {
            RecyclerView findViewById2 = view.findViewById(R.id.rcv_time);
            if (findViewById2 != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_ok);
                if (shapeTextView != null) {
                    return new DialogSetRelationshipBinding((LinearLayout) view, findViewById, findViewById2, shapeTextView);
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

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.d;
    }
}
