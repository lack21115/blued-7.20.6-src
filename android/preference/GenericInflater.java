package android.preference;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.preference.GenericInflater.Parent;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/preference/GenericInflater.class */
public abstract class GenericInflater<T, P extends Parent> {
    private static final Class[] mConstructorSignature = {Context.class, AttributeSet.class};
    private static final HashMap sConstructorMap = new HashMap();
    private final boolean DEBUG;
    private final Object[] mConstructorArgs;
    protected final Context mContext;
    private String mDefaultPackage;
    private Factory<T> mFactory;
    private boolean mFactorySet;

    /* loaded from: source-9557208-dex2jar.jar:android/preference/GenericInflater$Factory.class */
    public interface Factory<T> {
        T onCreateItem(String str, Context context, AttributeSet attributeSet);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/preference/GenericInflater$FactoryMerger.class */
    private static class FactoryMerger<T> implements Factory<T> {
        private final Factory<T> mF1;
        private final Factory<T> mF2;

        FactoryMerger(Factory<T> factory, Factory<T> factory2) {
            this.mF1 = factory;
            this.mF2 = factory2;
        }

        @Override // android.preference.GenericInflater.Factory
        public T onCreateItem(String str, Context context, AttributeSet attributeSet) {
            T onCreateItem = this.mF1.onCreateItem(str, context, attributeSet);
            return onCreateItem != null ? onCreateItem : this.mF2.onCreateItem(str, context, attributeSet);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/preference/GenericInflater$Parent.class */
    public interface Parent<T> {
        void addItemFromInflater(T t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GenericInflater(Context context) {
        this.DEBUG = false;
        this.mConstructorArgs = new Object[2];
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GenericInflater(GenericInflater<T, P> genericInflater, Context context) {
        this.DEBUG = false;
        this.mConstructorArgs = new Object[2];
        this.mContext = context;
        this.mFactory = genericInflater.mFactory;
    }

    private final T createItemFromTag(XmlPullParser xmlPullParser, String str, AttributeSet attributeSet) {
        T t = null;
        try {
            if (this.mFactory != null) {
                t = this.mFactory.onCreateItem(str, this.mContext, attributeSet);
            }
            return t == null ? -1 == str.indexOf(46) ? onCreateItem(str, attributeSet) : createItem(str, null, attributeSet) : t;
        } catch (InflateException e) {
            throw e;
        } catch (ClassNotFoundException e2) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e2);
            throw inflateException;
        } catch (Exception e3) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e3);
            throw inflateException2;
        }
    }

    private void rInflate(XmlPullParser xmlPullParser, T t, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2 && !onCreateCustomFromTag(xmlPullParser, t, attributeSet)) {
                T createItemFromTag = createItemFromTag(xmlPullParser, xmlPullParser.getName(), attributeSet);
                ((Parent) t).addItemFromInflater(createItemFromTag);
                rInflate(xmlPullParser, createItemFromTag, attributeSet);
            }
        }
    }

    public abstract GenericInflater cloneInContext(Context context);

    public final T createItem(String str, String str2, AttributeSet attributeSet) throws ClassNotFoundException, InflateException {
        Constructor<?> constructor;
        Constructor<?> constructor2 = (Constructor) sConstructorMap.get(str);
        Constructor<?> constructor3 = constructor2;
        if (constructor2 == null) {
            constructor = constructor2;
            try {
                constructor3 = this.mContext.getClassLoader().loadClass(str2 != null ? str2 + str : str).getConstructor(mConstructorSignature);
                sConstructorMap.put(str, constructor3);
            } catch (ClassNotFoundException e) {
                throw e;
            } catch (NoSuchMethodException e2) {
                StringBuilder append = new StringBuilder().append(attributeSet.getPositionDescription()).append(": Error inflating class ");
                String str3 = str;
                if (str2 != null) {
                    str3 = str2 + str;
                }
                InflateException inflateException = new InflateException(append.append(str3).toString());
                inflateException.initCause(e2);
                throw inflateException;
            } catch (Exception e3) {
                InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + constructor.getClass().getName());
                inflateException2.initCause(e3);
                throw inflateException2;
            }
        }
        Constructor<?> constructor4 = constructor3;
        Object[] objArr = this.mConstructorArgs;
        objArr[1] = attributeSet;
        constructor = constructor3;
        return (T) constructor3.newInstance(objArr);
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDefaultPackage() {
        return this.mDefaultPackage;
    }

    public final Factory<T> getFactory() {
        return this.mFactory;
    }

    public T inflate(int i, P p) {
        return inflate(i, (int) p, p != null);
    }

    public T inflate(int i, P p, boolean z) {
        XmlResourceParser xml = getContext().getResources().getXml(i);
        try {
            return inflate((XmlPullParser) xml, (XmlResourceParser) p, z);
        } finally {
            xml.close();
        }
    }

    public T inflate(XmlPullParser xmlPullParser, P p) {
        return inflate(xmlPullParser, (XmlPullParser) p, p != null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T inflate(XmlPullParser xmlPullParser, P p, boolean z) {
        int next;
        T t;
        synchronized (this.mConstructorArgs) {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            this.mConstructorArgs[0] = this.mContext;
            do {
                try {
                    try {
                        next = xmlPullParser.next();
                        if (next == 2) {
                            break;
                        }
                    } catch (IOException e) {
                        InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e.getMessage());
                        inflateException.initCause(e);
                        throw inflateException;
                    } catch (XmlPullParserException e2) {
                        InflateException inflateException2 = new InflateException(e2.getMessage());
                        inflateException2.initCause(e2);
                        throw inflateException2;
                    }
                } catch (InflateException e3) {
                    throw e3;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
            }
            t = (T) onMergeRoots(p, z, (Parent) createItemFromTag(xmlPullParser, xmlPullParser.getName(), asAttributeSet));
            rInflate(xmlPullParser, t, asAttributeSet);
        }
        return t;
    }

    protected boolean onCreateCustomFromTag(XmlPullParser xmlPullParser, T t, AttributeSet attributeSet) throws XmlPullParserException {
        return false;
    }

    protected T onCreateItem(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        return createItem(str, this.mDefaultPackage, attributeSet);
    }

    protected P onMergeRoots(P p, boolean z, P p2) {
        return p2;
    }

    public void setDefaultPackage(String str) {
        this.mDefaultPackage = str;
    }

    public void setFactory(Factory<T> factory) {
        if (this.mFactorySet) {
            throw new IllegalStateException("A factory has already been set on this inflater");
        }
        if (factory == null) {
            throw new NullPointerException("Given factory can not be null");
        }
        this.mFactorySet = true;
        if (this.mFactory == null) {
            this.mFactory = factory;
        } else {
            this.mFactory = new FactoryMerger(factory, this.mFactory);
        }
    }
}
