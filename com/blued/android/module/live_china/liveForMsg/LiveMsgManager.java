package com.blued.android.module.live_china.liveForMsg;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.internal.util.cm.SpamFilter;
import com.anythink.core.common.g.g;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.NetworkUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.listener.SysNetworkListener;
import com.blued.android.module.common.model.LiveFansLevelModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.CircleProgressView;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.view.animation.AnimationListenerAdapter;
import com.blued.android.module.live.base.view.animation.LiveAnimationView;
import com.blued.android.module.live.base.view.animation.LiveAnimationViewFactory;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveMultiDialogFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveFullModeFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveSimpleModeFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.liveForMsg.LiveMsgManager;
import com.blued.android.module.live_china.liveForMsg.model.LiveMsgBonusExtra;
import com.blued.android.module.live_china.liveForMsg.ui.LiveSendMsgTransitionAnimView;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.GiftAnimManager;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.EnumOperation;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveEntranceData;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveHornModelNew;
import com.blued.android.module.live_china.model.LiveMsgReportModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.model.MultiDialogModel;
import com.blued.android.module.live_china.model.MultiDialogResourceModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.msg.SendMsgListener;
import com.blued.android.module.live_china.observer.LiveFansObserver;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.observer.PushGuideObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.log.EventTrackLive;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.view.BarrageView;
import com.blued.android.module.live_china.view.BarrageViewMultiOneRow;
import com.blued.android.module.live_china.view.EntranceEffectLayout;
import com.blued.android.module.live_china.view.EntranceNormalLayout;
import com.blued.android.module.live_china.view.UserCardDialogFragment;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.Gson;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/LiveMsgManager.class */
public class LiveMsgManager implements SysNetworkListener, Serializable {
    private static String A = LiveMsgManager.class.getSimpleName();
    private String B;
    private String D;
    private ShapeLinearLayout E;
    private TextView F;
    private CircleProgressView G;
    private ImageView H;
    private View I;
    private String J;
    private long K;
    private Vibrator L;
    private View M;
    private View N;
    private View O;
    private View P;
    private GiftAnimManager Q;
    private View R;
    private View S;
    private Runnable W;
    public View a;
    public ViewGroup b;
    public ActivityFragmentActive c;
    public BaseFragment d;
    public boolean g;
    public Context i;
    public RecyclerView j;
    public TextView l;
    public View m;
    public LinearLayout n;
    public RecyclerView o;
    public RecyclerView p;
    public HotWordAdapter q;
    public HotEmojiAdapter r;
    public BarrageView s;
    public EntranceEffectLayout t;
    public EntranceNormalLayout u;
    public LiveAnimationView v;
    public BarrageViewMultiOneRow w;
    public int x;
    UserCardDialogFragment.UserCardOnclickListner z;
    public short e = -1;
    public long f = -1;
    public boolean h = true;
    private boolean C = false;
    public LiveMsgContentManager k = new LiveMsgContentManager();
    private int T = 0;
    private int U = 0;
    private int V = 0;
    private boolean X = false;
    Runnable y = new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.7
        @Override // java.lang.Runnable
        public void run() {
            if (LiveMsgManager.this.R != null) {
                LiveMsgManager.this.R.setVisibility(8);
            }
        }
    };
    private int Y = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.liveForMsg.LiveMsgManager$10  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/LiveMsgManager$10.class */
    public class AnonymousClass10 extends RecyclerView.OnScrollListener {
        AnonymousClass10() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            if (LiveMsgManager.this.l == null || LiveMsgManager.this.l.getVisibility() != 0) {
                return;
            }
            LiveMsgManager.this.l.setVisibility(8);
            LiveMsgManager.this.v();
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (LiveMsgManager.this.k.f()) {
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.-$$Lambda$LiveMsgManager$10$0jyJntWKFPNnHYxjEyElFGRXImw
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveMsgManager.AnonymousClass10.this.a();
                    }
                });
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/LiveMsgManager$HotEmojiAdapter.class */
    public class HotEmojiAdapter extends CommonRecycleAdapter<LiveZanExtraModel.EmojiModel> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.blued.android.module.live_china.liveForMsg.LiveMsgManager$HotEmojiAdapter$1  reason: invalid class name */
        /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/LiveMsgManager$HotEmojiAdapter$1.class */
        public class AnonymousClass1 implements SendMsgListener {
            final /* synthetic */ FrameLayout a;
            final /* synthetic */ LiveZanExtraModel.EmojiModel b;

            AnonymousClass1(FrameLayout frameLayout, LiveZanExtraModel.EmojiModel emojiModel) {
                this.a = frameLayout;
                this.b = emojiModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a(FrameLayout frameLayout, LiveZanExtraModel.EmojiModel emojiModel, Runnable runnable) {
                if (LiveMsgManager.this.d == null || LiveMsgManager.this.d.getFragmentActive() == null) {
                    return;
                }
                if (LiveMsgManager.this.l != null && LiveMsgManager.this.l.getVisibility() == 0) {
                    LiveMsgManager.this.l.setVisibility(8);
                }
                if (!LiveMsgManager.this.k.f()) {
                    LiveMsgManager.this.k.e();
                }
                new LiveSendMsgTransitionAnimView(HotEmojiAdapter.this.mContext).a((Activity) LiveMsgManager.this.d.getActivity(), LiveMsgManager.this.b, frameLayout, (View) LiveMsgManager.this.j, emojiModel, runnable);
            }

            @Override // com.blued.android.module.live_china.msg.SendMsgListener
            public void a() {
            }

            @Override // com.blued.android.module.live_china.msg.SendMsgListener
            public void a(final Runnable runnable) {
                if (LiveMsgManager.this.d == null || LiveMsgManager.this.d.getFragmentActive() == null) {
                    return;
                }
                final FrameLayout frameLayout = this.a;
                final LiveZanExtraModel.EmojiModel emojiModel = this.b;
                frameLayout.post(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.-$$Lambda$LiveMsgManager$HotEmojiAdapter$1$8uqHmOm-2H0PsO2jnwkfiURUD6U
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveMsgManager.HotEmojiAdapter.AnonymousClass1.this.a(frameLayout, emojiModel, runnable);
                    }
                });
            }

            @Override // com.blued.android.module.live_china.msg.SendMsgListener
            public void b() {
            }
        }

        public HotEmojiAdapter(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(LiveZanExtraModel.EmojiModel emojiModel, FrameLayout frameLayout, View view) {
            if (!LiveMsgManager.this.C || emojiModel.local) {
                MultiDialogModel multiDialogModel = new MultiDialogModel();
                multiDialogModel.close_type = 0;
                multiDialogModel.resource_type = 1;
                multiDialogModel.show_close_btn = true;
                multiDialogModel.from_type = 1;
                multiDialogModel.resource = new MultiDialogResourceModel();
                multiDialogModel.resource.url = LiveMsgManager.this.D;
                LiveMultiDialogFragment.a(LiveMsgManager.this.d.getChildFragmentManager(), multiDialogModel);
            } else if (SystemClock.elapsedRealtime() - LiveMsgManager.this.K < 3000 && StringUtils.a(emojiModel.id, LiveMsgManager.this.J)) {
                ToastUtils.b("发送过于频繁，请稍后再试~");
            } else {
                if (LiveMsgManager.this.X) {
                    EventTrackLive.b(LiveProtos.Event.LIVE_KEYBOARD_BARRAGE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), emojiModel.id);
                } else {
                    EventTrackLive.b(LiveProtos.Event.LIVE_SCREEN_BARRAGE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), emojiModel.id);
                }
                LiveMsgManager.this.K = SystemClock.elapsedRealtime();
                LiveMsgManager.this.J = emojiModel.id;
                LiveMsgSendManager.a().a(emojiModel, new AnonymousClass1(frameLayout, emojiModel));
                PushGuideObserver.d().c();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(final LiveZanExtraModel.EmojiModel emojiModel, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
            final FrameLayout frameLayout = (FrameLayout) commonAdapterHolder.a(R.id.sf_emoji);
            ImageView imageView = (ImageView) commonAdapterHolder.a(R.id.iv_emoji);
            ImageView imageView2 = (ImageView) commonAdapterHolder.a(R.id.iv_emoji_local);
            ImageView imageView3 = (ImageView) commonAdapterHolder.a(R.id.iv_emoji_lock);
            if (emojiModel.local) {
                frameLayout.setVisibility(8);
                imageView3.setVisibility(8);
                imageView2.setVisibility(0);
                ImageLoader.a(LiveMsgManager.this.c, R.drawable.live_emoji_default).a(imageView2);
            } else {
                frameLayout.setVisibility(0);
                imageView3.setVisibility(0);
                imageView2.setVisibility(8);
                if (emojiModel.w > 0 && emojiModel.h > 0) {
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.width = DensityUtils.a(AppInfo.d(), emojiModel.w / 2);
                    layoutParams.height = DensityUtils.a(AppInfo.d(), emojiModel.h / 2);
                    imageView.setLayoutParams(layoutParams);
                }
                if (LiveMsgManager.this.C) {
                    imageView.setAlpha(1.0f);
                    commonAdapterHolder.b(R.id.iv_emoji_lock, 8);
                } else {
                    imageView.setAlpha(0.5f);
                    commonAdapterHolder.b(R.id.iv_emoji_lock, 0);
                }
                ImageLoader.a(LiveMsgManager.this.c, emojiModel.url).a(imageView);
            }
            commonAdapterHolder.a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.-$$Lambda$LiveMsgManager$HotEmojiAdapter$NED3zCEp3Sf0aYhLS9aOPsqOIyw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveMsgManager.HotEmojiAdapter.this.a(emojiModel, frameLayout, view);
                }
            });
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return R.layout.item_live_msg_emoji;
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/LiveMsgManager$HotWordAdapter.class */
    public class HotWordAdapter extends CommonRecycleAdapter<LiveZanExtraModel.HotWords> {
        private boolean b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.blued.android.module.live_china.liveForMsg.LiveMsgManager$HotWordAdapter$1  reason: invalid class name */
        /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/LiveMsgManager$HotWordAdapter$1.class */
        public class AnonymousClass1 implements SendMsgListener {
            final /* synthetic */ LiveZanExtraModel.HotWords a;
            final /* synthetic */ TextView b;

            AnonymousClass1(LiveZanExtraModel.HotWords hotWords, TextView textView) {
                this.a = hotWords;
                this.b = textView;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a(TextView textView, Runnable runnable) {
                if (LiveMsgManager.this.d == null || LiveMsgManager.this.d.getFragmentActive() == null) {
                    return;
                }
                if (LiveMsgManager.this.l != null && LiveMsgManager.this.l.getVisibility() == 0) {
                    LiveMsgManager.this.l.setVisibility(8);
                }
                if (!LiveMsgManager.this.k.f()) {
                    LiveMsgManager.this.k.e();
                }
                new LiveSendMsgTransitionAnimView(HotWordAdapter.this.mContext).a(LiveMsgManager.this.d.getActivity(), LiveMsgManager.this.b, textView, LiveMsgManager.this.j, runnable);
                LiveMsgManager.this.h = false;
                if (LiveMsgManager.this.o == null || LiveMsgManager.this.o.getVisibility() != 0) {
                    return;
                }
                LiveMsgManager.this.o.setVisibility(8);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void c() {
                LiveMsgManager.this.o.setEnabled(true);
            }

            @Override // com.blued.android.module.live_china.msg.SendMsgListener
            public void a() {
                if (HotWordAdapter.this.b) {
                    InstantLog.b("live_quick_chat_click", this.a.id);
                }
            }

            @Override // com.blued.android.module.live_china.msg.SendMsgListener
            public void a(final Runnable runnable) {
                if (LiveMsgManager.this.d == null || LiveMsgManager.this.d.getFragmentActive() == null) {
                    return;
                }
                final TextView textView = this.b;
                textView.post(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.-$$Lambda$LiveMsgManager$HotWordAdapter$1$nVDrPssYcANZMsO6kRV4xNzyWks
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveMsgManager.HotWordAdapter.AnonymousClass1.this.a(textView, runnable);
                    }
                });
            }

            @Override // com.blued.android.module.live_china.msg.SendMsgListener
            public void b() {
                this.b.post(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.-$$Lambda$LiveMsgManager$HotWordAdapter$1$U0uIdyb73HNybzXGSq-rfg-n4h0
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveMsgManager.HotWordAdapter.AnonymousClass1.this.c();
                    }
                });
            }
        }

        public HotWordAdapter(Context context) {
            super(context);
            this.b = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(LiveZanExtraModel.HotWords hotWords, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, View view) {
            if (SystemClock.elapsedRealtime() - LiveMsgManager.this.K < 3000 && StringUtils.a(hotWords.id, LiveMsgManager.this.J)) {
                ToastUtils.b("发送过于频繁，请稍后再试~");
                return;
            }
            LiveMsgManager.this.o.setEnabled(false);
            LiveMsgManager.this.K = SystemClock.elapsedRealtime();
            LiveMsgManager.this.J = hotWords.id;
            LiveMsgSendManager.a().a(hotWords.text, true, (SendMsgListener) new AnonymousClass1(hotWords, (TextView) commonAdapterHolder.a(R.id.item_live_msg_hot_word_tv)));
            com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive.l(this.b ? LiveProtos.Event.LIVE_MSG_GUIDE_KEYBOARD_POP_CLICK : LiveProtos.Event.LIVE_MSG_GUIDE_POP_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), hotWords.id);
            PushGuideObserver.d().c();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(final LiveZanExtraModel.HotWords hotWords, int i, final CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
            commonAdapterHolder.a(R.id.item_live_msg_hot_word_tv, hotWords.text);
            commonAdapterHolder.a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.-$$Lambda$LiveMsgManager$HotWordAdapter$f3YzdQMmDLhvOFWQ4znBdIi9YaI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveMsgManager.HotWordAdapter.this.a(hotWords, commonAdapterHolder, view);
                }
            });
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return R.layout.item_live_msg_hot_word;
        }
    }

    public LiveMsgManager(BaseFragment baseFragment) {
        a(baseFragment);
        b();
        z();
        A();
    }

    private void A() {
        this.j.addOnScrollListener(new AnonymousClass10());
    }

    private void a(BaseFragment baseFragment) {
        if (baseFragment == null) {
            return;
        }
        this.i = baseFragment.getActivity();
        this.d = baseFragment;
        this.c = baseFragment.getFragmentActive();
        if (baseFragment instanceof RecordingOnliveFragment) {
            this.g = true;
            this.a = ((RecordingOnliveFragment) baseFragment).b;
            this.x = 1;
            PlayingOnliveFragment.cB = 1;
        } else if (baseFragment instanceof PlayingOnliveBaseModeFragment) {
            this.g = false;
            PlayingOnliveBaseModeFragment playingOnliveBaseModeFragment = (PlayingOnliveBaseModeFragment) baseFragment;
            this.a = playingOnliveBaseModeFragment.b;
            this.e = playingOnliveBaseModeFragment.r;
            this.f = playingOnliveBaseModeFragment.s;
            if (baseFragment instanceof PlayingOnliveSimpleModeFragment) {
                this.x = 0;
            } else if (baseFragment instanceof PlayingOnliveFullModeFragment) {
                this.x = 1;
            }
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final LiveRoomUserModel liveRoomUserModel) {
        LiveRoomHttpUtils.c(new BluedUIHttpResponse(this.d.getFragmentActive()) { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.9
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                if (!(LiveMsgManager.this.d instanceof RecordingOnliveFragment) || LiveMsgManager.this.d == null) {
                    return;
                }
                ((RecordingOnliveFragment) LiveMsgManager.this.d).k(liveRoomUserModel.avatar);
            }
        }, liveRoomUserModel.uid, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(final LiveGiftModel liveGiftModel) {
        LiveAnimationViewFactory.ScaleType scaleType = LiveAnimationViewFactory.ScaleType.CENTER_CROP;
        LiveAnimationViewFactory.ScaleType scaleType2 = LiveDataManager.a().f() ? LiveAnimationViewFactory.ScaleType.FIT_CENTER : LiveAnimationViewFactory.ScaleType.FIT_BOTTOM;
        HashMap hashMap = null;
        if (!TextUtils.isEmpty(liveGiftModel.luck_bag_img)) {
            hashMap = new HashMap();
            hashMap.put("KEY_LUCKY_BAG_IMG_URL", liveGiftModel.images_static);
            hashMap.put("KEY_LUCKY_BAG_GIFT_IMG_URL", liveGiftModel.luck_bag_img);
        }
        this.v.a(this.c, liveGiftModel.images_gif, liveGiftModel.images_apng2, liveGiftModel.images_mp4, liveGiftModel.anim_code, scaleType2, hashMap, new AnimationListenerAdapter() { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.12
            @Override // com.blued.android.module.live.base.view.animation.AnimationListenerAdapter, com.blued.android.module.live.base.view.animation.LiveAnimationListener
            public void b() {
                LiveSetDataObserver.a().a(liveGiftModel);
            }
        });
    }

    public static LiveFansLevelModel i(LiveChattingModel liveChattingModel) {
        LiveFansLevelModel liveFansLevelModel = new LiveFansLevelModel();
        if (liveChattingModel == null) {
            return liveFansLevelModel;
        }
        if ((liveChattingModel.fromId + "").equals(LiveRoomInfo.a().f())) {
            LiveFansInfoModel q = LiveRoomManager.a().q();
            if (q != null) {
                liveFansLevelModel.fan_club_name = q.name;
                liveFansLevelModel.fan_club_level = q.level;
                liveFansLevelModel.in_fan_club = q.fans_status;
                liveFansLevelModel.fans_status = q.fans_status;
                return liveFansLevelModel;
            }
        } else if (liveChattingModel.msgMapExtra != null) {
            liveFansLevelModel.fan_club_name = MsgPackHelper.getStringValue(liveChattingModel.msgMapExtra, "fan_club_name");
            liveFansLevelModel.fan_club_level = MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "fan_club_level");
            liveFansLevelModel.in_fan_club = MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "in_fan_club");
            liveFansLevelModel.fans_status = MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "fans_status");
            Log.i("xpp", "from map fan_club_info:" + liveFansLevelModel.fan_club_name + " : " + liveFansLevelModel.fan_club_level + "  : " + liveFansLevelModel.in_fan_club + " : " + liveFansLevelModel.fans_status);
            return liveFansLevelModel;
        } else {
            Gson f = AppInfo.f();
            LiveFansLevelModel liveFansLevelModel2 = null;
            try {
                if (!TextUtils.isEmpty(liveChattingModel.getMsgExtra())) {
                    liveFansLevelModel2 = (LiveFansLevelModel) f.fromJson(liveChattingModel.getMsgExtra(), LiveFansLevelModel.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
                liveFansLevelModel2 = null;
            }
            if (liveFansLevelModel2 != null) {
                liveFansLevelModel.fan_club_name = liveFansLevelModel2.fan_club_name;
                liveFansLevelModel.fan_club_level = liveFansLevelModel2.fan_club_level;
                liveFansLevelModel.in_fan_club = liveFansLevelModel2.in_fan_club;
                liveFansLevelModel.fans_status = liveFansLevelModel2.fans_status;
            }
            Log.i("xpp", "from gson fan_club_info:" + liveFansLevelModel.fan_club_name + " : " + liveFansLevelModel.fan_club_level + "  : " + liveFansLevelModel.in_fan_club + " : " + liveFansLevelModel.fans_status);
        }
        return liveFansLevelModel;
    }

    private boolean j(LiveChattingModel liveChattingModel) {
        boolean z = false;
        if (liveChattingModel.msgType == 33) {
            z = false;
            if (liveChattingModel.msgMapExtra.containsKey("gift_model")) {
                z = false;
                if (liveChattingModel.msgMapExtra.get("gift_model") instanceof LiveGiftModel) {
                    LiveGiftModel liveGiftModel = (LiveGiftModel) liveChattingModel.msgMapExtra.get("gift_model");
                    z = false;
                    if (liveGiftModel.is_luck_bag) {
                        z = false;
                        if ("GOODS".equals(liveGiftModel.type)) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        ShapeLinearLayout shapeLinearLayout;
        if (LiveRoomManager.a().p() == null || LiveRoomManager.a().y() == null || (shapeLinearLayout = this.E) == null || this.l == null || this.x == 0) {
            return;
        }
        if (shapeLinearLayout.getVisibility() == 8) {
            this.E.setVisibility(0);
        }
        if (this.l.getVisibility() == 8) {
            this.F.setVisibility(0);
        } else if (this.l.getVisibility() == 0) {
            this.F.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        TextView textView = this.l;
        if (textView != null) {
            textView.setVisibility(8);
            v();
        }
        this.k.e();
    }

    private void x() {
        if (!this.g && (this.I.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.I.getLayoutParams();
            int i = this.Y;
            if (i == 0) {
                layoutParams.rightMargin = DisplayUtil.a(AppInfo.d(), 8.0f);
            } else {
                layoutParams.rightMargin = i;
            }
            this.I.setLayoutParams(layoutParams);
        }
        if (this.j.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            int i2 = this.Y;
            if (i2 == 0) {
                layoutParams2.rightMargin = DisplayUtil.a(AppInfo.d(), 143.0f);
            } else {
                layoutParams2.rightMargin = i2;
            }
            this.j.setLayoutParams(layoutParams2);
        }
    }

    private boolean y() {
        BaseFragment baseFragment = this.d;
        boolean z = false;
        if (baseFragment instanceof PlayingOnliveBaseModeFragment) {
            z = false;
            if (baseFragment != null) {
                z = false;
                if (((PlayingOnliveBaseModeFragment) baseFragment).ai == 4) {
                    z = true;
                }
            }
        }
        return z;
    }

    private void z() {
        GiftAnimManager giftAnimManager = new GiftAnimManager();
        this.Q = giftAnimManager;
        giftAnimManager.a(this, this.n, this.c);
    }

    public void a() {
        GiftAnimManager giftAnimManager = this.Q;
        if (giftAnimManager == null) {
            return;
        }
        giftAnimManager.h();
    }

    public void a(int i) {
        this.j.setVisibility(LiveFloatManager.a().C() ? 8 : i);
        BarrageViewMultiOneRow barrageViewMultiOneRow = this.w;
        if (barrageViewMultiOneRow != null) {
            barrageViewMultiOneRow.setVisibility(i);
        }
    }

    public void a(LiveChattingModel liveChattingModel) {
        GiftAnimManager giftAnimManager = this.Q;
        if (giftAnimManager == null) {
            return;
        }
        giftAnimManager.a(liveChattingModel);
    }

    public void a(LiveEntranceData liveEntranceData) {
        if (y()) {
            return;
        }
        this.t.a(liveEntranceData);
    }

    public void a(LiveGiftModel liveGiftModel) {
        GiftAnimManager giftAnimManager = this.Q;
        if (giftAnimManager == null) {
            return;
        }
        giftAnimManager.d(liveGiftModel);
    }

    public void a(final LiveMsgReportModel liveMsgReportModel, final String str) {
        Context context = this.i;
        LiveRefreshUIObserver.a().a(CommonAlertDialog.a(context, (String) null, 20, context.getString(R.string.liveVideo_livingView_tips_reportReason), (String) null, this.i.getString(R.string.liveVideo_livingView_label_reportButton), "", (String) null, new CommonAlertDialog.TextOnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.11
            @Override // com.blued.android.module.live_china.same.tip.CommonAlertDialog.TextOnClickListener
            public void a(String str2) {
                LiveMsgReportModel liveMsgReportModel2 = liveMsgReportModel;
                if (liveMsgReportModel2 != null) {
                    liveMsgReportModel2.reportContent = str2;
                    LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>() { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.11.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        /* renamed from: a */
                        public void onUIUpdate(BluedEntityA<LiveRoomUserModel> bluedEntityA) {
                            AppMethods.a((CharSequence) AppInfo.d().getString(R.string.liveVideo_livingView_tips_reportSuccess));
                        }
                    }, liveMsgReportModel);
                } else {
                    String a = LiveUtils.a(LiveMsgManager.this.k.b(-1));
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(a)) {
                        str2 = str2 + "\n" + a;
                    } else if (TextUtils.isEmpty(str2)) {
                        if (TextUtils.isEmpty(a)) {
                            str2 = "";
                        } else {
                            str2 = "\n" + a;
                        }
                    }
                    Logger.b(LiveMsgManager.A, "举报手输内容加聊天记录拼接字符串==", str2);
                    if (!TextUtils.isEmpty(str2)) {
                        LiveRoomInfo.a().a(LiveMsgManager.this.i, str2, str, LiveMsgManager.this.f, LiveMsgManager.this.c);
                    }
                }
                KeyboardUtils.a((Activity) LiveMsgManager.this.d.getActivity());
            }
        }, (DialogInterface.OnClickListener) null));
    }

    public void a(LiveRoomData liveRoomData) {
        BaseFragment baseFragment = this.d;
        if (baseFragment == null) {
            return;
        }
        UserCardDialogFragment userCardDialogFragment = new UserCardDialogFragment(baseFragment);
        userCardDialogFragment.a(liveRoomData);
        userCardDialogFragment.show(this.d.getFragmentManager(), "userCardDialog");
    }

    public void a(LiveRoomUserModel liveRoomUserModel) {
        BaseFragment baseFragment = this.d;
        if (baseFragment == null) {
            return;
        }
        UserCardDialogFragment userCardDialogFragment = new UserCardDialogFragment(baseFragment);
        userCardDialogFragment.a(liveRoomUserModel);
        userCardDialogFragment.show(this.d.getFragmentManager(), "userCardDialog");
    }

    public void a(LiveZanExtraModel liveZanExtraModel) {
        if (liveZanExtraModel == null || this.g || LiveDataManager.a().f() || (this.d instanceof PlayingOnliveSimpleModeFragment)) {
            return;
        }
        this.D = liveZanExtraModel.desc_url;
        if (liveZanExtraModel.privilege_emoji != 1 || TypeUtils.a((List<?>) liveZanExtraModel.emoji)) {
            this.C = false;
        } else {
            this.C = true;
            LiveRoomManager.a().N().setCan_emoji(liveZanExtraModel.privilege_emoji);
        }
        if (this.C) {
            this.o.setVisibility(8);
            if (!TypeUtils.a((List<?>) liveZanExtraModel.emoji)) {
                x();
                if (!y()) {
                    PushGuideObserver.d().a(this.I);
                }
                this.p.setVisibility(0);
            }
        } else {
            this.p.setVisibility(8);
            if (!TypeUtils.a((List<?>) liveZanExtraModel.hot_words) && this.h) {
                x();
                if (!y()) {
                    PushGuideObserver.d().a(this.I);
                }
                this.o.setVisibility(0);
                this.q.setDataAndNotify(liveZanExtraModel.hot_words);
            }
        }
        if (TypeUtils.a((List<?>) liveZanExtraModel.emoji)) {
            return;
        }
        this.r.setDataAndNotify(liveZanExtraModel.emoji);
    }

    public void a(String str) {
        BaseFragment baseFragment = this.d;
        if (baseFragment == null) {
            return;
        }
        UserCardDialogFragment userCardDialogFragment = new UserCardDialogFragment(baseFragment);
        userCardDialogFragment.e(str);
        userCardDialogFragment.show(this.d.getFragmentManager(), "userCardDialog");
    }

    public void a(String str, int i) {
        BaseFragment baseFragment = this.d;
        if (baseFragment == null) {
            return;
        }
        UserCardDialogFragment userCardDialogFragment = new UserCardDialogFragment(baseFragment);
        userCardDialogFragment.a(str, i);
        userCardDialogFragment.show(this.d.getFragmentManager(), "userCardDialog");
    }

    public void a(String str, LiveMsgReportModel liveMsgReportModel) {
        BaseFragment baseFragment = this.d;
        if (baseFragment == null) {
            return;
        }
        UserCardDialogFragment userCardDialogFragment = new UserCardDialogFragment(baseFragment);
        userCardDialogFragment.a(str, liveMsgReportModel);
        userCardDialogFragment.show(this.d.getFragmentManager(), "userCardDialog");
    }

    @Override // com.blued.android.module.common.listener.SysNetworkListener
    public void a(boolean z) {
    }

    public void b() {
        View findViewById = this.a.findViewById(R.id.live_msg_main_root);
        this.m = findViewById;
        this.j = findViewById.findViewById(R.id.live_msg_content_pullrefresh);
        TextView textView = (TextView) this.a.findViewById(R.id.tv_msg_scroll_to_bottom);
        this.l = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    LiveMsgManager.this.w();
                    EventTrackLive.a(LiveProtos.Event.LIVE_NEW_MSG_CLICK, String.valueOf(LiveMsgManager.this.f), LiveMsgManager.this.B);
                }
            });
        }
        this.E = (ShapeLinearLayout) this.a.findViewById(R.id.fl_back_to_last_live_room);
        this.F = (TextView) this.a.findViewById(R.id.tv_back_to_last_live_room_tips);
        CircleProgressView circleProgressView = (CircleProgressView) this.a.findViewById(R.id.circle_progress);
        this.G = circleProgressView;
        if (circleProgressView != null) {
            circleProgressView.setValue(100.0f);
            this.G.setBarColor(this.i.getResources().getColor(R.color.syc_dark_C933CC));
            this.G.setRimWidth(DensityUtils.a(this.i, 2.5f));
            this.G.setRimColor(this.i.getResources().getColor(R.color.syc_dark_00000000));
            this.G.setBarWidth(DensityUtils.a(this.i, 2.5f));
            this.G.setBarStrokeCap(Paint.Cap.ROUND);
        }
        this.H = (ImageView) this.a.findViewById(R.id.iv_last_avatar);
        LiveRoomData y = LiveRoomManager.a().y();
        if (this.E != null && this.G != null && this.H != null && y != null && this.W == null && this.x == 1) {
            com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive.d(LiveProtos.Event.LIVE_PK_BACK_ROOM_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), String.valueOf(y.lid), y.profile != null ? y.profile.uid : "");
            Runnable runnable = new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LiveRoomManager.a().b((LiveRoomData) null);
                        LiveMsgManager.this.W = null;
                        LiveMsgManager.this.E.setVisibility(8);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            this.W = runnable;
            this.E.postDelayed(runnable, 5000L);
            this.E.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    LiveRoomData y2 = LiveRoomManager.a().y();
                    if (y2 != null) {
                        com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive.d(LiveProtos.Event.LIVE_PK_BACK_ROOM_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), String.valueOf(y2.lid), y2.profile != null ? y2.profile.uid : "");
                        LiveDataListManager.a().b(y2);
                    }
                    LiveRoomManager.a().b((LiveRoomData) null);
                }
            });
            v();
            this.G.setValue(100.0f);
            this.G.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.4
                @Override // java.lang.Runnable
                public void run() {
                    LiveMsgManager.this.G.a(0.0f, 5000L);
                }
            }, 500L);
            ImageLoader.a(this.c, y.profile != null ? y.profile.avatar : "").c().a(this.H);
        }
        this.n = (LinearLayout) this.a.findViewById(R.id.ll_gift_ani_root);
        this.s = (BarrageView) this.a.findViewById(R.id.barrage);
        this.t = (EntranceEffectLayout) this.a.findViewById(R.id.approach_effect_barrage);
        this.u = (EntranceNormalLayout) this.a.findViewById(R.id.approach_normal_barrage);
        this.v = (LiveAnimationView) this.a.findViewById(R.id.live_enter_animation);
        if (LiveFloatManager.a().C()) {
            this.w = (BarrageViewMultiOneRow) this.a.findViewById(R.id.multi_barrage);
            this.M = this.a.findViewById(R.id.barrage_occupy_view);
        } else {
            BarrageView barrageView = this.s;
            if (barrageView != null) {
                barrageView.b = 3;
            }
        }
        this.N = this.a.findViewById(R.id.occupy_view);
        this.O = this.a.findViewById(R.id.simple_model_high);
        this.P = this.a.findViewById(R.id.simple_model_low);
        this.R = this.a.findViewById(R.id.rl_msg_fans_reopen);
        View findViewById2 = this.a.findViewById(R.id.ll_msg_fans_reopen);
        this.S = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLive.a(LiveProtos.Event.LIVE_FANS_RENEW_TOAST_CLICK, String.valueOf(LiveMsgManager.this.f), LiveMsgManager.this.B);
                LiveMsgManager.this.R.removeCallbacks(LiveMsgManager.this.y);
                LiveMsgManager.this.R.setVisibility(8);
                LiveFansObserver.a().c();
            }
        });
        BarrageView barrageView2 = this.s;
        if (barrageView2 != null) {
            barrageView2.setBaseFragment(this.d);
        }
        BarrageViewMultiOneRow barrageViewMultiOneRow = this.w;
        if (barrageViewMultiOneRow != null) {
            barrageViewMultiOneRow.setBaseFragment(this.d);
        }
        GiftAnimManager giftAnimManager = this.Q;
        if (giftAnimManager != null) {
            giftAnimManager.a(this, this.n, this.c);
        }
        this.I = this.a.findViewById(R.id.live_msg_rv);
        RecyclerView findViewById3 = this.a.findViewById(R.id.live_msg_emoji_rv);
        this.p = findViewById3;
        findViewById3.setLayoutManager(new LinearLayoutManager(this.a.getContext(), 0, false));
        this.p.setHorizontalFadingEdgeEnabled(true);
        this.p.setFadingEdgeLength(DisplayUtil.a(AppInfo.d(), 30.0f));
        if (this.r == null) {
            this.r = new HotEmojiAdapter(this.p.getContext());
        }
        this.p.setAdapter(this.r);
        RecyclerView findViewById4 = this.a.findViewById(R.id.live_msg_hot_word_rv);
        this.o = findViewById4;
        findViewById4.setLayoutManager(new LinearLayoutManager(this.a.getContext(), 0, false));
        this.o.setHorizontalFadingEdgeEnabled(true);
        this.o.setFadingEdgeLength(DisplayUtil.a(AppInfo.d(), 30.0f));
        if (this.q == null) {
            this.q = new HotWordAdapter(this.o.getContext());
        }
        this.o.setAdapter(this.q);
        this.m.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.6
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                LiveMsgManager.this.m.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                LiveMsgManager.this.T = LiveMsgManager.this.m.getHeight();
                int[] iArr = new int[2];
                LiveMsgManager.this.m.getLocationOnScreen(iArr);
                LiveMsgManager.this.U = iArr[1];
                LiveMsgManager liveMsgManager = LiveMsgManager.this;
                liveMsgManager.b(liveMsgManager.V);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x01d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(int r6) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.b(int):void");
    }

    public void b(LiveChattingModel liveChattingModel) {
        GiftAnimManager giftAnimManager = this.Q;
        if (giftAnimManager == null) {
            return;
        }
        giftAnimManager.b(liveChattingModel);
    }

    public void b(LiveGiftModel liveGiftModel) {
        GiftAnimManager giftAnimManager = this.Q;
        if (giftAnimManager == null) {
            return;
        }
        giftAnimManager.e(liveGiftModel);
    }

    public void b(String str) {
        BaseFragment baseFragment = this.d;
        if (baseFragment == null) {
            return;
        }
        UserCardDialogFragment userCardDialogFragment = new UserCardDialogFragment(baseFragment);
        userCardDialogFragment.f(str);
        userCardDialogFragment.show(this.d.getFragmentManager(), "userCardDialog");
    }

    public void b(String str, LiveMsgReportModel liveMsgReportModel) {
        BaseFragment baseFragment = this.d;
        if (baseFragment == null) {
            return;
        }
        UserCardDialogFragment userCardDialogFragment = new UserCardDialogFragment(baseFragment);
        userCardDialogFragment.b(str, liveMsgReportModel);
        userCardDialogFragment.show(this.d.getFragmentManager(), "userCardDialog");
    }

    @Override // com.blued.android.module.common.listener.SysNetworkListener
    public void b(boolean z) {
        Logger.a("drb", "onWifiStatus = ", Boolean.valueOf(z));
        e(z);
    }

    public void c() {
        BaseFragment baseFragment = this.d;
        if (baseFragment == null || this.c == null) {
            return;
        }
        if (baseFragment instanceof RecordingOnliveFragment) {
            if (((RecordingOnliveFragment) baseFragment).x) {
                return;
            }
        } else if ((baseFragment instanceof PlayingOnliveBaseModeFragment) && LiveFloatManager.a().C()) {
            return;
        }
        if (y()) {
            return;
        }
        this.k.a(this.i, this.g, this.d, this.c, this.j);
        a(LiveRoomManager.a().Z());
        if (this.d instanceof PlayingOnliveFullModeFragment) {
            s();
        }
    }

    public void c(int i) {
        this.k.a(i);
    }

    public void c(LiveChattingModel liveChattingModel) {
        if (this.w != null && LiveFloatManager.a().C()) {
            if (y()) {
                return;
            }
            this.w.b(liveChattingModel);
            return;
        }
        BarrageView barrageView = this.s;
        if (barrageView != null) {
            barrageView.a(liveChattingModel);
        }
    }

    public void c(LiveGiftModel liveGiftModel) {
        GiftAnimManager giftAnimManager = this.Q;
        if (giftAnimManager == null) {
            return;
        }
        giftAnimManager.a(liveGiftModel);
    }

    public void c(String str, LiveMsgReportModel liveMsgReportModel) {
        if (TextUtils.isEmpty(str) || liveMsgReportModel == null) {
            return;
        }
        b(str, liveMsgReportModel);
    }

    public void c(boolean z) {
        if (z) {
            this.O.setVisibility(0);
            this.P.setVisibility(8);
            Logger.a("ddrb", "mSimpleModelHighView VISIBLE");
        } else if (LiveFloatManager.a().C()) {
        } else {
            this.O.setVisibility(8);
            Logger.a("ddrb", "mSimpleModelHighView GONE");
            this.P.setVisibility(0);
        }
    }

    public void d() {
        View view = this.R;
        if (view != null) {
            view.removeCallbacks(this.y);
        }
        g();
        LiveMsgContentManager liveMsgContentManager = this.k;
        if (liveMsgContentManager != null) {
            liveMsgContentManager.d();
        }
    }

    public void d(int i) {
        GiftAnimManager giftAnimManager = this.Q;
        if (giftAnimManager == null) {
            return;
        }
        giftAnimManager.a(i);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void d(LiveChattingModel liveChattingModel) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public void d(LiveGiftModel liveGiftModel) {
        GiftAnimManager giftAnimManager = this.Q;
        if (giftAnimManager == null) {
            return;
        }
        giftAnimManager.b(liveGiftModel);
    }

    public void d(String str, LiveMsgReportModel liveMsgReportModel) {
        if (TextUtils.isEmpty(str) || liveMsgReportModel == null) {
            return;
        }
        a(str, liveMsgReportModel);
    }

    public void d(boolean z) {
        this.k.b(z);
    }

    public void e() {
        if (this.R == null || LiveRoomPreferences.D()) {
            return;
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_FANS_RENEW_TOAST_SHOW, String.valueOf(this.f), this.B);
        this.R.setVisibility(0);
        this.R.postDelayed(this.y, 10000L);
        LiveRoomPreferences.E();
    }

    public void e(int i) {
        if (i == 0 && this.o.getVisibility() == 0) {
            this.o.setVisibility(8);
        } else if (i != 8 || this.g || LiveDataManager.a().f() || !(this.d instanceof PlayingOnliveFullModeFragment) || !this.h || this.q.getItemCount() <= 0) {
        } else {
            this.o.setVisibility(0);
        }
    }

    public void e(LiveChattingModel liveChattingModel) {
        this.k.a(liveChattingModel);
        if (liveChattingModel.msgType != 27 && liveChattingModel.msgType != 51 && liveChattingModel.msgType != 103 && liveChattingModel.msgType != 104) {
            LiveRoomManager.a().a(liveChattingModel);
        }
        if (LiveFloatManager.a().C()) {
            c(liveChattingModel);
            Logger.a("rrb", "addDanmaku");
        }
    }

    public void e(LiveGiftModel liveGiftModel) {
        GiftAnimManager giftAnimManager = this.Q;
        if (giftAnimManager == null) {
            return;
        }
        giftAnimManager.c(liveGiftModel);
    }

    public void e(boolean z) {
        Logger.a("drb", "onWifiNo = ", Boolean.valueOf(z));
        if (z) {
            return;
        }
        Logger.a("drb", "onWifiNo 横屏主态喇叭 ");
        LiveHornModelNew liveHornModelNew = new LiveHornModelNew();
        liveHornModelNew.contents = AppInfo.d().getString(R.string.Live_SendPresent_notWifi);
        liveHornModelNew.is_wifi = true;
        BaseFragment baseFragment = this.d;
        if (baseFragment instanceof RecordingOnliveFragment) {
            ((RecordingOnliveFragment) baseFragment).a(liveHornModelNew, true);
        } else if (baseFragment instanceof PlayingOnliveBaseModeFragment) {
            Logger.a("drb", "onWifiNo 横屏客态喇叭 ");
            LiveSetDataObserver.a().a(liveHornModelNew, true);
        }
    }

    public void f() {
    }

    public void f(int i) {
        this.Y = i;
        x();
    }

    public void f(LiveChattingModel liveChattingModel) {
        if (liveChattingModel == null) {
            return;
        }
        short s = liveChattingModel.msgType;
        if (s == 1 || s == 33) {
            g(liveChattingModel);
        }
    }

    public void f(final LiveGiftModel liveGiftModel) {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.-$$Lambda$LiveMsgManager$f-gvAnwsv_GRWtEBKoZuk5RI8Dg
            @Override // java.lang.Runnable
            public final void run() {
                LiveMsgManager.this.h(liveGiftModel);
            }
        }, g(liveGiftModel) ? 400L : 0L);
    }

    public void g() {
        Runnable runnable;
        if (this.Q == null) {
            return;
        }
        ShapeLinearLayout shapeLinearLayout = this.E;
        if (shapeLinearLayout != null && (runnable = this.W) != null) {
            shapeLinearLayout.removeCallbacks(runnable);
            this.W = null;
        }
        this.Q.e();
        this.Q = null;
        this.d = null;
    }

    public void g(LiveChattingModel liveChattingModel) {
        if (liveChattingModel == null) {
            return;
        }
        switch (liveChattingModel.msgType) {
            case -10007:
            case -10006:
            case -10005:
            case -10004:
            case g.j /* -10001 */:
            case -10000:
            case 275:
            case 276:
            case 279:
            case 286:
            case 287:
                h(liveChattingModel);
                return;
            case g.h /* -9999 */:
            case 221:
            case 245:
            case 251:
                h(liveChattingModel);
                return;
            case 1:
                if (!LiveRoomManager.a().A() || liveChattingModel.fromId == LiveRoomInfo.a().g()) {
                    h(liveChattingModel);
                    return;
                } else if (this.d instanceof PlayingOnliveSimpleModeFragment) {
                    return;
                } else {
                    int i = 0;
                    if (liveChattingModel.msgMapExtra != null) {
                        i = 0;
                        if (liveChattingModel.msgMapExtra.containsKey("is_history_data")) {
                            i = ((Integer) liveChattingModel.msgMapExtra.get("is_history_data")).intValue();
                        }
                    }
                    if (i == 1) {
                        h(liveChattingModel);
                        return;
                    } else {
                        LiveRoomManager.a().b(liveChattingModel);
                        return;
                    }
                }
            case 27:
            case 51:
            case 61:
            case 106:
            case 107:
            case 108:
            case 109:
            case 232:
                h(liveChattingModel);
                return;
            case 33:
                a(liveChattingModel);
                h(liveChattingModel);
                return;
            case 49:
                liveChattingModel.msgContent = AppInfo.d().getResources().getString(R.string.live_following);
                h(liveChattingModel);
                return;
            case 50:
                liveChattingModel.msgContent = AppInfo.d().getResources().getString(R.string.live_shared);
                h(liveChattingModel);
                return;
            case 102:
                Log.i("xpp", "MT_LIVECHAT_RICH_LEVEL");
                if (liveChattingModel.fromId == Integer.valueOf(LiveRoomInfo.a().f()).intValue()) {
                    Log.i("xpp", "MT_LIVECHAT_RICH_LEVEL :" + liveChattingModel.fromRichLevel);
                    LiveRoomInfo.a().a(liveChattingModel.fromRichLevel);
                }
                h(liveChattingModel);
                LiveMsgSendManager.a().d("收到财富等级升级消息：" + liveChattingModel.fromRichLevel);
                return;
            case 103:
            case 104:
                if ((this.d instanceof PlayingOnliveBaseModeFragment) && liveChattingModel.fromId == Integer.valueOf(LiveRoomInfo.a().f()).intValue()) {
                    if (LiveRoomManager.a().A()) {
                        LiveRoomManager.a().b(liveChattingModel);
                        return;
                    } else {
                        h(liveChattingModel);
                        return;
                    }
                }
                return;
            case 141:
                long longValue = MsgPackHelper.getLongValue(liveChattingModel.msgMapExtra, "type", 0L);
                if (longValue != 1) {
                    LiveEventBus.get(LiveEventBusUtil.k).post(Integer.valueOf(EnumOperation.VIEW_TYPE_FIRST_RECHARGE_GIFT_BAG.getValue()));
                    LiveMsgContentManager liveMsgContentManager = this.k;
                    if (liveMsgContentManager != null) {
                        liveMsgContentManager.g();
                    }
                }
                if (longValue != 2) {
                    LiveEventBus.get(LiveEventBusUtil.k).post(Integer.valueOf(EnumOperation.VIEW_TYPE_RECHARGE_GIFT_BAG.getValue()));
                    return;
                }
                return;
            case 155:
                if (!LiveRoomManager.a().t()) {
                    liveChattingModel.fromNickName = LiveRoomManager.a().p().profile.name;
                }
                h(liveChattingModel);
                LiveMsgSendManager.a().d("收到主播升级消息");
                return;
            case 223:
                a(liveChattingModel);
                return;
            case 224:
                if (LiveRoomManager.a().A()) {
                    LiveRoomManager.a().b(liveChattingModel);
                    return;
                } else {
                    h(liveChattingModel);
                    return;
                }
            case 249:
                h(liveChattingModel);
                return;
            case 267:
                if (liveChattingModel == null || liveChattingModel.msgMapExtra == null) {
                    return;
                }
                if (liveChattingModel.msgMapExtra.get("upgrade_streamer") != null && (liveChattingModel.msgMapExtra.get("upgrade_streamer") instanceof Long) && ((Long) liveChattingModel.msgMapExtra.get("upgrade_streamer")).longValue() == 1) {
                    liveChattingModel.msgMapExtra.put("isNobleUpgrade", true);
                    b(liveChattingModel);
                }
                if (liveChattingModel.msgMapExtra.get("upgrade_comment") != null && (liveChattingModel.msgMapExtra.get("upgrade_comment") instanceof Long) && ((Long) liveChattingModel.msgMapExtra.get("upgrade_comment")).longValue() == 1) {
                    h(liveChattingModel);
                    return;
                }
                return;
            case 273:
                if (this.d instanceof RecordingOnliveFragment) {
                    ((RecordingOnliveFragment) this.d).a(MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "fromUid", -1), MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "type", 1), MsgPackHelper.getStringValue(liveChattingModel.msgMapExtra, "toast", ""));
                    return;
                }
                return;
            case 274:
                if (this.d instanceof RecordingOnliveFragment) {
                    ((RecordingOnliveFragment) this.d).a(MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "fromUid", -1), MsgPackHelper.getIntValue(liveChattingModel.msgMapExtra, "type", 1), MsgPackHelper.getStringValue(liveChattingModel.msgMapExtra, "toast", ""), MsgPackHelper.getListValue(liveChattingModel.msgMapExtra, "groupPkUserList"));
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected boolean g(LiveGiftModel liveGiftModel) {
        if (liveGiftModel != null && liveGiftModel.vibrate_status == 1 && LiveDataManager.a().j()) {
            if (this.L == null) {
                this.L = (Vibrator) AppInfo.d().getSystemService("vibrator");
            }
            this.L.vibrate(400L);
            return true;
        }
        return false;
    }

    public void h() {
        GiftAnimManager giftAnimManager = this.Q;
        if (giftAnimManager == null) {
            return;
        }
        giftAnimManager.f();
    }

    public void h(LiveChattingModel liveChattingModel) {
        if (liveChattingModel == null) {
            return;
        }
        if (liveChattingModel.msgType == 61) {
            List<LiveMsgBonusExtra> parseBonusMap = LiveMsgBonusExtra.parseBonusMap(MsgPackHelper.getListValue(liveChattingModel.msgMapExtra, "bonus"));
            if (parseBonusMap != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= parseBonusMap.size()) {
                        break;
                    }
                    LiveMsgBonusExtra liveMsgBonusExtra = parseBonusMap.get(i2);
                    ArrayMap arrayMap = new ArrayMap();
                    MsgPackHelper.putMapValue((Map<String, Object>) arrayMap, "id", liveMsgBonusExtra.id);
                    MsgPackHelper.putMapValue((Map<String, Object>) arrayMap, SpamFilter.SpamContract.NotificationTable.COUNT, liveMsgBonusExtra.count);
                    MsgPackHelper.putMapValue((Map<String, Object>) arrayMap, "image", liveMsgBonusExtra.image);
                    if (liveMsgBonusExtra.profile != null) {
                        MsgPackHelper.putMapValue((Map<String, Object>) arrayMap, "uid", liveMsgBonusExtra.profile.uid);
                        MsgPackHelper.putMapValue((Map<String, Object>) arrayMap, "name", liveMsgBonusExtra.profile.name);
                    }
                    liveChattingModel.msgMapExtra = arrayMap;
                    this.k.a(liveChattingModel);
                    if (LiveFloatManager.a().C()) {
                        c(liveChattingModel);
                    }
                    i = i2 + 1;
                }
            }
        } else if (liveChattingModel.msgType == 27 || liveChattingModel.msgType == 51) {
            this.k.a(liveChattingModel);
            if (LiveFloatManager.a().C()) {
                c(liveChattingModel);
            }
        } else if (j(liveChattingModel)) {
            return;
        } else {
            e(liveChattingModel);
        }
        if (r()) {
            return;
        }
        if (TextUtils.equals(liveChattingModel.fromId + "", LiveRoomInfo.a().f()) || this.l.getVisibility() != 8) {
            return;
        }
        this.l.setVisibility(0);
        v();
    }

    public void i() {
        GiftAnimManager giftAnimManager = this.Q;
        if (giftAnimManager == null) {
            return;
        }
        giftAnimManager.a();
    }

    public List<LiveGiftModel> j() {
        GiftAnimManager giftAnimManager = this.Q;
        return giftAnimManager == null ? new ArrayList() : giftAnimManager.b();
    }

    public List<LiveGiftModel> k() {
        GiftAnimManager giftAnimManager = this.Q;
        return giftAnimManager == null ? new ArrayList() : giftAnimManager.c();
    }

    public void l() {
        this.X = true;
        if (this.j.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.bottomMargin = DisplayUtil.a(AppInfo.d(), 7.5f);
            this.j.setLayoutParams(layoutParams);
            e(0);
            if (this.g || LiveDataManager.a().f() || !(this.d instanceof PlayingOnliveFullModeFragment)) {
                return;
            }
            RecyclerView recyclerView = this.o;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            if (this.r.getItemCount() > 0) {
                if (!this.r.getDataList().get(0).local) {
                    LiveZanExtraModel.EmojiModel emojiModel = new LiveZanExtraModel.EmojiModel();
                    emojiModel.local = true;
                    this.r.getDataList().add(0, emojiModel);
                    this.r.notifyDataSetChanged();
                }
                RecyclerView recyclerView2 = this.p;
                if (recyclerView2 != null) {
                    recyclerView2.setVisibility(0);
                    ((ViewGroup.MarginLayoutParams) this.p.getLayoutParams()).bottomMargin = DensityUtils.a(AppInfo.d(), 10.0f);
                }
            }
        }
    }

    public void m() {
        this.X = false;
        if (this.j.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.j.setLayoutParams(layoutParams);
            e(8);
            if (this.g || LiveDataManager.a().f() || !(this.d instanceof PlayingOnliveFullModeFragment)) {
                return;
            }
            if (!this.C) {
                RecyclerView recyclerView = this.p;
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                }
                if (this.o == null || !this.h || this.q.getItemCount() <= 0) {
                    return;
                }
                this.o.setVisibility(0);
            } else if (this.r.getItemCount() > 0) {
                if (this.r.getDataList().get(0).local) {
                    this.r.getDataList().remove(0);
                    this.r.notifyDataSetChanged();
                }
                RecyclerView recyclerView2 = this.p;
                if (recyclerView2 != null) {
                    recyclerView2.setVisibility(0);
                    ((ViewGroup.MarginLayoutParams) this.p.getLayoutParams()).bottomMargin = DensityUtils.a(AppInfo.d(), 0.0f);
                }
            }
        }
    }

    public void n() {
        this.N.setVisibility(8);
    }

    public void o() {
        this.N.setVisibility(0);
    }

    public UserCardDialogFragment.UserCardOnclickListner p() {
        if (this.z == null) {
            this.z = new UserCardDialogFragment.UserCardOnclickListner() { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.8
                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void a() {
                    if (!(LiveMsgManager.this.d instanceof RecordingOnliveFragment)) {
                        LiveRefreshUIObserver.a().d(0);
                    } else if (((RecordingOnliveFragment) LiveMsgManager.this.d).x) {
                        ((RecordingOnliveFragment) LiveMsgManager.this.d).i(0);
                    } else {
                        ((RecordingOnliveFragment) LiveMsgManager.this.d).h(0);
                    }
                    LiveMsgManager.this.a(0);
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void a(LiveRoomUserModel liveRoomUserModel) {
                    if (LiveFloatManager.a().C()) {
                        AppMethods.d(R.string.no_landscape_mode);
                    } else if ((LiveMsgManager.this.d instanceof RecordingOnliveFragment) && LiveMsgManager.this.d != null && ((RecordingOnliveFragment) LiveMsgManager.this.d).d(false)) {
                        LiveMsgManager.this.b(liveRoomUserModel);
                    }
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void a(String str) {
                    LiveRoomHttpUtils.a(String.valueOf(LiveMsgManager.this.f), str, "2", new BluedUIHttpResponse() { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.8.3
                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        public void onUIUpdate(BluedEntity bluedEntity) {
                            AppMethods.d(R.string.live_forbid_to_speak_tip);
                        }
                    });
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void a(String str, LiveMsgReportModel liveMsgReportModel) {
                    if (CommonStringUtils.c(str) == LiveRoomManager.a().f()) {
                        LiveRefreshUIObserver.a().o();
                    } else {
                        LiveMsgManager.this.a(liveMsgReportModel, str);
                    }
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void a(final String str, final String str2) {
                    LiveRoomHttpUtils.a(String.valueOf(LiveMsgManager.this.f), str, new BluedUIHttpResponse(LiveMsgManager.this.c) { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.8.1
                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        public boolean onUIFailure(int i, String str3) {
                            AppMethods.a((CharSequence) str3);
                            return true;
                        }

                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        public void onUIUpdate(BluedEntity bluedEntity) {
                            AppMethods.d(R.string.live_kick_success);
                            LiveMsgSendManager.a().a(StringUtils.a(str, 0L), str2);
                        }
                    }, LiveMsgManager.this.c);
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void b() {
                    AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.8.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!(LiveMsgManager.this.d instanceof RecordingOnliveFragment)) {
                                LiveRefreshUIObserver.a().d(4);
                            } else if (((RecordingOnliveFragment) LiveMsgManager.this.d).x) {
                                ((RecordingOnliveFragment) LiveMsgManager.this.d).i(4);
                            } else {
                                ((RecordingOnliveFragment) LiveMsgManager.this.d).h(4);
                            }
                            LiveMsgManager.this.a(4);
                            Logger.a("drb", "onShow setChatViewVisibility");
                        }
                    });
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void b(final String str, final String str2) {
                    LiveRoomHttpUtils.a(String.valueOf(LiveMsgManager.this.f), str, "1", new BluedUIHttpResponse(LiveMsgManager.this.c) { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.8.2
                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        public void onUIUpdate(BluedEntity bluedEntity) {
                            ProfileData profileData = new ProfileData();
                            profileData.uid = StringUtils.a(str, 0L);
                            profileData.name = str2;
                            Logger.a("rrb", "uid = ", str);
                            Logger.a("rrb", "name = ", str2);
                            LiveMsgSendManager.a().b(profileData);
                            LiveEventBus.get("multi_dialog_banner").post(true);
                            AppMethods.d(R.string.live_forbid_to_speak_tip);
                        }
                    });
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void c() {
                    if (!(LiveMsgManager.this.d instanceof PlayingOnliveBaseModeFragment) || LiveMsgManager.this.d == null) {
                        return;
                    }
                    LiveRefreshUIObserver.a().b(true);
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void c(String str, String str2) {
                    LiveSetDataObserver.a().b(str2);
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void d() {
                    if (!(LiveMsgManager.this.d instanceof RecordingOnliveFragment) || LiveMsgManager.this.d == null) {
                        return;
                    }
                    ((RecordingOnliveFragment) LiveMsgManager.this.d).T();
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void d(final String str, final String str2) {
                    LiveRoomHttpUtils.a(String.valueOf(LiveMsgManager.this.f), str, "0", new BluedUIHttpResponse() { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgManager.8.4
                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        public void onUIUpdate(BluedEntity bluedEntity) {
                            ProfileData profileData = new ProfileData();
                            profileData.uid = CommonStringUtils.c(str);
                            profileData.name = str2;
                            LiveMsgSendManager.a().a(profileData);
                            LiveEventBus.get("multi_dialog_banner_cancel").post(true);
                            AppMethods.d(R.string.live_released_to_speak_tip);
                        }
                    });
                }
            };
        }
        return this.z;
    }

    public void q() {
        BaseFragment baseFragment = this.d;
        if (baseFragment instanceof RecordingOnliveFragment) {
            this.e = ((RecordingOnliveFragment) baseFragment).s;
            this.f = ((RecordingOnliveFragment) this.d).t;
            b();
        }
        if (NetworkUtils.a()) {
            e(false);
        }
    }

    public boolean r() {
        return this.k.f();
    }

    public void s() {
        if (this.d instanceof PlayingOnliveSimpleModeFragment) {
        }
    }

    public void t() {
        this.h = false;
        this.o.setVisibility(8);
    }
}
