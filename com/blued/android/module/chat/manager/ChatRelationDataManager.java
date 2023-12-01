package com.blued.android.module.chat.manager;

import android.os.Handler;
import android.util.Pair;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.chat.contract.IChatRelationDataListener;
import com.blued.android.module.chat.http.ModuleChatHttpUtils;
import com.blued.android.module.chat.model.SessionRelationModel;
import com.blued.android.module.chat.model.SessionSetting;
import com.blued.android.module.chat.utils.ListUtils;
import com.blued.android.module.chat.utils.PreferencesUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/manager/ChatRelationDataManager.class */
public class ChatRelationDataManager {
    private static ChatRelationDataManager instance;
    private String TAG = "@@@ module_chat_ChatRelationDataManager";
    private long lastUpdateTime = 0;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/manager/ChatRelationDataManager$SingleRelationRunnable.class */
    static class SingleRelationRunnable implements Runnable {
        private String TAG = "@@@ module_chat_SingleRelationRunnable";
        private long mUid;

        public SingleRelationRunnable(long j) {
            this.mUid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            ModuleChatHttpUtils.getInstance().getChatRelationData(new BluedUIHttpResponse<BluedEntity<SessionRelationModel, BluedEntityBaseExtra>>() { // from class: com.blued.android.module.chat.manager.ChatRelationDataManager.SingleRelationRunnable.1
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str) {
                    if (AppInfo.m()) {
                        Logger.b(SingleRelationRunnable.this.TAG, "返回关系数据 statusCode:", Integer.valueOf(i), " | errorMessage:", str);
                    }
                    return super.onUIFailure(i, str);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<SessionRelationModel, BluedEntityBaseExtra> bluedEntity) {
                    if (AppInfo.m()) {
                        Logger.b(SingleRelationRunnable.this.TAG, "返回关系数据 request()");
                    }
                    if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                        return;
                    }
                    if (AppInfo.m()) {
                        Logger.b(SingleRelationRunnable.this.TAG, "size:", Integer.valueOf(bluedEntity.data.size()));
                    }
                    for (SessionRelationModel sessionRelationModel : bluedEntity.data) {
                        if (AppInfo.m()) {
                            Logger.b(SingleRelationRunnable.this.TAG, "sessionRelationModel:", sessionRelationModel.toString());
                        }
                        SessionSetting sSModel = SessionDataManager.getInstance().getSSModel((short) 2, sessionRelationModel.getUid());
                        if (sSModel != null) {
                            sSModel.copySessionRelation(sessionRelationModel);
                            if (AppInfo.m()) {
                                Logger.b(SingleRelationRunnable.this.TAG, "sessionSetting:", sSModel.toString());
                            }
                            if (sessionRelationModel.getDelete() == 1) {
                                SessionDataManager.getInstance().deleteSessionAndChattingWithSetting(sSModel.getSessionType(), sSModel.getSessionId());
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(new Pair(Short.valueOf(sSModel.getSessionType()), Long.valueOf(sSModel.getSessionId())));
                                ChatRelationDataListenerManager.getInstance().onDeleteSessions(arrayList);
                            } else {
                                SessionDataManager.getInstance().updateSessionSetting(sSModel);
                            }
                            if (sSModel.getSessionId() == SingleRelationRunnable.this.mUid) {
                                Vector vector = new Vector();
                                vector.add(new Pair(Long.valueOf(sSModel.getSessionId()), Integer.valueOf(sSModel.getOnline())));
                                SessionDataManager.getInstance().updateOnLineState(vector);
                            }
                        } else if (AppInfo.m()) {
                            Logger.b(SingleRelationRunnable.this.TAG, "sessionSetting == null !!!");
                        }
                    }
                }
            }, new Long[]{Long.valueOf(this.mUid)});
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/manager/ChatRelationDataManager$UpdateRelationCallback.class */
    public interface UpdateRelationCallback {
        void finish(int i, String str);
    }

    private ChatRelationDataManager() {
    }

