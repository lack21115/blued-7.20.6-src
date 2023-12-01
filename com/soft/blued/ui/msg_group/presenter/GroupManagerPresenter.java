package com.soft.blued.ui.msg_group.presenter;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.group.GroupMemberModel;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.utils.ToastUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.ui.msg_group.fragment.SearchMemberFragment;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/presenter/GroupManagerPresenter.class */
public class GroupManagerPresenter extends MvpPresenter {
    private GroupInfoModel h;
    private GroupMemberModel i;

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        ArrayList arrayList;
        GroupInfoModel groupInfoModel = this.h;
        if (groupInfoModel != null) {
            List list = groupInfoModel.admin;
            if (list == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = list;
                if (list.size() > 0) {
                    arrayList = list;
                    if (((GroupMemberModel) list.get(0)).group_role == 1) {
                        this.i = (GroupMemberModel) list.remove(0);
                        arrayList = list;
                    }
                }
            }
            GroupMemberModel groupMemberModel = new GroupMemberModel();
            groupMemberModel.vbadge = 3;
            groupMemberModel.uid = "0";
            groupMemberModel.name = "添加管理员";
            if (arrayList.size() < this.h.group_max_admin && !arrayList.contains(groupMemberModel)) {
                arrayList.add(groupMemberModel);
            }
            a(d.K, this.h);
        }
    }

    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        if (bundle != null) {
            this.h = bundle.getSerializable(d.K);
            o();
        }
    }

    public void a(IFetchDataListener iFetchDataListener) {
    }

    public void a(UserBasicModel userBasicModel) {
        if (this.h == null || userBasicModel == null || !"0".equals(userBasicModel.uid)) {
            return;
        }
        Activity h = h();
        SearchMemberFragment.a(h, 0, this.h.group_id + "");
    }

    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void d(final String str) {
        if (this.h == null) {
            return;
        }
        IRequestHost g = g();
        MsgGroupHttpUtils.a(g, this.h.group_id + "", str, 3, new BluedUIHttpResponse<BluedEntityA>(g()) { // from class: com.soft.blued.ui.msg_group.presenter.GroupManagerPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
            }

            public void onUIFinish(boolean z) {
                GroupManagerPresenter.this.b("cancelManager", z);
                super.onUIFinish(z);
                if (z) {
                    ToastUtils.a(AppInfo.d().getString(R.string.group_chat_delete_success));
                    if (GroupManagerPresenter.this.h.admin != null) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= GroupManagerPresenter.this.h.admin.size()) {
                                break;
                            } else if (((GroupMemberModel) GroupManagerPresenter.this.h.admin.get(i2)).uid.equals(str)) {
                                GroupManagerPresenter.this.h.admin.remove(i2);
                                break;
                            } else {
                                i = i2 + 1;
                            }
                        }
                        GroupManagerPresenter.this.o();
                    }
                }
            }

            public void onUIStart() {
                super.onUIStart();
                GroupManagerPresenter.this.d_("cancelManager");
            }
        });
    }

    public GroupInfoModel m() {
        return this.h;
    }

    public void n() {
        GroupInfoModel groupInfoModel = this.h;
        if (groupInfoModel != null) {
            if (groupInfoModel.admin != null && this.h.admin.size() > 0) {
                if (((GroupMemberModel) this.h.admin.get(this.h.admin.size() - 1)).uid.equals("0")) {
                    this.h.admin.remove(this.h.admin.size() - 1);
                }
                if (this.i != null) {
                    this.h.admin.add(0, this.i);
                }
            }
            LiveEventBus.get("refresh_manager_list", GroupInfoModel.class).post(this.h);
        }
    }
}
