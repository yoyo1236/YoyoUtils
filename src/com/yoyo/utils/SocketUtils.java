package com.yoyo.utils;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.net.Socket;

public class SocketUtils {
	public static void sendfileBySocket(Socket socket, String fileName) {
		try {
			File file=new File( fileName); 
			PrintStream outs = new PrintStream(new BufferedOutputStream(socket.getOutputStream()),true); 
			DataInputStream in = new DataInputStream(new FileInputStream(file));
			int len = (int) file.length();
			byte buf[] = new byte[len];
			in.readFully(buf);
			outs.write(buf, 0, len);
			outs.flush();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
