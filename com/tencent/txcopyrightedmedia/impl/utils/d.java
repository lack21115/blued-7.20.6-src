package com.tencent.txcopyrightedmedia.impl.utils;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/d.class */
public final class d {
    public static File a(String str, int i) {
        File filesDir = TXCopyrightedMedia.instance().getApplicationContext().getFilesDir();
        File file = new File(filesDir, "AME" + File.separator + "subtitles" + str);
        if (file.exists()) {
            return file;
        }
        if (i != 1) {
            return new File(filesDir, "AME" + File.separator + "subtitles" + File.separator + str);
        }
        return new File(filesDir, "AME" + File.separator + "subtitles" + File.separator + str + "_chorus");
    }

    public static void a() {
        aj.a(new File(TXCopyrightedMedia.instance().getApplicationContext().getFilesDir(), "AME"));
    }

    public static void a(bb bbVar) {
        int length;
        byte[] bArr;
        File b = b(bbVar);
        if (b == null) {
            return;
        }
        if (b.exists() && (bbVar.o().f40089c == null || bbVar.o().d == 0)) {
            b.delete();
        } else {
            File parentFile = b.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
        }
        byte[] bArr2 = bbVar.o().f40089c;
        boolean z = false;
        String absolutePath = b.getAbsolutePath();
        if (bArr2 != null) {
            byte[] bArr3 = bbVar.o().f40089c;
            z = true;
            length = (int) bbVar.o().e;
            bArr = bArr3;
        } else {
            byte[] a2 = bbVar.a();
            if (bbVar.a() == null) {
                length = 0;
                bArr = a2;
            } else {
                length = bbVar.a().length;
                bArr = a2;
            }
        }
        ak.a(absolutePath, bArr, z, length);
    }

    public static void a(String str) {
        String[] list;
        File b = b(str);
        if (!b.exists() || (list = b.list()) == null || list.length <= 0) {
            aj.a(b);
            aj.a(a(str, 0));
            aj.a(a(str, 1));
        }
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00f9: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:63:0x00f9 */
    public static byte[] a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        AutoCloseable autoCloseable;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream3;
        ByteArrayOutputStream byteArrayOutputStream2;
        FileInputStream fileInputStream4;
        if (file == null || !file.exists()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            try {
                try {
                    fileInputStream2 = new FileInputStream(file);
                    try {
                        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int read = fileInputStream2.read(bArr);
                                if (read == -1) {
                                    byte[] byteArray = byteArrayOutputStream3.toByteArray();
                                    try {
                                        fileInputStream2.close();
                                        byteArrayOutputStream3.close();
                                        return byteArray;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        return byteArray;
                                    }
                                }
                                byteArrayOutputStream3.write(bArr, 0, read);
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                fileInputStream4 = fileInputStream2;
                                byteArrayOutputStream2 = byteArrayOutputStream3;
                                e.printStackTrace();
                                if (fileInputStream4 != null) {
                                    fileInputStream4.close();
                                }
                                if (byteArrayOutputStream2 != null) {
                                    byteArrayOutputStream2.close();
                                    return null;
                                }
                                return null;
                            } catch (IOException e3) {
                                e = e3;
                                fileInputStream3 = fileInputStream2;
                                byteArrayOutputStream = byteArrayOutputStream3;
                                e.printStackTrace();
                                if (fileInputStream3 != null) {
                                    fileInputStream3.close();
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                    return null;
                                }
                                return null;
                            }
                        }
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        fileInputStream4 = fileInputStream2;
                        byteArrayOutputStream2 = null;
                    } catch (IOException e5) {
                        e = e5;
                        fileInputStream3 = fileInputStream2;
                        byteArrayOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        autoCloseable = null;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                                throw th;
                            }
                        }
                        if (autoCloseable != null) {
                            autoCloseable.close();
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e7) {
                    e = e7;
                    byteArrayOutputStream2 = null;
                    fileInputStream4 = null;
                } catch (IOException e8) {
                    e = e8;
                    byteArrayOutputStream = null;
                    fileInputStream3 = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream2 = null;
                    autoCloseable = null;
                }
            } catch (Exception e9) {
                e9.printStackTrace();
                return null;
            }
        } catch (Throwable th4) {
            fileInputStream2 = fileInputStream;
            th = th4;
        }
    }

    public static File b(bb bbVar) {
        return bbVar instanceof au ? a(bbVar.i(), bbVar.l()) : c(bbVar);
    }

    private static File b(String str) {
        File filesDir = TXCopyrightedMedia.instance().getApplicationContext().getFilesDir();
        return new File(filesDir, "AME" + File.separator + "urlcache" + File.separator + str + File.separator);
    }

    public static File c(bb bbVar) {
        try {
            String b = ac.b(bbVar.c() + bbVar.j());
            if (!b.isEmpty()) {
                return new File(b(bbVar.i()), b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File b2 = b(bbVar.i());
        return new File(b2, System.currentTimeMillis() + BridgeUtil.UNDERLINE_STR + (Math.random() * 10000.0d));
    }
}
