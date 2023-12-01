package com.opos.cmn.biz.ststrategy.c;

import android.content.Context;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/ststrategy/c/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11016a = e.class.getSimpleName();
    private static final ReentrantReadWriteLock b = new ReentrantReadWriteLock();

    /* renamed from: c  reason: collision with root package name */
    private static final ReentrantReadWriteLock f11017c = new ReentrantReadWriteLock();
    private static STConfigEntity d = null;

    public static int a(Context context, JSONObject jSONObject) {
        int i;
        if (context != null && jSONObject != null) {
            try {
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.c(f11016a, "", e);
            }
            if (jSONObject.has("data") && !jSONObject.isNull("data")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (jSONObject2.has("currTime") && !jSONObject2.isNull("currTime")) {
                    i = jSONObject2.getInt("currTime");
                    com.opos.cmn.an.f.a.b(f11016a, "currTime=" + i);
                    return i;
                }
            }
        }
        i = 0;
        com.opos.cmn.an.f.a.b(f11016a, "currTime=" + i);
        return i;
    }

    public static STConfigEntity a() {
        try {
            b.readLock().lock();
            STConfigEntity sTConfigEntity = d;
            b.readLock().unlock();
            return sTConfigEntity;
        } catch (Throwable th) {
            b.readLock().unlock();
            throw th;
        }
    }

    public static STConfigEntity a(Context context) {
        STConfigEntity a2;
        synchronized (e.class) {
            if (context != null) {
                try {
                    if (a() == null) {
                        com.opos.cmn.an.f.a.b(f11016a, "sSTConfigEntity=null!set it.");
                        STConfigEntity a3 = g.a(context);
                        if (a() != null || a3 == null) {
                            com.opos.cmn.an.f.a.c(f11016a, "getSTConfigEntity != null || tempSTConfigEntity == null");
                        } else {
                            a(a3);
                        }
                    }
                    a2 = a();
                } finally {
                }
            } else {
                a2 = null;
            }
        }
        return a2;
    }

    public static JSONObject a(Context context, com.opos.cmn.func.b.b.e eVar) {
        JSONObject jSONObject = null;
        if (context != null) {
            jSONObject = null;
            if (eVar != null) {
                InputStream inputStream = eVar.f11175c;
                jSONObject = null;
                if (inputStream != null) {
                    byte[] a2 = a(inputStream);
                    jSONObject = null;
                    if (a2 != null) {
                        jSONObject = null;
                        if (a2.length > 0) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(new String(a2, 0, a2.length, "UTF-8"));
                                jSONObject = null;
                                if (jSONObject2.has("code")) {
                                    jSONObject = null;
                                    if (!jSONObject2.isNull("code")) {
                                        int i = jSONObject2.getInt("code");
                                        if (i == 0) {
                                            try {
                                                if (jSONObject2.has("data") && !jSONObject2.isNull("data")) {
                                                    JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                                                    if (jSONObject3.has("strategy") && !jSONObject3.isNull("strategy")) {
                                                        JSONObject jSONObject4 = jSONObject3.getJSONObject("strategy");
                                                        if (jSONObject4.has("nxLimit") && !jSONObject4.isNull("nxLimit")) {
                                                            long j = jSONObject4.getLong("nxLimit");
                                                            com.opos.cmn.an.f.a.b(f11016a, "set ntLimit=" + j);
                                                            d.a(context, j);
                                                        }
                                                        if (jSONObject4.has("dtLimit") && !jSONObject4.isNull("dtLimit")) {
                                                            int i2 = jSONObject4.getInt("dtLimit");
                                                            com.opos.cmn.an.f.a.b(f11016a, "set dtLimit=" + i2);
                                                            d.a(context, i2);
                                                        }
                                                        if (jSONObject4.has("blackListLimit") && !jSONObject4.isNull("blackListLimit")) {
                                                            int i3 = jSONObject4.getInt("blackListLimit");
                                                            com.opos.cmn.an.f.a.b(f11016a, "set blaLimit=" + i3);
                                                            d.b(context, i3);
                                                        }
                                                    }
                                                }
                                                d.a(context, com.opos.cmn.biz.a.d.a(context));
                                            } catch (Exception e) {
                                                e = e;
                                                jSONObject = jSONObject2;
                                                com.opos.cmn.an.f.a.c(f11016a, "", e);
                                                com.opos.cmn.an.f.a.b(f11016a, "netResponseToJsonObject result:" + jSONObject);
                                                return jSONObject;
                                            }
                                        } else if (-3 != i) {
                                            String string = jSONObject2.getString("msg");
                                            String str = f11016a;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("netResponseToJsonObject code=");
                                            sb.append(i);
                                            sb.append(",msg=");
                                            String str2 = string;
                                            if (string == null) {
                                                str2 = "";
                                            }
                                            sb.append(str2);
                                            sb.append(",json=");
                                            sb.append(jSONObject2.toString());
                                            com.opos.cmn.an.f.a.b(str, sb.toString());
                                            jSONObject = null;
                                        }
                                        jSONObject = jSONObject2;
                                    }
                                }
                            } catch (Exception e2) {
                                e = e2;
                                jSONObject = null;
                            }
                        }
                    }
                }
            }
        }
        com.opos.cmn.an.f.a.b(f11016a, "netResponseToJsonObject result:" + jSONObject);
        return jSONObject;
    }

    private static void a(STConfigEntity sTConfigEntity) {
        try {
            b.writeLock().lock();
            d = sTConfigEntity;
            b.writeLock().unlock();
        } catch (Throwable th) {
            b.writeLock().unlock();
            throw th;
        }
    }

    private static boolean a(Context context, byte[] bArr) {
        boolean z;
        boolean z2 = false;
        if (context == null || bArr == null || bArr.length <= 0) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        try {
            try {
                f11017c.writeLock().lock();
                FileOutputStream openFileOutput = context.openFileOutput(d(context), 0);
                if (openFileOutput != null) {
                    openFileOutput.write(bArr, 0, bArr.length);
                    openFileOutput.flush();
                    fileOutputStream = openFileOutput;
                    fileOutputStream2 = openFileOutput;
                    fileOutputStream3 = openFileOutput;
                    com.opos.cmn.an.f.a.b(f11016a, "fileOutputStream flush!!!");
                    z2 = true;
                }
                z = z2;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                        z = z2;
                    } catch (IOException e) {
                        e = e;
                        com.opos.cmn.an.f.a.c(f11016a, "", e);
                        z = z2;
                        f11017c.writeLock().unlock();
                        return z;
                    }
                }
            } catch (FileNotFoundException e2) {
                com.opos.cmn.an.f.a.c(f11016a, "", e2);
                z = false;
                if (fileOutputStream3 != null) {
                    try {
                        fileOutputStream3.close();
                        z = false;
                    } catch (IOException e3) {
                        e = e3;
                        z2 = false;
                        com.opos.cmn.an.f.a.c(f11016a, "", e);
                        z = z2;
                        f11017c.writeLock().unlock();
                        return z;
                    }
                }
            } catch (IOException e4) {
                com.opos.cmn.an.f.a.c(f11016a, "", e4);
                z = false;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                        z = false;
                    } catch (IOException e5) {
                        e = e5;
                        z2 = false;
                        com.opos.cmn.an.f.a.c(f11016a, "", e);
                        z = z2;
                        f11017c.writeLock().unlock();
                        return z;
                    }
                }
            }
            f11017c.writeLock().unlock();
            return z;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    com.opos.cmn.an.f.a.c(f11016a, "", e6);
                }
            }
            f11017c.writeLock().unlock();
            throw th;
        }
    }

    private static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 == read) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c(f11016a, "", e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject b(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.ststrategy.c.e.b(android.content.Context):org.json.JSONObject");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a3 A[Catch: all -> 0x00e0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00e0, blocks: (B:4:0x0003, B:9:0x001d, B:11:0x0024, B:14:0x0032, B:16:0x0038, B:17:0x0040, B:19:0x0055, B:21:0x005d, B:23:0x006f, B:25:0x0085, B:27:0x008d, B:32:0x00a3, B:35:0x00b1, B:36:0x00b9), top: B:47:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r4, org.json.JSONObject r5) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.ststrategy.c.e.b(android.content.Context, org.json.JSONObject):boolean");
    }

    public static boolean c(Context context) {
        if (context != null) {
            try {
                return new File(context.getFilesDir(), d(context)).exists();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c(f11016a, "", e);
                return false;
            }
        }
        return false;
    }

    private static boolean c(Context context, JSONObject jSONObject) {
        byte[] d2;
        boolean a2 = (context == null || jSONObject == null || (d2 = d(context, jSONObject)) == null || d2.length <= 0) ? false : a(context, d2);
        String str = f11016a;
        com.opos.cmn.an.f.a.b(str, "savejsonObjectSTConfig to file result: " + a2);
        return a2;
    }

    public static String d(Context context) {
        String str = (context == null || !f.b(context)) ? "acs_st_config_merge.ini" : "acs_st_config_overseas_merge.ini";
        String str2 = f11016a;
        com.opos.cmn.an.f.a.b(str2, "getSTConfigFileName=" + str);
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0024 -> B:12:0x002d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] d(android.content.Context r4, org.json.JSONObject r5) {
        /*
            r0 = r4
            if (r0 == 0) goto L2d
            r0 = r5
            if (r0 == 0) goto L2d
            r0 = r5
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L23
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L2d
            r0 = r5
            java.lang.String r1 = "UTF-8"
            byte[] r0 = r0.getBytes(r1)     // Catch: java.lang.Exception -> L62
            r4 = r0
            goto L2f
        L1b:
            r0 = r5
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Exception -> L23
            r4 = r0
            goto L2f
        L23:
            r4 = move-exception
            java.lang.String r0 = com.opos.cmn.biz.ststrategy.c.e.f11016a
            java.lang.String r1 = ""
            r2 = r4
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L2d:
            r0 = 0
            r4 = r0
        L2f:
            java.lang.String r0 = com.opos.cmn.biz.ststrategy.c.e.f11016a
            r6 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "getJsonObjectBytes bytes is null ?"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            if (r0 != 0) goto L4e
            java.lang.String r0 = "true"
            r5 = r0
            goto L52
        L4e:
            java.lang.String r0 = "false"
            r5 = r0
        L52:
            r0 = r7
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r1 = r7
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r4
            return r0
        L62:
            r4 = move-exception
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.ststrategy.c.e.d(android.content.Context, org.json.JSONObject):byte[]");
    }
}
