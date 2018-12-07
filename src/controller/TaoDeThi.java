package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import function.bodef;
import model.bode;
import model.cauhoi;

@WebServlet("/TaoDeThi")
public class TaoDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TaoDeThi() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession cauhoi = request.getSession();
		String maBoDe = (String) cauhoi.getAttribute("mabode");
		int sluong = (int) cauhoi.getAttribute("sluong");
		@SuppressWarnings("unchecked")
		ArrayList<cauhoi> ch = (ArrayList<cauhoi>) cauhoi.getAttribute("question");
		bode bode = (bode) cauhoi.getAttribute("bode");
		bodef bdf = new bodef();
		System.out.println(ch);
		/*bdf.TaoBoDe(bode);
		for (int i = 0; i < sluong; i++) {
			int maCauHoi = ch.get(i).getMacauhoi();
			bdf.BoDe_CauHoi(maBoDe, maCauHoi);
			} */
		cauhoi.invalidate();
		//request.getRequestDispatcher("QuanLyBoDe").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession cauhoi = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<cauhoi> ch = (ArrayList<cauhoi>) cauhoi.getAttribute("listcauhoi");
		cauhoi.setAttribute("question", ch);
		request.getRequestDispatcher("LayCauHoi").forward(request, response);	
	}

}
