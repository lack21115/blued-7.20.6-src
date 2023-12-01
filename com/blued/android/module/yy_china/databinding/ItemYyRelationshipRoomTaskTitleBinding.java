package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyRelationshipRoomTaskTitleBinding.class */
public final class ItemYyRelationshipRoomTaskTitleBinding implements ViewBinding {
    public final TextView a;
    public final TextView b;
    private final ConstraintLayout c;

    private ItemYyRelationshipRoomTaskTitleBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.c = constraintLayout;
        this.a = textView;
        this.b = textView2;
    }

    public static ItemYyRelationshipRoomTaskTitleBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.tv);
        if (textView != null) {
            TextView textView2 = (TextView) view.findViewById(R.id.tv_title);
            if (textView2 != null) {
                return new ItemYyRelationshipRoomTaskTitleBinding((ConstraintLayout) view, textView, textView2);
            }
            str = "tvTitle";
        } else {
            str = "tv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.c;
    }
}
