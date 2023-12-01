package com.blued.android.module.live_china.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.lifecycle.Observer;
import com.android.internal.widget.LockPatternUtils;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.web.LoaderConstants;
import com.blued.android.module.live.base.event.LiveBeansChangeEvent;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.constant.LiveRoomConstants;
import com.blued.android.module.live_china.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live_china.fragment.LiveGiftFragmentDialogFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment;
import com.blued.android.module.live_china.liveForMsg.LiveMsgManager;
import com.blued.android.module.live_china.liveForMsg.ui.LiveSendMsgTransitionAnimView;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.live_interface.IDispatchTouchEvent;
import com.blued.android.module.live_china.live_interface.IScreenManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.manager.PlayGifObserver;
import com.blued.android.module.live_china.manager.PlayingMakeFriendManager;
import com.blued.android.module.live_china.manager.PlayingMakeLoverManager;
import com.blued.android.module.live_china.manager.PlayingModelManager;
import com.blued.android.module.live_china.manager.PlayingMultiConnectionManager;
import com.blued.android.module.live_china.manager.RecordingMultiConnectionManager;
import com.blued.android.module.live_china.model.EnumOperation;
import com.blued.android.module.live_china.model.FunctionRedPModelJson;
import com.blued.android.module.live_china.model.GrabBoxListModel;
import com.blued.android.module.live_china.model.GrabBoxModel;
import com.blued.android.module.live_china.model.LiveBarrageModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveDailyTaskExtra;
import com.blued.android.module.live_china.model.LiveDailyTaskModel;
import com.blued.android.module.live_china.model.LiveEntranceData;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftWallFloatModel;
import com.blued.android.module.live_china.model.LiveHornModelNew;
import com.blued.android.module.live_china.model.LiveInviteUserModel;
import com.blued.android.module.live_china.model.LiveJoinRoomExtraModel;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.model.LiveRankingHourConfig;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.LiveRoomAnchorModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.model.LiveRoomOperationModel;
import com.blued.android.module.live_china.model.LiveRoomTipsModel;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.LiveRoomWishingWellData;
import com.blued.android.module.live_china.model.LiveShareTextModel;
import com.blued.android.module.live_china.model.LiveSyntheticFragmentSuccessModel;
import com.blued.android.module.live_china.model.LiveWishItemModel;
import com.blued.android.module.live_china.model.LiveWishingDrawModel;
import com.blued.android.module.live_china.model.MultiDialogModel;
import com.blued.android.module.live_china.model.MuteLiveAudioModel;
import com.blued.android.module.live_china.model.RelationInfo;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.msg.SendMsgListener;
import com.blued.android.module.live_china.observer.BeansRefreshObserver;
import com.blued.android.module.live_china.observer.LiveFansObserver;
import com.blued.android.module.live_china.observer.LiveKeyboardObserver;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveRelationshipObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.observer.LiveSysNetworkObserver;
import com.blued.android.module.live_china.observer.PushGuideObserver;
import com.blued.android.module.live_china.pop.LiveCommonPopTips;
import com.blued.android.module.live_china.pop.LiveRecommendPop;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.model.LogData;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BackgroundTextView;
import com.blued.android.module.live_china.view.BadgeView;
import com.blued.android.module.live_china.view.BarrageHornView;
import com.blued.android.module.live_china.view.GrabRewardView;
import com.blued.android.module.live_china.view.HornViewNew;
import com.blued.android.module.live_china.view.LiveAnnouceView;
import com.blued.android.module.live_china.view.LiveDefinedRankView;
import com.blued.android.module.live_china.view.LiveMsgShimmerTextView;
import com.blued.android.module.live_china.view.LiveOnlineUserTipsView;
import com.blued.android.module.live_china.view.LivePKPlusView;
import com.blued.android.module.live_china.view.LiveRankingButtonView;
import com.blued.android.module.live_china.view.LiveUserFansView;
import com.blued.android.module.live_china.view.LiveViewerListView;
import com.blued.android.module.live_china.view.PopTaskView;
import com.blued.android.module.live_china.view.VolumeBrightnessView;
import com.blued.android.module.live_china.view.WishingWellBubbleView;
import com.blued.android.module.live_china.view.operation.LiveBottomOperationView;
import com.blued.android.module.live_china.view.operation.LiveOperationView;
import com.blued.android.module.live_china.view.pkdared.PkDaredView;
import com.blued.android.module.live_china.view.righttopfunction.LiveRightTopFunctionPlace;
import com.blued.android.module.live_china.view.shimmer.Shimmer;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGADrawable;
import com.blued.android.module.svgaplayer.SVGADynamicEntity;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/PlayingOnliveBaseModeFragment.class */
public class PlayingOnliveBaseModeFragment extends BaseFragment implements View.OnClickListener, View.OnTouchListener, Chronometer.OnChronometerTickListener, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone, IDispatchTouchEvent, PlayGifObserver.IPlayGifObserver, BeansRefreshObserver.IBeansRefreshObserver, LiveFansObserver.ILiveFansObserver, LiveRelationshipObserver.ILiveRelationshipObserver, LiveSetDataObserver.ILiveSetDataObserver, LiveSysNetworkObserver.ILiveSysNetworkObserver {
    public View A;
    public View B;
    public View C;
    public View D;
    public View E;
    public ImageView F;
    public ViewGroup G;
    public BadgeView H;
    public ImageView I;
    public View J;
    public View K;
    public FrameLayout L;
    public SVGAImageView M;
    public ImageView N;
    public View O;
    protected ImageView P;
    public WishingWellBubbleView Q;
    public View R;
    public EditText S;
    public TextView T;
    public ImageView U;
    public ToggleButton V;
    public BackgroundTextView W;
    public ViewGroup X;
    public boolean Y;
    public long Z;
    public View aA;
    public View aB;
    public View aC;
    public View aD;
    public View aE;
    public View aF;
    public View aG;
    public View aH;
    public FrameLayout aI;
    public ImageView aJ;
    public ShapeRelativeLayout aK;
    public ImageView aL;
    public LiveRightTopFunctionPlace aM;
    public LiveOperationView aN;
    public LiveBottomOperationView aO;
    public View aP;
    protected LiveDefinedRankView aQ;
    public LiveAnnouceView aR;
    public Dialog aS;
    public LiveRankingButtonView aT;
    protected LiveOnlineUserTipsView aW;
    public FrameLayout aa;
    public IScreenManager ab;
    public ImageView ac;
    public ImageView ad;
    public ImageView ae;
    public ImageView af;
    public ImageView ag;
    public ImageView ah;
    public int ai;
    public boolean aj;
    public View al;
    public View am;
    public LinearLayout an;
    public int ao;
    public int ap;
    public int aq;
    public int ar;
    public boolean at;
    public FrameLayout au;
    public View av;
    public View aw;
    public View ax;
    public View ay;
    public View az;
    public View b;
    LiveCommonPopTips bg;
    private SVGAImageView bh;
    private View bi;
    private LiveUserFansView bj;
    private ImageView bk;
    private RelativeLayout bl;
    private VolumeBrightnessView bm;
    private LiveMsgShimmerTextView bn;
    private Shimmer bo;
    private ImageView bp;
    private ImageView bq;
    private ImageView br;
    private PopTaskView bs;
    private boolean bt;
    private PopupWindow bu;
    private double bw;
    private String bx;
    private CountDownTimer by;
    public ViewGroup c;
    public ViewGroup d;
    public TextView e;
    public ViewGroup f;
    public ImageView g;
    public ViewGroup h;
    public TextView i;
    public TextView j;
    public ImageView k;
    public LiveViewerListView l;
    public HornViewNew m;
    public BarrageHornView n;
    public View o;
    public ImageView p;
    public LiveMsgManager q;
    public long s;
    public long t;
    public boolean u;
    public boolean v;
    public ViewGroup w;
    public PkDaredView x;
    public GrabRewardView y;
    public View z;
    public short r = 4;
    public boolean ak = false;
    public SimpleScreen as = new SimpleScreen();
    public boolean aU = false;
    protected boolean aV = false;
    private Observer bv = new Observer<String>() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.1
        /* renamed from: a */
        public void onChanged(String str) {
            PlayingOnliveBaseModeFragment.this.ac();
        }
    };
    public TextWatcher aX = new TextWatcher() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.23
        public int a;
        public int b;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i;
            this.a = PlayingOnliveBaseModeFragment.this.S.getSelectionStart();
            this.b = PlayingOnliveBaseModeFragment.this.S.getSelectionEnd();
            PlayingOnliveBaseModeFragment.this.S.removeTextChangedListener(PlayingOnliveBaseModeFragment.this.aX);
            if (AppInfo.m() && TextUtils.equals("test", editable.toString())) {
                AppMethods.a((CharSequence) "1012");
            }
            while (editable.length() > LiveRoomConstants.a && (i = this.a) != 0) {
                editable.delete(i - 1, this.b);
                this.a--;
                this.b--;
            }
            Logger.a("rrb", "editStart = ", Integer.valueOf(this.a));
            if (this.a >= 0) {
                PlayingOnliveBaseModeFragment.this.S.setSelection(this.a);
            }
            PlayingOnliveBaseModeFragment.this.S.addTextChangedListener(PlayingOnliveBaseModeFragment.this.aX);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    public Context a;
    GestureDetector aY = new GestureDetector(this.a, new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.26
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            Logger.a("drb", "双击事件");
            if (LiveRoomManager.a().p() != null && !PlayingOnliveBaseModeFragment.this.P() && PlayingOnliveBaseModeFragment.this.ai != 4) {
                LiveRefreshUIObserver.a().p();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (PlayingOnliveBaseModeFragment.this.bm != null) {
                PlayingOnliveBaseModeFragment.this.bm.a();
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (PlayingOnliveBaseModeFragment.this.ai == 1 || PlayingOnliveBaseModeFragment.this.ai == 0 || PlayingOnliveBaseModeFragment.this.bm == null) {
                return false;
            }
            PlayingOnliveBaseModeFragment.this.bm.a(PlayingOnliveBaseModeFragment.this.getActivity(), motionEvent, f, f2);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Logger.a("drb", "单击事件");
            int i = PlayingOnliveBaseModeFragment.this.ai;
            if (i == 0) {
                LiveRefreshUIObserver.a().p();
            } else if (i != 1) {
                if (i == 2) {
                    if (!PlayingOnliveBaseModeFragment.this.P()) {
                        LiveRefreshUIObserver.a().p();
                    }
                    if (PlayingOnliveBaseModeFragment.this.P()) {
                        PlayingOnliveBaseModeFragment.this.ab.c();
                        LogData logData = new LogData();
                        logData.D = "live_change_to_brief";
                        logData.n = String.valueOf(PlayingOnliveBaseModeFragment.this.s);
                        InstantLog.a(logData);
                    }
                } else if (i == 3) {
                    PlayingOnliveBaseModeFragment.this.ab.a();
                }
            } else if (!PlayingOnliveBaseModeFragment.this.P()) {
                LiveRefreshUIObserver.a().p();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    });
    GestureDetector aZ = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.28
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            Log.i("==makelover==", "onDoubleTapA");
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Log.i("==makelover==", "onSingleTapConfirmedA");
            if (PlayingOnliveBaseModeFragment.this.aa()) {
                LiveRefreshUIObserver.a().b(true, 0);
            } else {
                LiveRefreshUIObserver.a().a(true, 0);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    });
    GestureDetector ba = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.29
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            Log.i("==makelover==", "onDoubleTapB");
            if (PlayingOnliveBaseModeFragment.this.aa()) {
                LiveRefreshUIObserver.a().b(0);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Log.i("==makelover==", "onSingleTapConfirmedB");
            if (PlayingOnliveBaseModeFragment.this.aa()) {
                LiveRefreshUIObserver.a().b(false, 0);
            } else {
                LiveRefreshUIObserver.a().a(false, 0);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    });
    GestureDetector bb = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.30
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (PlayingOnliveBaseModeFragment.this.aa()) {
                LiveRefreshUIObserver.a().b(1);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (PlayingOnliveBaseModeFragment.this.aa()) {
                LiveRefreshUIObserver.a().b(false, 1);
            } else {
                LiveRefreshUIObserver.a().a(false, 1);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    });
    GestureDetector bc = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.31
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (PlayingOnliveBaseModeFragment.this.aa()) {
                LiveRefreshUIObserver.a().b(2);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (PlayingOnliveBaseModeFragment.this.aa()) {
                LiveRefreshUIObserver.a().b(false, 2);
            } else {
                LiveRefreshUIObserver.a().a(false, 2);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    });
    GestureDetector bd = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.32
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (PlayingOnliveBaseModeFragment.this.aa()) {
                LiveRefreshUIObserver.a().b(3);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (PlayingOnliveBaseModeFragment.this.aa()) {
                LiveRefreshUIObserver.a().b(false, 3);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    });
    GestureDetector be = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.33
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (PlayingOnliveBaseModeFragment.this.aa()) {
                LiveRefreshUIObserver.a().b(4);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (PlayingOnliveBaseModeFragment.this.aa()) {
                LiveRefreshUIObserver.a().b(false, 4);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    });
    Runnable bf = new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.36
        @Override // java.lang.Runnable
        public void run() {
            PlayingOnliveBaseModeFragment.this.aq();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment$21  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/PlayingOnliveBaseModeFragment$21.class */
    public class AnonymousClass21 implements SendMsgListener {
        final /* synthetic */ boolean a;

        AnonymousClass21(boolean z) {
            this.a = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(final boolean z, final Runnable runnable) {
            if (PlayingOnliveBaseModeFragment.this.getActivity() == null || PlayingOnliveBaseModeFragment.this.getActivity().isFinishing()) {
                return;
            }
            PlayingOnliveBaseModeFragment.this.q.t();
            PlayingOnliveBaseModeFragment.this.T.setEnabled(true);
            PlayingOnliveBaseModeFragment.this.T.setText("发送");
            PlayingOnliveBaseModeFragment.this.T.animate().alpha(1.0f).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.21.1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v52, types: [com.blued.android.module.live_china.view.LiveMsgShimmerTextView] */
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PlayingOnliveBaseModeFragment.this.getActivity() == null || PlayingOnliveBaseModeFragment.this.getActivity().isFinishing()) {
                        return;
                    }
                    if (z) {
                        if (!PlayingOnliveBaseModeFragment.this.q.k.f()) {
                            PlayingOnliveBaseModeFragment.this.q.l.setVisibility(8);
                            PlayingOnliveBaseModeFragment.this.q.k.e();
                        }
                        new LiveSendMsgTransitionAnimView(PlayingOnliveBaseModeFragment.this.a).a((Activity) PlayingOnliveBaseModeFragment.this.getActivity(), PlayingOnliveBaseModeFragment.this.c, PlayingOnliveBaseModeFragment.this.S.getText().toString(), (View) (PlayingOnliveBaseModeFragment.this.R.getVisibility() == 0 ? PlayingOnliveBaseModeFragment.this.S : PlayingOnliveBaseModeFragment.this.bn), (View) PlayingOnliveBaseModeFragment.this.q.j, runnable);
                    } else {
                        Runnable runnable2 = runnable;
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                    }
                    PlayingOnliveBaseModeFragment.this.S.setFocusableInTouchMode(true);
                    PlayingOnliveBaseModeFragment.this.S.setText("");
                }
            }).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            PlayingOnliveBaseModeFragment.this.T.animate().alpha(1.0f).setDuration(300L).setListener(null).start();
            PlayingOnliveBaseModeFragment.this.T.setEnabled(true);
            PlayingOnliveBaseModeFragment.this.T.setText("发送");
            PlayingOnliveBaseModeFragment.this.S.setFocusableInTouchMode(true);
        }

        @Override // com.blued.android.module.live_china.msg.SendMsgListener
        public void a() {
        }

        @Override // com.blued.android.module.live_china.msg.SendMsgListener
        public void a(final Runnable runnable) {
            if (PlayingOnliveBaseModeFragment.this.getActivity() == null || PlayingOnliveBaseModeFragment.this.getActivity().isFinishing()) {
                return;
            }
            EditText editText = PlayingOnliveBaseModeFragment.this.S;
            final boolean z = this.a;
            editText.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveBaseModeFragment$21$o46pDjBhgn1COVKEJI7aQ_ehU18
                @Override // java.lang.Runnable
                public final void run() {
                    PlayingOnliveBaseModeFragment.AnonymousClass21.this.a(z, runnable);
                }
            });
        }

        @Override // com.blued.android.module.live_china.msg.SendMsgListener
        public void b() {
            PlayingOnliveBaseModeFragment.this.S.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveBaseModeFragment$21$32OIh7x7iFA-SHzGJhmxNa514-k
                @Override // java.lang.Runnable
                public final void run() {
                    PlayingOnliveBaseModeFragment.AnonymousClass21.this.c();
                }
            });
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/PlayingOnliveBaseModeFragment$SimpleScreen.class */
    public class SimpleScreen implements Runnable {
        public SimpleScreen() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PlayingOnliveBaseModeFragment.this.ab == null || !LiveFloatManager.a().C() || PlayingOnliveBaseModeFragment.this.ai == 4) {
                return;
            }
            PlayingOnliveBaseModeFragment.this.ab.c();
            LogData logData = new LogData();
            logData.D = "live_change_to_brief";
            logData.n = String.valueOf(PlayingOnliveBaseModeFragment.this.s);
            InstantLog.a(logData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveBeansChangeEvent liveBeansChangeEvent) {
        if (liveBeansChangeEvent == null) {
            return;
        }
        a(liveBeansChangeEvent.totalScore, liveBeansChangeEvent.currentScore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveEntranceData liveEntranceData) {
        if (b()) {
            this.q.a(liveEntranceData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveJoinRoomExtraModel liveJoinRoomExtraModel) {
        if (this.J != null && liveJoinRoomExtraModel.getGoods() != null && liveJoinRoomExtraModel.getGoods().getRed_point() == 1) {
            this.J.setVisibility(0);
        }
        if (this.K == null || liveJoinRoomExtraModel.getRecharge() == null || liveJoinRoomExtraModel.getRecharge().getRed_point() != 1) {
            return;
        }
        this.K.setVisibility(0);
    }

    private void a(final LiveSyntheticFragmentSuccessModel liveSyntheticFragmentSuccessModel) {
        SVGAImageView sVGAImageView = this.bh;
        if (sVGAImageView == null || liveSyntheticFragmentSuccessModel == null) {
            return;
        }
        sVGAImageView.setVisibility(0);
        SVGAParser.a.b().a("live_gift_fragment.svga", new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.40

            /* renamed from: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment$40$1  reason: invalid class name */
            /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/PlayingOnliveBaseModeFragment$40$1.class */
            class AnonymousClass1 implements SVGACallback {
                AnonymousClass1() {
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static /* synthetic */ void a(LiveSyntheticFragmentSuccessModel liveSyntheticFragmentSuccessModel, View view, LiveGiftFragmentDialogFragment liveGiftFragmentDialogFragment) {
                    LiveRefreshUIObserver.a().k();
                    LiveProtos.Event event = LiveProtos.Event.LIVE_COMPOSE_SUCCESS_POP_GO_CLICK;
                    String e = LiveRoomManager.a().e();
                    String g = LiveRoomManager.a().g();
                    EventTrackLive.x(event, e, g, liveSyntheticFragmentSuccessModel.getGoods_id() + "");
                }

                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onFinished() {
                    PlayingOnliveBaseModeFragment.this.bh.setVisibility(8);
                    LiveGiftFragmentDialogFragment liveGiftFragmentDialogFragment = new LiveGiftFragmentDialogFragment(PlayingOnliveBaseModeFragment.this.requireContext(), liveSyntheticFragmentSuccessModel);
                    final LiveSyntheticFragmentSuccessModel liveSyntheticFragmentSuccessModel = liveSyntheticFragmentSuccessModel;
                    liveGiftFragmentDialogFragment.a(new LiveGiftFragmentDialogFragment.ConfirmClickCallback() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveBaseModeFragment$40$1$0vAt9k7vuCuGs84jjUwDmrAqFJI
                        @Override // com.blued.android.module.live_china.fragment.LiveGiftFragmentDialogFragment.ConfirmClickCallback
                        public final void onConfirmClick(View view, LiveGiftFragmentDialogFragment liveGiftFragmentDialogFragment2) {
                            PlayingOnliveBaseModeFragment.AnonymousClass40.AnonymousClass1.a(LiveSyntheticFragmentSuccessModel.this, view, liveGiftFragmentDialogFragment2);
                        }
                    });
                    liveGiftFragmentDialogFragment.show();
                }

                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onPause() {
                }

                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onRepeat() {
                }

                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onStep(int i, double d) {
                }
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity sVGAVideoEntity) {
                LiveProtos.Event event = LiveProtos.Event.LIVE_COMPOSE_SUCCESS_POP_SHOW;
                String e = LiveRoomManager.a().e();
                String g = LiveRoomManager.a().g();
                EventTrackLive.x(event, e, g, liveSyntheticFragmentSuccessModel.getGoods_id() + "");
                SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                String image = liveSyntheticFragmentSuccessModel.getImage();
                String str = image;
                if (image.contains("http://")) {
                    str = image.replace("http://", "https://");
                }
                sVGADynamicEntity.a(str, "candy");
                PlayingOnliveBaseModeFragment.this.bh.setImageDrawable(new SVGADrawable(sVGAVideoEntity, sVGADynamicEntity));
                PlayingOnliveBaseModeFragment.this.bh.a();
                PlayingOnliveBaseModeFragment.this.bh.setClearsAfterDetached(true);
                PlayingOnliveBaseModeFragment.this.bh.setCallback(new AnonymousClass1());
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveRecommendPop liveRecommendPop) {
        liveRecommendPop.b(this.am);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        LiveUserFansView liveUserFansView = this.bj;
        if (liveUserFansView != null) {
            liveUserFansView.setFansViewState(LiveUserFansView.getFANS_CLUB());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Integer num) {
        LiveOperationView liveOperationView = this.aN;
        if (liveOperationView != null) {
            liveOperationView.a(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (view.getId() == R.id.live_msg_send_edit) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            int action = motionEvent.getAction() & 255;
            if (action == 0 || action == 1) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(TextView textView, int i, KeyEvent keyEvent) {
        if (this.T.isEnabled()) {
            am();
            return true;
        }
        return true;
    }

    private void ad() {
        LiveEventBus.get("live_luck_turning_btn", Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.2
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                PlayingOnliveBaseModeFragment.this.af();
            }
        });
        LiveEventBus.get(LiveEventBusUtil.c, LiveEntranceData.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveBaseModeFragment$NC7im0MJjmNkU84VvjubxjqZfww
            public final void onChanged(Object obj) {
                PlayingOnliveBaseModeFragment.this.a((LiveEntranceData) obj);
            }
        });
        LiveEventBus.get("live_beans_change", LiveBeansChangeEvent.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveBaseModeFragment$asl1qYEoIottL_sMwiKlDRUSKBY
            public final void onChanged(Object obj) {
                PlayingOnliveBaseModeFragment.this.a((LiveBeansChangeEvent) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.C, LiveRoomFunctionItemModel.class).observe(this, new $$Lambda$iYY4pdGBSBhTTrGtmUvzVDHnEHs(this));
        LiveEventBus.get(LiveEventBusUtil.k, Integer.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveBaseModeFragment$3MHksk-tJ23oxkVbqEFEQM1O6mw
            public final void onChanged(Object obj) {
                PlayingOnliveBaseModeFragment.this.a((Integer) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.l, Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveBaseModeFragment$FIwmL6r_ehey06AWnfKBMCtSkyg
            public final void onChanged(Object obj) {
                PlayingOnliveBaseModeFragment.this.b((Boolean) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.b, LiveChattingModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveBaseModeFragment$MHJtKrpziWi9vTG-YlZ_OzCORqg
            public final void onChanged(Object obj) {
                PlayingOnliveBaseModeFragment.this.d((LiveChattingModel) obj);
            }
        });
        LiveEventBus.get("key_event_live_add_fans_club_success", Boolean.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveBaseModeFragment$ugItoiwnf3J-wIfvVCoXJg7KPwM
            public final void onChanged(Object obj) {
                PlayingOnliveBaseModeFragment.this.a((Boolean) obj);
            }
        });
        LiveEventBus.get("live_function_red_dot", LiveJoinRoomExtraModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveBaseModeFragment$ItF1gjpQ5_UfgSGDyjLUeJE9dBA
            public final void onChanged(Object obj) {
                PlayingOnliveBaseModeFragment.this.a((LiveJoinRoomExtraModel) obj);
            }
        });
        LiveEventBus.get("live_gift_fragment_play_svga", LiveSyntheticFragmentSuccessModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveBaseModeFragment$-Xknqsu7CCzWHPZhEEtgA6b7Rrg
            public final void onChanged(Object obj) {
                PlayingOnliveBaseModeFragment.this.b((LiveSyntheticFragmentSuccessModel) obj);
            }
        });
    }

    private void ae() {
        if (this.aj || PushGuideObserver.d().a()) {
            return;
        }
        final String c = TimeAndDateUtils.c();
        if (LiveRoomPreferences.P().equals(c)) {
            return;
        }
        this.am.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveBaseModeFragment$ZRcgRFpRqM5LB1-HyTVyPTkilkE
            @Override // java.lang.Runnable
            public final void run() {
                PlayingOnliveBaseModeFragment.this.i(c);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af() {
        LiveRoomData p = LiveRoomManager.a().p();
        LiveBottomOperationView liveBottomOperationView = this.aO;
        if (liveBottomOperationView == null || liveBottomOperationView.getWishingWellView() == null || p == null) {
            return;
        }
        if (this.u) {
            this.aO.getWishingWellView().setVisibility(8);
        } else if (p.entrance_status == 0) {
            this.aO.getWishingWellView().setVisibility(8);
        } else {
            this.aO.getWishingWellView().setVisibility(0);
            this.aO.getWishingWellView().setIcon(p.entrance_icon);
            LiveRoomWishingWellData liveRoomWishingWellData = p.entrance_extra;
            if (this.aj || liveRoomWishingWellData == null) {
                return;
            }
            Date date = new Date(System.currentTimeMillis());
            date.getYear();
            date.getMonth();
            date.getDate();
            if (PushGuideObserver.d().a() || TextUtils.isEmpty(liveRoomWishingWellData.star_expire_text)) {
                return;
            }
            WishingWellBubbleView wishingWellBubbleView = this.Q;
            if (wishingWellBubbleView == null || !wishingWellBubbleView.s()) {
                WishingWellBubbleView wishingWellBubbleView2 = new WishingWellBubbleView(this.a, liveRoomWishingWellData.star_expire_text, liveRoomWishingWellData.star_expire_url, false);
                this.Q = wishingWellBubbleView2;
                wishingWellBubbleView2.b(this.aO.getWishingWellView());
            }
        }
    }

    private void ag() {
        if (LiveRoomManager.a().p() == null || LiveRoomManager.a().p().rankingExtra == null) {
            return;
        }
        LiveEventBus.get("live_ranking_msg").post(LiveRoomManager.a().p().rankingExtra);
    }

    private void ah() {
        if (LiveRoomManager.a().p() == null || LiveRoomManager.a().p().rankingHourExtra == null) {
            return;
        }
        LiveEventBus.get("live_ranking_hour_msg").post(LiveRoomManager.a().p().rankingHourExtra);
    }

    private void ai() {
        LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntity<Object, LiveRankingHourConfig>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.12
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<Object, LiveRankingHourConfig> bluedEntity) {
                if (bluedEntity == null || bluedEntity.extra == null || PlayingOnliveBaseModeFragment.this.aT == null) {
                    return;
                }
                LiveRoomData p = LiveRoomManager.a().p();
                boolean z = true;
                if (bluedEntity.extra.config != 1) {
                    z = false;
                }
                p.isShowHourRank = z;
                if (PlayingOnliveBaseModeFragment.this.aT != null) {
                    PlayingOnliveBaseModeFragment.this.aT.a(LiveRoomManager.a().p().isShowHourRank);
                }
            }
        }, getFragmentActive());
    }

    private void aj() {
        LiveMsgManager liveMsgManager = new LiveMsgManager(this);
        this.q = liveMsgManager;
        if (!this.aj && !this.u) {
            liveMsgManager.c();
        }
        this.q.b = this.c;
    }

    private void ak() {
        if (LiveRoomManager.a().t()) {
            return;
        }
        this.e.setText(LiveRoomManager.a().p().profile.name);
        ImageLoader.a(getFragmentActive(), LiveRoomManager.a().p().profile.avatar).c().b(R.drawable.user_bg_round).a(this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        LiveRoomData p = LiveRoomManager.a().p();
        if (p != null) {
            EventTrackLive.a(LiveProtos.Event.USER_ANCHOR_FOLLOW_BTN_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), p.liveFrom, p.recommendType, p.livePosition);
        }
        N();
        InstantLog.a("live_followed");
        PushGuideObserver.d().c();
    }

    private void am() {
        if (TextUtils.isEmpty(this.S.getText().toString())) {
            AppMethods.d(R.string.chat_send_alert);
            return;
        }
        LiveRoomData p = LiveRoomManager.a().p();
        if (p != null) {
            EventTrackLive.a(LiveProtos.Event.LIVE_USER_MSG_SEND, LiveRoomManager.a().e(), LiveRoomManager.a().g(), p.liveFrom, p.recommendType, p.livePosition);
        }
        if (this.Y) {
            if (LiveRoomManager.a().t()) {
                return;
            }
            this.T.setEnabled(false);
            LiveGiftModel liveGiftModel = new LiveGiftModel();
            liveGiftModel.contents = CommonStringUtils.f(this.S.getText().toString());
            liveGiftModel.goods_id = String.valueOf(this.Z);
            LiveGiftPayTools.a().a(this.a, getFragmentManager(), this.r, this.s, getFragmentActive(), liveGiftModel, LiveRoomManager.a().g(), "", 1, new LiveGiftPayTools.BackGiftStatusListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.19
                @Override // com.blued.android.module.live_china.utils.LiveGiftPayTools.BackGiftStatusListener
                public void a() {
                    LiveRefreshUIObserver.a().b(true);
                }

                @Override // com.blued.android.module.live_china.utils.LiveGiftPayTools.BackGiftStatusListener
                public void a(final LiveGiftModel liveGiftModel2, final LiveGiftModel liveGiftModel3, List<LiveGiftModel> list) {
                    AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.19.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PlayingOnliveBaseModeFragment.this.T.setEnabled(true);
                            if (liveGiftModel3.sendGiftStatus == 3) {
                                String f = LiveRoomInfo.a().f();
                                int u = LiveRoomInfo.a().u();
                                LiveChattingModel liveChattingModel = new LiveChattingModel();
                                liveChattingModel.fromId = Long.valueOf(f).longValue();
                                liveChattingModel.fromVBadge = u;
                                liveChattingModel.fromAvatar = LiveRoomInfo.a().d();
                                liveChattingModel.fromNickName = LiveRoomInfo.a().c();
                                liveChattingModel.msgContent = liveGiftModel2.contents;
                                liveChattingModel.msgType = (short) 37;
                                liveChattingModel.fromRichLevel = LiveRoomInfo.a().r();
                                if (LiveFloatManager.a().w()) {
                                    liveChattingModel.fromLiveManager = 1;
                                }
                                LiveSetDataObserver.a().b(liveChattingModel);
                                PlayingOnliveBaseModeFragment.this.S.setText("");
                                LiveRefreshUIObserver.a().r();
                                PlayingOnliveBaseModeFragment.this.b(liveGiftModel3.danmu_count);
                            }
                        }
                    });
                }
            });
        } else if (ClickUtils.a(this.S.getId())) {
        } else {
            this.T.setEnabled(false);
            this.S.setFocusableInTouchMode(false);
            this.T.animate().alpha(0.3f).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.20
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PlayingOnliveBaseModeFragment.this.T.isEnabled()) {
                        return;
                    }
                    PlayingOnliveBaseModeFragment.this.T.setText("正在发送");
                }
            }).start();
            boolean z = false;
            if (!this.aj) {
                z = false;
                if (this.q != null) {
                    int i = this.ai;
                    z = false;
                    if (i != 4) {
                        z = false;
                        if (i != 2) {
                            z = true;
                        }
                    }
                }
            }
            LiveSetDataObserver.a().a(this.S, z, new AnonymousClass21(z));
        }
    }

    private void an() {
        EventTrackLive.a(LiveProtos.Event.LIVE_RECHARGE_BTN_CLICK);
        LiveRoomData p = LiveRoomManager.a().p();
        if (p != null) {
            EventTrackLive.a(LiveProtos.Event.USER_RECHARGE_CLICK, String.valueOf(p.lid), LiveRoomManager.a().g(), p.liveFrom, p.recommendType, p.livePosition);
        }
        int i = this.ai;
        if (i == 2 || i == 4) {
            LiveRefreshUIObserver.a().d();
        } else {
            LiveRefreshUIObserver.a().e();
        }
        LiveJoinRoomExtraModel liveJoinRoomExtraModel = LiveRoomManager.a().d;
        if (liveJoinRoomExtraModel != null && liveJoinRoomExtraModel.getRecharge() != null && liveJoinRoomExtraModel.getRecharge().getRed_point() == 1 && liveJoinRoomExtraModel.getRecharge().getRed_point_cancel() == 1) {
            LiveRoomHttpUtils.b((BluedUIHttpResponse) null, liveJoinRoomExtraModel.getRecharge().getRed_point_word());
            liveJoinRoomExtraModel.getRecharge().setRed_point(0);
            liveJoinRoomExtraModel.getRecharge().setRed_point_cancel(0);
            this.K.setVisibility(8);
        }
        View view = this.K;
        if (view == null || view.getVisibility() != 0 || this.K.getTag() == null) {
            return;
        }
        FunctionRedPModelJson functionRedPModelJson = (FunctionRedPModelJson) this.K.getTag();
        String red_point_word = functionRedPModelJson.getRed_point_word();
        if (Boolean.valueOf(functionRedPModelJson.getRed_point_cancel()).booleanValue()) {
            LiveRoomHttpUtils.b((BluedUIHttpResponse) null, red_point_word);
            this.K.setVisibility(8);
        }
    }

    private void ao() {
        if (LiveRoomInfo.a().a(this.a, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveRefreshUIObserver.a().b(true);
            }
        })) {
            return;
        }
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap() {
        if (this.u || P() || PlayingOnliveFragment.cB == 0 || !TextUtils.isEmpty(this.S.getText().toString())) {
            return;
        }
        this.q.e(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq() {
        Log.i("xpp", "getLiveDailyTask");
        LiveRoomHttpUtils.i(new BluedUIHttpResponse<BluedEntity<LiveDailyTaskModel, LiveDailyTaskExtra>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.37
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveDailyTaskModel, LiveDailyTaskExtra> bluedEntity) {
                if (bluedEntity.extra != null) {
                    if (bluedEntity.extra.login_task_status == 1 && LiveRoomPreferences.F()) {
                        LiveMsgSendManager.a().g();
                        if (LiveRoomManager.a().p() == null || LiveRoomManager.a().p().profile == null) {
                            return;
                        }
                        EventTrackLive.a(LiveProtos.Event.LIVE_TODAY_WELFARE_TOAST_SHOW, String.valueOf(PlayingOnliveBaseModeFragment.this.s), LiveRoomManager.a().g());
                    } else if (bluedEntity.extra.exist_not_receive_task == 1 && LiveRoomPreferences.H()) {
                        LiveMsgSendManager.a().f();
                        if (LiveRoomManager.a().p() == null || LiveRoomManager.a().p().profile == null) {
                            return;
                        }
                        EventTrackLive.a(LiveProtos.Event.LIVE_GLOW_STICK_TOAST_SHOW, String.valueOf(PlayingOnliveBaseModeFragment.this.s), LiveRoomManager.a().g());
                    }
                }
            }
        }, getFragmentActive());
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment$38] */
    private void ar() {
        this.by = new CountDownTimer(5000L, 1000L) { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.38
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (PlayingOnliveBaseModeFragment.this.bu != null) {
                    PlayingOnliveBaseModeFragment.this.bu.dismiss();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(LiveSyntheticFragmentSuccessModel liveSyntheticFragmentSuccessModel) {
        if (!this.aj || this.u) {
            a(liveSyntheticFragmentSuccessModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Boolean bool) {
        LiveOperationView liveOperationView = this.aN;
        if (liveOperationView != null) {
            liveOperationView.a(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(LiveChattingModel liveChattingModel) {
        LiveMsgManager liveMsgManager;
        if (!this.u || liveChattingModel == null || (liveMsgManager = this.q) == null) {
            return;
        }
        liveMsgManager.f(liveChattingModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(String str) {
        if (isVisible()) {
            LiveRoomPreferences.A(str);
            new LiveRecommendDialogFragment(this.a, ab(), true).show(getFragmentManager(), "recommendDialog");
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void A() {
        if (this.u) {
            return;
        }
        g();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void B() {
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.14
            @Override // java.lang.Runnable
            public void run() {
                if (!PlayingOnliveBaseModeFragment.this.aj || PlayingOnliveBaseModeFragment.this.u) {
                    PlayingOnliveBaseModeFragment.this.l.a();
                    if ((LiveRoomManager.a().x().size() <= 0 && LiveRoomManager.a().w().size() <= 0) || PlayingOnliveBaseModeFragment.this.aW == null || PlayingOnliveBaseModeFragment.this.ak) {
                        return;
                    }
                    PlayingOnliveBaseModeFragment.this.ak = true;
                    PlayingOnliveBaseModeFragment.this.aW.a(10, "PlayingLive", PlayingOnliveBaseModeFragment.this.getChildFragmentManager());
                }
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void B_() {
        U();
        k();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void C() {
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.15
            @Override // java.lang.Runnable
            public void run() {
                long v = LiveRoomManager.a().v();
                Logger.a("drb", "refreshAllCount count = ", Long.valueOf(v));
                if (PlayingOnliveBaseModeFragment.this.getFragmentActive() == null || !PlayingOnliveBaseModeFragment.this.getFragmentActive().isActive()) {
                    return;
                }
                Logger.a("drb", "isActive refreshAllCount count = ", Long.valueOf(v));
                if (v >= 0) {
                    PlayingOnliveBaseModeFragment.this.i.setText(CommonStringUtils.d(String.valueOf(v)) + PlayingOnliveBaseModeFragment.this.getString(R.string.live_share_viewersCount));
                }
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void C_() {
        this.A.setVisibility(8);
        this.F.setVisibility(8);
        this.D.setVisibility(8);
        this.E.setVisibility(8);
        this.B.setVisibility(0);
        this.C.setVisibility(0);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void D() {
        this.at = false;
        LiveKeyboardObserver.a().c();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void D_() {
        if (this.bo == null) {
            this.bo = new Shimmer();
        }
        LiveMsgShimmerTextView liveMsgShimmerTextView = this.bn;
        if (liveMsgShimmerTextView != null) {
            this.bo.a((Shimmer) liveMsgShimmerTextView);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void E() {
        this.q.g();
        this.bg = null;
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void E_() {
        int i = AppInfo.l / 2;
        int i2 = PlayingMakeFriendManager.a;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i2 * 2);
        layoutParams.setMargins(0, PlayingMakeFriendManager.c, 0, 0);
        this.au.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i, i2);
        layoutParams3.leftMargin = i;
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i, i2);
        layoutParams4.topMargin = i2;
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(i, i2);
        layoutParams5.leftMargin = i;
        layoutParams5.topMargin = i2;
        this.av.setLayoutParams(layoutParams2);
        this.aw.setLayoutParams(layoutParams3);
        this.ax.setLayoutParams(layoutParams4);
        this.ay.setLayoutParams(layoutParams5);
        this.au.setVisibility(0);
        this.av.setVisibility(0);
        this.aw.setVisibility(0);
        this.ax.setVisibility(0);
        this.ay.setVisibility(0);
        this.az.setVisibility(8);
        this.aA.setVisibility(8);
    }

    @Override // com.blued.android.module.live_china.manager.PlayGifObserver.IPlayGifObserver
    public void F() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void F_() {
    }

    public void G() {
        List<LiveGiftModel> j = this.q.j();
        if (j.size() > 0) {
            this.v = true;
            LiveGiftModel liveGiftModel = j.get(0);
            Logger.a("drb", "播放全屏动画 playFullScreenAnim Observer notify ");
            if (this.ai == 4 && liveGiftModel.anim_code != "hongbao") {
                c(liveGiftModel);
            } else if (liveGiftModel.enterAnimLocal) {
                this.q.f(liveGiftModel);
            } else {
                LiveRefreshUIObserver.a().a(liveGiftModel);
            }
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void G_() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void H() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void H_() {
        RecordingMultiConnectionManager.b(this.aI);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void I() {
        LiveRefreshUIObserver.a().t();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void J() {
        LiveRightTopFunctionPlace liveRightTopFunctionPlace;
        if (this.aj || (liveRightTopFunctionPlace = this.aM) == null) {
            return;
        }
        liveRightTopFunctionPlace.setDataToWish(LiveRoomManager.a().p().wishList);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void K() {
        ToggleButton toggleButton;
        if (!this.u) {
            if (PlayingOnliveFragment.cB == 0 && !this.aj) {
                return;
            }
            if (PlayingOnliveFragment.cB == 1 && this.aj) {
                return;
            }
        }
        if (this.aj && (toggleButton = this.V) != null && !toggleButton.isChecked()) {
            this.V.setChecked(false);
        }
        this.S.setFocusableInTouchMode(true);
        this.S.setFocusable(true);
        this.S.requestFocus();
        ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(this.S, 0);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void L() {
        if (LiveRoomManager.a().p() == null || LiveRoomManager.a().p().screen_pattern != 1) {
            return;
        }
        if (this.u) {
            this.br.setVisibility(0);
        } else {
            this.bq.setVisibility(0);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void M() {
        if (LiveRoomManager.a().p() == null || LiveRoomManager.a().p().screen_pattern != 1) {
            return;
        }
        if (this.u) {
            this.br.setVisibility(8);
        } else {
            this.bq.setVisibility(8);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void N() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSysNetworkObserver.ILiveSysNetworkObserver
    public void O() {
        LiveMsgManager liveMsgManager = this.q;
        if (liveMsgManager != null) {
            liveMsgManager.e(false);
        }
    }

    public boolean P() {
        return LiveRoomManager.a().p() != null && LiveRoomManager.a().p().live_type == 1;
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void Q() {
        IScreenManager iScreenManager = this.ab;
        if (iScreenManager != null) {
            iScreenManager.b();
        }
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void Q_() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveFansObserver.ILiveFansObserver
    public void R() {
        if (this.aU) {
            Log.i("xpp", LoaderConstants.OPEN_SHARE);
            W();
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveFansObserver.ILiveFansObserver
    public void S() {
        if (this.aU) {
            Log.i("xpp", "openGif");
            LiveRefreshUIObserver.a().j();
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveFansObserver.ILiveFansObserver
    public void T() {
        if (this.aU) {
            Log.i("xpp", "requestLiveFansData");
            X();
        }
    }

    public void U() {
        this.G.setVisibility(8);
        LinearLayout linearLayout = this.an;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        this.z.setVisibility(0);
        this.A.setVisibility(8);
        this.B.setVisibility(0);
        this.C.setVisibility(0);
        this.F.setVisibility(8);
        this.D.setVisibility(8);
        this.E.setVisibility(8);
    }

    public void V() {
        if (LiveRefreshUIObserver.a().f() && !LiveRoomManager.a().t()) {
            ImageFileLoader.a(getFragmentActive()).a(LiveRoomManager.a().p().profile.avatar).a();
            ImageFileLoader.a(getFragmentActive()).b(LiveRoomManager.a().p().profile.avatar).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.27
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public void onUIFinish(File file, Exception exc) {
                    PlayingOnliveBaseModeFragment.this.a((file == null || !file.exists()) ? null : BitmapFactory.decodeFile(file.getPath()));
                }
            }).a();
        }
    }

    public void W() {
        if (LiveRoomManager.a().t()) {
            return;
        }
        LiveRoomHttpUtils.a(LiveRoomManager.a().g(), new BluedUIHttpResponse<BluedEntityA<LiveShareTextModel>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.34
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveShareTextModel> bluedEntityA) {
                if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                    PlayingOnliveBaseModeFragment.this.bx = bluedEntityA.data.get(0).copywriting;
                }
                PlayingOnliveBaseModeFragment.this.V();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                PlayingOnliveBaseModeFragment.this.V();
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(PlayingOnliveBaseModeFragment.this.aS);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(PlayingOnliveBaseModeFragment.this.aS);
            }
        }, getFragmentActive());
    }

    public void X() {
        Log.i("xpp", "getLiveFansInfo");
        String str = "";
        String g = LiveRoomManager.a().p() != null ? LiveRoomManager.a().g() : "";
        if (LiveRoomManager.a().p() != null) {
            str = LiveRoomManager.a().d() + "";
        }
        if (TextUtils.isEmpty(g)) {
            Log.i("xpp", "getLiveFansInfo uid is empty");
        } else if (TextUtils.isEmpty(str)) {
            Log.i("xpp", "getLiveFansInfo lid is empty");
        } else {
            LiveRoomHttpUtils.b(g, str, new BluedUIHttpResponse<BluedEntityA<LiveFansInfoModel>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.35
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<LiveFansInfoModel> bluedEntityA) {
                    if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                        return;
                    }
                    LiveRoomManager.a().a(bluedEntityA.data.get(0));
                    if (PlayingOnliveBaseModeFragment.this.q == null || PlayingOnliveFragment.cB != 1 || LiveFloatManager.a().C() || bluedEntityA.data.get(0).fans_status != 2) {
                        return;
                    }
                    PlayingOnliveBaseModeFragment.this.q.e();
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str2) {
                    return true;
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIStart() {
                    super.onUIStart();
                }
            }, getFragmentActive());
        }
    }

    public void Y() {
        AppInfo.n().postDelayed(this.bf, LockPatternUtils.FAILED_ATTEMPT_TIMEOUT_MS);
    }

    public void Z() {
        AppInfo.n().removeCallbacks(this.bf);
    }

    @Override // com.blued.android.module.live_china.observer.BeansRefreshObserver.IBeansRefreshObserver
    public void a(double d, double d2) {
        if (d < 0.0d || d2 < 0.0d) {
            return;
        }
        LiveRoomManager.a().a(d, d2);
        Logger.a("drb", "notifyUpdateBeans beans = ", Double.toString(d), "-- beans_current_count = ", Double.toString(d2));
        this.j.setText(CommonStringUtils.d(String.valueOf(d2)));
        LiveRoomData p = LiveRoomManager.a().p();
        if (p != null) {
            if (d >= this.bw) {
                p.beans_count = d;
            }
            p.beans_current_count = d2;
        }
        this.bw = d;
    }

    public void a(int i) {
        LiveRoomAnchorModel liveRoomAnchorModel = LiveRoomManager.a().p().profile;
        if (liveRoomAnchorModel != null && !TextUtils.isEmpty(liveRoomAnchorModel.avatar_frame)) {
            if (liveRoomAnchorModel.avatar_frame_type == 1) {
                ImageLoader.a(getFragmentActive(), liveRoomAnchorModel.avatar_frame).f(this.aL.hashCode()).g(-1).a(this.aL);
            } else if (liveRoomAnchorModel.avatar_frame_type == 2) {
                ImageLoader.a(getFragmentActive(), liveRoomAnchorModel.avatar_frame).e(this.aL.hashCode()).g(-1).a(this.aL);
            } else {
                ImageLoader.a(getFragmentActive(), liveRoomAnchorModel.avatar_frame).a(this.aL);
            }
            this.aL.setVisibility(0);
        } else if (i < 30) {
        } else {
            if (i >= 90) {
                this.aL.setImageResource(R.drawable.live_anchor_head_bg_90);
            } else if (i >= 60) {
                this.aL.setImageResource(R.drawable.live_anchor_head_bg_60);
            } else if (i >= 30) {
                this.aL.setImageResource(R.drawable.live_anchor_head_bg_30);
            }
            this.aL.setVisibility(0);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(int i, int i2) {
        LiveRankingButtonView liveRankingButtonView = this.aT;
        if (liveRankingButtonView != null) {
            liveRankingButtonView.a(i, i2);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(int i, int i2, int i3, float f) {
        Log.v("pk", "refreshRecordLevel mLiveRoomData:" + LiveRoomManager.a().p());
        a(i);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(int i, int i2, int i3, int i4) {
        this.ao = i;
        this.aq = i2;
        this.ap = i3;
        this.ar = i4;
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(final long j) {
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.13
            @Override // java.lang.Runnable
            public void run() {
                PlayingOnliveBaseModeFragment.this.t = j;
            }
        });
    }

    public void a(Bitmap bitmap) {
        LiveRoomInfo.a().a(this.a, this.u, LiveRoomManager.a().p(), bitmap, this.bx);
    }

    @Override // com.blued.android.module.live_china.live_interface.IDispatchTouchEvent
    public void a(MotionEvent motionEvent) {
        if (this.ai == 2) {
            AppInfo.n().removeCallbacks(this.as);
            AppInfo.n().postDelayed(this.as, 3000L);
        }
    }

    public void a(View view, final LiveRoomTipsModel liveRoomTipsModel) {
        if (this.aj || this.a == null || getFragmentActive() == null || !getFragmentActive().isActive()) {
            return;
        }
        LiveCommonPopTips liveCommonPopTips = this.bg;
        if (liveCommonPopTips == null || !liveCommonPopTips.z()) {
            LiveCommonPopTips liveCommonPopTips2 = new LiveCommonPopTips(this.a, liveRoomTipsModel);
            this.bg = liveCommonPopTips2;
            liveCommonPopTips2.a(view, new XPopupCallback() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.39
                @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void a(BasePopupView basePopupView) {
                }

                @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void a(BasePopupView basePopupView, int i) {
                }

                @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void a(BasePopupView basePopupView, int i, float f, boolean z) {
                }

                @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void b(BasePopupView basePopupView) {
                }

                @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void c(BasePopupView basePopupView) {
                }

                @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void d(BasePopupView basePopupView) {
                    String g = LiveRoomManager.a().g();
                    LiveRoomHttpUtils.a(g, liveRoomTipsModel.getId() + "", PlayingOnliveBaseModeFragment.this.getFragmentActive());
                }

                @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public void e(BasePopupView basePopupView) {
                }

                @Override // com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
                public boolean f(BasePopupView basePopupView) {
                    String g = LiveRoomManager.a().g();
                    LiveRoomHttpUtils.a(g, liveRoomTipsModel.getId() + "", PlayingOnliveBaseModeFragment.this.getFragmentActive());
                    return false;
                }
            });
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(EditText editText, boolean z, SendMsgListener sendMsgListener) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(FunctionRedPModelJson functionRedPModelJson) {
        int red_point_type = functionRedPModelJson.getRed_point_type();
        if (red_point_type == 1) {
            View view = this.J;
            if (view != null) {
                view.setTag(functionRedPModelJson);
                if (functionRedPModelJson.getRed_point_action() == 1) {
                    this.J.setVisibility(0);
                } else {
                    this.J.setVisibility(8);
                }
            }
        } else if (red_point_type == 2) {
            View view2 = this.K;
            if (view2 != null) {
                view2.setTag(functionRedPModelJson);
                if (functionRedPModelJson.getRed_point_action() == 1) {
                    this.K.setVisibility(0);
                } else {
                    this.K.setVisibility(8);
                }
            }
        } else if (red_point_type != 3) {
        } else {
            String red_point_word = functionRedPModelJson.getRed_point_word();
            LiveBottomOperationView liveBottomOperationView = this.aO;
            if (liveBottomOperationView != null) {
                if (liveBottomOperationView.getWishingWellView() != null && red_point_word.equals(this.aO.getWishingWellView().getRedPointWord())) {
                    this.aO.getWishingWellView().a.setTag(functionRedPModelJson);
                    if (functionRedPModelJson.getRed_point_action() == 1) {
                        this.aO.getWishingWellView().a.setVisibility(0);
                    } else {
                        this.aO.getWishingWellView().a.setVisibility(8);
                    }
                } else if (this.aO.getH5View() == null || !red_point_word.equals(this.aO.getH5View().getModel().getRed_point_word())) {
                } else {
                    if (functionRedPModelJson.getRed_point_action() == 1) {
                        this.aO.getH5View().getRedDot().setVisibility(0);
                    } else {
                        this.aO.getH5View().getRedDot().setVisibility(8);
                    }
                }
            }
        }
    }

    public void a(final LiveBarrageModel liveBarrageModel) {
        if (liveBarrageModel == null || liveBarrageModel.beans == 0 || liveBarrageModel.goods_id == 0) {
            this.S.setHint(getString(R.string.write_text));
            this.Y = false;
            LiveRoomConstants.a = 32;
            this.V.setVisibility(8);
            this.V.setChecked(false);
            return;
        }
        ImageFileLoader.a(getFragmentActive()).a(AvatarUtils.a(1, LiveRoomInfo.a().d())).a();
        this.V.setVisibility(0);
        this.Z = liveBarrageModel.goods_id;
        this.V.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.25
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                if (z) {
                    Logger.a("drb", PlayingOnliveBaseModeFragment.this.getSimpleName(), "-打开弹幕");
                    PlayingOnliveBaseModeFragment.this.Y = true;
                    PlayingOnliveBaseModeFragment.this.S.setHint(String.format(PlayingOnliveBaseModeFragment.this.getResources().getString(R.string.LiveVideo_danmaku_hint), Long.valueOf(liveBarrageModel.beans)));
                    PlayingOnliveBaseModeFragment.this.T.setEnabled(true);
                    LiveRoomConstants.a = 20;
                    PlayingOnliveBaseModeFragment.this.W.setVisibility(0);
                    PlayingOnliveBaseModeFragment.this.q.e(0);
                    return;
                }
                Logger.a("drb", PlayingOnliveBaseModeFragment.this.getSimpleName(), "-关闭弹幕");
                PlayingOnliveBaseModeFragment.this.W.setVisibility(8);
                if (PlayingOnliveFragment.cB == 0) {
                    PlayingOnliveBaseModeFragment.this.S.setHint(PlayingOnliveBaseModeFragment.this.getString(R.string.simple_model_danmaku));
                    PlayingOnliveBaseModeFragment.this.Y = false;
                    LiveRoomConstants.a = 0;
                    PlayingOnliveBaseModeFragment.this.T.setEnabled(false);
                } else {
                    PlayingOnliveBaseModeFragment.this.S.setHint(PlayingOnliveBaseModeFragment.this.getString(R.string.write_text));
                    PlayingOnliveBaseModeFragment.this.Y = false;
                    LiveRoomConstants.a = 32;
                    PlayingOnliveBaseModeFragment.this.T.setEnabled(true);
                }
                PlayingOnliveBaseModeFragment.this.ap();
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveChattingModel liveChattingModel) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveGiftModel liveGiftModel) {
        LiveRefreshUIObserver.a().b(liveGiftModel);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveGiftWallFloatModel liveGiftWallFloatModel) {
        LiveRightTopFunctionPlace liveRightTopFunctionPlace;
        if (this.aj || (liveRightTopFunctionPlace = this.aM) == null) {
            return;
        }
        liveRightTopFunctionPlace.setDataToGoodsWall(liveGiftWallFloatModel);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveHornModelNew liveHornModelNew, boolean z) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveMakeLoverFansModel liveMakeLoverFansModel) {
        this.bt = false;
        this.A.setVisibility(0);
        this.B.setVisibility(0);
        this.F.setVisibility(0);
        this.F.setImageResource(R.drawable.live_make_lover_mic_close);
        this.D.setVisibility(0);
        this.E.setVisibility(0);
        this.C.setVisibility(8);
        if (liveMakeLoverFansModel == null || liveMakeLoverFansModel.index != 1) {
            this.E.setVisibility(0);
        } else {
            this.E.setVisibility(8);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveRewardModel liveRewardModel) {
        Logger.a("drb", "setGrabRewardData");
        GrabRewardView grabRewardView = this.y;
        if (grabRewardView != null) {
            grabRewardView.a(liveRewardModel);
        }
        LiveOperationView liveOperationView = this.aN;
        if (liveOperationView != null) {
            liveOperationView.a(EnumOperation.VIEW_TYPE_RED_BAG.getValue(), liveRewardModel);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveRoomData liveRoomData) {
        if (LiveRoomManager.a().p() != null && this.s == LiveRoomManager.a().d()) {
            ak();
            Log.v(ReqAckPackage.REQ_RESPONSE_KEY.BEANS, "setData更新弯豆：" + LiveRoomManager.a().p().beans_count + " ：" + LiveRoomManager.a().p().beans_current_count);
            a(LiveRoomManager.a().p().beans_count, LiveRoomManager.a().p().beans_current_count);
            n();
        }
        if (this.bi != null) {
            if (LiveRoomManager.a().R()) {
                this.bi.setVisibility(0);
            } else {
                this.bi.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00e9, code lost:
        if (r0.equals(com.blued.android.module.live_china.model.ConstFunction.LIVE_ROOM_FIRST_RECHARGE_GIFT_BAG) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.module.live_china.model.LiveRoomFunctionItemModel r6) {
        /*
            Method dump skipped, instructions count: 739
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.a(com.blued.android.module.live_china.model.LiveRoomFunctionItemModel):void");
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveRoomOperationModel liveRoomOperationModel) {
        LiveOperationView liveOperationView = this.aN;
        if (liveOperationView == null || liveRoomOperationModel == null) {
            return;
        }
        liveOperationView.a(liveRoomOperationModel.getTools_type(), (Object) liveRoomOperationModel);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveRoomTipsModel liveRoomTipsModel) {
        if (liveRoomTipsModel == null || this.aj) {
            return;
        }
        switch (liveRoomTipsModel.getLocation()) {
            case 20:
                a(this.N, liveRoomTipsModel);
                return;
            case 21:
                a(this.L, liveRoomTipsModel);
                return;
            case 22:
                a(this.aJ, liveRoomTipsModel);
                return;
            case 23:
                if (this.aO.getViewList().size() <= 0 || this.aO.getViewList().get(0) == null) {
                    return;
                }
                a(this.aO.getViewList().get(0), liveRoomTipsModel);
                return;
            case 24:
                if (this.aO.getViewList().size() <= 1 || this.aO.getViewList().get(1) == null) {
                    return;
                }
                a(this.aO.getViewList().get(1), liveRoomTipsModel);
                return;
            case 25:
                if (this.aO.getViewList().size() <= 2 || this.aO.getViewList().get(2) == null) {
                    return;
                }
                a(this.aO.getViewList().get(2), liveRoomTipsModel);
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveRoomUserModel liveRoomUserModel) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveWishItemModel liveWishItemModel) {
        LiveRightTopFunctionPlace liveRightTopFunctionPlace;
        if (this.aj || (liveRightTopFunctionPlace = this.aM) == null || liveWishItemModel == null) {
            return;
        }
        liveRightTopFunctionPlace.a(liveWishItemModel);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveWishingDrawModel liveWishingDrawModel) {
        LiveOperationView liveOperationView = this.aN;
        if (liveOperationView != null) {
            liveOperationView.a(EnumOperation.VIEW_TYPE_WISHING_KNOCKING.getValue(), liveWishingDrawModel);
        }
        LiveBottomOperationView liveBottomOperationView = this.aO;
        if (liveBottomOperationView == null || liveBottomOperationView.getWishingWellView() == null) {
            return;
        }
        this.aO.getWishingWellView().a(liveWishingDrawModel);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(MultiDialogModel multiDialogModel) {
        if (PushGuideObserver.d().a() || multiDialogModel == null) {
            return;
        }
        multiDialogModel.from_type = 1;
        LiveMultiDialogFragment.a(getChildFragmentManager(), multiDialogModel);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(MuteLiveAudioModel muteLiveAudioModel, String str) {
        LiveRefreshUIObserver.a().a(muteLiveAudioModel, str);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(RelationInfo relationInfo) {
        if (relationInfo == null) {
            return;
        }
        b(relationInfo.getRelation(), relationInfo.getUid());
        if (LiveRoomManager.a().m() == 12 || LiveRoomManager.a().m() == 13 || LiveRoomManager.a().m() == 10) {
            RecordingMultiConnectionManager.a(this.aI, relationInfo);
        }
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void a(String str) {
        if (LiveRoomManager.a().t()) {
            return;
        }
        LiveMsgSendManager.a().k();
        LiveRelationshipObserver.a().a(str, LiveRoomManager.a().g());
        if (this.q != null) {
            if ("1".equals(str) || "3".equals(str)) {
                this.q.d(true);
            } else {
                this.q.d(false);
            }
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(String str, int i) {
        if (this.aj) {
            return;
        }
        LiveRefreshUIObserver.a().b(str, i);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(String str, String str2) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(String str, boolean z) {
        RecordingMultiConnectionManager.a(this.aI, str, z);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(List<LiveInviteUserModel> list) {
        if (this.aI == null) {
            return;
        }
        if (list == null || list.size() == 0) {
            RecordingMultiConnectionManager.c(this.aI);
            this.aI.removeAllViews();
            this.aI.setVisibility(8);
            return;
        }
        int i = PlayingMultiConnectionManager.f;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, PlayingMultiConnectionManager.c, 0, 0);
        this.aI.setLayoutParams(layoutParams);
        this.aI.removeAllViews();
        this.aI.setVisibility(0);
        RecordingMultiConnectionManager.a(this.aI, list, PlayingMultiConnectionManager.e, PlayingMultiConnectionManager.f, this);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(boolean z) {
        this.at = true;
        this.o.setVisibility(0);
        this.o.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.16
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                KeyboardUtils.a((Activity) PlayingOnliveBaseModeFragment.this.getActivity());
                PlayingOnliveBaseModeFragment.this.o.setVisibility(8);
                return true;
            }
        });
        LiveKeyboardObserver.a().b();
        if (PlayingOnliveFragment.cB != 1 || z || this.Y) {
            return;
        }
        ap();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(boolean z, boolean z2) {
        this.bt = z;
        d(z2);
    }

    public boolean aa() {
        PlayingOnliveFragment ab = ab();
        if (ab != null) {
            return ab.aC();
        }
        return false;
    }

    public PlayingOnliveFragment ab() {
        if (getParentFragment() instanceof PlayingOnliveFragment) {
            return (PlayingOnliveFragment) getParentFragment();
        }
        return null;
    }

    public void ac() {
        PopupWindow popupWindow = this.bu;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.bu.dismiss();
            return;
        }
        int[] iArr = new int[2];
        this.I.getLocationOnScreen(iArr);
        Logger.d("PlayingOnliveBaseModeFragment", "offestY = " + iArr[1]);
        PopupWindow popupWindow2 = new PopupWindow(this.a);
        this.bu = popupWindow2;
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0));
        this.bu.setOutsideTouchable(true);
        ImageView imageView = new ImageView(this.a);
        imageView.setImageResource(R.drawable.live_fans_guide_icon);
        imageView.measure(0, 0);
        int measuredWidth = (AppInfo.l - imageView.getMeasuredWidth()) - DensityUtils.a(this.a, 10.0f);
        Logger.d("PlayingOnliveBaseModeFragment", "guideView width = " + measuredWidth + " ; guideView height = " + imageView.getMeasuredHeight());
        int measuredHeight = (iArr[1] - imageView.getMeasuredHeight()) - DensityUtils.a(this.a, 5.0f);
        StringBuilder sb = new StringBuilder();
        sb.append("offestY = ");
        sb.append(measuredHeight);
        Logger.d("PlayingOnliveBaseModeFragment", sb.toString());
        this.bu.setContentView(imageView);
        this.bu.showAtLocation(this.I, 0, measuredWidth, measuredHeight);
        ar();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(int i) {
    }

    public void b(long j) {
        if (j > 99) {
            this.W.setBadgeCount("99+");
            return;
        }
        BackgroundTextView backgroundTextView = this.W;
        backgroundTextView.setBadgeCount(j + "");
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(LiveChattingModel liveChattingModel) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(LiveGiftModel liveGiftModel) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(LiveRoomData liveRoomData) {
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void b(String str) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(String str, int i) {
        if (this.aj) {
            return;
        }
        LiveRefreshUIObserver.a().c(str, i);
    }

    @Override // com.blued.android.module.live_china.observer.LiveRelationshipObserver.ILiveRelationshipObserver
    public void b(String str, String str2) {
        ShapeRelativeLayout shapeRelativeLayout;
        LogUtils.b("pLog", "notifyRelationshipState = ", getSimpleName(), " -- ", str);
        if (this.bj == null || LiveRoomManager.a().t()) {
            return;
        }
        LiveRoomManager.a().p().relationship = str;
        if (CommonStringUtils.c(str2) == LiveRoomManager.a().f()) {
            LiveUserFansView liveUserFansView = null;
            if ("1".equals(str) || "3".equals(str)) {
                LiveRoomManager.a().p().isFollow = true;
                if (LiveRoomManager.a().q() == null || LiveRoomManager.a().q().fans_status != 1) {
                    LiveUserFansView liveUserFansView2 = this.bj;
                    if (liveUserFansView2 != null) {
                        liveUserFansView2.setFansViewState(LiveUserFansView.getFOLLOW());
                    }
                } else {
                    LiveUserFansView liveUserFansView3 = this.bj;
                    if (liveUserFansView3 != null) {
                        liveUserFansView3.setFansViewState(LiveUserFansView.getFANS_CLUB());
                    }
                }
                this.q.d(true);
                shapeRelativeLayout = null;
            } else {
                LiveRoomManager.a().p().isFollow = false;
                if (LiveRoomManager.a().q() == null || LiveRoomManager.a().q().fans_status != 1) {
                    LiveUserFansView liveUserFansView4 = this.bj;
                    if (liveUserFansView4 != null) {
                        liveUserFansView4.setFansViewState(LiveUserFansView.getNOT_FOLLOW());
                    }
                    shapeRelativeLayout = this.aK;
                    liveUserFansView = this.bj;
                } else {
                    LiveUserFansView liveUserFansView5 = this.bj;
                    if (liveUserFansView5 != null) {
                        liveUserFansView5.setFansViewState(LiveUserFansView.getFANS_CLUB());
                    }
                    shapeRelativeLayout = null;
                    liveUserFansView = null;
                }
                this.q.d(false);
            }
            if (this.aj || liveUserFansView == null) {
                return;
            }
            PushGuideObserver.d().a(shapeRelativeLayout, liveUserFansView);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(List<GrabBoxModel> list) {
        if (this.aN != null) {
            GrabBoxListModel grabBoxListModel = new GrabBoxListModel();
            grabBoxListModel.setList(new ArrayList<>());
            grabBoxListModel.getList().addAll(list);
            this.aN.a(EnumOperation.VIEW_TYPE_TREASURE_BOX.getValue(), grabBoxListModel);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(boolean z) {
        if (this.u) {
            Logger.a("ddrb", " base setSimpleModelGift = ", Integer.valueOf(PlayingOnliveFragment.cB));
            this.q.c(z);
        }
    }

    protected boolean b() {
        return true;
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b_(String str) {
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void c() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void c(int i) {
        this.q.d(i);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void c(LiveChattingModel liveChattingModel) {
        this.q.a(liveChattingModel);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void c(LiveGiftModel liveGiftModel) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void c(String str, int i) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void c(List<LiveInviteUserModel> list) {
        RecordingMultiConnectionManager.a(this.aI, list);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void c(boolean z) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void c_(String str) {
        if (this.aJ != null) {
            ImageLoader.a(getFragmentActive(), str).a(this.aJ);
        }
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void d() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void d(int i) {
        this.q.b(i);
    }

    public void d(final LiveGiftModel liveGiftModel) {
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.17
            @Override // java.lang.Runnable
            public void run() {
                PlayingOnliveBaseModeFragment.this.v = false;
                PlayingOnliveBaseModeFragment.this.q.c(liveGiftModel);
                PlayingOnliveBaseModeFragment.this.G();
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void d(List<LiveInviteUserModel> list) {
        RecordingMultiConnectionManager.b(this.aI, list);
    }

    public void d(boolean z) {
        this.F.setImageResource(this.bt ? R.drawable.live_make_lover_mic_open : R.drawable.live_make_lover_mic_close);
        if (z) {
            AppMethods.d(this.bt ? R.string.live_make_lover_mic_close : R.string.live_make_lover_mic_open);
        }
        LiveRefreshUIObserver.a().a(this.bt);
    }

    public void e() {
        if (getActivity() instanceof BaseFragmentActivity) {
            getActivity().a((BaseFragmentActivity.IOnBackPressedListener) this);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void e(int i) {
        if (i != 0) {
            if (i == 1 && !this.Y) {
                this.S.setHint(getString(R.string.write_text));
                this.T.setEnabled(true);
                LiveRoomConstants.a = 32;
            }
        } else if (this.Y) {
            this.T.setEnabled(true);
            LiveRoomConstants.a = 20;
        } else {
            this.S.setHint(getString(R.string.simple_model_danmaku));
            this.T.setEnabled(false);
            LiveRoomConstants.a = 0;
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void e(String str) {
        if (this.aj) {
            return;
        }
        LiveRefreshUIObserver.a().a(str);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void e(List<LiveInviteUserModel> list) {
        RecordingMultiConnectionManager.a(this.aI, list, true);
    }

    public void f() {
        this.c = (ViewGroup) this.b.findViewById(R.id.fl_root);
        this.al = this.b.findViewById(R.id.header_lay);
        this.am = this.b.findViewById(R.id.live_recommend);
        this.an = (LinearLayout) this.b.findViewById(R.id.bottom_lay);
        this.d = (ViewGroup) this.b.findViewById(R.id.live_top_root);
        this.e = (TextView) this.b.findViewById(R.id.name_view);
        this.f = (ViewGroup) this.b.findViewById(R.id.live_header_layout);
        this.g = (ImageView) this.b.findViewById(R.id.header_view);
        this.h = (ViewGroup) this.b.findViewById(R.id.onlive_count_layout);
        this.i = (TextView) this.b.findViewById(R.id.onlive_all_count);
        this.j = (TextView) this.b.findViewById(R.id.onlive_current_beans);
        this.k = (ImageView) this.b.findViewById(R.id.close_btn);
        LiveViewerListView liveViewerListView = (LiveViewerListView) this.b.findViewById(R.id.live_viewer);
        this.l = liveViewerListView;
        liveViewerListView.a(getChildFragmentManager(), this.u);
        this.aW = (LiveOnlineUserTipsView) this.b.findViewById(R.id.view_live_online_user_tips);
        this.m = (HornViewNew) this.b.findViewById(R.id.horn_view);
        this.n = (BarrageHornView) this.b.findViewById(R.id.barrage_horn_view);
        this.o = this.b.findViewById(R.id.keyboard_view);
        this.p = (ImageView) this.b.findViewById(R.id.live_zan_view);
        LiveUserFansView liveUserFansView = (LiveUserFansView) this.b.findViewById(R.id.live_user_follow_fans_view);
        this.bj = liveUserFansView;
        if (liveUserFansView != null) {
            liveUserFansView.b(getContext());
            this.bl = (RelativeLayout) this.b.findViewById(R.id.rl_anchor_info);
            this.bk = (ImageView) this.b.findViewById(R.id.img_anchor_info_bg);
            this.bj.setStartFansClubAnchorBgListener(new LiveUserFansView.StartFansClubAnchorBgListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.3
                @Override // com.blued.android.module.live_china.view.LiveUserFansView.StartFansClubAnchorBgListener
                public void a() {
                    PlayingOnliveBaseModeFragment.this.bk.setVisibility(0);
                    ImageLoader.c(PlayingOnliveBaseModeFragment.this.getFragmentActive(), "live_anchor_info_bg.png").g(1).f().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.3.1
                        @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                        public void a() {
                        }

                        @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                        public void b() {
                            PlayingOnliveBaseModeFragment.this.bk.setVisibility(8);
                        }
                    }).a(PlayingOnliveBaseModeFragment.this.bk);
                }

                @Override // com.blued.android.module.live_china.view.LiveUserFansView.StartFansClubAnchorBgListener
                public void a(float f) {
                    PlayingOnliveBaseModeFragment.this.bl.setAlpha(f);
                }
            });
            this.bj.setBtnClickListener(new LiveUserFansView.OnBtnClickListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.4
                @Override // com.blued.android.module.live_china.view.LiveUserFansView.OnBtnClickListener
                public void a() {
                    PlayingOnliveBaseModeFragment.this.al();
                }

                @Override // com.blued.android.module.live_china.view.LiveUserFansView.OnBtnClickListener
                public void b() {
                    LiveRefreshUIObserver.a().m();
                }
            });
        }
        this.w = (ViewGroup) this.b.findViewById(R.id.live_beans_btn_root);
        this.bi = this.b.findViewById(R.id.live_guest_beans_arrow);
        PkDaredView pkDaredView = this.x;
        if (pkDaredView != null) {
            pkDaredView.d();
        }
        this.x = (PkDaredView) this.b.findViewById(R.id.pdv_pk_dared);
        GrabRewardView grabRewardView = (GrabRewardView) this.b.findViewById(R.id.grab_reward_view);
        this.y = grabRewardView;
        if (grabRewardView != null) {
            grabRewardView.setVisibility(8);
        }
        this.G = (ViewGroup) this.b.findViewById(R.id.chat_view);
        this.ag = (ImageView) this.b.findViewById(R.id.share_view);
        this.ah = (ImageView) this.b.findViewById(R.id.float_window_view);
        this.I = (ImageView) this.b.findViewById(R.id.live_bottom_icon_gift);
        this.J = this.b.findViewById(R.id.tv_gift_dot);
        this.K = this.b.findViewById(R.id.tv_recharge_dot);
        this.L = (FrameLayout) this.b.findViewById(R.id.fl_live_gift_img);
        this.M = (SVGAImageView) this.b.findViewById(R.id.iv_live_gift_apng);
        if (!this.u) {
            g();
        }
        this.N = (ImageView) this.b.findViewById(R.id.live_bottom_icon_more);
        this.O = this.b.findViewById(R.id.tv_dot);
        this.aJ = (ImageView) this.b.findViewById(R.id.live_bottom_icon_recharge);
        this.R = this.b.findViewById(R.id.live_msg_edit);
        this.T = (TextView) this.b.findViewById(R.id.live_msg_send_to);
        this.U = (ImageView) this.b.findViewById(R.id.live_msg_send_emotion);
        EditText editText = (EditText) this.b.findViewById(R.id.live_msg_send_edit);
        this.S = editText;
        editText.setFocusableInTouchMode(false);
        this.S.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveBaseModeFragment$9lGfskXaLuZv6dCoLJAyg-4Oi20
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean a;
                a = PlayingOnliveBaseModeFragment.a(view, motionEvent);
                return a;
            }
        });
        this.S.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveBaseModeFragment$giCKWrbBsgprQsXYS-JEciNVHao
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean a;
                a = PlayingOnliveBaseModeFragment.this.a(textView, i, keyEvent);
                return a;
            }
        });
        this.W = (BackgroundTextView) this.b.findViewById(R.id.danmaku_count_view);
        this.X = (ViewGroup) this.b.findViewById(R.id.bottom_layout);
        this.H = (BadgeView) this.b.findViewById(R.id.approach_gift_view);
        this.V = (ToggleButton) this.b.findViewById(R.id.toggle_danmaku_btn);
        LiveDefinedRankView liveDefinedRankView = (LiveDefinedRankView) this.b.findViewById(R.id.live_defined_rank_layout_id);
        this.aQ = liveDefinedRankView;
        if (liveDefinedRankView != null) {
            liveDefinedRankView.setFragment(this);
        }
        this.z = this.b.findViewById(R.id.ll_make_lover_btn);
        this.A = this.b.findViewById(R.id.iv_make_lover_hold_off);
        this.B = this.b.findViewById(R.id.iv_make_lover_keyboard);
        this.C = this.b.findViewById(R.id.iv_make_lover_share);
        this.F = (ImageView) this.b.findViewById(R.id.iv_make_lover_mic);
        this.D = this.b.findViewById(R.id.iv_make_lover_bao_zhao);
        this.E = this.b.findViewById(R.id.iv_make_lover_mie_deng);
        this.ac = (ImageView) this.b.findViewById(R.id.switch_horizontal_view);
        this.ad = (ImageView) this.b.findViewById(R.id.switch_vertical_view);
        this.ae = (ImageView) this.b.findViewById(R.id.switch_clear_view);
        this.af = (ImageView) this.b.findViewById(R.id.switch_normal_view);
        this.bn = (LiveMsgShimmerTextView) this.b.findViewById(R.id.say_something_view);
        this.bp = (ImageView) this.b.findViewById(R.id.live_chat_light);
        this.bq = (ImageView) this.b.findViewById(R.id.no_switch_horizontal_view);
        this.br = (ImageView) this.b.findViewById(R.id.no_switch_vertical_view);
        this.bm = (VolumeBrightnessView) this.b.findViewById(R.id.volume_brightness_view);
        this.au = (FrameLayout) this.b.findViewById(R.id.live_window_click_layout);
        this.av = this.b.findViewById(R.id.live_window_1_click_view);
        this.aw = this.b.findViewById(R.id.live_window_2_click_view);
        this.ax = this.b.findViewById(R.id.live_window_3_click_view);
        this.ay = this.b.findViewById(R.id.live_window_4_click_view);
        this.az = this.b.findViewById(R.id.live_window_5_click_view);
        this.aA = this.b.findViewById(R.id.live_window_6_click_view);
        this.aB = this.b.findViewById(R.id.ll_pk_banner_click_view);
        this.aC = this.b.findViewById(R.id.fl_pk_b_click);
        this.aI = (FrameLayout) this.b.findViewById(R.id.fl_multi_connection);
        this.aD = this.b.findViewById(R.id.pk_streak_left);
        this.aE = this.b.findViewById(R.id.pk_streak_right);
        this.aF = this.b.findViewById(R.id.pk_banner_left);
        this.aG = this.b.findViewById(R.id.pk_banner_right);
        this.aH = this.b.findViewById(R.id.live_pk_count_down_qa);
        this.aK = (ShapeRelativeLayout) this.b.findViewById(R.id.live_anchor_layout);
        this.aL = (ImageView) this.b.findViewById(R.id.header_level_bg);
        this.bh = (SVGAImageView) this.b.findViewById(R.id.iv_fragment_synthesis);
        if (ab() != null && ab().f49cn != null) {
            if (!this.aj && this.aN == null) {
                LiveOperationView liveOperationView = (LiveOperationView) this.b.findViewById(R.id.live_operation_view);
                this.aN = liveOperationView;
                if (liveOperationView != null) {
                    liveOperationView.a((BaseFragment) this, false);
                    ab().f49cn.a(this.aN);
                }
            }
            if (this.aO == null) {
                LiveBottomOperationView liveBottomOperationView = (LiveBottomOperationView) this.b.findViewById(R.id.live_bottom_operation);
                this.aO = liveBottomOperationView;
                if (liveBottomOperationView != null) {
                    liveBottomOperationView.a(this, false);
                    ab().f49cn.a(this.aO);
                }
            }
        }
        LiveRightTopFunctionPlace liveRightTopFunctionPlace = (LiveRightTopFunctionPlace) this.b.findViewById(R.id.live_right_top_function);
        this.aM = liveRightTopFunctionPlace;
        if (!this.aj && liveRightTopFunctionPlace != null) {
            liveRightTopFunctionPlace.setBaseFragment(this);
        }
        PkDaredView pkDaredView2 = this.x;
        if (pkDaredView2 != null) {
            if (this.aj) {
                pkDaredView2.setVisibility(8);
            } else {
                pkDaredView2.a(getFragmentActive());
                this.x.setStartPKAnimRootView(this.c);
            }
        }
        this.am.setOnClickListener(this);
        if (!PushGuideObserver.d().a() && LiveRoomPreferences.d() && this.am.getTag() == null) {
            final LiveRecommendPop liveRecommendPop = new LiveRecommendPop(this.a);
            this.am.setTag(liveRecommendPop);
            this.am.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveBaseModeFragment$FnlYdxDd5FBN__JGpcrZVuqfp9E
                @Override // java.lang.Runnable
                public final void run() {
                    PlayingOnliveBaseModeFragment.this.a(liveRecommendPop);
                }
            });
        }
        if (!this.aj) {
            PushGuideObserver.d().b(this.am);
        }
        this.aT = (LiveRankingButtonView) this.b.findViewById(R.id.ranking_button_view);
        GrabRewardView grabRewardView2 = this.y;
        if (grabRewardView2 != null) {
            grabRewardView2.a(this);
        }
        this.H.a(9, Color.parseColor("#ffffff"));
        this.W.a(9, Color.parseColor("#abd2ff"));
        if (!"en".equals(BlueAppLocal.a())) {
            ViewGroup.LayoutParams layoutParams = this.V.getLayoutParams();
            layoutParams.width = DensityUtils.a(this.a, 60.0f);
            this.V.setLayoutParams(layoutParams);
        }
        this.P = (ImageView) this.b.findViewById(R.id.img_live_recommend);
        this.k.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.G.setOnClickListener(this);
        ImageView imageView = this.ag;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ImageView imageView2 = this.ah;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        this.I.setOnClickListener(this);
        SVGAImageView sVGAImageView = this.M;
        if (sVGAImageView != null) {
            sVGAImageView.setOnClickListener(this);
        }
        ImageView imageView3 = this.N;
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
        }
        this.T.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.S.addTextChangedListener(this.aX);
        ImageView imageView4 = this.ac;
        if (imageView4 != null) {
            imageView4.setOnClickListener(this);
        }
        ImageView imageView5 = this.ad;
        if (imageView5 != null) {
            imageView5.setOnClickListener(this);
        }
        ImageView imageView6 = this.ae;
        if (imageView6 != null) {
            imageView6.setOnClickListener(this);
        }
        ImageView imageView7 = this.af;
        if (imageView7 != null) {
            imageView7.setOnClickListener(this);
        }
        this.R.setOnClickListener(this);
        this.p.setOnTouchListener(this);
        this.av.setOnClickListener(this);
        this.aw.setOnClickListener(this);
        this.ax.setOnClickListener(this);
        this.ay.setOnClickListener(this);
        this.az.setOnClickListener(this);
        this.aA.setOnClickListener(this);
        this.av.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return PlayingOnliveBaseModeFragment.this.aZ.onTouchEvent(motionEvent);
            }
        });
        this.aw.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return PlayingOnliveBaseModeFragment.this.ba.onTouchEvent(motionEvent);
            }
        });
        this.ax.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return PlayingOnliveBaseModeFragment.this.bb.onTouchEvent(motionEvent);
            }
        });
        this.ay.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return PlayingOnliveBaseModeFragment.this.bc.onTouchEvent(motionEvent);
            }
        });
        this.az.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return PlayingOnliveBaseModeFragment.this.bd.onTouchEvent(motionEvent);
            }
        });
        this.aA.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return PlayingOnliveBaseModeFragment.this.be.onTouchEvent(motionEvent);
            }
        });
        this.aF.setOnClickListener(this);
        this.aG.setOnClickListener(this);
        this.aD.setOnClickListener(this);
        this.aE.setOnClickListener(this);
        View view = this.aC;
        if (view != null) {
            view.setOnClickListener(this);
        }
        View view2 = this.aH;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        this.aJ.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        ag();
        ah();
        C();
        B();
        ai();
        ae();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void f(int i) {
        Logger.a("drb", "setBottomLayoutVisible = ", Integer.valueOf(i));
        int i2 = this.ai;
        if (i2 == 3 || i2 == 4) {
            return;
        }
        Logger.a("drb", "setBottomLayoutVisible ============= ");
        this.X.setVisibility(i);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void f(String str) {
        if (this.aj) {
            return;
        }
        LiveRefreshUIObserver.a().b(str);
    }

    public void g() {
        FrameLayout frameLayout = this.L;
        if (frameLayout != null) {
            if (this.M == null) {
                frameLayout.setVisibility(0);
                return;
            }
            ImageView imageView = this.I;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            this.M.setCallback(new SVGACallback() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.11
                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onFinished() {
                    if (PlayingOnliveBaseModeFragment.this.I != null) {
                        PlayingOnliveBaseModeFragment.this.I.setVisibility(0);
                    }
                    if (PlayingOnliveBaseModeFragment.this.M != null) {
                        PlayingOnliveBaseModeFragment.this.M.setImageResource(R.drawable.live_gift_btn_icon_1);
                    }
                }

                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onPause() {
                }

                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onRepeat() {
                }

                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onStep(int i, double d) {
                }
            });
            new SVGAPlayer.Builder().a("live_gift_btn_icon.svga").a((Integer) 1).a(SVGAImageView.FillMode.Clear).a((Boolean) true).a(this.M);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void g(int i) {
        this.R.setVisibility(i);
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void g(String str) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveFansObserver.ILiveFansObserver
    public void h(int i) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void h(String str) {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void i() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (((AppInfo.l / 2) / 3) * 4) + DensityUtils.a(this.a, 60.0f));
        layoutParams.topMargin = PlayingMakeFriendManager.c;
        this.aB.setLayoutParams(layoutParams);
        this.aB.setVisibility(0);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void j() {
        this.aB.setVisibility(8);
        LiveMsgManager liveMsgManager = this.q;
        if (liveMsgManager != null) {
            liveMsgManager.a();
        }
    }

    public void k() {
        int i = PlayingMakeLoverManager.b;
        int i2 = PlayingMakeLoverManager.c;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i2 * 2);
        layoutParams.setMargins(0, PlayingMakeLoverManager.e, 0, 0);
        this.au.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i, i2);
        layoutParams3.leftMargin = i;
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i, i2);
        int i3 = i * 2;
        layoutParams4.leftMargin = i3;
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(i, i2);
        layoutParams5.topMargin = i2;
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(i, i2);
        layoutParams6.leftMargin = i;
        layoutParams6.topMargin = i2;
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(i, i2);
        layoutParams7.leftMargin = i3;
        layoutParams7.topMargin = i2;
        this.av.setLayoutParams(layoutParams2);
        this.aw.setLayoutParams(layoutParams3);
        this.ax.setLayoutParams(layoutParams4);
        this.ay.setLayoutParams(layoutParams5);
        this.az.setLayoutParams(layoutParams6);
        this.aA.setLayoutParams(layoutParams7);
        this.au.setVisibility(0);
        this.av.setVisibility(0);
        this.aw.setVisibility(0);
        this.ax.setVisibility(0);
        this.ay.setVisibility(0);
        this.az.setVisibility(0);
        this.aA.setVisibility(0);
    }

    public void n() {
        if (LiveRoomManager.a().p() == null) {
            return;
        }
        a(LiveRoomManager.a().p().level, LiveRoomManager.a().p().next_level, (int) LiveRoomManager.a().p().percent, CommonStringUtils.b(LiveRoomManager.a().p().gap_exp));
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void o() {
        if (!this.aU || LiveRoomManager.a().t()) {
            return;
        }
        if (this.bs == null) {
            this.bs = new PopTaskView(getContext());
        }
        this.bs.a(this.s, LiveRoomManager.a().g());
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        LiveRefreshUIObserver.a().q();
        return true;
    }

    @Override // android.widget.Chronometer.OnChronometerTickListener
    public void onChronometerTick(Chronometer chronometer) {
        long j = this.t + 1;
        this.t = j;
        chronometer.setText(LiveTimeAndDateUtils.a(j, true));
        LiveRefreshUIObserver.a().a(this.t);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LivePKPlusView livePKPlusView;
        LivePKPlusView livePKPlusView2;
        Tracker.onClick(view);
        if (view.getId() == R.id.close_btn) {
            LiveRefreshUIObserver.a().s();
        } else if (view.getId() == R.id.header_view) {
            if (LiveRoomManager.a().t()) {
                return;
            }
            this.q.a(LiveRoomManager.a().g());
        } else if (view.getId() == R.id.live_beans_btn_root) {
            LiveRefreshUIObserver.a().l();
        } else if (view.getId() == R.id.chat_view) {
            if (getActivity() == null) {
                return;
            }
            ao();
            u();
        } else if (view.getId() == R.id.share_view) {
            if (LiveRoomManager.a().p() != null) {
                EventTrackLive.a(LiveProtos.Event.USER_SHARE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            }
            W();
        } else if (view.getId() == R.id.float_window_view) {
            LiveRefreshUIObserver.a().b(true);
        } else if (view.getId() == R.id.live_bottom_icon_gift || view.getId() == R.id.iv_live_gift_apng) {
            if (LiveRoomManager.a().p() != null) {
                EventTrackLive.a(LiveProtos.Event.GUEST_USER_GIFT_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            }
            LiveRefreshUIObserver.a().j();
            View view2 = this.J;
            if (view2 == null || view2.getVisibility() != 0 || this.J.getTag() == null) {
                return;
            }
            FunctionRedPModelJson functionRedPModelJson = (FunctionRedPModelJson) this.J.getTag();
            String red_point_word = functionRedPModelJson.getRed_point_word();
            if (Boolean.valueOf(functionRedPModelJson.getRed_point_cancel()).booleanValue()) {
                LiveRoomHttpUtils.b((BluedUIHttpResponse) null, red_point_word);
                this.J.setVisibility(8);
            }
        } else if (view.getId() == R.id.live_bottom_icon_more) {
            EventTrackLive.a(LiveProtos.Event.LIVE_DOWN_COLLECTION_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            LiveRoomFunctionDlgFragment.a.a(getFragmentManager(), false);
        } else if (view.getId() == R.id.switch_normal_view) {
            this.ab.a();
        } else if (view.getId() == R.id.switch_clear_view) {
            this.ab.d();
            LogData logData = new LogData();
            logData.D = "live_change_to_min";
            logData.n = String.valueOf(this.s);
            InstantLog.a(logData);
        } else if (view.getId() == R.id.switch_vertical_view) {
            if (this.br.getVisibility() == 0) {
                return;
            }
            AppInfo.n().removeCallbacks(this.as);
            getActivity().setRequestedOrientation(1);
            LogData logData2 = new LogData();
            logData2.D = "live_change_to_vertical";
            logData2.n = String.valueOf(this.s);
            logData2.k = String.valueOf(0);
            InstantLog.a(logData2);
        } else if (view.getId() == R.id.switch_horizontal_view) {
            getActivity().setRequestedOrientation(0);
            LogData logData3 = new LogData();
            logData3.D = "live_change_to_horizontal";
            logData3.n = String.valueOf(this.s);
            logData3.k = String.valueOf(0);
            InstantLog.a(logData3);
        } else if (view.getId() == R.id.live_msg_send_to) {
            am();
        } else if (view.getId() == R.id.live_bottom_icon_recharge) {
            an();
        } else if (view.getId() == R.id.live_recommend) {
            if (this.am.getTag() != null && (this.am.getTag() instanceof LiveRecommendPop)) {
                LiveRecommendPop liveRecommendPop = (LiveRecommendPop) this.am.getTag();
                if (!liveRecommendPop.t()) {
                    liveRecommendPop.p();
                }
                this.am.setTag(null);
            }
            EventTrackLive.a(LiveProtos.Event.LIVE_RECOMMEND_FOR_YOU_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            new LiveRecommendDialogFragment(this.a, ab()).show(getFragmentManager(), "recommendDialog");
            PushGuideObserver.d().c();
        } else if (view.getId() == R.id.iv_make_lover_hold_off) {
            if (LiveRoomManager.a().p() != null) {
                EventTrackLive.a(LiveProtos.Event.GUEST_HANG_UP_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            }
            LiveRefreshUIObserver.a().g();
        } else if (view.getId() == R.id.iv_make_lover_keyboard) {
            if (getActivity() == null) {
                return;
            }
            if (LiveRoomManager.a().p() != null) {
                EventTrackLive.a(LiveProtos.Event.GUEST_USER_KEYBOARD_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            }
            ao();
        } else if (view.getId() == R.id.iv_make_lover_share) {
            if (LiveRoomManager.a().p() != null) {
                EventTrackLive.a(LiveProtos.Event.USER_SHARE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            }
            W();
        } else if (view.getId() == R.id.iv_make_lover_mic) {
            PlayingOnliveFragment ab = ab();
            if (ab != null && ab.bY.d()) {
                AppMethods.d(R.string.live_make_lover_open_mic_tip);
                return;
            }
            if (LiveRoomManager.a().p() != null) {
                EventTrackLive.b(LiveProtos.Event.GUEST_CLOSE_MIKE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.bt);
            }
            this.bt = !this.bt;
            if (LiveRoomManager.a().p() != null) {
                EventTrackLive.b(LiveProtos.Event.GUEST_CLOSE_MIKE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.bt);
            }
            d(true);
        } else if (view.getId() == R.id.iv_make_lover_bao_zhao) {
            if (LiveRoomManager.a().p() != null) {
                EventTrackLive.a(LiveProtos.Event.GUEST_SHOW_PHOTO_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            }
            LiveSelectPhotoDialogFragment liveSelectPhotoDialogFragment = new LiveSelectPhotoDialogFragment();
            liveSelectPhotoDialogFragment.a((LiveBaseDialogFragment.IDialogEvent) new LiveBaseDialogFragment.IDialogEvent<LiveMakeLoverFansModel>() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.18
                @Override // com.blued.android.module.live_china.fragment.LiveBaseDialogFragment.IDialogEvent
                public void a() {
                    PlayingOnliveBaseModeFragment.this.e();
                }

                @Override // com.blued.android.module.live_china.fragment.LiveBaseDialogFragment.IDialogEvent
                public void a(LiveMakeLoverFansModel liveMakeLoverFansModel) {
                    if (liveMakeLoverFansModel == null) {
                        return;
                    }
                    Logger.d("PlayingOnliveBaseModeFragment", "onOkDialog result = " + liveMakeLoverFansModel.avatar + "  : " + liveMakeLoverFansModel.pic);
                    LiveRefreshUIObserver.a().a(liveMakeLoverFansModel.avatar, liveMakeLoverFansModel.pic);
                }
            });
            liveSelectPhotoDialogFragment.show(getFragmentManager(), "select_photo");
        } else if (view.getId() == R.id.iv_make_lover_mie_deng) {
            if (LiveRoomManager.a().p() != null) {
                EventTrackLive.a(LiveProtos.Event.GUEST_LIGHT_OFF_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            }
            LiveRefreshUIObserver.a().h();
        } else if (view.getId() == R.id.pk_banner_left) {
            LiveRefreshUIObserver.a().d(true);
        } else if (view.getId() == R.id.pk_banner_right) {
            LiveRefreshUIObserver.a().d(false);
        } else if (view.getId() == R.id.pk_streak_left) {
            if ((getParentFragment() instanceof PlayingOnliveFragment) && (livePKPlusView2 = ((PlayingOnliveFragment) getParentFragment()).bl) != null && livePKPlusView2.b()) {
                EventTrackLive.a(LiveProtos.Event.LIVE_PK_WIN_ICON_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                LiveRefreshUIObserver.a().b(LiveRoomInfo.a().G(), 0);
            }
        } else if (view.getId() == R.id.pk_streak_right) {
            if ((getParentFragment() instanceof PlayingOnliveFragment) && (livePKPlusView = ((PlayingOnliveFragment) getParentFragment()).bl) != null && livePKPlusView.c()) {
                EventTrackLive.a(LiveProtos.Event.LIVE_PK_WIN_ICON_CLICK, String.valueOf(livePKPlusView.getLid()), String.valueOf(livePKPlusView.getUid()));
                LiveRefreshUIObserver.a().b(LiveRoomInfo.a().G(), 0);
            }
        } else if (view.getId() == R.id.live_pk_count_down_qa) {
            EventTrackLive.a(LiveProtos.Event.LIVE_PK_EXPLAIN_BUBBLE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            LiveRefreshUIObserver.a().b(LiveRoomInfo.a().A(), 0);
        } else if (view.getId() != R.id.fl_pk_b_click || ab() == null) {
        } else {
            ab().H();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i == 1) {
            Logger.a("drb", "切换为竖屏 -- ");
            this.u = false;
            this.ab.b();
        } else if (i == 2) {
            Logger.a("drb", "切换为横屏 -- ");
            this.u = true;
            this.ab.a();
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (LiveRoomManager.a().p() != null) {
            this.s = LiveRoomManager.a().d();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aS = DialogUtils.a((Context) getActivity());
        this.u = LiveFloatManager.a().C();
        this.a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_onlive_base_mode, viewGroup, false);
            this.ab = new PlayingModelManager(this);
            ad();
            aj();
            BeansRefreshObserver.a().a(this);
            LiveSetDataObserver.a().a(this);
            PlayGifObserver.a().a(this);
            LiveSysNetworkObserver.a().a(this);
            LiveRelationshipObserver.a().a(this);
            LiveFansObserver.a().a(this);
            getActivity().a((IDispatchTouchEvent) this);
            Logger.a("drb", getSimpleName(), "++++++++++++ onCreateView ++++++++++++");
            a(LiveRoomManager.a().p());
            LiveRoomManager.a().b(true);
            if (aa() && this.z.getVisibility() != 0) {
                B_();
            }
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        BeansRefreshObserver.a().b(this);
        LiveSetDataObserver.a().b(this);
        PlayGifObserver.a().b(this);
        LiveSysNetworkObserver.a().b(this);
        LiveRelationshipObserver.a().b(this);
        LiveFansObserver.a().b(this);
        LiveUserFansView liveUserFansView = this.bj;
        if (liveUserFansView != null) {
            liveUserFansView.c();
        }
        PkDaredView pkDaredView = this.x;
        if (pkDaredView != null) {
            pkDaredView.d();
        }
        getActivity().b(this);
        this.q.d();
        u();
        LiveRankingButtonView liveRankingButtonView = this.aT;
        if (liveRankingButtonView != null) {
            liveRankingButtonView.a();
        }
        PopupWindow popupWindow = this.bu;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.bu.dismiss();
        }
        CountDownTimer countDownTimer = this.by;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        LiveEventBus.get(LiveEventBusUtil.C, LiveRoomFunctionItemModel.class).removeObserver(new $$Lambda$iYY4pdGBSBhTTrGtmUvzVDHnEHs(this));
        Logger.a("drb", getSimpleName(), "------------PlayingOnliveBaseModeFragment onDestroy-----------");
        Logger.a("rrb", getSimpleName(), " onDestroy -- liveMsgManager = ", this.q);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.aY.onTouchEvent(motionEvent);
        return true;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ViewGroup.LayoutParams layoutParams = this.aK.getLayoutParams();
        layoutParams.width = DensityUtils.a(this.a, 141.5f);
        this.aK.setLayoutParams(layoutParams);
        LiveRoomHttpUtils.j(new BluedUIHttpResponse<BluedEntity<LiveBarrageModel, LiveBarrageModel>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment.24
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveBarrageModel, LiveBarrageModel> bluedEntity) {
                if (bluedEntity == null || bluedEntity.extra == null) {
                    return;
                }
                PlayingOnliveBaseModeFragment.this.b(bluedEntity.extra.count);
                PlayingOnliveBaseModeFragment.this.a(bluedEntity.extra);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void q() {
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.aU = z;
        if (z) {
            LiveEventBus.get("live_fans_added", String.class).observeForever(this.bv);
        } else {
            LiveEventBus.get("live_fans_added", String.class).removeObserver(this.bv);
        }
    }

    public void u() {
        Shimmer shimmer = this.bo;
        if (shimmer == null || !shimmer.b()) {
            return;
        }
        this.bo.a();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void v() {
        LiveRefreshUIObserver.a().w();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void w() {
        LiveRefreshUIObserver.a().x();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void x() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void y() {
        if (this.O == null) {
            return;
        }
        if (LiveRoomManager.a().Y()) {
            this.O.setVisibility(0);
        } else {
            this.O.setVisibility(8);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void z() {
        LiveUserFansView liveUserFansView = this.bj;
        if (liveUserFansView != null) {
            liveUserFansView.e();
        }
    }
}
