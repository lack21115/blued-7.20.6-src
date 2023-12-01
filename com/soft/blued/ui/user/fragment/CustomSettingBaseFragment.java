package com.soft.blued.ui.user.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.user.adapter.VIPCustomSettingAdapter;
import com.soft.blued.ui.user.model.DynamicSkinModel;
import com.soft.blued.ui.user.model.VIPCustomSettingBase;
import com.soft.blued.ui.user.presenter.PayUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/CustomSettingBaseFragment.class */
public abstract class CustomSettingBaseFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f20155a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public Dialog f20156c;
    public PullToRefreshRecyclerView d;
    public RecyclerView e;
    public NoDataAndLoadFailView f;
    public VIPCustomSettingAdapter g;
    public int h;
    public int i;
    public String j;
    private VipProtos.FromType k = VipProtos.FromType.UNKNOWN_FROM;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/CustomSettingBaseFragment$CUSTOM_TYPE.class */
    public interface CUSTOM_TYPE {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        List<VIPCustomSettingBase> data = baseQuickAdapter.getData();
        VIPCustomSettingBase vIPCustomSettingBase = (VIPCustomSettingBase) data.get(i);
        if (vIPCustomSettingBase.selected != 1) {
            for (VIPCustomSettingBase vIPCustomSettingBase2 : data) {
                vIPCustomSettingBase2.selected = 0;
            }
            vIPCustomSettingBase.selected = 1;
        }
        this.g.notifyDataSetChanged();
        a(vIPCustomSettingBase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(VIPCustomSettingBase vIPCustomSettingBase, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        c(vIPCustomSettingBase);
    }

    private void c(final int i) {
        BluedUIHttpResponse<BluedEntityA<DynamicSkinModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<DynamicSkinModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.CustomSettingBaseFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<DynamicSkinModel> bluedEntityA) {
                CustomSettingBaseFragment.this.b(i);
                for (VIPCustomSettingBase vIPCustomSettingBase : CustomSettingBaseFragment.this.g.getData()) {
                    vIPCustomSettingBase.lastSelected = false;
                    if (vIPCustomSettingBase.id == i) {
                        vIPCustomSettingBase.lastSelected = true;
                    }
                }
                CustomSettingBaseFragment.this.g.notifyDataSetChanged();
            }

            public void onUIFinish() {
                CustomSettingBaseFragment.this.f20156c.dismiss();
            }

            public void onUIStart() {
                super.onUIStart();
                CustomSettingBaseFragment.this.f20156c.show();
            }
        };
        MineHttpUtils.a(bluedUIHttpResponse, i + "", b());
    }

    private void c(VIPCustomSettingBase vIPCustomSettingBase) {
        c(vIPCustomSettingBase.id);
        a(vIPCustomSettingBase.id);
    }

    private void k() {
        this.i = getArguments().getInt("KEY_VIP_GRADE");
        this.j = getArguments().getString("KEY_VIP_DETAIL");
        this.k = (VipProtos.FromType) getArguments().getSerializable("KEY_VIP_FROM_TYPE");
    }

    private void l() {
        CommonTopTitleNoTrans findViewById = this.b.findViewById(R.id.top_title);
        findViewById.setCenterText(c());
        findViewById.setLeftClickListener(this);
        findViewById.setLeftImg(2131233903);
        findViewById.setCenterTextColor(2131101780);
        findViewById.f();
        findViewById.a();
    }

    private void m() {
        this.f20156c = DialogUtils.a(this.f20155a);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.f20155a);
        this.f = noDataAndLoadFailView;
        noDataAndLoadFailView.d();
        this.f.setImageScale(0.7f);
        this.f.setNoDataImg(2131233627);
        PullToRefreshRecyclerView findViewById = this.b.findViewById(R.id.wrapper);
        this.d = findViewById;
        findViewById.setRefreshEnabled(false);
        this.e = (RecyclerView) this.d.getRefreshableView();
        this.e.setLayoutManager(new GridLayoutManager(this.f20155a, 3));
        VIPCustomSettingAdapter vIPCustomSettingAdapter = new VIPCustomSettingAdapter(this.f20155a, this.i, this.j, e(), a(), g());
        this.g = vIPCustomSettingAdapter;
        vIPCustomSettingAdapter.setEmptyView((View) this.f);
        View view = new View(this.f20155a);
        view.setLayoutParams(new ViewGroup.LayoutParams(0, DensityUtils.a(this.f20155a, 75.0f)));
        this.g.addFooterView(view);
        this.e.setAdapter(this.g);
        this.g.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$CustomSettingBaseFragment$EB-xRAIXMykymfyqLcJGZjQVxW8
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                CustomSettingBaseFragment.this.a(baseQuickAdapter, view2, i);
            }
        });
    }

    private void n() {
        MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<VIPCustomSettingBase>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.CustomSettingBaseFragment.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VIPCustomSettingBase> bluedEntityA) {
                Log.v("drb", "getBluedTheme onUIUpdate");
                boolean z = true;
                DynamicSkinModel dynamicSkinModel = new DynamicSkinModel(true, 1, true);
                dynamicSkinModel.name = CustomSettingBaseFragment.this.f20155a.getResources().getString(R.string.default_theme);
                CustomSettingBaseFragment.this.g.addData((VIPCustomSettingAdapter) dynamicSkinModel);
                if (bluedEntityA.hasData()) {
                    Iterator it = bluedEntityA.data.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        VIPCustomSettingBase vIPCustomSettingBase = (VIPCustomSettingBase) it.next();
                        if (vIPCustomSettingBase.selected == 1) {
                            vIPCustomSettingBase.lastSelected = true;
                            CustomSettingBaseFragment.this.h = vIPCustomSettingBase.id;
                            dynamicSkinModel.selected = 0;
                            dynamicSkinModel.lastSelected = false;
                            CustomSettingBaseFragment.this.b(vIPCustomSettingBase);
                            break;
                        }
                    }
                    if (!z) {
                        CustomSettingBaseFragment.this.b(dynamicSkinModel);
                    }
                    CustomSettingBaseFragment.this.g.addData((Collection) bluedEntityA.data);
                }
            }

            public boolean onUIFailure(int i, String str) {
                Log.v("drb", "getBluedTheme onUIFailure");
                if (CustomSettingBaseFragment.this.g.getData().size() == 0) {
                    CustomSettingBaseFragment.this.g.addData((VIPCustomSettingAdapter) new DynamicSkinModel(true, 1, true));
                }
                return super.onUIFailure(i, str);
            }

            public void onUIFinish() {
                CustomSettingBaseFragment.this.f20156c.dismiss();
            }

            public void onUIStart() {
                super.onUIStart();
                CustomSettingBaseFragment.this.f20156c.show();
            }
        }, b());
    }

    public abstract int a();

    public abstract void a(int i);

    public abstract void a(VIPCustomSettingBase vIPCustomSettingBase);

    public abstract String b();

    public abstract void b(int i);

    public abstract void b(VIPCustomSettingBase vIPCustomSettingBase);

    public abstract String c();

    public abstract int d();

    public abstract Drawable e();

    public abstract int f();

    public abstract int g();

    public boolean h() {
        return UserInfo.getInstance().getLoginUserInfo().vip_grade != 0;
    }

    public void i() {
        PayUtils.a(this.f20155a, this.i, this.j, d(), this.k);
    }

    public void j() {
        for (final VIPCustomSettingBase vIPCustomSettingBase : this.g.getData()) {
            if (vIPCustomSettingBase.selected == 1) {
                if (vIPCustomSettingBase.is_termination != 1) {
                    c(vIPCustomSettingBase);
                    return;
                }
                String string = this.f20155a.getResources().getString(R.string.limit_good_dialog_content);
                String format = String.format(string, TimeAndDateUtils.b(vIPCustomSettingBase.stop_time + ""));
                Context context = this.f20155a;
                CommonAlertDialog.a(context, "", format, context.getResources().getString(2131886739), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$CustomSettingBaseFragment$UhAVCHKpDJkqmkXja3HevLiLZGk
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        CustomSettingBaseFragment.this.a(vIPCustomSettingBase, dialogInterface, i);
                    }
                }, this.f20155a.getResources().getString(2131886718), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131363126) {
        } else {
            j();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20155a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(f(), viewGroup, false);
            k();
            l();
            m();
            n();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
