package com.huawei.openalliance.ad.feedback;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.bd;
import com.huawei.openalliance.ad.utils.o;
import com.huawei.openalliance.ad.utils.y;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/feedback/FeedbackView.class */
public class FeedbackView extends PPSBaseDialogContentView implements d {
    private LinearLayout g;
    private LinearLayout h;
    private FlowLayoutView i;
    private FlowLayoutView j;
    private ViewStub k;
    private View l;
    private ImageView m;
    private com.huawei.openalliance.ad.compliance.a n;
    private boolean o;
    private boolean p;
    private com.huawei.openalliance.ad.feedback.b q;
    private a r;
    private c s;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/feedback/FeedbackView$a.class */
    public static class a extends b {
        private com.huawei.openalliance.ad.compliance.a I;

        protected a(Context context) {
            super(context);
        }

        public void Code(com.huawei.openalliance.ad.compliance.a aVar) {
            this.I = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.huawei.openalliance.ad.compliance.a aVar;
            if (this.Code == null) {
                return;
            }
            boolean Z = this.Code.Z();
            ge.Code("FeedbackView", "click to complain:%s", Boolean.valueOf(Z));
            if (!Z || (aVar = this.I) == null) {
                return;
            }
            aVar.Code(3, this.Code.I());
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/feedback/FeedbackView$b.class */
    static abstract class b implements View.OnClickListener {
        protected com.huawei.openalliance.ad.feedback.b Code;
        protected final Context V;

        protected b(Context context) {
            this.V = context;
        }

        public void Code(com.huawei.openalliance.ad.feedback.b bVar) {
            this.Code = bVar;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/feedback/FeedbackView$c.class */
    public static class c extends b {
        protected c(Context context) {
            super(context);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.Code == null) {
                return;
            }
            ge.Code("FeedbackView", "click to why this ad:%s", Boolean.valueOf(this.Code.Code(this.V)));
        }
    }

    public FeedbackView(Context context) {
        super(context);
        this.o = true;
        this.p = true;
    }

    public FeedbackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = true;
        this.p = true;
    }

    public FeedbackView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = true;
        this.p = true;
    }

    public FeedbackView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.o = true;
        this.p = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i, FeedbackInfo feedbackInfo) {
        com.huawei.openalliance.ad.compliance.a aVar = this.n;
        if (aVar != null) {
            aVar.Code(i, feedbackInfo);
        }
    }

