package com.blued.android.module.chat.db;

import android.util.Pair;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.module.chat.model.SessionSetting;
import java.util.List;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/db/SessionSettingDBOper.class */
public interface SessionSettingDBOper {
    SessionSetting createSessionSetting(short s, long j, SessionSetting sessionSetting);

    int deleteAllSessionSetting();

    int deleteNoGroupSessionSetting(short s, long j);

    void deleteSessionAndChattingWithSetting(List<Pair<Short, Long>> list);

    void deleteSessionAndChattingWithSetting(short s, long j);

    int deleteSessionSetting(short s, long j);

    SessionSetting getOneSessionSetting(short s, long j);

    Map<String, SessionSetting> getSessionSettingMap();

    int updataSessionSetting(SessionSetting sessionSetting);

    int updateAllSessionSetting(Map<String, Object> map);

    void updateFollower(long j, int i);

    void updateRelationSessionSettingList(List<SessionSetting> list);

    int updateRelationSessionSettingListDb(List<SessionSettingBaseModel> list);

    int updateSessionSetting(short s, long j, Map<String, Object> map);

    void updateSessionSetting(SessionSetting sessionSetting);
}
