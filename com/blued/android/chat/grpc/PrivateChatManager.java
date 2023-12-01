package com.blued.android.chat.grpc;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.blued.android.chat.db.DBOper;
import com.blued.android.chat.grpc.core.chat.PrivateChatController;
import com.blued.android.chat.grpc.core.link.Connector;
import com.blued.android.chat.grpc.info.ChatAppInfo;
import com.blued.android.chat.grpc.info.ChatConnectInfo;
import com.blued.android.chat.grpc.info.ChatUserInfo;
import com.blued.android.chat.grpc.listener.ChatTipsListener;
import com.blued.android.chat.grpc.listener.ConnectListener;
import com.blued.android.chat.grpc.listener.ReceiveMsgListener;
import com.blued.android.chat.grpc.utils.ChatLog;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.module.im.IM;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/PrivateChatManager.class */
public class PrivateChatManager {
    private static volatile PrivateChatManager instance;
    private ChatAppInfo appInfo;
    private PrivateChatController chat;
    private Connector connector;
    private ChatUserInfo userInfo;
    public static final String TAG = PrivateChatManager.class.getSimpleName();
    public static boolean isDebug = true;
    private Gson gson = new Gson();
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    private PrivateChatManager() {
        Connector connector = new Connector();
        this.connector = connector;
        this.chat = new PrivateChatController(connector);
    }

    private File getDebugLogFile(Context context) {
        File file = new File(context.getFilesDir(), "blued_debug_log");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "blued_chat_grpc.txt");
        if (file2.exists() && file2.length() > 1024000 && !file2.delete()) {
            ChatLog.e(TAG, "文件大小超过限制, 但删除失败");
            return null;
        }
        try {
            file2.createNewFile();
            return file2;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static PrivateChatManager getInstance() {
        if (instance == null) {
            synchronized (PrivateChatManager.class) {
                try {
                    if (instance == null) {
                        instance = new PrivateChatManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public ChatAppInfo getChatAppInfo() {
        ChatAppInfo chatAppInfo = this.appInfo;
        ChatAppInfo chatAppInfo2 = chatAppInfo;
        if (chatAppInfo == null) {
            chatAppInfo2 = new ChatAppInfo();
        }
        return chatAppInfo2;
    }

    public Gson getGson() {
        return this.gson;
    }

    public int getUid() {
        try {
            String str = getInstance().getUserInfo().uid;
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (Exception e) {
            return -1;
        }
    }

    public ChatUserInfo getUserInfo() {
        ChatUserInfo chatUserInfo = this.userInfo;
        ChatUserInfo chatUserInfo2 = chatUserInfo;
        if (chatUserInfo == null) {
            chatUserInfo2 = new ChatUserInfo();
        }
        return chatUserInfo2;
    }

    public void init(ChatAppInfo chatAppInfo, ChatConnectInfo chatConnectInfo, DBOper dBOper, boolean z) {
        isDebug = z;
        this.appInfo = chatAppInfo;
        IM.a(z);
        this.connector.setChatConnectInfo(chatConnectInfo);
        PrivateChatController privateChatController = this.chat;
        DBOper dBOper2 = dBOper;
        if (dBOper == null) {
            dBOper2 = DBOper.EmptyDBOper;
        }
        privateChatController.setDbOperImpl(dBOper2);
        try {
            if (!z) {
                ChatLog.init(chatAppInfo.context, false, null);
                return;
            }
            File debugLogFile = getDebugLogFile(chatAppInfo.context);
            if (debugLogFile != null) {
                ChatLog.init(chatAppInfo.context, true, debugLogFile);
            } else {
                ChatLog.init(chatAppInfo.context, false, null);
            }
        } catch (Throwable th) {
            String str = TAG;
            ChatLog.e(str, "ChatLog init error :" + th);
        }
    }

    public void pause() {
        ChatLog.d(TAG, "pause()");
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.grpc.PrivateChatManager.4
            @Override // java.lang.Runnable
            public void run() {
                ChatLog.d(PrivateChatManager.TAG, "pause() running");
                long uptimeMillis = SystemClock.uptimeMillis();
                if (PrivateChatManager.this.connector != null) {
                    PrivateChatManager.this.connector.pause();
                }
                String str = PrivateChatManager.TAG;
                ChatLog.d(str, "pause() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
            }
        });
    }

    public void registerChatTipsListener(final ChatTipsListener chatTipsListener) {
        ChatLog.d(TAG, "ChatTipsListener");
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.grpc.PrivateChatManager.6
            @Override // java.lang.Runnable
            public void run() {
                if (PrivateChatManager.this.chat != null) {
                    PrivateChatManager.this.chat.registerChatTipsListener(chatTipsListener);
                }
            }
        });
    }

    public void registerConnectListener(final ConnectListener connectListener) {
        ChatLog.d(TAG, "registerConnectListener");
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.grpc.PrivateChatManager.7
            @Override // java.lang.Runnable
            public void run() {
                if (PrivateChatManager.this.connector != null) {
                    PrivateChatManager.this.connector.registerConnectListener(connectListener);
                }
            }
        });
    }

    public void registerExternalMsgListener(final ReceiveMsgListener receiveMsgListener) {
        ChatLog.d(TAG, "registerExternalMsgListener");
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.grpc.PrivateChatManager.9
            @Override // java.lang.Runnable
            public void run() {
                if (PrivateChatManager.this.connector != null) {
                    PrivateChatManager.this.connector.registerExternalReceiveListener(receiveMsgListener);
                }
            }
        });
    }

