package com.getui.gtc.dyc;

import android.util.Base64;
import com.getui.gtc.base.crypt.SecureCryptTools;
import com.getui.gtc.base.util.io.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/h.class */
public class h implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private String f21991a;

    /* renamed from: c  reason: collision with root package name */
    private long f21992c;
    private String d;
    private String e;
    private Map<String, String> f;

    public static h e(String str) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(SecureCryptTools.getInstance().decrypt(Base64.decode(str.getBytes(), 0)));
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream2);
            } catch (IOException e) {
                e = e;
                objectInputStream = null;
                com.getui.gtc.dyc.a.a.a.a(e);
                IOUtils.safeClose(objectInputStream);
                return null;
            } catch (ClassNotFoundException e2) {
                e = e2;
                objectInputStream = null;
                com.getui.gtc.dyc.a.a.a.a(e);
                IOUtils.safeClose(objectInputStream);
                return null;
            } catch (Throwable th2) {
                byteArrayInputStream = null;
                th = th2;
                IOUtils.safeClose(byteArrayInputStream);
                throw th;
            }
            try {
                h hVar = (h) objectInputStream.readObject();
                IOUtils.safeClose(objectInputStream);
                return hVar;
            } catch (IOException e3) {
                e = e3;
                com.getui.gtc.dyc.a.a.a.a(e);
                IOUtils.safeClose(objectInputStream);
                return null;
            } catch (ClassNotFoundException e4) {
                e = e4;
                com.getui.gtc.dyc.a.a.a.a(e);
                IOUtils.safeClose(objectInputStream);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = byteArrayInputStream2;
            IOUtils.safeClose(byteArrayInputStream);
            throw th;
        }
    }

    public String a() {
        return this.f21991a;
    }

    public void a(long j) {
        this.f21992c = j;
    }

    public void a(String str) {
        this.f21991a = str;
    }

    public void a(Map<String, String> map) {
        this.f = map;
    }

    public long c() {
        return this.f21992c;
    }

    public void c(String str) {
        this.e = str;
    }

    public String d() {
        return this.e;
    }

    public void d(String str) {
        this.d = str;
    }

    public String e() {
        return this.d;
    }

    public Map<String, String> f() {
        return this.f;
    }

    public String g() throws Throwable {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream2 = objectOutputStream;
            } catch (IOException e) {
                e = e;
                objectOutputStream = null;
            } catch (Throwable th) {
                th = th;
                IOUtils.safeClose(objectOutputStream2);
                throw th;
            }
            try {
                objectOutputStream.writeObject(this);
            } catch (IOException e2) {
                e = e2;
                objectOutputStream2 = objectOutputStream;
                com.getui.gtc.dyc.a.a.a.a(e);
                IOUtils.safeClose(objectOutputStream);
                return Base64.encodeToString(SecureCryptTools.getInstance().encrypt(byteArrayOutputStream.toByteArray()), 0);
            }
            IOUtils.safeClose(objectOutputStream);
            return Base64.encodeToString(SecureCryptTools.getInstance().encrypt(byteArrayOutputStream.toByteArray()), 0);
        } catch (Throwable th2) {
            th = th2;
            IOUtils.safeClose(objectOutputStream2);
            throw th;
        }
    }
}
