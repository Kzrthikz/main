package seedu.module.testutil;

import seedu.module.model.module.ArchivedModule;
import seedu.module.model.module.TrackedModule;

/**
 * A utility class to help with building Module objects.
 */
public class TrackedModuleBuilder {

    public static final String DEFAULT_MODULE_CODE = "CS2103T";
    public static final String DEFAULT_TITLE = "Software Engineering";
    public static final String DEFAULT_DESCRIPTION = "Lorem Ipsum";

    private String moduleCode;
    private String title;
    private String description;

    public TrackedModuleBuilder() {
        moduleCode = DEFAULT_MODULE_CODE;
        title = DEFAULT_TITLE;
        description = DEFAULT_DESCRIPTION;
    }

    /**
     * Initializes the ArchivedModuleBuilder with the data of {@code moduleToCopy}.
     */
    public TrackedModuleBuilder(TrackedModule moduleToCopy) {
        moduleCode = moduleToCopy.getModuleCode();
        title = moduleToCopy.getTitle();
        description = moduleToCopy.getDescription();
    }

    /**
     * Sets the moduleCode of the {@code ArchivedModule} that we are building.
     */
    public TrackedModuleBuilder withModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
        return this;
    }

    /**
     * Sets the title of the {@code ArchivedModule} that we are building.
     */
    public TrackedModuleBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the description of the {@code ArchivedModule} that we are building.
     */
    public TrackedModuleBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public TrackedModule build() {
        return new TrackedModule(new ArchivedModule(moduleCode, title, description));
    }
}
