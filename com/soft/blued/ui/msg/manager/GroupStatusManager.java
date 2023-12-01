package com.soft.blued.ui.msg.manager;

import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.msg.manager.GroupStatusManager;
import com.soft.blued.ui.msg.model.GroupStatusInfo;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/GroupStatusManager.class */
public final class GroupStatusManager {
    private static OnSyncGroupStatusListener b;

    /* renamed from: c  reason: collision with root package name */
    private static IRequestHost f32420c;
    private static long d;

    /* renamed from: a  reason: collision with root package name */
    public static final GroupStatusManager f32419a = new GroupStatusManager();
    private static final HashMap<String, GroupStatusInfo> e = new HashMap<>();
    private static String f = "";
    private static final GroupStatusManager$syncRunnable$1 g = new Runnable() { // from class: com.soft.blued.ui.msg.manager.GroupStatusManager$syncRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            GroupStatusManager.OnSyncGroupStatusListener onSyncGroupStatusListener;
            List<String> a2;
            onSyncGroupStatusListener = GroupStatusManager.b;
            if (onSyncGroupStatusListener != null && (a2 = onSyncGroupStatusListener.a()) != null && (!a2.isEmpty())) {
                GroupStatusManager.f32419a.a(a2);
            }
            AppInfo.n().postDelayed(this, 300000L);
        }
    };

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/GroupStatusManager$OnSyncGroupStatusListener.class */
    public interface OnSyncGroupStatusListener {
        List<String> a();

        void b();
    }

    private GroupStatusManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<String> list) {
        final IRequestHost iRequestHost = f32420c;
        ChatHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<GroupStatusInfo>>(iRequestHost) { // from class: com.soft.blued.ui.msg.manager.GroupStatusManager$syncOnlineStatusFromNetwork$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<GroupStatusInfo> bluedEntityA) {
                GroupStatusManager.OnSyncGroupStatusListener onSyncGroupStatusListener;
                HashMap hashMap;
                if (bluedEntityA == null) {
                    return;
                }
                List<GroupStatusInfo> data = bluedEntityA.data;
                Intrinsics.c(data, "data");
                if (!data.isEmpty()) {
                    List<GroupStatusInfo> data2 = bluedEntityA.data;
                    Intrinsics.c(data2, "data");
                    for (GroupStatusInfo it : data2) {
                        if (it.getGroup_id().length() > 0) {
                            hashMap = GroupStatusManager.e;
                            HashMap hashMap2 = hashMap;
                            String group_id = it.getGroup_id();
                            Intrinsics.c(it, "it");
                            hashMap2.put(group_id, it);
                        }
                    }
                    onSyncGroupStatusListener = GroupStatusManager.b;
                    if (onSyncGroupStatusListener == null) {
                        return;
                    }
                    onSyncGroupStatusListener.b();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return true;
            }
        }, list, f32420c);
    }

    private final void c() {
        String str;
        d = 0L;
        e.clear();
        BluedLoginResult loginUserInfo = UserInfo.getInstance().getLoginUserInfo();
        if (loginUserInfo != null) {
            String str2 = loginUserInfo.uid;
            if (!(str2 == null || str2.length() == 0)) {
                str = loginUserInfo.uid;
                Intrinsics.c(str, "{\n            loginInfo.uid\n        }");
                f = str;
            }
        }
        str = "";
        f = str;
    }

    public final GroupStatusInfo a(Long l) {
        if (l == null) {
            return null;
        }
        return e.get(String.valueOf(l.longValue()));
    }

    public final void a(IRequestHost iRequestHost, OnSyncGroupStatusListener onSyncGroupStatusListener, boolean z) {
        if (!Intrinsics.a((Object) f, (Object) UserInfo.getInstance().getLoginUserInfo().uid)) {
            c();
        }
        f32420c = iRequestHost;
        b = onSyncGroupStatusListener;
        if (d + 300000 <= System.currentTimeMillis() || z) {
            d = System.currentTimeMillis();
            AppInfo.n().post(g);
        }
    }
}
