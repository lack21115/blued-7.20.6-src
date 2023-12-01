package com.soft.blued.ui.user.model;

import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.alipay.sdk.util.l;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/AliPayResult.class */
public class AliPayResult {
    private String memo;
    private String result;
    private String resultStatus;

    public AliPayResult(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (String str : map.keySet()) {
            if (TextUtils.equals(str, l.f4671a)) {
                this.resultStatus = map.get(str);
            } else if (TextUtils.equals(str, "result")) {
                this.result = map.get(str);
            } else if (TextUtils.equals(str, l.b)) {
                this.memo = map.get(str);
            }
        }
    }

    public String getMemo() {
        return this.memo;
    }

    public String getResult() {
        return this.result;
    }

    public String getResultStatus() {
        return this.resultStatus;
    }

    public String toString() {
        return "resultStatus={" + this.resultStatus + "};memo={" + this.memo + "};result={" + this.result + i.d;
    }
}
