package com.blued.android.chat.core.worker.link;

import android.os.SystemClock;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.ConnPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.link.ReLinkTimer;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/link/Linker.class */
public class Linker implements IPackageQueue, LinkListener, ReLinkTimer.ReLinkListener {
    private static final String TAG = "Chat_Linker";
    private Stack<BasePackage> connStack;
    private AbstractLinkerImpl linkImpl;
    private ReLinkTimer reLinkTimer;
    private Stack<BasePackage> sendingStack;
    private Object linkLock = new Object();
    private LinkListener linkListener = null;
    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private Object stackLock = new Object();
    private Stack<BasePackage> normalStack = new Stack<>();

    public Linker() {
        Stack<BasePackage> stack = new Stack<>();
        this.connStack = stack;
        this.sendingStack = stack;
    }

    public void appActiveChanged(boolean z) {
        if (z) {
            ReLinkTimer reLinkTimer = this.reLinkTimer;
            if (reLinkTimer != null) {
                reLinkTimer.stop();
            }
            checkNet();
        }
    }

    public void cancelPackage(BasePackage basePackage) {
        if (ChatManager.debug) {
            Log.v(TAG, "cancelPackage(), pack:" + basePackage);
        }
        synchronized (this.stackLock) {
            this.connStack.remove(basePackage);
            this.normalStack.remove(basePackage);
        }
    }

    public void checkNet() {
        if (ChatManager.debug) {
            Log.v(TAG, "checkNet()");
        }
        synchronized (this.linkLock) {
            if (this.linkImpl != null && this.linkImpl.getState() != 0 && !this.linkImpl.isReleased()) {
                if (!AbstractLinkerImpl.isLinkerMatch(this.linkImpl)) {
                    if (ChatManager.debug) {
                        Log.v(TAG, "link is not match the net, so release it and link new one");
                    }
                    this.linkImpl.release();
                    this.linkImpl = null;
                    link();
                }
            }
            if (ChatManager.debug) {
                Log.v(TAG, "link is unlink, so link it");
            }
            link();
        }
    }

    @Override // com.blued.android.chat.core.worker.link.IPackageQueue
    public BasePackage getNext() {
        if (ChatManager.debug) {
            Log.v(TAG, "getNext()");
        }
        synchronized (this.stackLock) {
            if (this.sendingStack == null || this.sendingStack.isEmpty()) {
                return null;
            }
            return this.sendingStack.get(0);
        }
    }

    public int getState() {
        synchronized (this.linkLock) {
            if (this.linkImpl == null) {
                return 0;
            }
            return this.linkImpl.getState();
        }
    }

    public void link() {
        link(false);
    }

    public void link(boolean z) {
        if (ChatManager.debug) {
            Log.v(TAG, "link()");
        }
        synchronized (this.linkLock) {
            if (this.executor.isShutdown()) {
                this.executor = Executors.newSingleThreadExecutor();
            }
            if (this.linkImpl != null && !AbstractLinkerImpl.isLinkerMatch(this.linkImpl)) {
                if (ChatManager.debug) {
                    Log.v(TAG, "link is not match net, release it");
                }
                this.linkImpl.release();
                this.linkImpl = null;
            }
            if (this.linkImpl != null && !this.linkImpl.isReleased()) {
                if (this.linkImpl.getState() == 0) {
                    if (ChatManager.debug) {
                        Log.v(TAG, "link state is UNLINK, link it");
                    }
                    this.linkImpl.link(z);
                }
            }
            if (ChatManager.debug) {
                Log.v(TAG, "create a new link, and link it");
            }
            AbstractLinkerImpl createNewLinker = AbstractLinkerImpl.createNewLinker(this, this);
            this.linkImpl = createNewLinker;
            createNewLinker.link(z);
        }
    }

    public void linkAuthed() {
        if (ChatManager.debug) {
            Log.v(TAG, "linkAuthed()");
        }
        synchronized (this.linkLock) {
            if (this.linkImpl != null) {
                this.linkImpl.linkAuthed();
            }
        }
    }

