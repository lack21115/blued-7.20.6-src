package com.soft.blued.ui.msg;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.listener.RetractionListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.kbswitch.KeyboardConstraintLayout;
import com.blued.android.kbswitch.KeyboardHelper;
import com.blued.android.kbswitch.listener.KeyboardStatusListener;
import com.blued.android.kbswitch.listener.SwitchPreHandleListener;
import com.blued.android.module.base.shortvideo.DeleteAutoCheckedListener;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.group.GroupMemberModel;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AnimationUtils;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.ComplianceUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.common.utils.NinePatchUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.ScreenUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.utils.click.SingleTouchProxy;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.emoji.view.EmoticonsIndicatorView;
import com.blued.android.module.common.widget.emoticon.manager.EmotionManager;
import com.blued.android.module.common.widget.emoticon.manager.EmotionPackListener;
import com.blued.android.module.common.widget.emoticon.model.EmoticonModel;
import com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView;
import com.blued.android.module.common.widget.emoticon.ui.EmoticonsToolBarView;
import com.blued.android.module.common.widget.emoticon.ui.Emotion;
import com.blued.android.module.common.widget.emoticon.ui.IViewStateListener;
import com.blued.android.module.common.widget.pop.BluedPopupWindow;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.media.audio.audio_manager.BLAudioManager;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.event.fragment.EventDetailsFragment;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.event.model.EventLogData;
import com.blued.community.ui.send.dialog.PayVIPPopupWindow;
import com.blued.community.ui.send.model.FeedPostSignStateItem;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.constant.ChatConstants;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.RiskyMsgDeletedHint;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.bytedance.MessageEventUtils;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.model.UserInfoBasicModel;
import com.soft.blued.push.PushChecker;
import com.soft.blued.ui.community.view.FeedBubbleStateView;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.msg.MsgChattingFragment;
import com.soft.blued.ui.msg.adapter.BaseListAdapter;
import com.soft.blued.ui.msg.adapter.HelloExpressionAdapter;
import com.soft.blued.ui.msg.adapter.MessageChatAdapter;
import com.soft.blued.ui.msg.adapter.ViewHolder;
import com.soft.blued.ui.msg.contract.IMsgChatAdapterOperationCallback;
import com.soft.blued.ui.msg.contract.IMsgChattingView;
import com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.controller.tools.IMV4Constant;
import com.soft.blued.ui.msg.controller.tools.IMV4Method;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.msg.customview.RecentPhotoView;
import com.soft.blued.ui.msg.customview.RecordButton;
import com.soft.blued.ui.msg.event.FuGiftListEvent;
import com.soft.blued.ui.msg.event.KeepScreenEvent;
import com.soft.blued.ui.msg.event.OpenGiftPackageEvent;
import com.soft.blued.ui.msg.event.UpdateSourceFromEvent;
import com.soft.blued.ui.msg.fragment.UserGiftFragment;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.ui.msg.manager.FlashPhotoManager;
import com.soft.blued.ui.msg.manager.GiftPlayer;
import com.soft.blued.ui.msg.manager.OnlineStatusManager;
import com.soft.blued.ui.msg.manager.UserPagerGiftManager;
import com.soft.blued.ui.msg.model.DateTodaySayHelloModel;
import com.soft.blued.ui.msg.model.FuGiftModel;
import com.soft.blued.ui.msg.model.HelloExpressionData;
import com.soft.blued.ui.msg.model.MsgExtraForTextTypeEntity;
import com.soft.blued.ui.msg.model.MsgRecentPhotoInfo;
import com.soft.blued.ui.msg.model.MsgUserCheatModel;
import com.soft.blued.ui.msg.pop.CenterGuidePop;
import com.soft.blued.ui.msg.pop.FuGiftPop;
import com.soft.blued.ui.msg.pop.GiftVoucherHelpPop;
import com.soft.blued.ui.msg.pop.GiftVoucherPop;
import com.soft.blued.ui.msg.pop.UserGiftDialogFragment;
import com.soft.blued.ui.msg.presenter.MsgChattingPresent;
import com.soft.blued.ui.msg.util.LocalSecureNotifyContent;
import com.soft.blued.ui.msg.viewModel.MsgListViewModel;
import com.soft.blued.ui.msg_group.constant.GroupConstant;
import com.soft.blued.ui.msg_group.model.AtUserEvent;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.ui.user.model.ServiceMenuModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.AtChooseUserHelper;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import skin.support.SkinCompatManager;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgChattingFragment.class */
public class MsgChattingFragment extends BaseFragment implements View.OnClickListener, Observer<FuGiftListEvent>, RetractionListener, EmotionPackListener, IMsgChatAdapterOperationCallback, IMsgChattingView, RecentPhotoView.IRecentPhotoOperationCallback {
    private static final String k = MsgChattingFragment.class.getSimpleName();
    private FeedBubbleStateView A;
    private SmartRefreshLayout B;
    private ListView C;
    private MessageChatAdapter D;
    private CustomDialog E;
    private RecordButton F;
    private LinearLayout G;
    private ImageView H;
    private ImageView I;
    private ImageView J;
    private ImageView K;
    private View L;
    private ImageView M;
    private TextView N;
    private View O;
    private View P;
    private View Q;
    private View R;
    private View S;
    private View T;
    private TextView U;
    private ImageView V;
    private TextView W;
    private LinearLayout X;
    private RelativeLayout Y;
    private View Z;
    private RiskyMsgDeletedHint aA;
    private CenterGuidePop aB;
    private View aD;
    private ShapeTextView aE;
    private ViewStub aF;
    private View aG;
    private ViewStub aH;
    private View aI;
    private RiskyMsgDeletedHint aJ;
    private View aK;
    private TextView aL;
    private RelativeLayout aM;
    private ImageView aN;
    private TextView aO;
    private boolean aP;
    private ShapeTextView aQ;
    private ViewStub aR;
    private View aS;
    private MsgListViewModel aT;
    private RiskyMsgDeletedHint aU;
    private RiskyMsgDeletedHint aV;
    private KeyboardConstraintLayout aW;
    private View aX;
    private RiskyMsgDeletedHint aY;
    private LinearLayout aZ;
    private TextView aa;
    private TextView ab;
    private ShapeRelativeLayout ac;
    private TextView ad;
    private ImageView ae;
    private ShapeTextView af;
    private TextView ag;
    private LinearLayout ah;
    private ImageView ai;
    private String aj;
    private View ak;
    private AtChooseUserHelper al;
    private KeyboardListenLinearLayout am;
    private EmoticonsPageView ap;
    private EmoticonsIndicatorView aq;

    /* renamed from: ar  reason: collision with root package name */
    private EmoticonsToolBarView f18052ar;
    private Emotion as;
    private View at;
    private boolean au;
    private RecentPhotoView av;
    private boolean aw;
    private BluedAlertDialog ay;
    private ViewStub az;
    public Dialog b;
    private ImageView ba;
    private LinearLayout bb;
    private ImageView bc;
    private ImageView bd;
    private ConstraintLayout be;
    private FrameLayout bf;
    private LinearLayout bg;
    private RelativeLayout bh;
    private LinearLayout bi;
    private LinearLayout bj;
    private LinearLayout bk;
    private ShapeTextView bl;
    private View bm;
    private BluedAlertDialog bn;
    private BluedAlertDialog bo;
    private CardView bp;
    private ImageView bq;
    private ImageView br;
    private SVGAImageView bs;
    private LinearLayout bt;
    private SVGAImageView bu;
    private ViewPropertyAnimator bv;
    private boolean bw;

    /* renamed from: c  reason: collision with root package name */
    public EditText f18053c;
    public TextView d;
    public TextView e;
    public View g;
    public MsgChattingPresent h;
    public GiftPlayer i;
    private View l;
    private Context m;
    private View n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    private TextView r;
    private ImageView s;
    private ImageView t;
    private LinearLayout u;
    private TextView v;
    private ImageView w;
    private TextView x;
    private TextView y;
    private TextView z;

    /* renamed from: a  reason: collision with root package name */
    public List<ChattingModel> f18051a = new ArrayList();
    private int an = 256;
    public boolean f = false;
    private boolean ao = false;
    private boolean ax = false;
    private boolean aC = false;
    private TextWatcher bx = new TextWatcher() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.30
        private CharSequence b;

