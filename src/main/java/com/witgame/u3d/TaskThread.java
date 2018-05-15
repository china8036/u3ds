package com.witgame.u3d;

public class TaskThread implements Runnable {

	SocketThread st;

	TaskThread(SocketThread st) {
		this.st = st;
	}

	public void run() {
		while (true) {
			System.out.println("taskThreadMsg:" + st.getMsg());
			try {
				st.sendMsg(st.getMsg());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub

	}

}
