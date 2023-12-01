package com.blued.android.module.chat.manager;

import android.util.Pair;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.data.SessionHeader;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.chat.StableSessionListListener;
import com.blued.android.module.chat.contract.FilterSessionListListener;
import com.blued.android.module.chat.db.SessionSettingDBOper;
import com.blued.android.module.chat.manager.ChatRelationDataManager;
import com.blued.android.module.chat.model.SessionSetting;
import com.blued.android.module.chat.utils.FilterTools;
import com.blued.android.module.chat.utils.ListUtils;
import com.blued.android.module.chat.utils.PreferencesUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/manager/SessionDataManager.class */
public class SessionDataManager extends StableSessionListListener {
    private static String TAG = "@@@ module_chat_SessionDataManager";
    private static SessionDataManager instance;
    private SessionSettingDBOper mDBOper;
    private List<FilterSessionListListener> listeners = new Vector();
    private List<Long> allPrivateUids = new Vector();
    private Map<String, SessionSetting> allSSModels = new ConcurrentHashMap();
    private Map<String, SessionModel> filterSessionModels = new ConcurrentHashMap();
    private Map<String, SessionModel> filterExceptHasNoReadList = new ConcurrentHashMap();
    private volatile boolean isRegistSessionListListener = false;

    private void addPrivateUid(long j) {
        if (AppInfo.m()) {
            Logger.a(TAG, "addPrivateUid() | 已缓存的UID:", this.allPrivateUids.toString());
        }
        if (this.allPrivateUids.contains(Long.valueOf(j))) {
            return;
        }
        this.allPrivateUids.add(0, Long.valueOf(j));
        if (AppInfo.m()) {
            Logger.a(TAG, "缓存UID：", Long.valueOf(j));
        }
    }

    private void checkFilterExceptNoReadList(String str, SessionModel sessionModel) {
        if (sessionModel != null) {
            if (AppInfo.m()) {
                Logger.a(TAG, "checkFilterExceptNoReadList() | sessionKey:", str);
                Logger.a(TAG, "checkFilterExceptNoReadList() | SessionModel:", sessionModel.toString());
            }
            if (sessionModel.noReadMsgCount > 0) {
                if (AppInfo.m()) {
                    Logger.a(TAG, "添加到未读消息列表!!! | sessionKey:", str);
                }
                this.filterExceptHasNoReadList.put(str, sessionModel);
                return;
            }
            if (AppInfo.m()) {
                Logger.a(TAG, "未读消息数小于等于0 | sessionKey:", str);
            }
            if (this.filterExceptHasNoReadList.containsKey(str)) {
                if (AppInfo.m()) {
                    Logger.a(TAG, "未读消息列表中包含,并从列表中移除 | sessionKey:", str);
                }
                this.filterExceptHasNoReadList.remove(str);
            }
        }
    }

    private void checkFilterList(SessionSetting sessionSetting) {
        checkFilterList(sessionSetting, true);
    }

    private void checkFilterList(SessionSetting sessionSetting, boolean z) {
        if (AppInfo.m()) {
            Logger.a(TAG, "checkFilterList()");
        }
        if (!MsgFilterManager.getInstance().isFilterSwitchOpen()) {
            if (AppInfo.m()) {
                Logger.a(TAG, "筛选为开关关闭");
            }
        } else if (sessionSetting == null) {
            if (AppInfo.m()) {
                Logger.a(TAG, "checkFilterList() | ssm == null !!!");
            }
        } else {
            if (AppInfo.m()) {
                Logger.a(TAG, "SessionType : ", Short.valueOf(sessionSetting.getSessionType()));
            }
            if (sessionSetting.getSessionType() == 2) {
                String sessionKey = SessionHeader.getSessionKey(sessionSetting.getSessionType(), sessionSetting.getSessionId());
                if (AppInfo.m()) {
                    Logger.a(TAG, "sessionKey:", sessionKey);
                }
                SessionModel snapSessionModel = ChatManager.getInstance().getSnapSessionModel(sessionSetting.getSessionType(), sessionSetting.getSessionId());
                if (snapSessionModel == null) {
                    if (AppInfo.m()) {
                        Logger.a(TAG, "SessionModel == null !!!");
                        return;
                    }
                    return;
                }
                if (FilterTools.checkCondition(sessionSetting, PreferencesUtils.getInitiatorSwitch(), PreferencesUtils.getFollowerSwitch(), PreferencesUtils.getNearbySwitch())) {
                    addFilterSessionModel(snapSessionModel, z);
                } else {
                    deleteFilterSessionModels(sessionSetting.getSessionType(), sessionSetting.getSessionId(), z);
                }
                checkFilterExceptNoReadList(sessionKey, snapSessionModel);
            }
        }
    }

