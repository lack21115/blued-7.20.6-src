package javax.xml.datatype;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.GregorianCalendar;
import javax.xml.datatype.FactoryFinder;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/datatype/DatatypeFactory.class */
public abstract class DatatypeFactory {
    public static final String DATATYPEFACTORY_IMPLEMENTATION_CLASS = new String("org.apache.xerces.jaxp.datatype.DatatypeFactoryImpl");
    public static final String DATATYPEFACTORY_PROPERTY = "javax.xml.datatype.DatatypeFactory";

    protected DatatypeFactory() {
    }

    public static DatatypeFactory newInstance() throws DatatypeConfigurationException {
        try {
            return (DatatypeFactory) FactoryFinder.find(DATATYPEFACTORY_PROPERTY, DATATYPEFACTORY_IMPLEMENTATION_CLASS);
        } catch (FactoryFinder.ConfigurationError e) {
            throw new DatatypeConfigurationException(e.getMessage(), e.getException());
        }
    }

    public static DatatypeFactory newInstance(String str, ClassLoader classLoader) throws DatatypeConfigurationException {
        if (str == null) {
            throw new DatatypeConfigurationException("factoryClassName == null");
        }
        ClassLoader classLoader2 = classLoader;
        if (classLoader == null) {
            classLoader2 = Thread.currentThread().getContextClassLoader();
        }
        try {
            return (DatatypeFactory) (classLoader2 != null ? classLoader2.loadClass(str) : Class.forName(str)).newInstance();
        } catch (ClassNotFoundException e) {
            throw new DatatypeConfigurationException(e);
        } catch (IllegalAccessException e2) {
            throw new DatatypeConfigurationException(e2);
        } catch (InstantiationException e3) {
            throw new DatatypeConfigurationException(e3);
        }
    }

    public abstract Duration newDuration(long j);

    public abstract Duration newDuration(String str);

    public Duration newDuration(boolean z, int i, int i2, int i3, int i4, int i5, int i6) {
        return newDuration(z, i != Integer.MIN_VALUE ? BigInteger.valueOf(i) : null, i2 != Integer.MIN_VALUE ? BigInteger.valueOf(i2) : null, i3 != Integer.MIN_VALUE ? BigInteger.valueOf(i3) : null, i4 != Integer.MIN_VALUE ? BigInteger.valueOf(i4) : null, i5 != Integer.MIN_VALUE ? BigInteger.valueOf(i5) : null, i6 != Integer.MIN_VALUE ? BigDecimal.valueOf(i6) : null);
    }

    public abstract Duration newDuration(boolean z, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigDecimal bigDecimal);

