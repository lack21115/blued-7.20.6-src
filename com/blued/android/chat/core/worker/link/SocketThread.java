package com.blued.android.chat.core.worker.link;

import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.IMDebuger;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.BytesData;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.utils.BytesUtils;
import com.qiniu.android.dns.DnsManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/link/SocketThread.class */
public class SocketThread extends Thread {
    private static final int CONNECT_TIMEOUT_MS = 30000;
    private static final String TAG = "Chat_SocketThread";
    private AbstractLinkerImpl _linker;
    private final String addr;
    private final int backupPort;
    private final DnsManager dnsManager;
    private final boolean isDnsManagerPrior;
    private final boolean isSSL;
    private final int port;
    private final ConnectProgram[] retryPrograms;
    private AtomicBoolean stopFlag = new AtomicBoolean(false);
    private AtomicBoolean linkExceptionFlag = new AtomicBoolean(false);
    private int connectRetryCount = 0;
    private Socket _socket = null;
    private SendThread sendThread = null;
    private RecvThread recvThread = null;

    /* renamed from: com.blued.android.chat.core.worker.link.SocketThread$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/link/SocketThread$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$blued$android$chat$core$worker$link$SocketThread$ConnectProgram;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[ConnectProgram.values().length];
            $SwitchMap$com$blued$android$chat$core$worker$link$SocketThread$ConnectProgram = iArr;
            try {
                iArr[ConnectProgram.DnsManager.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$blued$android$chat$core$worker$link$SocketThread$ConnectProgram[ConnectProgram.Normal.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/link/SocketThread$ConnectProgram.class */
    enum ConnectProgram {
        DnsManager,
        Normal
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/link/SocketThread$RecvThread.class */
    public class RecvThread extends Thread {
        private boolean stop;

        private RecvThread() {
            this.stop = false;
        }

