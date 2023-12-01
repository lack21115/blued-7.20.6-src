package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.core.common.g.g;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveFunctionAdapter;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.BluedLiveTopCard;
import com.blued.android.module.live_china.model.LiveFunctionModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveMultiFunctionView;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMultiFunctionView.class */
public class LiveMultiFunctionView extends FrameLayout implements View.OnClickListener {
    private int A;
    public LiveEventListener a;
    private Context b;
    private LayoutInflater c;
    private View d;
    private View e;
    private View f;
    private RecyclerView g;
    private RecordingOnliveFragment h;
    private List<LiveFunctionModel> i;
    private LiveFunctionAdapter j;
    private CountDownTimer k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private PopupWindow z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.view.LiveMultiFunctionView$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMultiFunctionView$1.class */
    public class AnonymousClass1 implements BaseQuickAdapter.OnItemChildClickListener {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            LiveMultiFunctionView.this.h.aC();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            LiveMultiFunctionView.this.h.aB();
        }

        public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
            LiveFunctionModel b = LiveMultiFunctionView.this.j.b(i);
            if (b != null) {
                if (b.function_type == 0) {
                    if (!LiveRoomManager.a().t()) {
                        EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().d(), LiveRoomManager.a().g(), LiveProtos.BoxType.BEAUTY_FEATURE);
                    }
                    EventTrackLive.a(LiveProtos.Event.LIVE_SETTING_BEAUTY_BTN_CLICK);
                    LiveMultiFunctionView.this.a(new LiveMultiFunctionListener() { // from class: com.blued.android.module.live_china.view.LiveMultiFunctionView.1.1
                        @Override // com.blued.android.module.live_china.view.LiveMultiFunctionView.LiveMultiFunctionListener
                        public void onClose() {
                            LiveMultiFunctionView.this.h.ar();
                        }
                    });
                } else if (b.function_type == 1) {
                    if (!LiveRoomManager.a().t()) {
                        EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().d(), LiveRoomManager.a().g(), LiveProtos.BoxType.CAMERA_FEATURE);
                    }
                    LiveMultiFunctionView.this.h.switchCamera(view);
                } else if (b.function_type == 2) {
                    if (!LiveRoomManager.a().t()) {
                        EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().d(), LiveRoomManager.a().g(), LiveProtos.BoxType.MIRROR_FEATURE);
                    }
                    LiveMultiFunctionView.this.h.at();
                } else if (b.function_type == 3) {
                    LiveMultiFunctionView.this.h.as();
                } else if (b.function_type == 4) {
                    if (!LiveRoomManager.a().t()) {
                        EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().d(), LiveRoomManager.a().g(), LiveProtos.BoxType.TITLE_FEATURE);
                    }
                    if (LiveRoomManager.a().J()) {
                        AppMethods.d(R.string.live_game_tips);
                        return;
                    }
                    EventTrackLive.a(LiveProtos.Event.LIVE_SETTING_TITLE_BTN_CLICK);
                    LiveMultiFunctionView.this.a(new LiveMultiFunctionListener() { // from class: com.blued.android.module.live_china.view.LiveMultiFunctionView.1.2
                        @Override // com.blued.android.module.live_china.view.LiveMultiFunctionView.LiveMultiFunctionListener
                        public void onClose() {
                            LiveMultiFunctionView.this.h.cG.c();
                        }
                    });
                } else if (b.function_type == 5) {
                    if (!LiveRoomManager.a().t()) {
                        EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().d(), LiveRoomManager.a().g(), LiveProtos.BoxType.MAGIC_GESTURE);
                    }
                    LiveMultiFunctionView.this.a(new LiveMultiFunctionListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiFunctionView$1$z4Y1hMIvEj_iu6S5LEdxyYb2Lsw
                        @Override // com.blued.android.module.live_china.view.LiveMultiFunctionView.LiveMultiFunctionListener
                        public final void onClose() {
                            LiveMultiFunctionView.AnonymousClass1.this.b();
                        }
                    });
                } else if (b.function_type == 6) {
                    if (!LiveRoomManager.a().t()) {
                        EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().d(), LiveRoomManager.a().g(), LiveProtos.BoxType.DECORATIVE_STICKER);
                    }
                    LiveMultiFunctionView.this.a(new LiveMultiFunctionListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiFunctionView$1$EgI-yJgTFZfs5ZDGY-srPcyAlDo
                        @Override // com.blued.android.module.live_china.view.LiveMultiFunctionView.LiveMultiFunctionListener
                        public final void onClose() {
                            LiveMultiFunctionView.AnonymousClass1.this.a();
                        }
                    });
                } else if (b.function_type == 7) {
                    LiveMultiFunctionView.this.t = 0;
                    b.dot = LiveMultiFunctionView.this.t;
                    LiveMultiFunctionView.this.j.notifyDataSetChanged();
                    if (!LiveRoomManager.a().t()) {
                        EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().d(), LiveRoomManager.a().g(), LiveProtos.BoxType.SHOP_MALL);
                    }
                    LiveMultiFunctionView.this.a(new LiveMultiFunctionListener() { // from class: com.blued.android.module.live_china.view.LiveMultiFunctionView.1.3
                        @Override // com.blued.android.module.live_china.view.LiveMultiFunctionView.LiveMultiFunctionListener
                        public void onClose() {
                            if (LiveRoomInfo.a().j()) {
                                LiveMultiFunctionView.this.h.p("https://activity.blued.cn/hd/2020/free-shop?blued_mode=hide_nav");
                            } else {
                                LiveMultiFunctionView.this.h.p("https://activity-test.blued.cn/hd/2020/free-shop?blued_mode=hide_nav");
                            }
                        }
                    });
                } else if (b.function_type == 8) {
                    EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().d(), LiveRoomManager.a().g(), LiveProtos.BoxType.TOP_CARD_FEATURE);
                    LiveMultiFunctionView.this.s = 0;
                    b.dot = LiveMultiFunctionView.this.s;
                    LiveMultiFunctionView.this.j.notifyDataSetChanged();
                    LiveMultiFunctionView.this.g();
                } else if (b.function_type == 9) {
                    EventTrackLive.a(LiveProtos.Event.LIVE_FEATURE_BOX_CLICK, LiveRoomManager.a().d(), LiveRoomManager.a().g(), LiveProtos.BoxType.MUSIC);
                    LiveMultiFunctionView.this.u = 0;
                    b.dot = LiveMultiFunctionView.this.u;
                    LiveMultiFunctionView.this.j.notifyDataSetChanged();
                    LiveMultiFunctionView.this.a(new LiveMultiFunctionListener() { // from class: com.blued.android.module.live_china.view.LiveMultiFunctionView.1.4
                        @Override // com.blued.android.module.live_china.view.LiveMultiFunctionView.LiveMultiFunctionListener
                        public void onClose() {
                            LiveMultiFunctionView.this.h.bi();
                        }
                    });
                } else if (b.function_type != 10) {
                    if (b.function_type == 11) {
                        EventTrackLive.b(LiveProtos.Event.LIVE_FUNCTION_NOTICE_CLICK, LiveRoomManager.a().e());
                        LiveMultiFunctionView.this.w = 0;
                        b.dot = LiveMultiFunctionView.this.w;
                        LiveMultiFunctionView.this.j.notifyDataSetChanged();
                        LiveMultiFunctionView.this.a(new LiveMultiFunctionListener() { // from class: com.blued.android.module.live_china.view.LiveMultiFunctionView.1.6
                            @Override // com.blued.android.module.live_china.view.LiveMultiFunctionView.LiveMultiFunctionListener
                            public void onClose() {
                                LiveMultiFunctionView.this.h.ai();
                            }
                        });
                    }
                } else if (LiveMultiFunctionView.this.q) {
                    AppMethods.d(R.string.live_recording_title);
                } else {
                    EventTrackLive.b(LiveProtos.Event.LIVE_RECORD_SCREEN_START_CLICK, LiveRoomManager.a().e());
                    LiveMultiFunctionView.this.setRecording(true);
                    LiveMultiFunctionView.this.v = 0;
                    b.dot = LiveMultiFunctionView.this.v;
                    LiveMultiFunctionView.this.j.notifyDataSetChanged();
                    LiveMultiFunctionView.this.a(new LiveMultiFunctionListener() { // from class: com.blued.android.module.live_china.view.LiveMultiFunctionView.1.5
                        @Override // com.blued.android.module.live_china.view.LiveMultiFunctionView.LiveMultiFunctionListener
                        public void onClose() {
                            LiveMultiFunctionView.this.h.bn();
                        }
                    });
                }
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMultiFunctionView$LiveEventListener.class */
    public interface LiveEventListener {
        void onClose();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMultiFunctionView$LiveMultiFunctionListener.class */
    public interface LiveMultiFunctionListener {
        void onClose();
    }

    public LiveMultiFunctionView(Context context) {
        this(context, null);
    }

    public LiveMultiFunctionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveMultiFunctionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new ArrayList();
        this.m = true;
        this.u = 1;
        this.v = 1;
        this.w = 1;
        this.A = 0;
        this.b = context;
    }

    private PopupWindow a(String str, String str2, View.OnClickListener onClickListener, String str3, View.OnClickListener onClickListener2) {
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.pop_user_card_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_use_cancel);
        TextView textView2 = (TextView) inflate.findViewById(R.id.use_card_info);
        if (!TextUtils.isEmpty(str)) {
            textView2.setText(str);
        }
        textView.setText(str2);
        if (onClickListener != null) {
            textView.setOnClickListener(onClickListener);
        } else {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveMultiFunctionView.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    LiveMultiFunctionView.this.z.dismiss();
                }
            });
        }
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_use_now);
        textView3.setText(str3);
        textView3.setOnClickListener(onClickListener2);
        ((ImageView) inflate.findViewById(R.id.use_card_close)).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveMultiFunctionView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveMultiFunctionView.this.z.dismiss();
            }
        });
        if (this.z == null) {
            PopupWindow popupWindow = new PopupWindow(-1, -1);
            this.z = popupWindow;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.z.setOutsideTouchable(true);
            this.z.setFocusable(true);
        }
        this.z.setContentView(inflate);
        this.z.update();
        this.z.showAtLocation(this.h.getActivity().getWindow().getDecorView(), 17, 0, 0);
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        a(this.b.getResources().getString(R.string.live_card_use), this.b.getResources().getString(R.string.cancel), new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveMultiFunctionView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveMultiFunctionView.this.z.dismiss();
            }
        }, this.b.getResources().getString(R.string.live_use_now), new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveMultiFunctionView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveMultiFunctionView.this.c(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (this.h.aV()) {
            return;
        }
        this.o = z;
        List<LiveFunctionModel> functionData = getFunctionData();
        this.i = functionData;
        this.j.a(functionData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        int i2 = i / 6;
        this.A = i2;
        if (i % 6 > 0) {
            this.A = i2 + 1;
        }
        a(String.format(this.b.getResources().getString(R.string.live_card_waitting), Integer.valueOf(i), Integer.valueOf(this.A)), this.b.getResources().getString(R.string.cancel), new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveMultiFunctionView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveMultiFunctionView.this.z.dismiss();
            }
        }, this.b.getResources().getString(R.string.live_use_waitting), new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveMultiFunctionView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveMultiFunctionView.this.c(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final boolean z) {
        LiveRoomHttpUtils.a(LiveRoomManager.a().d(), new BluedUIHttpResponse<BluedEntityA<BluedLiveTopCard>>(this.h.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMultiFunctionView.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLiveTopCard> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.isEmpty()) {
                    return;
                }
                BluedLiveTopCard bluedLiveTopCard = bluedEntityA.data.get(0);
                if (bluedLiveTopCard.count <= 0) {
                    LiveMultiFunctionView.this.b(false);
                } else {
                    LiveMultiFunctionView.this.a(bluedLiveTopCard.count);
                }
                if (LiveMultiFunctionView.this.z != null) {
                    LiveMultiFunctionView.this.z.dismiss();
                }
                if (!z) {
                    ToastUtils.a(LiveMultiFunctionView.this.b.getResources().getString(R.string.live_use_toast), 0);
                } else if (LiveMultiFunctionView.this.A < 3) {
                    LiveMsgSendManager.a().a(-10003, LiveMultiFunctionView.this.b.getResources().getString(R.string.live_use_card_later));
                } else if (LiveMultiFunctionView.this.A == 3) {
                    LiveMsgSendManager.a().a(-10003, LiveMultiFunctionView.this.b.getResources().getString(R.string.live_use_card_watting));
                } else {
                    LiveMultiFunctionView.this.j();
                    LiveMsgSendManager.a().a(g.k, LiveMultiFunctionView.this.b.getResources().getString(R.string.live_use_card_notice));
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                if (i == 403021) {
                    ToastUtils.a("正在使用中，请稍后再试", 0);
                    return true;
                }
                return super.onUIFailure(i, str);
            }
        }, this.h.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.blued.android.module.live_china.view.LiveMultiFunctionView$10] */
    public void j() {
        Logger.d("LiveMultiFunctionView", "run timmer_3 ... ");
        this.k = new CountDownTimer((this.A - 3) * 60 * 1000, 1000L) { // from class: com.blued.android.module.live_china.view.LiveMultiFunctionView.10
            @Override // android.os.CountDownTimer
            public void onFinish() {
                Logger.d("LiveMultiFunctionView", "run timmer_3 onFinish ... ");
                LiveMultiFunctionView.this.A = 0;
                LiveMsgSendManager.a().a(-10003, LiveMultiFunctionView.this.b.getResources().getString(R.string.live_use_card_watting));
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        }.start();
    }

    public void a() {
        a((LiveMultiFunctionListener) null);
    }

    public void a(int i) {
        this.r = i;
        if (i <= 0) {
            b(false);
        } else {
            b(true);
        }
    }

    public void a(final LiveMultiFunctionListener liveMultiFunctionListener) {
        if (this.e.getVisibility() == 8) {
            return;
        }
        this.e.setVisibility(8);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out);
        this.e.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveMultiFunctionView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LiveMultiFunctionView.this.setVisibility(8);
                LiveMultiFunctionListener liveMultiFunctionListener2 = liveMultiFunctionListener;
                if (liveMultiFunctionListener2 != null) {
                    liveMultiFunctionListener2.onClose();
                }
                if (LiveMultiFunctionView.this.a != null) {
                    LiveMultiFunctionView.this.a.onClose();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    public void a(boolean z) {
        if (this.h.aV()) {
            return;
        }
        this.n = z;
        List<LiveFunctionModel> functionData = getFunctionData();
        this.i = functionData;
        this.j.a(functionData);
    }

    public void a(boolean z, RecordingOnliveFragment recordingOnliveFragment) {
        this.h = recordingOnliveFragment;
        LayoutInflater from = LayoutInflater.from(this.b);
        this.c = from;
        this.l = z;
        View inflate = from.inflate(z ? R.layout.live_multi_function_view_land : R.layout.live_multi_function_view, this);
        this.d = inflate;
        this.e = inflate.findViewById(R.id.ll_content);
        this.f = this.d.findViewById(R.id.live_multi_function_layer);
        this.g = this.d.findViewById(R.id.rv_function_list);
        this.g.setLayoutManager(new GridLayoutManager(this.b, 4));
        LiveFunctionAdapter liveFunctionAdapter = new LiveFunctionAdapter(getContext());
        this.j = liveFunctionAdapter;
        liveFunctionAdapter.setOnItemChildClickListener(new AnonymousClass1());
        List<LiveFunctionModel> functionData = getFunctionData();
        this.i = functionData;
        this.j.a(functionData);
        this.g.setAdapter(this.j);
        this.f.setOnClickListener(this);
    }

    public boolean b() {
        return getVisibility() == 0;
    }

    public void c() {
        i();
        setVisibility(0);
        this.e.setVisibility(0);
        this.e.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in);
        this.e.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveMultiFunctionView.2
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
        EventTrackLive.b(LiveProtos.Event.LIVE_FUNCTION_NOTICE_SHOW, LiveRoomManager.a().e());
    }

    public void d() {
        this.m = false;
        List<LiveFunctionModel> functionData = getFunctionData();
        this.i = functionData;
        this.j.a(functionData);
    }

    public void e() {
        this.t = 1;
        a(true);
    }

    public void f() {
        this.s = 1;
        b(true);
    }

    public void g() {
        LiveRoomHttpUtils.o(new BluedUIHttpResponse<BluedEntityA<BluedLiveTopCard>>(this.h.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMultiFunctionView.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLiveTopCard> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.isEmpty()) {
                    return;
                }
                BluedLiveTopCard bluedLiveTopCard = bluedEntityA.data.get(0);
                if (bluedLiveTopCard.queue_count <= 0) {
                    LiveMultiFunctionView.this.b(bluedLiveTopCard.queue_count);
                } else {
                    LiveMultiFunctionView.this.c(bluedLiveTopCard.queue_count);
                }
            }
        }, this.h.getFragmentActive());
    }

    public List<LiveFunctionModel> getFunctionData() {
        ArrayList arrayList = new ArrayList();
        if (this.l) {
            if (this.m) {
                arrayList.add(new LiveFunctionModel(0, getResources().getString(R.string.live_beauty), R.drawable.live_beauty_open));
            }
            arrayList.add(new LiveFunctionModel(1, getResources().getString(R.string.live_switch_camera), R.drawable.live_switch_carema));
            if (this.p) {
                arrayList.add(new LiveFunctionModel(3, getResources().getString(R.string.live_switch_flash_light), this.x ? R.drawable.flash_light_open : R.drawable.flash_light_close));
            } else {
                arrayList.add(new LiveFunctionModel(2, getResources().getString(R.string.live_switch_mirror), this.y ? R.drawable.live_mirror_open : R.drawable.live_mirror_close));
            }
            arrayList.add(new LiveFunctionModel(4, getResources().getString(R.string.live_title_record), R.drawable.live_reset_titile));
            return arrayList;
        }
        if (this.m) {
            arrayList.add(new LiveFunctionModel(0, getResources().getString(R.string.live_beauty), R.drawable.live_beauty_open));
        }
        arrayList.add(new LiveFunctionModel(1, getResources().getString(R.string.live_switch_camera), R.drawable.live_switch_carema));
        if (this.p) {
            arrayList.add(new LiveFunctionModel(3, getResources().getString(R.string.live_switch_flash_light), this.x ? R.drawable.flash_light_open : R.drawable.flash_light_close));
        } else {
            arrayList.add(new LiveFunctionModel(2, getResources().getString(R.string.live_switch_mirror), this.y ? R.drawable.live_mirror_open : R.drawable.live_mirror_close));
        }
        arrayList.add(new LiveFunctionModel(4, getResources().getString(R.string.live_title_record), R.drawable.live_reset_titile));
        arrayList.add(new LiveFunctionModel(11, getResources().getString(R.string.live_announce), R.drawable.live_announce, this.w));
        if (!this.h.aV()) {
            arrayList.add(new LiveFunctionModel(5, getResources().getString(R.string.live_record_level_gesture), R.drawable.live_gesture_icon));
            arrayList.add(new LiveFunctionModel(6, getResources().getString(R.string.live_record_level_sticker), R.drawable.live_sticker_icon));
            if (this.n) {
                arrayList.add(new LiveFunctionModel(7, getResources().getString(R.string.live_daily_task_mall), R.drawable.live_shop_titile, this.t));
            }
            if (this.o) {
                LiveFunctionModel liveFunctionModel = new LiveFunctionModel(8, getResources().getString(R.string.live_title_topcard), R.drawable.live_top_card, this.s, this.r);
                liveFunctionModel.item_type = 1;
                arrayList.add(liveFunctionModel);
            }
        }
        arrayList.add(new LiveFunctionModel(9, getResources().getString(R.string.live_music), R.drawable.live_music_icon, this.u));
        arrayList.add(new LiveFunctionModel(10, getResources().getString(this.q ? R.string.live_recording_tip2 : R.string.live_record_open), R.drawable.live_record_open, this.v));
        return arrayList;
    }

    public void h() {
        CountDownTimer countDownTimer = this.k;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void i() {
        List<LiveFunctionModel> functionData = getFunctionData();
        this.i = functionData;
        this.j.a(functionData);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_multi_function_layer) {
            a((LiveMultiFunctionListener) null);
        }
    }

    public void setFlashLightBtnState(boolean z) {
        LiveFunctionModel a = this.j.a(3);
        if (a == null) {
            return;
        }
        this.x = z;
        if (z) {
            a.icon = R.drawable.flash_light_open;
        } else {
            a.icon = R.drawable.flash_light_close;
        }
        this.j.notifyDataSetChanged();
    }

    public void setFlashLightVisibility(int i) {
        if (i == 0) {
            this.p = true;
            List<LiveFunctionModel> functionData = getFunctionData();
            this.i = functionData;
            this.j.a(functionData);
            return;
        }
        this.p = false;
        List<LiveFunctionModel> functionData2 = getFunctionData();
        this.i = functionData2;
        this.j.a(functionData2);
    }

    public void setLiveEventListener(LiveEventListener liveEventListener) {
        this.a = liveEventListener;
    }

    public void setMirrorBtnState(boolean z) {
        LiveFunctionModel a = this.j.a(2);
        if (a == null) {
            return;
        }
        this.y = z;
        if (z) {
            a.icon = R.drawable.live_mirror_open;
        } else {
            a.icon = R.drawable.live_mirror_close;
        }
        this.j.notifyDataSetChanged();
    }

    public void setRecording(boolean z) {
        this.q = z;
        i();
    }
}
