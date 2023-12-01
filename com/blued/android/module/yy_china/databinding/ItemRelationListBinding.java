package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemRelationListBinding.class */
public final class ItemRelationListBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    private final FrameLayout h;

    private ItemRelationListBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2, TextView textView3) {
        this.h = frameLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
    }

    public static ItemRelationListBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_num);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_relation);
            if (imageView2 != null) {
                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_user_l);
                if (imageView3 != null) {
                    ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_user_r);
                    if (imageView4 != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_auction_num);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_close_num);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_relation);
                                if (textView3 != null) {
                                    return new ItemRelationListBinding((FrameLayout) view, imageView, imageView2, imageView3, imageView4, textView, textView2, textView3);
                                }
                                str = "tvRelation";
                            } else {
                                str = "tvCloseNum";
                            }
                        } else {
                            str = "tvAuctionNum";
                        }
                    } else {
                        str = "ivUserR";
                    }
                } else {
                    str = "ivUserL";
                }
            } else {
                str = "ivRelation";
            }
        } else {
            str = "ivNum";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.h;
    }
}
