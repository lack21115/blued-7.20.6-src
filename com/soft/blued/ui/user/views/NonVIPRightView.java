package com.soft.blued.ui.user.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.soft.blued.R;
import com.soft.blued.ui.user.adapter.VIPCenterVIPRightHoriAdapter;
import com.soft.blued.ui.user.model.VIPCenterForJsonParse;
import com.soft.blued.ui.user.model.VIPRightOption;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/NonVIPRightView.class */
public class NonVIPRightView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    TextView f20679a;
    TextView b;

    /* renamed from: c  reason: collision with root package name */
    RecyclerView f20680c;
    Context d;
    View e;

    public NonVIPRightView(Context context) {
        super(context);
        a(context);
    }

    public NonVIPRightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public NonVIPRightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.e = LayoutInflater.from(context).inflate(R.layout.item_non_vip_right, this);
        this.d = context;
        c();
    }

    private void c() {
        this.f20679a = (TextView) findViewById(R.id.tv_top_line);
        this.b = (TextView) findViewById(R.id.tv_group_title);
        this.f20680c = (RecyclerView) findViewById(R.id.rv_right_items);
    }

    public void a() {
        this.f20679a.setVisibility(8);
    }

    public void a(IRequestHost iRequestHost, VIPCenterForJsonParse.NonVIPPriviledge nonVIPPriviledge, int i, FragmentManager fragmentManager) {
        if (nonVIPPriviledge == null || nonVIPPriviledge.privilege_list == null || nonVIPPriviledge.privilege_list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= nonVIPPriviledge.privilege_list.size()) {
                this.b.setText(nonVIPPriviledge.title);
                VIPCenterVIPRightHoriAdapter vIPCenterVIPRightHoriAdapter = new VIPCenterVIPRightHoriAdapter(iRequestHost, arrayList, i, fragmentManager);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.d);
                linearLayoutManager.setOrientation(0);
                this.f20680c.setLayoutManager(linearLayoutManager);
                this.f20680c.setAdapter(vIPCenterVIPRightHoriAdapter);
                return;
            }
            VIPRightOption vIPRightOption = nonVIPPriviledge.privilege_list.get(i3);
            if (i == 2) {
                arrayList.add(vIPRightOption);
            } else if (vIPRightOption.is_svip != 1) {
                arrayList.add(vIPRightOption);
            }
            i2 = i3 + 1;
        }
    }

    public void b() {
        this.f20679a.setVisibility(0);
    }
}
