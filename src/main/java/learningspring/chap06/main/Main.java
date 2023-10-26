package learningspring.chap06.main;import learningspring.chap06.client.Client;import learningspring.chap06.client.Client2;import learningspring.chap06.config.AppCtx;import learningspring.chap06.dao.MemberDao;import learningspring.chap06.service.ChangePasswordService;import learningspring.chap06.service.MemberRegisterService;import org.springframework.context.annotation.AnnotationConfigApplicationContext;import org.springframework.context.support.AbstractApplicationContext;public class Main {    public static void main(String[] args) {        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);        Client client = ctx.getBean(Client.class);        client.send();        Client2 client2 = ctx.getBean(Client2.class);        client2.send();        ctx.close();    }}