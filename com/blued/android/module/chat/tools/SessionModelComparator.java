package com.blued.android.module.chat.tools;

import com.blued.android.chat.model.SessionModel;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/tools/SessionModelComparator.class */
public class SessionModelComparator implements Comparator<SessionModel> {
    private Map<SessionModel, Long> sessionLastTimeMap = new HashMap();

    @Override // java.util.Comparator
    public int compare(SessionModel sessionModel, SessionModel sessionModel2) {
        long longValue;
        long longValue2;
        Long l = this.sessionLastTimeMap.get(sessionModel);
        if (l == null) {
            longValue = sessionModel.lastMsgTime;
            this.sessionLastTimeMap.put(sessionModel, Long.valueOf(longValue));
        } else {
            longValue = l.longValue();
        }
        Long l2 = this.sessionLastTimeMap.get(sessionModel2);
        if (l2 == null) {
            longValue2 = sessionModel2.lastMsgTime;
            this.sessionLastTimeMap.put(sessionModel2, Long.valueOf(longValue2));
        } else {
            longValue2 = l2.longValue();
        }
        int i = (longValue > longValue2 ? 1 : (longValue == longValue2 ? 0 : -1));
        if (i > 0) {
            return -1;
        }
        return i < 0 ? 1 : 0;
    }
}
