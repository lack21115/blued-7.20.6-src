package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyRelationshipRoomTaskTitleBinding.class */
public final class ItemYyRelationshipRoomTaskTitleBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16802a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f16803c;

    private ItemYyRelationshipRoomTaskTitleBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.f16803c = constraintLayout;
        this.f16802a = textView;
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f16803c;
    }
}
