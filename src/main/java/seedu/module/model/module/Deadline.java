package seedu.module.model.module;

import static java.util.Objects.requireNonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

import seedu.module.logic.commands.exceptions.CommandException;
import seedu.module.logic.parser.exceptions.ParseException;

/**
 * Represents Priority tags in Enum
 */
enum Priority {
    HIGH, MEDIUM, LOW;
    public boolean isValid() {
        return true;
    }
}

/**
 * Represents a Module's deadline in the module book.
 * Guarantees: immutable; is always valid
 */
public class Deadline {
    public static final String MESSAGE_CONSTRAINTS = "Not a valid Deadline";
    public static final SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy, hh:mm aaa");
    public static final SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy HHmm");
    protected Date date;

    private String description;
    private String time;
    private boolean isDone;
    private boolean isInProgress;
    private String tag;

    public Deadline (String description, String time, String tag) throws ParseException, CommandException {
        requireNonNull(description);
        this.description = description;
        this.time = time;
        try {
            isValidPriority(tag);
            this.tag = tag;
        } catch(IllegalArgumentException ex) {
            throw new CommandException("invalid tag entered");
        }
        this.date = parseDate(time);
    }

    /**
     * Validates priority tag.
     * @param tag priority tag.
     * @return true if input tag is valid, false otherwise.
     */
    public void isValidPriority(String tag) {
        Priority.valueOf(tag);
    }

    /**
     * Marks the deadline task as done.
     */
    public void markAsDone() {
        isDone = true;
        isInProgress = false;
    }

    /**
     * Marks the deadline task as in progress.
     */
    public void markAsInProgress() {
        isInProgress = true;
        isDone = false;
    }

    /**
     * Marks the deadline task as undone.
     * @throws CommandException when task is already undone.
     */
    public void markAsUndone() throws CommandException {
        if (!isInProgress && !isDone) {
            throw new CommandException("Deadline task already undone!");
        }
        isInProgress = false;
        isDone = false;
    }

    public String getStatus() {
        if (isDone) {
            return "" + "\u2713";
        } else if (isInProgress) {
            return "-";
        } else {
            return " ";
        }
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public Date getDate() {
        return date;
    }

    public String getTag() {
        return tag;
    }

    public void setValue(String newValue) {
        this.description = newValue;
    }

    public void editDescription(String newDescription) {
        this.description = newDescription;
    }

    public void editTime(String newTime) {
        this.time = newTime;
    }

    /**
     * Parses string date into Date object according to our format.
     *
     * @param s Input string to be parsed.
     * @return The parsed Date object.
     */
    protected static Date parseDate(String s) throws ParseException {
        try {
            return parser.parse(s);
        } catch (IllegalArgumentException | java.text.ParseException e) {
            throw new ParseException("Date and time not in dd/MM/yyyy HHmm format");
        }
    }

    /**
     * Converts Date object into string of our format.
     *
     * @param d The Date object in question.
     * @return The string representation in our format.
     */
    protected static String stringifyDate(Date d) {
        return formatter.format(d);
    }

    @Override
    public String toString() {
        return "[" + getStatus() + "] " + description + ", due by : " + stringifyDate(date) + "\n";
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Deadline // instanceof handles nulls
                && description.equals(((Deadline) other).description))
                && time.equals(((Deadline) other).time); // state check
    }

    @Override
    public int hashCode() {
        return description.hashCode();
    }
}
