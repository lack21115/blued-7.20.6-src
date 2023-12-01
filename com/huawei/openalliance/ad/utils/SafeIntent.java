package com.huawei.openalliance.ad.utils;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/SafeIntent.class */
public class SafeIntent extends Intent {
    private static final String Code = "SafeIntent";

    public SafeIntent(Intent intent) {
        super(intent == null ? new Intent() : intent);
    }

    public ArrayList<String> B(String str) {
        try {
            ArrayList<String> stringArrayListExtra = super.getStringArrayListExtra(str);
            ArrayList<String> arrayList = stringArrayListExtra;
            if (stringArrayListExtra == null) {
                arrayList = new ArrayList<>();
            }
            return arrayList;
        } catch (Throwable th) {
            return new ArrayList<>();
        }
    }

    public boolean[] C(String str) {
        try {
            boolean[] booleanArrayExtra = super.getBooleanArrayExtra(str);
            boolean[] zArr = booleanArrayExtra;
            if (booleanArrayExtra == null) {
                zArr = new boolean[0];
            }
            return zArr;
        } catch (Throwable th) {
            return new boolean[0];
        }
    }

    public String Code() {
        try {
            String action = super.getAction();
            return action == null ? "" : action;
        } catch (Throwable th) {
            return "";
        }
    }

    public String Code(int i) {
        String str;
        try {
            str = super.toUri(i);
        } catch (Throwable th) {
            ge.I(Code, "toUri: " + th.getClass().getSimpleName());
            str = "";
        }
        return str == null ? "" : str;
    }

    public String Code(String str) {
        try {
            String stringExtra = super.getStringExtra(str);
            return stringExtra == null ? "" : stringExtra;
        } catch (Throwable th) {
            return "";
        }
    }

    public char[] D(String str) {
        try {
            char[] charArrayExtra = super.getCharArrayExtra(str);
            char[] cArr = charArrayExtra;
            if (charArrayExtra == null) {
                cArr = new char[0];
            }
            return cArr;
        } catch (Throwable th) {
            return new char[0];
        }
    }

    public byte[] F(String str) {
        try {
            byte[] byteArrayExtra = super.getByteArrayExtra(str);
            byte[] bArr = byteArrayExtra;
            if (byteArrayExtra == null) {
                bArr = new byte[0];
            }
            return bArr;
        } catch (Throwable th) {
            return new byte[0];
        }
    }

