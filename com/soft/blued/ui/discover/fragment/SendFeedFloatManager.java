package com.soft.blued.ui.discover.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.CircleProgressView;
import com.blued.android.module.common.view.CubicInterpolator;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.send.manager.FeedSendManager;
import com.blued.community.ui.send.observer.FeedRefreshObserver;
import com.blued.community.ui.video.adapter.ShineVideoListAdapter;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.manager.SendNotificationManager;
import com.soft.blued.ui.community.fragment.AttentionFeedHomeFragment;
import com.soft.blued.ui.live.activity.SendFeedDialogActivity;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/fragment/SendFeedFloatManager.class */
public class SendFeedFloatManager implements FeedRefreshObserver.IFeedRefreshObserver {
    public static volatile SendFeedFloatManager i;

    /* renamed from: a  reason: collision with root package name */
    public Context f16120a;

    /* renamed from: c  reason: collision with root package name */
    public View f16121c;
    public int d;
    public CircleProgressView e;
    public TextView f;
    public TextView g;
    private WindowManager.LayoutParams j;
    private WindowManager k;
    public boolean b = false;
    Handler h = new Handler(Looper.getMainLooper());

    public static SendFeedFloatManager a() {
        if (i == null) {
            synchronized (SendFeedFloatManager.class) {
                try {
                    if (i == null) {
                        i = new SendFeedFloatManager();
                        i.a(AppInfo.d());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return i;
    }

    private void a(Object obj, final boolean z) {
        g();
        if (obj != null && (obj instanceof BluedIngSelfFeed)) {
            final BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) obj;
            if (bluedIngSelfFeed.is_bubble_ticktock == 1) {
                ToastUtils.a(z ? 2131888027 : 2131887995);
            } else {
                this.h.postDelayed(new Runnable() { // from class: com.soft.blued.ui.discover.fragment.-$$Lambda$SendFeedFloatManager$2TvbeMrWxGHq_e8gh9xovkeGwS0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SendFeedFloatManager.a(z, bluedIngSelfFeed);
                    }
                }, 100L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, BluedIngSelfFeed bluedIngSelfFeed) {
        if (z) {
            SendNotificationManager.a().b(bluedIngSelfFeed);
        } else {
            SendNotificationManager.a().a(bluedIngSelfFeed);
        }
    }

    private void h() {
        synchronized (this) {
            this.h.post(new Runnable() { // from class: com.soft.blued.ui.discover.fragment.SendFeedFloatManager.3
                @Override // java.lang.Runnable
                public void run() {
                    FeedRefreshObserver.a().a(SendFeedFloatManager.this);
                    SendFeedFloatManager.this.f16120a = AppInfo.d();
                    SendFeedFloatManager.this.f();
                    SendFeedFloatManager.this.f16121c = LayoutInflater.from(SendFeedFloatManager.this.f16120a).inflate(R.layout.layout_send_feed_float, (ViewGroup) null);
                    LinearLayout linearLayout = (LinearLayout) SendFeedFloatManager.this.f16121c.findViewById(R.id.ll_float);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                    int[] a2 = ShineVideoListAdapter.a(SendFeedFloatManager.this.f16120a);
                    layoutParams.width = (int) (a2[0] * 0.4d);
                    layoutParams.height = (int) (a2[1] * 0.4d);
                    linearLayout.setLayoutParams(layoutParams);
                    SendFeedFloatManager sendFeedFloatManager = SendFeedFloatManager.this;
                    sendFeedFloatManager.e = sendFeedFloatManager.f16121c.findViewById(R.id.pb_circle_progress);
                    SendFeedFloatManager.this.e.setValue(0.0f);
                    SendFeedFloatManager.this.e.setBarColor(new int[]{SendFeedFloatManager.this.f16120a.getResources().getColor(R.color.flash_video_yellow)});
                    SendFeedFloatManager.this.e.setRimWidth(DensityUtils.a(SendFeedFloatManager.this.f16120a, 2.5f));
                    SendFeedFloatManager.this.e.setRimColor(SendFeedFloatManager.this.f16120a.getResources().getColor(2131099824));
                    SendFeedFloatManager.this.e.setBarWidth(DensityUtils.a(SendFeedFloatManager.this.f16120a, 2.5f));
                    SendFeedFloatManager sendFeedFloatManager2 = SendFeedFloatManager.this;
                    sendFeedFloatManager2.f = (TextView) sendFeedFloatManager2.f16121c.findViewById(R.id.tv_progress);
                    SendFeedFloatManager sendFeedFloatManager3 = SendFeedFloatManager.this;
                    sendFeedFloatManager3.g = (TextView) sendFeedFloatManager3.f16121c.findViewById(R.id.tv_left_count);
                    SendFeedFloatManager.this.f16121c.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.discover.fragment.SendFeedFloatManager.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            SendFeedFloatManager.this.g();
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        try {
            if (this.b || AppInfo.g()) {
                return;
            }
            this.f16121c.setAlpha(1.0f);
            this.k.addView(this.f16121c, this.j);
            this.b = true;
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.setDuration(164L);
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(scaleAnimation);
            animationSet.setInterpolator(new CubicInterpolator(0.66f, 0.01f, 0.34f, 1.0f));
            this.f16121c.startAnimation(animationSet);
            this.e.setValue(0.0f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(Context context) {
        try {
            this.j = new WindowManager.LayoutParams();
            this.k = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Logger.b("ddrb", "sdk api version:", Integer.valueOf(Build.VERSION.SDK_INT));
            if (Build.VERSION.SDK_INT >= 26) {
                this.j.type = 2038;
            } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 23) {
                this.j.type = 2003;
            } else {
                this.j.type = 2005;
            }
            this.j.format = 1;
            this.j.flags = 8;
            this.j.gravity = 51;
            this.j.width = -2;
            this.j.height = -2;
            h();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public void a(Object obj) {
        BluedIngSelfFeed bluedIngSelfFeed;
        synchronized (this) {
            if ((obj instanceof BluedIngSelfFeed) && (bluedIngSelfFeed = (BluedIngSelfFeed) obj) != null && bluedIngSelfFeed.is_bubble_ticktock == 1) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23) {
                c();
            } else if (Settings.canDrawOverlays(AppInfo.d())) {
                c();
            } else if (!BluedApplicationLike.ifFeedFloatAuthShowed) {
                BluedApplicationLike.ifFeedFloatAuthShowed = true;
                if (AppUtils.a(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + AppInfo.d().getPackageManager())))) {
                    Intent intent = new Intent(AppInfo.d(), SendFeedDialogActivity.class);
                    intent.putExtra("flag", 2);
                    intent.addFlags(268435456);
                    AppInfo.d().startActivity(intent);
                } else {
                    b();
                    AppMethods.d((int) R.string.live_float_toast);
                }
            }
        }
    }

    public void a(Object obj, int i2) {
        if (obj != null) {
            if (obj instanceof BluedIngSelfFeed) {
                if (((BluedIngSelfFeed) obj).showNotificationWhenSend != 0) {
                    return;
                }
            } else if ((obj instanceof NewFeedModel) && ((NewFeedModel) obj).showNotificationWhenSend != 0) {
                return;
            }
        }
        if (i2 == 0) {
            a(obj, false);
        } else if (i2 == 1) {
            b(obj);
        } else if (i2 == 2) {
            a(obj, true);
        } else if (i2 == 3) {
            a(obj);
            b(obj);
        } else if (i2 != 4) {
        } else {
            g();
        }
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void b() {
        synchronized (this) {
        }
    }

    public void b(Object obj) {
        BluedIngSelfFeed bluedIngSelfFeed;
        if (((obj instanceof BluedIngSelfFeed) && (bluedIngSelfFeed = (BluedIngSelfFeed) obj) != null && bluedIngSelfFeed.is_bubble_ticktock == 1) || FeedSendManager.a() == null || FeedSendManager.a().d() == null || FeedSendManager.a().d().size() <= 0) {
            return;
        }
        int progress = ((NewFeedModel) FeedSendManager.a().d().get(0)).getProgress();
        this.e.setBarColor(new int[]{this.f16120a.getResources().getColor(R.color.flash_video_yellow)});
        this.e.a(progress, 200L);
        this.f.setText(progress + "%");
        int e = FeedSendManager.a().e() - FeedSendManager.a().h();
        int i2 = e;
        if (e < 1) {
            i2 = 1;
        }
        this.g.setText(String.format(this.f16120a.getResources().getString(R.string.left_to_send), i2 + ""));
    }

    public void c() {
        Fragment c2;
        synchronized (this) {
            Activity b = SendNotificationManager.a().b();
            if (b == null || (c2 = SendNotificationManager.a().c(b)) == null || !c2.getClass().getSimpleName().equalsIgnoreCase(AttentionFeedHomeFragment.class.getSimpleName())) {
                d();
                this.h.postDelayed(new Runnable() { // from class: com.soft.blued.ui.discover.fragment.SendFeedFloatManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SendFeedFloatManager.this.j.x = DensityUtils.a(AppInfo.d(), 8.0f);
                        SendFeedFloatManager.this.j.y = DensityUtils.a(AppInfo.d(), 52.0f);
                        if (SendFeedFloatManager.this.b) {
                            try {
                                SendFeedFloatManager.this.k.updateViewLayout(SendFeedFloatManager.this.f16121c, SendFeedFloatManager.this.j);
                            } catch (Exception e) {
                            }
                        }
                    }
                }, 300L);
                if (BluedPreferences.bl() == 0 && LiveFloatManager.U() && !LiveFloatManager.a(AppInfo.d())) {
                    Intent intent = new Intent(AppInfo.d(), SendFeedDialogActivity.class);
                    intent.putExtra("flag", 1);
                    intent.addFlags(268435456);
                    AppInfo.d().startActivity(intent);
                    BluedPreferences.j(1);
                }
            }
        }
    }

    public void d() {
        synchronized (this) {
            this.h.post(new Runnable() { // from class: com.soft.blued.ui.discover.fragment.-$$Lambda$SendFeedFloatManager$advkDGu0AvidkoIOQlpnRGGddns
                @Override // java.lang.Runnable
                public final void run() {
                    SendFeedFloatManager.this.i();
                }
            });
        }
    }

    public void e() {
        synchronized (this) {
            this.h.post(new Runnable() { // from class: com.soft.blued.ui.discover.fragment.SendFeedFloatManager.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (SendFeedFloatManager.this.b) {
                            SendFeedFloatManager.this.k.removeView(SendFeedFloatManager.this.f16121c);
                            SendFeedFloatManager.this.b = false;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public int f() {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            this.d = AppInfo.d().getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.d;
    }

    public void g() {
        synchronized (this) {
            e();
            b();
        }
    }
}
