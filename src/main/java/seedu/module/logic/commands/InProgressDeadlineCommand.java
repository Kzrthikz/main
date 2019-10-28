package seedu.module.logic.commands;

import java.util.List;

import seedu.module.commons.core.Messages;
import seedu.module.commons.core.index.Index;
import seedu.module.logic.commands.exceptions.CommandException;
import seedu.module.model.Model;
import seedu.module.model.module.TrackedModule;

/**
 * Marks a specified deadline task from a module's deadline list as 'In-Progress' with a dash.
 */
public class InProgressDeadlineCommand extends DeadlineCommand {

    public static final String COMMAND_WORD = "inProgress";

    public static final String MESSAGE_IN_PROGRESS_DEADLINE_SUCCESS = "Mark deadline as In-Progress for module: %1$s";
    public static final String MESSAGE_IN_PROGRESS_DEADLINE_FAIL = "Unable to mark deadline as Done from module: %1$s";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Marks the deadline task identified by the index number as in progress.\n"
            + "Parameters: INDEX (must be a positive integer), \n"
            + "TASK(must be a positive integer) \n"
            + "Example: deadline 2 a/" + COMMAND_WORD + " task/2";

    private Index index;
    private int taskListNum;
    private TrackedModule moduleToMarkDeadline;

    public InProgressDeadlineCommand(Index index, int taskListNum) {
        this.index = index;
        this.taskListNum = taskListNum;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<TrackedModule> lastShownList = model.getFilteredModuleList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_MODULE_DISPLAYED_INDEX);
        }

        moduleToMarkDeadline = lastShownList.get(index.getZeroBased());
        moduleToMarkDeadline.markDeadlineTaskAsInProgress(taskListNum - 1);

        model.updateFilteredModuleList(Model.PREDICATE_SHOW_ALL_MODULES);
        model.displayTrackedList();

        return new CommandResult(generateSuccessMessage(moduleToMarkDeadline));
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code moduleToEdit}.
     */
    private String generateSuccessMessage(TrackedModule moduleToAddDeadline) {
        String message = MESSAGE_IN_PROGRESS_DEADLINE_SUCCESS;
        return String.format(message, moduleToAddDeadline);
    }
}
