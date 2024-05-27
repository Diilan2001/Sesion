import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        res.setContentType("text/html; charset=UTF-8");
        //CREAMOS LA SESION
        HttpSession session = req.getSession();
        //creamos una variable de tipo string
        String titulo = null;
        Integer contadorVisitas = (Integer) session.getAttribute("contadorVisitas");
        //evaluamos la condicion, si es la primera vez que ingresa ala aplicacion:
        if (contadorVisitas==null){
            contadorVisitas=1;
            titulo = "Bienvenido a mi aplicacion por primera vez";
        }else {
            contadorVisitas=contadorVisitas+1;
            titulo = "Bienvenido a mi aplicacion nuevamente";
        }

        //seteamos o agregamos los nuevos valores a la ssesion mediante el metodo sesion
        session.setAttribute("contadorVisitas",contadorVisitas);

        PrintWriter out = res.getWriter();
        out.print("<html><body>");

        out.print("<h1>" + contadorVisitas + "</h1>");
        out.print("</body></html>");

    }

}