    @Override // com.blued.android.chat.core.worker.link.LinkListener
    public void onLinkReceive(final BasePackage basePackage) {
        synchronized (this) {
            this.executor.execute(new Runnable() { // from class: com.blued.android.chat.core.worker.link.Linker.1
                @Override // java.lang.Runnable
                public void run() {
                    if (Linker.this.linkListener != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        Linker.this.linkListener.onLinkReceive(basePackage);
                        long uptimeMillis2 = SystemClock.uptimeMillis();
                        if (ChatManager.debug) {
                            Log.v(Linker.TAG, "the package handle take time:" + (uptimeMillis2 - uptimeMillis));
                        }
                    }
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.link.LinkListener
    public void onLinkSendFailed(BasePackage basePackage, String str) {
        if (ChatManager.debug) {
            Log.v(TAG, "onLinkSendFailed(), pack:" + basePackage + ", failedMessage:" + str);
        }
        synchronized (this.stackLock) {
            this.normalStack.remove(basePackage);
            this.connStack.remove(basePackage);
        }
        LinkListener linkListener = this.linkListener;
        if (linkListener != null) {
            linkListener.onLinkSendFailed(basePackage, str);
        }
    }

    @Override // com.blued.android.chat.core.worker.link.LinkListener
    public void onLinkSendSuccess(BasePackage basePackage) {
        if (ChatManager.debug) {
            Log.v(TAG, "onLinkSendSuccess(), pack:" + basePackage);
        }
        synchronized (this.stackLock) {
            this.normalStack.remove(basePackage);
            this.connStack.remove(basePackage);
        }
        LinkListener linkListener = this.linkListener;
        if (linkListener != null) {
            linkListener.onLinkSendSuccess(basePackage);
        }
    }

    @Override // com.blued.android.chat.core.worker.link.LinkListener
    public void onLinkStateChanged(int i) {
        if (ChatManager.debug) {
            Log.v(TAG, "onLinkStateChanged(), newState:" + i);
        }
        synchronized (this.stackLock) {
            if (i < 3) {
                if (ChatManager.debug) {
                    Log.v(TAG, "switch sendingStack to connStack");
                }
                this.sendingStack = this.connStack;
            } else {
                if (ChatManager.debug) {
                    Log.v(TAG, "switch sendingStack to normalStack");
                }
                this.sendingStack = this.normalStack;
            }
        }
        synchronized (this.linkLock) {
            if (i == 0) {
                if (this.linkImpl != null) {
                    if (ChatManager.debug) {
                        Log.v(TAG, "socketlinker failed, so change to httplinker, and start pendingLink for SocketLinker" + i);
                    }
                    this.linkImpl.release();
                    this.linkImpl = null;
                }
                if (this.executor != null && !this.executor.isShutdown()) {
                    if (this.reLinkTimer == null) {
                        this.reLinkTimer = new ReLinkTimer(this);
                    }
                    this.reLinkTimer.start();
                }
            } else if (i >= 2) {
                if (this.reLinkTimer != null) {
                    this.reLinkTimer.stop();
                }
                if (this.linkImpl != null) {
                    this.linkImpl.notifyPackageHandler();
                }
            }
        }
        LinkListener linkListener = this.linkListener;
        if (linkListener != null) {
            linkListener.onLinkStateChanged(i);
        }
        if (i == 0) {
            if (ChatManager.debug) {
                Log.v(TAG, "newState is unlink, clear pack stack and notify failed");
            }
            ArrayList<BasePackage> arrayList = new ArrayList();
            synchronized (this.stackLock) {
                arrayList.addAll(this.connStack);
                arrayList.addAll(this.normalStack);
                this.connStack.clear();
                this.normalStack.clear();
            }
            for (BasePackage basePackage : arrayList) {
                LinkListener linkListener2 = this.linkListener;
                if (linkListener2 != null) {
                    linkListener2.onLinkSendFailed(basePackage, "link state is changed to UNLINK");
                }
            }
        }
    }

    @Override // com.blued.android.chat.core.worker.link.ReLinkTimer.ReLinkListener
    public boolean onReLink(int i, int i2) {
        if (ChatManager.debug) {
            Log.v(TAG, "onReLink(), retryCount:" + i + ", timeFreqMs:" + i2);
        }
        checkNet();
        return true;
    }

    public void registerLinkListener(LinkListener linkListener) {
        this.linkListener = linkListener;
    }

    public void relink(boolean z) {
        if (ChatManager.debug) {
            Log.v(TAG, "relink()");
        }
        synchronized (this.linkLock) {
            if (this.linkImpl == null || this.linkImpl.isReleased()) {
                link(z);
            } else {
                this.linkImpl.relink(z);
            }
        }
    }

    public void sendPackage(BasePackage basePackage) {
        sendPackage(basePackage, true);
    }

    public void sendPackage(BasePackage basePackage, boolean z) {
        if (ChatManager.debug) {
            Log.v(TAG, "sendPackage(), pack:" + basePackage + ", retryLink:" + z);
        }
        basePackage.sendTime = SystemClock.uptimeMillis();
        synchronized (this.stackLock) {
            if (basePackage instanceof ConnPackage) {
                this.connStack.add(basePackage);
            } else {
                this.normalStack.add(basePackage);
            }
        }
        synchronized (this.linkLock) {
            if (this.linkImpl != null && this.linkImpl.getState() != 0 && !this.linkImpl.isReleased()) {
                if (ChatManager.debug) {
                    Log.v(TAG, "add this pack to stack");
                }
                this.linkImpl.notifyPackageHandler();
            } else if (z) {
                if (ChatManager.debug) {
                    Log.v(TAG, "current link is unlink, so link it");
                }
                link();
            }
        }
    }

    public void unlink() {
        if (ChatManager.debug) {
            Log.v(TAG, "unlink()");
        }
        synchronized (this.linkLock) {
            this.executor.shutdownNow();
            if (this.linkImpl != null) {
                this.linkImpl.release();
                this.linkImpl = null;
            }
            if (this.reLinkTimer != null) {
                this.reLinkTimer.stop();
            }
            onLinkStateChanged(0);
        }
    }

    public void unregisterLinkListener(LinkListener linkListener) {
        if (this.linkListener == linkListener) {
            this.linkListener = null;
        }
    }
}
