package com.blued.android.module.yy_china.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.yy_china.model.YYRelationShipRoomMyRoom;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUserCardInfoMode;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYRelationShipMyRoomItemPresenter.class */
public final class YYRelationShipMyRoomItemPresenter extends MvpPresenter {
    private final String h = "data_member";
    private String i = "";
    private int j = 1;
    private boolean k = true;

    private final void c(final IFetchDataListener iFetchDataListener) {
        String str = this.i;
        final IRequestHost g = g();
        YYRoomHttpUtils.W(str, new BluedUIHttpResponse<BluedEntityA<YYRelationShipRoomUserCardInfoMode>>(g) { // from class: com.blued.android.module.yy_china.presenter.YYRelationShipMyRoomItemPresenter$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRelationShipRoomUserCardInfoMode> response) {
                int i;
                Intrinsics.e(response, "response");
                ArrayList arrayList = new ArrayList();
                if (!response.hasData()) {
                    this.a(false);
                    return;
                }
                if (IFetchDataListener.this != null) {
                    List<YYRelationShipRoomUserCardInfoMode> list = response.data;
                    Intrinsics.c(list, "response.data");
                    for (YYRelationShipRoomUserCardInfoMode it : list) {
                        Intrinsics.c(it, "it");
                        arrayList.add(new YYRelationShipRoomMyRoom(0, it));
                    }
                    IFetchDataListener.this.a(this.m(), arrayList);
                    YYRelationShipMyRoomItemPresenter yYRelationShipMyRoomItemPresenter = this;
                    i = yYRelationShipMyRoomItemPresenter.j;
                    yYRelationShipMyRoomItemPresenter.j = i + 1;
                }
                this.a(response.hasMore());
                IFetchDataListener iFetchDataListener2 = IFetchDataListener.this;
                if (iFetchDataListener2 == null) {
                    return;
                }
                iFetchDataListener2.b(this.n());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                int i;
                int i2;
                super.onUIFinish(z);
                if (!z) {
                    i = this.j;
                    if (i > 0) {
                        YYRelationShipMyRoomItemPresenter yYRelationShipMyRoomItemPresenter = this;
                        i2 = yYRelationShipMyRoomItemPresenter.j;
                        yYRelationShipMyRoomItemPresenter.j = i2 - 1;
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
        String string = bundle.getString("relation_id");
        String str = string;
        if (string == null) {
            str = "";
        }
        d(str);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
        this.j = 1;
        this.k = true;
        c(iFetchDataListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(boolean z) {
        this.k = z;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
        c(iFetchDataListener);
    }

    public final void d(String str) {
        Intrinsics.e(str, "<set-?>");
        this.i = str;
    }

    public final String m() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean n() {
        return this.k;
    }
}
