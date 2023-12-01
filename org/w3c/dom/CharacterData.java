package org.w3c.dom;

/* loaded from: source-2895416-dex2jar.jar:org/w3c/dom/CharacterData.class */
public interface CharacterData extends Node {
    void appendData(String str) throws DOMException;

    void deleteData(int i, int i2) throws DOMException;

    String getData() throws DOMException;

    int getLength();

    void insertData(int i, String str) throws DOMException;

    void replaceData(int i, int i2, String str) throws DOMException;

    void setData(String str) throws DOMException;

    String substringData(int i, int i2) throws DOMException;
}
