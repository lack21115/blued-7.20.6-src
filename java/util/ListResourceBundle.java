package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/ListResourceBundle.class */
public abstract class ListResourceBundle extends ResourceBundle {
    HashMap<String, Object> table;

    private void initializeTable() {
        synchronized (this) {
            if (this.table == null) {
                Object[][] contents = getContents();
                this.table = new HashMap<>(((contents.length / 3) * 4) + 3);
                int length = contents.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    Object[] objArr = contents[i2];
                    if (objArr[0] == null || objArr[1] == null) {
                        break;
                    }
                    this.table.put((String) objArr[0], objArr[1]);
                    i = i2 + 1;
                }
                throw new NullPointerException("null entry");
            }
        }
    }

    protected abstract Object[][] getContents();

    @Override // java.util.ResourceBundle
    public Enumeration<String> getKeys() {
        initializeTable();
        return this.parent != null ? new Enumeration<String>() { // from class: java.util.ListResourceBundle.1
            Iterator<String> local;
            String nextElement;
            Enumeration<String> pEnum;

            {
                this.local = ListResourceBundle.this.table.keySet().iterator();
                this.pEnum = ListResourceBundle.this.parent.getKeys();
            }

            private boolean findNext() {
                if (this.nextElement != null) {
                    return true;
                }
                while (this.pEnum.hasMoreElements()) {
                    String nextElement = this.pEnum.nextElement();
                    if (!ListResourceBundle.this.table.containsKey(nextElement)) {
                        this.nextElement = nextElement;
                        return true;
                    }
                }
                return false;
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                if (this.local.hasNext()) {
                    return true;
                }
                return findNext();
            }

            @Override // java.util.Enumeration
            public String nextElement() {
                if (this.local.hasNext()) {
                    return this.local.next();
                }
                if (findNext()) {
                    String str = this.nextElement;
                    this.nextElement = null;
                    return str;
                }
                return this.pEnum.nextElement();
            }
        } : new Enumeration<String>() { // from class: java.util.ListResourceBundle.2
            Iterator<String> it;

            {
                this.it = ListResourceBundle.this.table.keySet().iterator();
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.it.hasNext();
            }

            @Override // java.util.Enumeration
            public String nextElement() {
                return this.it.next();
            }
        };
    }

    @Override // java.util.ResourceBundle
    public final Object handleGetObject(String str) {
        initializeTable();
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        return this.table.get(str);
    }

    @Override // java.util.ResourceBundle
    protected Set<String> handleKeySet() {
        initializeTable();
        return this.table.keySet();
    }
}
