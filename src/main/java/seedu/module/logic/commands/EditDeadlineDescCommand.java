package seedu.module.logic.commands;

import java.util.List;

import seedu.module.commons.core.Messages;
import seedu.module.commons.core.index.Index;
import seedu.module.logic.commands.exceptions.CommandException;
import seedu.module.model.Model;
import seedu.module.model.module.Deadline;
import seedu.module.model.module.TrackedModule;

/**
 * Edits deadline description of a module.
 */
public class EditDeadlineDescCommand extends EditDeadlineCommand {
    private Index index;
    private String description;
    private int taskListNum;
    private Deadline deadline;

    public EditDeadlineDescCommand(Index index, String description, int taskListNum) {
        this.index = index;
        this.description = description;
        this.taskListNum = taskListNum;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<TrackedModule> lastShownList = model.getFilteredModuleList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_MODULE_DISPLAYED_INDEX);
        }

        TrackedModule moduleToEditDeadline = lastShownList.get(index.getZeroBased());
        deadline = moduleToEditDeadline.getDeadlineList().get(taskListNum - 1);
        deadline.editDescription(description);

        model.updateFilteredModuleList(Model.PREDICATE_SHOW_ALL_MODULES);
        model.displayTrackedList();

        return new CommandResult(generateSuccessMessage(moduleToEditDeadline));
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code moduleToEdit}.
     */
    private String generateSuccessMessage(TrackedModule moduleToAddDeadline) {
        String message = !deadline.getDescription().isEmpty() ? MESSAGE_EDIT_DEADLINE_SUCCESS
                : MESSAGE_EDIT_DEADLINE_FAIL;
        return String.format(message, moduleToAddDeadline);
    }
}
