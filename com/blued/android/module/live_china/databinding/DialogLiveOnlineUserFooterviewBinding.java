package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveOnlineUserFooterviewBinding.class */
public final class DialogLiveOnlineUserFooterviewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f11794a;
    private final ShapeRelativeLayout b;

    private DialogLiveOnlineUserFooterviewBinding(ShapeRelativeLayout shapeRelativeLayout, TextView textView) {
        this.b = shapeRelativeLayout;
        this.f11794a = textView;
    }

    public static DialogLiveOnlineUserFooterviewBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveOnlineUserFooterviewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_online_user_footerview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveOnlineUserFooterviewBinding a(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_online_user_max_tips);
        if (textView != null) {
            return new DialogLiveOnlineUserFooterviewBinding((ShapeRelativeLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("tvOnlineUserMaxTips"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeRelativeLayout getRoot() {
        return this.b;
    }
}
