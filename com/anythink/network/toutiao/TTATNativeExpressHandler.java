package com.anythink.network.toutiao;

import android.util.Log;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATNativeExpressHandler.class */
public class TTATNativeExpressHandler {

    /* renamed from: a  reason: collision with root package name */
    static final String f9130a = TTATNativeExpressHandler.class.getSimpleName();
    final List<TTNativeExpressAd> b;

    /* renamed from: c  reason: collision with root package name */
    final List<TTNativeExpressAd> f9131c = new ArrayList();

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATNativeExpressHandler$RenderCallback.class */
    public interface RenderCallback {
        void onRenderFail(String str, int i);

        void onRenderSuccess(List<TTNativeExpressAd> list);
    }

    public TTATNativeExpressHandler(List<TTNativeExpressAd> list) {
        this.b = list;
    }

    public void startRender(final RenderCallback renderCallback) {
        int size = this.b.size();
        for (final TTNativeExpressAd tTNativeExpressAd : this.b) {
            final int[] iArr = {size};
            tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.anythink.network.toutiao.TTATNativeExpressHandler.1
                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public final void onAdClicked(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public final void onAdShow(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public final void onRenderFail(View view, String str, int i) {
                    Log.e(TTATNativeExpressHandler.f9130a, String.format("onRenderFail, errorCode: %d, errorMsg: %s", Integer.valueOf(i), str));
                    int[] iArr2 = iArr;
                    iArr2[0] = iArr2[0] - 1;
                    if (iArr2[0] == 0) {
                        if (TTATNativeExpressHandler.this.f9131c.size() == 0) {
                            RenderCallback renderCallback2 = renderCallback;
                            if (renderCallback2 != null) {
                                renderCallback2.onRenderFail(str, i);
                                return;
                            }
                            return;
                        }
                        RenderCallback renderCallback3 = renderCallback;
                        if (renderCallback3 != null) {
                            renderCallback3.onRenderSuccess(TTATNativeExpressHandler.this.f9131c);
                        }
                        TTATNativeExpressHandler.this.f9131c.clear();
                        TTATNativeExpressHandler.this.b.clear();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public final void onRenderSuccess(View view, float f, float f2) {
                    Log.i(TTATNativeExpressHandler.f9130a, "onRenderSuccess()");
                    TTATNativeExpressHandler.this.f9131c.add(tTNativeExpressAd);
                    int[] iArr2 = iArr;
                    iArr2[0] = iArr2[0] - 1;
                    if (iArr2[0] == 0) {
                        RenderCallback renderCallback2 = renderCallback;
                        if (renderCallback2 != null) {
                            renderCallback2.onRenderSuccess(TTATNativeExpressHandler.this.f9131c);
                        }
                        TTATNativeExpressHandler.this.f9131c.clear();
                        TTATNativeExpressHandler.this.b.clear();
                    }
                }
            });
            tTNativeExpressAd.render();
        }
    }
}
