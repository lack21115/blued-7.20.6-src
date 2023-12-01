package com.blued.android.chat;

import android.util.Pair;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.module.chat.db.SessionSettingDBOper;
import com.blued.android.module.chat.model.SessionSetting;
import com.blued.android.module.common.db.DataTransform;
import com.blued.android.module.common.db.SessionSettingDao;
import com.blued.android.module.common.db.model.SessionSettingModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/SessionSettingDBImpl.class */
public class SessionSettingDBImpl implements SessionSettingDBOper {
    public static final String TAG = "SS_DB";

    @Override // com.blued.android.module.chat.db.SessionSettingDBOper
    public SessionSetting createSessionSetting(short s, long j, SessionSetting sessionSetting) {
        SessionSettingModel a;
        if (sessionSetting == null) {
            a = new SessionSettingModel();
            a.setSessionType(s);
            a.setSessionId(j);
        } else {
            a = DataTransform.a(sessionSetting);
        }
        return DataTransform.a(SessionSettingDao.a().a(a));
    }

    @Override // com.blued.android.module.chat.db.SessionSettingDBOper
    public int deleteAllSessionSetting() {
        return SessionSettingDao.a().d();
    }

    @Override // com.blued.android.module.chat.db.SessionSettingDBOper
    public int deleteNoGroupSessionSetting(short s, long j) {
        return SessionSettingDao.a().a(s, j);
    }

    @Override // com.blued.android.module.chat.db.SessionSettingDBOper
    public void deleteSessionAndChattingWithSetting(List<Pair<Short, Long>> list) {
        ChatManager.getInstance().deleteSessionAndChattingWithSetting(list);
    }

    @Override // com.blued.android.module.chat.db.SessionSettingDBOper
    public void deleteSessionAndChattingWithSetting(short s, long j) {
        ChatManager.getInstance().deleteSessionAndChattingWithSetting(Short.valueOf(s), j);
    }

    @Override // com.blued.android.module.chat.db.SessionSettingDBOper
    public int deleteSessionSetting(short s, long j) {
        return SessionSettingDao.a().b(s, j);
    }

    @Override // com.blued.android.module.chat.db.SessionSettingDBOper
    public SessionSetting getOneSessionSetting(short s, long j) {
        return DataTransform.a(SessionSettingDao.a().a((int) s, j));
    }

    @Override // com.blued.android.module.chat.db.SessionSettingDBOper
    public Map<String, SessionSetting> getSessionSettingMap() {
        HashMap hashMap = new HashMap();
        Map<String, SessionSettingModel> c = SessionSettingDao.a().c();
        if (c != null) {
            for (Map.Entry<String, SessionSettingModel> entry : c.entrySet()) {
                hashMap.put(entry.getKey(), DataTransform.a(entry.getValue()));
            }
        }
        return hashMap;
    }

    @Override // com.blued.android.module.chat.db.SessionSettingDBOper
    public int updataSessionSetting(SessionSetting sessionSetting) {
        return SessionSettingDao.a().b(DataTransform.a(sessionSetting));
    }

    @Override // com.blued.android.module.chat.db.SessionSettingDBOper
    public int updateAllSessionSetting(Map<String, Object> map) {
        return SessionSettingDao.a().a(map);
    }

    @Override // com.blued.android.module.chat.db.SessionSettingDBOper
    public void updateFollower(long j, int i) {
        if (ChatManager.getInstance().getSnapSessionModel((short) 2, j) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("follower", Integer.valueOf(i));
            ChatManager.getInstance().updateSessionSetting((short) 2, j, hashMap);
        }
    }

    @Override // com.blued.android.module.chat.db.SessionSettingDBOper
    public void updateRelationSessionSettingList(List<SessionSetting> list) {
        for (SessionSetting sessionSetting : list) {
            HashMap hashMap = new HashMap();
            hashMap.put("nearby", Integer.valueOf(sessionSetting.getNearby()));
            hashMap.put("online", Integer.valueOf(sessionSetting.getOnline()));
            hashMap.put("follower", Integer.valueOf(sessionSetting.getFollower()));
            hashMap.put("initiator", Integer.valueOf(sessionSetting.getInitiator()));
            ChatManager.getInstance().updateRelationSessionSetting(sessionSetting.getSessionType(), sessionSetting.getSessionId(), hashMap);
        }
        ArrayList arrayList = new ArrayList();
        for (SessionSetting sessionSetting2 : list) {
            arrayList.add(DataTransform.a(sessionSetting2));
        }
        ChatManager.getInstance().updateRelationSessionSettingListDb(arrayList);
    }

    @Override // com.blued.android.module.chat.db.SessionSettingDBOper
    public int updateRelationSessionSettingListDb(List<SessionSettingBaseModel> list) {
        return SessionSettingDao.a().a(list);
    }

    @Override // com.blued.android.module.chat.db.SessionSettingDBOper
    public int updateSessionSetting(short s, long j, Map<String, Object> map) {
        return SessionSettingDao.a().a(s, j, map);
    }

    @Override // com.blued.android.module.chat.db.SessionSettingDBOper
    public void updateSessionSetting(SessionSetting sessionSetting) {
        HashMap hashMap = new HashMap();
        hashMap.put("nearby", Integer.valueOf(sessionSetting.getNearby()));
        hashMap.put("online", Integer.valueOf(sessionSetting.getOnline()));
        hashMap.put("follower", Integer.valueOf(sessionSetting.getFollower()));
        hashMap.put("initiator", Integer.valueOf(sessionSetting.getInitiator()));
        ChatManager.getInstance().updateSessionSetting(sessionSetting.getSessionType(), sessionSetting.getSessionId(), hashMap);
    }
}
