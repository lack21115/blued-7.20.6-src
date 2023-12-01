package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYSvgaView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyHomeRoomsAdBinding.class */
public final class ItemYyHomeRoomsAdBinding implements ViewBinding {
    public final YYSvgaView a;
    public final TextView b;
    public final TextView c;
    private final FrameLayout d;

    private ItemYyHomeRoomsAdBinding(FrameLayout frameLayout, YYSvgaView yYSvgaView, TextView textView, TextView textView2) {
        this.d = frameLayout;
        this.a = yYSvgaView;
        this.b = textView;
        this.c = textView2;
    }

    public static ItemYyHomeRoomsAdBinding a(View view) {
        String str;
        YYSvgaView yYSvgaView = (YYSvgaView) view.findViewById(R.id.svga);
        if (yYSvgaView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_title);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.tv_title_2);
                if (textView2 != null) {
                    return new ItemYyHomeRoomsAdBinding((FrameLayout) view, yYSvgaView, textView, textView2);
                }
                str = "tvTitle2";
            } else {
                str = "tvTitle";
            }
        } else {
            str = "svga";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.d;
    }
}
