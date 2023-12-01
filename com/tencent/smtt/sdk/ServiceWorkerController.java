package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build;
import com.tencent.smtt.export.external.interfaces.IX5CoreServiceWorkerController;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerClient;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/ServiceWorkerController.class */
public abstract class ServiceWorkerController {
    public static ServiceWorkerController getInstance(Context context) {
        w a2 = w.a();
        a2.a(context);
        ServiceWorkerController serviceWorkerController = null;
        if (!a2.b()) {
            if (Build.VERSION.SDK_INT >= 24) {
                return new k();
            }
            return null;
        }
        final IX5CoreServiceWorkerController q = w.a().c().q();
        if (q != null) {
            serviceWorkerController = new ServiceWorkerController() { // from class: com.tencent.smtt.sdk.ServiceWorkerController.1
                @Override // com.tencent.smtt.sdk.ServiceWorkerController
                public ServiceWorkerWebSettings getServiceWorkerWebSettings() {
                    return IX5CoreServiceWorkerController.this.getServiceWorkerWebSettings();
                }

                @Override // com.tencent.smtt.sdk.ServiceWorkerController
                public void setServiceWorkerClient(ServiceWorkerClient serviceWorkerClient) {
                    IX5CoreServiceWorkerController.this.setServiceWorkerClient(serviceWorkerClient);
                }
            };
        }
        return serviceWorkerController;
    }

    public abstract ServiceWorkerWebSettings getServiceWorkerWebSettings();

    public abstract void setServiceWorkerClient(ServiceWorkerClient serviceWorkerClient);
}
