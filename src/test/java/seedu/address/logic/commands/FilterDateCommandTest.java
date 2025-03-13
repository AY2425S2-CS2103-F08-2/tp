package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;

/**
 * Contains integration tests (interaction with the Model) and unit tests for FilterDateCommand.
 */
public class FilterDateCommandTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    /* to be continued
    @Test
    public void execute_validDateRange_success() {
        LocalDate startDate = LocalDate.of(2025, 3, 1);
        LocalDate endDate = LocalDate.of(2025, 3, 31);
        FilterDateCommand command = new FilterDateCommand(startDate, endDate, "date");

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.updateFilteredPersonList(person -> {
            LocalDate renewalDate = person.getPolicy().getRenewalDate();
            return renewalDate != null && !renewalDate.isBefore(startDate) && !renewalDate.isAfter(endDate);
        });

        List<Person> filteredList = expectedModel.getFilteredPersonList();
        String expectedMessage = filteredList.isEmpty()
                ? String.format(FilterDateCommand.MESSAGE_NO_RESULTS, startDate, endDate)
                : Messages.formatFilteredList(filteredList);

        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }
    */

    @Test
    public void execute_noMatchingResults_failure() {
        LocalDate startDate = LocalDate.of(2050, 1, 1);
        LocalDate endDate = LocalDate.of(2050, 12, 31);
        FilterDateCommand command = new FilterDateCommand(startDate, endDate, "date");

        String expectedMessage = String.format(FilterDateCommand.MESSAGE_NO_RESULTS, startDate, endDate);
        assertCommandSuccess(command, model, expectedMessage, model);
    }

    /* to be continued
    @Test
    public void execute_invalidDateRange_failure() {
        LocalDate startDate = LocalDate.of(2025, 3, 31);
        LocalDate endDate = LocalDate.of(2025, 3, 1);
        FilterDateCommand command = new FilterDateCommand(startDate, endDate, "date");

        assertCommandFailure(command, model, "Start date must be on or before end date.");
    }
     */
}
