package org.xml.sax.ext;

import libcore.util.EmptyArray;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/ext/Attributes2Impl.class */
public class Attributes2Impl extends AttributesImpl implements Attributes2 {
    private boolean[] declared;
    private boolean[] specified;

    public Attributes2Impl() {
        this.declared = EmptyArray.BOOLEAN;
        this.specified = EmptyArray.BOOLEAN;
    }

    public Attributes2Impl(Attributes attributes) {
        super(attributes);
    }

    @Override // org.xml.sax.helpers.AttributesImpl
    public void addAttribute(String str, String str2, String str3, String str4, String str5) {
        boolean z = true;
        super.addAttribute(str, str2, str3, str4, str5);
        int length = getLength();
        if (length > this.specified.length) {
            boolean[] zArr = new boolean[length];
            System.arraycopy(this.declared, 0, zArr, 0, this.declared.length);
            this.declared = zArr;
            boolean[] zArr2 = new boolean[length];
            System.arraycopy(this.specified, 0, zArr2, 0, this.specified.length);
            this.specified = zArr2;
        }
        this.specified[length - 1] = true;
        boolean[] zArr3 = this.declared;
        if ("CDATA".equals(str4)) {
            z = false;
        }
        zArr3[length - 1] = z;
    }

    @Override // org.xml.sax.ext.Attributes2
    public boolean isDeclared(int i) {
        if (i < 0 || i >= getLength()) {
            throw new ArrayIndexOutOfBoundsException("No attribute at index: " + i);
        }
        return this.declared[i];
    }

    @Override // org.xml.sax.ext.Attributes2
    public boolean isDeclared(String str) {
        int index = getIndex(str);
        if (index < 0) {
            throw new IllegalArgumentException("No such attribute: " + str);
        }
        return this.declared[index];
    }

    @Override // org.xml.sax.ext.Attributes2
    public boolean isDeclared(String str, String str2) {
        int index = getIndex(str, str2);
        if (index < 0) {
            throw new IllegalArgumentException("No such attribute: local=" + str2 + ", namespace=" + str);
        }
        return this.declared[index];
    }

    @Override // org.xml.sax.ext.Attributes2
    public boolean isSpecified(int i) {
        if (i < 0 || i >= getLength()) {
            throw new ArrayIndexOutOfBoundsException("No attribute at index: " + i);
        }
        return this.specified[i];
    }

    @Override // org.xml.sax.ext.Attributes2
    public boolean isSpecified(String str) {
        int index = getIndex(str);
        if (index < 0) {
            throw new IllegalArgumentException("No such attribute: " + str);
        }
        return this.specified[index];
    }

    @Override // org.xml.sax.ext.Attributes2
    public boolean isSpecified(String str, String str2) {
        int index = getIndex(str, str2);
        if (index < 0) {
            throw new IllegalArgumentException("No such attribute: local=" + str2 + ", namespace=" + str);
        }
        return this.specified[index];
    }

    @Override // org.xml.sax.helpers.AttributesImpl
    public void removeAttribute(int i) {
        int length = getLength() - 1;
        super.removeAttribute(i);
        if (i != length) {
            System.arraycopy(this.declared, i + 1, this.declared, i, length - i);
            System.arraycopy(this.specified, i + 1, this.specified, i, length - i);
        }
    }

    @Override // org.xml.sax.helpers.AttributesImpl
    public void setAttributes(Attributes attributes) {
        int length = attributes.getLength();
        super.setAttributes(attributes);
        this.declared = new boolean[length];
        this.specified = new boolean[length];
        if (attributes instanceof Attributes2) {
            Attributes2 attributes2 = (Attributes2) attributes;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                this.declared[i2] = attributes2.isDeclared(i2);
                this.specified[i2] = attributes2.isSpecified(i2);
                i = i2 + 1;
            }
        } else {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    return;
                }
                this.declared[i4] = !"CDATA".equals(attributes.getType(i4));
                this.specified[i4] = true;
                i3 = i4 + 1;
            }
        }
    }

    public void setDeclared(int i, boolean z) {
        if (i < 0 || i >= getLength()) {
            throw new ArrayIndexOutOfBoundsException("No attribute at index: " + i);
        }
        this.declared[i] = z;
    }

    public void setSpecified(int i, boolean z) {
        if (i < 0 || i >= getLength()) {
            throw new ArrayIndexOutOfBoundsException("No attribute at index: " + i);
        }
        this.specified[i] = z;
    }
}
