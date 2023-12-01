package kotlin.jvm.internal;

/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/MutablePropertyReference1Impl.class */
public class MutablePropertyReference1Impl extends MutablePropertyReference1 {
    public MutablePropertyReference1Impl(Class cls, String str, String str2, int i) {
        super(NO_RECEIVER, cls, str, str2, i);
    }

    public Object a(Object obj) {
        return a().call(obj);
    }
}
