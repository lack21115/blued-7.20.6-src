package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogApplyCloseRoomLayoutBinding.class */
public final class DialogApplyCloseRoomLayoutBinding implements ViewBinding {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    private final FrameLayout e;

    private DialogApplyCloseRoomLayoutBinding(FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.e = frameLayout;
        this.a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
    }

    public static DialogApplyCloseRoomLayoutBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_apply_close_room_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogApplyCloseRoomLayoutBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.cancle);
        if (textView != null) {
            TextView textView2 = (TextView) view.findViewById(R.id.dialog_title_time);
            if (textView2 != null) {
                TextView textView3 = (TextView) view.findViewById(R.id.ok);
                if (textView3 != null) {
                    TextView textView4 = (TextView) view.findViewById(R.id.tv_content_num);
                    if (textView4 != null) {
                        return new DialogApplyCloseRoomLayoutBinding((FrameLayout) view, textView, textView2, textView3, textView4);
                    }
                    str = "tvContentNum";
                } else {
                    str = "ok";
                }
            } else {
                str = "dialogTitleTime";
            }
        } else {
            str = "cancle";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
