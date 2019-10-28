package seedu.module.logic.parser;

import static seedu.module.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.module.logic.parser.CliSyntax.PREFIX_TASK_LIST_NUMBER;

import seedu.module.commons.core.index.Index;
import seedu.module.logic.commands.DeleteDeadlineCommand;
import seedu.module.logic.commands.DeleteDeadlineTaskCommand;
import seedu.module.logic.parser.exceptions.ParseException;
import seedu.module.model.module.Deadline;

/**
 * Parses input arguments and creates a new DeleteDeadlineCommand object
 */
public class DeleteDeadlineCommandParser {

    /**
     * Parses the given {@code String} of arguments in the context of the EditDeadlineCommand
     * and returns an EditDeadlineCommand object for execution.
     * @param argsMultimap
     * @return DeleteDeadlineCommand
     * @throws ParseException if the user input does not conform the expected format.
     */
    public DeleteDeadlineCommand parse(ArgumentMultimap argsMultimap) throws ParseException {
        Index index = ParserUtil.parseIndex(argsMultimap.getPreamble());
        if (argsMultimap.getValue(PREFIX_TASK_LIST_NUMBER).isPresent()) {
            try {
                int taskListNum = Integer.parseInt(argsMultimap.getValue(PREFIX_TASK_LIST_NUMBER).get().trim());
                return new DeleteDeadlineTaskCommand(index, taskListNum);
            } catch (NumberFormatException e) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteDeadlineCommand.MESSAGE_USAGE), e);
            }
        } else {
            throw new ParseException(Deadline.MESSAGE_CONSTRAINTS);
        }

    }
}
