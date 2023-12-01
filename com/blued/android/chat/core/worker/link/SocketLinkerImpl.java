package com.blued.android.chat.core.worker.link;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/link/SocketLinkerImpl.class */
public class SocketLinkerImpl extends AbstractLinkerImpl {
    private static final String TAG = "Chat_SocketLinker";
    private Object linkLock = new Object();
    private SocketThread managerThread;

    private void stopSocketThread() {
        if (this.managerThread != null) {
            if (ChatManager.debug) {
                Log.v(TAG, "stop managerThread");
            }
            this.managerThread.setLinker(null);
            if (this.managerThread.isAlive()) {
                this.managerThread.notifyStop();
                try {
                    this.managerThread.join(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.managerThread = null;
        }
    }

    @Override // com.blued.android.chat.core.worker.link.AbstractLinkerImpl
    public void link(boolean z) {
        if (ChatManager.debug) {
            Log.v(TAG, "link()");
        }
        synchronized (this.linkLock) {
            int state = getState();
            if (ChatManager.debug) {
                Log.v(TAG, "current state:" + state);
            }
            if (state == 0 && !TextUtils.isEmpty(ChatManager.chatHostAddr) && ChatManager.chatHostPort > 0) {
                stopSocketThread();
                changeState(1);
                SocketThread socketThread = new SocketThread(ChatManager.chatHostAddr, ChatManager.chatHostPort, ChatManager.chatBackupPort, ChatManager.dnsManager, z ? !ChatManager.isDnsManagerPrior : ChatManager.isDnsManagerPrior, ChatManager.isSSL);
                this.managerThread = socketThread;
                socketThread.setLinker(this);
                this.managerThread.start();
            }
        }
    }

    @Override // com.blued.android.chat.core.worker.link.AbstractLinkerImpl
    public void notifyPackageHandler() {
        if (ChatManager.debug) {
            Log.v(TAG, "notifyPackageHandler()");
        }
        synchronized (this.linkLock) {
            if (this.managerThread != null) {
                this.managerThread.notifyPackage();
            }
        }
    }

    @Override // com.blued.android.chat.core.worker.link.AbstractLinkerImpl
    public void release() {
        if (ChatManager.debug) {
            Log.v(TAG, "release()");
        }
        super.release();
        synchronized (this.linkLock) {
            stopSocketThread();
            changeState(0);
        }
    }

    @Override // com.blued.android.chat.core.worker.link.AbstractLinkerImpl
    public void relink(boolean z) {
        if (ChatManager.debug) {
            Log.v(TAG, "relink(), useBackupLink:" + z);
        }
        synchronized (this.linkLock) {
            stopSocketThread();
            if (!TextUtils.isEmpty(ChatManager.chatHostAddr) && ChatManager.chatHostPort > 0) {
                SocketThread socketThread = new SocketThread(ChatManager.chatHostAddr, ChatManager.chatHostPort, ChatManager.chatBackupPort, ChatManager.dnsManager, z ? !ChatManager.isDnsManagerPrior : ChatManager.isDnsManagerPrior, ChatManager.isSSL);
                this.managerThread = socketThread;
                socketThread.setLinker(this);
                this.managerThread.start();
            }
        }
    }

    @Override // com.blued.android.chat.core.worker.link.AbstractLinkerImpl
    public void unlink() {
        if (ChatManager.debug) {
            Log.v(TAG, "unlink()");
        }
        synchronized (this.linkLock) {
            stopSocketThread();
            changeState(0);
        }
    }
}