    private void checkFilterList(short s, long j) {
        checkFilterList(getSSModel(s, j), true);
    }

    private void checkFilterList(short s, long j, boolean z) {
        checkFilterList(getSSModel(s, j), z);
    }

    private void clearPrivateUids() {
        this.allPrivateUids.clear();
        if (AppInfo.m()) {
            Logger.a(TAG, "clearPrivateUids()");
        }
    }

    private void deleteFilterExceptNoReadList(short s, long j) {
        String sessionKey = SessionHeader.getSessionKey(s, j);
        if (AppInfo.m()) {
            Logger.a(TAG, "deleteFilterExceptNoReadList() | sessionKey:", sessionKey);
        }
        if (this.filterExceptHasNoReadList.containsKey(sessionKey)) {
            this.filterExceptHasNoReadList.remove(sessionKey);
        }
    }

    private void deletePrivateUid(long j) {
        if (AppInfo.m()) {
            Logger.a(TAG, "deletePrivateUid() | 已缓存的UID：", this.allPrivateUids.toString());
        }
        if (this.allPrivateUids.contains(Long.valueOf(j))) {
            this.allPrivateUids.remove(Long.valueOf(j));
            if (AppInfo.m()) {
                Logger.a(TAG, "移除UID：", Long.valueOf(j));
            }
        }
    }

    public static SessionDataManager getInstance() {
        if (instance == null) {
            instance = new SessionDataManager();
        }
        return instance;
    }

    private void removeSSModel(short s, long j) {
        String sessionKey = SessionHeader.getSessionKey(s, j);
        if (AppInfo.m()) {
            Logger.a(TAG, "removeSSModel() | sessionKey:", sessionKey);
        }
        if (this.allSSModels.containsKey(sessionKey)) {
            this.allSSModels.remove(sessionKey);
            if (AppInfo.m()) {
                Logger.a(TAG, "allSSModels中包含:", sessionKey, ",并且移除");
            }
        }
        deleteFilterExceptNoReadList(s, j);
        if (s == 2) {
            deletePrivateUid(j);
            deleteFilterSessionModels(s, j, true);
        }
    }

    private void setAllPrivateUids(List<Long> list) {
        clearPrivateUids();
        this.allPrivateUids.addAll(list);
        if (AppInfo.m()) {
            Logger.a(TAG, "setAllPrivateUids() | privateUids:", this.allPrivateUids.toString());
        }
    }

    private void updateAllSSModel(Map<String, Object> map) {
        if (AppInfo.m()) {
            Logger.a(TAG, "updateAllSSModel(keyValues)");
        }
        for (SessionSetting sessionSetting : this.allSSModels.values()) {
            if (sessionSetting != null) {
                if (AppInfo.m()) {
                    Logger.a(TAG, "updateAllSSModel(keyValues) | befor:", sessionSetting.toString());
                }
                sessionSetting.updateValues(map);
                if (AppInfo.m()) {
                    Logger.a(TAG, "updateAllSSModel(keyValues) | after:", sessionSetting.toString());
                }
                checkFilterList(sessionSetting, false);
            }
        }
        notifySessionListChanged();
    }

    private void updateSSModel(SessionSetting sessionSetting) {
        if (sessionSetting != null) {
            updateSSModel(sessionSetting.getSessionType(), sessionSetting.getSessionId(), sessionSetting);
        }
    }

