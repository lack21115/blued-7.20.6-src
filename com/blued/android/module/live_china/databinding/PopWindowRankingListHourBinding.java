package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/PopWindowRankingListHourBinding.class */
public final class PopWindowRankingListHourBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final LinearLayout f;
    public final RelativeLayout g;
    public final RelativeLayout h;
    public final RecyclerView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    private final FrameLayout n;

    private PopWindowRankingListHourBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.n = frameLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.e = imageView5;
        this.f = linearLayout;
        this.g = relativeLayout;
        this.h = relativeLayout2;
        this.i = recyclerView;
        this.j = textView;
        this.k = textView2;
        this.l = textView3;
        this.m = textView4;
    }

    public static PopWindowRankingListHourBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_avatar);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_avatar_frame);
            if (imageView2 != null) {
                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_bounce);
                if (imageView3 != null) {
                    ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_empty_view);
                    if (imageView4 != null) {
                        ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_rank_index);
                        if (imageView5 != null) {
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_anchor_rank_layout);
                            if (linearLayout != null) {
                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_avatar);
                                if (relativeLayout != null) {
                                    RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_empty_view);
                                    if (relativeLayout2 != null) {
                                        RecyclerView findViewById = view.findViewById(R.id.rv_list);
                                        if (findViewById != null) {
                                            TextView textView = (TextView) view.findViewById(R.id.tv_empty_view);
                                            if (textView != null) {
                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                                                if (textView2 != null) {
                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_rank);
                                                    if (textView3 != null) {
                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_rank_index);
                                                        if (textView4 != null) {
                                                            return new PopWindowRankingListHourBinding((FrameLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, linearLayout, relativeLayout, relativeLayout2, findViewById, textView, textView2, textView3, textView4);
                                                        }
                                                        str = "tvRankIndex";
                                                    } else {
                                                        str = "tvRank";
                                                    }
                                                } else {
                                                    str = "tvName";
                                                }
                                            } else {
                                                str = "tvEmptyView";
                                            }
                                        } else {
                                            str = "rvList";
                                        }
                                    } else {
                                        str = "rlEmptyView";
                                    }
                                } else {
                                    str = "rlAvatar";
                                }
                            } else {
                                str = "llAnchorRankLayout";
                            }
                        } else {
                            str = "ivRankIndex";
                        }
                    } else {
                        str = "ivEmptyView";
                    }
                } else {
                    str = "ivBounce";
                }
            } else {
                str = "ivAvatarFrame";
            }
        } else {
            str = "ivAvatar";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.n;
    }
}
