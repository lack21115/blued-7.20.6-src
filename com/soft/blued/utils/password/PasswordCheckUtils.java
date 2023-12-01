package com.soft.blued.utils.password;

import android.content.Context;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.framework.utils.DelayRepeatTaskUtils;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.soft.blued.R;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.StringUtils;
import com.tencent.ugc.datereport.UGCDataReportDef;
import com.xiaomi.mipush.sdk.Constants;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/password/PasswordCheckUtils.class */
public class PasswordCheckUtils {

    /* renamed from: a  reason: collision with root package name */
    private static PasswordCheckUtils f21130a;
    private CheckCallBackListener b;

    /* renamed from: c  reason: collision with root package name */
    private String f21131c;
    private String d;
    private String e;
    private String f;
    private String g;
    private Context h;
    private int i;
    private IRequestHost j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.utils.password.PasswordCheckUtils$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/password/PasswordCheckUtils$2.class */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21134a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[PWD_CHECK_PAGE.values().length];
            f21134a = iArr;
            try {
                iArr[PWD_CHECK_PAGE.MODIFY_PWD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21134a[PWD_CHECK_PAGE.REGISTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/password/PasswordCheckUtils$CLIENT_FORBIDDEN_RESULT.class */
    interface CLIENT_FORBIDDEN_RESULT {
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/password/PasswordCheckUtils$CheckCallBackListener.class */
    public interface CheckCallBackListener {
        void a();

        void a(int i, String str);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/password/PasswordCheckUtils$PASSWORD_LVL.class */
    public interface PASSWORD_LVL {
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/password/PasswordCheckUtils$PWD_CHECK_PAGE.class */
    public enum PWD_CHECK_PAGE {
        REGISTER,
        MODIFY_PWD
    }

    private PasswordCheckUtils() {
    }

    private BluedUIHttpResponse a(final PWD_CHECK_PAGE pwd_check_page) {
        return new BluedUIHttpResponse<BluedEntityA<PasswordCheckResultModel>>(this.j) { // from class: com.soft.blued.utils.password.PasswordCheckUtils.1

            /* renamed from: a  reason: collision with root package name */
            int f21132a;
            String b;

            /* renamed from: c  reason: collision with root package name */
            boolean f21133c;

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public BluedEntityA<PasswordCheckResultModel> parseData(String str) {
                int i = AnonymousClass2.f21134a[pwd_check_page.ordinal()];
                BluedEntityA<PasswordCheckResultModel> parseData = super.parseData(str);
                if (parseData != null) {
                    try {
                        if (parseData.data != null && parseData.data.size() > 0) {
                            parseData.data.set(0, (PasswordCheckResultModel) AppInfo.f().fromJson(AesCrypto2.a(((PasswordCheckResultModel) parseData.data.get(0)).encrypted), (Class<Object>) PasswordCheckResultModel.class));
                            return parseData;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.f21133c = true;
                    }
                }
                return parseData;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PasswordCheckResultModel> bluedEntityA) {
                if (PasswordCheckUtils.this.b != null) {
                    if (bluedEntityA == null || !bluedEntityA.hasData()) {
                        this.f21132a = 20;
                        return;
                    }
                    PasswordCheckResultModel passwordCheckResultModel = (PasswordCheckResultModel) bluedEntityA.data.get(0);
                    if (StringUtils.d(passwordCheckResultModel.password)) {
                        this.f21132a = 20;
                        this.b = PasswordCheckUtils.this.f;
                        return;
                    }
                    this.f21132a = passwordCheckResultModel.getStrength_level();
                    this.b = passwordCheckResultModel.password;
                }
            }

            public boolean onUIFailure(int i, String str) {
                this.f21133c = true;
                this.f21132a = 20;
                return true;
            }

            public void onUIFinish() {
                super.onUIFinish();
                if ((this.f21133c || PasswordCheckUtils.this.f.equals(this.b)) && PasswordCheckUtils.this.b != null) {
                    int min = Math.min(this.f21132a, PasswordCheckUtils.this.i);
                    if (min == 0) {
                        PasswordCheckUtils.this.b.a(min, PasswordCheckUtils.this.h.getString(R.string.pwd_server_forbidden));
                    } else if (min == 10) {
                        PasswordCheckUtils.this.b.a(min, PasswordCheckUtils.this.h.getString(R.string.pwd_weak));
                    } else if (min != 20) {
                        PasswordCheckUtils.this.b.a(min, PasswordCheckUtils.this.h.getString(R.string.pwd_regular));
                    } else {
                        PasswordCheckUtils.this.b.a(min, PasswordCheckUtils.this.h.getString(R.string.pwd_strong));
                    }
                }
            }
        };
    }

    public static PasswordCheckUtils a() {
        PasswordCheckUtils passwordCheckUtils;
        synchronized (PasswordCheckUtils.class) {
            try {
                if (f21130a == null) {
                    f21130a = new PasswordCheckUtils();
                }
                passwordCheckUtils = f21130a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return passwordCheckUtils;
    }

    private String a(String str) {
        String str2 = str;
        if (str != null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("@")) {
                String[] split = str.split("@");
                if (split.length > 0) {
                    return split[0];
                }
            }
            str2 = str;
            if (str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                String[] split2 = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                str2 = str;
                if (split2.length >= 1) {
                    str2 = split2[1];
                }
            }
        }
        return str2;
    }

    private boolean a(String str, String str2) {
        return Pattern.compile(str).matcher(str2).matches();
    }

    private void b(PWD_CHECK_PAGE pwd_check_page) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("token", this.g);
        arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, DeviceUtils.g());
        arrayMap.put("type", "mobile");
        arrayMap.put("stage", "strength");
        arrayMap.put("password", this.f);
        arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
        arrayMap.put("dev_dna_label", BluedDeviceIdentity.a().e());
        arrayMap.put("smid", BluedDeviceIdentity.a().f());
        arrayMap.put("boxid", BluedDeviceIdentity.a().g());
        Map a2 = BluedHttpTools.a();
        try {
            a2.put("_", AesCrypto2.b(AppInfo.f().toJson(arrayMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/identity", a(pwd_check_page), this.j).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, String str2, PWD_CHECK_PAGE pwd_check_page) {
        String str3 = str;
        if (str == null) {
            str3 = "";
        }
        this.e = str3;
        try {
            this.f = BluedHttpTools.b(str3);
        } catch (NoSuchAlgorithmException e) {
            this.f = "";
        }
        this.g = str2;
        CheckCallBackListener checkCallBackListener = this.b;
        if (checkCallBackListener != null) {
            checkCallBackListener.a();
            int c2 = c();
            if (c2 == 1) {
                this.i = 0;
                this.b.a(0, this.h.getResources().getString(R.string.pwd_same_with_account));
            } else if (c2 == 2) {
                this.i = 0;
                this.b.a(0, this.h.getResources().getString(R.string.pwd_same_with_name));
            } else if (c2 == 3) {
                this.i = 0;
                this.b.a(0, this.h.getResources().getString(R.string.pwd_less_than_8));
            } else if (c2 == 4) {
                this.i = 0;
                this.b.a(0, this.h.getResources().getString(2131890456));
            } else {
                if (b()) {
                    this.i = 20;
                }
                if (pwd_check_page == PWD_CHECK_PAGE.REGISTER) {
                    b(pwd_check_page);
                } else {
                    c(pwd_check_page);
                }
            }
        }
    }

    private boolean b() {
        String str = this.e;
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("(?=^.{8,}$)(?=(?:.*?\\d){1})(?=.*[a-z])(?=(?:.*?[A-Z]){1})(?=(?:.*?[`~!@#$%^&*()_+=\\-\\\\\\[\\]{}'\";:/?.>,<|]){1})(?!.*\\s)[0-9a-zA-Z`~!@#$%^&*()_+=\\-\\\\\\[\\]{}'\";:/?.>,<|]*$").matcher(this.e).find();
    }

    private boolean b(String str) {
        return a("(?=(?:.*?[0-9]))(?=(?:.*?[a-zA-Z]))[0-9a-zA-Z`~!@#$%^&*()_+=\\-\\\\\\[\\]{}'\";:/?.>,<|]*", str) || a("(?=(?:.*?[0-9]))(?=(?:.*?[`~!@#$%^&*()_+=\\-\\\\\\[\\]{}'\";:/?.>,<|]))[0-9a-zA-Z`~!@#$%^&*()_+=\\-\\\\\\[\\]{}'\";:/?.>,<|]*", str) || a("(?=(?:.*?[`~!@#$%^&*()_+=\\-\\\\\\[\\]{}'\";:/?.>,<|]))(?=(?:.*?[a-zA-Z]))[0-9a-zA-Z`~!@#$%^&*()_+=\\-\\\\\\[\\]{}'\";:/?.>,<|]*", str);
    }

    private int c() {
        String str = this.e;
        if (str == null || TextUtils.isEmpty(str) || this.e.length() < 8) {
            return 3;
        }
        if (b(this.e)) {
            this.i = 15;
            if (this.e.equals(this.d)) {
                return 2;
            }
            String str2 = this.f21131c;
            if (str2 != null) {
                return (str2.equals(this.e) || a(this.f21131c).equals(this.e)) ? 1 : 0;
            }
            return 0;
        }
        return 4;
    }

    private void c(PWD_CHECK_PAGE pwd_check_page) {
        Map a2 = BluedHttpTools.a();
        a2.put("stage", "strength");
        a2.put("passwd", this.f);
        Map a3 = BluedHttpTools.a();
        try {
            a3.put("_", AesCrypto2.b(AppInfo.f().toJson(a2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(BluedHttpUrl.q() + "/passport/passwd/reset", a(pwd_check_page), this.j).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a3)).h();
    }

    public void a(Context context, String str, String str2) {
        PasswordCheckUtils passwordCheckUtils = f21130a;
        passwordCheckUtils.f21131c = str;
        passwordCheckUtils.d = str2;
        this.h = context;
    }

    public void a(CheckCallBackListener checkCallBackListener, IRequestHost iRequestHost) {
        PasswordCheckUtils passwordCheckUtils = f21130a;
        passwordCheckUtils.b = checkCallBackListener;
        passwordCheckUtils.j = iRequestHost;
    }

    public void a(final String str, final String str2, final PWD_CHECK_PAGE pwd_check_page) {
        DelayRepeatTaskUtils.a("check_pwd_lvl", new Runnable() { // from class: com.soft.blued.utils.password.-$$Lambda$PasswordCheckUtils$C0g-Xlj0V4KtYdJGIp8qhvk3-ao
            @Override // java.lang.Runnable
            public final void run() {
                PasswordCheckUtils.this.b(str, str2, pwd_check_page);
            }
        }, 500);
    }
}
