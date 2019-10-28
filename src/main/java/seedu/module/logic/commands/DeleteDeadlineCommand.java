package seedu.module.logic.commands;

/**
 * Deletes deadline command.
 */
public abstract class DeleteDeadlineCommand extends DeadlineCommand {
    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_DELETE_DEADLINE_SUCCESS = "Deleted deadline from module: %1$s";
    public static final String MESSAGE_DELETE_DEADLINE_FAIL = "Unable to delete deadline from module: %1$s";
}
