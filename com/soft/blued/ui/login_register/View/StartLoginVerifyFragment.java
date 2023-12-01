package com.soft.blued.ui.login_register.View;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.login_register.Contract.StartLoginVerifyContract;
import com.soft.blued.ui.login_register.adapter.VerifyAdapter;
import com.soft.blued.ui.login_register.model.AccountNumberVerifyModel;
import com.soft.blued.ui.login_register.presenter.StartLoginVerifyPresenter;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/View/StartLoginVerifyFragment.class */
public class StartLoginVerifyFragment extends BaseFragment implements View.OnClickListener, StartLoginVerifyContract.IView {

    /* renamed from: a  reason: collision with root package name */
    private View f17847a;
    private Bundle b;

    /* renamed from: c  reason: collision with root package name */
    private Context f17848c;
    private StartLoginVerifyContract.IPresenter d;
    private TextView e;
    private TextView f;
    private CommonTopTitleNoTrans g;
    private TextView h;
    private String i;
    private List<AccountNumberVerifyModel> j = new ArrayList();
    private PullToRefreshRecyclerView k;
    private RecyclerView l;
    private VerifyAdapter m;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/View/StartLoginVerifyFragment$TARGET.class */
    public interface TARGET {
    }

    private void a() {
        CommonTopTitleNoTrans findViewById = this.f17847a.findViewById(R.id.cttnt_title);
        this.g = findViewById;
        findViewById.d();
        this.g.setCenterText("");
        this.g.f();
        this.g.setRightText((int) R.string.close);
        this.g.setRightTextColor(2131102260);
        this.g.setTitleBackgroundDrawable(2131101780);
        this.g.setRightClickListener(this);
        this.f = (TextView) this.f17847a.findViewById(R.id.tv_start_verify);
        TextView textView = (TextView) this.f17847a.findViewById(R.id.tv_phone_number);
        this.e = textView;
        textView.setText(this.i);
        this.f.setOnClickListener(this);
        TextView textView2 = (TextView) this.f17847a.findViewById(R.id.tv_appeal);
        this.h = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.View.-$$Lambda$StartLoginVerifyFragment$RTM9zkDk7cLa4-XVl095N4BBTHs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StartLoginVerifyFragment.this.a(view);
            }
        });
        PullToRefreshRecyclerView findViewById2 = this.f17847a.findViewById(R.id.list_view);
        this.k = findViewById2;
        this.l = (RecyclerView) findViewById2.getRefreshableView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f17848c);
        linearLayoutManager.setOrientation(1);
        this.l.setLayoutManager(linearLayoutManager);
        VerifyAdapter verifyAdapter = new VerifyAdapter(this.f17848c);
        this.m = verifyAdapter;
        this.l.setAdapter(verifyAdapter);
        this.k.setRefreshEnabled(false);
        this.m.setNewData(this.j);
    }

    public static void a(Context context, Bundle bundle) {
        TerminalActivity.d(context, StartLoginVerifyFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        WebViewShowInfoFragment.a(this.f17848c, BluedHttpUrl.a(getArguments() != null ? getArguments().getString("key_uid", "") : "", 8), getResources().getString(R.string.consult_online), 16);
    }

    private void b() {
        Bundle arguments = getArguments();
        this.b = arguments;
        if (arguments != null) {
            String string = arguments.getString("login_mobile");
            String string2 = this.b.getString("relation_mobile");
            String string3 = this.b.getString("login_email");
            String string4 = this.b.getString("safe_email");
            Log.v("drb", "get login_mobile:" + string + " --  relation_mobile:" + string2 + " --  login_email:" + string3 + " --  safe_email:" + string4);
            if (!TextUtils.isEmpty(string)) {
                this.j.add(new AccountNumberVerifyModel(string, "login_mobile"));
            }
            if (!TextUtils.isEmpty(string2)) {
                this.j.add(new AccountNumberVerifyModel(string2, "relation_mobile"));
            }
            if (!TextUtils.isEmpty(string3)) {
                this.j.add(new AccountNumberVerifyModel(string3, "login_email"));
            }
            if (!TextUtils.isEmpty(string4)) {
                this.j.add(new AccountNumberVerifyModel(string4, "safe_email"));
            }
            if (this.j.size() > 0) {
                this.j.get(0).isSelect = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        getActivity().finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363126) {
            postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.login_register.View.-$$Lambda$StartLoginVerifyFragment$eJO0ll3tuEE01w4hBmark7o-Gug
                @Override // java.lang.Runnable
                public final void run() {
                    StartLoginVerifyFragment.this.c();
                }
            });
        } else if (id != 2131372637) {
        } else {
            if (this.m.getData() != null) {
                Iterator<AccountNumberVerifyModel> it = this.m.getData().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AccountNumberVerifyModel next = it.next();
                    if (next.isSelect) {
                        Log.v("drb", "put SAFE_DEVICE_TYPE:" + next.type + " -- SAFE_DEVICE_NUMBER:" + next.number);
                        this.b.putString("safe_device_type", next.type);
                        this.b.putString("safe_device_number", next.number);
                        break;
                    }
                }
            }
            this.d.a(this.b);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f17848c = getActivity();
        View view = this.f17847a;
        if (view == null) {
            this.f17847a = layoutInflater.inflate(R.layout.fragment_start_login_verify, viewGroup, false);
            this.d = new StartLoginVerifyPresenter(this.f17848c, this, getFragmentActive());
            b();
            a();
        } else {
            ((ViewGroup) view.getParent()).removeView(this.f17847a);
        }
        return this.f17847a;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
