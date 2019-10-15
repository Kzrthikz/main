package seedu.module.model.module;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's deadline in the address book.
 * Guarantees: immutable; is always valid
 */
public class Deadline {
    public final String value;

    public Deadline(String deadline) {
        requireNonNull(deadline);
        value = deadline;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Deadline // instanceof handles nulls
                && value.equals(((Deadline) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
