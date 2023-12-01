package android.service.carrier;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.service.carrier.ICarrierMessagingService;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/service/carrier/CarrierMessagingService.class */
public abstract class CarrierMessagingService extends Service {
    public static final int DOWNLOAD_STATUS_ERROR = 2;
    public static final int DOWNLOAD_STATUS_OK = 0;
    public static final int DOWNLOAD_STATUS_RETRY_ON_CARRIER_NETWORK = 1;
    public static final int SEND_STATUS_ERROR = 2;
    public static final int SEND_STATUS_OK = 0;
    public static final int SEND_STATUS_RETRY_ON_CARRIER_NETWORK = 1;
    public static final String SERVICE_INTERFACE = "android.service.carrier.CarrierMessagingService";
    private final ICarrierMessagingWrapper mWrapper = new ICarrierMessagingWrapper();

    /* loaded from: source-9557208-dex2jar.jar:android/service/carrier/CarrierMessagingService$ICarrierMessagingWrapper.class */
    private class ICarrierMessagingWrapper extends ICarrierMessagingService.Stub {
        private ICarrierMessagingWrapper() {
        }

        @Override // android.service.carrier.ICarrierMessagingService
        public void downloadMms(Uri uri, int i, Uri uri2, final ICarrierMessagingCallback iCarrierMessagingCallback) {
            CarrierMessagingService.this.onDownloadMms(uri, i, uri2, new ResultCallback<Integer>() { // from class: android.service.carrier.CarrierMessagingService.ICarrierMessagingWrapper.6
                @Override // android.service.carrier.CarrierMessagingService.ResultCallback
                public void onReceiveResult(Integer num) throws RemoteException {
                    iCarrierMessagingCallback.onDownloadMmsComplete(num.intValue());
                }
            });
        }

        @Override // android.service.carrier.ICarrierMessagingService
        public void filterSms(MessagePdu messagePdu, String str, int i, int i2, final ICarrierMessagingCallback iCarrierMessagingCallback) {
            CarrierMessagingService.this.onFilterSms(messagePdu, str, i, i2, new ResultCallback<Boolean>() { // from class: android.service.carrier.CarrierMessagingService.ICarrierMessagingWrapper.1
                @Override // android.service.carrier.CarrierMessagingService.ResultCallback
                public void onReceiveResult(Boolean bool) throws RemoteException {
                    iCarrierMessagingCallback.onFilterComplete(bool.booleanValue());
                }
            });
        }

        @Override // android.service.carrier.ICarrierMessagingService
        public void sendDataSms(byte[] bArr, int i, String str, int i2, final ICarrierMessagingCallback iCarrierMessagingCallback) {
            CarrierMessagingService.this.onSendDataSms(bArr, i, str, i2, new ResultCallback<SendSmsResult>() { // from class: android.service.carrier.CarrierMessagingService.ICarrierMessagingWrapper.3
                @Override // android.service.carrier.CarrierMessagingService.ResultCallback
                public void onReceiveResult(SendSmsResult sendSmsResult) throws RemoteException {
                    iCarrierMessagingCallback.onSendSmsComplete(sendSmsResult.getSendStatus(), sendSmsResult.getMessageRef());
                }
            });
        }

        @Override // android.service.carrier.ICarrierMessagingService
        public void sendMms(Uri uri, int i, Uri uri2, final ICarrierMessagingCallback iCarrierMessagingCallback) {
            CarrierMessagingService.this.onSendMms(uri, i, uri2, new ResultCallback<SendMmsResult>() { // from class: android.service.carrier.CarrierMessagingService.ICarrierMessagingWrapper.5
                @Override // android.service.carrier.CarrierMessagingService.ResultCallback
                public void onReceiveResult(SendMmsResult sendMmsResult) throws RemoteException {
                    iCarrierMessagingCallback.onSendMmsComplete(sendMmsResult.getSendStatus(), sendMmsResult.getSendConfPdu());
                }
            });
        }

