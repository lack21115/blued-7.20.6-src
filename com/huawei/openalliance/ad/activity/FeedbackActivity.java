package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.AdFeedbackListener;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.ep;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.ko;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.activity.a;
import com.huawei.openalliance.ad.constant.at;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.feedback.FeedbackView;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.utils.o;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/activity/FeedbackActivity.class */
public class FeedbackActivity extends a implements com.huawei.openalliance.ad.compliance.a {
    private static AdFeedbackListener o;
    private static AdFeedbackListener p;

    public static void Code(Context context, com.huawei.openalliance.ad.feedback.a aVar) {
        if (aVar == null) {
            return;
        }
        if (o.Code()) {
            ge.V("FeedbackActivity", "fast click");
            return;
        }
        n Code = ep.Code();
        if (Code == null) {
            ge.V("FeedbackActivity", "nativeAd is null");
            return;
        }
        p = aVar.V();
        o = aVar.I();
        AdContentData l = Code.l();
        if (l == null || aVar.Code() == null || !o.Code(l.ax()) || p == null) {
            ge.Z("FeedbackActivity", "startFeedbackActivity fail: invalid parameter.");
            D();
            return;
        }
        try {
            View Code2 = aVar.Code();
            int[] iArr = new int[2];
            Code2.getLocationInWindow(iArr);
            ge.V("FeedbackActivity", "startFeedbackActivity, anchorView.getLocationInWindow [x,y]= %d, %d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            int[] iArr2 = new int[2];
            Code2.getLocationOnScreen(iArr2);
            int measuredWidth = Code2.getMeasuredWidth();
            int measuredHeight = Code2.getMeasuredHeight();
            Code2.getViewTreeObserver().addOnGlobalLayoutListener(new a.ViewTreeObserver$OnGlobalLayoutListenerC0429a(Code2, context, iArr2));
            Intent intent = new Intent(context, FeedbackActivity.class);
            intent.putExtra(at.ao, iArr);
            intent.putExtra(at.ap, new int[]{measuredWidth, measuredHeight});
            intent.setFlags(65536);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.setClipData(t.cF);
            context.startActivity(intent);
        } catch (Throwable th) {
            ge.I("FeedbackActivity", "startFeedbackActivity error: %s", th.getClass().getSimpleName());
            D();
        }
    }

    private void Code(List<FeedbackInfo> list) {
        Toast.makeText(getApplicationContext(), R.string.hiad_feedback_had_feedback, 0).show();
        ko.Code(this, this.f22933c, list, 2);
        eh.Code(this, this.f22933c, "1");
        AdFeedbackListener adFeedbackListener = p;
        if (adFeedbackListener != null) {
            adFeedbackListener.onAdLiked();
        }
        AdFeedbackListener adFeedbackListener2 = o;
        if (adFeedbackListener2 != null) {
            adFeedbackListener2.onAdLiked();
        }
    }

    private static void D() {
        AdFeedbackListener adFeedbackListener = o;
        if (adFeedbackListener != null) {
            adFeedbackListener.onAdFeedbackShowFailed();
        }
    }

    private static void F() {
        o = null;
        p = null;
    }

    private void S() {
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.FeedbackActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                try {
                    eh.Code(FeedbackActivity.this, FeedbackActivity.this.f22933c, "3");
                } catch (Throwable th) {
                    ge.I("FeedbackActivity", "onClick error: %s", th.getClass().getSimpleName());
                }
                FeedbackActivity.this.finish();
            }
        });
    }

    private void V(List<FeedbackInfo> list) {
        Toast.makeText(getApplicationContext(), R.string.hiad_feedback_reduce_such_content, 0).show();
        ko.Code(this, this.f22933c, list, 1);
        eh.Code(this, this.f22933c, "2");
        AdFeedbackListener adFeedbackListener = p;
        if (adFeedbackListener != null) {
            adFeedbackListener.onAdDisliked();
        }
        AdFeedbackListener adFeedbackListener2 = o;
        if (adFeedbackListener2 != null) {
            adFeedbackListener2.onAdDisliked();
        }
    }

    @Override // com.huawei.openalliance.ad.activity.a
    protected boolean B() {
        n Code = ep.Code();
        if (Code == null) {
            return false;
        }
        this.f22933c = Code.l();
        return super.B();
    }

    @Override // com.huawei.openalliance.ad.activity.a
    protected void Code() {
        this.j = (RelativeLayout) findViewById(R.id.feedback_activity_root);
        this.k = findViewById(R.id.margin_view);
        this.l = findViewById(R.id.feedback_anchor_view);
        this.d = (FeedbackView) findViewById(R.id.top_feedback_view);
        this.g = (ImageView) findViewById(R.id.top_feedback_iv);
        this.e = (FeedbackView) findViewById(R.id.bottom_feedback_view);
        this.h = (ImageView) findViewById(R.id.bottom_feedback_iv);
    }

    @Override // com.huawei.openalliance.ad.compliance.a
    public void Code(int i, FeedbackInfo feedbackInfo) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            arrayList.add(feedbackInfo);
        } catch (Throwable th) {
            ge.I("FeedbackActivity", "itemClickAction error: %s", th.getClass().getSimpleName());
        }
        if (i != 1) {
            if (i == 2) {
                Code(arrayList);
            } else if (i != 3) {
                ge.Code("FeedbackActivity", "invalid feedback type");
            }
            finish();
        }
        V(arrayList);
        finish();
    }

    @Override // com.huawei.openalliance.ad.activity.a
    protected void I() {
        C();
        this.f.Code(this.f22932a, this.b);
        this.f.setAdContentData(this.f22933c);
        this.f.setFeedbackListener(this);
    }

    @Override // com.huawei.openalliance.ad.activity.a
    protected int V() {
        return R.layout.hiad_activity_feedback;
    }

    @Override // com.huawei.openalliance.ad.activity.a
    protected void Z() {
        D();
    }

    @Override // com.huawei.openalliance.ad.activity.a, android.app.Activity
    public void finish() {
        super.finish();
        ge.V("FeedbackActivity", "finish");
        if (this.j != null) {
            this.j.setVisibility(4);
        }
    }

    @Override // com.huawei.openalliance.ad.activity.a, android.app.Activity
    protected void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            S();
            eh.Code(this, this.f22933c, "0");
        } catch (Throwable th) {
            ge.I("FeedbackActivity", "onCreate error: %s", th.getClass().getSimpleName());
            D();
            finish();
        }
    }

    @Override // com.huawei.openalliance.ad.activity.a, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ep.Code(null);
        F();
    }
}
