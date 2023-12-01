package com.blued.android.module.yy_china.test;

import android.util.Pair;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.module.chat.db.SessionSettingDBOper;
import com.blued.android.module.chat.model.SessionSetting;
import com.blued.android.module.common.db.DataTransform;
import com.blued.android.module.common.db.SessionSettingDao;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.soft.blued.ui.find.model.UserFindResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/test/SessionSettingDBImpl.class */
public class SessionSettingDBImpl implements SessionSettingDBOper {
    @Override // com.blued.android.module.chat.db.SessionSettingDBOper
    public SessionSetting createSessionSetting(short s, long j, SessionSetting sessionSetting) {
        SessionSettingModel a2;
        if (sessionSetting == null) {
            a2 = new SessionSettingModel();
            a2.setSessionType(s);
            a2.setSessionId(j);
        } else {
            a2 = DataTransform.a(sessionSetting);
        }
        return DataTransform.a(SessionSettingDao.a().a(a2));
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
        Map<String, SessionSettingModel> c2 = SessionSettingDao.a().c();
        if (c2 != null) {
            for (Map.Entry<String, SessionSettingModel> entry : c2.entrySet()) {
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
            hashMap.put(UserFindResult.USER_SORT_BY.NEARBY, Integer.valueOf(sessionSetting.getNearby()));
            hashMap.put(UserFindResult.USER_SORT_BY.ONLINE, Integer.valueOf(sessionSetting.getOnline()));
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
        hashMap.put(UserFindResult.USER_SORT_BY.NEARBY, Integer.valueOf(sessionSetting.getNearby()));
        hashMap.put(UserFindResult.USER_SORT_BY.ONLINE, Integer.valueOf(sessionSetting.getOnline()));
        hashMap.put("follower", Integer.valueOf(sessionSetting.getFollower()));
        hashMap.put("initiator", Integer.valueOf(sessionSetting.getInitiator()));
        ChatManager.getInstance().updateSessionSetting(sessionSetting.getSessionType(), sessionSetting.getSessionId(), hashMap);
    }
}
