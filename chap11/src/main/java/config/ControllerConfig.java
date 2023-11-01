package config;import controller.ChangePwdController;import controller.LoginController;import controller.LogoutController;import controller.RegisterController;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.Configuration;import org.springframework.context.annotation.Import;import service.AuthService;import service.ChangePasswordService;import service.MemberRegisterService;import survey.SurveyController;@Configuration@Import(MemberConfig.class)public class ControllerConfig {    @Autowired    private MemberRegisterService memberRegisterService;    @Autowired    private ChangePasswordService changePasswordService;    @Autowired    private AuthService authService;    @Bean    public ChangePwdController changePwdController() {        ChangePwdController changePwdController = new ChangePwdController();        changePwdController.setChangePasswordService(changePasswordService);        return changePwdController;    }    @Bean    public RegisterController registerController() {        RegisterController registerController = new RegisterController();        registerController.setMemberRegisterService(memberRegisterService);        return new RegisterController();    }    @Bean    public LoginController loginController() {        LoginController loginController = new LoginController();        loginController.setAuthService(authService);        return loginController;    }    @Bean    public LogoutController logoutController() {        return new LogoutController();    }    @Bean    public SurveyController surveyController() {        return new SurveyController();    }}