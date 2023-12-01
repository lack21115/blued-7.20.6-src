package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyHomeChatsNewRoomsBinding.class */
public final class ItemYyHomeChatsNewRoomsBinding implements ViewBinding {
    public final RecyclerView a;
    public final TextView b;
    private final ConstraintLayout c;

    private ItemYyHomeChatsNewRoomsBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        this.c = constraintLayout;
        this.a = recyclerView;
        this.b = textView;
    }

    public static ItemYyHomeChatsNewRoomsBinding a(View view) {
        String str;
        RecyclerView findViewById = view.findViewById(R.id.rec);
        if (findViewById != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_title);
            if (textView != null) {
                return new ItemYyHomeChatsNewRoomsBinding((ConstraintLayout) view, findViewById, textView);
            }
            str = "tvTitle";
        } else {
            str = "rec";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.c;
    }
}
