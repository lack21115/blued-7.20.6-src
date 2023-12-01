package org.xml.sax.helpers;

import java.util.ArrayList;
import org.xml.sax.AttributeList;

@Deprecated
/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/helpers/AttributeListImpl.class */
public class AttributeListImpl implements AttributeList {
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> types = new ArrayList<>();
    private ArrayList<String> values = new ArrayList<>();

    public AttributeListImpl() {
    }

    public AttributeListImpl(AttributeList attributeList) {
        setAttributeList(attributeList);
    }

    public void addAttribute(String str, String str2, String str3) {
        this.names.add(str);
        this.types.add(str2);
        this.values.add(str3);
    }

    public void clear() {
        this.names.clear();
        this.types.clear();
        this.values.clear();
    }

    @Override // org.xml.sax.AttributeList
    public int getLength() {
        return this.names.size();
    }

    @Override // org.xml.sax.AttributeList
    public String getName(int i) {
        if (i < 0 || i >= this.names.size()) {
            return null;
        }
        return this.names.get(i);
    }

    @Override // org.xml.sax.AttributeList
    public String getType(int i) {
        if (i < 0 || i >= this.types.size()) {
            return null;
        }
        return this.types.get(i);
    }

    @Override // org.xml.sax.AttributeList
    public String getType(String str) {
        return getType(this.names.indexOf(str));
    }

    @Override // org.xml.sax.AttributeList
    public String getValue(int i) {
        if (i < 0 || i >= this.values.size()) {
            return null;
        }
        return this.values.get(i);
    }

    @Override // org.xml.sax.AttributeList
    public String getValue(String str) {
        return getValue(this.names.indexOf(str));
    }

    public void removeAttribute(String str) {
        int indexOf = this.names.indexOf(str);
        if (indexOf != -1) {
            this.names.remove(indexOf);
            this.types.remove(indexOf);
            this.values.remove(indexOf);
        }
    }

    public void setAttributeList(AttributeList attributeList) {
        int length = attributeList.getLength();
        clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            addAttribute(attributeList.getName(i2), attributeList.getType(i2), attributeList.getValue(i2));
            i = i2 + 1;
        }
    }
}
