package javax.xml.validation;

import org.w3c.dom.TypeInfo;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/validation/TypeInfoProvider.class */
public abstract class TypeInfoProvider {
    protected TypeInfoProvider() {
    }

    public abstract TypeInfo getAttributeTypeInfo(int i);

    public abstract TypeInfo getElementTypeInfo();

    public abstract boolean isIdAttribute(int i);

    public abstract boolean isSpecified(int i);
}
