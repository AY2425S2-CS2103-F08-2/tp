package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static seedu.address.testutil.Assert.assertThrows;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RenewalDateTest {
    private LocalDate baseDate;
    private DateTimeFormatter formatter = RenewalDate.DATE_FORMATTER;

    @BeforeEach
    public void setUp() {
        // Set base date to 6 months in the future to ensure all test dates are valid
        baseDate = LocalDate.now().plusMonths(6);
    }

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new RenewalDate(null));
    }

    @Test
    public void constructor_invalidRenewalDate_throwsIllegalArgumentException() {
        // Invalid format
        String invalidFormat = "invalid-date";
        assertThrows(IllegalArgumentException.class, () -> new RenewalDate(invalidFormat));
        // Valid format but past date
        String pastDate = LocalDate.now().minusDays(1).format(RenewalDate.DATE_FORMATTER);
        assertThrows(IllegalArgumentException.class, () -> new RenewalDate(pastDate));
    }

    @Test
    public void constructor_invalidDateFormat_throwsIllegalArgumentException() {
        // This date string matches the regex but is not a valid date
        String invalidButMatchingDate = "31-13-2024"; // invalid month
        assertThrows(IllegalArgumentException.class, () -> new RenewalDate(invalidButMatchingDate));
    }

    @Test
    public void constructor_defaultRenewalDate_setsToOneYear() {
        RenewalDate renewalDate = new RenewalDate();
        LocalDate expectedDate = LocalDate.now().plusYears(1);
        assertEquals(expectedDate, renewalDate.value);
    }

    @Test
    public void isValidDateFormat() {
        // null renewal date
        assertFalse(RenewalDate.isValidDateFormat(null));

        // invalid renewal dates
        assertFalse(RenewalDate.isValidDateFormat("")); // empty string
        assertFalse(RenewalDate.isValidDateFormat(" ")); // spaces only
        assertFalse(RenewalDate.isValidDateFormat("date")); // non-numeric
        assertFalse(RenewalDate.isValidDateFormat("2020/12/31")); // wrong format
        assertFalse(RenewalDate.isValidDateFormat("31/12/2020")); // wrong format
        assertFalse(RenewalDate.isValidDateFormat("00-12-2020")); // invalid day
        assertFalse(RenewalDate.isValidDateFormat("32-12-2020")); // invalid day
        assertFalse(RenewalDate.isValidDateFormat("31-13-2020")); // invalid month
        assertFalse(RenewalDate.isValidDateFormat("31-00-2020")); // invalid month

        // valid renewal dates
        String futureDate = baseDate.format(formatter);
        assertTrue(RenewalDate.isValidDateFormat(futureDate));
    }

    @Test
    public void isFutureDate() {
        // Past dates
        String pastDate = LocalDate.now().minusDays(1).format(RenewalDate.DATE_FORMATTER);
        assertFalse(RenewalDate.isFutureDate(pastDate));

        // Today's date
        String todayDate = LocalDate.now().format(RenewalDate.DATE_FORMATTER);
        assertFalse(RenewalDate.isFutureDate(todayDate));

        // Future dates
        String tomorrowDate = LocalDate.now().plusDays(1).format(RenewalDate.DATE_FORMATTER);
        assertTrue(RenewalDate.isFutureDate(tomorrowDate));
        String nextMonthDate = LocalDate.now().plusMonths(1).format(RenewalDate.DATE_FORMATTER);
        assertTrue(RenewalDate.isFutureDate(nextMonthDate));
        String nextYearDate = LocalDate.now().plusYears(1).format(RenewalDate.DATE_FORMATTER);
        assertTrue(RenewalDate.isFutureDate(nextYearDate));

        // Invalid format should return false
        assertFalse(RenewalDate.isFutureDate("invalid-date"));
        assertFalse(RenewalDate.isFutureDate(""));
        assertFalse(RenewalDate.isFutureDate(null));
    }

    @Test
    public void isValidRenewalDate() {
        // null renewal date
        assertFalse(RenewalDate.isValidRenewalDate(null));

        // invalid renewal dates
        assertFalse(RenewalDate.isValidRenewalDate("")); // empty string
        assertFalse(RenewalDate.isValidRenewalDate(" ")); // spaces only
        assertFalse(RenewalDate.isValidRenewalDate("date")); // non-numeric
        assertFalse(RenewalDate.isValidRenewalDate("2020/12/31")); // wrong format
        assertFalse(RenewalDate.isValidRenewalDate("31/12/2020")); // wrong format

        // past dates
        assertFalse(RenewalDate.isValidRenewalDate(LocalDate.now().minusDays(1).format(formatter))); // yesterday
        assertFalse(RenewalDate.isValidRenewalDate(LocalDate.now().format(formatter))); // today

        // valid renewal dates (future dates)
        assertTrue(RenewalDate.isValidRenewalDate(baseDate.format(formatter))); // 6 months from now
        assertTrue(RenewalDate.isValidRenewalDate(baseDate.plusMonths(6).format(formatter))); // 1 year from now
    }

    @Test
    public void isValidRenewalDate_thirtyDayMonths() {
        // Test for months with 30 days
        String[] thirtyDayMonths = {
            baseDate.withMonth(4).format(formatter), // April
            baseDate.withMonth(6).format(formatter), // June
            baseDate.withMonth(9).format(formatter), // September
            baseDate.withMonth(11).format(formatter) // November
        };

        for (String date : thirtyDayMonths) {
            assertTrue(RenewalDate.isValidDateFormat(date));
        }

        // Test invalid dates for 30-day months
        for (int month : new int[]{4, 6, 9, 11}) {
            String invalidDate = String.format("31-%02d-%d", month, baseDate.getYear());
            assertFalse(RenewalDate.isValidDateFormat(invalidDate));
        }
    }

    @Test
    public void isValidRenewalDate_thirtyOneDayMonths() {
        // Test for months with 31 days
        String[] thirtyOneDayMonths = {
            baseDate.withMonth(1).format(formatter), // January
            baseDate.withMonth(3).format(formatter), // March
            baseDate.withMonth(5).format(formatter), // May
            baseDate.withMonth(7).format(formatter), // July
            baseDate.withMonth(8).format(formatter), // August
            baseDate.withMonth(10).format(formatter), // October
            baseDate.withMonth(12).format(formatter) // December
        };

        for (String date : thirtyOneDayMonths) {
            assertTrue(RenewalDate.isValidDateFormat(date));
        }
    }

    @Test
    public void isValidRenewalDate_februaryLeapYearRules() {
        int futureYear = baseDate.getYear();
        while (!isLeapYear(futureYear)) {
            futureYear++;
        }

        // Regular leap year (divisible by 4)
        String leapYearDate = String.format("29-02-%d", futureYear);
        assertTrue(RenewalDate.isValidDateFormat(leapYearDate));

        // Not a leap year
        String nonLeapYearDate = String.format("29-02-%d", futureYear + 1);
        assertFalse(RenewalDate.isValidDateFormat(nonLeapYearDate));

        // Invalid days for any February
        String invalidDate1 = String.format("30-02-%d", futureYear);
        String invalidDate2 = String.format("31-02-%d", futureYear);
        assertFalse(RenewalDate.isValidDateFormat(invalidDate1));
        assertFalse(RenewalDate.isValidDateFormat(invalidDate2));
    }

    @Test
    public void isValidRenewalDate_boundaryConditions() {
        // First day of month
        assertTrue(RenewalDate.isValidDateFormat(baseDate.withDayOfMonth(1).format(formatter)));

        // Invalid zero day/month
        assertFalse(RenewalDate.isValidDateFormat("00-01-" + baseDate.getYear()));
        assertFalse(RenewalDate.isValidDateFormat("01-00-" + baseDate.getYear()));

        // Invalid month > 12
        assertFalse(RenewalDate.isValidDateFormat("01-13-" + baseDate.getYear()));
    }

    @Test
    public void getDaysUntilRenewal_futureDate_returnsPositiveDays() {
        LocalDate today = LocalDate.now();
        LocalDate future = today.plusDays(5);
        String futureDate = future.format(RenewalDate.DATE_FORMATTER);
        RenewalDate renewalDate = new RenewalDate(futureDate);
        assertEquals(5, renewalDate.getDaysUntilRenewal());
    }

    @Test
    public void getDaysUntilRenewal_pastDate_returnsNegativeDays() {
        LocalDate today = LocalDate.now();
        LocalDate past = today.minusDays(5);
        String pastDate = past.format(RenewalDate.DATE_FORMATTER);
        try {
            RenewalDate renewalDate = new RenewalDate(pastDate);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(RenewalDate.DATE_FUTURE_CONSTRAINTS, e.getMessage());
        }
    }

    @Test
    public void getDaysUntilRenewal_today_returnsZero() {
        LocalDate today = LocalDate.now();
        String todayDate = today.format(RenewalDate.DATE_FORMATTER);
        try {
            RenewalDate renewalDate = new RenewalDate(todayDate);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(RenewalDate.DATE_FUTURE_CONSTRAINTS, e.getMessage());
        }
    }

    @Test
    public void isRenewalDueWithin() {
        LocalDate today = LocalDate.now();
        LocalDate future = today.plusDays(30);
        String futureDate = future.format(RenewalDate.DATE_FORMATTER);
        RenewalDate renewalDate = new RenewalDate(futureDate);
        assertTrue(renewalDate.isRenewalDueWithin(60)); // within range
        assertTrue(renewalDate.isRenewalDueWithin(30)); // exactly on range
        assertFalse(renewalDate.isRenewalDueWithin(15)); // outside range
    }

    @Test
    public void equals() {
        String date = baseDate.format(formatter);
        RenewalDate renewalDate = new RenewalDate(date);
        // same values -> returns true
        assertTrue(renewalDate.equals(new RenewalDate(date)));
        // same object -> returns true
        assertTrue(renewalDate.equals(renewalDate));
        // null -> returns false
        assertFalse(renewalDate.equals(null));
        // different types -> returns false
        assertFalse(renewalDate.equals(5.0f));
        // different dates -> returns false
        String differentDate = baseDate.plusDays(1).format(formatter);
        assertFalse(renewalDate.equals(new RenewalDate(differentDate)));
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
