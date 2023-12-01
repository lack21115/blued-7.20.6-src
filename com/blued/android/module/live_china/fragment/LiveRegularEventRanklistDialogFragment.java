package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveRankGuestListItemAdapter;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.BluedLiveRankListData;
import com.blued.android.module.live_china.model.LiveEventRankExtra;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRegularEventRanklistDialogFragment.class */
public class LiveRegularEventRanklistDialogFragment extends BaseDialogFragment {
    public static String a = "LID";
    ILiveHostDialog b;
    public RenrenPullToRefreshListView c;
    public ListView d;
    public LiveRankGuestListItemAdapter e;
    public TextView f;
    public Context g;
    public int h = 1;
    public boolean i = true;
    public View j;
    public View k;
    public View l;
    private long m;
    private String n;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRegularEventRanklistDialogFragment$ILiveHostDialog.class */
    public interface ILiveHostDialog {
        void a();

        void b();
    }

    private void h() {
        if (getArguments() != null) {
            this.m = getArguments().getLong(a);
            this.n = getArguments().getString("activity_id");
        }
    }

    public void a(boolean z) {
        if (z) {
            this.h = 1;
        } else {
            this.h++;
        }
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedLiveRankListData, LiveEventRankExtra>>() { // from class: com.blued.android.module.live_china.fragment.LiveRegularEventRanklistDialogFragment.3
            boolean a = false;

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                this.a = true;
                LiveRegularEventRanklistDialogFragment.this.h--;
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                if (this.a) {
                    LiveRegularEventRanklistDialogFragment.this.f();
                } else if (LiveRegularEventRanklistDialogFragment.this.e.getCount() == 0) {
                    LiveRegularEventRanklistDialogFragment.this.d();
                } else {
                    LiveRegularEventRanklistDialogFragment.this.g();
                }
                if (LiveRegularEventRanklistDialogFragment.this.i) {
                    LiveRegularEventRanklistDialogFragment.this.c.o();
                } else {
                    LiveRegularEventRanklistDialogFragment.this.c.p();
                }
                LiveRegularEventRanklistDialogFragment.this.c.q();
                LiveRegularEventRanklistDialogFragment.this.c.j();
                this.a = false;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                if (LiveRegularEventRanklistDialogFragment.this.h == 1) {
                    LiveRegularEventRanklistDialogFragment.this.e();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedLiveRankListData, LiveEventRankExtra> bluedEntity) {
                if (bluedEntity.extra != null) {
                    if (!TextUtils.isEmpty(bluedEntity.extra.title)) {
                        LiveRegularEventRanklistDialogFragment.this.f.setText(bluedEntity.extra.title);
                    }
                    if (!TextUtils.isEmpty(bluedEntity.extra.label)) {
                        LiveRegularEventRanklistDialogFragment.this.e.a(bluedEntity.extra.label);
                    }
                }
                if (bluedEntity != null && bluedEntity.data != null && bluedEntity.data.size() > 0) {
                    if (LiveRegularEventRanklistDialogFragment.this.h == 1) {
                        LiveRegularEventRanklistDialogFragment.this.e.a(bluedEntity.data);
                    } else {
                        LiveRegularEventRanklistDialogFragment.this.e.b(bluedEntity.data);
                    }
                }
                LiveRegularEventRanklistDialogFragment.this.i = bluedEntity.hasMore();
            }
        }, this.h, String.valueOf(this.m), this.n, new ActivityFragmentActive(getLifecycle()));
    }

    public void d() {
        this.j.setVisibility(0);
        this.k.setVisibility(8);
        this.c.setVisibility(8);
        this.l.setVisibility(8);
    }

    public void e() {
        this.l.setVisibility(0);
        this.k.setVisibility(8);
        this.c.setVisibility(8);
        this.j.setVisibility(8);
    }

    public void f() {
        this.k.setVisibility(0);
        this.l.setVisibility(8);
        this.c.setVisibility(8);
        this.j.setVisibility(8);
    }

    public void g() {
        this.c.setVisibility(0);
        this.l.setVisibility(8);
        this.k.setVisibility(8);
        this.j.setVisibility(8);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        boolean C = LiveFloatManager.a().C();
        View inflate = getActivity().getLayoutInflater().inflate(C ? R.layout.dialog_live_regular_event_rank_land : R.layout.dialog_live_regular_event_rank, (ViewGroup) null);
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        if (C) {
            dialog.setContentView(inflate, new ViewGroup.LayoutParams(DensityUtils.a(getActivity(), 360.0f), -1));
        } else {
            dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, DensityUtils.a(getActivity(), 290.0f)));
        }
        Window window = dialog.getWindow();
        window.setWindowAnimations(C ? R.style.rank_menu_animstyle : R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        attributes.width = C ? DensityUtils.a(getActivity(), 360.0f) : -1;
        attributes.height = C ? -1 : DensityUtils.a(getActivity(), 290.0f);
        attributes.gravity = 5;
        dialog.onWindowAttributesChanged(attributes);
        h();
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.g = getActivity();
        View inflate = layoutInflater.inflate(R.layout.dialog_live_regular_event_rank, viewGroup);
        this.j = inflate.findViewById(R.id.ll_nodata);
        this.k = inflate.findViewById(R.id.ll_error);
        this.l = inflate.findViewById(R.id.loading_view);
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) inflate.findViewById(R.id.rptrlv_live_list);
        this.c = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(false);
        this.d = (ListView) this.c.getRefreshableView();
        this.f = (TextView) inflate.findViewById(R.id.tv_rank_title);
        this.c.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.blued.android.module.live_china.fragment.LiveRegularEventRanklistDialogFragment.1
            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void a() {
                LiveRegularEventRanklistDialogFragment.this.a(true);
            }

            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void b() {
                LiveRegularEventRanklistDialogFragment.this.a(false);
            }
        });
        this.d.setDivider(null);
        this.d.setSelector(new ColorDrawable(0));
        LiveRankGuestListItemAdapter liveRankGuestListItemAdapter = new LiveRankGuestListItemAdapter(this, new ArrayList(), true, false, a());
        this.e = liveRankGuestListItemAdapter;
        this.d.setAdapter((ListAdapter) liveRankGuestListItemAdapter);
        ILiveHostDialog iLiveHostDialog = this.b;
        if (iLiveHostDialog != null) {
            iLiveHostDialog.a();
        }
        this.c.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.LiveRegularEventRanklistDialogFragment.2
            @Override // java.lang.Runnable
            public void run() {
                LiveRegularEventRanklistDialogFragment.this.c.k();
            }
        }, 100L);
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        ILiveHostDialog iLiveHostDialog = this.b;
        if (iLiveHostDialog != null) {
            iLiveHostDialog.b();
        }
    }
}
