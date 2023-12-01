package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/yxcorp/kuaishou/addfp/android/a/d.class */
public class d {
    private static volatile d d;

    /* renamed from: a  reason: collision with root package name */
    private e f41853a;
    private ConcurrentHashMap b = new ConcurrentHashMap(10);

    /* renamed from: c  reason: collision with root package name */
    private Context f41854c;

    private d(Context context) {
        this.f41853a = null;
        try {
            this.f41854c = context;
            this.f41853a = new e(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static d a(Context context) {
        if (d == null) {
            synchronized (d.class) {
                try {
                    if (d == null) {
                        d = new d(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    private String a(HashMap hashMap) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream2;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
            objectOutputStream = null;
        }
        try {
            objectOutputStream2.writeObject(hashMap);
            String str = new String(Base64.encode(com.yxcorp.kuaishou.addfp.android.b.b.c(byteArrayOutputStream.toByteArray(), "20212102sjcudiab".getBytes()), 0));
            try {
                objectOutputStream2.close();
                return str;
            } catch (IOException e) {
                return str;
            }
        } catch (Throwable th2) {
            objectOutputStream = objectOutputStream2;
            th = th2;
            try {
                th.printStackTrace();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                        return "";
                    } catch (IOException e2) {
                        return "";
                    }
                }
                return "";
            } catch (Throwable th3) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                throw th3;
            }
        }
    }

    public static void a(Context context, String str) {
        FileWriter fileWriter;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(context, false), new String(Base64.decode("Lm91a2R0ZnQ=", 0)));
                new File(file.getParent()).mkdirs();
                fileWriter = new FileWriter(file, false);
                try {
                    fileWriter.write(str);
                    fileWriter.flush();
                    fileWriter.close();
                    fileWriter.close();
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                    } catch (Throwable th2) {
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileWriter = null;
            }
        } catch (IOException e2) {
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x012b -> B:56:0x006d). Please submit an issue!!! */
    public Pair a() {
        byte[] bArr;
        synchronized (this) {
            try {
                if (this.b != null) {
                    StringBuilder sb = new StringBuilder();
                    if (!TextUtils.isEmpty((String) this.b.get("cache_e"))) {
                        return Pair.create(Pair.create(Boolean.TRUE, sb.toString()), this.b);
                    }
                }
                this.b.clear();
                String b = this.f41853a.b();
                if (!TextUtils.isEmpty(b)) {
                    try {
                        bArr = Base64.decode(b, 0);
                    } catch (Throwable th) {
                        bArr = null;
                    }
                    byte[] bArr2 = bArr;
                    if (bArr == null) {
                        try {
                            bArr2 = Base64.decode(b, 8);
                        } catch (Throwable th2) {
                            bArr2 = bArr;
                        }
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(new String(com.yxcorp.kuaishou.addfp.android.b.b.b(bArr2, "20212102sjcudiab".getBytes())));
                        this.b.put("cache_e", jSONObject.optString("cache_e", ""));
                        this.b.put("cache_m", jSONObject.optString("cache_m", ""));
                        this.b.put("c_time", Long.toString(jSONObject.optLong("c_time", 0L)));
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
                ConcurrentHashMap concurrentHashMap = this.b;
                if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    if (!TextUtils.isEmpty((String) this.b.get("cache_e"))) {
                        return Pair.create(Pair.create(Boolean.TRUE, sb2.toString()), this.b);
                    }
                }
                return Pair.create(Pair.create(Boolean.TRUE, "8"), null);
            }
        }
    }

    public String a(String str) {
        try {
            File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(this.f41854c, false), new String(Base64.decode(str, 0)));
            if (!file.exists()) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return sb.toString().trim();
                }
                sb.append(readLine);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0139, code lost:
        if (r8.size() == 0) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.d.a(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x006c -> B:21:0x0056). Please submit an issue!!! */
    public LinkedHashMap b(String str) {
        ObjectInputStream objectInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(com.yxcorp.kuaishou.addfp.android.b.b.b(Base64.decode(str.getBytes(), 0), "20212102sjcudiab".getBytes())));
                try {
                    LinkedHashMap linkedHashMap = (LinkedHashMap) objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                        return linkedHashMap;
                    } catch (IOException e) {
                        return linkedHashMap;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        return new LinkedHashMap();
                    } catch (Throwable th2) {
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            objectInputStream = null;
        }
        return new LinkedHashMap();
    }
}
