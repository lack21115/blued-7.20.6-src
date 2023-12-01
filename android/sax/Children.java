package android.sax;

/* loaded from: source-9557208-dex2jar.jar:android/sax/Children.class */
class Children {
    Child[] children = new Child[16];

    /* loaded from: source-9557208-dex2jar.jar:android/sax/Children$Child.class */
    static class Child extends Element {
        final int hash;
        Child next;

        Child(Element element, String str, String str2, int i, int i2) {
            super(element, str, str2, i);
            this.hash = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element get(String str, String str2) {
        Child child;
        int hashCode = (str.hashCode() * 31) + str2.hashCode();
        Child child2 = this.children[hashCode & 15];
        Child child3 = child2;
        if (child2 == null) {
            return null;
        }
        do {
            if (child3.hash == hashCode && child3.uri.compareTo(str) == 0 && child3.localName.compareTo(str2) == 0) {
                return child3;
            }
            child = child3.next;
            child3 = child;
        } while (child != null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element getOrCreate(Element element, String str, String str2) {
        Child child;
        Child child2;
        int hashCode = (str.hashCode() * 31) + str2.hashCode();
        int i = hashCode & 15;
        Child child3 = this.children[i];
        Child child4 = child3;
        if (child3 == null) {
            Child child5 = new Child(element, str, str2, element.depth + 1, hashCode);
            this.children[i] = child5;
            return child5;
        }
        do {
            child = child4;
            if (child.hash == hashCode && child.uri.compareTo(str) == 0 && child.localName.compareTo(str2) == 0) {
                return child;
            }
            child2 = child.next;
            child4 = child2;
        } while (child2 != null);
        Child child6 = new Child(element, str, str2, element.depth + 1, hashCode);
        child.next = child6;
        return child6;
    }
}
