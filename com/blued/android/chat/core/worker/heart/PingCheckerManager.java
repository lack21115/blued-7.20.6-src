package com.blued.android.chat.core.worker.heart;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.ChatManagerInner;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.heart.Heart;
import com.blued.android.chat.data.ConnectState;
import com.blued.android.chat.listener.IMStatusListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/heart/PingCheckerManager.class */
public class PingCheckerManager {
    private static final int PING_COUNT = 6;
    private static final int PING_INTERVAL = 5000;
    private static final String TAG = "Chat_PingChecker";
    private static final int WAIT_TIMEOUT = 30000;
    private IMStatusListener _imStatusListener;
    private Heart.PingReceiveListener _pingReceiveListener;
    private Timer _pingTestTimer;
    private HashSet<PingCheckerListener> pingCheckerListeners;
    private int pingTestCount;
    private AtomicBoolean pingTimerTesting;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/heart/PingCheckerManager$PingCheckerListener.class */
    public interface PingCheckerListener {
        void onPingCheckFinish();
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/heart/PingCheckerManager$SingletonCreator.class */
    static class SingletonCreator {
        public static final PingCheckerManager instance = new PingCheckerManager();

        private SingletonCreator() {
        }
    }

    private PingCheckerManager() {
        this.pingCheckerListeners = new HashSet<>();
        this.pingTestCount = 0;
        this.pingTimerTesting = new AtomicBoolean(false);
        this._imStatusListener = new IMStatusListener() { // from class: com.blued.android.chat.core.worker.heart.PingCheckerManager.1
            @Override // com.blued.android.chat.listener.IMStatusListener
            public void onConnected() {
                if (ChatManager.debug) {
                    Log.v(PingCheckerManager.TAG, "im connected, start ping test");
                }
                PingCheckerManager.this.startPingTest();
            }

            @Override // com.blued.android.chat.listener.IMStatusListener
            public void onConnecting() {
            }

            @Override // com.blued.android.chat.listener.IMStatusListener
            public void onDisconnected() {
            }

            @Override // com.blued.android.chat.listener.IMStatusListener
            public void onReceiving() {
            }
        };
        this._pingReceiveListener = new Heart.PingReceiveListener() { // from class: com.blued.android.chat.core.worker.heart.PingCheckerManager.2
            @Override // com.blued.android.chat.core.worker.heart.Heart.PingReceiveListener
            public void onReceivePing() {
                if (ChatManager.debug) {
                    Log.v(PingCheckerManager.TAG, "receive ping, checker finish");
                }
                PingCheckerManager.this.notifyPingCheckerFinish();
                PingCheckerManager.this.stopAllCheckImLink();
            }
        };
    }

    static /* synthetic */ int access$308(PingCheckerManager pingCheckerManager) {
        int i = pingCheckerManager.pingTestCount;
        pingCheckerManager.pingTestCount = i + 1;
        return i;
    }

    public static PingCheckerManager getInstance() {
        return SingletonCreator.instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPingCheckerFinish() {
        if (ChatManager.debug) {
            Log.v(TAG, "notifyPingCheckerFinish()");
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.pingCheckerListeners) {
            arrayList.addAll(this.pingCheckerListeners);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PingCheckerListener) it.next()).onPingCheckFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPingTest() {
        if (ChatManager.debug) {
            Log.v(TAG, "startPingTest(), pingTimerTesting:" + this.pingTimerTesting.get());
        }
        if (this.pingTimerTesting.compareAndSet(false, true)) {
            Timer timer = this._pingTestTimer;
            if (timer != null) {
                timer.cancel();
                this._pingTestTimer = null;
            }
            this.pingTestCount = 0;
            Heart heart = ChatManagerInner.getHeart();
            if (heart != null) {
                heart.registerPingReceiveListener(this._pingReceiveListener);
            }
            Timer timer2 = new Timer();
            timer2.schedule(new TimerTask() { // from class: com.blued.android.chat.core.worker.heart.PingCheckerManager.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Connector connector;
                    PingCheckerManager.access$308(PingCheckerManager.this);
                    if (ChatManager.debug) {
                        Log.v(PingCheckerManager.TAG, "ping testing, pingTestCount:" + PingCheckerManager.this.pingTestCount);
                    }
                    Heart heart2 = ChatManagerInner.getHeart();
                    if (heart2 != null) {
                        heart2.pingTest();
                    }
                    if (PingCheckerManager.this.pingTestCount > 6) {
                        if (PingCheckerManager.this.pingTimerTesting.get() && (connector = ChatManagerInner.getConnector()) != null) {
                            connector.pingFailed();
                        }
                        if (PingCheckerManager.this._pingTestTimer != null) {
                            PingCheckerManager.this._pingTestTimer.cancel();
                            PingCheckerManager.this._pingTestTimer = null;
                        }
                        PingCheckerManager.this.pingTimerTesting.set(false);
                    }
                }
            }, 0L, 5000L);
            this._pingTestTimer = timer2;
        }
    }

    private void stopPingTest() {
        if (ChatManager.debug) {
            Log.v(TAG, "stopPingTest()");
        }
        Timer timer = this._pingTestTimer;
        if (timer != null) {
            timer.cancel();
            this._pingTestTimer = null;
        }
        this.pingTimerTesting.set(false);
        Heart heart = ChatManagerInner.getHeart();
        if (heart != null) {
            heart.unregisterPingReceiveListener(this._pingReceiveListener);
        }
    }

    public boolean checkImLink(PingCheckerListener pingCheckerListener) {
        synchronized (this) {
            if (ChatManager.debug) {
                Log.v(TAG, "checkImLink(), listener:" + pingCheckerListener);
            }
            Connector connector = ChatManagerInner.getConnector();
            if (connector != null && connector.isWorking()) {
                if (pingCheckerListener != null) {
                    synchronized (this.pingCheckerListeners) {
                        this.pingCheckerListeners.add(pingCheckerListener);
                    }
                }
                if (connector.getConnectStatus() != ConnectState.CONNECTED) {
                    ChatManager.getInstance().registerIMStatusListener(this._imStatusListener);
                    connector.checkNet();
                } else {
                    startPingTest();
                }
                return false;
            }
            return true;
        }
    }

    public void stopAllCheckImLink() {
        synchronized (this) {
            if (ChatManager.debug) {
                Log.v(TAG, "stopAllCheckImLink()");
            }
            synchronized (this.pingCheckerListeners) {
                this.pingCheckerListeners.clear();
            }
            ChatManager.getInstance().unregisterIMStatusListener(this._imStatusListener);
            Heart heart = ChatManagerInner.getHeart();
            if (heart != null) {
                heart.unregisterPingReceiveListener(this._pingReceiveListener);
            }
            stopPingTest();
        }
    }

    public void stopCheckImLink(PingCheckerListener pingCheckerListener) {
        synchronized (this) {
            if (ChatManager.debug) {
                Log.v(TAG, "stopCheckImLink(), listener:" + pingCheckerListener);
            }
            int i = 0;
            if (pingCheckerListener != null) {
                synchronized (this.pingCheckerListeners) {
                    this.pingCheckerListeners.remove(pingCheckerListener);
                    i = this.pingCheckerListeners.size();
                }
            }
            if (i <= 0) {
                ChatManager.getInstance().unregisterIMStatusListener(this._imStatusListener);
                Heart heart = ChatManagerInner.getHeart();
                if (heart != null) {
                    heart.unregisterPingReceiveListener(this._pingReceiveListener);
                }
                stopPingTest();
            }
        }
    }
}
