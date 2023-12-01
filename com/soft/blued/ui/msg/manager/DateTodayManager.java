package com.soft.blued.ui.msg.manager;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.das.message.MessageProtos;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.soft.blued.R;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.ui.msg.model.DateTodayConfigModel;
import com.soft.blued.ui.msg.model.DateTodayMatchModel;
import com.soft.blued.ui.msg.model.DateTodayMatchUserModel;
import com.soft.blued.ui.msg.model.DateTodayQualificationModel;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/DateTodayManager.class */
public final class DateTodayManager {

    /* renamed from: a  reason: collision with root package name */
    public static final DateTodayManager f32404a = new DateTodayManager();
    private static Status b = Status.NULL;

    /* renamed from: c  reason: collision with root package name */
    private static DateTodayConfigModel f32405c;
    private static SessionModel d;
    private static long e;
    private static boolean f;
    private static boolean g;
    private static boolean h;
    private static String i;
    private static String j;
    private static String k;
    private static float l;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/DateTodayManager$OnFinishListener.class */
    public interface OnFinishListener {
        void onFinish(SessionModel sessionModel);
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/DateTodayManager$Status.class */
    public enum Status {
        NULL,
        UNAVAILABLE,
        HAVE_CHANCE,
        MATCHED,
        BE_MATCHED,
        COME_BACK_TOMORROW
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/DateTodayManager$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32408a;

        static {
            int[] iArr = new int[Status.values().length];
            iArr[Status.HAVE_CHANCE.ordinal()] = 1;
            iArr[Status.MATCHED.ordinal()] = 2;
            iArr[Status.BE_MATCHED.ordinal()] = 3;
            iArr[Status.COME_BACK_TOMORROW.ordinal()] = 4;
            iArr[Status.UNAVAILABLE.ordinal()] = 5;
            f32408a = iArr;
        }
    }

    private DateTodayManager() {
    }

    private final String A() {
        int i2 = WhenMappings.f32408a[b.ordinal()];
        String str = "";
        if (i2 == 1) {
            j = "";
            str = "no_request";
        } else if (i2 == 2 || i2 == 3) {
            return "request_match";
        } else {
            if (i2 == 4) {
                return "request_chat";
            }
            if (i2 != 5) {
                return i;
            }
        }
        return str;
    }

    private final String B() {
        return UserInfo.getInstance().getLoginUserInfo().uid;
    }

    private final String C() {
        return Intrinsics.a("date_today_next_update_time_", (Object) B());
    }

    private final long D() {
        return i(C());
    }

    private final String E() {
        return "date_today_guide_shown";
    }

    private final boolean F() {
        return g(E());
    }

    private final void G() {
        a(E(), true);
    }

    private final String H() {
        return Intrinsics.a("date_today_status_", (Object) B());
    }

    private final Status I() {
        return Status.values()[h(H())];
    }

    private final String J() {
        return Intrinsics.a("date_today_session_", (Object) B());
    }

    private final String K() {
        return j(J());
    }

    private final String L() {
        return Intrinsics.a("date_today_purpose_", (Object) B());
    }

    private final String M() {
        return Intrinsics.a("date_today_purpose_shown_time_", (Object) B());
    }

    private final String N() {
        return Intrinsics.a("date_today_fake_avatar_num_", (Object) B());
    }

    private final String O() {
        return Intrinsics.a("date_today_remaining_times_", (Object) B());
    }

    private final int P() {
        return h(O());
    }

    private final String Q() {
        return "date_today_evaluation_function_next_show_time";
    }

    private final long R() {
        return i(Q());
    }

    private final String S() {
        return Intrinsics.a("date_today_purpose_", (Object) B());
    }

    private final String T() {
        return Intrinsics.a("date_today_first_chat_", (Object) B());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U() {
        h = !f32404a.F();
        d = f32404a.y();
        b = f32404a.I();
        e = f32404a.D();
        f = false;
        ChatHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<DateTodayConfigModel>>() { // from class: com.soft.blued.ui.msg.manager.DateTodayManager$getConfig$1$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<DateTodayConfigModel> bluedEntityA) {
                List<DateTodayConfigModel> list;
                if (bluedEntityA == null || (list = bluedEntityA.data) == null || list.size() <= 0) {
                    return;
                }
                DateTodayManager dateTodayManager = DateTodayManager.f32404a;
                DateTodayManager.f32405c = list.get(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str) {
                return true;
            }
        });
    }

