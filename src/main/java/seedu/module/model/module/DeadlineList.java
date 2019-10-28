package seedu.module.model.module;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the DeadlineList of a TrackedModule.
 */
public class DeadlineList {
    private List<Deadline> deadlineList = new ArrayList<>();

    /**
     * Adds the deadline object to deadline list.
     * @param deadline
     */
    public void addDeadline (Deadline deadline) {
        this.deadlineList.add(deadline);
    }

    /**
     * returns the deadline list.
     * @return deadline list.
     */
    public List<Deadline> getDeadlineList() {
        return deadlineList;
    }

    /**
     * Returns the string representation of deadline list.
     * @return string deadline list as String.
     */
    public String toString() {
        String deadlineString = "Deadline: \n";
        for (int i = 0; i < deadlineList.size(); i++) {
            deadlineString += ((i + 1) + ". " + deadlineList.get(i).getDescription()
                    + ", " + deadlineList.get(i).getTime()) + "\n";
        }
        return deadlineString;
    }
}
