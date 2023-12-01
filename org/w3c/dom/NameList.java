package org.w3c.dom;

/* loaded from: source-2895416-dex2jar.jar:org/w3c/dom/NameList.class */
public interface NameList {
    boolean contains(String str);

    boolean containsNS(String str, String str2);

    int getLength();

    String getName(int i);

    String getNamespaceURI(int i);
}
