<%
    String msg = "";
    if (request.getSession().getAttribute("success") != null) {
        msg = (String) request.getSession().getAttribute("success");
        request.getSession().setAttribute("success", null);

        out.print(" <div class='alert alert-success' role='alert'>" + msg + "</div>");
    }

    if (request.getSession().getAttribute("error") != null) {
        msg = (String) request.getSession().getAttribute("error");
        request.getSession().setAttribute("error", null);

        out.print(" <div class='alert alert-danger' role='alert'>" + msg + "</div>");
    }
%>