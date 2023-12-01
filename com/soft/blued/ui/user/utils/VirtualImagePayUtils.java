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
    private DialogWith6PW f20645a;

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
        return this.f20645a;
    }

    public final void a(Context context, IRequestHost iRequestHost, String str, String str2, int i, List<VirtualImageModel.PayGoodsInfo> list, PayResult payResult) {
        Intrinsics.e(context, "context");
        Intrinsics.e(iRequestHost, "requestHost");
        Intrinsics.e(list, "goodsList");
        Intrinsics.e(payResult, "payResult");
        String a2 = Intrinsics.a(BluedHttpUrl.q(), "/users/face/pay/goods");
        Map b = BluedHttpTools.b();
        Intrinsics.c(b, "params");
        b.put("pay_code", str2);
        b.put("rememberMe", Integer.valueOf(i));
        b.put("pay_token", str);
        b.put("goodsInfo", list);
        HttpManager.b(a2, a(context, iRequestHost, list, payResult), iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public final void a(DialogWith6PW dialogWith6PW) {
        this.f20645a = dialogWith6PW;
    }
}
