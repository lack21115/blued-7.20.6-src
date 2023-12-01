package com.tencent.lbssearch.object;

import android.content.ContentValues;
import android.net.Uri;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/RequestParams.class */
public class RequestParams implements Serializable {
    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    public static final String LOG_TAG = "RequestParams";
    private static final long serialVersionUID = 1;
    public boolean autoCloseInputStreams;
    public boolean isRepeatable;
    private boolean mIsDebuggable;
    public final ConcurrentHashMap<String, String> urlParams;
    public final ConcurrentHashMap<String, Object> urlParamsWithObjects;
    public boolean useJsonStreamer;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/RequestParams$a.class */
    public class a extends HashMap<String, String> {
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f36210c;

        public a(String str, String str2) {
            this.b = str;
            this.f36210c = str2;
            put(str, str2);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/RequestParams$b.class */
    public class b implements Comparator<String> {
        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareToIgnoreCase(str2);
        }
    }

    public RequestParams() {
        this((Map<String, String>) null);
    }

    public RequestParams(String str, String str2) {
        this(new a(str, str2));
    }

    public RequestParams(Map<String, String> map) {
        this.urlParams = new ConcurrentHashMap<>();
        this.urlParamsWithObjects = new ConcurrentHashMap<>();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    public RequestParams(Object... objArr) {
        this.urlParams = new ConcurrentHashMap<>();
        this.urlParamsWithObjects = new ConcurrentHashMap<>();
        int length = objArr.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            put(String.valueOf(objArr[i2]), String.valueOf(objArr[i2 + 1]));
            i = i2 + 2;
        }
    }

    private List<ContentValues> getParamsList(String str, Object obj) {
        Object obj2;
        LinkedList linkedList = new LinkedList();
        if (obj instanceof Map) {
            Map map = (Map) obj;
            ArrayList arrayList = new ArrayList(map.keySet());
            if (arrayList.size() > 0 && (arrayList.get(0) instanceof Comparable)) {
                Collections.sort(arrayList);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if ((next instanceof String) && (obj2 = map.get(next)) != null) {
                    linkedList.addAll(getParamsList(str == null ? (String) next : String.format("%s[%s]", str, next), obj2));
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            int size = list.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                linkedList.addAll(getParamsList(String.format("%s[%d]", str, Integer.valueOf(i2)), list.get(i2)));
                i = i2 + 1;
            }
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    break;
                }
                linkedList.addAll(getParamsList(String.format("%s[%d]", str, Integer.valueOf(i4)), objArr[i4]));
                i3 = i4 + 1;
            }
        } else if (obj instanceof Set) {
            for (Object obj3 : (Set) obj) {
                linkedList.addAll(getParamsList(str, obj3));
            }
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, obj.toString());
            linkedList.add(contentValues);
        }
        return linkedList;
    }

    public void add(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        Object obj = this.urlParamsWithObjects.get(str);
        HashSet hashSet = obj;
        if (obj == null) {
            hashSet = new HashSet();
            put(str, hashSet);
        }
        if (hashSet instanceof List) {
            ((List) hashSet).add(str2);
        } else if (hashSet instanceof Set) {
            ((Set) hashSet).add(str2);
        }
    }

    public String getParamString() {
        return Uri.encode(toString(), "=&");
    }

    public List<ContentValues> getParamsList() {
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        arrayList.addAll(this.urlParams.keySet());
        arrayList.addAll(this.urlParamsWithObjects.keySet());
        Collections.sort(arrayList, new b());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String str2 = this.urlParams.get(str);
            if (str2 != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(str, str2);
                linkedList.add(contentValues);
            } else {
                Object obj = this.urlParamsWithObjects.get(str);
                if (obj != null) {
                    linkedList.addAll(getParamsList(str, obj));
                }
            }
        }
        return linkedList;
    }

    public boolean isDebuggable() {
        return this.mIsDebuggable;
    }

    public void put(String str, int i) {
        if (str != null) {
            this.urlParams.put(str, String.valueOf(i));
        }
    }

    public void put(String str, long j) {
        if (str != null) {
            this.urlParams.put(str, String.valueOf(j));
        }
    }

    public void put(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        this.urlParamsWithObjects.put(str, obj);
    }

    public void put(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.urlParams.put(str, str2);
    }

    public void remove(String str) {
        this.urlParams.remove(str);
        this.urlParamsWithObjects.remove(str);
    }

    public void setDebuggable(boolean z) {
        this.mIsDebuggable = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ContentValues contentValues : getParamsList()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue().toString());
            }
        }
        return sb.toString();
    }
}
