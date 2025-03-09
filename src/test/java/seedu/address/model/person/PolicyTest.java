package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PolicyTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Policy(null));
    }

    @Test
    public void constructor_invalidPolicy_throwsIllegalArgumentException() {
        String invalidPolicy = "";
        assertThrows(IllegalArgumentException.class, () -> new Policy(invalidPolicy));
    }

    @Test
    public void isValidPolicy() {
        // null policy number
        assertThrows(NullPointerException.class, () -> Policy.isValidPolicy(null));

        // invalid policy numbers
        assertFalse(Policy.isValidPolicy("")); // empty string
        assertFalse(Policy.isValidPolicy(" ")); // spaces only
        assertFalse(Policy.isValidPolicy("14")); // less than 3 numbers
        assertFalse(Policy.isValidPolicy("policy")); // non-numeric
        assertFalse(Policy.isValidPolicy("1033p041")); // alphabets within digits
        assertFalse(Policy.isValidPolicy("3912 1534")); // spaces within digits

        // valid policy numbers
        assertTrue(Policy.isValidPolicy("123")); // exactly 3 numbers
        assertTrue(Policy.isValidPolicy("647274521"));
        assertTrue(Policy.isValidPolicy("12492648284628492623")); // long policy numbers
    }

    @Test
    public void equals() {
        Policy policy = new Policy("123");

        // same values -> returns true
        assertTrue(policy.equals(new Policy("123")));

        // same object -> returns true
        assertTrue(policy.equals(policy));

        // null -> returns false
        assertFalse(policy.equals(null));

        // different types -> returns false
        assertFalse(policy.equals(5.0f));

        // different values -> returns false
        assertFalse(policy.equals(new Policy("120")));
    }
}
