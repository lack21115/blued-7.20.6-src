package com.soft.blued.ui.msg;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.ui.msg.adapter.SelectSessionAdapter;
import com.soft.blued.ui.msg.presenter.SelectSessionPresenter;
import com.soft.blued.ui.setting.event.SelectSessionEvent;
import com.soft.blued.utils.RecyclerViewUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/SelectSessionFragment.class */
public class SelectSessionFragment extends MvpFragment<SelectSessionPresenter> {

    /* renamed from: a  reason: collision with root package name */
    SelectSessionAdapter f31888a;
    @BindView
    RecyclerView recyclerView;
    @BindView
    CommonTopTitleNoTrans top_title;
    @BindView
    TextView tv_all;

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.top_title.setCenterText("选择会话");
        this.top_title.setRightText("完成");
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerViewUtil.a(this.recyclerView);
        SelectSessionAdapter selectSessionAdapter = new SelectSessionAdapter(getFragmentActive());
        this.f31888a = selectSessionAdapter;
        selectSessionAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg.SelectSessionFragment.1
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SessionModel sessionModel = (SessionModel) baseQuickAdapter.getData().get(i);
                sessionModel.checked = !sessionModel.checked;
                baseQuickAdapter.notifyItemChanged(i);
            }
        });
        this.recyclerView.setAdapter(this.f31888a);
        this.top_title.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.SelectSessionFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SelectSessionFragment.this.t();
            }
        });
        this.top_title.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.SelectSessionFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ArrayList arrayList = new ArrayList();
                for (SessionModel sessionModel : SelectSessionFragment.this.f31888a.getData()) {
                    if (sessionModel.checked) {
                        arrayList.add(Long.valueOf(sessionModel.sessionId));
                    }
                }
                SelectSessionEvent selectSessionEvent = new SelectSessionEvent();
                selectSessionEvent.f33314a = arrayList;
                LiveEventBus.get(EventBusConstant.KEY_EVENT_SELECT_SESSION).post(selectSessionEvent);
                SelectSessionFragment.this.t();
            }
        });
        this.tv_all.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.SelectSessionFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                for (SessionModel sessionModel : SelectSessionFragment.this.f31888a.getData()) {
                    sessionModel.checked = true;
                }
                SelectSessionFragment.this.f31888a.notifyDataSetChanged();
            }
        });
    }

    public void a(List<SessionModel> list) {
        for (SessionModel sessionModel : list) {
            sessionModel.checked = false;
        }
        this.f31888a.setNewData(list);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fm_select_session;
    }
}
