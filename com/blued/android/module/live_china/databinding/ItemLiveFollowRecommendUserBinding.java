package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.LiveAutoPlayView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/ItemLiveFollowRecommendUserBinding.class */
public final class ItemLiveFollowRecommendUserBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f12028a;
    public final CardView b;

    /* renamed from: c  reason: collision with root package name */
    public final LiveAutoPlayView f12029c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final FrameLayout g;
    public final ShapeTextView h;
    public final TextView i;
    private final FrameLayout j;

    private ItemLiveFollowRecommendUserBinding(FrameLayout frameLayout, ImageView imageView, CardView cardView, LiveAutoPlayView liveAutoPlayView, ImageView imageView2, ImageView imageView3, ImageView imageView4, FrameLayout frameLayout2, ShapeTextView shapeTextView, TextView textView) {
        this.j = frameLayout;
        this.f12028a = imageView;
        this.b = cardView;
        this.f12029c = liveAutoPlayView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = frameLayout2;
        this.h = shapeTextView;
        this.i = textView;
    }

    public static ItemLiveFollowRecommendUserBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.aariv_cover);
        if (imageView != null) {
            CardView cardView = (CardView) view.findViewById(R.id.aariv_cover_layout);
            if (cardView != null) {
                LiveAutoPlayView liveAutoPlayView = (LiveAutoPlayView) view.findViewById(R.id.fl_video_view);
                if (liveAutoPlayView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_cover_box);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_top_left);
                        if (imageView3 != null) {
                            ImageView imageView4 = (ImageView) view.findViewById(R.id.live_record_level);
                            if (imageView4 != null) {
                                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.live_user_layout);
                                if (frameLayout != null) {
                                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_follow_anchor);
                                    if (shapeTextView != null) {
                                        TextView textView = (TextView) view.findViewById(R.id.tv_username);
                                        if (textView != null) {
                                            return new ItemLiveFollowRecommendUserBinding((FrameLayout) view, imageView, cardView, liveAutoPlayView, imageView2, imageView3, imageView4, frameLayout, shapeTextView, textView);
                                        }
                                        str = "tvUsername";
                                    } else {
                                        str = "tvFollowAnchor";
                                    }
                                } else {
                                    str = "liveUserLayout";
                                }
                            } else {
                                str = "liveRecordLevel";
                            }
                        } else {
                            str = "ivTopLeft";
                        }
                    } else {
                        str = "ivCoverBox";
                    }
                } else {
                    str = "flVideoView";
                }
            } else {
                str = "aarivCoverLayout";
            }
        } else {
            str = "aarivCover";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.j;
    }
}
