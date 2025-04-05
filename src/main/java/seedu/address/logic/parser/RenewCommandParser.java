package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_POLICY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RENEWAL_DATE;

import java.util.stream.Stream;

import seedu.address.logic.commands.RenewCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Policy;
import seedu.address.model.person.RenewalDate;

/**
 * Parses input arguments and creates a new RenewCommand object
 */
public class RenewCommandParser implements Parser<RenewCommand> {

    public static final String MESSAGE_MULTIPLE_POLICIES = "Only one policy number is allowed for the renew command.";

    /**
     * Parses the given {@code String} of arguments in the context of the RenewCommand
     * and returns a RenewCommand object for execution.
     * @throws ParseException if the user input does not conform to the expected format
     */
    public RenewCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_POLICY, PREFIX_RENEWAL_DATE);

        if (!arePrefixesPresent(argMultimap, PREFIX_POLICY, PREFIX_RENEWAL_DATE)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, RenewCommand.MESSAGE_USAGE));
        }

        // Check for multiple policy numbers
        if (argMultimap.getAllValues(PREFIX_POLICY).size() > 1) {
            throw new ParseException(MESSAGE_MULTIPLE_POLICIES);
        }

        String policyNumber = argMultimap.getValue(PREFIX_POLICY).get();
        String renewalDate = argMultimap.getValue(PREFIX_RENEWAL_DATE).get();

        if (!Policy.isValidPolicy(policyNumber)) {
            throw new ParseException(Policy.MESSAGE_CONSTRAINTS);
        }

        if (!RenewalDate.isValidDateFormat(renewalDate)) {
            throw new ParseException(RenewalDate.DATE_FORMAT_CONSTRAINTS);
        }

        if (!RenewalDate.isFutureDate(renewalDate)) {
            throw new ParseException(RenewalDate.DATE_FUTURE_CONSTRAINTS);
        }

        return new RenewCommand(policyNumber, new RenewalDate(renewalDate));
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
