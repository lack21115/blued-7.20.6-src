package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveConnectPkUserItemBinding.class */
public final class LiveConnectPkUserItemBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final RelativeLayout c;
    public final TextView d;
    private final RelativeLayout e;

    private LiveConnectPkUserItemBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout2, TextView textView) {
        this.e = relativeLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = relativeLayout2;
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

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.e;
    }
}
