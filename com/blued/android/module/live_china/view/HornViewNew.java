package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.view.ScanningImageView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveHornModelNew;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.ScrollTextViewNew;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/HornViewNew.class */
public class HornViewNew extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f14323a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private View f14324c;
    private View d;
    private View e;
    private ScrollTextViewNew f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private ScanningImageView k;
    private ScanningImageView l;
    private List<LiveHornModelNew> m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;

    public HornViewNew(Context context) {
        super(context);
        this.m = new ArrayList();
        this.f14323a = context;
        b();
    }

    public HornViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = new ArrayList();
        this.f14323a = context;
        b();
    }

    private void b() {
        LayoutInflater from = LayoutInflater.from(this.f14323a);
        this.b = from;
        View inflate = from.inflate(R.layout.live_horn_layout_new, (ViewGroup) this, true);
        this.f14324c = inflate.findViewById(R.id.horn_layout);
        this.d = inflate.findViewById(R.id.ll_bar);
        this.e = inflate.findViewById(R.id.fl_horn_icon_root);
        this.f = (ScrollTextViewNew) inflate.findViewById(R.id.horn_text);
        this.g = (ImageView) inflate.findViewById(R.id.left_bg);
        this.h = (ImageView) inflate.findViewById(R.id.middle_bg);
        this.i = (ImageView) inflate.findViewById(R.id.right_bg);
        this.j = (ImageView) inflate.findViewById(R.id.horn_icon);
        this.k = (ScanningImageView) inflate.findViewById(R.id.scanning_bar);
        this.l = (ScanningImageView) inflate.findViewById(R.id.scanning_icon);
        this.f14324c.setVisibility(8);
        this.f.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final LiveHornModelNew liveHornModelNew) {
        Animation loadAnimation = AnimationUtils.loadAnimation(AppInfo.d(), R.anim.hornview_in_from_right);
        loadAnimation.setDuration(500L);
        final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.HornViewNew.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.HornViewNew.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HornViewNew.this.f.a();
                    }
                }, 4000L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.f.setOnScrollListener(new ScrollTextViewNew.OnScrollListener() { // from class: com.blued.android.module.live_china.view.HornViewNew.8
            @Override // com.blued.android.module.live_china.view.ScrollTextViewNew.OnScrollListener
            public void a() {
                HornViewNew.this.f.setVisibility(4);
                HornViewNew.this.f14324c.startAnimation(alphaAnimation);
            }
        });
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.HornViewNew.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                HornViewNew.this.m.remove(liveHornModelNew);
                HornViewNew.this.f14324c.setVisibility(8);
                HornViewNew.this.n = false;
                HornViewNew.this.c();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.f.startAnimation(loadAnimation);
        this.f.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        final LiveHornModelNew liveHornModelNew;
        if (this.n || this.m.size() <= 0 || (liveHornModelNew = this.m.get(0)) == null) {
            return;
        }
        this.n = true;
        this.p = false;
        this.q = false;
        this.r = false;
        this.o = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.s = false;
        ImageFileLoader.a((IRequestHost) null).a(liveHornModelNew.head_image).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.view.HornViewNew.3
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public void onUIFinish(File file, Exception exc) {
                Log.i("==xpm", "head_image:" + liveHornModelNew.head_image);
                if (file != null && file.exists()) {
                    HornViewNew.this.t = true;
                }
                HornViewNew.this.p = true;
                HornViewNew.this.a(liveHornModelNew);
            }
        }).a();
        ImageFileLoader.a((IRequestHost) null).a(liveHornModelNew.back_image).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.view.HornViewNew.4
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public void onUIFinish(File file, Exception exc) {
                Log.i("==xpm", "back_image:" + liveHornModelNew.back_image);
                if (file != null && file.exists()) {
                    HornViewNew.this.u = true;
                }
                HornViewNew.this.q = true;
                HornViewNew.this.a(liveHornModelNew);
            }
        }).a();
        ImageFileLoader.a((IRequestHost) null).a(liveHornModelNew.tail_image).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.view.HornViewNew.5
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public void onUIFinish(File file, Exception exc) {
                Log.i("==xpm", "tail_image:" + liveHornModelNew.tail_image);
                if (file != null && file.exists()) {
                    HornViewNew.this.v = true;
                }
                HornViewNew.this.r = true;
                HornViewNew.this.a(liveHornModelNew);
            }
        }).a();
        ImageFileLoader.a((IRequestHost) null).a(liveHornModelNew.icon_image).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.view.HornViewNew.6
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public void onUIFinish(File file, Exception exc) {
                Log.i("==xpm", "head_image:" + liveHornModelNew.head_image);
                if (file != null && file.exists()) {
                    HornViewNew.this.s = true;
                }
                HornViewNew.this.o = true;
                HornViewNew.this.a(liveHornModelNew);
            }
        }).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.k.setDuration(900L);
        this.k.setView(this.d);
        this.k.setSrcBitmap(LivePKRoundStartView.a(this.d));
        this.k.a();
    }

    private void setScrollText(LiveHornModelNew liveHornModelNew) {
        this.f.a(liveHornModelNew);
    }

    /* renamed from: a */
    public void e() {
        this.l.setDuration(500L);
        this.l.setView(this.j);
        this.l.setSrcBitmap(LivePKRoundStartView.a(this.j));
        this.l.a();
        ObjectAnimator.ofFloat(this.l, "Alpha", 1.0f, 0.0f).setDuration(500L).start();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$HornViewNew$3cNvsJKseucA-ysTi_je3siLI1s
            @Override // java.lang.Runnable
            public final void run() {
                HornViewNew.this.d();
            }
        }, 400L);
        final LinearInterpolator linearInterpolator = new LinearInterpolator();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.e, "Rotation", 0.0f, -15.0f, 15.0f, -15.0f, 15.0f);
        ofFloat.setDuration(1200L);
        ofFloat.setInterpolator(linearInterpolator);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.HornViewNew.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                final ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(HornViewNew.this.e, "Rotation", 15.0f, -8.0f);
                ofFloat2.setDuration(240L);
                ofFloat2.setInterpolator(linearInterpolator);
                ofFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.HornViewNew.10.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        super.onAnimationEnd(animator2);
                        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(HornViewNew.this.e, "Rotation", -8.0f, 5.0f, 0.0f);
                        ofFloat3.setDuration(420L);
                        ofFloat2.setInterpolator(linearInterpolator);
                        ofFloat3.start();
                    }
                });
                ofFloat2.start();
            }
        });
        ofFloat.start();
    }

    public void a(final LiveHornModelNew liveHornModelNew) {
        if (this.p && this.q && this.r && this.o && liveHornModelNew != null) {
            if (!this.t || !this.u || !this.v) {
                liveHornModelNew.head_image = "";
                liveHornModelNew.back_image = "";
                liveHornModelNew.tail_image = "";
            }
            ImageLoader.a((IRequestHost) null, liveHornModelNew.head_image).b(R.drawable.live_horn_left_bg).a(this.g);
            ImageLoader.a((IRequestHost) null, liveHornModelNew.back_image).b(R.drawable.live_horn_middle_bg).a(this.h);
            ImageLoader.a((IRequestHost) null, liveHornModelNew.tail_image).b(R.drawable.live_horn_end_bg).a(this.i);
            if (!this.s) {
                ImageLoader.a((IRequestHost) null, liveHornModelNew.icon_image).b(R.drawable.live_horn_icon_new).g(-1).a(this.j);
            } else if (TextUtils.isEmpty(liveHornModelNew.icon_image) || !liveHornModelNew.icon_image.endsWith(".gif")) {
                ImageLoader.a((IRequestHost) null, liveHornModelNew.icon_image).e((int) (System.currentTimeMillis() / 1000)).g(-1).a(this.j);
            } else {
                ImageLoader.a((IRequestHost) null, liveHornModelNew.icon_image).g(-1).a(this.j);
            }
            if (liveHornModelNew.effect == 0) {
                this.j.clearAnimation();
            } else if (liveHornModelNew.effect == 1) {
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$HornViewNew$LaN2qaOxqsLvaoJioSgJUAaO6m8
                    @Override // java.lang.Runnable
                    public final void run() {
                        HornViewNew.this.e();
                    }
                }, 500L);
            }
            setScrollText(liveHornModelNew);
            this.f14324c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.HornViewNew.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    EventTrackLive.e(LiveProtos.Event.LIVE_HORN_CLICK, liveHornModelNew.lid, liveHornModelNew.uid, String.valueOf(liveHornModelNew.scene), liveHornModelNew.report_id);
                    if (liveHornModelNew.link_type > 0) {
                        LiveRoomFunctionItemModel liveRoomFunctionItemModel = new LiveRoomFunctionItemModel();
                        liveRoomFunctionItemModel.setLink(liveHornModelNew.link);
                        liveRoomFunctionItemModel.setLink_type(liveHornModelNew.link_type);
                        LiveEventBusUtil.a(liveRoomFunctionItemModel);
                    } else if (!TextUtils.isEmpty(liveHornModelNew.redirect_url)) {
                        LiveRefreshUIObserver.a().b(liveHornModelNew.redirect_url, 0);
                        LiveSetDataObserver.a().b(liveHornModelNew.redirect_url, 0);
                    } else if (StringUtils.a(liveHornModelNew.lid, 0L) <= 0) {
                        if (TextUtils.isEmpty(liveHornModelNew.uid)) {
                            return;
                        }
                        LiveSetDataObserver.a().e(liveHornModelNew.uid);
                    } else {
                        LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(liveHornModelNew.lid, 0L), 0, "live_room_ranking", liveHornModelNew.uid, "", "", 0);
                        if (!LiveFloatManager.a().y() || TextUtils.equals(liveHornModelNew.lid, LiveRoomManager.a().e())) {
                            return;
                        }
                        LiveDataListManager.a().a(liveRoomData, false);
                    }
                }
            });
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.HornViewNew.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    HornViewNew.this.b(liveHornModelNew);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.f14324c.setVisibility(0);
            this.f14324c.clearAnimation();
            this.f14324c.startAnimation(translateAnimation);
            EventTrackLive.e(LiveProtos.Event.LIVE_HORN_SHOW, liveHornModelNew.lid, liveHornModelNew.uid, String.valueOf(liveHornModelNew.scene), liveHornModelNew.report_id);
        }
    }

    public void a(LiveHornModelNew liveHornModelNew, boolean z) {
        if (z) {
            this.m.add(0, liveHornModelNew);
        } else {
            this.m.add(liveHornModelNew);
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
