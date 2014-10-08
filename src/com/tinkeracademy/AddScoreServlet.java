package com.tinkeracademy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONStringer;

/**
 * Servlet implementation class AddScoreServlet
 */
public class AddScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimulPlay play = SimulPlay.getInstance();
		play.setScore(play.getScore() + 100);
		int score = play.getScore();
		String responseStr = new JSONStringer()
	     .object()
	         .key("score")
	         .value(score)
	     .endObject()
	     .toString();
		response.setContentType("text/plain");
		response.getWriter().write(responseStr);
		response.getWriter().flush();
	}

}
