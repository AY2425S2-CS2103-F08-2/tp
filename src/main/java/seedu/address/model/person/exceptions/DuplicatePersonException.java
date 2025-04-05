package seedu.address.model.person.exceptions;

/**
 * Signals that the operation will result in duplicate Persons (Persons are considered duplicates if they have the same
 * name or policy number).
 */
public class DuplicatePersonException extends RuntimeException {
    /**
     * Constructs a new DuplicatePersonException with a default error message.
     */
    public DuplicatePersonException() {
        super("This operation cannot be completed as it would result in a person with the same name or "
                + "policy number as another person in the address book");
    }
}
