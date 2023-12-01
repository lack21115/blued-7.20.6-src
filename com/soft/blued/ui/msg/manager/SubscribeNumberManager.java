package com.soft.blued.ui.msg.manager;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.user.BluedConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/SubscribeNumberManager.class */
public final class SubscribeNumberManager {

    /* renamed from: a  reason: collision with root package name */
    public static final SubscribeNumberManager f32449a;
    private static final String b;

    /* renamed from: c  reason: collision with root package name */
    private static List<String> f32450c;
    private static List<String> d;
    private static int e;
    private static int f;

    static {
        SubscribeNumberManager subscribeNumberManager = new SubscribeNumberManager();
        f32449a = subscribeNumberManager;
        String simpleName = subscribeNumberManager.getClass().getSimpleName();
        Intrinsics.c(simpleName, "SubscribeNumberManager.javaClass.simpleName");
        b = simpleName;
        f32450c = new ArrayList();
        d = new ArrayList();
    }

    private SubscribeNumberManager() {
    }

    public final int a() {
        return e;
    }

    public final List<SessionModel> a(List<SessionModel> list, boolean z) {
        Intrinsics.e(list, "list");
        ArrayList<SessionModel> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        e = 0;
        f = 0;
        for (SessionModel sessionModel : list) {
            if (a(sessionModel.sessionId, sessionModel.sessionType) && sessionModel.sessionType == 2) {
                arrayList.add(sessionModel);
            } else {
                arrayList2.add(sessionModel);
            }
        }
        for (SessionModel sessionModel2 : arrayList) {
            SessionSettingBaseModel sessionSettingBaseModel = sessionModel2.sessionSettingModel;
            if (sessionSettingBaseModel instanceof SessionSettingModel) {
                if (((SessionSettingModel) sessionSettingBaseModel).getRemindAudio() == 1) {
                    arrayList3.add(String.valueOf(sessionModel2.sessionId));
                    SubscribeNumberManager subscribeNumberManager = f32449a;
                    subscribeNumberManager.b(subscribeNumberManager.b() + sessionModel2.noReadMsgCount);
                } else {
                    SubscribeNumberManager subscribeNumberManager2 = f32449a;
                    subscribeNumberManager2.a(subscribeNumberManager2.a() + sessionModel2.noReadMsgCount);
                }
            }
        }
        d.clear();
        d.addAll(arrayList3);
        if (!z && arrayList.size() > 0) {
            SessionModel sessionModel3 = new SessionModel();
            sessionModel3.sessionType = (short) 6668;
            sessionModel3.sessionId = 2L;
            if (e != 0 || f <= 0) {
                sessionModel3.noReadMsgCount = e;
            } else {
                sessionModel3.noReadMsgCount = -1;
            }
            SessionModel sessionModel4 = (SessionModel) arrayList.get(0);
            sessionModel3.lastMsgType = sessionModel4.lastMsgType;
            sessionModel3.lastMsgTime = sessionModel4.lastMsgTime;
            sessionModel3.lastMsgContent = sessionModel4.lastMsgContent;
            sessionModel3.lastMsgFromNickname = sessionModel4.lastMsgFromNickname;
            sessionModel3.lastMsgFromId = sessionModel4.lastMsgFromId;
            sessionModel3.lastMsgStateCode = sessionModel4.lastMsgStateCode;
            sessionModel3.lastMsgExtra = sessionModel4.lastMsgExtra;
            SessionSettingModel sessionSettingModel = new SessionSettingModel();
            sessionSettingModel.setRemindAudio(0);
            sessionModel3.sessionSettingModel = sessionSettingModel;
            arrayList2.add(0, sessionModel3);
        }
        return z ? arrayList : arrayList2;
    }

    public final void a(int i) {
        e = i;
    }

    public final boolean a(long j) {
        if (d.size() > 0) {
            return d.contains(String.valueOf(j));
        }
        return false;
    }

    public final boolean a(long j, short s) {
        boolean z = false;
        if (BluedConfig.a().b() != null) {
            if (BluedConfig.a().b().official_account == null) {
                return false;
            }
            z = false;
            if (BluedConfig.a().b().official_account.contains(String.valueOf(j))) {
                z = false;
                if (s == 2) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final boolean a(String str, Short sh) {
        List<String> list = f32450c;
        if ((list == null || list.isEmpty()) || TextUtils.isEmpty(str) || !CollectionsKt.a((Iterable<? extends String>) f32450c, str)) {
            return false;
        }
        return sh != null && sh.shortValue() == 2;
    }

    public final boolean a(short s, long j) {
        return s == 6668 && j == 2;
    }

    public final int b() {
        return f;
    }

    public final void b(int i) {
        f = i;
    }

    public final void c() {
        List<String> list = BluedConfig.a().b().official_account;
        if (list == null || list.isEmpty()) {
            return;
        }
        String obj = BluedConfig.a().b().official_account.toString();
        boolean z = false;
        if (obj.length() > 0) {
            z = true;
        }
        if (z) {
            String substring = obj.substring(1, obj.length() - 1);
            Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            ChatManager.getInstance().registerServiceMsgContentListener((short) 2, StringsKt.a(substring, " ", "", false, 4, (Object) null));
        }
    }

    public final void d() {
        AppConfigModel b2 = BluedConfig.a().b();
        List<String> officialAccount = b2.official_account;
        String str = b2.official_unique_account;
        if (b2 != null) {
            List<String> list = officialAccount;
            if ((list == null || list.isEmpty()) || str == null) {
                return;
            }
            f32450c.clear();
            List<String> list2 = f32450c;
            Intrinsics.c(officialAccount, "officialAccount");
            list2.addAll(list);
            f32450c.add(str);
        }
    }
}