        /* synthetic */ RecvThread(SocketThread socketThread, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void notifyStop() {
            this.stop = true;
            synchronized (this) {
                notify();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedInputStream bufferedInputStream;
            Throwable th;
            BasePackage parseMsgBody;
            if (ChatManager.debug) {
                Log.v(SocketThread.TAG, "RecvThread running...");
            }
            byte[] bArr = new byte[6];
            BasePackage createEmptyHeader = BasePackage.createEmptyHeader();
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(SocketThread.this._socket.getInputStream());
                    while (!this.stop && !SocketThread.this.linkExceptionFlag.get()) {
                        try {
                            SocketThread.readFully(bufferedInputStream, bArr, 0, 1);
                            if (ChatManager.debug) {
                                Log.v(SocketThread.TAG, "read a pack header:" + ((int) bArr[0]));
                            }
                            createEmptyHeader.parseFixHeader(bArr[0]);
                            if (createEmptyHeader.hasPayLoads) {
                                if (ChatManager.debug) {
                                    Log.v(SocketThread.TAG, "pack has a payloads, so read 5 bytes more");
                                }
                                SocketThread.readFully(bufferedInputStream, bArr, 1, 5);
                                if (ChatManager.debug && ChatManager.debugByteData) {
                                    Log.v(SocketThread.TAG, "read payload header:" + BytesUtils.byte2HexStr(bArr, 1, 6));
                                }
                                try {
                                    createEmptyHeader.parsePayLoadsHeader(bArr, 1);
                                    BytesData bytesData = new BytesData(createEmptyHeader.msgBodyLength);
                                    if (ChatManager.debug) {
                                        Log.v(SocketThread.TAG, "read msgbady, length:" + createEmptyHeader.msgBodyLength);
                                    }
                                    SocketThread.readFully(bufferedInputStream, bytesData.data, 0, bytesData.length);
                                    if (ChatManager.debug && ChatManager.debugByteData) {
                                        Log.v(SocketThread.TAG, "read msgbady:" + BytesUtils.byte2HexStr(bytesData.data, 0, bytesData.length));
                                    }
                                    try {
                                        parseMsgBody = BasePackage.parseMsgBody(createEmptyHeader, bytesData.data, 0, bytesData.length);
                                        if (ChatManager.debug) {
                                            Log.v(SocketThread.TAG, "parse pack:" + parseMsgBody);
                                        }
                                        BytesUtils.saveToReuseByte(bytesData.data);
                                    } finally {
                                        try {
                                        } catch (Throwable th2) {
                                        }
                                    }
                                } catch (BasePackage.UnsupportedVersionException e) {
                                    e.printStackTrace();
                                    if (ChatManager.debug) {
                                        Log.e(SocketThread.TAG, "unsupported version", e);
                                    }
                                    throw e;
                                }
                            } else {
                                if (ChatManager.debug) {
                                    Log.v(SocketThread.TAG, "no payloads, copy header");
                                }
                                parseMsgBody = BasePackage.parseMsgBody(createEmptyHeader, null, 0, 0);
                            }
                            if (parseMsgBody != null) {
                                IMDebuger.setSocketStatus(IMDebuger.SocketStatus.RECEIVE_OK);
                                IMDebuger.setLastReceivePackage(parseMsgBody);
                                try {
                                    SocketThread.this.notifyPackageReceived(parseMsgBody);
                                } catch (Throwable th3) {
                                    th3.printStackTrace();
                                    if (ChatManager.debug) {
                                        Log.e(SocketThread.TAG, "package handle exception", th3);
                                    }
                                }
                            } else if (ChatManager.debug) {
                                Log.e(SocketThread.TAG, "no pack parsed");
                            }
                        } catch (IOException e2) {
                            e = e2;
                            BufferedInputStream bufferedInputStream2 = bufferedInputStream;
                            if (ChatManager.debug) {
                                BufferedInputStream bufferedInputStream3 = bufferedInputStream;
                                Log.e(SocketThread.TAG, "RecvThread ioexception", e);
                            }
                            BufferedInputStream bufferedInputStream4 = bufferedInputStream;
                            SocketThread.this.linkExceptionFlag.set(true);
                            BufferedInputStream bufferedInputStream5 = bufferedInputStream;
                            BufferedInputStream bufferedInputStream6 = bufferedInputStream;
                            synchronized (SocketThread.this) {
                                SocketThread.this.notify();
                            }
                            BufferedInputStream bufferedInputStream7 = bufferedInputStream;
                            e.printStackTrace();
                            SocketThread.safeClose(bufferedInputStream);
                            return;
                        } catch (Throwable th4) {
                            th = th4;
                            th.printStackTrace();
                            BufferedInputStream bufferedInputStream8 = bufferedInputStream;
                            if (ChatManager.debug) {
                                BufferedInputStream bufferedInputStream9 = bufferedInputStream;
                                Log.e(SocketThread.TAG, "sendThread throwable", th);
                            }
                            BufferedInputStream bufferedInputStream10 = bufferedInputStream;
                            SocketThread.this.linkExceptionFlag.set(true);
                            BufferedInputStream bufferedInputStream11 = bufferedInputStream;
                            BufferedInputStream bufferedInputStream12 = bufferedInputStream;
                            synchronized (SocketThread.this) {
                                SocketThread.this.notify();
                            }
                            SocketThread.safeClose(bufferedInputStream);
                            return;
                        }
                    }
                    SocketThread.safeClose(bufferedInputStream);
                } catch (IOException e3) {
                    e = e3;
                    bufferedInputStream = null;
                } catch (Throwable th5) {
                    bufferedInputStream = null;
                    th = th5;
                }
            } catch (Throwable th6) {
                SocketThread.safeClose((InputStream) null);
                throw th6;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/link/SocketThread$SendThread.class */
    public class SendThread extends Thread {
        private boolean stop;

        private SendThread() {
            this.stop = false;
        }

        /* synthetic */ SendThread(SocketThread socketThread, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void notifyStop() {
            this.stop = true;
            synchronized (this) {
                notify();
            }
        }

        /* JADX WARN: Not initialized variable reg: 7, insn: 0x020b: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:122:0x020b */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedOutputStream bufferedOutputStream;
            OutputStream outputStream;
            if (ChatManager.debug) {
                Log.v(SocketThread.TAG, "SendThread running...");
            }
            try {
                try {
                    outputStream = new BufferedOutputStream(SocketThread.this._socket.getOutputStream());
                } catch (IOException e) {
                    e = e;
                    bufferedOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = null;
                }
                try {
                    IMDebuger.setSocketStatus(IMDebuger.SocketStatus.SEND_OK);
                    while (!this.stop && !SocketThread.this.linkExceptionFlag.get()) {
                        BasePackage nextSendPackage = SocketThread.this.getNextSendPackage();
                        if (nextSendPackage == null) {
                            synchronized (this) {
                                try {
                                    if (ChatManager.debug) {
                                        Log.v(SocketThread.TAG, "no pack need to send, so wait...");
                                    }
                                    wait();
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        } else {
                            if (ChatManager.debug) {
                                Log.v(SocketThread.TAG, "get a pack from stack, send it, pack:" + nextSendPackage);
                            }
                            try {
                                BytesData bype = nextSendPackage.toBype();
                                if (ChatManager.debug && ChatManager.debugByteData) {
                                    Log.v(SocketThread.TAG, "package data:" + BytesUtils.byte2HexStr(bype.data, 0, bype.length));
                                }
                                outputStream.write(bype.data, 0, bype.length);
                                outputStream.flush();
                                if (ChatManager.debug) {
                                    Log.v(SocketThread.TAG, "-----------  send data:" + bype.length + "   -------------");
                                }
                                BytesUtils.saveToReuseByte(bype.data);
                                SocketThread.this.notifyPackageSendedSuccess(nextSendPackage);
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                                if (ChatManager.debug) {
                                    Log.e(SocketThread.TAG, "pack toBype exception", th2);
                                }
                                SocketThread.this.notifyPackageSendedFailed(nextSendPackage, "pack toBype exception, e:" + th2);
                            }
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    BufferedOutputStream bufferedOutputStream2 = bufferedOutputStream;
                    e.printStackTrace();
                    BufferedOutputStream bufferedOutputStream3 = bufferedOutputStream;
                    if (ChatManager.debug) {
                        BufferedOutputStream bufferedOutputStream4 = bufferedOutputStream;
                        Log.e(SocketThread.TAG, "sendThread ioexception", e);
                    }
                    BufferedOutputStream bufferedOutputStream5 = bufferedOutputStream;
                    SocketThread.this.linkExceptionFlag.set(true);
                    BufferedOutputStream bufferedOutputStream6 = bufferedOutputStream;
                    BufferedOutputStream bufferedOutputStream7 = bufferedOutputStream;
                    synchronized (SocketThread.this) {
                        SocketThread.this.notify();
                    }
                    outputStream = bufferedOutputStream;
                } catch (Throwable th3) {
                    th = th3;
                    th.printStackTrace();
                    BufferedOutputStream bufferedOutputStream8 = bufferedOutputStream;
                    if (ChatManager.debug) {
                        BufferedOutputStream bufferedOutputStream9 = bufferedOutputStream;
                        Log.e(SocketThread.TAG, "sendThread throwable", th);
                    }
                    BufferedOutputStream bufferedOutputStream10 = bufferedOutputStream;
                    SocketThread.this.linkExceptionFlag.set(true);
                    BufferedOutputStream bufferedOutputStream11 = bufferedOutputStream;
                    BufferedOutputStream bufferedOutputStream12 = bufferedOutputStream;
                    synchronized (SocketThread.this) {
                        SocketThread.this.notify();
                    }
                    outputStream = bufferedOutputStream;
                }
            } finally {
                SocketThread.safeClose(outputStream);
            }
        }
    }

    public SocketThread(String str, int i, int i2, DnsManager dnsManager, boolean z, boolean z2) {
        if (ChatManager.debug) {
            Log.v(TAG, "SocketThread(), addr:" + str + ", port:" + i + ", backupPort:" + i2 + ", isDnsManagerPrior:" + z + ", isSSL:" + z2);
        }
        this.addr = str;
        this.port = i;
        this.backupPort = i2;
        this.dnsManager = dnsManager;
        this.isDnsManagerPrior = z;
        this.isSSL = z2;
        if (z) {
            this.retryPrograms = new ConnectProgram[]{ConnectProgram.DnsManager, ConnectProgram.Normal};
        } else {
            this.retryPrograms = new ConnectProgram[]{ConnectProgram.Normal, ConnectProgram.DnsManager};
        }
    }

    private Socket createSocket(String str, int i) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        Socket createSocket = this.isSSL ? SSLSocketFactory.getDefault().createSocket() : new Socket();
        createSocket.connect(new InetSocketAddress(str, i), 30000);
        createSocket.setSoTimeout(0);
        createSocket.setTcpNoDelay(true);
        return createSocket;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BasePackage getNextSendPackage() {
        AbstractLinkerImpl linker = getLinker();
        if (linker != null) {
            return linker.packageQueue.getNext();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPackageReceived(BasePackage basePackage) {
        AbstractLinkerImpl linker = getLinker();
        if (linker != null) {
            linker.linkListener.onLinkReceive(basePackage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPackageSendedFailed(BasePackage basePackage, String str) {
        AbstractLinkerImpl linker = getLinker();
        if (linker != null) {
            linker.linkListener.onLinkSendFailed(basePackage, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPackageSendedSuccess(BasePackage basePackage) {
        AbstractLinkerImpl linker = getLinker();
        if (linker != null) {
            linker.linkListener.onLinkSendSuccess(basePackage);
        }
    }

    private String queryHttpDns(String str) {
        DnsManager dnsManager = this.dnsManager;
        if (dnsManager != null) {
            try {
                String[] query = dnsManager.query(str);
                if (query != null) {
                    if (query.length > 0) {
                        return query[0];
                    }
                    return null;
                }
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readFully(BufferedInputStream bufferedInputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return;
            }
            int read = bufferedInputStream.read(bArr, i + i4, i2 - i4);
            if (ChatManager.debug) {
                Log.v(TAG, "+++++++++++  read data:" + read + "   +++++++++++++");
            }
            if (read == -1) {
                throw new EOFException("read to eof");
            }
            i3 = i4 + read;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void safeClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void safeClose(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void safeClose(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setlinkerState(int i) {
        AbstractLinkerImpl linker = getLinker();
        if (linker != null) {
            linker.changeState(i);
        }
    }

    private void stopSubThread() {
        SendThread sendThread = this.sendThread;
        if (sendThread != null && sendThread.isAlive()) {
            this.sendThread.notifyStop();
            try {
                this.sendThread.join(m.ag);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.sendThread = null;
        }
        RecvThread recvThread = this.recvThread;
        if (recvThread == null || !recvThread.isAlive()) {
            return;
        }
        this.recvThread.notifyStop();
        try {
            this.recvThread.join(m.ag);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.recvThread = null;
    }

    public AbstractLinkerImpl getLinker() {
        AbstractLinkerImpl abstractLinkerImpl;
        synchronized (this) {
            abstractLinkerImpl = this._linker;
        }
        return abstractLinkerImpl;
    }

    public void notifyPackage() {
        if (ChatManager.debug) {
            Log.v(TAG, "notifyPackage(), sendThread:" + this.sendThread);
        }
        SendThread sendThread = this.sendThread;
        if (sendThread != null) {
            synchronized (sendThread) {
                sendThread.notify();
            }
        }
    }

    public void notifyStop() {
        if (ChatManager.debug) {
            Log.v(TAG, "notifyStop()");
        }
        this.stopFlag.set(true);
        synchronized (this) {
            notify();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:215:0x0678, code lost:
        setlinkerState(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x067d, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:127:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x04b9 A[Catch: InterruptedException -> 0x04cc, TryCatch #5 {InterruptedException -> 0x04cc, blocks: (B:128:0x04af, B:130:0x04b9), top: B:219:0x04af }] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 1662
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.chat.core.worker.link.SocketThread.run():void");
    }

    public void setLinker(AbstractLinkerImpl abstractLinkerImpl) {
        synchronized (this) {
            if (ChatManager.debug) {
                Log.v(TAG, "setLinker(), linker:" + abstractLinkerImpl);
            }
            this._linker = abstractLinkerImpl;
        }
    }
}
