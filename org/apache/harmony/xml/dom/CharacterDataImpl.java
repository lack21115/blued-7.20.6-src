package org.apache.harmony.xml.dom;

import org.w3c.dom.CharacterData;
import org.w3c.dom.DOMException;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/CharacterDataImpl.class */
public abstract class CharacterDataImpl extends LeafNodeImpl implements CharacterData {
    protected StringBuffer buffer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharacterDataImpl(DocumentImpl documentImpl, String str) {
        super(documentImpl);
        setData(str);
    }

    @Override // org.w3c.dom.CharacterData
    public void appendData(String str) throws DOMException {
        this.buffer.append(str);
    }

    public void appendDataTo(StringBuilder sb) {
        sb.append(this.buffer);
    }

    @Override // org.w3c.dom.CharacterData
    public void deleteData(int i, int i2) throws DOMException {
        this.buffer.delete(i, i + i2);
    }

    @Override // org.w3c.dom.CharacterData
    public String getData() throws DOMException {
        return this.buffer.toString();
    }

    @Override // org.w3c.dom.CharacterData
    public int getLength() {
        return this.buffer.length();
    }

    @Override // org.apache.harmony.xml.dom.NodeImpl, org.w3c.dom.Node
    public String getNodeValue() {
        return getData();
    }

    @Override // org.w3c.dom.CharacterData
    public void insertData(int i, String str) throws DOMException {
        try {
            this.buffer.insert(i, str);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DOMException((short) 1, null);
        }
    }

    @Override // org.w3c.dom.CharacterData
    public void replaceData(int i, int i2, String str) throws DOMException {
        try {
            this.buffer.replace(i, i + i2, str);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DOMException((short) 1, null);
        }
    }

    @Override // org.w3c.dom.CharacterData
    public void setData(String str) throws DOMException {
        this.buffer = new StringBuffer(str);
    }

    @Override // org.w3c.dom.CharacterData
    public String substringData(int i, int i2) throws DOMException {
        try {
            return this.buffer.substring(i, i + i2);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DOMException((short) 1, null);
        }
    }
}
