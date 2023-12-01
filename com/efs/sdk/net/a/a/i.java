package com.efs.sdk.net.a.a;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/a/a/i.class */
public final class i {
    public static void a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }
}
