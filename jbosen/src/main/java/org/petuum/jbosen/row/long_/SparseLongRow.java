package org.petuum.jbosen.row.long_;

import org.petuum.jbosen.row.RowUpdate;

import java.nio.ByteBuffer;

/**
 * This implementation of {@code LongRow} assumes a sparse set of columns,
 * ie. column IDs can be any int value. In general, this class is less CPU and
 * memory efficient than {@link DenseLongRow}.
 */
public class SparseLongRow extends SparseLongColumnMap
        implements LongRow {

    /**
     * Construct a new object, this object initially contains no columns (ie.
     * all columns are implicitly zero).
     */
    public SparseLongRow() {
        super();
    }

    /**
     * Copy constructor, constructs a new, deep copy of the argument.
     *
     * @param other object to construct a deep copy of.
     */
    public SparseLongRow(SparseLongRow other) {
        super(other);
    }

    /**
     * Construct an object by de-serializing from a {@code ByteBuffer} object.
     *
     * @param buffer the {@code ByteBuffer} containing the serialized data.
     */
    public SparseLongRow(ByteBuffer buffer) {
        super(buffer);
    }

    /**
     * Returns a deep copy of this row.
     *
     * @return deep copy of this row.
     */
    public SparseLongRow getCopy() {
        return new SparseLongRow(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void inc(RowUpdate rowUpdate) {
        assert rowUpdate instanceof LongColumnMap
                : "Incorrect type for rowUpdate!";
        super.incAll((LongColumnMap) rowUpdate);
    }
}
