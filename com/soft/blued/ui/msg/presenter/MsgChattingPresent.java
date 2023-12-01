package com.soft.blued.ui.msg.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.tv.TvContract;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.listener.LoadListener;
import com.blued.android.chat.listener.MsgContentListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.db.ChattingDao;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.ChatConstants;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackGroup;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.model.UserInfoBasicModel;
import com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment;
import com.soft.blued.ui.find.fragment.FindSearchMapFragment;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.model.PayExperimentConfigModel;
import com.soft.blued.ui.msg.ChatSettingFragment;
import com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback;
import com.soft.blued.ui.msg.contract.IMsgChattingView;
import com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.controller.tools.CheckYellowListener;
import com.soft.blued.ui.msg.controller.tools.IMV4Constant;
import com.soft.blued.ui.msg.controller.tools.IMV4Method;
import com.soft.blued.ui.msg.controller.tools.IdentifyYellowManager;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.ui.msg.manager.FlashPhotoManager;
import com.soft.blued.ui.msg.manager.RecentPhotoManager;
import com.soft.blued.ui.msg.manager.SubscribeNumberManager;
import com.soft.blued.ui.msg.model.ChatBundleExtra;
import com.soft.blued.ui.msg.model.ChatUserPrivilegeStatusModel;
import com.soft.blued.ui.msg.model.DateTodayInterestPlayedModel;
import com.soft.blued.ui.msg.model.DateTodaySayHelloModel;
import com.soft.blued.ui.msg.model.DateTodayStateModel;
import com.soft.blued.ui.msg.model.FlashNumberModel;
import com.soft.blued.ui.msg.model.FromFeedModel;
import com.soft.blued.ui.msg.model.HelloExpressionData;
import com.soft.blued.ui.msg.model.MsgChattingImageModel;
import com.soft.blued.ui.msg.model.MsgChattingVideoModel;
import com.soft.blued.ui.msg.model.MsgExtraForTextTypeEntity;
import com.soft.blued.ui.msg.model.MsgRecentPhotoInfo;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg.pop.LoadingPop;
import com.soft.blued.ui.msg_group.fragment.GroupAnnouncementFragment;
import com.soft.blued.ui.msg_group.fragment.GroupInfoFragment;
import com.soft.blued.ui.msg_group.pop.UserCardPop;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.ui.user.model.ServiceMenuModel;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.CameraUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.umeng.analytics.pro.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/presenter/MsgChattingPresent.class */
public class MsgChattingPresent implements FetchDataListener<SessionModel>, MsgContentListener, IMsgChatAdapterCallback {
    private static final String i = MsgChattingPresent.class.getSimpleName();
    private volatile String A;
    private boolean B;
    private long C;
    private long D;
    private String F;
    private int G;
    private int H;
    private long I;
    private int J;
    private boolean T;
    private String V;
    private UserInfoBasicModel W;
    private SessionSettingModel X;
    private SessionModel Y;
    private MsgSourceEntity Z;

    /* renamed from: a  reason: collision with root package name */
    public LogData f32533a;
    private RecentPhotoManager aa;
    private EditDataModel.SerializableData ab;
    private ChatBundleExtra ac;
    private BluedIngSelfFeed ad;
    private PayExperimentConfigModel am;
    private GroupInfoModel an;
    public String d;
    public String e;
    public boolean f;
    private BasePopupView j;
    private IMsgChattingView l;
    private boolean m;
    private boolean n;
    private long o;
    private short p;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private boolean z;
    private int k = 0;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f32534c = "";
    private String q = "";
    private String r = "";
    private String y = "";
    private int E = 0;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private boolean N = false;
    private boolean O = false;
    private boolean P = false;
    private boolean Q = false;
    private boolean R = true;
    private boolean S = true;
    private int U = 0;
    public String g = "";
    private boolean ae = true;
    private boolean af = true;
    private long ag = 0;
    private boolean ah = false;
    private boolean ai = false;
    private DateTodayStateModel aj = new DateTodayStateModel();
    private boolean ak = false;
    private boolean al = false;
    private boolean ao = false;
    public AtomicBoolean h = new AtomicBoolean(false);

    /* renamed from: com.soft.blued.ui.msg.presenter.MsgChattingPresent$18  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/presenter/MsgChattingPresent$18.class */
    class AnonymousClass18 implements CheckYellowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f32545a;
        final /* synthetic */ List b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f32546c;

        AnonymousClass18(int i, List list, ArrayList arrayList) {
            this.f32545a = i;
            this.b = list;
            this.f32546c = arrayList;
        }

        @Override // com.soft.blued.ui.msg.controller.tools.CheckYellowListener
        public void a() {
            MsgChattingPresent.this.l.E();
        }

