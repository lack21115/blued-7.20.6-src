package com.ut.mini.core.sign;

import com.alibaba.mtl.log.e.i;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication.class */
public class UTSecuritySDKRequestAuthentication implements IUTRequestAuthentication {
    private String Z;

    /* renamed from: b  reason: collision with other field name */
    private String f35b;
    private Object b = null;

    /* renamed from: c  reason: collision with root package name */
    private Object f27334c = null;

    /* renamed from: a  reason: collision with root package name */
    private Class f27333a = null;

    /* renamed from: a  reason: collision with other field name */
    private Field f33a = null;

    /* renamed from: b  reason: collision with other field name */
    private Field f36b = null;

    /* renamed from: c  reason: collision with other field name */
    private Field f37c = null;

    /* renamed from: a  reason: collision with other field name */
    private Method f34a = null;
    private int z = 1;
    private boolean D = false;

    public UTSecuritySDKRequestAuthentication(String str, String str2) {
        this.f35b = null;
        this.f35b = str;
        this.Z = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006e A[Catch: all -> 0x0113, TRY_ENTER, TryCatch #5 {, blocks: (B:4:0x0002, B:37:0x011e, B:17:0x0060, B:20:0x006e, B:28:0x00be, B:33:0x00ed, B:29:0x00d4, B:22:0x00a1), top: B:55:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void F() {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication.F():void");
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getAppkey() {
        return this.f35b;
    }

    public String getAuthCode() {
        return this.Z;
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getSign(String str) {
        Class cls;
        if (!this.D) {
            F();
        }
        if (this.f35b == null) {
            i.a("UTSecuritySDKRequestAuthentication:getSign", "There is no appkey,please check it!");
            return null;
        } else if (str == null || this.b == null || (cls = this.f27333a) == null || this.f33a == null || this.f36b == null || this.f37c == null || this.f34a == null || this.f27334c == null) {
            return null;
        } else {
            try {
                Object newInstance = cls.newInstance();
                this.f33a.set(newInstance, this.f35b);
                ((Map) this.f36b.get(newInstance)).put("INPUT", str);
                this.f37c.set(newInstance, Integer.valueOf(this.z));
                return (String) this.f34a.invoke(this.f27334c, newInstance, this.Z);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return null;
            }
        }
    }
}
