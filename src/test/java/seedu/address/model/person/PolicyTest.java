package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PolicyTest {
    private LocalDate baseDate;
    private DateTimeFormatter formatter = RenewalDate.DATE_FORMATTER;

    @BeforeEach
    public void setUp() {
        // Set base date to 6 months in the future to ensure all test dates are valid
        baseDate = LocalDate.now().plusMonths(6);
    }

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
        assertFalse(Policy.isValidPolicy("^")); // only non-alphanumeric characters
        assertFalse(Policy.isValidPolicy("peter*")); // contains non-alphanumeric characters
        assertFalse(Policy.isValidPolicy("12 34")); // contains space
        assertFalse(Policy.isValidPolicy("12.34")); // contains period

        // valid policy numbers
        assertTrue(Policy.isValidPolicy("12345")); // numbers only
        assertTrue(Policy.isValidPolicy("123456")); // alphanumeric characters
        assertTrue(Policy.isValidPolicy("12345678")); // long policy numbers
    }

    @Test
    public void isValidRenewalDate() {
        // null renewal date
        assertFalse(Policy.isValidRenewalDate(null));

        // invalid renewal dates
        assertFalse(Policy.isValidRenewalDate("")); // empty string
        assertFalse(Policy.isValidRenewalDate(" ")); // spaces only
        assertFalse(Policy.isValidRenewalDate("date")); // non-numeric
        assertFalse(Policy.isValidRenewalDate("2020/12/31")); // wrong format
        assertFalse(Policy.isValidRenewalDate("31/12/2020")); // wrong format

        // past dates
        assertFalse(Policy.isValidRenewalDate(LocalDate.now().minusDays(1).format(formatter))); // yesterday
        assertFalse(Policy.isValidRenewalDate(LocalDate.now().format(formatter))); // today

        // valid renewal dates (future dates)
        assertTrue(Policy.isValidRenewalDate(baseDate.format(formatter))); // 6 months from now
        assertTrue(Policy.isValidRenewalDate(baseDate.plusMonths(6).format(formatter))); // 1 year from now
    }

    @Test
    public void policyType() {
        // Test creating policies with different types
        String date = baseDate.format(formatter);
        Policy lifePolicy = new Policy("12345", new RenewalDate(date), PolicyType.LIFE);
        Policy healthPolicy = new Policy("12345", new RenewalDate(date), PolicyType.HEALTH);
        Policy propertyPolicy = new Policy("12345", new RenewalDate(date), PolicyType.PROPERTY);

        // Check that the types are set correctly
        assertEquals(PolicyType.LIFE, lifePolicy.getType());
        assertEquals(PolicyType.HEALTH, healthPolicy.getType());
        assertEquals(PolicyType.PROPERTY, propertyPolicy.getType());

        // Test null policy type
        assertThrows(NullPointerException.class, () -> new Policy("12345", new RenewalDate(date), null));
    }

    @Test
    public void equals() {
        String date = baseDate.format(formatter);
        Policy policy = new Policy("12345", new RenewalDate(date));

        // same values -> returns true
        assertTrue(policy.equals(new Policy("12345", new RenewalDate(date))));

        // same object -> returns true
        assertTrue(policy.equals(policy));

        // null -> returns false
        assertFalse(policy.equals(null));

        // different type -> returns false
        assertFalse(policy.equals(5.0f));

        // different policy number -> returns false
        assertFalse(policy.equals(new Policy("54321", new RenewalDate(date))));

        // different renewal date -> returns false
        String differentDate = baseDate.plusDays(1).format(formatter);
        assertFalse(policy.equals(new Policy("12345", new RenewalDate(differentDate))));

        // different policy type -> returns false
        assertFalse(policy.equals(new Policy("12345", new RenewalDate(date), PolicyType.HEALTH)));
    }
}
