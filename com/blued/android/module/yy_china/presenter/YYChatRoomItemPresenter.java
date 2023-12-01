package com.blued.android.module.yy_china.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.yy_china.model.YyHomeChatItemDataMode;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYChatRoomItemPresenter.class */
public final class YYChatRoomItemPresenter extends MvpPresenter {
    private String k;
    private String l;
    private final String h = "data_member";
    private int i = 1;
    private boolean j = true;
    private final HashSet<String> m = new HashSet<>();
    private boolean n = true;

    private final void c(final IFetchDataListener iFetchDataListener) {
        int i = this.i;
        String str = this.l;
        final IRequestHost g = g();
        YYRoomHttpUtils.b(i, str, new BluedUIHttpResponse<BluedEntityA<YyHomeChatItemDataMode>>(g) { // from class: com.blued.android.module.yy_china.presenter.YYChatRoomItemPresenter$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YyHomeChatItemDataMode> response) {
                int i2;
                IFetchDataListener iFetchDataListener2;
                int i3;
                Intrinsics.e(response, "response");
                ArrayList arrayList = new ArrayList();
                if (!response.hasData()) {
                    i2 = this.i;
                    if (i2 == 1 && (iFetchDataListener2 = IFetchDataListener.this) != null) {
                        iFetchDataListener2.a(this.m(), arrayList);
                    }
                    this.a(false);
                    return;
                }
                if (IFetchDataListener.this != null) {
                    for (YyHomeChatItemDataMode yyHomeChatItemDataMode : response.data) {
                        if (yyHomeChatItemDataMode.getType() != 0) {
                            arrayList.add(yyHomeChatItemDataMode);
                        } else if (!this.q().contains(yyHomeChatItemDataMode.getData().getRoom_id())) {
                            arrayList.add(yyHomeChatItemDataMode);
                            this.q().add(yyHomeChatItemDataMode.getData().getRoom_id());
                        }
                    }
                    IFetchDataListener.this.a(this.m(), arrayList);
                    YYChatRoomItemPresenter yYChatRoomItemPresenter = this;
                    i3 = yYChatRoomItemPresenter.i;
                    yYChatRoomItemPresenter.i = i3 + 1;
                }
                this.a(response.hasMore());
                IFetchDataListener iFetchDataListener3 = IFetchDataListener.this;
                if (iFetchDataListener3 == null) {
                    return;
                }
                iFetchDataListener3.b(this.n());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                int i2;
                int i3;
                super.onUIFinish(z);
                if (!z) {
                    i2 = this.i;
                    if (i2 > 0) {
                        YYChatRoomItemPresenter yYChatRoomItemPresenter = this;
                        i3 = yYChatRoomItemPresenter.i;
                        yYChatRoomItemPresenter.i = i3 - 1;
                    }
                }
                IFetchDataListener iFetchDataListener2 = IFetchDataListener.this;
                if (iFetchDataListener2 == null) {
                    return;
                }
                iFetchDataListener2.a(z);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                IFetchDataListener iFetchDataListener2 = IFetchDataListener.this;
                if (iFetchDataListener2 == null) {
                    return;
                }
                iFetchDataListener2.a();
            }
        }, g());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        if (bundle == null) {
            return;
        }
        d(bundle.getString("from_source"));
        e(bundle.getString("room_type"));
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        this.i = 1;
        this.j = true;
        this.m.clear();
        c(iFetchDataListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(boolean z) {
        this.j = z;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        c(iFetchDataListener);
    }

    public final void b(boolean z) {
        this.n = z;
    }

    public final void d(String str) {
        this.k = str;
    }

    public final void e(String str) {
        this.l = str;
    }

    public final String m() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean n() {
        return this.j;
    }

    public final String o() {
        return this.k;
    }

    public final String p() {
        return this.l;
    }

    public final HashSet<String> q() {
        return this.m;
    }

    public final boolean r() {
        return this.n;
    }
}
