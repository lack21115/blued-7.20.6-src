package java.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* loaded from: source-2895416-dex2jar.jar:java/util/PropertyResourceBundle.class */
public class PropertyResourceBundle extends ResourceBundle {
    Properties resources;

    public PropertyResourceBundle(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new NullPointerException("stream == null");
        }
        this.resources = new Properties();
        this.resources.load(inputStream);
    }

    public PropertyResourceBundle(Reader reader) throws IOException {
        this.resources = new Properties();
        this.resources.load(reader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Enumeration<String> getLocalKeys() {
        return this.resources.propertyNames();
    }

    @Override // java.util.ResourceBundle
    public Enumeration<String> getKeys() {
        return this.parent == null ? getLocalKeys() : new Enumeration<String>() { // from class: java.util.PropertyResourceBundle.1
            Enumeration<String> local;
            String nextElement;
            Enumeration<String> pEnum;

            {
                this.local = PropertyResourceBundle.this.getLocalKeys();
                this.pEnum = PropertyResourceBundle.this.parent.getKeys();
            }

            private boolean findNext() {
                if (this.nextElement != null) {
                    return true;
                }
                while (this.pEnum.hasMoreElements()) {
                    String nextElement = this.pEnum.nextElement();
                    if (!PropertyResourceBundle.this.resources.containsKey(nextElement)) {
                        this.nextElement = nextElement;
                        return true;
                    }
                }
                return false;
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                if (this.local.hasMoreElements()) {
                    return true;
                }
                return findNext();
            }

            @Override // java.util.Enumeration
            public String nextElement() {
                if (this.local.hasMoreElements()) {
                    return this.local.nextElement();
                }
                if (findNext()) {
                    String str = this.nextElement;
                    this.nextElement = null;
                    return str;
                }
                return this.pEnum.nextElement();
            }
        };
    }

    @Override // java.util.ResourceBundle
    public Object handleGetObject(String str) {
        return this.resources.get(str);
    }

    @Override // java.util.ResourceBundle
    protected Set<String> handleKeySet() {
        return this.resources.stringPropertyNames();
    }
}
