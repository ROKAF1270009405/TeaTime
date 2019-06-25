package com.teatime.cs.action;

import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;

/**
 * Servlet implementation class CSController
 */
@WebServlet(urlPatterns = { "*.do" }, initParams = {
		@WebInitParam(name = "init", value = "com/teatime/cs/properties/CustomerService.properties") })
public class CSController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CSController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Hashtable<String, Action> ht = new Hashtable<>();

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String param = config.getInitParameter("init");
		String realpath = config.getServletContext().getRealPath(param);
		Properties prop = new Properties();
		try {
			prop.load(new FileReader(realpath));
			// System.out.println("test:"+prop.getProperty("/list.do"));

			Enumeration<Object> enu = prop.keys();
			while (enu.hasMoreElements()) {
				String key = (String) enu.nextElement();
				String value = (String) prop.get(key);

				Class c = Class.forName(value);
				Action act = (Action) c.newInstance();
				ht.put(key, act);
			}

		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (IllegalAccessException | InstantiationException e) {
			System.out.println(e);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		Action act = ht.get(path);
		ActionForward forward = act.execute(request, response);

		if (forward != null) {
			if (forward.isRedirect())
				response.sendRedirect(forward.getPath());
			else {
				RequestDispatcher disp = request.getRequestDispatcher(forward.getPath());
				disp.forward(request, response);
			}

		}
	}

}
