package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.adapter.GroupAdminSetAdapter;
import com.soft.blued.ui.group.model.BluedGroupAdminLists;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupAdminSetFragment.class */
public class GroupAdminSetFragment extends BaseFragment implements View.OnClickListener {
    public static String b;

    /* renamed from: c  reason: collision with root package name */
    public static String f17065c;
    public static String d;

    /* renamed from: a  reason: collision with root package name */
    public List<BluedGroupAdminLists> f17066a;
    private View h;
    private Context i;
    private ListView j;
    private GroupAdminSetAdapter k;
    private Dialog l;
    private LinearLayout m;
    private ImageView n;
    private TextView o;
    private LinearLayout p;
    private TextView q;
    private CommonTopTitleNoTrans r;
    private String g = GroupAdminSetFragment.class.getSimpleName();
    public BluedUIHttpResponse e = new BluedUIHttpResponse<BluedEntityA<BluedGroupAdminLists>>() { // from class: com.soft.blued.ui.group.GroupAdminSetFragment.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedGroupAdminLists> bluedEntityA) {
            if (bluedEntityA != null) {
                try {
                    if (bluedEntityA.data != null) {
                        GroupAdminSetFragment.this.j.setVisibility(0);
                        GroupAdminSetFragment.this.f17066a.clear();
                        GroupAdminSetFragment.this.f17066a.addAll(bluedEntityA.data);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= GroupAdminSetFragment.this.f17066a.size()) {
                                break;
                            }
                            GroupAdminSetFragment.this.f17066a.get(i2).users_height = StringUtils.a(GroupAdminSetFragment.this.f17066a.get(i2).users_height, BlueAppLocal.c(), false);
                            GroupAdminSetFragment.this.f17066a.get(i2).users_weight = StringUtils.b(GroupAdminSetFragment.this.f17066a.get(i2).users_weight, BlueAppLocal.c(), false);
                            i = i2 + 1;
                        }
                        GroupAdminSetFragment.this.k.notifyDataSetChanged();
                        TextView textView = GroupAdminSetFragment.this.q;
                        textView.setText("(" + GroupAdminSetFragment.this.f17066a.size() + "/" + GroupAdminSetFragment.f17065c + ")");
                        if (GroupAdminSetFragment.this.f17066a.size() == StringUtils.c(GroupAdminSetFragment.f17065c)) {
                            GroupAdminSetFragment.this.m.setClickable(false);
                            GroupAdminSetFragment.this.n.setImageResource(R.drawable.icon_group_add_admin_blue);
                            GroupAdminSetFragment.this.o.setTextColor(GroupAdminSetFragment.this.getResources().getColor(2131100461));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(GroupAdminSetFragment.this.l);
        }

        public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(GroupAdminSetFragment.this.l);
        }
    };
    public BluedUIHttpResponse f = new BluedUIHttpResponse<BluedEntity>() { // from class: com.soft.blued.ui.group.GroupAdminSetFragment.2
        public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(GroupAdminSetFragment.this.l);
        }

        public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(GroupAdminSetFragment.this.l);
        }

        public void onUIUpdate(BluedEntity bluedEntity) {
            AppMethods.d((int) R.string.group_admin_add_success);
            if (GroupAdminSetFragment.this.k.f17204a) {
                GroupAdminSetFragment.this.r.setRightText(GroupAdminSetFragment.this.getString(R.string.done));
            } else {
                GroupAdminSetFragment.this.r.setRightText(GroupAdminSetFragment.this.getString(R.string.group_admins_edit));
            }
            GroupAdminSetFragment.this.b();
        }
    };

    private void c() {
        CommonTopTitleNoTrans findViewById = this.h.findViewById(R.id.top_title);
        this.r = findViewById;
        findViewById.a();
        this.r.setCenterText(getString(R.string.group_admin));
        if (!StringUtils.d(d)) {
            if (d.equals("0")) {
                this.r.a();
            } else {
                this.r.setRightText(getString(R.string.group_admins_edit));
            }
        }
        this.r.setRightClickListener(this);
        this.r.setLeftClickListener(this);
    }

    private void d() {
        this.l = DialogUtils.a(this.i);
        View inflate = ((LayoutInflater) this.i.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.item_group_admin_add_footer, (ViewGroup) null);
        this.m = (LinearLayout) inflate.findViewById(R.id.ll_group_admin_add);
        this.n = (ImageView) inflate.findViewById(R.id.tv_icon_group_admin_add);
        this.o = (TextView) inflate.findViewById(R.id.tv_group_admins_add);
        this.m.setOnClickListener(this);
        this.p = (LinearLayout) this.h.findViewById(R.id.ll_group_admin);
        this.q = (TextView) this.h.findViewById(R.id.tv_group_admin_count);
        this.f17066a = new ArrayList();
        this.j = (ListView) this.h.findViewById(R.id.lv_group_admins);
        TextView textView = this.q;
        textView.setText("(" + d + "/" + f17065c + ")");
        if (!StringUtils.d(f17065c) && d.equals(f17065c)) {
            this.m.setClickable(false);
            this.n.setImageResource(R.drawable.icon_group_add_admin_gray);
            this.o.setTextColor(getResources().getColor(2131100461));
        }
        this.k = new GroupAdminSetAdapter(this.i, this.f17066a, this.j, this.q, this.m, this.n, this.o, this.r.findViewById(2131363126), getFragmentActive());
        this.j.addFooterView(inflate);
        this.j.setAdapter((ListAdapter) this.k);
    }

    private void e() {
        getActivity().setResult(-1);
        getActivity().finish();
    }

    public void a() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        b = arguments.getString("gid");
        f17065c = arguments.getString("admin_total");
        d = arguments.getString("admin_amount");
    }

    public void b() {
        if (StringUtils.d(b)) {
            return;
        }
        GroupHttpUtils.h(this.i, this.e, b, getFragmentActive());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 100 && intent != null && !StringUtils.d(intent.getStringExtra("uid"))) {
            GroupHttpUtils.g(this.i, this.f, b, intent.getStringExtra("uid"), getFragmentActive());
        }
        super.onActivityResult(i, i2, intent);
    }

    public boolean onBackPressed() {
        e();
        return super.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            e();
        } else if (id != 2131363126) {
            if (id != 2131367845) {
                return;
            }
            if (this.f17066a.size() == StringUtils.a(f17065c, 0)) {
                this.m.setClickable(false);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gid", b);
            TerminalActivity.a(this, GroupAdminSelectFragment.class, bundle, 100);
        } else {
            String charSequence = ((TextView) this.r.findViewById(2131363126)).getText().toString();
            if (!StringUtils.d(charSequence) && charSequence.equals(getResources().getString(R.string.group_admins_edit))) {
                this.k.f17204a = true;
                this.r.setRightText(getString(R.string.done));
                this.n.setImageResource(R.drawable.icon_group_add_admin_gray);
                this.o.setTextColor(getResources().getColor(2131100461));
            } else if (!StringUtils.d(charSequence) && charSequence.equals(getResources().getString(R.string.done))) {
                this.k.f17204a = false;
                this.r.setRightText(getString(R.string.group_admins_edit));
                this.n.setImageResource(R.drawable.icon_group_add_admin_blue);
                this.o.setTextColor(getResources().getColor(2131100275));
            }
            this.k.notifyDataSetChanged();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.i = getActivity();
        View view = this.h;
        if (view == null) {
            this.h = layoutInflater.inflate(R.layout.fragment_group_admin_set, viewGroup, false);
            a();
            c();
            d();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.h.getParent()).removeView(this.h);
        }
        return this.h;
    }
}
