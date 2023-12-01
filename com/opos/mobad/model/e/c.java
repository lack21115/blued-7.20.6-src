package com.opos.mobad.model.e;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/e/c.class */
public class c {
    public static final String a(InputStream inputStream) throws IOException {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    String str = new String(byteArrayOutputStream.toByteArray(), Charset.forName("UTF-8"));
                    bufferedInputStream.close();
                    return str;
                } else if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
