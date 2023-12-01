package android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.android.internal.R;
import com.anythink.expressad.a;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/view/LayoutInflater.class */
public abstract class LayoutInflater {
    private static final int[] ATTRS_THEME = null;
    private static final boolean DEBUG = false;
    private static final String TAG = null;
    private static final String TAG_1995 = "blink";
    private static final String TAG_INCLUDE = "include";
    private static final String TAG_MERGE = "merge";
    private static final String TAG_REQUEST_FOCUS = "requestFocus";
    private static final String TAG_TAG = "tag";
    static final Class<?>[] mConstructorSignature = null;
    private static final HashMap<String, Constructor<? extends View>> sConstructorMap = null;
    final Object[] mConstructorArgs;
    protected final Context mContext;
    private Factory mFactory;
    private Factory2 mFactory2;
    private boolean mFactorySet;
    private Filter mFilter;
    private HashMap<String, Boolean> mFilterMap;
    private Factory2 mPrivateFactory;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/LayoutInflater$BlinkLayout.class */
    public static class BlinkLayout extends FrameLayout {
        private static final int BLINK_DELAY = 500;
        private static final int MESSAGE_BLINK = 66;
        private boolean mBlink;
        private boolean mBlinkState;
        private final Handler mHandler;

        public BlinkLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mHandler = new Handler(new Handler.Callback() { // from class: android.view.LayoutInflater.BlinkLayout.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    boolean z = false;
                    if (message.what == 66) {
                        if (BlinkLayout.this.mBlink) {
                            BlinkLayout blinkLayout = BlinkLayout.this;
                            if (!BlinkLayout.this.mBlinkState) {
                                z = true;
                            }
                            blinkLayout.mBlinkState = z;
                            BlinkLayout.this.makeBlink();
                        }
                        BlinkLayout.this.invalidate();
                        return true;
                    }
                    return false;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void makeBlink() {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(66), 500L);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            if (this.mBlinkState) {
                super.dispatchDraw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.mBlink = true;
            this.mBlinkState = true;
            makeBlink();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.mBlink = false;
            this.mBlinkState = true;
            this.mHandler.removeMessages(66);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/view/LayoutInflater$Factory.class */
    public interface Factory {
        View onCreateView(String str, Context context, AttributeSet attributeSet);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/view/LayoutInflater$Factory2.class */
    public interface Factory2 extends Factory {
        View onCreateView(View view, String str, Context context, AttributeSet attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/LayoutInflater$FactoryMerger.class */
    public static class FactoryMerger implements Factory2 {
        private final Factory mF1;
        private final Factory2 mF12;
        private final Factory mF2;
        private final Factory2 mF22;

        FactoryMerger(Factory factory, Factory2 factory2, Factory factory3, Factory2 factory22) {
            this.mF1 = factory;
            this.mF2 = factory3;
            this.mF12 = factory2;
            this.mF22 = factory22;
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            View onCreateView = this.mF12 != null ? this.mF12.onCreateView(view, str, context, attributeSet) : this.mF1.onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
            return this.mF22 != null ? this.mF22.onCreateView(view, str, context, attributeSet) : this.mF2.onCreateView(str, context, attributeSet);
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            View onCreateView = this.mF1.onCreateView(str, context, attributeSet);
            return onCreateView != null ? onCreateView : this.mF2.onCreateView(str, context, attributeSet);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/view/LayoutInflater$Filter.class */
    public interface Filter {
        boolean onLoadClass(Class cls);
    }

    static {
        throw new VerifyError("bad dex opcode");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutInflater(Context context) {
        this.mConstructorArgs = new Object[2];
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutInflater(LayoutInflater layoutInflater, Context context) {
        this.mConstructorArgs = new Object[2];
        this.mContext = context;
        this.mFactory = layoutInflater.mFactory;
        this.mFactory2 = layoutInflater.mFactory2;
        this.mPrivateFactory = layoutInflater.mPrivateFactory;
        setFilter(layoutInflater.mFilter);
    }

    private void failNotAllowed(String str, String str2, AttributeSet attributeSet) {
        StringBuilder append = new StringBuilder().append(attributeSet.getPositionDescription()).append(": Class not allowed to be inflated ");
        String str3 = str;
        if (str2 != null) {
            str3 = str2 + str;
        }
        throw new InflateException(append.append(str3).toString());
    }

    public static LayoutInflater from(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater == null) {
            throw new AssertionError("LayoutInflater not found.");
        }
        return layoutInflater;
    }

    private void parseInclude(XmlPullParser xmlPullParser, View view, AttributeSet attributeSet, boolean z) throws XmlPullParserException, IOException {
        int next;
        int next2;
        if (!(view instanceof ViewGroup)) {
            throw new InflateException("<include /> can only be used inside of a ViewGroup");
        }
        int attributeResourceValue = attributeSet.getAttributeResourceValue(null, "layout", 0);
        if (attributeResourceValue == 0) {
            String attributeValue = attributeSet.getAttributeValue(null, "layout");
            if (attributeValue != null) {
                throw new InflateException("You must specifiy a valid layout reference. The layout ID " + attributeValue + " is not valid.");
            }
            throw new InflateException("You must specifiy a layout in the include tag: <include layout=\"@layout/layoutID\" />");
        }
        XmlResourceParser layout = getContext().getResources().getLayout(attributeResourceValue);
        try {
            AttributeSet asAttributeSet = Xml.asAttributeSet(layout);
            do {
                next = layout.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(layout.getPositionDescription() + ": No start tag found!");
            }
            String name = layout.getName();
            if (TAG_MERGE.equals(name)) {
                rInflate(layout, view, asAttributeSet, false, z);
            } else {
                View createViewFromTag = createViewFromTag(view, name, asAttributeSet, z);
                ViewGroup viewGroup = (ViewGroup) view;
                try {
                    ViewGroup.LayoutParams generateLayoutParams = viewGroup.generateLayoutParams(attributeSet);
                    if (generateLayoutParams != null) {
                        createViewFromTag.setLayoutParams(generateLayoutParams);
                    }
                } catch (RuntimeException e) {
                    ViewGroup.LayoutParams generateLayoutParams2 = viewGroup.generateLayoutParams(asAttributeSet);
                    if (generateLayoutParams2 != null) {
                        createViewFromTag.setLayoutParams(generateLayoutParams2);
                    }
                }
                rInflate(layout, createViewFromTag, asAttributeSet, true, true);
                TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.View, 0, 0);
                int resourceId = obtainStyledAttributes.getResourceId(9, -1);
                int i = obtainStyledAttributes.getInt(21, -1);
                obtainStyledAttributes.recycle();
                if (resourceId != -1) {
                    createViewFromTag.setId(resourceId);
                }
                switch (i) {
                    case 0:
                        createViewFromTag.setVisibility(0);
                        break;
                    case 1:
                        createViewFromTag.setVisibility(4);
                        break;
                    case 2:
                        createViewFromTag.setVisibility(8);
                        break;
                }
                viewGroup.addView(createViewFromTag);
            }
            layout.close();
            int depth = xmlPullParser.getDepth();
            do {
                next2 = xmlPullParser.next();
                if (next2 == 3 && xmlPullParser.getDepth() <= depth) {
                    return;
                }
            } while (next2 != 1);
        } catch (Throwable th) {
            layout.close();
            throw th;
        }
    }

    private void parseRequestFocus(XmlPullParser xmlPullParser, View view) throws XmlPullParserException, IOException {
        int next;
        view.requestFocus();
        int depth = xmlPullParser.getDepth();
        do {
            next = xmlPullParser.next();
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        } while (next != 1);
    }

    private void parseViewTag(XmlPullParser xmlPullParser, View view, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int next;
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.ViewTag);
        view.setTag(obtainStyledAttributes.getResourceId(1, 0), obtainStyledAttributes.getText(0));
        obtainStyledAttributes.recycle();
        int depth = xmlPullParser.getDepth();
        do {
            next = xmlPullParser.next();
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        } while (next != 1);
    }

    public abstract LayoutInflater cloneInContext(Context context);

    public final View createView(String str, String str2, AttributeSet attributeSet) throws ClassNotFoundException, InflateException {
        Class cls;
        Constructor<? extends View> constructor;
        Constructor<? extends View> constructor2 = sConstructorMap.get(str);
        Class cls2 = null;
        try {
            try {
                try {
                    try {
                        Trace.traceBegin(8L, str);
                        if (constructor2 == null) {
                            cls = this.mContext.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class);
                            if (this.mFilter != null && cls != null && !this.mFilter.onLoadClass(cls)) {
                                failNotAllowed(str, str2, attributeSet);
                            }
                            constructor = cls.getConstructor(mConstructorSignature);
                            sConstructorMap.put(str, constructor);
                        } else {
                            cls = null;
                            constructor = constructor2;
                            if (this.mFilter != null) {
                                Boolean bool = this.mFilterMap.get(str);
                                if (bool == null) {
                                    Class asSubclass = this.mContext.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class);
                                    boolean z = asSubclass != null && this.mFilter.onLoadClass(asSubclass);
                                    this.mFilterMap.put(str, Boolean.valueOf(z));
                                    cls = asSubclass;
                                    constructor = constructor2;
                                    if (!z) {
                                        failNotAllowed(str, str2, attributeSet);
                                        cls = asSubclass;
                                        constructor = constructor2;
                                    }
                                } else {
                                    cls = null;
                                    constructor = constructor2;
                                    if (bool.equals(Boolean.FALSE)) {
                                        failNotAllowed(str, str2, attributeSet);
                                        cls = null;
                                        constructor = constructor2;
                                    }
                                }
                            }
                        }
                        Class cls3 = cls;
                        Object[] objArr = this.mConstructorArgs;
                        objArr[1] = attributeSet;
                        constructor.setAccessible(true);
                        Class cls4 = cls;
                        View newInstance = constructor.newInstance(objArr);
                        Class cls5 = cls;
                        if (newInstance instanceof ViewStub) {
                            cls2 = cls;
                            ((ViewStub) newInstance).setLayoutInflater(cloneInContext((Context) objArr[0]));
                        }
                        Trace.traceEnd(8L);
                        return newInstance;
                    } catch (ClassCastException e) {
                        StringBuilder append = new StringBuilder().append(attributeSet.getPositionDescription()).append(": Class is not a View ");
                        String str3 = str;
                        if (str2 != null) {
                            str3 = str2 + str;
                        }
                        InflateException inflateException = new InflateException(append.append(str3).toString());
                        inflateException.initCause(e);
                        throw inflateException;
                    } catch (ClassNotFoundException e2) {
                        throw e2;
                    }
                } catch (NoSuchMethodException e3) {
                    StringBuilder append2 = new StringBuilder().append(attributeSet.getPositionDescription()).append(": Error inflating class ");
                    String str4 = str;
                    if (str2 != null) {
                        str4 = str2 + str;
                    }
                    InflateException inflateException2 = new InflateException(append2.append(str4).toString());
                    inflateException2.initCause(e3);
                    throw inflateException2;
                }
            } catch (Exception e4) {
                InflateException inflateException3 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + (cls2 == null ? "<unknown>" : cls2.getName()));
                inflateException3.initCause(e4);
                throw inflateException3;
            }
        } catch (Throwable th) {
            Trace.traceEnd(8L);
            throw th;
        }
    }

    View createViewFromTag(View view, String str, AttributeSet attributeSet, boolean z) {
        BlinkLayout blinkLayout;
        String str2 = str;
        if (str.equals(a.B)) {
            str2 = attributeSet.getAttributeValue(null, "class");
        }
        Context context = (view == null || !z) ? this.mContext : view.getContext();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS_THEME);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        ContextThemeWrapper contextThemeWrapper = context;
        if (resourceId != 0) {
            contextThemeWrapper = new ContextThemeWrapper(context, resourceId);
        }
        obtainStyledAttributes.recycle();
        if (str2.equals(TAG_1995)) {
            blinkLayout = new BlinkLayout(contextThemeWrapper, attributeSet);
        } else {
            try {
                BlinkLayout onCreateView = this.mFactory2 != null ? this.mFactory2.onCreateView(view, str2, contextThemeWrapper, attributeSet) : this.mFactory != null ? this.mFactory.onCreateView(str2, contextThemeWrapper, attributeSet) : null;
                BlinkLayout blinkLayout2 = onCreateView;
                if (onCreateView == null) {
                    blinkLayout2 = onCreateView;
                    if (this.mPrivateFactory != null) {
                        blinkLayout2 = this.mPrivateFactory.onCreateView(view, str2, contextThemeWrapper, attributeSet);
                    }
                }
                blinkLayout = blinkLayout2;
                if (blinkLayout2 == null) {
                    Object obj = this.mConstructorArgs[0];
                    this.mConstructorArgs[0] = contextThemeWrapper;
                    try {
                        View onCreateView2 = -1 == str2.indexOf(46) ? onCreateView(view, str2, attributeSet) : createView(str2, null, attributeSet);
                        this.mConstructorArgs[0] = obj;
                        return onCreateView2;
                    } catch (Throwable th) {
                        this.mConstructorArgs[0] = obj;
                        throw th;
                    }
                }
            } catch (InflateException e) {
                throw e;
            } catch (ClassNotFoundException e2) {
                InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str2);
                inflateException.initCause(e2);
                throw inflateException;
            } catch (Exception e3) {
                InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str2);
                inflateException2.initCause(e3);
                throw inflateException2;
            }
        }
        return blinkLayout;
    }

    public Context getContext() {
        return this.mContext;
    }

    public final Factory getFactory() {
        return this.mFactory;
    }

    public final Factory2 getFactory2() {
        return this.mFactory2;
    }

    public Filter getFilter() {
        return this.mFilter;
    }

    public View inflate(int i, ViewGroup viewGroup) {
        return inflate(i, viewGroup, viewGroup != null);
    }

    public View inflate(int i, ViewGroup viewGroup, boolean z) {
        XmlResourceParser layout = getContext().getResources().getLayout(i);
        try {
            return inflate(layout, viewGroup, z);
        } finally {
            layout.close();
        }
    }

    public View inflate(XmlPullParser xmlPullParser, ViewGroup viewGroup) {
        return inflate(xmlPullParser, viewGroup, viewGroup != null);
    }

    public View inflate(XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z) {
        View view;
        int next;
        synchronized (this.mConstructorArgs) {
            Trace.traceBegin(8L, "inflate");
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            Context context = (Context) this.mConstructorArgs[0];
            this.mConstructorArgs[0] = this.mContext;
            view = viewGroup;
            do {
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
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
            }
            String name = xmlPullParser.getName();
            if (!TAG_MERGE.equals(name)) {
                View createViewFromTag = createViewFromTag(viewGroup, name, asAttributeSet, false);
                ViewGroup.LayoutParams layoutParams = null;
                if (viewGroup != null) {
                    ViewGroup.LayoutParams generateLayoutParams = viewGroup.generateLayoutParams(asAttributeSet);
                    layoutParams = generateLayoutParams;
                    if (!z) {
                        createViewFromTag.setLayoutParams(generateLayoutParams);
                        layoutParams = generateLayoutParams;
                    }
                }
                rInflate(xmlPullParser, createViewFromTag, asAttributeSet, true, true);
                if (viewGroup != null && z) {
                    viewGroup.addView(createViewFromTag, layoutParams);
                }
                if (viewGroup == null || !z) {
                    view = createViewFromTag;
                }
            } else if (viewGroup == null || !z) {
                throw new InflateException("<merge /> can be used only with a valid ViewGroup root and attachToRoot=true");
            } else {
                rInflate(xmlPullParser, viewGroup, asAttributeSet, false, false);
            }
            this.mConstructorArgs[0] = context;
            this.mConstructorArgs[1] = null;
            Trace.traceEnd(8L);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(View view, String str, AttributeSet attributeSet) throws ClassNotFoundException {
        return onCreateView(str, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        return createView(str, "android.view.", attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cd, code lost:
        if (r11 == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d0, code lost:
        r9.onFinishInflate();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d4, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void rInflate(org.xmlpull.v1.XmlPullParser r8, android.view.View r9, android.util.AttributeSet r10, boolean r11, boolean r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r7 = this;
            r0 = r8
            int r0 = r0.getDepth()
            r13 = r0
        L8:
            r0 = r8
            int r0 = r0.next()
            r14 = r0
            r0 = r14
            r1 = 3
            if (r0 != r1) goto L21
            r0 = r8
            int r0 = r0.getDepth()
            r1 = r13
            if (r0 <= r1) goto Lcb
        L21:
            r0 = r14
            r1 = 1
            if (r0 == r1) goto Lcb
            r0 = r14
            r1 = 2
            if (r0 != r1) goto L8
            r0 = r8
            java.lang.String r0 = r0.getName()
            r15 = r0
            java.lang.String r0 = "requestFocus"
            r1 = r15
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L48
            r0 = r7
            r1 = r8
            r2 = r9
            r0.parseRequestFocus(r1, r2)
            goto L8
        L48:
            java.lang.String r0 = "tag"
            r1 = r15
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L5c
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r0.parseViewTag(r1, r2, r3)
            goto L8
        L5c:
            java.lang.String r0 = "include"
            r1 = r15
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L86
            r0 = r8
            int r0 = r0.getDepth()
            if (r0 != 0) goto L7a
            android.view.InflateException r0 = new android.view.InflateException
            r1 = r0
            java.lang.String r2 = "<include /> cannot be the root element"
            r1.<init>(r2)
            throw r0
        L7a:
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r12
            r0.parseInclude(r1, r2, r3, r4)
            goto L8
        L86:
            java.lang.String r0 = "merge"
            r1 = r15
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L9b
            android.view.InflateException r0 = new android.view.InflateException
            r1 = r0
            java.lang.String r2 = "<merge /> must be the root element"
            r1.<init>(r2)
            throw r0
        L9b:
            r0 = r7
            r1 = r9
            r2 = r15
            r3 = r10
            r4 = r12
            android.view.View r0 = r0.createViewFromTag(r1, r2, r3, r4)
            r15 = r0
            r0 = r9
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r16 = r0
            r0 = r16
            r1 = r10
            android.view.ViewGroup$LayoutParams r0 = r0.generateLayoutParams(r1)
            r17 = r0
            r0 = r7
            r1 = r8
            r2 = r15
            r3 = r10
            r4 = 1
            r5 = 1
            r0.rInflate(r1, r2, r3, r4, r5)
            r0 = r16
            r1 = r15
            r2 = r17
            r0.addView(r1, r2)
            goto L8
        Lcb:
            r0 = r11
            if (r0 == 0) goto Ld4
            r0 = r9
            r0.onFinishInflate()
        Ld4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.LayoutInflater.rInflate(org.xmlpull.v1.XmlPullParser, android.view.View, android.util.AttributeSet, boolean, boolean):void");
    }

    public void setFactory(Factory factory) {
        if (this.mFactorySet) {
            throw new IllegalStateException("A factory has already been set on this LayoutInflater");
        }
        if (factory == null) {
            throw new NullPointerException("Given factory can not be null");
        }
        this.mFactorySet = true;
        if (this.mFactory == null) {
            this.mFactory = factory;
        } else {
            this.mFactory = new FactoryMerger(factory, null, this.mFactory, this.mFactory2);
        }
    }

    public void setFactory2(Factory2 factory2) {
        if (this.mFactorySet) {
            throw new IllegalStateException("A factory has already been set on this LayoutInflater");
        }
        if (factory2 == null) {
            throw new NullPointerException("Given factory can not be null");
        }
        this.mFactorySet = true;
        if (this.mFactory == null) {
            this.mFactory2 = factory2;
            this.mFactory = factory2;
            return;
        }
        FactoryMerger factoryMerger = new FactoryMerger(factory2, factory2, this.mFactory, this.mFactory2);
        this.mFactory2 = factoryMerger;
        this.mFactory = factoryMerger;
    }

    public void setFilter(Filter filter) {
        this.mFilter = filter;
        if (filter != null) {
            this.mFilterMap = new HashMap<>();
        }
    }

    public void setPrivateFactory(Factory2 factory2) {
        if (this.mPrivateFactory == null) {
            this.mPrivateFactory = factory2;
        } else {
            this.mPrivateFactory = new FactoryMerger(factory2, factory2, this.mPrivateFactory, this.mPrivateFactory);
        }
    }
}
