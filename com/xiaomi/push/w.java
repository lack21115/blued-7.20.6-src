package com.xiaomi.push;

import java.io.File;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/w.class */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, String> f41713a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f41713a = hashMap;
        hashMap.put("FFD8FF", "jpg");
        f41713a.put("89504E47", "png");
        f41713a.put(com.huawei.openalliance.ad.constant.t.an, "gif");
        f41713a.put("474946", "gif");
        f41713a.put("424D", "bmp");
    }

    public static long a(File file) {
        long j;
        long length;
        long j2 = 0;
        long j3 = 0;
        try {
            File[] listFiles = file.listFiles();
            int i = 0;
            while (true) {
                int i2 = i;
                j3 = j2;
                j = j2;
                if (i2 >= listFiles.length) {
                    break;
                }
                long j4 = j2;
                if (listFiles[i2].isDirectory()) {
                    long j5 = j2;
                    length = a(listFiles[i2]);
                } else {
                    length = listFiles[i2].length();
                }
                j2 += length;
                i = i2 + 1;
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            j = j3;
        }
        return j;
    }
}
