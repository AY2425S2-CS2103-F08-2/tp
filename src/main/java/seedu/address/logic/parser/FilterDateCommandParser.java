package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_START_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_END_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SORT;

import java.time.LocalDate;

import seedu.address.logic.commands.FilterDateCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new FilterDateCommand object.
 */
public class FilterDateCommandParser implements Parser<FilterDateCommand> {

    private static final String MESSAGE_INVALID_START_DATE = "Invalid start date: Must be valid date in YYYY-MM-DD format " +
            "and less than or equal to END_DATE.";
    private static final String MESSAGE_INVALID_END_DATE = "Invalid end date: Must be valid date in YYYY-MM-DD format " +
            "and must be >= start date and within 5 years";
    private static final String MESSAGE_INVALID_SORT = "Invalid sort. Use 'date' or 'name' (case-insensitive)";
    private static final int MAX_YEARS_RANGE = 5;

    @Override
    public FilterDateCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_START_DATE, PREFIX_END_DATE, PREFIX_SORT);

        if (argMultimap.getValue(PREFIX_START_DATE).isEmpty() || argMultimap.getValue(PREFIX_END_DATE).isEmpty()) {
            throw new ParseException("Start date (sd/) and end date (ed/) are required.");
        }

        LocalDate startDate = ParserUtil.parseDate(argMultimap.getValue(PREFIX_START_DATE).get(), MESSAGE_INVALID_START_DATE);
        LocalDate endDate = ParserUtil.parseDate(argMultimap.getValue(PREFIX_END_DATE).get(), MESSAGE_INVALID_END_DATE);

        if (startDate.isAfter(endDate)) {
            throw new ParseException(MESSAGE_INVALID_START_DATE);
        }

        LocalDate maxAllowedDate = LocalDate.now().plusYears(MAX_YEARS_RANGE);
        if (endDate.isAfter(maxAllowedDate)) {
            throw new ParseException(MESSAGE_INVALID_END_DATE);
        }

        String sortOrder = argMultimap.getValue(PREFIX_SORT).orElse("date").toLowerCase();
        if (!sortOrder.equals("date") && !sortOrder.equals("name")) {
            throw new ParseException(MESSAGE_INVALID_SORT);
        }

        return new FilterDateCommand(startDate, endDate, sortOrder);
    }
}
