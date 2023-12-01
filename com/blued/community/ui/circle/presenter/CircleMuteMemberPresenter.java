package com.blued.community.ui.circle.presenter;

import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.community.R;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.ui.circle.model.CircleBaseMember;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/presenter/CircleMuteMemberPresenter.class */
public class CircleMuteMemberPresenter extends CircleJoinMemberPresenter {
    @Override // com.blued.community.ui.circle.presenter.CircleJoinMemberPresenter, com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        this.j = 1;
        this.l = true;
        c(iFetchDataListener);
    }

    @Override // com.blued.community.ui.circle.presenter.CircleJoinMemberPresenter
    public void a(final CircleBaseMember.Member member, final int i) {
        CircleHttpUtils.a(this.h, new BluedUIHttpResponse(g()) { // from class: com.blued.community.ui.circle.presenter.CircleMuteMemberPresenter.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                CircleMuteMemberPresenter.this.m.remove(i);
                if (member.mute_type == 1009 || member.mute_type == 1010) {
                    member.mute_type = 0;
                }
                AppMethods.a((CharSequence) CircleMuteMemberPresenter.this.h().getResources().getString(R.string.circle_post_detail_menu_mute_canceled_success));
            }
        }, member.uid, member.is_anonym, g());
    }

    @Override // com.blued.community.ui.circle.presenter.CircleJoinMemberPresenter, com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        this.j++;
        c(iFetchDataListener);
    }

    @Override // com.blued.community.ui.circle.presenter.CircleJoinMemberPresenter
    protected void c(final IFetchDataListener iFetchDataListener) {
        CircleHttpUtils.b(this.h, new BluedUIHttpResponse<BluedEntityA<CircleBaseMember.Member>>(g()) { // from class: com.blued.community.ui.circle.presenter.CircleMuteMemberPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CircleBaseMember.Member> bluedEntityA) {
                if (bluedEntityA.hasData()) {
                    IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                    if (iFetchDataListener2 != null) {
                        iFetchDataListener2.a("data_member", bluedEntityA.data);
                    }
                    CircleMuteMemberPresenter.this.l = bluedEntityA.hasMore();
                } else {
                    CircleMuteMemberPresenter.this.l = false;
                }
                iFetchDataListener.b(CircleMuteMemberPresenter.this.l);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (!z && CircleMuteMemberPresenter.this.j > 0) {
                    CircleMuteMemberPresenter.this.j--;
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
}
