package com.soft.blued.ui.msg_group.presenter;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Contacts;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.module.common.event.CommonLiveEventData;
import com.blued.android.module.common.group.GroupMemberModel;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/presenter/GroupMemberPresenter.class */
public class GroupMemberPresenter extends MvpPresenter {
    public static final String h = GroupMemberPresenter.class.getSimpleName();
    public String m;
    public int o;
    public int i = 1;
    public int j = 1;
    public String k = "";
    int l = 20;
    public String n = "joined";
    public int p = 3;

    private void c(final IFetchDataListener iFetchDataListener) {
        MsgGroupHttpUtils.a(g(), this.m, this.n, this.i, this.l, "", new BluedUIHttpResponse<BluedEntityA<GroupMemberModel>>(g()) { // from class: com.soft.blued.ui.msg_group.presenter.GroupMemberPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<GroupMemberModel> bluedEntityA) {
                if (bluedEntityA.hasData()) {
                    iFetchDataListener.a("data_member", bluedEntityA.data);
                    iFetchDataListener.b(bluedEntityA.hasMore());
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (!z && GroupMemberPresenter.this.i > 1) {
                    GroupMemberPresenter.this.i--;
                }
                iFetchDataListener.a(z);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                iFetchDataListener.a();
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        if (bundle != null) {
            this.m = bundle.getString(Contacts.GroupMembership.GROUP_ID);
            this.o = bundle.getInt("group_role");
            this.p = bundle.getInt("group_type");
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        this.i = 1;
        c(iFetchDataListener);
    }

    public void a(String str, final int i, final int... iArr) {
        MsgGroupHttpUtils.a(g(), this.m, str, i, new BluedUIHttpResponse<BluedEntityA>(g()) { // from class: com.soft.blued.ui.msg_group.presenter.GroupMemberPresenter.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str2) {
                if (i2 == 40319048) {
                    CommonAlertDialog.a(GroupMemberPresenter.this.h(), GroupMemberPresenter.this.h().getString(R.string.group_transfer_failed), str2, GroupMemberPresenter.this.h().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.presenter.GroupMemberPresenter.2.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            Tracker.onClick(dialogInterface, i3);
                            dialogInterface.dismiss();
                        }
                    }, (DialogInterface.OnDismissListener) null, 0);
                    return true;
                } else if (i2 == 40319058) {
                    GroupUtil.a(GroupMemberPresenter.this.h(), AppUtils.a((int) R.string.group_add_full_hint), str2, (DialogInterface.OnClickListener) null);
                    return true;
                } else {
                    return false;
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    ToastUtils.a(AppInfo.d().getString(R.string.group_chat_delete_success));
                    int i2 = i;
                    if (i2 == 4) {
                        GroupMemberPresenter.this.f_("data_delete");
                    } else if (i2 != 2) {
                        if (i2 == 1) {
                            GroupMemberPresenter.this.i();
                        }
                    } else {
                        int[] iArr2 = iArr;
                        if (iArr2 == null || iArr2.length <= 0) {
                            return;
                        }
                        GroupMemberPresenter.this.a("data_set_manager", (String) Integer.valueOf(iArr2[0]));
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        this.i++;
        c(iFetchDataListener);
    }

    public void d(String str) {
        this.k = str;
        MsgGroupHttpUtils.a(g(), this.m, this.n, this.j, this.l, str, new BluedUIHttpResponse<BluedEntityA<GroupMemberModel>>(g()) { // from class: com.soft.blued.ui.msg_group.presenter.GroupMemberPresenter.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<GroupMemberModel> bluedEntityA) {
                CommonLiveEventData commonLiveEventData = new CommonLiveEventData();
                if (!bluedEntityA.hasData()) {
                    commonLiveEventData.a(new ArrayList());
                    LiveEventBus.get("data_search", CommonLiveEventData.class).post(commonLiveEventData);
                    return;
                }
                commonLiveEventData.a(bluedEntityA.data);
                LiveEventBus.get("data_search", CommonLiveEventData.class).post(commonLiveEventData);
                LiveEventBus.get("data_search_has_more", Boolean.class).post(Boolean.valueOf(bluedEntityA.hasMore()));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (!z && GroupMemberPresenter.this.j > 1) {
                    GroupMemberPresenter.this.j--;
                }
                LiveEventBus.get("data_search_end", Boolean.class).post(Boolean.valueOf(z));
            }
        });
    }

    public void e(String str) {
        MsgGroupHttpUtils.a(g(), this.m, str, new BluedUIHttpResponse<BluedEntityA<GroupMemberModel>>(g()) { // from class: com.soft.blued.ui.msg_group.presenter.GroupMemberPresenter.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<GroupMemberModel> bluedEntityA) {
                if (bluedEntityA.hasData()) {
                    GroupMemberPresenter.this.a("data_search", (String) bluedEntityA.data);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                GroupMemberPresenter.this.a("update_no_data_view", (String) new Boolean(z));
            }
        });
    }

    public void m() {
        this.j++;
        d(this.k);
    }
}
