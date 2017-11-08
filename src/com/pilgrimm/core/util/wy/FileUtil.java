package com.pilgrimm.core.util.wy;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传 下载 文件
 * 
 * @author haozi
 * 
 */
public class FileUtil {

	private static Logger logger = Logger.getLogger(FileUtil.class);

	private FileUtil() {

	}

	/***************************************************************************
	 * 
	 * 下载文件
	 */
	public static void downLoadFile(String filePath,
			HttpServletResponse response) {
		File file = null;
		DataInputStream dis = null;
		ServletOutputStream out = null;
		try {
			file = new File(filePath);
			out = response.getOutputStream();
			FileInputStream fis = new FileInputStream(file);
			dis = new DataInputStream(fis);
			int len = (int) file.length();
			byte[] buffer = new byte[len];
			try {
				dis.readFully(buffer);
			} catch (IOException e) {
				logger.error(e);
			} finally {
				if (dis != null) {
					try {
						dis.close();
					} catch (IOException e) {
						logger.error("close inputstream throw exception:", e);
					}
				}
			}
			try {
				out.write(buffer);
				out.flush();
			} catch (IOException e) {
				logger.error("close inputstream throw exception:", e);
			} finally {
				if (out != null) {
					try {
						out.close();
					} catch (IOException e) {
						logger.error("close inputstream throw exception:", e);
					}
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException:", e);
		} catch (IOException e) {
			logger.error("close inputstream throw exception:", e);
		}
	}

	/***************************************************************************
	 * 上传文件 返回生成的文件名
	 * 
	 * @param uploadFile
	 *            MultipartFile
	 * @param filePath
	 *            指定到文件夹
	 * @return
	 */
	public static String upLoadFile(MultipartFile uploadFile, String filePath) {
		String fileName = uploadFile.getOriginalFilename();
		String physicsPath = null;
		String templateName = "activation" + "_"
				+ DateUtil.dateToStr(new Date(), "yyyyMMddHHmmss")
				+ Math.random() * 10000 + ".";
		if (!(fileName == null || fileName.equals(""))) {
			String ext = fileName.substring(fileName.lastIndexOf(".") + 1,
					fileName.length()).toLowerCase();// 获取文件扩展名 并转化成小写
			templateName += ext;
			filePath += templateName;
			FileOutputStream fos = null;
			try {
				physicsPath = filePath;
				byte[] temp = uploadFile.getBytes();
				File file = new File(physicsPath);
				fos = new FileOutputStream(file);
				fos.write(temp);
				fos.flush();
			} catch (IOException e) {
				logger.error("upLoadFile throw exception:", e);
				return null;
			} finally {
				try {
					if (fos != null) {
						fos.close();
					}
				} catch (IOException e) {
					logger.error("close inputstream throw exception:", e);
				}
			}
		}
		return templateName;
	}

	/***************************************************************************
	 * 上传文件 返回生成的文件名
	 * 
	 * @param uploadFile
	 *            MultipartFile
	 * @param filePath
	 *            指定到文件夹
	 * @return
	 */
	public static boolean upLoadFile(MultipartFile uploadFile, String filePath,
			String fileNameSpecify) {
		String fileName = uploadFile.getOriginalFilename();
		String physicsPath = null;
		if (!(fileName == null || fileName.equals(""))) {
			filePath += fileNameSpecify;
			FileOutputStream fos = null;
			try {
				physicsPath = filePath;
				byte[] temp = uploadFile.getBytes();
				File file = new File(physicsPath);
				fos = new FileOutputStream(file);
				fos.write(temp);
				fos.flush();
			} catch (IOException e) {
				logger.error("upLoadFile throw exception:", e);
				return false;
			} finally {
				try {
					if (fos != null) {
						fos.close();
					}
				} catch (IOException e) {
					logger.error("close inputstream throw exception:", e);
				}
			}
		}
		return true;
	}

	/**
	 * 创建一个文件
	 * 
	 * @param filePath
	 *            文件路径
	 */
	public static boolean createFile(String filePath) {
		try {
			FileWriter fw = new FileWriter(filePath);// 建立FileWriter对象，并实例化fw
			fw.close();
		} catch (Exception e) {
			logger.error("创建文件错误：（" + filePath + "）" + e.toString());
			return false;
		}
		return true;
	}

	/**
	 * 删除文件
	 * 
	 * @param filePath
	 *            文件路径
	 */
	public static boolean deleteFile(String filePath) {
		boolean temp = false;
		try {
			File f = new File(filePath);
			if (f.exists()) {// 检查文件是否存在
				temp = f.delete();// 删除文件文件
			}
		} catch (Exception e) {
			logger.error("删除文件失败：（" + filePath + "）" + e.toString());
		}
		return temp;
	}

	/**
	 * 获取文件内容
	 * 
	 * @param filePath
	 *            文件路径
	 */
	public static String readFileContent(String filePath) {
		StringBuffer sb = new StringBuffer();
		FileReader fr = null;
		try {
			fr = new FileReader(filePath);
			// 建立BufferedReader对象，并实例化为br
			BufferedReader br = new BufferedReader(fr);
			// 从文件读取一行字符串
			String Line = br.readLine();
			// 判断读取到的字符串是否不为空
			while (Line != null) {
				sb.append(Line + "\n");// 输出从文件中读取的数据
				Line = br.readLine();// 从文件中继续读取一行数据
			}
			br.close();// 关闭BufferedReader对象
		} catch (Exception e) {
			logger.error("读取文件出错误：(" + filePath + ")" + e.toString());
		} finally {
			try {
				if (fr != null) {
					fr.close();// 关闭文件
				}
			} catch (IOException e) {
				if (logger.isInfoEnabled())
					logger.info("关闭文件出错!" + e.toString());
			}
		}
		return sb.toString();
	}

	/**
	 * 创建一个文件文件，并进行写入内容
	 * 
	 * @param text
	 *            要写入的字符串
	 * @param filePath
	 *            文件路径
	 */
	public static boolean createFileAndContent(String text, String filePath) {
		try {
			FileWriter fw = new FileWriter(filePath);// 建立FileWriter对象，并实例化fw
			// 将字符串写入文件
			fw.write(text);
			fw.close();
		} catch (Exception e) {
			logger.error("写入文件错误：（" + filePath + "）" + e.toString());
			return false;
		}
		return true;
	}

	/**
	 * 创建一个文件路径，可以创建很深的路径，而不是一级文件夹。
	 * 
	 * @param filePath
	 *            文件路径
	 */
	public static boolean CreatePath(String filePath) {
		String strpa = filePath.replace("\\", "/");
		boolean temp = false;
		File baseFile = new File(strpa);
		if (!baseFile.exists()) {
			temp = baseFile.mkdirs();
		}
		return temp;
	}

	/**
	 * 判断路径地址的最后一个字符号是不是/，如果不是，加上/，注意，这个路径是UNIX形式的,此路径不包括文件名称
	 * 
	 * @param filePath
	 *            文件路径
	 */
	public static String setUnixPath(String filePath) {
		filePath = filePath.replace('\\', '/');
		if (filePath.lastIndexOf("/") != (filePath.length() - 1)) {
			filePath = filePath + "/";
		}
		return filePath;
	}

	/**
	 * 判断路径地址的最后一个符号是不是\，如果不是，自动加上，注意，此路径不包括文件名称
	 * 
	 * @param filePath
	 *            文件路径
	 */
	public static String setWinPath(String filePath) {
		if (filePath.lastIndexOf("\\") != (filePath.length() - 1)) {
			filePath = filePath + "\\";
		}
		return filePath;
	}

	/**
	 * 验证文件地址是否存在，如果文件存在返回true
	 * 
	 * @param filePath
	 *            文件路径
	 */
	public static boolean validataFileDir(String filePath) {
		boolean temp = false;
		File baseFile = new File(filePath);
		temp = baseFile.exists();
		return temp;
	}

}
