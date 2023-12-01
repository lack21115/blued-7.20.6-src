package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyRelationshipRoomUsersItemBinding.class */
public final class ItemYyRelationshipRoomUsersItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16804a;
    public final YYBaseUserHeadView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16805c;
    public final TextView d;
    private final ConstraintLayout e;

    private ItemYyRelationshipRoomUsersItemBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, YYBaseUserHeadView yYBaseUserHeadView, TextView textView, TextView textView2) {
        this.e = constraintLayout;
        this.f16804a = shapeTextView;
        this.b = yYBaseUserHeadView;
        this.f16805c = textView;
        this.d = textView2;
    }

    public static ItemYyRelationshipRoomUsersItemBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_invite);
        if (shapeTextView != null) {
            YYBaseUserHeadView yYBaseUserHeadView = (YYBaseUserHeadView) view.findViewById(R.id.iv_user);
            if (yYBaseUserHeadView != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_mess);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                    if (textView2 != null) {
                        return new ItemYyRelationshipRoomUsersItemBinding((ConstraintLayout) view, shapeTextView, yYBaseUserHeadView, textView, textView2);
                    }
                    str = "tvName";
                } else {
                    str = "tvMess";
                }
            } else {
                str = "ivUser";
            }
        } else {
            str = "btnInvite";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
