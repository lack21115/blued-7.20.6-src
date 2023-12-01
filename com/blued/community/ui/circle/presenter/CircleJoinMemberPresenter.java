package com.blued.community.ui.circle.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.community.R;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.ui.circle.adapter.CircleMemberAdapter;
import com.blued.community.ui.circle.model.CircleBaseMember;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/presenter/CircleJoinMemberPresenter.class */
public class CircleJoinMemberPresenter extends MvpPresenter {
    protected String h;
    protected int i;
    protected int j = 1;
    protected int k = 30;
    protected boolean l = true;
    protected CircleMemberAdapter m;
    private boolean n;

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        if (bundle != null) {
            this.h = bundle.getString("circle_id");
            this.i = bundle.getInt("admin_level");
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        this.j = 1;
        this.l = true;
        this.n = false;
        c(iFetchDataListener);
    }

    public void a(CircleMemberAdapter circleMemberAdapter) {
        this.m = circleMemberAdapter;
    }

    public void a(final CircleBaseMember.Member member, int i) {
        if (member.is_mute == 1) {
            CircleHttpUtils.a(this.h, new BluedUIHttpResponse(g()) { // from class: com.blued.community.ui.circle.presenter.CircleJoinMemberPresenter.2
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity bluedEntity) {
                    AppMethods.a((CharSequence) CircleJoinMemberPresenter.this.h().getResources().getString(R.string.circle_post_detail_menu_mute_canceled_success));
                    member.is_mute = 0;
                    member.is_mute_tag = 0;
                    CircleJoinMemberPresenter.this.m.notifyDataSetChanged();
                    if (member.mute_type == 1009 || member.mute_type == 1010) {
                        member.mute_type = 0;
                    }
                }
            }, member.uid, member.is_anonym, g());
        } else {
            CircleHttpUtils.a(this.h, new BluedUIHttpResponse(g()) { // from class: com.blued.community.ui.circle.presenter.CircleJoinMemberPresenter.3
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity bluedEntity) {
                    AppMethods.a((CharSequence) CircleJoinMemberPresenter.this.h().getResources().getString(R.string.circle_post_detail_menu_mute_success));
                    member.is_mute = 1;
                    member.is_mute_tag = 1;
                    if (member.mute_type == 0) {
                        member.mute_type = 1;
                    } else if (member.mute_type == 1) {
                        member.mute_type = 2;
                    } else if (member.mute_type == 2) {
                        member.mute_type = 1009;
                    } else {
                        member.mute_type = 1009;
                    }
                    CircleJoinMemberPresenter.this.m.notifyDataSetChanged();
                }
            }, member.uid, member.is_anonym, member.name, member.avatar, g());
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        this.j++;
        c(iFetchDataListener);
    }

    public void b(CircleBaseMember.Member member, final int i) {
        CircleHttpUtils.c(this.h, new BluedUIHttpResponse(g()) { // from class: com.blued.community.ui.circle.presenter.CircleJoinMemberPresenter.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                CircleJoinMemberPresenter.this.m.remove(i);
                CircleJoinMemberPresenter.this.m.b(false);
            }
        }, member.uid, "3", g());
    }

    protected void c(final IFetchDataListener iFetchDataListener) {
        CircleHttpUtils.a(this.h, new BluedUIHttpResponse<BluedEntityA<CircleBaseMember>>(g()) { // from class: com.blued.community.ui.circle.presenter.CircleJoinMemberPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CircleBaseMember> bluedEntityA) {
                if (!bluedEntityA.hasData()) {
                    CircleJoinMemberPresenter.this.l = false;
                    return;
                }
                CircleJoinMemberPresenter.this.i = bluedEntityA.data.get(0).admin_level;
                if (iFetchDataListener != null) {
                    ArrayList arrayList = new ArrayList();
                    if (CircleJoinMemberPresenter.this.j == 1 && bluedEntityA.data.get(0).admins != null && !bluedEntityA.data.get(0).admins.isEmpty()) {
                        CircleBaseMember.MemberHeader memberHeader = new CircleBaseMember.MemberHeader();
                        memberHeader.name = CircleJoinMemberPresenter.this.h().getString(R.string.circle_member_manager) + BridgeUtil.SPLIT_MARK + CircleJoinMemberPresenter.this.h().getString(R.string.circle_member_asst_manager);
                        memberHeader.number = bluedEntityA.data.get(0).admins_num;
                        memberHeader.adapterType = 1;
                        arrayList.add(memberHeader);
                        arrayList.addAll(bluedEntityA.data.get(0).admins);
                    }
                    if (bluedEntityA.data.get(0).members != null && !bluedEntityA.data.get(0).members.isEmpty()) {
                        if (!CircleJoinMemberPresenter.this.n) {
                            CircleBaseMember.MemberHeader memberHeader2 = new CircleBaseMember.MemberHeader();
                            memberHeader2.name = CircleJoinMemberPresenter.this.h().getString(R.string.members_count);
                            memberHeader2.number = bluedEntityA.data.get(0).members_num;
                            memberHeader2.adapterType = 2;
                            arrayList.add(memberHeader2);
                            CircleJoinMemberPresenter.this.n = true;
                        }
                        arrayList.addAll(bluedEntityA.data.get(0).members);
                    }
                    iFetchDataListener.a("data_member", arrayList);
                }
                CircleJoinMemberPresenter.this.l = bluedEntityA.hasMore();
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.b(CircleJoinMemberPresenter.this.l);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (!z && CircleJoinMemberPresenter.this.j > 0) {
                    CircleJoinMemberPresenter.this.j--;
                }
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a(z);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                if (iFetchDataListener2 != null) {
                    iFetchDataListener2.a();
                }
            }
        }, this.j + "", this.k + "", g());
    }

    public void c(final CircleBaseMember.Member member, final int i) {
        if (member.isManager()) {
            CircleHttpUtils.c(this.h, new BluedUIHttpResponse(g()) { // from class: com.blued.community.ui.circle.presenter.CircleJoinMemberPresenter.5
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity bluedEntity) {
                    member.setMember();
                    CircleJoinMemberPresenter.this.m.notifyDataSetChanged();
                    CircleJoinMemberPresenter.this.m.a(false);
                    CircleJoinMemberPresenter.this.m.b(true);
                    CircleJoinMemberPresenter.this.m.remove(i);
                    CircleJoinMemberPresenter.this.m.addData(member);
                }
            }, member.uid, "2", g());
        } else {
            CircleHttpUtils.c(this.h, new BluedUIHttpResponse(g()) { // from class: com.blued.community.ui.circle.presenter.CircleJoinMemberPresenter.6
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity bluedEntity) {
                    member.setManager();
                    CircleJoinMemberPresenter.this.m.notifyDataSetChanged();
                    CircleJoinMemberPresenter.this.m.a(true);
                    CircleJoinMemberPresenter.this.m.b(false);
                    CircleJoinMemberPresenter.this.m.remove(i);
                    CircleJoinMemberPresenter.this.m.addData(2, member);
                }
            }, member.uid, "1", g());
        }
    }

    public String m() {
        return this.h;
    }

    public int n() {
        return this.i;
    }
}
