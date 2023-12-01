package com.soft.blued.ui.msg.controller.tools;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.model.SessionModel;
import com.soft.blued.utils.Logger;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/controller/tools/SessionModelComparator.class */
public class SessionModelComparator implements Comparator<SessionModel> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f32267a = SessionModelComparator.class.getSimpleName();
    private Map<SessionModel, Long> b = new HashMap();

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(SessionModel sessionModel, SessionModel sessionModel2) {
        long longValue;
        long longValue2;
        if (sessionModel.lieTop == 1 && sessionModel2.lieTop == 0) {
            return -1;
        }
        if (sessionModel.lieTop == 0 && sessionModel2.lieTop == 1) {
            return 1;
        }
        if (sessionModel.expireTime != 0) {
            String str = f32267a;
            Logger.e(str, "arg0=" + sessionModel.lastMsgFromNickname + "===" + (System.currentTimeMillis() - sessionModel.expireTime));
        }
        if (sessionModel2.expireTime != 0) {
            String str2 = f32267a;
            Logger.e(str2, "arg1=" + sessionModel2.lastMsgFromNickname + "===" + (System.currentTimeMillis() - sessionModel2.expireTime));
        }
        if (sessionModel.expireTime != 0 && sessionModel.expireTime < System.currentTimeMillis()) {
            sessionModel.expireTime = 0L;
            sessionModel.totalMoney = 0.0f;
            ChatManager.getInstance().updateSessionTopGift(sessionModel.sessionType, sessionModel.sessionId, 0L, 0.0f);
        }
        if (sessionModel2.expireTime != 0 && sessionModel2.expireTime < System.currentTimeMillis()) {
            sessionModel2.expireTime = 0L;
            sessionModel2.totalMoney = 0.0f;
            ChatManager.getInstance().updateSessionTopGift(sessionModel2.sessionType, sessionModel2.sessionId, 0L, 0.0f);
        }
        if (sessionModel.expireTime == 0 || sessionModel2.expireTime != 0) {
            if (sessionModel.expireTime != 0 || sessionModel2.expireTime == 0) {
                if (sessionModel.expireTime != 0 && sessionModel2.expireTime != 0) {
                    if (sessionModel.totalMoney > sessionModel2.totalMoney) {
                        return -1;
                    }
                    if (sessionModel.totalMoney < sessionModel2.totalMoney) {
                        return 1;
                    }
                }
                Long l = this.b.get(sessionModel);
                if (l == null) {
                    longValue = sessionModel.lastMsgTime;
                    this.b.put(sessionModel, Long.valueOf(longValue));
                } else {
                    longValue = l.longValue();
                }
                Long l2 = this.b.get(sessionModel2);
                if (l2 == null) {
                    longValue2 = sessionModel2.lastMsgTime;
                    this.b.put(sessionModel2, Long.valueOf(longValue2));
                } else {
                    longValue2 = l2.longValue();
                }
                int i = (longValue > longValue2 ? 1 : (longValue == longValue2 ? 0 : -1));
                if (i > 0) {
                    return -1;
                }
                return i < 0 ? 1 : 0;
            }
            return 1;
        }
        return -1;
    }
}
