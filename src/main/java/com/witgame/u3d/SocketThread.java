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
		//新起一个线程负责处理请求
		new Thread(new TaskThread(this)).start();
	}

	/**
	 * 此线程负责拼装socket为一个完整的请求
	 */
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

	
	/**
	 * 获取消息 会阻塞
	 * @return
	 */
	public String getMsg() {
		return ptl.getMsg();
	}

	
	/**
	 * 发送消息
	 * @param msg
	 * @throws Exception
	 */
	public void sendMsg(String msg) throws Exception {
		writeBuffer.clear();
		writeBuffer.put(Protocol.encodeMsg(msg));
		writeBuffer.flip();
		while (writeBuffer.hasRemaining()) {
			sc.write(writeBuffer);
		}
	}

}
