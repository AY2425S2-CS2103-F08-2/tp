package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's note in the address book.
 * Guarantees: immutable; is always valid
 */
public class Note {
    public static final Note EMPTY = new Note("");
    public final String note;

    /**
     * Constructs a {@code Note}.
     *
     * @param note A note.
     */
    public Note(String note) {
        requireNonNull(note);
        this.note = note;
    }

    @Override
    public String toString() {
        return note;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Note
                && note.equals(((Note) other).note));
    }

    @Override
    public int hashCode() {
        return note.hashCode();
    }
}
