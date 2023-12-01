package java.lang;

import java.net.URL;
import java.util.Enumeration;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/lang/TwoEnumerationsInOne.class */
public class TwoEnumerationsInOne implements Enumeration<URL> {
    private final Enumeration<URL> first;
    private final Enumeration<URL> second;

    public TwoEnumerationsInOne(Enumeration<URL> enumeration, Enumeration<URL> enumeration2) {
        this.first = enumeration;
        this.second = enumeration2;
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.first.hasMoreElements() || this.second.hasMoreElements();
    }

    @Override // java.util.Enumeration
    public URL nextElement() {
        return this.first.hasMoreElements() ? this.first.nextElement() : this.second.nextElement();
    }
}
