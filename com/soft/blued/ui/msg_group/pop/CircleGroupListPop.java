package com.soft.blued.ui.msg_group.pop;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.ui.msg_group.adapter.CircleGroupAdapter;
import com.soft.blued.ui.msg_group.fragment.GroupInfoFragment;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/pop/CircleGroupListPop.class */
public class CircleGroupListPop extends BottomPopupView {
    private List<GroupInfoModel> b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f19103c;
    private int d;

    public CircleGroupListPop(Context context, List<GroupInfoModel> list, int i, IRequestHost iRequestHost) {
        super(context);
        this.d = 1;
        this.b = list;
        this.f19103c = iRequestHost;
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        if (view.getId() == 2131372911 || view.getId() == 2131365477) {
            GroupInfoModel groupInfoModel = (GroupInfoModel) baseQuickAdapter.getData().get(i);
            Context context = getContext();
            GroupInfoFragment.a(context, groupInfoModel.group_id + "", groupInfoModel, SocialNetWorkProtos.SourceType.CIRCLE);
            p();
        }
    }

    public void a(Context context) {
        new XPopup.Builder(context).a(this).h();
    }

    public void b() {
        super.b();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.group_list);
        ((TextView) findViewById(2131371675)).setText(getContext().getString(this.d == 1 ? 2131888333 : 2131888388));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        CircleGroupAdapter circleGroupAdapter = new CircleGroupAdapter(this.b, this.f19103c);
        circleGroupAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$CircleGroupListPop$_udqE997JY_bOFeZuW43uBFDMXQ
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CircleGroupListPop.this.a(baseQuickAdapter, view, i);
            }
        });
        recyclerView.setAdapter(circleGroupAdapter);
    }

    public int getImplLayoutId() {
        return R.layout.pop_circle_group_list;
    }
}
