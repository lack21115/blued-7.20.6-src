package com.qiniu.android.dns.local;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.NetworkInfo;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/local/Hosts.class */
public final class Hosts {
    private final Hashtable<String, ArrayList<Value>> hosts = new Hashtable<>();

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/local/Hosts$Value.class */
    public static class Value {
        public final String ip;
        public final int provider;

        public Value(String str) {
            this(str, 0);
        }

        public Value(String str, int i) {
            this.ip = str;
            this.provider = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof Value)) {
                return false;
            }
            Value value = (Value) obj;
            return this.ip.equals(value.ip) && this.provider == value.provider;
        }
    }

    private ArrayList<Value> filter(ArrayList<Value> arrayList, NetworkInfo networkInfo) {
        ArrayList<Value> arrayList2 = new ArrayList<>();
        ArrayList<Value> arrayList3 = new ArrayList<>();
        Iterator<Value> it = arrayList.iterator();
        while (it.hasNext()) {
            Value next = it.next();
            if (next.provider == 0) {
                arrayList2.add(next);
            }
            if (networkInfo.provider != 0 && next.provider == networkInfo.provider) {
                arrayList3.add(next);
            }
        }
        return arrayList3.size() != 0 ? arrayList3 : arrayList2;
    }

    public Hosts put(String str, Value value) {
        ArrayList<Value> arrayList = this.hosts.get(str);
        ArrayList<Value> arrayList2 = arrayList;
        if (arrayList == null) {
            arrayList2 = new ArrayList<>();
        }
        arrayList2.add(value);
        this.hosts.put(str, arrayList2);
        return this;
    }

    public Hosts put(String str, String str2) {
        put(str, new Value(str2));
        return this;
    }

    public String[] query(Domain domain, NetworkInfo networkInfo) {
        ArrayList<Value> arrayList = this.hosts.get(domain.domain);
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() > 1) {
            arrayList.remove(0);
            arrayList.add(arrayList.get(0));
        }
        return toIps(filter(arrayList, networkInfo));
    }

    public String[] toIps(ArrayList<Value> arrayList) {
        int size = arrayList.size();
        String[] strArr = new String[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return strArr;
            }
            strArr[i2] = arrayList.get(i2).ip;
            i = i2 + 1;
        }
    }
}
