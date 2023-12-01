package com.tencent.thumbplayer.core.downloadproxy.utils;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyUtils.class */
public class TPDLProxyUtils {
    private static final String FILE_NAME = "TPDLProxyUtils";

    public static String byteArrayToString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "byteArrayToString failed, error:" + th.toString());
            return "";
        }
    }

    public static String losePackageCheck(int i) {
        String str;
        String str2;
        String str3;
        String str4 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ping -c " + i + " www.qq.com").getInputStream()));
            String str5 = "";
            while (true) {
                str = str5;
                str2 = str4;
                try {
                    String readLine = bufferedReader.readLine();
                    str2 = str4;
                    str3 = str;
                    if (readLine == null) {
                        break;
                    }
                    String str6 = str4;
                    if (readLine.contains(" packet loss")) {
                        String str7 = str4;
                        str6 = readLine.substring(10 + readLine.indexOf("received, "), readLine.indexOf("%") + 1);
                    }
                    str4 = str6;
                    str5 = str;
                    if (readLine.contains("avg")) {
                        String str8 = str6;
                        int indexOf = readLine.indexOf(BridgeUtil.SPLIT_MARK, 20);
                        String str9 = str6;
                        str5 = readLine.substring(indexOf + 1, readLine.indexOf(".", indexOf));
                        str4 = str6;
                    }
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    str3 = str;
                    return str2 + ";" + str3;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            str = "";
            str2 = str4;
        }
        return str2 + ";" + str3;
    }

    public static int objectToInt(Object obj, int i) {
        if (obj == null) {
            return i;
        }
        try {
            return ((Integer) obj).intValue();
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "object to int failed, error:" + th.toString());
            return i;
        }
    }

    public static long objectToLong(Object obj, long j) {
        if (obj == null) {
            return j;
        }
        try {
            return ((Long) obj).longValue();
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "object to long failed, error:" + th.toString());
            return j;
        }
    }

    public static String serialize(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeObject(obj);
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString("ISO-8859-1");
                    try {
                        objectOutputStream2.close();
                    } catch (Throwable th) {
                        TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "obj serialize to string  objectOutputStream close, error:" + th.toString());
                    }
                    try {
                        byteArrayOutputStream.close();
                        return byteArrayOutputStream2;
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "obj serialize to string byteArrayOutputStream close, error:" + th2.toString());
                        return byteArrayOutputStream2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    objectOutputStream = objectOutputStream2;
                    try {
                        TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "serialize obj, error:" + th.toString());
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Throwable th4) {
                                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "obj serialize to string  objectOutputStream close, error:" + th4.toString());
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                            return "";
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "obj serialize to string byteArrayOutputStream close, error:" + th5.toString());
                            return "";
                        }
                    } catch (Throwable th6) {
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Throwable th7) {
                                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "obj serialize to string  objectOutputStream close, error:" + th7.toString());
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th8) {
                            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "obj serialize to string byteArrayOutputStream close, error:" + th8.toString());
                        }
                        throw th6;
                    }
                }
            } catch (Throwable th9) {
                th = th9;
            }
        } catch (Throwable th10) {
            th = th10;
            byteArrayOutputStream = null;
        }
    }

    public static Object serializeToObject(String str) {
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (Throwable th) {
                th = th;
                objectInputStream = null;
            }
            try {
                Object readObject = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (Throwable th2) {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "serialize to obj objectInputStream close, error:" + th2.toString());
                }
                try {
                    byteArrayInputStream.close();
                    return readObject;
                } catch (Throwable th3) {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "serialize to obj byteArrayInputStream close, error:" + th3.toString());
                    return readObject;
                }
            } catch (Throwable th4) {
                th = th4;
                try {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "serialize to obj , error:" + th.toString());
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Throwable th5) {
                            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "serialize to obj objectInputStream close, error:" + th5.toString());
                        }
                    }
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                            return null;
                        } catch (Throwable th6) {
                            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "serialize to obj byteArrayInputStream close, error:" + th6.toString());
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th7) {
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Throwable th8) {
                            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "serialize to obj objectInputStream close, error:" + th8.toString());
                        }
                    }
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th9) {
                            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "serialize to obj byteArrayInputStream close, error:" + th9.toString());
                        }
                    }
                    throw th7;
                }
            }
        } catch (Throwable th10) {
            th = th10;
            objectInputStream = null;
            byteArrayInputStream = null;
        }
    }
}
