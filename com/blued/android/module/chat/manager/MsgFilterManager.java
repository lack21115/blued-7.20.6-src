package com.blued.android.module.chat.manager;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.chat.contract.FilterSessionListListener;
import com.blued.android.module.chat.model.SessionSetting;
import com.blued.android.module.chat.utils.FilterTools;
import com.blued.android.module.chat.utils.PreferencesUtils;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/manager/MsgFilterManager.class */
public class MsgFilterManager {
    private static MsgFilterManager instance;
    private boolean filterSwitchOpen;
    private String TAG = "@@@ module_chat_MsgFilterManager";
    private volatile boolean updateRelationFinishNeedFilter = false;

    private MsgFilterManager() {
        this.filterSwitchOpen = false;
        if (getInitiatorSwitch() || getFollowerSwitch() || getNearBySwitch()) {
            this.filterSwitchOpen = true;
        } else {
            this.filterSwitchOpen = false;
        }
    }

    public static MsgFilterManager getInstance() {
        if (instance == null) {
            instance = new MsgFilterManager();
        }
        return instance;
    }

    @Deprecated
    public void checkFilterStatus() {
        if (this.updateRelationFinishNeedFilter) {
            filterData();
        }
    }

    public void filterData() {
        synchronized (this) {
            ChatManager.getInstance().getSessionModelList(new FetchDataListener<List<SessionModel>>() { // from class: com.blued.android.module.chat.manager.MsgFilterManager.1
                @Override // com.blued.android.chat.listener.FetchDataListener
                public void onFetchData(final List<SessionModel> list) {
                    if (PreferencesUtils.getUpdateFinish()) {
                        ThreadManager.a().a(new ThreadExecutor("session_filter_thread") { // from class: com.blued.android.module.chat.manager.MsgFilterManager.1.1
                            @Override // com.blued.android.framework.pool.ThreadExecutor
                            public void execute() {
                                MsgFilterManager.this.updateRelationFinishNeedFilter = false;
                                SessionDataManager.getInstance().clearFilterSessionModel(false);
                                boolean initiatorSwitch = PreferencesUtils.getInitiatorSwitch();
                                boolean followerSwitch = PreferencesUtils.getFollowerSwitch();
                                boolean nearbySwitch = PreferencesUtils.getNearbySwitch();
                                for (SessionModel sessionModel : list) {
                                    if (sessionModel.sessionType == 2) {
                                        SessionSetting sSModel = SessionDataManager.getInstance().getSSModel(sessionModel.sessionType, sessionModel.sessionId);
                                        if (AppInfo.m()) {
                                            if (sSModel == null) {
                                                String str = MsgFilterManager.this.TAG;
                                                Logger.b(str, "SessionSetting == null !!! sessionType：" + ((int) sessionModel.sessionType) + " | sessionId:" + sessionModel.sessionId);
                                            } else {
                                                String str2 = MsgFilterManager.this.TAG;
                                                Logger.b(str2, "获取到 SessionSetting:" + sSModel.toString());
                                            }
                                        }
                                        if (FilterTools.checkCondition(sSModel, initiatorSwitch, followerSwitch, nearbySwitch)) {
                                            SessionDataManager.getInstance().addFilterSessionModel(sessionModel, false);
                                        }
                                    }
                                }
                                SessionDataManager.getInstance().notifySessionListChanged();
                            }
                        });
                    } else {
                        MsgFilterManager.this.updateRelationFinishNeedFilter = true;
                    }
                }
            });
        }
    }

    public boolean getFollowerSwitch() {
        return PreferencesUtils.getFollowerSwitch();
    }

    public boolean getInitiatorSwitch() {
        return PreferencesUtils.getInitiatorSwitch();
    }

    public boolean getNearBySwitch() {
        return PreferencesUtils.getNearbySwitch();
    }

    public boolean getOnlineSwitch() {
        return PreferencesUtils.getOnlineSwitch();
    }

    public boolean isFilterSwitchOpen() {
        return this.filterSwitchOpen;
    }

    public void registerFilterSessionListListener(FilterSessionListListener filterSessionListListener) {
        SessionDataManager.getInstance().registerFilterSessionListListener(filterSessionListListener);
    }

    public void setFilterSwitch(boolean z, boolean z2, boolean z3) {
        setInitiatorSwitch(z);
        setFollowerSwitch(z2);
        setNearBySwitch(z3);
        if (z || z2 || z3) {
            this.filterSwitchOpen = true;
        } else {
            this.filterSwitchOpen = false;
        }
    }

    public void setFilterSwitch(boolean z, boolean z2, boolean z3, boolean z4) {
        setInitiatorSwitch(z);
        setFollowerSwitch(z2);
        setNearBySwitch(z3);
        setOnlineSwitch(z4);
        if (z || z2 || z3) {
            this.filterSwitchOpen = true;
        } else {
            this.filterSwitchOpen = false;
        }
    }

    public void setFollowerSwitch(boolean z) {
        PreferencesUtils.setFollowerSwitch(z);
        if (getInitiatorSwitch() || z || getNearBySwitch()) {
            this.filterSwitchOpen = true;
        } else {
            this.filterSwitchOpen = false;
        }
    }

    public void setInitiatorSwitch(boolean z) {
        PreferencesUtils.setInitiatorSwitch(z);
        if (z || getFollowerSwitch() || getNearBySwitch()) {
            this.filterSwitchOpen = true;
        } else {
            this.filterSwitchOpen = false;
        }
    }

    public void setNearBySwitch(boolean z) {
        PreferencesUtils.setNearbySwitch(z);
        if (getInitiatorSwitch() || getFollowerSwitch() || z) {
            this.filterSwitchOpen = true;
        } else {
            this.filterSwitchOpen = false;
        }
    }

    public void setOnlineSwitch(boolean z) {
        PreferencesUtils.setOnlineSwitch(z);
    }

    public void unRegisterFilterSessionListListener(FilterSessionListListener filterSessionListListener) {
        SessionDataManager.getInstance().unRegisterFilterSessionListListener(filterSessionListListener);
    }

    public void unRegisterSessionListener() {
        SessionDataManager.getInstance().unRegisterSessionListener();
    }
}
