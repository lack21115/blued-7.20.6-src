package com.blued.android.chat.db;

import android.database.sqlite.SQLiteDatabase;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/db/DBOper.class */
public interface DBOper {
    public static final DBOper EmptyDBOper = new DBOper() { // from class: com.blued.android.chat.db.DBOper.1
        @Override // com.blued.android.chat.db.DBOper
        public void changeAllMsgType(short s, short s2) {
        }

        @Override // com.blued.android.chat.db.DBOper
        public int changeAllTempMsgToNormal(short s, long j) {
            return 0;
        }

        @Override // com.blued.android.chat.db.DBOper
        public SessionSettingBaseModel createSessionSetting(short s, long j, SessionSettingBaseModel sessionSettingBaseModel) {
            return null;
        }

        @Override // com.blued.android.chat.db.DBOper
        public void deleteAllSessionSetting() {
        }

        @Override // com.blued.android.chat.db.DBOper
        public void deleteChattingForAll() {
        }

        @Override // com.blued.android.chat.db.DBOper
        public void deleteChattingForOne(int i, long j) {
        }

        @Override // com.blued.android.chat.db.DBOper
        public void deleteNoGroupSessionSetting(short s, long j) {
        }

        @Override // com.blued.android.chat.db.DBOper
        public void deleteSessionAndChattingForAll() {
        }

        @Override // com.blued.android.chat.db.DBOper
        public void deleteSessionAndChattingForOne(int i, long j) {
        }

        @Override // com.blued.android.chat.db.DBOper
        public void deleteSessionForAll() {
        }

        @Override // com.blued.android.chat.db.DBOper
        public void deleteSessionForOne(int i, long j) {
        }

        @Override // com.blued.android.chat.db.DBOper
        public void deleteSessionSetting(short s, long j) {
        }

        @Override // com.blued.android.chat.db.DBOper
        public boolean existChattingModel(short s, long j, long j2) {
            return false;
        }

        @Override // com.blued.android.chat.db.DBOper
        public void failedAllSendingMsg(long j) {
        }

        @Override // com.blued.android.chat.db.DBOper
        public List<Long> findAllMsgId(short s, long j, long j2) {
            return new ArrayList();
        }

        @Override // com.blued.android.chat.db.DBOper
        public ChattingModel findMsgData(short s, long j, long j2, long j3) {
            return null;
        }

        @Override // com.blued.android.chat.db.DBOper
        public long findReadReceiptMaxMessageId(int i, long j) {
            return -1L;
        }

        @Override // com.blued.android.chat.db.DBOper
        public ChattingModel findSessionLastMsg(int i, long j) {
            return null;
        }

        @Override // com.blued.android.chat.db.DBOper
        public List<ChattingModel> getMsgList(long j, int i, long j2, long j3, long j4, long j5, int i2, boolean z) {
            return null;
        }

        @Override // com.blued.android.chat.db.DBOper
        public SQLiteDatabase getReadDatabase() {
            return null;
        }

        @Override // com.blued.android.chat.db.DBOper
        public ChattingModel getSendingMsgData(short s, long j, long j2) {
            return null;
        }

        @Override // com.blued.android.chat.db.DBOper
        public List<ChattingModel> getServiceMsgList(long j, int i, String str, long j2, long j3, long j4, int i2) {
            return null;
        }

        @Override // com.blued.android.chat.db.DBOper
        public List<SessionModel> getSessionList() {
            return null;
        }

        @Override // com.blued.android.chat.db.DBOper
        public SessionSettingBaseModel getSessionSetting(short s, long j) {
            return null;
        }

        @Override // com.blued.android.chat.db.DBOper
        public Map<String, SessionSettingBaseModel> getSessionSettingList() {
            return null;
        }

        @Override // com.blued.android.chat.db.DBOper
        public Set<Long> getSessionUnreadedIds(int i, long j, long j2) {
            return null;
        }

        public List<ChattingModel> getTempMsgList(long j, int i, long j2, long j3, long j4, long j5, int i2, boolean z) {
            return null;
        }

        @Override // com.blued.android.chat.db.DBOper
        public void ignoredNoReadNumAll() {
        }

        @Override // com.blued.android.chat.db.DBOper
        public int insertChattingData(ChattingModel chattingModel) {
            return -1;
        }

        @Override // com.blued.android.chat.db.DBOper
        public void insertMsgList(List<ChattingModel> list) {
        }

        @Override // com.blued.android.chat.db.DBOper
        public int insertMsgListFromBackup(List<ChattingModel> list) {
            return -1;
        }

        @Override // com.blued.android.chat.db.DBOper
        public int insertSessionList(List<SessionModel> list) {
            return -1;
        }

        @Override // com.blued.android.chat.db.DBOper
        public void readedAllMsg(short s, long j, long j2) {
        }

        @Override // com.blued.android.chat.db.DBOper
        public void readedOneMsg(short s, long j, long j2) {
        }

        @Override // com.blued.android.chat.db.DBOper
        public void saveSession(SessionModel sessionModel) {
        }

        @Override // com.blued.android.chat.db.DBOper
        public void updateAllLastMsgContentNull() {
        }

        @Override // com.blued.android.chat.db.DBOper
        public int updateAllSessionSetting(Map<String, Object> map) {
            return -1;
        }

        @Override // com.blued.android.chat.db.DBOper
        public void updateChattingModel(ChattingModel chattingModel) {
        }

        @Override // com.blued.android.chat.db.DBOper
        public void updateMsgForTextTranslateInit(int i, long j) {
        }

        @Override // com.blued.android.chat.db.DBOper
        public int updateRelationSessionSettingListDb(List<SessionSettingBaseModel> list) {
            return -1;
        }

        @Override // com.blued.android.chat.db.DBOper
        public int updateSendingMsgId(long j, int i, long j2, long j3) {
            return -1;
        }

        @Override // com.blued.android.chat.db.DBOper
        public void updateSession(SessionModel sessionModel) {
        }

        @Override // com.blued.android.chat.db.DBOper
        public int updateSessionSetting(short s, long j, Map<String, Object> map) {
            return -1;
        }

        @Override // com.blued.android.chat.db.DBOper
        public void updateSessionSetting(short s, long j, SessionSettingBaseModel sessionSettingBaseModel) {
        }
    };

