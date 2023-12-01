package com.huawei.openalliance.ad.compliance;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.gb;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.utils.y;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/compliance/ComplianceView.class */
public class ComplianceView extends PPSBaseDialogContentView {
    private static final String e = "ComplianceView";
    private static String m = ", ";
    private View f;
    private TextView g;
    private RelativeLayout h;
    private AdContentData i;
    private TextView j;
    private gb k;
    private ImageView l;

    public ComplianceView(Context context) {
        super(context);
    }

    public ComplianceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ComplianceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void B() {
        TextView textView;
        if (!v.c(getContext()) || (textView = this.g) == null || this.j == null) {
            return;
        }
        textView.setTextSize(1, 28.0f);
        this.j.setTextSize(1, 28.0f);
    }

    private void I() {
        if (this.f == null || this.h == null) {
            ge.V(e, "partingLine or whyThisAdClick view not init");
        } else if (this.f23014c != null && !this.f23014c.booleanValue()) {
            ge.V(e, "not need show why this ad");
        } else {
            this.f.setVisibility(0);
            this.h.setVisibility(0);
            this.h.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.compliance.ComplianceView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (ComplianceView.this.i != null) {
                        v.Code(ComplianceView.this.getContext(), ComplianceView.this.i.W());
                        if (ComplianceView.this.k != null) {
                            ComplianceView.this.k.Code();
                        }
                    }
                }
            });
        }
    }

    private void Z() {
        String value;
        AdContentData adContentData = this.i;
        if (adContentData != null) {
            List<AdvertiserInfo> aG = adContentData.aG();
            StringBuffer stringBuffer = new StringBuffer();
            if (aa.Code(aG)) {
                ge.V(e, "complianceInfo is null");
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aG.size()) {
                    break;
                }
                if (i2 != aG.size() - 1) {
                    stringBuffer.append(aG.get(i2).getValue());
                    value = m;
                } else {
                    value = aG.get(i2).getValue();
                }
                stringBuffer.append(value);
                i = i2 + 1;
            }
            TextView textView = this.g;
            if (textView != null) {
                textView.setText(stringBuffer);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void Code() {
        try {
            ge.V(e, "adapterView mFeedbackViewPaddingLeft = %s, mFeedbackViewPaddingRight= %s", Integer.valueOf(this.f23013a), Integer.valueOf(this.b));
            if (V()) {
                this.V.setPadding(this.f23013a, 0, this.b, 0);
                this.V.requestLayout();
                this.V.getViewTreeObserver().addOnGlobalLayoutListener(this.d);
            }
        } catch (Throwable th) {
            ge.I(e, "adapterView error, %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void Code(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.hiad_compliance_choice_view, this);
        this.V = inflate.findViewById(R.id.compliance_view_root);
        this.f = inflate.findViewById(R.id.why_this_ad_line);
        this.g = (TextView) inflate.findViewById(R.id.compliance_info);
        this.h = (RelativeLayout) inflate.findViewById(R.id.why_this_ad_btn);
        this.I = inflate.findViewById(R.id.compliance_scrollview);
        this.j = (TextView) inflate.findViewById(R.id.why_this_ad_tv);
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void V(Context context) {
        ImageView imageView = (ImageView) findViewById(R.id.right_arrow);
        this.l = imageView;
        if (imageView != null) {
            Drawable drawable = getResources().getDrawable(R.drawable.hiad_feedback_right_arrow);
            if (ay.I()) {
                this.l.setImageBitmap(y.V(drawable));
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void setAdContentData(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        this.i = adContentData;
        I();
        Z();
        Code();
        B();
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void setViewClickListener(gb gbVar) {
        this.k = gbVar;
    }
}
