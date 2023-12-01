package org.apache.harmony.xml.parsers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import org.apache.harmony.xml.ExpatReader;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderAdapter;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/parsers/SAXParserImpl.class */
final class SAXParserImpl extends SAXParser {
    private Map<String, Boolean> initialFeatures;
    private Parser parser;
    private XMLReader reader;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Map] */
    public SAXParserImpl(Map<String, Boolean> map) throws SAXNotRecognizedException, SAXNotSupportedException {
        this.initialFeatures = map.isEmpty() ? Collections.emptyMap() : new HashMap(map);
        resetInternal();
    }

    private void resetInternal() throws SAXNotSupportedException, SAXNotRecognizedException {
        this.reader = new ExpatReader();
        for (Map.Entry<String, Boolean> entry : this.initialFeatures.entrySet()) {
            this.reader.setFeature(entry.getKey(), entry.getValue().booleanValue());
        }
    }

    @Override // javax.xml.parsers.SAXParser
    public Parser getParser() {
        if (this.parser == null) {
            this.parser = new XMLReaderAdapter(this.reader);
        }
        return this.parser;
    }

    @Override // javax.xml.parsers.SAXParser
    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        return this.reader.getProperty(str);
    }

    @Override // javax.xml.parsers.SAXParser
    public XMLReader getXMLReader() {
        return this.reader;
    }

    @Override // javax.xml.parsers.SAXParser
    public boolean isNamespaceAware() {
        try {
            return this.reader.getFeature("http://xml.org/sax/features/namespaces");
        } catch (SAXException e) {
            return false;
        }
    }

    @Override // javax.xml.parsers.SAXParser
    public boolean isValidating() {
        return false;
    }

    @Override // javax.xml.parsers.SAXParser
    public void reset() {
        try {
            resetInternal();
        } catch (SAXNotRecognizedException e) {
            throw new AssertionError();
        } catch (SAXNotSupportedException e2) {
            throw new AssertionError();
        }
    }

    @Override // javax.xml.parsers.SAXParser
    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        this.reader.setProperty(str, obj);
    }
}
