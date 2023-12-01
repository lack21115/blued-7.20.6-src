package com.huawei.hms.ads.whythisad;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.utils.aa;
import java.util.ArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/whythisad/CusWhyThisAdView.class */
public class CusWhyThisAdView extends RelativeLayout {
    private HorizontalScrollView B;
    private ScrollView C;
    private c D;
    private LinearLayout F;
    private RelativeLayout I;
    private RelativeLayout L;
    private LinearLayout S;
    private RelativeLayout V;

    /* renamed from: a  reason: collision with root package name */
    private HorizontalScrollView f22583a;
    private ScrollView b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f22584c;
    private LinearLayout d;
    private c e;
    private TextView f;
    private b g;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/whythisad/CusWhyThisAdView$a.class */
    public enum a {
        NONE,
        INIT,
        SHOWN,
        DISLIKED
    }

    public CusWhyThisAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context, attributeSet);
    }

    public CusWhyThisAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context, attributeSet);
    }

    public CusWhyThisAdView(Context context, RelativeLayout relativeLayout) {
        super(context);
        this.V = relativeLayout;
        Code(context, null);
    }

    private void Code(Context context, AttributeSet attributeSet) {
        inflate(context, R.layout.hiad_choices_whythisad_root, this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.hiad_whythisad_wrapper);
        this.I = relativeLayout;
        relativeLayout.setVisibility(8);
        this.f22583a = (HorizontalScrollView) findViewById(R.id.hiad_whythisad_horizontal_List);
        this.f22584c = (LinearLayout) findViewById(R.id.hiad_whythisad_horizional_ll_wrapper);
        this.f22583a.setVisibility(8);
        this.b = (ScrollView) findViewById(R.id.hiad_whythisad_vertical_feedback_List);
        this.d = (LinearLayout) findViewById(R.id.hiad_whythisad_vertical_ll_wrapper);
        this.b.setVisibility(8);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.hiad_feedback_wrapper);
        this.L = relativeLayout2;
        relativeLayout2.setVisibility(8);
        this.B = (HorizontalScrollView) findViewById(R.id.hiad_feedback_horizontal_List);
        this.S = (LinearLayout) findViewById(R.id.hiad_feedback_horizional_ll_wrapper);
        this.B.setVisibility(8);
        this.C = (ScrollView) findViewById(R.id.hiad_feedback_vertical_feedback_List);
        this.F = (LinearLayout) findViewById(R.id.hiad_feedback_vertical_ll_wrapper);
        this.C.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.hiad_closed_hint);
        this.f = textView;
        textView.setVisibility(8);
    }

    public void B() {
        Z();
    }

    public void Code() {
        this.I.setVisibility(8);
        this.f22583a.setVisibility(8);
        this.b.setVisibility(8);
        this.B.setVisibility(8);
        this.C.setVisibility(8);
        this.L.setVisibility(8);
        this.f.setVisibility(8);
    }

    public void Code(String str) {
        HorizontalScrollView horizontalScrollView = this.B;
        if (horizontalScrollView != null) {
            horizontalScrollView.setVisibility(8);
        }
        ScrollView scrollView = this.C;
        if (scrollView != null) {
            scrollView.setVisibility(8);
        }
        HorizontalScrollView horizontalScrollView2 = this.f22583a;
        if (horizontalScrollView2 != null) {
            horizontalScrollView2.setVisibility(8);
        }
        ScrollView scrollView2 = this.b;
        if (scrollView2 != null) {
            scrollView2.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.L;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        TextView textView = this.f;
        if (textView != null) {
            textView.setVisibility(0);
        }
        this.g.Code(str);
        ge.Code("CusWhyView", "SDK processCloseEvent");
    }

    public void I() {
        b bVar = this.g;
        if (bVar != null) {
            bVar.V();
        }
    }

    public void V() {
        RelativeLayout relativeLayout = this.L;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        boolean z = false;
        this.I.setVisibility(0);
        d dVar = new d(getContext().getString(R.string.hiad_choices_hide), com.huawei.hms.ads.whythisad.a.HIDE_AD);
        d dVar2 = new d(getContext().getString(R.string.hiad_choices_whythisad), com.huawei.hms.ads.whythisad.a.WHY_THIS_AD);
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar);
        arrayList.add(dVar2);
        if (this.V.getWidth() > this.V.getHeight()) {
            this.e = new c(getContext(), this, this.f22584c);
            this.f22583a.setVisibility(0);
            this.b.setVisibility(8);
            z = true;
        } else {
            this.e = new c(getContext(), this, this.d);
            this.f22583a.setVisibility(8);
            this.b.setVisibility(0);
        }
        this.e.Code(arrayList, z);
        ge.Code("CusWhyView", "SDK showWhyThisAd end");
    }

    public void Z() {
        b bVar = this.g;
        if (bVar != null) {
            bVar.Code();
        }
        TextView textView = this.f;
        if (textView != null) {
            textView.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.I;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.L;
        boolean z = false;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        HorizontalScrollView horizontalScrollView = this.B;
        if (horizontalScrollView != null) {
            horizontalScrollView.setVisibility(0);
        }
        ArrayList<String> arrayList = new ArrayList();
        b bVar2 = this.g;
        if (bVar2 != null) {
            arrayList = bVar2.I();
        }
        ArrayList arrayList2 = new ArrayList();
        if (aa.Code(arrayList)) {
            Code(null);
            return;
        }
        arrayList2.add(new d(getContext().getString(R.string.hiad_choices_ad_no_interest), com.huawei.hms.ads.whythisad.a.NOT_INTEREST));
        for (String str : arrayList) {
            arrayList2.add(new d(str, com.huawei.hms.ads.whythisad.a.CLOSE_AD));
        }
        if (this.V.getWidth() > this.V.getHeight()) {
            this.D = new c(getContext(), this, this.S);
            this.B.setVisibility(0);
            this.C.setVisibility(8);
            z = true;
        } else {
            this.D = new c(getContext(), this, this.F);
            this.B.setVisibility(8);
            this.C.setVisibility(0);
        }
        this.D.Code(arrayList2, z);
        ge.Code("CusWhyView", "SDK showFeedBackList end");
    }

    public void setOnCloseCallBack(b bVar) {
        this.g = bVar;
    }
}
