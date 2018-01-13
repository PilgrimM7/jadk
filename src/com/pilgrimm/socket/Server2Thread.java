package com.pilgrimm.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Server2Thread implements Runnable {

	private Socket client = null;

	public Server2Thread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {

		try {
			// 获取一个输入流，用来读取客户端所发送的登录信息
			InputStream is = client.getInputStream();// 字节输入流
			InputStreamReader isr = new InputStreamReader(is);// 将字节流转为
			BufferedReader br = new BufferedReader(isr);// 为输入流添加缓冲

			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println("我是服务器，客户端说" + info);
			}
			client.shutdownInput();// 关闭输入流

			// 获取输出流
			OutputStream os = client.getOutputStream();
			PrintWriter pw = new PrintWriter(os);// 包装打印流
			
			StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?><bzjpkg>"
    				+ "<TransCode>1</TransCode>"
    				+ "<TransDate>2</TransDate>"
    				+ "<TransTime>3</TransTime>"
    				+ "<SeqNo>4</SeqNo>"
    				+ "<Result>5</Result>"
    				+ "<AddWord>6</AddWord>"
    				+ "<itemcnt>7</itemcnt>"
    				
    				+ "<item>"
    					+ "<InDate>11</InDate>"
    					+ "<InTime>12</InTime>"
    					+ "<InAmount>13</InAmount>"
    					+ "<AccName>14</AccName>"
    					+ "<AccAcct>15</AccAcct>"
    					+ "<AccBank>16</AccBank>"
    					+ "<OpeningBank>17</OpeningBank>"
    					+ "<InMemo>18</InMemo>"
    					+ "<HstSeqNum>19</HstSeqNum>"
    				+ "</item>"
    					
    				+ "<item>"
    					+ "<InDate>21</InDate>"
    					+ "<InTime>22</InTime>"
    					+ "<InAmount>23</InAmount>"
    					+ "<AccName>24</AccName>"
    					+ "<AccAcct>25</AccAcct>"
    					+ "<AccBank>26</AccBank>"
    					+ "<OpeningBank>27</OpeningBank>"
    					+ "<InMemo>28</InMemo>"
    					+ "<HstSeqNum>29</HstSeqNum>"
    				+ "</item>"
    				
    				+ "</bzjpkg>");
            pw.write(sb.toString());
			
//			pw.write("好的，我收到消息了，你可以出去玩了");
			pw.flush();
			client.shutdownOutput();

			// 关闭资源
			pw.close();
			br.close();
			isr.close();
			is.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
