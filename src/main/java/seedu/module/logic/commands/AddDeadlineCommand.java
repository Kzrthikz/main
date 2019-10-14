package seedu.module.logic.commands;

import seedu.module.commons.core.index.Index;
import seedu.module.logic.commands.exceptions.CommandException;
import seedu.module.model.Model;

public class AddDeadlineCommand extends Command {
    public static final String COMMAND_WORD = "add_deadline";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a deadline to a specific module in the ModuleBook. "
            + "Parameters: "
            + "module code\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + "d/ quiz submission /by 2/2/2019 2359";

    public static final String MESSAGE_SUCCESS = "New module added: %1$s";

    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Deadline: %2$S";

    private final Index index;
    private final String deadlineDescription;

    public AddDeadlineCommand(Index index,  String deadlineDescription) {
        this.index = index;
        this.deadlineDescription = deadlineDescription;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException{
        throw new CommandException(String.format(MESSAGE_ARGUMENTS, index.getOneBased(), deadlineDescription));
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) {
            return true;
        }
        if(!(other instanceof AddDeadlineCommand)) {
            return false;
        }
        AddDeadlineCommand e = (AddDeadlineCommand) other;
        return index.equals(e.deadlineDescription);
    }
}
