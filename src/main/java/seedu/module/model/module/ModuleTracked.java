package seedu.module.model.module;

/**
 * Represents a Module.
 */
public interface ModuleTracked extends Module {
    String getModuleCode();

    String getTitle();

    String getDescription();

    Deadline getDeadline();

}
