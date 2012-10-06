package com.yoyo.utils;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;


/**
* FileUtils: (文件处理类)
* @author yoyo E-mail:152106619@qq.com
* @version 创建时间：2012-8-17 上午10:12:31
*/
public class FileUtils {
	/**
	* @Title readFileByBytes
	* @Description 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
	* @return String 文件内容
	* @param fileName 文件路径
	* @return
	* @author yoyo Email:152106619@qq.com
	* @date 2012-8-17 上午11:38:41
	* @ModificationHistory
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2012-8-17  yoyo Email:152106619@qq.com v1.0.0   修改原因
	*/
	public static String readFileByBytes(String fileName) {
		File file = new File(fileName);
		InputStream in = null;
		try {
			System.out.println("以字节为单位读取文件内容，一次读一个字节：");
			// 一次读一个字节
			in = new FileInputStream(file);
			int tempbyte;
			while ((tempbyte = in.read()) != -1) {
				System.out.write(tempbyte);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		try {
			// 一次读多个字节
			byte[] tempbytes = new byte[100];
			in = new FileInputStream(fileName);
			FileUtils.showAvailableBytes(in);
			// 读入多个字节到字节数组中，byteread为一次读入的字节数
			while (in.read(tempbytes) != -1) {
				// System.out.write(tempbytes, 0, byteread);
			}
			return new String(tempbytes, "ISO-8859-1");
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e1) {
				}
			}
		}
		// return new String(tempbytes);
		return null;

	}

	/**
	* @Title readFileByChars
	* @Description 以字符为单位读取文件，常用于读文本，数字等类型的文件
	* @return String 文件内容
	* @param fileName 文件路径
	* @return
	* @author yoyo Email:152106619@qq.com
	* @date 2012-8-17 上午11:39:28
	* @ModificationHistory
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2012-8-17  yoyo Email:152106619@qq.com v1.0.0   修改原因
	*/
	public static String readFileByChars(String fileName) {
		File file = new File(fileName);
		Reader reader = null;
		String content = null;
		try {
			System.out.println("以字符为单位读取文件内容，一次读一个字节：");
			// 一次读一个字符
			reader = new InputStreamReader(new FileInputStream(file));
			int tempchar;
			while ((tempchar = reader.read()) != -1) {
				// 对于windows下，\r\n这两个字符在一起时，表示一个换行。
				// 但如果这两个字符分开显示时，会换两次行。
				// 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
				content += tempchar;
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * try { System.out.println("以字符为单位读取文件内容，一次读多个字节："); // 一次读多个字符 char[]
		 * tempchars = new char[30]; int charread = 0; reader = new
		 * InputStreamReader(new FileInputStream(fileName)); //
		 * 读入多个字符到字符数组中，charread为一次读取字符数 while ((charread =
		 * reader.read(tempchars)) != -1) { // 同样屏蔽掉\r不显示 if ((charread ==
		 * tempchars.length) && (tempchars[tempchars.length - 1] != '\r')) {
		 * System.out.print(tempchars); } else { for (int i = 0; i < charread;
		 * i++) { if (tempchars[i] == '\r') { continue; } else {
		 * System.out.print(tempchars[i]); } } } }
		 * 
		 * } catch (Exception e1) { e1.printStackTrace(); }
		 */
		finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return content;
	}

