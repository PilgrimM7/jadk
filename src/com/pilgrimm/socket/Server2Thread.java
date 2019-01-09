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
			InputStreamReader isr = new InputStreamReader(is, "GBK");// 将字节流转为
			BufferedReader br = new BufferedReader(isr);// 为输入流添加缓冲

			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println("我是服务器，客户端说" + info);
			}
			client.shutdownInput();// 关闭输入流

			// 获取输出流
			OutputStream os = client.getOutputStream();
			PrintWriter pw = new PrintWriter(os);// 包装打印流
			
			// 2、入账明细
//			StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><bzjpkg><TransCode>3502</TransCode><TransDate>20180320</TransDate><TransTime>114005</TransTime><SeqNo>20180320114005</SeqNo><Result>1</Result><AddWord></AddWord>"
//					+ "<item><InDate>20180319</InDate><InTime>091910</InTime><InAmount>10000.00</InAmount><AccName>邢台迅捷电梯销售有限公司</AccName><AccAcct>8808812002000006454</AccAcct><AccBank>邢台银行股份有限公司汇通支行</AccBank><OpeningBank>邢台银行股份有限公司汇通支行</OpeningBank><InMemo>8808812011000000268</InMemo><HstSeqNum>24827</HstSeqNum><Abstract>邢东土储[2018]0号</Abstract><Remark>邢台银行股份有限公司汇通支行</Remark></item>"
//					+ "<item><InDate>20180319</InDate><InTime>101322</InTime><InAmount>10000.00</InAmount><AccName>邢台市晨宁电梯销售有限公司</AccName><AccAcct>8808812002000005936</AccAcct><AccBank>邢台银行股份有限公司汇通支行</AccBank><OpeningBank>邢台银行股份有限公司汇通支行</OpeningBank><InMemo>8808812011000000268</InMemo><HstSeqNum>27480</HstSeqNum><Abstract>邢东土储[2018]0号</Abstract><Remark>邢台银行股份有限公司汇通支行</Remark></item>"
//					+ "<item><InDate>20180319</InDate><InTime>101853</InTime><InAmount>50000.00</InAmount><AccName>邢台华菱电梯设备有限公司</AccName><AccAcct>8808812008000002765</AccAcct><AccBank>邢台银行股份有限公司汇通支行</AccBank><OpeningBank>邢台银行股份有限公司汇通支行</OpeningBank><InMemo>8808812011000000268</InMemo><HstSeqNum>27757</HstSeqNum><Abstract>邢东土储[2018]0号</Abstract><Remark>邢台银行股份有限公司汇通支行</Remark></item></bzjpkg>");
			
			// 3、单笔入账
//			StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><bzjpkg><TransCode>3503</TransCode><TransDate>20180320</TransDate><TransTime>114005</TransTime><SeqNo>20180320114005</SeqNo><Result>1</Result><AddWord></AddWord>"
//					+ "<item><InDate>20180315</InDate><InTime>091910</InTime><InAmount>100000001.11</InAmount><AccName>邢台迅捷电梯销售有限公司</AccName><AccAcct>8808812002000006454</AccAcct><AccBank>邢台银行股份有限公司汇通支行</AccBank><OpeningBank>邢台银行股份有限公司汇通支行</OpeningBank><InMemo>8808812011000000268</InMemo><HstSeqNum>00014</HstSeqNum><Abstract>邢东土储[2018]0号</Abstract><Remark>邢台银行股份有限公司汇通支行</Remark></item>"
//					+ "<item><InDate>20180316</InDate><InTime>101853</InTime><InAmount>200050099.68</InAmount><AccName>邢台迅捷电梯销售有限公司</AccName><AccAcct>8808812002000006454</AccAcct><AccBank>邢台银行股份有限公司汇通支行</AccBank><OpeningBank>邢台银行股份有限公司汇通支行</OpeningBank><InMemo>8808812011000000268</InMemo><HstSeqNum>00016</HstSeqNum><Abstract></Abstract><Remark>邢台银行股份有限公司汇通支行</Remark></item></bzjpkg>");
			
			// 4、保证金退款
//			StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?><bzjpkg>"
//					+ "<TransCode>1</TransCode>"
//					+ "<TransDate>20180114</TransDate>"
//					+ "<TransTime>120000</TransTime>"
//					+ "<SeqNo>4</SeqNo>"
//					+ "<Result>5</Result>"
//					+ "<AddWord>6</AddWord>"
//					
//    				+ "<InAcctNo>20180114</InAcctNo>"
//    				+ "<InName>120000</InName>"
//    				+ "<HstSeqNum>0000000001</HstSeqNum>"
//    				+ "</bzjpkg>");
			
			// 5、退款明细
