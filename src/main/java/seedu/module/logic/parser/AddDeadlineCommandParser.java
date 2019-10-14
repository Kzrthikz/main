package seedu.module.logic.parser;

import static seedu.module.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.module.commons.core.index.Index;
import seedu.module.logic.commands.AddCommand;
import seedu.module.logic.commands.AddDeadlineCommand;
import seedu.module.logic.parser.exceptions.ParseException;
import seedu.module.model.module.NameContainsKeywordsPredicate;

public class AddDeadlineCommandParser implements Parser<AddDeadlineCommand>  {

    public AddDeadlineCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddDeadlineCommand.MESSAGE_USAGE));
        }
        NameContainsKeywordsPredicate predicate = new NameContainsKeywordsPredicate(Arrays.asList(trimmedArgs));

        return new AddDeadlineCommand(predicate);
    }
}
