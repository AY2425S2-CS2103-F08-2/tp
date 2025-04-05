package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.END_DATE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_END_DATE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_SORT_ORDER_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_START_DATE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.SORT_ORDER_DESC_DATE;
import static seedu.address.logic.commands.CommandTestUtil.SORT_ORDER_DESC_NAME;
import static seedu.address.logic.commands.CommandTestUtil.START_DATE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.VALID_END_DATE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SORT_ORDER_DATE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SORT_ORDER_NAME;
import static seedu.address.logic.commands.CommandTestUtil.VALID_START_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_END_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SORT_ORDER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_START_DATE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.FilterDateCommand;
import seedu.address.model.person.RenewalDate;

public class FilterDateCommandParserTest {

    private final FilterDateCommandParser parser = new FilterDateCommandParser();

    @Test
    public void parse_allArgsSpecified_success() {
        String userInput = START_DATE_DESC + END_DATE_DESC + SORT_ORDER_DESC_NAME;
        FilterDateCommand expectedCommand = new FilterDateCommand(
                new RenewalDate(VALID_START_DATE),
                new RenewalDate(VALID_END_DATE),
                VALID_SORT_ORDER_NAME
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
                VALID_SORT_ORDER_DATE
        );

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_startDateAfterEndDate_throwsParseException() {
        assertParseFailure(parser, " sd/01-04-2025 ed/01-03-2025", FilterDateCommandParser.MESSAGE_INVALID_START_DATE);
    }

    @Test
    public void parse_endDateBeyondMaxYears_throwsParseException() {
        assertParseFailure(parser, " sd/01-03-2025 ed/01-03-2031", FilterDateCommandParser.MESSAGE_INVALID_END_DATE);
    }

    @Test
    public void parse_invalidDateFormat_throwsParseException() {
        assertParseFailure(parser, " sd/2025-01-01 ed/2025-03-31", RenewalDate.DATE_CONSTRAINTS);
    }

    @Test
    public void parse_nonExistentDate_failure() {
        // Invalid start date
        assertParseFailure(parser, INVALID_START_DATE_DESC + END_DATE_DESC,
                RenewalDate.DATE_CONSTRAINTS);

        // Invalid end date
        assertParseFailure(parser, START_DATE_DESC + INVALID_END_DATE_DESC,
                RenewalDate.DATE_CONSTRAINTS);

        // Both dates invalid
        assertParseFailure(parser, INVALID_START_DATE_DESC + INVALID_END_DATE_DESC,
                RenewalDate.DATE_CONSTRAINTS);
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
                VALID_SORT_ORDER_NAME
        );

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_startDateEqualsEndDate_success() {
        String userInput = " sd/01-03-2025 ed/01-03-2025" + SORT_ORDER_DESC_DATE; // Same start and end date
        FilterDateCommand expectedCommand = new FilterDateCommand(
                new RenewalDate(VALID_START_DATE),
                new RenewalDate(VALID_START_DATE),
                VALID_SORT_ORDER_DATE
        );

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_endDateAtMaxAllowedLimit_success() {
        RenewalDate startDate = new RenewalDate(VALID_START_DATE);
        RenewalDate endDate = new RenewalDate("01-03-2030"); // Max limit of 5 years

        String userInput = " sd/01-03-2025 ed/01-03-2030 s/date";
        FilterDateCommand expectedCommand = new FilterDateCommand(startDate, endDate, VALID_SORT_ORDER_DATE);

        assertParseSuccess(parser, userInput, expectedCommand);
    }
}
