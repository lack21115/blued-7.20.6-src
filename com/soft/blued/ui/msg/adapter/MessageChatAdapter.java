package com.soft.blued.ui.msg.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.data.MsgType;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.VideoChatMsgContentModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.db.model.MsgExtra;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.share.model.ShareEventToMsgEntity;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.ImageUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.YyChatRoomTagShapeUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.android.module.common.view.LinePageIndicator;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.emoticon.manager.EmotionLoadListener;
import com.blued.android.module.common.widget.emoticon.manager.EmotionManager;
import com.blued.android.module.common.widget.emoticon.model.EmoticonModel;
import com.blued.android.module.common.widget.emoticon.ui.Emotion;
import com.blued.android.module.common.widget.menu.BottomMenuPop;
import com.blued.android.module.common.widget.pop.BluedPopupWindow;
import com.blued.android.module.live_china.liveForMsg.model.LiveMsgShareEntity;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.event.fragment.EventDetailsFragment;
import com.blued.community.ui.event.fragment.EventUserInfoDlgFragment;
import com.blued.community.ui.event.model.EventLogData;
import com.blued.community.ui.feed.fragment.FeedDetailsFragment;
import com.blued.community.ui.feed.fragment.SignFeedListFragment;
import com.blued.community.ui.feed.model.FeedDetailParams;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.blued.das.guy.GuyProtos;
import com.blued.das.message.MessageProtos;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.google.android.material.timepicker.TimeModel;
import com.google.gson.reflect.TypeToken;
import com.igexin.push.core.b;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.XRoundedImageView;
import com.soft.blued.customview.selectabletextview.SelectFrameLayout;
import com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener;
import com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener2;
import com.soft.blued.customview.selectabletextview.SelectableOnChangeListener;
import com.soft.blued.customview.selectabletextview.SelectableOnShowListener;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.bytedance.MessageEventUtils;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.model.UserInfoBasicModel;
import com.soft.blued.ui.feed.fragment.ShowPhotoDestroyFragment;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.msg.DialogSkipFragment;
import com.soft.blued.ui.msg.MsgChattingFragment;
import com.soft.blued.ui.msg.ShowPositionActivity;
import com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback;
import com.soft.blued.ui.msg.contract.IMsgChatAdapterOperationCallback;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.controller.tools.IMV4Constant;
import com.soft.blued.ui.msg.controller.tools.IMV4Method;
import com.soft.blued.ui.msg.controller.tools.MediaRecordHelper;
import com.soft.blued.ui.msg.controller.tools.MediaUtils;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.msg.event.KeepScreenEvent;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.ui.msg.manager.MessageChatMethod;
import com.soft.blued.ui.msg.manager.SubscribeNumberManager;
import com.soft.blued.ui.msg.manager.UserPagerGiftManager;
import com.soft.blued.ui.msg.model.ChannelModel;
import com.soft.blued.ui.msg.model.CommonNoticeExtra;
import com.soft.blued.ui.msg.model.DateTodayConfigModel;
import com.soft.blued.ui.msg.model.DateTodayInterestPlayedModel;
import com.soft.blued.ui.msg.model.DateTodayMatchModel;
import com.soft.blued.ui.msg.model.DateTodayMatchUserModel;
import com.soft.blued.ui.msg.model.DateTodaySayHelloModel;
import com.soft.blued.ui.msg.model.FriendsNotificationExtra;
import com.soft.blued.ui.msg.model.FromFeedModel;
import com.soft.blued.ui.msg.model.MsgAudioExtra;
import com.soft.blued.ui.msg.model.MsgChattingImageModel;
import com.soft.blued.ui.msg.model.MsgChattingVideoModel;
import com.soft.blued.ui.msg.model.MsgContentTranslatedEntity;
import com.soft.blued.ui.msg.model.MsgExtraForTextTypeEntity;
import com.soft.blued.ui.msg.model.MsgExtraGift;
import com.soft.blued.ui.msg.model.MsgExtraLike;
import com.soft.blued.ui.msg.model.MsgImageAndTextModel;
import com.soft.blued.ui.msg.model.MsgPrivateImgApplyExtra;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg.model.RelationshipStatus;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.ui.msg.model.SystemNoticeExtra;
import com.soft.blued.ui.msg.pop.DateTodayUserEvaluationPop;
import com.soft.blued.ui.msg.pop.MsgItemMenuPop;
import com.soft.blued.ui.msg.util.ChatUtils;
import com.soft.blued.ui.msg.view.MultiPicLayout;
import com.soft.blued.ui.msg.view.SafeTabLayout;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.fragment.VipBubbleFragment;
import com.soft.blued.ui.user.manager.VipBubbleManager;
import com.soft.blued.ui.user.model.VipBubbleModel;
import com.soft.blued.ui.video.ShowVideoDestroyFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.AtChooseUserHelper;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.FileUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.MemoryBitmapCache;
import com.soft.blued.utils.SkinHelper;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.io.File;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/MessageChatAdapter.class */
public class MessageChatAdapter extends BaseListAdapter<ChattingModel> implements MsgItemMenuPop.ItemClickListener {
    private static final String l = MessageChatAdapter.class.getSimpleName();
    private final int A;
    private final int B;
    private final int C;
    private final int D;
    private final int E;
    private final int F;
    private final int G;
    private final int H;
    private final int I;
    private final int J;
    private final int K;
    private final int L;
    private final int M;
    private final int N;
    private final int O;
    private final int P;
    private final int Q;
    private final int R;
    private final int S;
    private final int T;
    private final int U;
    private final int V;
    private final int W;
    private final int X;
    private final int Y;
    private final int Z;
    private final int aA;
    private final int aB;
    private final int aC;
    private final int aD;
    private final int aE;
    private final int aF;
    private final int aG;
    private final int aH;
    private final int aI;
    private final int aJ;
    private String aK;
    private Dialog aL;
    private AtChooseUserHelper aM;
    private TextWatcher aN;
    private LoadOptions aO;
    private LoadOptions aP;
    private LoadOptions aQ;
    private LoadOptions aR;
    private LoadOptions aS;
    private IMsgChatAdapterCallback aT;
    private IMsgChatAdapterOperationCallback aU;
    private MsgChattingFragment aV;
    private Set<Long> aW;
    private HashMap<String, ShareToMsgEntity> aX;
    private int aY;
    private BottomMenuPop aZ;
    private final int aa;
    private final int ab;
    private final int ac;
    private final int ad;
    private final int ae;
    private final int af;
    private final int ag;
    private final int ah;
    private final int ai;
    private final int aj;
    private final int ak;
    private final int al;
    private final int am;
    private final int an;
    private final int ao;
    private final int ap;
    private final int aq;

    /* renamed from: ar  reason: collision with root package name */
    private final int f18293ar;
    private final int as;
    private final int at;
    private final int au;
    private final int av;
    private final int aw;
    private final int ax;
    private final int ay;
    private final int az;
    private HashSet<Long> ba;
    private HashSet<Long> bb;
    public int e;
    public Emotion f;
    public MediaRecordHelper g;
    public String h;
    public String i;
    public List<String> j;
    public VipBubbleModel k;
    private final int m;
    private final int n;
    private final int o;
    private final int p;
    private final int q;
    private final int r;
    private final int s;
    private final int t;
    private final int u;
    private final int v;
    private final int w;
    private final int x;
    private final int y;
    private final int z;

