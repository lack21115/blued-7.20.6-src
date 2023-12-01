package com.soft.blued.ui.msg.customview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.soft.blued.R;
import com.soft.blued.ui.msg.model.UserGiftPackageModel;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import java.text.DecimalFormat;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/customview/GiftGivingOptionViewNew.class */
public class GiftGivingOptionViewNew extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f32274a;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public View f32275c;
    private ShapeLinearLayout d;
    private TextView e;
    private TextView f;
    private ImageView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;

    public GiftGivingOptionViewNew(Context context) {
        super(context);
        this.f32274a = 2;
        this.b = context;
        a();
    }

    public GiftGivingOptionViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32274a = 2;
        this.b = context;
        a();
    }

    public GiftGivingOptionViewNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f32274a = 2;
        this.b = context;
        a();
    }

    private String a(long j) {
        String str = 0 + getContext().getString(R.string.msg_minute);
        if (j > 60) {
            long j2 = j / 60;
            str = j2 + getContext().getString(R.string.msg_minute);
            if (j2 > 60) {
                long j3 = j2 % 60;
                long j4 = j2 / 60;
                str = j4 + getContext().getString(R.string.msg_hour) + j3 + getContext().getString(R.string.msg_minute);
                if (j4 > 24) {
                    return (j4 / 24) + getContext().getString(R.string.msg_day) + (j4 % 24) + getContext().getString(R.string.msg_hour) + j3 + getContext().getString(R.string.msg_minute);
                }
            }
        }
        return str;
    }

    public void a() {
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.item_gift_giving_option_dialog_new, this);
        this.f32275c = inflate;
        this.d = (ShapeLinearLayout) inflate.findViewById(R.id.ll_item);
        this.g = (ImageView) this.f32275c.findViewById(2131364552);
        this.h = (TextView) this.f32275c.findViewById(2131372046);
        this.e = (TextView) this.f32275c.findViewById(R.id.tv_per_amount);
        this.f = (TextView) this.f32275c.findViewById(R.id.tv_favourate);
        this.i = (TextView) this.f32275c.findViewById(R.id.tv_stock);
        this.j = (TextView) this.f32275c.findViewById(2131372795);
        this.k = (TextView) this.f32275c.findViewById(R.id.tv_package_cnt);
    }

    public void a(IRequestHost iRequestHost, UserGiftPackageModel userGiftPackageModel) {
        if (userGiftPackageModel.gift_detail == null) {
            return;
        }
        TextView textView = this.k;
        textView.setText(userGiftPackageModel.num + "");
        this.k.setVisibility(0);
        a(iRequestHost, userGiftPackageModel.gift_detail, userGiftPackageModel.chosen);
        if (userGiftPackageModel.end_time == 0) {
            this.e.setVisibility(4);
            return;
        }
        long j = userGiftPackageModel.end_time;
        long currentTimeMillis = System.currentTimeMillis();
        this.e.setVisibility(0);
        this.e.setText(a(((j * 1000) - currentTimeMillis) / 1000));
    }

    public void a(IRequestHost iRequestHost, GiftGivingOptionForJsonParse giftGivingOptionForJsonParse, boolean z) {
        if (z) {
            this.k.setTextColor(ContextCompat.getColor(getContext(), 2131102478));
            this.k.setBackgroundResource(R.drawable.shape_gift_giving_package_bg);
            ShapeHelper.b(this.d, 2131102404);
            ShapeHelper.d(this.d, 2131102241);
            if (giftGivingOptionForJsonParse.is_free == 2) {
                this.f.setVisibility(0);
                this.f.setText(giftGivingOptionForJsonParse.description);
            } else {
                this.f.setVisibility(4);
            }
            this.f.setBackground(this.b.getResources().getDrawable(R.drawable.shape_buy_privilege_favourate));
            if (giftGivingOptionForJsonParse.is_stock == 1) {
                this.i.setText("1");
                this.i.setTextColor(this.b.getResources().getColor(2131102173));
                this.i.setBackground(this.b.getResources().getDrawable(R.drawable.shape_gift_giving_stock_bg));
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(4);
            }
        } else {
            this.k.setTextColor(ContextCompat.getColor(getContext(), 2131102263));
            this.k.setBackgroundResource(R.drawable.shape_gift_package_bg_normal);
            ShapeHelper.b(this.d, 2131102170);
            ShapeHelper.d(this.d, 2131102170);
            this.f.setVisibility(4);
            if (giftGivingOptionForJsonParse.is_stock == 1) {
                this.i.setText("1");
                this.i.setTextColor(this.b.getResources().getColor(2131102205));
                this.i.setBackground(this.b.getResources().getDrawable(R.drawable.shape_gift_giving_stock_gray_bg));
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(4);
            }
        }
        if (giftGivingOptionForJsonParse.is_free == 2) {
            this.e.getPaint().setFlags(17);
        } else {
            this.e.getPaint().setFlags(1);
        }
        if (giftGivingOptionForJsonParse.type == -1 && !TextUtils.isEmpty(giftGivingOptionForJsonParse.label)) {
            if (giftGivingOptionForJsonParse.chosen) {
                this.f.setVisibility(0);
                this.f.setText(giftGivingOptionForJsonParse.label);
            } else {
                this.f.setVisibility(4);
            }
        }
        ImageLoader.a(iRequestHost, giftGivingOptionForJsonParse.icon).a(16.0f).a(this.g);
        if (!BlueAppLocal.d()) {
            this.h.setText(giftGivingOptionForJsonParse.gift_name_en);
        } else if ("CN".equals(BlueAppLocal.c().getCountry().toUpperCase())) {
            this.h.setText(giftGivingOptionForJsonParse.gift_name_cn);
        } else {
            this.h.setText(giftGivingOptionForJsonParse.gift_name_tw);
        }
        if (this.f32274a != 3) {
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            TextView textView = this.e;
            textView.setText("¥" + decimalFormat.format(giftGivingOptionForJsonParse.money));
        } else {
            TextView textView2 = this.e;
            textView2.setText(giftGivingOptionForJsonParse.beans + getContext().getString(2131889580));
        }
        if (giftGivingOptionForJsonParse.type == 2) {
            this.j.setVisibility(0);
        } else if (giftGivingOptionForJsonParse.type != 3) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
            this.j.setText(getContext().getString(R.string.msg_gift_card));
        }
    }
}
