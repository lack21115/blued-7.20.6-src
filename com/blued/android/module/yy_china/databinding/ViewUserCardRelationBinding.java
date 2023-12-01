package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewUserCardRelationBinding.class */
public final class ViewUserCardRelationBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16882a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private final View f16883c;

    private ViewUserCardRelationBinding(View view, ImageView imageView, TextView textView) {
        this.f16883c = view;
        this.f16882a = imageView;
        this.b = textView;
    }

    public static ViewUserCardRelationBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.view_user_card_relation, viewGroup);
            return a(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    public static ViewUserCardRelationBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_relation_use_1);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_relation_name_1);
            if (textView != null) {
                return new ViewUserCardRelationBinding(view, imageView, textView);
            }
            str = "tvRelationName1";
        } else {
            str = "ivRelationUse1";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f16883c;
    }
}
