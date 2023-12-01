package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.user.model.PayBeanDetail;
import com.soft.blued.ui.user.model.PayPlatformDiscountModel;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/NormalPayTypeChoosePop.class */
public class NormalPayTypeChoosePop extends BottomPopupView {
    private ImageView A;
    private TextView B;
    private Context C;
    private boolean D;
    private iChoosePayResultListener b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f32497c;
    private LinearLayout d;
    private ShapeTextView e;
    private ImageView f;
    private LinearLayout g;
    private ImageView h;
    private LinearLayout i;
    private ImageView j;
    private ShapeTextView k;
    private View t;
    private int u;
    private IRequestHost v;
    private int w;
    private int x;
    private int y;
    private ShapeLinearLayout z;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/NormalPayTypeChoosePop$iChoosePayResultListener.class */
    public interface iChoosePayResultListener {
        void a();

        void a(int i, boolean z);
    }

    private NormalPayTypeChoosePop(Context context, iChoosePayResultListener ichoosepayresultlistener, int i, int i2, IRequestHost iRequestHost) {
        super(context);
        this.C = context;
        this.b = ichoosepayresultlistener;
        this.u = i;
        Log.v("drb", "payPlatform:" + i);
        this.w = i2;
        this.v = iRequestHost;
    }

    public static void a(Context context, iChoosePayResultListener ichoosepayresultlistener, int i, int i2, IRequestHost iRequestHost) {
        new XPopup.Builder(context).a((BasePopupView) new NormalPayTypeChoosePop(context, ichoosepayresultlistener, i, i2, iRequestHost)).h();
    }

    private void c() {
        this.f32497c = (TextView) findViewById(2131372754);
        this.d = (LinearLayout) findViewById(R.id.ll_alipay);
        this.e = (ShapeTextView) findViewById(R.id.tv_alipay_discount_desc);
        this.f = (ImageView) findViewById(R.id.img_alipay_choose_status);
        this.g = (LinearLayout) findViewById(R.id.ll_weixin);
        this.h = (ImageView) findViewById(R.id.img_wechat_choose_status);
        this.i = (LinearLayout) findViewById(R.id.ll_huabei);
        this.j = (ImageView) findViewById(R.id.img_huabei_choose_status);
        this.k = (ShapeTextView) findViewById(2131371164);
        this.t = findViewById(R.id.pb_loading);
        this.z = (ShapeLinearLayout) findViewById(2131367655);
        this.A = (ImageView) findViewById(R.id.img_beans_choose_status);
        this.B = (TextView) findViewById(2131368942);
    }

