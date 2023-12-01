package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveConnectPkUserItemBinding.class */
public final class LiveConnectPkUserItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f12161a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f12162c;
    public final TextView d;
    private final RelativeLayout e;

    private LiveConnectPkUserItemBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout2, TextView textView) {
        this.e = relativeLayout;
        this.f12161a = imageView;
        this.b = imageView2;
        this.f12162c = relativeLayout2;
        this.d = textView;
    }

    public static LiveConnectPkUserItemBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_avatar);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_switch);
            if (imageView2 != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_switch);
                if (relativeLayout != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_nickname);
                    if (textView != null) {
                        return new LiveConnectPkUserItemBinding((RelativeLayout) view, imageView, imageView2, relativeLayout, textView);
                    }
                    str = "tvNickname";
                } else {
                    str = "rlSwitch";
                }
            } else {
                str = "ivSwitch";
            }
        } else {
            str = "ivAvatar";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.e;
    }
}
