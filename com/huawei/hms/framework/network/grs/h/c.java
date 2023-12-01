package com.huawei.hms.framework.network.grs.h;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/h/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9114a = "c";

    public static String a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        try {
            try {
            } catch (IOException e) {
                InputStream inputStream3 = inputStream2;
                Logger.w(f9114a, "local config file is not exist.filename is {%s}", str);
            }
            if (new File(str).isDirectory()) {
                inputStream2 = null;
                IoUtils.closeSecure((OutputStream) byteArrayOutputStream);
                IoUtils.closeSecure(inputStream2);
                return "";
            }
            InputStream open = context.getAssets().open(str);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = open.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    inputStream = open;
                    inputStream2 = open;
                    String str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    IoUtils.closeSecure((OutputStream) byteArrayOutputStream);
                    IoUtils.closeSecure(open);
                    return str2;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            IoUtils.closeSecure((OutputStream) byteArrayOutputStream);
            IoUtils.closeSecure(inputStream);
            throw th;
        }
    }
}
