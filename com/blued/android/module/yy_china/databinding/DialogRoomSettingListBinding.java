package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogRoomSettingListBinding.class */
public final class DialogRoomSettingListBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final RecyclerView c;
    public final TextView d;
    private final FrameLayout e;

    private DialogRoomSettingListBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, TextView textView) {
        this.e = frameLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = recyclerView;
        this.d = textView;
    }

    public static DialogRoomSettingListBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_b);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_back);
            if (imageView2 != null) {
                RecyclerView findViewById = view.findViewById(R.id.rcv);
                if (findViewById != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_null);
                    if (textView != null) {
                        return new DialogRoomSettingListBinding((FrameLayout) view, imageView, imageView2, findViewById, textView);
                    }
                    str = "tvNull";
                } else {
                    str = "rcv";
                }
            } else {
                str = "ivBack";
            }
        } else {
            str = "ivB";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