    @Deprecated
    public String I() {
        String str;
        try {
            str = super.toURI();
        } catch (Throwable th) {
            ge.I(Code, "toURI: exception " + th.getClass().getSimpleName());
            str = "";
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public ArrayList<CharSequence> I(String str) {
        try {
            ArrayList<CharSequence> charSequenceArrayListExtra = super.getCharSequenceArrayListExtra(str);
            ArrayList<CharSequence> arrayList = charSequenceArrayListExtra;
            if (charSequenceArrayListExtra == null) {
                arrayList = new ArrayList<>();
            }
            return arrayList;
        } catch (Throwable th) {
            return new ArrayList<>();
        }
    }

    public CharSequence[] L(String str) {
        try {
            CharSequence[] charSequenceArrayExtra = super.getCharSequenceArrayExtra(str);
            CharSequence[] charSequenceArr = charSequenceArrayExtra;
            if (charSequenceArrayExtra == null) {
                charSequenceArr = new CharSequence[0];
            }
            return charSequenceArr;
        } catch (Throwable th) {
            return new CharSequence[0];
        }
    }

    public Bundle S(String str) {
        try {
            Bundle bundleExtra = super.getBundleExtra(str);
            Bundle bundle = bundleExtra;
            if (bundleExtra == null) {
                bundle = new Bundle();
            }
            return bundle;
        } catch (Throwable th) {
            return new Bundle();
        }
    }

    public Bundle V() {
        try {
            Bundle extras = super.getExtras();
            Bundle bundle = extras;
            if (extras == null) {
                bundle = new Bundle();
            }
            return bundle;
        } catch (Throwable th) {
            return new Bundle();
        }
    }

    public CharSequence V(String str) {
        try {
            CharSequence charSequenceExtra = super.getCharSequenceExtra(str);
            return charSequenceExtra == null ? "" : charSequenceExtra;
        } catch (Throwable th) {
            return "";
        }
    }

    public ArrayList<Integer> Z(String str) {
        try {
            ArrayList<Integer> integerArrayListExtra = super.getIntegerArrayListExtra(str);
            ArrayList<Integer> arrayList = integerArrayListExtra;
            if (integerArrayListExtra == null) {
                arrayList = new ArrayList<>();
            }
            return arrayList;
        } catch (Throwable th) {
            return new ArrayList<>();
        }
    }

    public double[] a(String str) {
        try {
            double[] doubleArrayExtra = super.getDoubleArrayExtra(str);
            double[] dArr = doubleArrayExtra;
            if (doubleArrayExtra == null) {
                dArr = new double[0];
            }
            return dArr;
        } catch (Throwable th) {
            return new double[0];
        }
    }

    public float[] b(String str) {
        try {
            float[] floatArrayExtra = super.getFloatArrayExtra(str);
            float[] fArr = floatArrayExtra;
            if (floatArrayExtra == null) {
                fArr = new float[0];
            }
            return fArr;
        } catch (Throwable th) {
            return new float[0];
        }
    }

    public int[] c(String str) {
        try {
            int[] intArrayExtra = super.getIntArrayExtra(str);
            int[] iArr = intArrayExtra;
            if (intArrayExtra == null) {
                iArr = new int[0];
            }
            return iArr;
        } catch (Throwable th) {
            return new int[0];
        }
    }

    public long[] d(String str) {
        try {
            long[] longArrayExtra = super.getLongArrayExtra(str);
            long[] jArr = longArrayExtra;
            if (longArrayExtra == null) {
                jArr = new long[0];
            }
            return jArr;
        } catch (Throwable th) {
            return new long[0];
        }
    }

    public Parcelable[] e(String str) {
        try {
            Parcelable[] parcelableArrayExtra = super.getParcelableArrayExtra(str);
            Parcelable[] parcelableArr = parcelableArrayExtra;
            if (parcelableArrayExtra == null) {
                parcelableArr = new Parcelable[0];
            }
            return parcelableArr;
        } catch (Throwable th) {
            return new Parcelable[0];
        }
    }

    public String[] f(String str) {
        try {
            String[] stringArrayExtra = super.getStringArrayExtra(str);
            String[] strArr = stringArrayExtra;
            if (stringArrayExtra == null) {
                strArr = new String[0];
            }
            return strArr;
        } catch (Throwable th) {
            return new String[0];
        }
    }

    public short[] g(String str) {
        try {
            short[] shortArrayExtra = super.getShortArrayExtra(str);
            short[] sArr = shortArrayExtra;
            if (shortArrayExtra == null) {
                sArr = new short[0];
            }
            return sArr;
        } catch (Throwable th) {
            return new short[0];
        }
    }

    @Override // android.content.Intent
    public String getAction() {
        try {
            return super.getAction();
        } catch (Throwable th) {
            return "";
        }
    }

    @Override // android.content.Intent
    public boolean[] getBooleanArrayExtra(String str) {
        try {
            return super.getBooleanArrayExtra(str);
        } catch (Throwable th) {
            return new boolean[0];
        }
    }

    @Override // android.content.Intent
    public boolean getBooleanExtra(String str, boolean z) {
        try {
            return super.getBooleanExtra(str, z);
        } catch (Throwable th) {
            return z;
        }
    }

    @Override // android.content.Intent
    public Bundle getBundleExtra(String str) {
        try {
            return super.getBundleExtra(str);
        } catch (Throwable th) {
            return new Bundle();
        }
    }

    @Override // android.content.Intent
    public byte[] getByteArrayExtra(String str) {
        try {
            return super.getByteArrayExtra(str);
        } catch (Throwable th) {
            return new byte[0];
        }
    }

    @Override // android.content.Intent
    public byte getByteExtra(String str, byte b) {
        try {
            return super.getByteExtra(str, b);
        } catch (Throwable th) {
            return b;
        }
    }

    @Override // android.content.Intent
    public char[] getCharArrayExtra(String str) {
        try {
            return super.getCharArrayExtra(str);
        } catch (Throwable th) {
            return new char[0];
        }
    }

    @Override // android.content.Intent
    public char getCharExtra(String str, char c2) {
        try {
            return super.getCharExtra(str, c2);
        } catch (Throwable th) {
            return c2;
        }
    }

    @Override // android.content.Intent
    public CharSequence[] getCharSequenceArrayExtra(String str) {
        try {
            return super.getCharSequenceArrayExtra(str);
        } catch (Throwable th) {
            return new CharSequence[0];
        }
    }

    @Override // android.content.Intent
    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String str) {
        try {
            return super.getCharSequenceArrayListExtra(str);
        } catch (Throwable th) {
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public CharSequence getCharSequenceExtra(String str) {
        try {
            return super.getCharSequenceExtra(str);
        } catch (Throwable th) {
            return "";
        }
    }

    @Override // android.content.Intent
    public double[] getDoubleArrayExtra(String str) {
        try {
            return super.getDoubleArrayExtra(str);
        } catch (Throwable th) {
            return new double[0];
        }
    }

    @Override // android.content.Intent
    public double getDoubleExtra(String str, double d) {
        try {
            return super.getDoubleExtra(str, d);
        } catch (Throwable th) {
            return d;
        }
    }

    @Override // android.content.Intent
    public Bundle getExtras() {
        try {
            return super.getExtras();
        } catch (Throwable th) {
            return new Bundle();
        }
    }

    @Override // android.content.Intent
    public float[] getFloatArrayExtra(String str) {
        try {
            return super.getFloatArrayExtra(str);
        } catch (Throwable th) {
            return new float[0];
        }
    }

    @Override // android.content.Intent
    public float getFloatExtra(String str, float f) {
        try {
            return super.getFloatExtra(str, f);
        } catch (Throwable th) {
            return f;
        }
    }

    @Override // android.content.Intent
    public int[] getIntArrayExtra(String str) {
        try {
            return super.getIntArrayExtra(str);
        } catch (Throwable th) {
            return new int[0];
        }
    }

    @Override // android.content.Intent
    public int getIntExtra(String str, int i) {
        try {
            return super.getIntExtra(str, i);
        } catch (Throwable th) {
            return i;
        }
    }

    @Override // android.content.Intent
    public ArrayList<Integer> getIntegerArrayListExtra(String str) {
        try {
            return super.getIntegerArrayListExtra(str);
        } catch (Throwable th) {
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public long[] getLongArrayExtra(String str) {
        try {
            return super.getLongArrayExtra(str);
        } catch (Throwable th) {
            return new long[0];
        }
    }

    @Override // android.content.Intent
    public long getLongExtra(String str, long j) {
        try {
            return super.getLongExtra(str, j);
        } catch (Throwable th) {
            return j;
        }
    }

    @Override // android.content.Intent
    public Parcelable[] getParcelableArrayExtra(String str) {
        try {
            return super.getParcelableArrayExtra(str);
        } catch (Throwable th) {
            return new Parcelable[0];
        }
    }

    @Override // android.content.Intent
    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String str) {
        try {
            return super.getParcelableArrayListExtra(str);
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // android.content.Intent
    public <T extends Parcelable> T getParcelableExtra(String str) {
        try {
            return (T) super.getParcelableExtra(str);
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // android.content.Intent
    public Serializable getSerializableExtra(String str) {
        try {
            return super.getSerializableExtra(str);
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // android.content.Intent
    public short[] getShortArrayExtra(String str) {
        try {
            return super.getShortArrayExtra(str);
        } catch (Throwable th) {
            return new short[0];
        }
    }

    @Override // android.content.Intent
    public short getShortExtra(String str, short s) {
        try {
            return super.getShortExtra(str, s);
        } catch (Throwable th) {
            return s;
        }
    }

    @Override // android.content.Intent
    public String[] getStringArrayExtra(String str) {
        try {
            return super.getStringArrayExtra(str);
        } catch (Throwable th) {
            return new String[0];
        }
    }

    @Override // android.content.Intent
    public ArrayList<String> getStringArrayListExtra(String str) {
        try {
            return super.getStringArrayListExtra(str);
        } catch (Throwable th) {
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public String getStringExtra(String str) {
        try {
            return super.getStringExtra(str);
        } catch (Throwable th) {
            return "";
        }
    }

    @Override // android.content.Intent
    public boolean hasExtra(String str) {
        try {
            return super.hasExtra(str);
        } catch (Throwable th) {
            return false;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, Bundle bundle) {
        try {
            return super.putExtra(str, bundle);
        } catch (Throwable th) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, Parcelable parcelable) {
        try {
            return super.putExtra(str, parcelable);
        } catch (Throwable th) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, Serializable serializable) {
        try {
            return super.putExtra(str, serializable);
        } catch (Throwable th) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, CharSequence charSequence) {
        try {
            return super.putExtra(str, charSequence);
        } catch (Throwable th) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, String str2) {
        try {
            return super.putExtra(str, str2);
        } catch (Throwable th) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, Parcelable[] parcelableArr) {
        try {
            return super.putExtra(str, parcelableArr);
        } catch (Throwable th) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, CharSequence[] charSequenceArr) {
        try {
            return super.putExtra(str, charSequenceArr);
        } catch (Throwable th) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, String[] strArr) {
        try {
            return super.putExtra(str, strArr);
        } catch (Throwable th) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtras(Intent intent) {
        try {
            return super.putExtras(intent);
        } catch (Throwable th) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putParcelableArrayListExtra(String str, ArrayList<? extends Parcelable> arrayList) {
        try {
            return super.putParcelableArrayListExtra(str, arrayList);
        } catch (Throwable th) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent setAction(String str) {
        try {
            return super.setAction(str);
        } catch (Throwable th) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent setPackage(String str) {
        try {
            return super.setPackage(str);
        } catch (Throwable th) {
            return this;
        }
    }

    @Override // android.content.Intent
    public void setSelector(Intent intent) {
        try {
            super.setSelector(intent);
        } catch (Throwable th) {
            ge.I(Code, "setSelector: " + th.getClass().getSimpleName());
        }
    }

    @Override // android.content.Intent
    @Deprecated
    public String toURI() {
        try {
            return super.toURI();
        } catch (Throwable th) {
            ge.I(Code, "toURI: exception " + th.getClass().getSimpleName());
            return "";
        }
    }

    @Override // android.content.Intent
    public String toUri(int i) {
        try {
            return super.toUri(i);
        } catch (Throwable th) {
            ge.I(Code, "toUri: " + th.getClass().getSimpleName());
            return "";
        }
    }
}
