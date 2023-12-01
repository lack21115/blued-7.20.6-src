package org.apache.harmony.xml.dom;

import android.provider.ContactsContract;
import com.alipay.sdk.cons.c;
import java.util.Map;
import java.util.TreeMap;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMErrorHandler;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMStringList;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/DOMConfigurationImpl.class */
public final class DOMConfigurationImpl implements DOMConfiguration {
    private static final Map<String, Parameter> PARAMETERS = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private DOMErrorHandler errorHandler;
    private String schemaLocation;
    private String schemaType;
    private boolean cdataSections = true;
    private boolean comments = true;
    private boolean datatypeNormalization = false;
    private boolean entities = true;
    private boolean namespaces = true;
    private boolean splitCdataSections = true;
    private boolean validate = false;
    private boolean wellFormed = true;

    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/DOMConfigurationImpl$BooleanParameter.class */
    static abstract class BooleanParameter implements Parameter {
        BooleanParameter() {
        }

        @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
        public boolean canSet(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
            return obj instanceof Boolean;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/DOMConfigurationImpl$FixedParameter.class */
    static class FixedParameter implements Parameter {
        final Object onlyValue;

        FixedParameter(Object obj) {
            this.onlyValue = obj;
        }

        @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
        public boolean canSet(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
            return this.onlyValue.equals(obj);
        }

        @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
        public Object get(DOMConfigurationImpl dOMConfigurationImpl) {
            return this.onlyValue;
        }

        @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
        public void set(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
            if (!this.onlyValue.equals(obj)) {
                throw new DOMException((short) 9, "Unsupported value: " + obj);
            }
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/xml/dom/DOMConfigurationImpl$Parameter.class */
    interface Parameter {
        boolean canSet(DOMConfigurationImpl dOMConfigurationImpl, Object obj);

        Object get(DOMConfigurationImpl dOMConfigurationImpl);

        void set(DOMConfigurationImpl dOMConfigurationImpl, Object obj);
    }

    static {
        PARAMETERS.put("canonical-form", new FixedParameter(false));
        PARAMETERS.put("cdata-sections", new BooleanParameter() { // from class: org.apache.harmony.xml.dom.DOMConfigurationImpl.1
            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public Object get(DOMConfigurationImpl dOMConfigurationImpl) {
                return Boolean.valueOf(dOMConfigurationImpl.cdataSections);
            }

            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public void set(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
                dOMConfigurationImpl.cdataSections = ((Boolean) obj).booleanValue();
            }
        });
        PARAMETERS.put("check-character-normalization", new FixedParameter(false));
        PARAMETERS.put(ContactsContract.StreamItemsColumns.COMMENTS, new BooleanParameter() { // from class: org.apache.harmony.xml.dom.DOMConfigurationImpl.2
            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public Object get(DOMConfigurationImpl dOMConfigurationImpl) {
                return Boolean.valueOf(dOMConfigurationImpl.comments);
            }

            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public void set(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
                dOMConfigurationImpl.comments = ((Boolean) obj).booleanValue();
            }
        });
        PARAMETERS.put("datatype-normalization", new BooleanParameter() { // from class: org.apache.harmony.xml.dom.DOMConfigurationImpl.3
            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public Object get(DOMConfigurationImpl dOMConfigurationImpl) {
                return Boolean.valueOf(dOMConfigurationImpl.datatypeNormalization);
            }

            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public void set(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
                if (!((Boolean) obj).booleanValue()) {
                    dOMConfigurationImpl.datatypeNormalization = false;
                    return;
                }
                dOMConfigurationImpl.datatypeNormalization = true;
                dOMConfigurationImpl.validate = true;
            }
        });
        PARAMETERS.put("element-content-whitespace", new FixedParameter(true));
        PARAMETERS.put(ContactsContract.Contacts.Entity.CONTENT_DIRECTORY, new BooleanParameter() { // from class: org.apache.harmony.xml.dom.DOMConfigurationImpl.4
            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public Object get(DOMConfigurationImpl dOMConfigurationImpl) {
                return Boolean.valueOf(dOMConfigurationImpl.entities);
            }

            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public void set(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
                dOMConfigurationImpl.entities = ((Boolean) obj).booleanValue();
            }
        });
        PARAMETERS.put("error-handler", new Parameter() { // from class: org.apache.harmony.xml.dom.DOMConfigurationImpl.5
            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public boolean canSet(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
                return obj == null || (obj instanceof DOMErrorHandler);
            }

            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public Object get(DOMConfigurationImpl dOMConfigurationImpl) {
                return dOMConfigurationImpl.errorHandler;
            }

            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public void set(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
                dOMConfigurationImpl.errorHandler = (DOMErrorHandler) obj;
            }
        });
        PARAMETERS.put("infoset", new BooleanParameter() { // from class: org.apache.harmony.xml.dom.DOMConfigurationImpl.6
            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public Object get(DOMConfigurationImpl dOMConfigurationImpl) {
                return Boolean.valueOf(!dOMConfigurationImpl.entities && !dOMConfigurationImpl.datatypeNormalization && !dOMConfigurationImpl.cdataSections && dOMConfigurationImpl.wellFormed && dOMConfigurationImpl.comments && dOMConfigurationImpl.namespaces);
            }

            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public void set(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
                if (((Boolean) obj).booleanValue()) {
                    dOMConfigurationImpl.entities = false;
                    dOMConfigurationImpl.datatypeNormalization = false;
                    dOMConfigurationImpl.cdataSections = false;
                    dOMConfigurationImpl.wellFormed = true;
                    dOMConfigurationImpl.comments = true;
                    dOMConfigurationImpl.namespaces = true;
                }
            }
        });
        PARAMETERS.put("namespaces", new BooleanParameter() { // from class: org.apache.harmony.xml.dom.DOMConfigurationImpl.7
            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public Object get(DOMConfigurationImpl dOMConfigurationImpl) {
                return Boolean.valueOf(dOMConfigurationImpl.namespaces);
            }

            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public void set(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
                dOMConfigurationImpl.namespaces = ((Boolean) obj).booleanValue();
            }
        });
        PARAMETERS.put("namespace-declarations", new FixedParameter(true));
        PARAMETERS.put("normalize-characters", new FixedParameter(false));
        PARAMETERS.put("schema-location", new Parameter() { // from class: org.apache.harmony.xml.dom.DOMConfigurationImpl.8
            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public boolean canSet(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
                return obj == null || (obj instanceof String);
            }

            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public Object get(DOMConfigurationImpl dOMConfigurationImpl) {
                return dOMConfigurationImpl.schemaLocation;
            }

            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public void set(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
                dOMConfigurationImpl.schemaLocation = (String) obj;
            }
        });
        PARAMETERS.put("schema-type", new Parameter() { // from class: org.apache.harmony.xml.dom.DOMConfigurationImpl.9
            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public boolean canSet(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
                return obj == null || (obj instanceof String);
            }

            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public Object get(DOMConfigurationImpl dOMConfigurationImpl) {
                return dOMConfigurationImpl.schemaType;
            }

            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public void set(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
                dOMConfigurationImpl.schemaType = (String) obj;
            }
        });
        PARAMETERS.put("split-cdata-sections", new BooleanParameter() { // from class: org.apache.harmony.xml.dom.DOMConfigurationImpl.10
            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public Object get(DOMConfigurationImpl dOMConfigurationImpl) {
                return Boolean.valueOf(dOMConfigurationImpl.splitCdataSections);
            }

            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public void set(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
                dOMConfigurationImpl.splitCdataSections = ((Boolean) obj).booleanValue();
            }
        });
        PARAMETERS.put(c.j, new BooleanParameter() { // from class: org.apache.harmony.xml.dom.DOMConfigurationImpl.11
            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public Object get(DOMConfigurationImpl dOMConfigurationImpl) {
                return Boolean.valueOf(dOMConfigurationImpl.validate);
            }

            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public void set(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
                dOMConfigurationImpl.validate = ((Boolean) obj).booleanValue();
            }
        });
        PARAMETERS.put("validate-if-schema", new FixedParameter(false));
        PARAMETERS.put("well-formed", new BooleanParameter() { // from class: org.apache.harmony.xml.dom.DOMConfigurationImpl.12
            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public Object get(DOMConfigurationImpl dOMConfigurationImpl) {
                return Boolean.valueOf(dOMConfigurationImpl.wellFormed);
            }

            @Override // org.apache.harmony.xml.dom.DOMConfigurationImpl.Parameter
            public void set(DOMConfigurationImpl dOMConfigurationImpl, Object obj) {
                dOMConfigurationImpl.wellFormed = ((Boolean) obj).booleanValue();
            }
        });
    }

    private void checkTextValidity(CharSequence charSequence) {
        if (!this.wellFormed || isValid(charSequence)) {
            return;
        }
        report((short) 2, "wf-invalid-character");
    }

    private boolean isValid(CharSequence charSequence) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= charSequence.length()) {
                return true;
            }
            char charAt = charSequence.charAt(i2);
            if (!(charAt == '\t' || charAt == '\n' || charAt == '\r' || (charAt >= ' ' && charAt <= 55295) || (charAt >= 57344 && charAt <= 65533))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private void report(short s, String str) {
        if (this.errorHandler != null) {
            this.errorHandler.handleError(new DOMErrorImpl(s, str));
        }
    }

    @Override // org.w3c.dom.DOMConfiguration
    public boolean canSetParameter(String str, Object obj) {
        Parameter parameter = PARAMETERS.get(str);
        return parameter != null && parameter.canSet(this, obj);
    }

    @Override // org.w3c.dom.DOMConfiguration
    public Object getParameter(String str) throws DOMException {
        Parameter parameter = PARAMETERS.get(str);
        if (parameter == null) {
            throw new DOMException((short) 8, "No such parameter: " + str);
        }
        return parameter.get(this);
    }

    @Override // org.w3c.dom.DOMConfiguration
    public DOMStringList getParameterNames() {
        final String[] strArr = (String[]) PARAMETERS.keySet().toArray(new String[PARAMETERS.size()]);
        return new DOMStringList() { // from class: org.apache.harmony.xml.dom.DOMConfigurationImpl.13
            @Override // org.w3c.dom.DOMStringList
            public boolean contains(String str) {
                return DOMConfigurationImpl.PARAMETERS.containsKey(str);
            }

            @Override // org.w3c.dom.DOMStringList
            public int getLength() {
                return strArr.length;
            }

            @Override // org.w3c.dom.DOMStringList
            public String item(int i) {
                if (i < strArr.length) {
                    return strArr[i];
                }
                return null;
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0136 A[LOOP:1: B:39:0x0132->B:41:0x0136, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0099 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void normalize(org.w3c.dom.Node r7) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.harmony.xml.dom.DOMConfigurationImpl.normalize(org.w3c.dom.Node):void");
    }

    @Override // org.w3c.dom.DOMConfiguration
    public void setParameter(String str, Object obj) throws DOMException {
        Parameter parameter = PARAMETERS.get(str);
        if (parameter == null) {
            throw new DOMException((short) 8, "No such parameter: " + str);
        }
        try {
            parameter.set(this, obj);
        } catch (ClassCastException e) {
            throw new DOMException((short) 17, "Invalid type for " + str + ": " + obj.getClass());
        } catch (NullPointerException e2) {
            throw new DOMException((short) 17, "Null not allowed for " + str);
        }
    }
}
