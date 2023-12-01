package com.blued.community.ui.circle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.community.R;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.circle.presenter.CircleSettingPresenter;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleSettingFragment.class */
public class CircleSettingFragment extends MvpFragment<CircleSettingPresenter> implements View.OnClickListener {
    private CommonTopTitleNoTrans a;
    private LinearLayout b;
    private LinearLayout c;
    private TextView d;
    private ImageView e;
    private Context f;
    private MyCircleModel g;

    public static void a(Context context, MyCircleModel myCircleModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("circle_data", myCircleModel);
        TerminalActivity.d(context, CircleSettingFragment.class, bundle);
    }

    private void b() {
        this.a = (CommonTopTitleNoTrans) this.i.findViewById(R.id.title);
        LinearLayout linearLayout = (LinearLayout) this.i.findViewById(R.id.ll_info_setting);
        this.b = linearLayout;
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) this.i.findViewById(R.id.ll_join_setting);
        this.c = linearLayout2;
        linearLayout2.setOnClickListener(this);
        this.d = (TextView) this.i.findViewById(R.id.tv_join_setting);
        this.e = (ImageView) this.i.findViewById(R.id.iv_join_setting_icon);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        b();
        this.f = getContext();
        this.g = j().m();
        if (j().m().is_disclosure == 0) {
            this.d.setTextColor(this.f.getResources().getColor(R.color.syc_i));
            this.e.setImageDrawable(BluedSkinUtils.b(this.f, R.drawable.icon_common_right_arrow_new_gray));
        }
        this.a.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleSettingFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CircleSettingFragment.this.t();
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_circle_setting;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.ll_info_setting) {
            EventTrackFeed.h(FeedProtos.Event.CIRCLE_SETTINGS_PAGE_INFO_CLICK, j().n());
            CircleInfoSettingFragment.a(getContext(), j().m());
        } else if (id == R.id.ll_join_setting && j().m().is_disclosure == 1) {
            CircleJoinSettingFragment.a(getContext(), this.g);
        }
    }
}
