package com.blued.android.module.yy_china.manager;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.live.base.view.animation.AnimationListenerAdapter;
import com.blued.android.module.live.base.view.animation.LiveAnimationView;
import com.blued.android.module.live.base.view.animation.LiveAnimationViewFactory;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGADrawable;
import com.blued.android.module.svgaplayer.SVGADynamicEntity;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.GiftHitListener;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYMsgGiftExtra;
import com.blued.android.module.yy_china.model.YYMsgJsonGiftExtra;
import com.blued.android.module.yy_china.observer.GiftObserver;
import com.blued.android.module.yy_china.view.GiftBaseHitView;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYGiftAnimManager.class */
public class YYGiftAnimManager implements GiftHitListener, GiftObserver {

    /* renamed from: a  reason: collision with root package name */
    private List<YYImModel> f17525a = Collections.synchronizedList(new LinkedList());
    private List<YYMsgGiftExtra> b = Collections.synchronizedList(new LinkedList());

    /* renamed from: c  reason: collision with root package name */
    private GiftBaseHitView f17526c;
    private GiftBaseHitView d;
    private LiveAnimationView e;
    private YYMsgGiftExtra f;
    private BaseYYStudioFragment g;
    private SVGAImageView h;
    private SVGAParser i;
    private SVGACallback j;

