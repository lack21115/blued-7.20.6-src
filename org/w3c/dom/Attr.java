package org.w3c.dom;

/* loaded from: source-2895416-dex2jar.jar:org/w3c/dom/Attr.class */
public interface Attr extends Node {
    String getName();

    Element getOwnerElement();

    TypeInfo getSchemaTypeInfo();

    boolean getSpecified();

    String getValue();

    boolean isId();

    void setValue(String str) throws DOMException;
}
