package com.umeng.commonsdk.statistics.noise;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.d;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/noise/ABTest.class */
public class ABTest implements d {
    private static ABTest instance;
    private Context context;
    private boolean isInTest = false;
    private int mPolicy = -1;
    private int mInterval = -1;
    private int mGroup = -1;
    private float mProb13 = 0.0f;
    private float mProb07 = 0.0f;
    private String mPoli = null;

    private ABTest(Context context, String str, int i) {
        this.context = null;
        this.context = context;
        onExperimentChanged(str, i);
    }

    public static ABTest getService(Context context) {
        ABTest aBTest;
        synchronized (ABTest.class) {
            try {
                if (instance == null) {
                    instance = new ABTest(context, UMEnvelopeBuild.imprintProperty(context, "client_test", null), Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "test_report_interval", "0")).intValue());
                }
                aBTest = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aBTest;
    }

    private void parseFIXED(String str) {
        if (str == null) {
            return;
        }
        String[] split = str.split("\\|");
        float f = 0.0f;
        if (split[2].equals("SIG13")) {
            f = Float.valueOf(split[3]).floatValue();
        }
        if (this.mProb13 > f) {
            this.isInTest = false;
            return;
        }
        int intValue = split[0].equals("FIXED") ? Integer.valueOf(split[1]).intValue() : -1;
        int[] iArr = null;
        if (split[4].equals("RPT")) {
            this.mPoli = "RPT";
            String[] split2 = split[5].split(",");
            int[] iArr2 = new int[split2.length];
            int i = 0;
            while (true) {
                int i2 = i;
                iArr = iArr2;
                if (i2 >= split2.length) {
                    break;
                }
                iArr2[i2] = Integer.valueOf(split2[i2]).intValue();
                i = i2 + 1;
            }
        } else if (split[4].equals("DOM")) {
            this.mPoli = "DOM";
            this.isInTest = true;
            int[] iArr3 = null;
            try {
                String[] split3 = split[5].split(",");
                int[] iArr4 = new int[split3.length];
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    iArr = iArr4;
                    iArr3 = iArr4;
                    if (i4 >= split3.length) {
                        break;
                    }
                    iArr4[i4] = Integer.valueOf(split3[i4]).intValue();
                    i3 = i4 + 1;
                }
            } catch (Exception e) {
                iArr = iArr3;
            }
        }
        if (intValue == -1) {
            this.isInTest = false;
            return;
        }
        this.isInTest = true;
        this.mGroup = intValue;
        if (iArr != null) {
            this.mPolicy = iArr[intValue - 1];
        }
    }

    private void parseSig7(String str) {
        float[] fArr;
        if (str == null) {
            return;
        }
        String[] split = str.split("\\|");
        if (this.mProb13 > (split[2].equals("SIG13") ? Float.valueOf(split[3]).floatValue() : 0.0f)) {
            this.isInTest = false;
            return;
        }
        int[] iArr = null;
        if (split[0].equals("SIG7")) {
            String[] split2 = split[1].split(",");
            float[] fArr2 = new float[split2.length];
            int i = 0;
            while (true) {
                int i2 = i;
                fArr = fArr2;
                if (i2 >= split2.length) {
                    break;
                }
                fArr2[i2] = Float.valueOf(split2[i2]).floatValue();
                i = i2 + 1;
            }
        } else {
            fArr = null;
        }
        if (split[4].equals("RPT")) {
            this.mPoli = "RPT";
            String[] split3 = split[5].split(",");
            int[] iArr2 = new int[split3.length];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                iArr = iArr2;
                if (i4 >= split3.length) {
                    break;
                }
                iArr2[i4] = Integer.valueOf(split3[i4]).intValue();
                i3 = i4 + 1;
            }
        } else if (split[4].equals("DOM")) {
            this.isInTest = true;
            this.mPoli = "DOM";
            int[] iArr3 = null;
            try {
                String[] split4 = split[5].split(",");
                int[] iArr4 = new int[split4.length];
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    iArr = iArr4;
                    iArr3 = iArr4;
                    if (i6 >= split4.length) {
                        break;
                    }
                    iArr4[i6] = Integer.valueOf(split4[i6]).intValue();
                    i5 = i6 + 1;
                }
            } catch (Exception e) {
                iArr = iArr3;
            }
        }
        int i7 = 0;
        float f = 0.0f;
        while (true) {
            if (i7 >= fArr.length) {
                i7 = -1;
                break;
            }
            f += fArr[i7];
            if (this.mProb07 < f) {
                break;
            }
            i7++;
        }
        if (i7 == -1) {
            this.isInTest = false;
            return;
        }
        this.isInTest = true;
        this.mGroup = i7 + 1;
        if (iArr != null) {
            this.mPolicy = iArr[i7];
        }
    }

    private float prob(String str, int i) {
        int i2 = i * 2;
        if (str == null) {
            return 0.0f;
        }
        return Integer.valueOf(str.substring(i2, i2 + 5), 16).intValue() / 1048576.0f;
    }

    public static boolean validate(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split("\\|");
        if (split.length != 6) {
            return false;
        }
        if (split[0].startsWith("SIG7") && split[1].split(",").length == split[5].split(",").length) {
            return true;
        }
        if (split[0].startsWith("FIXED")) {
            int length = split[5].split(",").length;
            int parseInt = Integer.parseInt(split[1]);
            return length >= parseInt && parseInt >= 1;
        }
        return false;
    }

    public int getGroup() {
        return this.mGroup;
    }

    public String getGroupInfo() {
        return !this.isInTest ? "error" : String.valueOf(this.mGroup);
    }

    public int getTestInterval() {
        return this.mInterval;
    }

    public String getTestName() {
        return this.mPoli;
    }

    public int getTestPolicy() {
        return this.mPolicy;
    }

    public boolean isInTest() {
        return this.isInTest;
    }

    public void onExperimentChanged(String str, int i) {
        this.mInterval = i;
        String signature = Envelope.getSignature(this.context);
        if (TextUtils.isEmpty(signature) || TextUtils.isEmpty(str)) {
            this.isInTest = false;
            return;
        }
        try {
            this.mProb13 = prob(signature, 12);
            this.mProb07 = prob(signature, 6);
            if (str.startsWith("SIG7")) {
                parseSig7(str);
            } else if (str.startsWith("FIXED")) {
                parseFIXED(str);
            }
        } catch (Exception e) {
            this.isInTest = false;
            MLog.e("v:" + str, e);
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.d
    public void onImprintChanged(ImprintHandler.a aVar) {
        onExperimentChanged(aVar.a("client_test", null), Integer.valueOf(aVar.a("test_report_interval", "0")).intValue());
    }

    public String toString() {
        return " p13:" + this.mProb13 + " p07:" + this.mProb07 + " policy:" + this.mPolicy + " interval:" + this.mInterval;
    }
}
