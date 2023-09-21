package org.example;

import net.serenitybdd.jbehave.SerenityStory;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import java.util.List;

import static org.codehaus.groovy.runtime.InvokerHelper.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

@RunWith(SerenityRunner.class)
public class AcceptanceTest extends SerenityStory {

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(getClass()));
    }


    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new GoogleSearchSteps());
    }

    @Override
    public List<String> storyPaths() {
        return new StoryFinder()
                .findPaths(codeLocationFromClass(this.getClass()).getFile(), asList("**/*.story"), null);
    }
}
