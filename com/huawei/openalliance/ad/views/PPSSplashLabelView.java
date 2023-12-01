package com.huawei.openalliance.ad.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.er;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.gz;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.constant.at;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.utils.y;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSSplashLabelView.class */
public class PPSSplashLabelView extends PPSLabelView {
    private gz B;
    private Integer C;
    private View.OnClickListener F;
    private Integer S;

    public PPSSplashLabelView(Context context) {
        super(context);
        this.F = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashLabelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                er.Code(PPSSplashLabelView.this.getContext()).Code();
                eh.Code(PPSSplashLabelView.this.getContext());
                Intent intent = new Intent();
                intent.setAction(t.ag);
                intent.setPackage(v.Z(PPSSplashLabelView.this.getContext()));
                PPSSplashLabelView pPSSplashLabelView = PPSSplashLabelView.this;
                intent.putExtra(at.ah, pPSSplashLabelView.Code(pPSSplashLabelView.C.intValue()));
                if (!(PPSSplashLabelView.this.getContext() instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                ay.Code(PPSSplashLabelView.this.getContext(), intent);
                if (PPSSplashLabelView.this.B != null) {
                    PPSSplashLabelView.this.B.B();
                }
            }
        };
    }

    public PPSSplashLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashLabelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                er.Code(PPSSplashLabelView.this.getContext()).Code();
                eh.Code(PPSSplashLabelView.this.getContext());
                Intent intent = new Intent();
                intent.setAction(t.ag);
                intent.setPackage(v.Z(PPSSplashLabelView.this.getContext()));
                PPSSplashLabelView pPSSplashLabelView = PPSSplashLabelView.this;
                intent.putExtra(at.ah, pPSSplashLabelView.Code(pPSSplashLabelView.C.intValue()));
                if (!(PPSSplashLabelView.this.getContext() instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                ay.Code(PPSSplashLabelView.this.getContext(), intent);
                if (PPSSplashLabelView.this.B != null) {
                    PPSSplashLabelView.this.B.B();
                }
            }
        };
    }

    public PPSSplashLabelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.F = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashLabelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                er.Code(PPSSplashLabelView.this.getContext()).Code();
                eh.Code(PPSSplashLabelView.this.getContext());
                Intent intent = new Intent();
                intent.setAction(t.ag);
                intent.setPackage(v.Z(PPSSplashLabelView.this.getContext()));
                PPSSplashLabelView pPSSplashLabelView = PPSSplashLabelView.this;
                intent.putExtra(at.ah, pPSSplashLabelView.Code(pPSSplashLabelView.C.intValue()));
                if (!(PPSSplashLabelView.this.getContext() instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                ay.Code(PPSSplashLabelView.this.getContext(), intent);
                if (PPSSplashLabelView.this.B != null) {
                    PPSSplashLabelView.this.B.B();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Code(int i) {
        Integer L = v.L(getContext());
        int i2 = i;
        if (!v.I()) {
            if (L != null && L.intValue() >= 30454100) {
                return i;
            }
            ge.V("PPSSplashLabelView", "HMS version is low, interactMode is %s", Integer.valueOf(i));
            int i3 = i;
            if (i == 4) {
                i3 = 1;
            }
            i2 = i3;
            if (i3 == 3) {
                i2 = 2;
            }
        }
        return i2;
    }

    private SpannableStringBuilder Code(SpannableString spannableString) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
        spannableStringBuilder.setSpan(getClickImageSpan(), spannableString.length() - 1, spannableString.length(), 33);
        return spannableStringBuilder;
    }

    private ImageSpan getClickImageSpan() {
        Drawable drawable = getResources().getDrawable(R.drawable.hiad_chevron_right);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        if (ay.I()) {
            return new b(getContext(), y.V(drawable), 2, v.V(getContext(), 4.0f), 0);
        }
        return new b(drawable, 2, v.V(getContext(), 4.0f), 0);
    }

    private void setClick(SpannableStringBuilder spannableStringBuilder) {
        if (!PPSSplashAdSourceView.Code(getContext(), this.C, this.S)) {
            setText(spannableStringBuilder);
            return;
        }
        spannableStringBuilder.append(" ");
        setText(Code(new SpannableString(spannableStringBuilder)));
        setOnClickListener(this.F);
    }

    @Override // com.huawei.openalliance.ad.views.PPSLabelView
    protected void Code(AdSource adSource, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (adSource == null) {
            ge.V("PPSSplashLabelView", "adSource is null");
            setClick(spannableStringBuilder);
            return;
        }
        String V = au.V(adSource.Code()) == null ? "" : au.V(adSource.Code());
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        String str3 = V + str2;
        String V2 = adSource.V();
        if (TextUtils.isEmpty(V) && TextUtils.isEmpty(V2)) {
            setClick(spannableStringBuilder);
        } else if (TextUtils.isEmpty(V) || !TextUtils.isEmpty(V2)) {
            Code(str3, V2);
        } else {
            setClick(new SpannableStringBuilder(str3));
        }
    }

    public void Code(AdSource adSource, String str, Integer num, Integer num2, gz gzVar) {
        this.C = num;
        this.S = num2;
        this.B = gzVar;
        Code(adSource, str);
    }

    @Override // com.huawei.openalliance.ad.views.PPSLabelView
    protected void Code(String str, Drawable drawable) {
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            boolean isEmpty = TextUtils.isEmpty(str);
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.setSpan(Code(drawable, !isEmpty), 0, 1, 33);
            setClick(spannableStringBuilder);
        } catch (Throwable th) {
            ge.I("PPSSplashLabelView", "setTextWhenImgLoaded error");
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSLabelView
    protected void setTextWhenImgLoadFail(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append((CharSequence) str);
        }
        setClick(spannableStringBuilder);
    }
}
