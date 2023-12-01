package com.huawei.agconnect.config.impl;

import android.util.Log;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.huawei.agconnect.AGCRoutePolicy;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/config/impl/Utils.class */
public final class Utils {
    private static final int BUFF_SIZE = 4096;
    public static final String DEFAULT_NAME = "DEFAULT_INSTANCE";
    private static final String TAG = "Utils";

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.e(TAG, "Exception when closing the 'Closeable'.");
            }
        }
    }

    public static void copy(Reader reader, Writer writer) throws IOException {
        copy(reader, writer, new char[4096]);
    }

    public static void copy(Reader reader, Writer writer, char[] cArr) throws IOException {
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return;
            }
            writer.write(cArr, 0, read);
        }
    }

    public static Map<String, String> fixKeyPathMap(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            hashMap.put(fixPath(entry.getKey()), entry.getValue());
        }
        return hashMap;
    }

    public static String fixPath(String str) {
        int i = 0;
        int i2 = 0;
        if (str.length() > 0) {
            while (true) {
                i = i2;
                if (str.charAt(i2) != '/') {
                    break;
                }
                i2++;
            }
        }
        return BridgeUtil.SPLIT_MARK + str.substring(i);
    }

    public static AGCRoutePolicy getRoutePolicyFromJson(String str, String str2) {
        if (str != null) {
            boolean z = true;
            int hashCode = str.hashCode();
            if (hashCode != 2155) {
                if (hashCode != 2177) {
                    if (hashCode != 2627) {
                        if (hashCode == 2644 && str.equals("SG")) {
                            z = true;
                        }
                    } else if (str.equals("RU")) {
                        z = true;
                    }
                } else if (str.equals("DE")) {
                    z = true;
                }
            } else if (str.equals("CN")) {
                z = false;
            }
            if (!z) {
                return AGCRoutePolicy.CHINA;
            }
            if (z) {
                return AGCRoutePolicy.GERMANY;
            }
            if (z) {
                return AGCRoutePolicy.RUSSIA;
            }
            if (z) {
                return AGCRoutePolicy.SINGAPORE;
            }
        }
        if (str2 != null) {
            if (str2.contains("connect-drcn")) {
                return AGCRoutePolicy.CHINA;
            }
            if (str2.contains("connect-dre")) {
                return AGCRoutePolicy.GERMANY;
            }
            if (str2.contains("connect-drru")) {
                return AGCRoutePolicy.RUSSIA;
            }
            if (str2.contains("connect-dra")) {
                return AGCRoutePolicy.SINGAPORE;
            }
        }
        return AGCRoutePolicy.UNKNOWN;
    }

    public static String toString(InputStream inputStream, String str) throws UnsupportedEncodingException, IOException {
        StringWriter stringWriter = new StringWriter();
        copy(new InputStreamReader(inputStream, str), stringWriter);
        return stringWriter.toString();
    }
}
