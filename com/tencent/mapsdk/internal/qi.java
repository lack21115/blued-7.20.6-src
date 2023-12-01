package com.tencent.mapsdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qi.class */
public class qi extends Handler {
    public static final int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f37730c = 1;
    public static final int d = 2;

    /* renamed from: a  reason: collision with root package name */
    private final yi f37731a;

    public qi(yi yiVar, Looper looper) {
        super(looper);
        this.f37731a = yiVar;
        ra.h(qa.T);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        CameraPosition J;
        super.handleMessage(message);
        yi yiVar = this.f37731a;
        if (yiVar == null || yiVar.getMap() == null || !yiVar.getMap().g() || (J = yiVar.J()) == null) {
            return;
        }
        if (message.what == 2) {
            yiVar.Z();
            ra.i(qa.T);
        }
        int i = message.what;
        if (i == 0) {
            yiVar.onCameraChange(J);
        } else if (i == 1) {
            yiVar.a0();
            yiVar.onCameraChangeFinished(J);
        }
        yiVar.d0();
    }
}
