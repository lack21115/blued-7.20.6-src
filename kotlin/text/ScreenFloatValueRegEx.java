package kotlin.text;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/ScreenFloatValueRegEx.class */
final class ScreenFloatValueRegEx {

    /* renamed from: a  reason: collision with root package name */
    public static final ScreenFloatValueRegEx f42742a = new ScreenFloatValueRegEx();
    public static final Regex b = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");

    private ScreenFloatValueRegEx() {
    }
}
