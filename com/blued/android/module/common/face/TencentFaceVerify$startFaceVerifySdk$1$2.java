package com.blued.android.module.common.face;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import kotlin.Metadata;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/face/TencentFaceVerify$startFaceVerifySdk$1$2.class */
public final class TencentFaceVerify$startFaceVerifySdk$1$2 extends BluedUIHttpResponse<BluedEntityA<Object>> {
    TencentFaceVerify$startFaceVerifySdk$1$2() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    /* renamed from: a */
    public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
    }

    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    public void onUIFinish() {
        TencentFaceVerify.a.b();
    }
}
