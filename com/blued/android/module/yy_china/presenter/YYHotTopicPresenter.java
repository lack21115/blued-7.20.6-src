package com.blued.android.module.yy_china.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.yy_china.model.HotTopicItemModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYHotTopicPresenter.class */
public final class YYHotTopicPresenter extends MvpPresenter {
    private final String h = "data_member";
    private int i = 1;
    private boolean j = true;
    private String k;
    private String l;

    private final void c(final IFetchDataListener iFetchDataListener) {
        int i = this.i;
        String str = this.l;
        final IRequestHost g = g();
        YYRoomHttpUtils.a(i, str, new BluedUIHttpResponse<BluedEntityA<HotTopicItemModel>>(g) { // from class: com.blued.android.module.yy_china.presenter.YYHotTopicPresenter$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<HotTopicItemModel> response) {
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
                    YYHotTopicPresenter yYHotTopicPresenter = this;
                    i2 = yYHotTopicPresenter.i;
                    yYHotTopicPresenter.i = i2 + 1;
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
                        YYHotTopicPresenter yYHotTopicPresenter = this;
                        i3 = yYHotTopicPresenter.i;
                        yYHotTopicPresenter.i = i3 - 1;
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
        d(bundle.getString("topic_name"));
        e(bundle.getString("topic_type"));
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
}
