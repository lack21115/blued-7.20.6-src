package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyHomeChatsNewRoomsBinding.class */
public final class ItemYyHomeChatsNewRoomsBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f16729a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f16730c;

    private ItemYyHomeChatsNewRoomsBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        this.f16730c = constraintLayout;
        this.f16729a = recyclerView;
        this.b = textView;
    }

    public static ItemYyHomeChatsNewRoomsBinding a(View view) {
        String str;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rec);
        if (recyclerView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_title);
            if (textView != null) {
                return new ItemYyHomeChatsNewRoomsBinding((ConstraintLayout) view, recyclerView, textView);
            }
            str = "tvTitle";
        } else {
            str = "rec";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f16730c;
    }
}
