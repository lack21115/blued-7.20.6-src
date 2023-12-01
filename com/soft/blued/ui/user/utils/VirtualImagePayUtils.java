package com.soft.blued.ui.user.utils;

import android.content.Context;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.soft.blued.ui.user.model.VirtualImageModel;
import com.soft.blued.view.dialog.DialogWith6PW;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/utils/VirtualImagePayUtils.class */
public final class VirtualImagePayUtils {

    /* renamed from: a  reason: collision with root package name */
    private DialogWith6PW f34336a;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/utils/VirtualImagePayUtils$PayResult.class */
    public interface PayResult {
        void a(int i);

        void a(int i, String str);
    }

    private final BluedUIHttpResponse<BluedEntityA<VirtualImageModel.PaidResp>> a(Context context, IRequestHost iRequestHost, List<VirtualImageModel.PayGoodsInfo> list, PayResult payResult) {
        return new VirtualImagePayUtils$getResponse$1(iRequestHost, this, payResult, context, list);
    }

    public final DialogWith6PW a() {
        return this.f34336a;
    }

    public final void a(Context context, IRequestHost requestHost, String str, String str2, int i, List<VirtualImageModel.PayGoodsInfo> goodsList, PayResult payResult) {
        Intrinsics.e(context, "context");
        Intrinsics.e(requestHost, "requestHost");
        Intrinsics.e(goodsList, "goodsList");
        Intrinsics.e(payResult, "payResult");
        String a2 = Intrinsics.a(BluedHttpUrl.q(), (Object) "/users/face/pay/goods");
        Map<String, Object> params = BluedHttpTools.b();
        Intrinsics.c(params, "params");
        params.put("pay_code", str2);
        params.put("rememberMe", Integer.valueOf(i));
        params.put("pay_token", str);
        params.put("goodsInfo", goodsList);
        HttpManager.b(a2, a(context, requestHost, goodsList, payResult), requestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(params)).h();
    }

    public final void a(DialogWith6PW dialogWith6PW) {
        this.f34336a = dialogWith6PW;
    }
}
