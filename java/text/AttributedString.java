package java.text;

import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* loaded from: source-2895416-dex2jar.jar:java/text/AttributedString.class */
public class AttributedString {
    Map<AttributedCharacterIterator.Attribute, List<Range>> attributeMap;
    String text;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/text/AttributedString$AttributedIterator.class */
    public static class AttributedIterator implements AttributedCharacterIterator {
        private AttributedString attrString;
        private HashSet<AttributedCharacterIterator.Attribute> attributesAllowed;
        private int begin;
        private int end;
        private int offset;

        AttributedIterator(AttributedString attributedString) {
            this.attrString = attributedString;
            this.begin = 0;
            this.end = attributedString.text.length();
            this.offset = 0;
        }

        AttributedIterator(AttributedString attributedString, AttributedCharacterIterator.Attribute[] attributeArr, int i, int i2) {
            if (i < 0 || i2 > attributedString.text.length() || i > i2) {
                throw new IllegalArgumentException();
            }
            this.begin = i;
            this.end = i2;
            this.offset = i;
            this.attrString = attributedString;
            if (attributeArr == null) {
                return;
            }
            HashSet<AttributedCharacterIterator.Attribute> hashSet = new HashSet<>(((attributeArr.length * 4) / 3) + 1);
            int length = attributeArr.length;
            while (true) {
                length--;
                if (length < 0) {
                    this.attributesAllowed = hashSet;
                    return;
                }
                hashSet.add(attributeArr[length]);
            }
        }

        private Object currentValue(List<Range> list) {
            Object obj;
            Iterator<Range> it = list.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                Range next = it.next();
                if (this.offset >= next.start && this.offset < next.end) {
                    obj = null;
                    if (inRange(next)) {
                        obj = next.value;
                    }
                }
            }
            return obj;
        }

