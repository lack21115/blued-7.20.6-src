package com.ta.utdid2.b.a;

import com.ta.utdid2.b.a.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: source-8457232-dex2jar.jar:com/ta/utdid2/b/a/d.class */
public class d {
    private static final Object b = new Object();

    /* renamed from: a  reason: collision with root package name */
    private File f34902a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f67a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private HashMap<File, a> f68a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ta/utdid2/b/a/d$a.class */
    public static final class a implements b {

        /* renamed from: c  reason: collision with root package name */
        private static final Object f34903c = new Object();

        /* renamed from: a  reason: collision with root package name */
        private Map f34904a;

        /* renamed from: a  reason: collision with other field name */
        private WeakHashMap<b.InterfaceC0892b, Object> f69a;
        private final File b;

        /* renamed from: c  reason: collision with other field name */
        private final int f70c;

        /* renamed from: c  reason: collision with other field name */
        private final File f71c;
        private boolean j = false;

        /* renamed from: com.ta.utdid2.b.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: source-8457232-dex2jar.jar:com/ta/utdid2/b/a/d$a$a.class */
        public final class C0893a implements b.a {
            private final Map<String, Object> b = new HashMap();
            private boolean k = false;

            public C0893a() {
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str) {
                synchronized (this) {
                    this.b.put(str, this);
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, float f) {
                synchronized (this) {
                    this.b.put(str, Float.valueOf(f));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, int i) {
                synchronized (this) {
                    this.b.put(str, Integer.valueOf(i));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, long j) {
                synchronized (this) {
                    this.b.put(str, Long.valueOf(j));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, String str2) {
                synchronized (this) {
                    this.b.put(str, str2);
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, boolean z) {
                synchronized (this) {
                    this.b.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a b() {
                synchronized (this) {
                    this.k = true;
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public boolean commit() {
                boolean z;
                ArrayList arrayList;
                HashSet<b.InterfaceC0892b> hashSet;
                boolean e;
                synchronized (d.b) {
                    z = a.this.f69a.size() > 0;
                    arrayList = null;
                    if (z) {
                        arrayList = new ArrayList();
                        hashSet = new HashSet(a.this.f69a.keySet());
                    } else {
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.k) {
                            a.this.f34904a.clear();
                            this.k = false;
                        }
                        for (Map.Entry<String, Object> entry : this.b.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (value == this) {
                                a.this.f34904a.remove(key);
                            } else {
                                a.this.f34904a.put(key, value);
                            }
                            if (z) {
                                arrayList.add(key);
                            }
                        }
                        this.b.clear();
                    }
                    e = a.this.e();
                    if (e) {
                        a.this.a(true);
                    }
                }
                if (z) {
                    int size = arrayList.size();
                    while (true) {
                        int i = size - 1;
                        if (i < 0) {
                            break;
                        }
                        String str = (String) arrayList.get(i);
                        for (b.InterfaceC0892b interfaceC0892b : hashSet) {
                            if (interfaceC0892b != null) {
                                interfaceC0892b.a(a.this, str);
                            }
                        }
                        size = i;
                    }
                }
                return e;
            }
        }

        a(File file, int i, Map map) {
            this.b = file;
            this.f71c = d.a(file);
            this.f70c = i;
            this.f34904a = map == null ? new HashMap() : map;
            this.f69a = new WeakHashMap<>();
        }

        private FileOutputStream a(File file) {
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException e2) {
                    return null;
                }
            }
            return fileOutputStream;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean e() {
            if (this.b.exists()) {
                if (this.f71c.exists()) {
                    this.b.delete();
                } else if (!this.b.renameTo(this.f71c)) {
                    return false;
                }
            }
            try {
                FileOutputStream a2 = a(this.b);
                if (a2 == null) {
                    return false;
                }
                e.a(this.f34904a, a2);
                a2.close();
                this.f71c.delete();
                return true;
            } catch (Exception e) {
                if (this.b.exists()) {
                    this.b.delete();
                    return false;
                }
                return false;
            }
        }

        @Override // com.ta.utdid2.b.a.b
        public b.a a() {
            return new C0893a();
        }

        public void a(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.f34904a = map;
                }
            }
        }

        public void a(boolean z) {
            synchronized (this) {
                this.j = z;
            }
        }

        @Override // com.ta.utdid2.b.a.b
        public boolean b() {
            return this.b != null && new File(this.b.getAbsolutePath()).exists();
        }

        public boolean d() {
            boolean z;
            synchronized (this) {
                z = this.j;
            }
            return z;
        }

        @Override // com.ta.utdid2.b.a.b
        public Map<String, ?> getAll() {
            HashMap hashMap;
            synchronized (this) {
                hashMap = new HashMap(this.f34904a);
            }
            return hashMap;
        }

        @Override // com.ta.utdid2.b.a.b
        public long getLong(String str, long j) {
            synchronized (this) {
                Long l = (Long) this.f34904a.get(str);
                if (l != null) {
                    j = l.longValue();
                }
            }
            return j;
        }

        @Override // com.ta.utdid2.b.a.b
        public String getString(String str, String str2) {
            synchronized (this) {
                String str3 = (String) this.f34904a.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            }
            return str2;
        }
    }

    public d(String str) {
        if (str == null || str.length() <= 0) {
            throw new RuntimeException("Directory can not be empty");
        }
        this.f34902a = new File(str);
    }

    private File a() {
        File file;
        synchronized (this.f67a) {
            file = this.f34902a;
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File a(File file) {
        return new File(file.getPath() + ".bak");
    }

    private File a(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private File b(String str) {
        File a2 = a();
        return a(a2, str + ".xml");
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.ta.utdid2.b.a.b a(java.lang.String r7, int r8) {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.b.a.d.a(java.lang.String, int):com.ta.utdid2.b.a.b");
    }
}
