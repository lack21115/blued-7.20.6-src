package com.blued.android.chat;

import android.database.sqlite.SQLiteDatabase;
import com.blued.android.chat.db.DBOper;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.module.chat.ModuleChatConfig;
import com.blued.android.module.chat.manager.SessionDataManager;
import com.blued.android.module.chat.model.SessionSetting;
import com.blued.android.module.common.db.BluedBaseDataHelper;
import com.blued.android.module.common.db.ChattingDao;
import com.blued.android.module.common.db.DataTransform;
import com.blued.android.module.common.db.SessionDao;
import com.blued.android.module.common.db.model.ChattingModelDB;
import com.blued.android.module.common.db.model.SessionModelDB;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/ChatDBImpl.class */
public class ChatDBImpl implements DBOper {
    private static final String TAG = "Chat_DB";

    public ChatDBImpl() {
        ModuleChatConfig.getInstance().setSessionSettingDBOperImpl(new SessionSettingDBImpl());
    }

    private int insertChattingData(ChattingModel chattingModel, boolean z) {
        ChattingModelDB a = DataTransform.a(chattingModel);
        int a2 = ChattingDao.a().a(a, z);
        if (a2 > 0) {
            chattingModel.dbId = a.dbId;
        }
        return a2;
    }

    @Override // com.blued.android.chat.db.DBOper
    public void changeAllMsgType(short s, short s2) {
        ChattingDao.a().a(s, s2);
        SessionDao.a().a(s, s2);
    }

    @Override // com.blued.android.chat.db.DBOper
    public int changeAllTempMsgToNormal(short s, long j) {
        return ChattingDao.a().a(s, j);
    }

    @Override // com.blued.android.chat.db.DBOper
    public SessionSettingBaseModel createSessionSetting(short s, long j, SessionSettingBaseModel sessionSettingBaseModel) {
        return DataTransform.a(SessionDataManager.getInstance().createSessionSetting(s, j, DataTransform.a(sessionSettingBaseModel)));
    }

    @Override // com.blued.android.chat.db.DBOper
    public void deleteAllSessionSetting() {
        SessionDataManager.getInstance().deleteAllSessionSetting();
    }

    @Override // com.blued.android.chat.db.DBOper
    public void deleteChattingForAll() {
        ChattingDao.a().d();
    }

    @Override // com.blued.android.chat.db.DBOper
    public void deleteChattingForOne(int i, long j) {
        ChattingDao.a().b(i, j);
    }

    @Override // com.blued.android.chat.db.DBOper
    public void deleteNoGroupSessionSetting(short s, long j) {
        SessionDataManager.getInstance().deleteNoGroupSessionSettingModel(s, j);
    }

    @Override // com.blued.android.chat.db.DBOper
    public void deleteSessionAndChattingForAll() {
        SessionDao.a().d();
        ChattingDao.a().d();
        SessionDataManager.getInstance().deleteSessionForAll();
    }

    @Override // com.blued.android.chat.db.DBOper
    public void deleteSessionAndChattingForOne(int i, long j) {
        SessionDao.a().a(i, j);
        ChattingDao.a().b(i, j);
        SessionDataManager.getInstance().deleteSessionForOne((short) i, j);
    }

    @Override // com.blued.android.chat.db.DBOper
    public void deleteSessionForAll() {
        SessionDao.a().d();
        SessionDataManager.getInstance().deleteSessionForAll();
    }

    @Override // com.blued.android.chat.db.DBOper
    public void deleteSessionForOne(int i, long j) {
        SessionDao.a().a(i, j);
        SessionDataManager.getInstance().deleteSessionForOne((short) i, j);
    }

    @Override // com.blued.android.chat.db.DBOper
    public void deleteSessionSetting(short s, long j) {
        SessionDataManager.getInstance().deleteSessionSettingModel(s, j);
    }

    @Override // com.blued.android.chat.db.DBOper
    public boolean existChattingModel(short s, long j, long j2) {
        return ChattingDao.a().a(s, j, j2);
    }

    @Override // com.blued.android.chat.db.DBOper
    public void failedAllSendingMsg(long j) {
        SessionDao.a().e();
        ChattingDao.a().c();
    }

    @Override // com.blued.android.chat.db.DBOper
    public List<Long> findAllMsgId(short s, long j, long j2) {
        return ChattingDao.a().b(s, j, j2);
    }

    @Override // com.blued.android.chat.db.DBOper
    public ChattingModel findMsgData(short s, long j, long j2, long j3) {
        return DataTransform.a(ChattingDao.a().a(s, j, j2, j3));
    }

    @Override // com.blued.android.chat.db.DBOper
    public long findReadReceiptMaxMessageId(int i, long j) {
        ChattingModelDB e = ChattingDao.a().e(i, j);
        if (e != null) {
            return e.msgId;
        }
        return -1L;
    }

    @Override // com.blued.android.chat.db.DBOper
    public ChattingModel findSessionLastMsg(int i, long j) {
        return DataTransform.a(ChattingDao.a().c(i, j));
    }

    @Override // com.blued.android.chat.db.DBOper
    public List<ChattingModel> getMsgList(long j, int i, long j2, long j3, long j4, long j5, int i2, boolean z) {
        return z ? DataTransform.b(ChattingDao.a().a(i, j2, j3, j4, j5, i2)) : DataTransform.b(ChattingDao.a().b(i, j2, j3, j4, j5, i2));
    }

