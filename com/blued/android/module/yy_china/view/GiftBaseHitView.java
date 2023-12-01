package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.listener.GiftHitListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.LuckGiftModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYMsgGiftExtra;
import com.blued.android.module.yy_china.model.YYMsgJsonGiftExtra;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/GiftBaseHitView.class */
public class GiftBaseHitView extends LinearLayout {
    private String a;
    private View b;
    private ImageView c;
    private ShapeTextView d;
    private TextView e;
    private TextView f;
    private ShapeConstraintLayout g;
    private ImageView h;
    private SVGAImageView i;
    private LinearLayout j;
    private TextView k;
    private GiftHitListener l;
    private YYImModel m;
    private YYMsgGiftExtra n;
    private int o;
    private int p;
    private boolean q;
    private Runnable r;

    public GiftBaseHitView(Context context) {
        this(context, null);
    }

    public GiftBaseHitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GiftBaseHitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = GiftBaseHitView.class.getSimpleName();
        this.q = false;
        this.r = new Runnable() { // from class: com.blued.android.module.yy_china.view.GiftBaseHitView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GiftBaseHitView.this.l != null) {
                    GiftBaseHitView.this.setVisibility(8);
                    GiftBaseHitView.this.l.b(GiftBaseHitView.this);
                }
            }
        };
        a(context);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_yy_msg_gift_hit, (ViewGroup) this, true);
        this.b = inflate;
        this.c = (ImageView) inflate.findViewById(R.id.iv_user_img);
        this.d = (ShapeTextView) this.b.findViewById(R.id.tv_role);
        this.e = (TextView) this.b.findViewById(R.id.tv_source_name);
        this.f = (TextView) this.b.findViewById(R.id.tv_target_name);
        this.g = (ShapeConstraintLayout) this.b.findViewById(R.id.shape_background);
        this.h = (ImageView) this.b.findViewById(R.id.iv_gift);
        this.j = (LinearLayout) this.b.findViewById(R.id.ll_hit);
        this.k = (TextView) this.b.findViewById(R.id.tv_hit_count);
        this.i = (SVGAImageView) this.b.findViewById(R.id.svga);
    }

    private void b() {
        if (this.m == null) {
            setVisibility(8);
            GiftHitListener giftHitListener = this.l;
            if (giftHitListener != null) {
                giftHitListener.b(this);
                return;
            }
            return;
        }
        setVisibility(0);
        this.e.setText(YYRoomInfoManager.e().a(this.m.source_profile.getUid(), this.m.source_profile.getName()));
        TextView textView = this.f;
        textView.setText("送给  " + YYRoomInfoManager.e().a(this.m.target_profile.getUid(), this.m.target_profile.getName()));
        YYRoomInfoManager.e().a((IRequestHost) null, this.c, this.m.source_profile.getUid(), this.m.source_profile.getAvatar());
        this.d.setVisibility(0);
        ShapeModel shapeModel = this.d.getShapeModel();
        if (TextUtils.equals("2", this.m.source_profile.chat_anchor)) {
            ShapeHelper.b(this.d, R.color.syc_8F38FD);
            this.d.setText(getContext().getResources().getString(R.string.yy_role_manager));
        } else if (TextUtils.equals("1", this.m.source_profile.chat_anchor)) {
            shapeModel.U = R.color.syc_3883FD;
            this.d.setText(getContext().getResources().getString(R.string.yy_role_host));
        } else {
            this.d.setVisibility(8);
        }
        ShapeModel shapeModel2 = this.g.getShapeModel();
        shapeModel2.t = Color.parseColor("#ff000000");
        shapeModel2.v = Color.parseColor("#00000000");
        this.i.setImageResource(R.drawable.transparent);
        if (this.n.json_contents_modes == null || StringUtils.b(this.n.json_contents_modes.getNotice_bg_image())) {
            this.i.a(true);
        } else {
            if (!StringUtils.b(this.n.json_contents_modes.getNotice_bg_tag_color())) {
                shapeModel.k = Color.parseColor(this.n.json_contents_modes.getNotice_bg_tag_color());
            }
            shapeModel2.t = Color.parseColor("#00000000");
            if (this.n.json_contents_modes.getNotice_bg_image().toLowerCase().endsWith("png")) {
                ImageLoader.a((IRequestHost) null, this.n.json_contents_modes.getNotice_bg_image()).g(-1).f().a(this.i);
            } else {
                new SVGAPlayer.Builder(this.n.json_contents_modes.getNotice_bg_image()).a(this.i);
            }
        }
        this.g.setShapeModel(shapeModel2);
        this.d.setShapeModel(shapeModel);
        if (this.n.extra == null || this.n.extra.getGoods_id() == null || "".equals(this.n.extra.getGoods_id())) {
            ImageLoader.a((IRequestHost) null, this.n.gift_icon).b(R.drawable.gift_default_icon).a(this.h);
        } else {
            ImageLoader.a((IRequestHost) null, this.n.extra.getImages_static()).b(R.drawable.gift_default_icon).a(this.h);
        }
        if (this.o <= 0) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
            TextView textView2 = this.k;
            textView2.setText(this.o + "");
        }
        c();
    }

    private void c() {
        this.q = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(AppInfo.d(), R.anim.live_msg_gift_in_from_left);
        setAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.yy_china.view.GiftBaseHitView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                GiftBaseHitView.this.post(new Runnable() { // from class: com.blued.android.module.yy_china.view.GiftBaseHitView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GiftBaseHitView.this.o > 0 || GiftBaseHitView.this.l == null) {
                            GiftBaseHitView.this.d();
                            return;
                        }
                        GiftBaseHitView.this.l.a(GiftBaseHitView.this);
                        GiftBaseHitView.this.e();
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.q = true;
        removeCallbacks(this.r);
        TextView textView = this.k;
        textView.setText(this.o + "");
        AnimationSet animationSet = new AnimationSet(false);
        if (this.n.hit_batch != 1 || this.o == this.p) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(2.0f, 0.5f, 2.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(250L);
            scaleAnimation2.setStartOffset(250L);
            scaleAnimation2.setDuration(100L);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(scaleAnimation2);
        } else {
            ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation3.setDuration(100L);
            animationSet.addAnimation(scaleAnimation3);
        }
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.yy_china.view.GiftBaseHitView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                GiftBaseHitView.this.post(new Runnable() { // from class: com.blued.android.module.yy_china.view.GiftBaseHitView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GiftBaseHitView.this.o < GiftBaseHitView.this.p) {
                            GiftBaseHitView.f(GiftBaseHitView.this);
                            GiftBaseHitView.this.d();
                        } else if (GiftBaseHitView.this.l != null) {
                            GiftBaseHitView.this.l.a(GiftBaseHitView.this);
                            GiftBaseHitView.this.e();
                        }
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.j.startAnimation(animationSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.q = false;
        removeCallbacks(this.r);
        postDelayed(this.r, 2000L);
    }

    static /* synthetic */ int f(GiftBaseHitView giftBaseHitView) {
        int i = giftBaseHitView.o;
        giftBaseHitView.o = i + 1;
        return i;
    }

    public YYMsgGiftExtra a(String str) {
        YYMsgGiftExtra yYMsgGiftExtra = new YYMsgGiftExtra();
        if (str != null) {
            yYMsgGiftExtra = (YYMsgGiftExtra) AppInfo.f().fromJson(str, YYMsgGiftExtra.class);
        }
        return yYMsgGiftExtra;
    }

    public void a() {
        setGiftHitListener(null);
        this.p = 0;
    }

    public boolean a(YYImModel yYImModel) {
        YYMsgGiftExtra yYMsgGiftExtra;
        if (this.m == null || (yYMsgGiftExtra = this.n) == null || yYMsgGiftExtra.hit_batch == 1 || this.n.hit_id != MsgPackHelper.getLongValue(yYImModel.msgMapExtra, "hit_id") || !TextUtils.equals(yYImModel.source_profile.getUid(), this.m.source_profile.getUid()) || !TextUtils.equals(yYImModel.target_profile.getUid(), this.m.target_profile.getUid()) || this.n.hit_id == 0) {
            return false;
        }
        int intValue = MsgPackHelper.getIntValue(yYImModel.msgMapExtra, "hit_count");
        if (intValue > this.p) {
            this.p = intValue;
            if (this.q) {
                return true;
            }
            this.o++;
            d();
            return true;
        }
        return true;
    }

    public void setGiftHitListener(GiftHitListener giftHitListener) {
        this.l = giftHitListener;
    }

    public void setHitModel(YYImModel yYImModel) {
        this.m = yYImModel;
        YYMsgGiftExtra a = a(yYImModel.getMsgExtra());
        this.n = a;
        if (!StringUtils.b(a.json_contents)) {
            this.n.json_contents_modes = (YYMsgJsonGiftExtra) AppInfo.f().fromJson(this.n.json_contents, YYMsgJsonGiftExtra.class);
        }
        this.n.extra = (LuckGiftModel) yYImModel.msgMapExtra.get("extra");
        if (this.n.hit_batch == 1) {
            this.o = 1;
        } else if (this.n.hit_id == 0) {
            this.o = 0;
        } else {
            this.o = this.n.hit_count;
        }
        this.p = this.n.hit_count;
        b();
    }
}
