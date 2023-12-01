package com.soft.blued.ui.msg.pop;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.ui.user.model.PayPlatformDiscountModel;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/UserGiftPayTypeChoosePop.class */
public class UserGiftPayTypeChoosePop extends BottomPopupView {
    private iChoosePayResultListener b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f32514c;
    private ShapeLinearLayout d;
    private ImageView e;
    private ShapeLinearLayout f;
    private LinearLayout g;
    private ShapeTextView h;
    private ImageView i;
    private LinearLayout j;
    private ImageView k;
    private LinearLayout t;
    private ImageView u;
    private ShapeTextView v;
    private int w;
    private View x;
    private IRequestHost y;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/UserGiftPayTypeChoosePop$iChoosePayResultListener.class */
    public interface iChoosePayResultListener {
        void a(int i);
    }

    private void c() {
        this.f32514c = (TextView) findViewById(2131372754);
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) findViewById(2131367655);
        this.d = shapeLinearLayout;
        ShapeHelper.b(shapeLinearLayout, 2131101780);
        this.e = (ImageView) findViewById(R.id.img_beans_choose_status);
        ShapeLinearLayout shapeLinearLayout2 = (ShapeLinearLayout) findViewById(R.id.ll_others);
        this.f = shapeLinearLayout2;
        ShapeHelper.b(shapeLinearLayout2, 2131101780);
        this.g = (LinearLayout) findViewById(R.id.ll_alipay);
        this.h = (ShapeTextView) findViewById(R.id.tv_alipay_discount_desc);
        this.i = (ImageView) findViewById(R.id.img_alipay_choose_status);
        this.j = (LinearLayout) findViewById(R.id.ll_weixin);
        this.k = (ImageView) findViewById(R.id.img_wechat_choose_status);
        this.t = (LinearLayout) findViewById(R.id.ll_huabei);
        this.u = (ImageView) findViewById(R.id.img_huabei_choose_status);
        this.v = (ShapeTextView) findViewById(2131371164);
        this.x = findViewById(R.id.pb_loading);
    }

    public BluedUIHttpResponse a(IRequestHost iRequestHost) {
        return new BluedUIHttpResponse<BluedEntityA<PayPlatformDiscountModel>>(iRequestHost) { // from class: com.soft.blued.ui.msg.pop.UserGiftPayTypeChoosePop.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PayPlatformDiscountModel> bluedEntityA) {
                if (!bluedEntityA.hasData() || bluedEntityA.getSingleData() == null || bluedEntityA.getSingleData().channel == null || bluedEntityA.getSingleData().channel == null || bluedEntityA.getSingleData().channel.alipay == null) {
                    return;
                }
                UserGiftPayTypeChoosePop.this.h.setText(bluedEntityA.getSingleData().channel.alipay.desc);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    if (!StringUtils.d(((Object) UserGiftPayTypeChoosePop.this.h.getText()) + "")) {
                        UserGiftPayTypeChoosePop.this.h.setVisibility(0);
                        UserGiftPayTypeChoosePop.this.x.setVisibility(8);
                    }
                }
                UserGiftPayTypeChoosePop.this.h.setVisibility(8);
                UserGiftPayTypeChoosePop.this.x.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                UserGiftPayTypeChoosePop.this.x.setVisibility(0);
            }
        };
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        c();
        int i = this.w;
        if (i == 1) {
            setChoose(this.i);
        } else if (i == 2) {
            setChoose(this.k);
        } else if (i == 3) {
            setChoose(this.e);
        } else if (i == 4) {
            setChoose(this.u);
        }
        this.g.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.UserGiftPayTypeChoosePop.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                UserGiftPayTypeChoosePop userGiftPayTypeChoosePop = UserGiftPayTypeChoosePop.this;
                userGiftPayTypeChoosePop.setChoose(userGiftPayTypeChoosePop.i);
            }
        }));
        this.j.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.UserGiftPayTypeChoosePop.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                UserGiftPayTypeChoosePop userGiftPayTypeChoosePop = UserGiftPayTypeChoosePop.this;
                userGiftPayTypeChoosePop.setChoose(userGiftPayTypeChoosePop.k);
            }
        }));
        this.t.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.UserGiftPayTypeChoosePop.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                UserGiftPayTypeChoosePop userGiftPayTypeChoosePop = UserGiftPayTypeChoosePop.this;
                userGiftPayTypeChoosePop.setChoose(userGiftPayTypeChoosePop.u);
            }
        }));
        this.d.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.UserGiftPayTypeChoosePop.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                UserGiftPayTypeChoosePop userGiftPayTypeChoosePop = UserGiftPayTypeChoosePop.this;
                userGiftPayTypeChoosePop.setChoose(userGiftPayTypeChoosePop.e);
            }
        }));
        this.v.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.UserGiftPayTypeChoosePop.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (UserGiftPayTypeChoosePop.this.b != null) {
                    UserGiftPayTypeChoosePop.this.b.a(UserGiftPayTypeChoosePop.this.w);
                }
                UserGiftPayTypeChoosePop.this.p();
            }
        }));
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.item_choose_pay_platform;
    }

    public void setChoose(ImageView imageView) {
        this.i.setImageResource(R.drawable.icon_pay_unchoosed);
        this.k.setImageResource(R.drawable.icon_pay_unchoosed);
        this.u.setImageResource(R.drawable.icon_pay_unchoosed);
        this.e.setImageResource(R.drawable.icon_pay_unchoosed);
        imageView.setImageResource(R.drawable.icon_coupon_choosed);
        switch (imageView.getId()) {
            case R.id.img_alipay_choose_status /* 2131364423 */:
                this.w = 1;
                return;
            case R.id.img_beans_choose_status /* 2131364451 */:
                this.w = 3;
                return;
            case R.id.img_huabei_choose_status /* 2131364551 */:
                this.w = 4;
                return;
            case R.id.img_wechat_choose_status /* 2131364731 */:
                this.w = 2;
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void w() {
        super.w();
        PayHttpUtils.a(a(this.y), 0, this.y);
    }
}
