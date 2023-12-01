package android.media;

import android.util.Log;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/media/Utils.class */
public class Utils {
    private static final String TAG = "Utils";

    Utils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Range<Integer> alignRange(Range<Integer> range, int i) {
        return range.intersect(Integer.valueOf(divUp(range.getLower().intValue(), i) * i), Integer.valueOf((range.getUpper().intValue() / i) * i));
    }

    public static <T extends Comparable<? super T>> int binarySearchDistinctRanges(Range<T>[] rangeArr, T t) {
        return Arrays.binarySearch(rangeArr, Range.create(t, t), new Comparator<Range<T>>() { // from class: android.media.Utils.2
            /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Comparable] */
            /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Comparable] */
            public int compare(Range<T> range, Range<T> range2) {
                if (range.getUpper().compareTo(range2.getLower()) < 0) {
                    return -1;
                }
                return range.getLower().compareTo(range2.getUpper()) > 0 ? 1 : 0;
            }

            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return compare((Range) ((Range) obj), (Range) ((Range) obj2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int divUp(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    private static long divUp(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Range<Integer> factorRange(Range<Integer> range, int i) {
        return i == 1 ? range : Range.create(Integer.valueOf(divUp(range.getLower().intValue(), i)), Integer.valueOf(range.getUpper().intValue() / i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Range<Long> factorRange(Range<Long> range, long j) {
        return j == 1 ? range : Range.create(Long.valueOf(divUp(range.getLower().longValue(), j)), Long.valueOf(range.getUpper().longValue() / j));
    }

    static int gcd(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return 1;
        }
        int i3 = i2;
        if (i2 < 0) {
            i3 = -i2;
        }
        int i4 = i;
        int i5 = i3;
        if (i < 0) {
            i4 = -i;
            i5 = i3;
        }
        while (true) {
            int i6 = i5;
            if (i4 == 0) {
                return i6;
            }
            i5 = i4;
            i4 = i6 % i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Range<Integer> intRangeFor(double d) {
        return Range.create(Integer.valueOf((int) d), Integer.valueOf((int) Math.ceil(d)));
    }

    public static <T extends Comparable<? super T>> Range<T>[] intersectSortedDistinctRanges(Range<T>[] rangeArr, Range<T>[] rangeArr2) {
        int i = 0;
        Vector vector = new Vector();
        int length = rangeArr2.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            Range<T> range = rangeArr2[i3];
            int i4 = i;
            while (true) {
                int i5 = i4;
                i = i5;
                if (i5 >= rangeArr.length) {
                    break;
                }
                i = i5;
                if (rangeArr[i5].getUpper().compareTo(range.getLower()) >= 0) {
                    break;
                }
                i4 = i5 + 1;
            }
            while (i < rangeArr.length && rangeArr[i].getUpper().compareTo(range.getUpper()) < 0) {
                vector.add(range.intersect(rangeArr[i]));
                i++;
            }
            if (i == rangeArr.length) {
                break;
            }
            if (rangeArr[i].getLower().compareTo(range.getUpper()) <= 0) {
                vector.add(range.intersect(rangeArr[i]));
            }
            i2 = i3 + 1;
        }
        return (Range[]) vector.toArray(new Range[vector.size()]);
    }

    private static long lcm(int i, int i2) {
        if (i == 0 || i2 == 0) {
            throw new IllegalArgumentException("lce is not defined for zero arguments");
        }
        return (i * i2) / gcd(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Range<Long> longRangeFor(double d) {
        return Range.create(Long.valueOf((long) d), Long.valueOf((long) Math.ceil(d)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Range<Integer> parseIntRange(Object obj, Range<Integer> range) {
        try {
            String str = (String) obj;
            int indexOf = str.indexOf(45);
            if (indexOf >= 0) {
                return Range.create(Integer.valueOf(Integer.parseInt(str.substring(0, indexOf), 10)), Integer.valueOf(Integer.parseInt(str.substring(indexOf + 1), 10)));
            }
            int parseInt = Integer.parseInt(str);
            return Range.create(Integer.valueOf(parseInt), Integer.valueOf(parseInt));
        } catch (ClassCastException e) {
            Log.w(TAG, "could not parse integer range '" + obj + "'");
            return range;
        } catch (NullPointerException e2) {
            return range;
        } catch (NumberFormatException e3) {
            Log.w(TAG, "could not parse integer range '" + obj + "'");
            return range;
        } catch (IllegalArgumentException e4) {
            Log.w(TAG, "could not parse integer range '" + obj + "'");
            return range;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int parseIntSafely(Object obj, int i) {
        try {
            return Integer.parseInt((String) obj);
        } catch (ClassCastException e) {
            Log.w(TAG, "could not parse integer '" + obj + "'");
            return i;
        } catch (NullPointerException e2) {
            return i;
        } catch (NumberFormatException e3) {
            Log.w(TAG, "could not parse integer '" + obj + "'");
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Range<Long> parseLongRange(Object obj, Range<Long> range) {
        try {
            String str = (String) obj;
            int indexOf = str.indexOf(45);
            if (indexOf >= 0) {
                return Range.create(Long.valueOf(Long.parseLong(str.substring(0, indexOf), 10)), Long.valueOf(Long.parseLong(str.substring(indexOf + 1), 10)));
            }
            long parseLong = Long.parseLong(str);
            return Range.create(Long.valueOf(parseLong), Long.valueOf(parseLong));
        } catch (ClassCastException e) {
            Log.w(TAG, "could not parse long range '" + obj + "'");
            return range;
        } catch (IllegalArgumentException e2) {
            Log.w(TAG, "could not parse long range '" + obj + "'");
            return range;
        } catch (NullPointerException e3) {
            return range;
        } catch (NumberFormatException e4) {
            Log.w(TAG, "could not parse long range '" + obj + "'");
            return range;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Range<Rational> parseRationalRange(Object obj, Range<Rational> range) {
        try {
            String str = (String) obj;
            int indexOf = str.indexOf(45);
            if (indexOf >= 0) {
                return Range.create(Rational.parseRational(str.substring(0, indexOf)), Rational.parseRational(str.substring(indexOf + 1)));
            }
            Rational parseRational = Rational.parseRational(str);
            return Range.create(parseRational, parseRational);
        } catch (ClassCastException e) {
            Log.w(TAG, "could not parse rational range '" + obj + "'");
            return range;
        } catch (NullPointerException e2) {
            return range;
        } catch (NumberFormatException e3) {
            Log.w(TAG, "could not parse rational range '" + obj + "'");
            return range;
        } catch (IllegalArgumentException e4) {
            Log.w(TAG, "could not parse rational range '" + obj + "'");
            return range;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Size parseSize(Object obj, Size size) {
        try {
            return Size.parseSize((String) obj);
        } catch (ClassCastException e) {
            Log.w(TAG, "could not parse size '" + obj + "'");
            return size;
        } catch (NullPointerException e2) {
            return size;
        } catch (NumberFormatException e3) {
            Log.w(TAG, "could not parse size '" + obj + "'");
            return size;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<Size, Size> parseSizeRange(Object obj) {
        try {
            String str = (String) obj;
            int indexOf = str.indexOf(45);
            if (indexOf >= 0) {
                return Pair.create(Size.parseSize(str.substring(0, indexOf)), Size.parseSize(str.substring(indexOf + 1)));
            }
            Size parseSize = Size.parseSize(str);
            return Pair.create(parseSize, parseSize);
        } catch (ClassCastException e) {
            Log.w(TAG, "could not parse size range '" + obj + "'");
            return null;
        } catch (NullPointerException e2) {
            return null;
        } catch (NumberFormatException e3) {
            Log.w(TAG, "could not parse size range '" + obj + "'");
            return null;
        } catch (IllegalArgumentException e4) {
            Log.w(TAG, "could not parse size range '" + obj + "'");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Range<Rational> scaleRange(Range<Rational> range, int i, int i2) {
        return i == i2 ? range : Range.create(scaleRatio(range.getLower(), i, i2), scaleRatio(range.getUpper(), i, i2));
    }

    private static Rational scaleRatio(Rational rational, int i, int i2) {
        int gcd = gcd(i, i2);
        return new Rational((int) (rational.getNumerator() * (i / gcd)), (int) (rational.getDenominator() * (i2 / gcd)));
    }

    public static <T extends Comparable<? super T>> void sortDistinctRanges(Range<T>[] rangeArr) {
        Arrays.sort(rangeArr, new Comparator<Range<T>>() { // from class: android.media.Utils.1
            /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Comparable] */
            /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Comparable] */
            public int compare(Range<T> range, Range<T> range2) {
                if (range.getUpper().compareTo(range2.getLower()) < 0) {
                    return -1;
                }
                if (range.getLower().compareTo(range2.getUpper()) > 0) {
                    return 1;
                }
                throw new IllegalArgumentException("sample rate ranges must be distinct (" + range + " and " + range2 + ")");
            }

            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return compare((Range) ((Range) obj), (Range) ((Range) obj2));
            }
        });
    }
}
