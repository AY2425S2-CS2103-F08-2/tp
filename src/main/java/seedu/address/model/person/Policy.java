package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's policy in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPolicy(String)}
 */
public class Policy {


    public static final String MESSAGE_CONSTRAINTS =
            "Policy should only contain numbers, and it should be at least 3 digits long";
    public static final String VALIDATION_REGEX = "\\d{3,}";
    public final String policyNumber;

    /**
     * Constructs a {@code Policy}.
     *
     * @param policyNumber A valid policy number.
     */
    public Policy(String policyNumber) {
        requireNonNull(policyNumber);
        checkArgument(isValidPolicy(policyNumber), MESSAGE_CONSTRAINTS);
        this.policyNumber = policyNumber;
    }

    /**
     * Returns true if a given string is a valid policy.
     */
    public static boolean isValidPolicy(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return policyNumber;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Policy)) {
            return false;
        }

        Policy otherPolicy = (Policy) other;
        return policyNumber.equals(otherPolicy.policyNumber);
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }

}
