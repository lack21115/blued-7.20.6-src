package com.soft.blued.ui.qr_scan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/qr_scan/ScanResultFragment.class */
public class ScanResultFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static String f19439a;
    private CommonTopTitleNoTrans b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f19440c;
    private View d;
    private Bundle e;
    private String f;

    private void a() {
        CommonTopTitleNoTrans findViewById = this.d.findViewById(R.id.top_title);
        this.b = findViewById;
        findViewById.a();
        this.b.setCenterText(getString(R.string.qr_scan_result_remind_title));
        this.b.setLeftClickListener(this);
    }

    private void b() {
        this.f19440c = (EditText) this.d.findViewById(R.id.qr_scan_result_info);
    }

    private void c() {
        Bundle arguments = getArguments();
        this.e = arguments;
        if (arguments != null) {
            String string = arguments.getString(f19439a);
            this.f = string;
            this.f19440c.setText(string);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131363120) {
            return;
        }
        getActivity().finish();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.fragment_scan_qr_result, viewGroup, false);
            a();
            b();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        return this.d;
    }
}
