package com.soft.blued.ui.msg.manager;

import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.statistics.BluedStatistics;
import com.blued.das.message.MessageProtos;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.msg.manager.OnlineStatusManager;
import com.soft.blued.ui.msg.model.ChatOnlineStatusModel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/OnlineStatusManager.class */
public final class OnlineStatusManager {
    private static OnSyncOnlineStatusListener b;

    /* renamed from: c  reason: collision with root package name */
    private static IRequestHost f18746c;
    private static long d;

    /* renamed from: a  reason: collision with root package name */
    public static final OnlineStatusManager f18745a = new OnlineStatusManager();
    private static final HashMap<String, ChatOnlineStatusModel> e = new HashMap<>();
    private static final HashSet<Long> f = new HashSet<>();
    private static String g = "";
    private static final OnlineStatusManager$syncRunnable$1 h = new Runnable() { // from class: com.soft.blued.ui.msg.manager.OnlineStatusManager$syncRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            OnlineStatusManager.OnSyncOnlineStatusListener onSyncOnlineStatusListener;
            List<String> a2;
            onSyncOnlineStatusListener = OnlineStatusManager.b;
            if (onSyncOnlineStatusListener != null && (a2 = onSyncOnlineStatusListener.a()) != null && (!a2.isEmpty())) {
                OnlineStatusManager.f18745a.a(a2);
            }
            AppInfo.n().postDelayed(this, 300000L);
        }
    };

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/OnlineStatusManager$OnSyncOnlineStatusListener.class */
    public interface OnSyncOnlineStatusListener {
        List<String> a();

        void b();
    }

    private OnlineStatusManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<String> list) {
        final IRequestHost iRequestHost = f18746c;
        ChatHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<ChatOnlineStatusModel>>(iRequestHost) { // from class: com.soft.blued.ui.msg.manager.OnlineStatusManager$syncOnlineStatusFromNetwork$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ChatOnlineStatusModel> bluedEntityA) {
                HashSet hashSet;
                OnlineStatusManager.OnSyncOnlineStatusListener onSyncOnlineStatusListener;
                HashMap hashMap;
                if (bluedEntityA == null) {
                    return;
                }
                List list2 = bluedEntityA.data;
                Intrinsics.c(list2, "data");
                if (!list2.isEmpty()) {
                    List<ChatOnlineStatusModel> list3 = bluedEntityA.data;
                    Intrinsics.c(list3, "data");
                    for (ChatOnlineStatusModel chatOnlineStatusModel : list3) {
                        if (chatOnlineStatusModel.getUid().length() > 0) {
                            hashMap = OnlineStatusManager.e;
                            HashMap hashMap2 = hashMap;
                            String uid = chatOnlineStatusModel.getUid();
                            Intrinsics.c(chatOnlineStatusModel, "it");
                            hashMap2.put(uid, chatOnlineStatusModel);
                        }
                    }
                    hashSet = OnlineStatusManager.f;
                    hashSet.clear();
                    onSyncOnlineStatusListener = OnlineStatusManager.b;
                    if (onSyncOnlineStatusListener == null) {
                        return;
                    }
                    onSyncOnlineStatusListener.b();
                }
            }

            public boolean onUIFailure(int i, String str) {
                return true;
            }
        }, list, f18746c);
    }

    private final void f() {
        String str;
        d = 0L;
        e.clear();
        f.clear();
        BluedLoginResult loginUserInfo = UserInfo.getInstance().getLoginUserInfo();
        if (loginUserInfo != null) {
            String str2 = loginUserInfo.uid;
            if (!(str2 == null || str2.length() == 0)) {
                str = loginUserInfo.uid;
                Intrinsics.c(str, "{\n            loginInfo.uid\n        }");
                g = str;
            }
        }
        str = "";
        g = str;
    }

    public final ChatOnlineStatusModel a(Long l) {
        if (l == null) {
            return null;
        }
        return e.get(String.valueOf(l.longValue()));
    }

    public final String a(Integer num) {
        return (num != null && num.intValue() == 2) ? "live" : (num != null && num.intValue() == 3) ? "yy" : "user";
    }

    public final void a(SessionModel sessionModel, ChatOnlineStatusModel chatOnlineStatusModel) {
        Intrinsics.e(sessionModel, "sessionModel");
        if (sessionModel.sessionType == 2 && !f.contains(Long.valueOf(sessionModel.sessionId))) {
            f.add(Long.valueOf(sessionModel.sessionId));
            if (chatOnlineStatusModel != null) {
                EventTrackMessage.d(MessageProtos.Event.MSG_USER_SHOW, a(Integer.valueOf(chatOnlineStatusModel.getSocial_status())), Intrinsics.a("", Long.valueOf(sessionModel.sessionId)), Intrinsics.a("", Long.valueOf(chatOnlineStatusModel.getSource_id())));
            } else {
                EventTrackMessage.d(MessageProtos.Event.MSG_USER_SHOW, a((Integer) 0), Intrinsics.a("", Long.valueOf(sessionModel.sessionId)), "");
            }
        }
    }

    public final void a(IRequestHost iRequestHost, OnSyncOnlineStatusListener onSyncOnlineStatusListener) {
        if (!Intrinsics.a(g, UserInfo.getInstance().getLoginUserInfo().uid)) {
            f();
        }
        if (a()) {
            f18746c = iRequestHost;
            b = onSyncOnlineStatusListener;
            if (d + 300000 > System.currentTimeMillis()) {
                return;
            }
            d = System.currentTimeMillis();
            AppInfo.n().post(h);
        }
    }

    public final boolean a() {
        return BluedStatistics.g().a("0131_消息列表及私聊对话页展示在线绿点及状态展示_chatOnlineStatus", "").equals("experimentalGroup1");
    }

    public final void b() {
        AppInfo.n().removeCallbacks(h);
    }
}
