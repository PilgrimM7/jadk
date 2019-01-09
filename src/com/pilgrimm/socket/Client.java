package com.pilgrimm.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) {
		
		try {
			// 1.创建 socket 指定服务器地址和端
			Socket client = new Socket("192.168.1.8", 11165);
			client.setSoTimeout(10000);
			// 2.客户端向服务器发送登录信息
            OutputStream os = client.getOutputStream();// 字节输出流
            PrintWriter pw = new PrintWriter(os);
            
            // 1、保证金到账
			StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?><bzjpkg>"
					+ "<TransCode>3001</TransCode>"
					+ "<TransDate>20180320</TransDate>"
					+ "<TransTime>111609</TransTime>"
					+ "<SeqNo>2018032000214386</SeqNo>"
					+ "<AccNo>8808812008000003300</AccNo>"
					+ "<AccName>河北家乐园房地产开发有限公司</AccName>"
					+ "<AccBank>邢台银行股份有限公司汇通支行</AccBank>"
					+ "<InAmount>0.01</InAmount>"
					+ "<InDate>20180319</InDate>"
					+ "<InTime>103518</InTime>"
					+ "<HstSeqNum>2486</HstSeqNum>"
					+ "<Abstract>邢东储[2017]54号</Abstract>"
					+ "<Remark></Remark>"
				+ "</bzjpkg>");
            
            // 10、保证金对账
//            StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"gb2312\" standalone=\"no\"?><bzjpkg>"
//            		+ "<TransCode>3012</TransCode>"
//            		+ "<TransDate>20180319</TransDate>"
//            		+ "<TransTime>000008</TransTime>"
//            		+ "<SeqNo></SeqNo>"
//            		+ "<filename>20180621.txt</filename>"
//            		+ "</bzjpkg>");
            
			String xml = new String(sb.toString().getBytes(), "iso8859-1");
			
            pw.write(xml);
            pw.flush();
            client.shutdownOutput();// 关闭输出流

            // 3. 获取输入流
            InputStream is = client.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("服务器发来消息说：" + info);
            }

            // 3.关闭其他资源
            pw.close();
            os.close();
            client.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}