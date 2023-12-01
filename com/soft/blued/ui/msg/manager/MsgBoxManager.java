package com.soft.blued.ui.msg.manager;

import android.text.TextUtils;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.R;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/MsgBoxManager.class */
public class MsgBoxManager {

    /* renamed from: a  reason: collision with root package name */
    public static final String f18741a = MsgBoxManager.class.getSimpleName();
    private static volatile MsgBoxManager b;

    /* renamed from: c  reason: collision with root package name */
    private Set<Long> f18742c = new HashSet();
    private Set<Long> d = new HashSet();
    private int e;

    private MsgBoxManager() {
        if (!c()) {
            return;
        }
        String af = BluedPreferences.af(UserInfo.getInstance().getLoginUserInfo().getUid());
        if (TextUtils.isEmpty(af)) {
            return;
        }
        String[] split = af.split(",");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.f18742c.add(Long.valueOf(split[i2]));
            i = i2 + 1;
        }
    }

    private int a(long j, List<SessionModel> list) {
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return size;
            }
            if (j > list.get(i2).lastMsgTime) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static MsgBoxManager a() {
        if (b == null) {
            synchronized (MsgBoxManager.class) {
                try {
                    if (b == null) {
                        b = new MsgBoxManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private boolean b(SessionModel sessionModel) {
        return sessionModel.sessionType == 3 || d(sessionModel) || e(sessionModel) || g(sessionModel) || c(sessionModel) || !h(sessionModel);
    }

    private boolean c(SessionModel sessionModel) {
        return sessionModel.sessionType == 1;
    }

    private void d() {
        if (this.f18742c.isEmpty()) {
            BluedPreferences.b(UserInfo.getInstance().getLoginUserInfo().getUid(), "");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Long l : this.f18742c) {
            sb.append(l);
            sb.append(",");
        }
        String sb2 = sb.toString();
        String substring = sb2.substring(0, sb2.length() - 1);
        String str = f18741a;
        Logger.c(str, "saveBoxSessionId : " + substring);
        BluedPreferences.b(UserInfo.getInstance().getLoginUserInfo().getUid(), substring);
    }

    private boolean d(SessionModel sessionModel) {
        return sessionModel.friend == 1;
    }

    private boolean e(SessionModel sessionModel) {
        boolean z = false;
        if (sessionModel.sessionSettingModel != null) {
            z = false;
            if (sessionModel.sessionSettingModel.getFollower() == 1) {
                z = true;
            }
        }
        return z;
    }

    private boolean f(SessionModel sessionModel) {
        return sessionModel.vBadge == 3;
    }

    private boolean g(SessionModel sessionModel) {
        return sessionModel.sourceFrom == 13 || sessionModel.sourceFrom == 14 || sessionModel.sourceFrom == 15 || sessionModel.sourceFrom == 16 || sessionModel.sourceFrom == 17 || sessionModel.sourceFrom == 22 || sessionModel.sourceFrom == 23 || sessionModel.sourceFrom == 24;
    }

    private boolean h(SessionModel sessionModel) {
        boolean z;
        boolean z2;
        boolean z3;
        String cG = BluedPreferences.cG();
        if (StringUtils.d(cG)) {
            z = false;
            z2 = false;
            z3 = false;
        } else {
            Set set = (Set) AppInfo.f().fromJson(cG, (Class<Object>) Set.class);
            boolean z4 = set.contains("1") && (sessionModel.sourceFrom == 1 || sessionModel.sourceFrom == 2 || sessionModel.sourceFrom == 3 || sessionModel.sourceFrom == 4 || sessionModel.sourceFrom == 5 || sessionModel.sourceFrom == 6 || sessionModel.sourceFrom == 7 || sessionModel.sourceFrom == 19 || sessionModel.sourceFrom == 20 || sessionModel.sourceFrom == 25 || sessionModel.sourceFrom == 26 || sessionModel.sourceFrom == 27 || sessionModel.sourceFrom == 28 || sessionModel.sourceFrom == 31);
            z3 = set.contains("2") && (sessionModel.sourceFrom == 8 || sessionModel.sourceFrom == 9 || sessionModel.sourceFrom == 10 || sessionModel.sourceFrom == 11 || sessionModel.sourceFrom == 12 || sessionModel.sourceFrom == 32 || sessionModel.sourceFrom == 33 || sessionModel.sourceFrom == 34 || sessionModel.sourceFrom == 35 || sessionModel.sourceFrom == 36 || sessionModel.sourceFrom == 37 || sessionModel.sourceFrom == 38 || sessionModel.sourceFrom == 39 || sessionModel.sourceFrom == 40 || sessionModel.sourceFrom == 41 || sessionModel.sourceFrom == 42 || sessionModel.sourceFrom == 43 || sessionModel.sourceFrom == 44 || sessionModel.sourceFrom == 45 || sessionModel.sourceFrom == 46 || sessionModel.sourceFrom == 47 || sessionModel.sourceFrom == 48);
            if (set.contains("3") && sessionModel.sourceFrom == 18) {
                z2 = z4;
                z = true;
            } else {
                z2 = z4;
                z = false;
            }
        }
        boolean z5 = true;
        if (!z2) {
            z5 = true;
            if (!z3) {
                if (z) {
                    return true;
                }
                z5 = false;
            }
        }
        return z5;
    }

    public List<SessionModel> a(List<SessionModel> list, boolean z) {
        if (c()) {
            this.f18742c.clear();
            this.d.clear();
            this.e = 0;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                SessionModel sessionModel = list.get(i2);
                Logger.c(f18741a, sessionModel.lastMsgContent + "====source==" + sessionModel.sourceFrom);
                Logger.c(f18741a, sessionModel.lastMsgContent + "====isFriend==" + d(sessionModel));
                Logger.c(f18741a, sessionModel.lastMsgContent + "====isAttention==" + e(sessionModel));
                Logger.c(f18741a, sessionModel.lastMsgContent + "====isPurpleV==" + f(sessionModel));
                Logger.c(f18741a, sessionModel.lastMsgContent + "====isFromExposureOrHellCall==" + g(sessionModel));
                Logger.c(f18741a, sessionModel.lastMsgContent + "====isBoxMsg==" + h(sessionModel));
                if (b(sessionModel)) {
                    arrayList2.add(sessionModel);
                } else {
                    this.f18742c.add(Long.valueOf(sessionModel.sessionId));
                    this.e += sessionModel.noReadMsgCount;
                    if (sessionModel.noReadMsgCount > 0) {
                        this.d.add(Long.valueOf(sessionModel.sessionId));
                    }
                    arrayList.add(sessionModel);
                }
                i = i2 + 1;
            }
            if (!z) {
                SessionModel sessionModel2 = new SessionModel();
                sessionModel2.sessionType = (short) 6668;
                sessionModel2.sessionId = 1L;
                if (arrayList.size() > 0) {
                    sessionModel2.noReadMsgCount = this.e;
                    SessionModel sessionModel3 = (SessionModel) arrayList.get(0);
                    sessionModel2.lastMsgType = sessionModel3.lastMsgType;
                    sessionModel2.lastMsgTime = sessionModel3.lastMsgTime;
                    sessionModel2.lastMsgContent = sessionModel3.lastMsgContent;
                    sessionModel2.lastMsgFromNickname = sessionModel3.lastMsgFromNickname;
                    sessionModel2.lastMsgFromId = sessionModel3.lastMsgFromId;
                    sessionModel2.lastMsgStateCode = sessionModel3.lastMsgStateCode;
                    sessionModel2.lastMsgExtra = sessionModel3.lastMsgExtra;
                    SessionSettingModel sessionSettingModel = new SessionSettingModel();
                    sessionSettingModel.setRemindAudio(0);
                    sessionModel2.sessionSettingModel = sessionSettingModel;
                } else {
                    sessionModel2.lastMsgContent = AppInfo.d().getString(R.string.msg_box_empty_hint);
                    sessionModel2.lastMsgTime = BluedPreferences.dp();
                }
                arrayList2.add(a(sessionModel2.lastMsgTime, arrayList2), sessionModel2);
            }
            d();
            return z ? arrayList : arrayList2;
        }
        return list;
    }

    public boolean a(long j) {
        return this.f18742c.contains(Long.valueOf(j));
    }

    public boolean a(SessionModel sessionModel) {
        if (sessionModel == null) {
            return false;
        }
        return !b(sessionModel);
    }

    public boolean a(short s, long j) {
        return s == 6668 && j == 1;
    }

    public void b() {
        this.f18742c.clear();
        this.d.clear();
    }

    public boolean c() {
        return false;
    }
}
