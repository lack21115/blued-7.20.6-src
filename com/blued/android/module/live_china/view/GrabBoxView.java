package com.blued.android.module.live_china.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
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
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.manager.PlayGifObserver;
import com.blued.android.module.live_china.model.GrabBoxDetailModel;
import com.blued.android.module.live_china.model.GrabBoxModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.OpenBoxModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.view.PopGrabBoxView;
import com.blued.android.module.live_china.view.progress.SlopeProgress;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.EventBusConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/GrabBoxView.class */
public class GrabBoxView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragment f14282a;
    public ActivityFragmentActive b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14283c;
    PopGrabBoxView.DismissLisnter d;
    private View e;
    private Context f;
    private LayoutInflater g;
    private ImageView h;
    private TextView i;
    private SlopeProgress j;
    private View k;
    private View l;
    private Chronometer m;
    private RecordingOnliveFragment n;
    private PlayingOnliveBaseModeFragment o;
    private List<GrabBoxModel> p;
    private GrabBoxModel q;
    private Set<String> r;
    private Handler s;
    private long t;
    private boolean u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/GrabBoxView$DurationThread.class */
    public class DurationThread implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        GrabBoxModel f14289a;

        public DurationThread(GrabBoxModel grabBoxModel) {
            this.f14289a = grabBoxModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14289a == null) {
                return;
            }
            if (GrabBoxView.this.q != null && this.f14289a != GrabBoxView.this.q) {
                GrabBoxView.this.q.duration--;
            }
            this.f14289a.duration--;
            if (this.f14289a.duration == 0) {
                GrabBoxView.this.b(this.f14289a);
            } else {
                GrabBoxView.this.s.postDelayed(new DurationThread(this.f14289a), 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/GrabBoxView$MyChronometerTickListener.class */
    public class MyChronometerTickListener implements Chronometer.OnChronometerTickListener {

        /* renamed from: a  reason: collision with root package name */
        GrabBoxModel f14290a;

        public MyChronometerTickListener(GrabBoxModel grabBoxModel) {
            this.f14290a = grabBoxModel;
        }

        @Override // android.widget.Chronometer.OnChronometerTickListener
        public void onChronometerTick(Chronometer chronometer) {
            GrabBoxModel grabBoxModel = this.f14290a;
            if (grabBoxModel == null) {
                return;
            }
            grabBoxModel.duration--;
            Logger.a("drb", "onChronometerTick id duration = ", this.f14290a.box_id, "--", Integer.valueOf(this.f14290a.duration));
            if (this.f14290a.duration > 0) {
                GrabBoxView.this.l.setVisibility(0);
                chronometer.setText(LiveTimeAndDateUtils.a(this.f14290a.duration, false));
                return;
            }
            chronometer.stop();
            GrabBoxView.this.l.setVisibility(8);
            GrabBoxView.this.b(this.f14290a);
            Logger.a("drb", "chronometer.stop");
        }
    }

    public GrabBoxView(Context context) {
        this(context, null);
    }

    public GrabBoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = new ArrayList();
        this.r = new HashSet();
        this.s = new Handler();
        this.d = new PopGrabBoxView.DismissLisnter() { // from class: com.blued.android.module.live_china.view.GrabBoxView.1
            @Override // com.blued.android.module.live_china.view.PopGrabBoxView.DismissLisnter
            public void a() {
                if (GrabBoxView.this.f14282a instanceof PlayingOnliveBaseModeFragment) {
                    LiveRefreshUIObserver.a().d(0);
                    LiveSetDataObserver.a().e(0);
                } else if (GrabBoxView.this.f14282a instanceof RecordingOnliveFragment) {
                    if (GrabBoxView.this.n.x) {
                        GrabBoxView.this.n.i(0);
                    } else {
                        GrabBoxView.this.n.h(0);
                    }
                    GrabBoxView.this.n.dd.a(0);
                }
            }
        };
        this.f = context;
        a();
    }

    private void a() {
        LayoutInflater from = LayoutInflater.from(this.f);
        this.g = from;
        View inflate = from.inflate(R.layout.live_grab_box_layout, (ViewGroup) this, true);
        this.e = inflate;
        this.h = (ImageView) inflate.findViewById(R.id.grab_box_image);
        this.i = (TextView) this.e.findViewById(R.id.grab_box_num);
        this.j = (SlopeProgress) this.e.findViewById(R.id.grab_box_progress);
        this.k = this.e.findViewById(R.id.receive_btn);
        this.l = this.e.findViewById(R.id.grab_box_chronometer_root);
        this.m = (Chronometer) this.e.findViewById(R.id.grab_box_chronometer);
        this.h.setOnClickListener(this);
        this.k.setOnClickListener(this);
        setVisibility(8);
    }

    private void a(GrabBoxModel grabBoxModel, GrabBoxModel grabBoxModel2) {
        grabBoxModel2.type = grabBoxModel.type;
        grabBoxModel2.duration = grabBoxModel.duration;
        grabBoxModel2.progress = grabBoxModel.progress;
    }

    private void a(GrabBoxModel grabBoxModel, boolean z) {
        setGrabViewVisible(0);
        c();
        setBoxImage(grabBoxModel);
        setReceiveBtn(grabBoxModel);
        if (z || grabBoxModel == null || grabBoxModel.type != 2) {
            return;
        }
        Logger.a("drb", "下一个宝箱也是开启状态，继续倒计时 宝箱id为 = ", grabBoxModel.box_id);
        LiveMsgSendManager a2 = LiveMsgSendManager.a();
        a2.d("下一个宝箱也是开启状态，继续倒计时 宝箱id为 = " + grabBoxModel.box_id);
        this.s.removeCallbacksAndMessages(null);
        this.s.postDelayed(new DurationThread(this.q), 1000L);
    }

    private void b() {
        if (this.p.size() <= 0) {
            setBoxProgress(this.q);
            return;
        }
        List<GrabBoxModel> list = this.p;
        setBoxProgress(list.get(list.size() - 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(GrabBoxModel grabBoxModel) {
        Logger.a("drb", "删除当前宝箱 = ", grabBoxModel.box_id);
        LiveMsgSendManager a2 = LiveMsgSendManager.a();
        a2.d("删除当前宝箱 = " + grabBoxModel.box_id);
        if (!this.p.remove(grabBoxModel)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.p.size()) {
                    break;
                }
                GrabBoxModel grabBoxModel2 = this.p.get(i2);
                if (grabBoxModel2.box_id.equals(grabBoxModel.box_id)) {
                    this.p.remove(grabBoxModel2);
                    break;
                }
                i = i2 + 1;
            }
        }
        if (this.p.size() <= 0) {
            this.q = null;
            setGrabViewVisible(8);
            return;
        }
        GrabBoxModel grabBoxModel3 = this.p.get(0);
        this.q = grabBoxModel3;
        Logger.a("drb", "删除当前宝箱后 还有宝箱 新宝箱id = ", grabBoxModel3.box_id);
        Logger.a("drb", "初始化宝箱");
        LiveMsgSendManager a3 = LiveMsgSendManager.a();
        a3.d("删除当前宝箱后 还有宝箱 新宝箱id = " + this.q.box_id + " -- 初始化宝箱");
        a(this.q, false);
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String e = RecyclingUtils.e(str);
        if (new File(e).exists()) {
            return;
        }
        synchronized (this.r) {
            if (this.r.contains(str)) {
                return;
            }
            this.r.add(str);
            FileDownloader.a(str, e, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= this.p.size()) {
                break;
            }
            int i4 = i;
            if (this.p.get(i2).type == 2) {
                i4 = i + 1;
            }
            i2++;
            i3 = i4;
        }
        Logger.a("drb", "设置右上角宝箱数量 = ", Integer.valueOf(i));
        LiveMsgSendManager.a().d("设置右上角宝箱数量 = " + i);
        if (i < 1) {
            this.i.setVisibility(8);
            return;
        }
        this.i.setVisibility(0);
        this.i.setText(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GrabBoxModel grabBoxModel) {
        this.l.setVisibility(0);
        this.m.setOnChronometerTickListener(new MyChronometerTickListener(grabBoxModel));
        this.m.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.p.size()) {
                return false;
            }
            if (this.p.get(i2).box_id.equals(str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        int i;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= this.p.size()) {
                break;
            }
            GrabBoxModel grabBoxModel = this.p.get(i2);
            Logger.a("drb", "hasUnclaimedBox type = ", Integer.valueOf(grabBoxModel.type));
            int i4 = i;
            if (grabBoxModel.type == 2) {
                i4 = i + 1;
            }
            i2++;
            i3 = i4;
        }
        if (i > 0) {
            z = true;
        }
        return z;
    }

    private int getBoxOpenNum() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= this.p.size()) {
                return i3;
            }
            int i4 = i3;
            if (this.p.get(i).type == 2) {
                i4 = i3 + 1;
            }
            i++;
            i2 = i4;
        }
    }

    private void setBoxImage(GrabBoxModel grabBoxModel) {
        if (grabBoxModel == null) {
            return;
        }
        ImageLoader.a((IRequestHost) null, grabBoxModel.box_image).a(this.h);
        Logger.a("drb", "model.box_image = ", grabBoxModel.box_image);
    }

    private void setBoxProgress(GrabBoxModel grabBoxModel) {
        if (grabBoxModel == null) {
            return;
        }
        SlopeProgress slopeProgress = this.j;
        ObjectAnimator.ofInt(slopeProgress, "progress", slopeProgress.getProgress(), grabBoxModel.progress).setDuration(300L).start();
        Logger.a("drb", "setBoxProgress", Integer.valueOf(grabBoxModel.progress));
        LiveMsgSendManager a2 = LiveMsgSendManager.a();
        a2.d("setBoxProgress" + grabBoxModel.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBoxReceive(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.p.size()) {
                return;
            }
            GrabBoxModel grabBoxModel = this.p.get(i2);
            if (grabBoxModel.box_id.equals(str)) {
                grabBoxModel.type = 4;
                return;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReceiveBtn(GrabBoxModel grabBoxModel) {
        if (grabBoxModel == null) {
            return;
        }
        if (grabBoxModel.type != 2) {
            Logger.a("drb", "setReceiveBtn 隐藏领取按钮  ");
            LiveMsgSendManager.a().d("setReceiveBtn 隐藏领取按钮");
            this.k.setVisibility(8);
            LiveEventBus.get(LiveEventBusUtil.l).post(false);
        } else if (this.f14283c) {
        } else {
            Logger.a("drb", "setReceiveBtn 显示领取按钮   ");
            LiveMsgSendManager.a().d("setReceiveBtn 显示领取按钮");
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            LiveEventBus.get(LiveEventBusUtil.l).post(true);
        }
    }

    public void a(BaseFragment baseFragment) {
        this.f14282a = baseFragment;
        if (baseFragment instanceof RecordingOnliveFragment) {
            this.f14283c = true;
            RecordingOnliveFragment recordingOnliveFragment = (RecordingOnliveFragment) baseFragment;
            this.n = recordingOnliveFragment;
            this.b = recordingOnliveFragment.getFragmentActive();
            this.t = this.n.t;
        } else if (baseFragment instanceof PlayingOnliveBaseModeFragment) {
            this.f14283c = false;
            PlayingOnliveBaseModeFragment playingOnliveBaseModeFragment = (PlayingOnliveBaseModeFragment) baseFragment;
            this.o = playingOnliveBaseModeFragment;
            this.b = playingOnliveBaseModeFragment.getFragmentActive();
            this.t = this.o.s;
        }
    }

    public void a(final GrabBoxModel grabBoxModel) {
        if (ClickUtils.a(R.id.receive_btn) || grabBoxModel == null) {
            return;
        }
        Logger.a("drb", "调用领取宝箱接口 id = ", grabBoxModel.box_id);
        LiveRoomHttpUtils.a(this.f, new BluedUIHttpResponse<BluedEntity<OpenBoxModel, OpenBoxModel>>() { // from class: com.blued.android.module.live_china.view.GrabBoxView.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(final Throwable th, final int i, final String str) {
                super.onFailure(th, i, str);
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.view.GrabBoxView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Pair<Integer, String> a2 = BluedHttpUtils.a(th, i, str);
                        Logger.a("drb", "领取宝箱失败 id = ", grabBoxModel.box_id);
                        if (a2 != null) {
                            if (a2.first.intValue() != 40301001) {
                                BluedHttpUtils.b(th, i, str);
                                return;
                            }
                            GrabBoxView.this.setBoxReceive(grabBoxModel.box_id);
                            Logger.a("drb", "领取宝箱失败 删除当前宝箱 id = ", grabBoxModel.box_id);
                            GrabBoxView.this.b(grabBoxModel);
                            GrabBoxView.this.c();
                            AppMethods.a((CharSequence) a2.second);
                        }
                    }
                });
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<OpenBoxModel, OpenBoxModel> bluedEntity) {
                if (bluedEntity == null || bluedEntity.extra == null) {
                    return;
                }
                OpenBoxModel openBoxModel = bluedEntity.extra;
                if (GrabBoxView.this.f14282a instanceof PlayingOnliveBaseModeFragment) {
                    LiveMsgSendManager a2 = LiveMsgSendManager.a();
                    a2.d("领取宝箱成功 id = " + grabBoxModel.box_id + "-- duration = " + grabBoxModel.duration);
                    Logger.a("drb", "领取宝箱成功 id = ", grabBoxModel.box_id, "-- duration = ", Integer.valueOf(grabBoxModel.duration));
                    LiveRefreshUIObserver.a().a(grabBoxModel);
                    LiveRefreshUIObserver.a().a(openBoxModel.num, openBoxModel.pic);
                    grabBoxModel.type = 4;
                    GrabBoxView.this.setBoxReceive(grabBoxModel.box_id);
                    GrabBoxView.this.c();
                    if (GrabBoxView.this.d()) {
                        Logger.a("drb", "领取宝箱成功 还有未领取的宝箱");
                        if (GrabBoxView.this.c(grabBoxModel.box_id)) {
                            Logger.a("drb", "当前宝箱队列含有当前领取的宝箱id 隐藏领取按钮");
                            GrabBoxView.this.setReceiveBtn(grabBoxModel);
                            Logger.a("drb", "领取宝箱成功 开启展示倒计时");
                            GrabBoxView.this.c(grabBoxModel);
                            GrabBoxView.this.s.removeCallbacksAndMessages(null);
                        }
                    } else {
                        Logger.a("drb", "领取宝箱成功 没有未领取的宝箱");
                        Logger.a("drb", "领取宝箱成功 隐藏领取按钮");
                        GrabBoxView.this.setReceiveBtn(grabBoxModel);
                    }
                    LiveRoomHttpUtils.d();
                    LiveEventBus.get(EventBusConstant.KEY_EVENT_LIVE_REFRESH_GIFT_LIST).post(true);
                }
            }
        }, this.q.box_id, this.t, this.b);
    }

    public void a(String str) {
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<GrabBoxDetailModel, GrabBoxDetailModel>>(this.b) { // from class: com.blued.android.module.live_china.view.GrabBoxView.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<GrabBoxDetailModel, GrabBoxDetailModel> bluedEntity) {
                if (bluedEntity == null || bluedEntity.extra == null) {
                    return;
                }
                GrabBoxDetailModel grabBoxDetailModel = bluedEntity.extra;
                InstantLog.a("live_activity_link_click");
                if (TextUtils.isEmpty(grabBoxDetailModel.url)) {
                    return;
                }
                if (GrabBoxView.this.f14282a instanceof PlayingOnliveBaseModeFragment) {
                    LiveRefreshUIObserver.a().b(grabBoxDetailModel.url, 0);
                } else if (GrabBoxView.this.f14282a instanceof RecordingOnliveFragment) {
                    ((RecordingOnliveFragment) GrabBoxView.this.f14282a).d(grabBoxDetailModel.url, 0);
                }
            }
        }, this.f14283c ? LiveRoomInfo.a().f() : LiveRoomManager.a().g(), str, this.b);
    }

    public boolean a(List<GrabBoxModel> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        GrabBoxModel grabBoxModel = list.get(0);
        if (this.q != null && grabBoxModel.type == 1 && grabBoxModel.index < this.q.index) {
            Logger.a("drb", "新宝箱消息的index小于老宝箱的index，那么丢弃这条消息");
            LiveMsgSendManager.a().d("新宝箱消息的index小于老宝箱的index，那么丢弃这条消息");
            return false;
        }
        this.p.addAll(list);
        List<GrabBoxModel> b = b(this.p);
        this.p = b;
        Collections.sort(b, new GrabBoxModel.GrabBoxModelComparator());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.p.size()) {
                break;
            }
            GrabBoxModel grabBoxModel2 = this.p.get(i2);
            LiveMsgSendManager a2 = LiveMsgSendManager.a();
            a2.d("model index = " + grabBoxModel2.index + ",,,,box_id = " + grabBoxModel2.box_id);
            Logger.a("drb", "model index = ", Integer.valueOf(grabBoxModel2.index), ",,,,box_id = ", grabBoxModel2.box_id);
            i = i2 + 1;
        }
        if (this.p.size() > 0) {
            this.q = this.p.get(0);
            Logger.a("drb", "收到宝箱消息 ＝ ", grabBoxModel.toString());
            LiveMsgSendManager a3 = LiveMsgSendManager.a();
            a3.d("收到宝箱消息 ＝ " + grabBoxModel.toString());
            Logger.a("drb", "初始化UI");
            a(this.q, true);
            b(this.q.progress_full_gif);
            b(this.q.box_gif);
        }
        if (grabBoxModel.type == 2) {
            setGrabViewVisible(0);
            GrabBoxModel grabBoxModel3 = this.q;
            if (grabBoxModel3 == null || TextUtils.isEmpty(grabBoxModel3.box_id) || !this.q.box_id.equals(grabBoxModel.box_id)) {
                Logger.a("drb", "这是宝箱开启消息 不是当前正在展示的宝箱");
                LiveMsgSendManager.a().d("这是宝箱开启消息 不是当前正在展示的宝箱");
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= this.p.size()) {
                        break;
                    }
                    GrabBoxModel grabBoxModel4 = this.p.get(i4);
                    if (TextUtils.isEmpty(grabBoxModel4.box_id) || !grabBoxModel4.box_id.equals(grabBoxModel.box_id)) {
                        i3 = i4 + 1;
                    } else {
                        a(grabBoxModel, grabBoxModel4);
                        if (!grabBoxModel4.isPlayAnim) {
                            LiveGiftModel liveGiftModel = new LiveGiftModel();
                            liveGiftModel.images_gif = this.q.progress_full_gif;
                            BaseFragment baseFragment = this.f14282a;
                            if (baseFragment instanceof PlayingOnliveBaseModeFragment) {
                                LiveSetDataObserver.a().b(liveGiftModel);
                            } else if (baseFragment instanceof RecordingOnliveFragment) {
                                this.n.b(liveGiftModel);
                            }
                            grabBoxModel4.isPlayAnim = true;
                            PlayGifObserver.a().b();
                        }
                    }
                }
                if (this.q.type == 4 && this.p.size() > 0) {
                    c(this.p.get(0));
                    setReceiveBtn(this.q);
                    this.s.removeCallbacksAndMessages(null);
                }
            } else {
                if (!this.q.isPlayAnim) {
                    Logger.a("drb", "这是宝箱开启消息 当前正在展示的宝箱");
                    LiveMsgSendManager.a().d("这是宝箱开启消息 当前正在展示的宝箱");
                    LiveGiftModel liveGiftModel2 = new LiveGiftModel();
                    liveGiftModel2.images_gif = this.q.progress_full_gif;
                    BaseFragment baseFragment2 = this.f14282a;
                    if (baseFragment2 instanceof PlayingOnliveBaseModeFragment) {
                        LiveSetDataObserver.a().b(liveGiftModel2);
                    } else if (baseFragment2 instanceof RecordingOnliveFragment) {
                        this.n.b(liveGiftModel2);
                    }
                    this.q.isPlayAnim = true;
                    PlayGifObserver.a().b();
                }
                this.q = grabBoxModel;
                Logger.a("drb", "这是宝箱开启消息 设置领取按钮状态");
                LiveMsgSendManager.a().d("这是宝箱开启消息 设置领取按钮状态");
                setReceiveBtn(this.q);
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= this.p.size()) {
                        break;
                    }
                    GrabBoxModel grabBoxModel5 = this.p.get(i6);
                    if (!TextUtils.isEmpty(grabBoxModel5.box_id) && grabBoxModel5.box_id.equals(grabBoxModel.box_id)) {
                        a(grabBoxModel, grabBoxModel5);
                        break;
                    }
                    i5 = i6 + 1;
                }
                Logger.a("drb", "宝箱开启消息 开始倒计时");
                LiveMsgSendManager.a().d("这是宝箱开启消息  开始倒计时");
                this.s.removeCallbacksAndMessages(null);
                this.s.postDelayed(new DurationThread(this.q), 1000L);
            }
            c();
            List<GrabBoxModel> list2 = this.p;
            setBoxProgress(list2.get(list2.size() - 1));
            return true;
        }
        if (grabBoxModel.type == 1) {
            setGrabViewVisible(0);
            if (this.q == null || TextUtils.isEmpty(grabBoxModel.box_id) || !this.q.box_id.equals(grabBoxModel.box_id)) {
                Logger.a("drb", "这是宝箱进度消息 -- 不是当前宝箱 ＝ ", grabBoxModel.box_id);
                LiveMsgSendManager a4 = LiveMsgSendManager.a();
                a4.d("这是宝箱进度消息 -- 不是当前宝箱 ＝ " + grabBoxModel.box_id);
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 >= this.p.size()) {
                        break;
                    }
                    GrabBoxModel grabBoxModel6 = this.p.get(i8);
                    if (!TextUtils.isEmpty(grabBoxModel6.box_id) && grabBoxModel6.box_id.equals(grabBoxModel.box_id)) {
                        a(grabBoxModel, grabBoxModel6);
                        break;
                    }
                    i7 = i8 + 1;
                }
            } else {
                Logger.a("drb", "这是宝箱进度消息 -- 当前宝箱 ＝ ", grabBoxModel.box_id);
                LiveMsgSendManager a5 = LiveMsgSendManager.a();
                a5.d("这是宝箱进度消息 -- 当前宝箱 ＝ " + grabBoxModel.box_id);
                this.q.progress = grabBoxModel.progress;
            }
            setBoxProgress(grabBoxModel);
        }
        if (grabBoxModel.type == 3) {
            setGrabViewVisible(0);
            Logger.a("drb", "这是宝箱失效消息");
            LiveMsgSendManager.a().d("这是宝箱失效消息");
            this.s.removeCallbacksAndMessages(0);
            Logger.a("drb", "停止 隐藏倒计时 GONE");
            LiveMsgSendManager.a().d("停止 隐藏倒计时 GONE");
            this.m.stop();
            this.l.setVisibility(8);
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= this.p.size()) {
                    break;
                }
                GrabBoxModel grabBoxModel7 = this.p.get(i10);
                Logger.a("drb", "列表中的数据有 index = ", Integer.valueOf(grabBoxModel7.index), "-- id = ", grabBoxModel7.box_id, "当前这条消息 index = ", Integer.valueOf(grabBoxModel.index));
                int i11 = i10;
                if (grabBoxModel7.index < grabBoxModel.index) {
                    Logger.a("drb", "------------列表中比这条消息小的index数据有 index = ", Integer.valueOf(grabBoxModel7.index), "-- id = ", grabBoxModel7.box_id);
                    this.p.remove(grabBoxModel7);
                    i11 = i10 - 1;
                }
                i9 = i11 + 1;
            }
            Logger.a("drb", "删除当前宝箱 id ＝ ", grabBoxModel.box_id);
            LiveMsgSendManager a6 = LiveMsgSendManager.a();
            a6.d("删除当前宝箱 id ＝ " + grabBoxModel.box_id);
            b(grabBoxModel);
        }
        if (grabBoxModel.type == 4) {
            Logger.a("drb", "这是宝箱已领取消息");
            LiveMsgSendManager.a().d("这是宝箱已领取消息");
            if (getBoxOpenNum() == 0) {
                Logger.a("drb", "没有可领取的宝箱");
                LiveMsgSendManager.a().d("没有可领取的宝箱");
                this.s.removeCallbacksAndMessages(null);
                this.s.postDelayed(new DurationThread(grabBoxModel), 1000L);
                a(grabBoxModel, true);
                b();
                return true;
            }
            GrabBoxModel grabBoxModel8 = this.p.get(1);
            Logger.a("drb", "有多个宝箱 id =", grabBoxModel8.box_id);
            LiveMsgSendManager a7 = LiveMsgSendManager.a();
            a7.d("有多个宝箱 id =" + grabBoxModel8.box_id);
            Logger.a("drb", "初始化宝箱 此时宝箱为队列中第二条");
            LiveMsgSendManager.a().d("初始化宝箱 此时宝箱为队列中第二条");
            a(grabBoxModel8, true);
            b();
            Logger.a("drb", "隐藏领取按钮");
            LiveMsgSendManager.a().d("隐藏领取按钮");
            setReceiveBtn(grabBoxModel);
            Logger.a("drb", "展示开启 倒计时");
            LiveMsgSendManager.a().d("展示开启 倒计时");
            c(grabBoxModel);
            return true;
        }
        return true;
    }

    public List<GrabBoxModel> b(List<GrabBoxModel> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return arrayList;
            }
            if (!arrayList.contains(list.get(i2))) {
                arrayList.add(list.get(i2));
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Tracker.onClick(view);
        if (view.getId() != R.id.grab_box_image) {
            if (view.getId() == R.id.receive_btn) {
                a(this.q);
                return;
            }
            return;
        }
        if (this.p.size() > 0) {
            List<GrabBoxModel> list = this.p;
            str = list.get(list.size() - 1).box_id;
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s.removeCallbacksAndMessages(null);
    }

    public void setGrabViewVisible(int i) {
        setVisibility(i);
        if (i == 0) {
            this.u = true;
        } else {
            this.u = false;
        }
    }
}
