package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_END_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SORT_ORDER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_START_DATE;

import java.time.LocalDate;
import java.util.stream.Stream;

import seedu.address.logic.commands.FilterDateCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.RenewalDate;

/**
 * Parses input arguments and creates a new FilterDateCommand object.
 */
public class FilterDateCommandParser implements Parser<FilterDateCommand> {

    public static final String MESSAGE_INVALID_DATE_FORMAT =
            "Invalid date format: Must be valid date in DD-MM-YYYY format";
    public static final String MESSAGE_INVALID_START_DATE =
            "Invalid start date: Must be valid date in DD-MM-YYYY format "
                    + "and before or equal to end date.";
    public static final String MESSAGE_INVALID_END_DATE =
            "Invalid end date: Must be valid date in DD-MM-YYYY format "
            + "and after or equal to start date, and within 5 years from the start date";
    public static final String MESSAGE_INVALID_SORT =
            "Invalid sort. Use 'date' or 'name' (case-insensitive)";
    private static final int MAX_YEARS_RANGE = 5;

    @Override
    public FilterDateCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_START_DATE, PREFIX_END_DATE, PREFIX_SORT_ORDER);
        String sortOrder = FilterDateCommand.DEFAULT_SORT;

        if (!arePrefixesPresent(argMultimap, PREFIX_START_DATE, PREFIX_END_DATE)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterDateCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_START_DATE, PREFIX_END_DATE, PREFIX_SORT_ORDER);

        RenewalDate startDate = ParserUtil.parseRenewalDate(argMultimap.getValue(PREFIX_START_DATE).get());
        RenewalDate endDate = ParserUtil.parseRenewalDate(argMultimap.getValue(PREFIX_END_DATE).get());

        if (startDate.value.isAfter(endDate.value)) {
            throw new ParseException(MESSAGE_INVALID_START_DATE);
        }

        LocalDate maxAllowedDate = LocalDate.now().plusYears(MAX_YEARS_RANGE);
        if (endDate.value.isAfter(maxAllowedDate)) {
            throw new ParseException(MESSAGE_INVALID_END_DATE);
        }

        if (argMultimap.getValue(PREFIX_SORT_ORDER).isPresent()) {
            sortOrder = argMultimap.getValue(PREFIX_SORT_ORDER).get().toLowerCase();
            if (!isValidSortOrder(sortOrder)) {
                throw new ParseException(MESSAGE_INVALID_SORT);
            }
        }

        return new FilterDateCommand(startDate, endDate, sortOrder);
    }

    private boolean isValidSortOrder(String sortOrder) {
        return FilterDateCommand.SORT_BY_NAME.equals(sortOrder)
                || FilterDateCommand.SORT_BY_DATE.equals(sortOrder);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
