package org.xml.sax.helpers;

import org.xml.sax.Attributes;

/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/helpers/AttributesImpl.class */
public class AttributesImpl implements Attributes {
    String[] data;
    int length;

    public AttributesImpl() {
        this.length = 0;
        this.data = null;
    }

    public AttributesImpl(Attributes attributes) {
        setAttributes(attributes);
    }

    private void badIndex(int i) throws ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException("Attempt to modify attribute at illegal index: " + i);
    }

    private void ensureCapacity(int i) {
        int i2;
        int i3;
        if (i <= 0) {
            return;
        }
        if (this.data == null || this.data.length == 0) {
            i2 = 25;
        } else if (this.data.length >= i * 5) {
            return;
        } else {
            i2 = this.data.length;
        }
        while (true) {
            i3 = i2;
            if (i3 >= i * 5) {
                break;
            }
            i2 = i3 * 2;
        }
        String[] strArr = new String[i3];
        if (this.length > 0) {
            System.arraycopy(this.data, 0, strArr, 0, this.length * 5);
        }
        this.data = strArr;
    }

    public void addAttribute(String str, String str2, String str3, String str4, String str5) {
        ensureCapacity(this.length + 1);
        this.data[this.length * 5] = str;
        this.data[(this.length * 5) + 1] = str2;
        this.data[(this.length * 5) + 2] = str3;
        this.data[(this.length * 5) + 3] = str4;
        this.data[(this.length * 5) + 4] = str5;
        this.length++;
    }

    public void clear() {
        if (this.data != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.length * 5) {
                    break;
                }
                this.data[i2] = null;
                i = i2 + 1;
            }
        }
        this.length = 0;
    }

    @Override // org.xml.sax.Attributes
    public int getIndex(String str) {
        int i = this.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i * 5) {
                return -1;
            }
            if (this.data[i3 + 2].equals(str)) {
                return i3 / 5;
            }
            i2 = i3 + 5;
        }
    }

    @Override // org.xml.sax.Attributes
    public int getIndex(String str, String str2) {
        int i = this.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i * 5) {
                return -1;
            }
            if (this.data[i3].equals(str) && this.data[i3 + 1].equals(str2)) {
                return i3 / 5;
            }
            i2 = i3 + 5;
        }
    }

    @Override // org.xml.sax.Attributes
    public int getLength() {
        return this.length;
    }

    @Override // org.xml.sax.Attributes
    public String getLocalName(int i) {
        if (i < 0 || i >= this.length) {
            return null;
        }
        return this.data[(i * 5) + 1];
    }

    @Override // org.xml.sax.Attributes
    public String getQName(int i) {
        if (i < 0 || i >= this.length) {
            return null;
        }
        return this.data[(i * 5) + 2];
    }

    @Override // org.xml.sax.Attributes
    public String getType(int i) {
        if (i < 0 || i >= this.length) {
            return null;
        }
        return this.data[(i * 5) + 3];
    }

    @Override // org.xml.sax.Attributes
    public String getType(String str) {
        int i = this.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i * 5) {
                return null;
            }
            if (this.data[i3 + 2].equals(str)) {
                return this.data[i3 + 3];
            }
            i2 = i3 + 5;
        }
    }

    @Override // org.xml.sax.Attributes
    public String getType(String str, String str2) {
        int i = this.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i * 5) {
                return null;
            }
            if (this.data[i3].equals(str) && this.data[i3 + 1].equals(str2)) {
                return this.data[i3 + 3];
            }
            i2 = i3 + 5;
        }
    }

    @Override // org.xml.sax.Attributes
    public String getURI(int i) {
        if (i < 0 || i >= this.length) {
            return null;
        }
        return this.data[i * 5];
    }

    @Override // org.xml.sax.Attributes
    public String getValue(int i) {
        if (i < 0 || i >= this.length) {
            return null;
        }
        return this.data[(i * 5) + 4];
    }

    @Override // org.xml.sax.Attributes
    public String getValue(String str) {
        int i = this.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i * 5) {
                return null;
            }
            if (this.data[i3 + 2].equals(str)) {
                return this.data[i3 + 4];
            }
            i2 = i3 + 5;
        }
    }

    @Override // org.xml.sax.Attributes
    public String getValue(String str, String str2) {
        int i = this.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i * 5) {
                return null;
            }
            if (this.data[i3].equals(str) && this.data[i3 + 1].equals(str2)) {
                return this.data[i3 + 4];
            }
            i2 = i3 + 5;
        }
    }

    public void removeAttribute(int i) {
        if (i < 0 || i >= this.length) {
            badIndex(i);
            return;
        }
        if (i < this.length - 1) {
            System.arraycopy(this.data, (i + 1) * 5, this.data, i * 5, ((this.length - i) - 1) * 5);
        }
        int i2 = (this.length - 1) * 5;
        int i3 = i2 + 1;
        this.data[i2] = null;
        int i4 = i3 + 1;
        this.data[i3] = null;
        int i5 = i4 + 1;
        this.data[i4] = null;
        this.data[i5] = null;
        this.data[i5 + 1] = null;
        this.length--;
    }

    public void setAttribute(int i, String str, String str2, String str3, String str4, String str5) {
        if (i < 0 || i >= this.length) {
            badIndex(i);
            return;
        }
        this.data[i * 5] = str;
        this.data[(i * 5) + 1] = str2;
        this.data[(i * 5) + 2] = str3;
        this.data[(i * 5) + 3] = str4;
        this.data[(i * 5) + 4] = str5;
    }

    public void setAttributes(Attributes attributes) {
        clear();
        this.length = attributes.getLength();
        if (this.length <= 0) {
            return;
        }
        this.data = new String[this.length * 5];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.length) {
                return;
            }
            this.data[i2 * 5] = attributes.getURI(i2);
            this.data[(i2 * 5) + 1] = attributes.getLocalName(i2);
            this.data[(i2 * 5) + 2] = attributes.getQName(i2);
            this.data[(i2 * 5) + 3] = attributes.getType(i2);
            this.data[(i2 * 5) + 4] = attributes.getValue(i2);
            i = i2 + 1;
        }
    }

    public void setLocalName(int i, String str) {
        if (i < 0 || i >= this.length) {
            badIndex(i);
        } else {
            this.data[(i * 5) + 1] = str;
        }
    }

    public void setQName(int i, String str) {
        if (i < 0 || i >= this.length) {
            badIndex(i);
        } else {
            this.data[(i * 5) + 2] = str;
        }
    }

    public void setType(int i, String str) {
        if (i < 0 || i >= this.length) {
            badIndex(i);
        } else {
            this.data[(i * 5) + 3] = str;
        }
    }

    public void setURI(int i, String str) {
        if (i < 0 || i >= this.length) {
            badIndex(i);
        } else {
            this.data[i * 5] = str;
        }
    }

    public void setValue(int i, String str) {
        if (i < 0 || i >= this.length) {
            badIndex(i);
        } else {
            this.data[(i * 5) + 4] = str;
        }
    }
}