    private void updateSSModel(short s, long j, SessionSetting sessionSetting) {
        if (sessionSetting != null) {
            String sessionKey = SessionHeader.getSessionKey(s, j);
            if (AppInfo.m()) {
                Logger.a(TAG, "updateSSModel(ss) | sessionKey:", sessionKey);
                Logger.a(TAG, "updateSSModel(ss) | SessionSetting:", sessionSetting.toString());
            }
            this.allSSModels.put(sessionKey, sessionSetting);
            checkFilterList(sessionSetting);
        }
    }

    private void updateSSModel(short s, long j, Map<String, Object> map) {
        String sessionKey = SessionHeader.getSessionKey(s, j);
        if (AppInfo.m()) {
            Logger.a(TAG, "updateSSModel(keyValues) | sessionKey:", sessionKey);
            Logger.a(TAG, "updateSSModel(keyValues) | keyValues", map.toString());
        }
        SessionSetting sessionSetting = this.allSSModels.get(sessionKey);
        if (sessionSetting == null) {
            if (AppInfo.m()) {
                Logger.a(TAG, "updateSSModel(keyValues) | SessionSetting == null !!!");
                return;
            }
            return;
        }
        if (AppInfo.m()) {
            Logger.a(TAG, "updateSSModel(keyValues) | befor:", sessionSetting.toString());
        }
        sessionSetting.updateValues(map);
        if (AppInfo.m()) {
            Logger.a(TAG, "updateSSModel(keyValues) | after:", sessionSetting.toString());
        }
        checkFilterList(s, j);
    }

    public void addFilterSessionModel(SessionModel sessionModel) {
        addFilterSessionModel(sessionModel, true);
    }

    public void addFilterSessionModel(SessionModel sessionModel, boolean z) {
        if (sessionModel != null) {
            if (AppInfo.m()) {
                Logger.a(TAG, "addFilterSessionModel()  SessionModel:", sessionModel.toString());
            }
            String sessionKey = SessionHeader.getSessionKey(sessionModel.sessionType, sessionModel.sessionId);
            if (this.filterSessionModels.containsKey(sessionKey)) {
                if (AppInfo.m()) {
                    Logger.a(TAG, "筛选集合包含:", sessionKey, " ！！！");
                    return;
                }
                return;
            }
            if (AppInfo.m()) {
                String str = TAG;
                Logger.a(str, "筛选集合中不包含，添加到筛选集合中:" + sessionKey);
            }
            this.filterSessionModels.put(sessionKey, sessionModel);
            if (z) {
                notifySessionListChanged();
            }
        }
    }

    public void addFilterSessionModel(short s, long j) {
        addFilterSessionModel(s, j, true);
    }

    public void addFilterSessionModel(short s, long j, boolean z) {
        if (AppInfo.m()) {
            Logger.a(TAG, "addFilterSessionModel() sessionType:", Short.valueOf(s), " | sessionId:", Long.valueOf(j));
        }
        addFilterSessionModel(ChatManager.getInstance().getSnapSessionModel(s, j), z);
    }

    public void clearFilterSessionModel(boolean z) {
        if (AppInfo.m()) {
            Logger.a(TAG, "clearFilterSessionModel()");
        }
        this.filterSessionModels.clear();
        if (z) {
            notifySessionListChanged();
        }
    }

    public SessionSetting createSessionSetting(short s, long j, SessionSetting sessionSetting) {
        SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
        if (sessionSettingDBOper != null) {
            SessionSetting createSessionSetting = sessionSettingDBOper.createSessionSetting(s, j, sessionSetting);
            if (createSessionSetting == null) {
                if (AppInfo.m()) {
                    Logger.a(TAG, "createSessionSetting(ss) 失败 ！！！");
                }
                return createSessionSetting;
            }
            if (AppInfo.m()) {
                Logger.a(TAG, "createSessionSetting(ss) | ", createSessionSetting.toString());
            }
            updateSSModel(createSessionSetting);
            return createSessionSetting;
        }
        return null;
    }

