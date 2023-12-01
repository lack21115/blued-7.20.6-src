package com.blued.android.module.yy_china.fragment;

import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.databinding.FragmentPageExhibitionBinding;
import com.blued.android.module.yy_china.fragment.YYDecorateExhibitionFragment;
import com.blued.android.module.yy_china.model.YYCarExhibitionModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYDecorateExhibitionFragment$loadCarList$1.class */
public final class YYDecorateExhibitionFragment$loadCarList$1 extends BluedUIHttpResponse<BluedEntityA<YYCarExhibitionModel>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ YYDecorateExhibitionFragment f17224a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYDecorateExhibitionFragment$loadCarList$1(YYDecorateExhibitionFragment yYDecorateExhibitionFragment, ActivityFragmentActive activityFragmentActive) {
        super(activityFragmentActive);
        this.f17224a = yYDecorateExhibitionFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYDecorateExhibitionFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    /* renamed from: a */
    public void onUIUpdate(BluedEntityA<YYCarExhibitionModel> bluedEntityA) {
        YYDecorateExhibitionFragment.ReceiveCarAdapter receiveCarAdapter;
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding;
        int i;
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding2;
        if (bluedEntityA == null || !bluedEntityA.hasData()) {
            this.f17224a.e();
            return;
        }
        receiveCarAdapter = this.f17224a.e;
        YYDecorateExhibitionFragment.ReceiveCarAdapter receiveCarAdapter2 = receiveCarAdapter;
        if (receiveCarAdapter == null) {
            Intrinsics.c("receiveCarAdapter");
            receiveCarAdapter2 = null;
        }
        receiveCarAdapter2.setNewData(bluedEntityA.data);
        if (!bluedEntityA.hasMore()) {
            fragmentPageExhibitionBinding = this.f17224a.d;
            FragmentPageExhibitionBinding fragmentPageExhibitionBinding3 = fragmentPageExhibitionBinding;
            if (fragmentPageExhibitionBinding3 == null) {
                Intrinsics.c("mBinding");
                fragmentPageExhibitionBinding3 = null;
            }
            fragmentPageExhibitionBinding3.e.l(false);
            return;
        }
        YYDecorateExhibitionFragment yYDecorateExhibitionFragment = this.f17224a;
        i = yYDecorateExhibitionFragment.f17221c;
        yYDecorateExhibitionFragment.f17221c = i + 1;
        fragmentPageExhibitionBinding2 = this.f17224a.d;
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding4 = fragmentPageExhibitionBinding2;
        if (fragmentPageExhibitionBinding4 == null) {
            Intrinsics.c("mBinding");
            fragmentPageExhibitionBinding4 = null;
        }
        fragmentPageExhibitionBinding4.e.l(true);
    }

    @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    public void onFailure(Throwable th, int i, String str) {
        super.onFailure(th, i, str);
        final YYDecorateExhibitionFragment yYDecorateExhibitionFragment = this.f17224a;
        yYDecorateExhibitionFragment.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateExhibitionFragment$loadCarList$1$F2DEbZHmqImHi55NR8siDDBYa6A
            @Override // java.lang.Runnable
            public final void run() {
                YYDecorateExhibitionFragment$loadCarList$1.a(YYDecorateExhibitionFragment.this);
            }
        });
    }

    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    public void onUIFinish(boolean z) {
        super.onUIFinish(z);
        this.f17224a.e();
    }
}
