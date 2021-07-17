package AAAtestPackage;

import java.util.concurrent.Callable;

import DB_Connection.DBConnection;
import javafx.concurrent.Task;

public class AnotherTestCall extends  Task<Void>{
	private DBConnection con = new DBConnection();
	@Override
	public Void call() throws Exception {
		System.out.println("in call in while");
			int var=con.get_last_msg_in_cnv_for_agent(99);
			System.out.println("last msg id of cnv 99 is "+var);
			Thread.sleep(3000);
			return null;
		// TODO Auto-generated method stub
	}

}