    void changeAllMsgType(short s, short s2);

    int changeAllTempMsgToNormal(short s, long j);

    SessionSettingBaseModel createSessionSetting(short s, long j, SessionSettingBaseModel sessionSettingBaseModel);

    void deleteAllSessionSetting();

    void deleteChattingForAll();

    void deleteChattingForOne(int i, long j);

    void deleteNoGroupSessionSetting(short s, long j);

    void deleteSessionAndChattingForAll();

    void deleteSessionAndChattingForOne(int i, long j);

    void deleteSessionForAll();

    void deleteSessionForOne(int i, long j);

    void deleteSessionSetting(short s, long j);

    boolean existChattingModel(short s, long j, long j2);

    void failedAllSendingMsg(long j);

    List<Long> findAllMsgId(short s, long j, long j2);

    ChattingModel findMsgData(short s, long j, long j2, long j3);

    long findReadReceiptMaxMessageId(int i, long j);

    ChattingModel findSessionLastMsg(int i, long j);

    List<ChattingModel> getMsgList(long j, int i, long j2, long j3, long j4, long j5, int i2, boolean z);

    SQLiteDatabase getReadDatabase();

    ChattingModel getSendingMsgData(short s, long j, long j2);

    List<ChattingModel> getServiceMsgList(long j, int i, String str, long j2, long j3, long j4, int i2);

    List<SessionModel> getSessionList();

    SessionSettingBaseModel getSessionSetting(short s, long j);

    Map<String, SessionSettingBaseModel> getSessionSettingList();

    Set<Long> getSessionUnreadedIds(int i, long j, long j2);

    void ignoredNoReadNumAll();

    int insertChattingData(ChattingModel chattingModel);

    void insertMsgList(List<ChattingModel> list);

    int insertMsgListFromBackup(List<ChattingModel> list);

    int insertSessionList(List<SessionModel> list);

    void readedAllMsg(short s, long j, long j2);

    void readedOneMsg(short s, long j, long j2);

    void saveSession(SessionModel sessionModel);

    void updateAllLastMsgContentNull();

    int updateAllSessionSetting(Map<String, Object> map);

    void updateChattingModel(ChattingModel chattingModel);

    void updateMsgForTextTranslateInit(int i, long j);

    int updateRelationSessionSettingListDb(List<SessionSettingBaseModel> list);

    int updateSendingMsgId(long j, int i, long j2, long j3);

    void updateSession(SessionModel sessionModel);

    int updateSessionSetting(short s, long j, Map<String, Object> map);

    void updateSessionSetting(short s, long j, SessionSettingBaseModel sessionSettingBaseModel);
}
