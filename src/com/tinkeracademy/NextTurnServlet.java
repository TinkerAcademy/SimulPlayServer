package com.tinkeracademy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONStringer;

/**
 * Servlet implementation class NextTurnServlet
 */
public class NextTurnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextTurnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("NextTurnServlet enter");
		String uid = request.getParameter("user_uid");
		System.out.println("NextTurnServlet user_uid="+uid);
		SimulPlay play = SimulPlay.getInstance();
		play.registerUserId(uid);
		String nextUid = play.nextUserId();
		System.out.println("NextTurnServlet nextUid="+nextUid);
		int score = play.getScore();
		System.out.println("NextTurnServlet score="+score);
		String responseStr = new JSONStringer()
	     .object()
	         .key("user_uid")
	         .value(nextUid)
	         .key("score")
	         .value(score)
	     .endObject()
	     .toString();
		System.out.println("NextTurnServlet responseStr="+responseStr);
		response.setContentType("text/plain");
		response.getWriter().write(responseStr);
		response.getWriter().flush();
		System.out.println("NextTurnServlet exit");
	}

}
