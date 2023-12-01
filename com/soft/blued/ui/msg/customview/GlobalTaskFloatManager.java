package com.soft.blued.ui.msg.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.live.activity.SendFeedDialogActivity;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.Logger;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/customview/GlobalTaskFloatManager.class */
public class GlobalTaskFloatManager {

    /* renamed from: a  reason: collision with root package name */
    public static volatile GlobalTaskFloatManager f32280a;
    private static final String b = GlobalTaskFloatManager.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private ViewHolder f32281c;
    private WindowManager.LayoutParams d;
    private WindowManager e;
    private TaskInfo f;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private int r;
    private int s;
    private ValueAnimator t;
    private String u;
    private Timer v;
    private boolean x;
    private boolean g = true;
    private boolean h = false;
    private float o = 0.0f;
    private float p = 0.0f;
    private int q = b();
    private int w = 1000;
    private int y = DensityUtil.a(8.0f);

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/customview/GlobalTaskFloatManager$TaskInfo.class */
    public static class TaskInfo {
        public String back_url;
        public int max;
        public int progress;
        public int task_id;
        public String task_name;

        public String toString() {
            return "TaskInfo{task_name='" + this.task_name + "', task_id=" + this.task_id + ", max=" + this.max + ", progress=" + this.progress + ", back_url='" + this.back_url + "'}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/customview/GlobalTaskFloatManager$ViewHolder.class */
    public static class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f32297a;
        public View b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f32298c;
        public ProgressBar d;
        public TextView e;
        public TextView f;
        public ImageView g;

        ViewHolder() {
        }
    }

