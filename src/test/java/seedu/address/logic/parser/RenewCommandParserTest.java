package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_POLICY_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_RENEWAL_DATE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.POLICY_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.POLICY_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.RENEWAL_DATE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_POLICY_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_RENEWAL_DATE_AMY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RENEWAL_DATE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.RenewCommand;
import seedu.address.model.person.Policy;
import seedu.address.model.person.RenewalDate;

public class RenewCommandParserTest {

    private RenewCommandParser parser = new RenewCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        // Valid policy number and renewal date
        assertParseSuccess(parser, POLICY_DESC_AMY + RENEWAL_DATE_DESC_AMY,
                new RenewCommand(VALID_POLICY_AMY, new RenewalDate(VALID_RENEWAL_DATE_AMY)));
        // whitespace only preamble
        assertParseSuccess(parser, "  " + POLICY_DESC_AMY + RENEWAL_DATE_DESC_AMY,
                new RenewCommand(VALID_POLICY_AMY, new RenewalDate(VALID_RENEWAL_DATE_AMY)));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, RenewCommand.MESSAGE_USAGE);

        // missing policy prefix
        assertParseFailure(parser, VALID_POLICY_AMY + RENEWAL_DATE_DESC_AMY, expectedMessage);

        // missing renewal date prefix
        assertParseFailure(parser, POLICY_DESC_AMY + VALID_RENEWAL_DATE_AMY, expectedMessage);

        // missing both prefixes
        assertParseFailure(parser, VALID_POLICY_AMY + VALID_RENEWAL_DATE_AMY, expectedMessage);

        // missing renewal date value
        assertParseFailure(parser, POLICY_DESC_AMY + PREFIX_RENEWAL_DATE + " ", expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid policy number
        assertParseFailure(parser, INVALID_POLICY_DESC + RENEWAL_DATE_DESC_AMY, Policy.MESSAGE_CONSTRAINTS);

        // invalid renewal date format
        assertParseFailure(parser, POLICY_DESC_AMY + INVALID_RENEWAL_DATE_DESC, RenewalDate.DATE_FORMAT_CONSTRAINTS);

        // valid format but past date
        String pastDate = LocalDate.now().minusDays(1).format(RenewalDate.DATE_FORMATTER);
        assertParseFailure(parser, POLICY_DESC_AMY + " r/" + pastDate, RenewalDate.DATE_FUTURE_CONSTRAINTS);

        // today's date (should fail with future date error)
        String todayDate = LocalDate.now().format(RenewalDate.DATE_FORMATTER);
        assertParseFailure(parser, POLICY_DESC_AMY + " r/" + todayDate, RenewalDate.DATE_FUTURE_CONSTRAINTS);

        // invalid policy number and invalid renewal date format
        assertParseFailure(parser, INVALID_POLICY_DESC + INVALID_RENEWAL_DATE_DESC, Policy.MESSAGE_CONSTRAINTS);

        // multiple policy numbers
        assertParseFailure(parser, POLICY_DESC_AMY + POLICY_DESC_BOB + RENEWAL_DATE_DESC_AMY,
                RenewCommandParser.MESSAGE_MULTIPLE_POLICIES);

        // tomorrow's date (should pass)
        String tomorrowDate = LocalDate.now().plusDays(1).format(RenewalDate.DATE_FORMATTER);
        assertParseSuccess(parser, POLICY_DESC_AMY + " r/" + tomorrowDate,
                new RenewCommand(VALID_POLICY_AMY, new RenewalDate(tomorrowDate)));
    }
}
