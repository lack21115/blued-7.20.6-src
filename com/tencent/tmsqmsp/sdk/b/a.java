package com.tencent.tmsqmsp.sdk.b;

import com.tencent.mapsdk.internal.oj;
import com.tencent.tmsqmsp.sdk.f.h;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f25989a = {49, 99, -3, 81, 63, 117, 116, -14, 40};
    private static final byte[] b = {4, 85, Byte.MIN_VALUE};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f25990c = {4, 85, Byte.MIN_VALUE, 15, 13, 25, 84, -78, 21, 91, -112, 115, 123, 11, 118, -7, 33, 121, -67, 71};
    private static final byte[] d = {-58, -26, -51, -19};
    private static final byte[] e = {-58, -26, -51, -19, 30, -3, -21, -29, 87, 39, 40, 12, -119, -40, -84, 65};
    private static final b f = b.AES;
    private static ThreadLocal<Integer> g = new ThreadLocal<>();

    /* renamed from: com.tencent.tmsqmsp.sdk.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/b/a$a.class */
    public static /* synthetic */ class C0872a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25991a;

        static {
            b.values();
            int[] iArr = new int[3];
            f25991a = iArr;
            try {
                b bVar = b.AES;
                iArr[1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f25991a;
                b bVar2 = b.NONE;
                iArr2[2] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/b/a$b.class */
    public enum b {
        UNKNOWN(0, ""),
        AES(1, ""),
        NONE(2, "");
        

        /* renamed from: a  reason: collision with root package name */
        private short f25993a;
        private String b;

        b(short s, String str) {
            this.f25993a = s;
            this.b = str;
        }

        public static b a(int i) {
            return i != 1 ? i != 2 ? UNKNOWN : NONE : AES;
        }

        public int a() {
            return this.f25993a;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.b;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/b/a$c.class */
    public enum c {
        SUCCESS(0, ""),
        OVERLOAD(1, ""),
        FATAL(2, ""),
        CMD_UNKNOWN(3, ""),
        HOST_UNKNOWN(10, ""),
        CONN_ERR(11, ""),
        SEND_ERR(12, ""),
        RECV_ERR(13, ""),
        WRONG_FORMAT(14, ""),
        SYS_ERR(15, ""),
        DECIPHER_ERR(16, ""),
        DECODE_JSON(20, "");
        
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private String f25994c;

        c(int i, String str) {
            this.b = i;
            this.f25994c = str;
        }

        public int a() {
            return this.b;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f25994c;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/b/a$d.class */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f25995a;
        public int b;

        public d(JSONObject jSONObject, int i) {
            this.f25995a = jSONObject;
            this.b = i;
        }
    }

    public static d a(int i, String str, int i2, JSONObject jSONObject) {
        DataInputStream dataInputStream;
        AtomicInteger atomConnTimeOut;
        DataOutputStream dataOutputStream;
        AtomicInteger atomReadTimeOut;
        g.set(Integer.valueOf(c.SUCCESS.a()));
        InetSocketAddress inetSocketAddress = new InetSocketAddress(h.a(f25989a), 33445);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            DataOutputStream dataOutputStream2 = null;
            if (i4 >= 1) {
                return new d(null, g.get().intValue());
            }
            Socket socket = new Socket();
            try {
                try {
                    try {
                        atomConnTimeOut = oj.getAtomConnTimeOut();
                        socket.connect(inetSocketAddress, atomConnTimeOut.get());
                        try {
                            dataOutputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                        } catch (IOException e2) {
                            dataOutputStream = null;
                        }
                        try {
                            a(i, str, i2, jSONObject, dataOutputStream);
                            atomReadTimeOut = oj.getAtomReadTimeOut();
                            socket.setSoTimeout(atomReadTimeOut.get());
                            DataInputStream dataInputStream2 = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                            try {
                                d dVar = new d(a(dataInputStream2), g.get().intValue());
                                a((Closeable) dataInputStream2);
                                a(dataOutputStream);
                                try {
                                    socket.close();
                                    return dVar;
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return dVar;
                                }
                            } catch (Throwable th) {
                                dataOutputStream2 = dataOutputStream;
                                dataInputStream = dataInputStream2;
                                try {
                                    g.set(Integer.valueOf(c.SYS_ERR.a()));
                                    a((Closeable) dataInputStream);
                                    a(dataOutputStream2);
                                    try {
                                        socket.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                    i3 = i4 + 1;
                                } catch (Throwable th2) {
                                    a((Closeable) dataInputStream);
                                    a(dataOutputStream2);
                                    try {
                                        socket.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                    throw th2;
                                }
                            }
                        } catch (IOException e6) {
                            d dVar2 = new d(null, c.SEND_ERR.a());
                            a((Closeable) null);
                            a(dataOutputStream);
                            try {
                                socket.close();
                                return dVar2;
                            } catch (IOException e7) {
                                e7.printStackTrace();
                                return dVar2;
                            }
                        }
                    } catch (IOException e8) {
                        d dVar3 = new d(null, c.CONN_ERR.a());
                        a((Closeable) null);
                        a((Closeable) null);
                        try {
                            socket.close();
                            return dVar3;
                        } catch (IOException e9) {
                            e9.printStackTrace();
                            return dVar3;
                        }
                    }
                } catch (Throwable th3) {
                    dataInputStream = null;
                }
            } catch (Throwable th4) {
                dataInputStream = null;
            }
            i3 = i4 + 1;
        }
    }

    private static JSONObject a(b bVar, byte[] bArr) {
        int i = C0872a.f25991a[bVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return new JSONObject(new String(bArr, Charset.forName("UTF-8")));
        }
        byte[] bArr2 = e;
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, h.a(b));
        Cipher cipher = Cipher.getInstance(h.a(f25990c));
        cipher.init(2, secretKeySpec, new IvParameterSpec(bArr2));
        return new JSONObject(new String(cipher.doFinal(bArr), Charset.forName("UTF-8")));
    }

    private static JSONObject a(DataInputStream dataInputStream) {
        ThreadLocal<Integer> threadLocal;
        c cVar;
        byte[] bArr = new byte[28];
        try {
            dataInputStream.readFully(bArr);
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 18, 10);
            g.set(Integer.valueOf(wrap.getShort()));
            b a2 = b.a(wrap.getShort());
            int i = wrap.getShort();
            int i2 = wrap.getInt();
            dataInputStream.readFully(new byte[i]);
            byte[] bArr2 = new byte[i2];
            dataInputStream.readFully(bArr2);
            if (i2 == 0) {
                return null;
            }
            try {
                return a(a2, bArr2);
            } catch (Exception e2) {
                threadLocal = g;
                cVar = c.DECIPHER_ERR;
                threadLocal.set(Integer.valueOf(cVar.a()));
                return null;
            }
        } catch (IOException e3) {
            threadLocal = g;
            cVar = c.RECV_ERR;
        }
    }

    private static void a(int i, String str, int i2, JSONObject jSONObject, DataOutputStream dataOutputStream) {
        byte[] bytes;
        dataOutputStream.write(d);
        dataOutputStream.writeInt(i);
        dataOutputStream.writeInt(i2);
        dataOutputStream.writeInt(0);
        dataOutputStream.writeShort(0);
        dataOutputStream.writeShort(0);
        b bVar = f;
        try {
            bytes = a(bVar, jSONObject);
        } catch (Exception e2) {
            bytes = jSONObject.toString().getBytes("UTF-8");
            bVar = b.NONE;
        }
        dataOutputStream.writeShort(bVar.a());
        byte[] bytes2 = str.getBytes("UTF-8");
        dataOutputStream.writeShort(bytes2.length + 3);
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(1);
        dataOutputStream.writeShort(bytes2.length);
        dataOutputStream.write(bytes2);
        dataOutputStream.write(bytes);
        dataOutputStream.flush();
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
            }
        }
    }

    private static byte[] a(b bVar, JSONObject jSONObject) {
        byte[] bytes = jSONObject.toString().getBytes("UTF-8");
        int i = C0872a.f25991a[bVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return bytes;
            }
            throw new IOException("unsupported");
        }
        byte[] bArr = e;
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, h.a(b));
        Cipher cipher = Cipher.getInstance(h.a(f25990c));
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr));
        return cipher.doFinal(bytes);
    }
}