    public int deleteAllSessionSetting() {
        int i;
        SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
        if (sessionSettingDBOper != null) {
            int deleteAllSessionSetting = sessionSettingDBOper.deleteAllSessionSetting();
            i = deleteAllSessionSetting;
            if (deleteAllSessionSetting > 0) {
                if (AppInfo.m()) {
                    Logger.a(TAG, "deleteAllSessionSetting() | result:", Integer.valueOf(deleteAllSessionSetting));
                }
                this.allSSModels.clear();
                clearPrivateUids();
                clearFilterSessionModel(true);
                return deleteAllSessionSetting;
            }
        } else {
            i = -1;
        }
        return i;
    }

    public void deleteFilterSessionModels(short s, long j) {
        deleteFilterSessionModels(s, j, true);
    }

    public void deleteFilterSessionModels(short s, long j, boolean z) {
        String sessionKey = SessionHeader.getSessionKey(s, j);
        if (AppInfo.m()) {
            Logger.a(TAG, "deleteFilterSessionModels()  sessionKey:", sessionKey);
        }
        if (!this.filterSessionModels.containsKey(sessionKey)) {
            if (AppInfo.m()) {
                Logger.a(TAG, "deleteFilterSessionModels() 筛选列表中不包含: ", sessionKey, " ！！！！");
                return;
            }
            return;
        }
        if (AppInfo.m()) {
            Logger.a(TAG, "deleteFilterSessionModels() 筛选列表中包含:", sessionKey);
        }
        this.filterSessionModels.remove(sessionKey);
        if (z) {
            notifySessionListChanged();
        }
    }

    public int deleteNoGroupSessionSettingModel(short s, long j) {
        int i;
        SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
        if (sessionSettingDBOper != null) {
            int deleteNoGroupSessionSetting = sessionSettingDBOper.deleteNoGroupSessionSetting(s, j);
            i = deleteNoGroupSessionSetting;
            if (deleteNoGroupSessionSetting > 0) {
                if (AppInfo.m()) {
                    Logger.a(TAG, "deleteNoGroupSessionSettingModel() | sessionType:", Short.valueOf(s), " | sessionId:", Long.valueOf(j));
                }
                removeSSModel(s, j);
                return deleteNoGroupSessionSetting;
            }
        } else {
            i = -1;
        }
        return i;
    }

    public void deleteSessionAndChattingWithSetting(List<Pair<Short, Long>> list) {
        if (AppInfo.m()) {
            Logger.a(TAG, "deleteSessionAndChattingWithSetting()");
        }
        SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
        if (sessionSettingDBOper != null) {
            sessionSettingDBOper.deleteSessionAndChattingWithSetting(list);
        }
    }

    public void deleteSessionAndChattingWithSetting(short s, long j) {
        if (AppInfo.m()) {
            Logger.a(TAG, "deleteSessionAndChattingWithSetting() | sessionType:", Short.valueOf(s), " | sessionId:", Long.valueOf(j));
        }
        SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
        if (sessionSettingDBOper != null) {
            sessionSettingDBOper.deleteSessionAndChattingWithSetting(s, j);
        }
    }

    public void deleteSessionForAll() {
        if (AppInfo.m()) {
            Logger.a(TAG, "deleteSessionForAll()");
        }
        clearPrivateUids();
        this.filterExceptHasNoReadList.clear();
        clearFilterSessionModel(true);
    }

    public void deleteSessionForOne(short s, long j) {
        if (AppInfo.m()) {
            Logger.a(TAG, "deleteSessionForOne() | sessionType:", Short.valueOf(s), " | sessionId:", Long.valueOf(j));
        }
        deleteFilterExceptNoReadList(s, j);
        if (s == 2) {
            deletePrivateUid(j);
            deleteFilterSessionModels(s, j);
        }
    }

