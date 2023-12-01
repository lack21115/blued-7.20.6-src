package com.heytap.baselib.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/baselib/utils/idIOUtil.class */
class idIOUtil {
    private static String EXTRAS_KEY_GEN = "G0";

    idIOUtil() {
    }

    public static String base64Decode(String str) {
        try {
            return new String(Base64.decode(str, 0), "UTF-8");
        } catch (Exception e) {
            ClientIdEnvironment.log("idIOUtil:" + e.getMessage());
            return "";
        }
    }

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String decodeBase64(String str) {
        return new String(Base64.decode(str, 0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String decryptTo(File file) {
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        byte[] bytes = readText(file).getBytes();
        int length = bytes.length / 2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return new String(Base64.decode(bytes, 0));
            }
            bytes[i2] = (byte) (bytes[i2] ^ i2);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean encryptTo(byte[] bArr, File file) {
        FileOutputStream fileOutputStream;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            byte[] encode = Base64.encode(bArr, 0);
            int length = encode.length / 2;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(encode);
                        fileOutputStream.flush();
                        close(fileOutputStream);
                        return true;
                    } catch (Exception e) {
                        close(fileOutputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        close(fileOutputStream);
                        throw th;
                    }
                }
                encode[i2] = (byte) (encode[i2] ^ i2);
                i = i2 + 1;
            }
        } catch (Exception e2) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    private static String getFolderName(String str) {
        String str2 = str;
        if (str != null) {
            if (str.isEmpty()) {
                return str;
            }
            int lastIndexOf = str.lastIndexOf(File.separator);
            if (lastIndexOf == -1) {
                return "";
            }
            str2 = str.substring(0, lastIndexOf);
        }
        return str2;
    }

    private static Object getObjectValue(JSONObject jSONObject, String str, Object obj) {
        Object obj2 = obj;
        if (jSONObject != null) {
            obj2 = obj;
            if (!jSONObject.isNull(str)) {
                try {
                    obj2 = jSONObject.get(str);
                } catch (JSONException e) {
                    return obj;
                }
            }
        }
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getString(String str, JSONObject jSONObject, String str2, String str3) {
        Object objectValue = getObjectValue(parseObject(str, jSONObject), str2, str3);
        if (objectValue != null) {
            str3 = objectValue.toString();
        }
        return str3;
    }

    private static boolean isHexDigit(byte b) {
        if (b < 48 || b > 57) {
            if (b < 97 || b > 122) {
                return b >= 65 && b <= 90;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isNullOrEmpty(String str) {
        if (str == null) {
            return true;
        }
        return "".equals(str.trim());
    }

    public static boolean makeDirs(String str) {
        String folderName = getFolderName(str);
        if (folderName == null || folderName.isEmpty()) {
            return false;
        }
        File file = new File(folderName);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    private static Object parse(String str, Object obj) {
        Object obj2 = obj;
        if (!isNullOrEmpty(str)) {
            try {
                obj2 = new JSONTokener(str).nextValue();
            } catch (JSONException e) {
                return obj;
            }
        }
        return obj2;
    }

    private static JSONObject parseObject(String str, JSONObject jSONObject) {
        Object parse = parse(str, jSONObject);
        if (parse instanceof JSONObject) {
            jSONObject = (JSONObject) parse;
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String readFileContent(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return readText(file);
        }
        return null;
    }

    private static String readText(File file) {
        BufferedReader bufferedReader;
        String str = null;
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (Exception e) {
                } catch (Throwable th) {
                    th = th;
                    close(bufferedReader);
                    throw th;
                }
            }
            str = sb.toString();
        } catch (Exception e2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        close(bufferedReader);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String replaceNonHexChar(String str) {
        if (isNullOrEmpty(str)) {
            return str;
        }
        byte[] bytes = str.getBytes();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bytes.length) {
                break;
            }
            if (!isHexDigit(bytes[i2])) {
                bytes[i2] = (byte) 48;
            }
            i = i2 + 1;
        }
        String md5_16 = MD5.md5_16(Build.MODEL + new String(bytes));
        String str2 = md5_16;
        if (TextUtils.isEmpty(md5_16)) {
            str2 = "";
        }
        return EXTRAS_KEY_GEN + str2 + "," + CRC16.calcCrc16(str2.getBytes());
    }
}
