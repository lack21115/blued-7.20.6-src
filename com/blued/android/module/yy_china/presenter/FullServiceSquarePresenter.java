package com.blued.android.module.yy_china.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.yy_china.model.FullServiceSquareMode;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/FullServiceSquarePresenter.class */
public final class FullServiceSquarePresenter extends MvpPresenter {
    private final String h = "data_member";
    private int i = 1;
    private boolean j = true;

    private final void c(final IFetchDataListener iFetchDataListener) {
        int i = this.i;
        final IRequestHost g = g();
        YYRoomHttpUtils.a(i, new BluedUIHttpResponse<BluedEntityA<FullServiceSquareMode>>(g) { // from class: com.blued.android.module.yy_china.presenter.FullServiceSquarePresenter$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<FullServiceSquareMode> response) {
                int i2;
                Intrinsics.e(response, "response");
                ArrayList arrayList = new ArrayList();
                if (!response.hasData()) {
                    this.a(false);
                    return;
                }
                if (IFetchDataListener.this != null) {
                    arrayList.addAll(response.data);
                    IFetchDataListener.this.a(this.m(), arrayList);
                    FullServiceSquarePresenter fullServiceSquarePresenter = this;
                    i2 = fullServiceSquarePresenter.i;
                    fullServiceSquarePresenter.i = i2 + 1;
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
                int i2;
                int i3;
                super.onUIFinish(z);
                if (!z) {
                    i2 = this.i;
                    if (i2 > 0) {
                        FullServiceSquarePresenter fullServiceSquarePresenter = this;
                        i3 = fullServiceSquarePresenter.i;
                        fullServiceSquarePresenter.i = i3 - 1;
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
    public void a(IFetchDataListener iFetchDataListener) {
        this.i = 1;
        this.j = true;
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

    public final String m() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean n() {
        return this.j;
    }
}
