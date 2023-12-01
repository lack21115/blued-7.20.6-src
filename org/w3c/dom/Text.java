package org.w3c.dom;

/* loaded from: source-2895416-dex2jar.jar:org/w3c/dom/Text.class */
public interface Text extends CharacterData {
    String getWholeText();

    boolean isElementContentWhitespace();

    Text replaceWholeText(String str) throws DOMException;

    Text splitText(int i) throws DOMException;
}
