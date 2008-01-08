package org.jsmpp.bean;

/**
 * This is class of <tt>DataCoding</tt>
 * 
 * @author uudashr
 * @version 1.0
 * 
 */
public abstract class DataCoding {

    /**
     * Create new instance of data coding with specified value.
     * 
     * @param value is the value.
     * @return the <tt>DataCoding</tt> based on specified value. 
     */
    public static final DataCoding newInstance(int value) {
        byte byteValue = (byte) value;
        if (GeneralDataCoding.isCompatible(byteValue)) {
            return new GeneralDataCoding(byteValue);
        } else if (DataCoding1111.isCompatible(byteValue)) {
            return new DataCoding1111(byteValue);
        } else {
            return null;
        }
    }

    /**
     * Create new instance of data coding with specified value.
     * 
     * @param value is the value.
     * @return <tt>DataCoding</tt> based on specified value.
     */
    public static final DataCoding newInstance(byte value) {
        if (GeneralDataCoding.isCompatible(value)) {
            return new GeneralDataCoding(value);
        } else if (DataCoding1111.isCompatible(value)) {
            return new DataCoding1111(value);
        } else {
            return null;
        }
    }

    protected final byte value;

    /**
     * Default constructor.
     */
    public DataCoding() {
        value = 0;
    }

    /**
     * Constrct with specified value.
     * 
     * @param value is the data coding value.
     */
    public DataCoding(int value) {
        this.value = (byte) value;
    }

    /**
     * Constrct with specified value.
     * 
     * @param value is the data coding value.
     */
    public DataCoding(byte value) {
        this.value = value;
    }

    /**
     * Get the value of data coding.
     * 
     * @return the data coding value.
     */
    public byte value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof DataCoding))
            return false;
        DataCoding other = (DataCoding) obj;
        return value == other.value;
    }
}