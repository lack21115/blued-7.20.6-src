package android.nfc.cardemulation;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/cardemulation/OffHostApduService.class */
public abstract class OffHostApduService extends Service {
    public static final String SERVICE_INTERFACE = "android.nfc.cardemulation.action.OFF_HOST_APDU_SERVICE";
    public static final String SERVICE_META_DATA = "android.nfc.cardemulation.off_host_apdu_service";

    @Override // android.app.Service
    public abstract IBinder onBind(Intent intent);
}