    public static ChatRelationDataManager getInstance() {
        if (instance == null) {
            instance = new ChatRelationDataManager();
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFinish(final UpdateRelationCallback updateRelationCallback, final int i, final String str) {
        Handler n = AppInfo.n();
        if (n != null) {
            n.postDelayed(new Runnable() { // from class: com.blued.android.module.chat.manager.ChatRelationDataManager.2
                @Override // java.lang.Runnable
                public void run() {
                    UpdateRelationCallback updateRelationCallback2 = updateRelationCallback;
                    if (updateRelationCallback2 != null) {
                        updateRelationCallback2.finish(i, str);
                    }
                }
            }, 1000L);
        }
    }

    public void registerChatRelationDataListener(IChatRelationDataListener iChatRelationDataListener) {
        ChatRelationDataListenerManager.getInstance().registerChatRelationDataListener(iChatRelationDataListener);
    }

    public void unRegisterChatRelationDataListener(IChatRelationDataListener iChatRelationDataListener) {
        ChatRelationDataListenerManager.getInstance().unRegisterChatRelationDataListener(iChatRelationDataListener);
    }

    @Deprecated
    public void updateRelationData(SessionModel sessionModel) {
        if (sessionModel == null) {
            Logger.b(this.TAG, "updateRelationData() session == null !!!");
        } else {
            AppInfo.n().postDelayed(new SingleRelationRunnable(sessionModel.sessionId), 1000L);
        }
    }

    public void updateRelationData(final UpdateRelationCallback updateRelationCallback) {
        synchronized (this) {
            if (updateRelationCallback == null) {
                updateFinish(updateRelationCallback, 404, "callback == null !!!");
                if (AppInfo.m()) {
                    Logger.b(this.TAG, "callback == null !!!");
                }
            } else if (this.lastUpdateTime != 0 && System.currentTimeMillis() - this.lastUpdateTime < 300000) {
                updateFinish(updateRelationCallback, 201, "更新关系数据，时间未到5分钟");
                if (AppInfo.m()) {
                    Logger.b(this.TAG, "更新关系数据，时间未到5分钟");
                }
            } else {
                final List<Long> allUids = SessionDataManager.getInstance().getAllUids();
                if (allUids != null && allUids.size() > 0) {
                    this.lastUpdateTime = System.currentTimeMillis();
                    ThreadManager.a().a(new ThreadExecutor("update_chat_relation_thread") { // from class: com.blued.android.module.chat.manager.ChatRelationDataManager.1
                        @Override // com.blued.android.framework.pool.ThreadExecutor
                        public void execute() {
                            int i = 500;
                            if (allUids.size() <= 500) {
                                i = allUids.size();
                            }
                            final ArrayList arrayList = new ArrayList();
                            final ArrayList arrayList2 = new ArrayList();
                            Iterator<Long[]> it = ListUtils.splitList(allUids.subList(0, i), 100).iterator();
                            while (it.hasNext()) {
                                Long[] next = it.next();
                                boolean hasNext = it.hasNext();
                                if (AppInfo.m()) {
                                    Logger.b(ChatRelationDataManager.this.TAG, "更新关系数据：", next);
                                }
                                final boolean z = !hasNext;
                                ModuleChatHttpUtils.getInstance().getChatRelationData(new BluedUIHttpResponse<BluedEntity<SessionRelationModel, BluedEntityBaseExtra>>() { // from class: com.blued.android.module.chat.manager.ChatRelationDataManager.1.1
                                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                                    public boolean onUIFailure(int i2, String str) {
                                        if (AppInfo.m()) {
                                            Logger.b(ChatRelationDataManager.this.TAG, "返回关系数据 statusCode:", Integer.valueOf(i2), " | errorMessage:", str);
                                        }
                                        return super.onUIFailure(i2, str);
                                    }

                                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                                    public void onUIFinish() {
                                        super.onUIFinish();
                                        if (z) {
                                            if (arrayList.size() > 0) {
                                                Vector vector = new Vector();
                                                vector.addAll(arrayList);
                                                SessionDataManager.getInstance().deleteSessionAndChattingWithSetting(vector);
                                                ChatRelationDataListenerManager.getInstance().onDeleteSessions(vector);
                                            }
                                            Vector vector2 = new Vector();
                                            vector2.addAll(arrayList2);
                                            SessionDataManager.getInstance().updateOnLineState(vector2);
                                            PreferencesUtils.setUpdtateFinish(true);
                                            MsgFilterManager.getInstance().checkFilterStatus();
                                            ChatRelationDataManager.this.updateFinish(updateRelationCallback, 200, null);
                                        }
                                    }

                                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                                    public void onUIUpdate(BluedEntity<SessionRelationModel, BluedEntityBaseExtra> bluedEntity) {
                                        if (AppInfo.m()) {
                                            Logger.b(ChatRelationDataManager.this.TAG, "返回关系数据 request()");
                                        }
                                        if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                                            return;
                                        }
                                        ArrayList arrayList3 = new ArrayList();
                                        if (AppInfo.m()) {
                                            String str = ChatRelationDataManager.this.TAG;
                                            Logger.b(str, "size:" + bluedEntity.data.size());
                                        }
                                        for (SessionRelationModel sessionRelationModel : bluedEntity.data) {
                                            if (AppInfo.m()) {
                                                Logger.b(ChatRelationDataManager.this.TAG, "sessionRelationModel:", sessionRelationModel.toString());
                                            }
                                            SessionSetting sSModel = SessionDataManager.getInstance().getSSModel((short) 2, sessionRelationModel.getUid());
                                            if (sSModel != null) {
                                                sSModel.copySessionRelation(sessionRelationModel);
                                                arrayList2.add(new Pair(Long.valueOf(sSModel.getSessionId()), Integer.valueOf(sSModel.getOnline())));
                                                if (sessionRelationModel.getDelete() == 1) {
                                                    arrayList.add(new Pair(Short.valueOf(sSModel.getSessionType()), Long.valueOf(sSModel.getSessionId())));
                                                } else {
                                                    arrayList3.add(sSModel);
                                                }
                                            } else if (AppInfo.m()) {
                                                Logger.b(ChatRelationDataManager.this.TAG, "sessionSetting == null !!!");
                                            }
                                        }
                                        if (arrayList3.size() > 0) {
                                            SessionDataManager.getInstance().updateRelationSessionSettingList(arrayList3);
                                        }
                                    }
                                }, next);
                            }
                        }
                    });
                    return;
                }
                updateFinish(updateRelationCallback, 404, "未更新关系数据：sessions == null || allUids.size() <= 0");
                if (AppInfo.m()) {
                    Logger.b(this.TAG, "未更新关系数据：sessions == null || allUids.size() <= 0");
                }
            }
        }
    }
}
