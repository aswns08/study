package kr.ac.daejeon;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BBSServlet extends HttpServlet {

	private static final long serialVersionUID = -710645512117758385L;

	HashMap<String, Object> hm = new HashMap<String, Object>();

	@Override
	public void init(ServletConfig config) throws ServletException {

		String path = config.getInitParameter("bbs_properties");
		FileReader fr = null;
		Properties pt = new Properties();

		try{
			fr = new FileReader(path);
			pt.load(fr); // pt.load => =을 기준으로 왼쪽은 key, 오른쪽은 value로 나눈다. 
			
		}catch(Exception e) {
			e.printStackTrace();

		} finally {
			if(fr != null) {
				try {
					fr.close();
				} catch(IOException ex) {
					ex.printStackTrace();
				}
			}
		}

		Iterator it = pt.keySet().iterator(); 
		// ketSet() => pt.load에서 구분해 논 는 key값을 리턴
		// Properties가 iterator를 지원하지 않기 때문에 Generic<>을 쓰지 않았음.
		while(it.hasNext()) {
			String key = (String)it.next();
			String value = pt.getProperty(key);

			try{
				Class cl = Class.forName(value); // value값(String)을 읽어와서 클래스화 함.
				Object oj = cl.newInstance(); // 클래스화 된 클래스를 인스턴스화
				hm.put(key, oj);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		daejeon(req, res);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		daejeon(req, res);
	}

	public void daejeon(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		String view = null;

		try{

			// command 요청한 주소값을 읽어내서 parsing함.
			String command = req.getRequestURI();
			if(command.indexOf(req.getContextPath()) == 0) {
				// getRequestURI() 와 getContextPath() 의 문자열을 비교해서 몇번째 인덱스부터 같은지 비교. 
				command = command.substring(req.getContextPath().length());
			}
			// 업캐스팅 : 실제 기능을 하는 클래스들이 TestService 인터페이스를 부모로 받아서 
			// 각각의 키값에 상관없이 모든 클래스들을 받을 수 있도록 함. 
			BBSService ts = (BBSService)hm.get(command);
			view = ts.service(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(view!=null) {
			RequestDispatcher rd = req.getRequestDispatcher(view);
			rd.forward(req, res);
		}

	}

}
