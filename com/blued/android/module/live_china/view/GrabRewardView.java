package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveGrabRewardFansGrayDlgFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.EnumOperation;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveRewardExtraModel;
import com.blued.android.module.live_china.model.LiveRewardListModel;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.RewardErrorModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveRewardStatusObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.view.PopRewardListView;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/GrabRewardView.class */
public class GrabRewardView extends FrameLayout implements View.OnClickListener, LiveRewardStatusObserver.ILiveRewardStatusObserver {
    public BaseFragment a;
    public boolean b;
    private View c;
    private Context d;
    private LayoutInflater e;
    private RecordingOnliveFragment f;
    private PlayingOnliveBaseModeFragment g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private View l;
    private Chronometer m;
    private long n;
    private CountDownTimer o;
    private CountDownTimer p;
    private LiveRewardModel q;
    private boolean r;

    public GrabRewardView(Context context) {
        super(context);
        this.d = context;
        i();
    }

    public GrabRewardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = context;
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.l.setVisibility(0);
        this.i.setVisibility(8);
        this.j.setVisibility(8);
        this.k.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.l.setVisibility(8);
        this.i.setVisibility(0);
        this.j.setVisibility(8);
        this.k.setVisibility(8);
    }

    private void e() {
        this.l.setVisibility(8);
        this.i.setVisibility(8);
        this.j.setVisibility(0);
        this.k.setVisibility(8);
    }

    private void f() {
        this.l.setVisibility(8);
        this.i.setVisibility(8);
        this.j.setVisibility(8);
        this.k.setVisibility(0);
    }

    private void g() {
        CountDownTimer countDownTimer = this.p;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void h() {
        CountDownTimer countDownTimer = this.o;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void i() {
        LayoutInflater from = LayoutInflater.from(this.d);
        this.e = from;
        View inflate = from.inflate(R.layout.live_grab_reward_layout, (ViewGroup) this, true);
        this.c = inflate;
        this.h = (ImageView) inflate.findViewById(R.id.grab_reward_image);
        this.i = (TextView) this.c.findViewById(R.id.grab_reward_btn);
        this.j = (TextView) this.c.findViewById(R.id.got_reward_btn);
        this.k = (TextView) this.c.findViewById(R.id.robbed_reward_btn);
        this.l = this.c.findViewById(R.id.grab_reward_chronomete_root);
        this.m = (Chronometer) this.c.findViewById(R.id.grab_reward_chronometer);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
    }

    private void j() {
        if (this.a.getParentFragment() == null || !this.a.getParentFragment().isAdded()) {
            return;
        }
        LiveGrabRewardFansGrayDlgFragment liveGrabRewardFansGrayDlgFragment = new LiveGrabRewardFansGrayDlgFragment();
        liveGrabRewardFansGrayDlgFragment.setCancelable(true);
        liveGrabRewardFansGrayDlgFragment.show(this.a.getParentFragment().getChildFragmentManager(), liveGrabRewardFansGrayDlgFragment.b());
    }

    public Boolean a(LiveRewardModel liveRewardModel) {
        if (liveRewardModel == null) {
            return false;
        }
        LiveRewardModel liveRewardModel2 = this.q;
        if (liveRewardModel2 == null || !TextUtils.equals(liveRewardModel2.hongbao_id, liveRewardModel.hongbao_id)) {
            this.q = liveRewardModel;
            setGrabViewVisible(0);
            g();
            h();
            if (liveRewardModel.start_second > 0) {
                a();
            } else {
                setRewardView(liveRewardModel.status);
            }
            Logger.a("drb", "mLiveRewardModel is_anim = ", Integer.valueOf(liveRewardModel.is_anim));
            if ((this.a instanceof PlayingOnliveBaseModeFragment) && liveRewardModel.status == 0 && liveRewardModel.is_anim == 1) {
                LiveGiftModel liveGiftModel = new LiveGiftModel();
                liveGiftModel.anim_code = "hongbao";
                PlayingOnliveBaseModeFragment playingOnliveBaseModeFragment = this.g;
                if (playingOnliveBaseModeFragment != null && playingOnliveBaseModeFragment.q != null) {
                    this.g.q.e(liveGiftModel);
                }
            }
            LiveRefreshUIObserver.a().b();
            b();
            return true;
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.blued.android.module.live_china.view.GrabRewardView$2] */
    public void a() {
        Logger.a("drb", "mLiveRewardModel.start_second = ", Long.valueOf(this.q.start_second));
        Logger.a("drb", "mLiveRewardModel.remaining_millisecond = ", Long.valueOf(this.q.remaining_millisecond));
        if (this.q.remaining_millisecond <= 0) {
            this.p = new CountDownTimer(this.q.start_second * 1000, 1000L) { // from class: com.blued.android.module.live_china.view.GrabRewardView.2
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    Logger.a("drb", "红包开抢");
                    if (GrabRewardView.this.b) {
                        GrabRewardView.this.l.setVisibility(8);
                    } else {
                        GrabRewardView.this.d();
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    long j2 = (j / 1000) + 1;
                    GrabRewardView.this.m.setText(LiveTimeAndDateUtils.a(j2, false));
                    GrabRewardView.this.c();
                    Logger.a("drb", "红包开抢倒计时：", Long.valueOf(j2));
                }
            }.start();
            return;
        }
        final long j = this.q.remaining_millisecond % 1000;
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.GrabRewardView.1
            /* JADX WARN: Type inference failed for: r1v0, types: [com.blued.android.module.live_china.view.GrabRewardView$1$1] */
            @Override // java.lang.Runnable
            public void run() {
                GrabRewardView.this.p = new CountDownTimer(GrabRewardView.this.q.remaining_millisecond - j, 1000L) { // from class: com.blued.android.module.live_china.view.GrabRewardView.1.1
                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        Logger.a("drb", "红包开抢");
                        if (GrabRewardView.this.b) {
                            GrabRewardView.this.l.setVisibility(8);
                        } else {
                            GrabRewardView.this.d();
                        }
                    }

                    @Override // android.os.CountDownTimer
                    public void onTick(long j2) {
                        long j3 = (j2 / 1000) + 1;
                        GrabRewardView.this.m.setText(LiveTimeAndDateUtils.a(j3, false));
                        GrabRewardView.this.c();
                        Logger.a("drb", "红包开抢倒计时：", Long.valueOf(j3));
                    }
                }.start();
            }
        }, j);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRewardStatusObserver.ILiveRewardStatusObserver
    public void a(int i) {
        this.q.status = i;
        setRewardView(i);
    }

    public void a(BaseFragment baseFragment) {
        this.a = baseFragment;
        if (baseFragment instanceof RecordingOnliveFragment) {
            this.b = true;
            RecordingOnliveFragment recordingOnliveFragment = (RecordingOnliveFragment) baseFragment;
            this.f = recordingOnliveFragment;
            this.n = recordingOnliveFragment.t;
        } else if (baseFragment instanceof PlayingOnliveBaseModeFragment) {
            this.b = false;
            PlayingOnliveBaseModeFragment playingOnliveBaseModeFragment = (PlayingOnliveBaseModeFragment) baseFragment;
            this.g = playingOnliveBaseModeFragment;
            this.n = playingOnliveBaseModeFragment.s;
        }
    }

    public void a(String str, long j, String str2, final String str3) {
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<LiveRewardListModel, LiveRewardExtraModel>>(this.a.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.GrabRewardView.5
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(final Throwable th, final int i, final String str4) {
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.view.GrabRewardView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GrabRewardView.this.a(th, i, str4);
                    }
                });
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveRewardListModel, LiveRewardExtraModel> bluedEntity) {
                try {
                    if (bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                        return;
                    }
                    PopRewardListView.a(GrabRewardView.this.a, GrabRewardView.this.q, bluedEntity.data.get(0), null);
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    LiveSetDataObserver.a().c(GrabRewardView.this.q.pwd);
                } catch (Exception e) {
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public BluedEntity<LiveRewardListModel, LiveRewardExtraModel> parseData(String str4) {
                return super.parseData(str4);
            }
        }, str, String.valueOf(j), str2, str3);
    }

    public void a(Throwable th, int i, String str) {
        Pair<Integer, String> a = BluedHttpUtils.a(th, i, str);
        RewardErrorModel rewardErrorModel = new RewardErrorModel();
        rewardErrorModel.throwable = th;
        rewardErrorModel.statusCode = i;
        rewardErrorModel.content = str;
        if (((Integer) a.first).intValue() == 4032014) {
            PopRewardListView.a(this.a, this.q, null, rewardErrorModel);
        } else if (((Integer) a.first).intValue() == 4032021) {
            PopRewardListView.a(this.a, this.q, null, rewardErrorModel);
        } else if (((Integer) a.first).intValue() == 4032022) {
            PopRewardListView.a(this.a, this.q, null, rewardErrorModel);
        } else if (((Integer) a.first).intValue() == 4032015) {
            AppMethods.a((CharSequence) this.d.getString(R.string.live_live_receive_conditions_toast), true);
        } else if (((Integer) a.first).intValue() == 4034003) {
            j();
        } else {
            BluedHttpUtils.b(th, i, str);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.blued.android.module.live_china.view.GrabRewardView$3] */
    public void b() {
        this.o = new CountDownTimer(1000 * this.q.end_second, 1000L) { // from class: com.blued.android.module.live_china.view.GrabRewardView.3
            @Override // android.os.CountDownTimer
            public void onFinish() {
                GrabRewardView.this.setGrabViewVisible(8);
                LiveRefreshUIObserver.a().c();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                long j2 = j / 1000;
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LiveRewardStatusObserver.a().a(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.grab_reward_image || view.getId() == R.id.grab_reward_btn) {
            if (this.l.getVisibility() == 0) {
                if (TextUtils.equals("3", this.q.condition)) {
                    AppMethods.d(R.string.live_reward_fans_after_count_down);
                } else {
                    AppMethods.d(R.string.live_reward_after_count_down);
                }
            } else if (this.b) {
                PopRewardListView.a(this.a, this.q);
            } else {
                LiveRewardModel liveRewardModel = this.q;
                if (liveRewardModel != null) {
                    if (liveRewardModel.status == 1) {
                        PopRewardListView.a(this.a, this.q);
                    } else if (this.q.status == 2) {
                        PopRewardListView.a(this.a, this.q);
                    } else if (TextUtils.isEmpty(this.q.pwd) || this.q.hasPwdTip) {
                        a(this.q.hongbao_id, this.n, "", this.q.pwd);
                    } else {
                        PopRewardListView.a(this.a, this.q).a(new PopRewardListView.OnPopEventCallBack() { // from class: com.blued.android.module.live_china.view.GrabRewardView.4
                            @Override // com.blued.android.module.live_china.view.PopRewardListView.OnPopEventCallBack
                            public void a(boolean z) {
                                GrabRewardView.this.q.hasPwdTip = z;
                                if (z) {
                                    GrabRewardView grabRewardView = GrabRewardView.this;
                                    grabRewardView.a(grabRewardView.q.hongbao_id, GrabRewardView.this.n, "", GrabRewardView.this.q.pwd);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
        h();
        LiveRewardStatusObserver.a().b(this);
    }

    public void setGrabViewVisible(int i) {
        if (i == 0) {
            this.r = true;
            return;
        }
        this.r = false;
        LiveEventBus.get(LiveEventBusUtil.k).post(Integer.valueOf(EnumOperation.VIEW_TYPE_RED_BAG.getValue()));
    }

    public void setRewardView(int i) {
        if (this.b) {
            return;
        }
        if (i == 0) {
            d();
        } else if (i == 1) {
            e();
        } else if (i == 2) {
            f();
        }
    }
}
