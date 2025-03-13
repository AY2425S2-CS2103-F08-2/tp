package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.List;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Filters clients based on policy renewal date range.
 */
public class FilterDateCommand extends Command {

    public static final String COMMAND_WORD = "filter";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Filters clients whose policy renewal date "
            + "falls within the specified date range.\n"
            + "Parameters: sd/START_DATE ed/END_DATE [s/SORT_ORDER]\n"
            + "Example: " + COMMAND_WORD + " sd/2025-03-01 ed/2025-03-31 s/name";

    public static final String MESSAGE_NO_RESULTS = "No renewals found between %s and %s.";

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String sortOrder;

    public FilterDateCommand(LocalDate startDate, LocalDate endDate, String sortOrder) {
        requireNonNull(startDate);
        requireNonNull(endDate);
        this.startDate = startDate;
        this.endDate = endDate;
        this.sortOrder = (sortOrder != null) ? sortOrder : "date";
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        //to be continued
        //model.updateFilteredPersonList(RenewalDatePredicate(startDate, endDate));

        List<Person> filteredList = model.getFilteredPersonList();

        if (filteredList.isEmpty()) {
            return new CommandResult(String.format(MESSAGE_NO_RESULTS, startDate, endDate));
        }

        /* to be continued
        if (sortOrder.equals("name")) {
            filteredList.sort((p1, p2) -> p1.getName().fullName.compareToIgnoreCase(p2.getName().fullName));
        } else {
            filteredList.sort((p1, p2) -> p1.getPolicy().getRenewalDate().compareTo(p2.getPolicy().getRenewalDate()));
        }
         */

        return new CommandResult("to be continued");
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof FilterDateCommand)) {
            return false;
        }
        FilterDateCommand otherCommand = (FilterDateCommand) other;
        return startDate.equals(otherCommand.startDate)
                && endDate.equals(otherCommand.endDate)
                && sortOrder.equals(otherCommand.sortOrder);
    }
}
