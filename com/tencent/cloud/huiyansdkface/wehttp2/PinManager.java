package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okio.ByteString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/PinManager.class */
public class PinManager {

    /* renamed from: a  reason: collision with root package name */
    private volatile String f22408a;
    private Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private List<Pin> f22409c = new ArrayList();
    private List<Pin> d = new ArrayList();

    private PinManager a(List<Pin> list, String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                return this;
            }
            synchronized (this.b) {
                int length = strArr.length;
                while (true) {
                    int i = length - 1;
                    if (i >= 0) {
                        String str2 = strArr[i];
                        if (str2 != null) {
                            list.add(0, new Pin(str, str2));
                        }
                        length = i;
                    }
                }
            }
            return this;
        }
        throw new IllegalArgumentException("must set  pin host");
    }

    private List<String> a(List<Pin> list, String str) {
        ArrayList arrayList;
        synchronized (this.b) {
            arrayList = new ArrayList();
            for (Pin pin : list) {
                if (pin.match(str)) {
                    arrayList.add(pin.getPin());
                }
            }
        }
        return arrayList;
    }

    private void a(String str, boolean z) {
        if (str == null) {
            return;
        }
        Iterator<Pin> it = (z ? this.d : this.f22409c).iterator();
        while (it.hasNext()) {
            if (it.next().getPattern().equals(str)) {
                it.remove();
            }
        }
    }

    private List<String> b(List<Pin> list, String str) {
        ArrayList arrayList;
        synchronized (this.b) {
            arrayList = new ArrayList();
            for (Pin pin : list) {
                if (pin.getPattern().equals(str)) {
                    arrayList.add(pin.getPin());
                }
            }
        }
        return arrayList;
    }

    public PinManager addErrorPins(String... strArr) {
        return addErrorPins4Host(this.f22408a, strArr);
    }

    public PinManager addErrorPins4Host(String str, String... strArr) {
        return a(this.d, str, strArr);
    }

    public PinManager addPemPins(String... strArr) {
        return addPemPins4Host(this.f22408a, strArr);
    }

    public PinManager addPemPins4Host(String str, String... strArr) {
        LinkedList linkedList = new LinkedList();
        if (strArr != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= strArr.length) {
                    break;
                }
                String str2 = strArr[i2];
                if (str2 != null && !str2.isEmpty()) {
                    String fingerPrint = HttpsCertificateUtils.getFingerPrint(HttpsCertificateUtils.getCertificate(str2));
                    linkedList.add(new Pin(str, "sha256/" + ByteString.decodeHex(fingerPrint).base64()));
                }
                i = i2 + 1;
            }
        }
        synchronized (this.b) {
            this.f22409c.addAll(0, linkedList);
        }
        return this;
    }

    @Deprecated
    public PinManager addPins(List<byte[]> list) {
        return addPins4Host(this.f22408a, list);
    }

    public PinManager addPins(String... strArr) {
        return addPins4Host(this.f22408a, strArr);
    }

    @Deprecated
    public PinManager addPins4Host(String str, List<byte[]> list) {
        if (list == null) {
            return this;
        }
        synchronized (this.b) {
            int size = list.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    byte[] bArr = list.get(i);
                    if (bArr != null) {
                        List<Pin> list2 = this.f22409c;
                        list2.add(0, new Pin(str, "sha1/" + ByteString.of(bArr).base64()));
                    }
                    size = i;
                }
            }
        }
        return this;
    }

    public PinManager addPins4Host(String str, String... strArr) {
        return a(this.f22409c, str, strArr);
    }

    public List<Pin> getAllPinErrorList() {
        return Collections.unmodifiableList(this.d);
    }

    public List<Pin> getAllPinList() {
        List<Pin> unmodifiableList;
        synchronized (this.b) {
            unmodifiableList = Collections.unmodifiableList(this.f22409c);
        }
        return unmodifiableList;
    }

    public List<String> getErrorPins() {
        return b(this.d, this.f22408a);
    }

    public List<String> getErrorPins(String str) {
        return a(this.d, str);
    }

    public String[] getPinArray4HostPattern(String str) {
        List<String> b = b(this.f22409c, str);
        return (String[]) b.toArray(new String[b.size()]);
    }

    public String getPinDefHostPattern() {
        return this.f22408a;
    }

    public List<String> getPinList4HostPattern(String str) {
        return b(this.f22409c, str);
    }

    public List<String> getPins() {
        return b(this.f22409c, this.f22408a);
    }

    public List<String> getPins(String str) {
        return a(this.f22409c, str);
    }

    public String pinListToString() {
        return pinListToString(null);
    }

    public String pinListToString(String str) {
        String trim;
        synchronized (this.b) {
            HashMap hashMap = new HashMap();
            for (Pin pin : this.f22409c) {
                String pattern = pin.getPattern();
                if (str == null || str.equals(pattern)) {
                    List list = (List) hashMap.get(pattern);
                    ArrayList arrayList = list;
                    if (list == null) {
                        arrayList = new ArrayList();
                        hashMap.put(pattern, arrayList);
                    }
                    arrayList.add(pin.getPin());
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : hashMap.entrySet()) {
                sb.append(((String) entry.getKey()) + ":\n");
                for (String str2 : (List) entry.getValue()) {
                    sb.append("\t" + str2);
                }
                sb.append("\n");
            }
            trim = sb.toString().trim();
        }
        return trim;
    }

    public PinManager setErrorPins(String... strArr) {
        setErrorPins4Host(this.f22408a, strArr);
        return this;
    }

    public PinManager setErrorPins4Host(String str, String... strArr) {
        PinManager addErrorPins4Host;
        synchronized (this.b) {
            a(str, true);
            addErrorPins4Host = addErrorPins4Host(str, strArr);
        }
        return addErrorPins4Host;
    }

    public PinManager setPinDefHostPattern(String str) {
        if (str != null) {
            this.f22408a = str;
        }
        return this;
    }

    public PinManager setPins(String... strArr) {
        return setPins4Host(this.f22408a, strArr);
    }

    public PinManager setPins4Host(String str, String... strArr) {
        if (str != null) {
            synchronized (this.b) {
                a(str, false);
                addPins4Host(str, strArr);
            }
            return this;
        }
        throw new IllegalArgumentException("must set  pin host");
    }
}
