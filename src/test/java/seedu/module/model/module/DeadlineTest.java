package seedu.module.model.module;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DeadlineTest {
    @Test
    public void constructor_null_throwsNullException() {
        assertThrows(NullPointerException.class, () ->
                new Deadline(null, "22/2/2019 1800", "HIGH"));
        assertThrows(NullPointerException.class, () ->
                new Deadline("description", null, "HIGH"));
        assertThrows(NullPointerException.class, () ->
                new Deadline("description", "12/2/2019 1800", null));
    }

    @Test
    public void equals() {
        Deadline comparedDeadline = new Deadline ("desc", "12/2/2019 1800", "LOW");
        //same object
        assertTrue(comparedDeadline.equals(comparedDeadline));
        //same description, time and priority
        assertTrue(comparedDeadline.equals(new Deadline ("desc", "12/2/2019 1800", "LOW")));
        //different description
        assertFalse(comparedDeadline.equals(new Deadline("notDesc", "12/2/2019 1800", "LOW")));
        //different time
        assertFalse(comparedDeadline.equals(new Deadline("desc", "12/2/2020 1800", "LOW")));
        //different tag
        assertFalse(comparedDeadline.equals(new Deadline("desc", "12/2/2019 1800", "MEDIUM")));
    }
}
