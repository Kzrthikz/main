package seedu.module.logic.commands;

import static seedu.module.logic.parser.CliSyntax.PREFIX_ACTION;
import static seedu.module.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.module.logic.parser.CliSyntax.PREFIX_TIME;

/**
 * Adds, Edits or Deletes a Deadline in a Module depending on input.
 */
public abstract class DeadlineCommand extends Command {

    public static final String COMMAND_WORD = "deadline";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds,deletes or edits a Deadline to a Module. "
            + "Parameters: "
            + "INDEX (must be a positive integer) "
            + PREFIX_ACTION + "ACTION\n"
            + PREFIX_DESCRIPTION + "DESCRIPTION\n"
            + PREFIX_TIME + "TIME\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_DESCRIPTION + " quiz submission " + PREFIX_TIME + "2/2/2019 2359";

    public static final String MESSAGE_ADD_DEADLINE_SUCCESS = "Added deadline to Module: %1$s";
    public static final String MESSAGE_DELETE_DEADLINE_SUCCESS = "Removed deadline from module: %1$s";
    public static final String MESSAGE_EDIT_DEADLINE_SUCCESS = "Edited deadline to Module: %1$s";
    public static final String MESSAGE_EDIT_DEADLINE_FAIL = "Unable to Edited deadline to Module: %1$s";

}

