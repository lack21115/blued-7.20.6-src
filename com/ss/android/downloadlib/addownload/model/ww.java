package com.ss.android.downloadlib.addownload.model;

import android.content.SharedPreferences;
import com.ss.android.downloadlib.addownload.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/model/ww.class */
public class ww {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/model/ww$mb.class */
    public static class mb {
        private static ww mb = new ww();
    }

    private ww() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences b() {
        return x.getContext().getSharedPreferences("sp_ad_download_event", 0);
    }

    public static ww mb() {
        return mb.mb;
    }

    public void mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(oxVar);
        mb((Collection<com.ss.android.downloadad.api.mb.ox>) arrayList);
    }

    public void mb(final Collection<com.ss.android.downloadad.api.mb.ox> collection) {
        synchronized (this) {
            if (collection != null) {
                if (!collection.isEmpty()) {
                    com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.addownload.model.ww.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SharedPreferences.Editor edit = ww.this.b().edit();
                            for (com.ss.android.downloadad.api.mb.ox oxVar : collection) {
                                if (oxVar != null && oxVar.ox() != 0) {
                                    edit.putString(String.valueOf(oxVar.ox()), oxVar.km().toString());
                                }
                            }
                            edit.apply();
                        }
                    }, true);
                }
            }
        }
    }

    public void mb(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.addownload.model.ww.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = ww.this.b().edit();
                for (String str : list) {
                    edit.remove(str);
                }
                edit.apply();
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.mb.ox> ox() {
        ConcurrentHashMap<Long, com.ss.android.downloadad.api.mb.ox> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = b().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long longValue = Long.valueOf(entry.getKey()).longValue();
                    com.ss.android.downloadad.api.mb.ox ox = com.ss.android.downloadad.api.mb.ox.ox(new JSONObject(String.valueOf(entry.getValue())));
                    if (longValue > 0 && ox != null) {
                        concurrentHashMap.put(Long.valueOf(longValue), ox);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return concurrentHashMap;
    }
}
