package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/DialogFeedPostReadAuthBinding.class */
public final class DialogFeedPostReadAuthBinding implements ViewBinding {
    private final FrameLayout A;

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f18801a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f18802c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final LinearLayout j;
    public final LinearLayout k;
    public final LinearLayout l;
    public final LinearLayout m;
    public final ShapeLinearLayout n;
    public final LinearLayout o;
    public final LinearLayout p;
    public final LinearLayout q;
    public final FrameLayout r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    private DialogFeedPostReadAuthBinding(FrameLayout frameLayout, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, ShapeLinearLayout shapeLinearLayout, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, FrameLayout frameLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.A = frameLayout;
        this.f18801a = linearLayout;
        this.b = imageView;
        this.f18802c = imageView2;
        this.d = imageView3;
        this.e = imageView4;
        this.f = imageView5;
        this.g = imageView6;
        this.h = imageView7;
        this.i = imageView8;
        this.j = linearLayout2;
        this.k = linearLayout3;
        this.l = linearLayout4;
        this.m = linearLayout5;
        this.n = shapeLinearLayout;
        this.o = linearLayout6;
        this.p = linearLayout7;
        this.q = linearLayout8;
        this.r = frameLayout2;
        this.s = textView;
        this.t = textView2;
        this.u = textView3;
        this.v = textView4;
        this.w = textView5;
        this.x = textView6;
        this.y = textView7;
        this.z = textView8;
    }

    public static DialogFeedPostReadAuthBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogFeedPostReadAuthBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_feed_post_read_auth, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogFeedPostReadAuthBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.feed_post_auth_comment_layout);
        if (linearLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.ivClose);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.ivCommentAll);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.ivCommentFans);
                    if (imageView3 != null) {
                        ImageView imageView4 = (ImageView) view.findViewById(R.id.ivCommentFollow);
                        if (imageView4 != null) {
                            ImageView imageView5 = (ImageView) view.findViewById(R.id.ivCommentFollowFans);
                            if (imageView5 != null) {
                                ImageView imageView6 = (ImageView) view.findViewById(R.id.ivSeeAll);
                                if (imageView6 != null) {
                                    ImageView imageView7 = (ImageView) view.findViewById(R.id.ivSeeFans);
                                    if (imageView7 != null) {
                                        ImageView imageView8 = (ImageView) view.findViewById(R.id.ivSeeSelf);
                                        if (imageView8 != null) {
                                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.layoutCommentAll);
                                            if (linearLayout2 != null) {
                                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.layoutCommentFans);
                                                if (linearLayout3 != null) {
                                                    LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.layoutCommentFollow);
                                                    if (linearLayout4 != null) {
                                                        LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.layoutCommentFollowFans);
                                                        if (linearLayout5 != null) {
                                                            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.layoutReadAuth);
                                                            if (shapeLinearLayout != null) {
                                                                LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.layoutSeeAll);
                                                                if (linearLayout6 != null) {
                                                                    LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.layoutSeeFans);
                                                                    if (linearLayout7 != null) {
                                                                        LinearLayout linearLayout8 = (LinearLayout) view.findViewById(R.id.layoutSeeSelf);
                                                                        if (linearLayout8 != null) {
                                                                            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.rootLayout);
                                                                            if (frameLayout != null) {
                                                                                TextView textView = (TextView) view.findViewById(R.id.tvCommentAll);
                                                                                if (textView != null) {
                                                                                    TextView textView2 = (TextView) view.findViewById(R.id.tvCommentFans);
                                                                                    if (textView2 != null) {
                                                                                        TextView textView3 = (TextView) view.findViewById(R.id.tvCommentFollow);
                                                                                        if (textView3 != null) {
                                                                                            TextView textView4 = (TextView) view.findViewById(R.id.tvCommentFollowFans);
                                                                                            if (textView4 != null) {
                                                                                                TextView textView5 = (TextView) view.findViewById(R.id.tvDone);
                                                                                                if (textView5 != null) {
                                                                                                    TextView textView6 = (TextView) view.findViewById(R.id.tvSeeAll);
                                                                                                    if (textView6 != null) {
                                                                                                        TextView textView7 = (TextView) view.findViewById(R.id.tvSeeFans);
                                                                                                        if (textView7 != null) {
                                                                                                            TextView textView8 = (TextView) view.findViewById(R.id.tvSeeSelf);
                                                                                                            if (textView8 != null) {
                                                                                                                return new DialogFeedPostReadAuthBinding((FrameLayout) view, linearLayout, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, linearLayout2, linearLayout3, linearLayout4, linearLayout5, shapeLinearLayout, linearLayout6, linearLayout7, linearLayout8, frameLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
                                                                                                            }
                                                                                                            str = "tvSeeSelf";
                                                                                                        } else {
                                                                                                            str = "tvSeeFans";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "tvSeeAll";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "tvDone";
                                                                                                }
                                                                                            } else {
                                                                                                str = "tvCommentFollowFans";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tvCommentFollow";
                                                                                        }
                                                                                    } else {
                                                                                        str = "tvCommentFans";
                                                                                    }
                                                                                } else {
                                                                                    str = "tvCommentAll";
                                                                                }
                                                                            } else {
                                                                                str = "rootLayout";
                                                                            }
                                                                        } else {
                                                                            str = "layoutSeeSelf";
                                                                        }
                                                                    } else {
                                                                        str = "layoutSeeFans";
                                                                    }
                                                                } else {
                                                                    str = "layoutSeeAll";
                                                                }
                                                            } else {
                                                                str = "layoutReadAuth";
                                                            }
                                                        } else {
                                                            str = "layoutCommentFollowFans";
                                                        }
                                                    } else {
                                                        str = "layoutCommentFollow";
                                                    }
                                                } else {
                                                    str = "layoutCommentFans";
                                                }
                                            } else {
                                                str = "layoutCommentAll";
                                            }
                                        } else {
                                            str = "ivSeeSelf";
                                        }
                                    } else {
                                        str = "ivSeeFans";
                                    }
                                } else {
                                    str = "ivSeeAll";
                                }
                            } else {
                                str = "ivCommentFollowFans";
                            }
                        } else {
                            str = "ivCommentFollow";
                        }
                    } else {
                        str = "ivCommentFans";
                    }
                } else {
                    str = "ivCommentAll";
                }
            } else {
                str = "ivClose";
            }
        } else {
            str = "feedPostAuthCommentLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.A;
    }
}
