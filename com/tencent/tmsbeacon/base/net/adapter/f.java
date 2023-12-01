package com.tencent.tmsbeacon.base.net.adapter;

import android.text.TextUtils;
import com.igexin.assist.sdk.AssistPushConsts;
import com.tencent.tmsbeacon.base.net.BResponse;
import com.tencent.tmsbeacon.base.net.NetException;
import com.tencent.tmsbeacon.base.net.RequestType;
import com.tencent.tmsbeacon.base.net.a.c;
import com.tencent.tmsbeacon.base.net.a.d;
import com.tencent.tmsbeacon.base.net.a.e;
import com.tencent.tmsbeacon.base.net.call.Callback;
import com.tencent.tmsbeacon.base.net.call.JceRequestEntity;
import com.tencent.tmsbeacon.pack.SocketRequestPackage;
import com.tencent.tmsbeacon.pack.SocketResponsePackage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/adapter/f.class */
public class f extends AbstractNetAdapter {

    /* renamed from: a  reason: collision with root package name */
    private c<byte[], SocketResponsePackage> f39500a = new e();
    private c<JceRequestEntity, SocketRequestPackage> b = new d();

    private f() {
    }

    public static AbstractNetAdapter a() {
        return new f();
    }

    private Socket a(String str, int i) throws IOException {
        com.tencent.tmsbeacon.base.util.c.a("SocketAdapter", "create socket domain: %s, port: %d", str, Integer.valueOf(i));
        Socket socket = new Socket(InetAddress.getByName(str).getHostAddress(), i);
        socket.setSoTimeout(30000);
        return socket;
    }

    private void a(Callback<byte[]> callback, String str, SocketResponsePackage socketResponsePackage) throws NetException {
        String str2 = socketResponsePackage.msg;
        if (str2 == null || !str2.equals("decrypt Data fail!")) {
            callback.onResponse(socketResponsePackage.body);
        } else {
            callback.onFailure(new com.tencent.tmsbeacon.base.net.d(str, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE, socketResponsePackage.statusCode, "server encrypt-status error!"));
        }
    }

    private void a(Socket socket, SocketRequestPackage socketRequestPackage) throws IOException {
        com.tencent.tmsbeacon.pack.b bVar = new com.tencent.tmsbeacon.pack.b();
        socketRequestPackage.writeTo(bVar);
        OutputStream outputStream = socket.getOutputStream();
        byte[] b = bVar.b();
        outputStream.write(a(b, b.length));
        outputStream.flush();
    }

    private byte[] a(Socket socket, boolean z) throws Throwable {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            inputStream = socket.getInputStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, read);
                    }
                    byteArrayOutputStream2.flush();
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    byte[] bArr2 = byteArray;
                    if (!z) {
                        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length - 4);
                        allocate.put(byteArray, 2, byteArray.length - 4);
                        bArr2 = allocate.array();
                    }
                    byteArrayOutputStream2.close();
                    inputStream.close();
                    com.tencent.tmsbeacon.base.util.b.a(inputStream, byteArrayOutputStream2);
                    return bArr2;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        com.tencent.tmsbeacon.base.util.c.a(th);
                        com.tencent.tmsbeacon.base.util.b.a(inputStream, byteArrayOutputStream);
                        throw th;
                    } catch (Throwable th2) {
                        com.tencent.tmsbeacon.base.util.b.a(inputStream, byteArrayOutputStream);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    private byte[] a(byte[] bArr, int i) {
        int i2 = i + 4;
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.putShort((short) (i2 & 65535));
        allocate.put(bArr);
        allocate.put((byte) 13);
        allocate.put((byte) 10);
        if (i >= 65532) {
            com.tencent.tmsbeacon.base.util.c.b("[Error] send bytes exceed 64kB will failure!", new Object[0]);
        }
        return allocate.array();
    }

    @Override // com.tencent.tmsbeacon.base.net.adapter.AbstractNetAdapter
    public void request(JceRequestEntity jceRequestEntity, Callback<byte[]> callback) {
        String domain = jceRequestEntity.getDomain();
        if (TextUtils.isEmpty(domain)) {
            return;
        }
        String name = jceRequestEntity.getType().name();
        try {
            Socket a2 = a(domain, jceRequestEntity.getPort());
            StringBuilder sb = new StringBuilder();
            sb.append("send data size: ");
            sb.append(jceRequestEntity.getContent().length);
            com.tencent.tmsbeacon.base.util.c.a("SocketAdapter", 0, sb.toString(), new Object[0]);
            a(a2, this.b.a(jceRequestEntity));
            byte[] a3 = a(a2, jceRequestEntity.getType() == RequestType.EVENT);
            if (a3 != null && a3.length > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("receivedData: ");
                sb2.append(a3.length);
                com.tencent.tmsbeacon.base.util.c.a("SocketAdapter", 1, sb2.toString(), new Object[0]);
                SocketResponsePackage a4 = this.f39500a.a(a3);
                if (a4 == null) {
                    callback.onFailure(new com.tencent.tmsbeacon.base.net.d(name, "402", -1, "responsePackage == null"));
                    return;
                }
                com.tencent.tmsbeacon.base.util.c.a("SocketAdapter", 2, "socket response code: %s, header: %s, msg: %s", Integer.valueOf(a4.statusCode), a4.header, a4.msg);
                int i = a4.statusCode;
                if (i == 200) {
                    a(callback, name, a4);
                    return;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("responsePackage msg: ");
                sb3.append(a4.msg);
                callback.onFailure(new com.tencent.tmsbeacon.base.net.d(name, "402", i, sb3.toString()));
                return;
            }
            callback.onFailure(new com.tencent.tmsbeacon.base.net.d(name, "402", -1, "receiveData == null"));
        } catch (ConnectException e) {
            callback.onFailure(new com.tencent.tmsbeacon.base.net.d(name, "401", -1, " connect time more than 30s", e));
        } catch (SocketTimeoutException e2) {
            callback.onFailure(new com.tencent.tmsbeacon.base.net.d(name, "401", -1, " request time more than 30s", e2));
        } catch (Throwable th) {
            com.tencent.tmsbeacon.base.util.c.b("SocketAdapter socket request error: %s", th.getMessage());
            com.tencent.tmsbeacon.base.util.c.a(th);
            callback.onFailure(new com.tencent.tmsbeacon.base.net.d(name, "449", -1, " unknown request error!", th));
        }
    }

    @Override // com.tencent.tmsbeacon.base.net.adapter.AbstractNetAdapter
    public void request(com.tencent.tmsbeacon.base.net.call.e eVar, Callback<BResponse> callback) {
    }
}
