package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyHomeChatsNewRoomsItemBinding.class */
public final class ItemYyHomeChatsNewRoomsItemBinding implements ViewBinding {
    public final ImageView a;
    private final ConstraintLayout b;

    private ItemYyHomeChatsNewRoomsItemBinding(ConstraintLayout constraintLayout, ImageView imageView) {
        this.b = constraintLayout;
        this.a = imageView;
    }

    public static ItemYyHomeChatsNewRoomsItemBinding a(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
        if (imageView != null) {
            return new ItemYyHomeChatsNewRoomsItemBinding((ConstraintLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("iv"));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.b;
    }
}