    public int deleteSessionSettingModel(short s, long j) {
        int i;
        SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
        if (sessionSettingDBOper != null) {
            int deleteSessionSetting = sessionSettingDBOper.deleteSessionSetting(s, j);
            i = deleteSessionSetting;
            if (deleteSessionSetting > 0) {
                if (AppInfo.m()) {
                    Logger.a(TAG, "deleteSessionSettingModel() | sessionType:", Short.valueOf(s), " | sessionId:", Long.valueOf(j));
                }
                removeSSModel(s, j);
                return deleteSessionSetting;
            }
        } else {
            i = -1;
        }
        return i;
    }

    public List<Long> getAllUids() {
        Vector vector = new Vector();
        vector.addAll(this.allPrivateUids);
        return vector;
    }

    public SessionSetting getOneSessionSetting(short s, long j) {
        SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
        if (sessionSettingDBOper != null) {
            SessionSetting oneSessionSetting = sessionSettingDBOper.getOneSessionSetting(s, j);
            if (oneSessionSetting == null) {
                if (AppInfo.m()) {
                    Logger.a(TAG, "getOneSessionSetting() | SessionSetting == null ！！！");
                }
                return oneSessionSetting;
            }
            if (AppInfo.m()) {
                Logger.a(TAG, "getOneSessionSetting() | ", oneSessionSetting.toString());
            }
            updateSSModel(s, j, oneSessionSetting);
            return oneSessionSetting;
        }
        return null;
    }

    public SessionSetting getSSModel(String str) {
        return this.allSSModels.get(str);
    }

    public SessionSetting getSSModel(short s, long j) {
        return this.allSSModels.get(SessionHeader.getSessionKey(s, j));
    }

    public Map<String, SessionSetting> getSessionSettingMap() {
        SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
        if (sessionSettingDBOper != null) {
            Map<String, SessionSetting> sessionSettingMap = sessionSettingDBOper.getSessionSettingMap();
            for (SessionSetting sessionSetting : sessionSettingMap.values()) {
                if (AppInfo.m()) {
                    Logger.a(TAG, "获取SessionSetting() | ", sessionSetting.toString());
                }
                updateSSModel(sessionSetting);
            }
            return sessionSettingMap;
        }
        return null;
    }

    public void init(SessionSettingDBOper sessionSettingDBOper) {
        this.mDBOper = sessionSettingDBOper;
    }

