package com.blued.community.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/ItemMineEmotionBinding.class */
public final class ItemMineEmotionBinding implements ViewBinding {
    public final ImageView a;
    private final ConstraintLayout b;

    private ItemMineEmotionBinding(ConstraintLayout constraintLayout, ImageView imageView) {
        this.b = constraintLayout;
        this.a = imageView;
    }

    public static ItemMineEmotionBinding a(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.img);
        if (imageView != null) {
            return new ItemMineEmotionBinding((ConstraintLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("img"));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.b;
    }
}
