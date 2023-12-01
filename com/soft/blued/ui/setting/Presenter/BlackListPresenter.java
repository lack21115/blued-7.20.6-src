package com.soft.blued.ui.setting.Presenter;

import android.content.Context;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.setting.Contract.IBlackListContract;
import com.soft.blued.ui.setting.model.BluedBlackList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Presenter/BlackListPresenter.class */
public class BlackListPresenter implements IBlackListContract.IPresenter {

    /* renamed from: a  reason: collision with root package name */
    BluedUIHttpResponse f33224a;
    private IBlackListContract.IView b;

    /* renamed from: c  reason: collision with root package name */
    private Context f33225c;
    private IRequestHost d;
    private int e;
    private int f;
    private boolean g;
    private List<BluedBlackList> h;

    public BlackListPresenter(Context context, IRequestHost iRequestHost, IBlackListContract.IView iView, int i) {
        this.e = 10;
        this.f33224a = new BluedUIHttpResponse<BluedEntityA<BluedBlackList>>(this.d) { // from class: com.soft.blued.ui.setting.Presenter.BlackListPresenter.1
            private boolean b;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedBlackList> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                if (bluedEntityA.data.size() >= BlackListPresenter.this.e) {
                    BlackListPresenter.this.g = true;
                    BlackListPresenter.this.b.a();
                } else {
                    BlackListPresenter.this.g = false;
                    BlackListPresenter.this.b.b();
                }
                if (BlackListPresenter.this.f == 1) {
                    BlackListPresenter.this.h = bluedEntityA.data;
                    BlackListPresenter.this.b.b(bluedEntityA.data);
                    return;
                }
                if (BlackListPresenter.this.h != null) {
                    BlackListPresenter.this.h.addAll(bluedEntityA.data);
                }
                BlackListPresenter.this.b.a(bluedEntityA.data);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str) {
                this.b = true;
                if (BlackListPresenter.this.f != 1) {
                    BlackListPresenter.e(BlackListPresenter.this);
                }
                return super.onUIFailure(i2, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                BlackListPresenter.this.b.c();
                if (BlackListPresenter.this.h != null && BlackListPresenter.this.h.size() != 0) {
                    BlackListPresenter.this.b.e();
                } else if (this.b) {
                    BlackListPresenter.this.b.f();
                } else {
                    BlackListPresenter.this.b.d();
                }
                super.onUIFinish();
            }
        };
        this.f33225c = context;
        this.d = iRequestHost;
        this.b = iView;
        if (i > 0) {
            this.e = i;
        }
    }

    private void a(boolean z) {
        String str;
        int i;
        if (z) {
            this.f = 1;
        }
        if (this.f == 1) {
            this.g = true;
        }
        if (!this.g && (i = this.f) != 1) {
            this.f = i - 1;
            AppMethods.a((CharSequence) this.f33225c.getResources().getString(2131887275));
            this.b.c();
            return;
        }
        if (this.f != 1) {
            str = ((this.f - 1) * 10) + "";
        } else {
            str = "0";
        }
        MineHttpUtils.g(this.f33225c, this.f33224a, UserInfo.getInstance().getLoginUserInfo().getUid(), str, this.e + "", this.d);
    }

    static /* synthetic */ int e(BlackListPresenter blackListPresenter) {
        int i = blackListPresenter.f;
        blackListPresenter.f = i - 1;
        return i;
    }

    @Override // com.blued.android.framework.mvp_similarity.BasePresenter
    public void ar_() {
    }

    @Override // com.soft.blued.ui.setting.Contract.IBlackListContract.IPresenter
    public void b() {
        a(true);
    }

    @Override // com.soft.blued.ui.setting.Contract.IBlackListContract.IPresenter
    public void c() {
        this.f++;
        a(false);
    }

    @Override // com.soft.blued.ui.setting.Contract.IBlackListContract.IPresenter
    public void d() {
        if (4 == UserInfo.getInstance().getLoginUserInfo().getVBadge() || 7 == UserInfo.getInstance().getLoginUserInfo().getVBadge()) {
            this.b.a(false);
        } else {
            this.b.a(true);
        }
    }
}