    public YYGiftAnimManager(BaseYYStudioFragment baseYYStudioFragment, GiftBaseHitView giftBaseHitView, GiftBaseHitView giftBaseHitView2, LiveAnimationView liveAnimationView, SVGAImageView sVGAImageView) {
        this.g = baseYYStudioFragment;
        this.f17526c = giftBaseHitView;
        this.d = giftBaseHitView2;
        this.e = liveAnimationView;
        this.h = sVGAImageView;
        giftBaseHitView.setGiftHitListener(this);
        this.d.setGiftHitListener(this);
        YYObserverManager.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SVGADynamicEntity sVGADynamicEntity) {
        if (TextUtils.isEmpty(this.f.gift_sign)) {
            return;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(-1);
        textPaint.setTextSize(24.0f);
        if (Build.VERSION.SDK_INT < 23) {
            sVGADynamicEntity.a(new StaticLayout(this.f.gift_sign, 0, this.f.gift_sign.length(), textPaint, 0, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false), "name01");
            return;
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(this.f.gift_sign, 0, this.f.gift_sign.length(), textPaint, 0);
        obtain.setAlignment(Layout.Alignment.ALIGN_CENTER);
        sVGADynamicEntity.a(obtain.build(), "name01");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final YYMsgGiftExtra yYMsgGiftExtra, String str, final String str2) {
        BaseYYStudioFragment baseYYStudioFragment = this.g;
        if (baseYYStudioFragment != null) {
            baseYYStudioFragment.E.a(new YYBaseUserHeadView.GetViewX_Y_W_H() { // from class: com.blued.android.module.yy_china.manager.YYGiftAnimManager.2
                @Override // com.blued.android.module.yy_china.view.YYBaseUserHeadView.GetViewX_Y_W_H
                public void a(final int i, final int i2, final int i3, final int i4) {
                    ImageLoader.a(YYGiftAnimManager.this.g.getFragmentActive(), yYMsgGiftExtra.gift_icon).a(new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.manager.YYGiftAnimManager.2.1
                        @Override // com.bumptech.glide.request.target.Target
                        /* renamed from: a */
                        public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                            if (drawable != null) {
                                YYGiftAnimManager.this.g.x.a(i, i2, i3, i4, ((BitmapDrawable) drawable).getBitmap(), StringUtils.a(str2, YYRoomInfoManager.e().k()));
                            }
                        }
                    });
                }
            }, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        synchronized (this) {
            if (this.f17526c != null && this.d != null && this.f17525a.size() != 0) {
                Iterator<YYImModel> it = this.f17525a.iterator();
                while (it.hasNext()) {
                    YYImModel next = it.next();
                    if (!next.is_play_only_mp4) {
                        boolean z = true;
                        boolean z2 = this.f17526c.getVisibility() == 0;
                        if (this.d.getVisibility() != 0) {
                            z = false;
                        }
                        if (z2 && this.f17526c.a(next)) {
                            it.remove();
                        } else if (!z || !this.d.a(next)) {
                            if (z2 && z) {
                                break;
                            } else if (!z2 && !z) {
                                this.f17526c.setHitModel(next);
                                it.remove();
                            } else if (z2 && !z) {
                                this.d.setHitModel(next);
                                it.remove();
                            } else if (!z2) {
                                this.f17526c.setHitModel(next);
                                it.remove();
                            }
                        } else {
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.g != null && this.f == null) {
            LogUtils.d("==yy==", "=== notifyPlayGif ===");
            this.g.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.manager.YYGiftAnimManager.3
                @Override // java.lang.Runnable
                public void run() {
                    YYGiftAnimManager.this.d();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        YYMsgGiftExtra e = e();
        LogUtils.d("==yy==", "=== loopPlayFullScreen ===");
        if (e == null) {
            this.e.setVisibility(8);
            this.h.setVisibility(8);
            return;
        }
        this.f = e;
        if (e.is_luck_gift == 2) {
            this.e.setVisibility(8);
            this.h.setVisibility(0);
            try {
                h();
            } catch (MalformedURLException e2) {
                Log.e("==yy==", "play svga animation error : " + e2.getMessage());
            }
        } else if (e.json_contents_modes == null || !StringUtils.a(e.json_contents_modes.is_show_rain(), "1") || StringUtils.b(e.json_contents_modes.getRain_level_ani_url())) {
            this.e.setVisibility(0);
            this.h.setVisibility(8);
            f();
        } else {
            this.e.setVisibility(8);
            this.h.setVisibility(0);
            g();
        }
    }

    private YYMsgGiftExtra e() {
        YYMsgGiftExtra yYMsgGiftExtra = this.f;
        if (yYMsgGiftExtra != null) {
            return yYMsgGiftExtra;
        }
        try {
            if (this.b.size() > 0) {
                return this.b.remove(0);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void f() {
        if (this.g == null) {
            return;
        }
        LogUtils.d("==yy==", "=== playFullScreenAnimation ===");
        this.e.a(this.g.getFragmentActive(), "", "", this.f.gift_mp4, "", LiveAnimationViewFactory.ScaleType.FIT_BOTTOM, new AnimationListenerAdapter() { // from class: com.blued.android.module.yy_china.manager.YYGiftAnimManager.4
            @Override // com.blued.android.module.live.base.view.animation.AnimationListenerAdapter, com.blued.android.module.live.base.view.animation.LiveAnimationListener
            public void b() {
                YYGiftAnimManager.this.j();
            }
        });
    }

    private void g() {
        if (this.j == null) {
            this.j = new SVGACallback() { // from class: com.blued.android.module.yy_china.manager.YYGiftAnimManager.5
                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onFinished() {
                    LogUtils.d("==yy==", "svgViewRain callback onFinished");
                    YYGiftAnimManager.this.j();
                }

                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onPause() {
                    LogUtils.d("==yy==", "svgViewRain callback onPause");
                }

                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onRepeat() {
                }

                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onStep(int i, double d) {
                }
            };
        }
        this.h.setCallback(this.j);
        ImageLoader.a((IRequestHost) null, this.f.gift_icon).a(new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.manager.YYGiftAnimManager.6
            @Override // com.bumptech.glide.request.target.Target
            /* renamed from: a */
            public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                new SVGAPlayer.Builder(YYGiftAnimManager.this.f.gift_mp4).a((Integer) 1).a(SVGAImageView.FillMode.Clear).a(YYGiftAnimManager.this.h, new SVGADynamicEntity().a(((BitmapDrawable) drawable).getBitmap(), "QIU"));
            }
        });
    }

    private void h() throws MalformedURLException {
        if (this.j == null) {
            this.j = new SVGACallback() { // from class: com.blued.android.module.yy_china.manager.YYGiftAnimManager.7
                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onFinished() {
                    LogUtils.d("==yy==", "svgView callback onFinished");
                    YYGiftAnimManager.this.j();
                }

                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onPause() {
                    LogUtils.d("==yy==", "svgView callback onPause");
                }

                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onRepeat() {
                }

                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onStep(int i, double d) {
                }
            };
        }
        this.h.setCallback(this.j);
        i().a(new URL(this.f.gift_svga), new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.yy_china.manager.YYGiftAnimManager.8
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity sVGAVideoEntity) {
                LogUtils.d("==yy==", "svgView load onFinished, start svga Anim");
                final SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                if (YYGiftAnimManager.this.f != null) {
                    YYGiftAnimManager.this.a(sVGADynamicEntity);
                    ImageLoader.a(YYGiftAnimManager.this.g.getFragmentActive(), YYGiftAnimManager.this.f.gift_avatar).a(new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.manager.YYGiftAnimManager.8.1
                        @Override // com.bumptech.glide.request.target.Target
                        /* renamed from: a */
                        public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                            try {
                                sVGADynamicEntity.a(((BitmapDrawable) drawable).getBitmap(), "use01");
                            } catch (Exception e) {
                            }
                        }
                    });
                }
                YYGiftAnimManager.this.h.setLoops(1);
                YYGiftAnimManager.this.h.setImageDrawable(new SVGADrawable(sVGAVideoEntity, sVGADynamicEntity));
                YYGiftAnimManager.this.h.a();
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null);
    }

    private SVGAParser i() {
        if (this.i == null) {
            this.i = SVGAParser.f15958a.b();
        }
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        BaseYYStudioFragment baseYYStudioFragment = this.g;
        if (baseYYStudioFragment == null) {
            return;
        }
        baseYYStudioFragment.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.manager.YYGiftAnimManager.9
            @Override // java.lang.Runnable
            public void run() {
                YYGiftAnimManager.this.f = null;
                YYGiftAnimManager.this.d();
            }
        });
    }

    public void a() {
        this.g = null;
        GiftBaseHitView giftBaseHitView = this.f17526c;
        if (giftBaseHitView != null) {
            giftBaseHitView.a();
            this.f17526c = null;
        }
        GiftBaseHitView giftBaseHitView2 = this.d;
        if (giftBaseHitView2 != null) {
            giftBaseHitView2.a();
            this.d = null;
        }
        this.e = null;
        this.f17525a.clear();
    }

    @Override // com.blued.android.module.yy_china.observer.GiftObserver
    public void a(final YYImModel yYImModel, final boolean z) {
        synchronized (this) {
            if (this.g == null) {
                return;
            }
            this.g.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.manager.YYGiftAnimManager.1
                @Override // java.lang.Runnable
                public void run() {
                    YYMsgGiftExtra a2 = YYGiftAnimManager.this.f17526c.a(yYImModel.getMsgExtra());
                    if (!StringUtils.b(a2.json_contents)) {
                        a2.json_contents_modes = (YYMsgJsonGiftExtra) AppInfo.f().fromJson(a2.json_contents, (Class<Object>) YYMsgJsonGiftExtra.class);
                    }
                    int i = a2.is_luck_gift;
                    if (i != 1) {
                        if (i == 2) {
                            a2.gift_mp4 = a2.gift_svga;
                            LogUtils.d("==yy==", "定制跑车礼物 svga：" + a2.gift_svga);
                        }
                    } else if (a2.extra != null && !TextUtils.isEmpty(a2.extra.getImages_mp4())) {
                        a2.gift_mp4 = a2.extra.getImages_mp4();
                        LogUtils.d("==yy==", "幸运礼物 gift_mp4：" + a2.gift_mp4);
                    }
                    if (a2.json_contents_modes != null && StringUtils.a(a2.json_contents_modes.is_show_rain(), "1") && !StringUtils.b(a2.json_contents_modes.getRain_level_ani_url())) {
                        a2.gift_mp4 = a2.json_contents_modes.getRain_level_ani_url();
                    }
                    if (yYImModel.type == 110) {
                        YYGiftAnimManager.this.b.add(a2);
                        YYGiftAnimManager.this.c();
                        return;
                    }
                    if (z) {
                        YYGiftAnimManager.this.f17525a.add(yYImModel);
                    } else {
                        YYGiftAnimManager.this.f17525a.add(0, yYImModel);
                    }
                    if (!TextUtils.isEmpty(a2.gift_mp4)) {
                        if (z) {
                            YYGiftAnimManager.this.b.add(a2);
                        } else {
                            YYGiftAnimManager.this.b.add(0, a2);
                        }
                        YYGiftAnimManager.this.c();
                    } else if (a2.json_contents_modes == null || StringUtils.b(a2.json_contents_modes.getRain_level_ani_url()) || !StringUtils.a(a2.json_contents_modes.is_show_rain(), "0")) {
                        YYGiftAnimManager.this.a(a2, yYImModel.target_profile.getUid(), yYImModel.source_profile.getUid());
                    }
                    YYGiftAnimManager.this.b();
                }
            });
        }
    }

    @Override // com.blued.android.module.yy_china.listener.GiftHitListener
    public void a(GiftBaseHitView giftBaseHitView) {
        b();
    }

    @Override // com.blued.android.module.yy_china.listener.GiftHitListener
    public void b(GiftBaseHitView giftBaseHitView) {
        b();
    }
}
