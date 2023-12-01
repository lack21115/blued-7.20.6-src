package org.apache.harmony.xml.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/DOMImplementationImpl.class */
public final class DOMImplementationImpl implements DOMImplementation {
    private static DOMImplementationImpl instance;

    DOMImplementationImpl() {
    }

    public static DOMImplementationImpl getInstance() {
        if (instance == null) {
            instance = new DOMImplementationImpl();
        }
        return instance;
    }

    @Override // org.w3c.dom.DOMImplementation
    public Document createDocument(String str, String str2, DocumentType documentType) throws DOMException {
        return new DocumentImpl(this, str, str2, documentType, null);
    }

    @Override // org.w3c.dom.DOMImplementation
    public DocumentType createDocumentType(String str, String str2, String str3) throws DOMException {
        return new DocumentTypeImpl(null, str, str2, str3);
    }

    @Override // org.w3c.dom.DOMImplementation
    public Object getFeature(String str, String str2) {
        if (hasFeature(str, str2)) {
            return this;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
        if (r5.equals("3.0") != false) goto L22;
     */
    @Override // org.w3c.dom.DOMImplementation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean hasFeature(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            r0 = 0
            r8 = r0
            r0 = r5
            if (r0 == 0) goto Le
            r0 = r5
            int r0 = r0.length()
            if (r0 != 0) goto L56
        Le:
            r0 = 1
            r6 = r0
        L10:
            r0 = r4
            r9 = r0
            r0 = r4
            java.lang.String r1 = "+"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L23
            r0 = r4
            r1 = 1
            java.lang.String r0 = r0.substring(r1)
            r9 = r0
        L23:
            r0 = r9
            java.lang.String r1 = "Core"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L5b
            r0 = r6
            if (r0 != 0) goto L50
            r0 = r5
            java.lang.String r1 = "1.0"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L50
            r0 = r5
            java.lang.String r1 = "2.0"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L50
            r0 = r8
            r7 = r0
            r0 = r5
            java.lang.String r1 = "3.0"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L53
        L50:
            r0 = 1
            r7 = r0
        L53:
            r0 = r7
            return r0
        L56:
            r0 = 0
            r6 = r0
            goto L10
        L5b:
            r0 = r9
            java.lang.String r1 = "XML"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L8a
            r0 = r6
            if (r0 != 0) goto L88
            r0 = r5
            java.lang.String r1 = "1.0"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L88
            r0 = r5
            java.lang.String r1 = "2.0"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L88
            r0 = r8
            r7 = r0
            r0 = r5
            java.lang.String r1 = "3.0"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L53
        L88:
            r0 = 1
            return r0
        L8a:
            r0 = r8
            r7 = r0
            r0 = r9
            java.lang.String r1 = "XMLVersion"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L53
            r0 = r6
            if (r0 != 0) goto Lb2
            r0 = r5
            java.lang.String r1 = "1.0"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb2
            r0 = r8
            r7 = r0
            r0 = r5
            java.lang.String r1 = "1.1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L53
        Lb2:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.harmony.xml.dom.DOMImplementationImpl.hasFeature(java.lang.String, java.lang.String):boolean");
    }
}
