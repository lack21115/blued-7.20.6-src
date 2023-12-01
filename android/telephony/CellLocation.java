package android.telephony;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.android.internal.telephony.ITelephony;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/CellLocation.class */
public abstract class CellLocation {
    public static CellLocation getEmpty() {
        switch (TelephonyManager.getDefault().getCurrentPhoneType()) {
            case 1:
                return new GsmCellLocation();
            case 2:
                return new CdmaCellLocation();
            default:
                return null;
        }
    }

    public static CellLocation newFromBundle(Bundle bundle) {
        switch (TelephonyManager.getDefault().getCurrentPhoneType()) {
            case 1:
                return new GsmCellLocation(bundle);
            case 2:
                return new CdmaCellLocation(bundle);
            default:
                return null;
        }
    }

    public static void requestLocationUpdate() {
        try {
            ITelephony asInterface = ITelephony.Stub.asInterface(ServiceManager.getService("phone"));
            if (asInterface != null) {
                asInterface.updateServiceLocation();
            }
        } catch (RemoteException e) {
        }
    }

    public abstract void fillInNotifierBundle(Bundle bundle);

    public abstract boolean isEmpty();
}
