package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveFansPrivilegeModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveFansPrivilegeAdapater.class */
public class LiveFansPrivilegeAdapater extends BaseQuickAdapter<LiveFansPrivilegeModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f11624a;
    private int b;

    public LiveFansPrivilegeAdapater(Context context, int i) {
        super(R.layout.live_fans_privilege_item_views);
        this.b = 0;
        this.f11624a = context;
        this.b = i;
        a();
        setNewData(a());
    }

    public List<LiveFansPrivilegeModel> a() {
        ArrayList arrayList = new ArrayList();
        LiveFansPrivilegeModel liveFansPrivilegeModel = new LiveFansPrivilegeModel(this.f11624a.getString(R.string.live_fans_privilege_one), this.f11624a.getString(R.string.live_fans_privilege_one_tip), R.drawable.live_privilege_one);
        LiveFansPrivilegeModel liveFansPrivilegeModel2 = new LiveFansPrivilegeModel(this.f11624a.getString(R.string.live_fans_privilege_two), this.f11624a.getString(R.string.live_fans_privilege_two_tip), R.drawable.live_privilege_two);
        LiveFansPrivilegeModel liveFansPrivilegeModel3 = new LiveFansPrivilegeModel(this.f11624a.getString(R.string.live_fans_privilege_three), this.f11624a.getString(R.string.live_fans_privilege_three_tip), R.drawable.live_privilege_three);
        LiveFansPrivilegeModel liveFansPrivilegeModel4 = new LiveFansPrivilegeModel(this.f11624a.getString(R.string.live_fans_privilege_four), String.format(this.f11624a.getString(R.string.live_fans_privilege_open_level), 6), R.drawable.live_privilege_four);
        LiveFansPrivilegeModel liveFansPrivilegeModel5 = new LiveFansPrivilegeModel(this.f11624a.getString(R.string.live_fans_privilege_five), String.format(this.f11624a.getString(R.string.live_fans_privilege_open_level), 16), R.drawable.live_privilege_five);
        LiveFansPrivilegeModel liveFansPrivilegeModel6 = new LiveFansPrivilegeModel(this.f11624a.getString(R.string.live_fans_privilege_six), String.format(this.f11624a.getString(R.string.live_fans_privilege_open_level), 26), R.drawable.live_privilege_six);
        arrayList.add(liveFansPrivilegeModel);
        arrayList.add(liveFansPrivilegeModel2);
        arrayList.add(liveFansPrivilegeModel3);
        arrayList.add(liveFansPrivilegeModel4);
        arrayList.add(liveFansPrivilegeModel5);
        arrayList.add(liveFansPrivilegeModel6);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, LiveFansPrivilegeModel liveFansPrivilegeModel) {
        if (this.b == 0) {
            baseViewHolder.getView(R.id.fl_view).setPadding(0, 0, 0, DensityUtils.a(this.f11624a, 20.0f));
        } else {
            baseViewHolder.getView(R.id.fl_view).setPadding(0, 0, 0, DensityUtils.a(this.f11624a, 10.0f));
        }
        ((ImageView) baseViewHolder.getView(R.id.iv_privilege)).setImageResource(liveFansPrivilegeModel.iconResourse);
        ((TextView) baseViewHolder.getView(R.id.tv_privilege_name)).setText(liveFansPrivilegeModel.name);
        ((TextView) baseViewHolder.getView(R.id.tv_privilege_des)).setText(liveFansPrivilegeModel.des);
    }
}
