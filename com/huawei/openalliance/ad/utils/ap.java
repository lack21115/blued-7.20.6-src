package com.huawei.openalliance.ad.utils;

import com.huawei.hms.ads.ge;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/ap.class */
public class ap {
    private static final String Code = ap.class.getSimpleName();

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00c3: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r5 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:38:0x00c3 */
    public static Serializable Code(String str) {
        FileInputStream fileInputStream;
        Closeable closeable;
        ao aoVar;
        InputStream inputStream;
        String str2;
        String str3;
        Serializable serializable;
        InputStream inputStream2;
        ao aoVar2;
        try {
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    aoVar = new ao(fileInputStream);
                } catch (FileNotFoundException e) {
                    aoVar = null;
                } catch (IOException e2) {
                    aoVar = null;
                } catch (ClassNotFoundException e3) {
                    aoVar = null;
                } catch (Throwable th) {
                    th = th;
                    closeable = null;
                    at.Code((Closeable) fileInputStream);
                    at.Code(closeable);
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                aoVar = null;
                fileInputStream = null;
            } catch (IOException e5) {
                aoVar = null;
                fileInputStream = null;
            } catch (ClassNotFoundException e6) {
                aoVar = null;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                closeable = null;
            }
            try {
                Object readObject = aoVar.readObject();
                serializable = null;
                inputStream2 = fileInputStream;
                aoVar2 = aoVar;
                if (readObject instanceof Serializable) {
                    serializable = (Serializable) readObject;
                    aoVar2 = aoVar;
                    inputStream2 = fileInputStream;
                }
            } catch (FileNotFoundException e7) {
                ge.Z(Code, "read file FileNotFoundException");
                serializable = null;
                inputStream2 = fileInputStream;
                aoVar2 = aoVar;
                at.Code((Closeable) inputStream2);
                at.Code((Closeable) aoVar2);
                return serializable;
            } catch (IOException e8) {
                str2 = Code;
                str3 = "read file IOException";
                ge.I(str2, str3);
                serializable = null;
                inputStream2 = fileInputStream;
                aoVar2 = aoVar;
                at.Code((Closeable) inputStream2);
                at.Code((Closeable) aoVar2);
                return serializable;
            } catch (ClassNotFoundException e9) {
                str2 = Code;
                str3 = "read file ClassNotFoundException";
                ge.I(str2, str3);
                serializable = null;
                inputStream2 = fileInputStream;
                aoVar2 = aoVar;
                at.Code((Closeable) inputStream2);
                at.Code((Closeable) aoVar2);
                return serializable;
            }
            at.Code((Closeable) inputStream2);
            at.Code((Closeable) aoVar2);
            return serializable;
        } catch (Throwable th3) {
            fileInputStream = inputStream;
            th = th3;
        }
    }

    public static String Code(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2;
        ObjectOutputStream objectOutputStream3;
        ObjectOutputStream objectOutputStream4;
        byte[] bArr;
        if (serializable == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException e) {
                byteArrayOutputStream = null;
                objectOutputStream2 = null;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
                objectOutputStream = null;
            }
            try {
                objectOutputStream4 = new ObjectOutputStream(byteArrayOutputStream);
            } catch (IOException e2) {
                objectOutputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream = null;
                at.Code(objectOutputStream);
                at.Code(byteArrayOutputStream);
                throw th;
            }
            try {
                objectOutputStream4.writeObject(serializable);
                objectOutputStream4.flush();
                byteArrayOutputStream2 = byteArrayOutputStream;
                objectOutputStream3 = objectOutputStream4;
                bArr = byteArrayOutputStream.toByteArray();
            } catch (IOException e3) {
                objectOutputStream2 = objectOutputStream4;
                byteArrayOutputStream2 = byteArrayOutputStream;
                objectOutputStream3 = objectOutputStream2;
                ge.Z(Code, "fail to get sequence");
                objectOutputStream4 = objectOutputStream2;
                bArr = null;
                at.Code(objectOutputStream4);
                at.Code(byteArrayOutputStream);
                return u.Code(bArr);
            }
            at.Code(objectOutputStream4);
            at.Code(byteArrayOutputStream);
            return u.Code(bArr);
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream = objectOutputStream3;
            byteArrayOutputStream = byteArrayOutputStream2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v31, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    public static boolean Code(Serializable serializable, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        ?? fileOutputStream;
        ObjectOutputStream objectOutputStream;
        Serializable serializable2 = null;
        Serializable serializable3 = null;
        try {
            try {
                File file = new File(str);
                if (!file.getParentFile().exists() && !p.Code(file.getParentFile())) {
                    ge.I(Code, "writeObject, mkdir failed");
                }
                fileOutputStream = new FileOutputStream(str);
                try {
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                } catch (FileNotFoundException e) {
                    str3 = null;
                } catch (IOException e2) {
                    objectOutputStream = 0;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = null;
                }
            } catch (FileNotFoundException e3) {
                str3 = null;
            } catch (IOException e4) {
                str2 = null;
            } catch (Throwable th2) {
                th = th2;
                str = null;
                serializable = null;
            }
            try {
                objectOutputStream.writeObject(serializable);
                at.Code((Closeable) fileOutputStream);
                at.Code(objectOutputStream);
                return true;
            } catch (FileNotFoundException e5) {
                str3 = objectOutputStream;
                serializable2 = fileOutputStream;
                str4 = Code;
                str5 = "write file FileNotFoundException";
                str6 = str3;
                serializable3 = serializable2;
                serializable = serializable3;
                str = str6;
                ge.I(str4, str5);
                at.Code((Closeable) serializable3);
                at.Code((Closeable) str6);
                return false;
            } catch (IOException e6) {
                serializable3 = fileOutputStream;
                str2 = objectOutputStream;
                str4 = Code;
                str5 = "write file IOException";
                str6 = str2;
                serializable = serializable3;
                str = str6;
                ge.I(str4, str5);
                at.Code((Closeable) serializable3);
                at.Code((Closeable) str6);
                return false;
            } catch (Throwable th3) {
                th = th3;
                serializable = fileOutputStream;
                str = objectOutputStream;
                at.Code((Closeable) serializable);
                at.Code(str);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00e0: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:41:0x00e0 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    public static Serializable V(String str) {
        Closeable closeable;
        Closeable closeable2;
        Throwable th;
        ao aoVar;
        ByteArrayInputStream byteArrayInputStream;
        String str2;
        String str3;
        ByteArrayInputStream byteArrayInputStream2;
        Serializable serializable;
        ao aoVar2;
        try {
            if (au.Code(str)) {
                return null;
            }
            try {
                byteArrayInputStream = new ByteArrayInputStream(u.Code(str));
                try {
                    aoVar = new ao(byteArrayInputStream);
                } catch (UnsupportedEncodingException e) {
                    aoVar = null;
                } catch (IOException e2) {
                    aoVar = null;
                } catch (ClassNotFoundException e3) {
                    aoVar = null;
                } catch (Throwable th2) {
                    th = th2;
                    str = byteArrayInputStream;
                    closeable2 = null;
                    at.Code(closeable2);
                    at.Code((Closeable) str);
                    throw th;
                }
            } catch (UnsupportedEncodingException e4) {
                aoVar = null;
                byteArrayInputStream = null;
            } catch (IOException e5) {
                aoVar = null;
                byteArrayInputStream = null;
            } catch (ClassNotFoundException e6) {
                aoVar = null;
                byteArrayInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                str = null;
                closeable2 = null;
            }
            try {
                Object readObject = aoVar.readObject();
                byteArrayInputStream2 = byteArrayInputStream;
                serializable = null;
                aoVar2 = aoVar;
                if (readObject instanceof Serializable) {
                    serializable = (Serializable) readObject;
                    aoVar2 = aoVar;
                    byteArrayInputStream2 = byteArrayInputStream;
                }
            } catch (UnsupportedEncodingException e7) {
                str2 = Code;
                str3 = "fail to get Serializable UnsupportedEncodingException";
                ge.Z(str2, str3);
                byteArrayInputStream2 = byteArrayInputStream;
                serializable = null;
                aoVar2 = aoVar;
                at.Code((Closeable) aoVar2);
                at.Code((Closeable) byteArrayInputStream2);
                return serializable;
            } catch (IOException e8) {
                str2 = Code;
                str3 = "fail to get Serializable IOException";
                ge.Z(str2, str3);
                byteArrayInputStream2 = byteArrayInputStream;
                serializable = null;
                aoVar2 = aoVar;
                at.Code((Closeable) aoVar2);
                at.Code((Closeable) byteArrayInputStream2);
                return serializable;
            } catch (ClassNotFoundException e9) {
                str2 = Code;
                str3 = "fail to get Serializable ClassNotFoundException";
                ge.Z(str2, str3);
                byteArrayInputStream2 = byteArrayInputStream;
                serializable = null;
                aoVar2 = aoVar;
                at.Code((Closeable) aoVar2);
                at.Code((Closeable) byteArrayInputStream2);
                return serializable;
            }
            at.Code((Closeable) aoVar2);
            at.Code((Closeable) byteArrayInputStream2);
            return serializable;
        } catch (Throwable th4) {
            closeable2 = closeable;
            th = th4;
        }
    }
}
