package org.w3c.dom.ls;

import org.w3c.dom.DOMException;

/* loaded from: source-2895416-dex2jar.jar:org/w3c/dom/ls/DOMImplementationLS.class */
public interface DOMImplementationLS {
    public static final short MODE_ASYNCHRONOUS = 2;
    public static final short MODE_SYNCHRONOUS = 1;

    LSInput createLSInput();

    LSOutput createLSOutput();

    LSParser createLSParser(short s, String str) throws DOMException;

    LSSerializer createLSSerializer();
}
