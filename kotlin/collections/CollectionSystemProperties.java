package kotlin.collections;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/CollectionSystemProperties.class */
public final class CollectionSystemProperties {
    public static final CollectionSystemProperties a = new CollectionSystemProperties();
    public static final boolean b;

    static {
        String property = System.getProperty("kotlin.collections.convert_arg_to_set_in_removeAll");
        b = property != null ? Boolean.parseBoolean(property) : false;
    }

    private CollectionSystemProperties() {
    }
}
