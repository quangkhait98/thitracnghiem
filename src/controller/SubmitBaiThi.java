package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.cauhoi;
import function.cauhoif;

@WebServlet("/SubmitBaiThi")
public class SubmitBaiThi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SubmitBaiThi() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		HttpSession cauhoi = request.getSession(false);
		@SuppressWarnings("unchecked")
		ArrayList<cauhoi> ch = (ArrayList<cauhoi>) cauhoi.getAttribute("questions");
		int sluong = Integer.parseInt(request.getParameter("soluong"));
		int[] dapAnDung = new int[sluong];
		String[] dapAn = request.getParameterValues("dapAn[]");
		int soCauDung = 0;
		cauhoif chf = new cauhoif();
		for (int i = 0; i < sluong; i++) {
			int maCauHoi = ch.get(i).getMacauhoi();
			dapAnDung[i] = chf.getAnswer(maCauHoi);
			if (dapAn[i].toString().equals(String.valueOf(dapAnDung[i])))
				soCauDung++;
		}
		cauhoi.removeAttribute("questions");
		DecimalFormat df = new DecimalFormat("#.##"); 
		request.setAttribute("soCau", sluong);
		request.setAttribute("soCauDung", soCauDung);
		request.setAttribute("diem", df.format(10/(double)(sluong)*soCauDung));
		request.setAttribute("time",dateFormat.format(date));
		request.getRequestDispatcher("scoreboard.jsp").forward(request, response);
	}

}
