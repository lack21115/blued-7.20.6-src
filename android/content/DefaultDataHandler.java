package android.content;

import android.net.Uri;
import android.util.Xml;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/* loaded from: source-9557208-dex2jar.jar:android/content/DefaultDataHandler.class */
public class DefaultDataHandler implements ContentInsertHandler {
    private static final String ARG = "arg";
    private static final String COL = "col";
    private static final String DEL = "del";
    private static final String POSTFIX = "postfix";
    private static final String ROW = "row";
    private static final String SELECT = "select";
    private static final String URI_STR = "uri";
    private ContentResolver mContentResolver;
    private Stack<Uri> mUris = new Stack<>();
    private ContentValues mValues;

    private Uri insertRow() {
        Uri insert = this.mContentResolver.insert(this.mUris.lastElement(), this.mValues);
        this.mValues = null;
        return insert;
    }

    private void parseRow(Attributes attributes) throws SAXException {
        Uri withAppendedPath;
        String value = attributes.getValue("uri");
        if (value != null) {
            Uri parse = Uri.parse(value);
            withAppendedPath = parse;
            if (parse == null) {
                throw new SAXException("attribute " + attributes.getValue("uri") + " parsing failure");
            }
        } else if (this.mUris.size() <= 0) {
            throw new SAXException("attribute parsing failure");
        } else {
            String value2 = attributes.getValue(POSTFIX);
            withAppendedPath = value2 != null ? Uri.withAppendedPath(this.mUris.lastElement(), value2) : this.mUris.lastElement();
        }
        this.mUris.push(withAppendedPath);
    }

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        if (ROW.equals(str2)) {
            if (this.mUris.empty()) {
                throw new SAXException("uri mismatch");
            }
            if (this.mValues != null) {
                insertRow();
            }
            this.mUris.pop();
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
    }

    @Override // android.content.ContentInsertHandler
    public void insert(ContentResolver contentResolver, InputStream inputStream) throws IOException, SAXException {
        this.mContentResolver = contentResolver;
        Xml.parse(inputStream, Xml.Encoding.UTF_8, this);
    }

    @Override // android.content.ContentInsertHandler
    public void insert(ContentResolver contentResolver, String str) throws SAXException {
        this.mContentResolver = contentResolver;
        Xml.parse(str, this);
    }

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
    }

    @Override // org.xml.sax.ContentHandler
    public void skippedEntity(String str) throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
    }

    @Override // org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (ROW.equals(str2)) {
            if (this.mValues == null) {
                if (attributes.getLength() == 0) {
                    this.mUris.push(this.mUris.lastElement());
                } else {
                    parseRow(attributes);
                }
            } else if (this.mUris.empty()) {
                throw new SAXException("uri is empty");
            } else {
                Uri insertRow = insertRow();
                if (insertRow == null) {
                    throw new SAXException("insert to uri " + this.mUris.lastElement().toString() + " failure");
                }
                this.mUris.pop();
                this.mUris.push(insertRow);
                parseRow(attributes);
            }
        } else if (COL.equals(str2)) {
            int length = attributes.getLength();
            if (length != 2) {
                throw new SAXException("illegal attributes number " + length);
            }
            String value = attributes.getValue(0);
            String value2 = attributes.getValue(1);
            if (value == null || value.length() <= 0 || value2 == null || value2.length() <= 0) {
                throw new SAXException("illegal attributes value");
            }
            if (this.mValues == null) {
                this.mValues = new ContentValues();
            }
            this.mValues.put(value, value2);
        } else if (!DEL.equals(str2)) {
            throw new SAXException("unknown element: " + str2);
        } else {
            Uri parse = Uri.parse(attributes.getValue("uri"));
            if (parse == null) {
                throw new SAXException("attribute " + attributes.getValue("uri") + " parsing failure");
            }
            int length2 = attributes.getLength() - 2;
            if (length2 <= 0) {
                if (length2 == 0) {
                    this.mContentResolver.delete(parse, attributes.getValue(1), null);
                    return;
                } else {
                    this.mContentResolver.delete(parse, null, null);
                    return;
                }
            }
            String[] strArr = new String[length2];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length2) {
                    this.mContentResolver.delete(parse, attributes.getValue(1), strArr);
                    return;
                } else {
                    strArr[i2] = attributes.getValue(i2 + 2);
                    i = i2 + 1;
                }
            }
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) throws SAXException {
    }
}
