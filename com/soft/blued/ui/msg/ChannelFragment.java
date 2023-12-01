package com.soft.blued.ui.msg;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.chat.VideoChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.bytedance.applog.tracker.Tracker;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.soft.blued.R;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.msg.manager.ChannelManager;
import com.soft.blued.ui.msg.model.ChannelModel;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.utils.Logger;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ChannelFragment.class */
public class ChannelFragment extends BaseFragment implements View.OnClickListener, Chronometer.OnChronometerTickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final String f17971a = ChannelFragment.class.getSimpleName();
    private LinearLayout A;
    private LinearLayout B;
    private LinearLayout C;
    private LinearLayout D;
    private ImageView E;
    private ImageView F;
    private RelativeLayout G;
    private RelativeLayout H;
    private ImageView I;
    private TextView J;
    private TextView K;
    private ImageView L;
    private TextView M;
    private ImageView N;
    private TextView O;
    private RelativeLayout P;
    private ImageView Q;
    private ImageView R;
    private TextView S;
    private ImageView T;
    private ChannelManager U;
    private View V;
    private boolean W;
    private boolean Z;
    private CustomDialog aa;
    private boolean ab;
    public FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f17972c;
    ChannelModel d;
    private Context k;
    private RelativeLayout l;
    private RelativeLayout m;
    private ImageView n;
    private RelativeLayout o;
    private ImageView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private RelativeLayout v;
    private View w;
    private Chronometer x;
    private TextView y;
    private LinearLayout z;
    public long e = 0;
    private long X = -1;
    private int Y = -1;
    private String ac = "";
    private String ad = "";
    Runnable f = new Runnable() { // from class: com.soft.blued.ui.msg.ChannelFragment.9
        @Override // java.lang.Runnable
        public void run() {
            if (ChannelFragment.this.e <= 0 || ChannelFragment.this.U == null || ChannelFragment.this.U.f18699a == null || ChannelFragment.this.U.f18699a.isDestroyed()) {
                return;
            }
            ChannelFragment.this.U.f18699a.updateCallTime((int) ChannelFragment.this.e);
            ChannelFragment.this.q();
            Logger.b(ChannelFragment.f17971a, "mTimer:", Long.valueOf(ChannelFragment.this.e));
        }
    };
    Runnable g = new Runnable() { // from class: com.soft.blued.ui.msg.ChannelFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (ChannelFragment.this.W) {
                return;
            }
            ChannelFragment.this.a(true);
        }
    };
    Runnable h = new Runnable() { // from class: com.soft.blued.ui.msg.ChannelFragment.11
        @Override // java.lang.Runnable
        public void run() {
            if (ChannelFragment.this.W) {
                return;
            }
            ChannelFragment.this.a(false);
        }
    };
    Runnable i = new Runnable() { // from class: com.soft.blued.ui.msg.ChannelFragment.12
        @Override // java.lang.Runnable
        public void run() {
            if (ChannelFragment.this.d.callType == 4) {
                ChannelFragment.this.w.setVisibility(8);
                ChannelFragment.this.x.setTextColor(Color.parseColor("#00ffffff"));
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setFillAfter(false);
                alphaAnimation.setDuration(500L);
                ChannelFragment.this.w.setAnimation(alphaAnimation);
                alphaAnimation.start();
            }
        }
    };
    Runnable j = new Runnable() { // from class: com.soft.blued.ui.msg.ChannelFragment.13
        @Override // java.lang.Runnable
        public void run() {
            if (ChannelFragment.this.W) {
                return;
            }
            ChannelFragment.this.a(false);
        }
    };

    /* renamed from: com.soft.blued.ui.msg.ChannelFragment$3  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ChannelFragment$3.class */
    class AnonymousClass3 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChannelFragment f17982a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            SurfaceView surfaceView = (SurfaceView) this.f17982a.f17972c.getChildAt(0);
            SurfaceView surfaceView2 = (SurfaceView) ((ViewGroup) view).getChildAt(0);
            int width = surfaceView.getWidth();
            int height = surfaceView.getHeight();
            int width2 = surfaceView2.getWidth();
            int height2 = surfaceView2.getHeight();
            if (surfaceView != null) {
                this.f17982a.a(surfaceView2, width, height);
                this.f17982a.a(surfaceView, width2, height2);
                SurfaceView a2 = this.f17982a.a(surfaceView2);
                this.f17982a.b.addView(this.f17982a.a(surfaceView));
                this.f17982a.f17972c.addView(a2);
                surfaceView.setZOrderOnTop(true);
                surfaceView.setZOrderMediaOverlay(true);
                surfaceView2.setZOrderOnTop(false);
                surfaceView2.setZOrderMediaOverlay(false);
            }
        }
    }

    public static void a(final Context context, final ChannelModel channelModel) {
        synchronized (ChannelFragment.class) {
            try {
                if (channelModel.callType != 0 && 2 != channelModel.callType) {
                    PermissionUtils.d(new PermissionCallbacks() { // from class: com.soft.blued.ui.msg.ChannelFragment.2
                        public void U_() {
                            ChannelFragment.c(Context.this, channelModel);
                        }

                        public void a(String[] strArr) {
                        }
                    });
                }
                PermissionUtils.g(new PermissionCallbacks() { // from class: com.soft.blued.ui.msg.ChannelFragment.1
                    public void U_() {
                        ChannelFragment.c(Context.this, channelModel);
                    }

                    public void a(String[] strArr) {
                    }
                });
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, ChannelModel channelModel) {
        if (!AppMethods.c(16)) {
            AppMethods.a(AppInfo.d().getResources().getString(R.string.msg_channel_un_userable));
        } else if (channelModel == null) {
        } else {
            LiveFloatManager.a().m();
            Bundle bundle = new Bundle();
            if (channelModel.callType == 0 || channelModel.callType == 1) {
                channelModel.channelId = (System.currentTimeMillis() / 1000) + "_" + EncryptTool.b(UserInfo.getInstance().getLoginUserInfo().getUid());
            }
            Logger.b(f17971a, "channelId:", channelModel.channelId, "remoteUid:", Integer.valueOf(channelModel.remoteUid));
            bundle.putSerializable("CHANNEL", channelModel);
            TerminalActivity.a(bundle);
            TerminalActivity.b(bundle);
            TerminalActivity.d(context, ChannelFragment.class, bundle);
        }
    }

    private void g() {
        getActivity().getWindow().addFlags(128);
        ChannelModel channelModel = (ChannelModel) getArguments().getSerializable("CHANNEL");
        this.d = channelModel;
        if (channelModel == null) {
            this.d = new ChannelModel();
        }
        this.Z = this.d.callType == 0 || this.d.callType == 1;
        ChannelModel channelModel2 = this.d;
        if (channelModel2 != null && channelModel2.callType == 2 && this.d.has_screenshot == 1) {
            ToastUtils.a(getString(R.string.msg_screenshot_hint));
        }
    }

    private void h() {
        this.b = (FrameLayout) this.V.findViewById(R.id.user_local_view);
        FrameLayout frameLayout = (FrameLayout) this.V.findViewById(R.id.user_remote_views);
        this.f17972c = frameLayout;
        frameLayout.setOnClickListener(this);
        this.l = (RelativeLayout) this.V.findViewById(R.id.remote_bg_lay);
        this.m = (RelativeLayout) this.V.findViewById(R.id.remote_header_bg_lay);
        this.n = (ImageView) this.V.findViewById(R.id.remote_header_bg);
        this.o = (RelativeLayout) this.V.findViewById(R.id.header_lay);
        this.p = (ImageView) this.V.findViewById(2131364232);
        this.q = (TextView) this.V.findViewById(R.id.remote_user_name);
        this.r = (TextView) this.V.findViewById(R.id.remote_connect_state);
        this.s = (TextView) this.V.findViewById(R.id.tip);
        this.t = (TextView) this.V.findViewById(R.id.user_remote_time_left);
        this.u = (TextView) this.V.findViewById(R.id.remote_time_left);
        this.v = (RelativeLayout) this.V.findViewById(R.id.channel_lay);
        this.w = this.V.findViewById(R.id.bottom_lay);
        this.x = (Chronometer) this.V.findViewById(2131362855);
        this.y = (TextView) this.V.findViewById(R.id.switch_to_voice_tv);
        this.z = (LinearLayout) this.V.findViewById(R.id.channel_mute_lay);
        this.A = (LinearLayout) this.V.findViewById(R.id.channel_voice_lay);
        this.B = (LinearLayout) this.V.findViewById(R.id.channel_hold_lay);
        this.C = (LinearLayout) this.V.findViewById(R.id.channel_camera_lay);
        this.D = (LinearLayout) this.V.findViewById(R.id.channel_speak_lay);
        this.E = (ImageView) this.V.findViewById(R.id.channel_muter);
        this.F = (ImageView) this.V.findViewById(R.id.channel_speak);
        this.G = (RelativeLayout) this.V.findViewById(R.id.launch_lay);
        this.H = (RelativeLayout) this.V.findViewById(R.id.launch_video_header_lay);
        this.I = (ImageView) this.V.findViewById(R.id.launch_video_header_view);
        this.J = (TextView) this.V.findViewById(R.id.launch_video_user_name);
        this.K = (TextView) this.V.findViewById(R.id.launch_video_connect_state);
        this.L = (ImageView) this.V.findViewById(R.id.launch_switch_voice);
        this.M = (TextView) this.V.findViewById(R.id.voice_tv);
        this.N = (ImageView) this.V.findViewById(R.id.launch_hold_off);
        this.O = (TextView) this.V.findViewById(R.id.launch_time_left);
        this.P = (RelativeLayout) this.V.findViewById(R.id.accept_lay);
        this.Q = (ImageView) this.V.findViewById(R.id.accept_hold_off);
        this.R = (ImageView) this.V.findViewById(R.id.accept_switch_voice);
        this.S = (TextView) this.V.findViewById(R.id.accept_voice_tv);
        this.T = (ImageView) this.V.findViewById(R.id.accept_hold);
        this.z.setTag(false);
        this.D.setTag(true);
        this.b.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        i();
        this.E.setSelected(false);
        this.F.setSelected(true);
        this.x.setText("00:00");
        this.x.setOnChronometerTickListener(this);
        AppInfo.n().postDelayed(this.g, 30000L);
        p();
        ChannelManager channelManager = new ChannelManager(this, this.d);
        this.U = channelManager;
        channelManager.a(false);
        int i = this.d.callType;
        if (i == 0) {
            if (NetworkUtils.a()) {
                a(getString(R.string.channel_wifi_tip), 1);
            } else {
                this.U.call();
            }
        } else if (i == 1) {
            this.U.call();
        } else if (i == 2 && NetworkUtils.a()) {
            a(getString(R.string.channel_wifi_tip), 1);
        }
    }

    private void i() {
        Logger.b(f17971a, "mChannelModel type:", Integer.valueOf(this.d.callType));
        int i = this.d.callType;
        if (i == 0) {
            j();
        } else if (i == 1) {
            k();
        } else if (i == 2) {
            l();
        } else if (i == 3) {
            m();
        } else if (i == 4) {
            n();
        } else if (i != 5) {
        } else {
            o();
        }
    }

    private void j() {
        this.b.setVisibility(0);
        this.f17972c.setVisibility(0);
        this.l.setVisibility(8);
        this.t.setVisibility(8);
        this.u.setVisibility(8);
        this.v.setVisibility(8);
        this.G.setVisibility(0);
        this.H.setVisibility(0);
        this.L.setVisibility(0);
        this.M.setVisibility(0);
        this.O.setVisibility(0);
        this.P.setVisibility(8);
    }

    private void k() {
        this.b.setVisibility(8);
        this.f17972c.setVisibility(8);
        this.l.setVisibility(0);
        this.o.setVisibility(0);
        this.t.setVisibility(8);
        this.u.setVisibility(0);
        this.v.setVisibility(8);
        this.G.setVisibility(0);
        this.H.setVisibility(8);
        this.L.setVisibility(8);
        this.M.setVisibility(8);
        this.O.setVisibility(8);
        this.P.setVisibility(8);
    }

    private void l() {
        this.b.setVisibility(8);
        this.f17972c.setVisibility(8);
        this.l.setVisibility(0);
        this.o.setVisibility(0);
        this.r.setText(this.k.getResources().getString(R.string.channel_invite_video_tip));
        this.t.setVisibility(8);
        this.u.setVisibility(0);
        this.v.setVisibility(8);
        this.G.setVisibility(8);
        this.O.setVisibility(8);
        this.P.setVisibility(0);
        this.S.setVisibility(0);
        this.R.setVisibility(0);
    }

    private void m() {
        this.b.setVisibility(8);
        this.f17972c.setVisibility(8);
        this.l.setVisibility(0);
        this.o.setVisibility(0);
        this.r.setText(this.k.getResources().getString(R.string.channel_invite_voice_tip));
        this.t.setVisibility(8);
        this.u.setVisibility(0);
        this.v.setVisibility(8);
        this.G.setVisibility(8);
        this.O.setVisibility(8);
        this.P.setVisibility(0);
        this.S.setVisibility(8);
        this.R.setVisibility(8);
    }

    private void n() {
        this.b.setVisibility(0);
        this.f17972c.setVisibility(0);
        this.l.setVisibility(8);
        this.o.setVisibility(8);
        this.r.setVisibility(8);
        this.t.setVisibility(0);
        this.u.setVisibility(8);
        this.v.setVisibility(0);
        this.A.setVisibility(0);
        this.B.setVisibility(0);
        this.C.setVisibility(0);
        this.D.setVisibility(8);
        this.z.setVisibility(8);
        this.G.setVisibility(8);
        this.O.setVisibility(8);
        this.P.setVisibility(8);
        this.x.setTextColor(Color.parseColor("#ffffff"));
        this.v.postDelayed(this.i, 5000L);
    }

    private void o() {
        this.b.setVisibility(8);
        this.f17972c.setVisibility(8);
        this.l.setVisibility(0);
        this.o.setVisibility(0);
        this.r.setVisibility(8);
        this.t.setVisibility(0);
        this.u.setVisibility(8);
        this.v.setVisibility(0);
        this.B.setVisibility(0);
        this.z.setVisibility(0);
        this.D.setVisibility(0);
        this.A.setVisibility(8);
        this.C.setVisibility(8);
        this.G.setVisibility(8);
        this.O.setVisibility(8);
        this.P.setVisibility(8);
        this.D.performClick();
        this.v.setBackgroundResource(0);
    }

    private void p() {
        UserHttpUtils.a(this.k, new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>(getFragmentActive()) { // from class: com.soft.blued.ui.msg.ChannelFragment.6
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserInfoEntity> bluedEntityA) {
                UserInfoEntity userInfoEntity;
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || (userInfoEntity = (UserInfoEntity) bluedEntityA.data.get(0)) == null) {
                    return;
                }
                ChannelFragment.this.d.remoteUserName = userInfoEntity.name;
                ChannelFragment.this.d.remoteUserHead = AvatarUtils.a(0, userInfoEntity.avatar);
                ImageLoader.a(ChannelFragment.this.getFragmentActive(), ChannelFragment.this.d.remoteUserHead).b((int) R.drawable.channel_default_head).c().a(ChannelFragment.this.I);
                ImageLoader.a(ChannelFragment.this.getFragmentActive(), ChannelFragment.this.d.remoteUserHead).a(ChannelFragment.this.n);
                ImageLoader.a(ChannelFragment.this.getFragmentActive(), ChannelFragment.this.d.remoteUserHead).b((int) R.drawable.channel_default_head).a(2.0f).a(ChannelFragment.this.p);
                ChannelFragment.this.q.setText(ChannelFragment.this.d.remoteUserName);
                ChannelFragment.this.J.setText(ChannelFragment.this.d.remoteUserName);
            }
        }, String.valueOf(this.d.remoteUid), "", false, 0, 0, 0, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        AppInfo.n().postDelayed(this.f, 30000L);
    }

    private void r() {
        AppInfo.n().removeCallbacks(this.f);
        AppInfo.n().removeCallbacks(this.g);
        AppInfo.n().removeCallbacks(this.j);
        AppInfo.n().removeCallbacks(this.h);
        AppInfo.n().removeCallbacks(this.i);
    }

    private void s() {
        int i = this.Y;
        if (i >= 0) {
            long j = i - this.e;
            int i2 = (j > 30L ? 1 : (j == 30L ? 0 : -1));
            if (i2 <= 0) {
                this.ac = String.format(getString(R.string.channel_left_mill_time), BaseWrapper.ENTER_ID_TOOLKIT);
                this.ad = String.format(getString(R.string.channel_today_left_mill_time), BaseWrapper.ENTER_ID_TOOLKIT);
            } else if (i2 > 0 && j <= 60) {
                this.ac = String.format(getString(R.string.channel_left_time), "1");
                this.ad = String.format(getString(R.string.channel_today_left_time), "1");
            } else if (j > 60 && j <= 120) {
                this.ac = String.format(getString(R.string.channel_left_time), "2");
                this.ad = String.format(getString(R.string.channel_today_left_time), "2");
            } else if (j > 120 && j <= 180) {
                this.ac = String.format(getString(R.string.channel_left_time), "3");
                this.ad = String.format(getString(R.string.channel_today_left_time), "3");
            } else if (j > 180 && j <= 240) {
                this.ac = String.format(getString(R.string.channel_left_time), "4");
                this.ad = String.format(getString(R.string.channel_today_left_time), "4");
            } else if (j <= 240 || j > 300) {
                this.ac = "";
                this.ad = "";
            } else {
                this.ac = String.format(getString(R.string.channel_left_time), "5");
                this.ad = String.format(getString(R.string.channel_today_left_time), "5");
            }
        } else {
            this.ac = "";
            this.ad = "";
        }
        this.t.setText(this.ac);
        this.u.setText(this.ad);
        this.O.setText(this.ad);
    }

    public SurfaceView a(SurfaceView surfaceView) {
        synchronized (this) {
            ViewParent parent = surfaceView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(surfaceView);
            }
        }
        return surfaceView;
    }

    public void a() {
        AppInfo.n().postDelayed(this.h, 10000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0202 A[Catch: all -> 0x0231, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0024, B:11:0x0036, B:13:0x003d, B:58:0x018f, B:60:0x01b4, B:62:0x01bf, B:64:0x01ca, B:67:0x01d8, B:70:0x01fc, B:72:0x0202, B:74:0x0209, B:77:0x0227, B:75:0x0213, B:68:0x01eb, B:14:0x004e, B:17:0x0064, B:19:0x006f, B:21:0x007a, B:23:0x0085, B:26:0x0093, B:28:0x009d, B:29:0x00ae, B:31:0x00b9, B:32:0x00ca, B:35:0x00e0, B:37:0x00e7, B:38:0x00f8, B:41:0x010f, B:44:0x0125, B:46:0x012c, B:47:0x013d, B:50:0x0153, B:52:0x015a, B:53:0x016b, B:56:0x0180), top: B:88:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0213 A[Catch: all -> 0x0231, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0024, B:11:0x0036, B:13:0x003d, B:58:0x018f, B:60:0x01b4, B:62:0x01bf, B:64:0x01ca, B:67:0x01d8, B:70:0x01fc, B:72:0x0202, B:74:0x0209, B:77:0x0227, B:75:0x0213, B:68:0x01eb, B:14:0x004e, B:17:0x0064, B:19:0x006f, B:21:0x007a, B:23:0x0085, B:26:0x0093, B:28:0x009d, B:29:0x00ae, B:31:0x00b9, B:32:0x00ca, B:35:0x00e0, B:37:0x00e7, B:38:0x00f8, B:41:0x010f, B:44:0x0125, B:46:0x012c, B:47:0x013d, B:50:0x0153, B:52:0x015a, B:53:0x016b, B:56:0x0180), top: B:88:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r7) {
        /*
            Method dump skipped, instructions count: 566
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.ChannelFragment.a(int):void");
    }

    public void a(View view, int i, int i2) {
        synchronized (this) {
            FrameLayout.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(i, i2);
            } else {
                layoutParams.width = i;
                layoutParams.height = i2;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public void a(VideoChatHelper.CallFailed callFailed, String str) {
        Logger.b(f17971a, "showFailView:", str);
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            if (callFailed != VideoChatHelper.CallFailed.NETWORK && callFailed != VideoChatHelper.CallFailed.SERVER_LIMIT) {
                VideoChatHelper.CallFailed callFailed2 = VideoChatHelper.CallFailed.UNKNOWN;
            }
            str2 = this.k.getResources().getString(R.string.channel_connect_over_time_tip);
        }
        a(str2, 2);
    }

    public void a(String str, final int i) {
        CustomDialog customDialog = this.aa;
        if (customDialog == null || !customDialog.isShowing()) {
            View inflate = LayoutInflater.from(this.k).inflate(2131560351, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(2131372754);
            textView.setText(getString(2131888879));
            TextView textView2 = (TextView) inflate.findViewById(2131371051);
            textView2.setText(getString(2131886718));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.ChannelFragment.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (i != 1 || ChannelFragment.this.getActivity() == null) {
                        return;
                    }
                    ChannelFragment.this.getActivity().finish();
                }
            });
            TextView textView3 = (TextView) inflate.findViewById(2131372161);
            textView3.setText(2131886739);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.ChannelFragment.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (i == 2) {
                        ChannelFragment.this.a(false);
                    }
                    if (i == 1 && ChannelFragment.this.d.callType == 0 && ChannelFragment.this.U != null) {
                        ChannelFragment.this.U.call();
                    }
                    ChannelFragment.this.aa.dismiss();
                }
            });
            View findViewById = inflate.findViewById(2131371289);
            ((TextView) inflate.findViewById(2131371259)).setText(str);
            if (i == 1) {
                textView3.setText(getString(2131886739));
            } else if (i == 2) {
                textView.setVisibility(8);
                textView2.setVisibility(8);
                findViewById.setVisibility(8);
                textView3.setText(getString(R.string.live_window_indicate_know));
            }
            CustomDialog customDialog2 = new CustomDialog(this.k, 2131952378);
            this.aa = customDialog2;
            customDialog2.a(inflate, new CustomDialog.OnBackCallBack() { // from class: com.soft.blued.ui.msg.ChannelFragment.16
                public void a() {
                    int i2 = i;
                    if (i2 == 1) {
                        if (ChannelFragment.this.getActivity() != null) {
                            ChannelFragment.this.getActivity().finish();
                        }
                    } else if (i2 == 2) {
                        ChannelFragment.this.a(false);
                    }
                }
            });
        }
    }

    public void a(boolean z) {
        synchronized (this) {
            Logger.b(f17971a, "removeTimer:", Boolean.valueOf(z));
            e();
            r();
            if (this.e > 0) {
                if (this.U != null && this.U.f18699a != null) {
                    this.U.f18699a.hangup((int) this.e);
                }
                this.e = 0L;
            } else if (this.U != null && this.U.f18699a != null) {
                this.U.f18699a.cancel(z);
            }
        }
    }

    public void b() {
        r();
        d();
        if (this.d.callType == 0 || this.d.callType == 2) {
            this.d.callType = 4;
            i();
        } else if (this.d.callType == 1 || this.d.callType == 3) {
            this.d.callType = 5;
            i();
        }
    }

    public void b(int i) {
        Logger.b(f17971a, "leftTime:", Integer.valueOf(i));
        this.Y = i;
        s();
    }

    public void b(boolean z) {
        if (this.d.callType == 0) {
            this.d.callType = 1;
        } else if (this.d.callType == 2) {
            this.d.callType = 3;
        } else {
            ChannelManager channelManager = this.U;
            if (channelManager != null) {
                channelManager.h();
                this.U.f18700c = System.currentTimeMillis() / 1000;
                this.U.b = "voice";
            }
            this.d.callType = 5;
            if (z) {
                this.y.setText(this.k.getResources().getString(R.string.channel_swich_to_voice_other_tip));
            } else {
                this.y.setText(this.k.getResources().getString(R.string.channel_swich_to_voice_tip));
            }
            this.y.setVisibility(0);
            this.y.postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.ChannelFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    ChannelFragment.this.y.setVisibility(8);
                }
            }, 5000L);
            this.w.setVisibility(0);
            this.x.setTextColor(Color.parseColor("#ffffff"));
        }
        ChannelManager channelManager2 = this.U;
        if (channelManager2 != null) {
            channelManager2.b();
        }
        i();
    }

    public void c() {
        String string = this.k.getResources().getString(R.string.channel_wait_tip);
        this.r.setText(string);
        this.K.setText(string);
    }

    public void d() {
        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.ChannelFragment.7
            @Override // java.lang.Runnable
            public void run() {
                ChannelFragment.this.x.start();
            }
        });
        q();
    }

    public void e() {
        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.ChannelFragment.8
            @Override // java.lang.Runnable
            public void run() {
                ChannelFragment.this.x.stop();
            }
        });
    }

    public void f() {
    }

    public boolean onBackPressed() {
        a(false);
        return super.onBackPressed();
    }

    @Override // android.widget.Chronometer.OnChronometerTickListener
    public void onChronometerTick(Chronometer chronometer) {
        this.e++;
        this.X = System.currentTimeMillis();
        chronometer.setText(TimeAndDateUtils.a(this.e, false));
        int i = this.Y;
        if (i < this.e && i >= 0) {
            ChannelManager channelManager = this.U;
            if (channelManager != null) {
                channelManager.g();
            }
            e();
            AppInfo.n().removeCallbacks(this.f);
            AppInfo.n().removeCallbacks(this.g);
            a(this.k.getResources().getString(R.string.channel_over_time_tip), 2);
        }
        s();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlphaAnimation alphaAnimation;
        Tracker.onClick(view);
        if (ClickUtils.a(view.getId(), 1000L)) {
            return;
        }
        switch (view.getId()) {
            case R.id.accept_hold /* 2131361906 */:
                if (this.d.callType == 2) {
                    this.d.callType = 4;
                    i();
                    ChannelManager channelManager = this.U;
                    if (channelManager != null) {
                        channelManager.a();
                        if (this.U.f18699a != null) {
                            this.U.f18699a.answer();
                            return;
                        }
                        return;
                    }
                    return;
                } else if (this.d.callType == 3) {
                    this.d.callType = 5;
                    i();
                    ChannelManager channelManager2 = this.U;
                    if (channelManager2 != null) {
                        channelManager2.b();
                        if (this.U.f18699a != null) {
                            this.U.f18699a.answer();
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case R.id.accept_hold_off /* 2131361907 */:
            case R.id.launch_hold_off /* 2131366695 */:
                a(false);
                return;
            case R.id.accept_switch_voice /* 2131361909 */:
            case R.id.channel_voice_lay /* 2131362804 */:
            case R.id.launch_switch_voice /* 2131366697 */:
                ChannelManager channelManager3 = this.U;
                if (channelManager3 != null && channelManager3.f18699a != null) {
                    this.U.f18699a.switchToAudio();
                }
                b(false);
                return;
            case R.id.channel_camera_lay /* 2131362794 */:
                ChannelManager channelManager4 = this.U;
                if (channelManager4 != null) {
                    channelManager4.i();
                    return;
                }
                return;
            case R.id.channel_hold_lay /* 2131362795 */:
                a(false);
                return;
            case R.id.channel_mute_lay /* 2131362798 */:
                boolean z = !((Boolean) this.z.getTag()).booleanValue();
                if (z) {
                    ChannelManager channelManager5 = this.U;
                    if (channelManager5 != null) {
                        channelManager5.a(true);
                    }
                    this.E.setSelected(true);
                } else {
                    ChannelManager channelManager6 = this.U;
                    if (channelManager6 != null) {
                        channelManager6.a(false);
                    }
                    this.E.setSelected(false);
                }
                this.z.setTag(Boolean.valueOf(z));
                return;
            case R.id.channel_speak_lay /* 2131362801 */:
                boolean z2 = !((Boolean) this.D.getTag()).booleanValue();
                if (z2) {
                    this.F.setSelected(true);
                    ChannelManager channelManager7 = this.U;
                    if (channelManager7 != null) {
                        channelManager7.b(true);
                    }
                } else {
                    this.F.setSelected(false);
                    ChannelManager channelManager8 = this.U;
                    if (channelManager8 != null) {
                        channelManager8.b(false);
                    }
                }
                this.D.setTag(Boolean.valueOf(z2));
                return;
            case R.id.user_local_view /* 2131373050 */:
                if (this.d.callType == 4) {
                    this.w.removeCallbacks(this.i);
                    if (this.w.getVisibility() == 0) {
                        this.w.setVisibility(8);
                        alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                        this.x.setTextColor(Color.parseColor("#00ffffff"));
                    } else {
                        this.w.setVisibility(0);
                        alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        this.w.postDelayed(this.i, 5000L);
                        this.x.setTextColor(Color.parseColor("#ffffff"));
                    }
                    alphaAnimation.setFillAfter(false);
                    alphaAnimation.setDuration(500L);
                    this.w.setAnimation(alphaAnimation);
                    alphaAnimation.start();
                    return;
                }
                return;
            case R.id.user_remote_views /* 2131373052 */:
                SurfaceView surfaceView = (SurfaceView) this.b.getChildAt(0);
                SurfaceView surfaceView2 = (SurfaceView) this.f17972c.getChildAt(0);
                int applyDimension = (int) TypedValue.applyDimension(1, 105.0f, this.k.getResources().getDisplayMetrics());
                int applyDimension2 = (int) TypedValue.applyDimension(1, 187.0f, this.k.getResources().getDisplayMetrics());
                int E = LiveFloatManager.a().E();
                int F = LiveFloatManager.a().F();
                Logger.b(f17971a, "screenViewWidth:", Integer.valueOf(E), " screenHeight:", Integer.valueOf(F), "   windowViewWidth:", Integer.valueOf(applyDimension), "  windowViewHeight:", Integer.valueOf(applyDimension2));
                if (surfaceView != null && surfaceView2 != null) {
                    a(surfaceView2, E, F);
                    a(surfaceView, applyDimension, applyDimension2);
                    this.b.addView(a(surfaceView2));
                    this.f17972c.addView(a(surfaceView));
                    surfaceView.setZOrderOnTop(true);
                    surfaceView.setZOrderMediaOverlay(true);
                    surfaceView2.setZOrderOnTop(false);
                    surfaceView2.setZOrderMediaOverlay(false);
                }
                ChannelManager channelManager9 = this.U;
                if (channelManager9 != null) {
                    channelManager9.j();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.d.callType == 0 || this.d.callType == 2 || this.d.callType == 4) {
            getActivity().getWindow().addFlags(8192);
        }
        this.k = getActivity();
        View view = this.V;
        if (view == null) {
            this.V = layoutInflater.inflate(R.layout.fragment_channel_room, viewGroup, false);
            h();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.V.getParent()).removeView(this.V);
        }
        return this.V;
    }

    public void onDestroy() {
        this.e = 0L;
        r();
        ChannelManager channelManager = this.U;
        if (channelManager != null) {
            channelManager.g();
            if (this.U.f18699a != null) {
                this.U.f18699a.destroy();
            }
            this.U.c(getActivity());
        }
        getActivity().getWindow().clearFlags(128);
        super.onDestroy();
    }

    public void onPause() {
        AppInfo.n().postDelayed(this.j, 30000L);
        if (this.U != null) {
            if (this.d.callType == 4) {
                this.U.e();
            }
            this.U.b(getActivity());
        }
        super.onPause();
    }

    public void onResume() {
        if (this.X > 0) {
            long currentTimeMillis = this.e + ((System.currentTimeMillis() - this.X) / 1000);
            this.e = currentTimeMillis;
            this.x.setText(TimeAndDateUtils.a(currentTimeMillis, false));
        }
        AppInfo.n().removeCallbacks(this.j);
        if (this.U != null) {
            if (this.d.callType == 4) {
                this.U.f();
            }
            this.U.a(getActivity());
        }
        super.onResume();
    }
}
