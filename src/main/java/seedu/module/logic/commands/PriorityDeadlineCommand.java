package seedu.module.logic.commands;

import java.util.List;

import seedu.module.commons.core.Messages;
import seedu.module.commons.core.index.Index;
import seedu.module.logic.commands.exceptions.CommandException;
import seedu.module.model.Model;
import seedu.module.model.module.TrackedModule;

/**
 * Creates a tag of priority to the deadline task.
 */
public class PriorityDeadlineCommand extends DeadlineCommand {
    public static final String COMMAND_WORD = "priority";

    public static final String MESSAGE_PRIORITY_DEADLINE_SUCCESS = "Added priority to deadline from module: %1$s";
    public static final String MESSAGE_PRIORITY_DEADLINE_FAIL = "Unable to add priority to deadline from module: %1$s";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds priority tag identified by the index number used in the displayed Module list.\n"
            + "Parameters: INDEX (must be a positive integer), \n"
            + "Tag: HIGH/MEDIUM/LOW"
            + "TASK Number(must be a positive integer) \n"
            + "Example: deadline 2 a/" + COMMAND_WORD + " tag/High task/2";

    private Index index;
    private int taskListNum;
    private String tag;
    private TrackedModule moduleToAddPriorityTag;

    public PriorityDeadlineCommand(Index index, String tag, int taskListNum) {
        this.index = index;
        this.taskListNum = taskListNum;
        this.tag = tag;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<TrackedModule> lastShownList = model.getFilteredModuleList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_MODULE_DISPLAYED_INDEX);
        }

        moduleToAddPriorityTag = lastShownList.get(index.getZeroBased());
        moduleToAddPriorityTag.addPriorityTag(taskListNum - 1);

        model.updateFilteredModuleList(Model.PREDICATE_SHOW_ALL_MODULES);
        model.displayTrackedList();

        return new CommandResult(generateSuccessMessage(moduleToAddPriorityTag));
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code moduleToEdit}.
     */
    private String generateSuccessMessage(TrackedModule moduleToAddDeadline) {
        String message = MESSAGE_PRIORITY_DEADLINE_SUCCESS;
        return String.format(message, moduleToAddDeadline);
    }
}
