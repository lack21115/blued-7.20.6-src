package javax.xml.transform;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/transform/TransformerFactory.class */
public abstract class TransformerFactory {
    public static TransformerFactory newInstance() throws TransformerFactoryConfigurationError {
        try {
            return (TransformerFactory) Class.forName("org.apache.xalan.processor.TransformerFactoryImpl").newInstance();
        } catch (Exception e) {
            throw new NoClassDefFoundError("org.apache.xalan.processor.TransformerFactoryImpl");
        }
    }

    public static TransformerFactory newInstance(String str, ClassLoader classLoader) throws TransformerFactoryConfigurationError {
        if (str == null) {
            throw new TransformerFactoryConfigurationError("factoryClassName == null");
        }
        ClassLoader classLoader2 = classLoader;
        if (classLoader == null) {
            classLoader2 = Thread.currentThread().getContextClassLoader();
        }
        try {
            return (TransformerFactory) (classLoader2 != null ? classLoader2.loadClass(str) : Class.forName(str)).newInstance();
        } catch (ClassNotFoundException e) {
            throw new TransformerFactoryConfigurationError(e);
        } catch (IllegalAccessException e2) {
            throw new TransformerFactoryConfigurationError(e2);
        } catch (InstantiationException e3) {
            throw new TransformerFactoryConfigurationError(e3);
        }
    }

    public abstract Source getAssociatedStylesheet(Source source, String str, String str2, String str3) throws TransformerConfigurationException;

    public abstract Object getAttribute(String str);

    public abstract ErrorListener getErrorListener();

    public abstract boolean getFeature(String str);

    public abstract URIResolver getURIResolver();

    public abstract Templates newTemplates(Source source) throws TransformerConfigurationException;

    public abstract Transformer newTransformer() throws TransformerConfigurationException;

    public abstract Transformer newTransformer(Source source) throws TransformerConfigurationException;

    public abstract void setAttribute(String str, Object obj);

    public abstract void setErrorListener(ErrorListener errorListener);

    public abstract void setFeature(String str, boolean z) throws TransformerConfigurationException;

    public abstract void setURIResolver(URIResolver uRIResolver);
}
