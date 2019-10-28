package seedu.module.logic.commands;

import java.util.List;

import seedu.module.commons.core.Messages;
import seedu.module.commons.core.index.Index;
import seedu.module.logic.commands.exceptions.CommandException;
import seedu.module.model.Model;
import seedu.module.model.module.TrackedModule;

/**
 * Deletes a specified deadline task from a module's deadline list.
 */
public class DeleteDeadlineTaskCommand extends DeleteDeadlineCommand {
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes entire Deadline list identified by the index number used in the displayed Module list.\n"
            + "Parameters: INDEX (must be a positive integer), \n"
            + "TASK(must be a positive integer) \n"
            + "Example: deadline 2 a/" + COMMAND_WORD + " task/2";

    private Index index;
    private int taskListNum;
    private TrackedModule moduleToDeleteDeadline;

    public DeleteDeadlineTaskCommand(Index index, int taskListNum) {
        this.index = index;
        this.taskListNum = taskListNum;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<TrackedModule> lastShownList = model.getFilteredModuleList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_MODULE_DISPLAYED_INDEX);
        }

        moduleToDeleteDeadline = lastShownList.get(index.getZeroBased());
        moduleToDeleteDeadline.deleteDeadlineTask(taskListNum - 1);

        model.updateFilteredModuleList(Model.PREDICATE_SHOW_ALL_MODULES);
        model.displayTrackedList();

        return new CommandResult(generateSuccessMessage(moduleToDeleteDeadline));
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code moduleToEdit}.
     */
    private String generateSuccessMessage(TrackedModule moduleToAddDeadline) {
        String message = MESSAGE_DELETE_DEADLINE_SUCCESS;
        return String.format(message, moduleToAddDeadline);
    }
}
