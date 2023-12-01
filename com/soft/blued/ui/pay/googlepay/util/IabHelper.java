package com.soft.blued.ui.pay.googlepay.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.vending.billing.IInAppBillingService;
import com.blued.android.framework.pool.ThreadExecutor;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/googlepay/util/IabHelper.class */
public class IabHelper {

    /* renamed from: a  reason: collision with root package name */
    boolean f19308a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    boolean f19309c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    String i;
    Context j;
    IInAppBillingService k;
    ServiceConnection l;
    String m;
    OnIabPurchaseFinishedListener n;
    private final Object o;

    /* renamed from: com.soft.blued.ui.pay.googlepay.util.IabHelper$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/googlepay/util/IabHelper$1.class */
    class AnonymousClass1 implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OnIabSetupFinishedListener f19310a;
        final /* synthetic */ IabHelper b;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (this.b.d) {
                return;
            }
            this.b.b("Billing service connected.");
            this.b.k = IInAppBillingService.Stub.a(iBinder);
            String packageName = this.b.j.getPackageName();
            try {
                this.b.b("Checking for in-app billing 3 support.");
                int a2 = this.b.k.a(3, packageName, "inapp");
                if (a2 != 0) {
                    if (this.f19310a != null) {
                        this.f19310a.a(new IabResult(a2, "Error checking for billing v3 support."));
                    }
                    this.b.f = false;
                    this.b.g = false;
                    return;
                }
                IabHelper iabHelper = this.b;
                iabHelper.b("In-app billing version 3 supported for " + packageName);
                if (this.b.k.a(5, packageName, "subs") == 0) {
                    this.b.b("Subscription re-signup AVAILABLE.");
                    this.b.g = true;
                } else {
                    this.b.b("Subscription re-signup not available.");
                    this.b.g = false;
                }
                if (this.b.g) {
                    this.b.f = true;
                } else {
                    int a3 = this.b.k.a(3, packageName, "subs");
                    if (a3 == 0) {
                        this.b.b("Subscriptions AVAILABLE.");
                        this.b.f = true;
                    } else {
                        IabHelper iabHelper2 = this.b;
                        iabHelper2.b("Subscriptions NOT AVAILABLE. Response: " + a3);
                        this.b.f = false;
                        this.b.g = false;
                    }
                }
                this.b.f19309c = true;
                OnIabSetupFinishedListener onIabSetupFinishedListener = this.f19310a;
                if (onIabSetupFinishedListener != null) {
                    onIabSetupFinishedListener.a(new IabResult(0, "Setup successful."));
                }
            } catch (RemoteException e) {
                OnIabSetupFinishedListener onIabSetupFinishedListener2 = this.f19310a;
                if (onIabSetupFinishedListener2 != null) {
                    onIabSetupFinishedListener2.a(new IabResult(-1001, "RemoteException while setting up in-app billing."));
                }
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.b.b("Billing service disconnected.");
            this.b.k = null;
        }
    }

    /* renamed from: com.soft.blued.ui.pay.googlepay.util.IabHelper$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/googlepay/util/IabHelper$2.class */
    class AnonymousClass2 extends ThreadExecutor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f19311a;
        final /* synthetic */ List b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f19312c;
        final /* synthetic */ QueryInventoryFinishedListener d;
        final /* synthetic */ Handler e;
        final /* synthetic */ IabHelper f;

        public void execute() {
            Inventory inventory;
            IabResult iabResult = new IabResult(0, "Inventory refresh successful.");
            try {
                inventory = this.f.a(this.f19311a, this.b, this.f19312c);
            } catch (IabException e) {
                iabResult = e.a();
                inventory = null;
            }
            this.f.b();
            if (this.f.d || this.d == null) {
                return;
            }
            final IabResult iabResult2 = iabResult;
            final Inventory inventory2 = inventory;
            this.e.post(new Runnable() { // from class: com.soft.blued.ui.pay.googlepay.util.IabHelper.2.1
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass2.this.d.a(iabResult2, inventory2);
                }
            });
        }
    }

    /* renamed from: com.soft.blued.ui.pay.googlepay.util.IabHelper$3  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/googlepay/util/IabHelper$3.class */
    class AnonymousClass3 extends ThreadExecutor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f19315a;
        final /* synthetic */ OnConsumeFinishedListener b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Handler f19316c;
        final /* synthetic */ OnConsumeMultiFinishedListener d;
        final /* synthetic */ IabHelper e;

        public void execute() {
            final ArrayList arrayList = new ArrayList();
            for (Purchase purchase : this.f19315a) {
                try {
                    this.e.a(purchase);
                    arrayList.add(new IabResult(0, "Successful consume of sku " + purchase.b()));
                } catch (IabException e) {
                    arrayList.add(e.a());
                }
            }
            this.e.b();
            if (!this.e.d && this.b != null) {
                this.f19316c.post(new Runnable() { // from class: com.soft.blued.ui.pay.googlepay.util.IabHelper.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass3.this.b.a((Purchase) AnonymousClass3.this.f19315a.get(0), (IabResult) arrayList.get(0));
                    }
                });
            }
            if (this.e.d || this.d == null) {
                return;
            }
            this.f19316c.post(new Runnable() { // from class: com.soft.blued.ui.pay.googlepay.util.IabHelper.3.2
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass3.this.d.a(AnonymousClass3.this.f19315a, arrayList);
                }
            });
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/googlepay/util/IabHelper$IabAsyncInProgressException.class */
    public static class IabAsyncInProgressException extends Exception {
        public IabAsyncInProgressException(String str) {
            super(str);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/googlepay/util/IabHelper$OnConsumeFinishedListener.class */
    public interface OnConsumeFinishedListener {
        void a(Purchase purchase, IabResult iabResult);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/googlepay/util/IabHelper$OnConsumeMultiFinishedListener.class */
    public interface OnConsumeMultiFinishedListener {
        void a(List<Purchase> list, List<IabResult> list2);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/googlepay/util/IabHelper$OnIabPurchaseFinishedListener.class */
    public interface OnIabPurchaseFinishedListener {
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/googlepay/util/IabHelper$OnIabSetupFinishedListener.class */
    public interface OnIabSetupFinishedListener {
        void a(IabResult iabResult);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/googlepay/util/IabHelper$QueryInventoryFinishedListener.class */
    public interface QueryInventoryFinishedListener {
        void a(IabResult iabResult, Inventory inventory);
    }

    public static String a(int i) {
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (i > -1000) {
            if (i < 0 || i >= split.length) {
                return i + ":Unknown";
            }
            return split[i];
        }
        int i2 = (-1000) - i;
        if (i2 < 0 || i2 >= split2.length) {
            return i + ":Unknown IAB Helper Error";
        }
        return split2[i2];
    }

    private void c() {
        if (this.d) {
            throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
        }
    }

    int a(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            b("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            c("Unexpected type for bundle response code.");
            c(obj.getClass().getName());
            throw new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
        }
    }

    int a(Inventory inventory, String str) throws JSONException, RemoteException {
        boolean z;
        String string;
        b("Querying owned items, item type: " + str);
        b("Package name: " + this.j.getPackageName());
        String str2 = null;
        boolean z2 = false;
        do {
            b("Calling getPurchases with continuation token: " + str2);
            Bundle a2 = this.k.a(3, this.j.getPackageName(), str, str2);
            int a3 = a(a2);
            b("Owned items response: " + a3);
            if (a3 != 0) {
                b("getPurchases() failed: " + a(a3));
                return a3;
            } else if (!a2.containsKey("INAPP_PURCHASE_ITEM_LIST") || !a2.containsKey("INAPP_PURCHASE_DATA_LIST") || !a2.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                c("Bundle returned from getPurchases() doesn't contain required fields.");
                return -1002;
            } else {
                ArrayList<String> stringArrayList = a2.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = a2.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = a2.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                z = z2;
                for (int i = 0; i < stringArrayList2.size(); i++) {
                    String str3 = stringArrayList2.get(i);
                    String str4 = stringArrayList3.get(i);
                    String str5 = stringArrayList.get(i);
                    b("queryPurchases result==");
                    b("Purchase data: " + str3);
                    b("Data signature: " + str4);
                    b("sku: " + str5);
                    if (Security.a(this.m, str3, str4)) {
                        b("Sku is owned: " + str5);
                        Purchase purchase = new Purchase(str, str3, str4);
                        if (TextUtils.isEmpty(purchase.c())) {
                            d("BUG: empty/null token!");
                            b("Purchase data: " + str3);
                        }
                        inventory.a(purchase);
                    } else {
                        d("Purchase signature verification **FAILED**. Not adding item.");
                        b("   Purchase data: " + str3);
                        b("   Signature: " + str4);
                        z = true;
                    }
                }
                string = a2.getString("INAPP_CONTINUATION_TOKEN");
                b("Continuation token: " + string);
                str2 = string;
                z2 = z;
            }
        } while (!TextUtils.isEmpty(string));
        return z ? -1003 : 0;
    }

    int a(String str, Inventory inventory, List<String> list) throws RemoteException, JSONException, IllegalStateException {
        b("Querying SKU details.");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(inventory.a(str));
        if (list != null) {
            for (String str2 : list) {
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        if (arrayList.size() == 0) {
            b("queryPrices: nothing to do because there are no SKUs.");
            return 0;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size() / 20;
        int size2 = arrayList.size() % 20;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            ArrayList arrayList3 = new ArrayList();
            int i3 = i2 * 20;
            for (String str3 : arrayList.subList(i3, i3 + 20)) {
                arrayList3.add(str3);
            }
            arrayList2.add(arrayList3);
            i = i2 + 1;
        }
        if (size2 != 0) {
            ArrayList arrayList4 = new ArrayList();
            int i4 = size * 20;
            for (String str4 : arrayList.subList(i4, size2 + i4)) {
                arrayList4.add(str4);
            }
            arrayList2.add(arrayList4);
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ArrayList<String> arrayList5 = (ArrayList) it.next();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList5);
            Bundle a2 = this.k.a(3, this.j.getPackageName(), str, bundle);
            if (!a2.containsKey("DETAILS_LIST")) {
                int a3 = a(a2);
                if (a3 == 0) {
                    c("getSkuDetails() returned a bundle with neither an error nor a detail list.");
                    return -1002;
                }
                b("getSkuDetails() failed: " + a(a3));
                return a3;
            }
            Iterator<String> it2 = a2.getStringArrayList("DETAILS_LIST").iterator();
            while (it2.hasNext()) {
                SkuDetails skuDetails = new SkuDetails(str, it2.next());
                b("Got sku details: " + skuDetails);
                inventory.a(skuDetails);
            }
        }
        return 0;
    }

    public Inventory a(boolean z, List<String> list, List<String> list2) throws IabException {
        int a2;
        c();
        a("queryInventory");
        try {
            Inventory inventory = new Inventory();
            int a3 = a(inventory, "inapp");
            if (a3 == 0) {
                if (!z || (a2 = a("inapp", inventory, list)) == 0) {
                    if (this.f) {
                        int a4 = a(inventory, "subs");
                        if (a4 != 0) {
                            throw new IabException(a4, "Error refreshing inventory (querying owned subscriptions).");
                        }
                        if (z) {
                            int a5 = a("subs", inventory, list2);
                            if (a5 == 0) {
                                return inventory;
                            }
                            throw new IabException(a5, "Error refreshing inventory (querying prices of subscriptions).");
                        }
                    }
                    return inventory;
                }
                throw new IabException(a2, "Error refreshing inventory (querying prices of items).");
            }
            throw new IabException(a3, "Error refreshing inventory (querying owned items).");
        } catch (RemoteException e) {
            throw new IabException(-1001, "Remote exception while refreshing inventory.", e);
        } catch (IllegalStateException e2) {
            throw new IabException(-1008, "Exception java.lang.IllegalStateException: Failed parsing settings file: /data/system/users/0/settings_fingerprint.xml IabHelper.querySkuDetails (IabHelper.java:1059)", e2);
        } catch (NullPointerException e3) {
            throw new IabException(-1008, "NullPointer while refreshing inventory.", e3);
        } catch (JSONException e4) {
            throw new IabException(-1002, "Error parsing JSON response while refreshing inventory.", e4);
        }
    }

    public void a() throws IabAsyncInProgressException {
        synchronized (this.o) {
            if (this.h) {
                throw new IabAsyncInProgressException("Can't dispose because an async operation (" + this.i + ") is in progress.");
            }
        }
        b("Disposing.");
        this.f19309c = false;
        if (this.l != null) {
            b("Unbinding from service.");
            Context context = this.j;
            if (context != null) {
                context.unbindService(this.l);
            }
        }
        this.d = true;
        this.j = null;
        this.l = null;
        this.k = null;
        this.n = null;
    }

    void a(Purchase purchase) throws IabException {
        c();
        a("consume");
        if (!purchase.f19321a.equals("inapp")) {
            throw new IabException(-1010, "Items of type '" + purchase.f19321a + "' can't be consumed.");
        }
        try {
            String c2 = purchase.c();
            String b = purchase.b();
            if (c2 == null || c2.equals("")) {
                c("Can't consume " + b + ". No token.");
                throw new IabException(-1007, "PurchaseInfo is missing token for sku: " + b + " " + purchase);
            }
            b("Consuming sku: " + b + ", token: " + c2);
            int b2 = this.k.b(3, this.j.getPackageName(), c2);
            if (b2 == 0) {
                b("Successfully consumed sku: " + b);
                return;
            }
            b("Error consuming consuming sku " + b + ". " + a(b2));
            throw new IabException(b2, "Error consuming sku " + b);
        } catch (RemoteException e) {
            throw new IabException(-1001, "Remote exception while consuming. PurchaseInfo: " + purchase, e);
        }
    }

    void a(String str) {
        if (this.f19309c) {
            return;
        }
        c("Illegal state for operation (" + str + "): IAB helper is not set up.");
        throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + str);
    }

    void b() {
        synchronized (this.o) {
            b("Ending async operation: " + this.i);
            this.i = "";
            this.h = false;
            if (this.e) {
                try {
                    a();
                } catch (IabAsyncInProgressException e) {
                }
            }
        }
    }

    void b(String str) {
        if (this.f19308a) {
            Logger.c(this.b, str);
        }
    }

    void c(String str) {
        Logger.e(this.b, "In-app billing error: ", str);
    }

    void d(String str) {
        Logger.d(this.b, "In-app billing warning: ", str);
    }
}
