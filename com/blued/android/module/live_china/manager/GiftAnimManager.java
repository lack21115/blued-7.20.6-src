package com.blued.android.module.live_china.manager;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.UiUtils;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.liveForMsg.LiveMsgManager;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.observer.BeansRefreshObserver;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.blued.android.module.live_china.utils.LiveViewUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.MarqueeTextView;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/GiftAnimManager.class */
public class GiftAnimManager extends Thread {
    private static long Y = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public static String f13570c = "";
    public static long d;
    private ImageView A;
    private ImageView B;
    private TextView C;
    private TextView D;
    private LinearLayout E;
    private LinearLayout F;
    private LoadOptions G;
    private LoadOptions H;
    private LiveMsgManager I;
    private ActivityFragmentActive J;
    private LiveGiftModel M;
    private LiveGiftModel N;
    private boolean T;
    private boolean U;
    private GiftHandler V;
    private BatchCountDownTimer1 W;
    private BatchCountDownTimer2 X;
    private LinearLayout f;
    private View g;
    private View h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private MarqueeTextView q;
    private MarqueeTextView r;
    private ImageView s;
    private ImageView t;
    private ImageView u;
    private ImageView v;
    private ImageView w;
    private ImageView x;
    private ShapeRelativeLayout y;
    private ShapeRelativeLayout z;
    private boolean e = false;
    private Anim1Runnable K = new Anim1Runnable();
    private Anim2Runnable L = new Anim2Runnable();

    /* renamed from: a  reason: collision with root package name */
    public boolean f13571a = true;
    public boolean b = true;
    private List<LiveChattingModel> O = Collections.synchronizedList(new LinkedList());
    private List<LiveGiftModel> P = Collections.synchronizedList(new LinkedList());
    private List<LiveGiftModel> Q = Collections.synchronizedList(new LinkedList());
    private List<LiveGiftModel> R = new ArrayList();
    private List<LiveGiftModel> S = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/GiftAnimManager$Anim1Runnable.class */
    public class Anim1Runnable implements Runnable {
        private Anim1Runnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GiftAnimManager.this.f13571a = true;
            GiftAnimManager.this.g.setVisibility(4);
            GiftAnimManager.this.C.setText("");
            GiftAnimManager.this.d();
            LogUtils.c("释放第一条弹道");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/GiftAnimManager$Anim2Runnable.class */
    public class Anim2Runnable implements Runnable {
        private Anim2Runnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GiftAnimManager.this.b = true;
            GiftAnimManager.this.h.setVisibility(4);
            GiftAnimManager.this.D.setText("");
            GiftAnimManager.this.d();
            LogUtils.c("释放第二条弹道");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/GiftAnimManager$BatchCountDownTimer1.class */
    public class BatchCountDownTimer1 extends CountDownTimer {
        private LiveGiftModel b;

        /* renamed from: c  reason: collision with root package name */
        private int f13588c;
        private int d;

