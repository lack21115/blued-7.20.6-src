package com.kwad.components.ad.reward.d;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/d/a.class */
public abstract class a implements f {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        return getPriority() - fVar.getPriority();
    }

    @Override // com.kwad.components.ad.reward.d.f
    public int getPriority() {
        return 0;
    }
}
