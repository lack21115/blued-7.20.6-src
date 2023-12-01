package com.qq.e.comm.managers.plugin;

import android.text.TextUtils;
import com.qq.e.comm.managers.plugin.c;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/managers/plugin/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final File f27924a;
    private final File b;

    /* renamed from: c  reason: collision with root package name */
    private String f27925c;
    private int d;
    private String e;

    public g(File file, File file2) {
        this.f27924a = file;
        this.b = file2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.BufferedReader] */
    private String a(File file) throws IOException {
        BufferedReader bufferedReader;
        if (file == null) {
            return null;
        }
        try {
            if (!file.exists()) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            } catch (IOException e) {
                e = e;
            } catch (Throwable th) {
                th = th;
                file = null;
                if (file != null) {
                    try {
                        file.close();
                    } catch (Exception e2) {
                        GDTLogger.d("Exception while close bufferreader");
                    }
                }
                throw th;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        String sb2 = sb.toString();
                        try {
                            bufferedReader.close();
                            return sb2;
                        } catch (Exception e3) {
                            GDTLogger.d("Exception while close bufferreader");
                            return sb2;
                        }
                    }
                    sb.append(readLine);
                }
            } catch (IOException e4) {
                e = e4;
                throw e;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        int i;
        try {
            if (this.b.exists() && this.f27924a.exists()) {
                String a2 = a(this.b);
                this.e = a2;
                if (TextUtils.isEmpty(a2)) {
                    return false;
                }
                String[] split = this.e.split("#####");
                if (split.length == 2) {
                    String str = split[1];
                    try {
                        i = Integer.parseInt(split[0]);
                    } catch (Throwable th) {
                        i = 0;
                    }
                    if (c.b.f27922a.a(str, this.f27924a)) {
                        this.f27925c = str;
                        this.d = i;
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        } catch (Throwable th2) {
            GDTLogger.d("Exception while checking plugin");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(File file, File file2) {
        if (file.equals(this.f27924a) || h.a(this.f27924a, file)) {
            return file2.equals(this.b) || h.a(this.b, file2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.f27925c;
    }

    public String d() {
        return this.e;
    }
}
