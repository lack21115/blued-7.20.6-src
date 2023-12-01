package android.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import org.apache.harmony.xml.ExpatReader;
import org.kxml2.io.KXmlParser;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-9557208-dex2jar.jar:android/util/Xml.class */
public class Xml {
    public static String FEATURE_RELAXED = "http://xmlpull.org/v1/doc/features.html#relaxed";

    /* loaded from: source-9557208-dex2jar.jar:android/util/Xml$Encoding.class */
    public enum Encoding {
        US_ASCII("US-ASCII"),
        UTF_8("UTF-8"),
        UTF_16("UTF-16"),
        ISO_8859_1("ISO-8859-1");
        
        final String expatName;

        Encoding(String str) {
            this.expatName = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/util/Xml$XmlSerializerFactory.class */
    public static class XmlSerializerFactory {
        static final String TYPE = "org.kxml2.io.KXmlParser,org.kxml2.io.KXmlSerializer";
        static final XmlPullParserFactory instance;

        static {
            try {
                instance = XmlPullParserFactory.newInstance(TYPE, null);
            } catch (XmlPullParserException e) {
                throw new AssertionError(e);
            }
        }

        XmlSerializerFactory() {
        }
    }

    public static AttributeSet asAttributeSet(XmlPullParser xmlPullParser) {
        return xmlPullParser instanceof AttributeSet ? (AttributeSet) xmlPullParser : new XmlPullAttributes(xmlPullParser);
    }

    public static Encoding findEncodingByName(String str) throws UnsupportedEncodingException {
        Encoding encoding;
        if (str == null) {
            encoding = Encoding.UTF_8;
        } else {
            Encoding[] values = Encoding.values();
            int length = values.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    throw new UnsupportedEncodingException(str);
                }
                Encoding encoding2 = values[i2];
                encoding = encoding2;
                if (encoding2.expatName.equalsIgnoreCase(str)) {
                    break;
                }
                i = i2 + 1;
            }
        }
        return encoding;
    }

    public static XmlPullParser newPullParser() {
        try {
            KXmlParser kXmlParser = new KXmlParser();
            kXmlParser.setFeature(XmlPullParser.FEATURE_PROCESS_DOCDECL, true);
            kXmlParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
            return kXmlParser;
        } catch (XmlPullParserException e) {
            throw new AssertionError();
        }
    }

    public static XmlSerializer newSerializer() {
        try {
            return XmlSerializerFactory.instance.newSerializer();
        } catch (XmlPullParserException e) {
            throw new AssertionError(e);
        }
    }

    public static void parse(InputStream inputStream, Encoding encoding, ContentHandler contentHandler) throws IOException, SAXException {
        ExpatReader expatReader = new ExpatReader();
        expatReader.setContentHandler(contentHandler);
        InputSource inputSource = new InputSource(inputStream);
        inputSource.setEncoding(encoding.expatName);
        expatReader.parse(inputSource);
    }

    public static void parse(Reader reader, ContentHandler contentHandler) throws IOException, SAXException {
        ExpatReader expatReader = new ExpatReader();
        expatReader.setContentHandler(contentHandler);
        expatReader.parse(new InputSource(reader));
    }

    public static void parse(String str, ContentHandler contentHandler) throws SAXException {
        try {
            ExpatReader expatReader = new ExpatReader();
            expatReader.setContentHandler(contentHandler);
            expatReader.parse(new InputSource(new StringReader(str)));
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