    public void notifySessionListChanged() {
        if (MsgFilterManager.getInstance().isFilterSwitchOpen()) {
            final ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            arrayList.addAll(this.filterSessionModels.values());
            arrayList2.addAll(this.filterExceptHasNoReadList.values());
            if (AppInfo.m()) {
                Logger.a(TAG, "notifySessionListChanged(), session size:", Integer.valueOf(arrayList.size()), ", listener size:", Integer.valueOf(arrayList.size()));
            }
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.chat.manager.SessionDataManager.3
                @Override // java.lang.Runnable
                public void run() {
                    for (FilterSessionListListener filterSessionListListener : SessionDataManager.this.listeners) {
                        filterSessionListListener.onUISessionDataChanged(arrayList, arrayList2);
                    }
                }
            });
        }
    }

    public void notifySessionListChanged(final FilterSessionListListener filterSessionListListener) {
        if (MsgFilterManager.getInstance().isFilterSwitchOpen()) {
            final ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            arrayList.addAll(this.filterSessionModels.values());
            arrayList2.addAll(this.filterExceptHasNoReadList.values());
            if (AppInfo.m()) {
                Logger.a(TAG, "notifySessionListChanged(), session size:", Integer.valueOf(arrayList.size()), ", listener size:", Integer.valueOf(arrayList.size()));
            }
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.chat.manager.SessionDataManager.2
                @Override // java.lang.Runnable
                public void run() {
                    filterSessionListListener.onUISessionDataChanged(arrayList, arrayList2);
                }
            });
        }
    }

    @Override // com.blued.android.module.chat.StableSessionListListener
    public void onUISessionDataChanged(List<SessionModel> list) {
        if (MsgFilterManager.getInstance().isFilterSwitchOpen()) {
            if (!PreferencesUtils.getUpdateFinish()) {
                if (AppInfo.m()) {
                    Logger.a(TAG, "onUISessionDataChanged(), 没有更新过关系数据，走更新关系数据逻辑");
                }
                ChatRelationDataManager.getInstance().updateRelationData(new ChatRelationDataManager.UpdateRelationCallback() { // from class: com.blued.android.module.chat.manager.SessionDataManager.1
                    @Override // com.blued.android.module.chat.manager.ChatRelationDataManager.UpdateRelationCallback
                    public void finish(int i, String str) {
                        if (i == 200) {
                            if (AppInfo.m()) {
                                Logger.a(SessionDataManager.TAG, "onUISessionDataChanged(), 更新关系成功,主动筛选");
                            }
                            MsgFilterManager.getInstance().filterData();
                        }
                    }
                });
                return;
            }
            this.filterExceptHasNoReadList.clear();
            this.filterSessionModels.clear();
            boolean initiatorSwitch = PreferencesUtils.getInitiatorSwitch();
            boolean followerSwitch = PreferencesUtils.getFollowerSwitch();
            boolean nearbySwitch = PreferencesUtils.getNearbySwitch();
            for (SessionModel sessionModel : list) {
                String sessionKey = SessionHeader.getSessionKey(sessionModel.sessionType, sessionModel.sessionId);
                if (FilterTools.checkCondition(getSSModel(sessionKey), initiatorSwitch, followerSwitch, nearbySwitch)) {
                    this.filterSessionModels.put(sessionKey, sessionModel);
                } else if (sessionModel.noReadMsgCount > 0) {
                    this.filterExceptHasNoReadList.put(sessionKey, sessionModel);
                }
            }
            notifySessionListChanged();
        }
    }

    public void registerFilterSessionListListener(FilterSessionListListener filterSessionListListener) {
        if (!this.listeners.contains(filterSessionListListener)) {
            this.listeners.add(filterSessionListListener);
            notifySessionListChanged(filterSessionListListener);
        }
        if (this.isRegistSessionListListener) {
            return;
        }
        this.isRegistSessionListListener = true;
        ChatManager.getInstance().registerSessionListener(this);
    }

    public void saveSession(SessionModel sessionModel) {
        if (sessionModel == null) {
            if (AppInfo.m()) {
                Logger.a(TAG, "saveSession(session) | session == null !!! ");
            }
        } else if (sessionModel.sessionType == 2) {
            if (AppInfo.m()) {
                Logger.a(TAG, "saveSession(session) | ", sessionModel.toString());
            }
            addPrivateUid(sessionModel.sessionId);
            ChatRelationDataManager.getInstance().updateRelationData(sessionModel);
        }
    }

    public void setSessionList(List<SessionModel> list) {
        if (list == null) {
            if (AppInfo.m()) {
                Logger.a(TAG, "setSessionList() | sessionList == null !!!");
                return;
            }
            return;
        }
        if (AppInfo.m()) {
            Logger.a(TAG, "setSessionList() | sessionList.size(): ", Integer.valueOf(list.size()));
        }
        if (list.size() > 0) {
            ArrayList<SessionModel> arrayList = new ArrayList();
            arrayList.addAll(list);
            ListUtils.sortSessionModelList(arrayList);
            ArrayList arrayList2 = new ArrayList();
            for (SessionModel sessionModel : arrayList) {
                if (sessionModel.sessionType == 2) {
                    arrayList2.add(Long.valueOf(sessionModel.sessionId));
                }
            }
            setAllPrivateUids(arrayList2);
        }
    }

    public void unRegisterFilterSessionListListener(FilterSessionListListener filterSessionListListener) {
        if (this.listeners.contains(filterSessionListListener)) {
            this.listeners.remove(filterSessionListListener);
        }
    }

    public void unRegisterSessionListener() {
        synchronized (this) {
            if (this.isRegistSessionListListener) {
                this.isRegistSessionListListener = false;
                ChatManager.getInstance().unregisterSessionListener(this);
            }
        }
    }

    public int updataSessionSetting(short s, long j, SessionSetting sessionSetting) {
        int i;
        SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
        if (sessionSettingDBOper != null) {
            int updataSessionSetting = sessionSettingDBOper.updataSessionSetting(sessionSetting);
            i = updataSessionSetting;
            if (updataSessionSetting > 0) {
                if (AppInfo.m()) {
                    Logger.a(TAG, "updataSessionSetting(ss) | " + sessionSetting.toString());
                }
                updateSSModel(s, j, sessionSetting);
                return updataSessionSetting;
            }
        } else {
            i = -1;
        }
        return i;
    }

    public int updateAllSessionSetting(Map<String, Object> map) {
        int i;
        SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
        if (sessionSettingDBOper != null) {
            int updateAllSessionSetting = sessionSettingDBOper.updateAllSessionSetting(map);
            i = updateAllSessionSetting;
            if (updateAllSessionSetting > 0) {
                if (AppInfo.m()) {
                    Logger.a(TAG, "updateAllSessionSetting(keyValues) | ", map.toString());
                }
                updateAllSSModel(map);
                return updateAllSessionSetting;
            }
        } else {
            i = -1;
        }
        return i;
    }

    public void updateFollower(long j, int i) {
        if (AppInfo.m()) {
            Logger.a(TAG, "updateFollower() | uid:", Long.valueOf(j), " | follower:", Integer.valueOf(i));
        }
        SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
        if (sessionSettingDBOper != null) {
            sessionSettingDBOper.updateFollower(j, i);
        }
    }

    public void updateOnLineState(List<Pair<Long, Integer>> list) {
        if (AppInfo.m()) {
            Logger.a(TAG, "updateOnLineState() | onlineStatusPairs:", list.toString());
        }
        ChatManager.getInstance().updateSessionOnLineState(list);
    }

    public void updateRelationSessionSettingList(List<SessionSetting> list) {
        if (AppInfo.m()) {
            Logger.a(TAG, "updateRelationSessionSettingList");
        }
        SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
        if (sessionSettingDBOper != null) {
            sessionSettingDBOper.updateRelationSessionSettingList(list);
        }
    }

    public int updateRelationSessionSettingListDb(List<SessionSettingBaseModel> list) {
        SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
        int updateRelationSessionSettingListDb = sessionSettingDBOper != null ? sessionSettingDBOper.updateRelationSessionSettingListDb(list) : -1;
        if (AppInfo.m()) {
            String str = TAG;
            Logger.a(str, "updateRelationSessionSettingListDb  result: " + updateRelationSessionSettingListDb);
        }
        return updateRelationSessionSettingListDb;
    }

    public void updateSession(SessionModel sessionModel) {
        if (sessionModel == null) {
            if (AppInfo.m()) {
                Logger.a(TAG, "updateSession(session) | session == null !!!");
            }
        } else if (sessionModel.sessionType == 2) {
            if (AppInfo.m()) {
                Logger.a(TAG, "updateSession(session) | ", sessionModel.toString());
            }
            addPrivateUid(sessionModel.sessionId);
        }
    }

    public int updateSessionSetting(short s, long j, Map<String, Object> map) {
        int i;
        SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
        if (sessionSettingDBOper != null) {
            int updateSessionSetting = sessionSettingDBOper.updateSessionSetting(s, j, map);
            i = updateSessionSetting;
            if (updateSessionSetting > 0) {
                if (AppInfo.m()) {
                    Logger.a(TAG, "updateSessionSetting(keyValues) | ", map.toString());
                }
                updateSSModel(s, j, map);
                return updateSessionSetting;
            }
        } else {
            i = -1;
        }
        return i;
    }

    public void updateSessionSetting(SessionSetting sessionSetting) {
        if (AppInfo.m()) {
            Logger.a(TAG, "updateSessionSetting() | SessionSetting:", sessionSetting.toString());
        }
        SessionSettingDBOper sessionSettingDBOper = this.mDBOper;
        if (sessionSettingDBOper != null) {
            sessionSettingDBOper.updateSessionSetting(sessionSetting);
        }
    }
}
