package kotlin.collections;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/CollectionSystemProperties.class */
public final class CollectionSystemProperties {

    /* renamed from: a  reason: collision with root package name */
    public static final CollectionSystemProperties f42371a = new CollectionSystemProperties();
    public static final boolean b;

    static {
        String property = System.getProperty("kotlin.collections.convert_arg_to_set_in_removeAll");
        b = property != null ? Boolean.parseBoolean(property) : false;
    }

    private CollectionSystemProperties() {
    }
}