    /* renamed from: com.soft.blued.ui.msg.adapter.MessageChatAdapter$35  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/MessageChatAdapter$35.class */
    class AnonymousClass35 implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Tracker.onClick(dialogInterface, i);
        }
    }

    /* renamed from: com.soft.blued.ui.msg.adapter.MessageChatAdapter$36  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/MessageChatAdapter$36.class */
    class AnonymousClass36 implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Tracker.onClick(dialogInterface, i);
        }
    }

    /* renamed from: com.soft.blued.ui.msg.adapter.MessageChatAdapter$84  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/MessageChatAdapter$84.class */
    class AnonymousClass84 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView f18464a;
        final /* synthetic */ RelativeLayout b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            if (this.f18464a.getVisibility() == 0) {
                this.f18464a.setVisibility(8);
                this.b.setVisibility(0);
                view.setSelected(false);
                return;
            }
            this.f18464a.setVisibility(0);
            this.b.setVisibility(4);
            view.setSelected(true);
        }
    }

    /* renamed from: com.soft.blued.ui.msg.adapter.MessageChatAdapter$85  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/MessageChatAdapter$85.class */
    class AnonymousClass85 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChattingModel f18465a;
        final /* synthetic */ MessageChatAdapter b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            Context context = this.b.b;
            List<E> list = this.b.f18271a;
            ChattingModel chattingModel = this.f18465a;
            MsgCommonUtils.a(context, list, chattingModel, this.b.aT.e() + "", 6, 0, this.b.aU.getFragmentActive());
        }
    }

    /* renamed from: com.soft.blued.ui.msg.adapter.MessageChatAdapter$86  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/MessageChatAdapter$86.class */
    class AnonymousClass86 extends GridLayoutManager {
        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    /* renamed from: com.soft.blued.ui.msg.adapter.MessageChatAdapter$89  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/MessageChatAdapter$89.class */
    class AnonymousClass89 extends LinearLayoutManager {
        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    /* renamed from: com.soft.blued.ui.msg.adapter.MessageChatAdapter$90  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/MessageChatAdapter$90.class */
    class AnonymousClass90 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChattingModel f18470a;
        final /* synthetic */ MessageChatAdapter b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            Context context = this.b.b;
            List<E> list = this.b.f18271a;
            ChattingModel chattingModel = this.f18470a;
            MsgCommonUtils.a(context, list, chattingModel, this.b.aT.f() + "", 6, 0, this.b.aU.getFragmentActive());
        }
    }

    /* renamed from: com.soft.blued.ui.msg.adapter.MessageChatAdapter$91  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/MessageChatAdapter$91.class */
    class AnonymousClass91 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MsgExtraForTextTypeEntity.SecureNotify f18471a;
        final /* synthetic */ MessageChatAdapter b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            if (TextUtils.isEmpty(this.f18471a.link)) {
                return;
            }
            WebViewShowInfoFragment.show(this.b.b, this.f18471a.link, -1);
        }
    }

    /* renamed from: com.soft.blued.ui.msg.adapter.MessageChatAdapter$94  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/MessageChatAdapter$94.class */
    class AnonymousClass94 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MsgExtraForTextTypeEntity.SecureNotify f18474a;
        final /* synthetic */ MessageChatAdapter b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            if (TextUtils.isEmpty(this.f18474a.link)) {
                return;
            }
            WebViewShowInfoFragment.show(this.b.b, this.f18474a.link, -1);
        }
    }

    /* renamed from: com.soft.blued.ui.msg.adapter.MessageChatAdapter$95  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/MessageChatAdapter$95.class */
    class AnonymousClass95 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MsgExtraForTextTypeEntity.SecureNotify f18475a;
        final /* synthetic */ MessageChatAdapter b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            if (TextUtils.isEmpty(this.f18475a.link)) {
                return;
            }
            WebViewShowInfoFragment.show(this.b.b, this.f18475a.link, -1);
        }
    }

    public MessageChatAdapter(IMsgChatAdapterCallback iMsgChatAdapterCallback, IMsgChatAdapterOperationCallback iMsgChatAdapterOperationCallback, List<ChattingModel> list, AtChooseUserHelper atChooseUserHelper, TextWatcher textWatcher, MsgChattingFragment msgChattingFragment) {
        super(iMsgChatAdapterOperationCallback.getActivity(), list);
        this.m = 75;
        this.n = 0;
        this.o = 1;
        this.p = 2;
        this.q = 3;
        this.r = 4;
        this.s = 5;
        this.t = 6;
        this.u = 7;
        this.v = 8;
        this.w = 9;
        this.x = 10;
        this.y = 11;
        this.z = 12;
        this.A = 13;
        this.B = 14;
        this.C = 15;
        this.D = 16;
        this.E = 17;
        this.F = 18;
        this.G = 19;
        this.H = 20;
        this.I = 21;
        this.J = 22;
        this.K = 23;
        this.L = 24;
        this.M = 25;
        this.N = 26;
        this.O = 27;
        this.P = 28;
        this.Q = 29;
        this.R = 30;
        this.S = 31;
        this.T = 32;
        this.U = 33;
        this.V = 34;
        this.W = 35;
        this.X = 36;
        this.Y = 37;
        this.Z = 38;
        this.aa = 39;
        this.ab = 40;
        this.ac = 41;
        this.ad = 42;
        this.ae = 43;
        this.e = 0;
        this.af = 44;
        this.ag = 45;
        this.ah = 46;
        this.ai = 47;
        this.aj = 48;
        this.ak = 49;
        this.al = 50;
        this.am = 51;
        this.an = 52;
        this.ao = 53;
        this.ap = 54;
        this.aq = 55;
        this.f18293ar = 56;
        this.as = 57;
        this.at = 58;
        this.au = 59;
        this.av = 60;
        this.aw = 61;
        this.ax = 62;
        this.ay = 63;
        this.az = 64;
        this.aA = 65;
        this.aB = 66;
        this.aC = 67;
        this.aD = 68;
        this.aE = 69;
        this.aF = 70;
        this.aG = 71;
        this.aH = 72;
        this.aI = 73;
        this.aJ = 74;
        this.g = new MediaRecordHelper();
        this.h = "";
        this.i = "";
        this.aW = new HashSet();
        this.aX = new HashMap<>();
        this.j = new ArrayList();
        this.ba = new HashSet<>();
        this.bb = new HashSet<>();
        this.aT = iMsgChatAdapterCallback;
        this.aU = iMsgChatAdapterOperationCallback;
        this.f = new Emotion(this.b);
        this.aL = DialogUtils.a(this.b);
        this.aM = atChooseUserHelper;
        this.aN = textWatcher;
        LoadOptions loadOptions = new LoadOptions();
        this.aO = loadOptions;
        loadOptions.d = 2131237310;
        this.aO.b = 2131237310;
        LoadOptions loadOptions2 = new LoadOptions();
        this.aQ = loadOptions2;
        loadOptions2.b = R.drawable.group_default_head;
        this.aQ.d = R.drawable.group_default_head;
        LoadOptions loadOptions3 = new LoadOptions();
        this.aP = loadOptions3;
        loadOptions3.d = 2131101212;
        this.aP.b = 2131101212;
        LoadOptions loadOptions4 = new LoadOptions();
        this.aR = loadOptions4;
        loadOptions4.d = R.drawable.icon_msg_share_feed_text;
        this.aR.b = R.drawable.icon_msg_share_feed_text;
        LoadOptions loadOptions5 = new LoadOptions();
        this.aS = loadOptions5;
        loadOptions5.d = R.drawable.icon_failed_share_viewpoint;
        this.aS.b = 2131101212;
        this.aV = msgChattingFragment;
    }

    private void A(ChattingModel chattingModel, View view) {
        String str;
        r(chattingModel, view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.msg_item_root);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_header_self);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_header_self);
        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_header_him);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_header_him);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_both_heart);
        int i = 0;
        ImageLoader.a(c(), AvatarUtils.a(0, UserInfo.getInstance().getLoginUserInfo().getAvatar())).b(2131237310).c().a(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.117
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                MessageChatAdapter.this.a(true);
            }
        });
        ImageLoader.a(c(), AvatarUtils.a(0, this.aT.d())).b(2131237310).c().a(imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.118
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                MessageChatAdapter.this.a(false);
            }
        });
        try {
            String msgExtra = chattingModel.getMsgExtra();
            if (TextUtils.isEmpty(msgExtra)) {
                return;
            }
            DateTodayInterestPlayedModel dateTodayInterestPlayedModel = (DateTodayInterestPlayedModel) AppInfo.f().fromJson(msgExtra, (Class<Object>) DateTodayInterestPlayedModel.class);
            StringBuilder sb = new StringBuilder();
            sb.append("refresh UI playedModel=");
            if (dateTodayInterestPlayedModel == null) {
                str = b.l;
            } else {
                str = "played=" + dateTodayInterestPlayedModel.getPlayed();
            }
            sb.append(str);
            Log.e("xxx", sb.toString());
            if (dateTodayInterestPlayedModel == null || dateTodayInterestPlayedModel.getPlayed() != 1) {
                i = 8;
            }
            imageView3.setVisibility(i);
        } catch (Exception e) {
        }
    }

    private void B(final ChattingModel chattingModel, View view) {
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_chat_date_today_evaluate);
        TextView textView = (TextView) view.findViewById(R.id.tv_to_evaluate);
        String string = this.b.getString(R.string.date_today_chatting_impressions1);
        String str = string + this.b.getString(R.string.date_today_chatting_impressions2);
        SpannableString spannableString = new SpannableString(str);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        spannableString.setSpan(new CharacterStyle() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.119
            @Override // android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(ContextCompat.getColor(MessageChatAdapter.this.b, 2131102263));
            }
        }, 0, string.length(), 33);
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.120
            @Override // android.text.style.ClickableSpan
            public void onClick(View view2) {
                linearLayout.callOnClick();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(ContextCompat.getColor(MessageChatAdapter.this.b, 2131101766));
            }
        }, string.length(), str.length(), 33);
        textView.setText(spannableString);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.121
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (DateTodayManager.f18714a.f(MessageChatAdapter.this.a(chattingModel.sessionId))) {
                    AppMethods.d((int) R.string.date_today_evaluation_toast);
                    return;
                }
                DateTodayConfigModel b = DateTodayManager.f18714a.b();
                if (b == null || b.getFriends_evaluation() == null) {
                    return;
                }
                new XPopup.Builder(MessageChatAdapter.this.b).a(new DateTodayUserEvaluationPop(MessageChatAdapter.this.b, MessageChatAdapter.this.a(chattingModel.sessionId), b.getFriends_evaluation(), MessageChatAdapter.this.c())).h();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return ((ChannelModel) AppInfo.f().fromJson(str, (Class<Object>) ChannelModel.class)).chat_sdk_type;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private View a(ChattingModel chattingModel, int i, ViewGroup viewGroup) {
        short s = chattingModel.msgType;
        if (MsgType.getClassify(s) == 1 || s == 26) {
            return this.f18272c.inflate(R.layout.item_chat_two_notify_notice, viewGroup, false);
        }
        if (MsgType.getGroupOperationNotifyType(s) == 2 || s == 0) {
            return this.f18272c.inflate(R.layout.item_chat_group_dismissed_notice, viewGroup, false);
        }
        if (s != -9) {
            if (s != -8) {
                if (s != -3) {
                    if (s != -2) {
                        if (s != -1) {
                            if (s != 1) {
                                if (s != 2) {
                                    if (s == 3) {
                                        return getItemViewType(i) == 7 ? this.f18272c.inflate(R.layout.item_chat_received_voice, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_voice, viewGroup, false);
                                    } else if (s == 4) {
                                        return getItemViewType(i) == 5 ? this.f18272c.inflate(R.layout.item_chat_received_location, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_location, viewGroup, false);
                                    } else if (s == 5) {
                                        return getItemViewType(i) == 17 ? this.f18272c.inflate(R.layout.item_chat_received_video, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_video, viewGroup, false);
                                    } else {
                                        if (s != 6) {
                                            if (s == 9) {
                                                return getItemViewType(i) == 9 ? this.f18272c.inflate(R.layout.item_chat_received_group_invite_share, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_group_invite_share, viewGroup, false);
                                            } else if (s == 10) {
                                                return getItemViewType(i) == 11 ? this.f18272c.inflate(R.layout.item_chat_received_group_share, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_group_share, viewGroup, false);
                                            } else if (s == 24) {
                                                return getItemViewType(i) == 19 ? this.f18272c.inflate(R.layout.item_chat_received_image_burn, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_image_burn, viewGroup, false);
                                            } else if (s == 25) {
                                                return getItemViewType(i) == 21 ? this.f18272c.inflate(R.layout.item_chat_received_video_burn, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_video_burn, viewGroup, false);
                                            } else if (s == 52 || s == 53) {
                                                return getItemViewType(i) == 27 ? this.f18272c.inflate(R.layout.item_chat_received_video_call, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_video_call, viewGroup, false);
                                            } else if (s == 73) {
                                                return getItemViewType(i) == 41 ? this.f18272c.inflate(R.layout.item_chat_received_apply_private_photo, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_apply_private_photo, viewGroup, false);
                                            } else if (s == 74) {
                                                return getItemViewType(i) == 43 ? this.f18272c.inflate(R.layout.item_chat_received_unlock_private_photo, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_unlock_private_photo, viewGroup, false);
                                            } else if (s == 98 || s == 99) {
                                                return getItemViewType(i) == 39 ? this.f18272c.inflate(R.layout.item_chat_received_vip, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_vip, viewGroup, false);
                                            } else {
                                                switch (s) {
                                                    case 6:
                                                        break;
                                                    case 32:
                                                        return getItemViewType(i) == 23 ? this.f18272c.inflate(R.layout.item_chat_received_live_share, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_live_share, viewGroup, false);
                                                    case 55:
                                                        return this.f18272c.inflate(R.layout.item_chat_two_notify_notice, viewGroup, false);
                                                    case 68:
                                                        return this.f18272c.inflate(R.layout.item_chat_image_and_text, viewGroup, false);
                                                    case 164:
                                                        return getItemViewType(i) == 45 ? this.f18272c.inflate(R.layout.item_chat_received_pager_gift, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_pager_gift, viewGroup, false);
                                                    case 169:
                                                        return this.f18272c.inflate(R.layout.item_chat_common_system_notice, viewGroup, false);
                                                    case 205:
                                                        return getItemViewType(i) == 51 ? this.f18272c.inflate(R.layout.item_chat_received_hello_expression, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_hello_expression, viewGroup, false);
                                                    case 210:
                                                        return getItemViewType(i) == 53 ? this.f18272c.inflate(R.layout.item_chat_received_yy_share, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_yy_share, viewGroup, false);
                                                    case 216:
                                                        return this.f18272c.inflate(R.layout.item_chat_system_notice, viewGroup, false);
                                                    case 220:
                                                        return this.f18272c.inflate(R.layout.item_chat_group_announcement, viewGroup, false);
                                                    case 250:
                                                        break;
                                                    case 251:
                                                        break;
                                                    case 256:
                                                        return this.f18272c.inflate(R.layout.item_chat_received_vi_hi, viewGroup, false);
                                                    case 257:
                                                        return this.f18272c.inflate(R.layout.item_chat_received_live_share_v2, viewGroup, false);
                                                    case 267:
                                                        return this.f18272c.inflate(R.layout.item_chat_received_privilege_source_tips, viewGroup, false);
                                                    case 271:
                                                        return this.f18272c.inflate(R.layout.item_chat_received_special_user_post_feed, viewGroup, false);
                                                    case 279:
                                                        return this.f18272c.inflate(R.layout.item_chat_received_super_exposure_post_feed, viewGroup, false);
                                                    case 281:
                                                        return this.f18272c.inflate(R.layout.item_chat_date_today, viewGroup, false);
                                                    case 282:
                                                        return getItemViewType(i) == 68 ? this.f18272c.inflate(R.layout.item_chat_received_date_today_say_hello, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_date_today_say_hello, viewGroup, false);
                                                    case 283:
                                                        return getItemViewType(i) == 70 ? this.f18272c.inflate(R.layout.item_chat_received_date_today_interest, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_date_today_interest, viewGroup, false);
                                                    case 288:
                                                        return this.f18272c.inflate(R.layout.item_chat_date_today_matched, viewGroup, false);
                                                    case 290:
                                                        return this.f18272c.inflate(R.layout.item_chat_yy_system_message, viewGroup, false);
                                                    default:
                                                        switch (s) {
                                                            case 87:
                                                                return getItemViewType(i) == 31 ? this.f18272c.inflate(R.layout.item_chat_received_share_viewpoint, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_share_viewpoint, viewGroup, false);
                                                            case 88:
                                                                return getItemViewType(i) == 33 ? this.f18272c.inflate(R.layout.item_chat_received_share_link, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_share_link, viewGroup, false);
                                                            case 89:
                                                                break;
                                                            case 90:
                                                                return getItemViewType(i) == 37 ? this.f18272c.inflate(R.layout.item_chat_received_share_user, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_share_user, viewGroup, false);
                                                            default:
                                                                switch (s) {
                                                                    case 240:
                                                                        return this.f18272c.inflate(R.layout.item_chat_group_evaluation, viewGroup, false);
                                                                    case 241:
                                                                        return this.f18272c.inflate(R.layout.item_chat_anonymous_notice, viewGroup, false);
                                                                    case 242:
                                                                        break;
                                                                    case 243:
                                                                        break;
                                                                    case 244:
                                                                        return this.f18272c.inflate(R.layout.item_chat_share_event, viewGroup, false);
                                                                    default:
                                                                        return getItemViewType(i) == 1 ? this.f18272c.inflate(R.layout.item_chat_received_message, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_message, viewGroup, false);
                                                                }
                                                        }
                                                        return getItemViewType(i) == 35 ? this.f18272c.inflate(R.layout.item_chat_received_share_feed, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_share_feed, viewGroup, false);
                                                }
                                            }
                                        }
                                        return getItemViewType(i) == 15 ? this.f18272c.inflate(R.layout.item_chat_received_emotion, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_emotion, viewGroup, false);
                                    }
                                }
                                return getItemViewType(i) == 3 ? this.f18272c.inflate(R.layout.item_chat_received_image, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_sent_image, viewGroup, false);
                            }
                            if (getItemViewType(i) == 1) {
                                SubscribeNumberManager subscribeNumberManager = SubscribeNumberManager.f18759a;
                                StringBuilder sb = new StringBuilder();
                                sb.append(chattingModel.sessionId);
                                sb.append("");
                                return subscribeNumberManager.a(sb.toString(), Short.valueOf(chattingModel.sessionType)) ? this.f18272c.inflate(R.layout.item_chat_service_message, viewGroup, false) : this.f18272c.inflate(R.layout.item_chat_received_message, viewGroup, false);
                            }
                            return this.f18272c.inflate(R.layout.item_chat_sent_message, viewGroup, false);
                        }
                        return this.f18272c.inflate(R.layout.item_chat_complete_profile, viewGroup, false);
                    }
                    return this.f18272c.inflate(R.layout.item_chat_first, viewGroup, false);
                }
                return this.f18272c.inflate(R.layout.item_chat_disturb_notice, viewGroup, false);
            }
            return this.f18272c.inflate(R.layout.item_chat_poke, viewGroup, false);
        }
        return this.f18272c.inflate(R.layout.item_chat_date_today_evaluate, viewGroup, false);
    }

    private String a(MsgExtraForTextTypeEntity msgExtraForTextTypeEntity) {
        return msgExtraForTextTypeEntity == null ? "" : msgExtraForTextTypeEntity.htmlContent;
    }

    private String a(MsgImageAndTextModel msgImageAndTextModel) {
        return (msgImageAndTextModel == null || TextUtils.isEmpty(msgImageAndTextModel.activity_work_id) || !msgImageAndTextModel.activity_work_id.contains(com.anythink.expressad.d.a.b.g)) ? "" : msgImageAndTextModel.activity_work_id;
    }

    private void a(int i, TextView textView) {
        String valueOf;
        String valueOf2;
        int i2 = i / 60;
        int i3 = i % 60;
        if (i2 < 10) {
            valueOf = "0" + i2;
        } else {
            valueOf = String.valueOf(i2);
        }
        if (i3 < 10) {
            valueOf2 = "0" + i3;
        } else {
            valueOf2 = String.valueOf(i3);
        }
        textView.setText(this.b.getResources().getString(R.string.msg_video_duration) + " " + valueOf + ":" + valueOf2);
    }

    private void a(long j, TextView textView) {
        if (!TimeAndDateUtils.g(j)) {
            this.aK = ((SimpleDateFormat) TimeAndDateUtils.e.get()).format(new Date(j));
        } else if (TimeAndDateUtils.f(j)) {
            this.aK = ((SimpleDateFormat) TimeAndDateUtils.f.get()).format(new Date(j));
        } else if (TimeAndDateUtils.h(j)) {
            this.aK = this.b.getResources().getString(R.string.biao_msg_yesterday) + " " + ((SimpleDateFormat) TimeAndDateUtils.f.get()).format(new Date(j));
        } else {
            this.aK = ((SimpleDateFormat) TimeAndDateUtils.h.get()).format(new Date(j));
        }
        textView.setText(this.aK);
        textView.setVisibility(0);
    }

    private void a(View view, View view2, boolean z, final View.OnClickListener onClickListener) {
        final ShapeLinearLayout findViewById = view.findViewById(R.id.sll_img_cover);
        if (findViewById != null) {
            if (!z) {
                findViewById.setVisibility(8);
                return;
            }
            ShapeTextView findViewById2 = view.findViewById(R.id.stv_remove_img_cover);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.width = view2.getLayoutParams().width;
            layoutParams.height = view2.getLayoutParams().height;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.55
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                }
            });
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.56
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    findViewById.setVisibility(8);
                    View.OnClickListener onClickListener2 = onClickListener;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(view3);
                    }
                }
            });
        }
    }

    private void a(View view, ChattingModel chattingModel) {
        if (chattingModel.isFromSelf()) {
            String msgExtra = chattingModel.getMsgExtra();
            if (TextUtils.isEmpty(msgExtra)) {
                return;
            }
            JSONObject parseObject = JSONObject.parseObject(msgExtra);
            if (parseObject.containsKey("illegal") && parseObject.getBoolean("illegal").booleanValue()) {
                TextView textView = (TextView) view.findViewById(R.id.tv_state);
                ImageView imageView = (ImageView) view.findViewById(R.id.chat_state_error);
                if (textView == null || imageView == null) {
                    return;
                }
                imageView.setVisibility(8);
                textView.setVisibility(0);
                textView.setText(this.b.getString(R.string.msg_send_illegal));
            }
        }
    }

    private void a(final View view, final ArrayList<String> arrayList, final ChattingModel chattingModel) {
        int i;
        if (KeyboardUtils.b(this.aV.getActivity())) {
            KeyboardUtils.a(this.aV.getActivity());
            i = 300;
        } else {
            i = 0;
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.111
            @Override // java.lang.Runnable
            public void run() {
                ListView c2;
                int b = MessageChatAdapter.this.b(view);
                if (b != 0 && (c2 = MessageChatAdapter.this.c(view)) != null) {
                    try {
                        c2.scrollListBy(b);
                    } catch (Throwable th) {
                    }
                }
                MsgItemMenuPop msgItemMenuPop = new MsgItemMenuPop(MessageChatAdapter.this.b, arrayList, chattingModel, MessageChatAdapter.this);
                if (MessageChatAdapter.this.c().isActive()) {
                    new XPopup.Builder(MessageChatAdapter.this.b).a(view).d(false).a(PopupAnimation.a).a(PopupPosition.c).b(true).a(msgItemMenuPop).h();
                }
            }
        }, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, String str, LoadOptions loadOptions) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Logger.b(l, "loadLocalPic===", RecyclingUtils.Scheme.c.b(str));
        (str.startsWith("assets://") ? ImageLoader.c(c(), str.substring(9)) : str.startsWith("file://") ? ImageLoader.d(c(), str.substring(7)) : ImageLoader.a(c(), str)).g(-1).a(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, String str, boolean z) {
        ImageWrapper d = str.contains("http") ^ true ? ImageLoader.d(c(), str) : ImageLoader.a(c(), str);
        if (z) {
            d.a(80);
        }
        d.a(6.0f).a(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, String str, int i, boolean... zArr) {
        TypefaceUtils.a(textView, (CharSequence) str, false, "", i, zArr);
    }

    private void a(ChattingModel chattingModel, View view) {
        if (view == null) {
            return;
        }
        try {
            TextView textView = (TextView) ViewHolder.a(view, R.id.tv_message);
            TextView textView2 = (TextView) ViewHolder.a(view, R.id.tv_detail);
            textView.setText(chattingModel.msgContent);
            LogUtils.d("message", "yy system message: " + chattingModel.getMsgExtra());
            JSONObject parseObject = JSON.parseObject(chattingModel.getMsgExtra());
            final String string = parseObject.getString("pop_content");
            final String string2 = parseObject.getString("id");
            final String string3 = parseObject.getString("data_id");
            final int intValue = parseObject.getInteger("operation_deadline").intValue();
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    MessageChatAdapter.this.a(string2, string3, string, intValue);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(final ChattingModel chattingModel, final View view, final int i) {
        final View findViewById = view.findViewById(R.id.chat_content_in);
        final String b = ChatHelperV4.a().b(chattingModel);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
        marginLayoutParams.width = DensityUtil.a(85.0f);
        marginLayoutParams.height = DensityUtil.a(85.0f);
        findViewById.setLayoutParams(marginLayoutParams);
        a(chattingModel, b, findViewById, 2);
        r(chattingModel, view);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.59
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                Logger.b(MessageChatAdapter.l, "点击解密后的视频地址===", b);
                if (TextUtils.isEmpty(b) || !b.contains("http")) {
                    return;
                }
                String str = b;
                String M = BluedPreferences.M(chattingModel.msgContent);
                if (!TextUtils.isEmpty(M)) {
                    File file = new File(M);
                    if (file.isFile() && file.exists()) {
                        str = M;
                    }
                }
                MsgChattingVideoModel e = ChatHelperV4.a().e(chattingModel);
                if (chattingModel.msgId == 1 && !chattingModel.isFromSelf() && e != null && e.getMsgSource() != null && (BluedConfig.a().r() || e.getMsgSource().getType() == MessageProtos.StrangerSource.SHADOW_SOURCE)) {
                    MessageChatAdapter.this.a(e.getMsgSource(), view, String.valueOf(chattingModel.fromId));
                }
                if (e == null || !e.identify_yellow || chattingModel.isFromSelf()) {
                    ShowVideoDestroyFragment.a(MessageChatAdapter.this.aU.v(), chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId, str, i, 701);
                    return;
                }
                final String str2 = str;
                CommonAlertDialog.a(MessageChatAdapter.this.b, MessageChatAdapter.this.b.getResources().getString(R.string.msg_yellow_tip_title), MessageChatAdapter.this.b.getResources().getString(R.string.msg_yellow_tip_content_see), MessageChatAdapter.this.b.getResources().getString(R.string.msg_yellow_tip_ok), 0, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.59.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Tracker.onClick(dialogInterface, i2);
                        ShowVideoDestroyFragment.a(MessageChatAdapter.this.aU.v(), chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId, str2, i, 701);
                    }
                }, MessageChatAdapter.this.b.getResources().getString(R.string.msg_yellow_tip_cancel), MessageChatAdapter.this.b.getResources().getColor(2131101632), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
            }
        });
        findViewById.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.60
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                MessageChatAdapter.this.c(findViewById, chattingModel);
                return false;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.blued.android.chat.model.ChattingModel r9, android.view.View r10, final int r11, final int r12) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.adapter.MessageChatAdapter.a(com.blued.android.chat.model.ChattingModel, android.view.View, int, int):void");
    }

    private void a(final ChattingModel chattingModel, View view, View view2) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.msg_item_root);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_feed_img);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_feed_img);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_video_preview);
        TextView textView = (TextView) view.findViewById(R.id.tv_feed_content);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_feed_right_bottom_tips);
        String msgExtra = chattingModel.getMsgExtra();
        if (TextUtils.isEmpty(msgExtra)) {
            return;
        }
        final FriendsNotificationExtra friendsNotificationExtra = (FriendsNotificationExtra) AppInfo.f().fromJson(msgExtra, (Class<Object>) FriendsNotificationExtra.class);
        if (BluedSkinUtils.c()) {
            textView2.setTextColor(BluedSkinUtils.a(this.b, 2131101780));
        } else {
            textView2.setTextColor(BluedSkinUtils.a(this.b, 2131102264));
        }
        if (friendsNotificationExtra.circle_type > 0) {
            frameLayout.setVisibility(0);
            if (friendsNotificationExtra.circle_type == 2) {
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
            }
            ImageLoader.a(c(), friendsNotificationExtra.img_url).a(6.0f).a(imageView);
        } else {
            frameLayout.setVisibility(8);
        }
        if (TextUtils.isEmpty(friendsNotificationExtra.circle_content)) {
            textView.setText("");
        } else {
            textView.setText(friendsNotificationExtra.circle_content);
        }
        if (a(chattingModel, MessageProtos.Event.MSG_SUPER_FEED_SHOW.name())) {
            EventTrackMessage.b(MessageProtos.Event.MSG_SUPER_FEED_SHOW, friendsNotificationExtra.circle_id + "", chattingModel.sessionId + "");
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                if (friendsNotificationExtra.circle_id > 0) {
                    BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
                    bluedIngSelfFeed.feed_id = friendsNotificationExtra.circle_id + "";
                    FeedDetailsFragment.a(MessageChatAdapter.this.b, bluedIngSelfFeed, -1, new FeedDetailParams(0));
                    MessageProtos.Event event = MessageProtos.Event.MSG_SUPER_FEED_CLICK;
                    String str = bluedIngSelfFeed.feed_id;
                    EventTrackMessage.b(event, str, chattingModel.sessionId + "");
                }
            }
        });
    }

    private void a(final ChattingModel chattingModel, View view, final View view2, final int i) {
        final String a2 = ChatHelperV4.a().a(chattingModel);
        Logger.c(l, "setPicBurnType=====ImageLoader");
        if (this.aV != null && !TextUtils.isEmpty(a2)) {
            MemoryBitmapCache.a().a(this.aV.getContext(), a2);
        }
        a(chattingModel, a2, view2, 1);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
        marginLayoutParams.width = DensityUtil.a(85.0f);
        marginLayoutParams.height = DensityUtil.a(85.0f);
        view2.setLayoutParams(marginLayoutParams);
        r(chattingModel, view);
        final MsgChattingImageModel d = ChatHelperV4.a().d(chattingModel);
        if (IMV4Method.a(chattingModel.fromId) == 1 && BluedConfig.a().r() && d != null && chattingModel.msgId == 1 && d.getMsgSource() != null) {
            a(d.getMsgSource(), view, String.valueOf(chattingModel.fromId));
        }
        view2.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.57
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                Logger.b(MessageChatAdapter.l, "点击解密后的图片地址===", a2);
                if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(a2) || !a2.contains("http")) {
                    return;
                }
                MsgChattingImageModel msgChattingImageModel = d;
                if (msgChattingImageModel == null || !msgChattingImageModel.identify_yellow || chattingModel.isFromSelf()) {
                    ShowPhotoDestroyFragment.a(MessageChatAdapter.this.aU.v(), chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId, a2, i, 700);
                } else {
                    CommonAlertDialog.a(MessageChatAdapter.this.b, MessageChatAdapter.this.b.getResources().getString(R.string.msg_yellow_tip_title), MessageChatAdapter.this.b.getResources().getString(R.string.msg_yellow_tip_content_see), MessageChatAdapter.this.b.getResources().getString(R.string.msg_yellow_tip_see_ok), 0, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.57.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Tracker.onClick(dialogInterface, i2);
                            ShowPhotoDestroyFragment.a(MessageChatAdapter.this.aU.v(), chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId, a2, i, 700);
                        }
                    }, MessageChatAdapter.this.b.getResources().getString(R.string.msg_yellow_tip_see_cancel), MessageChatAdapter.this.b.getResources().getColor(2131101632), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                }
            }
        }));
        view2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.58
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view3) {
                MessageChatAdapter.this.c(view2, chattingModel);
                return false;
            }
        });
    }

    private void a(final ChattingModel chattingModel, View view, View view2, final ImageView imageView, TextView textView) {
        if (TextUtils.isEmpty(chattingModel.msgContent)) {
            return;
        }
        r(chattingModel, view);
        MsgChattingImageModel f = ChatHelperV4.a().f(chattingModel);
        if (f != null) {
            final String longitude = f.getLongitude();
            final String latitude = f.getLatitude();
            final String location = f.getLocation();
            String replace = IMV4Constant.f18551c.replace(DateUtils.ABBREV_WEEKDAY_FORMAT, longitude).replace(DateUtils.ABBREV_MONTH_FORMAT, latitude).replace("%c", longitude).replace(TimeModel.NUMBER_FORMAT, latitude);
            LoadOptions loadOptions = new LoadOptions();
            loadOptions.b = R.drawable.chat_maping_bg;
            loadOptions.d = R.drawable.chat_maping_bg;
            ImageLoader.a(c(), replace).b((int) R.drawable.chat_maping_bg).a(imageView);
            TextView textView2 = textView;
            if (textView == null) {
                textView2 = (TextView) ViewHolder.a(view, R.id.tv_address);
            }
            if (textView2 != null) {
                textView2.setText(TextUtils.isEmpty(location) ? "" : location);
            }
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    String str;
                    Tracker.onClick(view3);
                    Context context = MessageChatAdapter.this.b;
                    String str2 = longitude;
                    String str3 = latitude;
                    String str4 = location;
                    if (IMV4Method.b(chattingModel.fromId)) {
                        str = "";
                    } else {
                        str = chattingModel.fromId + "";
                    }
                    ShowPositionActivity.a(context, str2, str3, str4, 0, str);
                }
            });
        }
        view2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.38
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view3) {
                MessageChatAdapter.this.c(imageView, chattingModel);
                return false;
            }
        });
    }

    private void a(final ChattingModel chattingModel, View view, final ImageView imageView) {
        if (TextUtils.isEmpty(chattingModel.msgContent) || imageView == null) {
            return;
        }
        if (imageView.getTag() == null || !imageView.getTag().equals(chattingModel.msgContent)) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = AppMethods.a(120);
            layoutParams.height = AppMethods.a(120);
            imageView.setLayoutParams(layoutParams);
            imageView.requestLayout();
            imageView.setImageResource(R.drawable.msg_emotion_defaultbg);
            imageView.setTag(chattingModel.msgContent);
            final LoadOptions loadOptions = new LoadOptions();
            loadOptions.d = R.drawable.msg_emotion_defaultbg;
            loadOptions.e = true;
            loadOptions.l = false;
            Logger.b(l, "emotionCode====", chattingModel.msgContent);
            EmoticonModel e = EmotionManager.e(chattingModel.msgContent);
            r(chattingModel, view);
            if (e == null) {
                EmotionManager.a(this.b, chattingModel.msgContent, new EmotionLoadListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.61
                    public void a(final EmoticonModel emoticonModel) {
                        if (emoticonModel == null) {
                            return;
                        }
                        Logger.b(MessageChatAdapter.l, "em.url111======", emoticonModel.url_original);
                        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.61.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (imageView.getTag() == null || !imageView.getTag().equals(chattingModel.msgContent)) {
                                    return;
                                }
                                MessageChatAdapter.this.a(imageView, emoticonModel.url_original, loadOptions);
                            }
                        });
                    }

                    public void b(EmoticonModel emoticonModel) {
                    }

                    public void c(EmoticonModel emoticonModel) {
                    }
                });
            } else {
                String str = e.url_original;
                Logger.b(l, "em.url222======", str);
                a(imageView, str, loadOptions);
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.62
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    String str2 = (String) view2.getTag();
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    BluedURIRouterAdapter.openEmotionDetail(MessageChatAdapter.this.b, str2);
                }
            });
            imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.63
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    MessageChatAdapter.this.c(imageView, chattingModel);
                    return false;
                }
            });
        }
    }

    private void a(final ChattingModel chattingModel, final View view, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        String msgExtra = chattingModel.getMsgExtra();
        if (TextUtils.isEmpty(msgExtra)) {
            return;
        }
        final MsgExtra msgExtra2 = (MsgExtra) AppInfo.f().fromJson(msgExtra, new TypeToken<MsgExtra>() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.32
        }.getType());
        textView.setText(this.b.getResources().getString(R.string.biao_im_msg_share_toone));
        ImageLoader.a(c(), msgExtra2.getGroups_avatar()).c().b((int) R.drawable.group_default_head).a(imageView);
        if (!TextUtils.isEmpty(msgExtra2.getGroups_name())) {
            textView2.setText(msgExtra2.getGroups_name());
        }
        if (!TextUtils.isEmpty(msgExtra2.getGroups_description())) {
            textView3.setText(msgExtra2.getGroups_description());
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
            if (textView3.getLineCount() == 1) {
                layoutParams.bottomToBottom = 0;
                layoutParams.bottomMargin = DensityUtils.a(this.b, 17.0f);
            } else {
                layoutParams.bottomToBottom = -1;
            }
            imageView.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (BluedConstant.f14549a && chattingModel.sessionType == 2 && (chattingModel.msgType == 9 || chattingModel.msgType == 10)) {
                    MessageChatAdapter.this.d();
                    return;
                }
                final Bundle bundle = new Bundle();
                final String valueOf = String.valueOf(msgExtra2.getGroups_gid());
                final String groups_iid = msgExtra2.getGroups_iid();
                if (StringUtils.d(valueOf)) {
                    return;
                }
                if (chattingModel.isFromSelf()) {
                    bundle.putString("gid", valueOf);
                    bundle.putString("iid", groups_iid);
                    bundle.putString("from_page", MsgChattingFragment.class.getSimpleName());
                    TerminalActivity.d(MessageChatAdapter.this.b, GroupInfoFragment.class, bundle);
                } else {
                    GroupHttpUtils.a(MessageChatAdapter.this.b, new BluedUIHttpResponse<BluedEntityA<BluedCreatedGroupInfo>>() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.33.1

                        /* renamed from: a  reason: collision with root package name */
                        boolean f18367a;

                        /* renamed from: a */
                        public void onUIUpdate(BluedEntityA<BluedCreatedGroupInfo> bluedEntityA) {
                            try {
                                int i = ((BluedCreatedGroupInfo) bluedEntityA.data.get(0)).groups_is_locked;
                                String str = ((BluedCreatedGroupInfo) bluedEntityA.data.get(0)).groups_in_members;
                                if (i == 1) {
                                    bundle.putString("gid", valueOf);
                                    bundle.putString("iid", groups_iid);
                                    bundle.putString("from_page", MsgChattingFragment.class.getSimpleName());
                                    TerminalActivity.d(MessageChatAdapter.this.b, GroupInfoFragment.class, bundle);
                                } else if (!"1".equals(str)) {
                                    bundle.putString("gid", valueOf);
                                    bundle.putString("iid", groups_iid);
                                    bundle.putString("from_page", MsgChattingFragment.class.getSimpleName());
                                    TerminalActivity.d(MessageChatAdapter.this.b, GroupInfoFragment.class, bundle);
                                } else {
                                    BluedCreatedGroupInfo bluedCreatedGroupInfo = (BluedCreatedGroupInfo) bluedEntityA.data.get(0);
                                    if (bluedCreatedGroupInfo == null) {
                                        return;
                                    }
                                    LogData logData = new LogData();
                                    logData.from = "none";
                                    ChatHelperV4.a().a(MessageChatAdapter.this.b, Long.valueOf(bluedCreatedGroupInfo.groups_gid).longValue(), bluedCreatedGroupInfo.groups_name, bluedCreatedGroupInfo.groups_avatar, bluedCreatedGroupInfo.vbadge, 0, 0, 0, "", false, 1, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        public boolean onUIFailure(int i, String str) {
                            this.f18367a = true;
                            return super.onUIFailure(i, str);
                        }

                        public void onUIFinish() {
                            super.onUIFinish();
                            if (this.f18367a) {
                                this.f18367a = false;
                                bundle.putString("gid", valueOf);
                                bundle.putString("iid", groups_iid);
                                bundle.putString("from_page", MsgChattingFragment.class.getSimpleName());
                                TerminalActivity.d(MessageChatAdapter.this.b, GroupInfoFragment.class, bundle);
                            }
                        }
                    }, valueOf, "detail", (IRequestHost) null);
                }
                if (10 == chattingModel.msgType) {
                    String str = "http://common.blued.com/?action=group&id=" + EncryptTool.b(valueOf);
                    String str2 = "";
                    if (!IMV4Method.b(chattingModel.fromId)) {
                        str2 = chattingModel.fromId + "";
                    }
                    InstantLog.a(10, str, str2);
                }
            }
        });
        if (chattingModel.msgType != 9) {
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.34
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (BluedConstant.f14549a && chattingModel.sessionType == 2 && chattingModel.msgType == 10) {
                        MessageChatAdapter.this.d();
                        return false;
                    }
                    MessageChatAdapter.this.c(view, chattingModel);
                    return false;
                }
            });
        }
    }

    private void a(ChattingModel chattingModel, View view, TextView textView, ShapeTextView shapeTextView, ImageView imageView, View view2, TextView textView2) {
        if (view == null || textView == null || shapeTextView == null || imageView == null || view2 == null || textView2 == null) {
            return;
        }
        if (!this.aT.c()) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.vip_grade = chattingModel.fromVipGrade;
        userBasicModel.is_vip_annual = chattingModel.fromVipAnnual;
        userBasicModel.vip_exp_lvl = chattingModel.fromVipExpLvl;
        userBasicModel.is_hide_vip_look = chattingModel.fromHideVipLook;
        if (textView != null) {
            if (TextUtils.isEmpty(chattingModel.fromNickName)) {
                textView.setText("");
            } else {
                textView.setText(chattingModel.fromNickName);
                UserRelationshipUtils.a(this.b, textView, userBasicModel);
            }
        }
        UserInfoHelper.a(imageView, userBasicModel, this.aV.getFragmentActive());
        String valueOf = String.valueOf(chattingModel.fromId);
        if (TextUtils.isEmpty(this.aT.g()) || !valueOf.equals(this.aT.g())) {
            String h = this.aT.h();
            if (TextUtils.isEmpty(h)) {
                shapeTextView.setVisibility(8);
            } else {
                try {
                    if (Arrays.asList(h.split(",")).contains(valueOf)) {
                        GroupUtil.a((TextView) shapeTextView, 2);
                    } else {
                        shapeTextView.setVisibility(8);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    shapeTextView.setVisibility(8);
                }
            }
        } else {
            GroupUtil.a((TextView) shapeTextView, 1);
        }
        view2.setVisibility(8);
    }

    private void a(final ChattingModel chattingModel, View view, short s, int i) {
        TextView textView = (TextView) view.findViewById(R.id.tv_continue);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_view);
        ImageView imageView = (ImageView) view.findViewById(2131365504);
        textView2.setVisibility(8);
        r(chattingModel, view);
        MsgExtraGift msgExtraGift = (MsgExtraGift) AppInfo.f().fromJson(chattingModel.getMsgExtra(), (Class<Object>) MsgExtraGift.class);
        if (!TextUtils.isEmpty(chattingModel.getMsgExtra()) && msgExtraGift != null && msgExtraGift.gift_like != null) {
            ((RelativeLayout) view.findViewById(R.id.chat_content_in)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (MessageChatAdapter.this.aV == null || MessageChatAdapter.this.aV.i == null) {
                        return;
                    }
                    MessageChatAdapter.this.aV.i.a(chattingModel);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.26
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (MessageChatAdapter.this.aV == null || MessageChatAdapter.this.aV.i == null) {
                        return;
                    }
                    MessageChatAdapter.this.aV.i.a(chattingModel);
                }
            });
            if (msgExtraGift.gift_like.giftTye == 3) {
                textView2.setVisibility(0);
            }
            ((TextView) view.findViewById(2131371186)).setText(UserPagerGiftManager.a(i == 1, msgExtraGift, this.b, chattingModel.fromNickName));
            ImageLoader.a(c(), msgExtraGift.gift_like.img_url).a(imageView);
        }
        if (i == 1) {
            textView.setText(this.b.getResources().getString(R.string.msg_give_return));
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                MessageChatAdapter.this.aU.y();
            }
        });
        if (chattingModel.isFromSelf()) {
            TextView textView3 = (TextView) view.findViewById(R.id.tv_state);
            TextView textView4 = (TextView) view.findViewById(R.id.tv_read);
            if (chattingModel.msgStateCode != 3) {
                textView4.setVisibility(8);
                return;
            }
            textView4.setVisibility(0);
            textView3.setVisibility(8);
            if (msgExtraGift == null || msgExtraGift.gift_like == null || msgExtraGift.gift_like.cardGift == null) {
                textView4.setText(this.b.getString(R.string.msg_gift_read));
            } else {
                textView4.setText(this.b.getString(R.string.msg_card_read));
            }
        }
    }

    private void a(final ChattingModel chattingModel, ImageView imageView, ImageView imageView2) {
        this.aO.c = AvatarUtils.a(0, GroupUtil.a(chattingModel, this.aT.c(), this.aT.d()));
        if (imageView == null) {
            return;
        }
        ImageWrapper c2 = ImageLoader.a(c(), AvatarUtils.a(1, GroupUtil.a(chattingModel, this.aT.c(), this.aT.d()))).c();
        if (chattingModel.isMatchMsg != 1 || chattingModel.isFromSelf()) {
            c2.b(2131237310);
        } else {
            c2.a(100).b((int) R.drawable.user_bg_round_blur);
        }
        c2.a(imageView);
        imageView.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.108
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (chattingModel.isMatchMsg == 1 && !chattingModel.isFromSelf()) {
                    ToastUtils.b((int) R.string.date_today_header_clicked);
                } else if (MessageChatAdapter.this.aV == null || MessageChatAdapter.this.aV.h == null) {
                } else {
                    if (!MessageChatAdapter.this.aT.c() || MessageChatAdapter.this.aV.h.m() == null || MessageChatAdapter.this.aV.h.m().event == null) {
                        MessageChatAdapter.this.aV.h.b(chattingModel, MessageChatAdapter.this.e);
                        return;
                    }
                    EventLogData eventLogData = new EventLogData();
                    eventLogData.setEventId(MessageChatAdapter.this.aV.h.f18842a.activity_id);
                    eventLogData.setUid(String.valueOf(chattingModel.fromId));
                    eventLogData.setSourcePage(FeedProtos.SourcePage.ACTIVITY_GROUP);
                    EventUserInfoDlgFragment.a.a(MessageChatAdapter.this.aV.getParentFragmentManager(), String.valueOf(chattingModel.fromId), MessageChatAdapter.this.aV.h.f18842a.activity_id, eventLogData);
                }
            }
        }));
        if (this.aT.c() && IMV4Method.a(chattingModel.fromId) == 1) {
            imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.109
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    try {
                        if (TextUtils.isEmpty(chattingModel.fromNickName)) {
                            return true;
                        }
                        if (MessageChatAdapter.this.aM != null && MessageChatAdapter.this.aU.getActivity() != null && MessageChatAdapter.this.aU.w() != null) {
                            UserBasicModel userBasicModel = new UserBasicModel();
                            userBasicModel.uid = String.valueOf(chattingModel.fromId);
                            userBasicModel.name = chattingModel.fromNickName;
                            userBasicModel.avatar = GroupUtil.a(chattingModel, MessageChatAdapter.this.aT.c(), MessageChatAdapter.this.aT.d());
                            MessageChatAdapter.this.aM.a(MessageChatAdapter.this.aU.w(), userBasicModel, MessageChatAdapter.this.aN, false);
                        }
                        MessageChatAdapter.this.aU.x();
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return true;
                    }
                }
            });
        }
        UserInfoHelper.a(imageView2, chattingModel.fromVBadge, 3);
    }

    private void a(ChattingModel chattingModel, TextView textView) {
        DialogUtils.b(this.aL);
        if (textView != null) {
            MessageChatMethod.a(chattingModel.isFromSelf(), chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgStateCode, textView, chattingModel.fromNickName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ChattingModel chattingModel, final TextView textView, final int i) {
        if (chattingModel == null) {
            return;
        }
        if (!this.aT.c()) {
            InstantLog.a("private_chat_option_show");
        }
        final String str = chattingModel.msgContent;
        final String str2 = chattingModel.msgTextTranslateContent;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String string = TextUtils.isEmpty(str2) ? this.b.getResources().getString(R.string.biao_msg_content_translate) : chattingModel.msgTextTranslateIsShow == 1 ? this.b.getResources().getString(R.string.biao_msg_content_translate_ori) : this.b.getResources().getString(R.string.biao_msg_content_translate);
        CommonAlertDialog.a(this.b, "", chattingModel.fromId == Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue() ? chattingModel.msgLocalId == 0 ? MessageChatMethod.a(chattingModel, this.aT) ? new String[]{this.b.getResources().getString(R.string.common_copy), string, this.b.getString(R.string.retraction), this.b.getString(R.string.msg_pop_custom_bubble)} : new String[]{this.b.getResources().getString(R.string.common_copy), string, this.b.getString(R.string.msg_pop_custom_bubble)} : new String[]{this.b.getResources().getString(R.string.common_copy), string} : this.k != null ? new String[]{this.b.getResources().getString(R.string.common_copy), string, this.b.getResources().getString(R.string.common_report), this.b.getString(R.string.msg_pop_custom_bubble)} : new String[]{this.b.getResources().getString(R.string.common_copy), string, this.b.getResources().getString(R.string.common_report)}, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.105
            void a() {
                MessageProtos.Event event = MessageProtos.Event.MSG_CLICK_BUBBLE_CLICK;
                EventTrackMessage.a(event, (MessageProtos.StrangerSource) null, chattingModel.fromId + "");
                VipBubbleFragment.a(MessageChatAdapter.this.b, 0, chattingModel.isFromSelf() ? "chat_msg_bubble_owner" : "chat_msg_bubble_guest");
            }

            void b() {
                String str3;
                if (chattingModel.msgTextTranslateIsShow != 1) {
                    str3 = str;
                } else if (TextUtils.isEmpty(str2)) {
                    str3 = str;
                } else {
                    str3 = str + "\n\n" + str2;
                }
                FileUtils.a(MessageChatAdapter.this.b, str3);
            }

            void c() {
                MessageChatMethod.a(MessageChatAdapter.this.b, chattingModel, MessageChatAdapter.this.f18271a, MessageChatAdapter.this.aT, MessageChatAdapter.this.aU);
            }

            void d() {
                if (TextUtils.isEmpty(str2)) {
                    MessageChatAdapter.this.c(str, chattingModel);
                } else if (chattingModel.msgTextTranslateIsShow == 1) {
                    MessageChatAdapter.this.f(chattingModel);
                } else {
                    MessageChatAdapter.this.e(chattingModel);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Tracker.onClick(dialogInterface, i2);
                if (!chattingModel.isFromSelf()) {
                    if (i2 == 0) {
                        b();
                    } else if (i2 == 1) {
                        d();
                    } else if (i2 == 2) {
                        c();
                    } else if (i2 != 3) {
                    } else {
                        a();
                    }
                } else if (i2 == 0) {
                    b();
                } else if (i2 == 1) {
                    d();
                } else if (i2 != 2) {
                    if (i2 != 3) {
                        return;
                    }
                    a();
                } else if (MessageChatMethod.a(chattingModel, MessageChatAdapter.this.aT)) {
                    MessageChatMethod.a(MessageChatAdapter.this.b, chattingModel, MessageChatAdapter.this.aT);
                } else {
                    a();
                }
            }
        }, new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.106
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MessageChatAdapter.this.a(textView, chattingModel.msgContent, i, new boolean[0]);
            }
        });
    }

    private void a(ChattingModel chattingModel, TextView textView, ImageView imageView, ImageView imageView2) {
        if (imageView == null || imageView2 == null) {
            return;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        if (textView == null || animationDrawable == null) {
            return;
        }
        if (this.aT.c()) {
            short s = chattingModel.msgStateCode;
            if (s == 1) {
                textView.setVisibility(4);
                imageView.setVisibility(0);
                animationDrawable.start();
                imageView2.setVisibility(8);
            } else if (s != 6) {
                textView.setVisibility(4);
                imageView.setVisibility(4);
                animationDrawable.stop();
                imageView2.setVisibility(8);
            } else {
                imageView.setVisibility(8);
                animationDrawable.stop();
                textView.setVisibility(4);
                imageView2.setVisibility(0);
            }
        } else {
            textView.setTextColor(this.b.getResources().getColor(2131100365));
            short s2 = chattingModel.msgStateCode;
            if (s2 == 1) {
                textView.setVisibility(4);
                imageView.setVisibility(0);
                animationDrawable.start();
                imageView2.setVisibility(8);
            } else if (s2 == 2) {
                imageView.setVisibility(4);
                animationDrawable.stop();
                textView.setVisibility(0);
                textView.setText(b(chattingModel.msgStateCode));
                imageView2.setVisibility(8);
            } else if (s2 == 3) {
                imageView.setVisibility(4);
                animationDrawable.stop();
                textView.setVisibility(0);
                textView.setText(b(chattingModel.msgStateCode));
                imageView2.setVisibility(8);
            } else if (s2 != 6) {
                textView.setVisibility(4);
                imageView.setVisibility(4);
                animationDrawable.stop();
                imageView2.setVisibility(8);
            } else {
                imageView.setVisibility(8);
                animationDrawable.stop();
                textView.setVisibility(4);
                imageView2.setVisibility(0);
            }
        }
        if (chattingModel.msgType == 256) {
            textView.setVisibility(8);
            if (imageView.getVisibility() == 4) {
                imageView.setVisibility(8);
            }
        }
    }

    private void a(final ChattingModel chattingModel, final MsgExtraForTextTypeEntity.SecureNotify secureNotify, View view) {
        if (TextUtils.isEmpty(secureNotify.title) && TextUtils.isEmpty(secureNotify.link_title)) {
            return;
        }
        if (!this.ba.contains(Long.valueOf(chattingModel.msgId))) {
            this.ba.add(Long.valueOf(chattingModel.msgId));
            MessageProtos.Event event = MessageProtos.Event.MSG_SENSITIVE_SHOW;
            EventTrackMessage.e(event, this.aT.f() + "");
        }
        view.setVisibility(0);
        TextView textView = (TextView) view.findViewById(R.id.sensitive_word_safe_title);
        ImageView imageView = (ImageView) view.findViewById(R.id.sensitive_word_img_safe);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_report);
        TextView textView3 = (TextView) view.findViewById(R.id.tv_link);
        View findViewById = view.findViewById(2131366859);
        TextView textView4 = (TextView) view.findViewById(2131371186);
        if (TextUtils.isEmpty(secureNotify.icon)) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
        if (TextUtils.isEmpty(secureNotify.title)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(secureNotify.title);
        }
        if (TextUtils.isEmpty(secureNotify.link_title) || TextUtils.isEmpty(secureNotify.link)) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(secureNotify.link_title);
            textView3.setVisibility(0);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.87
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    WebViewShowInfoFragment.show(MessageChatAdapter.this.b, secureNotify.link, -1);
                    if (secureNotify.link_title.toUpperCase().contains("HIV")) {
                        MessageProtos.Event event2 = MessageProtos.Event.MSG_SENSITIVE_HIV_CLICK;
                        EventTrackMessage.e(event2, MessageChatAdapter.this.aT.f() + "");
                        return;
                    }
                    MessageProtos.Event event3 = MessageProtos.Event.MSG_SENSITIVE_CASE_CLICK;
                    EventTrackMessage.e(event3, MessageChatAdapter.this.aT.f() + "");
                }
            });
        }
        if (TextUtils.isEmpty(secureNotify.report_title)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(secureNotify.report_title);
            textView2.setVisibility(0);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.88
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    Context context = MessageChatAdapter.this.b;
                    List<E> list = MessageChatAdapter.this.f18271a;
                    ChattingModel chattingModel2 = chattingModel;
                    MsgCommonUtils.a(context, list, chattingModel2, MessageChatAdapter.this.aT.f() + "", 6, 0, MessageChatAdapter.this.aU.getFragmentActive());
                }
            });
        }
        if (textView2.getVisibility() == 0 && textView3.getVisibility() == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        if (secureNotify.multi_contents == null || secureNotify.multi_contents.size() <= 0) {
            textView4.setVisibility(8);
            return;
        }
        textView4.setVisibility(0);
        textView4.setText(StringUtils.a(secureNotify.multi_contents.get(0).body, secureNotify.highlight_keywords));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.chat.model.ChattingModel r6, com.soft.blued.ui.msg.model.ShareToMsgEntity r7, boolean r8) {
        /*
            r5 = this;
            r0 = r6
            boolean r0 = r0.isFromSelf()
            if (r0 == 0) goto L8
            return
        L8:
            r0 = r7
            int r0 = r0.share_from
            r9 = r0
            java.lang.String r0 = "feed_text_image"
            r10 = r0
            r0 = r9
            r1 = 4
            if (r0 == r1) goto L57
            r0 = r9
            r1 = 10
            if (r0 == r1) goto L4f
            r0 = r9
            r1 = 11
            if (r0 == r1) goto L47
            r0 = r9
            switch(r0) {
                case 13: goto L47;
                case 14: goto L47;
                case 15: goto L57;
                default: goto L44;
            }
        L44:
            goto Lb6
        L47:
            java.lang.String r0 = "circle"
            r10 = r0
            goto Lbb
        L4f:
            java.lang.String r0 = "topic"
            r10 = r0
            goto Lbb
        L57:
            r0 = r7
            com.soft.blued.ui.msg.model.ShareToMsgEntity r0 = r0.repost
            if (r0 == 0) goto L66
            java.lang.String r0 = "feed_forward"
            r10 = r0
            goto Lbb
        L66:
            r0 = r7
            int r0 = r0.type
            r1 = 3
            if (r0 != r1) goto L76
            java.lang.String r0 = "feed_vote"
            r10 = r0
            goto Lbb
        L76:
            r0 = r7
            int r0 = r0.type
            r1 = 2
            if (r0 != r1) goto L86
            java.lang.String r0 = "feed_flash"
            r10 = r0
            goto Lbb
        L86:
            r0 = r7
            int r0 = r0.type
            r1 = 1
            if (r0 != r1) goto L91
            goto Lbb
        L91:
            r0 = r7
            int r0 = r0.type
            if (r0 != 0) goto Lb6
            r0 = r7
            java.util.List<java.lang.String> r0 = r0.imageList
            if (r0 == 0) goto Lae
            r0 = r7
            java.util.List<java.lang.String> r0 = r0.imageList
            int r0 = r0.size()
            if (r0 <= 0) goto Lae
            goto Lbb
        Lae:
            java.lang.String r0 = "feed_text"
            r10 = r0
            goto Lbb
        Lb6:
            java.lang.String r0 = ""
            r10 = r0
        Lbb:
            r0 = r8
            if (r0 == 0) goto Lc7
            com.blued.das.message.MessageProtos$Event r0 = com.blued.das.message.MessageProtos.Event.MSG_SHARE_MSG_SHOW
            r11 = r0
            goto Lcc
        Lc7:
            com.blued.das.message.MessageProtos$Event r0 = com.blued.das.message.MessageProtos.Event.MSG_SHARE_MSG_CLICK
            r11 = r0
        Lcc:
            r0 = r11
            r1 = r6
            r2 = r10
            r3 = r7
            java.lang.String r3 = r3.gid
            com.soft.blued.log.track.EventTrackMessage.a(r0, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.adapter.MessageChatAdapter.a(com.blued.android.chat.model.ChattingModel, com.soft.blued.ui.msg.model.ShareToMsgEntity, boolean):void");
    }

    private void a(ChattingModel chattingModel, String str, View view, int i) {
        IMV4Method.a(chattingModel.fromId);
        ImageView imageView = (ImageView) view.findViewById(R.id.msg_burn_pic);
        TextView textView = (TextView) view.findViewById(R.id.msg_burn_pic_tv);
        if (imageView == null || textView == null) {
            return;
        }
        int i2 = 2131236355;
        if (TextUtils.isEmpty(str)) {
            textView.setText(R.string.biao_msg_burn_deleted);
            textView.setTextColor(SkinHelper.c(this.b));
            Context context = this.b;
            if (!BluedSkinUtils.c()) {
                i2 = 2131236356;
            }
            view.setBackground(context.getDrawable(i2));
            imageView.setImageResource(R.drawable.icon_destroy_msg_burn_received);
            return;
        }
        Context context2 = this.b;
        if (!BluedSkinUtils.c()) {
            i2 = 2131236356;
        }
        view.setBackground(context2.getDrawable(i2));
        textView.setTextColor(SkinHelper.a(this.b));
        textView.setText(R.string.biao_msg_burn_look);
        if (i == 1) {
            imageView.setImageResource(R.drawable.icon_msg_burn_photo);
        } else if (i != 2) {
        } else {
            imageView.setImageResource(R.drawable.icon_msg_burn_video);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ShareEventToMsgEntity shareEventToMsgEntity, View view) {
        Tracker.onClick(view);
        MsgChattingFragment msgChattingFragment = this.aV;
        if (msgChattingFragment == null || msgChattingFragment.h == null || this.aV.h.m() == null) {
            a(shareEventToMsgEntity.gid, FeedProtos.SourcePage.MSG_ACTIVITY);
        } else {
            a(shareEventToMsgEntity.gid, FeedProtos.SourcePage.GROUP_ACTIVITY);
        }
    }

    private void a(SelectFrameLayout selectFrameLayout, final View view, final TextView textView, final View view2, final ChattingModel chattingModel) {
        if (selectFrameLayout == null) {
            return;
        }
        selectFrameLayout.setTurnTextVisibility((Locale.getDefault().getLanguage().equals("en") || view.getVisibility() == 0) ? false : true);
        if (chattingModel.isFromSelf()) {
            selectFrameLayout.setRepostVisibility(false);
            selectFrameLayout.setBubbleVisibility(true);
        } else {
            selectFrameLayout.setRepostVisibility(true);
            selectFrameLayout.setBubbleVisibility(this.k != null);
        }
        boolean z = false;
        if (this.aT.c()) {
            z = false;
            if (chattingModel.msgLocalId == 0) {
                z = true;
            }
        }
        selectFrameLayout.setQuoteVisibility(z);
        selectFrameLayout.setRecallVisibility(MessageChatMethod.a(chattingModel, this.aT));
        selectFrameLayout.setSelectableItemOnClickListener(new SelectableItemOnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.42
            @Override // com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener
            public void a() {
                MessageChatMethod.a(MessageChatAdapter.this.b, chattingModel, MessageChatAdapter.this.aT);
            }

            @Override // com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener
            public void b() {
            }

            @Override // com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener
            public void c() {
                ChatManager.getInstance().sendReadReceipt(chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId);
                MessageChatMethod.a(view, textView, view2, chattingModel, MessageChatAdapter.this.aW, MessageChatAdapter.this.aU, MessageChatAdapter.this.c());
            }

            @Override // com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener
            public void d() {
                MessageChatMethod.a(MessageChatAdapter.this.b, chattingModel, MessageChatAdapter.this.f18271a, MessageChatAdapter.this.aT, MessageChatAdapter.this.aU);
            }

            @Override // com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener
            public void e() {
                MessageChatMethod.a(MessageChatAdapter.this.b, chattingModel);
            }

            @Override // com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener
            public void f() {
            }

            @Override // com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener
            public void g() {
                MessageChatMethod.b(chattingModel, MessageChatAdapter.this.aU);
            }
        });
        selectFrameLayout.setSelectableOnShowListener(new SelectableOnShowListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.43
            @Override // com.soft.blued.customview.selectabletextview.SelectableOnShowListener
            public void a() {
                if (MessageChatAdapter.this.aT.c()) {
                    return;
                }
                InstantLog.a("private_chat_option_show");
            }
        });
    }

    private void a(final SelectFrameLayout selectFrameLayout, final ChattingModel chattingModel) {
        if (selectFrameLayout == null) {
            return;
        }
        selectFrameLayout.setSelectableOnChangeListener(new SelectableOnChangeListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.44
            @Override // com.soft.blued.customview.selectabletextview.SelectableOnChangeListener
            public void a(CharSequence charSequence, boolean z) {
                if (z) {
                    selectFrameLayout.setCancelVisibility(true);
                } else {
                    selectFrameLayout.setCancelVisibility(false);
                }
            }
        });
        selectFrameLayout.setSelectableItemOnClickListener(new SelectableItemOnClickListener2() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.45
            @Override // com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener2, com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener
            public void f() {
                MessageChatAdapter.this.aW.remove(Long.valueOf(chattingModel.msgId));
                MessageChatMethod.a(selectFrameLayout, MessageChatAdapter.this.aU, chattingModel);
            }

            @Override // com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener
            public void g() {
            }
        });
        selectFrameLayout.setSelectableOnShowListener(new SelectableOnShowListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.46
            @Override // com.soft.blued.customview.selectabletextview.SelectableOnShowListener
            public void a() {
                if (MessageChatAdapter.this.aT.c()) {
                    return;
                }
                InstantLog.a("private_chat_option_show");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(FromFeedModel fromFeedModel, View view) {
        Tracker.onClick(view);
        if (fromFeedModel.is_bubble_ticktock == 1) {
            SignFeedListFragment.b.a(this.b, fromFeedModel.feedId, 8);
            return;
        }
        BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
        bluedIngSelfFeed.feed_id = fromFeedModel.feedId;
        FeedDetailsFragment.a(this.b, bluedIngSelfFeed, -1, new FeedDetailParams(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final MsgSourceEntity msgSourceEntity, View view, String str) {
        View a2 = ViewHolder.a(view, R.id.msg_source_layout);
        if (a2 != null) {
            if (msgSourceEntity == null) {
                a2.setVisibility(8);
                return;
            }
            TextView textView = (TextView) a2.findViewById(R.id.msg_source_title);
            String a3 = MsgCommonUtils.a(AppInfo.d(), msgSourceEntity.getType(), msgSourceEntity.getContent(), str);
            if (StringUtils.d(a3)) {
                a2.setVisibility(8);
                return;
            }
            a2.setVisibility(0);
            textView.setMovementMethod(ScrollingMovementMethod.getInstance());
            textView.setText(Html.fromHtml(a3));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.92
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    MsgCommonUtils.a(MessageChatAdapter.this.b, msgSourceEntity.getType(), msgSourceEntity.getContent());
                }
            });
            a2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.93
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    MsgCommonUtils.a(MessageChatAdapter.this.b, msgSourceEntity.getType(), msgSourceEntity.getContent());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2, String str3) {
        CommonAlertDialog.a(this.b, "解除关系", str3, "同意", new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                MessageChatAdapter.this.b(str, str2, "4");
                dialogInterface.cancel();
            }
        }, "拒绝", new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                MessageChatAdapter.this.b(str, str2, "3");
                dialogInterface.cancel();
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2, final String str3, final int i) {
        ChatHttpUtils.b(str, new BluedUIHttpResponse<BluedEntityA<RelationshipStatus>>() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.3
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<RelationshipStatus> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                RelationshipStatus relationshipStatus = (RelationshipStatus) bluedEntityA.getSingleData();
                if (relationshipStatus.getStatus() == 1 || relationshipStatus.getStatus() == 4 || relationshipStatus.getStatus() == 3) {
                    ToastUtils.a("您已经做过处理，无需重复处理");
                } else if (System.currentTimeMillis() / 1000 >= i) {
                    ToastUtils.a("抱歉，处理时效已过");
                } else {
                    MessageChatAdapter.this.a(str, str2, str3);
                }
            }
        });
    }

    private void a(List<String> list, LinearLayout linearLayout, FlowLayout flowLayout) {
        if (list == null || list.size() <= 0) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        flowLayout.removeAllViews();
        for (String str : list) {
            ShapeTextView inflate = View.inflate(this.b, R.layout.item_chat_date_today_ceil, null);
            ShapeHelper.b(inflate, (int) R.color.syc_bh);
            inflate.setText(str);
            flowLayout.addView(inflate);
        }
    }

    private void a(List<String> list, FlowLayout flowLayout) {
        if (list == null || list.size() <= 0) {
            flowLayout.setVisibility(8);
            return;
        }
        flowLayout.setVisibility(0);
        flowLayout.removeAllViews();
        for (String str : list) {
            TextView textView = (TextView) View.inflate(this.b, R.layout.item_chat_date_today_ceil, null);
            textView.setText(str);
            flowLayout.addView(textView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.aV.h != null) {
            this.aV.h.a("private_chatting_photo", z);
        }
    }

    private boolean a(ChattingModel chattingModel, String str) {
        String str2 = chattingModel.msgId + str;
        if (this.j.contains(str2)) {
            return false;
        }
        this.j.add(str2);
        return true;
    }

    private boolean a(List<String> list, TextView textView) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        String str = BlueAppLocal.d() ? "、" : ", ";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size() - 1) {
                sb.append(list.get(list.size() - 1));
                textView.setText(String.format(this.b.getString(R.string.date_today_both_want), new Object[0]) + sb.toString());
                return true;
            }
            sb.append(list.get(i2));
            sb.append(str);
            i = i2 + 1;
        }
    }

    private int b(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 6) {
                            return 0;
                        }
                        return R.string.state_fail;
                    }
                    return R.string.state_get;
                }
                return R.string.state_has_read;
            }
            return R.string.state_has_send;
        }
        return R.string.state_sending;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (r0[1] <= 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.blued.android.module.player.media.model.VideoPlayConfig b(final com.blued.android.chat.model.ChattingModel r10) {
        /*
            Method dump skipped, instructions count: 193
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.adapter.MessageChatAdapter.b(com.blued.android.chat.model.ChattingModel):com.blued.android.module.player.media.model.VideoPlayConfig");
    }

    private String b(MsgExtraForTextTypeEntity msgExtraForTextTypeEntity) {
        return (msgExtraForTextTypeEntity == null || TextUtils.isEmpty(msgExtraForTextTypeEntity.activity_work_id) || !msgExtraForTextTypeEntity.activity_work_id.contains(com.anythink.expressad.d.a.b.g)) ? "" : msgExtraForTextTypeEntity.activity_work_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str, ChattingModel chattingModel) {
        String str2 = str;
        if (str.contains("http")) {
            str2 = IMV4Method.a(chattingModel.sessionType, chattingModel.sessionId, str);
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00c0, code lost:
        if (r9.msgType == 3) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01a7, code lost:
        if (r7.k != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01fe, code lost:
        if (r0.getVisibility() == 0) goto L78;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.view.View r8, com.blued.android.chat.model.ChattingModel r9) {
        /*
            Method dump skipped, instructions count: 721
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.adapter.MessageChatAdapter.b(android.view.View, com.blued.android.chat.model.ChattingModel):void");
    }

    private void b(final ChattingModel chattingModel, View view) {
        boolean z;
        boolean z2;
        boolean z3;
        LinearLayout linearLayout = (LinearLayout) ViewHolder.a(view, R.id.ll_msg_bottom_tips_view);
        if (!TextUtils.isEmpty(chattingModel.promptType)) {
            String[] split = chattingModel.promptType.split(",");
            int length = split.length;
            int i = 0;
            boolean z4 = false;
            while (true) {
                z2 = z4;
                if (i >= length) {
                    z = false;
                    break;
                }
                String str = split[i];
                if (str.trim().equals("2")) {
                    z3 = true;
                } else {
                    z3 = z2;
                    if (str.trim().equals("3")) {
                        z = true;
                        break;
                    }
                }
                i++;
                z4 = z3;
            }
        } else {
            z = false;
            z2 = false;
        }
        if (linearLayout == null || !(z2 || z)) {
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                linearLayout.removeAllViews();
                return;
            }
            return;
        }
        linearLayout.setVisibility(0);
        linearLayout.removeAllViews();
        if (z2) {
            long G = BluedPreferences.G(chattingModel.sessionId);
            if (0 == G || chattingModel.msgId == G) {
                View inflate = LayoutInflater.from(this.b).inflate(R.layout.msg_bottom_tips_layout, (ViewGroup) null, false);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_msg_bottom_tips);
                BluedPreferences.b(chattingModel.sessionId, chattingModel.msgId);
                textView.setText(Html.fromHtml(this.b.getString(R.string.msg_special_care_to_3_days)));
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        MessageChatAdapter.this.aT.j();
                    }
                });
                linearLayout.addView(inflate);
            }
        }
        if (z) {
            String format = ((SimpleDateFormat) TimeAndDateUtils.a.get()).format(new Date(chattingModel.msgTimestamp));
            long c2 = BluedPreferences.c(format, chattingModel.sessionId);
            if (c2 < 0 || c2 == chattingModel.msgId) {
                if (a(chattingModel, MessageProtos.Event.MSG_PASS_BY_TIPS_SHOW.name())) {
                    EventTrackMessage.e(MessageProtos.Event.MSG_PASS_BY_TIPS_SHOW, chattingModel.sessionId + "");
                }
                BluedPreferences.a(format, chattingModel.sessionId, chattingModel.msgId);
                View inflate2 = LayoutInflater.from(this.b).inflate(R.layout.msg_bottom_tips_layout, (ViewGroup) null, false);
                TextView textView2 = (TextView) inflate2.findViewById(R.id.tv_msg_bottom_tips);
                textView2.setText(Html.fromHtml(this.b.getString(R.string.msg_map_chance_encounter_tips)));
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        MessageProtos.Event event = MessageProtos.Event.MSG_PASS_BY_TIPS_GO_CLICK;
                        EventTrackMessage.e(event, chattingModel.sessionId + "");
                        MessageChatAdapter.this.aT.k();
                    }
                });
                linearLayout.addView(inflate2);
            }
        }
    }

    private void b(final ChattingModel chattingModel, View view, int i) {
        if (view == null) {
            return;
        }
        ViewHolder.a(view, R.id.chat_content_in);
        final TextView textView = (TextView) ViewHolder.a(view, R.id.tv_message);
        TextView textView2 = (TextView) ViewHolder.a(view, R.id.tv_divider);
        LinearLayout linearLayout = (LinearLayout) ViewHolder.a(view, R.id.ll_see_details);
        TextView textView3 = (TextView) ViewHolder.a(view, R.id.translate_line);
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        if (TextUtils.isEmpty(chattingModel.msgContent)) {
            textView.setText(chattingModel.msgContent);
            return;
        }
        MsgExtraForTextTypeEntity msgExtraForTextTypeEntity = null;
        try {
            msgExtraForTextTypeEntity = (MsgExtraForTextTypeEntity) AppInfo.f().fromJson(chattingModel.getMsgExtra(), (Class<Object>) MsgExtraForTextTypeEntity.class);
        } catch (Exception e) {
        }
        String a2 = a(msgExtraForTextTypeEntity);
        final String b = b(msgExtraForTextTypeEntity);
        if (TextUtils.isEmpty(a2)) {
            a(textView, chattingModel.msgContent, i, true);
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        textView.setMovementMethod(LinkMovementClickMethod.a());
        textView.setText(TypefaceUtils.a(this.b, a2, chattingModel.fromVBadge == 3, new TypefaceUtils.ClickLinkListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.67
            @Override // com.soft.blued.utils.TypefaceUtils.ClickLinkListener
            public void a(String str) {
                EventTrackMessage.a(MessageProtos.Event.MSG_SERVICE_ACCOUNT_MSG_ONE_CLICK, chattingModel.fromId + "", chattingModel.msgId + "", str, "txt", 2, textView.getText().toString());
                EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_CLICK, str, b);
            }
        }));
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) Html.fromHtml(a2);
        Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class);
        String url = (spans.length == 0 || !(spans[0] instanceof URLSpan)) ? "" : ((URLSpan) spans[0]).getURL();
        if (!this.bb.contains(Long.valueOf(chattingModel.msgId))) {
            this.bb.add(Long.valueOf(chattingModel.msgId));
            EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_SHOW, url, b);
        }
        if (linearLayout != null) {
            int i2 = 8;
            if (spans.length == 1) {
                i2 = 0;
            }
            linearLayout.setVisibility(i2);
            final String str = url;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.68
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    WebViewShowInfoFragment.show(MessageChatAdapter.this.b, str, -1);
                    EventTrackMessage.a(MessageProtos.Event.MSG_SERVICE_ACCOUNT_MSG_ONE_CLICK, chattingModel.fromId + "", chattingModel.msgId + "", str, "txt", 3, textView.getText().toString());
                    EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_CLICK, str, b);
                }
            });
        }
    }

    private void b(final ChattingModel chattingModel, View view, int i, int i2) {
        boolean z;
        r(chattingModel, view);
        if (chattingModel.isFromSelf()) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.msg_item_root);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(2131363811);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_header);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_like);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_date_today_like);
        int i3 = i2;
        while (true) {
            int i4 = i3 + 1;
            z = false;
            if (i4 >= a().size()) {
                break;
            } else if (((ChattingModel) getItem(i4)).msgType == 288) {
                z = true;
                break;
            } else {
                i3 = i4;
            }
        }
        if (z) {
            imageView2.setImageResource(R.drawable.icon_date_today_heart_left_like_small);
        }
        ImageWrapper c2 = ImageLoader.a(c(), chattingModel.fromAvatar).b(chattingModel.isMatchMsg == 1 ? 2131237311 : 2131237310).c();
        if (chattingModel.isMatchMsg == 1) {
            c2.a(100);
        }
        c2.a(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.115
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (chattingModel.isMatchMsg == 1) {
                    MessageChatAdapter.this.aV.J();
                } else {
                    MessageChatAdapter.this.a(false);
                }
            }
        });
        final boolean z2 = z;
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.116
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (z2) {
                    return;
                }
                DateTodayManager.f18714a.a(MessageProtos.Event.MSG_MATCH_CHAT_PAGE_LIKE_CLICK);
                MessageChatAdapter.this.aV.h.k(true);
            }
        });
    }

    private void b(final ChattingModel chattingModel, View view, View view2) {
        TextView textView = (TextView) view.findViewById(R.id.tv_special_care_tips);
        textView.setText(Html.fromHtml(this.b.getString(R.string.msg_special_care_post_feed_tips)));
        String msgExtra = chattingModel.getMsgExtra();
        MessageProtos.Event event = MessageProtos.Event.MSG_SPECIAL_CARE_FEED_NOTICE_SHOW;
        EventTrackMessage.e(event, chattingModel.sessionId + "");
        if (TextUtils.isEmpty(msgExtra)) {
            return;
        }
        final FriendsNotificationExtra friendsNotificationExtra = (FriendsNotificationExtra) AppInfo.f().fromJson(msgExtra, (Class<Object>) FriendsNotificationExtra.class);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                if (friendsNotificationExtra.circle_id > 0) {
                    BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
                    bluedIngSelfFeed.feed_id = friendsNotificationExtra.circle_id + "";
                    FeedDetailsFragment.a(MessageChatAdapter.this.b, bluedIngSelfFeed, -1, new FeedDetailParams(0));
                    MessageProtos.Event event2 = MessageProtos.Event.MSG_SPECIAL_CARE_FEED_NOTICE_CLICK;
                    EventTrackMessage.e(event2, chattingModel.sessionId + "");
                }
            }
        });
    }

    private void b(final ChattingModel chattingModel, View view, short s, int i) {
        ((TextView) view.findViewById(R.id.tv_message)).setText(this.b.getResources().getString(R.string.msg_unlock_private_photo));
        if (i == 1) {
            ((TextView) view.findViewById(R.id.tv_view)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.28
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (MessageChatAdapter.this.aV != null && MessageChatAdapter.this.aV.h != null) {
                        UserInfoFragmentNew.a(MessageChatAdapter.this.b, MessageChatAdapter.this.aV.h.a(chattingModel, MessageChatAdapter.this.e), "private_chatting");
                        return;
                    }
                    Context context = MessageChatAdapter.this.b;
                    UserInfoFragmentNew.b(context, chattingModel.fromId + "", "private_chatting");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ChattingModel chattingModel, String str) {
        chattingModel.msgTextTranslateStatus = 2;
        chattingModel.msgTextTranslateIsShow = 1;
        chattingModel.msgTextTranslateContent = str;
        g(chattingModel);
    }

    private void b(final SelectFrameLayout selectFrameLayout, final ChattingModel chattingModel) {
        if (selectFrameLayout == null) {
            return;
        }
        boolean z = true;
        if (chattingModel.isFromSelf()) {
            selectFrameLayout.setRecallVisibility(MessageChatMethod.a(chattingModel, this.aT));
            selectFrameLayout.setTranslateVisibility(true);
            selectFrameLayout.setBubbleVisibility(true);
        } else {
            selectFrameLayout.setTranslateVisibility(true);
            selectFrameLayout.setRepostVisibility(true);
            if (this.k == null) {
                z = false;
            }
            selectFrameLayout.setBubbleVisibility(z);
        }
        selectFrameLayout.setSelectableOnChangeListener(new SelectableOnChangeListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.71
            @Override // com.soft.blued.customview.selectabletextview.SelectableOnChangeListener
            public void a(CharSequence charSequence, boolean z2) {
                if (!z2) {
                    selectFrameLayout.setSelectAllVisibility(true);
                    selectFrameLayout.setRecallVisibility(false);
                    selectFrameLayout.setTranslateVisibility(false);
                    selectFrameLayout.setRepostVisibility(false);
                    selectFrameLayout.setBubbleVisibility(false);
                    return;
                }
                selectFrameLayout.setSelectAllVisibility(false);
                if (chattingModel.isFromSelf()) {
                    selectFrameLayout.setTranslateVisibility(true);
                    selectFrameLayout.setRepostVisibility(false);
                    selectFrameLayout.setBubbleVisibility(true);
                } else {
                    selectFrameLayout.setRecallVisibility(false);
                    selectFrameLayout.setTranslateVisibility(true);
                    selectFrameLayout.setRepostVisibility(true);
                    selectFrameLayout.setBubbleVisibility(MessageChatAdapter.this.k != null);
                }
                selectFrameLayout.setRecallVisibility(MessageChatMethod.a(chattingModel, MessageChatAdapter.this.aT));
                selectFrameLayout.setQuoteVisibility(MessageChatAdapter.this.aT.c() && chattingModel.msgLocalId == 0);
            }
        });
        selectFrameLayout.setSelectableItemOnClickListener(new SelectableItemOnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.72
            @Override // com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener
            public void a() {
                MessageChatMethod.a(MessageChatAdapter.this.b, chattingModel, MessageChatAdapter.this.aT);
            }

            @Override // com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener
            public void b() {
                MessageChatMethod.a(chattingModel, MessageChatAdapter.this.aU);
            }

            @Override // com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener
            public void c() {
            }

            @Override // com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener
            public void d() {
                MessageChatMethod.a(MessageChatAdapter.this.b, chattingModel, MessageChatAdapter.this.f18271a, MessageChatAdapter.this.aT, MessageChatAdapter.this.aU);
            }

            @Override // com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener
            public void e() {
                MessageChatMethod.a(MessageChatAdapter.this.b, chattingModel);
            }

            @Override // com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener
            public void f() {
            }

            @Override // com.soft.blued.customview.selectabletextview.SelectableItemOnClickListener
            public void g() {
                MessageChatMethod.b(chattingModel, MessageChatAdapter.this.aU);
            }
        });
        selectFrameLayout.setSelectableOnShowListener(new SelectableOnShowListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.73
            @Override // com.soft.blued.customview.selectabletextview.SelectableOnShowListener
            public void a() {
                if (MessageChatAdapter.this.aT.c()) {
                    return;
                }
                InstantLog.a("private_chat_option_show");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3) {
        ChatHttpUtils.a(str, str2, str3, new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.6
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ListView c(View view) {
        if (view.getParent() != null) {
            return view.getParent() instanceof ListView ? (ListView) view.getParent() : c((View) view.getParent());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IRequestHost c() {
        MsgChattingFragment msgChattingFragment = this.aV;
        if (msgChattingFragment != null) {
            return msgChattingFragment.getFragmentActive();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, ChattingModel chattingModel) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (MessageChatMethod.a(chattingModel, this.aT)) {
            arrayList.add(this.b.getString(R.string.retraction));
        }
        if (this.aT.c()) {
            arrayList.add(this.b.getString(R.string.group_msg_quote));
        }
        if (MessageChatMethod.b(chattingModel, this.aT)) {
            arrayList.add(this.b.getString(R.string.common_report));
        }
        if (arrayList.size() == 0) {
            return;
        }
        a(view, arrayList, chattingModel);
    }

    private void c(ChattingModel chattingModel) {
        chattingModel.msgTextTranslateStatus = 1;
        chattingModel.msgTextTranslateIsShow = 0;
        g(chattingModel);
    }

    private void c(final ChattingModel chattingModel, View view) {
        TextView textView = (TextView) ViewHolder.a(view, 2131371675);
        String format = String.format(this.b.getString(R.string.msg_poke_hint), chattingModel.msgContent);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.b.getString(R.string.msg_poke_hint_link));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(StringUtils.a(format, arrayList, 2131101766, new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                MessageChatAdapter.this.aT.a(chattingModel);
            }
        }));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0336  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x03fa -> B:66:0x0315). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x03ff -> B:86:0x03c2). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(final com.blued.android.chat.model.ChattingModel r10, android.view.View r11, int r12) {
        /*
            Method dump skipped, instructions count: 1027
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.adapter.MessageChatAdapter.c(com.blued.android.chat.model.ChattingModel, android.view.View, int):void");
    }

    private void c(ChattingModel chattingModel, View view, View view2) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_privilege_source_tips);
        if (linearLayout != null) {
            String str = UserInfo.getInstance().getLoginUserInfo().uid;
            if (str.equals(chattingModel.fromId + "")) {
                linearLayout.setVisibility(8);
            } else {
                linearLayout.setVisibility(0);
            }
        }
    }

    private void c(final ChattingModel chattingModel, View view, short s, int i) {
        ((TextView) view.findViewById(R.id.tv_message)).setText(this.b.getResources().getString(R.string.msg_like_see_private_photo));
        if (i == 1) {
            final TextView textView = (TextView) view.findViewById(R.id.tv_agree);
            final TextView textView2 = (TextView) view.findViewById(R.id.tv_ignore);
            final LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_status);
            final TextView textView3 = (TextView) view.findViewById(R.id.tv_status);
            final ImageView imageView = (ImageView) view.findViewById(R.id.tv_message_translate_status_icon);
            String msgExtra = chattingModel.getMsgExtra();
            MsgPrivateImgApplyExtra msgPrivateImgApplyExtra = !TextUtils.isEmpty(msgExtra) ? (MsgPrivateImgApplyExtra) AppInfo.f().fromJson(msgExtra, (Class<Object>) MsgPrivateImgApplyExtra.class) : new MsgPrivateImgApplyExtra();
            if (msgPrivateImgApplyExtra.state == 0) {
                textView.setVisibility(0);
                textView2.setVisibility(0);
                linearLayout.setVisibility(8);
                final MsgPrivateImgApplyExtra msgPrivateImgApplyExtra2 = msgPrivateImgApplyExtra;
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.29
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        PersonalProfileProtos.Event event = PersonalProfileProtos.Event.APPLY_PHOTO_AGREE_CLICK;
                        EventTrackPersonalProfile.d(event, chattingModel.fromId + "");
                        MineHttpUtils.a(String.valueOf(chattingModel.fromId), "open", (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(MessageChatAdapter.this.aV.getFragmentActive()) { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.29.1
                            /* JADX INFO: Access modifiers changed from: protected */
                            /* renamed from: a */
                            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                                if (MessageChatAdapter.this.aV == null || MessageChatAdapter.this.aV.h == null) {
                                    return;
                                }
                                SessionModel M = MessageChatAdapter.this.aV.h.M();
                                ChatHelperV4.a().a(String.valueOf(chattingModel.fromId), chattingModel.fromNickName, chattingModel.fromAvatar, M.vBadge, M.vipGrade, M.vipAnnual, M.vipExpLvl, M.hideVipLook);
                                msgPrivateImgApplyExtra2.state = 1;
                                chattingModel.setMsgExtra(AppInfo.f().toJson(msgPrivateImgApplyExtra2));
                                ChatManager.getInstance().updateMsgOneData(chattingModel);
                                textView.setVisibility(8);
                                textView2.setVisibility(8);
                                linearLayout.setVisibility(0);
                                textView3.setText(MessageChatAdapter.this.b.getResources().getString(R.string.msg_approved));
                                imageView.setImageResource(R.drawable.icon_translate_done);
                            }

                            public void onUIFinish() {
                                super.onUIFinish();
                                DialogUtils.b(MessageChatAdapter.this.aV.b);
                            }

                            public void onUIStart() {
                                super.onUIStart();
                                DialogUtils.a(MessageChatAdapter.this.aV.b);
                            }
                        }, (IRequestHost) MessageChatAdapter.this.aV.getFragmentActive());
                    }
                });
                final MsgPrivateImgApplyExtra msgPrivateImgApplyExtra3 = msgPrivateImgApplyExtra;
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.30
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        msgPrivateImgApplyExtra3.state = 2;
                        chattingModel.setMsgExtra(AppInfo.f().toJson(msgPrivateImgApplyExtra3));
                        ChatManager.getInstance().updateMsgOneData(chattingModel);
                        textView.setVisibility(8);
                        textView2.setVisibility(8);
                        linearLayout.setVisibility(0);
                        textView3.setText(MessageChatAdapter.this.b.getResources().getString(R.string.msg_ignored));
                        imageView.setImageResource(R.drawable.icon_private_photo_ignore);
                        PersonalProfileProtos.Event event = PersonalProfileProtos.Event.APPLY_PHOTO_IGNORE_CLICK;
                        EventTrackPersonalProfile.d(event, chattingModel.fromId + "");
                    }
                });
                return;
            }
            textView.setVisibility(8);
            textView2.setVisibility(8);
            linearLayout.setVisibility(0);
            if (msgPrivateImgApplyExtra.state == 1) {
                textView3.setText(this.b.getResources().getString(R.string.msg_approved));
                imageView.setImageResource(R.drawable.icon_translate_done);
                return;
            }
            textView3.setText(this.b.getResources().getString(R.string.msg_ignored));
            imageView.setImageResource(R.drawable.icon_private_photo_ignore);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, final ChattingModel chattingModel) {
        String str2;
        if (TextUtils.isEmpty(str) || chattingModel == null) {
            return;
        }
        try {
            str2 = URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            str2 = "";
        }
        c(chattingModel);
        ChatHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<MsgContentTranslatedEntity>>() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.107

            /* renamed from: a  reason: collision with root package name */
            boolean f18311a;

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MsgContentTranslatedEntity> bluedEntityA) {
                MsgContentTranslatedEntity msgContentTranslatedEntity;
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || (msgContentTranslatedEntity = (MsgContentTranslatedEntity) bluedEntityA.data.get(0)) == null || msgContentTranslatedEntity.trans_result == null || msgContentTranslatedEntity.trans_result.size() <= 0) {
                    return;
                }
                String str3 = msgContentTranslatedEntity.trans_result.get(0).dst;
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                MessageChatAdapter.this.b(chattingModel, str3);
            }

            public boolean onUIFailure(int i, String str3) {
                this.f18311a = true;
                return super.onUIFailure(i, str3);
            }

            public void onUIFinish() {
                super.onUIFinish();
                if (this.f18311a) {
                    this.f18311a = false;
                    MessageChatAdapter.this.d(chattingModel);
                }
            }
        }, str2, (IRequestHost) this.aU.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        AppMethods.d((int) R.string.msg_toast_group_function_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, ChattingModel chattingModel) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (MessageChatMethod.a(chattingModel, this.aT)) {
            arrayList.add(this.b.getString(R.string.retraction));
        }
        if (this.aT.c()) {
            arrayList.add(this.b.getString(R.string.group_msg_quote));
        }
        arrayList.add(this.b.getString(R.string.common_report));
        a(view, arrayList, chattingModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ChattingModel chattingModel) {
        chattingModel.msgTextTranslateStatus = 0;
        chattingModel.msgTextTranslateIsShow = 0;
        g(chattingModel);
    }

    private void d(ChattingModel chattingModel, View view) {
        TextView textView = (TextView) ViewHolder.a(view, 2131371675);
        if (chattingModel.isFromSelf()) {
            textView.setText(this.b.getString(R.string.msg_poke_him));
        } else {
            textView.setText(this.b.getString(R.string.msg_poke_you));
        }
    }

    private void d(ChattingModel chattingModel, View view, View view2) {
        r(chattingModel, view);
        String msgExtra = chattingModel.getMsgExtra();
        if (TextUtils.isEmpty(msgExtra)) {
            return;
        }
        Logger.b("直播分享extraJson==", msgExtra);
        try {
            final LiveMsgShareEntity liveMsgShareEntity = (LiveMsgShareEntity) AppInfo.f().fromJson(msgExtra, (Class<Object>) LiveMsgShareEntity.class);
            if (liveMsgShareEntity == null) {
                return;
            }
            MessageProtos.Event event = MessageProtos.Event.MSG_YY_OPEN_SHOW;
            String str = "";
            if (liveMsgShareEntity.session_id != 0) {
                str = "" + liveMsgShareEntity.session_id;
            }
            EventTrackMessage.c(event, str, liveMsgShareEntity.room_id, liveMsgShareEntity.uid);
            ShapeTextView a2 = ViewHolder.a(view, R.id.stv_room_tag);
            ImageView imageView = (ImageView) ViewHolder.a(view, R.id.iv_room_pic);
            Space space = (Space) ViewHolder.a(view, R.id.space_room_name);
            TextView textView = (TextView) ViewHolder.a(view, R.id.tv_room_name);
            ImageView imageView2 = (ImageView) ViewHolder.a(view, R.id.iv_room_level_pic);
            TextView textView2 = (TextView) ViewHolder.a(view, R.id.tv_room_desc);
            if (!TextUtils.isEmpty(liveMsgShareEntity.room_tag)) {
                YyChatRoomTagShapeUtils.a.a(a2, liveMsgShareEntity.room_type_id);
                a2.setText(liveMsgShareEntity.room_tag);
            }
            ImageLoader.a(c(), liveMsgShareEntity.pic_url).b(2131237310).c().a(imageView);
            if (!TextUtils.isEmpty(liveMsgShareEntity.room_name)) {
                Rect rect = new Rect();
                textView.getPaint().getTextBounds(liveMsgShareEntity.room_name, 0, liveMsgShareEntity.room_name.length(), rect);
                int width = rect.width();
                ViewGroup.LayoutParams layoutParams = space.getLayoutParams();
                if (width <= DensityUtil.a(76.0f)) {
                    layoutParams.width = DensityUtil.a(36.0f);
                } else if (width < DensityUtil.a(112.0f)) {
                    layoutParams.width = DensityUtil.a(112.0f) - width;
                } else {
                    layoutParams.width = 0;
                }
                space.setLayoutParams(layoutParams);
                textView.setText(liveMsgShareEntity.room_name);
            }
            if (!TextUtils.isEmpty(liveMsgShareEntity.room_level_img)) {
                ImageLoader.a(c(), liveMsgShareEntity.room_level_img).a(imageView2);
            }
            if (!TextUtils.isEmpty(liveMsgShareEntity.room_describe)) {
                textView2.setText(liveMsgShareEntity.room_describe);
            }
            view.findViewById(R.id.chat_content_in).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    if (LiveFloatManager.a().x()) {
                        AppMethods.a(MessageChatAdapter.this.b.getString(R.string.yy_living_toast));
                        return;
                    }
                    MessageProtos.Event event2 = MessageProtos.Event.MSG_YY_OPEN_CLICK;
                    String str2 = "";
                    if (liveMsgShareEntity.session_id != 0) {
                        str2 = "" + liveMsgShareEntity.session_id;
                    }
                    EventTrackMessage.c(event2, str2, liveMsgShareEntity.room_id, liveMsgShareEntity.uid);
                    YYRoomInfoManager.e().a(MessageChatAdapter.this.b, liveMsgShareEntity.room_id, "yy_open_msg");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        LiveEventBus.get(EventBusConstant.KEY_EVENT_KEEP_SCREEN).post(new KeepScreenEvent(true));
        this.g.b(this.i);
        this.g.a(new MediaPlayer.OnCompletionListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.47
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                LiveEventBus.get(EventBusConstant.KEY_EVENT_KEEP_SCREEN).post(new KeepScreenEvent(false));
                LiveFloatManager.a().i();
                MessageChatAdapter.this.h = "";
                MessageChatAdapter.this.notifyDataSetChanged();
                MediaUtils.a().a(2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ChattingModel chattingModel) {
        chattingModel.msgTextTranslateIsShow = 1;
        g(chattingModel);
    }

    private void e(final ChattingModel chattingModel, View view) {
        r(chattingModel, view);
        if (TextUtils.isEmpty(chattingModel.msgContent)) {
            return;
        }
        final TextView textView = (TextView) ViewHolder.a(view, R.id.tv_hi);
        textView.setText(ChatUtils.a(chattingModel.isFromSelf(), chattingModel.msgContent));
        textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.12
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                MessageChatAdapter.this.c(textView, chattingModel);
                return true;
            }
        });
    }

    private void e(final ChattingModel chattingModel, View view, final View view2) {
        final MsgExtra msgExtra;
        ImageView imageView = (ImageView) view2.findViewById(R.id.iv_header);
        TextView textView = (TextView) view2.findViewById(2131372754);
        TextView textView2 = (TextView) view2.findViewById(R.id.tv_desc);
        r(chattingModel, view);
        try {
            if (TextUtils.isEmpty(chattingModel.getMsgExtra()) || (msgExtra = (MsgExtra) AppInfo.f().fromJson(chattingModel.getMsgExtra(), (Class<Object>) MsgExtra.class)) == null) {
                return;
            }
            ImageLoader.a(c(), msgExtra.getGroups_avatar()).c().a(imageView);
            textView.setText(msgExtra.getGroups_name());
            textView2.setText(msgExtra.getGroups_description());
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    if (BluedConstant.f14549a) {
                        MessageChatAdapter.this.d();
                    } else {
                        com.soft.blued.ui.msg_group.fragment.GroupInfoFragment.a(MessageChatAdapter.this.b, msgExtra.getGroups_gid(), null, SocialNetWorkProtos.SourceType.MESSAGE);
                    }
                }
            });
            view2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.16
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view3) {
                    if (BluedConstant.f14549a) {
                        MessageChatAdapter.this.d();
                        return false;
                    }
                    MessageChatAdapter.this.c(view2, chattingModel);
                    return false;
                }
            });
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ChattingModel chattingModel) {
        chattingModel.msgTextTranslateIsShow = 0;
        g(chattingModel);
    }

    private void f(ChattingModel chattingModel, View view) {
        try {
            final FromFeedModel fromFeedModel = (FromFeedModel) AppInfo.f().fromJson(chattingModel.msgContent, (Class<Object>) FromFeedModel.class);
            View findViewById = view.findViewById(R.id.view_anony);
            ImageView imageView = (ImageView) view.findViewById(2131365719);
            TextView textView = (TextView) view.findViewById(2131371186);
            TextView textView2 = (TextView) view.findViewById(R.id.item_chat_anonymous_from_tv);
            if (fromFeedModel.is_bubble_ticktock == 1) {
                textView2.setText(R.string.super_topic_from_sign);
                if (TextUtils.isEmpty(this.aV.h.f18842a.bubble_exhibition_img)) {
                    imageView.setVisibility(8);
                    textView.setVisibility(0);
                    textView.setText(fromFeedModel.text);
                } else {
                    imageView.setVisibility(0);
                    ImageLoader.a(c(), fromFeedModel.pic).a(imageView);
                    textView.setVisibility(8);
                }
            } else {
                textView.setText(fromFeedModel.text);
                textView2.setText(R.string.super_topic_from_anonymous);
                ImageLoader.a(c(), fromFeedModel.pic).a(imageView);
            }
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.-$$Lambda$MessageChatAdapter$LIDUY_xizBJ6WlRhfJ7IWXG7Kuk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MessageChatAdapter.this.a(fromFeedModel, view2);
                }
            });
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:132:0x05e4 -> B:43:0x0246). Please submit an issue!!! */
    private void f(ChattingModel chattingModel, View view, View view2) {
        int a2;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        IMsgChatAdapterCallback iMsgChatAdapterCallback;
        if (TextUtils.isEmpty(chattingModel.msgContent)) {
            return;
        }
        String[] split = chattingModel.msgContent.split(",,");
        if (split.length >= 2 && (a2 = StringUtils.a(split[1], 0)) != 0) {
            float f = (((a2 - 1) / 5) * 12.5f) + 90.0f;
            float f2 = f;
            if (f > 365.0f) {
                f2 = 365.0f;
            }
            r(chattingModel, view);
            TextView textView = (TextView) ViewHolder.a(view, R.id.chat_tv_time_audio);
            ImageView imageView = (ImageView) ViewHolder.a(view, R.id.voice_has_state);
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.width = DensityUtils.a(this.b, f2);
            layoutParams.height = -2;
            view2.setLayoutParams(layoutParams);
            if (textView != null) {
                textView.setText(a2 + "”");
            }
            a(chattingModel);
            String a3 = IMV4Method.a(chattingModel);
            SelectFrameLayout selectFrameLayout = (SelectFrameLayout) view.findViewById(R.id.select_layout);
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.rl_anim);
            ImageView imageView2 = (ImageView) view2.findViewById(R.id.chat_img_audio);
            ImageView imageView3 = (ImageView) view2.findViewById(R.id.chat_img_audio_custom);
            View findViewById = view.findViewById(R.id.msg_include_avatar_right);
            View findViewById2 = view.findViewById(R.id.msg_include_avatar_left);
            SelectFrameLayout selectFrameLayout2 = (SelectFrameLayout) view.findViewById(R.id.select_layout2);
            TextView textView2 = (TextView) view.findViewById(R.id.tv_turn_text);
            View findViewById3 = view.findViewById(R.id.view_process);
            if (chattingModel.msgTextTranslateIsShow == 1 && this.aW.contains(Long.valueOf(chattingModel.msgId))) {
                selectFrameLayout2.setVisibility(0);
                textView2.setText(chattingModel.msgTextTranslateContent);
            } else {
                selectFrameLayout2.setVisibility(8);
            }
            VipBubbleModel c2 = VipBubbleManager.a().c();
            if (chattingModel.isFromSelf()) {
                if (findViewById != null) {
                    marginLayoutParams2 = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
                    marginLayoutParams2.topMargin = (int) this.b.getResources().getDimension(R.dimen.msg_item_header_margin_top);
                } else {
                    marginLayoutParams2 = null;
                }
                imageView3.setImageResource(R.drawable.voice_right_play);
                textView.setTextColor(ContextCompat.getColor(this.b, 2131102478));
                VipBubbleManager.a().a(1, 1, view2);
                VipBubbleManager.a().a(0, 1, selectFrameLayout2);
                if (textView2 != null) {
                    textView2.setTextColor(ContextCompat.getColor(this.b, 2131101780));
                }
                if (c2 != null && (iMsgChatAdapterCallback = this.aT) != null && !iMsgChatAdapterCallback.c()) {
                    if (marginLayoutParams2 != null) {
                        marginLayoutParams2.topMargin = (int) this.b.getResources().getDimension(R.dimen.msg_item_header_vip_bubble_margin_top);
                    }
                    ImageLoader.a(c(), c2.voice_right_default).d((int) R.drawable.voice_right_play).f().a(imageView3);
                    try {
                        textView.setTextColor(Color.parseColor(c2.text_color));
                        textView2.setTextColor(Color.parseColor(c2.text_color));
                    } catch (Throwable th) {
                    }
                    VipBubbleManager.a().a(c2, 1, view2);
                    VipBubbleManager.a().a(c2, 1, selectFrameLayout2);
                }
                if (findViewById != null && marginLayoutParams2 != null) {
                    findViewById.setLayoutParams(marginLayoutParams2);
                }
            } else if (!chattingModel.isFromSelf()) {
                if (findViewById2 != null) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById2.getLayoutParams();
                    marginLayoutParams.topMargin = (int) this.b.getResources().getDimension(R.dimen.msg_item_header_margin_top);
                } else {
                    marginLayoutParams = null;
                }
                imageView3.setImageResource(R.drawable.voice_left_play);
                textView.setTextColor(SkinHelper.a(this.b));
                VipBubbleManager.a().a(1, 0, view2);
                VipBubbleManager.a().a(0, 0, selectFrameLayout2);
                if (this.k != null) {
                    if (marginLayoutParams != null) {
                        marginLayoutParams.topMargin = (int) this.b.getResources().getDimension(R.dimen.msg_item_header_vip_bubble_margin_top);
                    }
                    try {
                        textView.setTextColor(Color.parseColor(this.k.text_color));
                        textView2.setTextColor(Color.parseColor(this.k.text_color));
                    } catch (Throwable th2) {
                    }
                    ImageLoader.a(c(), this.k.voice_left_default).d((int) R.drawable.voice_left_play).a(imageView3);
                    VipBubbleManager.a().a(this.k, 0, view2);
                    VipBubbleManager.a().b(this.k, 0, selectFrameLayout2);
                }
                if (findViewById2 != null && marginLayoutParams != null) {
                    findViewById2.setLayoutParams(marginLayoutParams);
                }
            }
            if (!TextUtils.isEmpty(this.h) && this.h.equals(a3)) {
                imageView3.setTag(true);
                if (chattingModel.isFromSelf()) {
                    if (c2 != null) {
                        ImageLoader.a(c(), c2.voice_right_gift).d((int) R.drawable.voice_right_play).g().g(-1).a(imageView3);
                    } else {
                        ImageLoader.c(c(), "voice_right_play_anim.png").d((int) R.drawable.voice_right_play).g().g(-1).a(imageView3);
                    }
                    imageView3.setTag(true);
                } else if (!chattingModel.isFromSelf()) {
                    if (this.k != null) {
                        ImageLoader.a(c(), this.k.voice_left_gift).d((int) R.drawable.voice_left_play).g().g(-1).a(imageView3);
                    } else {
                        ImageLoader.c(c(), BluedSkinUtils.c() ? "voice_left_play_anim.png" : "voice_left_play_anim_dark.png").d((int) R.drawable.voice_left_play).g().g(-1).a(imageView3);
                    }
                }
            } else if (imageView3.getTag() != null && ((Boolean) imageView3.getTag()).booleanValue()) {
                imageView3.setTag(false);
                if (IMV4Method.a(chattingModel.fromId) == 1) {
                    if (this.k != null) {
                        ImageLoader.a(c(), this.k.voice_left_default).d((int) R.drawable.voice_left_play).a(imageView3);
                    } else {
                        imageView3.setImageResource(R.drawable.voice_left_play);
                    }
                } else if (c2 != null) {
                    ImageLoader.a(c(), c2.voice_right_default).d((int) R.drawable.voice_right_play).a(imageView3);
                } else {
                    imageView3.setImageResource(R.drawable.voice_right_play);
                }
            }
            view2.setTag(chattingModel);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    if (AudioChannelManager.j().n()) {
                        AppMethods.a(MessageChatAdapter.this.b.getResources().getText(R.string.yy_in_use));
                        return;
                    }
                    ChattingModel chattingModel2 = (ChattingModel) view3.getTag();
                    if (MessageChatAdapter.this.a(chattingModel2)) {
                        String a4 = IMV4Method.a(chattingModel2);
                        MessageChatAdapter messageChatAdapter = MessageChatAdapter.this;
                        messageChatAdapter.i = messageChatAdapter.b(a4, chattingModel2);
                        if (MessageChatAdapter.this.f()) {
                            MessageChatAdapter.this.g.b();
                            LiveEventBus.get(EventBusConstant.KEY_EVENT_KEEP_SCREEN).post(new KeepScreenEvent(false));
                            if (MessageChatAdapter.this.h.equals(a4)) {
                                MessageChatAdapter.this.h = "";
                                MessageChatAdapter.this.notifyDataSetChanged();
                                return;
                            }
                        }
                        MessageChatAdapter.this.h = a4;
                        MessageChatAdapter.this.e();
                        if (IMV4Method.a(chattingModel2.fromId) == 1 && chattingModel2.msgStateCode != 5) {
                            ChatManager.getInstance().sendReadReceipt(chattingModel2.sessionType, chattingModel2.sessionId, chattingModel2.msgId);
                            ChatManager.getInstance().updateMsgState(chattingModel2, (short) 5);
                        }
                        if (MessageChatAdapter.this.aU != null) {
                            MessageChatAdapter.this.aU.u();
                        }
                        MessageChatAdapter.this.notifyDataSetChanged();
                    }
                }
            });
            if (imageView != null && IMV4Method.a(chattingModel.fromId) == 1) {
                if (chattingModel.msgStateCode != 5) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
            }
            if (BluedPreferences.ef()) {
                BluedPreferences.eg();
                View inflate = View.inflate(this.b, R.layout.pop_guide, null);
                TextView textView3 = (TextView) inflate.findViewById(R.id.tv_guide);
                textView3.setBackgroundResource(2131232902);
                textView3.setText(R.string.turn_text_pop);
                final BluedPopupWindow a4 = BluedPopupWindow.Builder.a((Activity) this.b, inflate).a(true).a();
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.40
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Tracker.onClick(view3);
                        a4.dismiss();
                    }
                });
                a4.a(selectFrameLayout, 1, 0, 0, 0);
                inflate.postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.41
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (a4.isShowing()) {
                                a4.dismiss();
                            }
                        } catch (Throwable th3) {
                        }
                    }
                }, m.ag);
            }
            a(selectFrameLayout, selectFrameLayout2, textView2, findViewById3, chattingModel);
            a(selectFrameLayout2, chattingModel);
            String msgExtra = chattingModel.getMsgExtra();
            if (TextUtils.isEmpty(msgExtra) || chattingModel.msgId != 1 || chattingModel.isFromSelf()) {
                return;
            }
            try {
                MsgAudioExtra msgAudioExtra = (MsgAudioExtra) AppInfo.f().fromJson(msgExtra, (Class<Object>) MsgAudioExtra.class);
                if (msgAudioExtra == null || msgAudioExtra.msgSource == null) {
                    return;
                }
                if (BluedConfig.a().r() || msgAudioExtra.msgSource.getType() == MessageProtos.StrangerSource.SHADOW_SOURCE) {
                    a(msgAudioExtra.msgSource, view, String.valueOf(chattingModel.fromId));
                }
            } catch (Throwable th3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return !TextUtils.isEmpty(this.h);
    }

    private void g(ChattingModel chattingModel) {
        ChatManager.getInstance().updateMsgOneData(chattingModel);
        IMsgChatAdapterOperationCallback iMsgChatAdapterOperationCallback = this.aU;
        if (iMsgChatAdapterOperationCallback != null) {
            iMsgChatAdapterOperationCallback.t();
        }
    }

    private void g(ChattingModel chattingModel, View view) {
        view.findViewById(2131367715).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                MessageChatAdapter.this.aT.i();
            }
        });
    }

    private void g(final ChattingModel chattingModel, View view, View view2) {
        int i;
        int i2;
        boolean z;
        if (TextUtils.isEmpty(chattingModel.msgContent) || view2 == null) {
            return;
        }
        final MsgChattingImageModel d = ChatHelperV4.a().d(chattingModel);
        if (d != null) {
            i = d.getPicWidth();
            i2 = d.getPicHeight();
            z = false;
            if (!chattingModel.isFromSelf()) {
                z = false;
                if (d.identify_yellow) {
                    z = true;
                }
            }
        } else {
            i = AppInfo.l / 3;
            i2 = i;
            z = false;
        }
        r(chattingModel, view);
        final ImageView imageView = (ImageView) view2.findViewById(R.id.img_pic);
        if (imageView != null) {
            if (i != 0 && i2 != 0) {
                Size b = ImageUtils.b(i, i2);
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.width = b.getWidth();
                layoutParams.height = b.getHeight();
                imageView.setLayoutParams(layoutParams);
            }
            final String str = chattingModel.msgContent;
            a(imageView, str, z);
            a(view2, imageView, z, new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.51
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    MessageChatAdapter.this.a(imageView, str, false);
                    try {
                        if (d != null) {
                            d.identify_yellow = false;
                            chattingModel.setMsgExtra(AppInfo.f().toJson(d));
                            ChatManager.getInstance().updateMsgOneData(chattingModel);
                            ChatManager.getInstance().sendReadReceipt(chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId);
                        }
                    } catch (Exception e) {
                    }
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.52
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    ArrayList<String> a2 = IMV4Method.a((List<ChattingModel>) MessageChatAdapter.this.f18271a);
                    BasePhotoFragment.a(MessageChatAdapter.this.b, (String[]) a2.toArray(new String[a2.size()]), IMV4Method.a(a2, str), 5, (LoadOptions) null, "", imageView, str);
                }
            });
            if (chattingModel.isFromSelf()) {
                imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.54
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view3) {
                        MessageChatAdapter.this.c(imageView, chattingModel);
                        return false;
                    }
                });
                return;
            }
            imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.53
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view3) {
                    if (!MessageChatAdapter.this.aT.c()) {
                        InstantLog.a("private_chat_option_show");
                    }
                    MessageChatAdapter.this.d(imageView, chattingModel);
                    return false;
                }
            });
            if (d == null || chattingModel.msgId != 1 || d.getMsgSource() == null) {
                return;
            }
            if (BluedConfig.a().r() || d.getMsgSource().getType() == MessageProtos.StrangerSource.SHADOW_SOURCE) {
                a(d.getMsgSource(), view, String.valueOf(chattingModel.fromId));
            }
        }
    }

    private void h(final ChattingModel chattingModel, View view) {
        final ShareToMsgEntity a2 = ChatHelperV4.a().a(chattingModel, this.aX);
        final View findViewById = view.findViewById(R.id.chat_include_invite_share);
        ImageView imageView = (ImageView) view.findViewById(2131365504);
        TextView textView = (TextView) view.findViewById(2131372754);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_desc);
        ImageLoader.a(this.aU.getFragmentActive(), a2.image).a(5.0f).b((int) R.drawable.icon_msg_share_feed_text).a(imageView);
        textView.setText(a2.title);
        if (TextUtils.isEmpty(a2.title)) {
            textView.setText(a2.name);
        }
        if (TextUtils.isEmpty(a2.description)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(a2.description);
        }
        if (!chattingModel.isFromSelf()) {
            EventTrackMessage.a(MessageProtos.Event.MSG_SHARE_MSG_SHOW, chattingModel, "h5", a2.url);
        }
        r(chattingModel, view);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (!chattingModel.isFromSelf()) {
                    EventTrackMessage.a(MessageProtos.Event.MSG_SHARE_MSG_CLICK, chattingModel, "h5", a2.url);
                }
                WebViewShowInfoFragment.show(MessageChatAdapter.this.b, a2.url, -1);
                short s = chattingModel.msgType;
                String str = a2.url;
                String str2 = "";
                if (!IMV4Method.b(chattingModel.fromId)) {
                    str2 = chattingModel.fromId + "";
                }
                InstantLog.a(s, str, str2);
            }
        });
        findViewById.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.18
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                MessageChatAdapter.this.c(findViewById, chattingModel);
                return true;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h(final com.blued.android.chat.model.ChattingModel r12, android.view.View r13, android.view.View r14) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.adapter.MessageChatAdapter.h(com.blued.android.chat.model.ChattingModel, android.view.View, android.view.View):void");
    }

    private void i(final ChattingModel chattingModel, View view) {
        int i;
        ImageLoader.a(c(), chattingModel.fromAvatar).b(2131237310).c().a((ImageView) view.findViewById(R.id.iv_header));
        ((TextView) view.findViewById(R.id.tv_nick)).setText(chattingModel.fromNickName);
        ShapeTextView findViewById = view.findViewById(R.id.tv_identity);
        if ((chattingModel.fromId + "").equals(this.aT.g())) {
            i = 1;
        } else {
            if (!TextUtils.isEmpty(this.aT.h())) {
                if (this.aT.h().contains(chattingModel.fromId + "")) {
                    i = 2;
                }
            }
            i = 3;
        }
        GroupUtil.a((TextView) findViewById, i);
        view.findViewById(2131367715).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                MessageChatAdapter.this.aT.a(chattingModel.msgContent);
            }
        });
    }

    private void i(final ChattingModel chattingModel, View view, View view2) {
        if (TextUtils.isEmpty(chattingModel.msgContent)) {
            return;
        }
        final int a2 = IMV4Method.a(chattingModel.fromId);
        TextView textView = (TextView) ViewHolder.a(view2, R.id.tv_message);
        ImageView imageView = (ImageView) ViewHolder.a(view2, R.id.icon_chat_video);
        if (imageView == null) {
            return;
        }
        r(chattingModel, view);
        View a3 = ViewHolder.a(view2, R.id.msg_item_root);
        if (a3 != null) {
            a3.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.74
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view3) {
                    MessageChatAdapter.this.a(chattingModel, (TextView) null, a2);
                    return false;
                }
            });
        }
        final VideoChatMsgContentModel videoChatMsgContentModel = (VideoChatMsgContentModel) AppInfo.f().fromJson(chattingModel.msgContent, (Class<Object>) VideoChatMsgContentModel.class);
        if (videoChatMsgContentModel != null) {
            if (videoChatMsgContentModel.room_type == 1) {
                if (a2 == 1) {
                    imageView.setImageResource(R.drawable.icon_chat_audio_receive_background);
                    if (chattingModel.msgType == 52) {
                        textView.setText(R.string.msg_invitation_audio_chat);
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.75
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                Tracker.onClick(view3);
                                ChannelModel channelModel = new ChannelModel();
                                channelModel.callType = 3;
                                channelModel.remoteUid = (int) chattingModel.fromId;
                                channelModel.channelId = videoChatMsgContentModel.room_id;
                                channelModel.has_screenshot = videoChatMsgContentModel.has_screenshot;
                                channelModel.chat_sdk_type = MessageChatAdapter.this.a(chattingModel.getMsgExtra());
                                DialogSkipFragment.a(MessageChatAdapter.this.b, channelModel);
                            }
                        });
                    } else {
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.76
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                Tracker.onClick(view3);
                                ChannelModel channelModel = new ChannelModel();
                                channelModel.callType = 1;
                                channelModel.remoteUid = (int) chattingModel.sessionId;
                                channelModel.chat_sdk_type = MessageChatAdapter.this.a(chattingModel.getMsgExtra());
                                channelModel.has_screenshot = videoChatMsgContentModel.has_screenshot;
                                DialogSkipFragment.a(MessageChatAdapter.this.b, channelModel);
                            }
                        });
                    }
                } else {
                    if (chattingModel.msgType == 52) {
                        textView.setText(R.string.msg_cancelled_by_self);
                    }
                    imageView.setImageResource(R.drawable.icon_chat_audio_send_background);
                    view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.77
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            Tracker.onClick(view3);
                            ChannelModel channelModel = new ChannelModel();
                            channelModel.callType = 1;
                            channelModel.remoteUid = (int) chattingModel.sessionId;
                            channelModel.has_screenshot = videoChatMsgContentModel.has_screenshot;
                            channelModel.chat_sdk_type = MessageChatAdapter.this.a(chattingModel.getMsgExtra());
                            DialogSkipFragment.a(MessageChatAdapter.this.b, channelModel);
                        }
                    });
                }
            } else if (videoChatMsgContentModel.room_type == 2) {
                if (a2 == 1) {
                    imageView.setImageResource(R.drawable.icon_chat_video_receive_background);
                    if (chattingModel.msgType == 52) {
                        textView.setText(R.string.msg_invitation_video_chat);
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.78
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                Tracker.onClick(view3);
                                ChannelModel channelModel = new ChannelModel();
                                channelModel.callType = 2;
                                channelModel.remoteUid = (int) chattingModel.fromId;
                                channelModel.channelId = videoChatMsgContentModel.room_id;
                                channelModel.has_screenshot = videoChatMsgContentModel.has_screenshot;
                                channelModel.chat_sdk_type = MessageChatAdapter.this.a(chattingModel.getMsgExtra());
                                DialogSkipFragment.a(MessageChatAdapter.this.b, channelModel);
                            }
                        });
                    } else {
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.79
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                Tracker.onClick(view3);
                                ChannelModel channelModel = new ChannelModel();
                                channelModel.callType = 0;
                                channelModel.remoteUid = (int) chattingModel.sessionId;
                                channelModel.has_screenshot = videoChatMsgContentModel.has_screenshot;
                                channelModel.chat_sdk_type = MessageChatAdapter.this.a(chattingModel.getMsgExtra());
                                DialogSkipFragment.a(MessageChatAdapter.this.b, channelModel);
                            }
                        });
                    }
                } else {
                    if (chattingModel.msgType == 52) {
                        textView.setText(R.string.msg_cancelled_by_self);
                    }
                    imageView.setImageResource(R.drawable.icon_chat_video_send_background);
                    view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.80
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            Tracker.onClick(view3);
                            ChannelModel channelModel = new ChannelModel();
                            channelModel.callType = 0;
                            channelModel.remoteUid = (int) chattingModel.sessionId;
                            channelModel.has_screenshot = videoChatMsgContentModel.has_screenshot;
                            channelModel.chat_sdk_type = MessageChatAdapter.this.a(chattingModel.getMsgExtra());
                            DialogSkipFragment.a(MessageChatAdapter.this.b, channelModel);
                        }
                    });
                }
            }
            if (chattingModel.msgType == 53) {
                if (a2 == 1) {
                    switch (videoChatMsgContentModel.close_type) {
                        case 1:
                        case 2:
                            a(videoChatMsgContentModel.total_time, textView);
                            return;
                        case 3:
                            textView.setText(R.string.msg_cancelled_by_other);
                            return;
                        case 4:
                            textView.setText(R.string.msg_refuse_by_self);
                            return;
                        case 5:
                            textView.setText(R.string.msg_cancelled_by_other);
                            return;
                        case 6:
                            textView.setText(R.string.msg_video_chat_busy_other);
                            return;
                        default:
                            textView.setText(R.string.msg_cancelled_by_other);
                            return;
                    }
                }
                switch (videoChatMsgContentModel.close_type) {
                    case 1:
                    case 2:
                        a(videoChatMsgContentModel.total_time, textView);
                        return;
                    case 3:
                        textView.setText(R.string.msg_cancelled_by_self);
                        return;
                    case 4:
                        textView.setText(R.string.msg_refuse_by_other);
                        return;
                    case 5:
                        textView.setText(R.string.msg_no_answer_by_other);
                        return;
                    case 6:
                        textView.setText(R.string.msg_video_chat_busy_other);
                        return;
                    default:
                        textView.setText(R.string.msg_cancelled_by_self);
                        return;
                }
            }
        }
    }

    private void j(final ChattingModel chattingModel, View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_header);
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
        SystemNoticeExtra systemNoticeExtra = null;
        if (!TextUtils.isEmpty(chattingModel.getMsgExtra())) {
            try {
                systemNoticeExtra = (SystemNoticeExtra) AppInfo.f().fromJson(chattingModel.getMsgExtra(), (Class<Object>) SystemNoticeExtra.class);
            } catch (Throwable th) {
                Logger.e(l, "setGroupNoticeType  error: " + th.getMessage());
                systemNoticeExtra = null;
            }
        }
        if (systemNoticeExtra != null && systemNoticeExtra.notice_type == 1) {
            imageView.setVisibility(0);
            view.findViewById(2131367715).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (MessageChatAdapter.this.aV == null || MessageChatAdapter.this.aV.h == null || !MessageChatAdapter.this.aT.c() || MessageChatAdapter.this.aV.h.m() == null || MessageChatAdapter.this.aV.h.m().event == null) {
                        Context context = MessageChatAdapter.this.b;
                        UserInfoFragmentNew.a(context, chattingModel.fromId + "", "group_chatting");
                        return;
                    }
                    EventLogData eventLogData = new EventLogData();
                    eventLogData.setEventId(MessageChatAdapter.this.aV.h.m().event.id + "");
                    eventLogData.setUid(String.valueOf(chattingModel.fromId));
                    eventLogData.setSourcePage(FeedProtos.SourcePage.ACTIVITY_GROUP);
                    EventUserInfoDlgFragment.a.a(MessageChatAdapter.this.aV.getParentFragmentManager(), String.valueOf(chattingModel.fromId), MessageChatAdapter.this.aV.h.f18842a.activity_id, eventLogData);
                }
            });
            ImageLoader.a(c(), chattingModel.fromAvatar).b(2131237310).c().a(imageView);
        }
        ((TextView) view.findViewById(R.id.tv_desc)).setText(chattingModel.msgContent);
    }

    private void k(ChattingModel chattingModel, View view) {
        ((TextView) view.findViewById(R.id.tv_notice_view)).setText(chattingModel.msgContent);
    }

    private void l(ChattingModel chattingModel, View view) {
        TextView textView = (TextView) view.findViewById(2131371675);
        ShapeFrameLayout findViewById = view.findViewById(R.id.fm_bg);
        ShapeHelper.b(findViewById, 2131100464);
        Logger.e("CommonNotice", "getMsgExtra===" + chattingModel.getMsgExtra());
        CommonNoticeExtra commonNoticeExtra = !TextUtils.isEmpty(chattingModel.getMsgExtra()) ? (CommonNoticeExtra) AppInfo.f().fromJson(chattingModel.getMsgExtra(), (Class<Object>) CommonNoticeExtra.class) : null;
        if (commonNoticeExtra != null && IMV4Method.a(chattingModel.fromId) == 0 && !TextUtils.isEmpty(commonNoticeExtra.sender_tips)) {
            findViewById.setVisibility(0);
            textView.setText(Html.fromHtml(commonNoticeExtra.sender_tips));
            Logger.e("CommonNotice", "sender===" + commonNoticeExtra.sender_tips);
        } else if (commonNoticeExtra == null || IMV4Method.a(chattingModel.fromId) != 1 || TextUtils.isEmpty(commonNoticeExtra.receiver_tips)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            textView.setText(Html.fromHtml(commonNoticeExtra.receiver_tips));
            Logger.e("CommonNotice", "receive===" + commonNoticeExtra.receiver_tips);
        }
    }

    private void m(final ChattingModel chattingModel, View view) {
        MsgExtraLike msgExtraLike;
        ImageView imageView = (ImageView) ViewHolder.a(view, R.id.iv_img_me);
        ImageView imageView2 = (ImageView) ViewHolder.a(view, R.id.iv_img_other);
        ImageLoader.a(c(), UserInfo.getInstance().getLoginUserInfo().avatar).a(2.0f, SkinHelper.b(this.b)).b(2131237310).a(imageView);
        ImageLoader.a(c(), this.aV.h.f18843c).a(2.0f, SkinHelper.b(this.b)).b(2131237310).a(imageView2);
        ShapeLinearLayout a2 = ViewHolder.a(view, R.id.sll_like);
        TextView textView = (TextView) ViewHolder.a(view, R.id.tv_action);
        ShapeHelper.b(a2, 2131102360);
        String msgExtra = chattingModel.getMsgExtra();
        if (TextUtils.isEmpty(msgExtra) || (msgExtraLike = (MsgExtraLike) AppInfo.f().fromJson(msgExtra, (Class<Object>) MsgExtraLike.class)) == null) {
            return;
        }
        if (TextUtils.isEmpty(msgExtraLike.content) || TextUtils.isEmpty(msgExtraLike.identical) || msgExtraLike.content.length() <= msgExtraLike.identical.length()) {
            textView.setText(msgExtraLike.content);
        } else {
            SpannableString spannableString = new SpannableString(msgExtraLike.content);
            int indexOf = msgExtraLike.content.indexOf(msgExtraLike.identical);
            spannableString.setSpan(new ForegroundColorSpan(SkinHelper.a(this.b)), indexOf, msgExtraLike.identical.length() + indexOf, 17);
            textView.setText(spannableString);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                Context context = MessageChatAdapter.this.b;
                UserInfoFragmentNew.a(context, chattingModel.fromId + "", "private_chatting");
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (chattingModel.isMatchMsg == 1) {
                    ToastUtils.a((int) R.string.date_today_header_clicked);
                    return;
                }
                Context context = MessageChatAdapter.this.b;
                UserInfoFragmentNew.a(context, MessageChatAdapter.this.aV.h.f() + "", "private_chatting");
            }
        });
    }

    private void n(final ChattingModel chattingModel, View view) {
        ((TextView) view.findViewById(R.id.tv_toEdit)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_OLD_MSG_CLICK);
                ModifyUserInfoFragment.a(MessageChatAdapter.this.b, 0, false);
            }
        });
        ((ImageView) view.findViewById(2131365207)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                ArrayList arrayList = new ArrayList();
                BottomMenuPop.MenuItemInfo menuItemInfo = new BottomMenuPop.MenuItemInfo();
                menuItemInfo.a = MessageChatAdapter.this.b.getString(R.string.msg_remind_later);
                menuItemInfo.b = 2131101766;
                menuItemInfo.d = new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.24.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Tracker.onClick(view3);
                        if (MessageChatAdapter.this.aZ != null) {
                            MessageChatAdapter.this.aZ.p();
                        }
                        EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_OLD_MSG_NOTIFY_CLICK);
                        ChatManager.getInstance().deleteOneMessage(chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId, chattingModel.msgLocalId);
                    }
                };
                BottomMenuPop.MenuItemInfo menuItemInfo2 = new BottomMenuPop.MenuItemInfo();
                menuItemInfo2.a = MessageChatAdapter.this.b.getString(R.string.msg_not_remind);
                menuItemInfo2.b = R.color.popitems_font_red;
                menuItemInfo2.d = new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.24.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Tracker.onClick(view3);
                        if (MessageChatAdapter.this.aZ != null) {
                            MessageChatAdapter.this.aZ.p();
                        }
                        EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_OLD_MSG_FORBID_CLICK);
                        ChatManager.getInstance().deleteOneMessage(chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId, chattingModel.msgLocalId);
                        BluedPreferences.cB();
                    }
                };
                arrayList.add(menuItemInfo);
                arrayList.add(menuItemInfo2);
                MessageChatAdapter.this.aZ = new BottomMenuPop(MessageChatAdapter.this.b);
                MessageChatAdapter.this.aZ.b = arrayList;
                MessageChatAdapter.this.aZ.c = new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.24.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Tracker.onClick(view3);
                        EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_OLD_MSG_CANCEL_CLICK);
                    }
                };
                new XPopup.Builder(MessageChatAdapter.this.b).a(MessageChatAdapter.this.aZ).h();
            }
        });
    }

    private void o(final ChattingModel chattingModel, View view) {
        try {
            final LiveMsgShareEntity liveMsgShareEntity = (LiveMsgShareEntity) AppInfo.f().fromJson(chattingModel.getMsgExtra(), (Class<Object>) LiveMsgShareEntity.class);
            if (liveMsgShareEntity == null) {
                return;
            }
            View findViewById = view.findViewById(R.id.chat_include_yy_share);
            ImageView imageView = (ImageView) findViewById.findViewById(R.id.iv_header);
            TextView textView = (TextView) findViewById.findViewById(2131372754);
            TextView textView2 = (TextView) findViewById.findViewById(R.id.tv_desc);
            ShapeTextView findViewById2 = findViewById.findViewById(R.id.tv_type);
            ImageLoader.a(c(), liveMsgShareEntity.pic_url).b(2131237310).c().a(imageView);
            if (!TextUtils.isEmpty(liveMsgShareEntity.name)) {
                textView2.setText(liveMsgShareEntity.name);
            }
            if (!TextUtils.isEmpty(liveMsgShareEntity.copywriting)) {
                textView.setText(liveMsgShareEntity.copywriting);
            }
            findViewById2.setText(liveMsgShareEntity.room_type_name);
            YyChatRoomTagShapeUtils yyChatRoomTagShapeUtils = YyChatRoomTagShapeUtils.a;
            yyChatRoomTagShapeUtils.a(findViewById2, liveMsgShareEntity.room_type + "");
            EventTrackMessage.a(MessageProtos.Event.MSG_SHARE_MSG_SHOW, chattingModel, "yy_chat", liveMsgShareEntity.room_id);
            view.findViewById(R.id.chat_content_in).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.31
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    EventTrackMessage.a(MessageProtos.Event.MSG_SHARE_MSG_CLICK, chattingModel, "yy_chat", liveMsgShareEntity.room_id);
                    MessageProtos.Event event = MessageProtos.Event.MSG_YY_ROOM_JOIN_CLICK;
                    String str = liveMsgShareEntity.room_id;
                    String str2 = liveMsgShareEntity.uid;
                    EventTrackMessage.b(event, str, str2, chattingModel.fromId + "");
                    if (LiveFloatManager.a().x()) {
                        AppMethods.a(MessageChatAdapter.this.b.getString(R.string.yy_living_toast));
                        return;
                    }
                    YYRoomInfoManager.e().a(MessageChatAdapter.this.b, liveMsgShareEntity.room_id, "msg_share");
                    EventTrackMessage.c(MessageProtos.Event.CHAT_ROOM_INVITE_MSG_JOIN_CLICK, liveMsgShareEntity.room_id, liveMsgShareEntity.uid);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void p(final ChattingModel chattingModel, View view) {
        String msgExtra = chattingModel.getMsgExtra();
        if (TextUtils.isEmpty(msgExtra)) {
            return;
        }
        Logger.b("直播分享extraJson==", msgExtra);
        try {
            final LiveMsgShareEntity liveMsgShareEntity = (LiveMsgShareEntity) AppInfo.f().fromJson(msgExtra, (Class<Object>) LiveMsgShareEntity.class);
            if (liveMsgShareEntity == null) {
                return;
            }
            final View findViewById = view.findViewById(R.id.chat_include_live_share);
            ImageView imageView = (ImageView) findViewById.findViewById(R.id.msg_live_img_pic_url);
            TextView textView = (TextView) findViewById.findViewById(R.id.msg_live_nickname);
            TextView textView2 = (TextView) findViewById.findViewById(R.id.msg_live_description);
            TextView textView3 = (TextView) findViewById.findViewById(R.id.msg_live_show_info);
            ImageLoader.a(c(), liveMsgShareEntity.pic_url).b((int) R.drawable.msg_live_default).a(14.0f).a(imageView);
            if (!TextUtils.isEmpty(liveMsgShareEntity.description)) {
                textView2.setText(liveMsgShareEntity.description);
            }
            if (!TextUtils.isEmpty(liveMsgShareEntity.name)) {
                textView.setText(this.b.getResources().getString(R.string.liveVideo_message_label_host) + ": " + liveMsgShareEntity.name);
            }
            if (!TextUtils.isEmpty(liveMsgShareEntity.copywriting)) {
                textView3.setText(liveMsgShareEntity.copywriting);
            } else if (liveMsgShareEntity.watch_count > 0) {
                textView3.setText(String.format(this.b.getResources().getString(R.string.liveVideo_videoList_label_watchedUserCountNotice), liveMsgShareEntity.watch_count + ""));
            } else {
                textView3.setText(this.b.getResources().getString(R.string.liveVideo_message_label_zeroPersonDesc));
            }
            final String str = "http://native.blued.cn/?action=liveplay&lid=" + liveMsgShareEntity.lid + "&uid=" + EncryptTool.b(liveMsgShareEntity.uid) + "&from=msg&note_type=" + liveMsgShareEntity.note_type;
            if (!chattingModel.isFromSelf()) {
                EventTrackMessage.a(MessageProtos.Event.MSG_SHARE_MSG_SHOW, chattingModel, "live", str);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.48
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    String str2;
                    String str3;
                    Tracker.onClick(view2);
                    if (!chattingModel.isFromSelf()) {
                        EventTrackMessage.a(MessageProtos.Event.MSG_SHARE_MSG_CLICK, chattingModel, "live", str);
                    }
                    LiveRoomInfoChannel.a(MessageChatAdapter.this.b, new LiveRoomData(StringUtils.a(liveMsgShareEntity.lid, 0L), 0, "msg", liveMsgShareEntity.uid, liveMsgShareEntity.name, liveMsgShareEntity.avatar, liveMsgShareEntity.vbadge));
                    String str4 = str;
                    if (IMV4Method.b(chattingModel.fromId)) {
                        str2 = "";
                    } else {
                        str2 = chattingModel.fromId + "";
                    }
                    InstantLog.a(32, str4, str2);
                    MessageProtos.Event event = MessageProtos.Event.MSG_CLICK;
                    if (IMV4Method.b(chattingModel.fromId)) {
                        str3 = "";
                    } else {
                        str3 = chattingModel.fromId + "";
                    }
                    EventTrackMessage.a(event, str3, "32", str);
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.49
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    MessageChatAdapter.this.c(findViewById, chattingModel);
                    return false;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void q(final ChattingModel chattingModel, View view) {
        int a2 = IMV4Method.a(chattingModel.fromId);
        final ImageView imageView = (ImageView) view.findViewById(R.id.img_pic);
        MsgChattingImageModel d = ChatHelperV4.a().d(chattingModel);
        if (d != null && d.getPicHeight() != 0 && d.getPicWidth() != 0) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            float a3 = DensityUtil.a(120.0f) / d.getPicWidth();
            layoutParams.height = (int) (d.getPicHeight() * a3);
            layoutParams.width = (int) (d.getPicWidth() * a3);
            imageView.setLayoutParams(layoutParams);
        }
        r(chattingModel, view);
        if (!TextUtils.isEmpty(chattingModel.msgContent)) {
            String[] split = chattingModel.msgContent.split("@");
            if (split.length > 1) {
                ImageLoader.a(c(), split[0]).a(6.0f).a(imageView);
                if (a2 == 0) {
                    imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.50
                        @Override // android.view.View.OnLongClickListener
                        public boolean onLongClick(View view2) {
                            MessageChatAdapter.this.c(imageView, chattingModel);
                            return true;
                        }
                    });
                }
            }
        }
        if (a2 != 1 || d == null || chattingModel.msgId != 1 || d.getMsgSource() == null) {
            return;
        }
        if (BluedConfig.a().r() || d.getMsgSource().getType() == MessageProtos.StrangerSource.SHADOW_SOURCE) {
            a(d.getMsgSource(), view, String.valueOf(chattingModel.fromId));
        }
    }

    private void r(ChattingModel chattingModel, View view) {
        View a2 = ViewHolder.a(view, R.id.common_safe_root);
        if (a2 != null) {
            a2.setVisibility(8);
        }
        View a3 = ViewHolder.a(view, R.id.sensitive_root);
        if (a3 != null) {
            a3.setVisibility(8);
        }
        String msgExtra = chattingModel.getMsgExtra();
        if (TextUtils.isEmpty(msgExtra)) {
            return;
        }
        try {
            MsgExtraForTextTypeEntity msgExtraForTextTypeEntity = (MsgExtraForTextTypeEntity) AppInfo.f().fromJson(msgExtra, (Class<Object>) MsgExtraForTextTypeEntity.class);
            if (msgExtraForTextTypeEntity == null) {
                return;
            }
            MsgExtraForTextTypeEntity.SecureNotify secureNotify = msgExtraForTextTypeEntity.secureNotify;
            if (secureNotify != null) {
                MsgExtraForTextTypeEntity.SecureNotify a4 = MsgCommonUtils.a(secureNotify);
                int i = a4.notify_type;
                if (i != 1) {
                    if (i == 2 && a3 != null) {
                        a(chattingModel, a4, a3);
                    }
                } else if (a2 != null) {
                    if (this.aT.c()) {
                        return;
                    }
                    Context context = this.b;
                    a(context, this.aT.e() + "", this.aU.getFragmentActive(), (List<ChattingModel>) this.f18271a, chattingModel, a4, a2);
                }
            }
            if (IMV4Method.a(chattingModel.fromId) == 1 && chattingModel.msgId == 1 && msgExtraForTextTypeEntity.msgSource != null) {
                if (BluedConfig.a().r() || msgExtraForTextTypeEntity.msgSource.getType() == MessageProtos.StrangerSource.SHADOW_SOURCE) {
                    a(msgExtraForTextTypeEntity.msgSource, view, String.valueOf(chattingModel.fromId));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void s(final ChattingModel chattingModel, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        MsgImageAndTextModel msgImageAndTextModel;
        CardView cardView = (CardView) ViewHolder.a(view, R.id.cv_content);
        TextView textView = (TextView) ViewHolder.a(view, R.id.tv_detail);
        TextView textView2 = (TextView) ViewHolder.a(view, R.id.tv_msg_desc);
        TextView textView3 = (TextView) ViewHolder.a(view, R.id.tv_msg_title);
        ImageView imageView = (ImageView) ViewHolder.a(view, R.id.aariv_msg_img);
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewHolder.a(view, R.id.cl_msg_content);
        LinearLayout linearLayout = (LinearLayout) ViewHolder.a(view, R.id.ll_see_details);
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.d = 2131101212;
        loadOptions.b = 2131101212;
        try {
            String str6 = "";
            if (TextUtils.isEmpty(chattingModel.getMsgExtra()) || (msgImageAndTextModel = (MsgImageAndTextModel) AppInfo.f().fromJson(chattingModel.getMsgExtra(), (Class<Object>) MsgImageAndTextModel.class)) == null) {
                str = "";
                str2 = str;
                str3 = str2;
                str4 = str3;
                str5 = str4;
            } else {
                str2 = msgImageAndTextModel.title;
                str = msgImageAndTextModel.image;
                str3 = msgImageAndTextModel.desc;
                str4 = msgImageAndTextModel.link;
                str5 = msgImageAndTextModel.click_desc;
                str6 = a(msgImageAndTextModel);
            }
            if (TextUtils.isEmpty(str2)) {
                textView3.setVisibility(8);
            } else {
                textView3.setText(str2);
                textView3.setVisibility(0);
            }
            ImageLoader.a(c(), str).b((int) R.drawable.icon_msg_image_and_text_bg).d((int) R.drawable.icon_msg_image_and_text_bg).a(imageView);
            if (TextUtils.isEmpty(str3)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(str3);
                textView2.setVisibility(0);
            }
            if (!TextUtils.isEmpty(str5)) {
                textView.setText(str5);
            }
            if (TextUtils.isEmpty(str4)) {
                cardView.setOnClickListener(null);
                linearLayout.setOnClickListener(null);
                return;
            }
            if (!this.bb.contains(Long.valueOf(chattingModel.msgId))) {
                this.bb.add(Long.valueOf(chattingModel.msgId));
                EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_SHOW, str4, str6);
                Log.v("drb", "--------img:" + imageView + " -- id:" + str6);
            }
            Log.v("drb", "--aarivMsgImg:" + imageView + " -- id:" + str6);
            final String str7 = str4;
            final String str8 = str6;
            final String str9 = str2;
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.96
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (!TextUtils.isEmpty(str7) && str7.contains("detail=auto_msg")) {
                        EventTrackMessage.a(MessageProtos.Event.MSG_SHADOW_BUY_CLICK);
                    }
                    EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_CLICK, str7, str8);
                    MessageEventUtils.b(str7);
                    InstantLog.a("message_page", str7);
                    EventTrackMessage.a(MessageProtos.Event.MESSAGE_PAGE);
                    WebViewShowInfoFragment.show(MessageChatAdapter.this.b, str7, -1);
                    EventTrackMessage.a(MessageProtos.Event.MSG_SERVICE_ACCOUNT_MSG_ONE_CLICK, chattingModel.fromId + "", chattingModel.msgId + "", str7, "image", 2, str9);
                }
            });
            final String str10 = str4;
            final String str11 = str4;
            final String str12 = str6;
            final String str13 = str2;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.97
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (!TextUtils.isEmpty(str10) && str10.contains("detail=auto_msg")) {
                        EventTrackMessage.a(MessageProtos.Event.MSG_SHADOW_BUY_CLICK);
                    }
                    EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_CLICK, str11, str12);
                    MessageEventUtils.b(str11);
                    InstantLog.a("message_page", str11);
                    EventTrackMessage.a(MessageProtos.Event.MESSAGE_PAGE);
                    WebViewShowInfoFragment.show(MessageChatAdapter.this.b, str11, -1);
                    EventTrackMessage.a(MessageProtos.Event.MSG_SERVICE_ACCOUNT_MSG_ONE_CLICK, chattingModel.fromId + "", chattingModel.msgId + "", str11, "image", 3, str13);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void t(final ChattingModel chattingModel, View view) {
        final View a2 = ViewHolder.a(view, R.id.chat_include_invite_share);
        ImageView imageView = (ImageView) ViewHolder.a(view, R.id.iv_header);
        ImageView imageView2 = (ImageView) ViewHolder.a(view, R.id.img_verify);
        TextView textView = (TextView) ViewHolder.a(view, 2131372754);
        TextView textView2 = (TextView) ViewHolder.a(view, 2131371186);
        TextView textView3 = (TextView) ViewHolder.a(view, R.id.tv_repost_content);
        MultiPicLayout multiPicLayout = (MultiPicLayout) ViewHolder.a(view, R.id.multiPic);
        FrameLayout frameLayout = (FrameLayout) ViewHolder.a(view, R.id.fmPic);
        RelativeLayout relativeLayout = (RelativeLayout) ViewHolder.a(view, R.id.rl_vote);
        ImageView imageView3 = (ImageView) ViewHolder.a(view, R.id.iv_vote);
        RelativeLayout relativeLayout2 = (RelativeLayout) ViewHolder.a(view, R.id.rl_video);
        ImageView imageView4 = (ImageView) ViewHolder.a(view, R.id.iv_video);
        View a3 = ViewHolder.a(view, 2131366859);
        CardView cardView = (CardView) ViewHolder.a(a2, R.id.content_card);
        LinearLayout linearLayout = (LinearLayout) ViewHolder.a(a2, 2131368288);
        a3.setVisibility(8);
        textView3.setVisibility(8);
        relativeLayout.setVisibility(8);
        multiPicLayout.setVisibility(8);
        imageView2.setVisibility(8);
        relativeLayout2.setVisibility(8);
        linearLayout.setVisibility(8);
        final ShareToMsgEntity a4 = ChatHelperV4.a().a(chattingModel, this.aX);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cardView.getLayoutParams();
        if (a4.repost != null) {
            a4.imageList = a4.repost.imageList;
            a4.image = a4.repost.image;
            a4.type = a4.repost.type;
            textView3.setText(StringUtils.a((CharSequence) StringUtils.a(StringUtils.a(a4.repost.name, (int) textView3.getTextSize(), 0).toString(), false, true, false, null, false, "", "").toString(), false, false).toString());
            textView3.setVisibility(0);
            layoutParams.bottomMargin = DensityUtil.a(12.0f);
            layoutParams.leftMargin = DensityUtil.a(12.0f);
            layoutParams.rightMargin = DensityUtil.a(12.0f);
            cardView.setRadius(DensityUtil.a(10.0f));
            cardView.setCardBackgroundColor(SkinHelper.d(this.b));
        } else {
            layoutParams.bottomMargin = DensityUtil.a(0.0f);
            layoutParams.leftMargin = DensityUtil.a(0.0f);
            layoutParams.rightMargin = DensityUtil.a(0.0f);
            cardView.setRadius(DensityUtil.a(0.0f));
            cardView.setCardBackgroundColor(SkinHelper.b(this.b));
        }
        cardView.setLayoutParams(layoutParams);
        r(chattingModel, view);
        if (a4.shareUserInfo == null) {
            int i = 2131101212;
            if (a4.share_from == 15 || a4.share_from == 10) {
                i = 2131237269;
            }
            ImageLoader.a(c(), a4.image).a(5.0f).b(i).a(imageView);
            if (!TextUtils.isEmpty(a4.title)) {
                linearLayout.setVisibility(0);
                textView.setText(a4.title);
            } else if (!TextUtils.isEmpty(chattingModel.msgContent)) {
                linearLayout.setVisibility(0);
                textView.setText(chattingModel.msgContent);
            }
            textView.setCompoundDrawables(null, null, null, null);
            textView2.setText(a4.name);
            frameLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            frameLayout.setVisibility(0);
            if (a4.imageList == null) {
                a4.imageList = new ArrayList();
            }
            if (a4.imageList.size() > 0 || !TextUtils.isEmpty(a4.image)) {
                if (a4.imageList.size() == 0 && !TextUtils.isEmpty(a4.image)) {
                    a4.imageList.add(a4.image);
                }
                int i2 = a4.type;
                if (i2 == 0 || i2 == 1) {
                    multiPicLayout.setVisibility(0);
                    multiPicLayout.setData(a4.imageList);
                } else if (i2 == 2) {
                    relativeLayout2.setVisibility(0);
                    ImageLoader.a(this.aU.getFragmentActive(), a4.image).a(imageView4);
                } else if (i2 == 3) {
                    if (a4.imageList.size() == 1) {
                        relativeLayout.setVisibility(0);
                        ImageLoader.a(this.aU.getFragmentActive(), a4.imageList.get(0)).a(imageView3);
                    } else if (a4.imageList.size() == 2) {
                        multiPicLayout.setVisibility(0);
                        multiPicLayout.setData(a4.imageList);
                    }
                }
            }
            if (a4.imageList.size() == 0 && TextUtils.isEmpty(a4.image)) {
                frameLayout.setVisibility(8);
            }
            ImageWrapper c2 = ImageLoader.a(c(), a4.shareUserInfo.avatar).b(2131237310).c();
            if (!TextUtils.isEmpty(a4.shareUserInfo.nick)) {
                textView.setText(a4.shareUserInfo.nick);
            }
            if (a4.share_from == 15) {
                c2.d();
                Drawable drawable = this.b.getResources().getDrawable(R.drawable.anonymous_icon);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView.setCompoundDrawables(null, null, drawable, null);
            } else {
                textView.setCompoundDrawables(null, null, null, null);
            }
            c2.a(imageView);
            textView2.setText(StringUtils.a((CharSequence) StringUtils.a(StringUtils.a(a4.name, (int) textView2.getTextSize(), 0).toString(), false, true, false, null, false, "", "").toString(), false, false).toString());
            UserInfoHelper.a(imageView2, a4.shareUserInfo.badge, 3);
        }
        a(chattingModel, a4, true);
        a2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.98
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                MessageChatAdapter.this.a(chattingModel, a4, false);
                WebViewShowInfoFragment.show(MessageChatAdapter.this.b, a4.url, -1);
                short s = chattingModel.msgType;
                String str = a4.url;
                String str2 = "";
                if (!IMV4Method.b(chattingModel.fromId)) {
                    str2 = chattingModel.fromId + "";
                }
                InstantLog.a(s, str, str2);
            }
        });
        a2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.99
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                MessageChatAdapter.this.c(a2, chattingModel);
                return true;
            }
        });
    }

    private void u(ChattingModel chattingModel, View view) {
        int i = 1;
        if (IMV4Method.a(chattingModel.fromId) != 1) {
            i = 0;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.msg_item_root);
        linearLayout.setLayoutDirection(i ^ 1);
        final ShareEventToMsgEntity b = ChatHelperV4.a().b(chattingModel, this.aX);
        ImageLoader.a((IRequestHost) null, b.image).b((int) R.drawable.event_avatar_square).a(6.0f).a((ImageView) linearLayout.findViewById(R.id.share_event_iv));
        ((TextView) linearLayout.findViewById(R.id.share_event_name)).setText(b.activityName);
        ((TextView) linearLayout.findViewById(R.id.share_event_time)).setText(b.activityTime);
        ((TextView) linearLayout.findViewById(R.id.share_event_location)).setText(b.activityLocation);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.share_event_name_arrow);
        CardView cardView = (CardView) linearLayout.findViewById(R.id.chat_share_event_cv);
        if (CommunityManager.a.a().s()) {
            imageView.setImageResource(R.drawable.right_arrow_black_dark);
            cardView.setCardBackgroundColor(this.b.getResources().getColor(2131101490));
        } else {
            imageView.setImageResource(R.drawable.right_arrow_black);
            cardView.setCardBackgroundColor(this.b.getResources().getColor(2131102478));
        }
        if (i != 0) {
            linearLayout.findViewById(R.id.chat_state_error).setVisibility(8);
            linearLayout.findViewById(R.id.chat_sending_img).setVisibility(8);
        }
        r(chattingModel, view);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.-$$Lambda$MessageChatAdapter$pTJRZl3wvwcHs81CrCQ00s8XStw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MessageChatAdapter.this.a(b, view2);
            }
        });
    }

    private void v(final ChattingModel chattingModel, View view) {
        final View a2 = ViewHolder.a(view, R.id.chat_include_invite_share);
        TextView textView = (TextView) ViewHolder.a(view, R.id.tv_msg_title);
        XRoundedImageView xRoundedImageView = (XRoundedImageView) ViewHolder.a(view, R.id.xriv_viewpoint_cover);
        final ShareToMsgEntity a3 = ChatHelperV4.a().a(chattingModel, this.aX);
        textView.setText(chattingModel.msgContent);
        ImageLoader.a(c(), a3.image).b(2131101212).d((int) R.drawable.icon_failed_share_viewpoint).a(xRoundedImageView);
        a2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.100
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                WebViewShowInfoFragment.show(MessageChatAdapter.this.b, a3.url, -1);
                short s = chattingModel.msgType;
                String str = a3.url;
                String str2 = "";
                if (!IMV4Method.b(chattingModel.fromId)) {
                    str2 = chattingModel.fromId + "";
                }
                InstantLog.a(s, str, str2);
            }
        });
        a2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.101
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                MessageChatAdapter.this.c(a2, chattingModel);
                return true;
            }
        });
    }

    private void w(final ChattingModel chattingModel, View view) {
        String str;
        final View a2 = ViewHolder.a(view, R.id.chat_include_invite_share);
        ImageView imageView = (ImageView) ViewHolder.a(view, R.id.iv_vip);
        TextView textView = (TextView) ViewHolder.a(view, 2131372046);
        TextView textView2 = (TextView) ViewHolder.a(view, R.id.tv_info);
        ImageView imageView2 = (ImageView) ViewHolder.a(view, R.id.img_verify);
        ImageView imageView3 = (ImageView) ViewHolder.a(view, R.id.iv_header);
        r(chattingModel, view);
        final ShareToMsgEntity a3 = ChatHelperV4.a().a(chattingModel, this.aX);
        textView.setText(a3.name);
        if (a3.shareUserInfo != null) {
            UserInfoHelper.a(imageView2, a3.shareUserInfo.badge, 3);
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.vip_exp_lvl = a3.shareUserInfo.vip_exp_lvl;
            userBasicModel.vip_grade = a3.shareUserInfo.vip_grade;
            userBasicModel.expire_type = a3.shareUserInfo.expire_type;
            userBasicModel.is_hide_vip_look = a3.shareUserInfo.is_hide_vip_look;
            userBasicModel.is_vip_annual = a3.shareUserInfo.is_vip_annual;
            UserInfoHelper.a(imageView, userBasicModel, this.aV.getFragmentActive());
            if (a3.shareUserInfo.badge == 3 || a3.shareUserInfo.badge == 5) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(a3.shareUserInfo.age)) {
                    sb.append(a3.shareUserInfo.age);
                    sb.append("·");
                }
                if (!TextUtils.isEmpty(a3.shareUserInfo.height)) {
                    sb.append(a3.shareUserInfo.height);
                    sb.append("cm·");
                }
                if (!TextUtils.isEmpty(a3.shareUserInfo.weight)) {
                    sb.append(a3.shareUserInfo.weight);
                    sb.append("kg·");
                }
                if (!TextUtils.isEmpty(a3.shareUserInfo.role)) {
                    sb.append(UserInfoHelper.b(this.b, a3.shareUserInfo.role));
                    sb.append("·");
                }
                if (sb.length() > 0) {
                    textView2.setText(sb.substring(0, sb.toString().length() - 1));
                }
            }
        }
        ImageLoader.a(c(), a3.image).c().b(2131237310).a(imageView3);
        try {
            str = Uri.parse(a3.url).getQueryParameter("uid");
        } catch (Throwable th) {
            str = "";
        }
        if (!chattingModel.isFromSelf()) {
            EventTrackMessage.a(MessageProtos.Event.MSG_SHARE_MSG_SHOW, chattingModel, MediaFormat.KEY_PROFILE, str);
        }
        final String str2 = str;
        a2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.102
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (!chattingModel.isFromSelf()) {
                    EventTrackMessage.a(MessageProtos.Event.MSG_SHARE_MSG_CLICK, chattingModel, MediaFormat.KEY_PROFILE, str2);
                }
                WebViewShowInfoFragment.show(MessageChatAdapter.this.b, a3.url, -1);
                short s = chattingModel.msgType;
                String str3 = a3.url;
                String str4 = "";
                if (!IMV4Method.b(chattingModel.fromId)) {
                    str4 = chattingModel.fromId + "";
                }
                InstantLog.a(s, str3, str4);
            }
        });
        a2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.103
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                MessageChatAdapter.this.c(a2, chattingModel);
                return true;
            }
        });
    }

    private void x(ChattingModel chattingModel, View view) {
        boolean z;
        TextView textView = (TextView) ViewHolder.a(view, R.id.tv_date);
        if (textView != null) {
            if (chattingModel.msgType != 0) {
                try {
                    if (chattingModel.isShowTime) {
                        a(chattingModel.msgTimestamp, textView);
                    } else {
                        textView.setVisibility(8);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    textView.setVisibility(0);
                    textView.setText("时间异常: " + chattingModel.msgTimestamp);
                }
            } else {
                textView.setVisibility(8);
            }
        }
        LinearLayout linearLayout = (LinearLayout) ViewHolder.a(view, R.id.ll_do_not_disturb_on);
        if (chattingModel.isMatchMsg == 1) {
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(chattingModel.promptType)) {
            String[] split = chattingModel.promptType.split(",");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                } else if (split[i2].trim().equals("1")) {
                    z = true;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
        }
        z = false;
        if (linearLayout != null) {
            if (!z) {
                linearLayout.setVisibility(8);
                return;
            }
            linearLayout.setVisibility(0);
            ((TextView) ViewHolder.a(view, R.id.tv_do_not_disturb_on)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.110
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    new BluedAlertDialog.Builder(MessageChatAdapter.this.b).d((int) R.string.no_disturb_hint_dialog_title).e((int) R.string.no_disturb_hint_dialog_message).a(2131887278, (DialogInterface.OnClickListener) null).f(2131101766).a().show();
                }
            });
        }
    }

    private void y(final ChattingModel chattingModel, View view) {
        r(chattingModel, view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.msg_item_root);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_header_self);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_header_self);
        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_header_him);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_header_him);
        TextView textView = (TextView) view.findViewById(R.id.tv_match_text);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_desc);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(2131367622);
        TextView textView3 = (TextView) view.findViewById(R.id.tv_your_common_title);
        ShapeLinearLayout findViewById = view.findViewById(R.id.sll_your_common);
        TextView textView4 = (TextView) view.findViewById(R.id.tv_your_common);
        FlowLayout flowLayout = (FlowLayout) view.findViewById(R.id.fl_your_common);
        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_your_type);
        FlowLayout flowLayout2 = (FlowLayout) view.findViewById(R.id.fl_your_type);
        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.ll_him_as);
        FlowLayout flowLayout3 = (FlowLayout) view.findViewById(R.id.fl_him_as);
        LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.ll_single);
        FlowLayout flowLayout4 = (FlowLayout) view.findViewById(R.id.fl_attestation);
        ImageLoader.a(c(), UserInfo.getInstance().getLoginUserInfo().getAvatar()).b(2131237310).c().a(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.113
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                MessageChatAdapter.this.a(true);
            }
        });
        String msgExtra = chattingModel.getMsgExtra();
        if (TextUtils.isEmpty(msgExtra)) {
            return;
        }
        try {
            DateTodayMatchModel dateTodayMatchModel = (DateTodayMatchModel) AppInfo.f().fromJson(msgExtra, (Class<Object>) DateTodayMatchModel.class);
            DateTodayMatchUserModel target_info = dateTodayMatchModel.getTarget_info();
            DateTodayMatchUserModel self_info = dateTodayMatchModel.getSelf_info();
            if (target_info == null || self_info == null) {
                return;
            }
            DateTodayMatchUserModel dateTodayMatchUserModel = target_info;
            if (String.valueOf(DateTodayManager.f18714a.d(target_info.getUid())).equals(UserInfo.getInstance().getLoginUserInfo().getUid())) {
                dateTodayMatchUserModel = self_info;
            }
            ImageWrapper c2 = ImageLoader.a(c(), dateTodayMatchUserModel.getAvatar()).b(chattingModel.isMatchMsg == 1 ? 2131237311 : 2131237310).c();
            if (chattingModel.isMatchMsg == 1) {
                c2.a(100);
            }
            c2.a(imageView2);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.114
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (chattingModel.isMatchMsg == 1) {
                        MessageChatAdapter.this.aV.J();
                    } else {
                        MessageChatAdapter.this.a(false);
                    }
                }
            });
            if (dateTodayMatchModel.getScore() > 0.0f) {
                textView.setText(this.b.getString(R.string.recommend_people_match) + (((int) (dateTodayMatchModel.getScore() * 100.0f)) + "%"));
            } else {
                textView.setText(this.b.getString(R.string.date_today_title));
            }
            if ((dateTodayMatchModel.getSame_point_friends_purpose() != null && dateTodayMatchModel.getSame_point_friends_purpose().size() > 0) || ((dateTodayMatchModel.getSame_point_like() != null && dateTodayMatchModel.getSame_point_like().size() > 0) || ((dateTodayMatchUserModel.getYour_like_type() != null && dateTodayMatchUserModel.getYour_like_type().size() > 0) || (dateTodayMatchUserModel.getOthers_evaluation() != null && dateTodayMatchUserModel.getOthers_evaluation().size() > 0)))) {
                linearLayout2.setVisibility(0);
                linearLayout5.setVisibility(8);
                findViewById.setVisibility(a(dateTodayMatchModel.getSame_point_friends_purpose(), textView4) ? 0 : 8);
                a(dateTodayMatchModel.getSame_point_like(), flowLayout);
                a(dateTodayMatchUserModel.getYour_like_type(), linearLayout3, flowLayout2);
                a(dateTodayMatchUserModel.getOthers_evaluation(), linearLayout4, flowLayout3);
                if (flowLayout.getVisibility() != 0 && findViewById.getVisibility() != 0) {
                    textView3.setVisibility(8);
                }
                textView3.setVisibility(0);
            } else if (dateTodayMatchUserModel.getAttestation_info() == null || dateTodayMatchUserModel.getAttestation_info().size() <= 0) {
                linearLayout2.setVisibility(8);
                linearLayout5.setVisibility(8);
            } else {
                linearLayout2.setVisibility(8);
                linearLayout5.setVisibility(0);
                a(dateTodayMatchUserModel.getAttestation_info(), flowLayout4);
            }
            textView2.setText(String.format(this.b.getString(R.string.date_today_desc3), DateTodayManager.f18714a.a(dateTodayMatchUserModel)));
        } catch (Exception e) {
        }
    }

    private void z(ChattingModel chattingModel, View view) {
        r(chattingModel, view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.msg_item_root);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_header);
        ImageWrapper c2 = ImageLoader.a(c(), AvatarUtils.a(0, chattingModel.fromAvatar)).b(2131237310).c();
        if (chattingModel.isMatchMsg == 1) {
            c2.a(100);
        }
        c2.a(imageView);
        try {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.img_pic);
            String msgExtra = chattingModel.getMsgExtra();
            if (TextUtils.isEmpty(msgExtra)) {
                return;
            }
            int matchAnimationType = ((DateTodaySayHelloModel) AppInfo.f().fromJson(msgExtra, (Class<Object>) DateTodaySayHelloModel.class)).getMatchAnimationType();
            if (matchAnimationType == 1) {
                imageView2.setImageResource(R.drawable.icon_date_today_send_hi);
            } else if (matchAnimationType == 2) {
                imageView2.setImageResource(R.drawable.icon_date_today_send_heart);
            } else if (matchAnimationType == 3) {
                imageView2.setImageResource(R.drawable.icon_date_today_send_hug);
            } else if (matchAnimationType != 4) {
            } else {
                imageView2.setImageResource(R.drawable.icon_date_today_send_ok);
            }
        } catch (Exception e) {
        }
    }

    public long a(long j) {
        long j2 = j;
        if (j < 0) {
            j2 = -j;
        }
        return j2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:118:0x04aa  */
    @Override // com.soft.blued.ui.msg.adapter.BaseListAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View a(int r10, android.view.View r11, android.view.ViewGroup r12) {
        /*
            Method dump skipped, instructions count: 1762
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.adapter.MessageChatAdapter.a(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public void a(int i) {
        this.aY = i;
        this.k = VipBubbleManager.a().b(i);
    }

    public void a(View view) {
        UserInfoBasicModel I;
        MsgChattingFragment msgChattingFragment = this.aV;
        if (msgChattingFragment == null || (I = msgChattingFragment.I()) == null || !UserInfoHelper.b(I.vbadge)) {
            return;
        }
        ShapeTextView a2 = ViewHolder.a(view, R.id.stv_merchant_hint);
        a2.setText(String.format(this.b.getString(R.string.msg_merchant_hint), I.name));
        a2.setVisibility(0);
    }

    @Override // com.soft.blued.ui.msg.pop.MsgItemMenuPop.ItemClickListener
    public void a(String str, final ChattingModel chattingModel) {
        if (str.equals(this.b.getString(R.string.common_report))) {
            if ((chattingModel.msgType == 24 || chattingModel.msgType == 25) && System.currentTimeMillis() - chattingModel.msgTimestamp > 604800000) {
                ToastUtils.a(this.b.getString(R.string.msg_expire));
            } else {
                MessageChatMethod.a(this.b, chattingModel, this.f18271a, this.aT, this.aU);
            }
        } else if (str.equals(this.b.getString(R.string.retraction))) {
            MessageChatMethod.a(this.b, chattingModel, this.aT);
        } else if (str.equals(this.b.getString(R.string.group_msg_quote))) {
            AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.112
                @Override // java.lang.Runnable
                public void run() {
                    MessageChatMethod.b(chattingModel, MessageChatAdapter.this.aU);
                }
            }, 500L);
        }
    }

    public void a(String str, FeedProtos.SourcePage sourcePage) {
        EventLogData eventLogData = new EventLogData();
        eventLogData.setEventId(str);
        eventLogData.setSourcePage(sourcePage);
        EventDetailsFragment.a.a(this.b, str, eventLogData);
    }

    public boolean a(final Context context, final String str, final ActivityFragmentActive activityFragmentActive, final List<ChattingModel> list, final ChattingModel chattingModel, final MsgExtraForTextTypeEntity.SecureNotify secureNotify, View view) {
        if (secureNotify.multi_contents == null || secureNotify.multi_contents.size() <= 0) {
            return false;
        }
        view.setVisibility(0);
        ViewPager viewPager = (ViewPager) ViewHolder.a(view, 2131373100);
        SafeTabLayout safeTabLayout = (SafeTabLayout) ViewHolder.a(view, R.id.tab_layout);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (final MsgExtraForTextTypeEntity.SecureNotify.SecureContent secureContent : secureNotify.multi_contents) {
            arrayList.add(secureContent.title);
            View inflate = View.inflate(context, R.layout.item_msg_safe_vp, null);
            TextView textView = (TextView) inflate.findViewById(2131371186);
            final TextView textView2 = (TextView) inflate.findViewById(R.id.tv_link);
            if (TextUtils.isEmpty(secureContent.link_title) || TextUtils.isEmpty(secureContent.link)) {
                textView2.setVisibility(8);
                textView2.setOnClickListener(null);
            } else {
                textView2.setVisibility(0);
                textView2.setText(secureContent.link_title);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.81
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        WebViewShowInfoFragment.show(textView2.getContext(), secureContent.link, -1);
                        if (secureNotify.multi_contents.indexOf(secureContent) != 1) {
                            return;
                        }
                        EventTrackMessage.e(MessageProtos.Event.MSG_AIDS_MORE_CLICK, str);
                    }
                });
            }
            textView.setText(StringUtils.a(secureContent.body, secureNotify.highlight_keywords));
            arrayList2.add(inflate);
        }
        viewPager.setAdapter(new MsgSafeAdapter(arrayList2, arrayList));
        safeTabLayout.a(arrayList, viewPager);
        if (view.getTag() == null) {
            view.setTag(true);
            EventTrackMessage.e(MessageProtos.Event.MSG_DECEPTION_SHOW, str);
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.82
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 0) {
                    EventTrackMessage.e(MessageProtos.Event.MSG_DECEPTION_SHOW, str);
                } else if (i == 1) {
                    EventTrackMessage.e(MessageProtos.Event.MSG_AIDS_SHOW, str);
                } else if (i != 2) {
                } else {
                    EventTrackMessage.e(MessageProtos.Event.MSG_DISABLE_SHOW, str);
                }
            }
        });
        ((TextView) ViewHolder.a(view, R.id.tv_report)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.MessageChatAdapter.83
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                MsgCommonUtils.a(context, list, chattingModel, str, 6, 0, activityFragmentActive);
            }
        });
        LinePageIndicator a2 = ViewHolder.a(view, 2131368404);
        a2.setSelectedColor(context.getResources().getColor(R.color.chat_safe_page_indicator));
        a2.setUnselectedColor(SkinHelper.e(context));
        a2.setViewPager(viewPager);
        a(view);
        return true;
    }

    public boolean a(ChattingModel chattingModel) {
        String a2 = IMV4Method.a(chattingModel);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if (a2.contains("http")) {
            String a3 = IMV4Method.a(chattingModel.sessionType, chattingModel.sessionId, a2);
            if (new File(a3).exists()) {
                return true;
            }
            FileDownloader.a(a2, a3, (FileHttpResponseHandler) null, (IRequestHost) null);
            return false;
        }
        return new File(a2).exists();
    }

    public int b(View view) {
        if (view != null) {
            int height = view.getHeight();
            Rect rect = new Rect();
            view.getLocalVisibleRect(rect);
            if (rect.top > 0 && rect.left == 0 && rect.bottom == height) {
                return -rect.top;
            }
            if (rect.top == 0 && rect.left == 0 && rect.bottom < height) {
                int i = rect.bottom;
                return 0;
            }
            return 0;
        }
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        ChattingModel chattingModel = (ChattingModel) this.f18271a.get(i);
        int a2 = IMV4Method.a(chattingModel.fromId);
        short s = chattingModel.msgType;
        int i2 = 1;
        if (MsgType.getClassify(s) == 1 || s == 26) {
            return a2 == 0 ? 12 : 13;
        } else if (MsgType.getGroupOperationNotifyType(s) == 2 || s == 0) {
            return a2 == 0 ? 24 : 25;
        } else if (s != -9) {
            if (s != -8) {
                if (s != -3) {
                    if (s != -2) {
                        if (s != -1) {
                            if (s != 1) {
                                if (s != 2) {
                                    if (s == 3) {
                                        return a2 == 0 ? 6 : 7;
                                    } else if (s == 4) {
                                        int i3 = 5;
                                        if (a2 == 0) {
                                            i3 = 4;
                                        }
                                        return i3;
                                    } else if (s == 5) {
                                        return a2 == 0 ? 16 : 17;
                                    } else {
                                        if (s != 6) {
                                            if (s == 9) {
                                                int i4 = 9;
                                                if (a2 == 0) {
                                                    i4 = 8;
                                                }
                                                return i4;
                                            } else if (s == 10) {
                                                return a2 == 0 ? 10 : 11;
                                            } else if (s == 24) {
                                                return a2 == 0 ? 18 : 19;
                                            } else if (s == 25) {
                                                return a2 == 0 ? 20 : 21;
                                            } else if (s == 52 || s == 53) {
                                                return a2 == 0 ? 26 : 27;
                                            } else if (s == 73) {
                                                return a2 == 0 ? 40 : 41;
                                            } else if (s == 74) {
                                                return a2 == 0 ? 42 : 43;
                                            } else if (s == 98 || s == 99) {
                                                return a2 == 0 ? 38 : 39;
                                            } else {
                                                switch (s) {
                                                    case 6:
                                                        break;
                                                    case 32:
                                                        return a2 == 0 ? 22 : 23;
                                                    case 55:
                                                        return 28;
                                                    case 68:
                                                        return 29;
                                                    case 164:
                                                        return a2 == 0 ? 44 : 45;
                                                    case 169:
                                                        return 48;
                                                    case 205:
                                                        return a2 == 0 ? 50 : 51;
                                                    case 210:
                                                        return a2 == 0 ? 52 : 53;
                                                    case 216:
                                                        return 54;
                                                    case 220:
                                                        return 55;
                                                    case 250:
                                                        break;
                                                    case 251:
                                                        break;
                                                    case 256:
                                                        return 61;
                                                    case 257:
                                                        return 62;
                                                    case 267:
                                                        return 63;
                                                    case 271:
                                                        return 64;
                                                    case 279:
                                                        return 65;
                                                    case 281:
                                                        return 66;
                                                    case 282:
                                                        return a2 == 0 ? 67 : 68;
                                                    case 283:
                                                        return a2 == 0 ? 69 : 70;
                                                    case 287:
                                                        return 71;
                                                    case 288:
                                                        return 72;
                                                    case 290:
                                                        return 74;
                                                    default:
                                                        switch (s) {
                                                            case 87:
                                                                return a2 == 0 ? 30 : 31;
                                                            case 88:
                                                                return a2 == 0 ? 32 : 33;
                                                            case 89:
                                                                break;
                                                            case 90:
                                                                return a2 == 0 ? 36 : 37;
                                                            default:
                                                                switch (s) {
                                                                    case 240:
                                                                        return 56;
                                                                    case 241:
                                                                        return 57;
                                                                    case 242:
                                                                        break;
                                                                    case 243:
                                                                        return 59;
                                                                    case 244:
                                                                        return 60;
                                                                    default:
                                                                        if (a2 == 0) {
                                                                            i2 = 0;
                                                                        }
                                                                        return i2;
                                                                }
                                                        }
                                                        return a2 == 0 ? 34 : 35;
                                                }
                                            }
                                        }
                                        return a2 == 0 ? 14 : 15;
                                    }
                                }
                                return a2 == 0 ? 2 : 3;
                            }
                            int i5 = 1;
                            if (a2 == 0) {
                                i5 = 0;
                            }
                            return i5;
                        }
                        return 46;
                    }
                    return 47;
                }
                return 49;
            }
            return 58;
        } else {
            return 73;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 75;
    }
}
