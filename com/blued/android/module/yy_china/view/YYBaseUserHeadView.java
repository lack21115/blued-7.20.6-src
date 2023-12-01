package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.svgaplayer.SVGADrawable;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewYyUserHeadBaseLayoutBinding;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.VoiceSkinInfoMode;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYBaseUserHeadView.class */
public class YYBaseUserHeadView extends FrameLayout {
    private ViewYyUserHeadBaseLayoutBinding a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private View f;
    private float g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private int[] l;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYBaseUserHeadView$GetViewX_Y_W_H.class */
    public interface GetViewX_Y_W_H {
        void a(int i, int i2, int i3, int i4);
    }

    public YYBaseUserHeadView(Context context) {
        this(context, null);
    }

    public YYBaseUserHeadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYBaseUserHeadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = true;
        this.g = 1.2f;
        this.i = true;
        this.j = -1;
        this.k = -1;
        this.l = new int[2];
        this.a = ViewYyUserHeadBaseLayoutBinding.a(LayoutInflater.from(getContext()), this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.YYRoomUsHeadView, i, 0);
        this.b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.YYRoomUsHeadView_head_us_img_width, 0);
        this.c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.YYRoomUsHeadView_head_ani_img_width, 0);
        this.h = obtainStyledAttributes.getBoolean(R.styleable.YYRoomUsHeadView_is_empty_us_head, false);
        obtainStyledAttributes.recycle();
        this.d = (int) (this.b * this.g);
        b();
    }

    private void b() {
        if (this.b != 0) {
            ViewGroup.LayoutParams layoutParams = this.a.j.getLayoutParams();
            layoutParams.width = this.b;
            layoutParams.height = this.b;
            this.a.j.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.a.k.getLayoutParams();
            layoutParams2.width = this.b;
            layoutParams2.height = this.b;
            this.a.k.setLayoutParams(layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = this.a.h.getLayoutParams();
            layoutParams3.width = this.d;
            layoutParams3.height = this.d;
            this.a.h.setLayoutParams(layoutParams3);
            this.a.b.setRadius((this.b - getResources().getDimensionPixelOffset(R.dimen.dp_2)) / 2);
            this.a.a.getShapeModel().H = this.b / 2;
            this.a.a.setShapeModel(this.a.a.getShapeModel());
            this.a.d.setRadius(this.b / 2);
        }
        if (this.c != 0) {
            ViewGroup.LayoutParams layoutParams4 = this.a.l.getLayoutParams();
            layoutParams4.width = this.c;
            layoutParams4.height = this.c;
            this.a.l.setLayoutParams(layoutParams4);
        }
    }

    private void b(YYSeatMemberModel yYSeatMemberModel, IRequestHost iRequestHost) {
        if (!YYRoomInfoManager.e().J()) {
            ImageLoader.a(iRequestHost, yYSeatMemberModel.getAvatar()).b(R.drawable.user_bg_round).a(this.a.g);
            c(yYSeatMemberModel, iRequestHost);
        } else if (!YYRoomInfoManager.e().g(yYSeatMemberModel.getUid()) || YYRoomInfoManager.e().h(yYSeatMemberModel.getUid())) {
            this.a.h.setVisibility(4);
            ImageLoader.a(iRequestHost, R.drawable.icon_user_mask_with_text).b(R.drawable.user_bg_round).a(this.a.g);
        } else {
            ImageLoader.a(iRequestHost, yYSeatMemberModel.getAvatar()).b(R.drawable.user_bg_round).a(this.a.g);
            this.a.h.setVisibility(0);
            c(yYSeatMemberModel, iRequestHost);
        }
    }

    private void c() {
        VoiceSkinInfoMode voiceSkinInfoMode;
        if (YYRoomInfoManager.e().b() == null || (voiceSkinInfoMode = YYRoomInfoManager.e().b().voice_skin_info) == null) {
            return;
        }
        ImageLoader.a((IRequestHost) null, voiceSkinInfoMode.getIcon()).a((Target<Drawable>) new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.view.YYBaseUserHeadView.1
            /* renamed from: a */
            public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                YYBaseUserHeadView.this.a.d.setBackgroundDrawable(drawable);
                YYBaseUserHeadView.this.a.c.setBackgroundDrawable(drawable);
            }
        });
        ImageLoader.a((IRequestHost) null, voiceSkinInfoMode.getIcon_small()).b(R.drawable.icon_apply_seat).a(this.a.f);
    }

    private void c(YYSeatMemberModel yYSeatMemberModel, IRequestHost iRequestHost) {
        if (StringUtils.b(yYSeatMemberModel.avatar_frame)) {
            this.a.h.setImageResource(R.color.transparent);
            return;
        }
        ImageLoader.a(iRequestHost, this.a.h);
        ImageLoader.a(iRequestHost, yYSeatMemberModel.avatar_frame).e(StringUtils.a(yYSeatMemberModel.getUid(), 0)).g(-1).a(this.a.h);
    }

    public void a() {
        this.a.h.setVisibility(4);
    }

    public void a(int i, int i2) {
        ShapeHelper.a(this.a.a, i, i2);
    }

    public void a(int i, int i2, int i3, int i4) {
        try {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.i.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.topMargin = i2;
            layoutParams.rightMargin = i3;
            layoutParams.bottomMargin = i4;
        } catch (Exception e) {
            Log.e("YYBaseUserHeadView", "throw exception：" + e.getMessage());
        }
    }

    public void a(IRequestHost iRequestHost, String str, String str2) {
        ImageLoader.a(iRequestHost, this.a.h);
        ImageLoader.a(iRequestHost, str).b(R.drawable.user_bg_round).a(this.a.g);
        if (str2 == null || "".equals(str2)) {
            this.a.h.setVisibility(4);
        } else {
            this.a.h.setVisibility(0);
            ImageLoader.a(iRequestHost, str2).f().g(-1).a(this.a.h);
        }
        this.a.m.setVisibility(4);
    }

    public void a(IRequestHost iRequestHost, final String str, String str2, final YYImModel yYImModel) {
        final YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        this.a.e.setVisibility(0);
        ImageLoader.a(iRequestHost, str2).e(StringUtils.a(str, 4)).a().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.android.module.yy_china.view.YYBaseUserHeadView.2
            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void a() {
                b.putPlayingEmoji(str, yYImModel);
                Logger.e("timer", "onAnimationStart ... ");
                Logger.c("YYConnectingAdapter", "apng start ... position：" + str);
            }

            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void b() {
                Logger.e("timer", "onAnimationEnd ... ");
                Logger.c("YYConnectingAdapter", "apng end ...position：" + str);
                YYBaseUserHeadView.this.a.e.setVisibility(8);
                if (yYImModel != null) {
                    b.removePlayingEmoji(str);
                    YYImMsgManager.a().v(yYImModel);
                }
            }
        }).a(this.a.e);
    }

    public void a(final YYSeatMemberModel yYSeatMemberModel, final IRequestHost iRequestHost) {
        if (this.i && TextUtils.equals(yYSeatMemberModel.chat_anchor, "1")) {
            this.a.m.setVisibility(0);
            this.a.m.setText(getResources().getString(R.string.yy_role_host));
        } else if (this.i && TextUtils.equals(yYSeatMemberModel.chat_anchor, "2")) {
            this.a.m.setVisibility(0);
            this.a.m.setText(getResources().getString(R.string.yy_role_manager));
        } else {
            this.a.m.setVisibility(8);
        }
        b(yYSeatMemberModel, iRequestHost);
        this.a.l.setVisibility(4);
        if (yYSeatMemberModel.speech_ripple == null || StringUtils.b(yYSeatMemberModel.speech_ripple.getImg())) {
            ImageLoader.c(iRequestHost, yYSeatMemberModel.isVip ? "live_talking_vip.png" : "live_talking.png").g(-1).e(StringUtils.a(yYSeatMemberModel.getUid(), 2)).a(this.a.l);
        } else {
            String img = yYSeatMemberModel.speech_ripple.getImg();
            if (img.toLowerCase().endsWith("png")) {
                ImageLoader.a(iRequestHost, img).f().a(this.a.l);
            } else {
                try {
                    SVGAParser.a.b().a(new URL(img), new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.yy_china.view.YYBaseUserHeadView.3
                        @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
                        public void onComplete(SVGAVideoEntity sVGAVideoEntity) {
                            YYBaseUserHeadView.this.a.l.setImageDrawable(new SVGADrawable(sVGAVideoEntity));
                            YYBaseUserHeadView.this.a.l.a();
                        }

                        @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
                        public void onError() {
                            ImageLoader.c(iRequestHost, yYSeatMemberModel.isVip ? "live_talking_vip.png" : "live_talking.png").g(-1).e(StringUtils.a(yYSeatMemberModel.getUid(), 2)).a(YYBaseUserHeadView.this.a.l);
                        }
                    }, (SVGAParser.PlayCallback) null);
                } catch (MalformedURLException e) {
                }
            }
        }
        if (this.f == null) {
            this.f = this.a.d;
        }
        ShapeFrameLayout shapeFrameLayout = this.a.a;
        int i = this.j;
        int i2 = i;
        if (i <= -1) {
            i2 = R.color.white;
        }
        int i3 = this.k;
        int i4 = i3;
        if (i3 <= -1) {
            i4 = R.color.white;
        }
        ShapeHelper.a(shapeFrameLayout, i2, i4);
        int i5 = yYSeatMemberModel.position_status;
        if (i5 == -1) {
            this.a.a.setVisibility(8);
            this.a.h.setVisibility(8);
            this.a.k.setVisibility(8);
            if (this.a.c != null) {
                this.a.c.setVisibility(0);
                if (yYSeatMemberModel.isBoss) {
                    this.a.c.setBackgroundResource(R.drawable.icon_yy_entertainment_empty);
                } else {
                    ShapeHelper.b(this.a.c, R.color.syc_alpha_3_000000);
                }
            }
            if (this.f != null && !yYSeatMemberModel.isVip) {
                this.f.setVisibility(8);
            }
        } else if (i5 == 0) {
            this.a.a.setVisibility(8);
            this.a.h.setVisibility(8);
            this.a.k.setVisibility(8);
            if (this.a.c != null) {
                this.a.c.setVisibility(8);
            }
            View view = this.f;
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (i5 == 1) {
            this.a.a.setVisibility(0);
            this.a.h.setVisibility(0);
            this.a.k.setVisibility(0);
            this.a.i.setVisibility(this.e ? 0 : 8);
            if (this.a.c != null) {
                this.a.c.setVisibility(8);
            }
            View view2 = this.f;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (yYSeatMemberModel.is_open_mic == 0) {
                this.a.i.setImageResource(R.drawable.icon_microphone_close);
            } else if (yYSeatMemberModel.is_open_mic == 1) {
                this.a.i.setImageResource(R.drawable.icon_microphone_open);
            } else {
                this.a.l.setVisibility(0);
                this.a.i.setImageResource(yYSeatMemberModel.isVip ? R.drawable.icon_microphone_vip_open : R.drawable.icon_microphone_connecting);
            }
        }
        if (yYSeatMemberModel.isVip) {
            this.a.d.setBackgroundResource(R.drawable.icon_vip_empty);
            this.a.f.setVisibility(8);
        } else if (!yYSeatMemberModel.isBoss) {
            c();
        } else {
            this.f.setBackgroundResource(R.drawable.icon_yy_entertainment_empty);
            VoiceSkinInfoMode voiceSkinInfoMode = YYRoomInfoManager.e().b().voice_skin_info;
            if (voiceSkinInfoMode != null) {
                ImageLoader.a((IRequestHost) null, voiceSkinInfoMode.getIcon_small()).b(R.drawable.icon_apply_seat).a(this.a.f);
            } else {
                ImageLoader.a((IRequestHost) null, R.drawable.icon_apply_seat).a(this.a.f);
            }
        }
    }

    public void a(GetViewX_Y_W_H getViewX_Y_W_H) {
        if (this.l[0] == 0) {
            this.a.j.getLocationInWindow(this.l);
        }
        int[] iArr = this.l;
        if (iArr[0] != 0) {
            int i = iArr[0];
            int i2 = iArr[1];
            int i3 = this.b;
            getViewX_Y_W_H.a(i, i2, i3, i3);
        }
    }

    public void a(Set<String> set, YYSeatMemberModel yYSeatMemberModel) {
        if (this.a == null) {
            return;
        }
        if (set.contains(yYSeatMemberModel.getUid())) {
            this.a.l.setVisibility(0);
        } else {
            this.a.l.setVisibility(4);
        }
        int i = yYSeatMemberModel.is_open_mic;
        if (i == 1) {
            this.a.i.setImageResource(R.drawable.icon_microphone_open);
        } else if (i != 2) {
        } else {
            this.a.i.setImageResource(yYSeatMemberModel.isVip ? R.drawable.icon_microphone_vip_open : R.drawable.icon_microphone_connecting);
        }
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b(int i, int i2) {
        this.j = i;
        this.k = i2;
    }

    public void b(boolean z) {
        this.i = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        super.onMeasure(i, i2);
        int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
        int i3 = min;
        if (min <= 1) {
            i3 = 2;
        }
        int i4 = this.d;
        if (i4 == 0 || i3 >= i4) {
            z = false;
        } else {
            int i5 = i3 - 1;
            this.d = i5;
            this.b = (int) (i5 / this.g);
            z = true;
        }
        if (z) {
            b();
        }
    }

    public void setEmptyHead(int i) {
        this.a.g.setImageResource(i);
        this.a.h.setVisibility(4);
        this.a.m.setVisibility(4);
    }

    public void setNoAudienceView(View view) {
        this.f = view;
    }
}
