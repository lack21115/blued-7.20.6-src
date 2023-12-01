package com.soft.blued.ui.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.ui.pay.adapter.CouponListAdapter;
import com.soft.blued.ui.pay.model.BluedCoupon;
import com.soft.blued.ui.pay.presenter.CouponPresenter;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/CouponFragment.class */
public class CouponFragment extends MvpFragment<CouponPresenter> {
    public static String b = "COUPON_RESULT";

    /* renamed from: a  reason: collision with root package name */
    public Context f19285a;

    /* renamed from: c  reason: collision with root package name */
    private CouponListAdapter f19286c;
    @BindView
    RecyclerView couponListView;
    @BindView
    NoDataAndLoadFailView noDataAndLoadFailView;
    @BindView
    CommonTopTitleNoTrans title;
    @BindView
    ShapeTextView tvUseBtn;

    private void a(int i) {
        BluedCoupon bluedCoupon;
        HashMap hashMap = new HashMap();
        int i2 = 0;
        if (this.f19286c.a() != null) {
            hashMap.put("id", String.valueOf(this.f19286c.a().id));
            hashMap.put("money", this.f19286c.a().money);
        } else {
            hashMap.put("id", "");
            hashMap.put("money", 0);
        }
        if (i == -1) {
            i2 = 1;
        }
        hashMap.put("is_confirm", Integer.valueOf(i2));
        Intent intent = new Intent();
        if (i == -1) {
            bluedCoupon = this.f19286c.a();
        } else {
            bluedCoupon = null;
            if (((CouponPresenter) j()).n > 0) {
                bluedCoupon = null;
                if (this.f19286c.a() != null) {
                    Iterator<BluedCoupon> it = this.f19286c.getData().iterator();
                    while (true) {
                        bluedCoupon = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        bluedCoupon = it.next();
                        if (bluedCoupon.id == ((CouponPresenter) j()).n) {
                            bluedCoupon.ifChoosed = true;
                            break;
                        }
                    }
                }
            }
        }
        LiveEventBus.get("select_coupon_model").post(bluedCoupon);
        intent.putExtra(b, this.f19286c.a());
        if (getActivity() != null) {
            getActivity().setResult(i, intent);
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        a(-1);
    }

    public static void a(Fragment fragment, int i, int i2, int i3) {
        if (i2 <= 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(CouponPresenter.j, i2);
        bundle.putInt(CouponPresenter.l, i3);
        TerminalActivity.a(fragment, CouponFragment.class, bundle, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        ((CouponPresenter) j()).f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        WebViewShowInfoFragment.show(this.f19285a, H5Url.a(45), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        Tracker.onClick(view);
        a(0);
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        this.f19285a = getActivity();
        CouponListAdapter couponListAdapter = new CouponListAdapter(this.f19285a, this.tvUseBtn);
        this.f19286c = couponListAdapter;
        couponListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.pay.-$$Lambda$CouponFragment$bw6CjYXHx7SSxsclZ4c4qWkjKRQ
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public final void onLoadMoreRequested() {
                CouponFragment.this.b();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f19285a);
        linearLayoutManager.setOrientation(1);
        this.couponListView.setAdapter(this.f19286c);
        this.couponListView.setLayoutManager(linearLayoutManager);
        this.title.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.-$$Lambda$CouponFragment$LsRemuzxNVl648wgUMnLxsrNvJI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CouponFragment.this.c(view);
            }
        });
        this.title.setRightText(this.f19285a.getResources().getString(R.string.use_manual));
        this.title.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.-$$Lambda$CouponFragment$sYwmufLfxaiIGhfnow9-awx8iic
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CouponFragment.this.b(view);
            }
        });
        this.tvUseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.-$$Lambda$CouponFragment$1cjmzWap0zCsI5qYNGjkdOyL0SI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CouponFragment.this.a(view);
            }
        });
        this.noDataAndLoadFailView.setNoDataImg(2131233628);
        this.noDataAndLoadFailView.setNoDataStr((int) R.string.no_available_coupon);
    }

    public void a(String str, List list) {
        super.a(str, list);
        if (list == null || list.size() == 0) {
            this.noDataAndLoadFailView.setVisibility(0);
            this.couponListView.setVisibility(8);
            CouponListAdapter.a(this.f19285a, this.tvUseBtn, false);
            return;
        }
        this.noDataAndLoadFailView.setVisibility(8);
        this.couponListView.setVisibility(0);
        this.f19286c.setNewData(list);
        if (this.f19286c.a() == null) {
            CouponListAdapter.a(this.f19285a, this.tvUseBtn, false);
        } else {
            CouponListAdapter.a(this.f19285a, this.tvUseBtn, true);
        }
    }

    public void a(String str, boolean z) {
        super.a(str, z);
        if (z || this.f19286c.getItemCount() != 0) {
            return;
        }
        this.noDataAndLoadFailView.setVisibility(0);
        this.couponListView.setVisibility(8);
        CouponListAdapter.a(this.f19285a, this.tvUseBtn, false);
    }

    public int g() {
        return R.layout.fragment_coupon;
    }

    public void o() {
        super.o();
        this.f19286c.setEnableLoadMore(true);
    }

    public boolean onBackPressed() {
        a(0);
        return true;
    }

    public void p() {
        super.p();
        this.f19286c.setEnableLoadMore(false);
    }
}
