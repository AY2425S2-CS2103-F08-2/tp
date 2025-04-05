package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.person.Person;
import seedu.address.model.person.RenewalDate;
import seedu.address.testutil.PersonBuilder;

public class FilterDateCommandTest {
    private static final String VALID_START_DATE = LocalDate.now().plusMonths(1).format(RenewalDate.DATE_FORMATTER);
    private static final String VALID_END_DATE = LocalDate.now().plusMonths(2).format(RenewalDate.DATE_FORMATTER);

    private Model model;
    private Person alice;
    private Person bob;
    private Person charlie;
    private LocalDate baseDate;

    @BeforeEach
    public void setUp() {
        model = new ModelManager();
        // Set base date to 1 month in the future to ensure all test dates are valid
        baseDate = LocalDate.now().plusMonths(1);
        alice = new PersonBuilder().withName("Alice")
                .withPhone("85355255")
                .withEmail("alice@gmail.com")
                .withAddress("123, Jurong West Ave 6, #08-111")
                .withPolicy("12345", baseDate.format(RenewalDate.DATE_FORMATTER)).build();
        bob = new PersonBuilder().withName("Bob")
                .withPhone("85355255")
                .withEmail("bob@gmail.com")
                .withAddress("456, Clementi Ave 3, #05-333")
                .withPolicy("67890", baseDate.plusDays(10).format(RenewalDate.DATE_FORMATTER)).build();
        charlie = new PersonBuilder().withName("Charlie")
                .withPhone("85555255")
                .withEmail("charlie@gmail.com")
                .withAddress("789, Tampines St 12, #07-222")
                .withPolicy("11111", baseDate.plusDays(20).format(RenewalDate.DATE_FORMATTER)).build();
    }

    @Test
    public void execute_emptyModel_noResults() {
        RenewalDate startDate = new RenewalDate(VALID_START_DATE);
        RenewalDate endDate = new RenewalDate(VALID_END_DATE);
        FilterDateCommand command = new FilterDateCommand(startDate, endDate, FilterDateCommand.DEFAULT_SORT);
        CommandResult result = command.execute(model);
        assertEquals(String.format(FilterDateCommand.MESSAGE_NO_RESULTS, startDate, endDate),
                result.getFeedbackToUser());
        assertTrue(model.getRenewalsList().isEmpty());
    }

    @Test
    public void execute_validDateRange_filtersCorrectly() {
        model.addPerson(alice);
        model.addPerson(bob);
        model.addPerson(charlie);
        RenewalDate startDate = new RenewalDate(VALID_START_DATE);
        RenewalDate endDate = new RenewalDate(VALID_END_DATE);

        FilterDateCommand command = new FilterDateCommand(startDate, endDate, FilterDateCommand.DEFAULT_SORT);
        CommandResult result = command.execute(model);

        assertEquals(String.format(FilterDateCommand.MESSAGE_FILTER_SUCCESS, 3, startDate, endDate),
                result.getFeedbackToUser());
        List<Person> filteredList = model.getRenewalsList();
        assertEquals(3, filteredList.size());
        assertTrue(filteredList.contains(alice));
        assertTrue(filteredList.contains(bob));
        assertTrue(filteredList.contains(charlie));
    }

    @Test
    public void execute_sortByName_sortsCorrectly() {
        model.addPerson(bob);
        model.addPerson(alice);
        model.addPerson(charlie);
        FilterDateCommand command = new FilterDateCommand(new RenewalDate(VALID_START_DATE),
                new RenewalDate(VALID_END_DATE), FilterDateCommand.SORT_BY_NAME);
        command.execute(model);

        List<Person> filteredList = model.getRenewalsList();
        assertEquals(3, filteredList.size());
        assertEquals(alice, filteredList.get(0));
        assertEquals(bob, filteredList.get(1));
        assertEquals(charlie, filteredList.get(2));
    }

    @Test
    public void execute_sortByDate_sortsCorrectly() {
        model.addPerson(charlie);
        model.addPerson(bob);
        model.addPerson(alice);
        FilterDateCommand command = new FilterDateCommand(new RenewalDate(VALID_START_DATE),
                new RenewalDate(VALID_END_DATE), FilterDateCommand.SORT_BY_DATE);
        command.execute(model);

        List<Person> filteredList = model.getRenewalsList();
        assertEquals(3, filteredList.size());
        assertEquals(alice, filteredList.get(0));
        assertEquals(bob, filteredList.get(1));
        assertEquals(charlie, filteredList.get(2));
    }

    @Test
    public void execute_noResults_returnsNoResults() {
        Person futurePerson = new PersonBuilder().withName("Future")
                .withPhone("88888888")
                .withEmail("future@gmail.com")
                .withAddress("Future Avenue")
                .withPolicy("99999", baseDate.plusMonths(3).format(RenewalDate.DATE_FORMATTER)).build();
        model.addPerson(futurePerson);
        RenewalDate startDate = new RenewalDate(VALID_START_DATE);
        RenewalDate endDate = new RenewalDate(VALID_END_DATE);

        FilterDateCommand command = new FilterDateCommand(startDate, endDate, FilterDateCommand.DEFAULT_SORT);
        CommandResult result = command.execute(model);

        assertEquals(String.format(FilterDateCommand.MESSAGE_NO_RESULTS, startDate, endDate),
                result.getFeedbackToUser());
        assertTrue(model.getRenewalsList().isEmpty());
    }

    @Test
    public void equals() {
        RenewalDate startDate = new RenewalDate(VALID_START_DATE);
        RenewalDate endDate = new RenewalDate(VALID_END_DATE);
        RenewalDate differentEndDate = new RenewalDate(
                LocalDate.now().plusMonths(3).format(RenewalDate.DATE_FORMATTER));

        FilterDateCommand command1 = new FilterDateCommand(startDate, endDate, FilterDateCommand.DEFAULT_SORT);
        FilterDateCommand command2 = new FilterDateCommand(startDate, endDate, FilterDateCommand.DEFAULT_SORT);
        FilterDateCommand command3 = new FilterDateCommand(startDate, differentEndDate, FilterDateCommand.DEFAULT_SORT);
        FilterDateCommand command4 = new FilterDateCommand(startDate, endDate, FilterDateCommand.SORT_BY_NAME);

        assertTrue(command1.equals(command1)); // same object
        assertTrue(command1.equals(command2)); // same values
        assertFalse(command1.equals(null)); // null
        assertFalse(command1.equals(new ClearCommand())); // different type
        assertFalse(command1.equals(command3)); // different date range
        assertFalse(command1.equals(command4)); // different sorting
    }
}
