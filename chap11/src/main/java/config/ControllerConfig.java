package config;import controller.RegisterController;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.Configuration;import org.springframework.context.annotation.Import;import service.MemberRegisterService;import survey.SurveyController;@Configuration@Import(MemberConfig.class)public class ControllerConfig {    @Autowired    private MemberRegisterService memberRegisterService;    @Bean    public RegisterController registerController() {        RegisterController registerController = new RegisterController();        registerController.setMemberRegisterService(memberRegisterService);        return new RegisterController();    }    @Bean    public SurveyController surveyController() {        return new SurveyController();    }}