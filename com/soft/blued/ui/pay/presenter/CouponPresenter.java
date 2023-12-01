package com.soft.blued.ui.pay.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.ui.pay.model.BluedCoupon;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/presenter/CouponPresenter.class */
public class CouponPresenter extends MvpPresenter {
    public static String j = "KEY_GOOD_ID";
    public static String l = "KEY_CHOOSED_COUPON_ID";
    public static String m = "KEY_RECOMMEND_TYPE";
    public int k;
    public int n;
    public int h = 1;
    public int i = 20;
    public int o = 0;

    private BluedUIHttpResponse c(final IFetchDataListener iFetchDataListener) {
        return new BluedUIHttpResponse<BluedEntityA<BluedCoupon>>("coupon_list", g()) { // from class: com.soft.blued.ui.pay.presenter.CouponPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedCoupon> bluedEntityA) {
                if (bluedEntityA != null) {
                    if (CouponPresenter.this.n > 0 && bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= bluedEntityA.data.size()) {
                                break;
                            }
                            if (CouponPresenter.this.n == ((BluedCoupon) bluedEntityA.data.get(i2)).id && ((BluedCoupon) bluedEntityA.data.get(i2)).is_available == 1) {
                                ((BluedCoupon) bluedEntityA.data.get(i2)).ifChoosed = true;
                            }
                            i = i2 + 1;
                        }
                    }
                    iFetchDataListener.a("fresh", bluedEntityA.data);
                    iFetchDataListener.b(bluedEntityA.hasMore());
                }
            }

            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                iFetchDataListener.a(z);
                if (z) {
                    return;
                }
                CouponPresenter.this.h--;
            }

            public void onUIStart() {
                super.onUIStart();
                iFetchDataListener.a();
            }
        };
    }

    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        if (bundle != null) {
            this.k = bundle.getInt(j);
            this.n = bundle.getInt(l);
            this.o = bundle.getInt(m);
        }
    }

    public void a(IFetchDataListener iFetchDataListener) {
        PayHttpUtils.a(c(iFetchDataListener), this.h, this.i, this.k, this.o, g());
    }

    public void b(IFetchDataListener iFetchDataListener) {
        this.h++;
        PayHttpUtils.a(c(iFetchDataListener), this.h, this.i, this.k, this.o, g());
    }
}
