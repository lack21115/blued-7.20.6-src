package com.soft.blued.ui.mine.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.user.model.UserInfo;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/MineSettingDialogFragment.class */
public class MineSettingDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f17938a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f17939c;
    private TextView d;
    private ToggleButton e;
    private ToggleButton f;
    private boolean g;
    private boolean h;
    private OnMineSettingListener i;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/MineSettingDialogFragment$OnMineSettingListener.class */
    public interface OnMineSettingListener {
        void a(boolean z, boolean z2);
    }

    private void h() {
        ShapeHelper.b(this.b.findViewById(R.id.layout_read_auth), 2131101780);
        this.f17939c = (ImageView) this.b.findViewById(2131365207);
        this.d = (TextView) this.b.findViewById(R.id.tv_done);
        this.f17939c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e = (ToggleButton) this.b.findViewById(R.id.tglbtn_last_operate_onoff);
        this.f = (ToggleButton) this.b.findViewById(R.id.tglbtn_distance_onoff);
        this.e.setChecked(this.g);
        this.f.setChecked(this.h);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int i = UserInfo.getInstance().getLoginUserInfo().vip_grade;
        switch (view.getId()) {
            case 2131365207:
                dismiss();
                return;
            case R.id.tglbtn_distance_onoff /* 2131370647 */:
                if (i == 0 && BluedConfig.a().g().is_hide_distance == 0) {
                    this.f.setChecked(false);
                    PayUtils.a(getActivity(), 1, "mine_hide_distance");
                    return;
                }
                return;
            case R.id.tglbtn_last_operate_onoff /* 2131370651 */:
                if (i == 0 && BluedConfig.a().g().is_hide_last_operate == 0) {
                    this.e.setChecked(false);
                    PayUtils.a(getActivity(), 0, "mine_hide_time");
                    return;
                }
                return;
            case R.id.tv_done /* 2131371293 */:
                OnMineSettingListener onMineSettingListener = this.i;
                if (onMineSettingListener != null && i != 0) {
                    onMineSettingListener.a(this.e.isChecked(), this.f.isChecked());
                }
                dismiss();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f17938a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.dialog_mine_setting, viewGroup, false);
            h();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
