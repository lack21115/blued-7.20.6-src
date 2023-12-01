package org.xml.sax.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.xml.XMLConstants;

/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/helpers/NamespaceSupport.class */
public class NamespaceSupport {
    private static final Enumeration EMPTY_ENUMERATION = Collections.enumeration(Collections.emptyList());
    public static final String NSDECL = "http://www.w3.org/xmlns/2000/";
    public static final String XMLNS = "http://www.w3.org/XML/1998/namespace";
    private int contextPos;
    private Context[] contexts;
    private Context currentContext;
    private boolean namespaceDeclUris;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:org/xml/sax/helpers/NamespaceSupport$Context.class */
    public final class Context {
        Hashtable attributeNameTable;
        Hashtable elementNameTable;
        Hashtable prefixTable;
        Hashtable uriTable;
        String defaultNS = null;
        boolean declsOK = true;
        private ArrayList<String> declarations = null;
        private boolean declSeen = false;
        private Context parent = null;

        Context() {
            copyTables();
        }

        private void copyTables() {
            if (this.prefixTable != null) {
                this.prefixTable = (Hashtable) this.prefixTable.clone();
            } else {
                this.prefixTable = new Hashtable();
            }
            if (this.uriTable != null) {
                this.uriTable = (Hashtable) this.uriTable.clone();
            } else {
                this.uriTable = new Hashtable();
            }
            this.elementNameTable = new Hashtable();
            this.attributeNameTable = new Hashtable();
            this.declSeen = true;
        }

        void clear() {
            this.parent = null;
            this.prefixTable = null;
            this.uriTable = null;
            this.elementNameTable = null;
            this.attributeNameTable = null;
            this.defaultNS = null;
        }

        void declarePrefix(String str, String str2) {
            if (!this.declsOK) {
                throw new IllegalStateException("can't declare any more prefixes in this context");
            }
            if (!this.declSeen) {
                copyTables();
            }
            if (this.declarations == null) {
                this.declarations = new ArrayList<>();
            }
            String intern = str.intern();
            String intern2 = str2.intern();
            if (!"".equals(intern)) {
                this.prefixTable.put(intern, intern2);
                this.uriTable.put(intern2, intern);
            } else if ("".equals(intern2)) {
                this.defaultNS = null;
            } else {
                this.defaultNS = intern2;
            }
            this.declarations.add(intern);
        }

        Enumeration getDeclaredPrefixes() {
            return this.declarations == null ? NamespaceSupport.EMPTY_ENUMERATION : Collections.enumeration(this.declarations);
        }

        String getPrefix(String str) {
            if (this.uriTable == null) {
                return null;
            }
            return (String) this.uriTable.get(str);
        }

        Enumeration getPrefixes() {
            return this.prefixTable == null ? NamespaceSupport.EMPTY_ENUMERATION : this.prefixTable.keys();
        }

        String getURI(String str) {
            if ("".equals(str)) {
                return this.defaultNS;
            }
            if (this.prefixTable == null) {
                return null;
            }
            return (String) this.prefixTable.get(str);
        }

        String[] processName(String str, boolean z) {
            this.declsOK = false;
            Hashtable hashtable = z ? this.attributeNameTable : this.elementNameTable;
            String[] strArr = (String[]) hashtable.get(str);
            if (strArr != null) {
                return strArr;
            }
            String[] strArr2 = new String[3];
            strArr2[2] = str.intern();
            int indexOf = str.indexOf(58);
            if (indexOf == -1) {
                if (z) {
                    if (str == XMLConstants.XMLNS_ATTRIBUTE && NamespaceSupport.this.namespaceDeclUris) {
                        strArr2[0] = NamespaceSupport.NSDECL;
                    } else {
                        strArr2[0] = "";
                    }
                } else if (this.defaultNS == null) {
                    strArr2[0] = "";
                } else {
                    strArr2[0] = this.defaultNS;
                }
                strArr2[1] = strArr2[2];
            } else {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 1);
                String str2 = "".equals(substring) ? this.defaultNS : (String) this.prefixTable.get(substring);
                if (str2 == null) {
                    return null;
                }
                if (!z && XMLConstants.XMLNS_ATTRIBUTE.equals(substring)) {
                    return null;
                }
                strArr2[0] = str2;
                strArr2[1] = substring2.intern();
            }
            hashtable.put(strArr2[2], strArr2);
            return strArr2;
        }