    @Override // com.blued.android.chat.db.DBOper
    public SQLiteDatabase getReadDatabase() {
        return BluedBaseDataHelper.a().getReadableDatabase();
    }

    @Override // com.blued.android.chat.db.DBOper
    public ChattingModel getSendingMsgData(short s, long j, long j2) {
        return DataTransform.a(ChattingDao.a().a(j2, s, j));
    }

    @Override // com.blued.android.chat.db.DBOper
    public List<ChattingModel> getServiceMsgList(long j, int i, String str, long j2, long j3, long j4, int i2) {
        return DataTransform.b(ChattingDao.a().a(i, str, j2, j4, i2));
    }

    @Override // com.blued.android.chat.db.DBOper
    public List<SessionModel> getSessionList() {
        List<SessionModel> a = DataTransform.a(SessionDao.a().c());
        SessionDataManager.getInstance().setSessionList(a);
        return a;
    }

    @Override // com.blued.android.chat.db.DBOper
    public SessionSettingBaseModel getSessionSetting(short s, long j) {
        return DataTransform.a(SessionDataManager.getInstance().getOneSessionSetting(s, j));
    }

    @Override // com.blued.android.chat.db.DBOper
    public Map<String, SessionSettingBaseModel> getSessionSettingList() {
        Map<String, SessionSetting> sessionSettingMap = SessionDataManager.getInstance().getSessionSettingMap();
        HashMap hashMap = new HashMap();
        if (sessionSettingMap != null) {
            for (Map.Entry<String, SessionSetting> entry : sessionSettingMap.entrySet()) {
                hashMap.put(entry.getKey(), DataTransform.a(entry.getValue()));
            }
        }
        return hashMap;
    }

    @Override // com.blued.android.chat.db.DBOper
    public Set<Long> getSessionUnreadedIds(int i, long j, long j2) {
        return ChattingDao.a().a(i, j, j2);
    }

    @Override // com.blued.android.chat.db.DBOper
    public void ignoredNoReadNumAll() {
        SessionDao.a().g();
    }

    @Override // com.blued.android.chat.db.DBOper
    public int insertChattingData(ChattingModel chattingModel) {
        return insertChattingData(chattingModel, false);
    }

    @Override // com.blued.android.chat.db.DBOper
    public void insertMsgList(List<ChattingModel> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (ChattingModel chattingModel : list) {
            insertChattingData(chattingModel, true);
        }
    }

    @Override // com.blued.android.chat.db.DBOper
    public int insertMsgListFromBackup(List<ChattingModel> list) {
        return ChattingDao.a().a(list);
    }

    @Override // com.blued.android.chat.db.DBOper
    public int insertSessionList(List<SessionModel> list) {
        return SessionDao.a().a(list);
    }

    @Override // com.blued.android.chat.db.DBOper
    public void readedAllMsg(short s, long j, long j2) {
        ChattingDao.a().c(s, j, j2);
    }

    @Override // com.blued.android.chat.db.DBOper
    public void readedOneMsg(short s, long j, long j2) {
        ChattingDao.a().d(s, j, j2);
    }

    public void saveMessage(ChattingModel chattingModel) {
        ChattingDao.a().a(DataTransform.a(chattingModel), false);
    }

    @Override // com.blued.android.chat.db.DBOper
    public void saveSession(SessionModel sessionModel) {
        SessionModelDB a = DataTransform.a(sessionModel);
        if (SessionDao.a().a(a) > 0) {
            sessionModel.dbId = a.dbId;
            SessionDataManager.getInstance().saveSession(sessionModel);
        }
    }

    @Override // com.blued.android.chat.db.DBOper
    public void updateAllLastMsgContentNull() {
        SessionDao.a().f();
    }

    @Override // com.blued.android.chat.db.DBOper
    public int updateAllSessionSetting(Map<String, Object> map) {
        return SessionDataManager.getInstance().updateAllSessionSetting(map);
    }

    @Override // com.blued.android.chat.db.DBOper
    public void updateChattingModel(ChattingModel chattingModel) {
        ChattingDao.a().a(DataTransform.a(chattingModel));
    }

    @Override // com.blued.android.chat.db.DBOper
    public void updateMsgForTextTranslateInit(int i, long j) {
        ChattingDao.a().a(i, j);
    }

    @Override // com.blued.android.chat.db.DBOper
    public int updateRelationSessionSettingListDb(List<SessionSettingBaseModel> list) {
        return SessionDataManager.getInstance().updateRelationSessionSettingListDb(list);
    }

    @Override // com.blued.android.chat.db.DBOper
    public int updateSendingMsgId(long j, int i, long j2, long j3) {
        return ChattingDao.a().a(j, i, j2, j3);
    }

    @Override // com.blued.android.chat.db.DBOper
    public void updateSession(SessionModel sessionModel) {
        SessionDao.a().b(DataTransform.a(sessionModel));
        SessionDataManager.getInstance().updateSession(sessionModel);
    }

    @Override // com.blued.android.chat.db.DBOper
    public int updateSessionSetting(short s, long j, Map<String, Object> map) {
        return SessionDataManager.getInstance().updateSessionSetting(s, j, map);
    }

    @Override // com.blued.android.chat.db.DBOper
    public void updateSessionSetting(short s, long j, SessionSettingBaseModel sessionSettingBaseModel) {
        SessionDataManager.getInstance().updataSessionSetting(s, j, DataTransform.a(sessionSettingBaseModel));
    }
}
