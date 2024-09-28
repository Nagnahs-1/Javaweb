package top.soft.bookonline.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.service.RegisterService;
import top.soft.bookonline.service.impl.RegisterServiceImpl;
@WebServlet( "/register")
public class RegisterServlet extends HttpServlet {
    private RegisterService registerService;
    @Override
//    初始化方法
    public void init(ServletConfig config) throws ServletException {
        registerService = new RegisterServiceImpl();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取表单数据
        String account = req.getParameter("account1");
        String password = req.getParameter("password1");
        String nickname = req.getParameter("nickname1");
        String address = req.getParameter("address1");
//        调用 registerService 的 signRegister 方法尝试注册新用户
        User user = registerService.signRegister(account, password,nickname,address);
//          判断结果
            if (user != null) {
//                设置响应的内容类型和字符编码
                resp.setContentType("text/html;charset=UTF-8");
                resp.setCharacterEncoding("UTF-8");
//                向客户端发送 JavaScript 代码以显示一个提示框，并重定向到主页（/）
                resp.getWriter().write( "<script>alert('注册成功');location.href='/';</script>");
            } else {
                resp.setContentType("text/html;charset=UTF-8");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write("<script>alert('账号或密码错误');location.href='/';</script>");
            }
    }

}