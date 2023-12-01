package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.dialog.LiveDialogTip;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKCountDownView.class */
public class LivePKCountDownView extends FrameLayout implements View.OnClickListener {
    public int a;
    public int b;
    private Context c;
    private LayoutInflater d;
    private View e;
    private View f;
    private TextView g;
    private Chronometer h;
    private ImageView i;
    private View j;
    private BaseFragment k;
    private CountDownTimer l;
    private CountDownTimer m;
    private int n;
    private PKCountDownCallback o;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKCountDownView$PKCountDownCallback.class */
    public interface PKCountDownCallback {
        void a();
    }

    public LivePKCountDownView(Context context) {
        this(context, null);
    }

    public LivePKCountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LivePKCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 5;
        this.n = 0;
        this.c = context;
        g();
    }

    private void g() {
        LayoutInflater from = LayoutInflater.from(this.c);
        this.d = from;
        View inflate = from.inflate(R.layout.live_pk_count_down_layout, this);
        this.e = inflate;
        this.f = inflate.findViewById(R.id.live_pk_count_down_layout);
        this.g = (TextView) this.e.findViewById(R.id.live_pk_count_down_punish);
        this.h = (Chronometer) this.e.findViewById(R.id.live_pk_count_down_chronometer);
        this.j = this.e.findViewById(R.id.live_pk_count_down_qa);
        this.i = (ImageView) this.e.findViewById(R.id.iv_pk);
        this.h.setText("00:00");
        this.j.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Logger.b("pk", "stopPK --------------");
        BaseFragment baseFragment = this.k;
        if (baseFragment instanceof RecordingOnliveFragment) {
            ((RecordingOnliveFragment) baseFragment).bc();
        } else if (baseFragment instanceof PlayingOnliveFragment) {
            ((PlayingOnliveFragment) baseFragment).i();
        }
        setCurrentModel(0);
    }

    public void a(int i) {
        LiveRoomHttpUtils.d(new BluedUIHttpResponse() { // from class: com.blued.android.module.live_china.view.LivePKCountDownView.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, i);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.blued.android.module.live_china.view.LivePKCountDownView$7] */
    public void a(long j) {
        this.g.setVisibility(0);
        this.g.setText(LiveRoomManager.a().X());
        this.i.setVisibility(8);
        this.h.setVisibility(0);
        b();
        this.l = new CountDownTimer(j * 1000, 500L) { // from class: com.blued.android.module.live_china.view.LivePKCountDownView.7
            @Override // android.os.CountDownTimer
            public void onFinish() {
                LivePKCountDownView.this.h();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                LivePKCountDownView.this.h.setText(LiveTimeAndDateUtils.a((j2 / 1000) + 1, false));
            }
        }.start();
        if (j > 0) {
            setCurrentModel(2);
        }
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [com.blued.android.module.live_china.view.LivePKCountDownView$5] */
    public void a(long j, final boolean z) {
        Log.i("==xpm", "startPKCountDownTimer:" + j);
        c();
        b();
        this.g.setVisibility(8);
        this.i.setVisibility(0);
        this.h.setVisibility(0);
        this.l = new CountDownTimer(j * 1000, 500L) { // from class: com.blued.android.module.live_china.view.LivePKCountDownView.5
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (z) {
                    LivePKCountDownView.this.d();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                long j3 = (j2 / 1000) + 1;
                LivePKCountDownView.this.n = (int) j3;
                if (j3 == 5 && LivePKCountDownView.this.o != null) {
                    LivePKCountDownView.this.o.a();
                    LivePKCountDownView.this.o = null;
                }
                LivePKCountDownView.this.h.setText(LiveTimeAndDateUtils.a(j3, false));
            }
        }.start();
        setCurrentModel(1);
    }

    public void a(final boolean z) {
        if (a()) {
            Context context = this.c;
            CommonAlertDialog.a(context, "", context.getString(R.string.live_pk_exit_punish), this.c.getString(R.string.live_window_permisson_cancel), (DialogInterface.OnClickListener) null, this.c.getString(R.string.biao_v4_ok), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.LivePKCountDownView.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    LivePKCountDownView.this.a(0);
                    LivePKCountDownView.this.h();
                    InstantLog.a("live_pk_end_afterphase");
                }
            }, (DialogInterface.OnDismissListener) null);
            return;
        }
        View inflate = LayoutInflater.from(this.c).inflate(R.layout.live_exit_pk_tips, (ViewGroup) null);
        final CustomDialog customDialog = new CustomDialog(this.c);
        customDialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
        customDialog.a(inflate, null);
        TextView textView = (TextView) inflate.findViewById(R.id.tips_message);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tips_confirm);
        textView.setText(R.string.live_pk_exit);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LivePKCountDownView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                customDialog.dismiss();
                LivePKCountDownView.this.a(0);
                LivePKCountDownView.this.h();
                if (z && (LivePKCountDownView.this.k instanceof RecordingOnliveFragment)) {
                    ((RecordingOnliveFragment) LivePKCountDownView.this.k).G();
                }
            }
        });
        ((TextView) inflate.findViewById(R.id.tips_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LivePKCountDownView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                customDialog.dismiss();
            }
        });
    }

    public boolean a() {
        return this.a == 2;
    }

    public void b() {
        CountDownTimer countDownTimer = this.l;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void c() {
        CountDownTimer countDownTimer = this.m;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.blued.android.module.live_china.view.LivePKCountDownView$6] */
    public void d() {
        c();
        this.m = new CountDownTimer(this.b * 1000, 500L) { // from class: com.blued.android.module.live_china.view.LivePKCountDownView.6
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (LivePKCountDownView.this.k == null || LivePKCountDownView.this.k.getFragmentActive() == null || !LivePKCountDownView.this.k.getFragmentActive().isActive()) {
                    return;
                }
                new LiveDialogTip(LivePKCountDownView.this.k.getActivity(), LivePKCountDownView.this.getResources().getString(R.string.live_wenxin_tip), LivePKCountDownView.this.getResources().getString(R.string.live_pk_connect_fail), new LiveDialogTip.IEventCallback() { // from class: com.blued.android.module.live_china.view.LivePKCountDownView.6.1
                    @Override // com.blued.android.module.live_china.dialog.LiveDialogTip.IEventCallback
                    public void a() {
                        LivePKCountDownView.this.a(3);
                        LivePKCountDownView.this.h();
                    }
                }).show();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        }.start();
    }

    public void e() {
        this.g.setVisibility(0);
        this.g.setText(getResources().getString(R.string.live_pk_round_wait_3));
        this.i.setVisibility(8);
        this.h.setVisibility(8);
        b();
    }

    public void f() {
        c();
        b();
        this.o = null;
    }

    public int getCurrentModel() {
        return this.a;
    }

    public int getLastTime() {
        return this.n;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_pk_count_down_qa) {
            EventTrackLive.a(LiveProtos.Event.LIVE_PK_EXPLAIN_BUBBLE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            LiveSetDataObserver.a().b(LiveRoomInfo.a().A(), 0);
        }
    }

    public void setCurrentModel(int i) {
        this.a = i;
    }

    public void setData(BaseFragment baseFragment) {
        this.k = baseFragment;
    }

    public void setPKCountDownCallback(PKCountDownCallback pKCountDownCallback) {
        this.o = pKCountDownCallback;
    }
}
