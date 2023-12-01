package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.SpacesItemDecoration;
import com.soft.blued.ui.msg.adapter.GiftVoucherAdapter;
import com.soft.blued.ui.msg.event.UpdateVoucherEvent;
import com.soft.blued.ui.msg.model.GiftVoucherModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/GiftVoucherPop.class */
public class GiftVoucherPop extends BottomPopupView {
    public static GiftVoucherPop b;

    /* renamed from: c  reason: collision with root package name */
    public List<GiftVoucherModel> f32484c;
    public double d;
    public GiftVoucherModel e;
    private CommonTopTitleNoTrans f;
    private GiftVoucherAdapter g;
    private RecyclerView h;
    private boolean i;

    public GiftVoucherPop(Context context) {
        super(context);
        this.g = new GiftVoucherAdapter();
    }

    private void c() {
        UpdateVoucherEvent updateVoucherEvent = new UpdateVoucherEvent();
        updateVoucherEvent.f32330a = this.e;
        updateVoucherEvent.b = this.i;
        LiveEventBus.get(EventBusConstant.KEY_EVENT_UPDATE_VOUCHER).post(updateVoucherEvent);
        b = null;
        this.e = null;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        b = this;
        findViewById(2131369389).setBackgroundDrawable(BluedSkinUtils.b(getContext(), R.drawable.shape_gift_voucher_pop_bg));
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) findViewById(2131370749);
        this.f = commonTopTitleNoTrans;
        commonTopTitleNoTrans.getRightImg().setImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.icon_gift_voucher_help));
        this.f.setLeftImg(2131233902);
        this.f.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.GiftVoucherPop.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                new XPopup.Builder(GiftVoucherPop.this.getContext()).a((BasePopupView) new GiftVoucherHelpPop(GiftVoucherPop.this.getContext())).h();
            }
        });
        this.f.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.GiftVoucherPop.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GiftVoucherPop.this.p();
            }
        });
        this.f.setCenterText(getContext().getString(R.string.voucher));
        ViewGroup.LayoutParams layoutParams = this.f.getContent().getLayoutParams();
        layoutParams.height = DensityUtils.a(getContext(), 50.0f);
        this.f.getContent().setLayoutParams(layoutParams);
        RecyclerView recyclerView = (RecyclerView) findViewById(2131369096);
        this.h = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(0, 0, 0, DensityUtils.a(AppInfo.d(), 9.0f));
        spacesItemDecoration.a(1);
        this.h.addItemDecoration(spacesItemDecoration);
        this.g.f31977a = this.d;
        this.h.setAdapter(this.g);
        this.g.setNewData(this.f32484c);
        this.g.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg.pop.GiftVoucherPop.3
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                if (baseQuickAdapter.getData().size() <= 0 || baseQuickAdapter.getData().size() <= i - 1) {
                    return;
                }
                GiftVoucherModel giftVoucherModel = (GiftVoucherModel) baseQuickAdapter.getData().get(i);
                if (giftVoucherModel.money < GiftVoucherPop.this.d || giftVoucherModel.isExpire) {
                    return;
                }
                if (GiftVoucherPop.this.e == null || giftVoucherModel != GiftVoucherPop.this.e) {
                    if (GiftVoucherPop.this.e != null) {
                        GiftVoucherPop.this.e.isChecked = false;
                    }
                    GiftVoucherPop.this.e = giftVoucherModel;
                    GiftVoucherPop.this.e.isChecked = true;
                } else {
                    GiftVoucherPop.this.e.isChecked = false;
                    GiftVoucherPop.this.e = null;
                }
                baseQuickAdapter.notifyDataSetChanged();
            }
        });
        findViewById(2131372161).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.GiftVoucherPop.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GiftVoucherPop.this.i = true;
                GiftVoucherPop.this.p();
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_gift_voucher;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void r() {
        c();
        super.r();
    }
}
