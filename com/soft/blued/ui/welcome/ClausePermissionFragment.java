package com.soft.blued.ui.welcome;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.login.LoginAndRegisterProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.constant.CommonConstants;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.login_register.utils.LoginTool;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.Arrays;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/ClausePermissionFragment.class */
public class ClausePermissionFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private Context f20830a;
    private BluedAlertDialog b;

    /* renamed from: c  reason: collision with root package name */
    private BluedAlertDialog f20831c;
    private View d;

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        BluedPreferences.aE();
        LoginTool.a();
    }

    public static void a(Context context) {
        if (CommonConstants.d) {
            return;
        }
        CommonConstants.d = true;
        TerminalActivity.d(context, ClausePermissionFragment.class, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    private void b(final Context context) {
        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
            Log.v("drb", " ++++++ checkClauseAndPermission  openFirstActivity");
            Intent intent = new Intent(context, FirstActivity.class);
            intent.putExtra("extra_bool_open_welcome_page", true);
            intent.setFlags(268468224);
            startActivity(intent);
            BluedApplicationLike.isEnterLogin = true;
            return;
        }
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_PRIVACY_POP_SHOW);
        BluedAlertDialog a2 = CommonAlertDialog.a(context, 0, getString(2131892465), getString(2131892464), getString(2131892463), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.welcome.ClausePermissionFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                ClausePermissionFragment.this.a();
                BluedPreferences.aE();
            }
        }, getString(2131892462), (DialogInterface.OnClickListener) null, new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.welcome.ClausePermissionFragment.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (!BluedPreferences.aD()) {
                    ClausePermissionFragment.this.c(context);
                    return;
                }
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_PRIVACY_POP_AGREE_CLICK);
                BluedApplicationLike.isEnterLogin = true;
                Log.v("drb", " +++ checkClauseAndPermission  openFirstActivity");
                FirstActivity.a(context, false);
            }
        }, 3);
        this.f20831c = a2;
        a2.a(false);
        TextView h = this.f20831c.h();
        h.setMovementMethod(LinkMovementClickMethod.a());
        h.setText(StringUtils.a(StringUtils.a(StringUtils.a(StringUtils.a(new SpannableStringBuilder(h.getText().toString()), Arrays.asList(getResources().getStringArray(2130903100)), 2131102254), getString(2131890427), new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.ClausePermissionFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                WebViewShowInfoFragment.show(context, H5Url.a(21), 0);
            }
        }), getString(2131890425), new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.ClausePermissionFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                WebViewShowInfoFragment.show(context, H5Url.a(22), 0);
            }
        }), h.getContext().getString(2131890426), new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.ClausePermissionFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                WebViewShowInfoFragment.show(ClausePermissionFragment.this.f20830a, H5Url.a(83), 0);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Context context) {
        BluedAlertDialog a2 = CommonAlertDialog.a(context, 0, getString(2131892461), getString(2131892460), getString(2131892459), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.welcome.ClausePermissionFragment.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                ClausePermissionFragment.this.a();
                BluedPreferences.aE();
            }
        }, getString(2131892458), (DialogInterface.OnClickListener) null, new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.welcome.ClausePermissionFragment.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (BluedPreferences.aD()) {
                    EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_PRIVACY_POP_AGREE_CLICK);
                } else {
                    EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_PRIVACY_POP_DISAGREE_CLICK);
                }
                BluedApplicationLike.isEnterLogin = true;
                Log.v("drb", " +++ 检查是否同意了条款 checkClauseAndDeniedPermission  openFirstActivity");
                ClausePermissionFragment.this.b();
                FirstActivity.a(context, false);
            }
        }, 3);
        this.b = a2;
        a2.a(false);
        final TextView h = this.b.h();
        h.setMovementMethod(LinkMovementClickMethod.a());
        h.setText(StringUtils.a(StringUtils.a(new SpannableStringBuilder(h.getText().toString()), h.getContext().getString(2131890427), new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.ClausePermissionFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                WebViewShowInfoFragment.show(h.getContext(), H5Url.a(21), 0);
            }
        }), h.getContext().getString(2131890425), new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.ClausePermissionFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                WebViewShowInfoFragment.show(h.getContext(), H5Url.a(22), 0);
            }
        }));
    }

    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = getContext();
        this.f20830a = context;
        b(context);
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.fragment_clause_permission, viewGroup, false);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        ActivityChangeAnimationUtils.k(getActivity());
        return this.d;
    }

    public void onDestroy() {
        BluedAlertDialog bluedAlertDialog = this.f20831c;
        if (bluedAlertDialog != null && bluedAlertDialog.isShowing()) {
            this.f20831c.dismiss();
        }
        BluedAlertDialog bluedAlertDialog2 = this.b;
        if (bluedAlertDialog2 != null && bluedAlertDialog2.isShowing()) {
            this.b.dismiss();
        }
        this.f20831c = null;
        this.b = null;
        super.onDestroy();
    }
}