    private GlobalTaskFloatManager() {
        a(AppInfo.d());
        LiveEventBus.get("live_open_close", Boolean.class).observeForever(new Observer<Boolean>() { // from class: com.soft.blued.ui.msg.customview.GlobalTaskFloatManager.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                if (bool.booleanValue()) {
                    GlobalTaskFloatManager.this.b(26);
                } else {
                    GlobalTaskFloatManager.this.a(26);
                }
            }
        });
    }

    public static GlobalTaskFloatManager a() {
        if (f32280a == null) {
            synchronized (GlobalTaskFloatManager.class) {
                try {
                    if (f32280a == null) {
                        f32280a = new GlobalTaskFloatManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f32280a;
    }

    private void a(Context context) {
        try {
            this.d = new WindowManager.LayoutParams();
            this.e = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Logger.b("ddrb", "sdk api version:", Integer.valueOf(Build.VERSION.SDK_INT));
            if (Build.VERSION.SDK_INT >= 26) {
                this.d.type = 2038;
            } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 23) {
                this.d.type = 2003;
            } else {
                this.d.type = 2005;
            }
            this.d.format = 1;
            this.d.flags = 8;
            this.d.gravity = 51;
            this.d.width = -2;
            this.d.height = -2;
            g();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ int b(GlobalTaskFloatManager globalTaskFloatManager, int i) {
        int i2 = globalTaskFloatManager.w - i;
        globalTaskFloatManager.w = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i) {
        TaskInfo taskInfo;
        if (this.f32281c == null || (taskInfo = this.f) == null || i != taskInfo.task_id) {
            return;
        }
        if (this.v == null) {
            this.v = new Timer();
        }
        this.v.schedule(new TimerTask() { // from class: com.soft.blued.ui.msg.customview.GlobalTaskFloatManager.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.customview.GlobalTaskFloatManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GlobalTaskFloatManager.this.x || GlobalTaskFloatManager.this.f32281c == null || GlobalTaskFloatManager.this.v == null) {
                            return;
                        }
                        GlobalTaskFloatManager.b(GlobalTaskFloatManager.this, 100);
                        String str = GlobalTaskFloatManager.b;
                        Logger.c(str, "second====" + GlobalTaskFloatManager.this.w);
                        GlobalTaskFloatManager.this.f32281c.d.setProgress((int) ((1.0f - (((float) ((GlobalTaskFloatManager.this.f.progress * 1000) + GlobalTaskFloatManager.this.w)) / ((float) (GlobalTaskFloatManager.this.f.max * 1000)))) * 1000.0f));
                        String str2 = GlobalTaskFloatManager.b;
                        Logger.c(str2, "progress====" + GlobalTaskFloatManager.this.f32281c.d.getProgress());
                        if (GlobalTaskFloatManager.this.w == 0) {
                            TextView textView = GlobalTaskFloatManager.this.f32281c.f32297a;
                            StringBuilder sb = new StringBuilder();
                            TaskInfo taskInfo2 = GlobalTaskFloatManager.this.f;
                            int i2 = taskInfo2.progress;
                            taskInfo2.progress = i2 - 1;
                            sb.append(i2);
                            sb.append("s");
                            textView.setText(sb.toString());
                            GlobalTaskFloatManager.this.w = 1000;
                        }
                        if (GlobalTaskFloatManager.this.f == null || GlobalTaskFloatManager.this.f.progress != -1) {
                            return;
                        }
                        GlobalTaskFloatManager.this.a(i);
                        if (GlobalTaskFloatManager.this.f32281c != null) {
                            GlobalTaskFloatManager.this.f32281c.f32297a.setVisibility(8);
                            GlobalTaskFloatManager.this.f32281c.e.setText(AppInfo.d().getString(R.string.task_completed));
                            GlobalTaskFloatManager.this.f32281c.f.setVisibility(0);
                        }
                        ChatHttpUtils.a(new BluedUIHttpResponse<BluedEntityA>(null) { // from class: com.soft.blued.ui.msg.customview.GlobalTaskFloatManager.2.1.1
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.blued.android.framework.http.BluedUIHttpResponse
                            /* renamed from: a */
                            public void onUIUpdate(BluedEntityA bluedEntityA) {
                            }
                        }, GlobalTaskFloatManager.this.f.max);
                    }
                });
            }
        }, 1000L, 100L);
    }

    static /* synthetic */ float g(GlobalTaskFloatManager globalTaskFloatManager, float f) {
        float f2 = globalTaskFloatManager.m + f;
        globalTaskFloatManager.m = f2;
        return f2;
    }

    private void g() {
        try {
            Point point = new Point();
            ((WindowManager) AppInfo.d().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSize(point);
            this.r = point.x;
            this.s = point.y;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ float h(GlobalTaskFloatManager globalTaskFloatManager, float f) {
        float f2 = globalTaskFloatManager.n + f;
        globalTaskFloatManager.n = f2;
        return f2;
    }

    private void h() {
        if (this.f32281c != null) {
            if (!TextUtils.isEmpty(this.f.task_name)) {
                this.f32281c.e.setText(this.f.task_name);
            }
            if (this.f.task_id == 26) {
                this.f32281c.d.setProgress((int) ((1.0f - (((this.f.progress * 1000) + this.w) / (this.f.max * 1000))) * 1000.0f));
                TextView textView = this.f32281c.f32297a;
                textView.setText(this.f.progress + "s");
                if (LiveFloatManager.a().x()) {
                    b(26);
                    return;
                }
                return;
            }
            this.f32281c.f32297a.setVisibility(this.f.progress == this.f.max ? 8 : 0);
            TextView textView2 = this.f32281c.f32297a;
            textView2.setText("(" + this.f.progress + BridgeUtil.SPLIT_MARK + this.f.max + ")");
            int floatValue = (int) ((((float) this.f.progress) / Float.valueOf((float) this.f.max).floatValue()) * 1000.0f);
            ValueAnimator valueAnimator = this.t;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.t.cancel();
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(this.f32281c.d.getProgress(), floatValue);
            this.t = ofInt;
            ofInt.setDuration(1000L);
            this.t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.msg.customview.GlobalTaskFloatManager.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    if (GlobalTaskFloatManager.this.f32281c != null) {
                        GlobalTaskFloatManager.this.f32281c.d.setProgress(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                    }
                }
            });
            if (i()) {
                this.t.addListener(new AnimatorListenerAdapter() { // from class: com.soft.blued.ui.msg.customview.GlobalTaskFloatManager.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (GlobalTaskFloatManager.this.f32281c != null) {
                            GlobalTaskFloatManager.this.f32281c.e.setText(AppInfo.d().getString(R.string.task_completed));
                            GlobalTaskFloatManager.this.f32281c.f.setVisibility(0);
                        }
                    }
                });
            }
            this.t.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        TaskInfo taskInfo = this.f;
        if (taskInfo != null && taskInfo.task_id == 26 && this.f.progress == -1) {
            return true;
        }
        TaskInfo taskInfo2 = this.f;
        return taskInfo2 != null && taskInfo2.progress == this.f.max;
    }

    private void j() {
        ViewHolder viewHolder = new ViewHolder();
        this.f32281c = viewHolder;
        viewHolder.b = View.inflate(AppInfo.d(), R.layout.global_pop_task_progress, null);
        ViewHolder viewHolder2 = this.f32281c;
        viewHolder2.d = (ProgressBar) viewHolder2.b.findViewById(2131368973);
        ViewHolder viewHolder3 = this.f32281c;
        viewHolder3.f32298c = (ImageView) viewHolder3.b.findViewById(2131365051);
        ViewHolder viewHolder4 = this.f32281c;
        viewHolder4.e = (TextView) viewHolder4.b.findViewById(2131371675);
        ViewHolder viewHolder5 = this.f32281c;
        viewHolder5.f = (TextView) viewHolder5.b.findViewById(R.id.tv_back);
        ViewHolder viewHolder6 = this.f32281c;
        viewHolder6.f32297a = (TextView) viewHolder6.b.findViewById(2131372318);
        ViewHolder viewHolder7 = this.f32281c;
        viewHolder7.g = (ImageView) viewHolder7.b.findViewById(2131365207);
        this.f32281c.f.setVisibility(8);
        this.f32281c.d.setMax(1000);
        this.f32281c.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.customview.GlobalTaskFloatManager.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (GlobalTaskFloatManager.this.i()) {
                    if (GlobalTaskFloatManager.this.f != null && GlobalTaskFloatManager.this.f.task_id == 26) {
                        LiveRefreshUIObserver.a().b(true);
                    }
                    GlobalTaskFloatManager.this.a(true);
                }
            }
        });
        this.f32281c.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.customview.GlobalTaskFloatManager.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GlobalTaskFloatManager.this.a(26);
                GlobalTaskFloatManager.this.a(false);
            }
        });
        this.f32281c.b.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.msg.customview.GlobalTaskFloatManager.7
            /* JADX WARN: Removed duplicated region for block: B:109:0x055c A[Catch: Exception -> 0x05ae, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x05ae, blocks: (B:2:0x0000, B:11:0x001c, B:16:0x007a, B:26:0x00d9, B:31:0x00f4, B:41:0x015a, B:43:0x0182, B:45:0x01a9, B:47:0x01bb, B:49:0x01cc, B:51:0x01f4, B:53:0x021b, B:55:0x0235, B:57:0x024e, B:59:0x0284, B:32:0x0101, B:34:0x0117, B:36:0x013b, B:39:0x014f, B:17:0x0087, B:19:0x0095, B:21:0x00b9, B:24:0x00cd, B:61:0x029a, B:63:0x02af, B:65:0x02c4, B:67:0x02ce, B:71:0x02da, B:73:0x0322, B:84:0x041e, B:95:0x04f0, B:97:0x051a, B:99:0x052f, B:74:0x034c, B:76:0x0360, B:78:0x037c, B:80:0x038e, B:81:0x03b0, B:82:0x03e8, B:101:0x053d, B:103:0x0543, B:109:0x055c, B:86:0x0433, B:88:0x0445, B:90:0x0491, B:92:0x04a3), top: B:120:0x0000, inners: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onTouch(final android.view.View r8, android.view.MotionEvent r9) {
                /*
                    Method dump skipped, instructions count: 1469
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.customview.GlobalTaskFloatManager.AnonymousClass7.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
    }

    public void a(int i) {
        TaskInfo taskInfo;
        if (this.f32281c == null || (taskInfo = this.f) == null || i != taskInfo.task_id) {
            return;
        }
        Timer timer = this.v;
        if (timer != null) {
            timer.cancel();
            this.v = null;
        }
        this.w = 1000;
    }

    public void a(TaskInfo taskInfo) {
        if (taskInfo == null || this.f == null || taskInfo.task_id != this.f.task_id || taskInfo.task_id == 26) {
            return;
        }
        this.f = taskInfo;
        h();
    }

    public void a(boolean z) {
        ViewHolder viewHolder = this.f32281c;
        if (viewHolder != null && viewHolder.b.getWindowToken() != null) {
            this.e.removeViewImmediate(this.f32281c.b);
            this.f32281c.f32298c.setImageBitmap(null);
        }
        if (z && !TextUtils.isEmpty(this.u) && UserInfo.getInstance().isLogin()) {
            WebViewShowInfoFragment.show(AppInfo.d(), this.u, -1);
        }
        this.f32281c = null;
        this.f = null;
    }

    public int b() {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            this.q = AppInfo.d().getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.q;
    }

    public void b(TaskInfo taskInfo) {
        TaskInfo taskInfo2 = this.f;
        if (taskInfo2 != null && taskInfo2.task_id == taskInfo.task_id && taskInfo.task_id == 26 && this.f.progress != 0) {
            taskInfo.progress = this.f.progress;
        }
        this.f = taskInfo;
        String str = b;
        Logger.c(str, "currentTaskInfo : " + this.f.toString());
        this.u = taskInfo.back_url;
        if (Build.VERSION.SDK_INT < 23) {
            c();
        } else if (Settings.canDrawOverlays(AppInfo.d())) {
            c();
        } else if (BluedApplicationLike.ifFeedFloatAuthShowed) {
        } else {
            BluedApplicationLike.ifFeedFloatAuthShowed = true;
            if (!AppUtils.a(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + AppInfo.d().getPackageManager())))) {
                AppMethods.d(2131889566);
                return;
            }
            Intent intent = new Intent(AppInfo.d(), SendFeedDialogActivity.class);
            intent.putExtra("type", 1);
            intent.putExtra("flag", 2);
            intent.addFlags(268435456);
            AppInfo.d().startActivity(intent);
        }
    }

    public void c() {
        if (this.f == null) {
            return;
        }
        this.g = true;
        if (this.f32281c == null) {
            j();
        }
        h();
        if (this.f32281c.b.getWindowToken() != null) {
            this.e.removeViewImmediate(this.f32281c.b);
        }
        this.d.x = DensityUtils.a(AppInfo.d(), 8.0f);
        this.d.y = DensityUtils.a(AppInfo.d(), 52.0f);
        try {
            this.e.addView(this.f32281c.b, this.d);
            ImageLoader.a((IRequestHost) null, (int) R.drawable.task_top_anim).b(R.drawable.icon_task_float_first).f().g(-1).a(this.f32281c.f32298c);
        } catch (Throwable th) {
        }
    }

    public void d() {
        ViewHolder viewHolder = this.f32281c;
        if (viewHolder == null || viewHolder.b == null) {
            return;
        }
        this.f32281c.b.setVisibility(4);
        this.x = true;
    }

    public void e() {
        ViewHolder viewHolder = this.f32281c;
        if (viewHolder == null || viewHolder.b == null) {
            return;
        }
        this.f32281c.b.setVisibility(0);
        this.x = false;
    }
}
