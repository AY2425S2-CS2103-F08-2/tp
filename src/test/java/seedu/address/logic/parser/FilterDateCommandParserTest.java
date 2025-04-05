package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_END_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SORT_ORDER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_START_DATE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.FilterDateCommand;
import seedu.address.model.person.RenewalDate;

public class FilterDateCommandParserTest {
    private static final String VALID_START_DATE = LocalDate.now().plusMonths(1).format(RenewalDate.DATE_FORMATTER);
    private static final String VALID_END_DATE = LocalDate.now().plusMonths(2).format(RenewalDate.DATE_FORMATTER);
    private static final String START_DATE_DESC = " " + PREFIX_START_DATE + VALID_START_DATE;
    private static final String END_DATE_DESC = " " + PREFIX_END_DATE + VALID_END_DATE;
    private static final String SORT_ORDER_DESC_NAME = " " + PREFIX_SORT_ORDER + "name";
    private static final String SORT_ORDER_DESC_DATE = " " + PREFIX_SORT_ORDER + "date";
    private static final String INVALID_START_DATE_DESC = " " + PREFIX_START_DATE + "30-02-2025"; // invalid day
    private static final String INVALID_END_DATE_DESC = " " + PREFIX_END_DATE + "31-04-2025"; // invalid day
    private static final String INVALID_SORT_ORDER_DESC = " " + PREFIX_SORT_ORDER + "invalid";

    private final FilterDateCommandParser parser = new FilterDateCommandParser();

    @Test
    public void parse_allArgsSpecified_success() {
        String userInput = START_DATE_DESC + END_DATE_DESC + SORT_ORDER_DESC_NAME;
        FilterDateCommand expectedCommand = new FilterDateCommand(
                new RenewalDate(VALID_START_DATE),
                new RenewalDate(VALID_END_DATE),
                "name"
        );

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_repeatedValue_failure() {
        String validUserInput = START_DATE_DESC + END_DATE_DESC + SORT_ORDER_DESC_NAME;

        // Multiple start date prefixes
        assertParseFailure(parser, START_DATE_DESC + validUserInput,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_START_DATE));

        // Multiple end date prefixes
        assertParseFailure(parser, END_DATE_DESC + validUserInput,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_END_DATE));

        // Multiple sort order prefixes
        assertParseFailure(parser, SORT_ORDER_DESC_NAME + validUserInput,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_SORT_ORDER));

        // Multiple fields repeated
        assertParseFailure(parser, START_DATE_DESC + END_DATE_DESC + SORT_ORDER_DESC_NAME
                + validUserInput,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_START_DATE, PREFIX_END_DATE, PREFIX_SORT_ORDER));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterDateCommand.MESSAGE_USAGE);

        // Empty input
        assertParseFailure(parser, "", expectedMessage);

        // Missing start date
        assertParseFailure(parser, END_DATE_DESC, expectedMessage);

        // Missing end date
        assertParseFailure(parser, START_DATE_DESC, expectedMessage);
    }

    @Test
    public void parse_noSortOrder_defaultsToDate() {
        String userInput = START_DATE_DESC + END_DATE_DESC;
        FilterDateCommand expectedCommand = new FilterDateCommand(
                new RenewalDate(VALID_START_DATE),
                new RenewalDate(VALID_END_DATE),
                "date"
        );

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_startDateAfterEndDate_throwsParseException() {
        String laterDate = LocalDate.now().plusMonths(3).format(RenewalDate.DATE_FORMATTER);
        String earlierDate = LocalDate.now().plusMonths(1).format(RenewalDate.DATE_FORMATTER);
        assertParseFailure(parser,
            " " + PREFIX_START_DATE + laterDate + " " + PREFIX_END_DATE + earlierDate,
            FilterDateCommandParser.MESSAGE_INVALID_START_DATE);
    }

    @Test
    public void parse_endDateBeyondMaxYears_throwsParseException() {
        String startDate = LocalDate.now().plusMonths(1).format(RenewalDate.DATE_FORMATTER);
        String farFutureDate = LocalDate.now().plusYears(6).format(RenewalDate.DATE_FORMATTER);
        assertParseFailure(parser,
            " " + PREFIX_START_DATE + startDate + " " + PREFIX_END_DATE + farFutureDate,
            FilterDateCommandParser.MESSAGE_INVALID_END_DATE);
    }

    @Test
    public void parse_invalidDateFormat_throwsParseException() {
        assertParseFailure(parser, " sd/2025-01-01 ed/2025-03-31", RenewalDate.DATE_FORMAT_CONSTRAINTS);
    }

    @Test
    public void parse_nonExistentDate_failure() {
        // Invalid start date
        assertParseFailure(parser, INVALID_START_DATE_DESC + END_DATE_DESC,
                RenewalDate.DATE_FORMAT_CONSTRAINTS);

        // Invalid end date
        assertParseFailure(parser, START_DATE_DESC + INVALID_END_DATE_DESC,
                RenewalDate.DATE_FORMAT_CONSTRAINTS);

        // Both dates invalid
        assertParseFailure(parser, INVALID_START_DATE_DESC + INVALID_END_DATE_DESC,
                RenewalDate.DATE_FORMAT_CONSTRAINTS);
    }

    @Test
    public void parse_nonExistentSortType_throwsParseException() {
        assertParseFailure(parser, START_DATE_DESC + END_DATE_DESC + INVALID_SORT_ORDER_DESC,
                FilterDateCommandParser.MESSAGE_INVALID_SORT);
    }

    @Test
    public void parse_caseInsensitiveSortOrder_success() {
        String userInput = START_DATE_DESC + END_DATE_DESC + " s/NaMe"; // Mixed lower and upper case
        FilterDateCommand expectedCommand = new FilterDateCommand(
                new RenewalDate(VALID_START_DATE),
                new RenewalDate(VALID_END_DATE),
                "name"
        );

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_startDateEqualsEndDate_success() {
        String sameDate = LocalDate.now().plusMonths(1).format(RenewalDate.DATE_FORMATTER);
        String userInput = " " + PREFIX_START_DATE + sameDate + " " + PREFIX_END_DATE + sameDate + SORT_ORDER_DESC_DATE;
        FilterDateCommand expectedCommand = new FilterDateCommand(
                new RenewalDate(sameDate),
                new RenewalDate(sameDate),
                "date"
        );

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_endDateAtMaxAllowedLimit_success() {
        String startDate = LocalDate.now().plusMonths(1).format(RenewalDate.DATE_FORMATTER);
        String maxDate = LocalDate.now().plusYears(5).minusDays(1).format(RenewalDate.DATE_FORMATTER);
        String userInput = " " + PREFIX_START_DATE + startDate + " " + PREFIX_END_DATE + maxDate + " s/date";
        FilterDateCommand expectedCommand = new FilterDateCommand(
                new RenewalDate(startDate),
                new RenewalDate(maxDate),
                "date"
        );

        assertParseSuccess(parser, userInput, expectedCommand);
    }
}
