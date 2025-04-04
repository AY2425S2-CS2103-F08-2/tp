package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.address.logic.commands.CommandTestUtil.END_DATE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_SORT_ORDER_DESC;
import static seedu.address.logic.commands.CommandTestUtil.SORT_ORDER_DESC_DATE;
import static seedu.address.logic.commands.CommandTestUtil.SORT_ORDER_DESC_NAME;
import static seedu.address.logic.commands.CommandTestUtil.START_DATE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SORT_ORDER_DATE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SORT_ORDER_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_END_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SORT_ORDER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_START_DATE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.FilterDateCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class FilterDateCommandParserTest {

    private final FilterDateCommandParser parser = new FilterDateCommandParser();

    @Test
    public void parse_validArgs_returnsFilterDateCommand() {
        String userInput = START_DATE_DESC + END_DATE_DESC + SORT_ORDER_DESC_NAME;
        FilterDateCommand expectedCommand = new FilterDateCommand(
                LocalDate.of(2025, 3, 1),
                LocalDate.of(2025, 3, 31),
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
    public void parse_missingStartDate_throwsParseException() {
        String userInput = END_DATE_DESC + SORT_ORDER_DESC_DATE;
        assertThrows(ParseException.class, () -> parser.parse(userInput));
    }

    @Test
    public void parse_missingEndDate_throwsParseException() {
        String userInput = START_DATE_DESC + SORT_ORDER_DESC_NAME;
        assertThrows(ParseException.class, () -> parser.parse(userInput));
    }

    @Test
    public void parse_startDateAfterEndDate_throwsParseException() {
        String userInput = " sd/01-04-2025 ed/01-03-2025";
        assertThrows(ParseException.class, () -> parser.parse(userInput));
    }

    @Test
    public void parse_endDateBeyondMaxYears_throwsParseException() {
        String userInput = " sd/01-03-2025 ed/01-03-2031";
        assertThrows(ParseException.class, () -> parser.parse(userInput));
    }

    @Test
    public void parse_invalidDateFormat_throwsParseException() {
        String userInput = " sd/2025-01-01 ed/2025-03-31" + SORT_ORDER_DESC_DATE; // Incorrect date format
        assertThrows(IllegalArgumentException.class, () -> parser.parse(userInput));
    }

    @Test
    public void parse_nonExistentDate_throwsParseException() {
        String userInput = " sd/30-02-2025 ed/31-03-2025" + SORT_ORDER_DESC_DATE; // Feb 30 does not exist
        assertThrows(IllegalArgumentException.class, () -> parser.parse(userInput));
    }

    @Test
    public void parse_nonExistentSortType_throwsParseException() {
        String userInput = " sd/11-02-2025 ed/31-03-2025" + INVALID_SORT_ORDER_DESC;
        assertThrows(ParseException.class, () -> parser.parse(userInput));
    }

    @Test
    public void parse_noSortOrder_defaultsToDate() throws Exception {
        String userInput = " sd/01-03-2025 ed/31-03-2025";
        FilterDateCommand expectedCommand = new FilterDateCommand(
                LocalDate.of(2025, 3, 1),
                LocalDate.of(2025, 3, 31),
                VALID_SORT_ORDER_DATE
        );

        assertEquals(expectedCommand, parser.parse(userInput));
    }

    @Test
    public void parse_caseInsensitiveSortOrder_valid() throws Exception {
        String userInput = " sd/01-03-2025 ed/31-03-2025 s/NaMe"; // Mixed lower and upper case
        FilterDateCommand expectedCommand = new FilterDateCommand(
                LocalDate.of(2025, 3, 1),
                LocalDate.of(2025, 3, 31),
                VALID_SORT_ORDER_NAME
        );

        assertEquals(expectedCommand, parser.parse(userInput));
    }

    @Test
    public void parse_extraSpaces_trimmedCorrectly() throws Exception {
        String userInput = "  sd/01-03-2025   ed/31-03-2025   s/name   ";
        FilterDateCommand expectedCommand = new FilterDateCommand(
                LocalDate.of(2025, 3, 1),
                LocalDate.of(2025, 3, 31),
                VALID_SORT_ORDER_NAME
        );

        assertEquals(expectedCommand, parser.parse(userInput));
    }

    @Test
    public void parse_emptyInput_throwsParseException() {
        String userInput = "";
        assertThrows(ParseException.class, () -> parser.parse(userInput));
    }

    @Test
    public void parse_startDateEqualsEndDate_valid() throws Exception {
        String userInput = " sd/01-03-2025 ed/01-03-2025" + SORT_ORDER_DESC_DATE; // Same start and end date
        FilterDateCommand expectedCommand = new FilterDateCommand(
                LocalDate.of(2025, 3, 1),
                LocalDate.of(2025, 3, 1),
                VALID_SORT_ORDER_DATE
        );

        assertEquals(expectedCommand, parser.parse(userInput));
    }

    @Test
    public void parse_endDateAtMaxAllowedLimit_valid() throws Exception {
        LocalDate startDate = LocalDate.of(2025, 3, 1);
        LocalDate endDate = LocalDate.of(2030, 3, 1); // Max limit of 5 years

        String userInput = " sd/01-03-2025 ed/01-03-2030 s/date";
        FilterDateCommand expectedCommand = new FilterDateCommand(startDate, endDate, VALID_SORT_ORDER_DATE);

        assertEquals(expectedCommand, parser.parse(userInput));
    }
}
