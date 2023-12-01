package android.hardware;

import android.content.Context;
import android.hardware.IConsumerIrService;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/ConsumerIrManager.class */
public final class ConsumerIrManager {
    private static final String TAG = "ConsumerIr";
    private final String mPackageName;
    private final IConsumerIrService mService = IConsumerIrService.Stub.asInterface(ServiceManager.getService(Context.CONSUMER_IR_SERVICE));

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/ConsumerIrManager$CarrierFrequencyRange.class */
    public final class CarrierFrequencyRange {
        private final int mMaxFrequency;
        private final int mMinFrequency;

        public CarrierFrequencyRange(int i, int i2) {
            this.mMinFrequency = i;
            this.mMaxFrequency = i2;
        }

        public int getMaxFrequency() {
            return this.mMaxFrequency;
        }

        public int getMinFrequency() {
            return this.mMinFrequency;
        }
    }

    public ConsumerIrManager(Context context) {
        this.mPackageName = context.getPackageName();
    }

    public CarrierFrequencyRange[] getCarrierFrequencies() {
        CarrierFrequencyRange[] carrierFrequencyRangeArr;
        if (this.mService == null) {
            Log.w(TAG, "no consumer ir service.");
            carrierFrequencyRangeArr = null;
        } else {
            try {
                int[] carrierFrequencies = this.mService.getCarrierFrequencies();
                if (carrierFrequencies.length % 2 == 0) {
                    CarrierFrequencyRange[] carrierFrequencyRangeArr2 = new CarrierFrequencyRange[carrierFrequencies.length / 2];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        carrierFrequencyRangeArr = carrierFrequencyRangeArr2;
                        if (i2 >= carrierFrequencies.length) {
                            break;
                        }
                        carrierFrequencyRangeArr2[i2 / 2] = new CarrierFrequencyRange(carrierFrequencies[i2], carrierFrequencies[i2 + 1]);
                        i = i2 + 2;
                    }
                } else {
                    Log.w(TAG, "consumer ir service returned an uneven number of frequencies.");
                    return null;
                }
            } catch (RemoteException e) {
                return null;
            }
        }
        return carrierFrequencyRangeArr;
    }

    public boolean hasIrEmitter() {
        if (this.mService == null) {
            Log.w(TAG, "no consumer ir service.");
            return false;
        }
        try {
            return this.mService.hasIrEmitter();
        } catch (RemoteException e) {
            return false;
        }
    }

    public void transmit(int i, int[] iArr) {
        if (this.mService == null) {
            Log.w(TAG, "failed to transmit; no consumer ir service.");
            return;
        }
        try {
            this.mService.transmit(this.mPackageName, i, iArr);
        } catch (RemoteException e) {
            Log.w(TAG, "failed to transmit.", e);
        }
    }
}
