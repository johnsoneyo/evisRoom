/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author johnson3yo
 */
@WebServlet("/jas")
public class Jas extends HttpServlet {

   @EJB EveEJB ev;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       byte[] di = ev.downloadInvoice(1204);
        
            resp.setContentType("application/force-download");
            resp.setHeader("Content-Transfer-Encoding", "binary");
            resp.setHeader("Content-Disposition", "attachment; filename=rec.pdf");;
            ServletOutputStream os = resp.getOutputStream();
            os.write(di);
            os.flush();
    }
   
    
}
