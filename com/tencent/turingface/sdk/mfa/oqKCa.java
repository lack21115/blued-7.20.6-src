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
        public final String f39971a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f39972c;
        public String[] d;

        public ShGzN(String str, int i) {
            if (str == null) {
                throw new NullPointerException("keystoreAlias == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("keystoreAlias must not be empty");
            }
            this.f39971a = str;
            this.b = i;
        }

        @Override // com.tencent.turingface.sdk.mfa.oqKCa
        public final oqKCa a(String... strArr) {
            String[] strArr2 = strArr;
            if (strArr.length > 0) {
                strArr2 = (String[]) strArr.clone();
            }
            this.f39972c = strArr2;
            return this;
        }

        @Override // com.tencent.turingface.sdk.mfa.oqKCa
        public final AlgorithmParameterSpec a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            Class<?> cls = Class.forName("android.security.keystore.KeyGenParameterSpec");
            Class<Integer> cls2 = Integer.TYPE;
            Class<Boolean> cls3 = Boolean.TYPE;
            return (AlgorithmParameterSpec) cls.getConstructor(String.class, cls2, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, cls2, String[].class, String[].class, String[].class, String[].class, cls3, cls3, cls2).newInstance(this.f39971a, -1, null, null, null, null, null, null, null, null, Integer.valueOf(this.b), this.f39972c, null, this.d, null, Boolean.TRUE, Boolean.FALSE, -1);
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
        public KeyGenParameterSpec.Builder f39973a;

        public spXPg(String str, int i) {
            this.f39973a = null;
            this.f39973a = new KeyGenParameterSpec.Builder(str, i);
        }

        @Override // com.tencent.turingface.sdk.mfa.oqKCa
        public final oqKCa a(String... strArr) {
            this.f39973a.setDigests(strArr);
            return this;
        }

        @Override // com.tencent.turingface.sdk.mfa.oqKCa
        public final AlgorithmParameterSpec a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            return this.f39973a.build();
        }

        @Override // com.tencent.turingface.sdk.mfa.oqKCa
        public final oqKCa b(String... strArr) {
            this.f39973a.setSignaturePaddings(strArr);
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
