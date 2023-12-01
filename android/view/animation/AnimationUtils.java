package android.view.animation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Xml;
import com.android.internal.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-4181928-dex2jar.jar:android/view/animation/AnimationUtils.class */
public class AnimationUtils {
    private static final int SEQUENTIALLY = 1;
    private static final int TOGETHER = 0;

    private static Animation createAnimationFromXml(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return createAnimationFromXml(context, xmlPullParser, null, Xml.asAttributeSet(xmlPullParser));
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00f0, code lost:
        return r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.view.animation.Animation createAnimationFromXml(android.content.Context r5, org.xmlpull.v1.XmlPullParser r6, android.view.animation.AnimationSet r7, android.util.AttributeSet r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.animation.AnimationUtils.createAnimationFromXml(android.content.Context, org.xmlpull.v1.XmlPullParser, android.view.animation.AnimationSet, android.util.AttributeSet):android.view.animation.Animation");
    }

    private static Interpolator createInterpolatorFromXml(Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Interpolator interpolator = null;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
                    String name = xmlPullParser.getName();
                    if (name.equals("linearInterpolator")) {
                        interpolator = new LinearInterpolator();
                    } else if (name.equals("accelerateInterpolator")) {
                        interpolator = new AccelerateInterpolator(resources, theme, asAttributeSet);
                    } else if (name.equals("decelerateInterpolator")) {
                        interpolator = new DecelerateInterpolator(resources, theme, asAttributeSet);
                    } else if (name.equals("accelerateDecelerateInterpolator")) {
                        interpolator = new AccelerateDecelerateInterpolator();
                    } else if (name.equals("cycleInterpolator")) {
                        interpolator = new CycleInterpolator(resources, theme, asAttributeSet);
                    } else if (name.equals("anticipateInterpolator")) {
                        interpolator = new AnticipateInterpolator(resources, theme, asAttributeSet);
                    } else if (name.equals("overshootInterpolator")) {
                        interpolator = new OvershootInterpolator(resources, theme, asAttributeSet);
                    } else if (name.equals("anticipateOvershootInterpolator")) {
                        interpolator = new AnticipateOvershootInterpolator(resources, theme, asAttributeSet);
                    } else if (name.equals("bounceInterpolator")) {
                        interpolator = new BounceInterpolator();
                    } else if (!name.equals("pathInterpolator")) {
                        throw new RuntimeException("Unknown interpolator name: " + xmlPullParser.getName());
                    } else {
                        interpolator = new PathInterpolator(resources, theme, asAttributeSet);
                    }
                }
            }
        }
        return interpolator;
    }

    private static LayoutAnimationController createLayoutAnimationFromXml(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return createLayoutAnimationFromXml(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
    }

    private static LayoutAnimationController createLayoutAnimationFromXml(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        GridLayoutAnimationController gridLayoutAnimationController = null;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if ("layoutAnimation".equals(name)) {
                        gridLayoutAnimationController = new LayoutAnimationController(context, attributeSet);
                    } else if (!"gridLayoutAnimation".equals(name)) {
                        throw new RuntimeException("Unknown layout animation name: " + name);
                    } else {
                        gridLayoutAnimationController = new GridLayoutAnimationController(context, attributeSet);
                    }
                }
            }
        }
        return gridLayoutAnimationController;
    }

    public static long currentAnimationTimeMillis() {
        return SystemClock.uptimeMillis();
    }

    public static Animation loadAnimation(Context context, int i) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        XmlResourceParser xmlResourceParser2 = null;
        XmlResourceParser xmlResourceParser3 = null;
        try {
            try {
                try {
                    XmlResourceParser animation = context.getResources().getAnimation(i);
                    xmlResourceParser3 = animation;
                    xmlResourceParser = animation;
                    xmlResourceParser2 = animation;
                    Animation createAnimationFromXml = createAnimationFromXml(context, animation);
                    if (animation != null) {
                        animation.close();
                    }
                    return createAnimationFromXml;
                } catch (IOException e) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    XmlResourceParser xmlResourceParser4 = xmlResourceParser2;
                    notFoundException.initCause(e);
                    XmlResourceParser xmlResourceParser5 = xmlResourceParser2;
                    throw notFoundException;
                }
            } catch (XmlPullParserException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                XmlResourceParser xmlResourceParser6 = xmlResourceParser3;
                notFoundException2.initCause(e2);
                XmlResourceParser xmlResourceParser7 = xmlResourceParser3;
                throw notFoundException2;
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    public static Interpolator loadInterpolator(Context context, int i) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        XmlResourceParser xmlResourceParser2 = null;
        XmlResourceParser xmlResourceParser3 = null;
        try {
            try {
                XmlResourceParser animation = context.getResources().getAnimation(i);
                xmlResourceParser3 = animation;
                xmlResourceParser = animation;
                xmlResourceParser2 = animation;
                Interpolator createInterpolatorFromXml = createInterpolatorFromXml(context.getResources(), context.getTheme(), animation);
                if (animation != null) {
                    animation.close();
                }
                return createInterpolatorFromXml;
            } catch (IOException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                XmlResourceParser xmlResourceParser4 = xmlResourceParser2;
                notFoundException.initCause(e);
                XmlResourceParser xmlResourceParser5 = xmlResourceParser2;
                throw notFoundException;
            } catch (XmlPullParserException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                XmlResourceParser xmlResourceParser6 = xmlResourceParser3;
                notFoundException2.initCause(e2);
                XmlResourceParser xmlResourceParser7 = xmlResourceParser3;
                throw notFoundException2;
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    public static Interpolator loadInterpolator(Resources resources, Resources.Theme theme, int i) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        XmlResourceParser xmlResourceParser2 = null;
        XmlResourceParser xmlResourceParser3 = null;
        try {
            try {
                try {
                    XmlResourceParser animation = resources.getAnimation(i);
                    xmlResourceParser3 = animation;
                    xmlResourceParser = animation;
                    xmlResourceParser2 = animation;
                    Interpolator createInterpolatorFromXml = createInterpolatorFromXml(resources, theme, animation);
                    if (animation != null) {
                        animation.close();
                    }
                    return createInterpolatorFromXml;
                } catch (IOException e) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    XmlResourceParser xmlResourceParser4 = xmlResourceParser2;
                    notFoundException.initCause(e);
                    XmlResourceParser xmlResourceParser5 = xmlResourceParser2;
                    throw notFoundException;
                }
            } catch (XmlPullParserException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                XmlResourceParser xmlResourceParser6 = xmlResourceParser3;
                notFoundException2.initCause(e2);
                XmlResourceParser xmlResourceParser7 = xmlResourceParser3;
                throw notFoundException2;
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    public static LayoutAnimationController loadLayoutAnimation(Context context, int i) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        XmlResourceParser xmlResourceParser2 = null;
        XmlResourceParser xmlResourceParser3 = null;
        try {
            try {
                try {
                    XmlResourceParser animation = context.getResources().getAnimation(i);
                    xmlResourceParser3 = animation;
                    xmlResourceParser = animation;
                    xmlResourceParser2 = animation;
                    LayoutAnimationController createLayoutAnimationFromXml = createLayoutAnimationFromXml(context, animation);
                    if (animation != null) {
                        animation.close();
                    }
                    return createLayoutAnimationFromXml;
                } catch (IOException e) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    XmlResourceParser xmlResourceParser4 = xmlResourceParser2;
                    notFoundException.initCause(e);
                    XmlResourceParser xmlResourceParser5 = xmlResourceParser2;
                    throw notFoundException;
                }
            } catch (XmlPullParserException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                XmlResourceParser xmlResourceParser6 = xmlResourceParser3;
                notFoundException2.initCause(e2);
                XmlResourceParser xmlResourceParser7 = xmlResourceParser3;
                throw notFoundException2;
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    public static Animation makeInAnimation(Context context, boolean z) {
        Animation loadAnimation = z ? loadAnimation(context, R.anim.slide_in_left) : loadAnimation(context, R.anim.slide_in_right);
        loadAnimation.setInterpolator(new DecelerateInterpolator());
        loadAnimation.setStartTime(currentAnimationTimeMillis());
        return loadAnimation;
    }

    public static Animation makeInChildBottomAnimation(Context context) {
        Animation loadAnimation = loadAnimation(context, R.anim.slide_in_child_bottom);
        loadAnimation.setInterpolator(new AccelerateInterpolator());
        loadAnimation.setStartTime(currentAnimationTimeMillis());
        return loadAnimation;
    }

    public static Animation makeOutAnimation(Context context, boolean z) {
        Animation loadAnimation = z ? loadAnimation(context, R.anim.slide_out_right) : loadAnimation(context, R.anim.slide_out_left);
        loadAnimation.setInterpolator(new AccelerateInterpolator());
        loadAnimation.setStartTime(currentAnimationTimeMillis());
        return loadAnimation;
    }
}
