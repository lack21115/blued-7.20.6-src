package com.blued.android.chat.core.worker.link;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/link/AbstractLinkerImpl.class */
public abstract class AbstractLinkerImpl {
    private static final String TAG = "Chat_AbstractLinker";
    protected IPackageQueue packageQueue;
    private int state;
    private boolean released = false;
    protected Object stateLocker = new Object();
    protected LinkListener linkListener = null;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/link/AbstractLinkerImpl$LinkState.class */
    public interface LinkState {
        public static final int AUTHED = 3;
        public static final int LINKED = 2;
        public static final int LINKING = 1;
        public static final int UNLINK = 0;
    }

    public static AbstractLinkerImpl createNewLinker(LinkListener linkListener, IPackageQueue iPackageQueue) {
        SocketLinkerImpl socketLinkerImpl = new SocketLinkerImpl();
        socketLinkerImpl.registerLinkListener(linkListener);
        socketLinkerImpl.registerPackageQueue(iPackageQueue);
        return socketLinkerImpl;
    }

    public static boolean isLinkerMatch(AbstractLinkerImpl abstractLinkerImpl) {
        return abstractLinkerImpl instanceof SocketLinkerImpl;
    }

    private void unregisterLinkListener(LinkListener linkListener) {
        if (this.linkListener == linkListener) {
            this.linkListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void changeState(int i) {
        int i2;
        LinkListener linkListener;
        synchronized (this.stateLocker) {
            i2 = this.state;
            this.state = i;
        }
        if (i2 == i || (linkListener = this.linkListener) == null) {
            return;
        }
        linkListener.onLinkStateChanged(i);
    }

    public int getState() {
        int i;
        synchronized (this.stateLocker) {
            i = this.state;
        }
        return i;
    }

    public boolean isLinkFinished() {
        boolean z;
        synchronized (this.stateLocker) {
            z = this.state == 3;
        }
        return z;
    }

    public boolean isReleased() {
        return this.released;
    }

    public void link() {
        link(false);
    }

    public abstract void link(boolean z);

    public void linkAuthed() {
        changeState(3);
    }

    public abstract void notifyPackageHandler();

    protected void registerLinkListener(LinkListener linkListener) {
        this.linkListener = linkListener;
    }

    protected void registerPackageQueue(IPackageQueue iPackageQueue) {
        this.packageQueue = iPackageQueue;
    }

    public void release() {
        if (ChatManager.debug) {
            Log.v(TAG, "release");
        }
        this.released = true;
        this.linkListener = null;
        this.packageQueue = null;
    }

    public abstract void relink(boolean z);

    public abstract void unlink();
}
