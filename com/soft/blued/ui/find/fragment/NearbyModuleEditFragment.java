package com.soft.blued.ui.find.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.ui.find.adapter.ModuleEditAdapterForListview;
import com.soft.blued.ui.find.model.NearbyModule;
import com.soft.blued.ui.find.observer.PeopleDataObserver;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyModuleEditFragment.class */
public class NearbyModuleEditFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public Context f30433a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public CommonTopTitleNoTrans f30434c;
    public ListView d;
    public ModuleEditAdapterForListview e;
    public Dialog f;
    public NoDataAndLoadFailView g;
    public boolean h;
    public boolean i = false;
    public View.OnClickListener j = new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyModuleEditFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            NearbyModuleEditFragment.this.e();
        }
    };
    BluedUIHttpResponse k = new BluedUIHttpResponse<BluedEntityA<NearbyModule>>("nearby_module", getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.NearbyModuleEditFragment.5
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<NearbyModule> bluedEntityA) {
            NearbyModuleEditFragment.this.a(bluedEntityA);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: b */
        public void onUICache(BluedEntityA<NearbyModule> bluedEntityA) {
            NearbyModuleEditFragment.this.a(bluedEntityA);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            NearbyModuleEditFragment.this.h = true;
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            DialogUtils.b(NearbyModuleEditFragment.this.f);
            if (NearbyModuleEditFragment.this.h) {
                if (NearbyModuleEditFragment.this.e.getCount() == 0) {
                    NearbyModuleEditFragment.this.g.b();
                } else {
                    NearbyModuleEditFragment.this.g.d();
                }
            } else if (NearbyModuleEditFragment.this.e.getCount() == 0) {
                NearbyModuleEditFragment.this.g.a();
            } else {
                NearbyModuleEditFragment.this.g.d();
            }
            NearbyModuleEditFragment.this.e.notifyDataSetChanged();
            super.onUIFinish();
            NearbyModuleEditFragment.this.h = false;
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(NearbyModuleEditFragment.this.f);
        }
    };

    public void a() {
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.f30433a);
        this.g = noDataAndLoadFailView;
        noDataAndLoadFailView.d();
        this.g.setFailBtnVisibility(0);
        this.g.setFailBtnListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyModuleEditFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NearbyModuleEditFragment.this.d();
            }
        });
        this.f = DialogUtils.a(this.f30433a);
        this.d = (ListView) this.b.findViewById(R.id.rv_edit);
        ModuleEditAdapterForListview moduleEditAdapterForListview = new ModuleEditAdapterForListview(this.f30433a, this.j);
        this.e = moduleEditAdapterForListview;
        this.d.setAdapter((ListAdapter) moduleEditAdapterForListview);
        this.d.setEmptyView(this.g);
        this.e.notifyDataSetChanged();
        d();
    }

    public void a(BluedEntityA<NearbyModule> bluedEntityA) {
        if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
            return;
        }
        this.e.a(bluedEntityA.data);
    }

    public void b() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(2131370694);
        this.f30434c = commonTopTitleNoTrans;
        commonTopTitleNoTrans.a();
        this.f30434c.setCenterText(R.string.view_live_only);
        this.f30434c.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyModuleEditFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NearbyModuleEditFragment.this.c();
            }
        });
        this.f30434c.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.NearbyModuleEditFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NearbyModuleEditFragment.this.e();
            }
        });
    }

    public void c() {
        if (this.i) {
            PeopleDataObserver.a().c();
        }
        getActivity().finish();
    }

    public void d() {
        NearbyHttpUtils.a(this.k, "column", getFragmentActive());
    }

    public void e() {
        NearbyHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>(getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.NearbyModuleEditFragment.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLoginResult> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                UserInfo.getInstance().getLoginUserInfo().setCustom(bluedEntityA.data.get(0).getCustom());
                NearbyModuleEditFragment.this.i = true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }
        }, getFragmentActive(), this.e.a());
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        c();
        return true;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f30433a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_nearby_module_edit, viewGroup, false);
            a();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.k.refresh();
    }
}
