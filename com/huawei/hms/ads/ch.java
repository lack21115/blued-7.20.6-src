package com.huawei.hms.ads;

import android.text.TextUtils;
import android.widget.TextView;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ch.class */
public class ch extends cw<TextView> {
    public ch(TextView textView) {
        super(textView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.hms.ads.cw
    public String Code() {
        return "ellipsize";
    }

    @Override // com.huawei.hms.ads.ci
    public void Code(String str, String str2) {
        TextView textView;
        TextUtils.TruncateAt truncateAt;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        boolean z = true;
        switch (str2.hashCode()) {
            case -1074341483:
                if (str2.equals("middle")) {
                    z = true;
                    break;
                }
                break;
            case 100571:
                if (str2.equals("end")) {
                    z = false;
                    break;
                }
                break;
            case 109757538:
                if (str2.equals("start")) {
                    z = true;
                    break;
                }
                break;
            case 839444514:
                if (str2.equals("marquee")) {
                    z = true;
                    break;
                }
                break;
        }
        if (!z) {
            textView = (TextView) this.Code;
            truncateAt = TextUtils.TruncateAt.END;
        } else if (z) {
            textView = (TextView) this.Code;
            truncateAt = TextUtils.TruncateAt.MARQUEE;
        } else if (z) {
            textView = (TextView) this.Code;
            truncateAt = TextUtils.TruncateAt.MIDDLE;
        } else if (!z) {
            return;
        } else {
            textView = (TextView) this.Code;
            truncateAt = TextUtils.TruncateAt.START;
        }
        textView.setEllipsize(truncateAt);
    }
}