        @Override // android.service.carrier.ICarrierMessagingService
        public void sendMultipartTextSms(List<String> list, int i, String str, final ICarrierMessagingCallback iCarrierMessagingCallback) {
            CarrierMessagingService.this.onSendMultipartTextSms(list, i, str, new ResultCallback<SendMultipartSmsResult>() { // from class: android.service.carrier.CarrierMessagingService.ICarrierMessagingWrapper.4
                @Override // android.service.carrier.CarrierMessagingService.ResultCallback
                public void onReceiveResult(SendMultipartSmsResult sendMultipartSmsResult) throws RemoteException {
                    iCarrierMessagingCallback.onSendMultipartSmsComplete(sendMultipartSmsResult.getSendStatus(), sendMultipartSmsResult.getMessageRefs());
                }
            });
        }

        @Override // android.service.carrier.ICarrierMessagingService
        public void sendTextSms(String str, int i, String str2, final ICarrierMessagingCallback iCarrierMessagingCallback) {
            CarrierMessagingService.this.onSendTextSms(str, i, str2, new ResultCallback<SendSmsResult>() { // from class: android.service.carrier.CarrierMessagingService.ICarrierMessagingWrapper.2
                @Override // android.service.carrier.CarrierMessagingService.ResultCallback
                public void onReceiveResult(SendSmsResult sendSmsResult) throws RemoteException {
                    iCarrierMessagingCallback.onSendSmsComplete(sendSmsResult.getSendStatus(), sendSmsResult.getMessageRef());
                }
            });
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/service/carrier/CarrierMessagingService$ResultCallback.class */
    public interface ResultCallback<T> {
        void onReceiveResult(T t) throws RemoteException;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/service/carrier/CarrierMessagingService$SendMmsResult.class */
    public static final class SendMmsResult {
        private byte[] mSendConfPdu;
        private int mSendStatus;

        public SendMmsResult(int i, byte[] bArr) {
            this.mSendStatus = i;
            this.mSendConfPdu = bArr;
        }

        public byte[] getSendConfPdu() {
            return this.mSendConfPdu;
        }

        public int getSendStatus() {
            return this.mSendStatus;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/service/carrier/CarrierMessagingService$SendMultipartSmsResult.class */
    public static final class SendMultipartSmsResult {
        private final int[] mMessageRefs;
        private final int mSendStatus;

        public SendMultipartSmsResult(int i, int[] iArr) {
            this.mSendStatus = i;
            this.mMessageRefs = iArr;
        }

        public int[] getMessageRefs() {
            return this.mMessageRefs;
        }

        public int getSendStatus() {
            return this.mSendStatus;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/service/carrier/CarrierMessagingService$SendSmsResult.class */
    public static final class SendSmsResult {
        private final int mMessageRef;
        private final int mSendStatus;

        public SendSmsResult(int i, int i2) {
            this.mSendStatus = i;
            this.mMessageRef = i2;
        }

        public int getMessageRef() {
            return this.mMessageRef;
        }

        public int getSendStatus() {
            return this.mSendStatus;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (SERVICE_INTERFACE.equals(intent.getAction())) {
            return this.mWrapper;
        }
        return null;
    }

    public void onDownloadMms(Uri uri, int i, Uri uri2, ResultCallback<Integer> resultCallback) {
        try {
            resultCallback.onReceiveResult(1);
        } catch (RemoteException e) {
        }
    }

    public void onFilterSms(MessagePdu messagePdu, String str, int i, int i2, ResultCallback<Boolean> resultCallback) {
        try {
            resultCallback.onReceiveResult(true);
        } catch (RemoteException e) {
        }
    }

    public void onSendDataSms(byte[] bArr, int i, String str, int i2, ResultCallback<SendSmsResult> resultCallback) {
        try {
            resultCallback.onReceiveResult(new SendSmsResult(1, 0));
        } catch (RemoteException e) {
        }
    }

    public void onSendMms(Uri uri, int i, Uri uri2, ResultCallback<SendMmsResult> resultCallback) {
        try {
            resultCallback.onReceiveResult(new SendMmsResult(1, null));
        } catch (RemoteException e) {
        }
    }

    public void onSendMultipartTextSms(List<String> list, int i, String str, ResultCallback<SendMultipartSmsResult> resultCallback) {
        try {
            resultCallback.onReceiveResult(new SendMultipartSmsResult(1, null));
        } catch (RemoteException e) {
        }
    }

    public void onSendTextSms(String str, int i, String str2, ResultCallback<SendSmsResult> resultCallback) {
        try {
            resultCallback.onReceiveResult(new SendSmsResult(1, 0));
        } catch (RemoteException e) {
        }
    }
}
