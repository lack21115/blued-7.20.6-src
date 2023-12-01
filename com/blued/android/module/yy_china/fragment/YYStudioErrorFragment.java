package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.yy_china.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYStudioErrorFragment.class */
public class YYStudioErrorFragment extends MvpFragment<MvpPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f17457a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f17458c;
    private ImageView d;

    public static void a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("error_msg", str);
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        TerminalActivity.d(context, YYStudioErrorFragment.class, bundle);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f17457a = (ImageView) this.i.findViewById(R.id.img_right);
        this.b = (TextView) this.i.findViewById(R.id.tv_error);
        this.f17458c = (RelativeLayout) this.i.findViewById(R.id.ll_common_title);
        this.d = (ImageView) this.i.findViewById(R.id.ctt_left);
        if (StatusBarHelper.a()) {
            this.f17458c.setPadding(0, StatusBarHelper.a((Context) getActivity()), 0, 0);
            ((FrameLayout.LayoutParams) this.f17457a.getLayoutParams()).topMargin = DensityUtils.a(getContext(), 35.0f) + StatusBarHelper.a(getContext());
        }
        this.f17458c.setBackgroundColor(getResources().getColor(R.color.transparent));
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.YYStudioErrorFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYStudioErrorFragment.this.t();
            }
        });
        this.b.setText(getArguments().getString("error_msg"));
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_yy_studio_error_layout;
    }
}
