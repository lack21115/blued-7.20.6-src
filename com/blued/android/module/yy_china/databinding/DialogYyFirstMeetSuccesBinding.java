package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYyFirstMeetSuccesBinding.class */
public final class DialogYyFirstMeetSuccesBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final Group f16429a;
    public final SquareImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16430c;
    public final RecyclerView d;
    public final SVGAImageView e;
    public final TextView f;
    private final LinearLayout g;

    private DialogYyFirstMeetSuccesBinding(LinearLayout linearLayout, Group group, SquareImageView squareImageView, ImageView imageView, RecyclerView recyclerView, SVGAImageView sVGAImageView, TextView textView) {
        this.g = linearLayout;
        this.f16429a = group;
        this.b = squareImageView;
        this.f16430c = imageView;
        this.d = recyclerView;
        this.e = sVGAImageView;
        this.f = textView;
    }

    public static DialogYyFirstMeetSuccesBinding a(View view) {
        String str;
        Group group = (Group) view.findViewById(R.id.group);
        if (group != null) {
            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_smeel);
            if (squareImageView != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_title);
                if (imageView != null) {
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rec);
                    if (recyclerView != null) {
                        SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.svga);
                        if (sVGAImageView != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_title);
                            if (textView != null) {
                                return new DialogYyFirstMeetSuccesBinding((LinearLayout) view, group, squareImageView, imageView, recyclerView, sVGAImageView, textView);
                            }
                            str = "tvTitle";
                        } else {
                            str = "svga";
                        }
                    } else {
                        str = "rec";
                    }
                } else {
                    str = "ivTitle";
                }
            } else {
                str = "ivSmeel";
            }
        } else {
            str = "group";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.g;
    }
}
