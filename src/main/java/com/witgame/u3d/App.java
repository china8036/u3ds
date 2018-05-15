package com.witgame.u3d;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ServerSocketChannel serverSocketChannel;
		try {
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(8888));
			serverSocketChannel.configureBlocking(false);
			Selector selector = Selector.open();
			SelectionKey key = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			while (true) {
				int readyChannels = selector.select();
				if (readyChannels == 0)
					continue;
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
				while (keyIterator.hasNext()) {
					key = keyIterator.next();
					if (key.isAcceptable()) {// 有新的链接
						ServerSocketChannel serverChanel = (ServerSocketChannel) key.channel();
						new Thread(new SocketThread(serverChanel.accept())).start();
					} else {
						System.out.println("Undefinded Status!");
					}
					keyIterator.remove(); // 新生注册任务完成了，呵呵
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
