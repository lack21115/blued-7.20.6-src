package com.soft.blued.ui.find.manager;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.R;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/FilterHelper.class */
public class FilterHelper {
    private static FilterHelper i;

    /* renamed from: a  reason: collision with root package name */
    private String[] f16901a;
    private String[] b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f16902c;
    private boolean d;
    private String e;
    private String f;
    private String g;
    private String h;

    private FilterHelper() {
        o();
    }

    public static FilterHelper d() {
        if (i == null) {
            synchronized (FilterHelper.class) {
                try {
                    if (i == null) {
                        i = new FilterHelper();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return i;
    }

    private void o() {
        int aF = BluedPreferences.aF();
        if (aF == 1) {
            this.d = false;
        } else if (aF == 2) {
            this.d = true;
        }
        this.f16901a = AppInfo.d().getResources().getStringArray(R.array.age_array_key_all);
        if (this.d) {
            this.b = AppInfo.d().getResources().getStringArray(R.array.inch_height_list_all);
            this.f16902c = StringUtils.a(AppInfo.d());
        } else {
            this.b = AppInfo.d().getResources().getStringArray(R.array.height_array_key_all);
            this.f16902c = AppInfo.d().getResources().getStringArray(R.array.weight_key_all);
        }
        this.e = AppInfo.d().getResources().getString(R.string.unlimited);
        this.f = AppInfo.d().getResources().getString(R.string.less_than);
        this.g = AppInfo.d().getResources().getString(R.string.greater_than);
        this.h = AppInfo.d().getResources().getString(R.string.greater_than_equal);
    }

    public String a(String str) {
        String str2;
        String str3;
        String string = AppInfo.d().getResources().getString(R.string.old);
        if (StringUtils.d(str) || str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER).length != 2) {
            return this.e;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        String[] strArr = this.f16901a;
        if (parseInt > strArr.length - 1 || parseInt2 > strArr.length - 1) {
            try {
                String str4 = this.f16901a[0];
                String str5 = "";
                try {
                    String str6 = this.f16901a[this.f16901a.length - 1];
                    StringBuilder sb = new StringBuilder();
                    sb.append("0-");
                    sb.append(this.f16901a.length - 1);
                    str5 = str6;
                    BluedPreferences.l(sb.toString());
                    str5 = str6;
                } catch (Exception e) {
                }
                String str7 = str5;
                str3 = str4;
                str2 = str7;
            } catch (Exception e2) {
                str2 = "";
                str3 = "";
            }
        } else {
            str3 = strArr[parseInt];
            str2 = strArr[parseInt2];
        }
        if (str3.equals(this.e) && str2.equals(this.e)) {
            StringBuilder sb2 = new StringBuilder();
            String[] strArr2 = this.f16901a;
            sb2.append(strArr2[strArr2.length - 2]);
            sb2.append(string);
            return sb2.toString();
        } else if (str3.equals(this.e)) {
            return this.f + str2 + string;
        } else if (str2.equals(this.e)) {
            if (parseInt == 0) {
                return this.h + str3 + string;
            }
            return this.g + str3 + string;
        } else if (str3.equals(str2)) {
            return str3 + string;
        } else {
            return str3 + " ～ " + str2 + string;
        }
    }

    public String[] a() {
        return this.f16901a;
    }

    public String b(String str) {
        String str2;
        String str3;
        String string = this.d ? "" : AppInfo.d().getResources().getString(R.string.cm);
        if (StringUtils.d(str) || str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER).length != 2) {
            return this.e;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        String[] strArr = this.b;
        if (parseInt > strArr.length - 1 || parseInt2 > strArr.length - 1) {
            String[] strArr2 = this.b;
            str2 = strArr2[0];
            str3 = strArr2[strArr2.length - 1];
        } else {
            str2 = strArr[parseInt];
            str3 = strArr[parseInt2];
        }
        if (parseInt == 0 && parseInt2 == 0) {
            return this.b[1] + string;
        }
        String[] strArr3 = this.b;
        if (parseInt == strArr3.length - 1 && parseInt2 == strArr3.length - 1) {
            StringBuilder sb = new StringBuilder();
            String[] strArr4 = this.b;
            sb.append(strArr4[strArr4.length - 2]);
            sb.append(string);
            return sb.toString();
        } else if (str2.equals(this.e) && str3.equals(this.e)) {
            return this.e;
        } else {
            if (str2.equals(this.e)) {
                return this.f + str3 + string;
            } else if (str3.equals(this.e)) {
                return this.g + str2 + string;
            } else if (str2.equals(str3)) {
                return str2 + string;
            } else {
                return str2 + " ～ " + str3 + string;
            }
        }
    }

    public String[] b() {
        return this.b;
    }

    public String c(String str) {
        String str2;
        String str3;
        String string = this.d ? AppInfo.d().getResources().getString(R.string.lbs) : AppInfo.d().getResources().getString(R.string.kg);
        if (StringUtils.d(str) || str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER).length != 2) {
            return this.e;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        int intValue = Integer.valueOf(split[0]).intValue();
        int intValue2 = Integer.valueOf(split[1]).intValue();
        String[] strArr = this.f16902c;
        if (intValue > strArr.length - 1 || intValue2 > strArr.length - 1) {
            String[] strArr2 = this.f16902c;
            str2 = strArr2[0];
            str3 = strArr2[strArr2.length - 1];
        } else {
            str2 = strArr[intValue];
            str3 = strArr[intValue2];
        }
        if (intValue == 0 && intValue2 == 0) {
            return this.f16902c[1] + string;
        }
        String[] strArr3 = this.f16902c;
        if (intValue == strArr3.length - 1 && intValue2 == strArr3.length - 1) {
            StringBuilder sb = new StringBuilder();
            String[] strArr4 = this.f16902c;
            sb.append(strArr4[strArr4.length - 2]);
            sb.append(string);
            return sb.toString();
        } else if (str2.equals(this.e) && str3.equals(this.e)) {
            return this.e;
        } else {
            if (str2.equals(this.e)) {
                return this.f + str3 + string;
            } else if (str3.equals(this.e)) {
                return this.g + str2 + string;
            } else if (str2.equals(str3)) {
                return str2 + string;
            } else {
                return str2 + " ～ " + str3 + string;
            }
        }
    }

    public String[] c() {
        return this.f16902c;
    }

    public void e() {
        i = null;
    }

    public void f() {
        i = null;
    }

    public boolean g() {
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0 || BluedConfig.a().g().is_filter_vip == 1) {
            return BluedPreferences.S();
        }
        return false;
    }

    public boolean h() {
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0 || BluedConfig.a().g().is_filter_vip == 1) {
            return BluedPreferences.Y();
        }
        return false;
    }

    public boolean i() {
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0 || BluedConfig.a().g().is_filter_vip == 1) {
            String aa = BluedPreferences.aa();
            boolean z = false;
            if (!TextUtils.isEmpty(aa)) {
                z = false;
                if (!aa.equals("0-max")) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    public boolean j() {
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0 || BluedConfig.a().g().is_filter_vip == 1) {
            String Z = BluedPreferences.Z();
            boolean z = false;
            if (!TextUtils.isEmpty(Z)) {
                z = false;
                if (!Z.equals("0-max")) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    public boolean k() {
        String K = BluedPreferences.K();
        if (TextUtils.isEmpty(K)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0-");
        sb.append(this.f16901a.length - 1);
        return !K.equals(sb.toString());
    }

    public boolean l() {
        String M = this.d ? BluedPreferences.M() : BluedPreferences.L();
        if (TextUtils.isEmpty(M)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0-");
        sb.append(this.b.length - 1);
        return !M.equals(sb.toString());
    }

    public boolean m() {
        String O = this.d ? BluedPreferences.O() : BluedPreferences.N();
        if (TextUtils.isEmpty(O)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0-");
        sb.append(this.f16902c.length - 1);
        return !O.equals(sb.toString());
    }

    public boolean n() {
        return !TextUtils.isEmpty(BluedPreferences.T()) || !TextUtils.isEmpty(BluedPreferences.X()) || !TextUtils.isEmpty(BluedPreferences.W()) || m() || l() || k() || !TextUtils.isEmpty(BluedPreferences.I()) || BluedPreferences.R() || BluedPreferences.P() || i() || j() || h() || g();
    }
}
