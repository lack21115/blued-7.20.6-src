package com.kwad.sdk.core.report;

import com.kwad.sdk.core.report.f;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/p.class */
public final class p<T extends f> implements n<T> {
    private final Map<String, T> aiE = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.n
    /* renamed from: b */
    public void e(T t) {
        synchronized (this) {
            this.aiE.put(t.actionId, t);
        }
    }

    @Override // com.kwad.sdk.core.report.n
    public final void o(List<T> list) {
        synchronized (this) {
            for (T t : list) {
                this.aiE.remove(t.actionId);
            }
        }
    }

    @Override // com.kwad.sdk.core.report.n
    public final long size() {
        long j;
        synchronized (this) {
            int size = this.aiE.size();
            com.kwad.sdk.core.d.b.d("MemReportCache", "size() = " + size);
            j = size;
        }
        return j;
    }

    @Override // com.kwad.sdk.core.report.n
    public final List<T> wV() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.aiE.size());
            for (Map.Entry<String, T> entry : this.aiE.entrySet()) {
                arrayList.add(entry.getValue());
            }
        }
        return arrayList;
    }
}
