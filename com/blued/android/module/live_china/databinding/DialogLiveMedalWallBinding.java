package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveMedalWallBinding.class */
public final class DialogLiveMedalWallBinding implements ViewBinding {
    public final View a;
    public final FrameLayout b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final LinearLayout f;
    public final RecyclerView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    private final FrameLayout k;

    private DialogLiveMedalWallBinding(FrameLayout frameLayout, View view, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        this.k = frameLayout;
        this.a = view;
        this.b = frameLayout2;
        this.c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = linearLayout;
        this.g = recyclerView;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
    }

    public static DialogLiveMedalWallBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveMedalWallBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_medal_wall, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveMedalWallBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.dividing_line);
        if (findViewById != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_user_avatar);
            if (frameLayout != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_avatar);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_avatar_decorate);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_medal_explain);
                        if (imageView3 != null) {
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_empty_view);
                            if (linearLayout != null) {
                                RecyclerView findViewById2 = view.findViewById(R.id.rv_medal_wall);
                                if (findViewById2 != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_left_tab);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_right_tab);
                                        if (textView2 != null) {
                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_user_nick);
                                            if (textView3 != null) {
                                                return new DialogLiveMedalWallBinding((FrameLayout) view, findViewById, frameLayout, imageView, imageView2, imageView3, linearLayout, findViewById2, textView, textView2, textView3);
                                            }
                                            str = "tvUserNick";
                                        } else {
                                            str = "tvRightTab";
                                        }
                                    } else {
                                        str = "tvLeftTab";
                                    }
                                } else {
                                    str = "rvMedalWall";
                                }
                            } else {
                                str = "llEmptyView";
                            }
                        } else {
                            str = "ivMedalExplain";
                        }
                    } else {
                        str = "ivAvatarDecorate";
                    }
                } else {
                    str = "ivAvatar";
                }
            } else {
                str = "flUserAvatar";
            }
        } else {
            str = "dividingLine";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.k;
    }
}