    public void resume() {
        ChatLog.d(TAG, "resume()");
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.grpc.PrivateChatManager.3
            @Override // java.lang.Runnable
            public void run() {
                ChatLog.d(PrivateChatManager.TAG, "resume() running");
                long uptimeMillis = SystemClock.uptimeMillis();
                if (PrivateChatManager.this.connector != null) {
                    PrivateChatManager.this.connector.resume();
                }
                String str = PrivateChatManager.TAG;
                ChatLog.d(str, "resume() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
            }
        });
    }

    public void sendMsg(final ChattingModel chattingModel) {
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.grpc.PrivateChatManager.11
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (PrivateChatManager.this.chat != null) {
                    PrivateChatManager.this.chat.sendMsg(chattingModel);
                }
                String str = PrivateChatManager.TAG;
                ChatLog.v(str, "sendMsg() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
            }
        });
    }

    public void shutdownNow() {
        this.executor.shutdownNow();
        instance = null;
    }

    public void start(ChatUserInfo chatUserInfo) {
        String str = TAG;
        ChatLog.d(str, "start---" + chatUserInfo.token);
        this.userInfo = chatUserInfo;
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.grpc.PrivateChatManager.2
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (PrivateChatManager.this.chat != null) {
                    PrivateChatManager.this.chat.start();
                }
                if (PrivateChatManager.this.connector != null) {
                    PrivateChatManager.this.connector.start();
                }
                String str2 = PrivateChatManager.TAG;
                ChatLog.v(str2, "start() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
            }
        });
    }

    public void stop() {
        ChatLog.d(TAG, "stop-----");
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.grpc.PrivateChatManager.5
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (PrivateChatManager.this.chat != null) {
                    PrivateChatManager.this.chat.stop();
                }
                if (PrivateChatManager.this.connector != null) {
                    PrivateChatManager.this.connector.stop();
                }
                String str = PrivateChatManager.TAG;
                ChatLog.v(str, "stop() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
            }
        });
    }

    public void unregisterConnectListener(final ConnectListener connectListener) {
        ChatLog.d(TAG, "unregisterConnectListener");
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.grpc.PrivateChatManager.8
            @Override // java.lang.Runnable
            public void run() {
                if (PrivateChatManager.this.connector != null) {
                    PrivateChatManager.this.connector.unregisterConnectListener(connectListener);
                }
            }
        });
    }

    public void unregisterExternalMsgListener(final ReceiveMsgListener receiveMsgListener) {
        ChatLog.d(TAG, "unregisterExternalMsgListener");
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.grpc.PrivateChatManager.10
            @Override // java.lang.Runnable
            public void run() {
                if (PrivateChatManager.this.connector != null) {
                    PrivateChatManager.this.connector.unregisterExternalReceiveListener(receiveMsgListener);
                }
            }
        });
    }

    public void updateConnectInfo(final ChatConnectInfo chatConnectInfo) {
        this.executor.execute(new Runnable() { // from class: com.blued.android.chat.grpc.PrivateChatManager.1
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (PrivateChatManager.this.connector != null) {
                    PrivateChatManager.this.connector.setChatConnectInfo(chatConnectInfo);
                }
                String str = PrivateChatManager.TAG;
                ChatLog.v(str, "updateConnectInfo() takes " + (SystemClock.uptimeMillis() - uptimeMillis));
            }
        });
    }
}