        private boolean inRange(Range range) {
            if (range.value instanceof Annotation) {
                return range.start >= this.begin && range.start < this.end && range.end > this.begin && range.end <= this.end;
            }
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
            if (r0.end <= r3.end) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0061, code lost:
            return r5;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean inRange(java.util.List<java.text.AttributedString.Range> r4) {
            /*
                r3 = this;
                r0 = 0
                r6 = r0
                r0 = r4
                java.util.Iterator r0 = r0.iterator()
                r4 = r0
            L9:
                r0 = r6
                r5 = r0
                r0 = r4
                boolean r0 = r0.hasNext()
                if (r0 == 0) goto L60
                r0 = r4
                java.lang.Object r0 = r0.next()
                java.text.AttributedString$Range r0 = (java.text.AttributedString.Range) r0
                r7 = r0
                r0 = r7
                int r0 = r0.start
                r1 = r3
                int r1 = r1.begin
                if (r0 < r1) goto L62
                r0 = r7
                int r0 = r0.start
                r1 = r3
                int r1 = r1.end
                if (r0 >= r1) goto L62
                r0 = r7
                java.lang.Object r0 = r0.value
                boolean r0 = r0 instanceof java.text.Annotation
                if (r0 == 0) goto L5e
                r0 = r6
                r5 = r0
                r0 = r7
                int r0 = r0.end
                r1 = r3
                int r1 = r1.begin
                if (r0 <= r1) goto L60
                r0 = r6
                r5 = r0
                r0 = r7
                int r0 = r0.end
                r1 = r3
                int r1 = r1.end
                if (r0 > r1) goto L60
            L5e:
                r0 = 1
                r5 = r0
            L60:
                r0 = r5
                return r0
            L62:
                r0 = r7
                int r0 = r0.end
                r1 = r3
                int r1 = r1.begin
                if (r0 <= r1) goto L9
                r0 = r7
                int r0 = r0.end
                r1 = r3
                int r1 = r1.end
                if (r0 > r1) goto L9
                r0 = r7
                java.lang.Object r0 = r0.value
                boolean r0 = r0 instanceof java.text.Annotation
                if (r0 == 0) goto La1
                r0 = r6
                r5 = r0
                r0 = r7
                int r0 = r0.start
                r1 = r3
                int r1 = r1.begin
                if (r0 < r1) goto L60
                r0 = r6
                r5 = r0
                r0 = r7
                int r0 = r0.start
                r1 = r3
                int r1 = r1.end
                if (r0 >= r1) goto L60
            La1:
                r0 = 1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.text.AttributedString.AttributedIterator.inRange(java.util.List):boolean");
        }

        private int runLimit(List<Range> list) {
            int i = this.end;
            ListIterator<Range> listIterator = list.listIterator(list.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                Range previous = listIterator.previous();
                if (previous.end <= this.begin) {
                    break;
                } else if (this.offset < previous.start || this.offset >= previous.end) {
                    if (this.offset >= previous.end) {
                        break;
                    }
                    i = previous.start;
                } else if (inRange(previous)) {
                    return previous.end;
                }
            }
            return i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
            return r5;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int runStart(java.util.List<java.text.AttributedString.Range> r4) {
            /*
                r3 = this;
                r0 = r3
                int r0 = r0.begin
                r5 = r0
                r0 = r4
                java.util.Iterator r0 = r0.iterator()
                r4 = r0
            Lc:
                r0 = r4
                boolean r0 = r0.hasNext()
                if (r0 == 0) goto L2a
                r0 = r4
                java.lang.Object r0 = r0.next()
                java.text.AttributedString$Range r0 = (java.text.AttributedString.Range) r0
                r6 = r0
                r0 = r6
                int r0 = r0.start
                r1 = r3
                int r1 = r1.end
                if (r0 < r1) goto L2c
            L2a:
                r0 = r5
                return r0
            L2c:
                r0 = r3
                int r0 = r0.offset
                r1 = r6
                int r1 = r1.start
                if (r0 < r1) goto L4f
                r0 = r3
                int r0 = r0.offset
                r1 = r6
                int r1 = r1.end
                if (r0 >= r1) goto L4f
                r0 = r3
                r1 = r6
                boolean r0 = r0.inRange(r1)
                if (r0 == 0) goto L2a
                r0 = r6
                int r0 = r0.start
                return r0
            L4f:
                r0 = r3
                int r0 = r0.offset
                r1 = r6
                int r1 = r1.start
                if (r0 < r1) goto L2a
                r0 = r6
                int r0 = r0.end
                r5 = r0
                goto Lc
            */
            throw new UnsupportedOperationException("Method not decompiled: java.text.AttributedString.AttributedIterator.runStart(java.util.List):int");
        }

        @Override // java.text.CharacterIterator
        public Object clone() {
            try {
                AttributedIterator attributedIterator = (AttributedIterator) super.clone();
                if (this.attributesAllowed != null) {
                    attributedIterator.attributesAllowed = (HashSet) this.attributesAllowed.clone();
                }
                return attributedIterator;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        @Override // java.text.CharacterIterator
        public char current() {
            if (this.offset == this.end) {
                return (char) 65535;
            }
            return this.attrString.text.charAt(this.offset);
        }

        @Override // java.text.CharacterIterator
        public char first() {
            if (this.begin == this.end) {
                return (char) 65535;
            }
            this.offset = this.begin;
            return this.attrString.text.charAt(this.offset);
        }

        @Override // java.text.AttributedCharacterIterator
        public Set<AttributedCharacterIterator.Attribute> getAllAttributeKeys() {
            HashSet hashSet;
            if (this.begin != 0 || this.end != this.attrString.text.length() || this.attributesAllowed != null) {
                HashSet hashSet2 = new HashSet(((this.attrString.attributeMap.size() * 4) / 3) + 1);
                Iterator<Map.Entry<AttributedCharacterIterator.Attribute, List<Range>>> it = this.attrString.attributeMap.entrySet().iterator();
                while (true) {
                    hashSet = hashSet2;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<AttributedCharacterIterator.Attribute, List<Range>> next = it.next();
                    if (this.attributesAllowed == null || this.attributesAllowed.contains(next.getKey())) {
                        if (inRange(next.getValue())) {
                            hashSet2.add(next.getKey());
                        }
                    }
                }
            } else {
                hashSet = this.attrString.attributeMap.keySet();
            }
            return hashSet;
        }

        @Override // java.text.AttributedCharacterIterator
        public Object getAttribute(AttributedCharacterIterator.Attribute attribute) {
            ArrayList arrayList;
            if ((this.attributesAllowed == null || this.attributesAllowed.contains(attribute)) && (arrayList = (ArrayList) this.attrString.attributeMap.get(attribute)) != null) {
                return currentValue(arrayList);
            }
            return null;
        }

        @Override // java.text.AttributedCharacterIterator
        public Map<AttributedCharacterIterator.Attribute, Object> getAttributes() {
            HashMap hashMap = new HashMap(((this.attrString.attributeMap.size() * 4) / 3) + 1);
            for (Map.Entry<AttributedCharacterIterator.Attribute, List<Range>> entry : this.attrString.attributeMap.entrySet()) {
                if (this.attributesAllowed == null || this.attributesAllowed.contains(entry.getKey())) {
                    Object currentValue = currentValue(entry.getValue());
                    if (currentValue != null) {
                        hashMap.put(entry.getKey(), currentValue);
                    }
                }
            }
            return hashMap;
        }

        @Override // java.text.CharacterIterator
        public int getBeginIndex() {
            return this.begin;
        }

        @Override // java.text.CharacterIterator
        public int getEndIndex() {
            return this.end;
        }

        @Override // java.text.CharacterIterator
        public int getIndex() {
            return this.offset;
        }

        @Override // java.text.AttributedCharacterIterator
        public int getRunLimit() {
            return getRunLimit(getAllAttributeKeys());
        }

        @Override // java.text.AttributedCharacterIterator
        public int getRunLimit(AttributedCharacterIterator.Attribute attribute) {
            ArrayList arrayList;
            if ((this.attributesAllowed == null || this.attributesAllowed.contains(attribute)) && (arrayList = (ArrayList) this.attrString.attributeMap.get(attribute)) != null) {
                return runLimit(arrayList);
            }
            return this.end;
        }

        @Override // java.text.AttributedCharacterIterator
        public int getRunLimit(Set<? extends AttributedCharacterIterator.Attribute> set) {
            int i = this.end;
            for (AttributedCharacterIterator.Attribute attribute : set) {
                int runLimit = getRunLimit(attribute);
                if (runLimit < i) {
                    i = runLimit;
                }
            }
            return i;
        }

        @Override // java.text.AttributedCharacterIterator
        public int getRunStart() {
            return getRunStart(getAllAttributeKeys());
        }

        @Override // java.text.AttributedCharacterIterator
        public int getRunStart(AttributedCharacterIterator.Attribute attribute) {
            ArrayList arrayList;
            if ((this.attributesAllowed == null || this.attributesAllowed.contains(attribute)) && (arrayList = (ArrayList) this.attrString.attributeMap.get(attribute)) != null) {
                return runStart(arrayList);
            }
            return this.begin;
        }

        @Override // java.text.AttributedCharacterIterator
        public int getRunStart(Set<? extends AttributedCharacterIterator.Attribute> set) {
            int i = this.begin;
            for (AttributedCharacterIterator.Attribute attribute : set) {
                int runStart = getRunStart(attribute);
                if (runStart > i) {
                    i = runStart;
                }
            }
            return i;
        }

        @Override // java.text.CharacterIterator
        public char last() {
            if (this.begin == this.end) {
                return (char) 65535;
            }
            this.offset = this.end - 1;
            return this.attrString.text.charAt(this.offset);
        }

        @Override // java.text.CharacterIterator
        public char next() {
            if (this.offset >= this.end - 1) {
                this.offset = this.end;
                return (char) 65535;
            }
            String str = this.attrString.text;
            int i = this.offset + 1;
            this.offset = i;
            return str.charAt(i);
        }

        @Override // java.text.CharacterIterator
        public char previous() {
            if (this.offset == this.begin) {
                return (char) 65535;
            }
            String str = this.attrString.text;
            int i = this.offset - 1;
            this.offset = i;
            return str.charAt(i);
        }

        @Override // java.text.CharacterIterator
        public char setIndex(int i) {
            if (i < this.begin || i > this.end) {
                throw new IllegalArgumentException();
            }
            this.offset = i;
            if (this.offset == this.end) {
                return (char) 65535;
            }
            return this.attrString.text.charAt(this.offset);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/text/AttributedString$Range.class */
    public static class Range {
        int end;
        int start;
        Object value;

        Range(int i, int i2, Object obj) {
            this.start = i;
            this.end = i2;
            this.value = obj;
        }
    }

    public AttributedString(String str) {
        if (str == null) {
            throw new NullPointerException("value == null");
        }
        this.text = str;
        this.attributeMap = new HashMap(11);
    }

    public AttributedString(String str, Map<? extends AttributedCharacterIterator.Attribute, ?> map) {
        if (str == null) {
            throw new NullPointerException("value == null");
        }
        if (str.length() == 0 && !map.isEmpty()) {
            throw new IllegalArgumentException("Cannot add attributes to empty string");
        }
        this.text = str;
        this.attributeMap = new HashMap(((map.size() * 4) / 3) + 1);
        for (Map.Entry<? extends AttributedCharacterIterator.Attribute, ?> entry : map.entrySet()) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(new Range(0, this.text.length(), entry.getValue()));
            this.attributeMap.put(entry.getKey(), arrayList);
        }
    }

    public AttributedString(AttributedCharacterIterator attributedCharacterIterator) {
        if (attributedCharacterIterator.getBeginIndex() > attributedCharacterIterator.getEndIndex()) {
            throw new IllegalArgumentException("Invalid substring range");
        }
        StringBuilder sb = new StringBuilder();
        int beginIndex = attributedCharacterIterator.getBeginIndex();
        while (true) {
            int i = beginIndex;
            if (i >= attributedCharacterIterator.getEndIndex()) {
                break;
            }
            sb.append(attributedCharacterIterator.current());
            attributedCharacterIterator.next();
            beginIndex = i + 1;
        }
        this.text = sb.toString();
        Set<AttributedCharacterIterator.Attribute> allAttributeKeys = attributedCharacterIterator.getAllAttributeKeys();
        if (allAttributeKeys == null) {
            return;
        }
        this.attributeMap = new HashMap(((allAttributeKeys.size() * 4) / 3) + 1);
        for (AttributedCharacterIterator.Attribute attribute : allAttributeKeys) {
            attributedCharacterIterator.setIndex(0);
            while (attributedCharacterIterator.current() != 65535) {
                int runStart = attributedCharacterIterator.getRunStart(attribute);
                int runLimit = attributedCharacterIterator.getRunLimit(attribute);
                Object attribute2 = attributedCharacterIterator.getAttribute(attribute);
                if (attribute2 != null) {
                    addAttribute(attribute, attribute2, runStart, runLimit);
                }
                attributedCharacterIterator.setIndex(runLimit);
            }
        }
    }

    public AttributedString(AttributedCharacterIterator attributedCharacterIterator, int i, int i2) {
        this(attributedCharacterIterator, i, i2, attributedCharacterIterator.getAllAttributeKeys());
    }

    private AttributedString(AttributedCharacterIterator attributedCharacterIterator, int i, int i2, Set<AttributedCharacterIterator.Attribute> set) {
        if (i < attributedCharacterIterator.getBeginIndex() || i2 > attributedCharacterIterator.getEndIndex() || i > i2) {
            throw new IllegalArgumentException();
        }
        if (set == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        attributedCharacterIterator.setIndex(i);
        while (attributedCharacterIterator.getIndex() < i2) {
            sb.append(attributedCharacterIterator.current());
            attributedCharacterIterator.next();
        }
        this.text = sb.toString();
        this.attributeMap = new HashMap(((set.size() * 4) / 3) + 1);
        for (AttributedCharacterIterator.Attribute attribute : set) {
            attributedCharacterIterator.setIndex(i);
            while (attributedCharacterIterator.getIndex() < i2) {
                Object attribute2 = attributedCharacterIterator.getAttribute(attribute);
                int runStart = attributedCharacterIterator.getRunStart(attribute);
                int runLimit = attributedCharacterIterator.getRunLimit(attribute);
                if (((attribute2 instanceof Annotation) && runStart >= i && runLimit <= i2) || (attribute2 != null && !(attribute2 instanceof Annotation))) {
                    addAttribute(attribute, attribute2, (runStart < i ? i : runStart) - i, (runLimit > i2 ? i2 : runLimit) - i);
                }
                attributedCharacterIterator.setIndex(runLimit);
            }
        }
    }

    public AttributedString(AttributedCharacterIterator attributedCharacterIterator, int i, int i2, AttributedCharacterIterator.Attribute[] attributeArr) {
        this(attributedCharacterIterator, i, i2, attributeArr == null ? new HashSet() : new HashSet(Arrays.asList(attributeArr)));
    }

    public void addAttribute(AttributedCharacterIterator.Attribute attribute, Object obj) {
        ArrayList arrayList;
        if (attribute == null) {
            throw new NullPointerException("attribute == null");
        }
        if (this.text.isEmpty()) {
            throw new IllegalArgumentException("text is empty");
        }
        List<Range> list = this.attributeMap.get(attribute);
        if (list == null) {
            ArrayList arrayList2 = new ArrayList(1);
            this.attributeMap.put(attribute, arrayList2);
            arrayList = arrayList2;
        } else {
            list.clear();
            arrayList = list;
        }
        arrayList.add(new Range(0, this.text.length(), obj));
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x009f, code lost:
        r0.add(new java.text.AttributedString.Range(r10, r11, r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b1, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addAttribute(java.text.AttributedCharacterIterator.Attribute r8, java.lang.Object r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.text.AttributedString.addAttribute(java.text.AttributedCharacterIterator$Attribute, java.lang.Object, int, int):void");
    }

    public void addAttributes(Map<? extends AttributedCharacterIterator.Attribute, ?> map, int i, int i2) {
        for (Map.Entry<? extends AttributedCharacterIterator.Attribute, ?> entry : map.entrySet()) {
            addAttribute(entry.getKey(), entry.getValue(), i, i2);
        }
    }

    public AttributedCharacterIterator getIterator() {
        return new AttributedIterator(this);
    }

    public AttributedCharacterIterator getIterator(AttributedCharacterIterator.Attribute[] attributeArr) {
        return new AttributedIterator(this, attributeArr, 0, this.text.length());
    }

    public AttributedCharacterIterator getIterator(AttributedCharacterIterator.Attribute[] attributeArr, int i, int i2) {
        return new AttributedIterator(this, attributeArr, i, i2);
    }
}
