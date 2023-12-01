package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditConstants;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/dr.class */
public final /* synthetic */ class dr implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    private static final dr f26641a = new dr();

    private dr() {
    }

    public static Comparator a() {
        return f26641a;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return UGCMediaListSource.lambda$cutSingleVideoFileToClips$1((TXVideoEditConstants.TXRepeat) obj, (TXVideoEditConstants.TXRepeat) obj2);
    }
}
