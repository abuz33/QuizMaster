package service;

import model.Quiz;

import java.util.ArrayList;
import java.util.List;

public class DemoQuizProviderService implements QuizProviderService{

    private List<Quiz> sampleQuizes;

    public DemoQuizProviderService() {
        this.sampleQuizes = new ArrayList<>();
        // add a demo quiz (domain) object
        this.sampleQuizes.add(new Quiz("Jan&Erik's demo of a Quiz object"));
    }

    /**
     * this method is a demo of a service method.
     * it returns a String object, based on a domain object.
     * Note: preferably don't return actual domain objects!
     * @return
     */
    @Override
    public String getARandomQuizName() {
        // not really random. But hey, it's a demo!
        return this.sampleQuizes.get(0).getNaam();
    }
}
