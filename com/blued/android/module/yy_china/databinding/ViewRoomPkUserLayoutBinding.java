package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewRoomPkUserLayoutBinding.class */
public final class ViewRoomPkUserLayoutBinding implements ViewBinding {
    public final ShapeTextView a;
    public final YYBaseUserHeadView b;
    private final ConstraintLayout c;

    private ViewRoomPkUserLayoutBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, YYBaseUserHeadView yYBaseUserHeadView) {
        this.c = constraintLayout;
        this.a = shapeTextView;
        this.b = yYBaseUserHeadView;
    }

    public static ViewRoomPkUserLayoutBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_room_pk_user_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewRoomPkUserLayoutBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_user_name);
        if (shapeTextView != null) {
            YYBaseUserHeadView yYBaseUserHeadView = (YYBaseUserHeadView) view.findViewById(R.id.user_view);
            if (yYBaseUserHeadView != null) {
                return new ViewRoomPkUserLayoutBinding((ConstraintLayout) view, shapeTextView, yYBaseUserHeadView);
            }
            str = "userView";
        } else {
            str = "tvUserName";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.c;
    }
}
