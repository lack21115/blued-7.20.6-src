package java.util.prefs;

import com.anythink.expressad.foundation.g.a;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.UUID;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import libcore.io.IoUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* loaded from: source-2895416-dex2jar.jar:java/util/prefs/XMLParser.class */
class XMLParser {
    static final String DOCTYPE = "<!DOCTYPE preferences SYSTEM";
    private static final String FILE_PREFS = "<!DOCTYPE map SYSTEM 'http://java.sun.com/dtd/preferences.dtd'>";
    static final String HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    static final String PREFS_DTD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>    <!ELEMENT preferences (root)>    <!ATTLIST preferences EXTERNAL_XML_VERSION CDATA \"0.0\" >    <!ELEMENT root (map, node*) >    <!ATTLIST root type (system|user) #REQUIRED >    <!ELEMENT node (map, node*) >    <!ATTLIST node name CDATA #REQUIRED >    <!ELEMENT map (entry*) >    <!ELEMENT entry EMPTY >    <!ATTLIST entry key   CDATA #REQUIRED value CDATA #REQUIRED >";
    static final String PREFS_DTD_NAME = "http://java.sun.com/dtd/preferences.dtd";
    private static final float XML_VERSION = 1.0f;
    private static final DocumentBuilder builder;
    private static int indent = -1;

