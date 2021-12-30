package com.nerjal.json.parser.options;

/**
 * The formatting options of a JsonNumber, used upon stringifying the
 * said JsonNumber.
 * <p>
 * Allows setting whether the JsonNumber should be parsed to an
 * integer or a floating point, and if it should be done to a decimal
 * number, a hexadecimal one, or using scientific notation
 * (e.g. <i>3.2e4 = 32 000</i> )
 * <p>
 * <i>Warning!</i> Although it is set to parse to an integer by default,
 * the stringified JsonNumber will only be parsed as so if it has an
 * integer value. This won't force the parsed value to change.
 * @author Nerjal Nosk
 */
public class NumberParseOptions {
    private NumberFormat format;
    private boolean floating;

    /**
     * Constructs a {@link com.nerjal.json.elements.JsonNumber} parsing
     * option set with the given settings.
     * @param floating whether the concerned number shall be stringified as
     *                 an integer or floating number
     * @param format whether the concerned number shall be stringified as a
     *               decimal number, with scientific notation, or to hex
     */
    public NumberParseOptions(boolean floating, NumberFormat format) {
        this.floating = floating;
        this.format = format;
    }

    /**
     * Constructs a {@link com.nerjal.json.elements.JsonNumber} parsing
     * option set with the given setting and a default DECIMAL format.
     * @param floating whether the concerned number shall be stringified as
     *                 an integer or floating number
     */
    public NumberParseOptions(boolean floating) {
        this(floating, NumberFormat.DECIMAL);
    }

    /**
     * Constructs a {@link com.nerjal.json.elements.JsonNumber} parsing
     * option set with the given format and a default Integer setting.
     * @param format whether the concerned number shall be stringified as a
     *               decimal number, with scientific notation, or to hex
     */
    public NumberParseOptions(NumberFormat format) {
        this(false, format);
    }

    /**
     * Constructs a {@link com.nerjal.json.elements.JsonNumber} parsing
     * option set with default Integer and DECIMAL format settings.
     */
    public NumberParseOptions() {
        this(false);
    }

    /**
     * Gives whether the option set is set to parse to an integer or not.
     * @return the Integer/Float setting of the option set
     */
    public boolean isInteger() {
        return !floating;
    }

    /**
     * Gives whether the option set is set to parse to a float or not.
     * @return the Integer/Float setting of the option set
     */
    public boolean isFloating() {
        return floating;
    }

    /**
     * Sets the option set to parse to float
     */
    public void setFloating() {
        this.floating = true;
    }

    /**
     * Sets the option set to parse to integer
     */
    public void setInteger() {
        this.floating = false;
    }

    /**
     * @return Whether the option set is set to parse to a decimal number
     */
    public boolean usesDecimal() {
        return this.format == NumberFormat.DECIMAL;
    }

    /**
     * @return Whether the option set is set to parse using scientific
     * notation
     */
    public boolean usesScientific() {
        return this.format == NumberFormat.SCIENTIFIC;
    }

    /**
     * @return Whether the option set os set to parse to a hexadecimal
     * number
     */
    public boolean usesHexadecimal() {
        return this.format == NumberFormat.HEXADECIMAL;
    }

    /**
     * Sets the option set to use the given format upon parsing
     * @param format The format to parse a JsonNumber to
     */
    public void setFormat(NumberFormat format) {
        this.format = format;
    }

    /**
     * The notation type of the option set.
     * Used to define whether the stringified JsonNumber should be parsed
     * to a decimal or hexadecimal number, or using scientific notation
     */
    public enum NumberFormat {
        DECIMAL,
        SCIENTIFIC,
        HEXADECIMAL
    }
}