//			StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?><bzjpkg>"
//					+ "<TransCode>1</TransCode>"
//					+ "<TransDate>20180114</TransDate>"
//					+ "<TransTime>120000</TransTime>"
//					+ "<SeqNo>4</SeqNo>"
//					+ "<Result>5</Result>"
//					+ "<AddWord>6</AddWord>"
//					
//					+ "<itemcnt>7</itemcnt>"
//					+ "<item>"
//						+ "<InDate>20180114</InDate>"
//						+ "<InTime>120000</InTime>"
//						+ "<InAmount>13.00</InAmount>"
//						+ "<AccName>邢台天丰工程技术有限公司</AccName>"
//						+ "<AccNo>0000001</AccNo>"
//						+ "<AccBank>中国农业银行</AccBank>"
//						+ "<HstSeqNum>0000000001</HstSeqNum>"
//					+ "</item>"
//						
//					+ "<item>"
//						+ "<InDate>20180114</InDate>"
//						+ "<InTime>120000</InTime>"
//						+ "<InAmount>13.00</InAmount>"	
//						+ "<AccName>邢台天丰工程技术有限公司</AccName>"
//						+ "<AccNo>0000001</AccNo>"
//						+ "<AccBank>中国农业银行</AccBank>"
//						+ "<HstSeqNum>0000000002</HstSeqNum>"
//					+ "</item>"
//						
//    				+ "</bzjpkg>");
			
			// 6、退款单笔明细
//			StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?><bzjpkg>"
//					+ "<TransCode>1</TransCode>"
//					+ "<TransDate>2</TransDate>"
//					+ "<TransTime>3</TransTime>"
//					+ "<SeqNo>4</SeqNo>"
//					+ "<Result>5</Result>"
//					+ "<AddWord>6</AddWord>"
//					
//    				+ "<InDate>20180114</InDate>"
//    				+ "<InTime>120000</InTime>"
//    				+ "<InAmount>13.00</InAmount>"
//    				+ "<AccName>邢台天丰工程技术有限公司</AccName>"
//    				+ "<AccNo>15</AccNo>"
//    				+ "<AccBank>16</AccBank>"
//    				+ "<HstSeqNum>0000000001</HstSeqNum>"
//    				+ "</bzjpkg>");
			
			// 7、保证金转账
//			StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><bzjpkg><TransCode>3507</TransCode><TransDate>20180320</TransDate><TransTime>144425</TransTime><SeqNo>20180320144425</SeqNo><Result>1</Result><AddWord></AddWord><HstSeqNum>957220</HstSeqNum><InAcctNo>1234567890</InAcctNo><InName>国土资源局</InName><AccBank>邢台银行</AccBank><InAmount>5000000.00</InAmount></bzjpkg>");
			
			// 8、全部入账明细
//			StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><bzjpkg><TransCode>3508</TransCode><TransDate>20180320</TransDate><TransTime>114005</TransTime><SeqNo>20180320114005</SeqNo><Result>1</Result><AddWord></AddWord>"
//					+ "<item><InDate>20180315</InDate><InTime>091910</InTime><InAmount>100000001.11</InAmount><AccName>邢台迅捷电梯销售有限公司</AccName><AccAcct>8808812002000006454</AccAcct><AccBank>邢台银行股份有限公司汇通支行</AccBank><OpeningBank>邢台银行股份有限公司汇通支行</OpeningBank><InMemo>8808812011000000268</InMemo><HstSeqNum>00014</HstSeqNum><Abstract>邢东土储[2018]0号</Abstract><Remark>邢台银行股份有限公司汇通支行</Remark></item>"
//					+ "<item><InDate>20180316</InDate><InTime>101853</InTime><InAmount>200050099.68</InAmount><AccName>邢台迅捷电梯销售有限公司</AccName><AccAcct>8808812002000006454</AccAcct><AccBank>邢台银行股份有限公司汇通支行</AccBank><OpeningBank>邢台银行股份有限公司汇通支行</OpeningBank><InMemo>8808812011000000268</InMemo><HstSeqNum>00016</HstSeqNum><Abstract></Abstract><Remark>邢台银行股份有限公司汇通支行</Remark></item></bzjpkg>");
			
			// 9、全部退费明细
//			StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?><bzjpkg>"
//					+ "<TransCode>1</TransCode>"
//					+ "<TransDate>20180114</TransDate>"
//					+ "<TransTime>120000</TransTime>"
//					+ "<SeqNo>4</SeqNo>"
//					+ "<Result>5</Result>"
//					+ "<AddWord>6</AddWord>"
//					
//					+ "<itemcnt>7</itemcnt>"
//					+ "<item>"
//						+ "<InDate>20180114</InDate>"
//						+ "<InTime>120000</InTime>"
//						+ "<InAmount>13.00</InAmount>"
//						+ "<AccName>邢台天丰工程技术有限公司</AccName>"
//						+ "<AccNo>0000001</AccNo>"
//						+ "<AccBank>中国农业银行</AccBank>"
//						+ "<HstSeqNum>0000000001</HstSeqNum>"
//					+ "</item>"
//						
//					+ "<item>"
//						+ "<InDate>20180114</InDate>"
//						+ "<InTime>120000</InTime>"
//						+ "<InAmount>13.00</InAmount>"
//						+ "<AccName>邢台天丰工程技术有限公司</AccName>"
//						+ "<AccNo>0000001</AccNo>"
//						+ "<AccBank>中国农业银行</AccBank>"
//						+ "<HstSeqNum>0000000002</HstSeqNum>"
//					+ "</item>"
//						
//    				+ "</bzjpkg>");
			
			//11、保证金中心获取回执单
			StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?><bzjpkg>"
					+ "<TransCode>3513</TransCode>"
					+ "<TransDate>20180524</TransDate>"
					+ "<TransTime>010101</TransTime>"
					+ "<SeqNo>20180524010101</SeqNo>"
					+ "<filename>2018040200051311</filename>"
					+ "<Result>1</Result>"
					+ "<AddWord>...</AddWord>"
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
