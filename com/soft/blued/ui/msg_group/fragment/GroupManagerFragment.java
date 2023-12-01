package com.soft.blued.ui.msg_group.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.group.GroupMemberModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.TranslationAnimHintView;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg_group.adapter.GroupManagerDetailAdapter;
import com.soft.blued.ui.msg_group.presenter.GroupManagerPresenter;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.RecyclerViewUtil;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupManagerFragment.class */
public class GroupManagerFragment extends MvpFragment<GroupManagerPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private GroupManagerDetailAdapter f19053a;
    @BindView
    RecyclerView admin_list;
    @BindView
    TranslationAnimHintView hintView;
    @BindView
    CommonTopTitleNoTrans title;

    /* JADX WARN: Multi-variable type inference failed */
    private void b() {
        LiveEventBus.get("set_manager", GroupMemberModel.class).observe(this, new Observer<GroupMemberModel>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupManagerFragment.4
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(GroupMemberModel groupMemberModel) {
                if (((GroupManagerPresenter) GroupManagerFragment.this.j()).m() == null || GroupManagerFragment.this.f19053a == null || GroupManagerFragment.this.f19053a.getItemCount() <= 0) {
                    return;
                }
                if (GroupManagerFragment.this.f19053a.getData().size() == ((GroupManagerPresenter) GroupManagerFragment.this.j()).m().group_max_admin) {
                    GroupManagerFragment.this.f19053a.getData().set(GroupManagerFragment.this.f19053a.getItemCount() - 1, groupMemberModel);
                } else {
                    GroupManagerFragment.this.f19053a.getData().add(GroupManagerFragment.this.f19053a.getItemCount() - 1, groupMemberModel);
                }
                GroupManagerFragment.this.f19053a.notifyDataSetChanged();
            }
        });
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        this.title.setCenterText(getString(R.string.group_admin_list));
        this.title.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupManagerFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GroupManagerFragment.this.t();
            }
        });
        b();
    }

    public void a(GroupInfoModel groupInfoModel) {
        if (groupInfoModel != null) {
            TranslationAnimHintView.HintInfo hintInfo = new TranslationAnimHintView.HintInfo();
            hintInfo.a = 11;
            String string = getString(R.string.group_max_admin);
            hintInfo.b = String.format(string, groupInfoModel.group_max_admin + "");
            this.hintView.a(hintInfo);
            RecyclerViewUtil.a(this.admin_list);
            this.f19053a = new GroupManagerDetailAdapter(groupInfoModel.admin, getFragmentActive());
            this.admin_list.setLayoutManager(new LinearLayoutManager(getContext()));
            this.admin_list.setAdapter(this.f19053a);
            this.f19053a.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupManagerFragment.1
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
                public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    ((GroupManagerPresenter) GroupManagerFragment.this.j()).a((UserBasicModel) baseQuickAdapter.getData().get(i));
                }
            });
            this.f19053a.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupManagerFragment.2
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
                public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    UserBasicModel userBasicModel = (UserBasicModel) baseQuickAdapter.getData().get(i);
                    int id = view.getId();
                    if (id == 2131362715) {
                        ((GroupManagerPresenter) GroupManagerFragment.this.j()).d(userBasicModel.uid);
                    } else if (id != 2131365504) {
                    } else {
                        if ("0".equals(userBasicModel.uid)) {
                            ((GroupManagerPresenter) GroupManagerFragment.this.j()).a((UserBasicModel) baseQuickAdapter.getData().get(i));
                        } else {
                            UserInfoFragmentNew.a(GroupManagerFragment.this.getContext(), (UserBasicModel) baseQuickAdapter.getData().get(i), "group_chatting", view, (LogData) null, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
                        }
                    }
                }
            });
        }
    }

    public int g() {
        return R.layout.fm_group_manager_list;
    }

    public void onDestroy() {
        super.onDestroy();
        ((GroupManagerPresenter) j()).n();
    }
}
