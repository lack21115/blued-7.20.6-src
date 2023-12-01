package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentEventUserInfoBinding.class */
public final class FragmentEventUserInfoBinding implements ViewBinding {
    public final ImageView A;
    private final FrameLayout B;
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final ImageView f;
    public final TextView g;
    public final View h;
    public final LinearLayout i;
    public final TextView j;
    public final CardView k;
    public final ImageView l;
    public final RelativeLayout m;
    public final TextView n;
    public final View o;
    public final TextView p;
    public final LinearLayout q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final View v;
    public final ImageView w;
    public final FrameLayout x;
    public final TextView y;
    public final ImageView z;

    private FragmentEventUserInfoBinding(FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ImageView imageView, TextView textView6, View view, LinearLayout linearLayout, TextView textView7, CardView cardView, ImageView imageView2, RelativeLayout relativeLayout, TextView textView8, View view2, TextView textView9, LinearLayout linearLayout2, TextView textView10, TextView textView11, TextView textView12, TextView textView13, View view3, ImageView imageView3, FrameLayout frameLayout2, TextView textView14, ImageView imageView4, ImageView imageView5) {
        this.B = frameLayout;
        this.a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f = imageView;
        this.g = textView6;
        this.h = view;
        this.i = linearLayout;
        this.j = textView7;
        this.k = cardView;
        this.l = imageView2;
        this.m = relativeLayout;
        this.n = textView8;
        this.o = view2;
        this.p = textView9;
        this.q = linearLayout2;
        this.r = textView10;
        this.s = textView11;
        this.t = textView12;
        this.u = textView13;
        this.v = view3;
        this.w = imageView3;
        this.x = frameLayout2;
        this.y = textView14;
        this.z = imageView4;
        this.A = imageView5;
    }

