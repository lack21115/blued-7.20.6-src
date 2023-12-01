package java.util;

import com.alipay.sdk.sys.a;
import com.anythink.core.common.c.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* loaded from: source-2895416-dex2jar.jar:java/util/Properties.class */
public class Properties extends Hashtable<Object, Object> {
    private static final int CONTINUE = 3;
    private static final int IGNORE = 5;
    private static final int KEY_DONE = 4;
    private static final int NONE = 0;
    private static final String PROP_DTD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>    <!ELEMENT properties (comment?, entry*) >    <!ATTLIST properties version CDATA #FIXED \"1.0\" >    <!ELEMENT comment (#PCDATA) >    <!ELEMENT entry (#PCDATA) >    <!ATTLIST entry key CDATA #REQUIRED >";
    private static final String PROP_DTD_NAME = "http://java.sun.com/dtd/properties.dtd";
    private static final int SLASH = 1;
    private static final int UNICODE = 2;
    private static final long serialVersionUID = 4112578634029874840L;
    private transient DocumentBuilder builder = null;
    protected Properties defaults;

    public Properties() {
    }

    public Properties(Properties properties) {
        this.defaults = properties;
    }

    private void dumpString(StringBuilder sb, String str, boolean z) {
        int i = 0;
        if (!z) {
            i = 0;
            if (str.length() < 0) {
                i = 0;
                if (str.charAt(0) == ' ') {
                    sb.append("\\ ");
                    i = 0 + 1;
                }
            }
        }
        while (i < str.length()) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\t':
                    sb.append("\\t");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case 11:
                default:
                    if ("\\#!=:".indexOf(charAt) >= 0 || (z && charAt == ' ')) {
                        sb.append('\\');
                    }
                    if (charAt >= ' ' && charAt <= '~') {
                        sb.append(charAt);
                        break;
                    } else {
                        String hexString = Integer.toHexString(charAt);
                        sb.append("\\u");
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= 4 - hexString.length()) {
                                sb.append(hexString);
                                break;
                            } else {
                                sb.append("0");
                                i2 = i3 + 1;
                            }
                        }
                    }
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
            }
            i++;
        }
    }

    private void listToAppendable(Appendable appendable) {
        try {
            if (appendable == null) {
                throw new NullPointerException("out == null");
            }
            StringBuilder sb = new StringBuilder(80);
            Enumeration<?> propertyNames = propertyNames();
            while (propertyNames.hasMoreElements()) {
                String str = (String) propertyNames.nextElement();
                sb.append(str);
                sb.append('=');
                String str2 = (String) super.get(str);
                Properties properties = this.defaults;
                while (str2 == null) {
                    str2 = (String) properties.get(str);
                    properties = properties.defaults;
                }
                if (str2.length() > 40) {
                    sb.append(str2.substring(0, 37));
                    sb.append("...");
                } else {
                    sb.append(str2);
                }
                sb.append(System.lineSeparator());
                appendable.append(sb.toString());
                sb.setLength(0);
            }
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K> void selectProperties(Hashtable<K, Object> hashtable, boolean z) {
        if (this.defaults != null) {
            this.defaults.selectProperties(hashtable, z);
        }
        Enumeration<Object> keys = keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            if (!z || (nextElement instanceof String)) {
                hashtable.put(nextElement, get(nextElement));
            }
        }
    }

    private String substitutePredefinedEntries(String str) {
        return str.replaceAll(a.b, "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("'", "&apos;").replaceAll("\"", "&quot;");
    }

    public String getProperty(String str) {
        Object obj = super.get(str);
        String str2 = obj instanceof String ? (String) obj : null;
        String str3 = str2;
        if (str2 == null) {
            str3 = str2;
            if (this.defaults != null) {
                str3 = this.defaults.getProperty(str);
            }
        }
        return str3;
    }

    public String getProperty(String str, String str2) {
        Object obj = super.get(str);
        String str3 = obj instanceof String ? (String) obj : null;
        String str4 = str3;
        if (str3 == null) {
            str4 = str3;
            if (this.defaults != null) {
                str4 = this.defaults.getProperty(str);
            }
        }
        return str4 == null ? str2 : str4;
    }

    public void list(PrintStream printStream) {
        listToAppendable(printStream);
    }

    public void list(PrintWriter printWriter) {
        listToAppendable(printWriter);
    }

    public void load(InputStream inputStream) throws IOException {
        synchronized (this) {
            if (inputStream == null) {
                throw new NullPointerException("in == null");
            }
            load(new InputStreamReader(inputStream, "ISO-8859-1"));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x043f, code lost:
        if (r17 == true) goto L106;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0430 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x025b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void load(java.io.Reader r7) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1124
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Properties.load(java.io.Reader):void");
    }

    public void loadFromXML(InputStream inputStream) throws IOException, InvalidPropertiesFormatException {
        synchronized (this) {
            if (inputStream == null) {
                throw new NullPointerException("in == null");
            }
            if (this.builder == null) {
                try {
                    this.builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    this.builder.setErrorHandler(new ErrorHandler() { // from class: java.util.Properties.1
                        @Override // org.xml.sax.ErrorHandler
                        public void error(SAXParseException sAXParseException) throws SAXException {
                            throw sAXParseException;
                        }

                        @Override // org.xml.sax.ErrorHandler
                        public void fatalError(SAXParseException sAXParseException) throws SAXException {
                            throw sAXParseException;
                        }

                        @Override // org.xml.sax.ErrorHandler
                        public void warning(SAXParseException sAXParseException) throws SAXException {
                            throw sAXParseException;
                        }
                    });
                    this.builder.setEntityResolver(new EntityResolver() { // from class: java.util.Properties.2
                        @Override // org.xml.sax.EntityResolver
                        public InputSource resolveEntity(String str, String str2) throws SAXException, IOException {
                            if (str2.equals(Properties.PROP_DTD_NAME)) {
                                InputSource inputSource = new InputSource(new StringReader(Properties.PROP_DTD));
                                inputSource.setSystemId(Properties.PROP_DTD_NAME);
                                return inputSource;
                            }
                            throw new SAXException("Invalid DOCTYPE declaration: " + str2);
                        }
                    });
                } catch (ParserConfigurationException e) {
                    throw new Error(e);
                }
            }
            try {
                try {
                    NodeList elementsByTagName = this.builder.parse(inputStream).getElementsByTagName("entry");
                    if (elementsByTagName != null) {
                        int length = elementsByTagName.getLength();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= length) {
                                break;
                            }
                            Element element = (Element) elementsByTagName.item(i2);
                            put(element.getAttribute(d.a.b), element.getTextContent());
                            i = i2 + 1;
                        }
                    }
                } catch (IOException e2) {
                    throw e2;
                }
            } catch (SAXException e3) {
                throw new InvalidPropertiesFormatException(e3);
            }
        }
    }

    public Enumeration<?> propertyNames() {
        Hashtable hashtable = new Hashtable();
        selectProperties(hashtable, false);
        return hashtable.keys();
    }

    @Deprecated
    public void save(OutputStream outputStream, String str) {
        try {
            store(outputStream, str);
        } catch (IOException e) {
        }
    }

    public Object setProperty(String str, String str2) {
        return put(str, str2);
    }

    public void store(OutputStream outputStream, String str) throws IOException {
        synchronized (this) {
            store(new OutputStreamWriter(outputStream, "ISO-8859-1"), str);
        }
    }

    public void store(Writer writer, String str) throws IOException {
        synchronized (this) {
            if (str != null) {
                writer.write("#");
                writer.write(str);
                writer.write(System.lineSeparator());
            }
            writer.write("#");
            writer.write(new Date().toString());
            writer.write(System.lineSeparator());
            StringBuilder sb = new StringBuilder(200);
            for (Map.Entry<Object, Object> entry : entrySet()) {
                dumpString(sb, (String) entry.getKey(), true);
                sb.append('=');
                dumpString(sb, (String) entry.getValue(), false);
                sb.append(System.lineSeparator());
                writer.write(sb.toString());
                sb.setLength(0);
            }
            writer.flush();
        }
    }

    public void storeToXML(OutputStream outputStream, String str) throws IOException {
        storeToXML(outputStream, str, "UTF-8");
    }

    public void storeToXML(OutputStream outputStream, String str, String str2) throws IOException {
        String str3;
        synchronized (this) {
            if (outputStream == null) {
                throw new NullPointerException("os == null");
            }
            if (str2 == null) {
                throw new NullPointerException("encoding == null");
            }
            try {
                try {
                    str3 = Charset.forName(str2).name();
                } catch (IllegalCharsetNameException e) {
                    System.out.println("Warning: encoding name " + str2 + " is illegal, using UTF-8 as default encoding");
                    str3 = "UTF-8";
                }
            } catch (UnsupportedCharsetException e2) {
                System.out.println("Warning: encoding " + str2 + " is not supported, using UTF-8 as default encoding");
                str3 = "UTF-8";
            }
            PrintStream printStream = new PrintStream(outputStream, false, str3);
            printStream.print("<?xml version=\"1.0\" encoding=\"");
            printStream.print(str3);
            printStream.println("\"?>");
            printStream.print("<!DOCTYPE properties SYSTEM \"");
            printStream.print(PROP_DTD_NAME);
            printStream.println("\">");
            printStream.println("<properties>");
            if (str != null) {
                printStream.print("<comment>");
                printStream.print(substitutePredefinedEntries(str));
                printStream.println("</comment>");
            }
            for (Map.Entry<Object, Object> entry : entrySet()) {
                String str4 = (String) entry.getKey();
                printStream.print("<entry key=\"");
                printStream.print(substitutePredefinedEntries(str4));
                printStream.print("\">");
                printStream.print(substitutePredefinedEntries((String) entry.getValue()));
                printStream.println("</entry>");
            }
            printStream.println("</properties>");
            printStream.flush();
        }
    }

    public Set<String> stringPropertyNames() {
        Hashtable hashtable = new Hashtable();
        selectProperties(hashtable, true);
        return Collections.unmodifiableSet(hashtable.keySet());
    }
}