    private void Code(FlowLayoutView flowLayoutView, List<FeedbackInfo> list, final int i) {
        flowLayoutView.removeAllViews();
        if (aa.Code(list)) {
            ge.V("FeedbackView", "feedbackInfoList is null");
            return;
        }
        ge.V("FeedbackView", "initFlowLayout, feedType: %s, feedbackList.size: %s", Integer.valueOf(i), Integer.valueOf(list.size()));
        for (final FeedbackInfo feedbackInfo : list) {
            if (feedbackInfo != null && !TextUtils.isEmpty(feedbackInfo.Code())) {
                String Code = feedbackInfo.Code();
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hiad_feedback_unlike_label_item, (ViewGroup) flowLayoutView, false);
                if (inflate instanceof TextView) {
                    TextView textView = (TextView) inflate;
                    textView.setText(Code);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.feedback.FeedbackView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            try {
                                if (FeedbackView.this.o) {
                                    FeedbackView.this.o = false;
                                    view.setSelected(!view.isSelected());
                                    view.postDelayed(new Runnable() { // from class: com.huawei.openalliance.ad.feedback.FeedbackView.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            FeedbackView.this.o = true;
                                            FeedbackView.this.Code(i, feedbackInfo);
                                        }
                                    }, 200L);
                                }
                            } catch (Throwable th) {
                                ge.I("FeedbackView", "onClick error, %s", th.getClass().getSimpleName());
                            }
                        }
                    });
                    flowLayoutView.addView(textView);
                }
            }
        }
        flowLayoutView.setDefaultDisplayMode(ay.I() ? -1 : 1);
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void Code() {
        try {
            this.p = dt.Code(getContext()).V();
            ge.V("FeedbackView", "adapterView mFeedbackViewPaddingLeft = %s, mFeedbackViewPaddingRight= %s", Integer.valueOf(this.f9405a), Integer.valueOf(this.b));
            if (V() && this.V != null) {
                this.V.setPadding(this.f9405a, 0, this.b, 0);
                if (this.q != null) {
                    List<FeedbackInfo> Code = this.q.Code();
                    List<FeedbackInfo> V = this.q.V();
                    FeedbackInfo I = this.q.I();
                    if (o.Code(Code)) {
                        bd.Code((View) this.g, true);
                        Code(this.i, Code, 2);
                    } else {
                        bd.Code((View) this.g, false);
                    }
                    if (o.Code(V)) {
                        bd.Code((View) this.h, true);
                        Code(this.j, V, 1);
                    } else {
                        bd.Code((View) this.h, false);
                    }
                    if (this.p) {
                        if (I != null && I.Z()) {
                            ((TextView) findViewById(R.id.complain_tv)).setText(I.Code());
                        } else if (this.k != null) {
                            this.k.setVisibility(8);
                        }
                    }
                    View findViewById = findViewById(R.id.extra_area);
                    this.l = findViewById;
                    if (findViewById != null) {
                        findViewById.setOnClickListener(!this.p ? this.s : this.r);
                    }
                }
                this.V.requestLayout();
                this.V.getViewTreeObserver().addOnGlobalLayoutListener(this.d);
            }
        } catch (Throwable th) {
            ge.I("FeedbackView", "adapterView error, %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void Code(Context context) {
        try {
            this.Code = LayoutInflater.from(context).inflate(R.layout.hiad_feedback_view, this);
            this.g = (LinearLayout) this.Code.findViewById(R.id.feedback_positive_ll);
            this.h = (LinearLayout) this.Code.findViewById(R.id.feedback_negative_ll);
            this.V = this.Code.findViewById(R.id.feedback_view_root);
            this.I = this.Code.findViewById(R.id.feedback_scrollview);
            this.i = (FlowLayoutView) this.Code.findViewById(R.id.feedback_positive_flv);
            this.j = (FlowLayoutView) this.Code.findViewById(R.id.feedback_negative_flv);
            this.k = (ViewStub) this.Code.findViewById(R.id.feedback_viewstub);
            this.q = new com.huawei.openalliance.ad.feedback.b(this);
            this.r = new a(getContext());
            this.s = new c(getContext());
            this.r.Code(this.q);
            this.s.Code(this.q);
        } catch (Throwable th) {
            ge.I("FeedbackView", "initView error, %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void V(Context context) {
        boolean V = dt.Code(context).V();
        this.p = V;
        ge.Code("FeedbackView", "isChinaRom = %s", Boolean.valueOf(V));
        ViewStub viewStub = this.k;
        if (viewStub == null) {
            return;
        }
        viewStub.setLayoutResource(!this.p ? R.layout.hiad_whythisad_viewstub : R.layout.hiad_complain_viewstub);
        this.k.inflate();
        ImageView imageView = (ImageView) findViewById(R.id.right_arrow);
        this.m = imageView;
        if (imageView != null) {
            Drawable drawable = getResources().getDrawable(R.drawable.hiad_feedback_right_arrow);
            if (ay.I()) {
                this.m.setImageBitmap(y.V(drawable));
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void setAdContentData(AdContentData adContentData) {
        com.huawei.openalliance.ad.feedback.b bVar = this.q;
        if (bVar != null) {
            bVar.Code(getContext(), adContentData);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void setFeedbackListener(com.huawei.openalliance.ad.compliance.a aVar) {
        this.n = aVar;
        a aVar2 = this.r;
        if (aVar2 != null) {
            aVar2.Code(aVar);
        }
    }
}
