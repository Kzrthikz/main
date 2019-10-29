package seedu.module.logic.parser;

import static seedu.module.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.module.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.module.logic.parser.CliSyntax.PREFIX_TASK_LIST_NUMBER;

import seedu.module.commons.core.index.Index;
import seedu.module.logic.commands.PriorityDeadlineCommand;
import seedu.module.logic.parser.exceptions.ParseException;
import seedu.module.model.module.Deadline;

/**
 * Parses input and creates a PriorityDeadlineCommand object.
 */
public class PriorityDeadlineCommandParser {
    /**
     * Parses the given {@code String} of arguments in the context of the PriorityDeadlineCommand
     * and returns an PriorityDeadlineCommand object for execution.
     * @param argsMultimap
     * @return PriorityDeadlineCommand
     * @throws ParseException if the user input does not conform the expected format.
     */
    public PriorityDeadlineCommand parse(ArgumentMultimap argsMultimap) throws ParseException {
        Index index = ParserUtil.parseIndex(argsMultimap.getPreamble());
        if (argsMultimap.getValue(PREFIX_TAG).isPresent()
                && argsMultimap.getValue(PREFIX_TASK_LIST_NUMBER).isPresent()) {
            try {
                String tag = argsMultimap.getValue(PREFIX_TAG).get().trim();
                int taskListNum = Integer.parseInt(argsMultimap.getValue(PREFIX_TASK_LIST_NUMBER).get().trim());
                return new PriorityDeadlineCommand(index, tag, taskListNum);
            } catch (NumberFormatException e) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, PriorityDeadlineCommand.MESSAGE_USAGE), e);
            }
        } else {
            throw new ParseException(Deadline.MESSAGE_CONSTRAINTS);
        }
    }
}