        void setParent(Context context) {
            this.parent = context;
            this.declarations = null;
            this.prefixTable = context.prefixTable;
            this.uriTable = context.uriTable;
            this.elementNameTable = context.elementNameTable;
            this.attributeNameTable = context.attributeNameTable;
            this.defaultNS = context.defaultNS;
            this.declSeen = false;
            this.declsOK = true;
        }
    }

    public NamespaceSupport() {
        reset();
    }

    public boolean declarePrefix(String str, String str2) {
        if (str.equals(XMLConstants.XML_NS_PREFIX) || str.equals(XMLConstants.XMLNS_ATTRIBUTE)) {
            return false;
        }
        this.currentContext.declarePrefix(str, str2);
        return true;
    }

    public Enumeration getDeclaredPrefixes() {
        return this.currentContext.getDeclaredPrefixes();
    }

    public String getPrefix(String str) {
        return this.currentContext.getPrefix(str);
    }

    public Enumeration getPrefixes() {
        return this.currentContext.getPrefixes();
    }

    public Enumeration getPrefixes(String str) {
        ArrayList arrayList = new ArrayList();
        Enumeration prefixes = getPrefixes();
        while (prefixes.hasMoreElements()) {
            String str2 = (String) prefixes.nextElement();
            if (str.equals(getURI(str2))) {
                arrayList.add(str2);
            }
        }
        return Collections.enumeration(arrayList);
    }

    public String getURI(String str) {
        return this.currentContext.getURI(str);
    }

    public boolean isNamespaceDeclUris() {
        return this.namespaceDeclUris;
    }

    public void popContext() {
        this.contexts[this.contextPos].clear();
        this.contextPos--;
        if (this.contextPos < 0) {
            throw new EmptyStackException();
        }
        this.currentContext = this.contexts[this.contextPos];
    }

    public String[] processName(String str, String[] strArr, boolean z) {
        String[] processName = this.currentContext.processName(str, z);
        if (processName == null) {
            return null;
        }
        strArr[0] = processName[0];
        strArr[1] = processName[1];
        strArr[2] = processName[2];
        return strArr;
    }

    public void pushContext() {
        int length = this.contexts.length;
        this.contexts[this.contextPos].declsOK = false;
        this.contextPos++;
        if (this.contextPos >= length) {
            Context[] contextArr = new Context[length * 2];
            System.arraycopy(this.contexts, 0, contextArr, 0, length);
            this.contexts = contextArr;
        }
        this.currentContext = this.contexts[this.contextPos];
        if (this.currentContext == null) {
            Context[] contextArr2 = this.contexts;
            int i = this.contextPos;
            Context context = new Context();
            this.currentContext = context;
            contextArr2[i] = context;
        }
        if (this.contextPos > 0) {
            this.currentContext.setParent(this.contexts[this.contextPos - 1]);
        }
    }

    public void reset() {
        this.contexts = new Context[32];
        this.namespaceDeclUris = false;
        this.contextPos = 0;
        Context[] contextArr = this.contexts;
        int i = this.contextPos;
        Context context = new Context();
        this.currentContext = context;
        contextArr[i] = context;
        this.currentContext.declarePrefix(XMLConstants.XML_NS_PREFIX, "http://www.w3.org/XML/1998/namespace");
    }

    public void setNamespaceDeclUris(boolean z) {
        if (this.contextPos != 0) {
            throw new IllegalStateException();
        }
        if (z == this.namespaceDeclUris) {
            return;
        }
        this.namespaceDeclUris = z;
        if (z) {
            this.currentContext.declarePrefix(XMLConstants.XMLNS_ATTRIBUTE, NSDECL);
            return;
        }
        Context[] contextArr = this.contexts;
        int i = this.contextPos;
        Context context = new Context();
        this.currentContext = context;
        contextArr[i] = context;
        this.currentContext.declarePrefix(XMLConstants.XML_NS_PREFIX, "http://www.w3.org/XML/1998/namespace");
    }
}
