package com.blued.android.module.chat.manager;

import android.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.module.chat.contract.IChatRelationDataListener;
import java.util.List;
import java.util.Vector;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/manager/ChatRelationDataListenerManager.class */
public class ChatRelationDataListenerManager {
    private static ChatRelationDataListenerManager instance;
    private String TAG = "@@@ module_chat_ChatRelationDataListenerManager";
    private List<IChatRelationDataListener> listeners = new Vector();

    private ChatRelationDataListenerManager() {
    }

    public static ChatRelationDataListenerManager getInstance() {
        if (instance == null) {
            instance = new ChatRelationDataListenerManager();
        }
        return instance;
    }

    public void onDeleteSessions(final List<Pair<Short, Long>> list) {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.chat.manager.ChatRelationDataListenerManager.1
            @Override // java.lang.Runnable
            public void run() {
                for (IChatRelationDataListener iChatRelationDataListener : ChatRelationDataListenerManager.this.listeners) {
                    if (iChatRelationDataListener != null) {
                        iChatRelationDataListener.onDeleteSessions(list);
                    }
                }
            }
        });
    }

    public void registerChatRelationDataListener(IChatRelationDataListener iChatRelationDataListener) {
        if (iChatRelationDataListener == null || this.listeners.contains(iChatRelationDataListener)) {
            return;
        }
        this.listeners.add(iChatRelationDataListener);
    }

    public void unRegisterChatRelationDataListener(IChatRelationDataListener iChatRelationDataListener) {
        if (iChatRelationDataListener == null || !this.listeners.contains(iChatRelationDataListener)) {
            return;
        }
        this.listeners.remove(iChatRelationDataListener);
    }
}
