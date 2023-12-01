package com.tencent.beacon.a.c;

import com.tencent.beacon.base.util.BeaconLogger;
import com.tencent.qimei.log.IObservableLog;
import com.tencent.qimei.upload.BuildConfig;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/c/h.class */
final class h implements IObservableLog {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BeaconLogger f34946a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BeaconLogger beaconLogger) {
        this.f34946a = beaconLogger;
    }

    @Override // com.tencent.qimei.log.IObservableLog
    public void onLog(String str) {
        this.f34946a.d(BuildConfig.SDK_ID, str);
    }
}