    public Duration newDurationDayTime(long j) {
        boolean z;
        if (j == 0) {
            return newDuration(true, Integer.MIN_VALUE, Integer.MIN_VALUE, 0, 0, 0, 0);
        }
        boolean z2 = false;
        boolean z3 = false;
        if (j < 0) {
            z = false;
            long j2 = j;
            if (j == Long.MIN_VALUE) {
                j2 = j + 1;
                z3 = true;
            }
            j = j2 * (-1);
            z2 = z3;
        } else {
            z = true;
        }
        int i = (int) (j % 60000);
        int i2 = i;
        if (z2) {
            i2 = i + 1;
        }
        if (i2 % 1000 != 0) {
            BigDecimal valueOf = BigDecimal.valueOf(i2, 3);
            long j3 = j / 60000;
            BigInteger valueOf2 = BigInteger.valueOf(j3 % 60);
            long j4 = j3 / 60;
            return newDuration(z, (BigInteger) null, (BigInteger) null, BigInteger.valueOf(j4 / 24), BigInteger.valueOf(j4 % 24), valueOf2, valueOf);
        }
        long j5 = j / 60000;
        int i3 = (int) (j5 % 60);
        long j6 = j5 / 60;
        int i4 = (int) (j6 % 24);
        long j7 = j6 / 24;
        return j7 <= 2147483647L ? newDuration(z, Integer.MIN_VALUE, Integer.MIN_VALUE, (int) j7, i4, i3, i2 / 1000) : newDuration(z, (BigInteger) null, (BigInteger) null, BigInteger.valueOf(j7), BigInteger.valueOf(i4), BigInteger.valueOf(i3), BigDecimal.valueOf(i2, 3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        throw new java.lang.IllegalArgumentException("Invalid dayTimeDuration value: " + r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public javax.xml.datatype.Duration newDurationDayTime(java.lang.String r6) {
        /*
            r5 = this;
            r0 = r6
            if (r0 != 0) goto Le
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r1 = r0
            java.lang.String r2 = "lexicalRepresentation == null"
            r1.<init>(r2)
            throw r0
        Le:
            r0 = r6
            r1 = 84
            int r0 = r0.indexOf(r1)
            r7 = r0
            r0 = r7
            if (r0 < 0) goto L50
        L19:
            r0 = 0
            r8 = r0
        L1b:
            r0 = r8
            r1 = r7
            if (r0 >= r1) goto L5f
            r0 = r6
            r1 = r8
            char r0 = r0.charAt(r1)
            r9 = r0
            r0 = r9
            r1 = 89
            if (r0 == r1) goto L35
            r0 = r9
            r1 = 77
            if (r0 != r1) goto L58
        L35:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Invalid dayTimeDuration value: "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r6
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L50:
            r0 = r6
            int r0 = r0.length()
            r7 = r0
            goto L19
        L58:
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto L1b
        L5f:
            r0 = r5
            r1 = r6
            javax.xml.datatype.Duration r0 = r0.newDuration(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.xml.datatype.DatatypeFactory.newDurationDayTime(java.lang.String):javax.xml.datatype.Duration");
    }

    public Duration newDurationDayTime(boolean z, int i, int i2, int i3, int i4) {
        return newDuration(z, Integer.MIN_VALUE, Integer.MIN_VALUE, i, i2, i3, i4);
    }

    public Duration newDurationDayTime(boolean z, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        return newDuration(z, (BigInteger) null, (BigInteger) null, bigInteger, bigInteger2, bigInteger3, bigInteger4 != null ? new BigDecimal(bigInteger4) : null);
    }

    public Duration newDurationYearMonth(long j) {
        return newDuration(j);
    }

    public Duration newDurationYearMonth(String str) {
        if (str == null) {
            throw new NullPointerException("lexicalRepresentation == null");
        }
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return newDuration(str);
            }
            char charAt = str.charAt(i2);
            if (charAt == 'D' || charAt == 'T') {
                break;
            }
            i = i2 + 1;
        }
        throw new IllegalArgumentException("Invalid yearMonthDuration value: " + str);
    }

    public Duration newDurationYearMonth(boolean z, int i, int i2) {
        return newDuration(z, i, i2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public Duration newDurationYearMonth(boolean z, BigInteger bigInteger, BigInteger bigInteger2) {
        return newDuration(z, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null, (BigInteger) null, (BigDecimal) null);
    }

    public abstract XMLGregorianCalendar newXMLGregorianCalendar();

    public XMLGregorianCalendar newXMLGregorianCalendar(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        BigInteger valueOf = i != Integer.MIN_VALUE ? BigInteger.valueOf(i) : null;
        BigDecimal bigDecimal = null;
        if (i7 != Integer.MIN_VALUE) {
            if (i7 < 0 || i7 > 1000) {
                throw new IllegalArgumentException("javax.xml.datatype.DatatypeFactory#newXMLGregorianCalendar(int year, int month, int day, int hour, int minute, int second, int millisecond, int timezone)with invalid millisecond: " + i7);
            }
            bigDecimal = BigDecimal.valueOf(i7, 3);
        }
        return newXMLGregorianCalendar(valueOf, i2, i3, i4, i5, i6, bigDecimal, i8);
    }

    public abstract XMLGregorianCalendar newXMLGregorianCalendar(String str);

    public abstract XMLGregorianCalendar newXMLGregorianCalendar(BigInteger bigInteger, int i, int i2, int i3, int i4, int i5, BigDecimal bigDecimal, int i6);

    public abstract XMLGregorianCalendar newXMLGregorianCalendar(GregorianCalendar gregorianCalendar);

    public XMLGregorianCalendar newXMLGregorianCalendarDate(int i, int i2, int i3, int i4) {
        return newXMLGregorianCalendar(i, i2, i3, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, i4);
    }

    public XMLGregorianCalendar newXMLGregorianCalendarTime(int i, int i2, int i3, int i4) {
        return newXMLGregorianCalendar(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, i, i2, i3, Integer.MIN_VALUE, i4);
    }

    public XMLGregorianCalendar newXMLGregorianCalendarTime(int i, int i2, int i3, int i4, int i5) {
        BigDecimal bigDecimal = null;
        if (i4 != Integer.MIN_VALUE) {
            if (i4 < 0 || i4 > 1000) {
                throw new IllegalArgumentException("javax.xml.datatype.DatatypeFactory#newXMLGregorianCalendarTime(int hours, int minutes, int seconds, int milliseconds, int timezone)with invalid milliseconds: " + i4);
            }
            bigDecimal = BigDecimal.valueOf(i4, 3);
        }
        return newXMLGregorianCalendarTime(i, i2, i3, bigDecimal, i5);
    }

    public XMLGregorianCalendar newXMLGregorianCalendarTime(int i, int i2, int i3, BigDecimal bigDecimal, int i4) {
        return newXMLGregorianCalendar((BigInteger) null, Integer.MIN_VALUE, Integer.MIN_VALUE, i, i2, i3, bigDecimal, i4);
    }
}
