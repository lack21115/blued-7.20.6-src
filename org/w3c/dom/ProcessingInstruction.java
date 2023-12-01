package org.w3c.dom;

/* loaded from: source-2895416-dex2jar.jar:org/w3c/dom/ProcessingInstruction.class */
public interface ProcessingInstruction extends Node {
    String getData();

    String getTarget();

    void setData(String str) throws DOMException;
}
