/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Bailey
 */
@WebServlet(urlPatterns = {"/LoanServlet"})
public class LoanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user input from the form
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        double annualInterestRate = Double.parseDouble(request.getParameter("annualInterestRate"));
        int numberOfYears = Integer.parseInt(request.getParameter("numberOfYears"));
        
        // Calculate monthly and total payments using the Loan class
        Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);
        double monthlyPayment = loan.getMonthlyPayment();
        double totalPayment = loan.getTotalPayment();
        
        // Prepare the response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Loan Payment Details</title></head><body>");
        out.println("<h2>Loan Payment Details</h2>");
        out.println("<p>Loan Amount: $" + loanAmount + "</p>");
        out.println("<p>Annual Interest Rate: " + annualInterestRate + "%</p>");
        out.println("<p>Number of Years: " + numberOfYears + "</p>");
        out.println("<p>Monthly Payment: $" + monthlyPayment + "</p>");
        out.println("<p>Total Payment: $" + totalPayment + "</p>");
        out.println("</body></html>");
    }
}
