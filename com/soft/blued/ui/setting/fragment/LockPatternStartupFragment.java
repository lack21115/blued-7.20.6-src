package com.soft.blued.ui.setting.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.constant.CommonConstants;
import com.soft.blued.customview.LockPatternView;
import com.soft.blued.ui.login_register.SignInActivity;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/LockPatternStartupFragment.class */
public class LockPatternStartupFragment extends BaseFragment implements View.OnClickListener, LockPatternView.OnPatternListener {

    /* renamed from: a  reason: collision with root package name */
    private LockPatternView f19711a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f19712c;
    private ImageView d;
    private View e;
    private int f = 0;

    private void c() {
        LockPatternView lockPatternView = (LockPatternView) this.e.findViewById(R.id.lock_pattern);
        this.f19711a = lockPatternView;
        lockPatternView.setOnPatternListener(this);
        this.b = (TextView) this.e.findViewById(R.id.lock_pattern_enter);
        this.f19712c = (TextView) this.e.findViewById(R.id.tv_forgot_pattern);
        this.d = (ImageView) this.e.findViewById(R.id.iv_user_profile_pic);
        this.f19712c.setOnClickListener(this);
        if (UserInfo.getInstance().getLoginUserInfo() != null) {
            ImageLoader.a(getFragmentActive(), UserInfo.getInstance().getLoginUserInfo().getAvatar()).c().b(2131237310).a(this.d);
        }
    }

    @Override // com.soft.blued.customview.LockPatternView.OnPatternListener
    public void a() {
    }

    @Override // com.soft.blued.customview.LockPatternView.OnPatternListener
    public void a(List<LockPatternView.Cell> list) {
    }

    @Override // com.soft.blued.customview.LockPatternView.OnPatternListener
    public void b() {
    }

    @Override // com.soft.blued.customview.LockPatternView.OnPatternListener
    public void b(List<LockPatternView.Cell> list) {
        if (LockPatternView.a(list).equals(BluedPreferences.bb())) {
            LiveFloatManager.a().k();
            getActivity().finish();
            return;
        }
        int i = this.f + 1;
        this.f = i;
        if (i > 4) {
            CommonConstants.f14625a = true;
            SignInActivity.d = true;
            UserRelationshipUtils.a("", new int[0]);
            BluedPreferences.F(false);
            BluedPreferences.F("");
            getActivity().finish();
            return;
        }
        this.f19711a.setDisplayMode(LockPatternView.DisplayMode.Wrong);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.LockPatternStartupFragment.2
            @Override // java.lang.Runnable
            public void run() {
                LockPatternStartupFragment.this.f19711a.a();
                LockPatternStartupFragment.this.f19711a.c();
            }
        }, 500L);
        TextView textView = this.b;
        textView.setText(((Object) getResources().getText(R.string.lock_pattern_input_error)) + "" + (5 - this.f) + "" + ((Object) getResources().getText(R.string.lock_pattern_input_count)));
        this.b.setTextColor(getResources().getColor(2131100314));
        this.b.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.input_error_shake));
    }

    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    public boolean onBackPressed() {
        getActivity().finish();
        AppUtils.a(AppInfo.d());
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131371488) {
            return;
        }
        CommonAlertDialog.a(getActivity(), "", getResources().getString(R.string.lock_pattern_forgot_confirm), getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.LockPatternStartupFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                CommonConstants.f14625a = true;
                SignInActivity.d = true;
                UserRelationshipUtils.a("", new int[0]);
                BluedPreferences.F(false);
                BluedPreferences.F("");
                LockPatternStartupFragment.this.getActivity().finish();
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.e;
        if (view == null) {
            this.e = layoutInflater.inflate(R.layout.fragment_lock_pattern_startup, viewGroup, false);
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.e.getParent()).removeView(this.e);
        }
        return this.e;
    }

    public void onDestroy() {
        CommonConstants.b = false;
        super.onDestroy();
    }

    public void onStart() {
        CommonConstants.b = true;
        super.onStart();
    }
}