    public static FragmentEventUserInfoBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static FragmentEventUserInfoBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_event_user_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentEventUserInfoBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.event_user_info_activity_join);
        if (textView != null) {
            TextView textView2 = (TextView) view.findViewById(R.id.event_user_info_activity_join_des);
            if (textView2 != null) {
                TextView textView3 = (TextView) view.findViewById(R.id.event_user_info_activity_num);
                if (textView3 != null) {
                    TextView textView4 = (TextView) view.findViewById(R.id.event_user_info_activity_num_des);
                    if (textView4 != null) {
                        TextView textView5 = (TextView) view.findViewById(R.id.event_user_info_age_height);
                        if (textView5 != null) {
                            ImageView imageView = (ImageView) view.findViewById(R.id.event_user_info_avatar);
                            if (imageView != null) {
                                TextView textView6 = (TextView) view.findViewById(R.id.event_user_info_chat);
                                if (textView6 != null) {
                                    View findViewById = view.findViewById(R.id.event_user_info_chat_divider);
                                    if (findViewById != null) {
                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.event_user_info_content_layout);
                                        if (linearLayout != null) {
                                            TextView textView7 = (TextView) view.findViewById(R.id.event_user_info_des);
                                            if (textView7 != null) {
                                                CardView findViewById2 = view.findViewById(R.id.event_user_info_des_auditing);
                                                if (findViewById2 != null) {
                                                    ImageView imageView2 = (ImageView) view.findViewById(R.id.event_user_info_des_edit_icon);
                                                    if (imageView2 != null) {
                                                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.event_user_info_des_layout);
                                                        if (relativeLayout != null) {
                                                            TextView textView8 = (TextView) view.findViewById(R.id.event_user_info_follow);
                                                            if (textView8 != null) {
                                                                View findViewById3 = view.findViewById(R.id.event_user_info_follow_divider);
                                                                if (findViewById3 != null) {
                                                                    TextView textView9 = (TextView) view.findViewById(R.id.event_user_info_name);
                                                                    if (textView9 != null) {
                                                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.event_user_info_name_layout);
                                                                        if (linearLayout2 != null) {
                                                                            TextView textView10 = (TextView) view.findViewById(R.id.event_user_info_profile);
                                                                            if (textView10 != null) {
                                                                                TextView textView11 = (TextView) view.findViewById(R.id.event_user_info_reg_time);
                                                                                if (textView11 != null) {
                                                                                    TextView textView12 = (TextView) view.findViewById(R.id.event_user_info_reg_time_des);
                                                                                    if (textView12 != null) {
                                                                                        TextView textView13 = (TextView) view.findViewById(R.id.event_user_info_report);
                                                                                        if (textView13 != null) {
                                                                                            View findViewById4 = view.findViewById(R.id.event_user_info_sub_divider);
                                                                                            if (findViewById4 != null) {
                                                                                                ImageView imageView3 = (ImageView) view.findViewById(R.id.event_user_info_sub_iv);
                                                                                                if (imageView3 != null) {
                                                                                                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.event_user_info_sub_layout);
                                                                                                    if (frameLayout != null) {
                                                                                                        TextView textView14 = (TextView) view.findViewById(R.id.event_user_info_sub_tv);
                                                                                                        if (textView14 != null) {
                                                                                                            ImageView imageView4 = (ImageView) view.findViewById(R.id.event_user_info_verify);
                                                                                                            if (imageView4 != null) {
                                                                                                                ImageView imageView5 = (ImageView) view.findViewById(R.id.event_user_info_vip);
                                                                                                                if (imageView5 != null) {
                                                                                                                    return new FragmentEventUserInfoBinding((FrameLayout) view, textView, textView2, textView3, textView4, textView5, imageView, textView6, findViewById, linearLayout, textView7, findViewById2, imageView2, relativeLayout, textView8, findViewById3, textView9, linearLayout2, textView10, textView11, textView12, textView13, findViewById4, imageView3, frameLayout, textView14, imageView4, imageView5);
                                                                                                                }
                                                                                                                str = "eventUserInfoVip";
                                                                                                            } else {
                                                                                                                str = "eventUserInfoVerify";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "eventUserInfoSubTv";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "eventUserInfoSubLayout";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "eventUserInfoSubIv";
                                                                                                }
                                                                                            } else {
                                                                                                str = "eventUserInfoSubDivider";
                                                                                            }
                                                                                        } else {
                                                                                            str = "eventUserInfoReport";
                                                                                        }
                                                                                    } else {
                                                                                        str = "eventUserInfoRegTimeDes";
                                                                                    }
                                                                                } else {
                                                                                    str = "eventUserInfoRegTime";
                                                                                }
                                                                            } else {
                                                                                str = "eventUserInfoProfile";
                                                                            }
                                                                        } else {
                                                                            str = "eventUserInfoNameLayout";
                                                                        }
                                                                    } else {
                                                                        str = "eventUserInfoName";
                                                                    }
                                                                } else {
                                                                    str = "eventUserInfoFollowDivider";
                                                                }
                                                            } else {
                                                                str = "eventUserInfoFollow";
                                                            }
                                                        } else {
                                                            str = "eventUserInfoDesLayout";
                                                        }
                                                    } else {
                                                        str = "eventUserInfoDesEditIcon";
                                                    }
                                                } else {
                                                    str = "eventUserInfoDesAuditing";
                                                }
                                            } else {
                                                str = "eventUserInfoDes";
                                            }
                                        } else {
                                            str = "eventUserInfoContentLayout";
                                        }
                                    } else {
                                        str = "eventUserInfoChatDivider";
                                    }
                                } else {
                                    str = "eventUserInfoChat";
                                }
                            } else {
                                str = "eventUserInfoAvatar";
                            }
                        } else {
                            str = "eventUserInfoAgeHeight";
                        }
                    } else {
                        str = "eventUserInfoActivityNumDes";
                    }
                } else {
                    str = "eventUserInfoActivityNum";
                }
            } else {
                str = "eventUserInfoActivityJoinDes";
            }
        } else {
            str = "eventUserInfoActivityJoin";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.B;
    }
}
