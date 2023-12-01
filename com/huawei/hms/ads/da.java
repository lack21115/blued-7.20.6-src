package com.huawei.hms.ads;

import android.widget.TextView;
import com.huawei.hms.ads.template.DTManager;
import com.huawei.hms.ads.template.util.b;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/da.class */
public class da extends cw<TextView> {
    private String I;

    public da(TextView textView) {
        super(textView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.huawei.hms.ads.cw
    public String Code() {
        return "text";
    }

    @Override // com.huawei.hms.ads.ci
    public void Code(String str, String str2) {
        String str3;
        TextView textView;
        String decode;
        String I = com.huawei.hms.ads.template.util.a.I(str2);
        this.I = I;
        if (I == null) {
            try {
                if (str2.startsWith("@strings/")) {
                    decode = b.V(((TextView) this.Code).getContext(), str2);
                    textView = (TextView) this.Code;
                } else {
                    textView = (TextView) this.Code;
                    decode = URLDecoder.decode(str2, "UTF-8");
                }
                textView.setText(decode);
            } catch (UnsupportedEncodingException e) {
                str3 = "parse UnsupportedEncodingException";
                ge.I("TextHandler", str3);
            } catch (Exception e2) {
                str3 = "parse " + e2.getClass().getSimpleName();
                ge.I("TextHandler", str3);
            }
        }
    }

    @Override // com.huawei.hms.ads.cw, com.huawei.hms.ads.ce
    public void Code(JSONObject jSONObject) {
        StringBuilder sb;
        String simpleName;
        String sb2;
        if (this.I == null || jSONObject == null) {
            return;
        }
        try {
            String Code = DTManager.getInstance().Code(this.I, jSONObject);
            ((TextView) this.Code).setText(Code == null ? "" : URLDecoder.decode(Code, "UTF-8"));
        } catch (com.huawei.hms.ads.template.b e) {
            sb2 = "bindData PlacementParseException";
            ge.I("TextHandler", sb2);
        } catch (JSONException e2) {
            sb = new StringBuilder();
            sb.append("bindData json exception: ");
            simpleName = e2.getMessage();
            sb.append(simpleName);
            sb2 = sb.toString();
            ge.I("TextHandler", sb2);
        } catch (Exception e3) {
            sb = new StringBuilder();
            sb.append("bindData ");
            simpleName = e3.getClass().getSimpleName();
            sb.append(simpleName);
            sb2 = sb.toString();
            ge.I("TextHandler", sb2);
        }
    }
}