    public BluedUIHttpResponse a(IRequestHost iRequestHost) {
        return new BluedUIHttpResponse<BluedEntityA<PayPlatformDiscountModel>>(iRequestHost) { // from class: com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.6

            /* renamed from: a  reason: collision with root package name */
            String f32503a = "";

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PayPlatformDiscountModel> bluedEntityA) {
                if (!bluedEntityA.hasData() || bluedEntityA.getSingleData() == null) {
                    return;
                }
                if (bluedEntityA.getSingleData().channel != null) {
                    if (bluedEntityA.getSingleData().channel.alipay != null) {
                        this.f32503a = bluedEntityA.getSingleData().channel.alipay.desc;
                        NormalPayTypeChoosePop.this.e.setVisibility(0);
                        NormalPayTypeChoosePop.this.e.setText(this.f32503a);
                    }
                    PayPlatformDiscountModel._channel _channelVar = bluedEntityA.getSingleData().channel;
                    if (_channelVar.weixin == null) {
                        NormalPayTypeChoosePop.this.g.setVisibility(8);
                    }
                    if (NormalPayTypeChoosePop.this.u == 0 && _channelVar != null) {
                        if (_channelVar.alipay != null && _channelVar.alipay.is_choose == 1) {
                            NormalPayTypeChoosePop normalPayTypeChoosePop = NormalPayTypeChoosePop.this;
                            normalPayTypeChoosePop.setChoose(normalPayTypeChoosePop.f);
                        } else if (_channelVar.weixin != null && _channelVar.weixin.is_choose == 1) {
                            NormalPayTypeChoosePop normalPayTypeChoosePop2 = NormalPayTypeChoosePop.this;
                            normalPayTypeChoosePop2.setChoose(normalPayTypeChoosePop2.h);
                        } else if (_channelVar.huabei != null && _channelVar.huabei.is_choose == 1) {
                            NormalPayTypeChoosePop normalPayTypeChoosePop3 = NormalPayTypeChoosePop.this;
                            normalPayTypeChoosePop3.setChoose(normalPayTypeChoosePop3.j);
                        }
                    }
                }
                if (bluedEntityA.getSingleData().vip != null) {
                    NormalPayTypeChoosePop.this.y = bluedEntityA.getSingleData().vip.is_upgrade;
                    NormalPayTypeChoosePop.this.x = bluedEntityA.getSingleData().vip.contract;
                }
                if (bluedEntityA.getSingleData().strategy_num != 0) {
                    VipProtos.Event event = VipProtos.Event.VIP_BUY_SHOW;
                    EventTrackVIP.a(VipProtos.Event.PAY_CASHIER_PAGE_SHOW, bluedEntityA.getSingleData().strategy_num, bluedEntityA.getSingleData().type);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (!z || StringUtils.d(this.f32503a)) {
                    NormalPayTypeChoosePop.this.e.setVisibility(8);
                } else {
                    NormalPayTypeChoosePop.this.e.setVisibility(0);
                }
                NormalPayTypeChoosePop.this.t.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                NormalPayTypeChoosePop.this.t.setVisibility(0);
            }
        };
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        c();
        int i = this.u;
        if (i == 1) {
            setChoose(this.f);
        } else if (i == 2) {
            setChoose(this.h);
        } else if (i == 3) {
            setChoose(this.A);
        } else if (i == 4) {
            setChoose(this.j);
        }
        this.d.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NormalPayTypeChoosePop normalPayTypeChoosePop = NormalPayTypeChoosePop.this;
                normalPayTypeChoosePop.setChoose(normalPayTypeChoosePop.f);
            }
        }));
        this.g.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NormalPayTypeChoosePop normalPayTypeChoosePop = NormalPayTypeChoosePop.this;
                normalPayTypeChoosePop.setChoose(normalPayTypeChoosePop.h);
            }
        }));
        this.i.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NormalPayTypeChoosePop normalPayTypeChoosePop = NormalPayTypeChoosePop.this;
                normalPayTypeChoosePop.setChoose(normalPayTypeChoosePop.j);
            }
        }));
        this.z.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (NormalPayTypeChoosePop.this.D) {
                    NormalPayTypeChoosePop normalPayTypeChoosePop = NormalPayTypeChoosePop.this;
                    normalPayTypeChoosePop.setChoose(normalPayTypeChoosePop.A);
                }
            }
        }));
        this.k.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.5
            /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
                if ((r4.f32502a.u == 4 ? 1 : r4.f32502a.u) != r4.f32502a.x) goto L14;
             */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onClick(android.view.View r5) {
                /*
                    r4 = this;
                    r0 = r5
                    com.bytedance.applog.tracker.Tracker.onClick(r0)
                    r0 = r4
                    com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop r0 = com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.this
                    com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop$iChoosePayResultListener r0 = com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.f(r0)
                    if (r0 == 0) goto L66
                    r0 = r4
                    com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop r0 = com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.this
                    int r0 = com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.g(r0)
                    r6 = r0
                    r0 = 1
                    r7 = r0
                    r0 = r6
                    if (r0 != 0) goto L1f
                    goto L52
                L1f:
                    r0 = r4
                    com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop r0 = com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.this
                    int r0 = com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.h(r0)
                    r1 = 1
                    if (r0 != r1) goto L50
                    r0 = r4
                    com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop r0 = com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.this
                    int r0 = com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.i(r0)
                    r1 = 4
                    if (r0 != r1) goto L3a
                    r0 = 1
                    r6 = r0
                    goto L42
                L3a:
                    r0 = r4
                    com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop r0 = com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.this
                    int r0 = com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.i(r0)
                    r6 = r0
                L42:
                    r0 = r6
                    r1 = r4
                    com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop r1 = com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.this
                    int r1 = com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.g(r1)
                    if (r0 == r1) goto L50
                    goto L52
                L50:
                    r0 = 0
                    r7 = r0
                L52:
                    r0 = r4
                    com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop r0 = com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.this
                    com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop$iChoosePayResultListener r0 = com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.f(r0)
                    r1 = r4
                    com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop r1 = com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.this
                    int r1 = com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.i(r1)
                    r2 = r7
                    r0.a(r1, r2)
                L66:
                    r0 = r4
                    com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop r0 = com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.this
                    r0.p()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.AnonymousClass5.onClick(android.view.View):void");
            }
        }));
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.item_choose_pay_platform;
    }

    public void getPayBeansGetDetail() {
        PayHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<PayBeanDetail>>(this.v) { // from class: com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PayBeanDetail> bluedEntityA) {
                PayBeanDetail payBeanDetail;
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || (payBeanDetail = bluedEntityA.data.get(0)) == null) {
                    return;
                }
                if (payBeanDetail.is_support_beans != 1) {
                    NormalPayTypeChoosePop.this.z.setVisibility(8);
                    return;
                }
                NormalPayTypeChoosePop.this.z.setVisibility(0);
                if (payBeanDetail.is_enough == 1) {
                    NormalPayTypeChoosePop.this.D = true;
                    NormalPayTypeChoosePop.this.B.setVisibility(0);
                    NormalPayTypeChoosePop.this.B.setText(String.format(NormalPayTypeChoosePop.this.C.getResources().getString(R.string.no_free_beans), StringUtils.a(String.valueOf(payBeanDetail.beans))));
                    return;
                }
                NormalPayTypeChoosePop.this.D = false;
                NormalPayTypeChoosePop.this.B.setVisibility(0);
                NormalPayTypeChoosePop.this.B.setText(NormalPayTypeChoosePop.this.C.getResources().getString(R.string.not_enough_beans));
                NormalPayTypeChoosePop.this.z.setAlpha(0.5f);
                if (NormalPayTypeChoosePop.this.u == 3) {
                    NormalPayTypeChoosePop normalPayTypeChoosePop = NormalPayTypeChoosePop.this;
                    normalPayTypeChoosePop.setChoose(normalPayTypeChoosePop.f);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }
        }, this.w);
    }

    public void setChoose(ImageView imageView) {
        this.f.setImageResource(R.drawable.icon_pay_unchoosed);
        this.h.setImageResource(R.drawable.icon_pay_unchoosed);
        this.j.setImageResource(R.drawable.icon_pay_unchoosed);
        this.A.setImageResource(R.drawable.icon_pay_unchoosed);
        imageView.setImageResource(R.drawable.icon_coupon_choosed);
        switch (imageView.getId()) {
            case R.id.img_alipay_choose_status /* 2131364423 */:
                this.u = 1;
                break;
            case R.id.img_beans_choose_status /* 2131364451 */:
                this.u = 3;
                break;
            case R.id.img_huabei_choose_status /* 2131364551 */:
                this.u = 4;
                break;
            case R.id.img_wechat_choose_status /* 2131364731 */:
                this.u = 2;
                break;
        }
        Log.v("drb", "setChoose payPlatform:" + this.u);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void u() {
        super.u();
        iChoosePayResultListener ichoosepayresultlistener = this.b;
        if (ichoosepayresultlistener != null) {
            ichoosepayresultlistener.a();
        }
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void w() {
        super.w();
        PayHttpUtils.a(a(this.v), this.w, this.v);
        getPayBeansGetDetail();
    }
}
