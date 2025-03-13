package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FilterDateCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class FilterDateCommandParserTest {

    private final FilterDateCommandParser parser = new FilterDateCommandParser();

    @Test
    public void parse_validArgs_returnsFilterDateCommand() throws Exception {
        String userInput = "sd/2025-03-01 ed/2025-03-31 s/name";
        FilterDateCommand expectedCommand = new FilterDateCommand(
                LocalDate.of(2025, 3, 1),
                LocalDate.of(2025, 3, 31),
                "name"
        );

        assertEquals(expectedCommand, parser.parse(userInput));
    }

    /* to be continued
    @Test
    public void parse_missingStartDate_throwsParseException() {
        String userInput = "ed/2025-03-31 s/date";
        assertThrows(ParseException.class, () -> parser.parse(userInput));
    }
    */

    /* to be continued
    @Test
    public void parse_missingEndDate_throwsParseException() {
        String userInput = "sd/2025-03-01 s=name";
        assertThrows(ParseException.class, () -> parser.parse(userInput));
    }
    */

    @Test
    public void parse_startDateAfterEndDate_throwsParseException() {
        String userInput = "sd/2025-04-01 ed/2025-03-01";
        assertThrows(ParseException.class, () -> parser.parse(userInput));
    }

    /* to be continued
    @Test
    public void parse_invalidSortOrder_throwsParseException() {
        String userInput = "sd/2025-03-01 ed/2025-03-31 s/random";
        assertThrows(ParseException.class, () -> parser.parse(userInput));
    }
    */


    @Test
    public void parse_noSortOrder_defaultsToDate() throws Exception {
        String userInput = "sd/2025-03-01 ed/2025-03-31";
        FilterDateCommand expectedCommand = new FilterDateCommand(
                LocalDate.of(2025, 3, 1),
                LocalDate.of(2025, 3, 31),
                "date"
        );

        assertEquals(expectedCommand, parser.parse(userInput));
    }
}