    static {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setValidating(false);
        try {
            builder = newInstance.newDocumentBuilder();
            builder.setEntityResolver(new EntityResolver() { // from class: java.util.prefs.XMLParser.1
                @Override // org.xml.sax.EntityResolver
                public InputSource resolveEntity(String str, String str2) throws SAXException, IOException {
                    if (str2.equals(XMLParser.PREFS_DTD_NAME)) {
                        InputSource inputSource = new InputSource(new StringReader(XMLParser.PREFS_DTD));
                        inputSource.setSystemId(XMLParser.PREFS_DTD_NAME);
                        return inputSource;
                    }
                    throw new SAXException("Invalid DOCTYPE declaration " + str2);
                }
            });
            builder.setErrorHandler(new ErrorHandler() { // from class: java.util.prefs.XMLParser.2
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
        } catch (ParserConfigurationException e) {
            throw new Error(e);
        }
    }

    private XMLParser() {
    }

    private static void exportEntries(Preferences preferences, BufferedWriter bufferedWriter) throws BackingStoreException, IOException {
        String[] keys = preferences.keys();
        String[] strArr = new String[keys.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= keys.length) {
                exportEntries(keys, strArr, bufferedWriter);
                return;
            } else {
                strArr[i2] = preferences.get(keys[i2], null);
                i = i2 + 1;
            }
        }
    }

    private static void exportEntries(String[] strArr, String[] strArr2, BufferedWriter bufferedWriter) throws IOException {
        if (strArr.length == 0) {
            flushEmptyElement("map", bufferedWriter);
            return;
        }
        flushStartTag("map", bufferedWriter);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                flushEndTag("map", bufferedWriter);
                return;
            }
            if (strArr2[i2] != null) {
                flushEmptyElement(a.aj, new String[]{"key", "value"}, new String[]{strArr[i2], strArr2[i2]}, bufferedWriter);
            }
            i = i2 + 1;
        }
    }

    private static void exportNode(StringTokenizer stringTokenizer, Preferences preferences, boolean z, BufferedWriter bufferedWriter) throws IOException, BackingStoreException {
        if (stringTokenizer.hasMoreTokens()) {
            flushStartTag("node", new String[]{"name"}, new String[]{stringTokenizer.nextToken()}, bufferedWriter);
            if (stringTokenizer.hasMoreTokens()) {
                flushEmptyElement("map", bufferedWriter);
                exportNode(stringTokenizer, preferences, z, bufferedWriter);
            } else {
                exportEntries(preferences, bufferedWriter);
                if (z) {
                    exportSubTree(preferences, bufferedWriter);
                }
            }
            flushEndTag("node", bufferedWriter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void exportPrefs(Preferences preferences, OutputStream outputStream, boolean z) throws IOException, BackingStoreException {
        indent = -1;
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        bufferedWriter.write(HEADER);
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        bufferedWriter.write(DOCTYPE);
        bufferedWriter.write(" '");
        bufferedWriter.write(PREFS_DTD_NAME);
        bufferedWriter.write("'>");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        flushStartTag("preferences", new String[]{"EXTERNAL_XML_VERSION"}, new String[]{String.valueOf(1.0f)}, bufferedWriter);
        flushStartTag("root", new String[]{"type"}, new String[]{preferences.isUserNode() ? "user" : "system"}, bufferedWriter);
        flushEmptyElement("map", bufferedWriter);
        exportNode(new StringTokenizer(preferences.absolutePath(), BridgeUtil.SPLIT_MARK), preferences, z, bufferedWriter);
        flushEndTag("root", bufferedWriter);
        flushEndTag("preferences", bufferedWriter);
        bufferedWriter.flush();
    }

    private static void exportSubTree(Preferences preferences, BufferedWriter bufferedWriter) throws BackingStoreException, IOException {
        String[] childrenNames = preferences.childrenNames();
        if (childrenNames.length <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childrenNames.length) {
                return;
            }
            Preferences node = preferences.node(childrenNames[i2]);
            flushStartTag("node", new String[]{"name"}, new String[]{childrenNames[i2]}, bufferedWriter);
            exportEntries(node, bufferedWriter);
            exportSubTree(node, bufferedWriter);
            flushEndTag("node", bufferedWriter);
            i = i2 + 1;
        }
    }

    private static void flushEmptyElement(String str, BufferedWriter bufferedWriter) throws IOException {
        int i = indent + 1;
        indent = i;
        flushIndent(i, bufferedWriter);
        bufferedWriter.write(SimpleComparison.LESS_THAN_OPERATION);
        bufferedWriter.write(str);
        bufferedWriter.write(" />");
        bufferedWriter.newLine();
        indent--;
    }

    private static void flushEmptyElement(String str, String[] strArr, String[] strArr2, BufferedWriter bufferedWriter) throws IOException {
        int i = indent + 1;
        indent = i;
        flushIndent(i, bufferedWriter);
        bufferedWriter.write(SimpleComparison.LESS_THAN_OPERATION);
        bufferedWriter.write(str);
        flushPairs(strArr, strArr2, bufferedWriter);
        bufferedWriter.write(" />");
        bufferedWriter.newLine();
        indent--;
    }

    private static void flushEndTag(String str, BufferedWriter bufferedWriter) throws IOException {
        int i = indent;
        indent = i - 1;
        flushIndent(i, bufferedWriter);
        bufferedWriter.write("</");
        bufferedWriter.write(str);
        bufferedWriter.write(SimpleComparison.GREATER_THAN_OPERATION);
        bufferedWriter.newLine();
    }

    private static void flushIndent(int i, BufferedWriter bufferedWriter) throws IOException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            bufferedWriter.write("  ");
            i2 = i3 + 1;
        }
    }

    private static void flushPairs(String[] strArr, String[] strArr2, BufferedWriter bufferedWriter) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            bufferedWriter.write(" ");
            bufferedWriter.write(strArr[i2]);
            bufferedWriter.write("=\"");
            bufferedWriter.write(htmlEncode(strArr2[i2]));
            bufferedWriter.write("\"");
            i = i2 + 1;
        }
    }

    private static void flushStartTag(String str, BufferedWriter bufferedWriter) throws IOException {
        int i = indent + 1;
        indent = i;
        flushIndent(i, bufferedWriter);
        bufferedWriter.write(SimpleComparison.LESS_THAN_OPERATION);
        bufferedWriter.write(str);
        bufferedWriter.write(SimpleComparison.GREATER_THAN_OPERATION);
        bufferedWriter.newLine();
    }

    private static void flushStartTag(String str, String[] strArr, String[] strArr2, BufferedWriter bufferedWriter) throws IOException {
        int i = indent + 1;
        indent = i;
        flushIndent(i, bufferedWriter);
        bufferedWriter.write(SimpleComparison.LESS_THAN_OPERATION);
        bufferedWriter.write(str);
        flushPairs(strArr, strArr2, bufferedWriter);
        bufferedWriter.write(SimpleComparison.GREATER_THAN_OPERATION);
        bufferedWriter.newLine();
    }

    private static String htmlEncode(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            switch (charAt) {
                case '\"':
                    sb.append("&quot;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                default:
                    sb.append(charAt);
                    break;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void importPrefs(InputStream inputStream) throws IOException, InvalidPreferencesFormatException {
        try {
            Element documentElement = builder.parse(new InputSource(inputStream)).getDocumentElement();
            String attribute = documentElement.getAttribute("EXTERNAL_XML_VERSION");
            if (attribute != null && Float.parseFloat(attribute) > 1.0f) {
                throw new InvalidPreferencesFormatException("Preferences version " + attribute + " is not supported");
            }
            Element element = (Element) documentElement.getElementsByTagName("root").item(0);
            loadNode(element.getAttribute("type").equals("user") ? Preferences.userRoot() : Preferences.systemRoot(), element);
        } catch (FactoryConfigurationError e) {
            throw new InvalidPreferencesFormatException(e);
        } catch (SAXException e2) {
            throw new InvalidPreferencesFormatException(e2);
        }
    }

    private static void loadNode(Preferences preferences, Element element) {
        NodeList selectNodeList = selectNodeList(element, "node");
        NodeList selectNodeList2 = selectNodeList(element, "map/entry");
        int length = selectNodeList.getLength();
        Preferences[] preferencesArr = new Preferences[length];
        int length2 = selectNodeList2.getLength();
        synchronized (((AbstractPreferences) preferences).lock) {
            if (((AbstractPreferences) preferences).isRemoved()) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length2) {
                    break;
                }
                Element element2 = (Element) selectNodeList2.item(i2);
                preferences.put(element2.getAttribute("key"), element2.getAttribute("value"));
                i = i2 + 1;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    break;
                }
                preferencesArr[i4] = preferences.node(((Element) selectNodeList.item(i4)).getAttribute("name"));
                i3 = i4 + 1;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= length) {
                    return;
                }
                loadNode(preferencesArr[i6], (Element) selectNodeList.item(i6));
                i5 = i6 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Properties readXmlPreferences(File file) {
        InputStreamReader inputStreamReader;
        Properties properties = new Properties();
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            return properties;
        } else if (!file.canRead()) {
            file.delete();
            return properties;
        } else {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            } catch (IOException e) {
                inputStreamReader = null;
            } catch (SAXException e2) {
                inputStreamReader = null;
            } catch (Throwable th) {
                th = th;
                inputStreamReader = null;
            }
            try {
                NodeList selectNodeList = selectNodeList(builder.parse(new InputSource(inputStreamReader)).getDocumentElement(), a.aj);
                int length = selectNodeList.getLength();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        IoUtils.closeQuietly(inputStreamReader);
                        return properties;
                    }
                    Element element = (Element) selectNodeList.item(i2);
                    properties.setProperty(element.getAttribute("key"), element.getAttribute("value"));
                    i = i2 + 1;
                }
            } catch (IOException e3) {
                IoUtils.closeQuietly(inputStreamReader);
                return properties;
            } catch (SAXException e4) {
                IoUtils.closeQuietly(inputStreamReader);
                return properties;
            } catch (Throwable th2) {
                th = th2;
                IoUtils.closeQuietly(inputStreamReader);
                throw th;
            }
        }
    }

    private static NodeList selectNodeList(Element element, String str) {
        ArrayList arrayList = new ArrayList();
        String[] split = str.split(BridgeUtil.SPLIT_MARK);
        NodeList childNodes = element.getChildNodes();
        if (split[0].equals(a.aj) || split[0].equals("node")) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childNodes.getLength()) {
                    break;
                }
                Node item = childNodes.item(i2);
                if ((item instanceof Element) && ((Element) item).getNodeName().equals(split[0])) {
                    arrayList.add(item);
                }
                i = i2 + 1;
            }
        } else if (split[0].equals("map") && split[1].equals(a.aj)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= childNodes.getLength()) {
                    break;
                }
                Node item2 = childNodes.item(i4);
                if ((item2 instanceof Element) && ((Element) item2).getNodeName().equals(split[0])) {
                    NodeList childNodes2 = item2.getChildNodes();
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 < childNodes2.getLength()) {
                            Node item3 = childNodes2.item(i6);
                            if ((item3 instanceof Element) && ((Element) item3).getNodeName().equals(split[1])) {
                                arrayList.add(item3);
                            }
                            i5 = i6 + 1;
                        }
                    }
                }
                i3 = i4 + 1;
            }
        }
        return new NodeSet(arrayList.iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeXmlPreferences(File file, Properties properties) throws IOException {
        BufferedWriter bufferedWriter;
        File file2 = new File(file.getParentFile(), "prefs-" + UUID.randomUUID() + ".xml.tmp");
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2), "UTF-8"));
            try {
                bufferedWriter2.write(HEADER);
                bufferedWriter2.newLine();
                bufferedWriter2.write(FILE_PREFS);
                bufferedWriter2.newLine();
                String[] strArr = (String[]) properties.keySet().toArray(new String[properties.size()]);
                int length = strArr.length;
                String[] strArr2 = new String[length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    strArr2[i2] = properties.getProperty(strArr[i2]);
                    i = i2 + 1;
                }
                exportEntries(strArr, strArr2, bufferedWriter2);
                bufferedWriter2.close();
                if (!file2.renameTo(file)) {
                    throw new IOException("Failed to write preferences to " + file);
                }
                IoUtils.closeQuietly(bufferedWriter2);
                file2.delete();
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                IoUtils.closeQuietly(bufferedWriter);
                file2.delete();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter = null;
        }
    }
}
