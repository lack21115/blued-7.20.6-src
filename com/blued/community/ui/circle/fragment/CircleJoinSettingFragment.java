package com.blued.community.ui.circle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.community.R;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.circle.presenter.CircleJoinSettingPresenter;
import com.blued.community.utils.CommunityPreferences;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleJoinSettingFragment.class */
public class CircleJoinSettingFragment extends MvpFragment<CircleJoinSettingPresenter> implements View.OnClickListener {
    private CommonTopTitleNoTrans a;
    private LinearLayout b;
    private ImageView c;
    private LinearLayout d;
    private ImageView e;
    private boolean f = false;
    private String g = "";

    public static void a(Context context, MyCircleModel myCircleModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("circle_data", myCircleModel);
        TerminalActivity.d(context, CircleJoinSettingFragment.class, bundle);
    }

    private void c() {
        this.a = (CommonTopTitleNoTrans) this.i.findViewById(R.id.title);
        LinearLayout linearLayout = (LinearLayout) this.i.findViewById(R.id.ll_direct);
        this.b = linearLayout;
        linearLayout.setOnClickListener(this);
        this.c = (ImageView) this.i.findViewById(R.id.iv_direct);
        LinearLayout linearLayout2 = (LinearLayout) this.i.findViewById(R.id.ll_apply);
        this.d = linearLayout2;
        linearLayout2.setOnClickListener(this);
        this.e = (ImageView) this.i.findViewById(R.id.iv_apply);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        c();
        if (CommunityPreferences.c()) {
            this.c.setVisibility(0);
            this.e.setVisibility(8);
        } else {
            this.c.setVisibility(8);
            this.e.setVisibility(0);
        }
        this.a.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleJoinSettingFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CircleJoinSettingFragment.this.b();
            }
        });
    }

    public void b() {
        if (this.f) {
            j().d(this.g);
        }
        getActivity().finish();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_circle_join_setting;
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        b();
        return super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.ll_direct) {
            this.c.setVisibility(0);
            this.e.setVisibility(8);
            this.g = "1";
            this.f = true;
            CommunityPreferences.a("1".equals("1"));
        } else if (id == R.id.ll_apply) {
            this.c.setVisibility(8);
            this.e.setVisibility(0);
            this.g = "0";
            this.f = true;
            CommunityPreferences.a("0".equals("1"));
        }
    }
}
