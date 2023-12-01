package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewRobMusicRoomBgBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRobMusicRoomVIew.class */
public final class YYRobMusicRoomVIew extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewRobMusicRoomBgBinding f18441a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYRobMusicRoomVIew(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYRobMusicRoomVIew(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYRobMusicRoomVIew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.f18441a = ViewRobMusicRoomBgBinding.a(LayoutInflater.from(getContext()), this, true);
    }

    public final void a(int i, BaseYYStudioFragment baseYYStudioFragment) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        SVGAImageView sVGAImageView;
        SVGAImageView sVGAImageView2;
        SVGAImageView sVGAImageView3;
        ViewRobMusicRoomBgBinding viewRobMusicRoomBgBinding = this.f18441a;
        SVGAImageView sVGAImageView4 = viewRobMusicRoomBgBinding == null ? null : viewRobMusicRoomBgBinding.f16875a;
        if (sVGAImageView4 != null) {
            sVGAImageView4.setVisibility(0);
        }
        ViewRobMusicRoomBgBinding viewRobMusicRoomBgBinding2 = this.f18441a;
        if (viewRobMusicRoomBgBinding2 != null && (sVGAImageView3 = viewRobMusicRoomBgBinding2.f16875a) != null) {
            sVGAImageView3.a(true);
        }
        ViewRobMusicRoomBgBinding viewRobMusicRoomBgBinding3 = this.f18441a;
        if (viewRobMusicRoomBgBinding3 != null && (sVGAImageView2 = viewRobMusicRoomBgBinding3.f16875a) != null) {
            sVGAImageView2.b();
        }
        ViewRobMusicRoomBgBinding viewRobMusicRoomBgBinding4 = this.f18441a;
        if (viewRobMusicRoomBgBinding4 != null && (sVGAImageView = viewRobMusicRoomBgBinding4.f16875a) != null) {
            sVGAImageView.setImageResource(R.color.transparent);
        }
        if (i == 1) {
            ImageLoader.a(baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive(), "https://www.bldimg.com/common/160abaadfb0d61225572469651f355b9-359377.png").a(new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.view.YYRobMusicRoomVIew$playRobSvgaBg$1
                @Override // com.bumptech.glide.request.target.Target
                /* renamed from: a */
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    ViewRobMusicRoomBgBinding viewRobMusicRoomBgBinding5;
                    ViewRobMusicRoomBgBinding viewRobMusicRoomBgBinding6;
                    SVGAImageView sVGAImageView5;
                    Intrinsics.e(resource, "resource");
                    viewRobMusicRoomBgBinding5 = YYRobMusicRoomVIew.this.f18441a;
                    if (viewRobMusicRoomBgBinding5 != null && (sVGAImageView5 = viewRobMusicRoomBgBinding5.f16875a) != null) {
                        sVGAImageView5.setImageDrawable(resource);
                    }
                    viewRobMusicRoomBgBinding6 = YYRobMusicRoomVIew.this.f18441a;
                    ImageView imageView4 = viewRobMusicRoomBgBinding6 == null ? null : viewRobMusicRoomBgBinding6.b;
                    if (imageView4 == null) {
                        return;
                    }
                    imageView4.setVisibility(0);
                }
            });
            ViewRobMusicRoomBgBinding viewRobMusicRoomBgBinding5 = this.f18441a;
            if (viewRobMusicRoomBgBinding5 == null || (imageView = viewRobMusicRoomBgBinding5.b) == null) {
                return;
            }
            imageView.setImageResource(R.color.black);
        } else if (i != 2) {
            if (i != 3) {
                return;
            }
            ViewRobMusicRoomBgBinding viewRobMusicRoomBgBinding6 = this.f18441a;
            if (viewRobMusicRoomBgBinding6 != null && (imageView3 = viewRobMusicRoomBgBinding6.b) != null) {
                imageView3.setImageResource(R.color.syc_0C1D34);
            }
            ImageWrapper a2 = ImageLoader.a(baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive(), "https://www.bldimg.com/common/1a94796578a5862e265070e41882f2bb-591794.png");
            ViewRobMusicRoomBgBinding viewRobMusicRoomBgBinding7 = this.f18441a;
            a2.a(viewRobMusicRoomBgBinding7 == null ? null : viewRobMusicRoomBgBinding7.f16875a);
            ViewRobMusicRoomBgBinding viewRobMusicRoomBgBinding8 = this.f18441a;
            ImageView imageView4 = viewRobMusicRoomBgBinding8 == null ? null : viewRobMusicRoomBgBinding8.b;
            if (imageView4 == null) {
                return;
            }
            imageView4.setVisibility(0);
        } else {
            ViewRobMusicRoomBgBinding viewRobMusicRoomBgBinding9 = this.f18441a;
            if (viewRobMusicRoomBgBinding9 != null && (imageView2 = viewRobMusicRoomBgBinding9.b) != null) {
                imageView2.setImageResource(R.color.syc_0C1D34);
            }
            SVGAPlayer.Builder builder = new SVGAPlayer.Builder("https://www.bldimg.com/common/5b261d4828f056d8e5d551f8efc9736a-565963.svga");
            ViewRobMusicRoomBgBinding viewRobMusicRoomBgBinding10 = this.f18441a;
            SVGAImageView sVGAImageView5 = viewRobMusicRoomBgBinding10 == null ? null : viewRobMusicRoomBgBinding10.f16875a;
            Intrinsics.a(sVGAImageView5);
            Intrinsics.c(sVGAImageView5, "binding?.imgRobSvgaBackground!!");
            builder.a(sVGAImageView5);
            ViewRobMusicRoomBgBinding viewRobMusicRoomBgBinding11 = this.f18441a;
            ImageView imageView5 = viewRobMusicRoomBgBinding11 == null ? null : viewRobMusicRoomBgBinding11.b;
            if (imageView5 == null) {
                return;
            }
            imageView5.setVisibility(0);
        }
    }
}
