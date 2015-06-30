package org.petuum.jbosen.row.float_;

import org.petuum.jbosen.row.RowUpdate;

import java.nio.ByteBuffer;

/**
 * This implementation of {@code FloatRowUpdate} assumes a sparse set of
 * columns, ie. column IDs can be any int value. In general, this class is less
 * CPU and memory efficient than {@link DenseFloatRowUpdate}.
 */
public class SparseFloatRowUpdate extends SparseFloatColumnMap
        implements FloatRowUpdate {

    /**
     * Construct a new object, this object initially contains no columns (ie.
     * all columns are implicitly zero).
     */
    public SparseFloatRowUpdate() {
        super();
    }

    /**
     * Copy constructor, constructs a new, deep copy of the argument.
     *
     * @param other object to construct a deep copy of.
     */
    public SparseFloatRowUpdate(SparseFloatRowUpdate other) {
        super(other);
    }

    /**
     * Construct an object by de-serializing from a {@code ByteBuffer} object.
     *
     * @param buffer the {@code ByteBuffer} containing the serialized data.
     */
    public SparseFloatRowUpdate(ByteBuffer buffer) {
        super(buffer);
    }

    /**
     * Returns a deep copy of this row update.
     *
     * @return deep copy of this row update.
     */
    public SparseFloatRowUpdate getCopy() {
        return new SparseFloatRowUpdate(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void inc(RowUpdate rowUpdate) {
        assert rowUpdate instanceof FloatColumnMap
                : "Incorrect type for rowUpdate!";
        super.incAll((FloatColumnMap) rowUpdate);
    }
}