        @Override // com.soft.blued.ui.msg.controller.tools.CheckYellowListener
        public void a(boolean z, String[] strArr) {
            MsgChattingPresent.this.l.F();
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    MsgChattingPresent.this.a(z, strArr, this.f32545a, this.b, this.f32546c.size());
                    return;
                }
                String str = strArr[i2];
                Log.v("drb", "checkYellow onFinish path:" + str);
                i = i2 + 1;
            }
        }
    }

    /* renamed from: com.soft.blued.ui.msg.presenter.MsgChattingPresent$19  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/presenter/MsgChattingPresent$19.class */
    class AnonymousClass19 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f32547a;

        AnonymousClass19(int i) {
            this.f32547a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChattingModel chattingModel;
            if (MsgChattingPresent.this.l == null || MsgChattingPresent.this.l.z().f31961a == null || MsgChattingPresent.this.l.z().f31961a.size() <= 0 || MsgChattingPresent.this.l.z().f31961a.size() <= this.f32547a || (chattingModel = (ChattingModel) MsgChattingPresent.this.l.z().f31961a.get(this.f32547a)) == null) {
                return;
            }
            ChatHelperV4.a().a(MsgChattingPresent.this.p, MsgChattingPresent.this.o, chattingModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.msg.presenter.MsgChattingPresent$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/presenter/MsgChattingPresent$2.class */
    public class AnonymousClass2 implements IRecentPhotoAdapterCallback.IGetPhotoListCallback {
        AnonymousClass2() {
        }

        @Override // com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback.IGetPhotoListCallback
        public void a(final List<MsgRecentPhotoInfo> list) {
            AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.2.1
                @Override // java.lang.Runnable
                public void run() {
                    ChattingModel a2;
                    final ArrayList arrayList = new ArrayList();
                    for (MsgRecentPhotoInfo msgRecentPhotoInfo : list) {
                        String a3 = MsgChattingPresent.this.l.z().getCount() <= 0 ? ChatHelperV4.a().a(MsgChattingPresent.this.Z, msgRecentPhotoInfo.width, msgRecentPhotoInfo.height) : ChatHelperV4.a().a(msgRecentPhotoInfo.width, msgRecentPhotoInfo.height);
                        if (MsgChattingPresent.this.Z != null) {
                            MsgChattingPresent.this.Z = null;
                        }
                        if (MsgChattingPresent.this.k == 1) {
                            MsgChattingPresent.this.av();
                            a2 = MsgChattingPresent.this.a((short) 24, msgRecentPhotoInfo.imgPath, a3);
                        } else {
                            a2 = MsgChattingPresent.this.a((short) 2, msgRecentPhotoInfo.imgPath, a3);
                        }
                        if (a2 != null) {
                            if (MsgChattingPresent.this.ap() && !MsgChattingPresent.this.al) {
                                DateTodayManager.a(a2);
                            }
                            arrayList.add(a2);
                            MsgChattingPresent.this.a(msgRecentPhotoInfo.imgPath, msgRecentPhotoInfo.width, msgRecentPhotoInfo.height);
                        }
                    }
                    IdentifyYellowManager.a().a(arrayList, new CheckYellowListener() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.2.1.1
                        @Override // com.soft.blued.ui.msg.controller.tools.CheckYellowListener
                        public void a() {
                            MsgChattingPresent.this.l.E();
                        }

                        @Override // com.soft.blued.ui.msg.controller.tools.CheckYellowListener
                        public void a(boolean z, String[] strArr) {
                            MsgChattingPresent.this.l.F();
                            int length = strArr.length;
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= length) {
                                    MsgChattingPresent.this.a(z, strArr, MsgChattingPresent.this.k, arrayList, list.size());
                                    return;
                                }
                                String str = strArr[i2];
                                Log.v("drb", "checkYellow onFinish path:" + str);
                                i = i2 + 1;
                            }
                        }
                    });
                }
            });
        }
    }

    public MsgChattingPresent(Bundle bundle, IMsgChattingView iMsgChattingView) {
        this.V = "";
        this.l = iMsgChattingView;
        if (iMsgChattingView == null) {
            return;
        }
        this.aa = new RecentPhotoManager();
        if (bundle != null) {
            this.V = bundle.getString("image_path");
        }
    }

    private List<ChattingModel> a(List<ChattingModel> list) {
        long j;
        int i2;
        long j2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= list.size()) {
                return list;
            }
            ChattingModel chattingModel = list.get(i4);
            if (chattingModel == null) {
                list.remove(i4);
                i2 = i4 - 1;
            } else {
                chattingModel.isShowTime = false;
                if (i4 == 0) {
                    chattingModel.isShowTime = true;
                    j = chattingModel.msgTimestamp;
                } else {
                    long j3 = chattingModel.msgTimestamp;
                    if ((j3 - list.get(i4 - 1).msgTimestamp) / 1000 > 180) {
                        chattingModel.isShowTime = true;
                        j = chattingModel.msgTimestamp;
                    } else {
                        j = j2;
                        if ((j3 - j2) / 1000 > 180) {
                            chattingModel.isShowTime = true;
                            j = chattingModel.msgTimestamp;
                        }
                    }
                }
                j2 = j;
                i2 = i4;
                if (chattingModel.msgType == 3) {
                    j2 = j;
                    i2 = i4;
                    if (!chattingModel.isFromSelf()) {
                        j2 = j;
                        i2 = i4;
                        if (chattingModel.msgStateCode != 5) {
                            j2 = j;
                            i2 = i4;
                            if (this.l.z() != null) {
                                this.l.z().a(chattingModel);
                                i2 = i4;
                                j2 = j;
                            }
                        }
                    }
                }
            }
            i3 = i2 + 1;
        }
    }

    private void a(int i2, String str, int i3, int i4, int i5) {
        ChattingModel a2;
        if (this.l == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a3 = i2 <= 0 ? ChatHelperV4.a().a(this.Z, i3, i4) : ChatHelperV4.a().a(i3, i4);
        if (this.Z != null) {
            this.Z = null;
        }
        if (i5 == 1) {
            av();
            a2 = a((short) 24, str, a3);
        } else {
            a2 = a((short) 2, str, a3);
        }
        if (a2 == null) {
            return;
        }
        a(str, i3, i4);
        b(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, List<ChattingModel> list, MessageProtos.SourceType sourceType, int i3) {
        a(list);
        ChatHelperV4.a().a(list, this.b, this.f32534c, this.s, this.t, this.u, this.v, this.w);
        EventTrackMessage.a(MessageProtos.Event.MSG_SEND_PHOTO, sourceType, i3, i2 == 1 ? MessageProtos.PhotoType.BURN_AFTER_READ : MessageProtos.PhotoType.NORMAL_PHOTO);
        this.R = true;
    }

    private void a(FetchDataListener<SessionModel> fetchDataListener) {
        ChatManager.getInstance().getSessionModel((short) 2, e(), fetchDataListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final String str, File file, Exception exc) {
        if (file == null || !file.exists()) {
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            int c2 = FeedMethods.c(18);
            a(1, this.f32533a.bubble_exhibition_img, (int) ((options.outWidth * options.outHeight) / c2), c2, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        FeedHttpUtils.j(new BluedUIHttpResponse<BluedEntityA<String>>(null) { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.27
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<String> bluedEntityA) {
                LiveEventBus.get("FEED_BUBBLE_SAY_HELLO").post(str);
            }
        }, str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void a(boolean z, int i2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String[] strArr, final int i2, final List<ChattingModel> list, final int i3) {
        if (strArr == null || strArr.length <= 0) {
            a(i2, list, MessageProtos.SourceType.COMPLETE_PHOTO, i3);
            return;
        }
        if (!z) {
            for (MsgRecentPhotoInfo msgRecentPhotoInfo : o()) {
                int length = strArr.length;
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 < length) {
                        if (TextUtils.equals(msgRecentPhotoInfo.imgPath, strArr[i5])) {
                            Log.v("drb", "满足鉴黄写入要求");
                            this.aa.b(msgRecentPhotoInfo);
                        }
                        i4 = i5 + 1;
                    }
                }
            }
        }
        for (ChattingModel chattingModel : list) {
            int length2 = strArr.length;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 < length2) {
                    if (TextUtils.equals(IdentifyYellowManager.a().a(chattingModel), strArr[i7])) {
                        e(chattingModel);
                    }
                    i6 = i7 + 1;
                }
            }
        }
        Log.v("drb", "checkYellowAndSendMsg 展示拦截弹窗");
        if (this.l.getContext() != null) {
            if (ap()) {
                CommonAlertDialog.a(this.l.getContext(), AppInfo.d().getResources().getString(R.string.msg_yellow_tip_title), AppInfo.d().getResources().getString(R.string.date_today_forbidden), AppInfo.d().getResources().getString(R.string.date_today_ok), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, 0);
            } else {
                CommonAlertDialog.a(this.l.getContext(), AppInfo.d().getResources().getString(R.string.msg_yellow_tip_title), AppInfo.d().getResources().getString(R.string.msg_yellow_tip_content_send), AppInfo.d().getResources().getString(R.string.msg_yellow_tip_ok), 0, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.20
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i8) {
                        Tracker.onClick(dialogInterface, i8);
                        MsgChattingPresent.this.a(i2, list, MessageProtos.SourceType.COMPLETE_PHOTO, i3);
                    }
                }, AppInfo.d().getResources().getString(R.string.msg_yellow_tip_cancel), AppInfo.d().getResources().getColor(2131101632), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA() {
        PayHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<PayExperimentConfigModel>>(this.l.M()) { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.15
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PayExperimentConfigModel> bluedEntityA) {
                if (bluedEntityA.hasData()) {
                    MsgChattingPresent.this.am = bluedEntityA.data.get(0);
                    if (MsgChattingPresent.this.am.is_gift_free == 1) {
                        MsgChattingPresent.this.l.a(1, MsgChattingPresent.this.am.is_gift_free_content);
                    } else if (MsgChattingPresent.this.am.is_gift_new == 0 || BluedPreferences.u(MsgChattingPresent.this.am.is_gift_new)) {
                    } else {
                        MsgChattingPresent.this.l.a(2, MsgChattingPresent.this.am.is_gift_new_content);
                    }
                }
            }
        });
    }

    private void aB() {
        if (this.Y.expireTime != 0) {
            this.Y.expireTime = 0L;
            this.Y.totalMoney = 0.0f;
            ChatManager.getInstance().updateSessionTopGift(this.Y.sessionType, this.Y.sessionId, 0L, 0.0f);
        }
    }

    private void aC() {
        Log.w("xxx", "dateTodayReceiveBothInterest");
        this.l.e(3);
        as();
        this.l.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.30
            @Override // java.lang.Runnable
            public void run() {
                MsgChattingPresent.this.l.e(4);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD() {
        ChatHttpUtils.a(f(), this.l.M(), new BluedUIHttpResponse<BluedEntityA<DateTodayStateModel>>(this.l.M()) { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.31
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Code restructure failed: missing block: B:11:0x0050, code lost:
                if (r0 != false) goto L11;
             */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0053, code lost:
                r7 = 2;
             */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
                r7 = 3;
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
                if (r0 != false) goto L21;
             */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA<com.soft.blued.ui.msg.model.DateTodayStateModel> r6) {
                /*
                    Method dump skipped, instructions count: 246
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.presenter.MsgChattingPresent.AnonymousClass31.onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA):void");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str) {
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aE() {
        l(false);
        i(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aF() {
        as();
        this.l.e(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av() {
        FlashPhotoManager.a().a(FlashPhotoManager.a().b().flash_left_times - 1);
        this.l.b(false);
    }

    private UserBasicModel aw() {
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.uid = String.valueOf(this.ah ? -this.o : this.o);
        userBasicModel.avatar = this.f32534c;
        userBasicModel.name = F();
        if (this.W != null) {
            userBasicModel.age = this.W.age + "";
            userBasicModel.height = this.W.height + "";
            userBasicModel.weight = this.W.weight + "";
            userBasicModel.role = this.W.role + "";
            userBasicModel.distance = this.W.distance;
            userBasicModel.is_hide_distance = this.W.is_hide_distance;
            userBasicModel.is_hide_last_operate = this.W.is_hide_last_operate;
        }
        userBasicModel.vip_grade = this.t;
        userBasicModel.vbadge = this.s;
        return userBasicModel;
    }

    private UserBasicModel ax() {
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.uid = UserInfo.getInstance().getLoginUserInfo().getUid();
        userBasicModel.avatar = UserInfo.getInstance().getLoginUserInfo().getAvatar();
        userBasicModel.name = UserInfo.getInstance().getLoginUserInfo().getName();
        return userBasicModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay() {
        BluedUIHttpResponse<BluedEntityA<ServiceMenuModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<ServiceMenuModel>>(this.l.M()) { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.13
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ServiceMenuModel> bluedEntityA) {
                if (bluedEntityA != null) {
                    MsgChattingPresent.this.l.a(bluedEntityA.data);
                }
            }
        };
        UserHttpUtils.f(bluedUIHttpResponse, f() + "", this.l.M());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        FlashPhotoManager.a().a(new FlashPhotoManager.FlashPhotoModelSuccessListener() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.14
            @Override // com.soft.blued.ui.msg.manager.FlashPhotoManager.FlashPhotoModelSuccessListener
            public void onSuccess(BluedEntityA<FlashNumberModel> bluedEntityA) {
                MsgChattingPresent.this.l.D();
                FlashPhotoManager.a().a(MsgChattingPresent.this.ah);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final ChattingModel chattingModel, final boolean z) {
        if (chattingModel.msgType != 3) {
            IdentifyYellowManager.a().a(chattingModel, new CheckYellowListener() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.7
                @Override // com.soft.blued.ui.msg.controller.tools.CheckYellowListener
                public void a() {
                    MsgChattingPresent.this.l.E();
                }

                @Override // com.soft.blued.ui.msg.controller.tools.CheckYellowListener
                public void a(boolean z2, String[] strArr) {
                    MsgChattingPresent.this.l.F();
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= length) {
                            break;
                        }
                        String str = strArr[i3];
                        Log.v("drb", "checkYellow onFinish path:" + str);
                        i2 = i3 + 1;
                    }
                    if (strArr == null || strArr.length <= 0) {
                        ChatHelperV4.a().a(chattingModel, MsgChattingPresent.this.b, MsgChattingPresent.this.f32534c, MsgChattingPresent.this.s, MsgChattingPresent.this.t, MsgChattingPresent.this.u, MsgChattingPresent.this.v, MsgChattingPresent.this.w, z);
                        MsgChattingPresent.this.R = true;
                    } else if (MsgChattingPresent.this.l.getContext() != null) {
                        if (MsgChattingPresent.this.ap()) {
                            CommonAlertDialog.a(MsgChattingPresent.this.l.getContext(), AppInfo.d().getResources().getString(R.string.msg_yellow_tip_title), AppInfo.d().getResources().getString(R.string.date_today_forbidden), AppInfo.d().getResources().getString(R.string.date_today_ok), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, 0);
                        } else {
                            CommonAlertDialog.a(MsgChattingPresent.this.l.getContext(), AppInfo.d().getResources().getString(R.string.msg_yellow_tip_title), AppInfo.d().getResources().getString(R.string.msg_yellow_tip_content_send), AppInfo.d().getResources().getString(R.string.msg_yellow_tip_ok), 0, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.7.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i4) {
                                    Tracker.onClick(dialogInterface, i4);
                                    ChatHelperV4.a().a(MsgChattingPresent.this.e(chattingModel), MsgChattingPresent.this.b, MsgChattingPresent.this.f32534c, MsgChattingPresent.this.s, MsgChattingPresent.this.t, MsgChattingPresent.this.u, MsgChattingPresent.this.v, MsgChattingPresent.this.w, z);
                                    MsgChattingPresent.this.R = true;
                                }
                            }, AppInfo.d().getResources().getString(R.string.msg_yellow_tip_cancel), AppInfo.d().getResources().getColor(2131101632), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                        }
                    }
                }
            });
            return;
        }
        this.R = true;
        ChatHelperV4.a().a(chattingModel, this.b, this.f32534c, this.s, this.t, this.u, this.v, this.w, z);
    }

    private void b(List<ChattingModel> list) {
        Iterator<ChattingModel> it = list.iterator();
        ChattingModel chattingModel = null;
        while (it.hasNext()) {
            ChattingModel next = it.next();
            if (next.isMatchMsg == 1) {
                it.remove();
            } else if (!next.isFromSelf() && next.msgType == 288 && chattingModel == null) {
                f(next);
                chattingModel = next;
            }
        }
    }

    private LoadListener c(final Handler handler) {
        return new LoadListener() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.12
            @Override // com.blued.android.chat.listener.LoadListener
            public void onLoadFailed(String str) {
                Handler handler2 = handler;
                if (handler2 != null) {
                    handler2.sendEmptyMessage(304);
                }
            }

            @Override // com.blued.android.chat.listener.LoadListener
            public void onLoadSuccess() {
                Handler handler2 = handler;
                if (handler2 != null) {
                    handler2.sendEmptyMessage(303);
                }
            }
        };
    }

    private void c(int i2) {
        if (this.l != null) {
            ChattingModel chattingModel = new ChattingModel();
            chattingModel.msgType = (short) 0;
            chattingModel.msgContent = this.l.getContext().getResources().getString(R.string.following_for_new_message);
            this.l.z().f31961a.add(i2, chattingModel);
            this.l.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ChattingModel chattingModel, final boolean z) {
        IdentifyYellowManager.a().a(chattingModel, new CheckYellowListener() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.8
            @Override // com.soft.blued.ui.msg.controller.tools.CheckYellowListener
            public void a() {
                MsgChattingPresent.this.l.E();
            }

            @Override // com.soft.blued.ui.msg.controller.tools.CheckYellowListener
            public void a(boolean z2, String[] strArr) {
                MsgChattingPresent.this.l.F();
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        break;
                    }
                    String str = strArr[i3];
                    Log.v("drb", "checkYellow onFinish path:" + str);
                    i2 = i3 + 1;
                }
                if (strArr == null || strArr.length <= 0) {
                    ChatHelperV4.a().b(chattingModel, MsgChattingPresent.this.b, MsgChattingPresent.this.f32534c, MsgChattingPresent.this.s, MsgChattingPresent.this.t, MsgChattingPresent.this.u, MsgChattingPresent.this.v, MsgChattingPresent.this.w, z);
                    MsgChattingPresent.this.R = true;
                } else if (MsgChattingPresent.this.l.getContext() != null) {
                    if (MsgChattingPresent.this.ap()) {
                        CommonAlertDialog.a(MsgChattingPresent.this.l.getContext(), AppInfo.d().getResources().getString(R.string.msg_yellow_tip_title), AppInfo.d().getResources().getString(R.string.date_today_forbidden), AppInfo.d().getResources().getString(R.string.date_today_ok), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, 0);
                    } else {
                        CommonAlertDialog.a(MsgChattingPresent.this.l.getContext(), AppInfo.d().getResources().getString(R.string.msg_yellow_tip_title), AppInfo.d().getResources().getString(R.string.msg_yellow_tip_content_send), AppInfo.d().getResources().getString(R.string.msg_yellow_tip_ok), 0, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.8.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i4) {
                                Tracker.onClick(dialogInterface, i4);
                                ChatHelperV4.a().b(MsgChattingPresent.this.e(chattingModel), MsgChattingPresent.this.b, MsgChattingPresent.this.f32534c, MsgChattingPresent.this.s, MsgChattingPresent.this.t, MsgChattingPresent.this.u, MsgChattingPresent.this.v, MsgChattingPresent.this.w, z);
                                MsgChattingPresent.this.R = true;
                            }
                        }, AppInfo.d().getResources().getString(R.string.msg_yellow_tip_cancel), AppInfo.d().getResources().getColor(2131101632), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                    }
                }
            }
        });
    }

    private void c(List<ChattingModel> list) {
        List<ChattingModel> a2;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<ChattingModel> it = list.iterator();
        ChattingModel chattingModel = null;
        while (it.hasNext()) {
            ChattingModel next = it.next();
            if (next.isMatchMsg == 0) {
                it.remove();
            } else if (next.msgType == 281 || next.msgType == 287 || next.msgType == 282 || next.msgType == 283 || next.msgType == 288) {
                if (next.msgType == 287) {
                    it.remove();
                }
                chattingModel = next;
            }
        }
        if (chattingModel != null) {
            f(chattingModel);
        }
        SessionModel c2 = DateTodayManager.f32404a.c();
        if (c2 == null || c2.lastMsgFromId != f() || (a2 = this.l.z().a()) == null || a2.size() <= 1) {
            return;
        }
        ChattingModel chattingModel2 = a2.get(a2.size() - 1);
        if (chattingModel2.msgType <= 0 || chattingModel2.msgType == 281) {
            return;
        }
        DateTodayManager.f32404a.a(DateTodayManager.Status.COME_BACK_TOMORROW, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ChattingModel chattingModel) {
        this.R = true;
        ChatHelperV4.a().a(chattingModel, this.b, this.f32534c, this.s, this.t, this.u, this.v, this.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(List list) {
        IMsgChattingView iMsgChattingView = this.l;
        if (iMsgChattingView == null || iMsgChattingView.getActivity() == null || this.l.getActivity().isFinishing()) {
            return;
        }
        List<ChattingModel> a2 = a((List<ChattingModel>) list);
        if (ap()) {
            c(a2);
        } else {
            b(a2);
        }
        this.l.b(a2);
        if (ap()) {
            at();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChattingModel e(ChattingModel chattingModel) {
        try {
            Gson f = AppInfo.f();
            short s = chattingModel.msgType;
            if (s != 2) {
                if (s != 5) {
                    if (s != 24) {
                        if (s != 25) {
                            return chattingModel;
                        }
                    }
                }
                MsgChattingVideoModel msgChattingVideoModel = (MsgChattingVideoModel) f.fromJson(chattingModel.getMsgExtra(), (Class<Object>) MsgChattingVideoModel.class);
                msgChattingVideoModel.identify_yellow = true;
                chattingModel.identifyYellow = 1;
                chattingModel.setMsgExtra(f.toJson(msgChattingVideoModel));
                return chattingModel;
            }
            MsgChattingImageModel msgChattingImageModel = (MsgChattingImageModel) f.fromJson(chattingModel.getMsgExtra(), (Class<Object>) MsgChattingImageModel.class);
            msgChattingImageModel.identify_yellow = true;
            chattingModel.identifyYellow = 1;
            chattingModel.setMsgExtra(f.toJson(msgChattingImageModel));
            return chattingModel;
        } catch (Exception e) {
            return chattingModel;
        }
    }

    private void f(ChattingModel chattingModel) {
        String msgExtra = chattingModel.getMsgExtra();
        if (TextUtils.isEmpty(msgExtra) || chattingModel.isFromSelf()) {
            return;
        }
        Log.e("xxx", "dateTodayProcessLastMessage() msg.msgType=" + ((int) chattingModel.msgType));
        try {
            if (chattingModel.msgType == 281) {
                return;
            }
            if (chattingModel.msgType == 282) {
                DateTodaySayHelloModel dateTodaySayHelloModel = (DateTodaySayHelloModel) AppInfo.f().fromJson(msgExtra, (Class<Object>) DateTodaySayHelloModel.class);
                DateTodaySayHelloModel dateTodaySayHelloModel2 = dateTodaySayHelloModel;
                if (dateTodaySayHelloModel == null) {
                    dateTodaySayHelloModel2 = new DateTodaySayHelloModel();
                }
                if (dateTodaySayHelloModel2.getPlayed() == 0) {
                    dateTodaySayHelloModel2.setPlayed(1);
                    chattingModel.setMsgExtra(AppInfo.f().toJson(dateTodaySayHelloModel2, DateTodaySayHelloModel.class));
                    ChatManager.getInstance().updateMsgOneData(chattingModel);
                    if (this.ak) {
                        final int matchAnimationType = dateTodaySayHelloModel2.getMatchAnimationType();
                        this.l.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.29
                            @Override // java.lang.Runnable
                            public void run() {
                                MsgChattingPresent.this.l.d(matchAnimationType);
                            }
                        }, 500L);
                    }
                }
            } else if (chattingModel.msgType == 287) {
                if (chattingModel.isFromSelf() || g(chattingModel)) {
                    return;
                }
                this.l.e(-1);
            } else if (chattingModel.msgType == 283) {
                if (g(chattingModel)) {
                    return;
                }
                DateTodayManager.f32404a.b(false, f());
                this.l.e(3);
            } else if (chattingModel.msgType == 288) {
                DateTodayInterestPlayedModel dateTodayInterestPlayedModel = (DateTodayInterestPlayedModel) AppInfo.f().fromJson(chattingModel.getMsgExtra(), (Class<Object>) DateTodayInterestPlayedModel.class);
                DateTodayInterestPlayedModel dateTodayInterestPlayedModel2 = dateTodayInterestPlayedModel;
                if (dateTodayInterestPlayedModel == null) {
                    dateTodayInterestPlayedModel2 = new DateTodayInterestPlayedModel();
                }
                if (dateTodayInterestPlayedModel2.getPlayed() == 0) {
                    DateTodayManager.f32404a.b(false, f());
                    this.al = true;
                    Log.w("xxx", "dateTodayProcessLastMessage dateTodayViewCreated=" + this.ak);
                    if (this.ak) {
                        aC();
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private boolean g(ChattingModel chattingModel) {
        DateTodayInterestPlayedModel dateTodayInterestPlayedModel = (DateTodayInterestPlayedModel) AppInfo.f().fromJson(chattingModel.getMsgExtra(), (Class<Object>) DateTodayInterestPlayedModel.class);
        DateTodayInterestPlayedModel dateTodayInterestPlayedModel2 = dateTodayInterestPlayedModel;
        if (dateTodayInterestPlayedModel == null) {
            dateTodayInterestPlayedModel2 = new DateTodayInterestPlayedModel();
        }
        if (dateTodayInterestPlayedModel2.getPlayed() == 0) {
            dateTodayInterestPlayedModel2.setPlayed(1);
            Log.e("xxx", "dateTodaySetPlayed() set playedModel 1");
            chattingModel.setMsgExtra(AppInfo.f().toJson(dateTodayInterestPlayedModel2, DateTodayInterestPlayedModel.class));
            ChatManager.getInstance().updateMsgOneData(chattingModel);
            return false;
        }
        return true;
    }

    private void l(boolean z) {
        Log.e("xxx", "dateTodayStateModel [initiator=" + this.aj.getInitiator() + ", state=" + this.aj.getState() + "]");
        ChatHttpUtils.a(f(), this.aj.getInitiator(), z, this.aj.getState());
    }

    public void A() {
        LogData logData;
        if (this.m || (logData = this.f32533a) == null || this.n) {
            return;
        }
        logData.logService = "chat_send_msg";
        InstantLog.a(this.f32533a);
        this.n = true;
        EventTrackMessage.a(MessageProtos.Event.CHAT_SEND_MSG, this.f32533a, this.Z);
    }

    public void B() {
        if (TextUtils.isEmpty(H())) {
            return;
        }
        ChatManager.getInstance().updateSessionDraft(this.p, this.o, "");
        BluedPreferences.a(this.p, this.o, "");
    }

    public boolean C() {
        if (c()) {
            return true;
        }
        SubscribeNumberManager subscribeNumberManager = SubscribeNumberManager.f32449a;
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        sb.append("");
        return subscribeNumberManager.a(sb.toString(), (Short) 2) || SubscribeNumberManager.f32449a.a(UserInfo.getInstance().getLoginUserInfo().uid, (Short) 2);
    }

    public boolean D() {
        SubscribeNumberManager subscribeNumberManager = SubscribeNumberManager.f32449a;
        return subscribeNumberManager.a(f() + "", Short.valueOf(E()));
    }

    public short E() {
        return this.p;
    }

    public String F() {
        return this.b;
    }

    public String G() {
        return this.q;
    }

    public String H() {
        return this.r;
    }

    public String I() {
        return this.y;
    }

    public String J() {
        return this.A;
    }

    public LogData K() {
        return this.f32533a;
    }

    public SessionSettingModel L() {
        return this.X;
    }

    public SessionModel M() {
        return this.Y;
    }

    public int N() {
        return this.H;
    }

    public long O() {
        return this.I;
    }

    public int P() {
        return this.J;
    }

    public boolean Q() {
        return this.M;
    }

    public boolean R() {
        return this.N;
    }

    public UserInfoBasicModel S() {
        return this.W;
    }

    public boolean T() {
        return this.L;
    }

    public boolean U() {
        return this.K;
    }

    public boolean V() {
        return this.R;
    }

    public boolean W() {
        return this.S;
    }

    public boolean X() {
        return this.T;
    }

    public int Y() {
        return this.U;
    }

    public boolean Z() {
        Bundle arguments;
        IMsgChattingView iMsgChattingView = this.l;
        if (iMsgChattingView == null || (arguments = iMsgChattingView.getArguments()) == null) {
            return false;
        }
        this.o = arguments.getLong("passby_session_id");
        this.p = arguments.getShort("passby_session_type");
        this.b = arguments.getString("passby_nick_name");
        this.f32534c = arguments.getString("passby_avatar");
        this.s = arguments.getInt("passby_vbadge");
        this.t = arguments.getInt("passby_vip_grade", 0);
        this.u = arguments.getInt("passby_is_vip_annual", 0);
        this.v = arguments.getInt("passby_vip_exp_lvl", 0);
        this.w = arguments.getInt("passby_is_hide_vip_look", 0);
        this.y = arguments.getString("passby_last_msg_distance");
        this.z = arguments.getBoolean("passby_session_secret");
        this.B = arguments.getBoolean("IS_FROM_MSG_BOX", false);
        this.C = arguments.getLong("PASSBY_MSG_ID", -1L);
        this.D = arguments.getLong("PASSBY_MSG_LOCAL_ID", -1L);
        this.f = arguments.getBoolean("show_guide", false);
        this.ah = arguments.getBoolean("PASSBY_DATE_TODAY", false);
        DateTodayManager.f32404a.a(this.ah);
        Log.e("xxx", "MsgChattingPresent dateTodayTemp=" + this.ah + ", sessionId=" + this.o);
        try {
            LogData logData = (LogData) arguments.getSerializable("PASSBY_LOG_DATA");
            this.f32533a = logData;
            this.g = logData.details;
        } catch (Exception e) {
            String str = i;
            Logger.c(str, "logData===error: " + e.getMessage());
            this.f32533a = new LogData();
        }
        this.f32533a.target_uid = String.valueOf(this.o);
        try {
            this.Z = (MsgSourceEntity) arguments.getSerializable("msg_source_model");
            Logger.c("msgSource", "msgSource===" + this.Z.getType());
        } catch (Exception e2) {
            this.Z = new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, "");
        }
        try {
            ChatBundleExtra chatBundleExtra = (ChatBundleExtra) arguments.getSerializable("EXTRA");
            this.ac = chatBundleExtra;
            if (chatBundleExtra != null) {
                this.ad = chatBundleExtra.feed;
                AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MsgChattingPresent.this.l != null) {
                            MsgChattingPresent.this.l.a(MsgChattingPresent.this.ad);
                        }
                    }
                });
                if (this.ac.fuGiftListEvent != null && this.ac.fuGiftListEvent.f32324a != null) {
                    AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.10
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MsgChattingPresent.this.l != null) {
                                MsgChattingPresent.this.l.a(MsgChattingPresent.this.ac.fuGiftListEvent);
                            }
                        }
                    }, 500L);
                }
            }
        } catch (Throwable th) {
        }
        if (this.o == 0) {
            return false;
        }
        short s = this.p;
        if (s == 2) {
            InstantLog.a("chat_page_show", (Object) 0);
            this.m = false;
            SubscribeNumberManager.f32449a.d();
        } else if (s != 3) {
            return false;
        } else {
            InstantLog.a("chat_page_show", (Object) 1);
            this.m = true;
            SocialNetWorkProtos.Event event = SocialNetWorkProtos.Event.GROUP_CHAT_SHOW;
            EventTrackGroup.a(event, this.o + "", this.f32533a.from == d.K ? SocialNetWorkProtos.SourceType.GROUPINFO : SocialNetWorkProtos.SourceType.MESSAGE);
        }
        ad();
        return true;
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback
    public long a() {
        try {
            return Long.parseLong(this.d);
        } catch (Throwable th) {
            return 0L;
        }
    }

    public ChattingModel a(short s, String str) {
        return a(s, str, "");
    }

    public ChattingModel a(short s, String str, String str2) {
        return ChatHelper.getChattingModelForSendmsg(this.o, s, str, ChatHelperV4.a().b(), str2, this.p);
    }

    public UserBasicModel a(ChattingModel chattingModel, int i2) {
        String name = this.m ? IMV4Method.a(chattingModel.fromId) == 1 ? chattingModel.fromNickName : UserInfo.getInstance().getLoginUserInfo().getName() : IMV4Method.a(chattingModel.fromId) == 1 ? this.b : UserInfo.getInstance().getLoginUserInfo().getName();
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.uid = String.valueOf(chattingModel.fromId);
        userBasicModel.avatar = GroupUtil.a(chattingModel, this.m, this.f32534c);
        userBasicModel.name = name;
        if (!this.m && this.W != null) {
            userBasicModel.age = this.W.age + "";
            userBasicModel.height = this.W.height + "";
            userBasicModel.weight = this.W.weight + "";
            userBasicModel.role = this.W.role + "";
            userBasicModel.distance = this.W.distance;
            userBasicModel.is_hide_distance = this.W.is_hide_distance;
            userBasicModel.is_hide_last_operate = this.W.is_hide_last_operate;
        }
        userBasicModel.vip_grade = chattingModel.fromVipGrade;
        userBasicModel.vbadge = chattingModel.fromVBadge;
        if (userBasicModel.uid.equals(UserInfo.getInstance().getLoginUserInfo().uid)) {
            userBasicModel.is_show_vip_page = BluedConfig.a().b().is_show_vip_page;
            return userBasicModel;
        }
        userBasicModel.is_show_vip_page = i2;
        return userBasicModel;
    }

    public void a(int i2) {
        ChattingModel chattingModel;
        IMsgChattingView iMsgChattingView = this.l;
        if (iMsgChattingView != null) {
            if (iMsgChattingView.z() != null && this.l.z().f31961a != null && i2 >= 0 && (chattingModel = (ChattingModel) this.l.z().f31961a.get(i2)) != null && chattingModel.msgType != 0) {
                int i3 = i2 - 1;
                if (i3 < 0) {
                    c(i2);
                } else {
                    ChattingModel chattingModel2 = (ChattingModel) this.l.z().f31961a.get(i3);
                    if (chattingModel2 != null && chattingModel2.msgType != 0) {
                        c(i2);
                    }
                }
            }
            this.l.l();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void a(int i2, int i3, Intent intent) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public void a(long j) {
        if (this.j == null) {
            this.j = new XPopup.Builder(this.l.getContext()).d((Boolean) false).a((BasePopupView) new LoadingPop(this.l.getContext()));
        }
        this.j.h();
        BluedUIHttpResponse<BluedEntityA<UserInfoEntity>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>(this.l.M()) { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.23
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserInfoEntity> bluedEntityA) {
                if (bluedEntityA.hasData()) {
                    int i2 = bluedEntityA.data.get(0).uid.equals(MsgChattingPresent.this.d) ? 1 : (MsgChattingPresent.this.e == null || !MsgChattingPresent.this.e.contains(bluedEntityA.data.get(0).uid)) ? 3 : 2;
                    if (MsgChattingPresent.this.m() != null) {
                        new XPopup.Builder(MsgChattingPresent.this.l.getContext()).a((BasePopupView) new UserCardPop(MsgChattingPresent.this.l.getContext(), bluedEntityA.data.get(0), MsgChattingPresent.this.l.M(), i2, MsgChattingPresent.this.m())).h();
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (MsgChattingPresent.this.j != null) {
                    MsgChattingPresent.this.j.p();
                }
            }
        };
        ChatHttpUtils.e(bluedUIHttpResponse, j + "", this.l.M());
    }

    public void a(long j, long j2, Handler handler) {
        ChatManager.getInstance().loadSessionDownMsgList(this.p, this.o, 20, j, j2, c(handler));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void a(Intent intent) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public void a(Bundle bundle) {
        if (TextUtils.isEmpty(this.V)) {
            return;
        }
        bundle.putString("image_path", this.V);
    }

    public void a(Handler handler) {
        ChatManager.getInstance().loadSessionMsgList(this.p, this.o, 20, c(handler));
    }

    public void a(Handler handler, int i2) {
        IMsgChattingView iMsgChattingView = this.l;
        if (iMsgChattingView == null || this.G == i2) {
            return;
        }
        this.G = i2;
        if (!this.K || this.Y == null) {
            return;
        }
        int i3 = this.J;
        if (i3 >= 0) {
            iMsgChattingView.b(i3);
        }
        this.U = this.l.z().f31961a.size();
        if (this.O) {
            return;
        }
        a(handler);
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback
    public void a(final ChattingModel chattingModel) {
        ChatHttpUtils.a(f() + "", "chat", new BluedUIHttpResponse() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.26
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                MsgChattingPresent.this.Y.lastMsgLocalId = chattingModel.msgLocalId;
                chattingModel.msgType = (short) 243;
                MsgChattingPresent.this.a(chattingModel, true);
            }
        });
    }

    public void a(ChattingModel chattingModel, String str, String str2) {
        MsgExtraForTextTypeEntity msgExtraForTextTypeEntity = !TextUtils.isEmpty(chattingModel.getMsgExtra()) ? (MsgExtraForTextTypeEntity) AppInfo.f().fromJson(chattingModel.getMsgExtra(), (Class<Object>) MsgExtraForTextTypeEntity.class) : new MsgExtraForTextTypeEntity();
        msgExtraForTextTypeEntity.quote = str;
        msgExtraForTextTypeEntity.quote_seqnum = str2;
        chattingModel.setMsgExtra(AppInfo.f().toJson(msgExtraForTextTypeEntity));
    }

    public void a(ChattingModel chattingModel, boolean z) {
        this.R = true;
        if (ap() && !this.al) {
            DateTodayManager.a(chattingModel);
        }
        ChatHelperV4.a().c(chattingModel, this.b, this.f32534c, this.s, this.t, this.u, this.v, this.w, z);
    }

    @Override // com.blued.android.chat.listener.FetchDataListener
    /* renamed from: a */
    public void onFetchData(SessionModel sessionModel) {
        boolean z = true;
        if (sessionModel != null) {
            this.r = sessionModel.lastDraft;
            this.Y = sessionModel;
            IMsgChattingView iMsgChattingView = this.l;
            if (iMsgChattingView != null && sessionModel != null) {
                iMsgChattingView.a(sessionModel);
            }
            if (this.Y != null) {
                this.X = (SessionSettingModel) sessionModel.sessionSettingModel;
            }
            SessionSettingModel sessionSettingModel = this.X;
            z = true;
            if (sessionSettingModel != null) {
                this.A = sessionSettingModel.getChatBgUri();
                this.q = this.X.getSessinoNote();
                this.l.f();
                z = false;
            }
            aB();
        }
        if (z) {
            ChatManager.getInstance().getSessionSettingModel(this.p, this.o, new FetchDataListener<SessionSettingBaseModel>() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.17
                @Override // com.blued.android.chat.listener.FetchDataListener
                /* renamed from: a */
                public void onFetchData(SessionSettingBaseModel sessionSettingBaseModel) {
                    MsgChattingPresent.this.X = (SessionSettingModel) sessionSettingBaseModel;
                    if (MsgChattingPresent.this.X == null) {
                        MsgChattingPresent.this.X = new SessionSettingModel();
                        MsgChattingPresent.this.X.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
                        MsgChattingPresent.this.X.setSessionId(MsgChattingPresent.this.o);
                        MsgChattingPresent.this.X.setSessionType(MsgChattingPresent.this.p);
                    } else {
                        MsgChattingPresent msgChattingPresent = MsgChattingPresent.this;
                        msgChattingPresent.A = msgChattingPresent.X.getChatBgUri();
                    }
                    MsgChattingPresent.this.l.f();
                    MsgChattingPresent.this.l.d();
                }
            });
        } else {
            this.l.d();
        }
    }

    public void a(BaseFragment baseFragment) {
        MsgPhotoSelectFragment.a(baseFragment, 4, C(), 605);
    }

    public void a(GroupInfoModel groupInfoModel) {
        this.an = groupInfoModel;
        SessionModel sessionModel = this.Y;
        if (sessionModel == null || sessionModel.sessionSettingModel == null) {
            return;
        }
        SessionSettingModel sessionSettingModel = (SessionSettingModel) this.Y.sessionSettingModel;
        if (sessionSettingModel.is_super != groupInfoModel.is_super) {
            sessionSettingModel.is_super = groupInfoModel.is_super;
            HashMap hashMap = new HashMap();
            hashMap.put("is_super", Integer.valueOf(sessionSettingModel.is_super));
            ChatManager.getInstance().updateSessionSetting(sessionSettingModel.getSessionType(), sessionSettingModel.getSessionId(), hashMap);
        }
    }

    public void a(UserInfoBasicModel userInfoBasicModel) {
        if (userInfoBasicModel == null) {
            return;
        }
        this.b = userInfoBasicModel.name;
        this.f32534c = userInfoBasicModel.avatar;
        this.s = userInfoBasicModel.vbadge;
        this.t = userInfoBasicModel.vip_grade;
        this.u = userInfoBasicModel.is_vip_annual;
        this.v = userInfoBasicModel.vip_exp_lvl;
        this.w = userInfoBasicModel.is_hide_vip_look;
        this.x = userInfoBasicModel.is_show_vip_page;
        this.q = userInfoBasicModel.note;
        String str = userInfoBasicModel.in_blacklist;
        this.F = str;
        Logger.b(i, "isInMyBlacklist===", str);
    }

    public void a(IRecentPhotoAdapterCallback.IGetPhotoListCallback iGetPhotoListCallback) {
        this.aa.a(iGetPhotoListCallback);
    }

    public void a(HelloExpressionData helloExpressionData) {
        String a2 = ChatHelperV4.a().a(this.Z, helloExpressionData.w, helloExpressionData.h);
        b(a((short) 205, helloExpressionData.gif + "@" + helloExpressionData.title, a2));
    }

    public void a(MsgRecentPhotoInfo msgRecentPhotoInfo) {
        this.aa.c(msgRecentPhotoInfo);
    }

    public void a(GiftGivingOptionForJsonParse giftGivingOptionForJsonParse) {
        if (giftGivingOptionForJsonParse == null) {
            return;
        }
        IMsgChattingView iMsgChattingView = this.l;
        if (iMsgChattingView != null) {
            iMsgChattingView.a(giftGivingOptionForJsonParse);
        }
        if (giftGivingOptionForJsonParse.type == -1) {
            return;
        }
        ChatHelperV4 a2 = ChatHelperV4.a();
        b(a2.a(this.o + "", this.b, giftGivingOptionForJsonParse, this.Z));
    }

    public void a(Object obj) {
        ChattingModel chattingModel = (ChattingModel) obj;
        if (ap() && !this.al) {
            DateTodayManager.a(chattingModel);
        }
        short s = chattingModel.msgType;
        if (s != 2 && s != 3) {
            if (s != 5) {
                if (s == 9) {
                    d(chattingModel);
                    return;
                } else if (s != 24) {
                    if (s != 25) {
                        a(chattingModel, true);
                        return;
                    }
                }
            }
            c(chattingModel, true);
            return;
        }
        b(chattingModel, true);
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback
    public void a(String str) {
        GroupAnnouncementFragment.f32668a.a(this.l.getContext(), this.an);
    }

    public void a(String str, int i2, int i3) {
        this.aa.a(this.aa.a(str, i2, i3), new RecentPhotoManager.IRecordPicCallback() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.6
            @Override // com.soft.blued.ui.msg.manager.RecentPhotoManager.IRecordPicCallback
            public void a() {
                if (MsgChattingPresent.this.l != null) {
                    MsgChattingPresent.this.l.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MsgChattingPresent.this.l != null) {
                                MsgChattingPresent.this.l.g();
                            }
                        }
                    });
                }
            }
        });
    }

    public void a(String str, String str2, int i2, int i3, long j, int i4) {
        ChattingModel a2;
        if (StringUtils.d(str) || StringUtils.d(str2) || i2 <= 0 || i3 <= 0) {
            return;
        }
        if (i4 == 1) {
            av();
            a2 = a((short) 25, str, "");
        } else {
            a2 = a((short) 5, str, "");
        }
        a2.msgMapExtra = new HashMap();
        a2.msgMapExtra.put(TvContract.Programs.COLUMN_VIDEO_WIDTH, Integer.valueOf(i2));
        a2.msgMapExtra.put(TvContract.Programs.COLUMN_VIDEO_HEIGHT, Integer.valueOf(i3));
        a2.msgMapExtra.put("video_time_long", Long.valueOf(j));
        a2.msgMapExtra.put("msgSource", this.Z);
        if (a2 == null) {
            return;
        }
        a2.msgVideoCoverUrlLocal = str2;
        b(a2);
    }

    public void a(String str, boolean z) {
        IMsgChattingView iMsgChattingView = this.l;
        if (iMsgChattingView != null) {
            UserInfoFragmentNew.a(iMsgChattingView.v(), z ? ax() : aw(), str, 608);
        }
    }

    public void a(final boolean z) {
        this.aa.b(new IRecentPhotoAdapterCallback.IGetPhotoListCallback() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.1
            @Override // com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback.IGetPhotoListCallback
            public void a(final List<MsgRecentPhotoInfo> list) {
                AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MsgChattingPresent.this.a(z, list.size());
                    }
                });
            }
        });
    }

    public boolean a(List<ChattingModel>... listArr) {
        if (this.af) {
            this.af = false;
            if (M() != null && M().lastMsgTime > 0) {
                this.ag = M().lastMsgTime;
            }
        }
        if (al()) {
            a(a((short) 241, AppInfo.f().toJson(new FromFeedModel(this.ad))), false);
            am();
            this.l.a((BluedIngSelfFeed) null);
            return true;
        }
        return false;
    }

    public boolean aa() {
        return this.C == -1 || this.D == -1;
    }

    public String ab() {
        return this.m ? "群聊页" : "私聊页";
    }

    public int ac() {
        SessionSettingModel sessionSettingModel = this.X;
        return sessionSettingModel != null ? sessionSettingModel.getRemindAudio() : ChatConstants.b;
    }

    public void ad() {
        if (this.l == null) {
            return;
        }
        SessionModel snapSessionModel = ChatManager.getInstance().getSnapSessionModel(this.p, this.o);
        this.Y = snapSessionModel;
        if (snapSessionModel == null) {
            this.P = true;
            ChatManager.getInstance().getSessionModel(this.p, this.o, this);
            return;
        }
        IMsgChattingView iMsgChattingView = this.l;
        if (iMsgChattingView != null) {
            iMsgChattingView.a(snapSessionModel);
        }
        this.H = this.Y.noReadMsgCount;
        this.I = (this.Y.lastMsgId - this.H) + 1;
        this.r = this.Y.lastDraft;
        SessionSettingModel sessionSettingModel = (SessionSettingModel) this.Y.sessionSettingModel;
        this.X = sessionSettingModel;
        if (sessionSettingModel != null) {
            this.A = sessionSettingModel.getChatBgUri();
            this.q = this.X.getSessinoNote();
            this.l.f();
        } else {
            this.P = true;
            ChatManager.getInstance().getSessionSettingModel(this.p, this.o, new FetchDataListener<SessionSettingBaseModel>() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.16
                @Override // com.blued.android.chat.listener.FetchDataListener
                /* renamed from: a */
                public void onFetchData(SessionSettingBaseModel sessionSettingBaseModel) {
                    if (sessionSettingBaseModel != null) {
                        MsgChattingPresent.this.X = (SessionSettingModel) sessionSettingBaseModel;
                    }
                    if (MsgChattingPresent.this.X != null) {
                        MsgChattingPresent msgChattingPresent = MsgChattingPresent.this;
                        msgChattingPresent.A = msgChattingPresent.X.getChatBgUri();
                        MsgChattingPresent msgChattingPresent2 = MsgChattingPresent.this;
                        msgChattingPresent2.q = msgChattingPresent2.X.getSessinoNote();
                        MsgChattingPresent.this.l.f();
                    }
                    MsgChattingPresent.this.l.d();
                }
            });
        }
        aB();
    }

    public void ae() {
        ChatConstants.f28313a = this.o;
        if (this.P) {
            return;
        }
        Logger.c(i, "onResume==updateInfo");
        this.l.d();
    }

    public void af() {
        this.P = false;
    }

    public void ag() {
        ChattingModel chattingModel;
        if (this.l == null) {
            return;
        }
        if (!this.Q) {
            this.Q = true;
            ChatManager.getInstance().unregisterMsgContentListener(this.p, this.o, this);
        }
        ChatConstants.f28313a = 0L;
        IMV4Constant.b = false;
        String G = this.l.G();
        if (TextUtils.isEmpty(G.trim()) && !TextUtils.isEmpty(this.r)) {
            ChatManager.getInstance().updateSessionDraft(this.p, this.o, "");
            BluedPreferences.a(this.p, this.o, "");
        } else if (!TextUtils.isEmpty(G.trim())) {
            ChatManager.getInstance().updateSessionDraft(this.p, this.o, G);
            this.l.a(this.p, this.o);
        }
        ChatManager.getInstance().updateMsgForTextTranslateInit(this.p, this.o);
        IMsgChattingView iMsgChattingView = this.l;
        if (iMsgChattingView != null && iMsgChattingView.z() != null && this.l.z().getCount() == 1 && (chattingModel = (ChattingModel) this.l.z().getItem(0)) != null && chattingModel.msgType == -2) {
            ChatManager.getInstance().deleteSessionAndChatting((short) 2, Long.valueOf(this.o).longValue());
        }
        this.l.getActivity().getWindow().clearFlags(128);
    }

    public void ah() {
        if (this.Y == null) {
            return;
        }
        ChatManager.getInstance().deleteSession(this.Y.sessionType, this.o);
        IMsgChattingView iMsgChattingView = this.l;
        if (iMsgChattingView == null || iMsgChattingView.getActivity() == null) {
            return;
        }
        this.l.getActivity().finish();
    }

    public void ai() {
        a(new FetchDataListener<SessionModel>() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.21
            @Override // com.blued.android.chat.listener.FetchDataListener
            /* renamed from: a */
            public void onFetchData(SessionModel sessionModel) {
                if (MsgChattingPresent.this.h.get() || sessionModel == null || sessionModel._msgList == null || sessionModel._msgList.size() > 2) {
                    return;
                }
                if (sessionModel._msgList.size() != 2 || sessionModel._msgList.get(0).msgType == -2) {
                    ChattingModel chattingModel = sessionModel._msgList.size() == 2 ? sessionModel._msgList.get(1) : sessionModel._msgList.get(0);
                    String str = MsgChattingPresent.i;
                    Logger.c(str, "fromId==" + chattingModel.fromId);
                    String str2 = MsgChattingPresent.i;
                    Logger.c(str2, "getSessionId==" + MsgChattingPresent.this.e());
                    String str3 = MsgChattingPresent.i;
                    Logger.c(str3, "msgId==" + chattingModel.msgId);
                    String str4 = MsgChattingPresent.i;
                    Logger.c(str4, "getIsShowMessageEditTip==" + BluedConfig.a().v());
                    String str5 = MsgChattingPresent.i;
                    Logger.c(str5, "time==" + (System.currentTimeMillis() - chattingModel.msgTimestamp));
                    if (IMV4Method.a(chattingModel.fromId) == 0 && chattingModel.msgId == 1 && chattingModel.msgType != -1 && !BluedPreferences.cA() && BluedConfig.a().v()) {
                        MsgChattingPresent.this.h.set(true);
                        if (MsgChattingPresent.this.ap()) {
                            return;
                        }
                        ChatHelperV4.a().a(sessionModel, chattingModel);
                    }
                }
            }
        });
    }

    public SessionSettingModel aj() {
        return this.X;
    }

    public void ak() {
        IMsgChattingView iMsgChattingView;
        if (this.m || (iMsgChattingView = this.l) == null || !iMsgChattingView.M().isActive()) {
            return;
        }
        ChatHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<HelloExpressionData>>(this.l.M()) { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.22
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<HelloExpressionData> bluedEntityA) {
                if (!bluedEntityA.hasData() || MsgChattingPresent.this.l == null) {
                    return;
                }
                MsgChattingPresent.this.l.c(bluedEntityA.data);
            }
        }, this.l.M());
    }

    public boolean al() {
        BluedIngSelfFeed bluedIngSelfFeed = this.ad;
        if (bluedIngSelfFeed == null || TextUtils.isEmpty(bluedIngSelfFeed.feed_id)) {
            return false;
        }
        return this.ad.is_feed_anonym == 1 || this.ad.is_bubble_ticktock == 1;
    }

    public void am() {
        this.ad = null;
    }

    public boolean an() {
        if (UserInfoHelper.b(UserInfo.getInstance().getLoginUserInfo().vbadge)) {
            return !ChattingDao.a().d(2, this.o);
        }
        return false;
    }

    public void ao() {
        LogData logData = this.f32533a;
        if (logData == null || TextUtils.isEmpty(logData.bubble_exhibition_img)) {
            return;
        }
        final String str = this.f32533a.feed_id;
        ImageFileLoader.a((IRequestHost) null).a(this.f32533a.bubble_exhibition_img).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.msg.presenter.-$$Lambda$MsgChattingPresent$ukKbIhCd7XOfvtqbC5KrOl8NPNg
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public final void onUIFinish(File file, Exception exc) {
                MsgChattingPresent.this.a(str, file, exc);
            }
        }).a();
    }

    public boolean ap() {
        return this.ah;
    }

    public void aq() {
        if (this.al) {
            ChattingModel chattingModel = null;
            if (this.l.z() != null) {
                List<ChattingModel> a2 = this.l.z().a();
                chattingModel = null;
                if (a2 != null) {
                    int size = a2.size();
                    while (true) {
                        int i2 = size - 1;
                        chattingModel = null;
                        if (i2 < 0) {
                            break;
                        }
                        chattingModel = a2.get(i2);
                        if (chattingModel.msgType == 288) {
                            break;
                        }
                        size = i2;
                    }
                }
            }
            Log.e("xxx", "dateTodaySetBothInterestFlagToDb()");
            if (chattingModel != null) {
                chattingModel.isMatchMsg = 0;
                if (chattingModel.sessionId < 0) {
                    chattingModel.sessionId = -chattingModel.sessionId;
                }
                try {
                    if (!TextUtils.isEmpty(chattingModel.getMsgExtra())) {
                        JsonObject asJsonObject = JsonParser.parseString(chattingModel.getMsgExtra()).getAsJsonObject();
                        asJsonObject.remove("is_match_msg");
                        chattingModel.setMsgExtra(asJsonObject.entrySet().isEmpty() ? "" : asJsonObject.toString());
                    }
                } catch (Exception e) {
                    Log.e("xxx", e.toString());
                }
                g(chattingModel);
                this.al = false;
            }
        }
    }

    public void ar() {
        this.ak = true;
        Log.w("xxx", "dateTodayViewCreated dateTodayBothMatchData");
        if (this.al) {
            aC();
        }
    }

    public void as() {
        ChatManager.getInstance().mergeAllTempChatting(this.p, this.o, this);
        DateTodayManager.f32404a.b(f());
        DateTodayManager.f32404a.a(false);
        long j = this.o;
        if (j < 0) {
            this.o = -j;
        }
        this.ah = false;
        this.l.K();
    }

    public void at() {
        List<ChattingModel> a2;
        if (DateTodayManager.f32404a.d(f()) || (a2 = this.l.z().a()) == null || a2.size() < 10) {
            return;
        }
        ChattingModel chattingModel = a2.get(a2.size() - 1);
        if (TextUtils.equals(UserInfo.getInstance().getLoginUserInfo().uid, chattingModel.fromId + "")) {
            int i2 = 0;
            int i3 = 0;
            for (int size = a2.size() - 1; size >= 0; size--) {
                if (a2.get(size).fromId == f()) {
                    i3++;
                } else {
                    i2++;
                }
            }
            if (i2 < 5 || i3 < 5) {
                return;
            }
            ChattingModel chattingModelForSendmsg = ChatHelper.getChattingModelForSendmsg(e(), (short) -9, "", ChatHelperV4.a().b(), "", (short) 2);
            chattingModelForSendmsg.msgId = chattingModel.msgId;
            DateTodayManager.a(chattingModelForSendmsg);
            ChatHelperV4.a().h(chattingModelForSendmsg);
            DateTodayManager.f32404a.e(f());
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback
    public int b() {
        GroupInfoModel groupInfoModel = this.an;
        if (groupInfoModel != null) {
            return groupInfoModel.group_role;
        }
        return 0;
    }

    public void b(int i2) {
        this.U = i2;
    }

    public void b(Handler handler) {
        Log.v("xxx", "MsgChattingPresent initData sessionId=" + this.o);
        if (this.z) {
            ChatManager.getInstance().registerMsgContentListenerSecret(this.p, this.o, this);
        } else {
            ChatManager.getInstance().registerMsgContentListener(this.p, this.o, this);
        }
        this.Q = false;
        if (aa()) {
            a(handler);
        } else {
            a(this.C, this.D, handler);
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.11
            @Override // java.lang.Runnable
            public void run() {
                if (!MsgChattingPresent.this.m) {
                    MsgChattingPresent.this.aA();
                }
                if (MsgChattingPresent.this.D()) {
                    MsgChattingPresent.this.ay();
                }
                MsgChattingPresent.this.az();
                if (MsgChattingPresent.this.ah) {
                    MsgChattingPresent.this.aD();
                }
            }
        }, 300L);
    }

    public void b(final ChattingModel chattingModel) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(chattingModel);
        boolean a2 = a(arrayList);
        if (ap() && !this.al) {
            DateTodayManager.a(chattingModel);
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.4
            @Override // java.lang.Runnable
            public void run() {
                short s = chattingModel.msgType;
                if (s != 2 && s != 3) {
                    if (s != 5) {
                        if (s == 9) {
                            MsgChattingPresent.this.d(chattingModel);
                            return;
                        } else if (s != 24) {
                            if (s != 25) {
                                MsgChattingPresent.this.a(chattingModel, false);
                                return;
                            }
                        }
                    }
                    MsgChattingPresent.this.c(chattingModel, false);
                    return;
                }
                MsgChattingPresent.this.b(chattingModel, false);
            }
        }, a2 ? 500L : 0L);
    }

    public void b(ChattingModel chattingModel, int i2) {
        if (!this.m || chattingModel.isFromSelf()) {
            UserInfoFragmentNew.a(this.l.v(), a(chattingModel, i2), "private_chatting_photo", 608);
        } else {
            a(chattingModel.fromId);
        }
    }

    public void b(GroupInfoModel groupInfoModel) {
        this.b = groupInfoModel.group_title;
        this.f32534c = groupInfoModel.group_cover;
    }

    public void b(IRecentPhotoAdapterCallback.IGetPhotoListCallback iGetPhotoListCallback) {
        this.aa.b(iGetPhotoListCallback);
    }

    public void b(MsgRecentPhotoInfo msgRecentPhotoInfo) {
        this.aa.a(msgRecentPhotoInfo);
    }

    public void b(String str) {
        this.A = str;
    }

    public void b(String str, int i2, int i3) {
        if (TextUtils.isEmpty(str) || i2 <= 0) {
            return;
        }
        ChattingModel a2 = a((short) 3, str + ",," + i2);
        if (a2 == null) {
            return;
        }
        a2.setMsgExtra(ChatHelperV4.a().b(this.Z));
        b(a2);
    }

    public void b(boolean z) {
        this.M = z;
    }

    public void c(ChattingModel chattingModel) {
        if (this.Z != null) {
            chattingModel.setMsgExtra(ChatHelperV4.a().a(this.Z));
            this.Z = null;
        }
    }

    public void c(String str) {
        this.d = str;
    }

    public void c(boolean z) {
        this.N = z;
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback
    public boolean c() {
        return this.m;
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback
    public String d() {
        return this.f32534c;
    }

    public void d(String str) {
        this.e = str;
    }

    public void d(boolean z) {
        this.L = z;
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback
    public long e() {
        return this.o;
    }

    public void e(String str) {
        LogData logData = this.f32533a;
        if (logData != null) {
            logData.userFrom = str;
        }
    }

    public void e(boolean z) {
        this.K = z;
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback
    public long f() {
        return this.ah ? -this.o : this.o;
    }

    public void f(String str) {
        ChatHttpUtils.b(new BluedUIHttpResponse<BluedEntityA>(this.l.M()) { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.24
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
            }
        }, str);
    }

    public void f(boolean z) {
        this.R = z;
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback
    public String g() {
        return this.d;
    }

    public void g(String str) {
        if (this.an == null) {
            return;
        }
        IRequestHost M = this.l.M();
        MsgGroupHttpUtils.a(M, this.an.group_id + "", str, 4, new BluedUIHttpResponse<BluedEntityA>(this.l.M()) { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.25
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    ToastUtils.a(AppInfo.d().getString(R.string.group_chat_delete_success));
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }
        });
    }

    public void g(boolean z) {
        this.S = z;
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback
    public String h() {
        String str = this.e;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public void h(boolean z) {
        this.T = z;
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback
    public void i() {
        GroupInfoModel groupInfoModel;
        if (!this.m || (groupInfoModel = this.an) == null || groupInfoModel.event == null || this.an.event.is_rate != 1) {
            return;
        }
        ToastUtils.a(this.l.getContext().getString(R.string.group_event_evaluation_error));
    }

    public void i(boolean z) {
        DateTodayManager.f32404a.a(this.o);
        this.ai = true;
        if (z) {
            this.l.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.28
                @Override // java.lang.Runnable
                public void run() {
                    MsgChattingPresent.this.v();
                }
            }, 500L);
        } else {
            this.l.L();
        }
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback
    public void j() {
        u();
    }

    public boolean j(boolean z) {
        return DateTodayManager.f32404a.a(z, f());
    }

    @Override // com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback
    public void k() {
        FindSearchMapFragment.a((BaseFragmentActivity) this.l.getActivity(), 2, true);
    }

    public void k(boolean z) {
        boolean z2 = false;
        short s = z ? j(false) ? (short) 288 : (short) 283 : (short) 287;
        b(a(s, "[]"));
        Log.e("xxx", "dateTodaySendInterestState msgType=" + ((int) s));
        if (s == 288) {
            z2 = true;
        }
        if (!z) {
            this.l.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.presenter.-$$Lambda$MsgChattingPresent$Ouv8SwJc1Bw5-07bvPCXWEwksvw
                @Override // java.lang.Runnable
                public final void run() {
                    MsgChattingPresent.this.aE();
                }
            }, 500L);
            return;
        }
        DateTodayManager.f32404a.b(true, f());
        this.l.e(2);
        l(true);
        if (z2) {
            this.al = true;
            this.l.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.presenter.-$$Lambda$MsgChattingPresent$kfdGVfCxLt0FgruUBgDW-ofEyoM
                @Override // java.lang.Runnable
                public final void run() {
                    MsgChattingPresent.this.aF();
                }
            }, 500L);
        }
    }

    public PayExperimentConfigModel l() {
        return this.am;
    }

    public GroupInfoModel m() {
        return this.an;
    }

    public void n() {
        if (this.l != null && this.aa.a().size() > 0) {
            this.aa.b(new AnonymousClass2());
        }
    }

    public List<MsgRecentPhotoInfo> o() {
        return this.aa.a();
    }

    @Override // com.blued.android.chat.listener.MsgContentListener
    public void onMsgDataChanged(final List<ChattingModel> list) {
        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.presenter.-$$Lambda$MsgChattingPresent$tMMChpzZeY1Xq-svZq7uRxDRSxo
            @Override // java.lang.Runnable
            public final void run() {
                MsgChattingPresent.this.d(list);
            }
        });
    }

    public void p() {
        this.aa.b();
    }

    public void q() {
        IMsgChattingView iMsgChattingView = this.l;
        if (iMsgChattingView != null) {
            Context context = iMsgChattingView.getContext();
            BluedUIHttpResponse<BluedEntityA<UserInfoBasicModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<UserInfoBasicModel>>(this.l.M()) { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.3
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<UserInfoBasicModel> bluedEntityA) {
                    MsgChattingPresent.this.W = bluedEntityA.data.get(0);
                    MsgChattingPresent.this.l.a(MsgChattingPresent.this.W);
                    if (MsgChattingPresent.this.W != null) {
                        SessionProfileModel sessionProfileModel = new SessionProfileModel();
                        sessionProfileModel.nickname = MsgChattingPresent.this.W.name;
                        sessionProfileModel.avatar = MsgChattingPresent.this.W.avatar;
                        sessionProfileModel.vBadge = MsgChattingPresent.this.W.vbadge;
                        sessionProfileModel.vipAnnual = MsgChattingPresent.this.W.is_vip_annual;
                        sessionProfileModel.vipExpLvl = MsgChattingPresent.this.W.vip_exp_lvl;
                        sessionProfileModel.vipGrade = MsgChattingPresent.this.W.vip_grade;
                        sessionProfileModel.hideVipLook = MsgChattingPresent.this.W.is_hide_vip_look;
                        if (MsgChattingPresent.this.l.z() != null) {
                            MsgChattingPresent.this.l.z().e = MsgChattingPresent.this.W.is_show_vip_page;
                        }
                        ChatManager.getInstance().updateSessionInfoData(MsgChattingPresent.this.p, MsgChattingPresent.this.o, sessionProfileModel);
                        int i2 = MsgChattingPresent.this.W.no_disturb;
                        if (MsgChattingPresent.this.ah) {
                            DateTodayManager.f32404a.b(MsgChattingPresent.this.W.distance);
                            i2 = 0;
                        }
                        if (MsgChattingPresent.this.X != null) {
                            MsgChattingPresent.this.X.setRemindAudio(i2);
                            MsgChattingPresent.this.X.setSessinoNote(StringUtils.d(MsgChattingPresent.this.W.note) ? "" : MsgChattingPresent.this.W.note);
                            ChatManager.getInstance().setSessionSetting(MsgChattingPresent.this.p, MsgChattingPresent.this.o, MsgChattingPresent.this.X);
                        } else if (!TextUtils.isEmpty(MsgChattingPresent.this.q) && !MsgChattingPresent.this.q.equals(MsgChattingPresent.this.b)) {
                            SessionSettingModel sessionSettingModel = new SessionSettingModel();
                            sessionSettingModel.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
                            sessionSettingModel.setSessionType(MsgChattingPresent.this.p);
                            sessionSettingModel.setSessionId(MsgChattingPresent.this.o);
                            sessionSettingModel.setSessinoNote(MsgChattingPresent.this.q);
                            ChatManager.getInstance().setSessionSetting(MsgChattingPresent.this.p, MsgChattingPresent.this.o, sessionSettingModel);
                        }
                        if (i2 == 0) {
                            MsgChattingPresent.this.l.a(8);
                        } else {
                            MsgChattingPresent.this.l.a(0);
                        }
                        if (MsgChattingPresent.this.W.is_locked == 1 && MsgChattingPresent.this.l.M().isActive()) {
                            MsgChattingPresent.this.l.h();
                        }
                        if (MsgChattingPresent.this.W.is_un_disturb == 1) {
                            MsgChattingPresent.this.l.i();
                        }
                        MsgChattingPresent.this.l.j();
                        if (MsgChattingPresent.this.W.has_abuse == 1) {
                            MsgChattingPresent.this.l.H();
                        }
                        if (MsgChattingPresent.this.W.theme != null && MsgChattingPresent.this.X != null && MsgChattingPresent.this.X.bubbleThemeId != MsgChattingPresent.this.W.theme.bubble) {
                            MsgChattingPresent.this.X.bubbleThemeId = MsgChattingPresent.this.W.theme.bubble;
                            MsgChattingPresent.this.l.a(MsgChattingPresent.this.W.theme.bubble, true);
                        }
                        MsgChattingPresent.this.l.a(MsgChattingPresent.this.W.bubble);
                    }
                }
            };
            ChatHttpUtils.a(context, bluedUIHttpResponse, f() + "", this.l.M());
        }
    }

    public int r() {
        UserInfoBasicModel userInfoBasicModel = this.W;
        if (userInfoBasicModel == null) {
            return 0;
        }
        return userInfoBasicModel.poke_days;
    }

    public void s() {
        IMsgChattingView iMsgChattingView = this.l;
        if (iMsgChattingView == null || iMsgChattingView.v() == null || !this.l.M().isActive()) {
            return;
        }
        this.V = CameraUtils.a(this.l.v());
    }

    public void t() {
        IMsgChattingView iMsgChattingView = this.l;
        if (iMsgChattingView == null) {
            return;
        }
        if (this.m) {
            GroupInfoFragment.a(iMsgChattingView.getContext(), String.valueOf(this.o), this.an, SocialNetWorkProtos.SourceType.MESSAGE);
        } else if (ap()) {
            ToastUtils.a((int) R.string.date_today_header_clicked);
        } else {
            a("private_chatting_top_title", false);
        }
    }

    public void u() {
        IMsgChattingView iMsgChattingView = this.l;
        if (iMsgChattingView == null) {
            return;
        }
        if (this.m) {
            GroupInfoFragment.a(iMsgChattingView.getContext(), String.valueOf(this.o), this.an, SocialNetWorkProtos.SourceType.MESSAGE);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("passby_nick_name", this.b);
        bundle.putString("passby_nick_note", this.q);
        bundle.putString("passby_avatar", this.f32534c);
        bundle.putInt("passby_vbadge", this.s);
        bundle.putString("passby_session_id", String.valueOf(this.o));
        bundle.putShort("passby_session_type", this.p);
        bundle.putString("passby_is_in_blacklist", this.F);
        bundle.putInt("passby_vip_grade", this.t);
        bundle.putInt("passby_is_vip_annual", this.u);
        bundle.putInt("passby_vip_exp_lvl", this.v);
        bundle.putInt("passby_remind_audio", ac());
        bundle.putInt("passby_show_vip_page", this.x);
        bundle.putInt("passby_is_hide_vip_look", this.w);
        bundle.putSerializable("user", this.W);
        bundle.putBoolean("IS_FROM_MSG_BOX", this.B);
        TerminalActivity.a(this.l.v(), ChatSettingFragment.class, bundle, 603);
    }

    public void v() {
        if (this.ah && this.ai) {
            this.ai = false;
            ChatManager.getInstance().deleteAllTempChatting(this.p, this.o);
            DateTodayManager.f32404a.b(f());
        }
        IMsgChattingView iMsgChattingView = this.l;
        if (iMsgChattingView == null) {
            return;
        }
        KeyboardUtils.a(iMsgChattingView.getActivity());
        if (K() != null && "group_create".equals(K().from)) {
            HomeArgumentHelper.a(this.l.getContext(), "msg", (Bundle) null);
            return;
        }
        if (!this.Q) {
            this.Q = true;
            ChatManager.getInstance().unregisterMsgContentListener(this.p, this.o, this);
        }
        this.l.getActivity().finish();
    }

    public void w() {
        this.T = false;
        this.S = false;
    }

    public void x() {
        if (this.N && y()) {
            a(this.J);
        }
    }

    public boolean y() {
        try {
            if (this.l == null || this.l.z() == null) {
                this.J = -1;
            }
            if (this.l.z().f31961a.size() >= this.H) {
                int size = this.l.z().f31961a.size() - this.H;
                ChattingModel chattingModel = (ChattingModel) this.l.z().f31961a.get(size);
                if (chattingModel == null) {
                    this.J = -1;
                } else if (this.I != chattingModel.msgId) {
                    if (this.I >= chattingModel.msgId) {
                        int i2 = size;
                        while (true) {
                            int i3 = i2 + 1;
                            if (i3 < this.l.z().f31961a.size()) {
                                if (((ChattingModel) this.l.z().f31961a.get(i3)).msgId == this.I) {
                                    this.O = true;
                                    this.J = i3;
                                    break;
                                }
                                this.J = 0;
                                i2 = i3;
                            } else {
                                break;
                            }
                        }
                    } else {
                        int i4 = size;
                        while (true) {
                            int i5 = i4 - 1;
                            if (i5 >= 0) {
                                if (((ChattingModel) this.l.z().f31961a.get(i5)).msgId == this.I) {
                                    this.O = true;
                                    this.J = i5;
                                    break;
                                }
                                this.J = 0;
                                i4 = i5;
                            } else {
                                break;
                            }
                        }
                    }
                } else {
                    this.O = true;
                    this.J = size;
                }
            } else {
                this.J = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.J = -1;
        }
        return this.O;
    }

    public void z() {
        if (this.ae) {
            this.ae = false;
            BluedUIHttpResponse<BluedEntityA<ChatUserPrivilegeStatusModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<ChatUserPrivilegeStatusModel>>(this.l.M()) { // from class: com.soft.blued.ui.msg.presenter.MsgChattingPresent.5
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<ChatUserPrivilegeStatusModel> bluedEntityA) {
                    if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                        return;
                    }
                    ChatUserPrivilegeStatusModel singleData = bluedEntityA.getSingleData();
                    MsgChattingPresent.this.f32533a.is_super_call = singleData.call_type == 2;
                    MsgChattingPresent.this.A();
                    if (TextUtils.isEmpty(singleData.super_call_id)) {
                        return;
                    }
                    String str = singleData.super_call_id;
                    if (str.equals(BluedPreferences.ax(MsgChattingPresent.this.e() + ""))) {
                        return;
                    }
                    ChattingModel chattingModelForSendmsg = ChatHelper.getChattingModelForSendmsg(MsgChattingPresent.this.e(), (short) 267, AppInfo.d().getString(R.string.msg_super_call_tips), ChatHelperV4.a().b(), "", (short) 2);
                    if (MsgChattingPresent.this.ap() && !MsgChattingPresent.this.al) {
                        DateTodayManager.a(chattingModelForSendmsg);
                    }
                    ChatHelperV4.a().c(chattingModelForSendmsg, "", "", 0, 0, 0, 0, 0, false);
                    BluedPreferences.c(MsgChattingPresent.this.e() + "", singleData.super_call_id);
                }
            };
            ChatHttpUtils.a(bluedUIHttpResponse, f() + "", this.ag);
        }
    }
}
