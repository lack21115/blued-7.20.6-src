package java.text;

import java.io.InvalidObjectException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Set;

/* loaded from: source-2895416-dex2jar.jar:java/text/AttributedCharacterIterator.class */
public interface AttributedCharacterIterator extends CharacterIterator {

    /* loaded from: source-2895416-dex2jar.jar:java/text/AttributedCharacterIterator$Attribute.class */
    public static class Attribute implements Serializable {
        public static final Attribute INPUT_METHOD_SEGMENT = new Attribute("input_method_segment");
        public static final Attribute LANGUAGE = new Attribute("language");
        public static final Attribute READING = new Attribute("reading");
        private static final long serialVersionUID = -9142742483513960612L;
        private String name;

        /* JADX INFO: Access modifiers changed from: protected */
        public Attribute(String str) {
            this.name = str;
        }

        public final boolean equals(Object obj) {
            return this == obj;
        }

        protected String getName() {
            return this.name;
        }

        public final int hashCode() {
            return super.hashCode();
        }

        protected Object readResolve() throws InvalidObjectException {
            try {
                Field[] fields = getClass().getFields();
                int length = fields.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    Field field = fields[i2];
                    if (field.getType() == getClass() && Modifier.isStatic(field.getModifiers())) {
                        Attribute attribute = (Attribute) field.get(null);
                        if (this.name.equals(attribute.name)) {
                            return attribute;
                        }
                    }
                    i = i2 + 1;
                }
            } catch (IllegalAccessException e) {
            }
            throw new InvalidObjectException("Failed to resolve " + this);
        }

        public String toString() {
            return getClass().getName() + '(' + getName() + ')';
        }
    }

    Set<Attribute> getAllAttributeKeys();

    Object getAttribute(Attribute attribute);

    Map<Attribute, Object> getAttributes();

    int getRunLimit();

    int getRunLimit(Attribute attribute);

    int getRunLimit(Set<? extends Attribute> set);

    int getRunStart();

    int getRunStart(Attribute attribute);

    int getRunStart(Set<? extends Attribute> set);
}