    public static /* synthetic */ SessionModel a(DateTodayManager dateTodayManager, Status status, SessionModel sessionModel, DateTodayMatchModel dateTodayMatchModel, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            sessionModel = null;
        }
        if ((i2 & 4) != 0) {
            dateTodayMatchModel = null;
        }
        return dateTodayManager.a(status, sessionModel, dateTodayMatchModel);
    }

    @JvmStatic
    public static final void a(ChattingModel chattingModel) {
        Intrinsics.e(chattingModel, "chattingModel");
        try {
            chattingModel.isMatchMsg = 1;
            String msgExtra = chattingModel.getMsgExtra();
            Intrinsics.c(msgExtra, "chattingModel.getMsgExtra()");
            String str = msgExtra;
            if (TextUtils.isEmpty(msgExtra)) {
                str = "{}";
            }
            JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
            if (!asJsonObject.has("is_match_msg")) {
                asJsonObject.addProperty("is_match_msg", (Number) 1);
            }
            chattingModel.setMsgExtra(asJsonObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final void a(SessionModel sessionModel, DateTodayMatchModel dateTodayMatchModel) {
        if (dateTodayMatchModel.getTarget_info() == null || dateTodayMatchModel.getSelf_info() == null) {
            return;
        }
        DateTodayMatchUserModel self_info = Intrinsics.a((Object) String.valueOf(d(dateTodayMatchModel.getTarget_info().getUid())), (Object) B()) ? dateTodayMatchModel.getSelf_info() : dateTodayMatchModel.getTarget_info();
        sessionModel.lastMsgTime = dateTodayMatchModel.getTime();
        long d2 = d(self_info.getUid());
        sessionModel.lastMsgFromId = d2;
        try {
            sessionModel.lastMsgExtra = AppInfo.f().toJson(self_info);
        } catch (Exception e2) {
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
        String string = AppInfo.d().getResources().getString(R.string.date_today_desc21);
        Intrinsics.c(string, "getAppContext().resource…string.date_today_desc21)");
        String format = String.format(string, Arrays.copyOf(new Object[]{a(self_info)}, 1));
        Intrinsics.c(format, "format(format, *args)");
        List<String> same_point_friends_purpose = dateTodayMatchModel.getSame_point_friends_purpose();
        if (!(same_point_friends_purpose == null || same_point_friends_purpose.isEmpty())) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f42549a;
            String string2 = AppInfo.d().getResources().getString(R.string.date_today_desc22);
            Intrinsics.c(string2, "getAppContext().resource…string.date_today_desc22)");
            Intrinsics.c(String.format(string2, Arrays.copyOf(new Object[]{StringUtils.a(dateTodayMatchModel.getSame_point_friends_purpose())}, 1)), "format(format, *args)");
        }
        sessionModel.lastMsgContent = format + "" + AppInfo.d().getResources().getString(R.string.date_today_desc23);
        j = String.valueOf(d2);
        l = dateTodayMatchModel.getScore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final IRequestHost iRequestHost, final OnFinishListener onFinishListener) {
        ChatHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<DateTodayQualificationModel>>(onFinishListener) { // from class: com.soft.blued.ui.msg.manager.DateTodayManager$getDatingTodaySession$1$1
            final /* synthetic */ DateTodayManager.OnFinishListener b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = onFinishListener;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<DateTodayQualificationModel> bluedEntityA) {
                List<DateTodayQualificationModel> list;
                if (bluedEntityA != null && (list = bluedEntityA.data) != null && list.size() > 0) {
                    DateTodayQualificationModel dateTodayQualificationModel = list.get(0);
                    Log.e("xxx", "getDatingTodaySession [enable=" + dateTodayQualificationModel.getEnable() + ", residue_degree=" + dateTodayQualificationModel.getResidue_degree() + ']');
                    DateTodayManager dateTodayManager = DateTodayManager.f32404a;
                    DateTodayManager.e = dateTodayQualificationModel.getExpire_time() * ((long) 1000);
                    DateTodayManager.f32404a.i(DateTodayManager.f32404a.d());
                    DateTodayManager.f32404a.b(dateTodayQualificationModel.getResidue_degree());
                    if (dateTodayQualificationModel.getEnable() == 1) {
                        if (dateTodayQualificationModel.getResidue_degree() > 0) {
                            DateTodayManager.a(DateTodayManager.f32404a, DateTodayManager.Status.HAVE_CHANCE, null, null, 6, null);
                            return;
                        }
                        SessionModel c2 = DateTodayManager.f32404a.c();
                        if (c2 != null && c2.lastMsgType == 281 && c2.lastMsgTime < DateTodayManager.f32404a.d()) {
                            Log.w("xxx", "getDatingTodaySession keep current state!!");
                            return;
                        } else {
                            DateTodayManager.a(DateTodayManager.f32404a, DateTodayManager.Status.COME_BACK_TOMORROW, null, null, 6, null);
                            return;
                        }
                    }
                }
                Log.e("xxx", "getDatingTodaySession() onUIUpdate()");
                DateTodayManager.a(DateTodayManager.f32404a, DateTodayManager.Status.UNAVAILABLE, null, null, 6, null);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str) {
                Log.e("xxx", "getDatingTodaySession() onUIFailure");
                DateTodayManager.a(DateTodayManager.f32404a, DateTodayManager.Status.UNAVAILABLE, null, null, 6, null);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DateTodayManager dateTodayManager = DateTodayManager.f32404a;
                DateTodayManager.f = false;
                DateTodayManager.OnFinishListener onFinishListener2 = this.b;
                if (onFinishListener2 == null) {
                    return;
                }
                onFinishListener2.onFinish(DateTodayManager.f32404a.c());
            }
        }, iRequestHost);
    }

    private final void a(Status status) {
        a(H(), status.ordinal());
    }

    private final void a(String str, int i2) {
        BluedPreferences.a().c().a(str, i2).b();
    }

    private final void a(String str, long j2) {
        BluedPreferences.a().c().a(str, j2).b();
    }

    private final void a(String str, String str2) {
        BluedPreferences.a().c().a(str, str2).b();
    }

    private final void a(String str, boolean z) {
        BluedPreferences.a().c().a(str, z).b();
    }

    private final DateTodayMatchModel b(SessionModel sessionModel) {
        String str;
        DateTodayMatchModel dateTodayMatchModel;
        Long valueOf;
        DateTodayMatchModel dateTodayMatchModel2 = null;
        if (sessionModel == null) {
            str = null;
        } else {
            try {
                str = sessionModel.lastMsgExtra;
            } catch (Exception e2) {
                e = e2;
                dateTodayMatchModel = null;
                e.printStackTrace();
                dateTodayMatchModel2 = dateTodayMatchModel;
                return dateTodayMatchModel2;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            DateTodayMatchModel dateTodayMatchModel3 = (DateTodayMatchModel) AppInfo.f().fromJson(str, (Class<Object>) DateTodayMatchModel.class);
            if (sessionModel == null) {
                valueOf = null;
            } else {
                try {
                    valueOf = Long.valueOf(sessionModel.lastMsgTime);
                } catch (Exception e3) {
                    dateTodayMatchModel = dateTodayMatchModel3;
                    e = e3;
                    e.printStackTrace();
                    dateTodayMatchModel2 = dateTodayMatchModel;
                    return dateTodayMatchModel2;
                }
            }
            dateTodayMatchModel3.setTime(valueOf == null ? System.currentTimeMillis() : valueOf.longValue());
            return dateTodayMatchModel3;
        }
        return dateTodayMatchModel2;
    }

    private final String c(boolean z, long j2) {
        StringBuilder sb;
        if (z) {
            sb = new StringBuilder();
            sb.append((Object) B());
            sb.append('-');
            sb.append(j2);
        } else {
            sb = new StringBuilder();
            sb.append(j2);
            sb.append('-');
            sb.append((Object) B());
        }
        return Intrinsics.a("date_today_interested_", (Object) sb.toString());
    }

    private final void c(SessionModel sessionModel) {
        String json;
        if (sessionModel == null) {
            json = "";
        } else {
            try {
                json = AppInfo.f().toJson(sessionModel);
            } catch (Exception e2) {
                return;
            }
        }
        Intrinsics.c(json, "if (session == null) {\n …on(session)\n            }");
        f(json);
    }

    private final void d(boolean z, long j2) {
        k(c(z, j2));
    }

    private final void f(String str) {
        a(J(), str);
    }

    private final boolean g(String str) {
        return BluedPreferences.a().a(str, false);
    }

    private final int h(String str) {
        return BluedPreferences.a().b(str, 0);
    }

    private final long i(String str) {
        return BluedPreferences.a().a(str, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(long j2) {
        a(C(), j2);
    }

    private final String j(long j2) {
        return "date_today_user_evaluation_message_" + ((Object) B()) + '_' + j2;
    }

    private final String j(String str) {
        return BluedPreferences.a().a(str, "");
    }

    private final String k(long j2) {
        return "date_today_user_evaluation_" + ((Object) B()) + '_' + j2;
    }

    private final void k(String str) {
        BluedPreferences.a().c().a(str).b();
    }

    private final SessionModel y() {
        try {
            String K = K();
            if (K == null) {
                return null;
            }
            return (SessionModel) AppInfo.f().fromJson(K, (Class<Object>) SessionModel.class);
        } catch (Exception e2) {
            return null;
        }
    }

    private final SessionModel z() {
        SessionModel sessionModel = new SessionModel();
        sessionModel.sessionType = (short) 6668;
        sessionModel.sessionId = 4L;
        sessionModel.lastMsgTime = System.currentTimeMillis();
        String B = B();
        Intrinsics.c(B, "getUid()");
        sessionModel.lastMsgFromId = Long.parseLong(B);
        sessionModel.lastMsgFromNickname = AppInfo.d().getString(R.string.date_today_title);
        return sessionModel;
    }

    public final SessionModel a(final OnFinishListener onFinishListener, final IRequestHost iRequestHost) {
        if (System.currentTimeMillis() < e || f) {
            return d;
        }
        f = true;
        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.manager.-$$Lambda$DateTodayManager$P2tzcHBbgV3TobxGsTKfyMM01UY
            @Override // java.lang.Runnable
            public final void run() {
                DateTodayManager.a(IRequestHost.this, onFinishListener);
            }
        });
        return null;
    }

    public final SessionModel a(Status nextStatus, SessionModel sessionModel, DateTodayMatchModel dateTodayMatchModel) {
        Intrinsics.e(nextStatus, "nextStatus");
        if (nextStatus != b) {
            StringBuilder sb = new StringBuilder();
            sb.append("changeStatus=");
            sb.append(nextStatus.name());
            sb.append(", session==null:");
            sb.append(sessionModel == null);
            sb.append(", model==null:");
            sb.append(dateTodayMatchModel == null);
            Log.e("xxx", sb.toString());
            SessionModel z = nextStatus == Status.UNAVAILABLE ? null : z();
            d = z;
            if (z != null) {
                int i2 = WhenMappings.f32408a[nextStatus.ordinal()];
                if (i2 == 1) {
                    z.noReadMsgCount = 1;
                    z.lastMsgContent = AppInfo.d().getString(R.string.date_today_desc1);
                } else if (i2 == 2) {
                    z.noReadMsgCount = 0;
                    z.lastMsgType = (short) 281;
                    if (dateTodayMatchModel == null) {
                        DateTodayMatchModel b2 = f32404a.b(sessionModel);
                        if (b2 != null) {
                            f32404a.a(z, b2);
                        }
                    } else {
                        f32404a.a(z, dateTodayMatchModel);
                    }
                } else if (i2 == 3) {
                    z.noReadMsgCount = 1;
                    z.lastMsgType = (short) 281;
                    DateTodayMatchModel b3 = f32404a.b(sessionModel);
                    if (b3 != null) {
                        f32404a.a(z, b3);
                    }
                } else if (i2 == 4) {
                    String B = f32404a.B();
                    Intrinsics.c(B, "getUid()");
                    z.lastMsgFromId = Long.parseLong(B);
                    z.noReadMsgCount = 0;
                    z.lastMsgContent = AppInfo.d().getString(R.string.date_today_finished);
                }
            }
            b = nextStatus;
            a(nextStatus);
            c(d);
            m();
        }
        return d;
    }

    public final Status a() {
        return b;
    }

    public final String a(DateTodayMatchUserModel userInfo) {
        Intrinsics.e(userInfo, "userInfo");
        StringBuilder sb = new StringBuilder();
        if (userInfo.getAge() > 0) {
            sb.append(userInfo.getAge());
        }
        sb.append(BridgeUtil.SPLIT_MARK);
        if (userInfo.getHeight() > 0) {
            sb.append(StringUtils.a(String.valueOf(userInfo.getHeight()), BlueAppLocal.c(), true));
        }
        sb.append(BridgeUtil.SPLIT_MARK);
        if (userInfo.getWeight() > 0) {
            sb.append(StringUtils.b(String.valueOf(userInfo.getWeight()), BlueAppLocal.c(), true));
        }
        sb.append(BridgeUtil.SPLIT_MARK);
        sb.append(StringUtils.e(String.valueOf(userInfo.getRole())));
        String sb2 = sb.toString();
        Intrinsics.c(sb2, "sBuilder.toString()");
        return sb2;
    }

    public final void a(int i2) {
        a(N(), i2);
    }

    public final void a(long j2) {
        SessionModel sessionModel = d;
        if (sessionModel == null) {
            return;
        }
        Log.e("xxx", "exitChatting() sessionId=" + j2 + ", it.lastMsgFromId=" + sessionModel.lastMsgFromId);
        if (sessionModel.lastMsgFromId == (-j2)) {
            a(f32404a, Status.COME_BACK_TOMORROW, null, null, 6, null);
        }
    }

    public final void a(Context context, DateTodayMatchUserModel targetInfo) {
        Intrinsics.e(context, "context");
        Intrinsics.e(targetInfo, "targetInfo");
        a(context, targetInfo.getName(), d(targetInfo.getUid()), targetInfo.getAvatar());
    }

    public final void a(Context context, String str, long j2, String str2) {
        Intrinsics.e(context, "context");
        LogData logData = new LogData();
        logData.from = "none";
        ChatHelperV4 a2 = ChatHelperV4.a();
        long j3 = -j2;
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        a2.a(context, j3, str, str2, 0, 0, 0, 0, "", false, 0, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""), -1L, -1L, false, true);
    }

    public final void a(MessageProtos.Event event) {
        Intrinsics.e(event, "event");
        EventTrackMessage.i(event, j, k);
    }

    public final void a(String str) {
        i = str;
    }

    public final void a(boolean z) {
        g = z;
    }

    public final boolean a(SessionModel session) {
        Intrinsics.e(session, "session");
        return session.sessionType == 6668 && session.sessionId == 4;
    }

    public final boolean a(boolean z, long j2) {
        return g(c(z, j2));
    }

    public final DateTodayConfigModel b() {
        return f32405c;
    }

    public final void b(int i2) {
        a(O(), i2);
    }

    public final void b(long j2) {
        d(true, j2);
        d(false, j2);
    }

    public final void b(String distance) {
        Intrinsics.e(distance, "distance");
        k = distance;
        if (w()) {
            return;
        }
        x();
        EventTrackMessage.a(j, distance, l);
    }

    public final void b(boolean z, long j2) {
        a(c(z, j2), true);
    }

    public final SessionModel c() {
        return d;
    }

    public final String c(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        return charAt + "***";
    }

    public final void c(int i2) {
        a(t(), i2);
    }

    public final void c(long j2) {
        a(M(), j2);
    }

    public final long d() {
        return e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
        if (kotlin.text.StringsKt.a((java.lang.CharSequence) r8, 'e', 0, false, 6, (java.lang.Object) null) >= 0) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long d(java.lang.String r8) {
        /*
            r7 = this;
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L1d
            r0 = r12
            int r0 = r0.length()
            if (r0 != 0) goto L18
            goto L1d
        L18:
            r0 = 0
            r9 = r0
            goto L1f
        L1d:
            r0 = 1
            r9 = r0
        L1f:
            r0 = r9
            if (r0 == 0) goto L25
            r0 = 0
            return r0
        L25:
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> L67
            r1 = 69
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            int r0 = kotlin.text.StringsKt.a(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L67
            if (r0 >= 0) goto L4a
            r0 = r8
            r12 = r0
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> L67
            r1 = 101(0x65, float:1.42E-43)
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            int r0 = kotlin.text.StringsKt.a(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L67
            if (r0 < 0) goto L57
        L4a:
            java.math.BigDecimal r0 = new java.math.BigDecimal     // Catch: java.lang.Exception -> L67 java.lang.Exception -> L67
            r1 = r0
            r2 = r8
            r1.<init>(r2)     // Catch: java.lang.Exception -> L67
            java.lang.String r0 = r0.toPlainString()     // Catch: java.lang.Exception -> L67
            r12 = r0
        L57:
            r0 = r12
            java.lang.String r1 = "if (uid.indexOf('E') >= …    uid\n                }"
            kotlin.jvm.internal.Intrinsics.c(r0, r1)     // Catch: java.lang.Exception -> L67
            r0 = r12
            long r0 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Exception -> L67
            r10 = r0
            r0 = r10
            return r0
        L67:
            r8 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.manager.DateTodayManager.d(java.lang.String):long");
    }

    public final boolean d(long j2) {
        return g(j(j2));
    }

    public final void e(long j2) {
        a(j(j2), true);
    }

    public final void e(String text) {
        Intrinsics.e(text, "text");
        a(S(), text);
    }

    public final boolean e() {
        return g;
    }

    public final boolean f() {
        return h;
    }

    public final boolean f(long j2) {
        return g(k(j2));
    }

    public final void g() {
        h = false;
        G();
    }

    public final void g(long j2) {
        a(k(j2), true);
    }

    public final void h() {
        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.manager.-$$Lambda$DateTodayManager$vms-S0PL2LghoVuV5os5ZE0pn5Q
            @Override // java.lang.Runnable
            public final void run() {
                DateTodayManager.U();
            }
        });
    }

    public final void i() {
        SessionModel sessionModel = d;
        if (sessionModel == null) {
            return;
        }
        sessionModel.noReadMsgCount = 0;
        f32404a.c(sessionModel);
    }

    public final int j() {
        SessionModel sessionModel = d;
        if (sessionModel == null) {
            return 0;
        }
        return sessionModel.noReadMsgCount;
    }

    public final void k() {
        int P = P();
        if (P > 0) {
            b(P - 1);
        }
        i();
    }

    public final long l() {
        long R = R();
        long j2 = R;
        if (R == 0) {
            j2 = s();
        }
        return j2;
    }

    public final void m() {
        String A = A();
        String str = A;
        if (str == null || str.length() == 0) {
            return;
        }
        EventTrackMessage.h(MessageProtos.Event.MSG_LIST_MATCH_SHOW, j, A);
    }

    public final void n() {
        String A = A();
        String str = A;
        if (str == null || str.length() == 0) {
            return;
        }
        EventTrackMessage.h(MessageProtos.Event.MSG_LIST_MATCH_CLICK, j, A);
    }

    public final boolean o() {
        return g(L());
    }

    public final void p() {
        a(L(), true);
    }

    public final long q() {
        return i(M());
    }

    public final int r() {
        return h(N());
    }

    public final long s() {
        long currentTimeMillis = System.currentTimeMillis() + ((long) BaseConstants.Time.WEEK);
        a(Q(), currentTimeMillis);
        return currentTimeMillis;
    }

    public final String t() {
        return "date_today_evaluation_function_pop_show_times";
    }

    public final int u() {
        return h(t());
    }

    public final String v() {
        return j(S());
    }

    public final boolean w() {
        return g(T());
    }

    public final void x() {
        a(T(), true);
    }
}
