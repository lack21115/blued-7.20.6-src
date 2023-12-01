package com.blued.android.chat.grpc.core.link;

import android.text.TextUtils;
import com.blued.android.chat.grpc.PrivateChatManager;
import com.blued.android.chat.grpc.core.BaseWorker;
import com.blued.android.chat.grpc.info.ChatConnectInfo;
import com.blued.android.chat.grpc.listener.ConnectListener;
import com.blued.android.chat.grpc.listener.MsgConsumer;
import com.blued.android.chat.grpc.listener.ReceiveMsgListener;
import com.blued.android.chat.grpc.utils.ChatLog;
import com.blued.android.module.im.IM;
import com.blued.android.module.im.grpc.OnConnectStateListener;
import com.google.protobuf.Any;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/core/link/Connector.class */
public class Connector extends BaseWorker {
    public static final String TAG = Connector.class.getSimpleName();
    private ChatConnectInfo connectInfo;
    private AtomicBoolean connected = new AtomicBoolean(false);
    private final Set<MsgConsumer> msgConsumers = new HashSet();
    private final Set<ReceiveMsgListener> receiveMsgListeners = new HashSet();
    private final Set<ConnectListener> connectListeners = new HashSet();
    private OnConnectStateListener mConnectStateListener = new OnConnectStateListener() { // from class: com.blued.android.chat.grpc.core.link.Connector.1
        @Override // com.blued.android.module.im.grpc.OnConnectStateListener
        public void onConnected() {
            Connector.this.connected.set(true);
            synchronized (Connector.this.connectListeners) {
                if (Connector.this.connectListeners.size() > 0) {
                    for (ConnectListener connectListener : Connector.this.connectListeners) {
                        connectListener.onConnected();
                    }
                }
            }
        }

        @Override // com.blued.android.module.im.grpc.OnConnectStateListener
        public void onConnecting() {
            synchronized (Connector.this.connectListeners) {
                if (Connector.this.connectListeners.size() > 0) {
                    for (ConnectListener connectListener : Connector.this.connectListeners) {
                        connectListener.onConnecting();
                    }
                }
            }
        }

        @Override // com.blued.android.module.im.grpc.OnConnectStateListener
        public void onDisconnected() {
            Connector.this.connected.set(false);
            synchronized (Connector.this.connectListeners) {
                if (Connector.this.connectListeners.size() > 0) {
                    for (ConnectListener connectListener : Connector.this.connectListeners) {
                        connectListener.onDisconnected(-1, "主动断开");
                    }
                }
            }
        }

        @Override // com.blued.android.module.im.grpc.OnConnectStateListener
        public void onReceive(Any any) {
            ChatLog.d(Connector.TAG, "onMessage-thread===" + Thread.currentThread().getName());
            ChatLog.d(Connector.TAG, "onMessage===" + any.toString());
            if (any != null) {
                boolean z = false;
                boolean z2 = false;
                try {
                    synchronized (Connector.this.msgConsumers) {
                        if (Connector.this.msgConsumers.size() > 0) {
                            Iterator it = Connector.this.msgConsumers.iterator();
                            while (true) {
                                z = z2;
                                if (!it.hasNext()) {
                                    break;
                                }
                                z2 |= ((MsgConsumer) it.next()).consumeMsg(any);
                            }
                        }
                    }
                    synchronized (Connector.this.receiveMsgListeners) {
                        if (!z && Connector.this.receiveMsgListeners.size() > 0) {
                            for (ReceiveMsgListener receiveMsgListener : Connector.this.receiveMsgListeners) {
                                receiveMsgListener.onReceiveMsg(any);
                            }
                        }
                    }
                } catch (Throwable th) {
                    ChatLog.e(Connector.TAG, "onMessage error : " + th);
                }
            }
        }
    };

    private void initIM() {
        if (this.connectInfo == null || PrivateChatManager.getInstance().getChatAppInfo().context == null) {
            return;
        }
        ChatLog.d(TAG, "initIM");
        IM.a(PrivateChatManager.getInstance().getChatAppInfo().context, this.connectInfo.host, this.connectInfo.dnsManager);
        IM.c().b(PrivateChatManager.getInstance().getChatAppInfo().platform).c(PrivateChatManager.getInstance().getChatAppInfo().appVersionName).d(PrivateChatManager.getInstance().getChatAppInfo().language).a(PrivateChatManager.getInstance().getChatAppInfo().channel).a(PrivateChatManager.getInstance().getChatAppInfo().appVersionCode);
    }

    private void startConnect() {
        if (this.connected.compareAndSet(false, true)) {
            ChatLog.d(TAG, "startConnect====");
            String str = PrivateChatManager.getInstance().getUserInfo().token;
            if (TextUtils.isEmpty(str)) {
                ChatLog.e(TAG, "startConnect token is empty !!");
                return;
            }
            IM.a(str);
            IM.a(this.mConnectStateListener);
            IM.a();
        }
    }

    private void stopConnect() {
        if (this.connected.compareAndSet(true, false)) {
            ChatLog.d(TAG, "stopConnect====");
            IM.b();
            IM.b(this.mConnectStateListener);
        }
    }

    @Override // com.blued.android.chat.grpc.core.BaseWorker
    public void onPause() {
        super.onPause();
        stopConnect();
    }

    @Override // com.blued.android.chat.grpc.core.BaseWorker
    public void onResume() {
        super.onResume();
        startConnect();
    }

    public void registerConnectListener(ConnectListener connectListener) {
        synchronized (this.connectListeners) {
            this.connectListeners.add(connectListener);
        }
    }

    public void registerExternalReceiveListener(ReceiveMsgListener receiveMsgListener) {
        synchronized (this.receiveMsgListeners) {
            this.receiveMsgListeners.add(receiveMsgListener);
        }
    }

    public void registerMsgConsumer(MsgConsumer msgConsumer) {
        synchronized (this.msgConsumers) {
            this.msgConsumers.add(msgConsumer);
        }
    }

    public void setChatConnectInfo(ChatConnectInfo chatConnectInfo) {
        if (chatConnectInfo == null) {
            throw new RuntimeException(" connectInfo is null ");
        }
        if (this.connected.get()) {
            stop();
        }
        this.connectInfo = chatConnectInfo;
        initIM();
    }

    public void unregisterConnectListener(ConnectListener connectListener) {
        synchronized (this.connectListeners) {
            this.connectListeners.remove(connectListener);
        }
    }

    public void unregisterExternalReceiveListener(ReceiveMsgListener receiveMsgListener) {
        synchronized (this.receiveMsgListeners) {
            this.receiveMsgListeners.remove(receiveMsgListener);
        }
    }

    public void unregisterMsgConsumer(MsgConsumer msgConsumer) {
        synchronized (this.msgConsumers) {
            this.msgConsumers.remove(msgConsumer);
        }
    }
}
