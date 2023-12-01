package org.xmlpull.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:org/xmlpull/v1/XmlPullParserFactory.class */
public class XmlPullParserFactory {
    public static final String PROPERTY_NAME = "org.xmlpull.v1.XmlPullParserFactory";
    protected String classNamesLocation = null;
    protected HashMap<String, Boolean> features = new HashMap<>();
    protected ArrayList parserClasses = new ArrayList();
    protected ArrayList serializerClasses = new ArrayList();

    protected XmlPullParserFactory() {
        try {
            this.parserClasses.add(Class.forName("org.kxml2.io.KXmlParser"));
            this.serializerClasses.add(Class.forName("org.kxml2.io.KXmlSerializer"));
        } catch (ClassNotFoundException e) {
            throw new AssertionError();
        }
    }

    private XmlPullParser getParserInstance() throws XmlPullParserException {
        ArrayList arrayList = null;
        if (this.parserClasses != null) {
            arrayList = null;
            if (!this.parserClasses.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                Iterator it = this.parserClasses.iterator();
                while (true) {
                    arrayList = arrayList2;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (next != null) {
                        try {
                            return (XmlPullParser) ((Class) next).newInstance();
                        } catch (ClassCastException e) {
                            arrayList2.add(e);
                        } catch (IllegalAccessException e2) {
                            arrayList2.add(e2);
                        } catch (InstantiationException e3) {
                            arrayList2.add(e3);
                        }
                    }
                }
            }
        }
        throw newInstantiationException("Invalid parser class list", arrayList);
    }

    private XmlSerializer getSerializerInstance() throws XmlPullParserException {
        ArrayList arrayList = null;
        if (this.serializerClasses != null) {
            arrayList = null;
            if (!this.serializerClasses.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                Iterator it = this.serializerClasses.iterator();
                while (true) {
                    arrayList = arrayList2;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (next != null) {
                        try {
                            return (XmlSerializer) ((Class) next).newInstance();
                        } catch (ClassCastException e) {
                            arrayList2.add(e);
                        } catch (IllegalAccessException e2) {
                            arrayList2.add(e2);
                        } catch (InstantiationException e3) {
                            arrayList2.add(e3);
                        }
                    }
                }
            }
        }
        throw newInstantiationException("Invalid serializer class list", arrayList);
    }

    public static XmlPullParserFactory newInstance() throws XmlPullParserException {
        return new XmlPullParserFactory();
    }

    public static XmlPullParserFactory newInstance(String str, Class cls) throws XmlPullParserException {
        return newInstance();
    }

    private static XmlPullParserException newInstantiationException(String str, ArrayList<Exception> arrayList) {
        XmlPullParserException xmlPullParserException;
        if (arrayList != null && !arrayList.isEmpty()) {
            XmlPullParserException xmlPullParserException2 = new XmlPullParserException(str);
            Iterator<Exception> it = arrayList.iterator();
            while (true) {
                xmlPullParserException = xmlPullParserException2;
                if (!it.hasNext()) {
                    break;
                }
                xmlPullParserException2.addSuppressed(it.next());
            }
        } else {
            xmlPullParserException = new XmlPullParserException(str);
        }
        return xmlPullParserException;
    }

    public boolean getFeature(String str) {
        Boolean bool = this.features.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean isNamespaceAware() {
        return getFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES);
    }

    public boolean isValidating() {
        return getFeature(XmlPullParser.FEATURE_VALIDATION);
    }

    public XmlPullParser newPullParser() throws XmlPullParserException {
        XmlPullParser parserInstance = getParserInstance();
        for (Map.Entry<String, Boolean> entry : this.features.entrySet()) {
            if (entry.getValue().booleanValue()) {
                parserInstance.setFeature(entry.getKey(), entry.getValue().booleanValue());
            }
        }
        return parserInstance;
    }

    public XmlSerializer newSerializer() throws XmlPullParserException {
        return getSerializerInstance();
    }

    public void setFeature(String str, boolean z) throws XmlPullParserException {
        this.features.put(str, Boolean.valueOf(z));
    }

    public void setNamespaceAware(boolean z) {
        this.features.put(XmlPullParser.FEATURE_PROCESS_NAMESPACES, Boolean.valueOf(z));
    }

    public void setValidating(boolean z) {
        this.features.put(XmlPullParser.FEATURE_VALIDATION, Boolean.valueOf(z));
    }
}
