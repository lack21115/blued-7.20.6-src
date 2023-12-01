package com.soft.blued.ui.qr_scan;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.utils.DialogUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.LoginRegisterHttpUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/qr_scan/ScanLoginFragment.class */
public class ScanLoginFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static String f19434a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f19435c;
    private TextView d;
    private TextView e;
    private TextView f;
    private Dialog g;
    private View h;
    private Bundle i;
    private String j;
    private boolean k;
    private boolean m;
    private int l = 15;
    private Handler n = new Handler(new Handler.Callback() { // from class: com.soft.blued.ui.qr_scan.ScanLoginFragment.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            return false;
        }
    });
    private Runnable o = new Runnable() { // from class: com.soft.blued.ui.qr_scan.ScanLoginFragment.2
        @Override // java.lang.Runnable
        public void run() {
            if (ScanLoginFragment.this.k) {
                return;
            }
            if (ScanLoginFragment.this.l != 0) {
                ScanLoginFragment.f(ScanLoginFragment.this);
                ScanLoginFragment.this.n.postDelayed(this, 1000L);
                return;
            }
            ScanLoginFragment.this.d.setVisibility(0);
            ScanLoginFragment.this.d.setTextColor(ScanLoginFragment.this.b.getResources().getColor(2131101277));
            ScanLoginFragment.this.m = true;
            ScanLoginFragment.this.e.setText(ScanLoginFragment.this.b.getResources().getString(R.string.qr_scan_login_rescan));
            ScanLoginFragment.this.d.setText(ScanLoginFragment.this.b.getResources().getString(R.string.qr_scan_login_failed));
        }
    };

    private void a() {
        TextView textView = (TextView) this.h.findViewById(R.id.scan_qr_login_close);
        this.f19435c = textView;
        textView.setOnClickListener(this);
    }

    private void a(String str) {
        LoginRegisterHttpUtils.a(this.b, new BluedUIHttpResponse() { // from class: com.soft.blued.ui.qr_scan.ScanLoginFragment.3
            public boolean onUIFailure(int i, String str2) {
                ScanLoginFragment.this.d.setVisibility(0);
                ScanLoginFragment.this.d.setTextColor(ScanLoginFragment.this.b.getResources().getColor(2131101275));
                ScanLoginFragment.this.d.setText(ScanLoginFragment.this.b.getResources().getString(R.string.qr_scan_login_net));
                return super.onUIFailure(i, str2);
            }

            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(ScanLoginFragment.this.g);
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(ScanLoginFragment.this.g);
            }

            public void onUIUpdate(BluedEntity bluedEntity) {
                AppMethods.a("登录成功");
                ScanLoginFragment.this.getActivity().finish();
            }
        }, str, (IRequestHost) getFragmentActive());
    }

    private void b() {
        this.g = DialogUtils.a(this.b);
        TextView textView = (TextView) this.h.findViewById(R.id.scan_qr_url_login);
        this.e = textView;
        textView.setOnClickListener(this);
        this.d = (TextView) this.h.findViewById(R.id.scan_login_remind);
        this.f = (TextView) this.h.findViewById(R.id.scan_qr_login_close);
    }

    private void c() {
        Bundle arguments = getArguments();
        this.i = arguments;
        if (arguments != null) {
            this.j = arguments.getString(f19434a);
        }
        this.n.post(this.o);
    }

    static /* synthetic */ int f(ScanLoginFragment scanLoginFragment) {
        int i = scanLoginFragment.l;
        scanLoginFragment.l = i - 1;
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case R.id.scan_qr_login_close /* 2131369623 */:
                getActivity().finish();
                return;
            case R.id.scan_qr_url_login /* 2131369624 */:
                if (!this.m) {
                    a(this.j);
                    return;
                }
                getActivity().startActivity(new Intent(getActivity(), CaptureActivity.class));
                getActivity().finish();
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        View view = this.h;
        if (view == null) {
            this.h = layoutInflater.inflate(R.layout.fragment_scan_qr_login, viewGroup, false);
            a();
            b();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.h.getParent()).removeView(this.h);
        }
        return this.h;
    }

    public void onPause() {
        super.onPause();
        this.k = true;
    }

    public void onResume() {
        super.onResume();
        if (this.k) {
            this.n.post(this.o);
            this.k = false;
        }
    }
}
