package org.designpatterns.managers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.designpatterns.DataObjects.Customer;
import org.designpatterns.constants.Constants;
import org.designpatterns.services.Service;
import org.designpatterns.services.ServiceFactory;

/**
 * Servlet implementation class RequestManager
 */
@WebServlet("/RequestManager")
public class RequestManager extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Hashtable RequestData = new Hashtable();
	private Hashtable ResponseData = new Hashtable();
	private String ServiceName = new String();
	private Object service;
	private Service IService;
	private String ResponsePage;
	private ServletContext context;
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private Customer customer = new Customer();
	private String[] customersArray;
	private String customername;
	private HttpSession session;
	private Properties properties;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/*
	 * All the Request are processed based on the kind of service. Requires:
	 * service parameter. Modifies: request and forwards / redirects the request
	 * to Module Manager.
	 */
	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// Validate the session every time
		validateSession(request, response);
		// get all the request data from the request object
		RequestData = getRequestData(request, response);

		ServiceName = (String) RequestData.get("service");
		System.out.println("Service Name : " + ServiceName);

		if (ServiceName.startsWith("display")
				|| ServiceName.contains("display")) {
			if (((String) RequestData.get("session"))
					.equalsIgnoreCase("notrequired")
					|| ((String) RequestData.get("session")) == "notrequired") {
				ResponsePage = "/"
						+ ServiceName.substring(7, ServiceName.length())
						+ ".jsp";
				setResponseDatatoSession(RequestData);
				ServletContext context = this.getServletContext();
				RequestDispatcher requestDispatcher = context
						.getRequestDispatcher(ResponsePage);
				requestDispatcher.forward(request, response);
			} else {
				String username = (String) session.getAttribute("username");
				String password = (String) session.getAttribute("password");
				IService = ServiceFactory
						.getServicebyTyprNameHighConcurrentVersion("Authentication");
				ResponseData = IService.ExecuteService(RequestData);
				setResponseDatatoSession(ResponseData);

				// session.setAttribute("ResponseData", ResponseData);
				if (ResponseData.get("Authentication").toString()
						.equalsIgnoreCase("success")
						|| ResponseData.get("Authentication").toString() == "success") {
					ResponsePage = "/"
							+ ServiceName.substring(7, ServiceName.length())
							+ ".jsp";
				} else {
					ResponsePage = "/"
							+ (String) ResponseData.get(Constants.RESPONSEPAGE);
				}

			}

		} else if (ServiceName.equals("Asynchronous")) {
			IService = ServiceFactory
					.getServicebyTyprNameHighConcurrentVersion(ServiceName);
			ResponseData = IService.ExecuteService(RequestData);
			customers = (ArrayList<Customer>) ResponseData.get("searchcontent");
			customersArray = new String[customers.size()];
			customername = "<div>";
			for (int i = 0; i < customers.size(); i++) {
				customer = customers.get(i);
				customername += customer.getFirstname() + " "
						+ customer.getLastname() + "<br>";
				customersArray[i] = customername;

			}
			customername = customername + "</div>";
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			response.getWriter().println(customername);

		} else {

			IService = ServiceFactory
					.getServicebyTyprNameHighConcurrentVersion(ServiceName);
			ResponseData = IService.ExecuteService(RequestData);
			setResponseDatatoSession(ResponseData);
			// session.setAttribute("ResponseData", ResponseData);
			ResponsePage = "/"
					+ (String) ResponseData.get(Constants.RESPONSEPAGE);
			ServletContext context = this.getServletContext();
			RequestDispatcher requestDispatcher = context
					.getRequestDispatcher(ResponsePage);
			requestDispatcher.forward(request, response);

		}

	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub

		super.init();
		// properties = new Properties();
		// try {
		// properties.load(getClass().getResourceAsStream("SQL.properties"));
		// } catch (IOException e) {
		// }
	}

	protected Hashtable getRequestData(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String paramValue = request.getParameter(paramName);
			System.out.println("Request Data added to Session : " + paramName
					+ " : " + paramValue);
			session.setAttribute(paramName, paramValue);
			RequestData.put(paramName, paramValue);
		}
		return RequestData;

	}

	protected void setResponseDatatoSession(Hashtable Responsedata)
			throws IOException, ServletException {

		Enumeration parameterNames = Responsedata.keys();
		while (parameterNames.hasMoreElements()) {
			String paramName = (String) parameterNames.nextElement();
			Object paramValue = Responsedata.get(paramName);
			System.out.println("Response Data added to session : " + paramName
					+ " : " + paramValue);
			session.setAttribute(paramName, paramValue);
			RequestData.put(paramName, paramValue);
		}

	}

	protected void validateSession(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		session = request.getSession(false);

		if (session == null) {
			session = request.getSession();
			session.setMaxInactiveInterval(30 * 60);
		} else {
			if ((session.getCreationTime() - session.getLastAccessedTime()) > (30 * 60)) {
				session.invalidate();
			}
		}
	}

}
