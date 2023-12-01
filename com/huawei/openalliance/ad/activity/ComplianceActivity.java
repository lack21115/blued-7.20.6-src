package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.gb;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.activity.a;
import com.huawei.openalliance.ad.constant.at;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.o;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/activity/ComplianceActivity.class */
public class ComplianceActivity extends a {
    private static final String n = "ComplianceActivity";
    private static final int o = 2;
    private static b p;
    private boolean q;
    private AdContentData r = new AdContentData();

    public static void Code(Context context, View view, AdContentData adContentData, boolean z) {
        if (view == null) {
            return;
        }
        try {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            ge.V(n, "startFeedbackActivity, anchorView.getLocationInWindow [x,y]= %d, %d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            view.getViewTreeObserver().addOnGlobalLayoutListener(new a.ViewTreeObserver$OnGlobalLayoutListenerC0259a(view, context, iArr2));
            Code(context, iArr, new int[]{measuredWidth, measuredHeight}, adContentData, z);
        } catch (Throwable th) {
            ge.I(n, "start Activity error: %s", th.getClass().getSimpleName());
        }
    }

    public static void Code(Context context, int[] iArr, int[] iArr2, AdContentData adContentData, boolean z) {
        if (Code(adContentData)) {
            return;
        }
        Intent intent = new Intent(context, ComplianceActivity.class);
        intent.putExtra(at.ao, iArr);
        intent.putExtra(at.ap, iArr2);
        intent.setFlags(65536);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        String X = adContentData.X();
        String str = X;
        if (TextUtils.isEmpty(X)) {
            str = adContentData.W();
        }
        intent.putExtra(at.au, str);
        intent.putExtra(at.av, z.V(adContentData.aG()));
        intent.putExtra(at.aw, z);
        intent.setClipData(t.cF);
        ay.Code(context, intent);
    }

    public static void Code(b bVar) {
        p = bVar;
    }

    private static boolean Code(AdContentData adContentData) {
        if (!o.Code()) {
            return adContentData == null;
        }
        ge.V(n, "repeat click too fast");
        return true;
    }

    private void F() {
        if (this.j == null || this.d == null || this.e == null) {
            return;
        }
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.ComplianceActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ComplianceActivity.this.finish();
            }
        });
        this.d.setViewClickListener(new gb() { // from class: com.huawei.openalliance.ad.activity.ComplianceActivity.2
            @Override // com.huawei.hms.ads.gb
            public void Code() {
                ComplianceActivity.this.finish();
            }
        });
        this.e.setViewClickListener(new gb() { // from class: com.huawei.openalliance.ad.activity.ComplianceActivity.3
            @Override // com.huawei.hms.ads.gb
            public void Code() {
                ComplianceActivity.this.finish();
            }
        });
    }

    public static void S() {
        p = null;
    }

    @Override // com.huawei.openalliance.ad.activity.a
    protected boolean B() {
        String stringExtra = getIntent().getStringExtra(at.au);
        String stringExtra2 = getIntent().getStringExtra(at.av);
        if (!TextUtils.isEmpty(stringExtra2)) {
            this.r.D((List) z.V(stringExtra2, List.class, AdvertiserInfo.class));
        }
        this.q = getIntent().getBooleanExtra(at.aw, false);
        this.r.D(stringExtra);
        return super.B();
    }

    @Override // com.huawei.openalliance.ad.activity.a
    protected void Code() {
        this.j = (RelativeLayout) findViewById(R.id.compliance_activity_root);
        this.k = findViewById(R.id.margin_view);
        this.l = findViewById(R.id.compliance_anchor_view);
        this.d = (PPSBaseDialogContentView) findViewById(R.id.top_compliance_view);
        this.g = (ImageView) findViewById(R.id.top_compliance_iv);
        this.e = (PPSBaseDialogContentView) findViewById(R.id.bottom_compliance_view);
        this.h = (ImageView) findViewById(R.id.bottom_compliance_iv);
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public void I() {
        C();
        this.f.Code(this.f9324a, this.b);
        this.f.setShowWhyThisAd(this.q);
        this.f.setAdContentData(this.r);
    }

    @Override // com.huawei.openalliance.ad.activity.a
    protected int V() {
        return R.layout.hiad_activity_compliance;
    }

    @Override // com.huawei.openalliance.ad.activity.a, android.app.Activity
    public void finish() {
        super.finish();
        b bVar = p;
        if (bVar != null) {
            bVar.V();
        }
    }

    @Override // com.huawei.openalliance.ad.activity.a, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        F();
        b bVar = p;
        if (bVar != null) {
            bVar.Code();
        }
    }
}
