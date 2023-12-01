package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditConstants;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ds.class */
public final /* synthetic */ class ds implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    private static final ds f40333a = new ds();

    private ds() {
    }

    public static Comparator a() {
        return f40333a;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return UGCMediaListSource.lambda$updateSpeedInfoToClips$2((TXVideoEditConstants.TXSpeed) obj, (TXVideoEditConstants.TXSpeed) obj2);
    }
}
