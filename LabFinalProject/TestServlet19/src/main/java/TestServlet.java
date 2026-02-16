import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // GET শুধু View এর জন্য ধরলাম
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String action = request.getParameter("action");
        String name = request.getParameter("studentName");
        String email = request.getParameter("studentEmail");
        String idStr = request.getParameter("studentId");

        int id = 0;
        if (idStr != null && !idStr.trim().isEmpty()) {
            try { id = Integer.parseInt(idStr.trim()); } catch (Exception ignored) {}
        }

        ServiceClass service = new ServiceClass();
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><style>");
        out.println("table { border-collapse: collapse; width: 70%; }");
        out.println("th, td { border: 1px solid #333; padding: 8px; text-align: left; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println("</style></head><body>");

        out.println("<h2>Action: " + (action == null ? "" : action) + "</h2>");

        if (action == null) {
            out.println("<p>Unknown action.</p>");
            out.println("</body></html>");
            return;
        }

        switch (action) {
            case "Insert":
                if (name == null || email == null || name.trim().isEmpty() || email.trim().isEmpty()) {
                    out.println("<p>Name/Email required.</p>");
                } else if (service.insertDB(name.trim(), email.trim())) {
                    out.println("<p>Inserted successfully.</p>");
                } else {
                    out.println("<p>Insertion failed.</p>");
                }
                break;

            case "View":
                List<Student> students = service.viewDB();
                if (students.isEmpty()) {
                    out.println("<p>No students found.</p>");
                } else {
                    out.println("<table>");
                    out.println("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");
                    for (Student s : students) {
                        out.println("<tr><td>" + s.getId() + "</td><td>"
                                + s.getName() + "</td><td>" + s.getEmail() + "</td></tr>");
                    }
                    out.println("</table>");
                }
                break;

            case "Update":
                if (id <= 0) {
                    out.println("<p>ID required for update.</p>");
                } else if (service.updateDB(id, name == null ? "" : name.trim(),
                        email == null ? "" : email.trim())) {
                    out.println("<p>Updated successfully.</p>");
                } else {
                    out.println("<p>Update failed. ID not found?</p>");
                }
                break;

            case "Delete":
                if (id <= 0) {
                    out.println("<p>ID required for delete.</p>");
                } else if (service.deleteDB(id)) {
                    out.println("<p>Deleted successfully.</p>");
                } else {
                    out.println("<p>Delete failed. ID not found?</p>");
                }
                break;

            default:
                out.println("<p>Unknown action.</p>");
        }

        out.println("</body></html>");
    }
}
