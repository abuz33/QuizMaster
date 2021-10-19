package service;

public class ServiceManager {
    // manage the services
    private QuizProviderService qps = new DemoQuizProviderService();


    public QuizProviderService getQuizProviderService(){
        return this.qps;
    }
}
