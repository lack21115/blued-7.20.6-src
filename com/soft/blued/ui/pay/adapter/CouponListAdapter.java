package com.soft.blued.ui.pay.adapter;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.customview.VerticalDashView;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.pay.model.BluedCoupon;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/adapter/CouponListAdapter.class */
public class CouponListAdapter extends BaseQuickAdapter<BluedCoupon, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public ShapeTextView f32987a;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/adapter/CouponListAdapter$CouponViewHolder.class */
    public class CouponViewHolder {
        private ConstraintLayout b;

        /* renamed from: c  reason: collision with root package name */
        private FrameLayout f32989c;
        private LinearLayout d;
        private ConstraintLayout e;
        private TextView f;
        private ImageView g;
        private TextView h;
        private TextView i;
        private TextView j;
        private TextView k;
        private ImageView l;
        private TextView m;
        private VerticalDashView n;
        private ImageView o;
        private TextView p;
        private TextView q;
        private ImageView r;
        private ImageView s;

        CouponViewHolder(BaseViewHolder baseViewHolder) {
            this.b = (ConstraintLayout) baseViewHolder.getView(R.id.view_item);
            this.f32989c = (FrameLayout) baseViewHolder.getView(R.id.view_left_part);
            this.d = (LinearLayout) baseViewHolder.getView(R.id.ll_money);
            this.e = (ConstraintLayout) baseViewHolder.getView(R.id.view_right_part);
            this.f = (TextView) baseViewHolder.getView(2131372046);
            this.g = (ImageView) baseViewHolder.getView(R.id.img_coupon_product_icon);
            this.h = (TextView) baseViewHolder.getView(R.id.tv_coupon_time_title);
            this.i = (TextView) baseViewHolder.getView(R.id.tv_coupon_time);
            this.j = (TextView) baseViewHolder.getView(R.id.tv_coupon_use_desc);
            this.k = (TextView) baseViewHolder.getView(R.id.tv_limit_cut);
            this.l = (ImageView) baseViewHolder.getView(R.id.img_limit_icon);
            this.m = (TextView) baseViewHolder.getView(R.id.tv_coupon_limit);
            this.n = (VerticalDashView) baseViewHolder.getView(R.id.view_vertical_dash);
            this.o = (ImageView) baseViewHolder.getView(R.id.img_choose_status);
            this.p = (TextView) baseViewHolder.getView(R.id.tv_money);
            this.q = (TextView) baseViewHolder.getView(R.id.tv_rate);
            this.r = (ImageView) baseViewHolder.getView(R.id.img_icon_rmb);
            this.s = (ImageView) baseViewHolder.getView(R.id.iv_selected);
        }
    }

    public CouponListAdapter(Context context, ShapeTextView shapeTextView) {
        super(R.layout.item_coupon, new ArrayList());
        this.mContext = context;
        this.f32987a = shapeTextView;
    }

    public static void a(Context context, ShapeTextView shapeTextView, boolean z) {
        if (z) {
            shapeTextView.setEnabled(true);
            ShapeHelper.b(shapeTextView, 2131102163);
            return;
        }
        shapeTextView.setEnabled(false);
        ShapeHelper.b(shapeTextView, 2131102204);
    }

    private void a(CouponViewHolder couponViewHolder, BluedCoupon bluedCoupon) {
        c(couponViewHolder, bluedCoupon);
        couponViewHolder.f32989c.setBackground(this.mContext.getResources().getDrawable(R.drawable.bg_coupon_left_normal));
        couponViewHolder.n.setDashColor(2131102260);
        couponViewHolder.e.setBackground(this.mContext.getResources().getDrawable(R.drawable.bg_coupon_right_normal));
        couponViewHolder.p.setTextColor(this.mContext.getResources().getColor(2131102260));
        couponViewHolder.r.setImageResource(R.drawable.icon_rmb_unavailable);
        couponViewHolder.q.setTextColor(this.mContext.getResources().getColor(2131102260));
        couponViewHolder.f.setTextColor(this.mContext.getResources().getColor(2131102260));
        couponViewHolder.h.setTextColor(this.mContext.getResources().getColor(2131102260));
        couponViewHolder.i.setTextColor(this.mContext.getResources().getColor(2131102260));
        couponViewHolder.j.setTextColor(this.mContext.getResources().getColor(2131102260));
        couponViewHolder.k.setVisibility(0);
        couponViewHolder.o.setVisibility(8);
        couponViewHolder.g.setVisibility(0);
        int i = bluedCoupon.type;
        if (i == 1) {
            couponViewHolder.g.setImageResource(R.drawable.icon_vip_unavailable);
        } else if (i == 2) {
            couponViewHolder.g.setImageResource(2131233883);
        } else if (i == 3) {
            couponViewHolder.g.setImageResource(R.drawable.icon_unavailable_super_coupon);
        } else if (i != 9) {
            couponViewHolder.g.setVisibility(8);
        } else {
            couponViewHolder.g.setImageResource(R.drawable.icon_general_coupon_unavailable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BluedCoupon bluedCoupon, View view) {
        Tracker.onClick(view);
        bluedCoupon.ifChoosed = !bluedCoupon.ifChoosed;
        if (bluedCoupon.ifChoosed) {
            for (BluedCoupon bluedCoupon2 : this.mData) {
                if (bluedCoupon2 != bluedCoupon) {
                    bluedCoupon2.ifChoosed = false;
                }
            }
        }
        EventTrackVIP.a(VipProtos.Event.ORDER_COUPON_CLICK, EventTrackVIP.c(bluedCoupon.type), bluedCoupon.id + "");
        a(this.mContext, this.f32987a, a() != null);
        notifyDataSetChanged();
    }

    private void b(CouponViewHolder couponViewHolder, final BluedCoupon bluedCoupon) {
        c(couponViewHolder, bluedCoupon);
        couponViewHolder.o.setVisibility(0);
        if (bluedCoupon.ifChoosed) {
            couponViewHolder.f32989c.setBackground(this.mContext.getResources().getDrawable(R.drawable.bg_coupon_left_selected));
            couponViewHolder.n.setDashColor("#84BDFF");
            couponViewHolder.e.setBackground(this.mContext.getResources().getDrawable(R.drawable.bg_coupon_right_selected));
            couponViewHolder.o.setImageResource(R.drawable.icon_coupon_choosed);
        } else {
            couponViewHolder.f32989c.setBackground(this.mContext.getResources().getDrawable(R.drawable.bg_coupon_left_normal));
            if (bluedCoupon.is_available == 1) {
                couponViewHolder.n.setDashColor(2131102260);
            } else {
                couponViewHolder.n.setDashColor(2131102360);
            }
            couponViewHolder.e.setBackground(this.mContext.getResources().getDrawable(R.drawable.bg_coupon_right_normal));
            couponViewHolder.o.setImageResource(R.drawable.icon_coupon_unchoosed);
        }
        couponViewHolder.p.setTextColor(this.mContext.getResources().getColor(2131101766));
        couponViewHolder.r.setImageResource(R.drawable.icon_rmb);
        couponViewHolder.q.setTextColor(this.mContext.getResources().getColor(2131101766));
        couponViewHolder.f.setTextColor(this.mContext.getResources().getColor(2131102254));
        couponViewHolder.h.setTextColor(this.mContext.getResources().getColor(2131102254));
        couponViewHolder.i.setTextColor(this.mContext.getResources().getColor(2131102254));
        couponViewHolder.j.setTextColor(this.mContext.getResources().getColor(2131102254));
        couponViewHolder.k.setVisibility(8);
        couponViewHolder.g.setVisibility(0);
        if (bluedCoupon.is_available == 1) {
            if (bluedCoupon.ifChoosed) {
                couponViewHolder.s.setImageDrawable(this.mContext.getDrawable(R.drawable.icon_coupon_item_selected));
            } else {
                couponViewHolder.s.setImageDrawable(this.mContext.getDrawable(R.drawable.icon_coupon_item_select));
            }
        }
        int i = bluedCoupon.type;
        if (i == 1) {
            couponViewHolder.g.setImageResource(2131233998);
        } else if (i == 2) {
            couponViewHolder.g.setImageResource(2131233869);
        } else if (i == 3) {
            couponViewHolder.g.setImageResource(R.drawable.icon_avaiable_super_coupon);
        } else if (i != 9) {
            couponViewHolder.g.setVisibility(8);
        } else {
            couponViewHolder.g.setImageResource(R.drawable.icon_general_coupon);
        }
        couponViewHolder.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.adapter.-$$Lambda$CouponListAdapter$qgD5etONdsgcMUJ0JAsxaZkJiuU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CouponListAdapter.this.a(bluedCoupon, view);
            }
        });
    }

    private void c(CouponViewHolder couponViewHolder, BluedCoupon bluedCoupon) {
        long round = Math.round(Double.parseDouble(bluedCoupon.money));
        TextView textView = couponViewHolder.p;
        textView.setText(round + "");
        if (round >= 100) {
            couponViewHolder.p.setTextSize(28.0f);
        } else {
            couponViewHolder.p.setTextSize(36.0f);
        }
        couponViewHolder.q.setText(bluedCoupon.discount_desc);
        couponViewHolder.f.setText(bluedCoupon.name);
        TextView textView2 = couponViewHolder.i;
        textView2.setText(bluedCoupon.start_time + "-" + bluedCoupon.end_time);
        if (StringUtils.d(bluedCoupon.tag)) {
            couponViewHolder.j.setVisibility(8);
        } else {
            couponViewHolder.j.setVisibility(0);
            couponViewHolder.j.setText(bluedCoupon.tag);
        }
        if (StringUtils.d(bluedCoupon.not_available_desc)) {
            couponViewHolder.m.setVisibility(8);
            couponViewHolder.l.setVisibility(8);
        } else {
            couponViewHolder.m.setText(bluedCoupon.not_available_desc);
            couponViewHolder.m.setVisibility(0);
            couponViewHolder.l.setVisibility(0);
        }
        if (bluedCoupon.discount_type == 0 || bluedCoupon.discount_type == 2) {
            couponViewHolder.d.setVisibility(0);
            couponViewHolder.q.setVisibility(8);
            return;
        }
        couponViewHolder.d.setVisibility(8);
        couponViewHolder.q.setVisibility(0);
    }

    public BluedCoupon a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mData.size()) {
                return null;
            }
            if (((BluedCoupon) this.mData.get(i2)).ifChoosed) {
                return (BluedCoupon) this.mData.get(i2);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, BluedCoupon bluedCoupon) {
        if (baseViewHolder != null) {
            CouponViewHolder couponViewHolder = new CouponViewHolder(baseViewHolder);
            if (bluedCoupon.is_available == 1) {
                b(couponViewHolder, bluedCoupon);
            } else {
                a(couponViewHolder, bluedCoupon);
            }
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) couponViewHolder.b.getLayoutParams();
            if (baseViewHolder.getAdapterPosition() == this.mData.size() - 1) {
                layoutParams.bottomMargin = DensityUtils.a(this.mContext, 85.0f);
            } else {
                layoutParams.bottomMargin = 0;
            }
            couponViewHolder.b.setLayoutParams(layoutParams);
            if (bluedCoupon.ifShowUrlVisited) {
                return;
            }
            VipProtos.Event event = VipProtos.Event.ORDER_COUPON_SHOW;
            VipProtos.OrderType c2 = EventTrackVIP.c(bluedCoupon.type);
            EventTrackVIP.a(event, c2, bluedCoupon.id + "");
            bluedCoupon.ifShowUrlVisited = true;
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(Collection<? extends BluedCoupon> collection) {
        super.addData((Collection) collection);
        notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<BluedCoupon> list) {
        super.setNewData(list);
        notifyDataSetChanged();
    }
}
