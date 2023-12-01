package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYKtvPro2View;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewKtvMusicProBinding.class */
public final class ViewKtvMusicProBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final LinearLayout d;
    public final LinearLayout e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final YYKtvPro2View i;
    private final ConstraintLayout j;

    private ViewKtvMusicProBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, YYKtvPro2View yYKtvPro2View) {
        this.j = constraintLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = linearLayout;
        this.e = linearLayout2;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = yYKtvPro2View;
    }

    public static ViewKtvMusicProBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_ktv_music_pro, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewKtvMusicProBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_ktv);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_ktv_pre);
            if (imageView2 != null) {
                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_music_pro_style);
                if (imageView3 != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_ktv_mess);
                    if (linearLayout != null) {
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_ktv_mess_pre);
                        if (linearLayout2 != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_add_ktv_num);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_ktv_num);
                                if (textView2 != null) {
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_ktv_num_pre);
                                    if (textView3 != null) {
                                        YYKtvPro2View yYKtvPro2View = (YYKtvPro2View) view.findViewById(R.id.yy_pro);
                                        if (yYKtvPro2View != null) {
                                            return new ViewKtvMusicProBinding((ConstraintLayout) view, imageView, imageView2, imageView3, linearLayout, linearLayout2, textView, textView2, textView3, yYKtvPro2View);
                                        }
                                        str = "yyPro";
                                    } else {
                                        str = "tvKtvNumPre";
                                    }
                                } else {
                                    str = "tvKtvNum";
                                }
                            } else {
                                str = "tvAddKtvNum";
                            }
                        } else {
                            str = "llKtvMessPre";
                        }
                    } else {
                        str = "llKtvMess";
                    }
                } else {
                    str = "ivMusicProStyle";
                }
            } else {
                str = "ivKtvPre";
            }
        } else {
            str = "ivKtv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.j;
    }
}
