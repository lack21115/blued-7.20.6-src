package com.tencent.turingface.sdk.mfa;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/oqKCa.class */
public abstract class oqKCa {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/oqKCa$ShGzN.class */
    public static final class ShGzN extends oqKCa {

        /* renamed from: a  reason: collision with root package name */
        public final String f26280a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f26281c;
        public String[] d;

        public ShGzN(String str, int i) {
            if (str == null) {
                throw new NullPointerException("keystoreAlias == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("keystoreAlias must not be empty");
            }
            this.f26280a = str;
            this.b = i;
        }

        @Override // com.tencent.turingface.sdk.mfa.oqKCa
        public final oqKCa a(String... strArr) {
            String[] strArr2 = strArr;
            if (strArr.length > 0) {
                strArr2 = (String[]) strArr.clone();
            }
            this.f26281c = strArr2;
            return this;
        }

        @Override // com.tencent.turingface.sdk.mfa.oqKCa
        public final AlgorithmParameterSpec a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            Class<?> cls = Class.forName("android.security.keystore.KeyGenParameterSpec");
            Class<?> cls2 = Integer.TYPE;
            Class<?> cls3 = Boolean.TYPE;
            return (AlgorithmParameterSpec) cls.getConstructor(String.class, cls2, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, cls2, String[].class, String[].class, String[].class, String[].class, cls3, cls3, cls2).newInstance(this.f26280a, -1, null, null, null, null, null, null, null, null, Integer.valueOf(this.b), this.f26281c, null, this.d, null, Boolean.TRUE, Boolean.FALSE, -1);
        }

        @Override // com.tencent.turingface.sdk.mfa.oqKCa
        public final oqKCa b(String... strArr) {
            String[] strArr2 = strArr;
            if (strArr.length > 0) {
                strArr2 = (String[]) strArr.clone();
            }
            this.d = strArr2;
            return this;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/oqKCa$spXPg.class */
    public static final class spXPg extends oqKCa {

        /* renamed from: a  reason: collision with root package name */
        public KeyGenParameterSpec.Builder f26282a;

        public spXPg(String str, int i) {
            this.f26282a = null;
            this.f26282a = new KeyGenParameterSpec.Builder(str, i);
        }

        @Override // com.tencent.turingface.sdk.mfa.oqKCa
        public final oqKCa a(String... strArr) {
            this.f26282a.setDigests(strArr);
            return this;
        }

        @Override // com.tencent.turingface.sdk.mfa.oqKCa
        public final AlgorithmParameterSpec a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            return this.f26282a.build();
        }

        @Override // com.tencent.turingface.sdk.mfa.oqKCa
        public final oqKCa b(String... strArr) {
            this.f26282a.setSignaturePaddings(strArr);
            return this;
        }
    }

    public static oqKCa a(String str, int i) {
        return Build.VERSION.SDK_INT >= 23 ? new spXPg(str, i) : new ShGzN(str, i);
    }

    public abstract oqKCa a(String... strArr);

    public abstract AlgorithmParameterSpec a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    public abstract oqKCa b(String... strArr);
}
