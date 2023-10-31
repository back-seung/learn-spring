package controller;import dto.RegisterRequest;import exception.DuplicateMemberException;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestParam;import service.MemberRegisterService;@Controllerpublic class RegisterController {    private MemberRegisterService memberRegisterService;    public void setMemberRegisterService(MemberRegisterService memberRegisterService) {        this.memberRegisterService = memberRegisterService;    }    @RequestMapping("/register/step1")    public String handleStep1() {        return "register/step1";    }    @PostMapping("/register/step2")    public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agreeVal, Model model) {        if (!agreeVal) {            return "register/step1";        }        model.addAttribute("registerRequest", new RegisterRequest());        return "register/step2";    }    @GetMapping("/register/step2")    public String handleStep2() {        return "redirect:/register/step1";    }    @PostMapping("/register/step3")    public String handleStep3(RegisterRequest registerRequest) {    // 커맨드 객체        try {            memberRegisterService.regist(registerRequest);            return "register/step3";        } catch (DuplicateMemberException e) {            return "register/step2";        }    }}