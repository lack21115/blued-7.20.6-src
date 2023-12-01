package org.xml.sax.helpers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/helpers/XMLReaderFactory.class */
public final class XMLReaderFactory {
    private static final String property = "org.xml.sax.driver";

    private XMLReaderFactory() {
    }

    public static XMLReader createXMLReader() throws SAXException {
        String str = null;
        ClassLoader classLoader = NewInstance.getClassLoader();
        try {
            str = System.getProperty(property);
        } catch (RuntimeException e) {
        }
        String str2 = str;
        if (str == null) {
            try {
                InputStream systemResourceAsStream = classLoader == null ? ClassLoader.getSystemResourceAsStream("META-INF/services/org.xml.sax.driver") : classLoader.getResourceAsStream("META-INF/services/org.xml.sax.driver");
                str2 = str;
                if (systemResourceAsStream != null) {
                    String readLine = new BufferedReader(new InputStreamReader(systemResourceAsStream, StandardCharsets.UTF_8)).readLine();
                    str2 = readLine;
                    systemResourceAsStream.close();
                    str2 = readLine;
                }
            } catch (Exception e2) {
            }
        }
        if (str2 == null) {
        }
        if (str2 != null) {
            return loadClass(classLoader, str2);
        }
        try {
            return new ParserAdapter(ParserFactory.makeParser());
        } catch (Exception e3) {
            throw new SAXException("Can't create default XMLReader; is system property org.xml.sax.driver set?");
        }
    }

    public static XMLReader createXMLReader(String str) throws SAXException {
        return loadClass(NewInstance.getClassLoader(), str);
    }

    private static XMLReader loadClass(ClassLoader classLoader, String str) throws SAXException {
        try {
            return (XMLReader) NewInstance.newInstance(classLoader, str);
        } catch (ClassCastException e) {
            throw new SAXException("SAX2 driver class " + str + " does not implement XMLReader", e);
        } catch (ClassNotFoundException e2) {
            throw new SAXException("SAX2 driver class " + str + " not found", e2);
        } catch (IllegalAccessException e3) {
            throw new SAXException("SAX2 driver class " + str + " found but cannot be loaded", e3);
        } catch (InstantiationException e4) {
            throw new SAXException("SAX2 driver class " + str + " loaded but cannot be instantiated (no empty public constructor?)", e4);
        }
    }
}
