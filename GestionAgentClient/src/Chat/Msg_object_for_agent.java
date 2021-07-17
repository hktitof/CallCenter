package Chat;

public class Msg_object_for_agent {
	private int msg_id;
	private String msg;
	public Msg_object_for_agent(int msg_id,String msg) {
		this.msg=msg;
		this.msg_id=msg_id;
	}
	public void SetMsg(String msg) {
		this.msg=msg;
	}
	public String GetMsg() {
		return this.msg;
	}

	public void SetMsg_id(int msg_id) {
		this.msg_id=msg_id;
	}
	public int GetMsg_id() {
		return msg_id;
	}
}