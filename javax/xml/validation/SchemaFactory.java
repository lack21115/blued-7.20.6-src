package javax.xml.validation;

import java.io.File;
import java.net.URL;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/validation/SchemaFactory.class */
public abstract class SchemaFactory {
    protected SchemaFactory() {
    }

    public static SchemaFactory newInstance(String str) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader classLoader = contextClassLoader;
        if (contextClassLoader == null) {
            classLoader = SchemaFactory.class.getClassLoader();
        }
        SchemaFactory newFactory = new SchemaFactoryFinder(classLoader).newFactory(str);
        if (newFactory == null) {
            throw new IllegalArgumentException(str);
        }
        return newFactory;
    }

    public static SchemaFactory newInstance(String str, String str2, ClassLoader classLoader) {
        if (str == null) {
            throw new NullPointerException("schemaLanguage == null");
        }
        if (str2 == null) {
            throw new NullPointerException("factoryClassName == null");
        }
        ClassLoader classLoader2 = classLoader;
        if (classLoader == null) {
            classLoader2 = Thread.currentThread().getContextClassLoader();
        }
        try {
            SchemaFactory schemaFactory = (SchemaFactory) (classLoader2 != null ? classLoader2.loadClass(str2) : Class.forName(str2)).newInstance();
            if (schemaFactory == null || !schemaFactory.isSchemaLanguageSupported(str)) {
                throw new IllegalArgumentException(str);
            }
            return schemaFactory;
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException(e2);
        } catch (InstantiationException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public abstract ErrorHandler getErrorHandler();

    public boolean getFeature(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        throw new SAXNotRecognizedException(str);
    }

    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        throw new SAXNotRecognizedException(str);
    }

    public abstract LSResourceResolver getResourceResolver();

    public abstract boolean isSchemaLanguageSupported(String str);

    public abstract Schema newSchema() throws SAXException;

    public Schema newSchema(File file) throws SAXException {
        return newSchema(new StreamSource(file));
    }

    public Schema newSchema(URL url) throws SAXException {
        return newSchema(new StreamSource(url.toExternalForm()));
    }

    public Schema newSchema(Source source) throws SAXException {
        return newSchema(new Source[]{source});
    }

    public abstract Schema newSchema(Source[] sourceArr) throws SAXException;

    public abstract void setErrorHandler(ErrorHandler errorHandler);

    public void setFeature(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str != null) {
            throw new SAXNotRecognizedException(str);
        }
        throw new NullPointerException("name == null");
    }

    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str != null) {
            throw new SAXNotRecognizedException(str);
        }
        throw new NullPointerException("name == null");
    }

    public abstract void setResourceResolver(LSResourceResolver lSResourceResolver);
}
