package mtopsdk.mtop.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.util.ErrorConstant;
import mtopsdk.mtop.util.MtopStatistics;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/domain/MtopResponse.class */
public class MtopResponse implements Serializable, IMTOPDataObject {
    private static final long serialVersionUID = 1566423746968673499L;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f43748c;
    private String d;
    private String e;
    private String[] f;
    private JSONObject g;
    private byte[] h;
    private Map i;
    private int j;
    private MtopStatistics k;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f43747a = false;
    private ResponseSource l = ResponseSource.NETWORK_REQUEST;

    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/domain/MtopResponse$ResponseSource.class */
    public enum ResponseSource {
        FRESH_CACHE,
        EXPIRED_CACHE,
        NETWORK_REQUEST
    }

    public MtopResponse() {
    }

    public MtopResponse(String str, String str2) {
        this.b = str;
        this.f43748c = str2;
    }

    public MtopResponse(String str, String str2, String str3, String str4) {
        this.d = str;
        this.e = str2;
        this.b = str3;
        this.f43748c = str4;
    }

    private void a(String[] strArr) {
        String[] split;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String str = strArr[0];
        if (!StringUtils.a(str) || (split = str.split("::")) == null || split.length <= 1) {
            return;
        }
        this.b = split[0];
        this.f43748c = split[1];
    }

    public String a() {
        return this.b;
    }

    public void a(int i) {
        this.j = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(Map map) {
        this.i = map;
    }

    public void a(MtopStatistics mtopStatistics) {
        this.k = mtopStatistics;
    }

    public void a(byte[] bArr) {
        this.h = bArr;
    }

    public String b() {
        if (this.d == null && !this.f43747a) {
            h();
        }
        return this.d;
    }

    public void b(String str) {
        this.f43748c = str;
    }

    public String c() {
        if (this.e == null && !this.f43747a) {
            h();
        }
        return this.e;
    }

    public void c(String str) {
        this.d = str;
    }

    public void d(String str) {
        this.e = str;
    }

    public byte[] d() {
        return this.h;
    }

    public Map e() {
        return this.i;
    }

    public int f() {
        return this.j;
    }

    public MtopStatistics g() {
        return this.k;
    }

    public void h() {
        if (this.f43747a) {
            return;
        }
        synchronized (this) {
            if (this.f43747a) {
                return;
            }
            if (this.h == null || this.h.length == 0) {
                if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
                    TBSdkLog.c("mtopsdk.MtopResponse", "[parseJsonByte]bytedata is blank ---api=" + this.d + ",v=" + this.e);
                }
                this.b = "ANDROID_SYS_JSONDATA_BLANK";
                this.f43748c = "返回JSONDATA为空";
                this.f43747a = true;
                return;
            }
            String str = new String(this.h);
            if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.a("mtopsdk.MtopResponse", "[parseJsonByte]response : " + str);
            }
            JSONObject jSONObject = new JSONObject(str);
            if (this.d == null) {
                this.d = jSONObject.getString("api");
            }
            if (this.e == null) {
                this.e = jSONObject.getString("v");
            }
            JSONArray jSONArray = jSONObject.getJSONArray("ret");
            int length = jSONArray.length();
            this.f = new String[length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    a(this.f);
                    this.g = jSONObject.optJSONObject("data");
                    this.f43747a = true;
                    return;
                }
                this.f[i2] = jSONArray.getString(i2);
                i = i2 + 1;
            }
        }
    }

    public boolean i() {
        return ErrorConstant.g(a()) && d() != null;
    }

    public boolean j() {
        return ErrorConstant.j(a());
    }

    public boolean k() {
        return ErrorConstant.c(a());
    }

    public boolean l() {
        return ErrorConstant.e(a());
    }

    public boolean m() {
        return ErrorConstant.f(a());
    }

    public boolean n() {
        return ErrorConstant.h(a());
    }

    public boolean o() {
        return ErrorConstant.i(a());
    }

    public boolean p() {
        return ErrorConstant.d(a());
    }

    public boolean q() {
        return ErrorConstant.k(a());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MtopResponse");
        try {
            sb.append("[api=");
            sb.append(this.d);
            sb.append(",v=");
            sb.append(this.e);
            sb.append(",responseCode=");
            sb.append(this.j);
            sb.append(",headerFields=");
            sb.append(this.i);
            sb.append(",retCode=");
            sb.append(this.b);
            sb.append(",retMsg=");
            sb.append(this.f43748c);
            sb.append(",ret=");
            sb.append(Arrays.toString(this.f));
            sb.append(",data=");
            sb.append(this.g);
            sb.append(",bytedata=");
            sb.append(this.h == null ? null : new String(this.h));
            sb.append("]");
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return super.toString();
        }
    }
}
