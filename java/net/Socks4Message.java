package java.net;

import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import libcore.io.Memory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/net/Socks4Message.class */
public class Socks4Message {
    private static final int BUFFER_LENGTH = 256;
    static final int COMMAND_BIND = 2;
    static final int COMMAND_CONNECT = 1;
    private static final int INDEX_COMMAND = 1;
    private static final int INDEX_IP = 4;
    private static final int INDEX_PORT = 2;
    private static final int INDEX_USER_ID = 8;
    static final int INDEX_VERSION = 0;
    private static final int MAX_USER_ID_LENGTH = 248;
    static final int REPLY_LENGTH = 8;
    static final int RETURN_CANNOT_CONNECT_TO_IDENTD = 92;
    static final int RETURN_DIFFERENT_USER_IDS = 93;
    static final int RETURN_FAILURE = 91;
    static final int RETURN_SUCCESS = 90;
    private static final int SOCKS_VERSION = 4;
    protected byte[] buffer = new byte[256];

    public Socks4Message() {
        setVersionNumber(4);
    }

    private String getString(int i, int i2) {
        int i3;
        int i4 = i;
        while (true) {
            i3 = i4;
            if (i3 >= i + i2 || this.buffer[i3] == 0) {
                break;
            }
            i4 = i3 + 1;
        }
        return new String(this.buffer, i, i3 - i, StandardCharsets.ISO_8859_1);
    }

    private int getVersionNumber() {
        return this.buffer[0];
    }

    private void setString(int i, int i2, String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        int min = Math.min(bytes.length, i2);
        System.arraycopy(bytes, 0, this.buffer, i, min);
        this.buffer[i + min] = 0;
    }

    private void setVersionNumber(int i) {
        this.buffer[0] = (byte) i;
    }

    public byte[] getBytes() {
        return this.buffer;
    }

    public int getCommandOrResult() {
        return this.buffer[1];
    }

    public String getErrorString(int i) {
        switch (i) {
            case 91:
                return "Failure to connect to SOCKS server";
            case 92:
                return "Unable to connect to identd to verify user";
            case 93:
                return "Failure - user ids do not match";
            default:
                return "Success";
        }
    }

    public int getIP() {
        return Memory.peekInt(this.buffer, 4, ByteOrder.BIG_ENDIAN);
    }

    public int getLength() {
        int i = 8;
        while (true) {
            int i2 = i;
            if (this.buffer[i2] == 0) {
                return i2 + 1;
            }
            i = i2 + 1;
        }
    }

    public int getPort() {
        return Memory.peekShort(this.buffer, 2, ByteOrder.BIG_ENDIAN);
    }

    public String getUserId() {
        return getString(8, 248);
    }

    public void setCommandOrResult(int i) {
        this.buffer[1] = (byte) i;
    }

    public void setIP(byte[] bArr) {
        this.buffer[4] = bArr[0];
        this.buffer[5] = bArr[1];
        this.buffer[6] = bArr[2];
        this.buffer[7] = bArr[3];
    }

    public void setPort(int i) {
        Memory.pokeShort(this.buffer, 2, (short) i, ByteOrder.BIG_ENDIAN);
    }

    public void setUserId(String str) {
        setString(8, 248, str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(50);
        sb.append("Version: ");
        sb.append(Integer.toHexString(getVersionNumber()));
        sb.append(" Command: ");
        sb.append(Integer.toHexString(getCommandOrResult()));
        sb.append(" Port: ");
        sb.append(getPort());
        sb.append(" IP: ");
        sb.append(Integer.toHexString(getIP()));
        sb.append(" User ID: ");
        sb.append(getUserId());
        return sb.toString();
    }
}
