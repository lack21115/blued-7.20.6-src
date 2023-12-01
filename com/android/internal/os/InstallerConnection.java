package com.android.internal.os;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.util.Slog;
import com.android.internal.telephony.PhoneConstants;
import com.blued.android.module.yy_china.model.YYGiftPackageModel;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import libcore.io.IoUtils;
import libcore.io.Streams;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/InstallerConnection.class */
public class InstallerConnection {
    private static final boolean LOCAL_DEBUG = false;
    private static final String TAG = "InstallerConnection";
    private final byte[] buf = new byte[1024];
    private InputStream mIn;
    private OutputStream mOut;
    private LocalSocket mSocket;

    private boolean connect() {
        if (this.mSocket != null) {
            return true;
        }
        Slog.i(TAG, "connecting...");
        try {
            this.mSocket = new LocalSocket();
            this.mSocket.connect(new LocalSocketAddress("installd", LocalSocketAddress.Namespace.RESERVED));
            this.mIn = this.mSocket.getInputStream();
            this.mOut = this.mSocket.getOutputStream();
            return true;
        } catch (IOException e) {
            disconnect();
            return false;
        }
    }

    private boolean readFully(byte[] bArr, int i) {
        try {
            Streams.readFully(this.mIn, bArr, 0, i);
            return true;
        } catch (IOException e) {
            Slog.e(TAG, "read exception");
            disconnect();
            return false;
        }
    }

    private int readReply() {
        int i;
        if (readFully(this.buf, 2)) {
            int i2 = (this.buf[0] & 255) | ((this.buf[1] & 255) << 8);
            if (i2 < 1 || i2 > this.buf.length) {
                Slog.e(TAG, "invalid reply length (" + i2 + ")");
                disconnect();
                return -1;
            }
            i = i2;
            if (!readFully(this.buf, i2)) {
                return -1;
            }
        } else {
            i = -1;
        }
        return i;
    }

    private boolean writeCommand(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        if (length < 1 || length > this.buf.length) {
            return false;
        }
        this.buf[0] = (byte) (length & 255);
        this.buf[1] = (byte) ((length >> 8) & 255);
        try {
            this.mOut.write(this.buf, 0, 2);
            this.mOut.write(bytes, 0, length);
            return true;
        } catch (IOException e) {
            Slog.e(TAG, "write error");
            disconnect();
            return false;
        }
    }

    public int dexopt(String str, int i, boolean z, String str2) {
        return dexopt(str, i, z, PhoneConstants.APN_TYPE_ALL, str2, false);
    }

    public int dexopt(String str, int i, boolean z, String str2, String str3, boolean z2) {
        StringBuilder sb = new StringBuilder("dexopt");
        sb.append(' ');
        sb.append(str);
        sb.append(' ');
        sb.append(i);
        sb.append(z ? " 1" : " 0");
        sb.append(' ');
        sb.append(str2);
        sb.append(' ');
        sb.append(str3);
        sb.append(' ');
        sb.append(z2 ? " 1" : " 0");
        return execute(sb.toString());
    }

    public void disconnect() {
        Slog.i(TAG, "disconnecting...");
        IoUtils.closeQuietly(this.mSocket);
        IoUtils.closeQuietly(this.mIn);
        IoUtils.closeQuietly(this.mOut);
        this.mSocket = null;
        this.mIn = null;
        this.mOut = null;
    }

    public int execute(String str) {
        try {
            return Integer.parseInt(transact(str));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public int patchoat(String str, int i, boolean z, String str2) {
        return patchoat(str, i, z, PhoneConstants.APN_TYPE_ALL, str2);
    }

    public int patchoat(String str, int i, boolean z, String str2, String str3) {
        StringBuilder sb = new StringBuilder("patchoat");
        sb.append(' ');
        sb.append(str);
        sb.append(' ');
        sb.append(i);
        sb.append(z ? " 1" : " 0");
        sb.append(' ');
        sb.append(str2);
        sb.append(' ');
        sb.append(str3);
        return execute(sb.toString());
    }

    public String transact(String str) {
        String str2;
        synchronized (this) {
            if (connect()) {
                if (!writeCommand(str)) {
                    Slog.e(TAG, "write command failed? reconnect!");
                    if (connect()) {
                        if (!writeCommand(str)) {
                        }
                    }
                    str2 = YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID;
                }
                int readReply = readReply();
                str2 = readReply > 0 ? new String(this.buf, 0, readReply) : YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID;
            } else {
                Slog.e(TAG, "connection failed");
                str2 = YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID;
            }
        }
        return str2;
    }
}
