package com.witgame.u3d;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class SocketThread implements Runnable {

	protected SocketChannel sc;

	protected final int MAX_LEN = 1024;

	ByteBuffer echoBuffer = ByteBuffer.allocate(MAX_LEN);

	ByteBuffer writeBuffer = ByteBuffer.allocate(MAX_LEN);

	byte[] content = new byte[MAX_LEN];

	Protocol ptl = new Protocol();

	SocketThread(SocketChannel sc) {
		this.sc = sc;
		new Thread(new TaskThread(this)).start();
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				echoBuffer.clear();
				sc.read(echoBuffer);
				echoBuffer.flip(); // ByteBuffer 读写转换
				echoBuffer.get(content, 0, echoBuffer.limit());
				ptl.dealPackage(Arrays.copyOfRange(content, 0, echoBuffer.limit()));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getMsg() {
		return ptl.getMsg();
	}

	public void sendMsg(String msg) throws Exception {
		writeBuffer.clear();
		writeBuffer.put(Protocol.encodeMsg(msg));
		writeBuffer.flip();
		while (writeBuffer.hasRemaining()) {
			sc.write(writeBuffer);
		}
	}

}
