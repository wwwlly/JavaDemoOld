package com.kemp.javademo;

import java.io.*;

/**
 * 测试多线程操作同一个文件
 * 
 */
public class TestSynchronize {
	private String filePath = System.getProperty("user.dir");
	private int i = 0;

	private String read() {
		System.out.println(filePath);
		try {
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(new File(filePath, "test.txt")),
					"UTF-8"));
			sb.append(br.readLine());
			// String s = br.readLine();
			br.close();
			return sb.toString();
			// FileInputStream fis = new FileInputStream(new File(filePath,
			// "test.txt"));
			// byte[] bytes = new byte[1024];
			// fis.read(bytes);
			// fis.close();
			// return new String(bytes, "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private void write(String str) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
					filePath, "test.txt")));
			bw.write(str);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void threadRead() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				i = 2;
				String str = read();
				System.out.println(str);
			}
		}).start();
	}

	private void threadWrite(final String str) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				i = 1;
				write(str);
			}
		}).start();
	}

	public static void main(String[] args) {
		TestSynchronize test = new TestSynchronize();
		// test.write("www");
		// String str = test.read();
		// System.out.println(str);
		test.threadWrite("1");
		test.threadWrite("2");
		test.threadRead();
	}
}
