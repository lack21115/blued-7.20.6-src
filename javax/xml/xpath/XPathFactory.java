package javax.xml.xpath;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/xpath/XPathFactory.class */
public abstract class XPathFactory {
    public static final String DEFAULT_OBJECT_MODEL_URI = "http://java.sun.com/jaxp/xpath/dom";
    public static final String DEFAULT_PROPERTY_NAME = "javax.xml.xpath.XPathFactory";

    protected XPathFactory() {
    }

    public static final XPathFactory newInstance() {
        try {
            return newInstance("http://java.sun.com/jaxp/xpath/dom");
        } catch (XPathFactoryConfigurationException e) {
            throw new RuntimeException("XPathFactory#newInstance() failed to create an XPathFactory for the default object model: http://java.sun.com/jaxp/xpath/dom with the XPathFactoryConfigurationException: " + e.toString());
        }
    }

    public static final XPathFactory newInstance(String str) throws XPathFactoryConfigurationException {
        if (str == null) {
            throw new NullPointerException("uri == null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("XPathFactory#newInstance(String uri) cannot be called with uri == \"\"");
        }
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader classLoader = contextClassLoader;
        if (contextClassLoader == null) {
            classLoader = XPathFactory.class.getClassLoader();
        }
        XPathFactory newFactory = new XPathFactoryFinder(classLoader).newFactory(str);
        if (newFactory == null) {
            throw new XPathFactoryConfigurationException("No XPathFactory implementation found for the object model: " + str);
        }
        return newFactory;
    }

    public static XPathFactory newInstance(String str, String str2, ClassLoader classLoader) throws XPathFactoryConfigurationException {
        if (str == null) {
            throw new NullPointerException("uri == null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("XPathFactory#newInstance(String uri) cannot be called with uri == \"\"");
        }
        if (str2 == null) {
            throw new XPathFactoryConfigurationException("factoryClassName cannot be null.");
        }
        ClassLoader classLoader2 = classLoader;
        if (classLoader == null) {
            classLoader2 = Thread.currentThread().getContextClassLoader();
        }
        XPathFactory createInstance = new XPathFactoryFinder(classLoader2).createInstance(str2);
        if (createInstance == null || !createInstance.isObjectModelSupported(str)) {
            throw new XPathFactoryConfigurationException("No XPathFactory implementation found for the object model: " + str);
        }
        return createInstance;
    }

    public abstract boolean getFeature(String str) throws XPathFactoryConfigurationException;

    public abstract boolean isObjectModelSupported(String str);

    public abstract XPath newXPath();

    public abstract void setFeature(String str, boolean z) throws XPathFactoryConfigurationException;

    public abstract void setXPathFunctionResolver(XPathFunctionResolver xPathFunctionResolver);

    public abstract void setXPathVariableResolver(XPathVariableResolver xPathVariableResolver);
}
