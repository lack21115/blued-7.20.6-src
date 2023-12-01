package com.soft.blued.ui.setting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.constant.CommonConstants;
import com.soft.blued.customview.LockIndicator;
import com.soft.blued.customview.LockPatternView;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/LockPatternSetupFragment.class */
public class LockPatternSetupFragment extends BaseFragment implements View.OnClickListener, LockPatternView.OnPatternListener {

    /* renamed from: a  reason: collision with root package name */
    private View f19707a;
    private LockPatternView b;

    /* renamed from: c  reason: collision with root package name */
    private LockIndicator f19708c;
    private TextView d;
    private int e;
    private List<LockPatternView.Cell> f;
    private boolean g = false;
    private List<String> h = new ArrayList();
    private boolean i = true;

    private void a(String str) {
        this.f19708c.setPath(str);
    }

    private void c() {
        LockPatternView lockPatternView = (LockPatternView) this.f19707a.findViewById(R.id.lock_pattern);
        this.b = lockPatternView;
        lockPatternView.setOnPatternListener(this);
        this.f19708c = (LockIndicator) this.f19707a.findViewById(R.id.lock_indicator);
        this.d = (TextView) this.f19707a.findViewById(R.id.lock_pattern_hint);
    }

    private void d() {
        CommonTopTitleNoTrans findViewById = this.f19707a.findViewById(R.id.top_title);
        findViewById.a();
        findViewById.setCenterText(getString(R.string.gesture_pwd));
        findViewById.setLeftClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int i = this.e;
        if (i == 1) {
            this.f = null;
            this.g = false;
            this.b.a();
            this.b.c();
        } else if (i == 2) {
            this.b.b();
        } else if (i == 3) {
            this.b.a();
            this.b.c();
        } else if (i != 4) {
        } else {
            if (!this.g) {
                this.b.setDisplayMode(LockPatternView.DisplayMode.Wrong);
                this.b.c();
                return;
            }
            this.b.b();
            AppMethods.a(getResources().getString(R.string.lock_pattern_success_set));
            BluedPreferences.F(LockPatternView.a(this.f));
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.LockPatternSetupFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    Bundle arguments = LockPatternSetupFragment.this.getArguments();
                    if (arguments != null) {
                        String string = arguments.getString("FRAGMENT_NAME_KEY");
                        if (!StringUtils.d(string) && string.equals(GestureLockSettingFragment.class.getSimpleName())) {
                            TerminalActivity.d(LockPatternSetupFragment.this.getActivity(), GestureLockSettingFragment.class, (Bundle) null);
                        }
                    } else {
                        CommonConstants.f14625a = false;
                        BluedPreferences.F(true);
                    }
                    LockPatternSetupFragment.this.getActivity().finish();
                }
            }, 500L);
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
        if (list.size() < 4 && this.i) {
            this.d.setText(getResources().getText(R.string.draw_lock_pattern_error));
            this.d.setTextColor(getResources().getColor(2131100314));
            this.b.setDisplayMode(LockPatternView.DisplayMode.Wrong);
            this.e = 1;
            e();
            return;
        }
        List<LockPatternView.Cell> list2 = this.f;
        if (list2 != null) {
            if (list2.equals(list)) {
                this.g = true;
                this.e = 4;
                e();
                return;
            }
            this.g = false;
            this.b.setDisplayMode(LockPatternView.DisplayMode.Wrong);
            this.d.setText(getResources().getText(R.string.confirm_lock_pattern_error));
            this.d.setTextColor(getResources().getColor(2131100314));
            this.d.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.input_error_shake));
            this.e = 1;
            this.i = true;
            a("");
            AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.LockPatternSetupFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    LockPatternSetupFragment.this.e();
                }
            }, 500L);
            return;
        }
        this.f = new ArrayList(list);
        this.d.setText(getResources().getText(R.string.confirm_lock_pattern));
        this.d.setTextColor(getResources().getColor(2131100471));
        this.e = 2;
        this.i = false;
        this.h.clear();
        for (LockPatternView.Cell cell : this.f) {
            this.h.add(Integer.toString((cell.a() * 3) + cell.b() + 1));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.h.size(); i++) {
            sb.append(this.h.get(i));
        }
        a(sb.toString());
        if (this.e == 2) {
            this.e = 3;
            e();
        }
    }

    public boolean onBackPressed() {
        CommonConstants.f14625a = false;
        getActivity().finish();
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131363120) {
            return;
        }
        CommonConstants.f14625a = false;
        getActivity().finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f19707a;
        if (view == null) {
            this.f19707a = layoutInflater.inflate(R.layout.fragment_lock_pattern_setup, viewGroup, false);
            c();
            d();
            this.e = 1;
            e();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f19707a.getParent()).removeView(this.f19707a);
        }
        return this.f19707a;
    }
}
