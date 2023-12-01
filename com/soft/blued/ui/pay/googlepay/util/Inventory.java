package com.soft.blued.ui.pay.googlepay.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/googlepay/util/Inventory.class */
public class Inventory {

    /* renamed from: a  reason: collision with root package name */
    Map<String, SkuDetails> f33011a = new HashMap();
    Map<String, Purchase> b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> a(String str) {
        ArrayList arrayList = new ArrayList();
        for (Purchase purchase : this.b.values()) {
            if (purchase.a().equals(str)) {
                arrayList.add(purchase.b());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Purchase purchase) {
        this.b.put(purchase.b(), purchase);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SkuDetails skuDetails) {
        this.f33011a.put(skuDetails.a(), skuDetails);
    }
}
