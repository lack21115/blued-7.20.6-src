package com.hihonor.push.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushCallback;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.ResponseHeader;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.j;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/r.class */
public class r extends IPushCallback.Stub {

    /* renamed from: a  reason: collision with root package name */
    public final Object f8714a;
    public final s b;

    public r(Object obj, s sVar) {
        this.f8714a = obj;
        this.b = sVar;
    }

    @Override // com.hihonor.push.framework.aidl.IPushCallback
    public void onResult(DataBuffer dataBuffer) throws RemoteException {
        Log.i("IPCCallback", "onResult parse start.");
        Bundle header = dataBuffer.getHeader();
        Bundle body = dataBuffer.getBody();
        ResponseHeader responseHeader = new ResponseHeader();
        MessageCodec.parseMessageEntity(header, responseHeader);
        Object obj = this.f8714a;
        if (obj instanceof IMessageEntity) {
            MessageCodec.parseMessageEntity(body, (IMessageEntity) obj);
        }
        s sVar = this.b;
        ApiException apiException = new ApiException(responseHeader.getStatusCode(), responseHeader.getStatusMessage());
        Object obj2 = this.f8714a;
        j.b bVar = (j.b) sVar;
        bVar.getClass();
        j jVar = j.f8694c;
        p0<?> p0Var = bVar.f8698a;
        jVar.getClass();
        Log.i("HonorApiManager", "sendResolveResult start");
        Handler handler = jVar.f8695a;
        handler.sendMessage(handler.obtainMessage(2, p0Var));
        bVar.f8698a.b(apiException, obj2);
        Log.i("IPCCallback", "onResult parse end.");
    }
}