        public BatchCountDownTimer1(long j, long j2, LiveGiftModel liveGiftModel, int i, int i2) {
            super(j, j2);
            this.f13588c = 0;
            this.b = liveGiftModel;
            this.f13588c = i;
            this.d = i2;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            LogUtils.a("onFinish 11 count = ", Integer.valueOf(this.f13588c));
            int i = this.f13588c;
            int i2 = this.d;
            if (i >= i2) {
                GiftAnimManager.this.V.postDelayed(GiftAnimManager.this.K, GiftAnimManager.this.a(this.b, false));
            } else if (i2 - i != 1) {
                GiftAnimManager giftAnimManager = GiftAnimManager.this;
                GiftAnimManager giftAnimManager2 = GiftAnimManager.this;
                int i3 = this.d;
                int i4 = this.f13588c;
                giftAnimManager.W = new BatchCountDownTimer1((i3 - i4) * 100, 100L, this.b, i4, i3);
                GiftAnimManager.this.W.start();
            } else {
                this.f13588c = i + 1;
                TextView textView = GiftAnimManager.this.C;
                textView.setText(this.f13588c + "");
                GiftAnimManager giftAnimManager3 = GiftAnimManager.this;
                giftAnimManager3.a(giftAnimManager3.E, this.b);
                GiftAnimManager.this.V.postDelayed(GiftAnimManager.this.K, GiftAnimManager.this.a(this.b, false));
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            this.f13588c++;
            GiftAnimManager.this.C.setText(this.f13588c + "");
            GiftAnimManager giftAnimManager = GiftAnimManager.this;
            giftAnimManager.a(giftAnimManager.E, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/GiftAnimManager$BatchCountDownTimer2.class */
    public class BatchCountDownTimer2 extends CountDownTimer {
        private LiveGiftModel b;

        /* renamed from: c  reason: collision with root package name */
        private int f13590c;
        private int d;

        public BatchCountDownTimer2(long j, long j2, LiveGiftModel liveGiftModel, int i, int i2) {
            super(j, j2);
            this.f13590c = 0;
            this.b = liveGiftModel;
            this.f13590c = i;
            this.d = i2;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            LogUtils.a("onFinish 22 count = ", Integer.valueOf(this.f13590c));
            int i = this.f13590c;
            int i2 = this.d;
            if (i >= i2) {
                GiftAnimManager.this.V.postDelayed(GiftAnimManager.this.L, GiftAnimManager.this.a(this.b, false));
            } else if (i2 - i != 1) {
                GiftAnimManager giftAnimManager = GiftAnimManager.this;
                GiftAnimManager giftAnimManager2 = GiftAnimManager.this;
                int i3 = this.d;
                int i4 = this.f13590c;
                giftAnimManager.X = new BatchCountDownTimer2((i3 - i4) * 100, 100L, this.b, i4, i3);
                GiftAnimManager.this.X.start();
            } else {
                this.f13590c = i + 1;
                TextView textView = GiftAnimManager.this.D;
                textView.setText(this.f13590c + "");
                GiftAnimManager giftAnimManager3 = GiftAnimManager.this;
                giftAnimManager3.a(giftAnimManager3.F, this.b);
                GiftAnimManager.this.V.postDelayed(GiftAnimManager.this.L, GiftAnimManager.this.a(this.b, false));
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            this.f13590c++;
            GiftAnimManager.this.D.setText(this.f13590c + "");
            GiftAnimManager giftAnimManager = GiftAnimManager.this;
            giftAnimManager.a(giftAnimManager.F, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/GiftAnimManager$GiftHandler.class */
    public final class GiftHandler extends Handler {
        private GiftHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LiveChattingModel liveChattingModel = (LiveChattingModel) message.obj;
            int i = message.arg1;
            if (i == 1) {
                GiftAnimManager.this.e(liveChattingModel);
            } else if (i == 2) {
                GiftAnimManager.this.f(liveChattingModel);
            } else if (i == 3) {
                GiftAnimManager.this.d(liveChattingModel);
            }
        }
    }

    public GiftAnimManager() {
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(LiveGiftModel liveGiftModel, boolean z) {
        if (liveGiftModel != null) {
            Log.v(ReqAckPackage.REQ_RESPONSE_KEY.BEANS, "动画礼物更新弯豆：" + liveGiftModel.beans_count);
            BeansRefreshObserver.a().a(liveGiftModel.beans_count, liveGiftModel.beans_current_count);
            LogUtils.a("pk", "msgExtra.ops = ", Integer.valueOf(liveGiftModel.ops));
            LogUtils.a("pk", "msgExtra.resource_url = ", liveGiftModel.resource_url);
            LogUtils.a("pk", "msgExtra.anim_code = ", liveGiftModel.anim_code);
            if (liveGiftModel.ops == 10) {
                d(liveGiftModel);
                return 4000L;
            } else if (liveGiftModel.ops != 5) {
                if (TextUtils.isEmpty(liveGiftModel.images_gif) && TextUtils.isEmpty(liveGiftModel.images_apng2) && TextUtils.isEmpty(liveGiftModel.images_mp4) && (!liveGiftModel.is_luck_bag || !"LUCK_BAG".equals(liveGiftModel.type))) {
                    return 5000L;
                }
                if (z) {
                    if (liveGiftModel.always_show_animation || LiveRoomManager.a().H()) {
                        if (liveGiftModel.anim_many != 1 || liveGiftModel.hit_count <= 1) {
                            this.P.add(liveGiftModel);
                        } else {
                            for (int i = 0; i < liveGiftModel.hit_count; i++) {
                                this.P.add(liveGiftModel);
                            }
                        }
                        PlayGifObserver.a().b();
                        return 4000L;
                    }
                    return 4000L;
                }
                return 4000L;
            } else {
                return 2000L;
            }
        }
        return 5000L;
    }

    private void a(final int i, LiveGiftModel liveGiftModel, final Runnable runnable, final View view, final View view2, final LiveGiftModel liveGiftModel2) {
        Animation loadAnimation = AnimationUtils.loadAnimation(AppInfo.d(), R.anim.live_msg_gift_in_from_left);
        view2.setAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.manager.GiftAnimManager.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view2.setVisibility(0);
                LiveGiftModel liveGiftModel3 = liveGiftModel2;
                if (liveGiftModel3 != null) {
                    if (!GiftAnimManager.this.f(liveGiftModel3)) {
                        LogUtils.a("第一个横条 hit_count = ", Integer.valueOf(liveGiftModel2.hit_count));
                        LiveGiftModel liveGiftModel4 = liveGiftModel2;
                        if (liveGiftModel4 == null || liveGiftModel4.hit_count <= 0) {
                            return;
                        }
                        GiftAnimManager.this.a(view);
                        return;
                    }
                    GiftAnimManager.this.V.removeCallbacks(runnable);
                    int i2 = i;
                    if (i2 == 1) {
                        GiftAnimManager giftAnimManager = GiftAnimManager.this;
                        GiftAnimManager giftAnimManager2 = GiftAnimManager.this;
                        long j = liveGiftModel2.hit_count * 100;
                        LiveGiftModel liveGiftModel5 = liveGiftModel2;
                        giftAnimManager.W = new BatchCountDownTimer1(j, 100L, liveGiftModel5, 0, liveGiftModel5.hit_count);
                        GiftAnimManager.this.W.start();
                    } else if (i2 == 2) {
                        GiftAnimManager giftAnimManager3 = GiftAnimManager.this;
                        GiftAnimManager giftAnimManager4 = GiftAnimManager.this;
                        long j2 = liveGiftModel2.hit_count * 100;
                        LiveGiftModel liveGiftModel6 = liveGiftModel2;
                        giftAnimManager3.X = new BatchCountDownTimer2(j2, 100L, liveGiftModel6, 0, liveGiftModel6.hit_count);
                        GiftAnimManager.this.X.start();
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.V.postDelayed(runnable, g(liveGiftModel));
        d();
        LogUtils.c("弹道一唤醒线程 继续轮询任务");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        a(view, (LiveGiftModel) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, LiveGiftModel liveGiftModel) {
        float f = f(liveGiftModel) ? 1.5f : 3.0f;
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, 0.5f, f, 0.5f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(250L);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(100L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.manager.GiftAnimManager.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.manager.GiftAnimManager.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(scaleAnimation);
    }

    private void a(final LiveChattingModel liveChattingModel, int i, Runnable runnable, View view, View view2, ImageView imageView, ShapeRelativeLayout shapeRelativeLayout, ImageView imageView2, ImageView imageView3, View view3, TextView textView, ImageView imageView4, ImageView imageView5, TextView textView2, View view4, View view5) {
        if (liveChattingModel.msgMapExtra == null || liveChattingModel.msgMapExtra.get("bg_url") == null || !(liveChattingModel.msgMapExtra.get("bg_url") instanceof String)) {
            ShapeModel shapeModel = shapeRelativeLayout.getShapeModel();
            shapeModel.t = Color.parseColor("#66000000");
            shapeModel.v = Color.parseColor("#00000000");
            shapeRelativeLayout.setShapeModel(shapeModel);
            shapeRelativeLayout.setVisibility(0);
            imageView.setVisibility(8);
        } else {
            ImageLoader.a(this.J, (String) liveChattingModel.msgMapExtra.get("bg_url")).a(imageView);
            shapeRelativeLayout.setVisibility(8);
            imageView.setVisibility(0);
        }
        ImageLoader.a(this.J, liveChattingModel.fromAvatar).c().b(R.drawable.user_bg_round).a(imageView2);
        if (liveChattingModel.msgMapExtra == null || liveChattingModel.msgMapExtra.get("avatar_frame_img") == null || !(liveChattingModel.msgMapExtra.get("avatar_frame_img") instanceof String)) {
            imageView3.setVisibility(8);
        } else {
            String str = (String) liveChattingModel.msgMapExtra.get("avatar_frame_img");
            imageView3.setVisibility(0);
            ImageLoader.a(this.J, str).g().g(-1).a(imageView3);
        }
        view3.setVisibility(0);
        textView.setText(LiveCloakingUtil.a(liveChattingModel.fromNickName, liveChattingModel.fromPrivilege));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.manager.-$$Lambda$GiftAnimManager$zNb2YDgA0abGyy7845blZ3Jwu04
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                GiftAnimManager.this.a(liveChattingModel, view6);
            }
        });
        String str2 = (String) liveChattingModel.msgMapExtra.get("nameplate_img");
        if (TextUtils.isEmpty(str2)) {
            imageView4.setVisibility(8);
        } else {
            imageView4.setVisibility(0);
            ImageLoader.a(this.J, str2).g().g(-1).a(imageView4);
        }
        String str3 = (String) liveChattingModel.msgMapExtra.get("noble_name");
        if (!TextUtils.isEmpty(str3)) {
            textView2.setText("荣升" + str3 + "贵族");
        }
        imageView5.setVisibility(8);
        view4.setVisibility(8);
        view5.setVisibility(8);
        a(i, null, runnable, view, view2, null);
        EventTrackLive.a(LiveProtos.Event.LIVE_NOBLE_BANNER_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveChattingModel liveChattingModel, View view) {
        g(liveChattingModel);
    }

    private void a(String str, ImageView imageView, List<String> list, ShapeRelativeLayout shapeRelativeLayout) {
        ShapeModel shapeModel;
        ShapeModel shapeModel2 = shapeRelativeLayout.getShapeModel();
        if (!TextUtils.isEmpty(str)) {
            imageView.setVisibility(0);
            shapeRelativeLayout.setVisibility(8);
            ImageLoader.a(this.J, str).a(imageView);
            shapeModel = null;
        } else if (list == null || list.size() <= 0) {
            imageView.setVisibility(8);
            shapeRelativeLayout.setVisibility(0);
            shapeModel2.t = Color.parseColor("#66000000");
            shapeModel2.v = Color.parseColor("#00000000");
            shapeModel2.H = UiUtils.a(AppInfo.d(), 23.0f);
            shapeModel = shapeModel2;
        } else {
            imageView.setVisibility(8);
            shapeRelativeLayout.setVisibility(0);
            shapeModel2.t = Color.parseColor(list.get(0));
            shapeModel2.H = UiUtils.a(AppInfo.d(), 23.0f);
            if (list.size() > 2) {
                shapeModel2.u = Color.parseColor(list.get(1));
                shapeModel2.v = Color.parseColor(list.get(2));
                shapeModel = shapeModel2;
            } else if (list.size() > 1) {
                shapeModel2.u = 0;
                shapeModel2.v = Color.parseColor(list.get(1));
                shapeModel = shapeModel2;
            } else {
                shapeModel2.u = 0;
                shapeModel2.v = Color.parseColor(list.get(0));
                shapeModel = shapeModel2;
            }
        }
        shapeRelativeLayout.setShapeModel(shapeModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(LiveChattingModel liveChattingModel) {
        LiveGiftModel liveGiftModel;
        if (liveChattingModel.msgMapExtra != null) {
            liveGiftModel = (LiveGiftModel) liveChattingModel.msgMapExtra.get("gift_model");
        } else {
            try {
                liveGiftModel = (LiveGiftModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), (Class<Object>) LiveGiftModel.class);
            } catch (Exception e) {
                e.printStackTrace();
                liveGiftModel = null;
            }
        }
        if (liveGiftModel == null) {
            this.f13571a = true;
            this.b = true;
            return;
        }
        LiveGiftModel liveGiftModel2 = this.M;
        if (liveGiftModel2 != null && liveGiftModel2.hit_id == liveGiftModel.hit_id && this.M.userId == liveChattingModel.fromId) {
            LogUtils.c("和第一条有关系 hit_count：" + liveGiftModel.hit_count + "-- hit_id：" + liveGiftModel.hit_id + "-- isPlayHit1 = " + this.T);
            this.V.removeCallbacks(this.K);
            this.R.add(liveGiftModel);
            if (this.T) {
                return;
            }
            n();
            return;
        }
        LiveGiftModel liveGiftModel3 = this.N;
        if (liveGiftModel3 != null && liveGiftModel3.hit_id == liveGiftModel.hit_id && this.N.userId == liveChattingModel.fromId) {
            LogUtils.c("和第二条有关系 hit_count：" + liveGiftModel.hit_count + "-- hit_id：" + liveGiftModel.hit_id + "-- isPlayHit2 = " + this.U);
            this.V.removeCallbacks(this.L);
            this.S.add(liveGiftModel);
            if (this.U) {
                return;
            }
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final LiveChattingModel liveChattingModel) {
        synchronized (this) {
            try {
                this.f13571a = false;
                Map<String, Object> map = liveChattingModel.msgMapExtra;
                if (!((map == null || !map.containsKey("isNobleUpgrade")) ? false : ((Boolean) map.get("isNobleUpgrade")).booleanValue())) {
                    LiveGiftModel liveGiftModel = null;
                    try {
                        if (map != null) {
                            liveGiftModel = (LiveGiftModel) liveChattingModel.msgMapExtra.get("gift_model");
                        } else {
                            try {
                                liveGiftModel = (LiveGiftModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), (Class<Object>) LiveGiftModel.class);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (liveGiftModel == null) {
                            this.f13571a = true;
                            return;
                        }
                        if (liveGiftModel.animation != 0 && this.f.getVisibility() != 8) {
                            this.M = liveGiftModel;
                            liveGiftModel.userId = liveChattingModel.fromId;
                            if ((!liveGiftModel.is_opponent && !liveGiftModel.onlyPlayScreen) || (TextUtils.isEmpty(liveGiftModel.images_gif) && TextUtils.isEmpty(liveGiftModel.images_apng2) && TextUtils.isEmpty(liveGiftModel.images_mp4))) {
                                this.q.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.manager.GiftAnimManager.9
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        Tracker.onClick(view);
                                        GiftAnimManager.this.g(liveChattingModel);
                                    }
                                });
                                if (liveGiftModel.hit_count > 0) {
                                    this.E.setVisibility(0);
                                } else {
                                    this.E.setVisibility(8);
                                }
                                this.o.setVisibility(8);
                                this.q.setText(LiveCloakingUtil.a(liveChattingModel.fromNickName, liveChattingModel.fromPrivilege));
                                this.m.setText(AppInfo.d().getResources().getString(R.string.Live_SendPresent_send) + liveGiftModel.name);
                                if (!f(liveGiftModel)) {
                                    this.C.setText(liveGiftModel.hit_count + "");
                                }
                                ImageLoader.a(this.J, liveChattingModel.fromAvatar).c().b(R.drawable.user_bg_round).a(this.s);
                                if (TextUtils.isEmpty(liveGiftModel.avatar_frame_url)) {
                                    this.u.setVisibility(8);
                                } else {
                                    this.u.setVisibility(0);
                                    ImageLoader.a(this.J, liveGiftModel.avatar_frame_url).g().g(-1).a(this.u);
                                }
                                a(liveGiftModel.bg_img, this.w, liveGiftModel.bg_color, this.y);
                                LogUtils.c("aniGiftView1 gift_pic_url = ", liveGiftModel.images_static);
                                this.A.setVisibility(0);
                                ImageLoader.a(this.J, liveGiftModel.images_static).b(R.drawable.gift_default_icon).a(this.A);
                                LiveViewUtils.f14195a.a(liveChattingModel, this.i);
                                if (this.i.getVisibility() == 0) {
                                    this.k.setVisibility(8);
                                } else {
                                    BitmapUtils.a(AppInfo.d(), this.k, liveChattingModel.fromRichLevel);
                                }
                                a(1, liveGiftModel, this.K, this.E, this.g, this.M);
                                return;
                            }
                            this.P.add(liveGiftModel);
                            PlayGifObserver.a().b();
                            this.V.postDelayed(this.K, 4000L);
                            d();
                            return;
                        }
                        Log.v(ReqAckPackage.REQ_RESPONSE_KEY.BEANS, "普通礼物没动画更新弯豆：" + liveGiftModel.beans_count);
                        BeansRefreshObserver.a().a(liveGiftModel.beans_count, liveGiftModel.beans_current_count);
                        this.f13571a = true;
                        return;
                    } catch (Throwable th) {
                        th = th;
                    }
                } else if (liveChattingModel.nobleModel == null) {
                    this.f13571a = true;
                    return;
                } else {
                    try {
                        a(liveChattingModel, 1, this.K, this.E, this.g, this.w, this.y, this.s, this.u, this.o, this.q, this.i, this.k, this.m, this.A, this.E);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final LiveChattingModel liveChattingModel) {
        LiveGiftModel liveGiftModel;
        synchronized (this) {
            try {
                this.b = false;
                Map<String, Object> map = liveChattingModel.msgMapExtra;
                if (!((map == null || !map.containsKey("isNobleUpgrade")) ? false : ((Boolean) map.get("isNobleUpgrade")).booleanValue())) {
                    try {
                        if (liveChattingModel.msgMapExtra != null) {
                            liveGiftModel = (LiveGiftModel) liveChattingModel.msgMapExtra.get("gift_model");
                        } else {
                            try {
                                liveGiftModel = (LiveGiftModel) AppInfo.f().fromJson(liveChattingModel.getMsgExtra(), (Class<Object>) LiveGiftModel.class);
                            } catch (Exception e) {
                                e.printStackTrace();
                                liveGiftModel = null;
                            }
                        }
                        if (liveGiftModel == null) {
                            this.b = true;
                            return;
                        }
                        if (liveGiftModel.animation != 0 && this.f.getVisibility() != 8) {
                            this.N = liveGiftModel;
                            liveGiftModel.userId = liveChattingModel.fromId;
                            if ((!liveGiftModel.is_opponent && !liveGiftModel.onlyPlayScreen) || (TextUtils.isEmpty(liveGiftModel.images_gif) && TextUtils.isEmpty(liveGiftModel.images_apng2) && TextUtils.isEmpty(liveGiftModel.images_mp4))) {
                                this.r.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.manager.GiftAnimManager.11
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        Tracker.onClick(view);
                                        GiftAnimManager.this.g(liveChattingModel);
                                    }
                                });
                                if (liveGiftModel.hit_count > 0) {
                                    this.F.setVisibility(0);
                                } else {
                                    this.F.setVisibility(8);
                                }
                                this.p.setVisibility(8);
                                this.r.setText(LiveCloakingUtil.a(liveChattingModel.fromNickName, liveChattingModel.fromPrivilege));
                                this.n.setText(AppInfo.d().getResources().getString(R.string.Live_SendPresent_send) + liveGiftModel.name);
                                if (!f(liveGiftModel)) {
                                    this.D.setText(liveGiftModel.hit_count + "");
                                }
                                ImageLoader.a(this.J, liveChattingModel.fromAvatar).c().b(R.drawable.user_bg_round).a(this.t);
                                if (TextUtils.isEmpty(liveGiftModel.avatar_frame_url)) {
                                    this.v.setVisibility(8);
                                } else {
                                    this.v.setVisibility(0);
                                    ImageLoader.a(this.J, liveGiftModel.avatar_frame_url).g().g(-1).a(this.v);
                                }
                                a(liveGiftModel.bg_img, this.x, liveGiftModel.bg_color, this.z);
                                LogUtils.c("aniGiftView2 giftModel.bg_img = ", liveGiftModel.bg_img);
                                this.B.setVisibility(0);
                                ImageLoader.a(this.J, liveGiftModel.images_static).b(R.drawable.gift_default_icon).a(this.B);
                                LiveViewUtils.f14195a.a(liveChattingModel, this.j);
                                if (this.j.getVisibility() == 0) {
                                    this.l.setVisibility(8);
                                } else {
                                    BitmapUtils.a(AppInfo.d(), this.l, liveChattingModel.fromRichLevel);
                                }
                                a(2, liveGiftModel, this.L, this.F, this.h, this.N);
                                return;
                            }
                            this.P.add(liveGiftModel);
                            PlayGifObserver.a().b();
                            this.V.postDelayed(this.L, 4000L);
                            d();
                            return;
                        }
                        Log.v(ReqAckPackage.REQ_RESPONSE_KEY.BEANS, "普通礼物没动画更新弯豆：" + liveGiftModel.beans_count);
                        BeansRefreshObserver.a().a(liveGiftModel.beans_count, liveGiftModel.beans_current_count);
                        this.b = true;
                        return;
                    } catch (Throwable th) {
                        th = th;
                    }
                } else if (liveChattingModel.nobleModel == null) {
                    this.f13571a = true;
                    return;
                } else {
                    try {
                        a(liveChattingModel, 2, this.L, this.F, this.h, this.x, this.z, this.t, this.v, this.p, this.r, this.j, this.l, this.n, this.B, this.F);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(LiveGiftModel liveGiftModel) {
        return liveGiftModel != null && liveGiftModel.hit_batch == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long g(LiveGiftModel liveGiftModel) {
        return a(liveGiftModel, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(LiveChattingModel liveChattingModel) {
        if (liveChattingModel.fromPrivilege == 1 || this.I == null || liveChattingModel.fromPrivilege == 1) {
            return;
        }
        this.I.a(String.valueOf(liveChattingModel.fromId));
    }

    private void i() {
        this.V = new GiftHandler();
    }

    private LiveChattingModel j() {
        if (this.O.size() > 0) {
            try {
                return this.O.remove(0);
            } catch (Exception e) {
                return new LiveChattingModel();
            }
        }
        return new LiveChattingModel();
    }

    private LiveChattingModel k() {
        return this.O.size() > 0 ? this.O.get(0) : new LiveChattingModel();
    }

    private boolean l() {
        return this.O.size() > 0;
    }

    private void m() {
        BatchCountDownTimer1 batchCountDownTimer1 = this.W;
        if (batchCountDownTimer1 != null) {
            batchCountDownTimer1.cancel();
        }
        BatchCountDownTimer2 batchCountDownTimer2 = this.X;
        if (batchCountDownTimer2 != null) {
            batchCountDownTimer2.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.R.size() > 0) {
            LogUtils.c("playHitGiftList1");
            this.T = true;
            this.V.removeCallbacks(this.K);
            final LiveGiftModel liveGiftModel = this.R.get(0);
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.manager.GiftAnimManager.1
                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.c("onAnimationEnd--------");
                    GiftAnimManager.this.T = false;
                    GiftAnimManager.this.R.remove(liveGiftModel);
                    GiftAnimManager.this.n();
                    GiftAnimManager.this.V.removeCallbacks(GiftAnimManager.this.K);
                    GiftAnimManager.this.V.postDelayed(GiftAnimManager.this.K, GiftAnimManager.this.g(liveGiftModel));
                }
            }, 200L);
            if (liveGiftModel.hit_count > 0) {
                this.E.setVisibility(0);
            } else {
                this.E.setVisibility(8);
            }
            this.g.setVisibility(0);
            TextView textView = this.C;
            textView.setText(liveGiftModel.hit_count + "");
            ScaleAnimation scaleAnimation = new ScaleAnimation(2.0f, 0.5f, 2.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(250L);
            final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(100L);
            scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.manager.GiftAnimManager.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    GiftAnimManager.this.E.startAnimation(scaleAnimation2);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.manager.GiftAnimManager.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.E.startAnimation(scaleAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        LogUtils.c("playHitGiftList2");
        if (this.S.size() > 0) {
            this.U = true;
            this.V.removeCallbacks(this.L);
            final LiveGiftModel liveGiftModel = this.S.get(0);
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.manager.GiftAnimManager.4
                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.c("onAnimationEnd2--------");
                    GiftAnimManager.this.U = false;
                    GiftAnimManager.this.S.remove(liveGiftModel);
                    GiftAnimManager.this.o();
                    GiftAnimManager.this.V.removeCallbacks(GiftAnimManager.this.L);
                    GiftAnimManager.this.V.postDelayed(GiftAnimManager.this.L, GiftAnimManager.this.g(liveGiftModel));
                }
            }, 200L);
            if (liveGiftModel.hit_count > 0) {
                this.F.setVisibility(0);
            } else {
                this.F.setVisibility(8);
            }
            this.h.setVisibility(0);
            TextView textView = this.D;
            textView.setText(liveGiftModel.hit_count + "");
            ScaleAnimation scaleAnimation = new ScaleAnimation(2.0f, 0.5f, 2.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(250L);
            final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(100L);
            scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.manager.GiftAnimManager.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    GiftAnimManager.this.F.startAnimation(scaleAnimation2);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.manager.GiftAnimManager.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.F.startAnimation(scaleAnimation);
        }
    }

    public void a() {
        f13570c = "";
        d = 0L;
    }

    public void a(int i) {
        LinearLayout linearLayout = this.f;
        if (linearLayout != null) {
            linearLayout.setVisibility(i);
        }
    }

    public void a(LiveMsgManager liveMsgManager, LinearLayout linearLayout, ActivityFragmentActive activityFragmentActive) {
        if (this.f == null) {
            start();
        }
        this.I = liveMsgManager;
        this.f = linearLayout;
        this.J = activityFragmentActive;
        this.g = linearLayout.findViewById(R.id.ll_gift_ani_c1);
        this.h = this.f.findViewById(R.id.ll_gift_ani_c2);
        this.q = (MarqueeTextView) this.g.findViewById(R.id.tv_from_gift_nickname);
        this.r = (MarqueeTextView) this.h.findViewById(R.id.tv_from_gift_nickname);
        this.i = (ImageView) this.g.findViewById(R.id.msg_noble_level);
        this.j = (ImageView) this.h.findViewById(R.id.msg_noble_level);
        this.k = (ImageView) this.g.findViewById(R.id.msg_user_level);
        this.l = (ImageView) this.h.findViewById(R.id.msg_user_level);
        this.o = (TextView) this.g.findViewById(R.id.tv_congratulations);
        this.p = (TextView) this.h.findViewById(R.id.tv_congratulations);
        this.m = (TextView) this.g.findViewById(R.id.live_msg_send_gift_name);
        this.n = (TextView) this.h.findViewById(R.id.live_msg_send_gift_name);
        this.s = (ImageView) this.g.findViewById(R.id.from_gift_avatar);
        this.t = (ImageView) this.h.findViewById(R.id.from_gift_avatar);
        this.u = (ImageView) this.g.findViewById(R.id.from_gift_avatar_frame);
        this.v = (ImageView) this.h.findViewById(R.id.from_gift_avatar_frame);
        this.w = (ImageView) this.g.findViewById(R.id.iv_gift_bg);
        this.x = (ImageView) this.h.findViewById(R.id.iv_gift_bg);
        this.y = (ShapeRelativeLayout) this.g.findViewById(R.id.srl_gift_bg);
        this.z = (ShapeRelativeLayout) this.h.findViewById(R.id.srl_gift_bg);
        this.A = (ImageView) this.g.findViewById(R.id.from_gift_url);
        this.B = (ImageView) this.h.findViewById(R.id.from_gift_url);
        this.C = (TextView) this.g.findViewById(R.id.hit_count_view);
        this.D = (TextView) this.h.findViewById(R.id.hit_count_view);
        this.E = (LinearLayout) this.g.findViewById(R.id.hit_layout);
        this.F = (LinearLayout) this.h.findViewById(R.id.hit_layout);
        LoadOptions loadOptions = new LoadOptions();
        this.G = loadOptions;
        loadOptions.b = R.drawable.user_bg_round;
        this.G.d = R.drawable.user_bg_round;
        this.G.a(AppMethods.a(40), AppMethods.a(40));
        LoadOptions loadOptions2 = new LoadOptions();
        this.H = loadOptions2;
        loadOptions2.d = R.drawable.gift_default_icon;
        this.H.b = R.drawable.gift_default_icon;
        this.H.l = false;
        this.H.a(AppMethods.a(60), AppMethods.a(60));
        this.f13571a = true;
        this.b = true;
    }

    public void a(LiveChattingModel liveChattingModel) {
        LiveMsgManager liveMsgManager = this.I;
        if ((liveMsgManager == null || liveMsgManager.x == PlayingOnliveFragment.cB) && !AppInfo.g() && this.O.size() <= 100) {
            this.O.add(liveChattingModel);
            synchronized (this) {
                notify();
            }
        }
    }

    public void a(LiveChattingModel liveChattingModel, int i) {
        Message obtainMessage = this.V.obtainMessage();
        obtainMessage.obj = liveChattingModel;
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    public void a(LiveGiftModel liveGiftModel) {
        if (this.P.remove(liveGiftModel) || this.P.size() <= 0) {
            return;
        }
        this.P.remove(0);
    }

    public List<LiveGiftModel> b() {
        return this.P;
    }

    public void b(LiveChattingModel liveChattingModel) {
        LiveMsgManager liveMsgManager = this.I;
        if ((liveMsgManager == null || liveMsgManager.x == PlayingOnliveFragment.cB) && !AppInfo.g()) {
            this.O.add(0, liveChattingModel);
            synchronized (this) {
                notify();
            }
        }
    }

    public void b(LiveGiftModel liveGiftModel) {
        int i;
        if (liveGiftModel == null) {
            return;
        }
        Log.i("==xpm", "removeARTask :" + liveGiftModel.resource_url + " goods id:" + liveGiftModel.goods_id);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = -1;
            if (i3 >= this.Q.size()) {
                break;
            } else if (TextUtils.equals(this.Q.get(i3).resource_url, liveGiftModel.resource_url)) {
                i = i3;
                break;
            } else {
                i2 = i3 + 1;
            }
        }
        if (i >= 0 && i < this.Q.size()) {
            this.Q.remove(i);
        } else if (this.Q.remove(liveGiftModel) || this.Q.size() <= 0) {
        } else {
            this.Q.remove(0);
        }
    }

    public List<LiveGiftModel> c() {
        return this.Q;
    }

    public void c(LiveGiftModel liveGiftModel) {
        this.P.add(0, liveGiftModel);
        PlayGifObserver.a().b();
    }

    public boolean c(LiveChattingModel liveChattingModel) {
        LiveChattingModel liveChattingModel2 = liveChattingModel;
        if (liveChattingModel == null) {
            try {
                liveChattingModel2 = k();
            } catch (Exception e) {
                return false;
            }
        }
        if (liveChattingModel2.msgMapExtra.containsKey("isNobleUpgrade") && (liveChattingModel2.msgMapExtra.get("isNobleUpgrade") instanceof Boolean)) {
            return false;
        }
        LiveGiftModel liveGiftModel = null;
        if (liveChattingModel2.msgMapExtra != null) {
            Object obj = liveChattingModel2.msgMapExtra.get("gift_model");
            if (obj instanceof LiveGiftModel) {
                liveGiftModel = (LiveGiftModel) obj;
            }
            if (liveGiftModel == null) {
                return false;
            }
            if (this.M == null || liveGiftModel.hit_id == 0 || this.M.hit_id != liveGiftModel.hit_id) {
                if (this.N == null || liveGiftModel.hit_id == 0) {
                    return false;
                }
                return this.N.hit_id == liveGiftModel.hit_id;
            }
            return true;
        }
        return false;
    }

    public void d() {
        synchronized (this) {
            notify();
        }
    }

    public void d(LiveGiftModel liveGiftModel) {
        LiveMsgManager liveMsgManager = this.I;
        if (liveMsgManager != null && (liveMsgManager.d instanceof RecordingOnliveFragment)) {
            this.Q.add(liveGiftModel);
            PlayARObserver.a().b();
        }
    }

    public void e() {
        synchronized (this) {
            notify();
        }
        this.f13571a = true;
        this.b = true;
        this.T = false;
        this.U = false;
        this.O.clear();
        this.P.clear();
        this.Q.clear();
        this.R.clear();
        this.S.clear();
        g();
        a();
        this.V.removeCallbacksAndMessages(null);
        m();
        this.I = null;
        this.J = null;
    }

    public void e(LiveGiftModel liveGiftModel) {
        LiveMsgManager liveMsgManager = this.I;
        if (liveMsgManager != null && (liveMsgManager.d instanceof RecordingOnliveFragment)) {
            this.Q.add(0, liveGiftModel);
            PlayARObserver.a().b();
        }
    }

    public void f() {
        synchronized (this) {
            notify();
        }
        this.g.setVisibility(4);
        this.h.setVisibility(4);
        this.f13571a = true;
        this.b = true;
        this.T = false;
        this.U = false;
        this.O.clear();
        this.P.clear();
        this.Q.clear();
        this.R.clear();
        this.S.clear();
        this.V.removeCallbacksAndMessages(null);
        m();
        a();
    }

    public void g() {
        this.e = true;
        synchronized (this) {
            notify();
        }
    }

    public void h() {
        LiveMsgManager liveMsgManager = this.I;
        if (liveMsgManager != null && (liveMsgManager.d instanceof RecordingOnliveFragment)) {
            ArrayList arrayList = new ArrayList();
            for (LiveGiftModel liveGiftModel : this.P) {
                if (!liveGiftModel.is_opponent) {
                    arrayList.add(liveGiftModel);
                }
            }
            this.P.clear();
            this.P.addAll(arrayList);
            ArrayList arrayList2 = new ArrayList();
            for (LiveGiftModel liveGiftModel2 : this.Q) {
                if (!liveGiftModel2.is_opponent) {
                    arrayList2.add(liveGiftModel2);
                }
            }
            this.Q.clear();
            this.Q.addAll(arrayList2);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.e) {
            if (Boolean.valueOf(l()).booleanValue()) {
                while (!this.f13571a && !this.b && !this.e && !c((LiveChattingModel) null)) {
                    try {
                        synchronized (this) {
                            LogUtils.c("等待任务 wait -----");
                            wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                LiveChattingModel j = j();
                if (c(j)) {
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    a(j, 3);
                    LogUtils.c("发送相同任务消息");
                } else if (this.f13571a) {
                    this.f13571a = false;
                    a(j, 1);
                    LogUtils.c("开始弹道一任务");
                } else if (this.b) {
                    this.b = false;
                    a(j, 2);
                    LogUtils.c("开始弹道二任务");
                }
            } else {
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                    return;
                }
            }
        }
    }
}
