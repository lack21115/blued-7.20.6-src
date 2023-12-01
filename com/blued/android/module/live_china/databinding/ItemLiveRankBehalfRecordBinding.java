package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/ItemLiveRankBehalfRecordBinding.class */
public final class ItemLiveRankBehalfRecordBinding implements ViewBinding {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final LinearLayout e;
    public final LinearLayout f;
    public final TextView g;
    private final LinearLayout h;

    private ItemLiveRankBehalfRecordBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView4) {
        this.h = linearLayout;
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = linearLayout2;
        this.f = linearLayout3;
        this.g = textView4;
    }

    public static ItemLiveRankBehalfRecordBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.live_end_user_pic);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.live_user_behalf_name);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.live_user_name);
                if (textView2 != null) {
                    TextView textView3 = (TextView) view.findViewById(R.id.live_user_score);
                    if (textView3 != null) {
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_fans);
                        if (linearLayout != null) {
                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_live_rank_name);
                            if (linearLayout2 != null) {
                                TextView textView4 = (TextView) view.findViewById(R.id.tv_live_rank);
                                if (textView4 != null) {
                                    return new ItemLiveRankBehalfRecordBinding((LinearLayout) view, imageView, textView, textView2, textView3, linearLayout, linearLayout2, textView4);
                                }
                                str = "tvLiveRank";
                            } else {
                                str = "llLiveRankName";
                            }
                        } else {
                            str = "llFans";
                        }
                    } else {
                        str = "liveUserScore";
                    }
                } else {
                    str = "liveUserName";
                }
            } else {
                str = "liveUserBehalfName";
            }
        } else {
            str = "liveEndUserPic";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.h;
    }
}