        /* renamed from: c  reason: collision with root package name */
        private int f18083c;
        private int d;
        private String e;
        private String f;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (!MsgChattingFragment.this.ax && editable != null && editable.toString().length() >= MsgChattingFragment.this.an) {
                    ToastUtils.a(MsgChattingFragment.this.getResources().getString(R.string.msg_char_limit));
                }
                MsgChattingFragment.this.f18053c.removeTextChangedListener(MsgChattingFragment.this.bx);
                this.f18083c = MsgChattingFragment.this.f18053c.getSelectionStart();
                this.d = MsgChattingFragment.this.f18053c.getSelectionEnd();
                while (editable.length() > MsgChattingFragment.this.an) {
                    editable.delete(this.f18083c - 1, this.d);
                    this.f18083c--;
                    this.d--;
                }
                if (!MsgChattingFragment.this.al.a(MsgChattingFragment.this.h.c() ? MsgChattingFragment.this : null, this.e, this.f, editable, this.d)) {
                    MsgChattingFragment.this.f18053c.setSelection(this.f18083c);
                }
                if (TextUtils.isEmpty(MsgChattingFragment.this.f18053c.getText().toString())) {
                    MsgChattingFragment.this.N.setVisibility(8);
                } else {
                    MsgChattingFragment.this.N.setVisibility(0);
                }
                MsgChattingFragment.this.f18053c.addTextChangedListener(MsgChattingFragment.this.bx);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (StackOverflowError e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.b = charSequence;
            this.e = ((Object) charSequence) + "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f = ((Object) charSequence) + "";
        }
    };
    private AtomicBoolean by = new AtomicBoolean(false);
    public Handler j = new MsgHandler(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.msg.MsgChattingFragment$27  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgChattingFragment$27.class */
    public class AnonymousClass27 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f18075a;

        AnonymousClass27(boolean z) {
            this.f18075a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MsgChattingFragment.this.h != null) {
                if (MsgChattingFragment.this.D.getCount() - MsgChattingFragment.this.C.getFirstVisiblePosition() >= MsgChattingFragment.this.h.N() || this.f18075a) {
                    Logger.c(MsgChattingFragment.k, "checkShowPopNoRead====updateInfo");
                    return;
                }
                MsgChattingFragment.this.h.c(true);
                if (MsgChattingFragment.this.h.y()) {
                    MsgChattingFragment.this.h.a(MsgChattingFragment.this.h.P());
                }
                MsgChattingFragment.this.C.setSelection(MsgChattingFragment.this.D.getCount() - 1);
                TranslateAnimation translateAnimation = new TranslateAnimation(MsgChattingFragment.this.ah.getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
                translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.27.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        MsgChattingFragment.this.ah.setVisibility(0);
                        MsgChattingFragment.this.C.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.27.1.1
                            @Override // android.widget.AbsListView.OnScrollListener
                            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                                try {
                                    if (MsgChattingFragment.this.h == null || MsgChattingFragment.this.h.Q() || !MsgChattingFragment.this.h.R() || ((ChattingModel) MsgChattingFragment.this.D.f18271a.get(i)).msgId > MsgChattingFragment.this.h.O()) {
                                        return;
                                    }
                                    MsgChattingFragment.this.h.b(true);
                                    MsgChattingFragment.this.B.j();
                                    MsgChattingFragment.this.B.h();
                                    MsgChattingFragment.this.c(true);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override // android.widget.AbsListView.OnScrollListener
                            public void onScrollStateChanged(AbsListView absListView, int i) {
                                if (i != 0) {
                                    if (i != 2) {
                                        return;
                                    }
                                    MsgChattingFragment.this.e();
                                } else if (MsgChattingFragment.this.h != null) {
                                    if (MsgChattingFragment.this.h.U() && MsgChattingFragment.this.C.getFirstVisiblePosition() != MsgChattingFragment.this.h.P()) {
                                        MsgChattingFragment.this.C.smoothScrollToPosition(MsgChattingFragment.this.h.P());
                                    }
                                    if (absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
                                        MsgChattingFragment.this.h.f(false);
                                        return;
                                    }
                                    MsgChattingFragment.this.X.setVisibility(8);
                                    MsgChattingFragment.this.h.f(true);
                                }
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                translateAnimation.setDuration(500L);
                MsgChattingFragment.this.ah.startAnimation(translateAnimation);
            }
        }
    }

    /* renamed from: com.soft.blued.ui.msg.MsgChattingFragment$35  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgChattingFragment$35.class */
    class AnonymousClass35 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MsgChattingFragment f18089a;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f18089a.M == null || this.f18089a.aB != null) {
                return;
            }
            this.f18089a.aB = new CenterGuidePop(this.f18089a.getContext(), this.f18089a.getString(R.string.msg_img_guide_hint));
            this.f18089a.aB.a(this.f18089a.M, new SimpleCallback() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.35.1
                public void c(BasePopupView basePopupView) {
                    BluedPreferences.dw();
                }

                public void d(BasePopupView basePopupView) {
                    AnonymousClass35.this.f18089a.aB = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.msg.MsgChattingFragment$67  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgChattingFragment$67.class */
    public class AnonymousClass67 implements DeleteAutoCheckedListener {
        AnonymousClass67() {
        }

        public void a(final CheckBox checkBox) {
            checkBox.setOnTouchListener(new SingleTouchProxy(new SingleTouchProxy.TouchListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.67.1
                public boolean a() {
                    if (ComplianceUtils.a.a(checkBox.getContext())) {
                        return true;
                    }
                    if (FlashPhotoManager.a().b().flash_left_times < 1) {
                        PayVIPPopupWindow.c.a(checkBox.getContext(), 1, new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.67.1.1
                            @Override // android.content.DialogInterface.OnDismissListener
                            public void onDismiss(DialogInterface dialogInterface) {
                                CheckBox checkBox2 = checkBox;
                                checkBox2.setText(MsgChattingFragment.this.m.getString(R.string.msg_look_burn) + FlashPhotoManager.a().b().flash_prompt);
                            }
                        });
                        return true;
                    }
                    return false;
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.msg.MsgChattingFragment$8  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgChattingFragment$8.class */
    public class AnonymousClass8 implements Runnable {
        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatManager.getInstance().getSessionModel(MsgChattingFragment.this.h.E(), MsgChattingFragment.this.h.e(), new FetchDataListener<SessionModel>() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.8.1
                /* renamed from: a */
                public void onFetchData(final SessionModel sessionModel) {
                    MsgChattingFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.8.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SessionModel sessionModel2;
                            if (!MsgChattingFragment.this.f && MsgChattingFragment.this.aG != null && ((sessionModel2 = sessionModel) == null || sessionModel2._msgList == null || sessionModel._msgList.size() == 0)) {
                                if (MsgChattingFragment.this.bv != null) {
                                    MsgChattingFragment.this.bv.cancel();
                                }
                                MsgChattingFragment.this.aG.setVisibility(0);
                                MsgChattingFragment.this.aG.setAlpha(0.0f);
                                MsgChattingFragment.this.bv = MsgChattingFragment.this.aG.animate().alpha(1.0f).setDuration(300L);
                                MsgChattingFragment.this.bv.start();
                            }
                            MsgChattingFragment.this.bw = false;
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.msg.MsgChattingFragment$80  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgChattingFragment$80.class */
    public class AnonymousClass80 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BluedIngSelfFeed f18149a;

        AnonymousClass80(BluedIngSelfFeed bluedIngSelfFeed) {
            this.f18149a = bluedIngSelfFeed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            Tracker.onClick(view);
            MsgChattingFragment.this.h.am();
            MsgChattingFragment.this.aI.setVisibility(8);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!MsgChattingFragment.this.h.al()) {
                if (MsgChattingFragment.this.aI != null) {
                    MsgChattingFragment.this.aI.setVisibility(8);
                    return;
                }
                return;
            }
            if (MsgChattingFragment.this.aI == null && MsgChattingFragment.this.aH != null) {
                MsgChattingFragment msgChattingFragment = MsgChattingFragment.this;
                msgChattingFragment.aI = msgChattingFragment.aH.inflate();
            }
            MsgChattingFragment.this.aI.findViewById(R.id.view_anony);
            TextView textView = (TextView) MsgChattingFragment.this.aI.findViewById(R.id.chat_anonymous_from_tv);
            ImageView imageView = (ImageView) MsgChattingFragment.this.aI.findViewById(2131365719);
            TextView textView2 = (TextView) MsgChattingFragment.this.aI.findViewById(2131371186);
            ImageView imageView2 = (ImageView) MsgChattingFragment.this.aI.findViewById(2131365207);
            textView2.setText(this.f18149a.feed_content);
            if (this.f18149a.is_bubble_ticktock == 1) {
                textView.setText(R.string.super_topic_from_sign);
            } else {
                textView.setText(R.string.super_topic_from_anonymous);
                if (this.f18149a.feed_pics != null && this.f18149a.feed_pics.length > 0) {
                    ImageLoader.a(MsgChattingFragment.this.getFragmentActive(), this.f18149a.feed_pics[0]).a(imageView);
                }
            }
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$MsgChattingFragment$80$Eimr4zLWizzK0wI1P4BYynGMFAk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MsgChattingFragment.AnonymousClass80.this.a(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgChattingFragment$LocalMsg.class */
    public class LocalMsg {

        /* renamed from: a  reason: collision with root package name */
        public List<ChattingModel> f18156a;

        LocalMsg() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgChattingFragment$MsgHandler.class */
    static class MsgHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<Fragment> f18157a;

        MsgHandler(Fragment fragment) {
            this.f18157a = new WeakReference<>(fragment);
        }

        public void a() {
            WeakReference<Fragment> weakReference = this.f18157a;
            if (weakReference != null) {
                weakReference.clear();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MsgChattingFragment msgChattingFragment = (MsgChattingFragment) this.f18157a.get();
            if (msgChattingFragment == null || msgChattingFragment.getActivity() == null || msgChattingFragment.getActivity().isFinishing()) {
                Logger.b(MsgChattingFragment.k, "fragment == null || getActivity() == null || getActivity().isFinishing()");
            } else {
                msgChattingFragment.a(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgChattingFragment$MyOnScrollListener.class */
    public class MyOnScrollListener implements AbsListView.OnScrollListener {
        private MyOnScrollListener() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                if (i != 2) {
                    return;
                }
                MsgChattingFragment.this.e();
            } else if (MsgChattingFragment.this.h != null) {
                if (absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
                    MsgChattingFragment.this.h.f(false);
                    return;
                }
                MsgChattingFragment.this.X.setVisibility(8);
                MsgChattingFragment.this.h.f(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        try {
            if (this.D.g == null || !IMV4Constant.b) {
                return;
            }
            this.D.h = "";
            this.D.notifyDataSetChanged();
            this.D.g.b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void P() {
        MessageChatAdapter messageChatAdapter = new MessageChatAdapter(this.h, this, this.f18051a, this.al, this.bx, this);
        this.D = messageChatAdapter;
        this.C.setAdapter((ListAdapter) messageChatAdapter);
        SessionSettingModel aj = this.h.aj();
        if (aj != null) {
            this.D.a(aj.bubbleThemeId);
        }
        a(this.h.ac(), this.h.F(), this.h.G());
        f();
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null && msgChattingPresent.c() && this.h.aj() != null && this.h.aj().is_super == 1) {
            this.r.setTextColor(ContextCompat.getColor(getContext(), 2131102251));
        }
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.7
            @Override // java.lang.Runnable
            public void run() {
                MsgChattingFragment.this.Z();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        View view = this.aG;
        if (view == null || !view.isShown()) {
            return;
        }
        this.aG.setVisibility(8);
        Logger.c(k, "hideHelloExpression=====");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        View view = this.at;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        AnimationUtils.a(this.at, 400L);
        if (this.h.m() != null) {
            BluedPreferences.a(this.h.m().group_id, System.currentTimeMillis() + (GroupUtil.f19137a * 60 * 1000));
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private void S() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void T() {
        this.al = new AtChooseUserHelper(this.m);
        this.b = DialogUtils.a(this.m);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.l.findViewById(R.id.msg_chatting_pullrefresh);
        this.B = smartRefreshLayout;
        smartRefreshLayout.findViewById(2131363911).setBackgroundColor(0);
        this.l.findViewById(R.id.refresh_header_view).setShowText(false);
        ListView listView = (ListView) this.l.findViewById(R.id.lv_chat_msg);
        this.C = listView;
        listView.setTranscriptMode(1);
        af();
        this.B.a(new OnRefreshListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.9
            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                if (MsgChattingFragment.this.h != null) {
                    MsgChattingFragment.this.h.h(true);
                    MsgChattingFragment.this.h.f(false);
                }
                AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MsgChattingFragment.this.h != null) {
                            MsgChattingFragment.this.h.a(MsgChattingFragment.this.j);
                        }
                    }
                }, 200L);
            }
        });
        this.B.a(new OnLoadMoreListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.10
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                ChattingModel chattingModel;
                if (MsgChattingFragment.this.h == null || MsgChattingFragment.this.D.f18271a.size() <= 0 || (chattingModel = (ChattingModel) MsgChattingFragment.this.D.f18271a.get(MsgChattingFragment.this.D.f18271a.size() - 1)) == null) {
                    return;
                }
                MsgChattingFragment.this.h.g(false);
                MsgChattingFragment.this.h.a(chattingModel.msgId, chattingModel.msgLocalId, MsgChattingFragment.this.j);
            }
        });
        ImageView imageView = (ImageView) this.l.findViewById(R.id.msg_chatting_bg);
        this.ai = imageView;
        imageView.post(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.11
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams = MsgChattingFragment.this.ai.getLayoutParams();
                layoutParams.width = ((ViewGroup) MsgChattingFragment.this.ai.getParent()).getWidth();
                layoutParams.height = ((ViewGroup) MsgChattingFragment.this.ai.getParent()).getHeight();
                MsgChattingFragment.this.ai.setLayoutParams(layoutParams);
            }
        });
        this.I = (ImageView) this.l.findViewById(R.id.bt_audio_or_keyboard);
        this.F = (RecordButton) this.l.findViewById(R.id.bt_audio);
        this.f18053c = (EditText) this.l.findViewById(R.id.et_sendMsg);
        if (this.h.an()) {
            this.f18053c.setHint(R.string.msg_merchant_input_hint);
        }
        this.f18053c.requestFocus();
        this.f18053c.addTextChangedListener(this.bx);
        this.J = (ImageView) this.l.findViewById(R.id.bt_emotion);
        this.H = (ImageView) this.l.findViewById(R.id.bt_type_select);
        this.K = (ImageView) this.l.findViewById(R.id.bt_gift);
        this.L = this.l.findViewById(R.id.iv_gift_dot);
        this.M = (ImageView) this.l.findViewById(R.id.bt_img);
        this.N = (TextView) this.l.findViewById(R.id.msg_send);
        this.G = (LinearLayout) this.l.findViewById(R.id.ll_op);
        this.g = this.l.findViewById(R.id.emoticon_layout);
        this.Y = (RelativeLayout) this.l.findViewById(R.id.bottom_layout);
        if (BluedPreferences.cK()) {
            this.Y.setBackgroundResource(2131101833);
        } else {
            this.Y.setBackgroundResource(2131101796);
        }
        this.O = this.l.findViewById(R.id.ll_function_photo);
        this.P = this.l.findViewById(R.id.ll_function_camera);
        this.Q = this.l.findViewById(R.id.ll_function_video_chat);
        this.R = this.l.findViewById(R.id.ll_function_location);
        this.S = this.l.findViewById(R.id.ll_function_video_root);
        this.T = this.l.findViewById(R.id.ll_function_group_video_root);
        this.bj = (LinearLayout) this.l.findViewById(R.id.ll_function_image);
        this.bk = (LinearLayout) this.l.findViewById(R.id.ll_function_gift);
        this.bl = this.l.findViewById(R.id.iv_service_gift_dot);
        this.U = (TextView) this.l.findViewById(R.id.tv_floating_group_msg);
        this.X = (LinearLayout) this.l.findViewById(R.id.ll_group_floating_msg);
        this.V = (ImageView) this.l.findViewById(R.id.iv_new_group_msg_head);
        this.W = (TextView) this.l.findViewById(R.id.tv_group_msg_time);
        this.d = (TextView) this.l.findViewById(R.id.tv_cover_transparent);
        TextView textView = (TextView) this.l.findViewById(R.id.tv_cover_bindcellphone_transparent);
        this.e = textView;
        textView.setOnClickListener(this);
        this.ah = (LinearLayout) this.l.findViewById(R.id.ll_pop_no_read_msg);
        TextView textView2 = (TextView) this.l.findViewById(R.id.tv_no_read_msg_count);
        this.ag = textView2;
        textView2.setText(String.format(getResources().getString(R.string.msg_num), String.valueOf(this.h.N())));
        this.aZ = (LinearLayout) this.l.findViewById(R.id.ll_service_menu);
        this.ba = (ImageView) this.l.findViewById(R.id.bt_service_menu);
        this.bb = (LinearLayout) this.l.findViewById(R.id.ll_service_btn);
        this.bc = (ImageView) this.l.findViewById(R.id.bt_service_emotion);
        this.bd = (ImageView) this.l.findViewById(R.id.bt_service_type_select);
        this.be = (ConstraintLayout) this.l.findViewById(R.id.cl_bottom_btn);
        this.bg = (LinearLayout) this.l.findViewById(R.id.ll_service_menu_list);
        this.bh = (RelativeLayout) this.l.findViewById(R.id.rl_chat_bottom);
        this.bi = (LinearLayout) this.l.findViewById(R.id.ll_chat_bottom);
        this.bf = (FrameLayout) this.l.findViewById(R.id.fm_gift);
        final boolean z = !TextUtils.isEmpty(BluedConfig.a().f().link);
        this.y = (TextView) this.l.findViewById(R.id.tv_tips);
        this.z = (TextView) this.l.findViewById(R.id.tv_tip_button);
        this.y.setText(BluedConfig.a().f().text);
        this.z.setVisibility((!z || this.h.c()) ? 8 : 0);
        RecentPhotoView recentPhotoView = (RecentPhotoView) this.l.findViewById(R.id.recent_photo_view);
        this.av = recentPhotoView;
        recentPhotoView.a((IRequestHost) getFragmentActive(), (RecentPhotoView.IRecentPhotoOperationCallback) this);
        if (this.h.C()) {
            this.av.a();
        }
        if (PopMenuUtils.a()) {
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        if (this.h.E() == 3) {
            this.T.setVisibility(0);
            this.Q.setVisibility(8);
            this.S.setVisibility(8);
            this.d.setVisibility(8);
        } else {
            this.S.setVisibility(0);
            this.Q.setVisibility(0);
            this.T.setVisibility(8);
            this.d.setVisibility(8);
        }
        this.am = this.l.findViewById(R.id.keyboardRelativeLayout);
        ViewStub viewStub = (ViewStub) this.l.findViewById(R.id.stub_gift_anim);
        this.az = viewStub;
        this.i = new GiftPlayer(viewStub, this.h.e());
        UserPagerGiftManager.a().a(this.i);
        RiskyMsgDeletedHint riskyMsgDeletedHint = (RiskyMsgDeletedHint) this.l.findViewById(R.id.no_disturb_hint);
        this.aA = riskyMsgDeletedHint;
        riskyMsgDeletedHint.setHint(getString(R.string.msg_no_disturb_hint));
        RiskyMsgDeletedHint riskyMsgDeletedHint2 = (RiskyMsgDeletedHint) this.l.findViewById(R.id.screenshot_hint);
        this.aJ = riskyMsgDeletedHint2;
        riskyMsgDeletedHint2.setHint(getString(R.string.msg_screenshot_hint));
        this.aJ.setTheme(RiskyMsgDeletedHint.Theme.RED);
        this.X.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.H.setOnClickListener(this);
        View findViewById = this.l.findViewById(R.id.cl_name);
        this.ak = findViewById;
        findViewById.setOnClickListener(this);
        if (this.h.c()) {
            this.bf.setVisibility(8);
        } else {
            this.K.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    MessageProtos.Event event = MessageProtos.Event.MSG_GIFT_ICON_CLICK;
                    EventTrackMessage.e(event, MsgChattingFragment.this.h.f() + "");
                    KeyboardUtils.a(MsgChattingFragment.this.getActivity());
                    if (!TextUtils.isEmpty(BluedConfig.a().A()) && !BluedPreferences.a().b(BluedConfig.a().A())) {
                        BluedPreferences.a().c().a(BluedConfig.a().A(), true).b();
                        MsgChattingFragment.this.L.setVisibility(8);
                    }
                    Context context = MsgChattingFragment.this.getContext();
                    ActivityFragmentActive fragmentActive = MsgChattingFragment.this.getFragmentActive();
                    UserGiftDialogFragment.a(context, fragmentActive, MsgChattingFragment.this.h.f() + "", !TextUtils.isEmpty(MsgChattingFragment.this.h.g) ? MsgChattingFragment.this.h.g : "chat_page_gift", new UserGiftDialogFragment.BuySucceedListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.12.1
                        @Override // com.soft.blued.ui.msg.pop.UserGiftDialogFragment.BuySucceedListener
                        public void a(UserGiftDialogFragment userGiftDialogFragment, GiftGivingOptionForJsonParse giftGivingOptionForJsonParse) {
                            userGiftDialogFragment.dismissAllowingStateLoss();
                            if (MsgChattingFragment.this.h != null) {
                                MsgChattingFragment.this.h.a(giftGivingOptionForJsonParse);
                            }
                        }
                    }, MsgChattingFragment.this.h.S() == null ? "0" : MsgChattingFragment.this.h.S().relationship, MsgChattingFragment.this.h.S() != null ? MsgChattingFragment.this.h.S().name : "", new int[0]);
                }
            }));
        }
        this.M.setOnClickListener(this);
        this.O.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.ah.setOnClickListener(this);
        if (this.h.D()) {
            this.bj.setVisibility(0);
            this.bk.setVisibility(0);
            this.Q.setVisibility(8);
            this.R.setVisibility(8);
            this.bj.setOnClickListener(this);
            this.bk.setOnClickListener(this);
        }
        if (this.h.ap()) {
            this.Q.setVisibility(8);
        }
        this.as = new Emotion(this.m);
        EmotionManager.a(this);
        this.ap = this.g.findViewById(2131373162);
        this.aq = this.g.findViewById(2131373161);
        EmoticonsToolBarView findViewById2 = this.g.findViewById(R.id.view_etv);
        this.f18052ar = findViewById2;
        findViewById2.setModel(false);
        this.f18052ar.setTargetUid(this.h.e() + "");
        CommonPreferences.a(System.currentTimeMillis());
        this.f18052ar.a(getFragmentActive(), EmotionManager.c());
        this.ap.a(getFragmentActive(), EmotionManager.c());
        this.f18052ar.setOnEmotionToolBarClickListener(new EmoticonsToolBarView.OnEmotionToolBarClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.13
            public void a(View view) {
                MessageProtos.Event event = MessageProtos.Event.MSG_EMOJI_CLICK;
                MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
                EventTrackMessage.a(event, strangerSource, MsgChattingFragment.this.h.f() + "");
                BluedURIRouterAdapter.openEmotionShop(MsgChattingFragment.this.m, 0);
            }

            public void b(View view) {
                BluedURIRouterAdapter.openEmotionShop(MsgChattingFragment.this.m, 1);
            }
        });
        this.ap.setOnIndicatorListener(new EmoticonsPageView.OnEmoticonsPageViewListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.14
            public void a(int i) {
                MsgChattingFragment.this.aq.a(i);
            }

            public void a(int i, int i2) {
                MsgChattingFragment.this.aq.a(i, i2);
            }

            public void b(int i) {
                MsgChattingFragment.this.aq.setIndicatorCount(i);
            }

            public void c(int i) {
                MsgChattingFragment.this.aq.b(i);
            }
        });
        this.ap.setIViewListener(new IViewStateListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.15
            public void a(int i) {
                MsgChattingFragment.this.f18052ar.setToolBtnSelect(i);
            }

            public void a(EmoticonModel emoticonModel) {
                if (MsgChattingFragment.this.f18053c != null) {
                    MsgChattingFragment.this.f18053c.setFocusable(true);
                    MsgChattingFragment.this.f18053c.setFocusableInTouchMode(true);
                    MsgChattingFragment.this.f18053c.requestFocus();
                    if (emoticonModel.eventType == 1) {
                        MsgChattingFragment.this.f18053c.onKeyDown(67, new KeyEvent(0, 67));
                    } else if (emoticonModel.eventType == 2) {
                    } else {
                        if (emoticonModel.emoticonType != 0) {
                            MsgChattingFragment msgChattingFragment = MsgChattingFragment.this;
                            msgChattingFragment.b(emoticonModel.packageCode + "_" + emoticonModel.code);
                        } else if (emoticonModel.emoji != null) {
                            MsgChattingFragment.this.f18053c.append(emoticonModel.emoji.a());
                        } else {
                            SpannableString a2 = MsgChattingFragment.this.as.a(emoticonModel.code);
                            if (MsgChattingFragment.this.f18053c.getText().length() + a2.length() <= MsgChattingFragment.this.an) {
                                MsgChattingFragment.this.f18053c.getText().insert(MsgChattingFragment.this.f18053c.getSelectionStart(), a2);
                            }
                        }
                    }
                }
            }
        });
        this.f18052ar.setOnToolBarItemClickListener(new EmoticonsToolBarView.OnToolBarItemClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.16
            public void a(int i) {
                MsgChattingFragment.this.ap.setPageSelect(i);
            }
        });
        View findViewById3 = this.l.findViewById(R.id.msg_ll_top_tip);
        this.Z = findViewById3;
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                Animation loadAnimation = android.view.animation.AnimationUtils.loadAnimation(MsgChattingFragment.this.m, 2130772123);
                loadAnimation.setFillAfter(true);
                MsgChattingFragment.this.Z.startAnimation(loadAnimation);
                MsgChattingFragment.this.Z.setVisibility(8);
            }
        });
        TextView textView3 = (TextView) this.Z.findViewById(R.id.include_top_tip_text);
        this.aa = textView3;
        textView3.setText(this.m.getResources().getText(R.string.biao_to_listen_current));
        this.af = this.l.findViewById(R.id.stv_top_title_online_status);
        this.ac = this.l.findViewById(R.id.srl_online_status);
        this.ad = (TextView) this.l.findViewById(R.id.tv_online_status_text);
        this.ae = (ImageView) this.l.findViewById(R.id.iv_online_status_anim);
        View findViewById4 = this.l.findViewById(R.id.msg_safe_notify_show);
        this.at = findViewById4;
        findViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (MsgChattingFragment.this.h.c()) {
                    return;
                }
                MsgChattingFragment.this.R();
                if (z) {
                    WebViewShowInfoFragment.show(MsgChattingFragment.this.m, BluedConfig.a().f().link, -1);
                }
            }
        });
        this.ab = (TextView) this.l.findViewById(R.id.tv_secreting);
        W();
        if (!this.h.c() && !TextUtils.isEmpty(BluedConfig.a().A()) && !BluedPreferences.a().b(BluedConfig.a().A())) {
            if (this.h.D()) {
                this.bl.setVisibility(0);
            } else {
                this.L.setVisibility(0);
            }
        }
        this.aD = this.l.findViewById(R.id.bottom_gap);
        V();
        Logger.c(k, "无实体虚拟按键底部加间距");
        this.aF = (ViewStub) this.l.findViewById(R.id.stub_hello_expression);
        this.aH = (ViewStub) this.l.findViewById(R.id.stub_anonymous);
        this.aK = this.l.findViewById(R.id.group_locked_shape);
        this.aL = (TextView) this.l.findViewById(R.id.tv_group_locked);
        this.aM = (RelativeLayout) this.l.findViewById(R.id.rl_quote);
        this.aO = (TextView) this.l.findViewById(R.id.tv_quote);
        ImageView imageView2 = (ImageView) this.l.findViewById(R.id.iv_quote_close);
        this.aN = imageView2;
        imageView2.setOnClickListener(this);
        this.aQ = this.l.findViewById(R.id.img_new_remind_circle);
        this.aR = (ViewStub) this.l.findViewById(R.id.vs_announcement);
        RiskyMsgDeletedHint riskyMsgDeletedHint3 = (RiskyMsgDeletedHint) this.l.findViewById(R.id.cheat_hint);
        this.aU = riskyMsgDeletedHint3;
        riskyMsgDeletedHint3.setAutoDismiss(false);
        this.aU.setTheme(RiskyMsgDeletedHint.Theme.RED);
        this.aV = (RiskyMsgDeletedHint) this.l.findViewById(R.id.group_freeze_hint);
        this.aX = this.l.findViewById(2131370259);
        this.aW = this.l.findViewById(2131369461);
        RiskyMsgDeletedHint riskyMsgDeletedHint4 = (RiskyMsgDeletedHint) this.l.findViewById(R.id.abuse_hint);
        this.aY = riskyMsgDeletedHint4;
        riskyMsgDeletedHint4.setHint(getString(R.string.msg_abuse_hint));
        this.aY.setAutoDismiss(false);
        this.aY.setTheme(RiskyMsgDeletedHint.Theme.RED);
        if (this.h.D()) {
            this.ba.setImageDrawable(BluedSkinUtils.b(this.m, (int) R.drawable.btn_keyboard));
            this.aZ.setVisibility(0);
            this.bg.setVisibility(0);
            this.be.setVisibility(8);
            this.bb.setVisibility(8);
            this.f18053c.setVisibility(8);
            this.N.setVisibility(8);
            this.ba.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    MsgChattingFragment.this.U();
                }
            });
        } else {
            this.aZ.setVisibility(8);
            this.bb.setVisibility(8);
            this.be.setVisibility(0);
            this.ba.setOnClickListener(null);
        }
        if (!this.h.c()) {
            MessageEventUtils.c("CHAT_SHOW");
        }
        if (this.h.f && BluedPreferences.eS() && this.h.D()) {
            this.p.postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.20
                @Override // java.lang.Runnable
                public void run() {
                    MsgChattingFragment msgChattingFragment = MsgChattingFragment.this;
                    msgChattingFragment.b(msgChattingFragment.p);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        e();
        final TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.bi.getHeight());
        translateAnimation.setDuration(100L);
        translateAnimation.setRepeatMode(2);
        translateAnimation.setRepeatCount(1);
        translateAnimation.setFillAfter(false);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.24
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                if (MsgChattingFragment.this.bg.getVisibility() == 0) {
                    MsgChattingFragment.this.ba.setImageDrawable(BluedSkinUtils.b(MsgChattingFragment.this.m, (int) R.drawable.icon_chat_service_menu));
                    MsgChattingFragment.this.bg.setVisibility(8);
                    MsgChattingFragment.this.bb.setVisibility(0);
                    MsgChattingFragment.this.f18053c.setVisibility(0);
                    if (MsgChattingFragment.this.f18053c.getText().toString().isEmpty()) {
                        return;
                    }
                    MsgChattingFragment.this.N.setVisibility(0);
                    return;
                }
                MsgChattingFragment.this.ba.setImageDrawable(BluedSkinUtils.b(MsgChattingFragment.this.m, (int) R.drawable.btn_keyboard));
                MsgChattingFragment.this.bg.setVisibility(0);
                MsgChattingFragment.this.bb.setVisibility(8);
                MsgChattingFragment.this.f18053c.setVisibility(8);
                if (MsgChattingFragment.this.N.getVisibility() == 0) {
                    MsgChattingFragment.this.N.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.25
            @Override // java.lang.Runnable
            public void run() {
                MsgChattingFragment.this.bi.startAnimation(translateAnimation);
            }
        }, 50L);
    }

    private void V() {
        if (this.f || this.ao || ScreenUtils.b(getActivity())) {
            return;
        }
        this.aD.setVisibility(0);
        Logger.c(k, "showBottomGap");
    }

    private void W() {
        this.aw = BluedPreferences.bZ();
        this.f18053c.setHorizontallyScrolling(false);
        if (!this.aw) {
            this.f18053c.setImeOptions(0);
            this.f18053c.setInputType(131072);
            this.f18053c.setSingleLine(false);
            this.f18053c.setMaxLines(4);
            return;
        }
        this.f18053c.setImeOptions(4);
        this.f18053c.setInputType(262144);
        this.f18053c.setSingleLine(false);
        this.f18053c.setMaxLines(4);
        this.f18053c.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$MsgChattingFragment$CK4sbGcm0D4Z0gz9ndxsdMWrfpw
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean a2;
                a2 = MsgChattingFragment.this.a(textView, i, keyEvent);
                return a2;
            }
        });
    }

    private void X() {
        SmartRefreshLayout smartRefreshLayout = this.B;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.j();
            this.B.h();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Y() {
        this.F.f18629a = 60;
        AudioChannelManager.j().n();
        this.F.setOnRecordListener(new RecordButton.OnRecordListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.39

            /* renamed from: a  reason: collision with root package name */
            String f18096a = "";

            private void b() {
                MsgChattingFragment.this.F.setBackground(BluedSkinUtils.b(MsgChattingFragment.this.m, (int) R.drawable.shape_msg_chatting_voice_blue_solid_ed));
                IMV4Constant.f18550a = true;
                BLAudioManager.a(MsgChattingFragment.this.m).c();
                MsgChattingFragment.this.F.setText(R.string.release_notalk);
            }

            private void c() {
                MsgChattingFragment.this.F.setBackground(BluedSkinUtils.b(MsgChattingFragment.this.m, (int) R.drawable.shape_msg_chatting_voice_blue_solid));
                IMV4Constant.f18550a = false;
                BLAudioManager.a(MsgChattingFragment.this.m).d();
                MsgChattingFragment.this.F.setText(R.string.press_talk);
            }

            @Override // com.soft.blued.ui.msg.customview.RecordButton.OnRecordListener
            public BaseFragment a() {
                return MsgChattingFragment.this;
            }

            @Override // com.soft.blued.ui.msg.customview.RecordButton.OnRecordListener
            public void a(int i) {
                if (MsgChattingFragment.this.h != null) {
                    File file = new File(this.f18096a);
                    if (!file.exists() || file.length() == 0) {
                        ToastUtils.a(MsgChattingFragment.this.m.getString(R.string.record_again));
                    } else {
                        MsgChattingFragment.this.h.b(this.f18096a, i, 0);
                    }
                }
            }

            @Override // com.soft.blued.ui.msg.customview.RecordButton.OnRecordListener
            public void a(MotionEvent motionEvent) {
                MsgChattingFragment.this.O();
                LiveFloatManager.a().j();
                b();
                short E = MsgChattingFragment.this.h.E();
                long e = MsgChattingFragment.this.h.e();
                this.f18096a = IMV4Method.a(E, e, System.currentTimeMillis() + "");
                Logger.b(MsgChattingFragment.k, "==recordPath===", this.f18096a);
                MsgChattingFragment.this.F.setRecordPath(this.f18096a);
            }

            @Override // com.soft.blued.ui.msg.customview.RecordButton.OnRecordListener
            public void b(MotionEvent motionEvent) {
                LiveFloatManager.a().i();
                c();
            }
        });
        this.D.a(Integer.valueOf((int) R.id.chat_state_error), new BaseListAdapter.onInternalClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.40
            @Override // com.soft.blued.ui.msg.adapter.BaseListAdapter.onInternalClickListener
            public void a(View view, View view2, Integer num, Object obj) {
                MsgChattingFragment.this.a(view, view2, obj);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_IM_BUBBLE, Void.class).observe(this, new Observer<Void>() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.41
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Void r4) {
                MsgChattingFragment.this.D.notifyDataSetChanged();
                if (MsgChattingFragment.this.h == null || !MsgChattingFragment.this.h.V()) {
                    return;
                }
                MsgChattingFragment.this.C.setSelection(MsgChattingFragment.this.D.getCount());
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_OPEN_GIFT_PACKAGE, OpenGiftPackageEvent.class).observe(this, new Observer<OpenGiftPackageEvent>() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.42
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(OpenGiftPackageEvent openGiftPackageEvent) {
                if (openGiftPackageEvent.f18638a == null || !openGiftPackageEvent.f18638a.equals(MsgChattingFragment.this.getFragmentActive())) {
                    return;
                }
                Context context = MsgChattingFragment.this.getContext();
                ActivityFragmentActive fragmentActive = MsgChattingFragment.this.getFragmentActive();
                UserGiftDialogFragment.a(context, fragmentActive, MsgChattingFragment.this.h.f() + "", !TextUtils.isEmpty(MsgChattingFragment.this.h.g) ? MsgChattingFragment.this.h.g : "chat_page_gift", new UserGiftDialogFragment.BuySucceedListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.42.1
                    @Override // com.soft.blued.ui.msg.pop.UserGiftDialogFragment.BuySucceedListener
                    public void a(UserGiftDialogFragment userGiftDialogFragment, GiftGivingOptionForJsonParse giftGivingOptionForJsonParse) {
                        userGiftDialogFragment.dismissAllowingStateLoss();
                        if (MsgChattingFragment.this.h != null) {
                            MsgChattingFragment.this.h.a(giftGivingOptionForJsonParse);
                        }
                    }
                }, MsgChattingFragment.this.h.S().relationship, MsgChattingFragment.this.h.S() != null ? MsgChattingFragment.this.h.S().name : "", 1);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_KEEP_SCREEN, KeepScreenEvent.class).observe(this, new Observer<KeepScreenEvent>() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.43
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(KeepScreenEvent keepScreenEvent) {
                if (keepScreenEvent.f18637a) {
                    MsgChattingFragment.this.getActivity().getWindow().addFlags(128);
                } else {
                    MsgChattingFragment.this.getActivity().getWindow().clearFlags(128);
                }
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_CHECK_SHOW_HELLO_EXPRESSION, Void.class).observe(this, new Observer<Void>() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.44
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Void r3) {
                MsgChattingFragment.this.Z();
            }
        });
        LiveEventBus.get("choose_at_user", GroupMemberModel.class).observe(this, new Observer<GroupMemberModel>() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.45
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(GroupMemberModel groupMemberModel) {
                MsgChattingFragment.this.a(groupMemberModel.uid, groupMemberModel.name);
            }
        });
        LiveEventBus.get("exit_group", Integer.class).observe(this, new Observer<Integer>() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.46
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Integer num) {
                if (MsgChattingFragment.this.h.m() == null || num.intValue() != MsgChattingFragment.this.h.m().group_id || MsgChattingFragment.this.getActivity() == null) {
                    return;
                }
                MsgChattingFragment.this.getActivity().finish();
            }
        });
        LiveEventBus.get("card_at_user", AtUserEvent.class).observe(this, new Observer<AtUserEvent>() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.47
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(AtUserEvent atUserEvent) {
                MsgChattingFragment.this.al.a(MsgChattingFragment.this.f18053c, atUserEvent.a(), MsgChattingFragment.this.bx, false);
                KeyboardUtils.c(MsgChattingFragment.this.getActivity());
            }
        });
        LiveEventBus.get("group_chat_kick_out", String.class).observe(this, new Observer<String>() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.48
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (MsgChattingFragment.this.h != null) {
                    MsgChattingFragment.this.h.g(str);
                }
            }
        });
        LiveEventBus.get("group_update_chat_source_from", UpdateSourceFromEvent.class).observe(this, new Observer<UpdateSourceFromEvent>() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.49
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(UpdateSourceFromEvent updateSourceFromEvent) {
                if (MsgChattingFragment.this.h != null) {
                    MsgChattingFragment.this.h.e(updateSourceFromEvent.a());
                }
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_REPORT_CONFIRM_DIALOG, String.class).observe(this, new Observer<String>() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.50
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (MsgChattingFragment.this.h != null) {
                    MsgChattingFragment.this.h.f(str);
                }
            }
        });
        this.aU.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.51
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        this.aU.setCloseClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.52
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                MessageProtos.Event event = MessageProtos.Event.MSG_CHEAT_TOAST_CLOSE;
                MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
                EventTrackMessage.a(event, strangerSource, MsgChattingFragment.this.h.f() + "");
            }
        });
        this.aT.e().observe(getViewLifecycleOwner(), new Observer() { // from class: com.soft.blued.ui.msg.-$$Lambda$MsgChattingFragment$PUmsk9WYHom1A6gdLa2zdpSPVc8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MsgChattingFragment.this.a((MsgUserCheatModel) obj);
            }
        });
        LiveEventBus.get("EVENT_BUS_ACTIVITY_SCORED", EventDetailsModel.class).observe(this, new Observer() { // from class: com.soft.blued.ui.msg.-$$Lambda$MsgChattingFragment$NP-nJj8dYnK8yT5QIKheGFemLcs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MsgChattingFragment.this.a((EventDetailsModel) obj);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_FLASH_TIP, Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.53
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                if (MsgChattingFragment.this.av != null) {
                    MsgChattingFragment.this.av.a(MsgChattingFragment.this.m);
                }
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_MSG_SEND_SUCCEED, ChattingModel.class).observe(this, new Observer<ChattingModel>() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.54
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(ChattingModel chattingModel) {
                MsgChattingFragment.this.b(chattingModel);
                MsgChattingFragment.this.k();
                MsgChattingFragment.this.h.z();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        if (this.h.D() || this.D.getCount() != 0 || this.h.ap()) {
            return;
        }
        if (this.aG != null) {
            a(new boolean[0]);
            return;
        }
        this.aG = this.aF.inflate();
        if (this.h.S() != null && this.h.S().fold_say_hi == 1) {
            ((LinearLayout) this.aG.findViewById(R.id.ll_hint)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.55
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    MsgChattingFragment.this.h.ak();
                }
            });
            return;
        }
        this.aG.setVisibility(8);
        this.h.ak();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        dialogInterface.dismiss();
        this.h.i(true);
    }

    private void a(View view, View view2, View view3) {
        HashMap hashMap = new HashMap();
        if (this.h.D()) {
            hashMap.put(this.bc, view);
            hashMap.put(this.bd, view2);
            this.av.setVisibility(8);
        } else {
            hashMap.put(this.J, view);
            hashMap.put(this.M, view3);
            hashMap.put(this.H, view2);
        }
        this.aW.getKeyboardHelper().a(hashMap);
        this.aW.getKeyboardHelper().a(new SwitchPreHandleListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.4
            public boolean a(KeyboardHelper keyboardHelper, View view4, boolean z, boolean z2) {
                if (view4.getId() == 2131362521) {
                    EventTrackMessage.a(MessageProtos.Event.MSG_ADD_BTN_CLICK);
                }
                if (z2 && view4.getId() == 2131362509) {
                    MsgChattingFragment.this.av.b();
                    if (MsgChattingFragment.this.h.S() != null && MsgChattingFragment.this.h.S().has_screenshot == 1) {
                        MsgChattingFragment.this.ae();
                    }
                }
                if (z2 && view4.getId() == 2131362521 && MsgChattingFragment.this.h.S() != null && MsgChattingFragment.this.h.S().has_screenshot == 1) {
                    MsgChattingFragment.this.ae();
                }
                if (z2) {
                    if (MsgChattingFragment.this.h.D()) {
                        if (view4.getId() == 2131362518) {
                            MsgChattingFragment.this.e(true);
                        } else {
                            MsgChattingFragment.this.e(false);
                        }
                    } else if (view4.getId() == 2131362521) {
                        MsgChattingFragment.this.d(true);
                    } else {
                        MsgChattingFragment.this.d(false);
                    }
                } else if (MsgChattingFragment.this.h.D()) {
                    MsgChattingFragment.this.e(false);
                } else {
                    MsgChattingFragment.this.d(false);
                }
                if (z2 || z) {
                    MsgChattingFragment.this.Q();
                    MsgChattingFragment.this.I.setTag("audio");
                    MsgChattingFragment.this.I.setImageDrawable(BluedSkinUtils.b(MsgChattingFragment.this.m, (int) R.drawable.btn_voice));
                    MsgChattingFragment.this.f18053c.setVisibility(0);
                    if (TextUtils.isEmpty(MsgChattingFragment.this.f18053c.getText().toString())) {
                        MsgChattingFragment.this.N.setVisibility(8);
                    } else {
                        MsgChattingFragment.this.N.setVisibility(0);
                    }
                    MsgChattingFragment.this.F.setVisibility(8);
                    return false;
                }
                return false;
            }
        });
        this.aW.getKeyboardHelper().a(new KeyboardStatusListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.5
            public void a(KeyboardHelper keyboardHelper, boolean z, boolean z2, int i) {
                MsgChattingFragment.this.f = z;
                MsgChattingFragment.this.ao = z2;
                if (!z2) {
                    try {
                        if (MsgChattingFragment.this.h.D()) {
                            MsgChattingFragment.this.e(false);
                        } else {
                            MsgChattingFragment.this.d(false);
                        }
                    } catch (Throwable th) {
                        return;
                    }
                }
                if (z || z2) {
                    MsgChattingFragment.this.C.requestFocusFromTouch();
                    MsgChattingFragment.this.C.setSelection(MsgChattingFragment.this.D.getCount() - 1);
                    MsgChattingFragment.this.C.clearFocus();
                    if (z) {
                        MsgChattingFragment.this.f18053c.requestFocus();
                    } else {
                        MsgChattingFragment.this.aX.requestFocus();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GroupInfoModel groupInfoModel) {
        int i = groupInfoModel.group_status;
        if (i == 2) {
            a(getString(R.string.group_locked_hint));
        } else if (i == 4) {
            this.aV.setHint(String.format(getString(groupInfoModel.group_role == 1 ? 2131888534 : 2131888460), groupInfoModel.lock_time));
            this.aV.setAutoDismiss(false);
            this.aV.c();
            if (groupInfoModel.group_role == 1) {
                this.aV.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.57
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        Context context = MsgChattingFragment.this.getContext();
                        WebViewShowInfoFragment.show(context, GroupConstant.f18972a + "frozen");
                    }
                });
            }
        } else if (i != 5) {
            this.aK.setVisibility(8);
            this.aV.setVisibility(8);
        } else {
            a(getString(R.string.group_frozen));
            TextView textView = (TextView) this.aK.findViewById(R.id.tv_unfreeze);
            if (groupInfoModel.group_role != 1) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.58
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    Context context = MsgChattingFragment.this.getContext();
                    WebViewShowInfoFragment.show(context, GroupConstant.f18972a + "relieve");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(EventDetailsModel eventDetailsModel) {
        if (this.h.m() == null || this.h.m().type != 4 || this.h.m().event == null) {
            return;
        }
        if ((this.h.m().event.id + "").equals(eventDetailsModel.id)) {
            this.h.m().event.is_rate = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MsgUserCheatModel msgUserCheatModel) {
        if (msgUserCheatModel.getRisk() == 1) {
            if (this.at.getVisibility() == 0) {
                this.at.setVisibility(8);
            }
            MessageProtos.Event event = MessageProtos.Event.MSG_CHEAT_TOAST_SHOW;
            MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
            EventTrackMessage.a(event, strangerSource, this.h.f() + "");
            this.aU.setHint(msgUserCheatModel.getAlert());
            this.aU.c();
        }
    }

    private void a(String str, short s) {
        boolean z;
        if (UserInfoHelper.b(UserInfo.getInstance().getLoginUserInfo().vbadge)) {
            this.f18053c.setHint("");
        }
        if (this.h != null) {
            if (TextUtils.isEmpty(str)) {
                str = this.al.b(this.f18053c.getText().toString());
                z = true;
            } else {
                z = false;
            }
            if (TextUtils.isEmpty(StringUtils.j(str))) {
                ToastUtils.a(2131886986);
                return;
            }
            ChattingModel a2 = this.h.a(s, str);
            if (this.D.getCount() <= 0 && z) {
                this.h.c(a2);
            }
            if (this.aM.getVisibility() == 0) {
                this.h.a(a2, this.aO.getText().toString(), this.aM.getTag() != null ? this.aM.getTag().toString() : null);
            }
            this.h.B();
            if (a2 == null) {
                return;
            }
            this.h.b(a2);
            if (s == 1) {
                this.f18053c.setText("");
                this.H.setVisibility(0);
                this.N.setVisibility(8);
                this.aM.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<ServiceMenuModel> list, View view, int i) {
        if (getFragmentActive().isActive()) {
            list.get(list.size() - 1).show_divider = 1;
            ServiceMenuPopWindow serviceMenuPopWindow = new ServiceMenuPopWindow(getContext());
            serviceMenuPopWindow.a(list, this.h.f(), i);
            new XPopup.Builder(getContext()).a(PopupAnimation.v).a(PopupPosition.c).d(false).b(true).b(true).a(view).a(serviceMenuPopWindow).h();
        }
    }

    private void a(boolean... zArr) {
        if (this.bw || this.h.c() || this.aG == null) {
            return;
        }
        this.bw = true;
        postDelaySafeRunOnUiThread(new AnonymousClass8(), zArr.length > 0 ? 100 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 4) {
            o();
            return true;
        }
        return false;
    }

    private void aa() {
        MsgGroupHttpUtils.a(getFragmentActive(), String.valueOf(this.h.f()), new BluedUIHttpResponse<BluedEntityA<GroupInfoModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.msg.MsgChattingFragment.60
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<GroupInfoModel> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                GroupInfoModel groupInfoModel = (GroupInfoModel) bluedEntityA.data.get(0);
                if (groupInfoModel != null) {
                    if (groupInfoModel.group_role == 0) {
                        MsgChattingFragment msgChattingFragment = MsgChattingFragment.this;
                        msgChattingFragment.a(msgChattingFragment.getString(R.string.group_kicked_hint));
                    } else {
                        MsgChattingFragment.this.a(groupInfoModel);
                    }
                    if (MsgChattingFragment.this.h.c()) {
                        if (groupInfoModel.online > 0) {
                            MsgChattingFragment.this.w.setVisibility(0);
                            MsgChattingFragment.this.x.setVisibility(0);
                            TextView textView = MsgChattingFragment.this.x;
                            textView.setText(groupInfoModel.online + MsgChattingFragment.this.m.getString(R.string.group_online_number));
                        } else {
                            MsgChattingFragment.this.x.setVisibility(8);
                            MsgChattingFragment.this.w.setVisibility(8);
                        }
                    }
                    MsgChattingFragment.this.h.a(groupInfoModel);
                    String a2 = ChatHelperV4.a().a(groupInfoModel.admin);
                    SessionSettingModel L = MsgChattingFragment.this.h.L();
                    if (L != null) {
                        if (!StringUtils.d(a2)) {
                            L.setGroupAdiminIDs(a2);
                        }
                        L.setGroupCreateId(groupInfoModel.group_uid);
                        L.group_status = groupInfoModel.group_status;
                        L.is_super = groupInfoModel.is_super;
                        ChatManager.getInstance().setSessionSetting(MsgChattingFragment.this.h.E(), MsgChattingFragment.this.h.e(), L);
                    }
                    SessionProfileModel sessionProfileModel = new SessionProfileModel();
                    sessionProfileModel.nickname = groupInfoModel.group_title;
                    sessionProfileModel.avatar = groupInfoModel.group_cover;
                    ChatManager.getInstance().updateSessionInfoData(MsgChattingFragment.this.h.E(), MsgChattingFragment.this.h.e(), sessionProfileModel);
                    SessionModel M = MsgChattingFragment.this.h.M();
                    if (M != null) {
                        if (groupInfoModel.group_status == 2 && M.sessionStatus != 1) {
                            ChatManager.getInstance().updateSesssionStatus(MsgChattingFragment.this.h.E(), MsgChattingFragment.this.h.e(), 1);
                        } else if (groupInfoModel.group_status == 1 && M.sessionStatus == 1) {
                            ChatManager.getInstance().updateSesssionStatus(MsgChattingFragment.this.h.E(), MsgChattingFragment.this.h.e(), 0);
                        }
                    }
                }
                if (MsgChattingFragment.this.j != null) {
                    Message obtain = Message.obtain();
                    obtain.what = 301;
                    obtain.obj = groupInfoModel;
                    MsgChattingFragment.this.j.sendMessage(obtain);
                }
            }

            public boolean onUIFailure(int i, String str) {
                if (i == 40319010 || i == 40319059) {
                    MsgChattingFragment.this.a(str);
                    MsgChattingFragment.this.q.setVisibility(4);
                    MsgChattingFragment.this.p.setVisibility(4);
                    return true;
                }
                return true;
            }
        });
    }

    private void ab() {
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent == null || msgChattingPresent.S() == null || this.h.c() || this.h.ap()) {
            this.af.setVisibility(8);
            this.ac.setVisibility(8);
            return;
        }
        final UserInfoBasicModel S = this.h.S();
        if (!OnlineStatusManager.f18745a.a() || (S.live == 0 && S.room_id == 0 && S.online_state != 1)) {
            this.af.setVisibility(8);
        } else {
            this.af.setVisibility(0);
        }
        if (S.live == 0 && S.room_id == 0) {
            this.ac.setVisibility(8);
        } else {
            ImageLoader.c(getFragmentActive(), "anim_nearby_chat.png").f().g(-1).a(this.ae);
            this.ac.setVisibility(0);
        }
        if (S.live != 0) {
            ShapeHelper.a(this.ac, 2131101608, 2131101728);
            this.ad.setText(this.m.getString(R.string.online_status_living));
            this.ac.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.61
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (S.live == 0 || MsgChattingFragment.this.h.f() == 0) {
                        return;
                    }
                    EventTrackMessage.d(MessageProtos.Event.CHAT_USER_LIVE_YY_CLICK, OnlineStatusManager.f18745a.a((Integer) 2), MsgChattingFragment.this.h.f() + "", S.live + "");
                    LiveRoomInfoChannel.a(MsgChattingFragment.this.m, new LiveRoomData(S.live, 0, MediaFormat.KEY_PROFILE, MsgChattingFragment.this.h.f() + "", S.name, S.avatar, S.vbadge));
                }
            });
            EventTrackMessage.d(MessageProtos.Event.CHAT_USER_SHOW, OnlineStatusManager.f18745a.a((Integer) 2), this.h.f() + "", S.live + "");
        } else if (S.room_id == 0) {
            EventTrackMessage.d(MessageProtos.Event.CHAT_USER_SHOW, OnlineStatusManager.f18745a.a((Integer) 0), this.h.f() + "", "");
        } else {
            ShapeHelper.a(this.ac, (int) R.color.syc_online_chat_start, (int) R.color.syc_online_chat_end);
            this.ad.setText(this.m.getString(R.string.online_status_chatting));
            this.ac.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.62
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    EventTrackMessage.d(MessageProtos.Event.CHAT_USER_LIVE_YY_CLICK, OnlineStatusManager.f18745a.a((Integer) 3), MsgChattingFragment.this.h.f() + "", S.room_id + "");
                    BluedURIRouterAdapter.openYYChatRoom(MsgChattingFragment.this.m, "" + S.room_id, "", "", "");
                }
            });
            EventTrackMessage.d(MessageProtos.Event.CHAT_USER_SHOW, OnlineStatusManager.f18745a.a((Integer) 3), this.h.f() + "", S.room_id + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac() {
        if (this.h != null) {
            VideoChatDialogFragment videoChatDialogFragment = new VideoChatDialogFragment();
            videoChatDialogFragment.a(this.h.f());
            videoChatDialogFragment.show(getActivity().getSupportFragmentManager(), VideoChatDialogFragment.class.getSimpleName());
            videoChatDialogFragment.a(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.65
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (MsgChattingFragment.this.h.S() != null && "3".equals(MsgChattingFragment.this.h.S().relationship)) {
                        MsgChattingFragment.this.h.a(new List[0]);
                    }
                }
            });
        }
    }

    private void ad() {
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent == null || msgChattingPresent.T() || this.h.M() == null) {
            return;
        }
        c(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae() {
        if (this.at.getVisibility() == 0) {
            R();
        }
        if (this.aA.a()) {
            this.aA.d();
        }
        this.aJ.c();
    }

    private void af() {
        if (this.h.c()) {
            return;
        }
        View inflate = getLayoutInflater().inflate(R.layout.layout_chat_safe_common_header, (ViewGroup) this.C, false);
        this.bm = inflate;
        this.C.addHeaderView(inflate, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag() {
        View view = this.bm;
        if (view != null) {
            this.C.removeHeaderView(view);
        }
    }

    private void ah() {
        View view = this.bm;
        if (view == null || this.D == null) {
            return;
        }
        this.D.a(ViewHolder.a(view, R.id.common_safe_root));
    }

    private void ai() {
        ImageView imageView = (ImageView) this.l.findViewById(R.id.iv_date_today_bg);
        if (this.h.ap()) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aW.getLayoutParams();
            layoutParams.topMargin = StatusBarHelper.a(this.m);
            this.aW.setLayoutParams(layoutParams);
            this.aW.setBackgroundColor(0);
            imageView.setVisibility(0);
            if (BluedPreferences.cK()) {
                ImageLoader.a(getFragmentActive(), ImgURLMap.a.a("bg_date_today_chat_dark")).a(imageView);
            } else {
                ImageLoader.a(getFragmentActive(), ImgURLMap.a.a("bg_date_today_chat")).a(imageView);
            }
        } else {
            this.aW.setBackgroundColor(BluedSkinUtils.a(this.m, 2131101796));
            imageView.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) this.l.findViewById(R.id.ll_date_today_block);
        RelativeLayout relativeLayout = (RelativeLayout) this.l.findViewById(R.id.rl_title_right);
        if (this.h.ap()) {
            relativeLayout.setVisibility(8);
            linearLayout.setVisibility(0);
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$MsgChattingFragment$fPD5Mbr5OBQT6t1YSb5E336oSxk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MsgChattingFragment.this.i(view);
                }
            });
        } else {
            relativeLayout.setVisibility(0);
            linearLayout.setVisibility(8);
        }
        this.bp = (CardView) this.l.findViewById(R.id.cv_pop_date_today_match);
        this.bq = (ImageView) this.l.findViewById(R.id.iv_date_today_like_left);
        this.br = (ImageView) this.l.findViewById(R.id.iv_date_today_like_right);
        this.bs = this.l.findViewById(R.id.svga_date_today_like_left);
        if (this.h.ap()) {
            this.bp.setVisibility(0);
            this.bp.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$MsgChattingFragment$jn-G18mIui9eRLOvwdb7rbZKVqM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MsgChattingFragment.this.h(view);
                }
            });
        } else {
            this.bp.setVisibility(8);
        }
        if (this.h.j(true)) {
            this.bq.setImageResource(R.drawable.icon_date_today_heart_left_like_small);
        }
        if (this.h.j(false)) {
            this.br.setImageResource(R.drawable.icon_date_today_heart_right_like_small);
        }
        if (this.bu == null) {
            this.bu = this.l.findViewById(R.id.svga_date_today_say_hello_anim);
        }
        this.bt = (LinearLayout) this.l.findViewById(R.id.ll_date_today_say_hi);
        if (this.h.ap()) {
            ImageView imageView2 = (ImageView) this.l.findViewById(R.id.iv_date_today_say_hi1);
            ImageView imageView3 = (ImageView) this.l.findViewById(R.id.iv_date_today_say_hi2);
            ImageView imageView4 = (ImageView) this.l.findViewById(R.id.iv_date_today_say_hi3);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$MsgChattingFragment$Xud2O-aBDc0w7e2dplNr6U_coFY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MsgChattingFragment.this.g(view);
                }
            });
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$MsgChattingFragment$9qME1Nu8aPi8YKCundL3z2DgDLk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MsgChattingFragment.this.f(view);
                }
            });
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$MsgChattingFragment$EsVdVmLdlecF3oNVOMlALpFqt7M
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MsgChattingFragment.this.e(view);
                }
            });
            ((ImageView) this.l.findViewById(R.id.iv_date_today_say_hi4)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$MsgChattingFragment$SkkG35n-rAHgveHtmnBuwypBExQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MsgChattingFragment.this.d(view);
                }
            });
        }
    }

    private void aj() {
        CardView cardView = this.bp;
        if (cardView != null) {
            cardView.animate().translationX(DensityUtil.a(33.0f)).setInterpolator(new AccelerateInterpolator()).setListener(new Animator.AnimatorListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.82
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    MsgChattingFragment.this.bp.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            }).start();
        }
        a(BluedSkinUtils.c() ? "date_today_both_interest.svga" : "date_today_both_interest_dark.svga", new Runnable() { // from class: com.soft.blued.ui.msg.-$$Lambda$MsgChattingFragment$x6Cq5gGW7B4rOcdLtJnyYwT-Fz8
            @Override // java.lang.Runnable
            public final void run() {
                MsgChattingFragment.this.an();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak() {
        SVGAImageView sVGAImageView = this.bu;
        if (sVGAImageView != null) {
            sVGAImageView.clearAnimation();
            this.bu.setVisibility(8);
        }
    }

    private void al() {
        BluedAlertDialog bluedAlertDialog = this.bn;
        if (bluedAlertDialog == null || !bluedAlertDialog.isShowing()) {
            BluedAlertDialog a2 = new BluedAlertDialog.Builder(this.m).d((int) R.string.date_today_do_not_like_confirm_title).e((int) R.string.date_today_do_not_like_confirm_desc).b((int) R.string.date_today_do_not_like_confirm_no, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$MsgChattingFragment$AfqFoPYX0qWap8s782ZUgfVEdSU
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MsgChattingFragment.d(dialogInterface, i);
                }
            }).g(2131102254).a((int) R.string.date_today_do_not_like_confirm_yes, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$MsgChattingFragment$eOVCboMc0c4xLpVI-QWXcXwBeIc
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MsgChattingFragment.this.c(dialogInterface, i);
                }
            }).b(false).f(2131102251).a();
            this.bn = a2;
            a2.show();
        }
    }

    private void am() {
        BluedAlertDialog bluedAlertDialog = this.bo;
        if (bluedAlertDialog == null || !bluedAlertDialog.isShowing()) {
            BluedAlertDialog a2 = new BluedAlertDialog.Builder(this.m).d((int) R.string.date_today_close_chat_title).e((int) R.string.date_today_close_chat_desc).b((int) R.string.date_today_close_chat_no, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$MsgChattingFragment$Vnp4n530p20hdVIh5IpeWJYvorM
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MsgChattingFragment.this.b(dialogInterface, i);
                }
            }).g(2131102254).a((int) R.string.date_today_close_chat_yes, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$MsgChattingFragment$BZT_T6wX3bVSi0528HGOhBGeTr0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MsgChattingFragment.this.a(dialogInterface, i);
                }
            }).b(false).f(2131102251).a();
            this.bo = a2;
            a2.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void an() {
        int i;
        View a2;
        List<E> list = this.D.f18271a;
        if (list != 0) {
            int size = list.size();
            while (true) {
                i = size - 1;
                if (i < 0) {
                    break;
                } else if (((ChattingModel) list.get(i)).msgType == 288) {
                    break;
                } else {
                    size = i;
                }
            }
            if (i >= 0 || (a2 = a(i, this.C)) == null) {
                ak();
            }
            Log.e("xxx", "dateTodayPlayBothInterestAnim() itemView=" + a2);
            c(a2);
            return;
        }
        i = -1;
        if (i >= 0) {
        }
        ak();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        dialogInterface.dismiss();
        this.h.i(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        try {
            View inflate = View.inflate(this.m, R.layout.pop_msg_chat_guide, null);
            final BluedPopupWindow a2 = BluedPopupWindow.Builder.a(getActivity(), inflate).a(true).a();
            TextView textView = (TextView) inflate.findViewById(R.id.tv_cnt);
            textView.setText(this.m.getString(R.string.service_msg_private_guide_content));
            textView.setBackground(NinePatchUtils.a(NinePatchUtils.GuideArrowPosition.c, new int[]{2131232898}));
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    a2.dismiss();
                }
            });
            a2.a(view, 2, 0, 0, DensityUtils.a(this.m, 2.0f));
            a2.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.22
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    BluedPreferences.eT();
                }
            });
            inflate.postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.23
                @Override // java.lang.Runnable
                public void run() {
                    BluedPopupWindow bluedPopupWindow = a2;
                    if (bluedPopupWindow == null || !bluedPopupWindow.isShowing()) {
                        return;
                    }
                    a2.dismiss();
                }
            }, m.ag);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ChattingModel chattingModel) {
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent == null || msgChattingPresent.r() <= 0 || this.by.get() || chattingModel.msgType <= 0 || chattingModel.msgType == 243) {
            return;
        }
        this.by.compareAndSet(false, true);
        ChattingModel chattingModel2 = new ChattingModel(chattingModel);
        chattingModel2.msgLocalId = ChatHelper.getLocalId();
        chattingModel2.msgType = (short) -8;
        chattingModel2.msgContent = this.h.r() + "";
        ChatHelperV4.a().h(chattingModel2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        DateTodayManager.f18714a.a(MessageProtos.Event.MSG_MATCH_CHAT_PAGE_UNLIKE_CLICK);
        dialogInterface.dismiss();
        this.h.k(false);
    }

    private void c(final View view) {
        int[] iArr;
        if (this.bu != null) {
            view.findViewById(R.id.rl_main_panel).getLocationOnScreen(r0);
            int[] iArr2 = {iArr2[0] + DensityUtil.a(62.0f), iArr2[1] + DensityUtil.a(60.0f)};
            this.bu.getLocationOnScreen(new int[2]);
            float width = this.bu.getWidth();
            float a2 = DensityUtil.a(33.0f);
            float f = a2 / (0.5833333f * width);
            float f2 = 1.7142857f * a2;
            float f3 = (f2 - a2) / 2.0f;
            float a3 = (f2 - DensityUtil.a(22.0f)) / 2.0f;
            float f4 = (width - f2) / 2.0f;
            this.bu.animate().scaleX(f).scaleY(f).translationX(((iArr2[0] - f3) - f4) - iArr[0]).translationY(((iArr2[1] - a3) - f4) - iArr[1]).setDuration(333L).setListener(new Animator.AnimatorListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.83
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    MsgChattingFragment.this.ak();
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_both_heart);
                    Log.e("xxx", "dateTodayShowScaleAndTranslateAnimation() ivBothHeart=" + imageView);
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                    if (MsgChattingFragment.this.h != null) {
                        MsgChattingFragment.this.h.aq();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ChattingModel chattingModel) {
        if (chattingModel != null && !IMV4Method.b(chattingModel.fromId)) {
            short s = chattingModel.msgType;
            if (s != 10 && s != 164 && s != 205 && s != 244 && s != 24 && s != 25 && s != 250 && s != 251) {
                switch (s) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        break;
                    default:
                        switch (s) {
                        }
                }
            }
            if (d(chattingModel)) {
                ag();
                return;
            }
        }
        View view = this.bm;
        if (view == null || this.D == null) {
            return;
        }
        View a2 = ViewHolder.a(view, R.id.common_safe_root);
        MsgExtraForTextTypeEntity.SecureNotify a3 = LocalSecureNotifyContent.a(this.m.getResources());
        MessageChatAdapter messageChatAdapter = this.D;
        Context context = this.m;
        messageChatAdapter.a(context, this.h.e() + "", getFragmentActive(), this.f18051a, (ChattingModel) null, a3, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null) {
            if (!msgChattingPresent.T() && this.D != null && !z) {
                this.h.d(true);
                postDelaySafeRunOnUiThread(new AnonymousClass27(z), 300L);
            }
            if (this.h.T() && z) {
                this.h.e(false);
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, this.ah.getMeasuredWidth(), 0.0f, 0.0f);
                translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.28
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (MsgChattingFragment.this.h != null) {
                            MsgChattingFragment.this.h.f(false);
                        }
                        MsgChattingFragment.this.C.setOnScrollListener(new MyOnScrollListener());
                        MsgChattingFragment.this.ah.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                translateAnimation.setDuration(500L);
                this.ah.startAnimation(translateAnimation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        Tracker.onClick(view);
        g(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        EventLogData eventLogData = new EventLogData();
        eventLogData.setEventId(str);
        eventLogData.setSourcePage(FeedProtos.SourcePage.GROUP_ACTIVITY);
        EventDetailsFragment.a.a(getContext(), str, eventLogData);
    }

    private void d(List<FuGiftModel> list) {
        BluedPreferences.aa(true);
        if (list != null && getFragmentActive().isActive()) {
            new XPopup.Builder(getContext()).a(false).b(false).a(new FuGiftPop(getContext(), list, UserGiftFragment.k, getFragmentActive())).h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z) {
            this.H.setImageDrawable(BluedSkinUtils.b(getContext(), (int) R.drawable.btn_plus_open));
        } else {
            this.H.setImageDrawable(BluedSkinUtils.b(getContext(), (int) R.drawable.btn_plus));
        }
    }

    private boolean d(ChattingModel chattingModel) {
        MsgExtraForTextTypeEntity msgExtraForTextTypeEntity;
        MsgExtraForTextTypeEntity.SecureNotify secureNotify;
        try {
            String msgExtra = chattingModel.getMsgExtra();
            if (TextUtils.isEmpty(msgExtra) || (msgExtraForTextTypeEntity = (MsgExtraForTextTypeEntity) AppInfo.f().fromJson(msgExtra, (Class<Object>) MsgExtraForTextTypeEntity.class)) == null || (secureNotify = msgExtraForTextTypeEntity.secureNotify) == null) {
                return false;
            }
            return MsgCommonUtils.a(secureNotify).notify_type == 1;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        Tracker.onClick(view);
        g(3);
    }

    private void e(List<ChattingModel> list) {
        int i;
        if (!this.h.ap() || this.bt == null) {
            return;
        }
        Iterator<ChattingModel> it = list.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            ChattingModel next = it.next();
            if (next.isFromSelf() && next.msgType != 281 && next.msgType > 0) {
                i = 8;
                break;
            }
        }
        f(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z) {
        if (z) {
            this.bd.setImageDrawable(BluedSkinUtils.b(getContext(), (int) R.drawable.icon_chat_service_plus_close));
        } else {
            this.bd.setImageDrawable(BluedSkinUtils.b(getContext(), (int) R.drawable.icon_chat_service_plus));
        }
    }

    private void f(int i) {
        this.bt.setVisibility(i);
        if (i == 0) {
            this.C.setClipToPadding(false);
            this.C.setPadding(0, 0, 0, DisplayUtil.a(this.m, 95.0f));
            return;
        }
        this.C.setClipToPadding(true);
        this.C.setPadding(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        Tracker.onClick(view);
        g(2);
    }

    private void g(int i) {
        f(8);
        int i2 = i != 1 ? i != 2 ? i != 3 ? i != 4 ? 0 : 2131887446 : 2131887445 : 2131887442 : 2131887444;
        DateTodaySayHelloModel dateTodaySayHelloModel = new DateTodaySayHelloModel(i, 0);
        dateTodaySayHelloModel.setMatchAnimationType(i);
        ChattingModel a2 = this.h.a((short) 282, this.m.getResources().getString(i2), AppInfo.f().toJson(dateTodaySayHelloModel));
        DateTodayManager.a(a2);
        this.h.b(a2);
        d(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        Tracker.onClick(view);
        g(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        Tracker.onClick(view);
        if (this.h.j(true)) {
            ToastUtils.b((int) R.string.date_today_text_wait_like);
            return;
        }
        DateTodayManager.f18714a.a(MessageProtos.Event.MSG_MATCH_CHAT_PAGE_LIKE_CLICK);
        this.h.k(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        Tracker.onClick(view);
        al();
    }

    @Override // com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback
    public List<MsgRecentPhotoInfo> A() {
        MsgChattingPresent msgChattingPresent = this.h;
        return msgChattingPresent != null ? msgChattingPresent.o() : new ArrayList();
    }

    @Override // com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback
    public void B() {
        RecentPhotoView recentPhotoView = this.av;
        if (recentPhotoView != null) {
            recentPhotoView.a(false);
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback
    public void C() {
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null) {
            msgChattingPresent.p();
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void D() {
        RecentPhotoView recentPhotoView = this.av;
        if (recentPhotoView != null) {
            recentPhotoView.a(this.m);
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void E() {
        DialogUtils.a(this.b);
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void F() {
        DialogUtils.b(this.b);
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public String G() {
        EditText editText = this.f18053c;
        return editText != null ? editText.getText().toString() : "";
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void H() {
        if (System.currentTimeMillis() > BluedPreferences.eL()) {
            this.aY.c();
        }
    }

    public UserInfoBasicModel I() {
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null) {
            return msgChattingPresent.S();
        }
        return null;
    }

    public void J() {
        SVGAImageView sVGAImageView;
        ToastUtils.a(this.m.getResources().getString(R.string.date_today_header_clicked));
        CardView cardView = this.bp;
        if ((cardView != null && cardView.getVisibility() != 0) || (sVGAImageView = this.bs) == null || sVGAImageView.getVisibility() == 0) {
            return;
        }
        String str = BluedSkinUtils.c() ? "date_today_interest.svga" : "date_today_interest_dark.svga";
        this.bs.setVisibility(0);
        new SVGAPlayer.Builder().a(str).a(1).a(this.bs);
        this.bs.setCallback(new SVGACallback() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.81
            public void onFinished() {
                MsgChattingFragment.this.bs.setVisibility(8);
            }

            public void onPause() {
            }

            public void onRepeat() {
            }

            public void onStep(int i, double d) {
            }
        });
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void K() {
        a(this.h.ac(), this.h.F(), this.h.G());
        ImageView imageView = this.t;
        if (imageView != null) {
            UserRelationshipUtils.a(imageView, this.h.S());
        }
        TextView textView = this.r;
        if (textView != null) {
            UserRelationshipUtils.a(this.m, textView, this.h.S());
        }
        ai();
        l();
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void L() {
        RelativeLayout relativeLayout = this.bh;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public /* synthetic */ IRequestHost M() {
        return super.getFragmentActive();
    }

    public View a(int i, ListView listView) {
        int headerViewsCount = i + listView.getHeaderViewsCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int childCount = listView.getChildCount();
        if (headerViewsCount < firstVisiblePosition || headerViewsCount > (childCount + firstVisiblePosition) - 1) {
            return null;
        }
        return listView.getChildAt(headerViewsCount - firstVisiblePosition);
    }

    public void a() {
        Logger.a("ddrb", "EmotionManager.getEmotionPacks() = ", Integer.valueOf(EmotionManager.c().size()));
        postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.6
            @Override // java.lang.Runnable
            public void run() {
                if (MsgChattingFragment.this.getActivity() == null || MsgChattingFragment.this.getActivity().isFinishing()) {
                    return;
                }
                MsgChattingFragment.this.f18052ar.setModel(false);
                MsgChattingFragment.this.f18052ar.a(MsgChattingFragment.this.getFragmentActive(), EmotionManager.c());
                MsgChattingFragment.this.ap.a(MsgChattingFragment.this.getFragmentActive(), EmotionManager.c());
                MsgChattingFragment.this.ap.a();
            }
        });
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void a(int i) {
        ImageView imageView = this.s;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void a(int i, long j) {
        if (this.aM.getVisibility() == 0 || this.aP) {
            String charSequence = this.aO.getText().toString();
            long j2 = 0;
            if (this.aM.getTag() != null) {
                j2 = ((Long) this.aM.getTag()).longValue();
            }
            Logger.c(k, "save quote msgId: " + j2);
            BluedPreferences.a(i, j, charSequence + "*" + j2);
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void a(final int i, String str) {
        if (this.h.D()) {
            return;
        }
        long du = BluedPreferences.du();
        if (i == 1 && du != 0 && System.currentTimeMillis() - du <= 604800000) {
            if (this.h.l().is_gift_new == 0 || BluedPreferences.u(this.h.l().is_gift_new)) {
                return;
            }
            a(2, this.h.l().is_gift_new_content);
            return;
        }
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = i != 0 ? i != 1 ? i != 2 ? str : getString(R.string.msg_gift_guide_new) : getString(R.string.msg_gift_guide_free) : getString(R.string.msg_gift_guide_hint);
        }
        final String str3 = str2;
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.36
            @Override // java.lang.Runnable
            public void run() {
                if (MsgChattingFragment.this.K == null || MsgChattingFragment.this.aB != null) {
                    return;
                }
                MsgChattingFragment.this.aB = new CenterGuidePop(MsgChattingFragment.this.getContext(), str3);
                MsgChattingFragment.this.aB.a(MsgChattingFragment.this.K, new SimpleCallback() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.36.1
                    public void c(BasePopupView basePopupView) {
                        EventTrackPersonalProfile.a(i == 1 ? PersonalProfileProtos.Event.GIFT_BUY_FREE_BUBBLE_SHOW : PersonalProfileProtos.Event.GIFT_BUY_NEW_BUBBLE_SHOW);
                        if (i == 1) {
                            BluedPreferences.o(System.currentTimeMillis());
                        } else if (i != 2 || MsgChattingFragment.this.h.l() == null) {
                        } else {
                            BluedPreferences.v(MsgChattingFragment.this.h.l().is_gift_new);
                        }
                    }

                    public void d(BasePopupView basePopupView) {
                        MsgChattingFragment.this.aB = null;
                    }
                });
            }
        }, 200L);
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void a(int i, String str, String str2) {
        if (StringUtils.d(str)) {
            TextView textView = this.r;
            textView.setText(this.h.f() + "");
        } else {
            String str3 = str;
            if (this.h.ap()) {
                str3 = DateTodayManager.f18714a.c(str);
            }
            this.r.setText(str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.r.setText(str2);
        }
        if (GroupUtil.a(i)) {
            this.s.setVisibility(0);
        } else {
            this.s.setVisibility(8);
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void a(int i, boolean z) {
        this.D.a(i);
        if (z) {
            this.D.notifyDataSetChanged();
            this.C.setSelection(this.D.getCount());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0385  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.os.Message r8) {
        /*
            Method dump skipped, instructions count: 1601
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.MsgChattingFragment.a(android.os.Message):void");
    }

    public void a(final View view) {
        if ("audio".equals((String) view.getTag())) {
            PermissionUtils.d(new PermissionCallbacks() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.64
                public void U_() {
                    view.setTag("keyboard");
                    ((ImageView) view).setImageDrawable(BluedSkinUtils.b(MsgChattingFragment.this.m, (int) R.drawable.btn_keyboard));
                    MsgChattingFragment.this.F.setVisibility(0);
                    if (MsgChattingFragment.this.aM.getVisibility() == 0) {
                        MsgChattingFragment.this.aM.setVisibility(8);
                        MsgChattingFragment.this.aP = true;
                    }
                    MsgChattingFragment.this.f18053c.setVisibility(8);
                    MsgChattingFragment.this.N.setVisibility(8);
                    MsgChattingFragment.this.aW.getKeyboardHelper().c();
                }

                public void a(String[] strArr) {
                }
            });
            return;
        }
        view.setTag("audio");
        ((ImageView) view).setImageDrawable(BluedSkinUtils.b(this.m, (int) R.drawable.btn_voice));
        this.f18053c.setVisibility(0);
        if (TextUtils.isEmpty(this.f18053c.getText().toString())) {
            this.N.setVisibility(8);
        } else {
            this.N.setVisibility(0);
        }
        this.F.setVisibility(8);
        this.f18053c.requestFocus();
        KeyboardUtils.c(getActivity());
    }

    public void a(View view, View view2, final Object obj) {
        Context context = this.m;
        CommonAlertDialog.a(context, (String) null, context.getResources().getString(R.string.biao_v4_is_resend), this.m.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.56
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                if (MsgChattingFragment.this.h != null) {
                    MsgChattingFragment.this.h.a(obj);
                }
            }
        }, this.m.getResources().getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0130  */
    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterOperationCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.chat.model.ChattingModel r7) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.MsgChattingFragment.a(com.blued.android.chat.model.ChattingModel):void");
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void a(SessionModel sessionModel) {
        GiftPlayer giftPlayer = this.i;
        if (giftPlayer != null) {
            giftPlayer.a(sessionModel);
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
        AppInfo.n().post(new AnonymousClass80(bluedIngSelfFeed));
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void a(FeedPostSignStateItem feedPostSignStateItem) {
        this.A.setBubbleState(feedPostSignStateItem);
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void a(UserInfoBasicModel userInfoBasicModel) {
        if (this.j != null) {
            Message obtain = Message.obtain();
            obtain.what = 302;
            obtain.obj = userInfoBasicModel;
            this.j.sendMessage(obtain);
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback
    public void a(IRecentPhotoAdapterCallback.IGetPhotoListCallback iGetPhotoListCallback) {
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null) {
            msgChattingPresent.a(iGetPhotoListCallback);
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void a(FuGiftListEvent fuGiftListEvent) {
        onChanged(fuGiftListEvent);
    }

    @Override // com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback
    public void a(MsgRecentPhotoInfo msgRecentPhotoInfo) {
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null) {
            msgChattingPresent.b(msgRecentPhotoInfo);
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void a(GiftGivingOptionForJsonParse giftGivingOptionForJsonParse) {
        GiftPlayer giftPlayer = this.i;
        if (giftPlayer != null) {
            giftPlayer.a(giftGivingOptionForJsonParse);
        }
    }

    public void a(String str) {
        this.aK.setVisibility(0);
        this.aK.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.59
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.aL.setText(str);
    }

    public void a(String str, final Runnable runnable) {
        SVGAImageView sVGAImageView = this.bu;
        if (sVGAImageView != null) {
            sVGAImageView.setVisibility(0);
            new SVGAPlayer.Builder().a(str).a(1).a(this.bu);
            this.bu.setCallback(new SVGACallback() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.84
                public void onFinished() {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    } else {
                        MsgChattingFragment.this.bu.setVisibility(8);
                    }
                }

                public void onPause() {
                }

                public void onRepeat() {
                }

                public void onStep(int i, double d) {
                }
            });
        }
    }

    public void a(String str, String str2) {
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.uid = str;
        userBasicModel.name = str2;
        this.al.a(this.f18053c, userBasicModel, this.bx, true);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.38
            @Override // java.lang.Runnable
            public void run() {
                if (MsgChattingFragment.this.getFragmentActive().isActive()) {
                    KeyboardUtils.c(MsgChattingFragment.this.getActivity());
                }
            }
        }, 500L);
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void a(List<ServiceMenuModel> list) {
        if (list == null) {
            return;
        }
        MessageProtos.Event event = MessageProtos.Event.SERVICE_MSG_PAGE_SHOW;
        EventTrackMessage.a(event, this.h.f() + "", list.size() > 0);
        if (list.size() == 0) {
            this.aZ.setVisibility(8);
            this.bg.setVisibility(8);
            this.bb.setVisibility(0);
            this.f18053c.setVisibility(0);
            return;
        }
        this.N.setVisibility(8);
        this.bg.removeAllViews();
        int i = 0;
        while (true) {
            final int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            View inflate = LayoutInflater.from(this.m).inflate(R.layout.item_chat_service_menu, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_service_menu_name);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_service_menu_item);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0f);
            layoutParams.gravity = 17;
            linearLayout.setLayoutParams(layoutParams);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_divider);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_menu_more);
            final ServiceMenuModel serviceMenuModel = list.get(i2);
            textView.setText(serviceMenuModel.name);
            if (serviceMenuModel.levelTwo == null || serviceMenuModel.levelTwo.size() <= 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
            }
            if (i2 == list.size() - 1) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
            }
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.26
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (serviceMenuModel.levelTwo != null && serviceMenuModel.levelTwo.size() > 0) {
                        MsgChattingFragment.this.a(serviceMenuModel.levelTwo, view, i2);
                    } else if (serviceMenuModel.type == 1) {
                        WebViewShowInfoFragment.show(MsgChattingFragment.this.m, serviceMenuModel.value.url, -1);
                    } else {
                        ChatHttpUtils.a((BluedUIHttpResponse) null, MsgChattingFragment.this.h.f() + "", 1, i2, 0, serviceMenuModel.name, (ChattingModel) null);
                    }
                    MessageProtos.Event event2 = MessageProtos.Event.SERVICE_MSG_PAGE_FIRST_CLICK;
                    EventTrackMessage.e(event2, MsgChattingFragment.this.h.f() + "", serviceMenuModel.name);
                }
            });
            this.bg.addView(inflate);
            i = i2 + 1;
        }
    }

    @Override // com.soft.blued.ui.common_contract.ISelectPhotoBarCallback
    public void a(boolean z) {
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null) {
            msgChattingPresent.a(z);
        }
    }

    @Override // com.soft.blued.ui.common_contract.ISelectPhotoBarCallback
    public void b() {
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null) {
            msgChattingPresent.n();
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void b(final int i) {
        this.C.post(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.63
            @Override // java.lang.Runnable
            public void run() {
                MsgChattingFragment.this.C.smoothScrollToPosition(i);
            }
        });
    }

    @Override // com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback
    public void b(IRecentPhotoAdapterCallback.IGetPhotoListCallback iGetPhotoListCallback) {
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null) {
            msgChattingPresent.b(iGetPhotoListCallback);
        }
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: b */
    public void onChanged(FuGiftListEvent fuGiftListEvent) {
        if (fuGiftListEvent.f18634a == null) {
            return;
        }
        d(fuGiftListEvent.f18634a);
    }

    @Override // com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback
    public void b(MsgRecentPhotoInfo msgRecentPhotoInfo) {
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null) {
            msgChattingPresent.a(msgRecentPhotoInfo);
        }
    }

    public void b(String str) {
        a(str, (short) 6);
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void b(final List<ChattingModel> list) {
        if (this.j != null) {
            Message obtain = Message.obtain();
            obtain.what = 305;
            LocalMsg localMsg = new LocalMsg();
            localMsg.f18156a = list;
            obtain.obj = localMsg;
            this.j.sendMessage(obtain);
            postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.31
                @Override // java.lang.Runnable
                public void run() {
                    List list2 = list;
                    if (list2 == null || list2.isEmpty()) {
                        return;
                    }
                    MsgChattingFragment.this.c((ChattingModel) list.get(0));
                    List list3 = list;
                    ChattingModel chattingModel = (ChattingModel) list3.get(list3.size() - 1);
                    if (chattingModel.msgType == -1 || !chattingModel.isFromSelf() || System.currentTimeMillis() - chattingModel.msgTimestamp >= 500) {
                        return;
                    }
                    PushChecker.a().a(MsgChattingFragment.this.getContext(), 1, MessageProtos.WarnTime.CHAT_FIRST);
                }
            });
        }
        if (this.h.M() == null) {
            postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.32
                @Override // java.lang.Runnable
                public void run() {
                    MsgChattingFragment.this.h.ad();
                }
            });
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void b(final boolean z) {
        if (this.av != null) {
            postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.79
                @Override // java.lang.Runnable
                public void run() {
                    MsgChattingFragment.this.av.setBurnChecked(z);
                }
            });
        }
    }

    @Override // com.soft.blued.ui.common_contract.ISelectPhotoBarCallback
    public void c() {
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null) {
            msgChattingPresent.a((BaseFragment) this);
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void c(int i) {
        PayVIPPopupWindow.c.a(this.m, i, (DialogInterface.OnDismissListener) null);
    }

    public void c(String str) {
        CustomDialog customDialog = this.E;
        if (customDialog == null || !customDialog.isShowing()) {
            View inflate = LayoutInflater.from(this.m).inflate(2131560351, (ViewGroup) null);
            inflate.findViewById(2131372754).setVisibility(8);
            TextView textView = (TextView) inflate.findViewById(2131371051);
            textView.setText(getString(2131886718));
            textView.setVisibility(8);
            inflate.findViewById(2131371289).setVisibility(8);
            ((TextView) inflate.findViewById(2131371259)).setText(str);
            TextView textView2 = (TextView) inflate.findViewById(2131372161);
            textView2.setText(getString(R.string.live_window_indicate_know));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.68
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    BluedPreferences.az();
                    MsgChattingFragment.this.ac();
                    MsgChattingFragment.this.E.dismiss();
                }
            });
            CustomDialog customDialog2 = new CustomDialog(this.m, 2131952378);
            this.E = customDialog2;
            customDialog2.a(inflate, (CustomDialog.OnBackCallBack) null);
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void c(List<HelloExpressionData> list) {
        View view = this.aG;
        if (view != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(2131369096);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            HelloExpressionAdapter helloExpressionAdapter = new HelloExpressionAdapter(getFragmentActive());
            recyclerView.setAdapter(helloExpressionAdapter);
            helloExpressionAdapter.setNewData(list);
            helloExpressionAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.37
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
                public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                    HelloExpressionData helloExpressionData = (HelloExpressionData) baseQuickAdapter.getData().get(i);
                    MsgChattingFragment.this.h.a(helloExpressionData);
                    MsgChattingFragment.this.Q();
                    MessageProtos.Event event = MessageProtos.Event.MSG_SAY_HI_ONE_CLICK;
                    String str = helloExpressionData.id;
                    EventTrackMessage.b(event, str, MsgChattingFragment.this.h.f() + "");
                }
            });
            ((ImageView) this.aG.findViewById(R.id.iv_arrow)).setVisibility(4);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.load(getContext(), R.xml.chat_hello_expression_show);
            if (this.h.S() == null || this.h.S().fold_say_hi != 1) {
                constraintSet.applyTo(this.aW);
                a(new boolean[0]);
            } else {
                TransitionSet transitionSet = new TransitionSet();
                transitionSet.setOrdering(0);
                transitionSet.addTransition(new ChangeBounds());
                transitionSet.setInterpolator((TimeInterpolator) new LinearInterpolator());
                transitionSet.setDuration(150L);
                TransitionManager.beginDelayedTransition(this.aW, transitionSet);
                constraintSet.applyTo(this.aW);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).id);
                if (i != list.size() - 1) {
                    sb.append(",");
                }
            }
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void d() {
        Logger.c(k, "updateInfo==========");
        try {
            if (this.h.c()) {
                aa();
            } else {
                this.h.q();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void d(int i) {
        String str = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "date_today_ok.svga" : "date_today_hug.svga" : "date_today_heart.svga" : "date_today_hi.svga";
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, (Runnable) null);
    }

    public void e() {
        this.aW.getKeyboardHelper().c();
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void e(int i) {
        if (i == -1) {
            am();
        } else if (i == 2) {
            ImageView imageView = this.bq;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.icon_date_today_heart_left_like_small);
            }
        } else if (i != 3) {
            if (i != 4) {
                return;
            }
            aj();
        } else {
            ImageView imageView2 = this.br;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.icon_date_today_heart_right_like_small);
            }
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void f() {
        postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.29
            /* JADX WARN: Code restructure failed: missing block: B:13:0x0067, code lost:
                if (com.soft.blued.ui.msg.manager.ChatBgManager.b(r6.f18079a.h.J()) != false) goto L5;
             */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x00dd  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r6 = this;
                    r0 = r6
                    com.soft.blued.ui.msg.MsgChattingFragment r0 = com.soft.blued.ui.msg.MsgChattingFragment.this
                    android.widget.ImageView r0 = com.soft.blued.ui.msg.MsgChattingFragment.p(r0)
                    if (r0 == 0) goto Le9
                    com.blued.android.module.common.user.model.UserInfo r0 = com.blued.android.module.common.user.model.UserInfo.getInstance()
                    com.blued.android.module.common.user.model.BluedLoginResult r0 = r0.getLoginUserInfo()
                    int r0 = r0.vip_grade
                    r7 = r0
                    r0 = 1
                    r8 = r0
                    r0 = r7
                    if (r0 != 0) goto L1f
                L1a:
                    r0 = 0
                    r7 = r0
                    goto L6f
                L1f:
                    r0 = r6
                    com.soft.blued.ui.msg.MsgChattingFragment r0 = com.soft.blued.ui.msg.MsgChattingFragment.this
                    com.soft.blued.ui.msg.presenter.MsgChattingPresent r0 = r0.h
                    java.lang.String r0 = r0.J()
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    if (r0 == 0) goto L5a
                    com.blued.android.module.common.user.model.UserInfo r0 = com.blued.android.module.common.user.model.UserInfo.getInstance()
                    com.blued.android.module.common.user.model.BluedLoginResult r0 = r0.getLoginUserInfo()
                    java.lang.String r0 = r0.getUid()
                    java.lang.String r0 = com.soft.blued.utils.BluedPreferences.z(r0)
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    if (r0 != 0) goto L1a
                    r0 = r6
                    com.soft.blued.ui.msg.MsgChattingFragment r0 = com.soft.blued.ui.msg.MsgChattingFragment.this
                    com.soft.blued.ui.msg.presenter.MsgChattingPresent r0 = r0.h
                    com.blued.android.module.common.user.model.UserInfo r1 = com.blued.android.module.common.user.model.UserInfo.getInstance()
                    com.blued.android.module.common.user.model.BluedLoginResult r1 = r1.getLoginUserInfo()
                    java.lang.String r1 = r1.getUid()
                    java.lang.String r1 = com.soft.blued.utils.BluedPreferences.z(r1)
                    r0.b(r1)
                    goto L6d
                L5a:
                    r0 = r6
                    com.soft.blued.ui.msg.MsgChattingFragment r0 = com.soft.blued.ui.msg.MsgChattingFragment.this
                    com.soft.blued.ui.msg.presenter.MsgChattingPresent r0 = r0.h
                    java.lang.String r0 = r0.J()
                    boolean r0 = com.soft.blued.ui.msg.manager.ChatBgManager.b(r0)
                    if (r0 == 0) goto L6d
                    goto L1a
                L6d:
                    r0 = 1
                    r7 = r0
                L6f:
                    r0 = r7
                    if (r0 == 0) goto Ldd
                    r0 = r6
                    com.soft.blued.ui.msg.MsgChattingFragment r0 = com.soft.blued.ui.msg.MsgChattingFragment.this
                    java.lang.String r0 = com.soft.blued.ui.msg.MsgChattingFragment.F(r0)
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    if (r0 == 0) goto L85
                    r0 = r8
                    r7 = r0
                    goto La3
                L85:
                    r0 = r6
                    com.soft.blued.ui.msg.MsgChattingFragment r0 = com.soft.blued.ui.msg.MsgChattingFragment.this
                    com.soft.blued.ui.msg.presenter.MsgChattingPresent r0 = r0.h
                    java.lang.String r0 = r0.J()
                    r1 = r6
                    com.soft.blued.ui.msg.MsgChattingFragment r1 = com.soft.blued.ui.msg.MsgChattingFragment.this
                    java.lang.String r1 = com.soft.blued.ui.msg.MsgChattingFragment.F(r1)
                    boolean r0 = r0.equals(r1)
                    if (r0 != 0) goto La1
                    r0 = r8
                    r7 = r0
                    goto La3
                La1:
                    r0 = 0
                    r7 = r0
                La3:
                    r0 = r7
                    if (r0 == 0) goto Le9
                    r0 = r6
                    com.soft.blued.ui.msg.MsgChattingFragment r0 = com.soft.blued.ui.msg.MsgChattingFragment.this
                    com.blued.android.core.ui.ActivityFragmentActive r0 = r0.getFragmentActive()
                    r1 = r6
                    com.soft.blued.ui.msg.MsgChattingFragment r1 = com.soft.blued.ui.msg.MsgChattingFragment.this
                    com.soft.blued.ui.msg.presenter.MsgChattingPresent r1 = r1.h
                    java.lang.String r1 = r1.J()
                    com.blued.android.core.image.ImageWrapper r0 = com.blued.android.core.image.ImageLoader.a(r0, r1)
                    r1 = 2131101292(0x7f06066c, float:1.781499E38)
                    com.blued.android.core.image.ImageWrapper r0 = r0.b(r1)
                    com.soft.blued.ui.msg.MsgChattingFragment$29$1 r1 = new com.soft.blued.ui.msg.MsgChattingFragment$29$1
                    r2 = r1
                    r3 = r6
                    r4 = r6
                    com.soft.blued.ui.msg.MsgChattingFragment r4 = com.soft.blued.ui.msg.MsgChattingFragment.this
                    com.blued.android.core.ui.ActivityFragmentActive r4 = r4.getFragmentActive()
                    r2.<init>(r4)
                    com.blued.android.core.image.ImageWrapper r0 = r0.a(r1)
                    r1 = r6
                    com.soft.blued.ui.msg.MsgChattingFragment r1 = com.soft.blued.ui.msg.MsgChattingFragment.this
                    android.widget.ImageView r1 = com.soft.blued.ui.msg.MsgChattingFragment.p(r1)
                    r0.a(r1)
                    return
                Ldd:
                    r0 = r6
                    com.soft.blued.ui.msg.MsgChattingFragment r0 = com.soft.blued.ui.msg.MsgChattingFragment.this
                    android.widget.ImageView r0 = com.soft.blued.ui.msg.MsgChattingFragment.p(r0)
                    r1 = 8
                    r0.setVisibility(r1)
                Le9:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.MsgChattingFragment.AnonymousClass29.run():void");
            }
        });
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void g() {
        RecentPhotoView recentPhotoView = this.av;
        if (recentPhotoView != null) {
            recentPhotoView.a(true);
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterOperationCallback, com.soft.blued.ui.msg.contract.IMsgChattingView
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    public String getPageBizName() {
        MsgChattingPresent msgChattingPresent = this.h;
        return msgChattingPresent != null ? msgChattingPresent.ab() : "私聊页";
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void h() {
        BluedAlertDialog bluedAlertDialog = this.ay;
        if (bluedAlertDialog == null || !bluedAlertDialog.isShowing()) {
            this.ay = CommonAlertDialog.a(getContext(), 0, "", getResources().getString(R.string.msg_user_locked_hint), (View) null, getContext().getString(2131886752), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.33
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    if (MsgChattingFragment.this.h != null) {
                        MsgChattingFragment.this.h.ah();
                    }
                }
            }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, false, 1, 0, false, false);
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void i() {
        MessageChatAdapter messageChatAdapter;
        int count;
        ChattingModel chattingModel;
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent == null || msgChattingPresent.S() == null || this.h.S().is_un_disturb != 1) {
            return;
        }
        if ((this.h.M() == null || this.h.M().hasReply != 1) && (messageChatAdapter = this.D) != null && (count = messageChatAdapter.getCount()) > 0 && (chattingModel = (ChattingModel) this.D.getItem(0)) != null && count <= 2) {
            if (count == 1 && chattingModel.msgType == -2) {
                return;
            }
            if (count != 2 || chattingModel.msgType == -2) {
                if (count != 1 || chattingModel.isFromSelf()) {
                    this.aA.c();
                    this.aA.setEnabled(false);
                }
            }
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void j() {
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.34
            @Override // java.lang.Runnable
            public void run() {
                if (MsgChattingFragment.this.aU.a() || MsgChattingFragment.this.au || MsgChattingFragment.this.h == null) {
                    return;
                }
                MsgChattingFragment.this.au = true;
                if (MsgChattingFragment.this.D.f18271a == null || MsgChattingFragment.this.D.f18271a.size() == 0) {
                    if (!MsgChattingFragment.this.h.c()) {
                        MsgChattingFragment.this.c((ChattingModel) null);
                        return;
                    }
                    MsgChattingFragment.this.ag();
                    if (MsgChattingFragment.this.at != null) {
                        MsgChattingFragment.this.at.setVisibility(0);
                        MsgChattingFragment.this.at.postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.34.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MsgChattingFragment.this.R();
                            }
                        }, 8000L);
                    }
                }
            }
        }, 200L);
    }

    public void k() {
        if (this.D.getCount() == 0 || this.D.getCount() > 2) {
            return;
        }
        this.h.ai();
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public void l() {
        MessageChatAdapter messageChatAdapter = this.D;
        if (messageChatAdapter != null) {
            messageChatAdapter.notifyDataSetChanged();
        }
    }

    public void m() {
        this.I.setTag("audio");
        this.I.setImageDrawable(BluedSkinUtils.b(this.m, (int) R.drawable.btn_voice));
        this.f18053c.setVisibility(0);
        this.f18053c.requestFocus();
        this.J.setVisibility(0);
        if (TextUtils.isEmpty(this.f18053c.getText().toString())) {
            this.N.setVisibility(8);
        } else {
            this.N.setVisibility(0);
        }
        this.F.setVisibility(8);
        if (this.h.D()) {
            e(false);
        } else {
            d(false);
        }
        a(new boolean[0]);
    }

    public void n() {
        RecentPhotoView recentPhotoView = this.av;
        if (recentPhotoView != null) {
            recentPhotoView.b();
        }
    }

    public void o() {
        a("", (short) 1);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null) {
            msgChattingPresent.a(i, i2, intent);
        }
    }

    public boolean onBackPressed() {
        if (GiftVoucherHelpPop.b != null) {
            GiftVoucherHelpPop.b.p();
            return true;
        } else if (GiftVoucherPop.b != null) {
            GiftVoucherPop.b.p();
            return true;
        } else {
            BluedPreferences.az();
            this.h.v();
            if (this.h.ap()) {
                LiveEventBus.get(DateTodayManager.f18714a.t()).post(null);
            }
            return super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        switch (id) {
            case R.id.bt_audio_or_keyboard /* 2131362501 */:
                a(view);
                return;
            case R.id.bt_gift /* 2131362506 */:
                e();
                if (!TextUtils.isEmpty(BluedConfig.a().A()) && !BluedPreferences.a().b(BluedConfig.a().A())) {
                    BluedPreferences.a().c().a(BluedConfig.a().A(), true).b();
                    this.L.setVisibility(8);
                }
                Context context = getContext();
                ActivityFragmentActive fragmentActive = getFragmentActive();
                UserGiftDialogFragment.a(context, fragmentActive, this.h.f() + "", TextUtils.isEmpty(this.h.g) ? "chat_page_gift" : this.h.g, new UserGiftDialogFragment.BuySucceedListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.74
                    @Override // com.soft.blued.ui.msg.pop.UserGiftDialogFragment.BuySucceedListener
                    public void a(UserGiftDialogFragment userGiftDialogFragment, GiftGivingOptionForJsonParse giftGivingOptionForJsonParse) {
                        userGiftDialogFragment.dismissAllowingStateLoss();
                        if (MsgChattingFragment.this.h != null) {
                            MsgChattingFragment.this.h.a(giftGivingOptionForJsonParse);
                        }
                    }
                }, this.h.S().relationship, this.h.S() != null ? this.h.S().name : "", new int[0]);
                return;
            case R.id.cl_name /* 2131362922 */:
            case 2131363108:
                MsgChattingPresent msgChattingPresent = this.h;
                if (msgChattingPresent != null) {
                    msgChattingPresent.t();
                    return;
                }
                return;
            case 2131363120:
                MsgChattingPresent msgChattingPresent2 = this.h;
                if (msgChattingPresent2 != null) {
                    msgChattingPresent2.v();
                    return;
                }
                return;
            case 2131363126:
                MsgChattingPresent msgChattingPresent3 = this.h;
                if (msgChattingPresent3 != null) {
                    msgChattingPresent3.u();
                }
                if (BluedPreferences.bV()) {
                    return;
                }
                this.aE.setVisibility(8);
                BluedPreferences.bW();
                return;
            case R.id.iv_quote_close /* 2131365774 */:
                this.aM.setVisibility(8);
                return;
            case R.id.ll_group_floating_msg /* 2131367846 */:
                this.C.setSelection(this.D.f18271a.size() - 1);
                this.X.setVisibility(8);
                MsgChattingPresent msgChattingPresent4 = this.h;
                if (msgChattingPresent4 != null) {
                    msgChattingPresent4.f(true);
                    return;
                }
                return;
            case R.id.ll_pop_no_read_msg /* 2131368134 */:
                MsgChattingPresent msgChattingPresent5 = this.h;
                if (msgChattingPresent5 != null) {
                    msgChattingPresent5.e(true);
                }
                MsgChattingPresent msgChattingPresent6 = this.h;
                if (msgChattingPresent6 != null) {
                    msgChattingPresent6.x();
                    this.h.a(this.j, this.D.getCount());
                    return;
                }
                return;
            case R.id.msg_send /* 2131368581 */:
                o();
                return;
            case R.id.tv_cover_bindcellphone_transparent /* 2131371208 */:
                PopMenuUtils.a(this.m);
                return;
            case R.id.tv_cover_transparent /* 2131371210 */:
                AppMethods.d((int) R.string.group_msg_failed_locked);
                return;
            default:
                switch (id) {
                    case R.id.ll_function_camera /* 2131367819 */:
                        s();
                        return;
                    case R.id.ll_function_gift /* 2131367820 */:
                        MessageProtos.Event event = MessageProtos.Event.MSG_GIFT_ICON_CLICK;
                        EventTrackMessage.e(event, this.h.f() + "");
                        KeyboardUtils.a(getActivity());
                        if (!TextUtils.isEmpty(BluedConfig.a().A()) && !BluedPreferences.a().b(BluedConfig.a().A())) {
                            BluedPreferences.a().c().a(BluedConfig.a().A(), true).b();
                            this.bl.setVisibility(8);
                        }
                        Context context2 = getContext();
                        ActivityFragmentActive fragmentActive2 = getFragmentActive();
                        UserGiftDialogFragment.a(context2, fragmentActive2, this.h.f() + "", TextUtils.isEmpty(this.h.g) ? "chat_page_gift" : this.h.g, new UserGiftDialogFragment.BuySucceedListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.75
                            @Override // com.soft.blued.ui.msg.pop.UserGiftDialogFragment.BuySucceedListener
                            public void a(UserGiftDialogFragment userGiftDialogFragment, GiftGivingOptionForJsonParse giftGivingOptionForJsonParse) {
                                userGiftDialogFragment.dismissAllowingStateLoss();
                                if (MsgChattingFragment.this.h != null) {
                                    MsgChattingFragment.this.h.a(giftGivingOptionForJsonParse);
                                }
                            }
                        }, this.h.S() == null ? "0" : this.h.S().relationship, this.h.S() != null ? this.h.S().name : "", new int[0]);
                        return;
                    case R.id.ll_function_group_video_root /* 2131367821 */:
                        if (this.h.S() != null) {
                            MessageProtos.Event event2 = MessageProtos.Event.CHAT_VIDEO_CLICK;
                            MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
                            EventTrackMessage.a(event2, strangerSource, this.h.S().uid + "");
                        }
                        InstantLog.a("chat_video_click", (Object) 1);
                        r();
                        return;
                    case R.id.ll_function_image /* 2131367822 */:
                        MsgChattingPresent msgChattingPresent7 = this.h;
                        if (msgChattingPresent7 != null) {
                            msgChattingPresent7.a((BaseFragment) this);
                            return;
                        }
                        return;
                    case R.id.ll_function_location /* 2131367823 */:
                        p();
                        return;
                    case R.id.ll_function_photo /* 2131367824 */:
                        if (this.h.c() && BluedConfig.a().i()) {
                            return;
                        }
                        q();
                        return;
                    case R.id.ll_function_video_chat /* 2131367825 */:
                        d(false);
                        if (BluedPreferences.ay()) {
                            c(this.m.getResources().getString(R.string.channel_invitation_first_time));
                            return;
                        } else {
                            ac();
                            return;
                        }
                    case R.id.ll_function_video_root /* 2131367826 */:
                        if (this.h.S() != null) {
                            MessageProtos.Event event3 = MessageProtos.Event.CHAT_VIDEO_CLICK;
                            MessageProtos.StrangerSource strangerSource2 = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
                            EventTrackMessage.a(event3, strangerSource2, this.h.S().uid + "");
                        }
                        InstantLog.a("chat_video_click", (Object) 0);
                        r();
                        return;
                    default:
                        return;
                }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.m = getActivity();
        getActivity().getWindow().setSoftInputMode(51);
        this.h = new MsgChattingPresent(bundle, this);
        this.aT = (MsgListViewModel) new ViewModelProvider(this).get(MsgListViewModel.class);
        View view = this.l;
        if (view == null) {
            this.l = layoutInflater.inflate(R.layout.fragment_msg_chating_new, viewGroup, false);
            if (!this.h.Z()) {
                getActivity().finish();
                return null;
            }
            S();
            T();
            ai();
            a(this.g, (View) this.G, (View) this.av);
            P();
            Y();
            if (this.h.aa()) {
                this.B.l(false);
            } else {
                this.aC = true;
            }
            this.h.b(this.j);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.l.getParent()).removeView(this.l);
        }
        return this.l;
    }

    public void onDestroy() {
        EmotionManager.b(this);
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null) {
            msgChattingPresent.ag();
        }
        Handler handler = this.j;
        if (handler != null) {
            ((MsgHandler) handler).a();
        }
        super.onDestroy();
    }

    public void onMsgRetractedTimeout() {
        Context context = this.m;
        CommonAlertDialog.a(context, (View) null, (String) null, context.getResources().getString(R.string.send_out_time), this.m.getResources().getString(2131892209), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.77
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
            }
        }, (DialogInterface.OnCancelListener) null, true);
    }

    public void onPause() {
        super.onPause();
        O();
        ChatConstants.f14623a = 0L;
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null) {
            msgChattingPresent.af();
        }
        LiveEventBus.get(EventBusConstant.KEY_EVENT_BUY_FU, FuGiftListEvent.class).removeObserver(this);
    }

    public void onResume() {
        super.onResume();
        if (this.i != null && this.h.M() != null) {
            UserPagerGiftManager.a().a(this.i);
            this.i.a(this.h.M());
        }
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null) {
            msgChattingPresent.ae();
        }
        if (this.e != null) {
            if (PopMenuUtils.a()) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
        }
        LiveEventBus.get(EventBusConstant.KEY_EVENT_BUY_FU, FuGiftListEvent.class).observeForever(this);
    }

    public void onRetractFailed() {
        Context context = this.m;
        CommonAlertDialog.a(context, (View) null, (String) null, context.getResources().getString(R.string.retraction_failed), this.m.getResources().getString(2131892209), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.76
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
            }
        }, (DialogInterface.OnCancelListener) null, true);
    }

    public void onRetractSuccess() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null) {
            msgChattingPresent.a(bundle);
        }
    }

    public void onStop() {
        super.onStop();
        UserPagerGiftManager.a().b(this.i);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            if (StatusBarHelper.a(getActivity())) {
                getActivity().findViewById(android.R.id.content).setFitsSystemWindows(true);
                getActivity().getWindow().setBackgroundDrawable(StatusBarHelper.a(getActivity(), AppInfo.k(), AppInfo.l(), AppInfo.j(), true));
                if (SkinCompatManager.a() != null) {
                    getActivity().findViewById(android.R.id.content).setBackgroundColor(BluedSkinUtils.a(getActivity(), 2131101796));
                }
            }
            if (this.h != null && !TextUtils.isEmpty(this.h.H())) {
                this.ax = true;
                CharSequence a2 = StringUtils.a(this.h.H(), (int) this.f18053c.getTextSize(), 1);
                this.f18053c.setText(a2);
                this.f18053c.setSelection(a2.toString().length());
                String a3 = BluedPreferences.a((int) this.h.E(), this.h.e());
                if (!TextUtils.isEmpty(a3)) {
                    this.aM.setVisibility(0);
                    this.aO.setText(a3.substring(0, a3.lastIndexOf("*")));
                    long parseLong = Long.parseLong(a3.substring(a3.lastIndexOf("*") + 1));
                    String str = k;
                    Logger.c(str, "init quote msgId: " + parseLong);
                    if (parseLong != 0) {
                        this.aM.setTag(Long.valueOf(parseLong));
                    }
                }
                this.ax = false;
            }
        } catch (Throwable th) {
        }
        this.ax = false;
        this.aU.b();
        this.aY.b();
        this.aY.setCloseClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                BluedPreferences.z(System.currentTimeMillis() + 604800000);
            }
        });
        this.C.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    MsgChattingFragment.this.e();
                    return false;
                }
                return false;
            }
        });
        if (!this.h.c()) {
            MsgListViewModel msgListViewModel = this.aT;
            msgListViewModel.a(this.h.f() + "");
        }
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null) {
            msgChattingPresent.ao();
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    MsgChattingFragment.this.h.ar();
                }
            }, 500L);
        }
    }

    public void p() {
        PermissionUtils.c(new PermissionCallbacks() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.66
            public void U_() {
                try {
                    MsgChattingFragment.this.startActivityForResult(new Intent(MsgChattingFragment.this.m, SendPositionActivity.class), 604);
                } catch (Exception e) {
                }
            }

            public void a(String[] strArr) {
            }
        });
    }

    public void q() {
        n();
        if (this.h.S() == null || this.h.S().has_screenshot != 1) {
            return;
        }
        ae();
    }

    public void r() {
        if (AudioChannelManager.j().n()) {
            AppMethods.a(getActivity().getResources().getText(R.string.yy_in_use));
            return;
        }
        ShortVideoProxy e = ShortVideoProxy.e();
        int i = this.h.C() ? 7 : 1;
        e.a(this, i, 23, this.m.getString(R.string.msg_look_burn) + FlashPhotoManager.a().b().flash_prompt, FlashPhotoManager.a().b().flash_left_times, new AnonymousClass67());
    }

    public void s() {
        MsgChattingPresent msgChattingPresent = this.h;
        if (msgChattingPresent != null) {
            msgChattingPresent.s();
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterOperationCallback
    public void t() {
        Handler handler;
        if (getActivity() == null || getActivity().isFinishing() || (handler = this.j) == null) {
            return;
        }
        handler.sendEmptyMessage(306);
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterOperationCallback
    public void u() {
        if (this.m == null) {
            return;
        }
        if (!BluedPreferences.aV()) {
            this.Z.setVisibility(8);
            return;
        }
        this.Z.setVisibility(0);
        Animation loadAnimation = android.view.animation.AnimationUtils.loadAnimation(this.m, 2130772122);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.78
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.MsgChattingFragment.78.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MsgChattingFragment.this.Z.getVisibility() == 0) {
                            Animation loadAnimation2 = android.view.animation.AnimationUtils.loadAnimation(MsgChattingFragment.this.m, 2130772123);
                            loadAnimation2.setFillAfter(true);
                            MsgChattingFragment.this.Z.startAnimation(loadAnimation2);
                        }
                    }
                }, 2000L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.Z.startAnimation(loadAnimation);
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterOperationCallback, com.soft.blued.ui.msg.contract.IMsgChattingView
    public BaseFragment v() {
        return this;
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterOperationCallback
    public EditText w() {
        return this.f18053c;
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterOperationCallback
    public void x() {
        if (!this.f) {
            KeyboardUtils.c(getActivity());
        }
        m();
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterOperationCallback
    public void y() {
        this.K.performClick();
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChattingView
    public MessageChatAdapter z() {
        return this.D;
    }
}
