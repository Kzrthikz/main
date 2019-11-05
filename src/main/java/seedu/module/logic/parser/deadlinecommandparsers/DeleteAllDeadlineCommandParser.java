package seedu.module.logic.parser.deadlinecommandparsers;

import seedu.module.commons.core.index.Index;
import seedu.module.logic.commands.deadlinecommands.DeleteAllDeadlineCommand;
import seedu.module.logic.parser.ArgumentMultimap;
import seedu.module.logic.parser.ParserUtil;
import seedu.module.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteAllDeadlineCommand object.
 */
public class DeleteAllDeadlineCommandParser {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteAllDeadlineCommand
     * and returns a DeleteAllDeadlineCommand object for execution.
     * @param argsMultimap
     * @return DeleteAllDeadlineCommand
     * @throws ParseException if the user input does not conform the expected format.
     */
    public DeleteAllDeadlineCommand parse(ArgumentMultimap argsMultimap) throws ParseException {
        Index index = ParserUtil.parseIndex(argsMultimap.getPreamble());
        return new DeleteAllDeadlineCommand(index);
    }
}

