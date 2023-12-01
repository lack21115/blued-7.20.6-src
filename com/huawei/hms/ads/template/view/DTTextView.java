package com.huawei.hms.ads.template.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.huawei.hms.ads.cc;
import com.huawei.hms.ads.ch;
import com.huawei.hms.ads.ci;
import com.huawei.hms.ads.cl;
import com.huawei.hms.ads.cm;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.co;
import com.huawei.hms.ads.cx;
import com.huawei.hms.ads.cy;
import com.huawei.hms.ads.cz;
import com.huawei.hms.ads.da;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.dc;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/template/view/DTTextView.class */
public class DTTextView extends TextView implements a {
    private cc Code;

    public DTTextView(Context context) {
        super(context);
    }

    public DTTextView(Context context, AttributeSet attributeSet) {
        this(context);
        if (attributeSet != null) {
            cc ccVar = new cc(this);
            this.Code = ccVar;
            ccVar.Code((ci) new da(this));
            this.Code.Code((ci) new cm(this));
            this.Code.Code((ci) new ch(this));
            this.Code.Code((ci) new cl(this));
            this.Code.Code((ci) new cx(this));
            this.Code.Code((ci) new cy(this));
            this.Code.Code((ci) new db(this));
            this.Code.Code((ci) new cz(this));
            this.Code.Code((ci) new dc(this));
            this.Code.Code((ci) new cn(this));
            this.Code.Code((ci) new co(this));
            this.Code.Code(attributeSet);
        }
    }

    @Override // com.huawei.hms.ads.template.view.a
    public void Code(JSONObject jSONObject) {
        cc ccVar = this.Code;
        if (ccVar != null) {
            ccVar.Code(jSONObject);
        }
    }
}
