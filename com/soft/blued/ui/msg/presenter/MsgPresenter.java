package com.soft.blued.ui.msg.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableSessionListListener;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.chat.contract.FilterSessionListListener;
import com.blued.android.module.chat.contract.IChatRelationDataListener;
import com.blued.android.module.chat.manager.ChatRelationDataManager;
import com.blued.android.module.chat.manager.MsgFilterManager;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.BluedSharedPreferences;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.menu.BottomMenuPop;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.biz.Event;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.model.HelloDataExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.group.GroupNotifyFragment;
import com.soft.blued.ui.msg.DateTodaySearchFragment;
import com.soft.blued.ui.msg.MsgBoxFragment;
import com.soft.blued.ui.msg.MsgPreferences;
import com.soft.blued.ui.msg.ServiceMsgFragment;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.manager.ChatBgManager;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.ui.msg.manager.GroupStatusManager;
import com.soft.blued.ui.msg.manager.MsgBoxManager;
import com.soft.blued.ui.msg.manager.MsgDataManager;
import com.soft.blued.ui.msg.manager.OnlineStatusManager;
import com.soft.blued.ui.msg.manager.SubscribeNumberManager;
import com.soft.blued.ui.msg.manager.YYChatRoomRecommend;
import com.soft.blued.ui.msg.model.ChatOnlineStatusModel;
import com.soft.blued.ui.msg.model.DateTodayMatchUserModel;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg.model.RefreshSessionEvent;
import com.soft.blued.ui.msg.observer.RecvMsgListenerObserver;
import com.soft.blued.ui.user.model.VipUpgradeModel;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/presenter/MsgPresenter.class */
public class MsgPresenter extends MvpPresenter implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, FilterSessionListListener, IChatRelationDataListener, RecvMsgListenerObserver.IRecvMsgListener {
    public MsgDataManager h;
    private MsgSessionListener r;
    private String[] s;
    private BottomMenuPop t;
    private YYChatRoomRecommend.OnFinishListener v;
    private DateTodayManager.OnFinishListener w;
    private int x;
    private String y;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private boolean o = true;
    private boolean p = true;
    private String q = "";
    private String u = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.msg.presenter.MsgPresenter$12  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/presenter/MsgPresenter$12.class */
    public static /* synthetic */ class AnonymousClass12 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32580a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[DateTodayManager.Status.values().length];
            f32580a = iArr;
            try {
                iArr[DateTodayManager.Status.HAVE_CHANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f32580a[DateTodayManager.Status.BE_MATCHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f32580a[DateTodayManager.Status.MATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f32580a[DateTodayManager.Status.COME_BACK_TOMORROW.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: com.soft.blued.ui.msg.presenter.MsgPresenter$7  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/presenter/MsgPresenter$7.class */
    class AnonymousClass7 implements FetchDataListener<List<SessionModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MsgPresenter f32588a;

        @Override // com.blued.android.chat.listener.FetchDataListener
        /* renamed from: a */
        public void onFetchData(List<SessionModel> list) {
            ChatHelperV4.a(list, true);
            int i = 0;
            for (SessionModel sessionModel : list) {
                int i2 = i;
                if (sessionModel.lastMsgId == 1) {
                    i2 = i;
                    if (sessionModel.lastMsgFromId == sessionModel.sessionId) {
                        i2 = i;
                        if (System.currentTimeMillis() - sessionModel.lastMsgTime < 86400000) {
                            i2 = i + 1;
                        }
                    }
                }
                i = i2;
                if (i2 == 3) {
                    BluedPreferences.cM();
                    BluedPreferences.m(System.currentTimeMillis());
                    this.f32588a.f_("showMsgBoxGuide");
                    return;
                }
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/presenter/MsgPresenter$MsgSessionListener.class */
    public class MsgSessionListener extends StableSessionListListener {
        public MsgSessionListener() {
        }

        @Override // com.blued.android.chat.StableSessionListListener
        public void onUISessionDataChanged(List<SessionModel> list) {
            MsgPresenter.this.c("onUISessionDataChanged start", list);
            MsgPresenter.this.h.c(list);
            MsgPresenter.this.c(list);
            SessionModel a2 = YYChatRoomRecommend.f32453a.a(MsgPresenter.this.v, MsgPresenter.this.g());
            if (a2 != null) {
                list.add(a2);
            }
            ChatHelperV4.a(list, true);
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                arrayList.addAll(SubscribeNumberManager.f32449a.a(MsgBoxManager.a().a(list, false), false));
            }
            if (BluedConstant.f28239a) {
                Iterator<E> it = arrayList.iterator();
                while (it.hasNext()) {
                    SessionModel sessionModel = (SessionModel) it.next();
                    if (sessionModel.sessionType == 3) {
                        it.remove();
                    } else if (sessionModel.sessionType == 1 && sessionModel.sessionId == 2) {
                        it.remove();
                    }
                }
            }
            MsgPresenter.this.h.b(arrayList);
            MsgPresenter.this.c("onUISessionDataChanged end", list);
            MsgPresenter.this.G();
        }
    }

    private void F() {
        if (t()) {
            this.i = false;
            MsgFilterManager.getInstance().filterData();
        } else if (TextUtils.isEmpty(this.q)) {
            a("dataUpdateFinish", (String) Integer.valueOf(s().size()));
        } else {
            d(this.q);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        e(false);
    }

    private void H() {
        OnlineStatusManager.f32435a.a(g(), new OnlineStatusManager.OnSyncOnlineStatusListener() { // from class: com.soft.blued.ui.msg.presenter.MsgPresenter.10
            @Override // com.soft.blued.ui.msg.manager.OnlineStatusManager.OnSyncOnlineStatusListener
            public List<String> a() {
                ArrayList arrayList = new ArrayList();
                for (SessionModel sessionModel : MsgPresenter.this.h.a()) {
                    if (sessionModel.sessionType != 6668) {
                        arrayList.add(String.valueOf(sessionModel.sessionId));
                    }
                }
                return arrayList;
            }

            @Override // com.soft.blued.ui.msg.manager.OnlineStatusManager.OnSyncOnlineStatusListener
            public void b() {
                MsgPresenter.this.G();
            }
        });
        EventTrackMessage.a(MessageProtos.Event.MSG_PAGE_SHOW);
    }

    private void I() {
        if (this.v == null) {
            this.v = new YYChatRoomRecommend.OnFinishListener() { // from class: com.soft.blued.ui.msg.presenter.-$$Lambda$MsgPresenter$Ahuh5Ke0uXlhGMbenzqB6g7haKw
                @Override // com.soft.blued.ui.msg.manager.YYChatRoomRecommend.OnFinishListener
                public final void onFinish(SessionModel sessionModel) {
                    MsgPresenter.this.f(sessionModel);
                }
            };
        }
    }

    private void J() {
        if (this.w == null) {
            this.w = new DateTodayManager.OnFinishListener() { // from class: com.soft.blued.ui.msg.presenter.-$$Lambda$MsgPresenter$JGJuTfi9ccDkjIYS8OoJs5Xrtic
                @Override // com.soft.blued.ui.msg.manager.DateTodayManager.OnFinishListener
                public final void onFinish(SessionModel sessionModel) {
                    MsgPresenter.this.e(sessionModel);
                }
            };
        }
    }

    private void K() {
        if (DateTodayManager.f32404a.f()) {
            AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.msg.presenter.-$$Lambda$MsgPresenter$EcgXZOfqbZlTFddl8Tzm9xBjKag
                @Override // java.lang.Runnable
                public final void run() {
                    MsgPresenter.this.L();
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        int i;
        List<SessionModel> a2 = this.h.a();
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= a2.size() || DateTodayManager.f32404a.a(a2.get(i))) {
                break;
            }
            i2 = i + 1;
        }
        a("showDateTodayGuide", (String) Integer.valueOf(i));
    }

    private void a(List<SessionModel> list) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= list.size() || YYChatRoomRecommend.f32453a.a(list.get(i))) {
                break;
            }
            i2 = i + 1;
        }
        if (i < list.size()) {
            list.remove(i);
        }
    }

    private void b(List<SessionModel> list) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= list.size() || DateTodayManager.f32404a.a(list.get(i))) {
                break;
            }
            i2 = i + 1;
        }
        if (i < list.size()) {
            list.remove(i);
        }
    }

    private void c(SessionModel sessionModel) {
        String str;
        if (sessionModel.sessionType == 2) {
            ChatOnlineStatusModel a2 = OnlineStatusManager.f32435a.a(Long.valueOf(sessionModel.sessionId));
            MessageProtos.Event event = MessageProtos.Event.MSG_USER_AVATAR_TEXT_CLICK;
            String a3 = OnlineStatusManager.f32435a.a(Integer.valueOf(a2 == null ? 0 : a2.getSocial_status()));
            String str2 = "";
            if (sessionModel.sessionId == 0) {
                str = "";
            } else {
                str = "" + sessionModel.sessionId;
            }
            if (a2 != null) {
                str2 = "" + a2.getSource_id();
            }
            EventTrackMessage.d(event, a3, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, List<SessionModel> list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                Log.v("xxx", str + " ------- sessionList.size()=" + list.size() + "\n" + ((Object) sb));
                return;
            }
            SessionModel sessionModel = list.get(i2);
            sb.append(i2);
            sb.append(" : [");
            sb.append(sessionModel.sessionId);
            sb.append(", ");
            sb.append((int) sessionModel.sessionType);
            sb.append(", ");
            sb.append(sessionModel.nickName);
            sb.append("]\n");
            i = i2 + 1;
        }
    }

    private void c(String str, boolean z) {
        List<SessionModel> r = r();
        this.h.c();
        if (r != null && r.size() > 0) {
            for (SessionModel sessionModel : r) {
                SessionSettingModel sessionSettingModel = (SessionSettingModel) sessionModel.sessionSettingModel;
                if ((!TextUtils.isEmpty(sessionModel.nickName) && sessionModel.nickName.contains(str)) || ((!TextUtils.isEmpty(sessionModel.lastMsgFromNickname) && sessionModel.lastMsgFromNickname.contains(str)) || ((!TextUtils.isEmpty(sessionModel.lastMsgContent) && sessionModel.lastMsgContent.contains(str)) || (sessionSettingModel != null && !TextUtils.isEmpty(sessionSettingModel.getSessinoNote()) && sessionSettingModel.getSessinoNote().contains(str))))) {
                    this.h.a(sessionModel);
                }
            }
        }
        a("dataUpdateFinish", (String) Integer.valueOf(s().size()));
        if (z) {
            a("filterOpenHasNewMessage", this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<SessionModel> list) {
        Iterator<SessionModel> it = list.iterator();
        long j = 0;
        SessionModel sessionModel = null;
        while (it.hasNext()) {
            SessionModel next = it.next();
            if (next.lastMsgType == 281 && next.sessionId < 0) {
                SessionModel sessionModel2 = sessionModel;
                long j2 = j;
                if (next.lastMsgFromId != Long.parseLong(UserInfo.getInstance().getLoginUserInfo().uid)) {
                    sessionModel2 = sessionModel;
                    j2 = j;
                    if (next.lastMsgTime + 86400000 > DateTodayManager.f32404a.d()) {
                        sessionModel2 = sessionModel;
                        j2 = j;
                        if (j < next.lastMsgTime) {
                            j2 = next.lastMsgTime;
                            sessionModel2 = next;
                        }
                    }
                }
                it.remove();
                sessionModel = sessionModel2;
                j = j2;
            }
        }
        Log.e("xxx", "processDateTodaySession() matchCard=" + sessionModel);
        if (sessionModel != null) {
            Log.e("xxx", "processDateTodaySession() -1");
            DateTodayManager.f32404a.a(DateTodayManager.Status.BE_MATCHED, sessionModel, null);
        } else {
            SessionModel c2 = DateTodayManager.f32404a.c();
            if (c2 != null) {
                if (c2.lastMsgFromId == 0) {
                    Log.e("xxx", "processDateTodaySession() -2");
                    DateTodayManager.f32404a.a(DateTodayManager.Status.COME_BACK_TOMORROW, null, null);
                } else {
                    for (SessionModel sessionModel3 : list) {
                        if (sessionModel3.sessionId == (-c2.lastMsgFromId) && sessionModel3.lastMsgType > 0 && sessionModel3.lastMsgType != 281) {
                            Log.e("xxx", "processDateTodaySession() -3");
                            DateTodayManager.f32404a.a(DateTodayManager.Status.COME_BACK_TOMORROW, null, null);
                        }
                    }
                }
            }
        }
        SessionModel a2 = DateTodayManager.f32404a.a(this.w, g());
        if (a2 != null) {
            Log.d("xxx", "add dateToday dateToday.lastMsgFromId=" + a2.lastMsgFromId + ", lastMsgContent=" + a2.lastMsgContent + ", lastMsgExtra=" + a2.lastMsgExtra);
            list.add(a2);
            K();
        }
        Log.e("xxx", "======================================================");
        c("processDateTodaySession", list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final SessionModel sessionModel) {
        if (!BluedSharedPreferences.a().a("IM_JOIN_YY_ROOM_LISTS_NOTIE", false) && YYChatRoomRecommend.f32453a.b() == 1) {
            LiveAlterDialog.a((Context) h(), (int) R.layout.dialog_notic_one_btn_layout, new View.OnClickListener() { // from class: com.soft.blued.ui.msg.presenter.MsgPresenter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                }
            }, new View.OnClickListener() { // from class: com.soft.blued.ui.msg.presenter.MsgPresenter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    BluedSharedPreferences.a().c().a("IM_JOIN_YY_ROOM_LISTS_NOTIE", true).b();
                    MsgPresenter.this.d(sessionModel);
                }
            }, true, true);
            return;
        }
        if (YYChatRoomRecommend.f32453a.b() == 1) {
            MessageProtos.Event event = MessageProtos.Event.MSG_YY_CLICK;
            String str = sessionModel.lastMsgExtra;
            EventTrackMessage.g(event, str, "" + sessionModel.lastMsgFromId);
            YYChatRoomsListFragment.f17120a.a(h(), "msg_yy_room", "0", "", sessionModel.lastMsgExtra);
        } else {
            MessageProtos.Event event2 = MessageProtos.Event.MSG_YY_CLICK;
            EventTrackMessage.g(event2, "", "" + sessionModel.lastMsgFromId);
            YYChatRoomsListFragment.f17120a.a(h(), "msg_yy_hall");
        }
        YYChatRoomRecommend.f32453a.e();
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(SessionModel sessionModel) {
        List<SessionModel> a2 = this.h.a();
        b(a2);
        if (sessionModel != null) {
            int i = 0;
            if (a2.size() > 0) {
                i = 0;
                if (a2.get(0).sessionType == 6668) {
                    i = 1;
                }
            }
            a2.add(i, sessionModel);
            K();
        }
        G();
    }

    private void e(boolean z) {
        if (!TextUtils.isEmpty(this.q)) {
            c(this.q, z);
            return;
        }
        a("dataUpdateFinish", (String) Integer.valueOf(s().size()));
        if (t() && z) {
            a("filterOpenHasNewMessage", this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(SessionModel sessionModel) {
        List<SessionModel> a2 = this.h.a();
        a(a2);
        if (sessionModel != null) {
            int i = 0;
            if (a2.size() > 0) {
                i = 0;
                if (a2.get(0).sessionType == 6668) {
                    i = 1;
                }
            }
            a2.add(i, sessionModel);
            EventTrackMessage.g(MessageProtos.Event.MSG_YY_SHOW, sessionModel.lastMsgExtra, "" + sessionModel.lastMsgFromId);
        }
        G();
    }

    public void A() {
        ChatManager.getInstance().registerSessionListener(this.r);
        ChatRelationDataManager.getInstance().registerChatRelationDataListener(this);
        DateTodayManager.f32404a.m();
    }

    public void B() {
        ChatManager.getInstance().unregisterSessionListener(this.r);
        ChatRelationDataManager.getInstance().unRegisterChatRelationDataListener(this);
    }

    public void C() {
        try {
            ChatRelationDataManager.getInstance().updateRelationData(new ChatRelationDataManager.UpdateRelationCallback() { // from class: com.soft.blued.ui.msg.presenter.MsgPresenter.9
                @Override // com.blued.android.module.chat.manager.ChatRelationDataManager.UpdateRelationCallback
                public void finish(int i, String str) {
                }
            });
        } catch (OutOfMemoryError e) {
            MemoryRequest.a().b();
        }
        H();
        YYChatRoomRecommend.f32453a.a(this.v, g());
        d(false);
    }

    public void D() {
        OnlineStatusManager.f32435a.b();
    }

    public void E() {
        MsgFilterManager.getInstance().setFilterSwitch(false, false, false);
        this.n = false;
        this.k = false;
        this.l = false;
        this.j = false;
        if (TextUtils.isEmpty(this.q)) {
            a("dataUpdateFinish", (String) Integer.valueOf(s().size()));
        } else {
            d(this.q);
        }
    }

    public SessionModel a(int i) {
        if (i < 0 || i >= s().size()) {
            return null;
        }
        return s().get(i);
    }

    public void a(final int i, final String str) {
        this.y = str;
        this.x = i;
        PayHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<VipUpgradeModel>>(g()) { // from class: com.soft.blued.ui.msg.presenter.MsgPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VipUpgradeModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    PayUtils.a(MsgPresenter.this.h(), i, str);
                } else {
                    MsgPresenter.this.a("showVipUpgradeDialog", (String) bluedEntityA.data);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str2, String str3) {
                PayUtils.a(MsgPresenter.this.h(), i, str);
                return true;
            }
        }, g());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        this.r = new MsgSessionListener();
        this.h = new MsgDataManager();
        ChatBgManager.a(UserInfo.getInstance().getLoginUserInfo().getUid());
        I();
        J();
        ArrayList arrayList = new ArrayList();
        arrayList.add(h().getString(2131890773));
        arrayList.add(h().getString(R.string.msg_item_delete));
        this.s = (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void a(SessionModel sessionModel) {
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 2 || BluedConfig.a().g().is_view_secretly != 0) {
            InstantLog.a("msg_view_secretly_click", 1);
            a(sessionModel, true);
            return;
        }
        InstantLog.a("msg_view_secretly_click", 0);
        a(6, "chat_msg_quiet_singe");
    }

    @Override // com.soft.blued.ui.msg.observer.RecvMsgListenerObserver.IRecvMsgListener
    public void a(SessionModel sessionModel, ChattingModel chattingModel) {
        if (t() && ChatHelperV4.a(sessionModel) && !this.h.e().contains(sessionModel)) {
            a("filterOpenHasNewMessage", this.m);
        }
    }

    public void a(SessionModel sessionModel, boolean z) {
        if (sessionModel == null) {
            return;
        }
        short s = sessionModel.sessionType;
        LogData logData = new LogData();
        logData.from = "none";
        if (s == 1) {
            if (sessionModel.sessionId != 2) {
                if (sessionModel.sessionId == 5) {
                    ChatHelperV4.a().a(h(), sessionModel.sessionId, sessionModel.maxHasReadMsgID);
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("passby_session_id", sessionModel.sessionId);
            bundle.putShort("passby_session_type", (short) 1);
            TerminalActivity.d(h(), GroupNotifyFragment.class, bundle);
        } else if (s == 2) {
            logData.details = this.u;
            this.u = "";
            if (sessionModel.sessionId < 0) {
                ChatHelperV4 a2 = ChatHelperV4.a();
                Activity h = h();
                long j = sessionModel.sessionId;
                String str = sessionModel.nickName;
                String str2 = sessionModel.avatar;
                int i = sessionModel.vBadge;
                int i2 = sessionModel.vipGrade;
                int i3 = sessionModel.vipAnnual;
                int i4 = sessionModel.vipExpLvl;
                a2.a(h, j, str, str2, i, i2, i3, i4, sessionModel.lastMsgFromDistance + "", z, 0, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE), -1L, -1L, false, true);
                return;
            }
            ChatHelperV4 a3 = ChatHelperV4.a();
            Activity h2 = h();
            long j2 = sessionModel.sessionId;
            String str3 = sessionModel.nickName;
            String str4 = sessionModel.avatar;
            int i5 = sessionModel.vBadge;
            int i6 = sessionModel.vipGrade;
            int i7 = sessionModel.vipAnnual;
            int i8 = sessionModel.vipExpLvl;
            a3.a(h2, j2, str3, str4, i5, i6, i7, i8, sessionModel.lastMsgFromDistance + "", z, 0, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
        } else if (s == 3) {
            logData.from = "msg_list";
            ChatHelperV4.a().a(h(), sessionModel.sessionId, sessionModel.nickName, sessionModel.avatar, sessionModel.vBadge, sessionModel.vipGrade, sessionModel.vipAnnual, sessionModel.vipExpLvl, "", false, 1, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
        } else if (s != 6668) {
        } else {
            if (sessionModel.sessionId == 1) {
                TerminalActivity.d(h(), MsgBoxFragment.class, null);
            } else if (sessionModel.sessionId == 2) {
                ServiceMsgFragment.b.a(h());
                EventTrackMessage.a(MessageProtos.Event.MSG_SERVICE_CELL_CLICK);
            } else if (sessionModel.sessionId == 3) {
                d(sessionModel);
            } else if (sessionModel.sessionId == 4) {
                DateTodayManager.f32404a.n();
                int i9 = AnonymousClass12.f32580a[DateTodayManager.f32404a.a().ordinal()];
                if (i9 == 1) {
                    DateTodayManager.f32404a.i();
                    DateTodaySearchFragment.f31701a.a(h());
                    return;
                }
                if (i9 == 2) {
                    DateTodayManager.f32404a.k();
                } else if (i9 != 3) {
                    if (i9 != 4) {
                        return;
                    }
                    ToastUtils.a(h().getString(R.string.date_today_finished));
                    return;
                }
                try {
                    DateTodayManager.f32404a.a(h(), (DateTodayMatchUserModel) AppInfo.f().fromJson(sessionModel.lastMsgExtra, (Class<Object>) DateTodayMatchUserModel.class));
                } catch (Exception e) {
                }
            }
        }
    }

    public void a(final SessionModel sessionModel, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                BottomMenuPop bottomMenuPop = new BottomMenuPop(h());
                this.t = bottomMenuPop;
                bottomMenuPop.b = arrayList;
                new XPopup.Builder(h()).a((BasePopupView) this.t).h();
                return;
            }
            final String str = strArr[i2];
            BottomMenuPop.MenuItemInfo menuItemInfo = new BottomMenuPop.MenuItemInfo();
            menuItemInfo.f11214a = str;
            if (TextUtils.equals(str, AppUtils.a(2131890773))) {
                menuItemInfo.f11215c = 2131233869;
            }
            if (TextUtils.equals(str, h().getResources().getString(R.string.msg_box_close))) {
                menuItemInfo.b = 2131101256;
            } else if (TextUtils.equals(str, h().getResources().getString(R.string.msg_box_clear))) {
                menuItemInfo.b = 2131101766;
            }
            menuItemInfo.d = new View.OnClickListener() { // from class: com.soft.blued.ui.msg.presenter.MsgPresenter.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (MsgPresenter.this.t != null) {
                        MsgPresenter.this.t.p();
                    }
                    if (TextUtils.equals(str, MsgPresenter.this.h().getResources().getString(2131890773))) {
                        MsgPresenter.this.a(sessionModel);
                        MessageProtos.Event event = MessageProtos.Event.MSG_LIST_OPERATE_VIEW_PRIVATE_CLICK;
                        MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
                        EventTrackMessage.a(event, strangerSource, sessionModel.sessionId + "");
                    } else if (TextUtils.equals(str, MsgPresenter.this.h().getResources().getString(R.string.msg_item_delete)) || TextUtils.equals(str, MsgPresenter.this.h().getResources().getString(R.string.msg_box_clear))) {
                        MsgPresenter.this.b(sessionModel);
                    } else if (TextUtils.equals(str, MsgPresenter.this.h().getResources().getString(R.string.msg_box_close))) {
                        MsgPresenter.this.w();
                    }
                }
            };
            arrayList.add(menuItemInfo);
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    public void a(boolean z) {
        MsgFilterManager.getInstance().setInitiatorSwitch(z);
        this.n = z;
        q();
        F();
    }

    public void b(SessionModel sessionModel) {
        if (sessionModel == null) {
            return;
        }
        Event c2 = BluedStatistics.c();
        c2.a("DELETE_SESSION_SUCCESS", 0L, 0, "user delete: " + sessionModel.sessionId);
        if (MsgBoxManager.a().a(sessionModel.sessionType, sessionModel.sessionId)) {
            CommonAlertDialog.a(h(), "", h().getResources().getString(R.string.msg_mute_box_clear), (String) null, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.presenter.MsgPresenter.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    ChatManager.getInstance().getSessionModelList(new FetchDataListener<List<SessionModel>>() { // from class: com.soft.blued.ui.msg.presenter.MsgPresenter.5.1
                        @Override // com.blued.android.chat.listener.FetchDataListener
                        /* renamed from: a */
                        public void onFetchData(List<SessionModel> list) {
                            for (SessionModel sessionModel2 : MsgBoxManager.a().a(list, true)) {
                                if (!MsgBoxManager.a().a(sessionModel2.sessionType, sessionModel2.sessionId) || sessionModel2.lastMsgFromId == 0) {
                                    MsgPresenter.this.b(sessionModel2);
                                } else {
                                    sessionModel2.lastMsgFromId = 0L;
                                }
                            }
                        }
                    });
                }
            }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else if (SubscribeNumberManager.f32449a.a(sessionModel.sessionType, sessionModel.sessionId)) {
            ChatManager.getInstance().getSessionModelList(new FetchDataListener<List<SessionModel>>() { // from class: com.soft.blued.ui.msg.presenter.MsgPresenter.6
                @Override // com.blued.android.chat.listener.FetchDataListener
                /* renamed from: a */
                public void onFetchData(List<SessionModel> list) {
                    for (SessionModel sessionModel2 : SubscribeNumberManager.f32449a.a(list, true)) {
                        if (SubscribeNumberManager.f32449a.a(sessionModel2.sessionId, sessionModel2.sessionType)) {
                            ChatManager.getInstance().deleteSession(sessionModel2.sessionType, sessionModel2.sessionId);
                        }
                    }
                }
            });
        } else if (!YYChatRoomRecommend.f32453a.a(sessionModel)) {
            ChatManager.getInstance().deleteSession(sessionModel.sessionType, sessionModel.sessionId);
        } else {
            a(this.h.a());
            G();
            YYChatRoomRecommend.f32453a.c();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void b(boolean z) {
        MsgFilterManager.getInstance().setFollowerSwitch(z);
        this.k = z;
        q();
        F();
    }

    public void c(boolean z) {
        MsgFilterManager.getInstance().setNearBySwitch(z);
        this.l = z;
        q();
        F();
    }

    public void d(String str) {
        c(str, false);
    }

    public void d(boolean z) {
        GroupStatusManager.f32419a.a(g(), new GroupStatusManager.OnSyncGroupStatusListener() { // from class: com.soft.blued.ui.msg.presenter.MsgPresenter.11
            @Override // com.soft.blued.ui.msg.manager.GroupStatusManager.OnSyncGroupStatusListener
            public List<String> a() {
                ArrayList arrayList = new ArrayList();
                for (SessionModel sessionModel : MsgPresenter.this.h.a()) {
                    if (sessionModel.sessionType == 3) {
                        arrayList.add(String.valueOf(sessionModel.sessionId));
                    }
                }
                return arrayList;
            }

            @Override // com.soft.blued.ui.msg.manager.GroupStatusManager.OnSyncGroupStatusListener
            public void b() {
                MsgPresenter.this.G();
            }
        }, z);
    }

    public void e(String str) {
        this.u = str;
    }

    public void m() {
        this.m = false;
        MsgPreferences.a();
    }

    public boolean n() {
        return this.n;
    }

    public boolean o() {
        return this.k;
    }

    @Override // com.blued.android.module.chat.contract.IChatRelationDataListener
    public void onDeleteSessions(List<Pair<Short, Long>> list) {
        if (list == null) {
            return;
        }
        for (Pair<Short, Long> pair : list) {
            Event c2 = BluedStatistics.c();
            c2.a("DELETE_SESSION_SUCCESS", 0L, 0, "server delete: " + pair.second);
        }
        a("showDeletedMsgHint", false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        SessionModel a2 = a(i - 2);
        if (a2 != null) {
            c(a2);
            if (BluedPreferences.av()) {
                a(a2);
            } else {
                a(a2, false);
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        SessionModel a2 = a(i - 2);
        if (a2 == null) {
            return true;
        }
        MessageProtos.Event event = MessageProtos.Event.MSG_LIST_OPERATE_SHOW;
        MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
        EventTrackMessage.a(event, strangerSource, a2.sessionId + "");
        if (a2.sessionType == 2) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(h().getString(2131890773));
            arrayList.add(h().getString(R.string.msg_item_delete));
            this.s = (String[]) arrayList.toArray(new String[arrayList.size()]);
        } else if (a2.sessionType == 3) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(h().getString(R.string.msg_item_delete));
            this.s = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
        } else if (a2.sessionType != 6668) {
            ArrayList arrayList3 = new ArrayList();
            if (a2.lastMsgFromId != 0) {
                arrayList3.add(h().getString(R.string.msg_box_clear));
            }
            arrayList3.add(h().getString(R.string.msg_box_close));
            this.s = (String[]) arrayList3.toArray(new String[arrayList3.size()]);
        } else if (a2.sessionId == 2 || a2.sessionId == 3) {
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(h().getString(R.string.msg_item_delete));
            this.s = (String[]) arrayList4.toArray(new String[arrayList4.size()]);
        } else if (a2.sessionId == 4) {
            return true;
        }
        a(a2, this.s);
        return true;
    }

    @Override // com.blued.android.module.chat.contract.FilterSessionListListener
    public void onUISessionDataChanged(List<SessionModel> list, List<SessionModel> list2) {
        if (t()) {
            ChatHelperV4.d(list);
            this.h.a(list);
            boolean z = true;
            this.i = true;
            if (!this.p) {
                G();
                return;
            }
            this.p = false;
            ChatHelperV4.a(list2, false);
            if (this.h.d(list2) <= 0) {
                z = false;
            }
            e(z);
        }
    }

    public boolean p() {
        return this.l;
    }

    public void q() {
        if (this.n || this.k || this.l) {
            this.j = true;
        } else {
            this.j = false;
        }
    }

    public List<SessionModel> r() {
        return t() ? this.h.e() : this.h.a();
    }

    public List<SessionModel> s() {
        return TextUtils.isEmpty(this.q) ? this.h.a() : this.h.b();
    }

    public boolean t() {
        return false;
    }

    public int u() {
        return this.x;
    }

    public String v() {
        return this.y;
    }

    public void w() {
        ToastUtils.a(h().getString(R.string.msg_mute_box_close));
        BluedPreferences.V(false);
        y();
    }

    public void x() {
        ArrayList arrayList = new ArrayList();
        for (SessionModel sessionModel : this.h.a()) {
            arrayList.add(new Pair(Short.valueOf(sessionModel.sessionType), Long.valueOf(sessionModel.sessionId)));
        }
        ChatManager.getInstance().ignoredNoReadNum(arrayList);
        SubscribeNumberManager.f32449a.c();
        DateTodayManager.f32404a.i();
    }

    public void y() {
        Logger.e("MsgPresent test", "refreshSessionList====" + this.h.d().size());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.h.d());
        RefreshSessionEvent refreshSessionEvent = new RefreshSessionEvent();
        refreshSessionEvent.list = new ArrayList();
        refreshSessionEvent.list.addAll(this.h.d());
        LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_UNREAD_MSG_CNT).post(refreshSessionEvent);
        this.r.onUISessionDataChanged(arrayList);
    }

    public void z() {
        UserHttpUtils.a(h(), new BluedUIHttpResponse<BluedEntity<UserFindResult, HelloDataExtra>>(g()) { // from class: com.soft.blued.ui.msg.presenter.MsgPresenter.8
            private boolean b = false;

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                this.b = true;
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                if (this.b) {
                    MsgPresenter.this.f_("hideHelloView");
                    MsgPresenter.this.a("helloViewShowBtn", (String) new Boolean(false));
                }
                MsgPresenter.this.f_("refreshComplete");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<UserFindResult, HelloDataExtra> bluedEntity) {
                if (bluedEntity == null) {
                    return;
                }
                HelloDataExtra helloDataExtra = bluedEntity.extra;
                boolean z = false;
                if (helloDataExtra == null) {
                    if (bluedEntity.hasData()) {
                        MsgPresenter.this.a("addHelloListData", (String) bluedEntity);
                    } else {
                        MsgPresenter.this.f_("hideHelloView");
                    }
                    MsgPresenter.this.a("helloViewShowBtn", (String) new Boolean(false));
                    return;
                }
                if (helloDataExtra.view_type == 2) {
                    MsgPresenter.this.a("setNewHelloView", (String) helloDataExtra);
                } else if (bluedEntity.hasData()) {
                    MsgPresenter.this.a("setNewHelloText", (String) helloDataExtra);
                    MsgPresenter.this.a("addHelloListData", (String) bluedEntity);
                } else {
                    MsgPresenter.this.f_("hideHelloView");
                }
                MsgPresenter msgPresenter = MsgPresenter.this;
                if (helloDataExtra.show_call_btn == 1) {
                    z = true;
                }
                msgPresenter.a("helloViewShowBtn", (String) new Boolean(z));
                if (helloDataExtra.show_call_btn == 1) {
                    CallHelloManager.a().a(MsgPresenter.this.h(), MsgPresenter.this.g(), 2, (CallHelloManager.ToOpenListener) null);
                }
            }
        }, "1", "15", "", "", "", g());
    }
}