	/**
	* @Title readFileByLines
	* @Description 以行为单位读取文件，常用于读面向行的格式化文件
	* @return String 文件内容
	* @param fileName 文件路径
	* @return
	* @author yoyo Email:152106619@qq.com
	* @date 2012-8-17 上午11:39:55
	* @ModificationHistory
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2012-8-17  yoyo Email:152106619@qq.com v1.0.0   修改原因
	*/
	public static String readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		String content = null;
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				// System.out.println("line " + line + ": " + tempString);
				content += tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return content;
	}

	/**
	* @Title readFileByRandomAccess
	* @Description 随机读取文件内容
	* @return String 文件内容
	* @param fileName 文件路径
	* @return
	* @author yoyo Email:152106619@qq.com
	* @date 2012-8-17 上午11:40:19
	* @ModificationHistory
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2012-8-17  yoyo Email:152106619@qq.com v1.0.0   修改原因
	*/
	public static String readFileByRandomAccess(String fileName) {
		RandomAccessFile randomFile = null;
		String content = null;
		try {
			System.out.println("随机读取一段文件内容：");
			// 打开一个随机访问文件流，按只读方式
			randomFile = new RandomAccessFile(fileName, "r");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 读文件的起始位置
			int beginIndex = (fileLength > 4) ? 4 : 0;
			// 将读文件的开始位置移到beginIndex位置。
			randomFile.seek(beginIndex);
			byte[] bytes = new byte[10];
			int byteread = 0;
			// 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
			// 将一次读取的字节数赋给byteread
			while ((byteread = randomFile.read(bytes)) != -1) {
				System.out.write(bytes, 0, byteread);
				content += bytes;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (randomFile != null) {
				try {
					randomFile.close();
				} catch (IOException e1) {
				}
			}
		}
		return content;
	}

	/**
	 * 显示输入流中还剩的字节数
	 */
	private static void showAvailableBytes(InputStream in) {
		try {
			System.out.println("当前字节输入流中的字节数为:" + in.available());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	* @Title readFile
	* @Description 读取源文件内容
	* 通过 new String(bytes, "ISO-8859-1") 转换成String类型
	* @return String 文件内容
	* @param fileName 文件路径
	* @return
	* @throws IOException
	* @author yoyo Email:152106619@qq.com
	* @date 2012-8-17 上午11:35:11
	* @ModificationHistory
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2012-8-17  yoyo Email:152106619@qq.com v1.0.0   修改原因
	*/
	public static byte[] readFile(String fileName) throws IOException {
		File file = new File(fileName);
		if (fileName == null || fileName.equals("")) {
			throw new NullPointerException("无效的文件路径");
		}
		long len = file.length();
		byte[] bytes = new byte[(int) len];

		BufferedInputStream bufferedInputStream = new BufferedInputStream(
				new FileInputStream(file));
		int r = bufferedInputStream.read(bytes);
		if (r != len) {
			throw new IOException("读取文件不正确");
		}
		bufferedInputStream.close();

		return bytes;
	}

	/**
	* @Title writeFile
	* @Description 将数据写入文件
	* 输入new String(写入内容, "ISO-8859-1").getBytes()
	* @return void
	* @param data 写入内容
	* @param filename 文件路径
	* @throws IOException
	* @author yoyo Email:152106619@qq.com
	* @date 2012-8-17 上午11:40:45
	* @ModificationHistory
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2012-8-17  yoyo Email:152106619@qq.com v1.0.0   修改原因
	*/
	public static void writeFile(byte[] data, String filename)
			throws IOException {
		File file = new File(filename);
		file.getParentFile().mkdirs();
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
				new FileOutputStream(file));
		bufferedOutputStream.write(data);
		bufferedOutputStream.close();
	}

	/**
	* @Title readFileJar
	* @Description 从jar文件里读取class
	* 通过 new String(bytes, "ISO-8859-1") 转换成String类型
	* @return byte[] 文件内容
	* @param filename 文件路径
	* @return
	* @throws IOException
	* @author yoyo Email:152106619@qq.com
	* @date 2012-8-17 上午11:41:22
	* @ModificationHistory
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2012-8-17  yoyo Email:152106619@qq.com v1.0.0   修改原因
	*/
	public byte[] readFileJar(String filename) throws IOException {
		BufferedInputStream bufferedInputStream = new BufferedInputStream(
				getClass().getResource(filename).openStream());
		int len = bufferedInputStream.available();
		byte[] bytes = new byte[len];
		int r = bufferedInputStream.read(bytes);
		if (len != r) {
			bytes = null;
			throw new IOException("读取文件不正确");
		}
		bufferedInputStream.close();
		return bytes;
	}

	/**
	* @Title readUrlStream
	* @Description 读取网络流，为了防止中文的问题，在读取过程中没有进行编码转换，而且采取了动态的byte[]的方式获得所有的byte返回
	* 通过 new String(bytes, "ISO-8859-1") 转换成String类型
	* @return byte[] 内容
	* @param bufferedInputStream 输入流
	* @return
	* @throws IOException
	* @author yoyo Email:152106619@qq.com
	* @date 2012-8-17 上午11:41:51
	* @ModificationHistory
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2012-8-17  yoyo Email:152106619@qq.com v1.0.0   修改原因
	*/
	public byte[] readUrlStream(BufferedInputStream bufferedInputStream)
			throws IOException {
		byte[] bytes = new byte[100];
		byte[] bytecount = null;
		int n = 0;
		int ilength = 0;
		while ((n = bufferedInputStream.read(bytes)) >= 0) {
			if (bytecount != null) {
				ilength = bytecount.length;
			}
			byte[] tempbyte = new byte[ilength + n];
			if (bytecount != null) {
				System.arraycopy(bytecount, 0, tempbyte, 0, ilength);
			}

			System.arraycopy(bytes, 0, tempbyte, ilength, n);
			bytecount = tempbyte;

			if (n < bytes.length) {
				break;
			}
		}
		return bytecount;
	}

}